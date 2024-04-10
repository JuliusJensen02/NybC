package ASTNode;

public class UnaryOpNode extends ExpNode{
    private ProgramNode Right;
    private String Op;

    public ProgramNode getRight() {
        return Right;
    }

    public void setRight(ProgramNode right) {
        Right = right;
    }

    public String getOp() {
        return Op;
    }

    public void setOp(String op) {
        Op = op;
    }
}
