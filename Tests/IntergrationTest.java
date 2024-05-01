import ASTNode.ProgramNode;
import AntlrGenFiles.NybCLexer;
import AntlrGenFiles.NybCParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IntergrationTest {


    @Test
    void FullTest() throws Exception {

        // Use the code from FullTest.txt and run it through the lexar and parser

        Path fileName = Path.of("Tests/FullTest.txt");
        var inputStream = CharStreams.fromString(Files.readString(fileName));
        var lexer = new NybCLexer(inputStream);
        var tokenStream = new CommonTokenStream(lexer);
        var parser = new NybCParser(tokenStream);
        var parseTree = parser.program();
        var parseTreevisitor = new ToASTVisitor();

        // Run ToAstVisitor and check if the AST is correct
        ProgramNode AST = (ProgramNode) parseTreevisitor.visit(parseTree);
        String ASTString = AST.toString();
        Assertions.assertEquals("ProgramNode{stmtList=[DeclNode{id='b', value=IntNode{value=0}}, FuncNode{id='a', param=[], stmtList=[DeclNode{id='b', value=IntNode{value=1}}, CtrlFlowNode{type='return', returnExp=IdentifierNode{value='b'}}]}, DeclNode{id='x', value=CallFuncNode{id='a', args=[]}}, CallFuncNode{id='out', args=[IdentifierNode{value='b'}]}]}"
                , ASTString);

        // Run InitialVisitor and check if the fmap is correct
        List<String> keyWords = new ArrayList<>();
        keyWords.add("out");
        Assertions.assertDoesNotThrow(()->{
            InitialVisitor initialVisitor = new InitialVisitor(new NybCStack(), keyWords);
            initialVisitor.Visit(AST);
        });

        NybCStack nybCStack = new NybCStack();

        InitialVisitor initialVisitor = new InitialVisitor(nybCStack, keyWords);
        initialVisitor.Visit(AST);
        Assertions.assertEquals("{a={0=FuncNode{id='a', param=[], stmtList=[DeclNode{id='b', value=IntNode{value=1}}, CtrlFlowNode{type='return', returnExp=IdentifierNode{value='b'}}]}, 1=null}}",nybCStack.FmapToString());


        // Run Interpreter and check if the stack is correct
        Interpreter interpreter = new Interpreter(nybCStack, keyWords);

        interpreter.Visit(AST);
        System.out.println(nybCStack.StackToString());

        Assertions.assertEquals(1,nybCStack.GetVariableOnStack("x"));
        Assertions.assertEquals(0,nybCStack.GetVariableOnStack("b"));
    }
}
