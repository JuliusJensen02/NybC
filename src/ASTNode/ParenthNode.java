package ASTNode;

public class ParenthNode extends ExpNode implements ASTNode {
    private ASTNode Inner;

    public ASTNode getInner() {
        return Inner;
    }

    public void setInner(ASTNode inner) {
        Inner = inner;
    }
}
