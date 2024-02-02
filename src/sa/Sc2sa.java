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
        // TODO Auto-generated method stub
        super.caseAAffectationInstruction(node);
    }

    @Override
    public void caseAAppelFonctionExp7(AAppelFonctionExp7 node) {
        // TODO Auto-generated method stub
        super.caseAAppelFonctionExp7(node);
    }

    @Override
    public void caseAAppelFonctionInstruction(AAppelFonctionInstruction node) {
        // TODO Auto-generated method stub
        super.caseAAppelFonctionInstruction(node);
    }

    @Override
    public void caseABlocInstruction(ABlocInstruction node) {
        // TODO Auto-generated method stub
        super.caseABlocInstruction(node);
    }

    @Override
    public void caseABoolType(ABoolType node) {
        // TODO Auto-generated method stub
        super.caseABoolType(node);
    }

    @Override
    public void caseADeclarationFonc(ADeclarationFonc node) {
        Type type = Type.NUL;
        String identif = node.getIdentif().getText();
        node.getTypeOptionnel().apply(this);
        type = this.returnType;
        SaLDecVar parametres = null;
        node.getArgument().apply(this);
        parametres = (SaLDecVar) this.returnValue;

        SaLDecVar variables = null;
        node.getVarLocale().apply(this);
        variables = (SaLDecVar) this.returnValue;

        SaInst corps = null;
        node.getBlocInstruction().apply(this);
        corps = (SaInstBloc) this.returnValue;

        SaDecFonc decFonc = new SaDecFonc(identif, type, parametres, variables, corps);
        this.returnValue = decFonc;
    }

    @Override
    public void caseADeclarationVar(ADeclarationVar node) {
        // TODO Auto-generated method stub
        super.caseADeclarationVar(node);
    }

    @Override
    public void caseADivExp4(ADivExp4 node) {
        // TODO Auto-generated method stub
        super.caseADivExp4(node);
    }

    @Override
    public void caseAEcrireInstruction(AEcrireInstruction node) {
        // TODO Auto-generated method stub
        super.caseAEcrireInstruction(node);
    }

    @Override
    public void caseAEgalExp2(AEgalExp2 node) {
        // TODO Auto-generated method stub
        super.caseAEgalExp2(node);
    }

    @Override
    public void caseAEntierType(AEntierType node) {
        // TODO Auto-generated method stub
        super.caseAEntierType(node);
    }

    @Override
    public void caseAEntreParanthesesExp7(AEntreParanthesesExp7 node) {
        // TODO Auto-generated method stub
        super.caseAEntreParanthesesExp7(node);
    }

    @Override
    public void caseAEtExp1(AEtExp1 node) {
        // TODO Auto-generated method stub
        super.caseAEtExp1(node);
    }

    @Override
    public void caseAExp1Exp(AExp1Exp node) {
        // TODO Auto-generated method stub
        super.caseAExp1Exp(node);
    }

    @Override
    public void caseAExp2Exp1(AExp2Exp1 node) {
        // TODO Auto-generated method stub
        super.caseAExp2Exp1(node);
    }

    @Override
    public void caseAExp3Exp2(AExp3Exp2 node) {
        // TODO Auto-generated method stub
        super.caseAExp3Exp2(node);
    }

    @Override
    public void caseAExp4Exp3(AExp4Exp3 node) {
        // TODO Auto-generated method stub
        super.caseAExp4Exp3(node);
    }

    @Override
    public void caseAExp5Exp4(AExp5Exp4 node) {
        // TODO Auto-generated method stub
        super.caseAExp5Exp4(node);
    }

    @Override
    public void caseAExp6Exp5(AExp6Exp5 node) {
        // TODO Auto-generated method stub
        super.caseAExp6Exp5(node);
    }

    @Override
    public void caseAExp7Exp6(AExp7Exp6 node) {
        // TODO Auto-generated method stub
        super.caseAExp7Exp6(node);
    }

    @Override
    public void caseAFaireTantQueInstruction(AFaireTantQueInstruction node) {
        // TODO Auto-generated method stub
        super.caseAFaireTantQueInstruction(node);
    }

    @Override
    public void caseAFauxExp7(AFauxExp7 node) {
        // TODO Auto-generated method stub
        super.caseAFauxExp7(node);
    }

    @Override
    public void caseAInfExp2(AInfExp2 node) {
        // TODO Auto-generated method stub
        super.caseAInfExp2(node);
    }

    @Override
    public void caseALireExp7(ALireExp7 node) {
        // TODO Auto-generated method stub
        super.caseALireExp7(node);
    }

    @Override
    public void caseAListeDeclarationFonc(AListeDeclarationFonc node) {
        // TODO Auto-generated method stub
        super.caseAListeDeclarationFonc(node);
    }

    @Override
    public void caseAListeDeclarationVar(AListeDeclarationVar node) {
        // TODO Auto-generated method stub
        super.caseAListeDeclarationVar(node);
    }

    @Override
    public void caseAListeDeclarationVarPrime(AListeDeclarationVarPrime node) {
        // TODO Auto-generated method stub
        super.caseAListeDeclarationVarPrime(node);
    }

    @Override
    public void caseAListeExp(AListeExp node) {
        // TODO Auto-generated method stub
        super.caseAListeExp(node);
    }

    @Override
    public void caseAListeExpPrime(AListeExpPrime node) {
        // TODO Auto-generated method stub
        super.caseAListeExpPrime(node);
    }

    @Override
    public void caseAListeInstruction(AListeInstruction node) {
        // TODO Auto-generated method stub
        super.caseAListeInstruction(node);
    }

    @Override
    public void caseAMoinsExp3(AMoinsExp3 node) {
        // TODO Auto-generated method stub
        super.caseAMoinsExp3(node);
    }

    @Override
    public void caseAMultExp4(AMultExp4 node) {
        // TODO Auto-generated method stub
        super.caseAMultExp4(node);
    }

    @Override
    public void caseANombreExp7(ANombreExp7 node) {
        // TODO Auto-generated method stub
        super.caseANombreExp7(node);
    }

    @Override
    public void caseANonExp5(ANonExp5 node) {
        // TODO Auto-generated method stub
        super.caseANonExp5(node);
    }

    @Override
    public void caseAOuExp(AOuExp node) {
        // TODO Auto-generated method stub
        super.caseAOuExp(node);
    }

    @Override
    public void caseAPlusExp3(APlusExp3 node) {
        // TODO Auto-generated method stub
        super.caseAPlusExp3(node);
    }

    @Override
    public void caseAPowerExp6(APowerExp6 node) {
        // TODO Auto-generated method stub
        super.caseAPowerExp6(node);
    }

    @Override
    public void caseAProgramme(AProgramme node) {
        // TODO Auto-generated method stub
        super.caseAProgramme(node);
    }

    @Override
    public void caseARetourInstruction(ARetourInstruction node) {
        // TODO Auto-generated method stub
        super.caseARetourInstruction(node);
    }

    @Override
    public void caseASiInstruction(ASiInstruction node) {
        // TODO Auto-generated method stub
        super.caseASiInstruction(node);
    }

    @Override
    public void caseASiSinonInstruction(ASiSinonInstruction node) {
        // TODO Auto-generated method stub
        super.caseASiSinonInstruction(node);
    }

    @Override
    public void caseATableauDeclarationVar(ATableauDeclarationVar node) {
        // TODO Auto-generated method stub
        super.caseATableauDeclarationVar(node);
    }

    @Override
    public void caseATableauVar(ATableauVar node) {
        // TODO Auto-generated method stub
        super.caseATableauVar(node);
    }

    @Override
    public void caseATantQueInstruction(ATantQueInstruction node) {
        // TODO Auto-generated method stub
        super.caseATantQueInstruction(node);
    }

    @Override
    public void caseATypeTypeOptionnel(ATypeTypeOptionnel node) {
        // TODO Auto-generated method stub
        super.caseATypeTypeOptionnel(node);
    }

    @Override
    public void caseAVar(AVar node) {
        // TODO Auto-generated method stub
        super.caseAVar(node);
    }

    @Override
    public void caseAVariableExp7(AVariableExp7 node) {
        // TODO Auto-generated method stub
        super.caseAVariableExp7(node);
    }

    @Override
    public void caseAVideListeDeclarationFonc(AVideListeDeclarationFonc node) {
        // TODO Auto-generated method stub
        super.caseAVideListeDeclarationFonc(node);
    }

    @Override
    public void caseAVideListeDeclarationVar(AVideListeDeclarationVar node) {
        // TODO Auto-generated method stub
        super.caseAVideListeDeclarationVar(node);
    }

    @Override
    public void caseAVideListeDeclarationVarPrime(AVideListeDeclarationVarPrime node) {
        // TODO Auto-generated method stub
        super.caseAVideListeDeclarationVarPrime(node);
    }

    @Override
    public void caseAVideListeExp(AVideListeExp node) {
        // TODO Auto-generated method stub
        super.caseAVideListeExp(node);
    }

    @Override
    public void caseAVideListeExpPrime(AVideListeExpPrime node) {
        // TODO Auto-generated method stub
        super.caseAVideListeExpPrime(node);
    }

    @Override
    public void caseAVideListeInstruction(AVideListeInstruction node) {
        // TODO Auto-generated method stub
        super.caseAVideListeInstruction(node);
    }

    @Override
    public void caseAVideTypeOptionnel(AVideTypeOptionnel node) {
        // TODO Auto-generated method stub
        super.caseAVideTypeOptionnel(node);
    }

    @Override
    public void caseAVraiExp7(AVraiExp7 node) {
        // TODO Auto-generated method stub
        super.caseAVraiExp7(node);
    }

    @Override
    public void caseStart(Start node) {
        // TODO Auto-generated method stub
        super.caseStart(node);
    }

    @Override
    public void inAAffectationInstruction(AAffectationInstruction node) {
        // TODO Auto-generated method stub
        super.inAAffectationInstruction(node);
    }

    @Override
    public void inAAppelFonctionExp7(AAppelFonctionExp7 node) {
        // TODO Auto-generated method stub
        super.inAAppelFonctionExp7(node);
    }

    @Override
    public void inAAppelFonctionInstruction(AAppelFonctionInstruction node) {
        // TODO Auto-generated method stub
        super.inAAppelFonctionInstruction(node);
    }

    @Override
    public void inABlocInstruction(ABlocInstruction node) {
        // TODO Auto-generated method stub
        super.inABlocInstruction(node);
    }

    @Override
    public void inABoolType(ABoolType node) {
        // TODO Auto-generated method stub
        super.inABoolType(node);
    }

    @Override
    public void inADeclarationFonc(ADeclarationFonc node) {
        // TODO Auto-generated method stub
        super.inADeclarationFonc(node);
    }

    @Override
    public void inADeclarationVar(ADeclarationVar node) {
        // TODO Auto-generated method stub
        super.inADeclarationVar(node);
    }

    @Override
    public void inADivExp4(ADivExp4 node) {
        // TODO Auto-generated method stub
        super.inADivExp4(node);
    }

    @Override
    public void inAEcrireInstruction(AEcrireInstruction node) {
        // TODO Auto-generated method stub
        super.inAEcrireInstruction(node);
    }

    @Override
    public void inAEgalExp2(AEgalExp2 node) {
        // TODO Auto-generated method stub
        super.inAEgalExp2(node);
    }

    @Override
    public void inAEntierType(AEntierType node) {
        // TODO Auto-generated method stub
        super.inAEntierType(node);
    }

    @Override
    public void inAEntreParanthesesExp7(AEntreParanthesesExp7 node) {
        // TODO Auto-generated method stub
        super.inAEntreParanthesesExp7(node);
    }

    @Override
    public void inAEtExp1(AEtExp1 node) {
        // TODO Auto-generated method stub
        super.inAEtExp1(node);
    }

    @Override
    public void inAExp1Exp(AExp1Exp node) {
        // TODO Auto-generated method stub
        super.inAExp1Exp(node);
    }

    @Override
    public void inAExp2Exp1(AExp2Exp1 node) {
        // TODO Auto-generated method stub
        super.inAExp2Exp1(node);
    }

    @Override
    public void inAExp3Exp2(AExp3Exp2 node) {
        // TODO Auto-generated method stub
        super.inAExp3Exp2(node);
    }

    @Override
    public void inAExp4Exp3(AExp4Exp3 node) {
        // TODO Auto-generated method stub
        super.inAExp4Exp3(node);
    }

    @Override
    public void inAExp5Exp4(AExp5Exp4 node) {
        // TODO Auto-generated method stub
        super.inAExp5Exp4(node);
    }

    @Override
    public void inAExp6Exp5(AExp6Exp5 node) {
        // TODO Auto-generated method stub
        super.inAExp6Exp5(node);
    }

    @Override
    public void inAExp7Exp6(AExp7Exp6 node) {
        // TODO Auto-generated method stub
        super.inAExp7Exp6(node);
    }

    @Override
    public void inAFaireTantQueInstruction(AFaireTantQueInstruction node) {
        // TODO Auto-generated method stub
        super.inAFaireTantQueInstruction(node);
    }

    @Override
    public void inAFauxExp7(AFauxExp7 node) {
        // TODO Auto-generated method stub
        super.inAFauxExp7(node);
    }

    @Override
    public void inAInfExp2(AInfExp2 node) {
        // TODO Auto-generated method stub
        super.inAInfExp2(node);
    }

    @Override
    public void inALireExp7(ALireExp7 node) {
        // TODO Auto-generated method stub
        super.inALireExp7(node);
    }

    @Override
    public void inAListeDeclarationFonc(AListeDeclarationFonc node) {
        // TODO Auto-generated method stub
        super.inAListeDeclarationFonc(node);
    }

    @Override
    public void inAListeDeclarationVar(AListeDeclarationVar node) {
        // TODO Auto-generated method stub
        super.inAListeDeclarationVar(node);
    }

    @Override
    public void inAListeDeclarationVarPrime(AListeDeclarationVarPrime node) {
        // TODO Auto-generated method stub
        super.inAListeDeclarationVarPrime(node);
    }

    @Override
    public void inAListeExp(AListeExp node) {
        // TODO Auto-generated method stub
        super.inAListeExp(node);
    }

    @Override
    public void inAListeExpPrime(AListeExpPrime node) {
        // TODO Auto-generated method stub
        super.inAListeExpPrime(node);
    }

    @Override
    public void inAListeInstruction(AListeInstruction node) {
        // TODO Auto-generated method stub
        super.inAListeInstruction(node);
    }

    @Override
    public void inAMoinsExp3(AMoinsExp3 node) {
        // TODO Auto-generated method stub
        super.inAMoinsExp3(node);
    }

    @Override
    public void inAMultExp4(AMultExp4 node) {
        // TODO Auto-generated method stub
        super.inAMultExp4(node);
    }

    @Override
    public void inANombreExp7(ANombreExp7 node) {
        // TODO Auto-generated method stub
        super.inANombreExp7(node);
    }

    @Override
    public void inANonExp5(ANonExp5 node) {
        // TODO Auto-generated method stub
        super.inANonExp5(node);
    }

    @Override
    public void inAOuExp(AOuExp node) {
        // TODO Auto-generated method stub
        super.inAOuExp(node);
    }

    @Override
    public void inAPlusExp3(APlusExp3 node) {
        // TODO Auto-generated method stub
        super.inAPlusExp3(node);
    }

    @Override
    public void inAPowerExp6(APowerExp6 node) {
        // TODO Auto-generated method stub
        super.inAPowerExp6(node);
    }

    @Override
    public void inAProgramme(AProgramme node) {
        // TODO Auto-generated method stub
        super.inAProgramme(node);
    }

    @Override
    public void inARetourInstruction(ARetourInstruction node) {
        // TODO Auto-generated method stub
        super.inARetourInstruction(node);
    }

    @Override
    public void inASiInstruction(ASiInstruction node) {
        // TODO Auto-generated method stub
        super.inASiInstruction(node);
    }

    @Override
    public void inASiSinonInstruction(ASiSinonInstruction node) {
        // TODO Auto-generated method stub
        super.inASiSinonInstruction(node);
    }

    @Override
    public void inATableauDeclarationVar(ATableauDeclarationVar node) {
        // TODO Auto-generated method stub
        super.inATableauDeclarationVar(node);
    }

    @Override
    public void inATableauVar(ATableauVar node) {
        // TODO Auto-generated method stub
        super.inATableauVar(node);
    }

    @Override
    public void inATantQueInstruction(ATantQueInstruction node) {
        // TODO Auto-generated method stub
        super.inATantQueInstruction(node);
    }

    @Override
    public void inATypeTypeOptionnel(ATypeTypeOptionnel node) {
        // TODO Auto-generated method stub
        super.inATypeTypeOptionnel(node);
    }

    @Override
    public void inAVar(AVar node) {
        // TODO Auto-generated method stub
        super.inAVar(node);
    }

    @Override
    public void inAVariableExp7(AVariableExp7 node) {
        // TODO Auto-generated method stub
        super.inAVariableExp7(node);
    }

    @Override
    public void inAVideListeDeclarationFonc(AVideListeDeclarationFonc node) {
        // TODO Auto-generated method stub
        super.inAVideListeDeclarationFonc(node);
    }

    @Override
    public void inAVideListeDeclarationVar(AVideListeDeclarationVar node) {
        // TODO Auto-generated method stub
        super.inAVideListeDeclarationVar(node);
    }

    @Override
    public void inAVideListeDeclarationVarPrime(AVideListeDeclarationVarPrime node) {
        // TODO Auto-generated method stub
        super.inAVideListeDeclarationVarPrime(node);
    }

    @Override
    public void inAVideListeExp(AVideListeExp node) {
        // TODO Auto-generated method stub
        super.inAVideListeExp(node);
    }

    @Override
    public void inAVideListeExpPrime(AVideListeExpPrime node) {
        // TODO Auto-generated method stub
        super.inAVideListeExpPrime(node);
    }

    @Override
    public void inAVideListeInstruction(AVideListeInstruction node) {
        // TODO Auto-generated method stub
        super.inAVideListeInstruction(node);
    }

    @Override
    public void inAVideTypeOptionnel(AVideTypeOptionnel node) {
        // TODO Auto-generated method stub
        super.inAVideTypeOptionnel(node);
    }

    @Override
    public void inAVraiExp7(AVraiExp7 node) {
        // TODO Auto-generated method stub
        super.inAVraiExp7(node);
    }

    @Override
    public void inStart(Start node) {
        // TODO Auto-generated method stub
        super.inStart(node);
    }

    @Override
    public void outAAffectationInstruction(AAffectationInstruction node) {
        // TODO Auto-generated method stub
        super.outAAffectationInstruction(node);
    }

    @Override
    public void outAAppelFonctionExp7(AAppelFonctionExp7 node) {
        // TODO Auto-generated method stub
        super.outAAppelFonctionExp7(node);
    }

    @Override
    public void outAAppelFonctionInstruction(AAppelFonctionInstruction node) {
        // TODO Auto-generated method stub
        super.outAAppelFonctionInstruction(node);
    }

    @Override
    public void outABlocInstruction(ABlocInstruction node) {
        // TODO Auto-generated method stub
        super.outABlocInstruction(node);
    }

    @Override
    public void outABoolType(ABoolType node) {
        // TODO Auto-generated method stub
        super.outABoolType(node);
    }

    @Override
    public void outADeclarationFonc(ADeclarationFonc node) {
        // TODO Auto-generated method stub
        super.outADeclarationFonc(node);
    }

    @Override
    public void outADeclarationVar(ADeclarationVar node) {
        // TODO Auto-generated method stub
        super.outADeclarationVar(node);
    }

    @Override
    public void outADivExp4(ADivExp4 node) {
        // TODO Auto-generated method stub
        super.outADivExp4(node);
    }

    @Override
    public void outAEcrireInstruction(AEcrireInstruction node) {
        // TODO Auto-generated method stub
        super.outAEcrireInstruction(node);
    }

    @Override
    public void outAEgalExp2(AEgalExp2 node) {
        // TODO Auto-generated method stub
        super.outAEgalExp2(node);
    }

    @Override
    public void outAEntierType(AEntierType node) {
        // TODO Auto-generated method stub
        super.outAEntierType(node);
    }

    @Override
    public void outAEntreParanthesesExp7(AEntreParanthesesExp7 node) {
        // TODO Auto-generated method stub
        super.outAEntreParanthesesExp7(node);
    }

    @Override
    public void outAEtExp1(AEtExp1 node) {
        // TODO Auto-generated method stub
        super.outAEtExp1(node);
    }

    @Override
    public void outAExp1Exp(AExp1Exp node) {
        // TODO Auto-generated method stub
        super.outAExp1Exp(node);
    }

    @Override
    public void outAExp2Exp1(AExp2Exp1 node) {
        // TODO Auto-generated method stub
        super.outAExp2Exp1(node);
    }

    @Override
    public void outAExp3Exp2(AExp3Exp2 node) {
        // TODO Auto-generated method stub
        super.outAExp3Exp2(node);
    }

    @Override
    public void outAExp4Exp3(AExp4Exp3 node) {
        // TODO Auto-generated method stub
        super.outAExp4Exp3(node);
    }

    @Override
    public void outAExp5Exp4(AExp5Exp4 node) {
        // TODO Auto-generated method stub
        super.outAExp5Exp4(node);
    }

    @Override
    public void outAExp6Exp5(AExp6Exp5 node) {
        // TODO Auto-generated method stub
        super.outAExp6Exp5(node);
    }

    @Override
    public void outAExp7Exp6(AExp7Exp6 node) {
        // TODO Auto-generated method stub
        super.outAExp7Exp6(node);
    }

    @Override
    public void outAFaireTantQueInstruction(AFaireTantQueInstruction node) {
        // TODO Auto-generated method stub
        super.outAFaireTantQueInstruction(node);
    }

    @Override
    public void outAFauxExp7(AFauxExp7 node) {
        // TODO Auto-generated method stub
        super.outAFauxExp7(node);
    }

    @Override
    public void outAInfExp2(AInfExp2 node) {
        // TODO Auto-generated method stub
        super.outAInfExp2(node);
    }

    @Override
    public void outALireExp7(ALireExp7 node) {
        // TODO Auto-generated method stub
        super.outALireExp7(node);
    }

    @Override
    public void outAListeDeclarationFonc(AListeDeclarationFonc node) {
        // TODO Auto-generated method stub
        super.outAListeDeclarationFonc(node);
    }

    @Override
    public void outAListeDeclarationVar(AListeDeclarationVar node) {
        // TODO Auto-generated method stub
        super.outAListeDeclarationVar(node);
    }

    @Override
    public void outAListeDeclarationVarPrime(AListeDeclarationVarPrime node) {
        // TODO Auto-generated method stub
        super.outAListeDeclarationVarPrime(node);
    }

    @Override
    public void outAListeExp(AListeExp node) {
        // TODO Auto-generated method stub
        super.outAListeExp(node);
    }

    @Override
    public void outAListeExpPrime(AListeExpPrime node) {
        // TODO Auto-generated method stub
        super.outAListeExpPrime(node);
    }

    @Override
    public void outAListeInstruction(AListeInstruction node) {
        // TODO Auto-generated method stub
        super.outAListeInstruction(node);
    }

    @Override
    public void outAMoinsExp3(AMoinsExp3 node) {
        // TODO Auto-generated method stub
        super.outAMoinsExp3(node);
    }

    @Override
    public void outAMultExp4(AMultExp4 node) {
        // TODO Auto-generated method stub
        super.outAMultExp4(node);
    }

    @Override
    public void outANombreExp7(ANombreExp7 node) {
        // TODO Auto-generated method stub
        super.outANombreExp7(node);
    }

    @Override
    public void outANonExp5(ANonExp5 node) {
        // TODO Auto-generated method stub
        super.outANonExp5(node);
    }

    @Override
    public void outAOuExp(AOuExp node) {
        // TODO Auto-generated method stub
        super.outAOuExp(node);
    }

    @Override
    public void outAPlusExp3(APlusExp3 node) {
        // TODO Auto-generated method stub
        super.outAPlusExp3(node);
    }

    @Override
    public void outAPowerExp6(APowerExp6 node) {
        // TODO Auto-generated method stub
        super.outAPowerExp6(node);
    }

    @Override
    public void outAProgramme(AProgramme node) {
        // TODO Auto-generated method stub
        super.outAProgramme(node);
    }

    @Override
    public void outARetourInstruction(ARetourInstruction node) {
        // TODO Auto-generated method stub
        super.outARetourInstruction(node);
    }

    @Override
    public void outASiInstruction(ASiInstruction node) {
        // TODO Auto-generated method stub
        super.outASiInstruction(node);
    }

    @Override
    public void outASiSinonInstruction(ASiSinonInstruction node) {
        // TODO Auto-generated method stub
        super.outASiSinonInstruction(node);
    }

    @Override
    public void outATableauDeclarationVar(ATableauDeclarationVar node) {
        // TODO Auto-generated method stub
        super.outATableauDeclarationVar(node);
    }

    @Override
    public void outATableauVar(ATableauVar node) {
        // TODO Auto-generated method stub
        super.outATableauVar(node);
    }

    @Override
    public void outATantQueInstruction(ATantQueInstruction node) {
        // TODO Auto-generated method stub
        super.outATantQueInstruction(node);
    }

    @Override
    public void outATypeTypeOptionnel(ATypeTypeOptionnel node) {
        // TODO Auto-generated method stub
        super.outATypeTypeOptionnel(node);
    }

    @Override
    public void outAVar(AVar node) {
        // TODO Auto-generated method stub
        super.outAVar(node);
    }

    @Override
    public void outAVariableExp7(AVariableExp7 node) {
        // TODO Auto-generated method stub
        super.outAVariableExp7(node);
    }

    @Override
    public void outAVideListeDeclarationFonc(AVideListeDeclarationFonc node) {
        // TODO Auto-generated method stub
        super.outAVideListeDeclarationFonc(node);
    }

    @Override
    public void outAVideListeDeclarationVar(AVideListeDeclarationVar node) {
        // TODO Auto-generated method stub
        super.outAVideListeDeclarationVar(node);
    }

    @Override
    public void outAVideListeDeclarationVarPrime(AVideListeDeclarationVarPrime node) {
        // TODO Auto-generated method stub
        super.outAVideListeDeclarationVarPrime(node);
    }

    @Override
    public void outAVideListeExp(AVideListeExp node) {
        // TODO Auto-generated method stub
        super.outAVideListeExp(node);
    }

    @Override
    public void outAVideListeExpPrime(AVideListeExpPrime node) {
        // TODO Auto-generated method stub
        super.outAVideListeExpPrime(node);
    }

    @Override
    public void outAVideListeInstruction(AVideListeInstruction node) {
        // TODO Auto-generated method stub
        super.outAVideListeInstruction(node);
    }

    @Override
    public void outAVideTypeOptionnel(AVideTypeOptionnel node) {
        // TODO Auto-generated method stub
        super.outAVideTypeOptionnel(node);
    }

    @Override
    public void outAVraiExp7(AVraiExp7 node) {
        // TODO Auto-generated method stub
        super.outAVraiExp7(node);
    }

    @Override
    public void outStart(Start node) {
        // TODO Auto-generated method stub
        super.outStart(node);
    }

    @Override
    public void caseEOF(EOF node) {
        // TODO Auto-generated method stub
        super.caseEOF(node);
    }

    @Override
    public void caseInvalidToken(InvalidToken node) {
        // TODO Auto-generated method stub
        super.caseInvalidToken(node);
    }

    @Override
    public void caseTAccoladeDroite(TAccoladeDroite node) {
        // TODO Auto-generated method stub
        super.caseTAccoladeDroite(node);
    }

    @Override
    public void caseTAccoladeGauche(TAccoladeGauche node) {
        // TODO Auto-generated method stub
        super.caseTAccoladeGauche(node);
    }

    @Override
    public void caseTAlors(TAlors node) {
        // TODO Auto-generated method stub
        super.caseTAlors(node);
    }

    @Override
    public void caseTBool(TBool node) {
        // TODO Auto-generated method stub
        super.caseTBool(node);
    }

    @Override
    public void caseTCommentaire(TCommentaire node) {
        // TODO Auto-generated method stub
        super.caseTCommentaire(node);
    }

    @Override
    public void caseTCrochetDroit(TCrochetDroit node) {
        // TODO Auto-generated method stub
        super.caseTCrochetDroit(node);
    }

    @Override
    public void caseTCrochetGauche(TCrochetGauche node) {
        // TODO Auto-generated method stub
        super.caseTCrochetGauche(node);
    }

    @Override
    public void caseTDiv(TDiv node) {
        // TODO Auto-generated method stub
        super.caseTDiv(node);
    }

    @Override
    public void caseTEcrire(TEcrire node) {
        // TODO Auto-generated method stub
        super.caseTEcrire(node);
    }

    @Override
    public void caseTEgal(TEgal node) {
        // TODO Auto-generated method stub
        super.caseTEgal(node);
    }

    @Override
    public void caseTEntier(TEntier node) {
        // TODO Auto-generated method stub
        super.caseTEntier(node);
    }

    @Override
    public void caseTEspace(TEspace node) {
        // TODO Auto-generated method stub
        super.caseTEspace(node);
    }

    @Override
    public void caseTEt(TEt node) {
        // TODO Auto-generated method stub
        super.caseTEt(node);
    }

    @Override
    public void caseTExclamation(TExclamation node) {
        // TODO Auto-generated method stub
        super.caseTExclamation(node);
    }

    @Override
    public void caseTFaire(TFaire node) {
        // TODO Auto-generated method stub
        super.caseTFaire(node);
    }

    @Override
    public void caseTFaux(TFaux node) {
        // TODO Auto-generated method stub
        super.caseTFaux(node);
    }

    @Override
    public void caseTIdentif(TIdentif node) {
        // TODO Auto-generated method stub
        super.caseTIdentif(node);
    }

    @Override
    public void caseTInf(TInf node) {
        // TODO Auto-generated method stub
        super.caseTInf(node);
    }

    @Override
    public void caseTLire(TLire node) {
        // TODO Auto-generated method stub
        super.caseTLire(node);
    }

    @Override
    public void caseTMoins(TMoins node) {
        // TODO Auto-generated method stub
        super.caseTMoins(node);
    }

    @Override
    public void caseTMult(TMult node) {
        // TODO Auto-generated method stub
        super.caseTMult(node);
    }

    @Override
    public void caseTNombre(TNombre node) {
        // TODO Auto-generated method stub
        super.caseTNombre(node);
    }

    @Override
    public void caseTOu(TOu node) {
        // TODO Auto-generated method stub
        super.caseTOu(node);
    }

    @Override
    public void caseTParentheseDroite(TParentheseDroite node) {
        // TODO Auto-generated method stub
        super.caseTParentheseDroite(node);
    }

    @Override
    public void caseTParentheseGauche(TParentheseGauche node) {
        // TODO Auto-generated method stub
        super.caseTParentheseGauche(node);
    }

    @Override
    public void caseTPlus(TPlus node) {
        // TODO Auto-generated method stub
        super.caseTPlus(node);
    }

    @Override
    public void caseTPointVirgule(TPointVirgule node) {
        // TODO Auto-generated method stub
        super.caseTPointVirgule(node);
    }

    @Override
    public void caseTPower(TPower node) {
        // TODO Auto-generated method stub
        super.caseTPower(node);
    }

    @Override
    public void caseTRetour(TRetour node) {
        // TODO Auto-generated method stub
        super.caseTRetour(node);
    }

    @Override
    public void caseTSi(TSi node) {
        // TODO Auto-generated method stub
        super.caseTSi(node);
    }

    @Override
    public void caseTSinon(TSinon node) {
        // TODO Auto-generated method stub
        super.caseTSinon(node);
    }

    @Override
    public void caseTTantQue(TTantQue node) {
        // TODO Auto-generated method stub
        super.caseTTantQue(node);
    }

    @Override
    public void caseTVirgule(TVirgule node) {
        // TODO Auto-generated method stub
        super.caseTVirgule(node);
    }

    @Override
    public void caseTVrai(TVrai node) {
        // TODO Auto-generated method stub
        super.caseTVrai(node);
    }

    @Override
    public void defaultCase(Node node) {
        // TODO Auto-generated method stub
        super.defaultCase(node);
    }

    @Override
    public Object getIn(Node node) {
        // TODO Auto-generated method stub
        return super.getIn(node);
    }

    @Override
    public Object getOut(Node node) {
        // TODO Auto-generated method stub
        return super.getOut(node);
    }

    @Override
    public void setIn(Node node, Object o) {
        // TODO Auto-generated method stub
        super.setIn(node, o);
    }

    @Override
    public void setOut(Node node, Object o) {
        // TODO Auto-generated method stub
        super.setOut(node, o);
    }


}
