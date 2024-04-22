package ASTNode;

public class BinaryOpNode extends ExpNode implements ASTNode{
    private ExpNode Left;
    private ExpNode Right;
    private String Op;

    public BinaryOpNode(ExpNode left, String op, ExpNode right) {
        Left = left;
        Right = right;
        Op = op;
    }

    public ExpNode getLeft() {
        return Left;
    }

    public void setLeft(ExpNode left) {
        Left = left;
    }

    public ExpNode getRight() {
        return Right;
    }

    public void setRight(ExpNode right) {
        Right = right;
    }

    public String getOp() {
        return Op;
    }

    public void setOp(String op) {
        Op = op;
    }

    @Override
    public String toString() {
        return "BinaryOpNode{" +
                "Left=" + Left +
                ", Op=" + Op +
                ", Right=" + Right  +
                '}';
    }
}
