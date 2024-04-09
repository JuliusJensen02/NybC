package ASTNode;

public class infixNode extends ExpNode {
    private ExpNode Left;
    private ExpNode Right;

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

}
