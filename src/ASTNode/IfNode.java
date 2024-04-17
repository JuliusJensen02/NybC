package ASTNode;

import java.util.ArrayList;
import java.util.List;

public class IfNode<T> extends StmtNode implements ASTNode{
    private ExpNode condition;
    private List<StmtNode> stmts = new ArrayList<StmtNode>();
    private T elseIfNode;

    public T getElseIfNode() {
        return elseIfNode;
    }
    public void setElseIfNode(T elseIfNode) {
        this.elseIfNode = elseIfNode;
    }
    public ExpNode getCondition() {
        return condition;
    }
    public void setCondition(ExpNode condition) {
        this.condition = condition;
    }
    public List<StmtNode> getStmts() {
        return stmts;
    }
    public void addStmt(StmtNode stmt) {
        this.stmts.add(stmt);
    }

    public String toString() {
        return "IfNode{" +
                "condition=" + condition +
                ", stmts=" + stmts +
                ", elseIfNodes=" + elseIfNode +
                '}';
    }
}
