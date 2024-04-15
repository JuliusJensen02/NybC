package ASTNode;

import java.util.ArrayList;
import java.util.List;

public class ProgramNode implements ASTNode{

    private List<StmtNode> stmtList = new ArrayList<StmtNode>();
    private List<FuncNode> functionList = new ArrayList<FuncNode>();

    public List<StmtNode> getStmtList() {
        return stmtList;
    }

    public void addStmt(StmtNode stmt) {
        this.stmtList.add(stmt);
    }

    public List<FuncNode> getFunctionList() {
        return functionList;
    }

    public void addFunction(FuncNode function) {
        this.functionList.add(function);
    }

    @Override
    public String toString() {
        return "ProgramNode{" +
                "stmtList=" + stmtList +
                ", functionList=" + functionList +
                '}';
    }
}



