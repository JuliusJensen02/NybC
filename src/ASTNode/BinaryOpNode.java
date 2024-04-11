package ASTNode;

public class BinaryOpNode extends ExpNode implements ASTNode{
    private ASTNode Left;
    private ASTNode Right;
    private String Op;

    public ASTNode getLeft() {
        return Left;
    }

    public void setLeft(ASTNode left) {
        Left = left;
    }

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

    public String toString() {
        return Left+Op+Right;
    }
}
