import ASTNode.ProgramNode;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

public class InitialVisitorTest {

    private ProgramNode setupAST(String input) {
        var inputStream = CharStreams.fromString(input);
        var lexer = new NybCLexer(inputStream);
        var tokenStream = new CommonTokenStream(lexer);
        var parser = new NybCParser(tokenStream);
        var parseTree = parser.program();
        var ASTVisitor = new ToASTVisitor();
        return (ProgramNode) ASTVisitor.visit(parseTree);

    }


    @Test
    void VisitProgramNodeTest() {

        var AST = setupAST("begin function hello(); var x = 2; end function;");
        System.out.println(AST);
        var InitialVisitor = new InitialVisitor();
        System.out.println(InitialVisitor.Visit(AST));

    }



}
