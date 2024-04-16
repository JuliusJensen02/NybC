import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import ASTNode.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ToASTVisitorTest {



    @Test
    void visitProgram() throws IOException {

        Path fileName = Path.of("Tests/FullTest.txt");
        var inputStream = CharStreams.fromString(Files.readString(fileName));
        var lexer = new NybCLexer(inputStream);
        var tokenStream = new CommonTokenStream(lexer);
        var parser = new NybCParser(tokenStream);
        var parseTree = parser.program();
        var ASTvisitor = new ToASTVisitor();
        ;

        System.out.println(ASTvisitor.visit(parseTree).toString());

    }


}
