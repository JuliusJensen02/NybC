package ASTNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProgramNode <T> implements ASTNode{

    private List<T> stmtList = new ArrayList<T>();

    public List<T> getStmtList() {
        return stmtList;
    }

    public void addStmt(T stmt) {
        this.stmtList.add(stmt);
    }

    @Override
    public String toString() {
        return "ProgramNode{" +
                "stmtList=" + stmtList +
                '}';
    }
}



