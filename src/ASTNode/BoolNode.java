package ASTNode;

public class BoolNode extends ExpNode {
    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    private boolean value;

}
