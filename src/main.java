import ASTNode.ProgramNode;
import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Stack;

public class main implements VisitorInterface{



    public static void main(String[] args) throws IOException {

        Path filePath;
        //Check if there is an input
        if (args.length > 0) {
            filePath = Path.of(args[0]);
        }else {
            filePath = Path.of("src/code.txt");
        }
            var inputStream = CharStreams.fromString(Files.readString(filePath));
            var lexer = new NybCLexer(inputStream);


            var tokenStream = new CommonTokenStream(lexer);


            var parser = new NybCParser(tokenStream);
            var parseTree = parser.program();
            var ASTvisitor = new ToASTVisitor();
            var AST = ASTvisitor.visit(parseTree);
            System.out.println(ASTvisitor.visit(parseTree));
            var InitialVisitor = new InitialVisitor();
            InitialVisitor.Visit((ProgramNode) AST);
            System.out.println(fmap);
            var Interpreter = new Interpreter();
            Interpreter.Visit((ProgramNode) AST);
        }

}
