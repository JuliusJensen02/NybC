
import ASTNode.*;

import java.util.HashMap;
import java.util.List;

public class InitialVisitor extends ASTVisitor {
    List<String> keywords;
    public InitialVisitor(NybCStack nybCStack, List<String> keywords) {
        super(nybCStack);
        this.keywords = keywords;
    }

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
        nybCStack.PushStack();

        for (Object stmt: node.getStmtList()) {
            /*if (stmt instanceof DeclNode) {
                if (global.containsKey(((DeclNode<?>) stmt).getId())){
                    throw new RuntimeException("Variable " + ((DeclNode<?>) stmt).getId() + " has already been declared");
                }
                global.put(((DeclNode<?>) stmt).getId(),Visit(((DeclNode<?>) stmt)));
            } else*/
            if (stmt instanceof FuncNode) {
                for (String keyword : keywords) {
                    if (((FuncNode) stmt).getId().equals(keyword)) {
                        Error.FUNCTION_NAME_RESERVED(((FuncNode) stmt).getId());
                    }
                }

                if(nybCStack.IsFunctionDeclared(((FuncNode) stmt).getId())) {
                    Error.FUNCTION_ALREADY_DECLARED(((FuncNode) stmt).getId());
                }

                FuncNode function = (FuncNode)Visit((FuncNode) stmt);
                HashMap<String, Object> functionMap = new HashMap<>();

                for (DeclNode<?> param: (function.getParam())){
                    functionMap.put(param.getId(), param.getValue());
                }
                functionMap.put("0", stmt);
                functionMap.put("1", null);

                @SuppressWarnings("unchecked")
                HashMap<String, Object> functionMapHashTable = (HashMap<String, Object>) functionMap.clone();

                nybCStack.PutFunction(function.getId(), functionMapHashTable);
            }
        }
    }
}
