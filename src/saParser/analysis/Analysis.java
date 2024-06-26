/* This file was generated by SableCC (http://www.sablecc.org/). */

package saParser.analysis;

import saParser.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAProg(AProg node);
    void caseAAddExp(AAddExp node);
    void caseAAndExp(AAndExp node);
    void caseADivExp(ADivExp node);
    void caseAEqualExp(AEqualExp node);
    void caseAInfExp(AInfExp node);
    void caseAMultExp(AMultExp node);
    void caseAModuloExp(AModuloExp node);
    void caseAOrExp(AOrExp node);
    void caseASubExp(ASubExp node);
    void caseANotExp(ANotExp node);
    void caseAAppelExp(AAppelExp node);
    void caseAVarExp(AVarExp node);
    void caseAFauxExp(AFauxExp node);
    void caseAVraiExp(AVraiExp node);
    void caseAIntExp(AIntExp node);
    void caseALireExp(ALireExp node);
    void caseAAffectInst(AAffectInst node);
    void caseAIncrInst(AIncrInst node);
    void caseABlocInst(ABlocInst node);
    void caseAEcritureInst(AEcritureInst node);
    void caseARetourInst(ARetourInst node);
    void caseASiInst(ASiInst node);
    void caseASi2Inst(ASi2Inst node);
    void caseATantqueInst(ATantqueInst node);
    void caseAAppelInst(AAppelInst node);
    void caseARecLdecfonc(ARecLdecfonc node);
    void caseAFinLdecfonc(AFinLdecfonc node);
    void caseARecLdecvar(ARecLdecvar node);
    void caseAFinLdecvar(AFinLdecvar node);
    void caseARecLexp(ARecLexp node);
    void caseAFinLexp(AFinLexp node);
    void caseARecLinst(ARecLinst node);
    void caseAFinLinst(AFinLinst node);
    void caseADecfonc(ADecfonc node);
    void caseATabDecvar(ATabDecvar node);
    void caseASimpleDecvar(ASimpleDecvar node);
    void caseAIndiceeVar(AIndiceeVar node);
    void caseASimpleVar(ASimpleVar node);
    void caseAAppel(AAppel node);
    void caseAEntierType(AEntierType node);
    void caseABoolType(ABoolType node);
    void caseANullType(ANullType node);

    void caseTEspaces(TEspaces node);
    void caseTCommentaire(TCommentaire node);
    void caseTPo(TPo node);
    void caseTPf(TPf node);
    void caseTSaappel(TSaappel node);
    void caseTSadecfonc(TSadecfonc node);
    void caseTSadectab(TSadectab node);
    void caseTSadecvar(TSadecvar node);
    void caseTSadecvarsimple(TSadecvarsimple node);
    void caseTSaexpadd(TSaexpadd node);
    void caseTSaexpand(TSaexpand node);
    void caseTSaexpappel(TSaexpappel node);
    void caseTSaexpdiv(TSaexpdiv node);
    void caseTSaexpequal(TSaexpequal node);
    void caseTSaexpfaux(TSaexpfaux node);
    void caseTSaexpinf(TSaexpinf node);
    void caseTSaexpint(TSaexpint node);
    void caseTSaexplire(TSaexplire node);
    void caseTSaexpmult(TSaexpmult node);
    void caseTSaexpmodulo(TSaexpmodulo node);
    void caseTSaexpnot(TSaexpnot node);
    void caseTSaexpor(TSaexpor node);
    void caseTSaexpsub(TSaexpsub node);
    void caseTSaexpvar(TSaexpvar node);
    void caseTSaexpvrai(TSaexpvrai node);
    void caseTSainstaffect(TSainstaffect node);
    void caseTSaincr(TSaincr node);
    void caseTSainstbloc(TSainstbloc node);
    void caseTSainstecriture(TSainstecriture node);
    void caseTSainstretour(TSainstretour node);
    void caseTSainstsi(TSainstsi node);
    void caseTSainsttantque(TSainsttantque node);
    void caseTSaldecfonc(TSaldecfonc node);
    void caseTSaldecvar(TSaldecvar node);
    void caseTSalexp(TSalexp node);
    void caseTSalinst(TSalinst node);
    void caseTSaprog(TSaprog node);
    void caseTSavarindicee(TSavarindicee node);
    void caseTSavarsimple(TSavarsimple node);
    void caseTFaux(TFaux node);
    void caseTVrai(TVrai node);
    void caseTLire(TLire node);
    void caseTNull(TNull node);
    void caseTEntier(TEntier node);
    void caseTBool(TBool node);
    void caseTNul(TNul node);
    void caseTInteger(TInteger node);
    void caseTId(TId node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
