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
				throw new ErrorException(Error.TYPE, "Le test du si doit être de type booléen");
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



}
