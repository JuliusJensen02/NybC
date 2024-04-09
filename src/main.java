import org.antlr.v4.runtime.*;

public class main {

    public static void main(String[] args) {
        var inputStream = CharStreams.fromString("var x = 3;");
        var lexer = new NybCLexer(inputStream);

        System.out.println(lexer);

        var tokenStream = new CommonTokenStream(lexer);

        System.out.println(tokenStream);

        var parser = new NybCParser(tokenStream);
        var parseTree = parser.program();

        System.out.println(parseTree);


    }
}
