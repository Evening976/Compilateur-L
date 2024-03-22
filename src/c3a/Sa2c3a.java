package c3a;
import ts.*;
import sa.*;


public class Sa2c3a extends SaDepthFirstVisitor <C3aOperand> {
    private C3a c3a;
    int indentation;
    public C3a getC3a(){return this.c3a;}
    
    public Sa2c3a(SaNode root, Ts tableGlobale){
	c3a = new C3a();
	C3aTemp result = c3a.newTemp();
	C3aFunction fct = new C3aFunction(tableGlobale.getFct("main"));
	c3a.ajouteInst(new C3aInstCall(fct, result, ""));
	c3a.ajouteInst(new C3aInstStop(result, ""));
	indentation = 0;
    }

    public void defaultIn(SaNode node)
    {
	//for(int i = 0; i < indentation; i++){System.out.print(" ");}
	//indentation++;
	//System.out.println("<" + node.getClass().getSimpleName() + ">");
    }

    public void defaultOut(SaNode node)
    {
	//indentation--;
	//	for(int i = 0; i < indentation; i++){System.out.print(" ");}
	//	System.out.println("</" + node.getClass().getSimpleName() + ">");
    }
    

    // EXP -> op2 EXP EXP
    public C3aOperand visit(SaExpAdd node) throws Exception
    {
	defaultIn(node);
	C3aOperand op1 = node.getOp1().accept(this);
	C3aOperand op2 = node.getOp2().accept(this);
	C3aOperand result = c3a.newTemp();

	c3a.ajouteInst(new C3aInstAdd(op1, op2, result, ""));
	defaultOut(node);
	return result;
    }

	public C3aOperand visit(SaExpMult node) throws Exception{
		defaultIn(node);
		C3aOperand op1 = node.getOp1().accept(this);
		C3aOperand op2 = node.getOp2().accept(this);
		C3aOperand result = c3a.newTemp();

		c3a.ajouteInst(new C3aInstMult(op1, op2, result, ""));
		defaultOut(node);
		return result;
	}

	public C3aOperand visit(SaExpDiv node) throws Exception{
		defaultIn(node);
		C3aOperand op1 = node.getOp1().accept(this);
		C3aOperand op2 = node.getOp2().accept(this);
		C3aOperand result = c3a.newTemp();

		c3a.ajouteInst(new C3aInstDiv(op1, op2, result, ""));
		defaultOut(node);
		return result;
	}

	public C3aOperand visit(SaInstEcriture node) throws Exception{
		defaultIn(node);
		C3aOperand op1 = node.getArg().accept(this);
		c3a.ajouteInst(new C3aInstWrite(op1, ""));
		defaultOut(node);
		return null;
	}

	public C3aOperand visit(SaExpInt node){
		return new C3aConstant(node.getVal());
	}

	@Override
	public C3aOperand visit(SaExpEqual node) throws Exception{
		defaultIn(node);
		C3aOperand op1 = node.getOp1().accept(this);
		C3aOperand op2 = node.getOp2().accept(this);

		c3a.ajouteInst(new C3aInstAffect(op1, op2, ""));

		defaultOut(node);
		return op1;
	}


	public C3aOperand visit(SaExpVrai node){
		return c3a.True;
	}

	public C3aOperand visit(SaExpFaux node){ 
		return c3a.False;
	}

	public C3aOperand visit(SaExp node) throws Exception
	{
		defaultIn(node);
		C3aOperand result = node.accept(this);
		defaultOut(node);
		return result;
	}

	public C3aOperand visit(SaExpVar node) throws Exception
	{
		defaultIn(node);
		C3aOperand result = node.getVar().accept(this);
		defaultOut(node);
		return result;
	}

	public C3aOperand visit(SaExpSub node) throws Exception
	{
		defaultIn(node);
		C3aOperand op1 = node.getOp1().accept(this);
		C3aOperand op2 = node.getOp2().accept(this);
		C3aOperand result = c3a.newTemp();

		c3a.ajouteInst(new C3aInstSub(op1, op2, result, ""));
		defaultOut(node);
		return result;
	}

	public C3aOperand visit(SaAppel node) throws Exception{
		defaultIn(node);
		if(node.getArguments() != null) node.getArguments().accept(this);
		C3aFunction fct = new C3aFunction(node.tsItem);
		C3aOperand result = c3a.newTemp();
		c3a.ajouteInst(new C3aInstCall(fct, result, ""));
		defaultOut(node);
		return result;
	}

	public C3aOperand visit(SaDecFonc node) throws Exception{
		defaultIn(node);
		C3aFunction fct = new C3aFunction(node.tsItem);
		c3a.addLabelToNextInst(c3a.newAutoLabel());
		c3a.ajouteInst(new C3aInstFBegin(node.tsItem, "entree fonction"));
		if(node.getCorps() != null){
			node.getCorps().accept(this);
		}
		if(node.getParametres() != null){
			node.getParametres().accept(this);
		}
		if(node.getVariable() != null){
			node.getVariable().accept(this);
		}
		c3a.ajouteInst(new C3aInstFEnd("fin fonction"));
		defaultOut(node);
		return fct;
	}

	@Override
	public C3aOperand visit(SaInstAffect node) throws Exception {
		defaultIn(node);
		C3aOperand op1 = node.getLhs().accept(this);
		C3aOperand op2 = node.getRhs().accept(this);
		c3a.ajouteInst(new C3aInstAffect(op2, op1, ""));
		defaultOut(node);
		return op1;
	}

	@Override
	public C3aOperand visit(SaProg node) throws Exception {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaVarSimple node) throws Exception {
		defaultIn(node);
		C3aVar var = new C3aVar(node.tsItem, null);
		defaultOut(node);
		return var;
	}

	@Override
	public C3aOperand visit(SaVarIndicee node) throws Exception {
		defaultIn(node);
		C3aVar var = new C3aVar(node.tsItem, node.getIndice().accept(this));
		defaultOut(node);
		return var;
	}

	@Override
	public C3aOperand visit(SaExpLire node) throws Exception {
		defaultIn(node);
		C3aTemp result = c3a.newTemp();
		c3a.ajouteInst(new C3aInstRead(result, ""));
		defaultOut(node);
		return result;
	}

	@Override
	public C3aOperand visit(SaExpAppel node) throws Exception {
		defaultIn(node);
		C3aOperand result = node.getVal().accept(this);
		defaultOut(node);
		return result;
	}
}
