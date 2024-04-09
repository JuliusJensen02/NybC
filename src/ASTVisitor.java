import ASTNode.ProgramNode;

public abstract class ASTVisitor<T> {


    public T Visit(ProgramNode Node) {
        return Visit((dynamic)Node);
    }
}
