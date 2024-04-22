import ASTNode.ProgramNode;
import org.antlr.v4.runtime.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main implements VisitorInterface{



    public static void main(String[] args) throws IOException {

        Path fileName = Path.of("src/code.txt");
        var inputStream = CharStreams.fromString(Files.readString(fileName));
        var lexer = new NybCLexer(inputStream);


        var tokenStream = new CommonTokenStream(lexer);


        var parser = new NybCParser(tokenStream);
        var parseTree = parser.program();
        var ASTVisitor = new ToASTVisitor();
        var AST = ASTVisitor.visit(parseTree);
        System.out.println(ASTVisitor.visit(parseTree));
        var InitialVisitor = new InitialVisitor();
        InitialVisitor.Visit((ProgramNode) AST);
        System.out.println(fmap);
        var Interpreter = new Interpreter();
        Interpreter.Visit((ProgramNode) AST);
    }
}
