package ASTNode;

public class UnaryOpNode extends ExpNode implements ASTNode{
    private ExpNode Right;
    private String Op;

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
        return "UnaryOpNode{" +
                "Op='" + Op + '\'' +
                ",  Right=" + Right +
                '}';
    }
}
