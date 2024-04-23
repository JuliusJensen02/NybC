import ASTNode.ProgramNode;
import AntlrGenFiles.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

        // Can the function be insterted into the function map?
        var AST = setupAST("begin function hello(); var x = 2; end function;");
        System.out.println(AST);
        NybCStack nybCStack = new NybCStack();
        List<String> keywords = new ArrayList<>();
        var InitialVisitor = new InitialVisitor(nybCStack,keywords);
        InitialVisitor.Visit(AST);
        System.out.println(nybCStack.getFmap().toString());

        // Can a function with the same name happen twice?
        AST = setupAST("begin function hello(); var x = 2; end function; begin function hello(); var x = 2; end function;");
        System.out.println(AST);
        nybCStack = new NybCStack();
        keywords = new ArrayList<>();
        InitialVisitor = new InitialVisitor(nybCStack,keywords);
        InitialVisitor.Visit(AST);
        System.out.println(nybCStack.getFmap().toString());



        // Can a function with the same name as a keyword happen?



    }



}
