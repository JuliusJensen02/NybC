package ASTNode;

public class ParenthNode extends ExpNode {
    private ProgramNode Inner;

    public ProgramNode getInner() {
        return Inner;
    }

    public void setInner(ProgramNode inner) {
        Inner = inner;
    }
}
