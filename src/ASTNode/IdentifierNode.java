package ASTNode;

public class IdentifierNode extends ExpNode implements ASTNode {
    private String value;

    public IdentifierNode(){}
    public IdentifierNode(String value){
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;

    public IdentifierNode(String value) {
        this.value = value;
    }

    public IdentifierNode() {
    }

    @Override
    public String toString() {
        return "IdentifierNode{" +
                "value='" + value + '\'' +
                '}';
    }
}

