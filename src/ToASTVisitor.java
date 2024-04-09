import ASTNode.*;
import ASTNode.NumberNode;
import com.sun.jdi.Value;

public class ToASTVisitor extends NybCBaseVisitor<ProgramNode>{

    public ProgramNode visitProgram(NybCParser.ProgramContext context){
        return visit(context.programList());
    }

    public ProgramNode visitProgramList(NybCParser.ProgramListContext context){

        switch (context.children.getClass()) {

        }
    }











    public ExpNode visitBoolean(NybCParser.ExpressionContext context) {
        BoolNode node = new BoolNode();

        node.setValue(Boolean.parseBoolean(context)
        return node;
    }

    public ExpNode visitString(NybCParser.ExpressionContext context) {
        StringNode node = new StringNode();

        node.setValue(context.getText());
        return node;
    }

    public ExpNode visitFloat(NybCParser.ExpressionContext context) {
        FloatNode node = new FloatNode();

        node.setValue(Float.parseFloat(context.getText()));
        return node;
    }
    public ExpNode visitInt(NybCParser.ExpressionContext context) {
        IntNode node = new IntNode();

        node.setValue(Integer.parseInt(context.getText()));
        return node;
    }
}
