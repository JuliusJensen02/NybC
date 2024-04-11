package ASTNode;

import java.util.ArrayList;
import java.util.List;

public class ArrayNode extends ExpNode implements ASTNode {
    private List<ASTNode> value = new ArrayList<>();

    public List<ASTNode> getValue() {
        return value;
    }

    public void addValue(ASTNode value) {
        this.value.add(value);
    }

    public String toString() {
        return value.toString();
    }
}
