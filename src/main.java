import org.antlr.v4.runtime.*;

public class main {

    public static void main(String[] args) {
        var inputStream = CharStreams.fromString("var x = 3 + 2;");
        var lexer = new NybCLexer(inputStream);


        var tokenStream = new CommonTokenStream(lexer);


        var parser = new NybCParser(tokenStream);
        var parseTree = parser.program();
        var ASTvisitor = new ToASTVisitor();
        System.out.println(ASTvisitor.visit(parseTree));



    }
}
