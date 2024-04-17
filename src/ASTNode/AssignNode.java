package ASTNode;

public class AssignNode <T,G> extends ExpNode implements ASTNode {
    private T Left;
    private G Right;

    public AssignNode(T left, G right){
        this.Left = left;
        this.Right = right;
    }

    public T getLeft() {
        return Left;
    }

    public void setLeft(T left) {
        Left = left;
    }

    public G getRight() {
        return Right;
    }

    public void setRight(G right) {
        Right = right;
    }

    @Override
    public String toString() {
        return "AssignNode{" +
                "Left=" + Left +
                ", Right=" + Right +
                '}';
    }
}
