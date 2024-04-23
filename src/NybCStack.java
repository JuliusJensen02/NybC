import java.util.HashMap;
import java.util.Stack;

public class NybCStack {
    private final HashMap<String, Object> fmap = new HashMap<>();
    private final Stack<NybCFrame> stack = new Stack<>();

    public Stack<NybCFrame> getStack() {
        return stack;
    }
    public HashMap<String, Object> getFmap() {
        return fmap;
    }

    public void PutVariableToCurrentStack(String id, Object value) {
        if(IsVariableOnCurrentStack(id)) {
            throw new RuntimeException("Variable " + id + " already declared");
        }
        getStack().peek().getVariables().put(id, value);
    }

    public Object GetVariableOnCurrentStack(String id) {
        if(IsVariableOnCurrentStack(id)) {
            return getStack().peek().getVariables().get(id);
        }
        throw new RuntimeException("Variable " + id + " is not declared on current stack");
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
