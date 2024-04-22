import ASTNode.ProgramNode;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main implements VisitorInterface{



    public static void main(String[] args) throws IOException {

        keywords.add("begin");
        keywords.add("end");
        keywords.add("loop");
        keywords.add("in");
        keywords.add("out");
        keywords.add("if");
        keywords.add("else");
        keywords.add("switch");
        keywords.add("var");
        keywords.add("function");
        keywords.add("case");
        keywords.add("return");
        keywords.add("break");
        keywords.add("continue");
        keywords.add("true");
        keywords.add("false");


        Path fileName = Path.of("src/code.txt");
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
            System.out.println("Stakkels Angela");
        }
    }
}
