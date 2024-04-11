package ASTNode;

public class ArrayAccessNode <T> extends ExpNode implements ASTNode{
    private String id;
    private T index;

    public ArrayAccessNode(String id, T index){
        this.id = id;
        this.index = index;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setIndex(T index){
        this.index = index;
    }

    public T getIndex(){
        return index;
    }

    public String toString(){
        return id+"["+index+"]";
    }
}
