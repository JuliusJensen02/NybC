import ASTNode.ProgramNode;

import java.util.HashMap;

/**
 * NybCFrame is a class that represents a hashmap on the stack
 */
public class NybCFrame {
    private final HashMap<String, Object> variables;
    public HashMap<String, Object> getVariables() {
        return variables;
    }

    public NybCFrame(HashMap<String, Object> hashMap) {
        variables = hashMap;
    }

    public NybCFrame() {
        variables = new HashMap<String, Object>();
    }

    @Override
    public String toString() {
        return variables.toString();
    }
}
