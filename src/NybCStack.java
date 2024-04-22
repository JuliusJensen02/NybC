import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class NybCStack {
    private HashMap<String, Object> fmap = new HashMap<>();
    private Stack<HashMap<String, Object>> stack = new Stack<>();

    public Stack<HashMap<String, Object>> getStack() {
        return stack;
    }
    public HashMap<String, Object> getFmap() {
        return fmap;
    }
}
