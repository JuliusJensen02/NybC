import java.util.HashMap;
import java.util.Stack;

public interface VisitorInterface {
    static Stack<HashMap<String, Object>> stack = new Stack<>();
    static HashMap<String, Object> vmap = new HashMap<>();

    static HashMap<String, Object> fmap = new HashMap<>();

}
