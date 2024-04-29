package ASTNode;

public class IntNode extends ExpNode implements ASTNode {

    private int value;
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "IntNode{" +
                "value=" + value +
                '}';
    }
}
