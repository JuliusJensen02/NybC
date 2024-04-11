package ASTNode;

public class ReturnNode extends StmtNode implements ASTNode {
    private ExpNode exp = null;

    public ExpNode getExp() {
        return exp;
    }

    public void setExp(ExpNode exp) {
        this.exp = exp;
    }
}
