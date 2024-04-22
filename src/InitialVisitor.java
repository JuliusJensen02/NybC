
import ASTNode.*;
import org.antlr.v4.codegen.model.decl.Decl;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

public class InitialVisitor extends ASTVisitor implements VisitorInterface{

    @Override
    public Object Visit(DeclNode<?> node) {

        if (node.getValue() instanceof ArrayNode) {
            return (List<Object>) Visit((ArrayNode) node.getValue());
        } else if (node.getValue() instanceof ExpNode){
            return Visit((ExpNode) node.getValue());
        } else  {
            return null;
        }
    }

    @Override
    public Object Visit(FuncNode node) {
        return node;
    }

    @Override
    public void Visit(ProgramNode node) {
        HashMap<String, Object> global = new HashMap<>();
        stack.push(global);

        for (Object stmt: node.getStmtList()) {
            if (stmt instanceof DeclNode) {
                if (global.containsKey(((DeclNode<?>) stmt).getId())){
                    throw new RuntimeException("Variable " + ((DeclNode<?>) stmt).getId() + " has already been declared");
                }
                global.put(((DeclNode<?>) stmt).getId(),Visit(((DeclNode<?>) stmt)));
            } else if (stmt instanceof FuncNode) {
                Object function = Visit((FuncNode) stmt);
                HashMap<String, Object> functionMap = new HashMap<>();

                for (DeclNode<?> param: ((FuncNode)function).getParam()){
                    functionMap.put(param.getId(), param.getValue());
                }
                functionMap.put("0", stmt);
                fmap.put(((FuncNode) function).getId(), functionMap);
            }
        }
    }
}
