import ASTNode.*;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Interpreter extends ASTVisitor{
    List<String> keywords;
    public Interpreter(NybCStack nybCStack, List<String> keywords) {
        super(nybCStack);
        this.keywords = keywords;
    }

    @Override
    public void Visit(ProgramNode node) {
        Object CtrlFlow;
        for (Object stmt: node.getStmtList()) {
            if (!(stmt instanceof FuncNode)){
                CtrlFlow = Visit((StmtNode) stmt);
                if (CtrlFlow != null) {
                    if (((CtrlFlowNode) CtrlFlow).getType().equals("continue") || ((CtrlFlowNode) CtrlFlow).getType().equals("break")){
                        Error.CONTINUE_BREAK_NOT_ALLOWED_IN_GLOBAL(((CtrlFlowNode) CtrlFlow).getType());
                    } else if (((CtrlFlowNode) CtrlFlow).getType().equals("return")) {
                        break;
                    }
                }
            }
        }
    }

    @Override
    public Object Visit(FuncNode node) {
        Object CtrlFlow;
        for (StmtNode stmt: node.getStmsList()) {
            CtrlFlow = Visit(stmt);
            if (CtrlFlow != null) {
                if (((CtrlFlowNode) CtrlFlow).getType().equals("continue") || ((CtrlFlowNode) CtrlFlow).getType().equals("break")){
                    Error.CONTINUE_BREAK_NOT_ALLOWED_IN_FUNCTION(((CtrlFlowNode) CtrlFlow).getType());
                } else if (((CtrlFlowNode) CtrlFlow).getType().equals("return")) {
                    nybCStack.getStack().pop();
                    return CtrlFlow;
                }
            }
        }
        nybCStack.getStack().pop();
        return null;
    }

    @Override
    public Object Visit(LoopNode node) {
        HashMap<String, Object> map = new HashMap<>();
        nybCStack.getStack().push(map);

        if (node.getDeclaration() != null) {
            Visit(node.getDeclaration());
        }
        if (!(Visit(node.getCondition()) instanceof Boolean)) {
            throw new RuntimeException("Condition for loops needs to be a boolean value");
        }
        Object CtrlFlow;
        Boolean bool = (Boolean) Visit(node.getCondition());
        switch (node.getType()) {
            case "while" -> {
                while (bool) {
                    HashMap<String, Object> InnerMap = new HashMap<>();
                    nybCStack.getStack().push(InnerMap);
                    bool = (Boolean) Visit(node.getCondition());
                    label:
                    for (StmtNode stmt : node.getStmtList()) {
                        CtrlFlow = Visit(stmt);
                        if (CtrlFlow != null) {
                            switch (((CtrlFlowNode) CtrlFlow).getType()) {
                                case "return":
                                    nybCStack.getStack().pop();
                                    nybCStack.getStack().pop();
                                    return CtrlFlow;
                                case "break":
                                    bool = false;
                                    break label;
                                case "continue":
                                    break label;
                            }
                        }
                    }
                    nybCStack.getStack().pop();
                }
                nybCStack.getStack().pop();
            }
            case "for" -> {
                while (bool) {
                    HashMap<String, Object> InnerMap = new HashMap<>();
                    nybCStack.getStack().push(InnerMap);
                    bool = (Boolean) Visit(node.getCondition());
                    label1:
                    for (StmtNode stmt : node.getStmtList()) {
                        CtrlFlow = Visit(stmt);
                        if (CtrlFlow != null) {
                            switch (((CtrlFlowNode) CtrlFlow).getType()) {
                                case "return":
                                    nybCStack.getStack().pop();
                                    nybCStack.getStack().pop();
                                    return CtrlFlow;
                                case "break":
                                    bool = false;
                                    break label1;
                                case "continue":
                                    break label1;
                            }
                        }

                    }
                    nybCStack.getStack().pop();
                    Visit(node.getAssignment());
                }
                nybCStack.getStack().pop();
            }
            case "do-while" -> {
                do {
                    HashMap<String, Object> InnerMap = new HashMap<>();
                    nybCStack.getStack().push(InnerMap);
                    bool = (Boolean) Visit(node.getCondition());
                    label2:
                    for (StmtNode stmt : node.getStmtList()) {
                        CtrlFlow = Visit(stmt);
                        if (CtrlFlow != null) {
                            switch (((CtrlFlowNode) CtrlFlow).getType()) {
                                case "return":
                                    nybCStack.getStack().pop();
                                    nybCStack.getStack().pop();
                                    return CtrlFlow;
                                case "break":
                                    bool = false;
                                    break label2;
                                case "continue":
                                    break label2;
                            }
                        }
                    }
                    nybCStack.getStack().pop();
                } while (bool);
                nybCStack.getStack().pop();
            }
        }
        return null;
    }

    @Override
    public Object Visit(SwitchNode node) {
        HashMap<String, Object> map = new HashMap<>();
        nybCStack.getStack().push(map);
        Object CtrlFlow;

        if (Visit(node.getSwitchCond()) instanceof String) {
            for (CaseNode cases: node.getCases()) {
                if (Visit(node.getSwitchCond()).equals(Visit(cases.getCaseExp())) || cases.getCaseExp() == null) {
                    CtrlFlow = Visit(cases);
                    if (CtrlFlow != null) {
                        if (((CtrlFlowNode) CtrlFlow).getType().equals("break")) {
                            nybCStack.getStack().pop();
                            return null;
                        } else if (((CtrlFlowNode) CtrlFlow).getType().equals("return")) {
                            nybCStack.getStack().pop();
                            return CtrlFlow;
                        }
                    }
                }
            }
        } else {
            for (CaseNode cases: node.getCases()) {
                if (Visit(node.getSwitchCond()) == Visit(cases.getCaseExp()) || cases.getCaseExp() == null) {
                    CtrlFlow = Visit(cases);
                    if (CtrlFlow != null) {
                        if (((CtrlFlowNode) CtrlFlow).getType().equals("break")) {
                            nybCStack.getStack().pop();
                            return null;
                        } else if (((CtrlFlowNode) CtrlFlow).getType().equals("return")) {
                            nybCStack.getStack().pop();
                            return CtrlFlow;
                        }
                    }
                }
            }
        }
        nybCStack.getStack().pop();
        return null;
    }

    @Override
    public Object Visit(CaseNode node) {
        Object CtrlFlow;
        for (StmtNode stmt: node.getStmtList()) {
            CtrlFlow = Visit(stmt);
            if (CtrlFlow != null && (((CtrlFlowNode) CtrlFlow).getType().equals("return") || ((CtrlFlowNode) CtrlFlow).getType().equals("break") || ((CtrlFlowNode) CtrlFlow).getType().equals("continue"))){
                return CtrlFlow;
            }
        }
        return null;
    }

    @Override
    public Object Visit(ArrayAccessNode<?> node) {

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
    public Object Visit(AssignNode<?,?> node) {
        var left = node.getLeft();
        var right = node.getRight();
        if (left instanceof ArrayAccessNode){
            var arrayName = ((ArrayAccessNode<?>) left).getId();
            var arrayIndex = ((ArrayAccessNode<?>) left).getIndex();
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

            for (int i = nybCStack.getStack().size() - 1; i >= 0; i--) {
                if (nybCStack.getStack().get(i).containsKey(left)) {
                    if (right instanceof ArrayNode) {
                        nybCStack.getStack().get(i).replace((String) left, Visit((ArrayNode) node.getRight()));
                    } else if (right instanceof ExpNode) {
                        nybCStack.getStack().get(i).replace((String) left, Visit((ExpNode) node.getRight()));
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
    public Object Visit(DeclNode<?> node) {

        for (int i = 0; i < keywords.size(); i++) {
            if (node.getId().equals(keywords.get(i))){
                throw new RuntimeException("Variable name '" + node.getId() + "' is reserved");
            }
        }
        for (int i = nybCStack.getStack().size() - 1; i >= 0; i--) {
            if (nybCStack.getStack().get(i).containsKey(node.getId())) {
                throw new RuntimeException("Variable " + node.getId() + " already declared");
            }
        }
        if (node.getValue() instanceof ArrayNode) {
            nybCStack.getStack().peek().put(node.getId(), Visit((ArrayNode) node.getValue()));
        } else if (node.getValue() instanceof ExpNode) {
            nybCStack.getStack().peek().put(node.getId(), Visit((ExpNode) node.getValue()));
        } else {
            nybCStack.getStack().peek().put(node.getId(), null);
        }
        return null;
    }

    @Override
    public Object Visit(IfNode node) {
        if (!(Visit(node.getCondition()) instanceof Boolean) && node.getCondition() != null){
            throw new RuntimeException("Condition for if statements needs to be a boolean value");
        }
        HashMap<String, Object> map = new HashMap<>();
        nybCStack.getStack().push(map);
        Object CtrlFlow;
        if (node.getCondition() == null || (Boolean) Visit(node.getCondition())){
            for (StmtNode stmt: node.getStmts()){
                CtrlFlow = Visit(stmt);
                if (CtrlFlow != null && (((CtrlFlowNode) CtrlFlow).getType().equals("return") || ((CtrlFlowNode) CtrlFlow).getType().equals("break") || ((CtrlFlowNode) CtrlFlow).getType().equals("continue"))){
                    nybCStack.getStack().pop();
                    return CtrlFlow;
                }
            }
        } else {
            CtrlFlow = Visit(node.getElseIfNode());
            if (CtrlFlow != null && (((CtrlFlowNode) CtrlFlow).getType().equals("return") || ((CtrlFlowNode) CtrlFlow).getType().equals("break") || ((CtrlFlowNode) CtrlFlow).getType().equals("continue"))){
                nybCStack.getStack().pop();
                return CtrlFlow;
            }
        }
        nybCStack.getStack().pop();
        return null;
    }

    @Override
    public Object Visit(CallFuncNode node) {
        if (node.getId().equals("out")) {
            if (node.getArgs().size() == 1) {
                System.out.println(Visit(node.getArgs().get(0)));
            } else {
                throw new RuntimeException("'out' can only take one argument");
            }
        } else if (node.getId().equals("in")) {
            Scanner scan = new Scanner(System.in);
            return scan.nextLine();
        } else {
            HashMap<String, Object> map = lookupFunc(node.getId());
            nybCStack.getStack().push(map);
            FuncNode funcNode = (FuncNode) map.get("0");
            if (node.getArgs().size() != funcNode.getParam().size()){
                throw new RuntimeException("Function call must have the same amount of parameters as function");
            }
            int i = 0;
            for (DeclNode<?> param: funcNode.getParam()) {
                map.replace(param.getId(), Visit(node.getArgs().get(i)));
                i++;
            }
            Object CtrlFlow = Visit(funcNode);
            if (CtrlFlow != null && ((CtrlFlowNode) CtrlFlow).getReturnExp() != null) {
                return map.get("1");
            }
        }
        return null;
    }
}
