
import ASTNode.*;
import org.antlr.v4.codegen.model.decl.Decl;

import java.lang.reflect.Type;
import java.util.HashMap;

public class InitialVisitor <T> extends ASTVisitor implements VisitorInterface{
    @Override
    public Boolean Visit(BoolNode node) {
        return node.isValue();
    }
    @Override
    public Float Visit(FloatNode node) {
        return node.getValue();
    }

    @Override
    public Integer Visit(IntNode node) {
        return node.getValue();
    }

    @Override
    public String Visit(StringNode node) {
        return node.getValue();
    }

    @Override
    public T Visit(IdentifierNode node) {
        return null;/*lookUp(node.getValue());*/
    }

    @Override
    public Object Visit(BinaryOpNode node) {
        var left = Visit(node.getLeft());
        var right = Visit(node.getRight());
        switch (node.getOp()){
            case "+":
                if (left instanceof String || right instanceof String){
                    return left + (String) right;
                } else if (left instanceof Integer && right instanceof Integer) {
                    return (int) left + (int) right;
                } else if ((left instanceof Float || left instanceof Integer) && (right instanceof Float || right instanceof Integer)) {
                    return (float) left + (float) right;
                } else {
                    throw new RuntimeException();
                }
            case "-":
                if (left instanceof Integer && right instanceof Integer) {
                    return (int) left - (int) right;
                } else if ((left instanceof Float || left instanceof Integer) && (right instanceof Float || right instanceof Integer)) {
                    return (float) left - (float) right;
                } else {
                    throw new RuntimeException();
                }
            case "*":
                if (left instanceof Integer && right instanceof Integer) {
                    return (int) left * (int) right;
                } else if ((left instanceof Float || left instanceof Integer) && (right instanceof Float || right instanceof Integer)) {
                    return (float) left * (float) right;
                } else {
                    throw new RuntimeException();
                }
            case "/":
                if ((left instanceof Float || left instanceof Integer) && (right instanceof Float || right instanceof Integer) && ((Number) right).floatValue() != 0.0) {
                    return (float) left / (float) right;
                } else {
                    throw new RuntimeException();
                }
            case "<":
                if ((left instanceof Float || left instanceof Integer) && (right instanceof Float || right instanceof Integer)) {
                    return (float) left < (float) right;
                } else {
                    throw new RuntimeException();
                }
            case ">":
                if ((left instanceof Float || left instanceof Integer) && (right instanceof Float || right instanceof Integer)) {
                    return (float) left > (float) right;
                } else {
                    throw new RuntimeException();
                }
            case "<=":
                if ((left instanceof Float || left instanceof Integer) && (right instanceof Float || right instanceof Integer)) {
                    return (float) left <= (float) right;
                } else {
                    throw new RuntimeException();
                }
            case ">=":
                if ((left instanceof Float || left instanceof Integer) && (right instanceof Float || right instanceof Integer)) {
                    return (float) left >= (float) right;
                } else {
                    throw new RuntimeException();
                }
            case "!=":
                if (left instanceof String && right instanceof String){
                    return !left.equals(right);
                } else if (left instanceof Float && right instanceof Float){
                    return (float) left != (float) right;
                } else if (left instanceof Boolean && right instanceof Boolean) {
                    return (Boolean) left != (Boolean) right;
                } else if (left instanceof Integer && right instanceof Integer) {
                    return (int) left != (int) right;
                } else {
                    throw new RuntimeException();
                }
            case "==":
                if (left instanceof String && right instanceof String){
                    return left.equals(right);
                } else if (left instanceof Float && right instanceof Float){
                    return (float) left == (float) right;
                } else if (left instanceof Boolean && right instanceof Boolean) {
                    return (Boolean) left == (Boolean) right;
                } else if (left instanceof Integer && right instanceof Integer) {
                    return (int) left == (int) right;
                } else {
                    throw new RuntimeException();
                }
            case "||":
                if (left instanceof Boolean && right instanceof Boolean) {
                    return (Boolean) left || (Boolean) right;
                } else {
                    throw new RuntimeException();
                }
            case "&&":
                if (left instanceof Boolean && right instanceof Boolean) {
                    return (Boolean) left && (Boolean) right;
                } else {
                    throw new RuntimeException();
                }
        }
        return null;
    }

    @Override
    public Object Visit(UnaryOpNode node) {
        return null;
    }

    @Override
    public Object Visit(ParenthNode node) {
        return null;
    }

    @Override
    public Object Visit(ArrayAccessNode node) {
        return null;
    }

    @Override
    public Object Visit(CallFuncNode node) {
        return null;
    }

    @Override
    public Object Visit(IfNode node) {
        return null;
    }

    @Override
    public Object Visit(ElseIfNode node) {
        return null;
    }

    @Override
    public Object Visit(ElseNode node) {
        return null;
    }


    @Override
    public Object Visit(DeclNode node) {
        if (node.getValue() instanceof ExpNode){
            return Visit((ExpNode) node.getValue());
        } else if (node.getValue() instanceof ArrayNode) {
            return Visit((ArrayNode) node.getValue());
        } else {
            return null;
        }
    }

    @Override
    public Object Visit(LoopNode node) {
        return null;
    }

    @Override
    public Object Visit(SwitchNode node) {
        return null;
    }

    @Override
    public Object Visit(CaseNode node) {
        return null;
    }

    @Override
    public Object Visit(ArrayNode node) {
        return null;
    }

    @Override
    public Object Visit(AssignNode node) {
        return null;
    }

    @Override
    public Object Visit(CtrlFlowNode node) {
        return null;
    }

    @Override
    public Object Visit(FuncNode node) {

        return null;
    }

    @Override
    public void Visit(ProgramNode node) {
        HashMap<String, Object> global = new HashMap<>();


        for (Object stmt: node.getStmtList()) {
            if (stmt instanceof DeclNode) {
                global.put(((DeclNode) stmt).getId(),Visit(((DeclNode) stmt)));
            } else if (stmt instanceof FuncNode) {
                Visit((FuncNode) stmt);
            }
        }
        vmap.put("global", global);
    }



    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! FUCK JAVA!!!!!!!!!!!!!!!!!!!!


}
