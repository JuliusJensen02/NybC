import ASTNode.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.lang.reflect.Type;

public class ToASTVisitor extends NybCBaseVisitor<ProgramNode>{

    @Override
    public ProgramNode visitProgramList(NybCParser.ProgramListContext context){
        return visitChildren(context);
    }

    @Override
    public ProgramNode visitDeclareStmt(NybCParser.DeclareStmtContext ctx) {
        String id = ctx.IDENT().getText();
        ProgramNode node = new ProgramNode();
        for (ParseTree childNode: ctx.children) {
            if (childNode.getClass().getSimpleName().equals("ExpressionContext")){
                node = visit(childNode);
            }
        }
        switch (node.getClass().getSimpleName()) {
            case "IntNode": System.out.println(new VarNode<Integer>(id,((IntNode) node).getValue())); return new VarNode<Integer>(id,((IntNode) node).getValue());
            case "FloatNode": return new VarNode<Float>(id,((FloatNode) node).getValue());
            case "IdentifierNode": return new VarNode<String>(id,((IdentifierNode) node).getValue());
            case "StringNode": return new VarNode<String>(id,((StringNode) node).getValue());
            case "BoolNode": return new VarNode<Boolean>(id,((BoolNode) node).isValue());
            default: return null;
        }
    }

    @Override
    public ProgramNode visitTerminal(TerminalNode node) {
        return super.visitTerminal(node);
    }

    @Override
    public ProgramNode visitExpression(NybCParser.ExpressionContext ctx) {

        ExpNode node;

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
    public ProgramNode visitValueExpression(NybCParser.ValueExpressionContext ctx) {
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
