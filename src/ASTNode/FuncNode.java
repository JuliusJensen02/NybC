package ASTNode;

import org.antlr.v4.codegen.model.decl.Decl;

import java.util.ArrayList;
import java.util.List;

public class FuncNode extends ProgramNode implements ASTNode {
    private String id;
    private List<String> param = new ArrayList<String>();

    private List<StmtNode> stmtList = new ArrayList<StmtNode>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getParam() {
        return param;
    }

    public void addParam(String param) {
        this.param.add(param);
    }

    public List<StmtNode> getStmsList() {
        return stmtList;
    }

    public void addStmt(StmtNode stmt) {
        this.stmtList.add(stmt);
    }

    @Override
    public String toString() {
        return "FuncNode{" +
                "id='" + id + '\'' +
                ", param=" + param +
                ", stmtList=" + stmtList +
                '}';
    }
}
