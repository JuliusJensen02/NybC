// Generated from C:/Users/Bruger/OneDrive - Aalborg Universitet/Software/SW4/NybCProject/src/NybC.g4 by ANTLR 4.13.1
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
	 * Visit a parse tree produced by {@link NybCParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(NybCParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link NybCParser#functionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionStmt(NybCParser.FunctionStmtContext ctx);
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
	 * Visit a parse tree produced by {@link NybCParser#valueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpression(NybCParser.ValueExpressionContext ctx);
}