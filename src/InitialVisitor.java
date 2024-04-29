
import ASTNode.*;
import org.antlr.v4.codegen.model.decl.Decl;

import javax.sound.midi.SysexMessage;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

public class InitialVisitor extends ASTVisitor implements VisitorInterface{

/*    @Override
    public Object Visit(DeclNode<?> node) {

        if (node.getValue() instanceof ArrayNode) {
            return (List<Object>) Visit((ArrayNode) node.getValue());
        } else if (node.getValue() instanceof ExpNode){
            return Visit((ExpNode) node.getValue());
        } else  {
            return null;
        }
    }*/

    @Override
    public Object Visit(FuncNode node) {
        return node;
    }

    @Override
    public void Visit(ProgramNode node) {
        HashMap<String, Object> global = new HashMap<>();
        stack.push(global);

        for (Object stmt: node.getStmtList()) {
            if (stmt instanceof FuncNode) {
                for (String keyword : keywords) {
                    if (((FuncNode) stmt).getId().equals(keyword)) {
                        Error.FUNCTION_NAME_RESERVED((FuncNode) stmt);
                    }
                }
                for (String key: fmap.keySet()){
                    if(key.equals(((FuncNode) stmt).getId())) {
                        Error.FUNCTION_ALREADY_DECLARED(((FuncNode) stmt));
                    }
                }
                Object function = Visit((FuncNode) stmt);
                HashMap<String, Object> functionMap = new HashMap<>();

                for (DeclNode<?> param: ((FuncNode)function).getParam()){
                    IdentifierNode identifierNode = (IdentifierNode) param.getId();
                    String id = identifierNode.getValue();
                    functionMap.put(id, param.getValue());
                }
                functionMap.put("0", stmt);
                fmap.put(((FuncNode) function).getId(), functionMap);
            }
        }
    }
}
