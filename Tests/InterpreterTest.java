import ASTNode.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InterpreterTest {

    @Test
    void visitLoopNode(){

        // Setup the interpreter
        NybCStack nybCStack = new NybCStack();
        Interpreter interpreter = new Interpreter(nybCStack, new ArrayList<>());
        nybCStack.PushStack();

        // Test for while loop
        DeclNode declNode = new DeclNode("x",new IntNode(2));
        nybCStack.PutVariableToCurrentStack(declNode.getId(),declNode.getValue());
        System.out.println(nybCStack.StackToString());


        LoopNode loopNode = new LoopNode();
        loopNode.setType("while");
        BinaryOpNode binaryOpNode = new BinaryOpNode(new IdentifierNode("x"),"<",new IntNode(10));
        loopNode.setCondition(binaryOpNode);

        System.out.println(interpreter.Visit(loopNode));





        // Test for for loop

        // Test for do while loop



    }


    @Test
    void visitSwitchNode(){

    }


    @Test
    void visitAssignNode(){

    }

    @Test
    void visitDeclarationNode(){

    }

    @Test
    void visitCallFuncNode(){

    }


}