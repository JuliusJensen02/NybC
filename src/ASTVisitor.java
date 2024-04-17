import ASTNode.*;
import org.antlr.v4.codegen.model.Loop;

import java.awt.geom.Arc2D;

public abstract class ASTVisitor<T> {

    public abstract T Visit(BoolNode node);
    public abstract T Visit(FloatNode node);
    public abstract T Visit(IntNode node);
    public abstract T Visit(StringNode node);
    public abstract T Visit(IdentifierNode node);
    public abstract T Visit(BinaryOpNode node);
    public abstract T Visit(UnaryOpNode node);
    public abstract T Visit(ParenthNode node);
    public abstract T Visit(ArrayAccessNode node);
    public abstract T Visit(CallFuncNode node);
    public abstract T Visit(ElseNode node);
    public abstract T Visit(ElseIfNode node);
    public abstract T Visit(IfNode node);
    public abstract T Visit(DeclNode node);
    public abstract T Visit(CtrlFlowNode node);
    public abstract T Visit(AssignNode node);
    public abstract T Visit(ArrayNode node);
    public abstract T Visit(CaseNode node);
    public abstract T Visit(SwitchNode node);
    public abstract T Visit(LoopNode node);
    public abstract T Visit(FuncNode node);
    public abstract void Visit(ProgramNode node);

    public T Visit(ExpNode node)
    {
        if (node instanceof BoolNode) {
            return Visit((BoolNode) node);
        } else if (node instanceof IdentifierNode) {
            return Visit((IdentifierNode) node);
        }else if (node instanceof IntNode) {
            return Visit((IntNode) node);
        }else if (node instanceof FloatNode) {
            return Visit((FloatNode) node);
        }else if (node instanceof StringNode) {
            return Visit((StringNode) node);
        }else if (node instanceof ParenthNode) {
            return Visit((ParenthNode) node);
        }else if (node instanceof UnaryOpNode) {
            return Visit((UnaryOpNode) node);
        }else if (node instanceof BinaryOpNode) {
            return Visit((BinaryOpNode) node);
        }else if (node instanceof ArrayAccessNode) {
            return Visit((ArrayAccessNode) node);
        }else if (node instanceof CallFuncNode) {
            return Visit((CallFuncNode) node);
        }
        return null;
    }

    public T Visit (StmtNode node)
    {
        if (node instanceof IfNode) {
            return Visit((IfNode) node);
        } else if (node instanceof LoopNode) {
            return Visit((LoopNode) node);
        }else if (node instanceof SwitchNode) {
            return Visit((SwitchNode) node);
        }else if (node instanceof DeclNode) {
            return Visit((DeclNode) node);
        }else if (node instanceof AssignNode) {
            return Visit((AssignNode) node);
        }else if (node instanceof CallFuncNode) {
            return Visit((CallFuncNode) node);
        }else if (node instanceof CtrlFlowNode) {
            return Visit((CtrlFlowNode) node);
        }else if (node instanceof FuncNode) {
            return Visit((FuncNode) node);
        }
        return null;
    }
}
