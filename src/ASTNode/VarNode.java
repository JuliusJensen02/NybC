package ASTNode;

public class VarNode <T> extends StmtNode {
    private String id;
    private T value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public VarNode(String id, T value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString(){
        return id+" = "+value;
    }
}
