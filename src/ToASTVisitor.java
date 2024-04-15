import ASTNode.*;
import org.antlr.v4.codegen.model.decl.Decl;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ToASTVisitor extends NybCBaseVisitor<ASTNode>{

    @Override
    public ASTNode visitProgram(NybCParser.ProgramContext ctx) {
        ProgramNode node = new ProgramNode();
        for (ParseTree childNode: ctx.children) {
            if (childNode.getClass().getSimpleName().equals("StmtContext")) {
                node.addStmt((StmtNode) visit(childNode));
            } else if (childNode.getClass().getSimpleName().equals("FunctionStmtContext")) {
                node.addFunction((FuncNode) visit(childNode));
            } else {
                throw new RuntimeException();
            }
        }
        return node;
    }

    @Override
    public ASTNode visitStmt(NybCParser.StmtContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public ASTNode visitFunctionStmt(NybCParser.FunctionStmtContext ctx) {
        FuncNode node = new FuncNode();
        node.setId(ctx.getChild(2).getText());
        for (ParseTree childNode: ctx.declareStmt()) {
            node.addParam((DeclNode) visit(childNode));
        }
        for (ParseTree childNode: ctx.stmt()) {
            node.addStmt((StmtNode) visit(childNode));
        }
        return node;
    }

    @Override
    public ASTNode visitBeginStmt(NybCParser.BeginStmtContext ctx) {
        if(ctx.getChild(1).getText().equals("if")){
            IfNode node = new IfNode();
            node.setCondition((ExpNode) visit(ctx.getChild(3)));
            int i = 6;
            for (; i < ctx.children.size(); i++) {
                if (ctx.getChild(i).getClass().getSimpleName().equals("StmtContext")) {
                    node.addStmt((StmtNode) visit(ctx.getChild(i)));
                }
                else {
                    break;
                }
            }
            if(ctx.extendedIf() != null){
                node.setElseIfNode((ElseIfNode) visit(ctx.getChild(ctx.children.size() - 1)));
            }
            return node;
        } else if (ctx.getChild(1).getText().equals("loop")){
            LoopNode node = new LoopNode();
            switch (ctx.getChild(3).getClass().getSimpleName()){
                case "ExpressionContext":
                    node.setType("while");
                    node.setCondition((ExpNode) visit(ctx.getChild(3)));
                    break;
                case "StmtContext":
                    node.setType("do-while");
                    node.setCondition((ExpNode) visit(ctx.getChild(ctx.children.size() - 2)));
                    break;
                case "DeclareStmtContext":
                    node.setType("for");
                    node.setDeclaration((DeclNode) visit(ctx.getChild(3)));
                    node.setCondition((ExpNode) visit(ctx.getChild(5)));
                    node.setAssignment((AssignNode) visit(ctx.getChild(7)));
                    break;
                default:
                    throw new RuntimeException();
            }
            for (int i = 3; i < ctx.children.size(); i++) {
                if (ctx.getChild(i).getClass().getSimpleName().equals("StmtContext")){
                    node.addStmt((StmtNode) visit(ctx.getChild(i)));
                }
            }
            return node;
        } else if (ctx.getChild(1).getText().equals("switch")) {
            SwitchNode node = new SwitchNode();
            node.setSwitchCond((ExpNode) visit(ctx.getChild(3)));
            for (int i = 3; i < ctx.children.size(); i++) {
                if (ctx.getChild(i).getText().equals("case") || ctx.getChild(i).getText().equals("default")) {
                    CaseNode casen = new CaseNode();
                    if (!ctx.getChild(i).getText().equals("default")) {
                        casen.setCaseExp((ExpNode) visit(ctx.getChild(i + 1)));
                    }
                    int j = i + 3;
                    while (ctx.getChild(j).getClass().getSimpleName().equals("StmtContext")){
                        casen.addStmt((StmtNode) visit(ctx.getChild(j)));
                        j++;
                    }
                    node.addCases(casen);
                }
            }
           return node;
        }
        return null;
    }

    @Override
    public ASTNode visitExtendedIf(NybCParser.ExtendedIfContext ctx) {
        if (ctx.getChild(1).getText().equals("else-if")) {
            ElseIfNode node = new ElseIfNode();
            for (ParseTree childNode : ctx.children) {
                if (childNode.getClass().getSimpleName().equals("StmtContext")) {
                    node.addStmt((StmtNode) visit(childNode));
                } else if (childNode.getClass().getSimpleName().equals("ExpressionContext")) {
                    node.setCondition((ExpNode) visit(childNode));
                }
                if(ctx.extendedIf() != null && childNode.getClass().getSimpleName().equals("ExtendedIfContext")){
                    node.setElseIfNode(visit(childNode));
                }
            }

            return node;
        } else if (ctx.getChild(1).getText().equals("else")) {
            ElseNode node = new ElseNode();
            for (ParseTree childNode : ctx.children) {
                if (childNode.getClass().getSimpleName().equals("StmtContext")) {
                    node.addStmt((StmtNode) visit(childNode));
                }
            }
            return node;
        }
        return null;
    }

    @Override
    public ASTNode visitDeclareStmt(NybCParser.DeclareStmtContext ctx) {
        if (ctx.getChild(3) != null) {
            return switch (ctx.getChild(3).getClass().getSimpleName()) {
                case "ExpressionContext" -> new DeclNode<ExpNode>(ctx.IDENT().getText(), (ExpNode) visit(ctx.getChild(3)));
                case "ArrayContext" -> new DeclNode<ArrayNode>(ctx.IDENT().getText(), (ArrayNode) visit(ctx.getChild(3)));
                default ->
                        throw new IllegalStateException("Unexpected value: " + ctx.getChild(3).getClass().getSimpleName());
            };
        } else return new DeclNode<>(ctx.IDENT().getText());
    }

    @Override
    public ASTNode visitAssignStmt(NybCParser.AssignStmtContext ctx) {
        if(ctx.getChild(0).getClass().getSimpleName().equals("ArrayAccessContext")){
            return new AssignNode<ArrayAccessNode, ExpNode>(
                    ((ArrayAccessNode)visit(ctx.getChild(0))), ((ExpNode)visit(ctx.getChild(2)))
            );
        }
        else{
            if(ctx.getChild(2).getClass().getSimpleName().equals("ArrayContext")) {
                return new AssignNode<String, ArrayNode>(ctx.IDENT().getText(), (ArrayNode) visit(ctx.getChild(2)));
            }
            else{
                return new AssignNode<String, ExpNode>(ctx.IDENT().getText(), (ExpNode) visit(ctx.getChild(2)));
            }
        }
    }

    @Override
    public ASTNode visitArray(NybCParser.ArrayContext ctx) {
        ArrayNode arrayNode = new ArrayNode();
        for (ParseTree childNode: ctx.children) {
            if(childNode.getClass().getSimpleName().equals("ExpressionContext")){
                arrayNode.addValue(visit(childNode));
            }
        }
        return arrayNode;
    }

    @Override
    public ASTNode visitTerminal(TerminalNode node) {
        return super.visitTerminal(node);
    }

    @Override
    public ASTNode visitCtrlFlowStmt(NybCParser.CtrlFlowStmtContext ctx) {
        switch (ctx.getClass().getSimpleName()) {
            case "return" -> {
                if (ctx.getChild(1) != null) {
                    ReturnNode returnNode = new ReturnNode();
                    returnNode.setExp((ExpNode) visit(ctx.getChild(1)));
                    return returnNode;
                } else {
                    return new ReturnNode();
                }
            }
            case "continue" -> {
                return new ContinueNode();
            }
            case "break" -> {
                return new BreakNode();
            }
            default -> {
                return null;
            }
        }
    }

    @Override
    public ASTNode visitExpression(NybCParser.ExpressionContext ctx) {

        ASTNode node;

        if (ctx.valueExpression() != null) {
            return visit(ctx.valueExpression());
        } else if (ctx.arrayAccess() != null) {
            return visit(ctx.arrayAccess());
        } else if (ctx.callStmt() != null) {
            return visit(ctx.callStmt());
        } else if (ctx.children.size() == 2) {
            node = new UnaryOpNode();
            ((UnaryOpNode) node).setRight(visit(ctx.getChild(1)));
            ((UnaryOpNode) node).setOp(ctx.UOPS().getText());
        } else if (ctx.children.size() == 3 && ctx.getChild(1).getClass().getSimpleName().equals("ExpressionContext")) {
            node = new ParenthNode();
            ((ParenthNode) node).setInner(visit(ctx.getChild(1)));
        } else {
            node = new BinaryOpNode();
            ((BinaryOpNode) node).setLeft(visit(ctx.getChild(0)));
            ((BinaryOpNode) node).setRight(visit(ctx.getChild(2)));
            ((BinaryOpNode) node).setOp(ctx.BOPS().getText());
        }
        return node;
    }

    @Override
    public ASTNode visitArrayAccess(NybCParser.ArrayAccessContext ctx) {
        String id = ctx.getChild(0).getText();
        if(ctx.INT() != null){
            return new ArrayAccessNode<Integer>(id, Integer.parseInt(ctx.INT().getText()));
        } else {
            return new ArrayAccessNode<String>(id, ctx.getChild(2).getText());
        }
    }

    @Override
    public ASTNode visitCallStmt(NybCParser.CallStmtContext ctx) {
        CallFuncNode node = new CallFuncNode();
        node.setId(ctx.IDENT().getText());
        for (ParseTree childNode: ctx.children) {
            if (childNode.getClass().getSimpleName().equals("ExpressionContext")){
                node.addArgs((ExpNode) visit(childNode));
            }
        }
        return node;
    }

    @Override
    public ASTNode visitValueExpression(NybCParser.ValueExpressionContext ctx) {
        if (ctx.INT() != null) {
            IntNode node = new IntNode();
            node.setValue(Integer.parseInt(ctx.INT().getText()));
            return node;
        } else if (ctx.IDENT() != null) {
            IdentifierNode node = new IdentifierNode();
            node.setValue(ctx.IDENT().getText());
            return node;
        } else if (ctx.FLOAT() != null) {
            FloatNode node = new FloatNode();
            node.setValue(Float.parseFloat(ctx.FLOAT().getText()));
            return node;
        } else if (ctx.STRING() != null) {
            StringNode node = new StringNode();
            node.setValue(ctx.STRING().getText());
            return node;
        } else if (ctx.BOOL() != null) {
            BoolNode node = new BoolNode();
            node.setValue(Boolean.parseBoolean(ctx.BOOL().getText()));
            return node;
        } else {
            throw new RuntimeException();
        }
    }
}
