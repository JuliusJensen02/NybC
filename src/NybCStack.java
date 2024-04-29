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

    public HashMap<String, Object> LookupFunc(CallFuncNode node) {
        if (getFMap().containsKey(node.getId())){
            //There is sent a cloned table to avoid writ in the same table
            @SuppressWarnings("unchecked")
            HashMap<String, Object> clonedFunctionMap = (HashMap<String, Object>) getFMap().get(id).clone();

            return clonedFunctionMap;
        } else {
            Error.FUNCTION_NOT_DECLARED(id);
            return null;
        }
    }

    public boolean IsFunctionDeclared(String id) {
        return getFMap().containsKey(id);
    }

    public void PutVariableToCurrentStack(String id, Object value) {
        if(IsVariableOnCurrentStack(id)) {
            Error.VARIABLE_ALREADY_DECLARED(id);
            return;
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
            if (variable == null && stack.get(i).getVariables().containsKey(id)) {
                return null;
            }
            else if(variable != null){
                return variable;
            }
        }
        Error.VARIABLE_NOT_DECLARED(id);
        return null;
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

    public String StackToString(){
        return stack.toString();
    }

    public String FmapToString(){
        return fMap.toString();
    }
}


