import ASTNode.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class InterpreterTest {

    @Test
    void visitLoopNode(){

        // Setup the interpreter
        NybCStack nybCStack = new NybCStack();
        Interpreter interpreter = new Interpreter(nybCStack, new ArrayList<>());
        nybCStack.PushStack();

        // Test for while loop
        DeclNode declNode = new DeclNode("x",2);
        nybCStack.PutVariableToCurrentStack(declNode.getId(),declNode.getValue());

        LoopNode whileLoopNode = new LoopNode();
        whileLoopNode.setType("while");
        whileLoopNode.setCondition(new BinaryOpNode(new IdentifierNode("x"),"<",new IntNode(10)));

        CallFuncNode print = new CallFuncNode();
        print.setId("out");
        print.addArgs(new IdentifierNode("x"));
        whileLoopNode.addStmt(print);

        whileLoopNode.addStmt(new AssignNode<>("x",new BinaryOpNode(new IdentifierNode("x"),"+",new IntNode(2))));
        interpreter.Visit(whileLoopNode);

        int xValue = (int) nybCStack.GetVariableOnStack("x");

        Assertions.assertEquals(xValue,10);

        // Test for for loop

        DeclNode gOrgVal = new DeclNode<>("g",new IntNode(0));
        nybCStack.PutVariableToCurrentStack(gOrgVal.getId(),gOrgVal.getValue());
        System.out.println(nybCStack.StackToString());

        LoopNode forLoopNode = new LoopNode();
        forLoopNode.setType("for");
        forLoopNode.setDeclaration(new DeclNode("y",new IntNode(0)));
        forLoopNode.setCondition(new BinaryOpNode(new IdentifierNode("y"),"<",new IntNode(10)));
        forLoopNode.setAssignment(new AssignNode("y",new BinaryOpNode(new IdentifierNode("y"),"+",new IntNode(1))));


        System.out.println(nybCStack.StackToString());

        //TODO Fix det her lort den kan ikke finde g på stakken samtigidt med at den kan i have no idea man
        AssignNode updateGVar = new AssignNode("g",new BinaryOpNode(new IdentifierNode("y"),"+",new IntNode(1)));
        System.out.println(updateGVar);
        forLoopNode.addStmt(updateGVar);

        interpreter.Visit(forLoopNode);

       int gNewVal = (int) nybCStack.GetVariableOnStack("g");

       System.out.println(gNewVal);
//       Assertions.assertEquals(gOrgVal.getValue(),gNewVal);




        // Test for do while loop

        DeclNode iVar = new DeclNode("i",0);
        nybCStack.PutVariableToCurrentStack(iVar.getId(),iVar.getValue());

        LoopNode doWhileLoop = new LoopNode();
        doWhileLoop.setCondition(new BinaryOpNode(new IdentifierNode("i"),"<",new IntNode(10)));
        doWhileLoop.setType("do-while");

        doWhileLoop.addStmt(new AssignNode<>("i",new BinaryOpNode(new IdentifierNode("i"),"+",new IntNode(1))));

        interpreter.Visit(doWhileLoop);

        int NewIVar = (int) nybCStack.GetVariableOnStack("i");

        Assertions.assertEquals(10,NewIVar);



    }


    @Test
    void visitSwitchNode(){
        //setup the stack and interpreter
        NybCStack nybCStack = new NybCStack();
        Interpreter interpreter = new Interpreter(nybCStack, new ArrayList<>());
        nybCStack.PushStack();


        // Test for switch with two cases' that have a break and a default


        SwitchNode switchNode = new SwitchNode();
        switchNode.setSwitchCond(new IdentifierNode("x"));

        CaseNode case1 = new CaseNode();
        case1.setCaseExp(new IntNode(1));
        AssignNode updateX = new AssignNode<>("x",new BinaryOpNode(new IdentifierNode("x"),"+",new IntNode(1)));
        case1.addStmt(updateX);
        CtrlFlowNode breaking = new CtrlFlowNode();
        breaking.setType("break");
        case1.addStmt(breaking);

        CaseNode case2 = new CaseNode();
        case2.setCaseExp(new IntNode(2));
        updateX = new AssignNode<>("x",new BinaryOpNode(new IdentifierNode("x"),"+",new IntNode(2)));
        case2.addStmt(updateX);
        case2.addStmt(breaking);


        CaseNode defaultCase = new CaseNode();
        updateX = new AssignNode<>("x",new BinaryOpNode(new IdentifierNode("x"),"+",new IntNode(3)));

        defaultCase.addStmt(updateX);
        defaultCase.addStmt(breaking);

        switchNode.addCase(case1);
        switchNode.addCase(case2);
        switchNode.addCase(defaultCase);


        DeclNode xVar = new DeclNode("x",1);
        nybCStack.PutVariableToCurrentStack(xVar.getId(),xVar.getValue());

        interpreter.Visit(switchNode);

        Assertions.assertEquals(2,(int)nybCStack.GetVariableOnStack("x"));

        xVar = new DeclNode("x",2);
        nybCStack.ReplaceVariableOnStack(xVar.getId(),xVar.getValue());

        interpreter.Visit(switchNode);

        Assertions.assertEquals(4,(int)nybCStack.GetVariableOnStack("x"));

        xVar = new DeclNode("x",6);
        nybCStack.ReplaceVariableOnStack(xVar.getId(),xVar.getValue());

        interpreter.Visit(switchNode);

        Assertions.assertEquals(9,(int)nybCStack.GetVariableOnStack("x"));



        // Test for switch with two cases' that have no break and a default
        switchNode = new SwitchNode();
        switchNode.setSwitchCond(new IdentifierNode("x"));

        case1 = new CaseNode();
        case1.setCaseExp(new IntNode(1));
        updateX = new AssignNode<>("x",new BinaryOpNode(new IdentifierNode("x"),"+",new IntNode(1)));
        case1.addStmt(updateX);

        case2 = new CaseNode();
        case2.setCaseExp(new IntNode(2));
        updateX = new AssignNode<>("x",new BinaryOpNode(new IdentifierNode("x"),"+",new IntNode(2)));
        case2.addStmt(updateX);

        defaultCase = new CaseNode();
        updateX = new AssignNode<>("x",new BinaryOpNode(new IdentifierNode("x"),"+",new IntNode(3)));

        defaultCase.addStmt(updateX);
        defaultCase.addStmt(breaking);

        switchNode.addCase(case1);
        switchNode.addCase(case2);
        switchNode.addCase(defaultCase);


        xVar = new DeclNode("x",1);
        nybCStack.ReplaceVariableOnStack(xVar.getId(),xVar.getValue());

        interpreter.Visit(switchNode);

        Assertions.assertEquals(7,(int)nybCStack.GetVariableOnStack("x"));

        xVar = new DeclNode("x",2);
        nybCStack.ReplaceVariableOnStack(xVar.getId(),xVar.getValue());

        interpreter.Visit(switchNode);

        Assertions.assertEquals(7,(int)nybCStack.GetVariableOnStack("x"));

        xVar = new DeclNode("x",6);
        nybCStack.ReplaceVariableOnStack(xVar.getId(),xVar.getValue());

        interpreter.Visit(switchNode);

        Assertions.assertEquals(9,(int)nybCStack.GetVariableOnStack("x"));


    }


    @Test
    void visitAssignNode(){

        //setup the stack and interpreter
        NybCStack nybCStack = new NybCStack();
        Interpreter interpreter = new Interpreter(nybCStack, new ArrayList<>());
        nybCStack.PushStack();

        DeclNode varX = new DeclNode("x",2);
        nybCStack.PutVariableToCurrentStack(varX.getId(),varX.getValue());

        AssignNode assignNode = new AssignNode<>("x",new BinaryOpNode(new IdentifierNode("x"),"+", new IntNode( 10)));

        interpreter.Visit(assignNode);

        Assertions.assertEquals((int) nybCStack.GetVariableOnStack("x"),(int)varX.getValue() + 10);
    }

    @Test
    void visitCallFuncNode(){
        //setup the stack and interpreter
        NybCStack nybCStack = new NybCStack();
        Interpreter interpreter = new Interpreter(nybCStack, new ArrayList<>());
        nybCStack.PushStack();

        //Setup the function
        FuncNode function = new FuncNode();
        function.setId("add2ToVar");
        function.addParam(new DeclNode("x"));

        function.addStmt(new AssignNode<>("x",new BinaryOpNode(new IdentifierNode("x"),"+", new IntNode( 2))));

        CtrlFlowNode rtrn = new CtrlFlowNode();
        rtrn.setType("return");
        rtrn.setReturnExp(new IdentifierNode("x"));
        function.addStmt(rtrn);

        nybCStack.PutFunction("add2ToVar",new HashMap<String,Object>());


        // Call the function
        CallFuncNode callFuncNode = new CallFuncNode();
        callFuncNode.addArgs(new IntNode(2));
        callFuncNode.setId("add2ToVar");

        DeclNode varY = new DeclNode<>("y",2);
        nybCStack.PutVariableToCurrentStack(varY.getId(),varY.getValue());

        AssignNode assignNode = new AssignNode("y",callFuncNode);

        interpreter.Visit(assignNode);

        Assertions.assertEquals(4,nybCStack.GetVariableOnStack("y"));


    }


}