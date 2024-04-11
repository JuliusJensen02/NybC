package ASTNode;

public class IntNode extends ExpNode implements ASTNode {

    public int value;
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString() {
        return String.valueOf(value);
    }

}
