package ASTNode;

public class IdentifierNode extends ExpNode implements ASTNode {
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;

    public String toString() {
        return value;
    }
}

