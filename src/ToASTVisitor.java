import ASTNode.*;
import ASTNode.NumberNode;
import org.antlr.v4.parse.v4ParserException;

public class ToASTVisitor extends NybCBaseVisitor<ProgramNode>{

    public ProgramNode visitProgram(NybCParser.ProgramContext context){
        return visit(context.programList());
    }

    public ProgramNode visitProgramList(NybCParser.ProgramListContext context){

    }


    @Override
    public ProgramNode visitParrentExpression(NybCParser.ParrentExpressionContext ctx) {
        if (ctx.valueExpression() != null) {
            return visit(ctx.valueExpression());
        } else if (ctx.arrayAccess() != null) {
            return visit(ctx.arrayAccess());
        } else if (ctx.callStmt() != null) {
            return visit(ctx.callStmt());
        } else if (ctx.expression() != null) {
            return visit(ctx.expression());
        } else {
            throw new RuntimeException();
        }
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
