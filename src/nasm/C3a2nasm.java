package nasm;

import java.util.*;
import ts.*;
import c3a.*;

public class C3a2nasm implements C3aVisitor<NasmOperand> {
  private C3a c3a;
  private Nasm nasm;
  private Ts tableGlobale;
  private TsItemFct currentFct;
  private NasmRegister esp;
  private NasmRegister ebp;

  public C3a2nasm(C3a c3a, Ts tableGlobale) {
    this.c3a = c3a;
    nasm = new Nasm(tableGlobale);
    nasm.setTempCounter(c3a.getTempCounter());

    this.tableGlobale = tableGlobale;
    this.currentFct = null;
    esp = new NasmRegister(-1);
    esp.colorRegister(Nasm.REG_ESP);

    ebp = new NasmRegister(-1);
    ebp.colorRegister(Nasm.REG_EBP);
  }

  public Nasm getNasm() {
    return nasm;
  }

  public NasmOperand visit(C3a c3a) {

    // c3a.listeInst.get(0).accept(this);
    // c3a.listeInst.remove(0);

    // nasm.ajouteInst(new NasmSub(null, esp, new NasmConstant(4), "allocation
    // mémoire pour la valeur de retour"));
    // nasm.ajouteInst(new NasmCall(null, new NasmLabel("main"), ""));
    // nasm.ajouteInst(new NasmPop(null, new NasmRegister(0), "récupération de la
    // valeur de retour"));

    // c3a.listeInst.forEach(inst -> inst.accept(this));
    // for(C3aInst inst : c3a.listeInst) {
    // inst.accept(this);
    // }
    // NasmRegister reg_ebx = nasm.newRegister();
    // reg_ebx.colorRegister(Nasm.REG_EBX);
    // nasm.ajouteInst(new NasmMov(null, reg_ebx, new NasmConstant(0), " valeur de
    // retour du programme"));
    // NasmRegister reg_eax = nasm.newRegister();
    // reg_eax.colorRegister(Nasm.REG_EAX);
    // nasm.ajouteInst(new NasmMov(null, reg_eax, new NasmConstant(1), " code de
    // sortie"));
    // nasm.ajouteInst(new NasmInt(null, ""));
      c3a.setTempCounter(7);
    c3a.listeInst.forEach(inst -> inst.accept(this));

    return null;
  }

  public NasmOperand visit(C3aInstAdd inst) {
    NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
    NasmOperand op1 = inst.op1.accept(this);
    NasmOperand op2 = inst.op2.accept(this);
    NasmOperand dest = inst.result.accept(this);
    nasm.ajouteInst(new NasmMov(label, dest, op1, ""));
    nasm.ajouteInst(new NasmAdd(null, dest, op2, ""));
    return null;
  }

  public NasmOperand visit(C3aInstCall inst) {
    TsItemFct _currentFct = currentFct;
    currentFct = inst.op1.val;
    NasmOperand label = inst.op1.accept(this);
    NasmOperand dest = inst.result.accept(this);
    nasm.ajouteInst(new NasmSub(null, esp, new NasmConstant(4), "allocation mémoire pour la valeur de retour"));
    nasm.ajouteInst(new NasmCall(null, label, ""));
    nasm.ajouteInst(new NasmPop(null, dest, "récupération de la valeur de retour"));
    if (inst.op1.val.nbArgs > 0) {
      nasm.ajouteInst(new NasmAdd(null, esp, new NasmConstant(inst.op1.val.nbArgs * 4), "désallocation des arguments"));
    }
    currentFct = _currentFct;

    // nasm.ajouteInst(new NasmCall(label, dest, ""));

    return null;
  }

  public NasmOperand visit(C3aInstFBegin inst) {
    NasmRegister reg_eax = new NasmRegister(Nasm.REG_EAX);
    NasmRegister reg_ebx = new NasmRegister(Nasm.REG_EBX);
    NasmRegister reg_ecx = new NasmRegister(Nasm.REG_ECX);
    NasmRegister reg_edx = new NasmRegister(Nasm.REG_EDX);
    reg_eax.colorRegister(Nasm.REG_EAX);
    reg_ebx.colorRegister(Nasm.REG_EBX);
    reg_ecx.colorRegister(Nasm.REG_ECX);
    reg_edx.colorRegister(Nasm.REG_EDX);

    currentFct = inst.val;

    NasmLabel funName = new NasmLabel(currentFct.identif);

    nasm.ajouteInst(new NasmPush(funName, ebp, "sauvegarde la valeur de ebp"));
    nasm.ajouteInst(new NasmMov(null, ebp, esp, "nouvelle valeur de ebp"));

    nasm.ajouteInst(new NasmPush(null, reg_eax, "sauvegarde de eax"));
    nasm.ajouteInst(new NasmPush(null, reg_ebx, "sauvegarde de ebx"));
    nasm.ajouteInst(new NasmPush(null, reg_ecx, "sauvegarde de ecx"));
    nasm.ajouteInst(new NasmPush(null, reg_edx, "sauvegarde de edx"));

    if (inst.val.saDecFonc.getVariable() == null)
      nasm.ajouteInst(new NasmSub(null, esp, new NasmConstant(0), "allocation des variables locales"));
    else
      nasm.ajouteInst(new NasmSub(null, esp,
          new NasmConstant(inst.val.saDecFonc.getVariable().length() * NasmSize.DWORD.getValue()),
          "allocation des variables locales"));

    return null;
    // System.out.println("Allocation des variables locales: " +
    // inst.val.saDecFonc.getVariable().length() * NasmSize.DWORD.getValue() + "
    // octets soit " + inst.val.getNbArgs() * NasmSize.DWORD.getValue() + "
    // octets");
  }

  public NasmOperand visit(C3aInst inst) {
    return null;
  }

  public NasmOperand visit(C3aInstJumpIfLess inst) {
    NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;

    NasmOperand op1 = inst.op1.accept(this);
    NasmOperand op2 = inst.op2.accept(this);

    if (op1 instanceof NasmConstant || (op1 instanceof NasmAddress && op2 instanceof NasmAddress)) {
      NasmRegister r1 = nasm.newRegister();
      nasm.ajouteInst(new NasmMov(label, r1, op1, "JumpIfLess 1"));
      nasm.ajouteInst(new NasmCmp(null, r1, op2, "on passe par un registre temporaire"));
      nasm.ajouteInst(new NasmJl(null, inst.result.accept(this), "JumpIfLess 2"));
    } else {
      nasm.ajouteInst(new NasmCmp(label, op1, op2, "JumpIfLess 1"));
      nasm.ajouteInst(new NasmJl(null, inst.result.accept(this), "JumpIfLess 2"));
    }
    return null;
  }

  public NasmOperand visit(C3aInstMult inst) {
    NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
    NasmOperand op1 = inst.op1.accept(this);
    NasmOperand op2 = inst.op2.accept(this);
    NasmOperand dest = inst.result.accept(this);
    nasm.ajouteInst(new NasmMov(label, dest, op1, ""));
    nasm.ajouteInst(new NasmMul(null, dest, op2, ""));
    return null;
  }

  public NasmOperand visit(C3aInstRead inst) {
    NasmRegister reg_eax = new NasmRegister(Nasm.REG_EAX);
    NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
    nasm.ajouteInst(new NasmMov(label, reg_eax, new NasmLabel("sinput"), ""));
    nasm.ajouteInst(new NasmCall(null, new NasmLabel("readline"), ""));
    nasm.ajouteInst(new NasmCall(null, new NasmLabel("atoi"), ""));
    nasm.ajouteInst(new NasmMov(null, inst.result.accept(this), reg_eax, ""));
    return null;
  }

  public NasmOperand visit(C3aInstSub inst) {
    NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
    NasmOperand op1 = inst.op1.accept(this);
    NasmOperand op2 = inst.op2.accept(this);
    NasmOperand dest = inst.result.accept(this);
    nasm.ajouteInst(new NasmMov(label, dest, op1, ""));
    nasm.ajouteInst(new NasmSub(null, dest, op2, ""));
    return null;
  }

  public NasmOperand visit(C3aInstAffect inst) {
    NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
    NasmOperand src = inst.op1.accept(this);
    NasmOperand dest = inst.result.accept(this);
    // System.out.println(dest);
    // desallocation des arguments ici?
    nasm.ajouteInst(new NasmMov(label, dest, src, "Affect"));
    return null;
  }

  public NasmOperand visit(C3aInstDiv inst) {
    NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
    NasmOperand op1 = inst.op1.accept(this);
    NasmOperand op2 = inst.op2.accept(this);
    NasmOperand dest = inst.result.accept(this);
    nasm.ajouteInst(new NasmMov(label, dest, op1, ""));
    nasm.ajouteInst(new NasmDiv(dest, op2, ""));

    return null;
  }

  public NasmOperand visit(C3aInstFEnd inst) {
    NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;

    if (currentFct.saDecFonc.getVariable() == null) {
      nasm.ajouteInst(new NasmAdd(label, esp, new NasmConstant(0), "désallocation des variables locales"));
    } else {
      nasm.ajouteInst(new NasmAdd(label, esp, new NasmConstant(currentFct.saDecFonc.getVariable().length() * 4),
          "désallocation des variables locales"));
    }

    NasmRegister reg_eax = new NasmRegister(Nasm.REG_EAX);
    NasmRegister reg_ebx = new NasmRegister(Nasm.REG_EBX);
    NasmRegister reg_ecx = new NasmRegister(Nasm.REG_ECX);
    NasmRegister reg_edx = new NasmRegister(Nasm.REG_EDX);
    reg_eax.colorRegister(Nasm.REG_EAX);
    reg_ebx.colorRegister(Nasm.REG_EBX);
    reg_ecx.colorRegister(Nasm.REG_ECX);
    reg_edx.colorRegister(Nasm.REG_EDX);

    nasm.ajouteInst(new NasmPop(null, reg_edx, "restaure edx"));
    nasm.ajouteInst(new NasmPop(null, reg_ecx, "restaure ecx"));
    nasm.ajouteInst(new NasmPop(null, reg_ebx, "restaure ebx"));
    nasm.ajouteInst(new NasmPop(null, reg_eax, "restaure eax"));
    nasm.ajouteInst(new NasmPop(null, ebp, "restaure la valeur de ebp"));
    nasm.ajouteInst(new NasmRet(null, ""));
    return null;
  }

  public NasmOperand visit(C3aInstJumpIfEqual inst) {
    NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;

    NasmOperand op1 = inst.op1.accept(this);
    NasmOperand op2 = inst.op2.accept(this);

    if (op1 instanceof NasmConstant || (op1 instanceof NasmAddress && op2 instanceof NasmAddress)) {
      NasmRegister r1 = nasm.newRegister();
      nasm.ajouteInst(new NasmMov(label, r1, op1, "JumpIfEqual 1"));
      nasm.ajouteInst(new NasmCmp(null, r1, op2, "on passe par un registre temporaire"));
      nasm.ajouteInst(new NasmJe(null, inst.result.accept(this), "JumpIfEqual 2"));
    } else {
      nasm.ajouteInst(new NasmCmp(label, op1, op2, "JumpIfEqual 1"));
      nasm.ajouteInst(new NasmJe(null, inst.result.accept(this), "JumpIfEqual 2"));
    }
    return null;
  }

  public NasmOperand visit(C3aInstJumpIfNotEqual inst) {
    NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;

    NasmOperand op1 = inst.op1.accept(this);
    NasmOperand op2 = inst.op2.accept(this);

    System.out.println(op1);
    System.out.println(op2);

    if (op1 instanceof NasmConstant || (op1 instanceof NasmAddress && op2 instanceof NasmAddress)) {
      NasmRegister r1 = nasm.newRegister();
      nasm.ajouteInst(new NasmMov(label, r1, op1, "jumpIfNotEqual 1"));
      nasm.ajouteInst(new NasmCmp(null, r1, op2, "on passe par un registre temporaire"));
      nasm.ajouteInst(new NasmJne(null, inst.result.accept(this), "jumpIfNotEqual 2"));
    } else {
      nasm.ajouteInst(new NasmCmp(label, op1, op2, "jumpIfNotEqual 1"));
      nasm.ajouteInst(new NasmJne(null, inst.result.accept(this), "jumpIfNotEqual 2"));
    }
    return null;
  }

  public NasmOperand visit(C3aInstJump inst) {
    NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
    nasm.ajouteInst(new NasmJmp(label, inst.result.accept(this), "Jump"));
    return null;
  }

  public NasmOperand visit(C3aInstParam inst) {
    NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
    nasm.ajouteInst(new NasmPush(label, inst.op1.accept(this), "Param"));
    return null;
  }

  public NasmOperand visit(C3aInstReturn inst) {
    NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
    System.out.println(label);
    NasmAddress na = new NasmAddress(new NasmExpPlus(ebp, new NasmConstant(8)), NasmSize.DWORD);
    System.out.println(inst.op1.accept(this));
    NasmInst ret = new NasmMov(label, na, inst.op1.accept(this), "ecriture de la valeur de retour");
    System.out.println(ret);
    nasm.ajouteInst(ret);
    return null;
  }

  public NasmOperand visit(C3aInstWrite inst) {
    NasmRegister reg_eax = nasm.newRegister();
    reg_eax.colorRegister(Nasm.REG_EAX);

    NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
    nasm.ajouteInst(new NasmMov(label, reg_eax, inst.op1.accept(this), "Write 1"));
    nasm.ajouteInst(new NasmCall(null, new NasmLabel("iprintLF"), "Write 2"));
    return null;
  }

  public NasmOperand visit(C3aInstStop inst) {
    NasmRegister reg_eax = nasm.newRegister();
    reg_eax.colorRegister(Nasm.REG_EAX);
    NasmRegister reg_ebx = nasm.newRegister();
    reg_ebx.colorRegister(Nasm.REG_EBX);

    NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;

    nasm.ajouteInst(new NasmMov(label, reg_ebx, new NasmConstant(0), " valeur de retour du programme"));
    nasm.ajouteInst(new NasmMov(null, reg_eax, new NasmConstant(1), " code de sortie"));
    nasm.ajouteInst(new NasmInt(null, ""));
    return null;
  }

  public NasmOperand visit(C3aConstant oper) {
    return new NasmConstant(oper.val);
  }

  public NasmOperand visit(C3aBooleanConstant oper) {
    return null;
  }

  public NasmOperand visit(C3aLabel oper) {
    return new NasmLabel("l"+oper.toString());
  }

  public NasmOperand visit(C3aTemp oper) {
    return new NasmRegister(oper.num);
  }

  public NasmOperand visit(C3aVar oper) {
    if (currentFct.getTable().getVar(oper.item.identif) != null) {
      TsItemVar var = currentFct.getTable().getVar(oper.item.identif);
      if (var.isParam) {
        return new NasmAddress(
            (NasmExp) new NasmExpPlus(ebp, new NasmConstant(8 + currentFct.getNbArgs() * NasmSize.DWORD.getValue()
                - var.adresse)),
            NasmSize.DWORD);
      }
      return new NasmAddress((NasmExp) new NasmExpMinus((NasmExp) ebp,
          (NasmExp) new NasmConstant(NasmSize.DWORD.getValue() + var.adresse)), NasmSize.DWORD);
      // return new NasmAddress(new NasmExpPlus((NasmExp)ebp, ))); //ebp + 8 + 4 *
      // (numéro du paramètre)
      // else
      // return new NasmAdress() //ebp - (adresse de la variable + taille de la
      // variable(?))
    } else {
      if (oper.index == null) {
        return new NasmAddress(new NasmLabel(oper.item.identif), NasmSize.DWORD);
      } else {
        TsItemVar var = tableGlobale.getVar(oper.item.identif);
        NasmRegister r1 = nasm.newRegister();
        nasm.ajouteInst(new NasmMov(null, r1, oper.index.accept(this), ""));
        nasm.ajouteInst(new NasmMov(null, r1, new NasmConstant(4), ""));
        return new NasmAddress(new NasmLabel(var.identif), NasmSize.DWORD);
        // c'est une variable globale
      }
    }
    // return null;
  }

  public NasmOperand visit(C3aFunction oper) {
    return new NasmLabel(oper.val.identif);
  }

}
