import ASTNode.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Condition;

public class Interpreter extends ASTVisitor implements VisitorInterface{

    @Override
    public void Visit(ProgramNode node) {
        for (Object stmt: node.getStmtList()) {
            if (!(stmt instanceof FuncNode) && !(stmt instanceof DeclNode)){
                Visit((StmtNode) stmt);
            }
        }
    }

    @Override
    public Object Visit(FuncNode node) {

        for (StmtNode stmt: node.getStmsList()) {
            Visit(stmt);
        }
        stack.pop();
        return null;
    }

    @Override
    public Object Visit(LoopNode node) {

        if (!(Visit(node.getCondition()) instanceof Boolean)) {
            throw new RuntimeException("Condition for loops needs to be a boolean value");
        }
        switch (node.getType()){
            case "while":
                HashMap<String, Object> map = new HashMap<>();
                stack.push(map);
                while ((Boolean) Visit(node.getCondition())){
                    for (StmtNode stmt: node.getStmtList()) {
                        Visit(stmt);
                    }
                }
                stack.pop();
                break;
            case "for":
                HashMap<String, Object> map1 = new HashMap<>();
                stack.push(map1);
                Visit(node.getDeclaration());
                while ((Boolean) Visit(node.getCondition())) {
                    for (StmtNode stmt: node.getStmtList()) {
                        Visit(stmt);
                    }
                    Visit(node.getAssignment());
                }
                stack.pop();
                break;
            case "do-while":
                HashMap<String, Object> map2 = new HashMap<>();
                stack.push(map2);
                do {
                    for (StmtNode stmt: node.getStmtList()) {
                        Visit(stmt);
                    }
                } while ((Boolean) Visit(node.getCondition()));
                stack.pop();
                break;
        }
        return null;
    }

    @Override
    public Object Visit(SwitchNode node) {
        HashMap<String, Object> map = new HashMap<>();
        stack.push(map);
        for (CaseNode cases: node.getCases()) {
            if (Visit(node.getSwitchCond()) == cases.getCaseExp() || cases.getCaseExp() == null) {
                Visit(cases);
            }
        }
        stack.pop();
        return null;
    }

    @Override
    public Object Visit(CaseNode node) {
        for (StmtNode stmt: node.getStmtList()) {
            Visit(stmt);
        }
        return null;
    }

    @Override
    public Object Visit(ArrayAccessNode node) {

        List<Object> array = lookupArray(node.getId());

        if (node.getIndex() instanceof Integer) {
            return array.get((Integer) node.getIndex());
        } else if (node.getIndex() instanceof String) {
            var index = lookup((String) node.getIndex());
            if (index instanceof Integer){
                return array.get((int) index);
            } else {
                throw new RuntimeException("Variable is not a whole number");
            }
        } else {
            throw new RuntimeException("Array index must be a whole number or a variable");
        }
    }

    @Override
    public Object Visit(AssignNode node) {
        var left = node.getLeft();
        var right = node.getRight();
        if (left instanceof ArrayAccessNode){
            var arrayName = ((ArrayAccessNode) left).getId();
            var arrayIndex = ((ArrayAccessNode) left).getIndex();
            List<Object> array = lookupArray(arrayName);
            if (arrayIndex instanceof Integer) {
                array.set((int) arrayIndex, Visit((ExpNode) right));
            } else if (arrayIndex instanceof String) {
                var index = lookup((String) arrayIndex);
                if (index instanceof Integer){
                    array.set((int) index, Visit((ExpNode) right));
                } else {
                    throw new RuntimeException("Variable is not a whole number");
                }
            } else {
                throw new RuntimeException("Array index must be a whole number or a variable");
            }
        } else if (left instanceof String) {
            lookup((String) left);

            for (int i = stack.size() - 1; i >= 0; i--) {
                if (stack.get(i).containsKey(left)) {
                    if (right instanceof ArrayNode) {
                        stack.get(i).replace((String) left, Visit((ArrayNode) node.getRight()));
                    } else if (right instanceof ExpNode) {
                        stack.get(i).replace((String) left, Visit((ExpNode) node.getRight()));
                    } else {
                        throw new RuntimeException("The assigned value is not accepted");
                    }
                    break;
                }
            }
        } else {
            throw new RuntimeException("You can not assign values to " + left);
        }
        return null;
    }

    @Override
    public Object Visit(CtrlFlowNode node) {
        return null;
    }

    @Override
    public Object Visit(DeclNode node) {
        return null;
    }

    @Override
    public Object Visit(IfNode<?> node) {
        if (!(Visit(node.getCondition()) instanceof Boolean)){
            throw new RuntimeException("Condition for if statements needs to be a boolean value");
        }
        HashMap<String, Object> map = new HashMap<>();
        stack.push(map);
        if ((Boolean) Visit(node.getCondition())){
            for (StmtNode stmt: node.getStmts()){
                Visit(stmt);
            }
        } else {
            if (node.getElseIfNode() instanceof ElseIfNode) {
                Visit((ElseIfNode<?>) node.getElseIfNode());
            } else if (node.getElseIfNode() instanceof ElseNode) {
                Visit((ElseNode) node.getElseIfNode());
            }
        }
        stack.pop();
        return null;
    }

    @Override
    public Object Visit(ElseIfNode<?> node) {
        if (!(Visit(node.getCondition()) instanceof Boolean)){
            throw new RuntimeException("Condition for if statements needs to be a boolean value");
        }
        HashMap<String, Object> map = new HashMap<>();
        stack.push(map);
        if ((Boolean) Visit(node.getCondition())){
            for (StmtNode stmt: node.getStmts()){
                Visit(stmt);
            }
        } else {
            if (node.getElseIfNode() instanceof ElseIfNode) {
                Visit((ElseIfNode<?>) node.getElseIfNode());
            } else if (node.getElseIfNode() instanceof ElseNode) {
                Visit((ElseNode) node.getElseIfNode());
            }
        }
        stack.pop();
        return null;
    }

    @Override
    public Object Visit(ElseNode node) {
        HashMap<String, Object> map = new HashMap<>();
        stack.push(map);
        for (StmtNode stmt: node.getStmts()){
            Visit(stmt);
        }
        stack.pop();
        return null;
    }

    @Override
    public Object Visit(CallFuncNode node) {
        HashMap<String, Object> map = lookupFunc(node.getId());
        stack.push(map);
        FuncNode funcNode = (FuncNode) map.get("0");
        Visit(funcNode);
        return null;
    }

}
