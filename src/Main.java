import ASTNode.ProgramNode;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Main implements VisitorInterface{



    public static void main(String[] args) throws IOException {
        keywords.addAll(Arrays.asList("begin", "end", "loop", "in", "out", "if", "else", "switch", "var", "function", "case", "return", "break", "continue", "true", "false"));

        Path fileName = Path.of("src/code.nybc");
        var inputStream = CharStreams.fromString(Files.readString(fileName));
        var lexer = new NybCLexer(inputStream);
        var tokenStream = new CommonTokenStream(lexer);

        NybCParser parser;
        ParseTree parseTree;
        try {
            parser = new NybCParser(tokenStream);
            parseTree = parser.program();
            var ASTVisitor = new ToASTVisitor();
            var AST = ASTVisitor.visit(parseTree);
            System.out.println(AST);
            var InitialVisitor = new InitialVisitor();
            InitialVisitor.Visit((ProgramNode) AST);
            System.out.println(fmap);
            var Interpreter = new Interpreter();
            Interpreter.Visit((ProgramNode) AST);
        } catch (NullPointerException e){
            Error.SYNTAX_ERROR(e);
        }
    }
}
