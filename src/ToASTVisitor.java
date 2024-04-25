import ASTNode.*;
import AntlrGenFiles.NybCBaseVisitor;
import AntlrGenFiles.NybCParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ToASTVisitor extends NybCBaseVisitor<ASTNode> {
    @Override
    public ASTNode visit(ParseTree tree) {
        if (tree == null) {
            return null;
        }
        return tree.accept(this);
    }

    @Override
    public ProgramNode visitProgram(NybCParser.ProgramContext ctx) {
        ProgramNode node = new ProgramNode();
        for (ParseTree childNode: ctx.children) {
            if (!(childNode instanceof NybCParser.StmtContext) && !(childNode instanceof NybCParser.FunctionStmtContext)) {
                Error.GLOBAL_MUST_CONTAIN_STMT(childNode.getClass().getSimpleName());
            }
            node.addStmt(visit(childNode));
        }
        return node;
    }

    @Override
    public StmtNode visitStmt(NybCParser.StmtContext ctx) {
        return (StmtNode) visit(ctx.getChild(0));
    }

    @Override
    public FuncNode visitFunctionStmt(NybCParser.FunctionStmtContext ctx) {
        FuncNode node = new FuncNode();

        node.setId(ctx.getChild(2).getText());
        if (!ctx.getChild(ctx.children.size()-2).getText().equals(node.getId()) && !ctx.getChild(ctx.children.size()-2).getText().equals("function"))  {
            Error.INCORRECT_END_FUNCTION();
        }
        if (ctx.getChild(ctx.children.size()-2).getText().equals("function")){
            for (int i = 1; i < ctx.IDENT().size(); i++) {
                if (node.getId().equals(ctx.IDENT(i).getText())){
                    Error.FUNC_PARAM_EQ_FUNC_NAME();
                }
                node.addParam(new DeclNode<>(ctx.IDENT(i).getText()));
            }
        } else {
            for (int i = 1; i < ctx.IDENT().size()-1; i++) {
                if (node.getId().equals(ctx.IDENT(i).getText())){
                    Error.FUNC_PARAM_EQ_FUNC_NAME();
                }
                node.addParam(new DeclNode<>(ctx.IDENT(i).getText()));
            }
        }
        for (ParseTree childNode: ctx.stmt()) {
            node.addStmt((StmtNode) visit(childNode));
        }
        return node;
    }

    @Override
    public ASTNode visitBeginStmt(NybCParser.BeginStmtContext ctx) {
        return switch (ctx.getChild(1).getText()){
            case "if" -> {
                IfNode node = new IfNode();
                node.setCondition((ExpNode) visit(ctx.getChild(3)));
                node.setIfNode((IfNode) visit(ctx.extendedIf()));
                for (ParseTree stmtNode: ctx.stmt()){
                    node.addStmt((StmtNode) visit(stmtNode));
                }
                yield node;
            }
            case "loop" -> {
                LoopNode node = new LoopNode();
                    ParseTree ctxChild = ctx.getChild(3);
                if (ctxChild instanceof NybCParser.ExpressionContext expressionContext) {
                    node.setType("while");
                    node.setCondition((ExpNode) visit(expressionContext));
                } else if (ctxChild instanceof NybCParser.StmtContext) {
                    node.setType("do-while");
                    node.setCondition((ExpNode) visit(ctx.getChild(ctx.children.size() - 2)));
                } else if (ctxChild instanceof NybCParser.DeclareStmtContext declareStmtContext) {
                    node.setType("for");
                    node.setDeclaration((DeclNode<Integer>) visit(declareStmtContext));
                    node.setCondition((ExpNode) visit(ctx.getChild(5)));
                    node.setAssignment((AssignNode<String, Integer>) visit(ctx.getChild(7)));
                }
                for (ParseTree stmt : ctx.stmt()) {
                    node.addStmt((StmtNode) visit(stmt));
                }
                yield node;
            }
            case "switch" -> {
                SwitchNode node = new SwitchNode();
                node.setSwitchCond((ExpNode) visit(ctx.expression()));
                for (ParseTree caseNode : ctx.switchCase()) {
                    node.addCase((CaseNode) visit(caseNode));
                }
                yield node;
            }
            default -> null;
        };
    }


    @Override
    public ASTNode visitSwitchCase(NybCParser.SwitchCaseContext ctx) {
        CaseNode node = new CaseNode();
        if (ctx.getChild(0).getText().equals("case")) {
            node.setCaseExp((ExpNode) visit(ctx.getChild(1)));
        }
        for (ParseTree stmtNode : ctx.stmt()) {
            node.addStmt((StmtNode) visit(stmtNode));
        }
        return node;
    }

    @Override
    public IfNode visitExtendedIf(NybCParser.ExtendedIfContext ctx) {
        IfNode node = new IfNode();
        for (ParseTree stmtNode : ctx.stmt()) {
            node.addStmt((StmtNode) visit(stmtNode));
        }
        node.setCondition((ExpNode) visit(ctx.expression()));
        node.setIfNode((IfNode) visit(ctx.extendedIf()));
        return node;
    }

    @Override
    public DeclNode<?> visitDeclareStmt(NybCParser.DeclareStmtContext ctx) {
        if (ctx.getChild(3) != null) {
            if (ctx.getChild(3) instanceof  NybCParser.ExpressionContext) {
                return new DeclNode<>(ctx.IDENT().getText(), (ExpNode) visit(ctx.expression()));
            } else if (ctx.getChild(3) instanceof NybCParser.ArrayContext) {
                return new DeclNode<>(ctx.IDENT().getText(), (ArrayNode) visit(ctx.array()));
            } else {
                Error.DECLARE_ASSIGNMENT_WRONG_TYPE(ctx.getChild(3).getClass().getSimpleName());
            }
        } else return new DeclNode<>(ctx.IDENT().getText());
        return null;
    }

    @Override
    public AssignNode<?, ?> visitAssignStmt(NybCParser.AssignStmtContext ctx) {
        if(ctx.getChild(0) instanceof NybCParser.ArrayAccessContext){
            return new AssignNode<>(((ArrayAccessNode<?>)visit(ctx.getChild(0))), ((ExpNode)visit(ctx.getChild(2))));
        }
        else{
            if(ctx.getChild(2) instanceof NybCParser.ArrayContext) {
                return new AssignNode<>(ctx.IDENT().getText(), (ArrayNode) visit(ctx.getChild(2)));
            }
            else{
                return new AssignNode<>(ctx.IDENT().getText(), (ExpNode) visit(ctx.getChild(2)));
            }
        }
    }

    @Override
    public ArrayNode visitArray(NybCParser.ArrayContext ctx) {
        ArrayNode arrayNode = new ArrayNode();
        for (ParseTree expNode : ctx.expression()) {
            arrayNode.addValue((ExpNode) visit(expNode));
        }
        return arrayNode;
    }

    @Override
    public ASTNode visitTerminal(TerminalNode node) {
        return super.visitTerminal(node);
    }

    @Override
    public CtrlFlowNode visitCtrlFlowStmt(NybCParser.CtrlFlowStmtContext ctx) {
        CtrlFlowNode node = new CtrlFlowNode();
        node.setReturnExp((ExpNode) visit(ctx.expression()));
        switch (ctx.getChild(0).getText()) {
            case "return" -> node.setType("return");
            case "continue" -> node.setType("continue");
            case "break" -> node.setType("break");
        }
        return node;
    }

    @Override
    public ASTNode visitExpression(NybCParser.ExpressionContext ctx) {
        if (ctx.children.size() == 3) {
            return new BinaryOpNode(
                    (ExpNode) visit(ctx.getChild(0)),
                    ctx.getChild(1).getText(),
                    (ExpNode) visit(ctx.getChild(2))
            );
        } else {
            return visit(ctx.getChild(0));
        }
    }

    @Override
    public ASTNode visitOrExp(NybCParser.OrExpContext ctx) {
        if (ctx.children.size() == 3) {
            return new BinaryOpNode(
                    (ExpNode) visit(ctx.getChild(0)),
                    ctx.getChild(1).getText(),
                    (ExpNode) visit(ctx.getChild(2))
            );
        } else {
            return visit(ctx.getChild(0));
        }
    }

    @Override
    public ASTNode visitAndExp(NybCParser.AndExpContext ctx) {
        if (ctx.children.size() == 3) {
            return new BinaryOpNode(
                    (ExpNode) visit(ctx.getChild(0)),
                    ctx.getChild(1).getText(),
                    (ExpNode) visit(ctx.getChild(2))
            );
        } else {
            return visit(ctx.getChild(0));
        }
    }

    @Override
    public ASTNode visitEqExp(NybCParser.EqExpContext ctx) {
        if (ctx.children.size() == 3) {
            return new BinaryOpNode(
                    (ExpNode) visit(ctx.getChild(0)),
                    ctx.getChild(1).getText(),
                    (ExpNode) visit(ctx.getChild(2))
            );
        } else {
            return visit(ctx.getChild(0));
        }
    }

    @Override
    public ASTNode visitRelationalExp(NybCParser.RelationalExpContext ctx) {
        if (ctx.children.size() == 3) {
            return new BinaryOpNode(
                    (ExpNode) visit(ctx.getChild(0)),
                    ctx.getChild(1).getText(),
                    (ExpNode) visit(ctx.getChild(2))
            );
        } else {
            return visit(ctx.getChild(0));
        }
    }

    @Override
    public ASTNode visitAdditionExp(NybCParser.AdditionExpContext ctx) {
        if (ctx.children.size() == 3) {
            return new BinaryOpNode(
                    (ExpNode) visit(ctx.getChild(0)),
                    ctx.getChild(1).getText(),
                    (ExpNode) visit(ctx.getChild(2))
            );
        } else {
            return visit(ctx.getChild(0));
        }
    }

    @Override
    public ASTNode visitUnaryExp(NybCParser.UnaryExpContext ctx) {
        if (ctx.children.size() == 2) {
            UnaryOpNode node = new UnaryOpNode();
            node.setRight((ExpNode) visit(ctx.getChild(1)));
            node.setOp(ctx.getChild(0).getText());
            return node;
        } else {
            return visit(ctx.getChild(0));
        }
    }

    @Override
    public ASTNode visitParenthExp(NybCParser.ParenthExpContext ctx) {
        if (ctx.children.size() ==  3) {
            ParenthNode node = new ParenthNode();
            node.setInner((ExpNode) visit(ctx.getChild(1)));
            return node;
        } else {
            return visit(ctx.getChild(0));
        }
    }

    @Override
    public ArrayAccessNode<?> visitArrayAccess(NybCParser.ArrayAccessContext ctx) {
        String id = ctx.getChild(0).getText();
        if(ctx.INT() != null){
            return new ArrayAccessNode<>(id, Integer.parseInt(ctx.INT().getText()));
        } else {
            return new ArrayAccessNode<>(id, ctx.getChild(2).getText());
        }
    }

    @Override
    public CallFuncNode visitCallStmt(NybCParser.CallStmtContext ctx) {
        CallFuncNode node = new CallFuncNode();
        node.setId(ctx.IDENT().getText());
        for (ParseTree childNode: ctx.children) {
            if (childNode instanceof NybCParser.ExpressionContext){
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
            String value = ctx.STRING().getText();
            value = value.substring(1,value.length()-1);
            node.setValue(value);
            return node;
        } else if (ctx.BOOL() != null) {
            BoolNode node = new BoolNode();
            node.setValue(Boolean.parseBoolean(ctx.BOOL().getText()));
            return node;
        } else {
            Error.INCORRECT_TYPE_FOR_VALUE_EXP();
            return null;
        }
    }
}
