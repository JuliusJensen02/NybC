package ASTNode;

public class NotNode extends ExpNode {
    private ExpNode InnerNode;

    public ExpNode getInnerNode() {
        return InnerNode;
    }

    public void setInnerNode(ExpNode innerNode) {
        InnerNode = innerNode;
    }
}
