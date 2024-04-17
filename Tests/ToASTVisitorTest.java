import ASTNode.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class ToASTVisitorTest {
    private ParseTree setupParseTree(String input) {
        var inputStream = CharStreams.fromString(input);
        var lexer = new NybCLexer(inputStream);
        var tokenStream = new CommonTokenStream(lexer);
        var parser = new NybCParser(tokenStream);
        return parser.program();
    }

    @Test
    void visitFunctionStmtTest() throws  IOException {
        var ASTvisitor = new ToASTVisitor();
        var parseTreeForFunction = setupParseTree("begin function test(var testValue); var x = 4; end function;");

        NybCParser.FunctionStmtContext functionStmtContext =(NybCParser.FunctionStmtContext) parseTreeForFunction.getChild(0).getChild(0);
        FuncNode funcNode = (FuncNode) ASTvisitor.visitFunctionStmt(functionStmtContext);
        Assertions.assertNotNull(funcNode);
        Assertions.assertEquals("FuncNode{id='test', param=[testValue], stmtList=[DeclNode{id='x', value=4}]}", funcNode.toString());
    }


    @Test
    void visitCallStmtTest(){
        // It wants to call - Daniel

    }
    //visitBeginStmt - Daniel

    //visitDeclareStmt - Markus

    //visitAssignStmt - Markus


    @Test
    void visitValueExpressionTest() throws IOException {
        var ASTvisitor = new ToASTVisitor();

        //Test For an Integer
        var parseTreeForInt = setupParseTree("var x = 4;");
        NybCParser.ValueExpressionContext IntExpCtx = (NybCParser.ValueExpressionContext)
                parseTreeForInt.getChild(0).getChild(0).getChild(3).getChild(0);
        IntNode IntResult = (IntNode) ASTvisitor.visitValueExpression(IntExpCtx);
        Assertions.assertNotNull(IntResult);
        assertThat(IntResult, instanceOf(IntNode.class));
        Assertions.assertEquals(4, IntResult.value);

        //Test For Identifier
        var parseTreeForIdent = setupParseTree("var x = y;");
        NybCParser.ValueExpressionContext IdentExpCtx = (NybCParser.ValueExpressionContext)
                parseTreeForIdent.getChild(0).getChild(0).getChild(3).getChild(0);
        IdentifierNode IdentResult = (IdentifierNode) ASTvisitor.visitValueExpression(IdentExpCtx);

        Assertions.assertNotNull(IdentResult);
        assertThat(IdentResult, instanceOf(IdentifierNode.class));
        Assertions.assertEquals("y", IdentResult.getValue());


        //Test for float
        var parseTreeForFloat = setupParseTree("var x = 4.2;");
        NybCParser.ValueExpressionContext FloatExpCtx = (NybCParser.ValueExpressionContext)
                parseTreeForFloat.getChild(0).getChild(0).getChild(3).getChild(0);
        FloatNode FloatResult = (FloatNode) ASTvisitor.visitValueExpression(FloatExpCtx);

        Assertions.assertNotNull(FloatResult);
        assertThat(FloatResult, instanceOf(FloatNode.class));

        //https://stackoverflow.com/questions/11701399/round-up-to-2-decimal-places-in-java note: c# er bedre
        Assertions.assertEquals(4.2, (double) Math.round(FloatResult.getValue() * 100) / 100 );


        //Test for String
        var parseTreeForString = setupParseTree("var x = \"Hello\";");
        NybCParser.ValueExpressionContext StringExpCtx = (NybCParser.ValueExpressionContext)
                    parseTreeForString.getChild(0).getChild(0).getChild(3).getChild(0);
        StringNode stringResult = (StringNode) ASTvisitor.visitValueExpression(StringExpCtx);

        Assertions.assertNotNull(stringResult);
        assertThat(stringResult, instanceOf(StringNode.class));
        Assertions.assertEquals("Hello", stringResult.getValue());


        //Test for bool to fix with merge
        var parseTreeForBool = setupParseTree("var x = true;");
        NybCParser.ValueExpressionContext BoolExpCtx = (NybCParser.ValueExpressionContext)
                parseTreeForBool.getChild(0).getChild(0).getChild(3).getChild(0);
        BoolNode boolResult = (BoolNode) ASTvisitor.visitValueExpression(BoolExpCtx);

        Assertions.assertNotNull(boolResult);
        assertThat(boolResult, instanceOf(BoolNode.class));
        Assertions.assertEquals(true, boolResult.isValue());
    }





    @Test
    void visitProgram() throws IOException {

        Path fileName = Path.of("Tests/FullTest.txt");
        var inputStream = CharStreams.fromString(Files.readString(fileName));
        var lexer = new NybCLexer(inputStream);
        var tokenStream = new CommonTokenStream(lexer);
        var parser = new NybCParser(tokenStream);
        var parseTree = parser.program();
        var ASTvisitor = new ToASTVisitor();


        System.out.println(ASTvisitor.visit(parseTree).toString());

    }


}
