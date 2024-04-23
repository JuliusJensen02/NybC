import ASTNode.CtrlFlowNode;
import ASTNode.DeclNode;
import ASTNode.ExpNode;
import ASTNode.IntNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ASTVisitorTest {

    @Test
    void DeclNodeVisitTest(){
        IntNode intNode = new IntNode();
        intNode.value = 2;
        DeclNode declNode = new DeclNode("x",intNode);

        InitialVisitor initialVisitor = new InitialVisitor();

        System.out.println(initialVisitor.Visit(declNode));


    }

    @Test
    void ProgramNodeTest(){

    }

    @Test
    void CtrlFlowNodeVisit(){
        InitialVisitor initialVisitor = new InitialVisitor();
        CtrlFlowNode ctrlFlowNode = new CtrlFlowNode();

        ctrlFlowNode.setType("return");
        CtrlFlowNode Result = initialVisitor.Visit(ctrlFlowNode);

        Assertions.assertNotNull(Result);
        Assertions.assertEquals(ctrlFlowNode,Result);
    }


}
