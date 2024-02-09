package ts;

import sa.*;
import util.Error;

public class Sa2ts extends SaDepthFirstVisitor<Void> {
    enum Context {
        LOCAL,
        GLOBAL,
        PARAM
    }

    private Ts tableGlobale;
    private Ts tableLocaleCourante;
    private Context context;

    public Ts getTableGlobale() {
        return this.tableGlobale;
    }

    public Sa2ts() {
        tableGlobale = new Ts();
        tableLocaleCourante = null;
        context = Context.GLOBAL;
    }

    public void defaultIn(SaNode node) {
        // System.out.println("<" + node.getClass().getSimpleName() + ">");
    }

    public void defaultOut(SaNode node) {
        // System.out.println("</" + node.getClass().getSimpleName() + ">");
    }

    @Override
    public Void visit(SaDecTab node) throws Exception {
        defaultIn(node);
        switch (context) {
            case GLOBAL:
                if (tableGlobale.getVar(node.getNom()) != null) {
                    throw new ErrorException(Error.TS, "Variable " + node.getNom() + " existe deja");
                }
                node.setTsItem(tableGlobale.addVar(node.getNom(), node.getType()));
                break;
            default:
                throw new ErrorException(Error.TS, "Invalid context");
        }
        defaultOut(node);
        return null;
    }

    @Override
    public Void visit(SaDecFonc node) throws Exception {
        defaultIn(node);

        // if(tableGlobale.getFct("main") == null || tableGlobale.getFct("main").getNbArgs() != 0)
        //     throw new ErrorException(Error.TS, "La fonction main doit être déclarée avec 0 arguments.");


        System.out.println(node.getNom());

        if (tableGlobale.getFct(node.getNom()) != null){
            throw new ErrorException(Error.TS, "Function " + node.getNom() + " existe deja");
        }

        tableLocaleCourante = new Ts();

        int argCount = 0;
        if (node.getParametres() != null) {
            argCount = node.getParametres().length();
            context = Context.PARAM;
            node.getParametres().accept(this);
        }
        node.tsItem = tableGlobale.addFct(node.getNom(), node.getTypeRetour(), argCount, tableLocaleCourante, node);

        if (node.getVariable() != null) {
            context = Context.LOCAL;
            node.getVariable().accept(this);
        }

        if (node.getCorps() != null) {
            context = Context.LOCAL;
            node.getCorps().accept(this);
        }

        context = Context.GLOBAL;

        defaultOut(node);
        return null;
    }

    @Override
    public Void visit(SaDecVar node) throws Exception {
        defaultIn(node);
        switch (context) {
            case LOCAL:
                if (tableLocaleCourante.getVar(node.getNom()) != null) {
                    throw new ErrorException(Error.TS, "Variable " + node.getNom() + " existe deja");
                }
                node.setTsItem(tableLocaleCourante.addVar(node.getNom(), node.getType()));
                break;
            case PARAM:
                if (tableLocaleCourante.getVar(node.getNom()) != null) {
                    throw new ErrorException(Error.TS, "Parameter " + node.getNom() + " existe deja");
                }
                node.setTsItem(tableLocaleCourante.addParam(node.getNom(), node.getType()));
                break;
            case GLOBAL:
                if (getTableGlobale().getVar(node.getNom()) != null) {
                    throw new ErrorException(Error.TS, "Variable " + node.getNom() + " existe deja");
                }
                node.setTsItem(tableGlobale.addVar(node.getNom(), node.getType()));
                break;
            default:
                throw new ErrorException(Error.TS, "Invalid context");
        }
        defaultOut(node);
        return null;
    }

    @Override
    public Void visit(SaVarSimple node) throws Exception {
        defaultIn(node);

        if (tableLocaleCourante.getVar(node.getNom()) == null && tableGlobale.getVar(node.getNom()) == null)
            throw new ErrorException(Error.TS, "La variable '" + node.getNom() + "' n'a pas été déclarée.");

        try {
            node.tsItem = (TsItemVarSimple) tableLocaleCourante.getVar(node.getNom());
        } catch (ClassCastException e) {
            throw new ErrorException(Error.TS, "Le tableau '" + node.getNom() + "' n'est pas indicé.");
        }

        defaultOut(node);
        return null;
    }

    @Override
    public Void visit(SaAppel node) throws Exception {
        defaultIn(node);
        if (tableGlobale.getFct(node.getNom()) == null)
            throw new ErrorException(Error.TS, "La fonction '" + node.getNom() + "' n'a pas été déclarée.");
        node.tsItem = tableGlobale.getFct(node.getNom());

        int argCount = 0;
        if (node.getArguments() != null) {
            argCount = node.getArguments().length();
            context = Context.PARAM;
            node.getArguments().accept(this);
        }
        if (argCount != node.tsItem.getNbArgs())
            throw new ErrorException(Error.TS, argCount + " arguments ont été fournis au lieu de "
                    + node.tsItem.getNbArgs() + " lors de l'appel de la fonction '" + node.getNom() + "'.");

        context = Context.LOCAL;
        defaultOut(node);
        return null;
    }

    @Override
    public Void visit(SaVarIndicee node) throws Exception {
        defaultIn(node);
        if (tableGlobale.getVar(node.getNom()) == null)
            throw new ErrorException(Error.TS, "Le tableau '" + node.getNom() + "' n'a pas été déclaré.");

        try {
            node.tsItem = tableGlobale.getVar(node.getNom());
        } catch (ClassCastException e) {
            throw new ErrorException(Error.TS, "La variable '" + node.getNom() + "' n'est pas un tableau.");
        }

        node.getIndice().accept(this);
        defaultOut(node);
        return null;
    }

}
