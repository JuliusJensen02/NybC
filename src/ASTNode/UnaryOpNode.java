package ASTNode;

public class UnaryOpNode extends ExpNode implements ASTNode{
    private ASTNode Right;
    private String Op;

    public ASTNode getRight() {
        return Right;
    }

    public void setRight(ASTNode right) {
        Right = right;
    }

    public String getOp() {
        return Op;
    }

    public void setOp(String op) {
        Op = op;
    }
}
