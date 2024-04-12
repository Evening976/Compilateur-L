package sa;

public class SaIncr implements SaInst{
    private SaVar lhs;
    private SaExp rhs;

    public SaIncr(SaVar lhs, SaExp rhs){
        this.lhs = lhs;
        this.rhs = rhs;
    }
    public SaVar getLhs(){return this.lhs;}
    public SaExp getRhs(){return this.rhs;}

    public <T> T accept(SaVisitor <T> visitor) throws Exception{
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "(" + this.getClass().getSimpleName()+ " " + lhs + " " + rhs + ")";
    }
}


