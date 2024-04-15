import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class main {

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of("src/code.txt");
        var inputStream = CharStreams.fromString(Files.readString(fileName));
        var lexer = new NybCLexer(inputStream);


        var tokenStream = new CommonTokenStream(lexer);


        var parser = new NybCParser(tokenStream);
        var parseTree = parser.program();
        var ASTvisitor = new ToASTVisitor();
        System.out.println(ASTvisitor.visit(parseTree));
    }
}
