// Generated from NybC.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NybCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NybCVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NybCParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(NybCParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#programList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramList(NybCParser.ProgramListContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#functionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionList(NybCParser.FunctionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#stmtList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtList(NybCParser.StmtListContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#functionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionStmt(NybCParser.FunctionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#declareFuncPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareFuncPara(NybCParser.DeclareFuncParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(NybCParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#beginStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeginStmt(NybCParser.BeginStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#extendedIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtendedIf(NybCParser.ExtendedIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#switchExpList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchExpList(NybCParser.SwitchExpListContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#switchExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchExp(NybCParser.SwitchExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#switchCond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchCond(NybCParser.SwitchCondContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#condtion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondtion(NybCParser.CondtionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#declareStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareStmt(NybCParser.DeclareStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#assignStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(NybCParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(NybCParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#arrayList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayList(NybCParser.ArrayListContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(NybCParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#callStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallStmt(NybCParser.CallStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#callFuncPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallFuncPara(NybCParser.CallFuncParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#ctrlFlowStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtrlFlowStmt(NybCParser.CtrlFlowStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(NybCParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(NybCParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#eqExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpression(NybCParser.EqExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#relExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExpression(NybCParser.RelExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#relOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelOps(NybCParser.RelOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#plusExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusExpression(NybCParser.PlusExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#multExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpression(NybCParser.MultExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#notExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(NybCParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#parrentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParrentExpression(NybCParser.ParrentExpressionContext ctx);
}