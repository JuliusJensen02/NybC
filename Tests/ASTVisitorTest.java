import ASTNode.*;
import AntlrGenFiles.NybCLexer;
import AntlrGenFiles.NybCParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ASTVisitorTest {


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
    void visitCtrlFlowNode(){
        //Setup a return control flow node with no return expression
        NybCStack nybCStack = new NybCStack();
        var ASTVisitor = new ASTVisitor(nybCStack);

        var tmpMap = new HashMap<String, Object>();
        var tmpMap2 = new HashMap<String, Object>();

        var funcNode = new FuncNode();
        funcNode.setId("hello");

        CtrlFlowNode ctrlFlowNode = new CtrlFlowNode();
        ctrlFlowNode.setType("return");
        funcNode.addStmt(ctrlFlowNode);

        tmpMap2.put("0",funcNode);
        tmpMap.put("hello",tmpMap2);
        nybCStack.PutFunction(funcNode.getId(),tmpMap2);

        CtrlFlowNode rtrnCFLN = ASTVisitor.Visit(ctrlFlowNode);

        Assertions.assertEquals(ctrlFlowNode,rtrnCFLN);

        System.out.println(nybCStack.toString());

        //Assertions.assertEquals("[{hello={0=FuncNode{id='hello', param=[], stmtList=[CtrlFlowNode{type='return', returnExp=null}]}}}]",nybCStack.);



        //Setup a return control flow node with a return expression
        nybCStack = new NybCStack();
        ASTVisitor = new ASTVisitor(nybCStack);

        tmpMap = new HashMap<String, Object>();
        tmpMap2 = new HashMap<String, Object>();

        funcNode = new FuncNode();
        funcNode.setId("hello");

        ctrlFlowNode = new CtrlFlowNode();
        ctrlFlowNode.setType("return");

        var intNode = new IntNode();
        intNode.setValue(2);
        ctrlFlowNode.setReturnExp(intNode);

        funcNode.addStmt(ctrlFlowNode);


        tmpMap2.put("0",funcNode);
        tmpMap.put("hello",tmpMap2);
        nybCStack.PushStack(tmpMap2);

        rtrnCFLN = ASTVisitor.Visit(ctrlFlowNode);

        Assertions.assertEquals(ctrlFlowNode,rtrnCFLN);
        Assertions.assertEquals("[{0=FuncNode{id='hello', param=[], stmtList=[CtrlFlowNode{type='return', returnExp=IntNode{value=2}}]}, 1=2}]",nybCStack.StackToString());


        //Setup a break control flow node
//        nybCStack = new NybCStack();
//        ASTVisitor = new ASTVisitor(nybCStack);
//
//        tmpMap = new HashMap<String, Object>();
//        tmpMap2 = new HashMap<String, Object>();
//
//        var switchNode = new SwitchNode();
//        switchNode.setSwitchCond();
//
//        ctrlFlowNode = new CtrlFlowNode();
//        ctrlFlowNode.setType("break");
//
//        var intNode = new IntNode();
//        intNode.setValue(2);
//        ctrlFlowNode.setReturnExp(intNode);
//
//        funcNode.addStmt(ctrlFlowNode);
//
//
//        tmpMap2.put("0",funcNode);
//        tmpMap.put("hello",tmpMap2);
//        nybCStack.getStack().add(tmpMap);
//
//        rtrnCFLN = ASTVisitor.Visit(ctrlFlowNode);
//
//        Assertions.assertEquals(ctrlFlowNode,rtrnCFLN);
//        Assertions.assertEquals("[{hello={0=FuncNode{id='hello', param=[], stmtList=[CtrlFlowNode{type='return', returnExp=IntNode{value=2}}]}}}]",nybCStack.getStack().toString());




    }


}
