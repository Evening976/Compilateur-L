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
    void caseAListeDeclarationVar(AListeDeclarationVar node);
    void caseAVideListeDeclarationVar(AVideListeDeclarationVar node);
    void caseAListeDeclarationVarPrime(AListeDeclarationVarPrime node);
    void caseAVideListeDeclarationVarPrime(AVideListeDeclarationVarPrime node);
    void caseADeclarationVar(ADeclarationVar node);
    void caseATableauDeclarationVar(ATableauDeclarationVar node);
    void caseAListeDeclarationFonc(AListeDeclarationFonc node);
    void caseAVideListeDeclarationFonc(AVideListeDeclarationFonc node);
    void caseADeclarationFonc(ADeclarationFonc node);
    void caseABoolType(ABoolType node);
    void caseAEntierType(AEntierType node);
    void caseATypeTypeOptionnel(ATypeTypeOptionnel node);
    void caseAVideTypeOptionnel(AVideTypeOptionnel node);
    void caseABlocInstruction(ABlocInstruction node);
    void caseAListeInstruction(AListeInstruction node);
    void caseAVideListeInstruction(AVideListeInstruction node);
    void caseAAffectationInstruction(AAffectationInstruction node);
    void caseAIncrInstruction(AIncrInstruction node);
    void caseASiInstruction(ASiInstruction node);
    void caseASiSinonInstruction(ASiSinonInstruction node);
    void caseATantQueInstruction(ATantQueInstruction node);
    void caseARetourInstruction(ARetourInstruction node);
    void caseAAppelFonctionInstruction(AAppelFonctionInstruction node);
    void caseAEcrireInstruction(AEcrireInstruction node);
    void caseAFaireTantQueInstruction(AFaireTantQueInstruction node);
    void caseAVar(AVar node);
    void caseATableauVar(ATableauVar node);
    void caseAListeExp(AListeExp node);
    void caseAVideListeExp(AVideListeExp node);
    void caseAListeExpPrime(AListeExpPrime node);
    void caseAVideListeExpPrime(AVideListeExpPrime node);
    void caseAOuExp(AOuExp node);
    void caseAExp1Exp(AExp1Exp node);
    void caseAEtExp1(AEtExp1 node);
    void caseAExp2Exp1(AExp2Exp1 node);
    void caseAEgalExp2(AEgalExp2 node);
    void caseAInfExp2(AInfExp2 node);
    void caseAExp3Exp2(AExp3Exp2 node);
    void caseAPlusExp3(APlusExp3 node);
    void caseAMoinsExp3(AMoinsExp3 node);
    void caseAExp4Exp3(AExp4Exp3 node);
    void caseAMultExp4(AMultExp4 node);
    void caseAModuloExp4(AModuloExp4 node);
    void caseADivExp4(ADivExp4 node);
    void caseAExp5Exp4(AExp5Exp4 node);
    void caseANonExp5(ANonExp5 node);
    void caseAExp6Exp5(AExp6Exp5 node);
    void caseAPowerExp6(APowerExp6 node);
    void caseAExp7Exp6(AExp7Exp6 node);
    void caseAEntreParanthesesExp7(AEntreParanthesesExp7 node);
    void caseANombreExp7(ANombreExp7 node);
    void caseAVraiExp7(AVraiExp7 node);
    void caseAFauxExp7(AFauxExp7 node);
    void caseAAppelFonctionExp7(AAppelFonctionExp7 node);
    void caseALireExp7(ALireExp7 node);
    void caseAVariableExp7(AVariableExp7 node);

    void caseTCrochetGauche(TCrochetGauche node);
    void caseTCrochetDroit(TCrochetDroit node);
    void caseTParentheseGauche(TParentheseGauche node);
    void caseTParentheseDroite(TParentheseDroite node);
    void caseTAccoladeGauche(TAccoladeGauche node);
    void caseTAccoladeDroite(TAccoladeDroite node);
    void caseTSi(TSi node);
    void caseTSinon(TSinon node);
    void caseTAlors(TAlors node);
    void caseTTantQue(TTantQue node);
    void caseTFaire(TFaire node);
    void caseTEcrire(TEcrire node);
    void caseTRetour(TRetour node);
    void caseTLire(TLire node);
    void caseTOu(TOu node);
    void caseTEt(TEt node);
    void caseTEgal(TEgal node);
    void caseTPlusegal(TPlusegal node);
    void caseTModulo(TModulo node);
    void caseTInf(TInf node);
    void caseTPlus(TPlus node);
    void caseTMoins(TMoins node);
    void caseTMult(TMult node);
    void caseTPower(TPower node);
    void caseTDiv(TDiv node);
    void caseTExclamation(TExclamation node);
    void caseTBool(TBool node);
    void caseTEntier(TEntier node);
    void caseTVrai(TVrai node);
    void caseTFaux(TFaux node);
    void caseTVirgule(TVirgule node);
    void caseTPointVirgule(TPointVirgule node);
    void caseTEspace(TEspace node);
    void caseTCommentaire(TCommentaire node);
    void caseTNombre(TNombre node);
    void caseTIdentif(TIdentif node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
