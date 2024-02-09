package sa;

import lParser.analysis.*;
import lParser.node.*;
import util.Type;

public class Sc2sa extends DepthFirstAdapter {
    private SaNode returnValue;
    private Type returnType;
    private SaProg saRoot = null;

    public void defaultIn(@SuppressWarnings("unused") Node node) {
        //System.out.println("<" + node.getClass().getSimpleName() + "> not implemented");
    }

    public void defaultOut(@SuppressWarnings("unused") Node node) {
        //System.out.println("</" + node.getClass().getSimpleName() + ">");
    }

    public SaProg getRoot() {
        return this.saRoot;
    }
    // exp3 = {plus} exp3 plus exp4
    /*
     * @Override
     * public void caseAPlusExp3(APlusExp3 node)
     * {
     * SaExp op1 = null;
     * SaExp op2 = null;
     * inAPlusExp3(node);
     * node.getExp3().apply(this);
     * op1 = (SaExp) this.returnValue;
     * node.getExp4().apply(this);
     * op2 = (SaExp) this.returnValue;
     * this.returnValue = new SaExpAdd(op1, op2);
     * outAPlusExp3(node);
     * }
     */

    @Override
    public void caseAAffectationInstruction(AAffectationInstruction node) {
       inAAffectationInstruction(node);
        SaVar var = null;
        SaExp exp = null;
        node.getVar().apply(this);
        var = (SaVar) this.returnValue;
        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = new SaInstAffect(var, exp);
        outAAffectationInstruction(node);
    }

    @Override
    public void caseAAppelFonctionExp7(AAppelFonctionExp7 node) {
        inAAppelFonctionExp7(node);
        String identif = node.getIdentif().getText();
        SaAppel appel = null;
        node.getListeExp().apply(this);
        SaLExp arguments = (SaLExp) this.returnValue;
        appel = new SaAppel(identif, arguments);
        this.returnValue = appel;
        outAAppelFonctionExp7(node);
    }

    @Override
    public void caseAAppelFonctionInstruction(AAppelFonctionInstruction node) {
        inAAppelFonctionInstruction(node);

        String identif = node.getIdentif().getText();
        SaAppel appel = null;
        SaLExp arguments = null;
        node.getListeExp().apply(this);
        arguments = (SaLExp) this.returnValue;
        appel = new SaAppel(identif, arguments);
        this.returnValue = appel;

        outAAppelFonctionInstruction(node);
    }

    @Override
    public void caseABlocInstruction(ABlocInstruction node) {
        inABlocInstruction(node);
        SaInstBloc bloc = null;
        node.getListeInstruction().apply(this);
        bloc = (SaInstBloc) this.returnValue;
        returnValue = bloc;
        outABlocInstruction(node);
    }

    @Override
    public void caseABoolType(ABoolType node) {
        inABoolType(node);
        this.returnType = Type.BOOL;
        outABoolType(node);

    }

    @Override
    public void caseADeclarationFonc(ADeclarationFonc node) {
        inADeclarationFonc(node);


        String identif = node.getIdentif().getText();
        node.getTypeOptionnel().apply(this);
        Type type = returnType;

        node.getArgument().apply(this);
        SaLDecVar parametres = (SaLDecVar) returnValue;

        node.getVarLocale().apply(this);
        SaLDecVar variables = (SaLDecVar) returnValue;


        node.getBlocInstruction().apply(this);
        SaInst corps = (SaInstBloc) returnValue;

        returnValue = new SaDecFonc(identif, type, parametres, variables, corps);

        outADeclarationFonc(node);
    }

    @Override
    public void caseADeclarationVar(ADeclarationVar node) {
        inADeclarationVar(node);

        String varName = node.getIdentif().getText();

        node.getType().apply(this);
        Type type = returnType;

        returnValue = new SaDecVarSimple(varName, type);

        outADeclarationVar(node);
    }

    @Override
    public void caseADivExp4(ADivExp4 node) {
        inADivExp4(node);

        node.getExp4().apply(this);
        SaExp op1 = (SaExp)  this.returnValue;

        node.getExp5().apply(this);
        SaExp op2 = (SaExp) this.returnValue;

        this.returnValue = new SaExpDiv(op1, op2);
        outADivExp4(node);
    }

    @Override
    public void caseAEcrireInstruction(AEcrireInstruction node) {
        inAEcrireInstruction(node);

        SaExp arg = null;
        node.getExp().apply(this);
        arg = (SaExp) this.returnValue;
        this.returnValue = new SaInstEcriture(arg);
        SaInstEcriture instEcriture = new SaInstEcriture(arg);
        this.returnValue = instEcriture;

        outAEcrireInstruction(node);
    }

    @Override
    public void caseAEgalExp2(AEgalExp2 node) {
        inAEgalExp2(node);
        SaExp op1 = null;
        SaExp op2 = null;
        node.getExp2().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExp3().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpEqual(op1, op2);
        outAEgalExp2(node);
    }

    @Override
    public void caseAEntierType(AEntierType node){
        inAEntierType(node);
        this.returnType = Type.ENTIER;
        outAEntierType(node);
    }

    @Override
    public void caseAEntreParanthesesExp7(AEntreParanthesesExp7 node) {
        inAEntreParanthesesExp7(node);

        node.getExp().apply(this);

        outAEntreParanthesesExp7(node);
    }

    @Override
    public void caseAEtExp1(AEtExp1 node) {
        inAEtExp1(node);
        SaExp op1 = null;
        SaExp op2 = null;
        node.getExp1().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExp2().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpAnd(op1, op2);
        outAEtExp1(node);
    }

    @Override
    public void caseAExp1Exp(AExp1Exp node) {
        inAExp1Exp(node);
        node.getExp1().apply(this);
        outAExp1Exp(node);
    }

    @Override
    public void caseAExp2Exp1(AExp2Exp1 node) {
        inAExp2Exp1(node);
        node.getExp2().apply(this);
        outAExp2Exp1(node);
    }

    @Override
    public void caseAExp3Exp2(AExp3Exp2 node) {
        inAExp3Exp2(node);
        node.getExp3().apply(this);
        outAExp3Exp2(node);
    }

    @Override
    public void caseAExp4Exp3(AExp4Exp3 node) {
        inAExp4Exp3(node);
        node.getExp4().apply(this);
        outAExp4Exp3(node);
    }

    @Override
    public void caseAExp5Exp4(AExp5Exp4 node) {
        inAExp5Exp4(node);
        node.getExp5().apply(this);
        outAExp5Exp4(node);
    }

    @Override
    public void caseAExp6Exp5(AExp6Exp5 node) {
        inAExp6Exp5(node);
        node.getExp6().apply(this);
        outAExp6Exp5(node);
    }

    @Override
    public void caseAExp7Exp6(AExp7Exp6 node) {
        inAExp7Exp6(node);
        node.getExp7().apply(this);
        outAExp7Exp6(node);
    }

    @Override
    public void caseAFaireTantQueInstruction(AFaireTantQueInstruction node) {
        inAFaireTantQueInstruction(node);

        SaExp test = null;
        SaInst faire = null;
        node.getExp().apply(this);
        test = (SaExp) this.returnValue;
        node.getBlocInstruction().apply(this);
        faire = (SaInst) this.returnValue;
        this.returnValue = new SaInstTantQue(test, faire);

        outAFaireTantQueInstruction(node);
    }

    @Override
    public void caseAFauxExp7(AFauxExp7 node) {
        inAFauxExp7(node);
        this.returnValue = new SaExpFaux();
        outAFauxExp7(node);
    }

    @Override
    public void caseAInfExp2(AInfExp2 node) {
        inAInfExp2(node);
        SaExp op1 = null;
        SaExp op2 = null;
        node.getExp2().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExp3().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpInf(op1, op2);
        outAInfExp2(node);
    }

    @Override
    public void caseALireExp7(ALireExp7 node) {
        inALireExp7(node);
        this.returnValue = new SaExpLire();
        outALireExp7(node);
    }

    @Override
    public void caseAListeDeclarationFonc(AListeDeclarationFonc node) {
        inAListeDeclarationFonc(node);
        SaLDecFonc dec = null;
        node.getDeclarationFonc().apply(this);
        dec = (SaLDecFonc) this.returnValue;
        this.returnValue = dec;
        outAListeDeclarationFonc(node);
    }

    @Override
    public void caseAListeDeclarationVar(AListeDeclarationVar node) {
        inAListeDeclarationVar(node);
        SaLDecVar dec = null;
        node.getDeclarationVar().apply(this);
        dec = (SaLDecVar) this.returnValue;
        this.returnValue = dec;
        outAListeDeclarationVar(node);
    }

    @Override
    public void caseAListeDeclarationVarPrime(AListeDeclarationVarPrime node) {
        inAListeDeclarationVarPrime(node);
        SaLDecVar dec = null;
        node.getDeclarationVar().apply(this);
        dec = (SaLDecVar) this.returnValue;
        this.returnValue = dec;
        outAListeDeclarationVarPrime(node);
    }

    @Override
    public void caseAListeExp(AListeExp node) {
        inAListeExp(node);
        SaLExp liste = null;
        node.getExp().apply(this);
        liste = (SaLExp) this.returnValue;
        this.returnValue = liste;
        outAListeExp(node);
    }

    @Override
    public void caseAListeExpPrime(AListeExpPrime node) {
        inAListeExpPrime(node);
        SaLExp liste = null;
        node.getExp().apply(this);
        liste = (SaLExp) this.returnValue;
        this.returnValue = liste;
        outAListeExpPrime(node);
    }

    @Override
    public void caseAListeInstruction(AListeInstruction node){
        inAListeInstruction(node);
        SaLInst liste = null;
        node.getInstruction().apply(this);
        liste = (SaLInst) this.returnValue;
        this.returnValue = liste;
        outAListeInstruction(node);
    }

    @Override
    public void caseAMoinsExp3(AMoinsExp3 node) {
        inAMoinsExp3(node);
        SaExp op1 = null;
        SaExp op2 = null;
        node.getExp3().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExp4().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpSub(op1, op2);
        outAMoinsExp3(node);
    }

    @Override
    public void caseAMultExp4(AMultExp4 node) {
        inAMultExp4(node);
        SaExp op1 = null;
        SaExp op2 = null;
        node.getExp4().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExp5().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpMult(op1, op2);
        outAMultExp4(node);
    }

    @Override
    public void caseANombreExp7(ANombreExp7 node) {
        inANombreExp7(node);
        int val = Integer.parseInt(node.getNombre().getText());
        this.returnValue = new SaExpInt(val);
        outANombreExp7(node);
    }

    @Override
    public void caseANonExp5(ANonExp5 node) {
        inANonExp5(node);
        SaExp op1 = null;
        node.getExp5().apply(this);
        op1 = (SaExp) this.returnValue;
        this.returnValue = new SaExpNot(op1);
        outANonExp5(node);
    }

    @Override
    public void caseAOuExp(AOuExp node) {
        inAOuExp(node);
        SaExp op1 = null;
        SaExp op2 = null;
        node.getExp().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExp1().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpOr(op1, op2);
        outAOuExp(node);
    }

    @Override
    public void caseAPlusExp3(APlusExp3 node) {
        inAPlusExp3(node);

        node.getExp3().apply(this);
        SaExp op1 = (SaExp) this.returnValue;

        node.getExp4().apply(this);
        SaExp op2 = (SaExp) this.returnValue;

        this.returnValue = new SaExpAdd(op1, op2);

        outAPlusExp3(node);
    }

    @Override
    public void caseAPowerExp6(APowerExp6 node) {
            //TODO
    }

    @Override
    public void caseAProgramme(AProgramme node) {
        inAProgramme(node);
        SaLDecVar dec = null;
        SaLDecFonc fonc = null;

        if(node.getListeDeclarationVar() != null) node.getListeDeclarationVar().apply(this); dec = (SaLDecVar) this.returnValue;
        if(node.getListeDeclarationFonc() != null) node.getListeDeclarationFonc().apply(this); fonc = (SaLDecFonc) this.returnValue;

        this.saRoot = new SaProg(dec, fonc);
        outAProgramme(node);
    }

    @Override
    public void caseARetourInstruction(ARetourInstruction node) {
        inARetourInstruction(node);
        SaExp exp = null;
        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = new SaInstRetour(exp);
        outARetourInstruction(node);
    }

    @Override
    public void caseASiInstruction(ASiInstruction node) {
        inASiInstruction(node);
        SaExp test = null;
        SaInst alors = null;
        node.getExp().apply(this);
        test = (SaExp) this.returnValue;
        node.getBlocInstruction().apply(this);
        alors = (SaInst) this.returnValue;
        this.returnValue = new SaInstSi(test, alors, null);
    }

    @Override
    public void caseASiSinonInstruction(ASiSinonInstruction node) {
        inASiSinonInstruction(node);
        SaExp test = null;
        SaInst alors = null;
        SaInst sinon = null;
        node.getExp().apply(this);
        test = (SaExp) this.returnValue;
        node.getSiInstruction().apply(this);
        alors = (SaInst) this.returnValue;
        node.getSinonInstruction().apply(this);
        sinon = (SaInst) this.returnValue;
        this.returnValue = new SaInstSi(test, alors, sinon);
        outASiSinonInstruction(node);
    }

    @Override
    public void caseATableauDeclarationVar(ATableauDeclarationVar node) {
        inATableauDeclarationVar(node);

        Type type = Type.NUL;
        String identif = node.getIdentif().getText();
        node.getType().apply(this);
        type = this.returnType;
        int taille = Integer.parseInt(node.getNombre().getText());
        SaDecTab decTab = new SaDecTab(identif, type, taille);
        this.returnValue = decTab;

        outATableauDeclarationVar(node);
    }

    @Override
    public void caseATableauVar(ATableauVar node) {
        inATableauVar(node);
        String identif = node.getIdentif().getText();
        SaExp index = null;
        node.getExp().apply(this);
        index = (SaExp) this.returnValue;
        this.returnValue = new SaVarIndicee(identif, index);
        outATableauVar(node);
    }

    @Override
    public void caseATantQueInstruction(ATantQueInstruction node) {
        inATantQueInstruction(node);
        SaExp test = null;
        SaInst faire = null;
        node.getExp().apply(this);
        test = (SaExp) this.returnValue;
        node.getBlocInstruction().apply(this);
        faire = (SaInst) this.returnValue;
        this.returnValue = new SaInstTantQue(test, faire);
        outATantQueInstruction(node);
    }

    @Override
    public void caseATypeTypeOptionnel(ATypeTypeOptionnel node) {
        inATypeTypeOptionnel(node);
        node.getType().apply(this);
        outATypeTypeOptionnel(node);
    }

    @Override
    public void caseAVar(AVar node) {
        inAVar(node);
        String identif = node.getIdentif().getText();
        this.returnValue = new SaVarSimple(identif);
        outAVar(node);
    }

    @Override
    public void caseAVariableExp7(AVariableExp7 node) {
        inAVariableExp7(node);
        SaVar var;
        node.getVar().apply(this);
        var = (SaVar) this.returnValue;
        this.returnValue = new SaExpVar(var);
        outAVariableExp7(node);
    }

    @Override
    public void caseAVideListeDeclarationFonc(AVideListeDeclarationFonc node) {
        inAVideListeDeclarationFonc(node);
        this.returnValue = null;
        outAVideListeDeclarationFonc(node);
    }

    @Override
    public void caseAVideListeDeclarationVar(AVideListeDeclarationVar node)
    {
        inAVideListeDeclarationVar(node);
        this.returnValue = null;
        outAVideListeDeclarationVar(node);
    }

    @Override
    public void caseAVideListeDeclarationVarPrime(AVideListeDeclarationVarPrime node) {
        inAVideListeDeclarationVarPrime(node);
        this.returnValue = null;
        outAVideListeDeclarationVarPrime(node);
    }

    @Override
    public void caseAVideListeExp(AVideListeExp node) {
        inAVideListeExp(node);
        this.returnValue = null;
        outAVideListeExp(node);
    }

    @Override
    public void caseAVideListeExpPrime(AVideListeExpPrime node) {
        inAVideListeExpPrime(node);
        this.returnValue = null;
        outAVideListeExpPrime(node);
    }

    @Override
    public void caseAVideListeInstruction(AVideListeInstruction node) {
        inAVideListeInstruction(node);
        this.returnValue = null;
        outAVideListeInstruction(node);
    }

    @Override
    public void caseAVideTypeOptionnel(AVideTypeOptionnel node) {
        inAVideTypeOptionnel(node);
        this.returnType = Type.NUL;
        outAVideTypeOptionnel(node);
    }

    @Override
    public void caseAVraiExp7(AVraiExp7 node) {
        inAVraiExp7(node);
        this.returnValue = new SaExpVrai();
        outAVraiExp7(node);
    }
}
