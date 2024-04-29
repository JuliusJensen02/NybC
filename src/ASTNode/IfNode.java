package ASTNode;

import java.util.ArrayList;
import java.util.List;

//TODO hviker ikke i interpreter: ifNode er null når den skal bruges 😫
public class IfNode extends StmtNode implements ASTNode{
    private ExpNode condition;
    private List<StmtNode> stmts = new ArrayList<StmtNode>();
    private IfNode ifNode;

    public IfNode getElseIfNode() {
        return ifNode;
    }
    public void setIfNode(IfNode elseIfNode) {
        this.ifNode = elseIfNode;
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
                ", elseIfNodes=" + ifNode +
                '}';
    }
}
