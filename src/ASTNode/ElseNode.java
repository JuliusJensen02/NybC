package ASTNode;

import java.util.ArrayList;
import java.util.List;

public class ElseNode implements ASTNode{
    private List<StmtNode> stmts = new ArrayList<StmtNode>();

    public List<StmtNode> getStmts() {
        return stmts;
    }

    public void addStmt(StmtNode stmt) {
        this.stmts.add(stmt);
    }
}
