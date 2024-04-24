import ASTNode.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ASTVisitor{
    protected NybCStack nybCStack;

    public ASTVisitor(NybCStack nybCStack) {
        this.nybCStack = nybCStack;
    }

    public Object Visit(IdentifierNode node) {
        return lookup(node.getValue());
    }
    public Boolean Visit(BoolNode node){
        return node.isValue();
    }
    public Float Visit(FloatNode node){
        return node.getValue();
    }
    public Integer Visit(IntNode node){
        return node.getValue();
    }
    public String Visit(StringNode node){
        return node.getValue();
    }

    public List<Object> Visit(ArrayNode node) {
        List<Object> list = new ArrayList<>();
        for (ExpNode exp: node.getValues()) {
            list.add(Visit(exp));
        }
        return list;
    }

    public CtrlFlowNode Visit(CtrlFlowNode node) {
        if (node.getType().equals("return") && node.getReturnExp() != null){
            var value = Visit(node.getReturnExp());
            for (int i = nybCStack.getStack().size() - 1; i >= 0; i--) {
                if (nybCStack.getStack().get(i).containsKey("0")) {
                    nybCStack.getStack().get(i).put("1", value);
                }
            }
        }
        return node;
    }
    public Object Visit(BinaryOpNode node){
        var left = Visit(node.getLeft());
        var right = Visit(node.getRight());
        switch (node.getOp()) {
            case "+" -> {
                if (left instanceof String) {
                    return (String) left + right;
                } else if (right instanceof String) {
                    return left + (String) right;
                } else if (left instanceof Integer && right instanceof Integer) {
                    return (int) left + (int) right;
                } else if ((left instanceof Float || left instanceof Integer) && (right instanceof Float || right instanceof Integer)) {
                    return ((Number) left).floatValue() + ((Number) right).floatValue();
                }
                Error.TYPE_NOT_VALID_FOR_BINARY_PLUS(node.getLeft() + " " + node.getOp() + " " + node.getRight());
            }
            case "-" -> {
                if (left instanceof Integer && right instanceof Integer) {
                    return (int) left - (int) right;
                } else if ((left instanceof Float || left instanceof Integer) && (right instanceof Float || right instanceof Integer)) {
                    return ((Number) left).floatValue() - ((Number) right).floatValue();
                }
                Error.TYPE_NOT_VALID_FOR_BINARY_MINUS(node.getLeft() + " " + node.getOp() + " " + node.getRight());
            }
            case "*" -> {
                if (left instanceof Integer && right instanceof Integer) {
                    return (int) left * (int) right;
                } else if ((left instanceof Float || left instanceof Integer) && (right instanceof Float || right instanceof Integer)) {
                    return ((Number) left).floatValue() * ((Number) right).floatValue();
                }
                Error.TYPE_NOT_VALID_FOR_BINARY_MULT(node.getLeft() + " " + node.getOp() + " " + node.getRight());
            }
            case "/" -> {
                if ((left instanceof Float || left instanceof Integer) && (right instanceof Float || right instanceof Integer) && ((Number) right).floatValue() != 0.0) {
                    return ((Number) left).floatValue() / ((Number) right).floatValue();
                }
                Error.TYPE_NOT_VALID_FOR_BINARY_DIV(node.getLeft() + " " + node.getOp() + " " + node.getRight());
            }
            case "<" -> {
                if ((left instanceof Float || left instanceof Integer) && (right instanceof Float || right instanceof Integer)) {
                    return ((Number) left).floatValue() < ((Number) right).floatValue();
                }
                Error.TYPE_NOT_VALID_FOR_BINARY_LT(node.getLeft() + " " + node.getOp() + " " + node.getRight());
            }
            case ">" -> {
                if ((left instanceof Float || left instanceof Integer) && (right instanceof Float || right instanceof Integer)) {
                    return ((Number) left).floatValue() > ((Number) right).floatValue();
                }
                Error.TYPE_NOT_VALID_FOR_BINARY_GT(node.getLeft() + " " + node.getOp() + " " + node.getRight());
            }
            case "<=" -> {
                if ((left instanceof Float || left instanceof Integer) && (right instanceof Float || right instanceof Integer)) {
                    return ((Number) left).floatValue() <= ((Number) right).floatValue();
                }
                Error.TYPE_NOT_VALID_FOR_BINARY_LTE(node.getLeft() + " " + node.getOp() + " " + node.getRight());
            }
            case ">=" -> {
                if ((left instanceof Float || left instanceof Integer) && (right instanceof Float || right instanceof Integer)) {
                    return ((Number) left).floatValue() >= ((Number) right).floatValue();
                }
                Error.TYPE_NOT_VALID_FOR_BINARY_GTE(node.getLeft() + " " + node.getOp() + " " + node.getRight());
            }
            case "!=" -> {
                if (left instanceof String && right instanceof String) {
                    return !left.equals(right);
                } else if (left instanceof Float && right instanceof Float) {
                    return (float) left != (float) right;
                } else if (left instanceof Boolean && right instanceof Boolean) {
                    return left != right;
                } else if (left instanceof Integer && right instanceof Integer) {
                    return (int) left != (int) right;
                }
                Error.TYPE_NOT_VALID_FOR_BINARY_NEQ(node.getLeft() + " " + node.getOp() + " " + node.getRight());
            }
            case "==" -> {
                if (left instanceof String && right instanceof String) {
                    return left.equals(right);
                } else if (left instanceof Float && right instanceof Float) {
                    return (float) left == (float) right;
                } else if (left instanceof Boolean && right instanceof Boolean) {
                    return left == right;
                } else if (left instanceof Integer && right instanceof Integer) {
                    return (int) left == (int) right;
                }
                Error.TYPE_NOT_VALID_FOR_BINARY_EQ(node.getLeft() + " " + node.getOp() + " " + node.getRight());
            }
            case "||" -> {
                if (left instanceof Boolean && right instanceof Boolean) {
                    return (Boolean) left || (Boolean) right;
                }
                Error.TYPE_NOT_VALID_FOR_BINARY_OR(node.getLeft() + " " + node.getOp() + " " + node.getRight());
            }
            case "&&" -> {
                if (left instanceof Boolean && right instanceof Boolean) {
                    return (Boolean) left && (Boolean) right;
                }
                Error.TYPE_NOT_VALID_FOR_BINARY_AND(node.getLeft() + " " + node.getOp() + " " + node.getRight());
            }
        }
        return null;
    }
    public Object Visit(UnaryOpNode node) {
        var right = Visit(node.getRight());
        switch (node.getOp()) {
            case "+" -> {
                if (right instanceof Integer || right instanceof Float) {
                    return ((Number) right).floatValue();
                }
                Error.TYPE_NOT_VALID_FOR_UNARY_PLUS(right.toString());
            }
            case "-" -> {
                if (right instanceof Integer || right instanceof Float) {
                    return -1 * ((Number) right).floatValue();
                }
                Error.TYPE_NOT_VALID_FOR_UNARY_MINUS(right.toString());
            }
            case "!" -> {
                if (right instanceof Boolean) {
                    return !(Boolean) right;
                }
                Error.TYPE_NOT_VALID_FOR_UNARY_NOT(right.toString());
            }
        }
        return null;
    }


    public Object Visit(ParenthNode node) {
        return Visit(node.getInner());
    }
    public  Object Visit(ArrayAccessNode<?> node){return null;}
    public  Object Visit(CallFuncNode node){return null;}
    public  Object Visit(IfNode node){return null;}
    public  Object Visit(DeclNode<?> node){return null;}
    public  Object Visit(AssignNode<?,?> node){return null;}
    public  Object Visit(CaseNode node){return null;}
    public  Object Visit(SwitchNode node){return null;}
    public  Object Visit(LoopNode node){return null;}
    public  Object Visit(FuncNode node){return null;}
    public  void Visit(ProgramNode node){}

    public Object Visit(ExpNode node)
    {
        if (node instanceof BoolNode) {
            return Visit((BoolNode) node);
        } else if (node instanceof IdentifierNode) {
            return Visit((IdentifierNode) node);
        }else if (node instanceof IntNode) {
            return Visit((IntNode) node);
        }else if (node instanceof FloatNode) {
            return Visit((FloatNode) node);
        }else if (node instanceof StringNode) {
            return Visit((StringNode) node);
        }else if (node instanceof ParenthNode) {
            return Visit((ParenthNode) node);
        }else if (node instanceof UnaryOpNode) {
            return Visit((UnaryOpNode) node);
        }else if (node instanceof BinaryOpNode) {
            return Visit((BinaryOpNode) node);
        }else if (node instanceof ArrayAccessNode) {
            return Visit((ArrayAccessNode<?>) node);
        }else if (node instanceof CallFuncNode) {
            return Visit((CallFuncNode) node);
        }
        return null;
    }

    public Object Visit (StmtNode node)
    {
        if (node instanceof IfNode) {
            return Visit((IfNode) node);
        } else if (node instanceof LoopNode) {
            return Visit((LoopNode) node);
        }else if (node instanceof SwitchNode) {
            return Visit((SwitchNode) node);
        }else if (node instanceof DeclNode) {
            return Visit((DeclNode<?>) node);
        }else if (node instanceof AssignNode) {
            return Visit((AssignNode<?,?>) node);
        }else if (node instanceof CallFuncNode) {
            return Visit((CallFuncNode) node);
        }else if (node instanceof CtrlFlowNode) {
            return Visit((CtrlFlowNode) node);
        }
        return null;
    }

    public Object lookup (String node) {
        for (int i = nybCStack.getStack().size() - 1; i >= 0; i--) {
            if (nybCStack.getStack().get(i).containsKey(node)) {
                return nybCStack.getStack().get(i).get(node);
            }
        }
        Error.VARIABLE_NOT_DECLARED(node);
        return null;
    }

    public List<Object> lookupArray (String node) {
        for (int i = nybCStack.getStack().size() - 1; i >= 0; i--) {
            if (nybCStack.getStack().get(i).containsKey(node)) {
                return (List<Object>) nybCStack.getStack().get(i).get(node);
            }
        }
        Error.VARIABLE_NOT_DECLARED(node);
        return null;
    }

    public HashMap<String, Object> lookupFunc (String node) {
        if (nybCStack.getFmap().containsKey(node)){
            return (HashMap<String, Object>) nybCStack.getFmap().get(node);
        }
        Error.FUNCTION_NOT_DECLARED(node);
        return null;
    }
}
