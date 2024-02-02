/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.analysis;

import lParser.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAProgramme(AProgramme node);
    void caseADecvarListedecvar(ADecvarListedecvar node);
    void caseAVideListedecvar(AVideListedecvar node);
    void caseARestedecvarListedecvar1(ARestedecvarListedecvar1 node);
    void caseAVideListedecvar1(AVideListedecvar1 node);
    void caseAVarsimpleDecvar(AVarsimpleDecvar node);
    void caseAVartabDecvar(AVartabDecvar node);
    void caseAEntierType(AEntierType node);
    void caseABooleanType(ABooleanType node);
    void caseADecfonctionListedecfonc(ADecfonctionListedecfonc node);
    void caseAVideListedecfonc(AVideListedecfonc node);
    void caseAFonction(AFonction node);
    void caseATypevarTypeoptionnel(ATypevarTypeoptionnel node);
    void caseAVideTypeoptionnel(AVideTypeoptionnel node);
    void caseABlocBlocinstructions(ABlocBlocinstructions node);
    void caseAInstructionsListeinstructions(AInstructionsListeinstructions node);
    void caseAVideListeinstructions(AVideListeinstructions node);
    void caseAAffectationInstruction(AAffectationInstruction node);
    void caseATantqueInstruction(ATantqueInstruction node);
    void caseASialorsInstruction(ASialorsInstruction node);
    void caseASisinonInstruction(ASisinonInstruction node);
    void caseARetourInstruction(ARetourInstruction node);
    void caseAEcrireInstruction(AEcrireInstruction node);
    void caseAIdInstruction(AIdInstruction node);
    void caseAIdentificateurVar(AIdentificateurVar node);
    void caseACasetableauVar(ACasetableauVar node);
    void caseAListeparametresListeexpressions(AListeparametresListeexpressions node);
    void caseAVideListeexpressions(AVideListeexpressions node);
    void caseAResteparametrescommencantvirguleListeexpressions1(AResteparametrescommencantvirguleListeexpressions1 node);
    void caseAVideListeexpressions1(AVideListeexpressions1 node);
    void caseAOuExpression(AOuExpression node);
    void caseAExpression1Expression(AExpression1Expression node);
    void caseAEtExpression1(AEtExpression1 node);
    void caseAExpression2Expression1(AExpression2Expression1 node);
    void caseAEgalExpression2(AEgalExpression2 node);
    void caseAInfExpression2(AInfExpression2 node);
    void caseAExpression3Expression2(AExpression3Expression2 node);
    void caseAPlusExpression3(APlusExpression3 node);
    void caseAMoinsExpression3(AMoinsExpression3 node);
    void caseAExpression5Expression3(AExpression5Expression3 node);
    void caseAMultExpression4(AMultExpression4 node);
    void caseADivExpression4(ADivExpression4 node);
    void caseAExpression5Expression4(AExpression5Expression4 node);
    void caseANonExpression5(ANonExpression5 node);
    void caseAExpression6Expression5(AExpression6Expression5 node);
    void caseAParenthesesExpression6(AParenthesesExpression6 node);
    void caseAVarExpression6(AVarExpression6 node);
    void caseANombreExpression6(ANombreExpression6 node);
    void caseAAppelfonction2Expression6(AAppelfonction2Expression6 node);
    void caseALireExpression6(ALireExpression6 node);
    void caseAVraiExpression6(AVraiExpression6 node);
    void caseAFauxExpression6(AFauxExpression6 node);

    void caseTEspaces(TEspaces node);
    void caseTCommentaire(TCommentaire node);
    void caseTPlus(TPlus node);
    void caseTMoins(TMoins node);
    void caseTNombre(TNombre node);
    void caseTDiv(TDiv node);
    void caseTMult(TMult node);
    void caseTMod(TMod node);
    void caseTEt(TEt node);
    void caseTOu(TOu node);
    void caseTNon(TNon node);
    void caseTParG(TParG node);
    void caseTParD(TParD node);
    void caseTEgal(TEgal node);
    void caseTInf(TInf node);
    void caseTAccG(TAccG node);
    void caseTAccD(TAccD node);
    void caseTCroG(TCroG node);
    void caseTCroD(TCroD node);
    void caseTSi(TSi node);
    void caseTTq(TTq node);
    void caseTRetour(TRetour node);
    void caseTAlors(TAlors node);
    void caseTEntier(TEntier node);
    void caseTSinon(TSinon node);
    void caseTBool(TBool node);
    void caseTFaire(TFaire node);
    void caseTLire(TLire node);
    void caseTEcrire(TEcrire node);
    void caseTVirgule(TVirgule node);
    void caseTPVirgule(TPVirgule node);
    void caseTVrai(TVrai node);
    void caseTFaux(TFaux node);
    void caseTId(TId node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
