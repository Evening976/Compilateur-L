package sa;
import util.Type;
import util.Error;
import ts.*;

public class SaTypeCheck extends SaDepthFirstVisitor <Void>{
    private TsItemFct fonctionCourante;

    public SaTypeCheck(SaNode root)
    {
		try{
			root.accept(this);
		} catch(ErrorException e){
			System.err.print("ERREUR DE TYPAGE : ");
			System.err.println(e.getMessage());
			System.exit(e.getCode());
		} catch(Exception e){}
	}

    public void defaultIn(SaNode node)
    {
		//			System.out.println("<" + node.getClass().getSimpleName() + ">");
    }

    public void defaultOut(SaNode node)
    {
		//		System.out.println("</" + node.getClass().getSimpleName() + ">");
    }

		@Override
		public Void visit(SaInstAffect node) throws Exception {
			defaultIn(node);

			if(!Type.checkCompatibility(node.getLhs().getTsItem().getType(), node.getRhs().getType())){
				throw new ErrorException(Error.TYPE, "Types incompatibles dans l'affectation entre " + node.getLhs().getTsItem().getIdentif() + " et " + node.getRhs().getType());
			}

			node.getLhs().accept(this);
			node.getRhs().accept(this);

			defaultOut(node);
			return null;
		}

		@Override
		public Void visit(SaInstTantQue node) throws Exception {
			defaultIn(node);

			System.out.println("CA VISITE UN TANT QUE");

			if(node.getTest().getType() != Type.BOOL){
				throw new ErrorException(Error.TYPE, "Le test du tant que doit être de type booléen");
			}

			node.getTest().accept(this);
			if(node.getFaire()!=null) node.getFaire().accept(this);

			defaultOut(node);
			return null;
		}

		@Override
		public Void visit(SaInstSi node) throws Exception {
			defaultIn(node);

			if(node.getTest().getType() != Type.BOOL){
				throw new ErrorException(Error.TYPE, "La condition doit être de type booléene");
			}

			node.getTest().accept(this);
			if(node.getAlors()!=null) node.getAlors().accept(this);
			if(node.getSinon()!=null) node.getSinon().accept(this);

			defaultOut(node);
			return null;
		}

		@Override
		public Void visit(SaInstRetour node) throws Exception {
			defaultIn(node);


			if(!Type.checkCompatibility(fonctionCourante.getTypeRetour(), node.getVal().getType())){
				throw new ErrorException(Error.TYPE, "Le type de retour de " + fonctionCourante.getIdentif()+ " est incompatible avec "  + node.getType());
			}

			node.getVal().accept(this);

			defaultOut(node);
			return null;
		}

		@Override
		public Void visit(SaExpAdd node) throws Exception {
			defaultIn(node);
			if(node.getOp1().getType() != Type.ENTIER || node.getOp2().getType() != Type.ENTIER){
				throw new ErrorException(Error.TYPE, "Les opérandes de l'addition doivent être de type entier");
			}
			defaultOut(node);
			return null;
		}

		@Override
		public Void visit(SaAppel node) throws Exception {
			defaultIn(node);
			if(node.getArguments() != null){
				//node.getArguments().getTete().getType() 
			}
			defaultOut(node);
			return null;
		}

		@Override
		public Void visit(SaLExp node) throws Exception {
			defaultIn(node);
			if(node.getTete() != null){
				node.getTete().accept(this);
			}
			if(node.getQueue() != null){
				node.getQueue().accept(this);
			}
			defaultOut(node);
			return null;
		}

		@Override
		public Void visit(SaExp node) throws Exception {
			// TODO Auto-generated method stub
			return super.visit(node);
		}

		@Override
		public Void visit(SaExpEqual node) throws Exception {
			defaultIn(node);
			if(node.getOp1().getType() != node.getOp2().getType()){
				throw new ErrorException(Error.TYPE, "Les 2 membres d'une égalité doivent être de même type");
			}
			defaultOut(node);
			return null;
		}

		@Override
		public Void visit(SaExpNot node) throws Exception 
		{
			defaultIn(node);
			if(node.getOp1().getType() != Type.BOOL){
				throw new ErrorException(Error.TYPE, "l'expression affectée par la négation doit être de type booléen");
			}
			defaultOut(node);
			return null;
		}

		@Override
		public Void visit(SaExpAnd node) throws Exception{
			defaultIn(node);
			if(node.getOp1().getType() != Type.BOOL || node.getOp2().getType() != Type.BOOL){
				throw new ErrorException(Error.TYPE, "Les 2 membres doivent être de même type");
			}
			defaultOut(node);
			return null;
		}


		@Override
		public Void visit(SaExpSub node) throws Exception{
			defaultIn(node);
			if(node.getOp1().getType() != Type.ENTIER || node.getOp2().getType() != Type.ENTIER){
				throw new ErrorException(Error.TYPE, "Les 2 membres doivent être de type entier");
			}
			defaultOut(node);
			return null;
		}

		@Override
		public Void visit(SaExpOr node) throws Exception{
			defaultIn(node);
			if(node.getOp1().getType() != Type.BOOL || node.getOp2().getType() != Type.BOOL){
				throw new ErrorException(Error.TYPE, "Les 2 membres doivent être de type booléen");
			}
			defaultOut(node);
			return null;
		}

		@Override
		public Void visit(SaExpMult node) throws Exception{
			defaultIn(node);
			if(node.getOp1().getType() != Type.ENTIER || node.getOp2().getType() != Type.ENTIER){
				throw new ErrorException(Error.TYPE, "Les 2 membres doivent être de type entier");
			}
			defaultOut(node);
			return null;
		}

		@Override
		public Void visit(SaExpInf node) throws Exception{
			defaultIn(node);
			if(node.getOp1().getType() != Type.ENTIER || node.getOp2().getType() != Type.ENTIER){
				throw new ErrorException(Error.TYPE, "Les 2 membres doivent être de type entier");
			}
			defaultOut(node);
			return null;
		}

		@Override
		public Void visit(SaExpDiv node) throws Exception{
			defaultIn(node);
			if(node.getOp1().getType() != Type.ENTIER || node.getOp2().getType() != Type.ENTIER){
				throw new ErrorException(Error.TYPE, "Les 2 membres doivent être de type entier");
			}
			defaultOut(node);
			return null;
		}
}
