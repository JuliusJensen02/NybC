import java.util.HashMap;
import java.util.Stack;

public class NybCStack {
    private final HashMap<String, HashMap<String, Object>> fMap = new HashMap<>();
    private final Stack<NybCFrame> stack = new Stack<>();

    private Stack<NybCFrame> getStack() { return stack; }

    private HashMap<String, HashMap<String, Object>> getFMap() {
        return fMap;
    }

    public void PutFunction(String id, HashMap<String, Object> functionMap) {
        getFMap().put(id, functionMap);
    }

    public HashMap<String, Object> LookupFunc(String node) {
        if (getFMap().containsKey(node)){
            return getFMap().get(node);
        } else {
            throw new RuntimeException("Function does not exist");
        }
    }

    public void PutVariableToCurrentStack(String id, Object value) {
        if(IsVariableOnCurrentStack(id)) {
            throw new RuntimeException("Variable " + id + " already declared");
        }
        getStack().peek().getVariables().put(id, value);
    }

    public boolean IsVariableOnCurrentStack(String id) {
        return getStack().peek().getVariables().containsKey(id);
    }

    public void ReplaceVariableOnStack(String id, Object newValue) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            if(!stack.get(i).getVariables().containsKey(id)) {
                continue;
            }
            stack.get(i).getVariables().replace(id, newValue);
            return;
        }
        throw new RuntimeException("Variable " + id + " is not declared");
    }

    public boolean IsVariableOnStack(String id) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            if(stack.get(i).getVariables().containsKey(id)) {
                return true;
            }
        }
        return false;
    }

    public Object GetVariableOnStack(String id) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            Object variable = stack.get(i).getVariables().get(id);
            if (variable != null) {
                return variable;
            }
        }
        throw new RuntimeException("Variable " + id + " is not declared");
    }

    public void PushStack() {
        stack.push(new NybCFrame());
    }

    public void PushStack(HashMap<String, Object> hashMap) {
        stack.push(new NybCFrame(hashMap));
    }

    public void PopStack() {
        stack.pop();
    }
}
