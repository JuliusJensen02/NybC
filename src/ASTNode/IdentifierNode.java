package ASTNode;

public class IdentifierNode extends ExpNode {
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;
}
