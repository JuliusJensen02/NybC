package ASTNode;

import java.util.ArrayList;
import java.util.List;

public class ElseIfNode <T> implements ASTNode{
    private List<StmtNode> stmts = new ArrayList<StmtNode>();
    private ExpNode condition;
    private T elseIfNode;

    public T getElseIfNode() {
        return elseIfNode;
    }

    public void setElseIfNode(T elseIfNode) {
        this.elseIfNode = elseIfNode;
    }
    public List<StmtNode> getStmts() {
        return stmts;
    }

    public void addStmt(StmtNode stmt) {
        this.stmts.add(stmt);
    }

    public ExpNode getCondition() {
        return condition;
    }

    public void setCondition(ExpNode condition) {
        this.condition = condition;
    }

    public String toString() {
        return "ElseIfNode{" +
                "condition=" + condition +
                ", stmts=" + stmts +
                ", elseIfNodes=" + elseIfNode +
                '}';
    }
}
