package ASTNode;

class ProgramNode {

}

class StmtNode extends ProgramNode{}

class FuncNode extends ProgramNode{}

class LoopNode extends StmtNode{}

class CondNode extends StmtNode{}

class SwitchNode extends CondNode{}

class ExpNode extends StmtNode{}

class ContinueNode extends StmtNode{}
class BreakNode extends StmtNode{}
class ReturnNode extends StmtNode{}

class infixNode extends ExpNode{
    private ExpNode Left;
    private ExpNode Right;

    public ExpNode getLeft() {
        return Left;
    }

    public void setLeft(ExpNode left) {
        Left = left;
    }

    public ExpNode getRight() {
        return Right;
    }

    public void setRight(ExpNode right) {
        Right = right;
    }



}

class AddNode extends infixNode{}
class SubNode extends infixNode{}
class MulNode extends infixNode{}
class DivNode extends infixNode{}

class NotNode extends ExpNode{
    private ExpNode InnerNode;

    public ExpNode getInnerNode() {
        return InnerNode;
    }

    public void setInnerNode(ExpNode innerNode) {
        InnerNode = innerNode;
    }
}
class PlusNode extends ExpNode{}
class MinusNode extends ExpNode{}
class AndNode extends infixNode{}
class OrNode extends infixNode{}


class EqNode extends infixNode{}
class NeqNode extends infixNode{}
class GtNode extends infixNode{}
class LtNode extends infixNode{}
class LtEqNode extends infixNode{}
class GtEqNode extends infixNode{}

class IntNode extends ExpNode{}
class FloatNode extends ExpNode{}
class StringNode extends ExpNode{}
class BoolNode extends ExpNode{}
class IdentifierNode extends ExpNode{}
class ArrayNode extends ExpNode{}

class AssignNode extends ExpNode{}
class DeclNode extends FuncNode{}




