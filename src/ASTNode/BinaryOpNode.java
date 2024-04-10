package ASTNode;

public class BinaryOpNode extends ExpNode {
    private ProgramNode Left;
    private ProgramNode Right;
    private String Op;

    public ProgramNode getLeft() {
        return Left;
    }

    public void setLeft(ProgramNode left) {
        Left = left;
    }

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
