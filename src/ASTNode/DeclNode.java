package ASTNode;

public class DeclNode <T> extends StmtNode implements ASTNode {
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

    public DeclNode(String id, T value) {
        this.id = id;
        this.value = value;
    }
    public DeclNode(String id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "DeclNode{" +
                "id='" + id + '\'' +
                ", value=" + value +
                '}';
    }
}
