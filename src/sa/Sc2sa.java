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

    @Override
    public void caseAAffectationInstruction(AAffectationInstruction node) {
        // TODO Auto-generated method stub
        super.caseAAffectationInstruction(node);
        //returnValue = new
    }

    @Override
    public void caseAAppelfonction2Expression6(AAppelfonction2Expression6 node) {
        // TODO Auto-generated method stub
        super.caseAAppelfonction2Expression6(node);
    }

    @Override
    public void caseABlocBlocinstructions(ABlocBlocinstructions node) {
        // TODO Auto-generated method stub
        super.caseABlocBlocinstructions(node);
    }

    @Override
    public void caseABooleanType(ABooleanType node) {
        // TODO Auto-generated method stub
        super.caseABooleanType(node);
    }

    @Override
    public void caseACasetableauVar(ACasetableauVar node) {
        // TODO Auto-generated method stub
        super.caseACasetableauVar(node);
    }

    @Override
    public void caseADecfonctionListedecfonc(ADecfonctionListedecfonc node) {
        // TODO Auto-generated method stub
        super.caseADecfonctionListedecfonc(node);
    }

    @Override
    public void caseADecvarListedecvar(ADecvarListedecvar node) {
        // TODO Auto-generated method stub
        super.caseADecvarListedecvar(node);
    }

    @Override
    public void caseADivExpression4(ADivExpression4 node) {
        // TODO Auto-generated method stub
        super.caseADivExpression4(node);
    }

    @Override
    public void caseAEcrireInstruction(AEcrireInstruction node) {
        // TODO Auto-generated method stub
        super.caseAEcrireInstruction(node);
    }

    @Override
    public void caseAEgalExpression2(AEgalExpression2 node) {
        // TODO Auto-generated method stub
        super.caseAEgalExpression2(node);
    }

    @Override
    public void caseAEntierType(AEntierType node) {
        // TODO Auto-generated method stub
        super.caseAEntierType(node);
    }

    @Override
    public void caseAEtExpression1(AEtExpression1 node) {
        // TODO Auto-generated method stub
        super.caseAEtExpression1(node);
    }

    @Override
    public void caseAExpression1Expression(AExpression1Expression node) {
        // TODO Auto-generated method stub
        super.caseAExpression1Expression(node);
    }

    @Override
    public void caseAExpression2Expression1(AExpression2Expression1 node) {
        // TODO Auto-generated method stub
        super.caseAExpression2Expression1(node);
    }

    @Override
    public void caseAExpression3Expression2(AExpression3Expression2 node) {
        // TODO Auto-generated method stub
        super.caseAExpression3Expression2(node);
    }

    @Override
    public void caseAExpression5Expression3(AExpression5Expression3 node) {
        // TODO Auto-generated method stub
        super.caseAExpression5Expression3(node);
    }

    @Override
    public void caseAExpression5Expression4(AExpression5Expression4 node) {
        // TODO Auto-generated method stub
        super.caseAExpression5Expression4(node);
    }

    @Override
    public void caseAExpression6Expression5(AExpression6Expression5 node) {
        // TODO Auto-generated method stub
        super.caseAExpression6Expression5(node);
    }

    @Override
    public void caseAFauxExpression6(AFauxExpression6 node) {
        // TODO Auto-generated method stub
        super.caseAFauxExpression6(node);
    }

    @Override
    public void caseAFonction(AFonction node) {
        // TODO Auto-generated method stub
        super.caseAFonction(node);
    }

    @Override
    public void caseAIdInstruction(AIdInstruction node) {
        // TODO Auto-generated method stub
        super.caseAIdInstruction(node);
    }

    @Override
    public void caseAIdentificateurVar(AIdentificateurVar node) {
        // TODO Auto-generated method stub
        super.caseAIdentificateurVar(node);
    }

    @Override
    public void caseAInfExpression2(AInfExpression2 node) {
        // TODO Auto-generated method stub
        super.caseAInfExpression2(node);
    }

    @Override
    public void caseAInstructionsListeinstructions(AInstructionsListeinstructions node) {
        // TODO Auto-generated method stub
        super.caseAInstructionsListeinstructions(node);
    }

    @Override
    public void caseALireExpression6(ALireExpression6 node) {
        // TODO Auto-generated method stub
        super.caseALireExpression6(node);
    }

    @Override
    public void caseAListeparametresListeexpressions(AListeparametresListeexpressions node) {
        // TODO Auto-generated method stub
        super.caseAListeparametresListeexpressions(node);
    }

    @Override
    public void caseAMoinsExpression3(AMoinsExpression3 node) {
        // TODO Auto-generated method stub
        super.caseAMoinsExpression3(node);
    }

    @Override
    public void caseAMultExpression4(AMultExpression4 node) {
        // TODO Auto-generated method stub
        super.caseAMultExpression4(node);
    }

    @Override
    public void caseANombreExpression6(ANombreExpression6 node) {
        // TODO Auto-generated method stub
        super.caseANombreExpression6(node);
    }

    @Override
    public void caseANonExpression5(ANonExpression5 node) {
        // TODO Auto-generated method stub
        super.caseANonExpression5(node);
    }

    @Override
    public void caseAOuExpression(AOuExpression node) {
        // TODO Auto-generated method stub
        super.caseAOuExpression(node);
    }

    @Override
    public void caseAParenthesesExpression6(AParenthesesExpression6 node) {
        // TODO Auto-generated method stub
        super.caseAParenthesesExpression6(node);
    }

    @Override
    public void caseAPlusExpression3(APlusExpression3 node) {
        // TODO Auto-generated method stub
       //super.caseAPlusExpression3(node);
        SaExp op1 = null;
        SaExp op2 = null;
        node.getExp3().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExp4().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpAdd(op1, op2);
    }

    @Override
    public void caseAProgramme(AProgramme node) {
        // TODO Auto-generated method stub
        super.caseAProgramme(node);
        returnValue = new SaProg(node.getListedecfonc(), node.getListedecvar(), (SaBloc) returnValue);
    }

    @Override
    public void caseARestedecvarListedecvar1(ARestedecvarListedecvar1 node) {
        // TODO Auto-generated method stub
        super.caseARestedecvarListedecvar1(node);
    }

    @Override
    public void caseAResteparametrescommencantvirguleListeexpressions1(
            AResteparametrescommencantvirguleListeexpressions1 node) {
        // TODO Auto-generated method stub
        super.caseAResteparametrescommencantvirguleListeexpressions1(node);
    }

    @Override
    public void caseARetourInstruction(ARetourInstruction node) {
        // TODO Auto-generated method stub
        super.caseARetourInstruction(node);
    }

    @Override
    public void caseASialorsInstruction(ASialorsInstruction node) {
        // TODO Auto-generated method stub
        super.caseASialorsInstruction(node);
    }

    @Override
    public void caseASisinonInstruction(ASisinonInstruction node) {
        // TODO Auto-generated method stub
        super.caseASisinonInstruction(node);
    }

    @Override
    public void caseATantqueInstruction(ATantqueInstruction node) {
        // TODO Auto-generated method stub
        super.caseATantqueInstruction(node);
    }

    @Override
    public void caseATypevarTypeoptionnel(ATypevarTypeoptionnel node) {
        // TODO Auto-generated method stub
        super.caseATypevarTypeoptionnel(node);
    }

    @Override
    public void caseAVarExpression6(AVarExpression6 node) {
        // TODO Auto-generated method stub
        super.caseAVarExpression6(node);
    }

    @Override
    public void caseAVarsimpleDecvar(AVarsimpleDecvar node) {
        // TODO Auto-generated method stub
        super.caseAVarsimpleDecvar(node);
    }

    @Override
    public void caseAVartabDecvar(AVartabDecvar node) {
        // TODO Auto-generated method stub
        super.caseAVartabDecvar(node);
    }

    @Override
    public void caseAVideListedecfonc(AVideListedecfonc node) {
        // TODO Auto-generated method stub
        super.caseAVideListedecfonc(node);
    }

    @Override
    public void caseAVideListedecvar(AVideListedecvar node) {
        // TODO Auto-generated method stub
        super.caseAVideListedecvar(node);
    }

    @Override
    public void caseAVideListedecvar1(AVideListedecvar1 node) {
        // TODO Auto-generated method stub
        super.caseAVideListedecvar1(node);
    }

    @Override
    public void caseAVideListeexpressions(AVideListeexpressions node) {
        // TODO Auto-generated method stub
        super.caseAVideListeexpressions(node);
    }

    @Override
    public void caseAVideListeexpressions1(AVideListeexpressions1 node) {
        // TODO Auto-generated method stub
        super.caseAVideListeexpressions1(node);
    }

    @Override
    public void caseAVideListeinstructions(AVideListeinstructions node) {
        // TODO Auto-generated method stub
        super.caseAVideListeinstructions(node);
    }

    @Override
    public void caseAVideTypeoptionnel(AVideTypeoptionnel node) {
        // TODO Auto-generated method stub
        super.caseAVideTypeoptionnel(node);
    }

    @Override
    public void caseAVraiExpression6(AVraiExpression6 node) {
        // TODO Auto-generated method stub
        super.caseAVraiExpression6(node);
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
    public void caseTAccD(TAccD node) {
        // TODO Auto-generated method stub
        super.caseTAccD(node);
    }

    @Override
    public void caseTAccG(TAccG node) {
        // TODO Auto-generated method stub
        super.caseTAccG(node);
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
    public void caseTCroD(TCroD node) {
        // TODO Auto-generated method stub
        super.caseTCroD(node);
    }

    @Override
    public void caseTCroG(TCroG node) {
        // TODO Auto-generated method stub
        super.caseTCroG(node);
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
    public void caseTEspaces(TEspaces node) {
        // TODO Auto-generated method stub
        super.caseTEspaces(node);
    }

    @Override
    public void caseTEt(TEt node) {
        // TODO Auto-generated method stub
        super.caseTEt(node);
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
    public void caseTId(TId node) {
        // TODO Auto-generated method stub
        super.caseTId(node);
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
    public void caseTMod(TMod node) {
        // TODO Auto-generated method stub
        super.caseTMod(node);
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
    public void caseTNon(TNon node) {
        // TODO Auto-generated method stub
        super.caseTNon(node);
    }

    @Override
    public void caseTOu(TOu node) {
        // TODO Auto-generated method stub
        super.caseTOu(node);
    }

    @Override
    public void caseTPVirgule(TPVirgule node) {
        // TODO Auto-generated method stub
        super.caseTPVirgule(node);
    }

    @Override
    public void caseTParD(TParD node) {
        // TODO Auto-generated method stub
        super.caseTParD(node);
    }

    @Override
    public void caseTParG(TParG node) {
        // TODO Auto-generated method stub
        super.caseTParG(node);
    }

    @Override
    public void caseTPlus(TPlus node) {
        // TODO Auto-generated method stub
        super.caseTPlus(node);
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
    public void caseTTq(TTq node) {
        // TODO Auto-generated method stub
        super.caseTTq(node);
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
}
