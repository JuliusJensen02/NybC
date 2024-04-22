import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public interface VisitorInterface {
    static Stack<HashMap<String, Object>> stack = new Stack<>();
    static List<String> keywords = new ArrayList<String>();
    static HashMap<String, Object> fmap = new HashMap<>();

}
