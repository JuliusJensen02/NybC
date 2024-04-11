// Generated from C:/Users/Julius/Desktop/NybC/src/NybC.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NybCParser}.
 */
public interface NybCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NybCParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(NybCParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(NybCParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#programList}.
	 * @param ctx the parse tree
	 */
	void enterProgramList(NybCParser.ProgramListContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#programList}.
	 * @param ctx the parse tree
	 */
	void exitProgramList(NybCParser.ProgramListContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#functionList}.
	 * @param ctx the parse tree
	 */
	void enterFunctionList(NybCParser.FunctionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#functionList}.
	 * @param ctx the parse tree
	 */
	void exitFunctionList(NybCParser.FunctionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void enterStmtList(NybCParser.StmtListContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void exitStmtList(NybCParser.StmtListContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#functionStmt}.
	 * @param ctx the parse tree
	 */
	void enterFunctionStmt(NybCParser.FunctionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#functionStmt}.
	 * @param ctx the parse tree
	 */
	void exitFunctionStmt(NybCParser.FunctionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#declareFuncPara}.
	 * @param ctx the parse tree
	 */
	void enterDeclareFuncPara(NybCParser.DeclareFuncParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#declareFuncPara}.
	 * @param ctx the parse tree
	 */
	void exitDeclareFuncPara(NybCParser.DeclareFuncParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(NybCParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(NybCParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#beginStmt}.
	 * @param ctx the parse tree
	 */
	void enterBeginStmt(NybCParser.BeginStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#beginStmt}.
	 * @param ctx the parse tree
	 */
	void exitBeginStmt(NybCParser.BeginStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#extendedIf}.
	 * @param ctx the parse tree
	 */
	void enterExtendedIf(NybCParser.ExtendedIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#extendedIf}.
	 * @param ctx the parse tree
	 */
	void exitExtendedIf(NybCParser.ExtendedIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#switchExpList}.
	 * @param ctx the parse tree
	 */
	void enterSwitchExpList(NybCParser.SwitchExpListContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#switchExpList}.
	 * @param ctx the parse tree
	 */
	void exitSwitchExpList(NybCParser.SwitchExpListContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#switchExp}.
	 * @param ctx the parse tree
	 */
	void enterSwitchExp(NybCParser.SwitchExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#switchExp}.
	 * @param ctx the parse tree
	 */
	void exitSwitchExp(NybCParser.SwitchExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#switchCond}.
	 * @param ctx the parse tree
	 */
	void enterSwitchCond(NybCParser.SwitchCondContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#switchCond}.
	 * @param ctx the parse tree
	 */
	void exitSwitchCond(NybCParser.SwitchCondContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#condtion}.
	 * @param ctx the parse tree
	 */
	void enterCondtion(NybCParser.CondtionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#condtion}.
	 * @param ctx the parse tree
	 */
	void exitCondtion(NybCParser.CondtionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#declareStmt}.
	 * @param ctx the parse tree
	 */
	void enterDeclareStmt(NybCParser.DeclareStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#declareStmt}.
	 * @param ctx the parse tree
	 */
	void exitDeclareStmt(NybCParser.DeclareStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(NybCParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(NybCParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(NybCParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(NybCParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(NybCParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(NybCParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#callStmt}.
	 * @param ctx the parse tree
	 */
	void enterCallStmt(NybCParser.CallStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#callStmt}.
	 * @param ctx the parse tree
	 */
	void exitCallStmt(NybCParser.CallStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#callFuncPara}.
	 * @param ctx the parse tree
	 */
	void enterCallFuncPara(NybCParser.CallFuncParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#callFuncPara}.
	 * @param ctx the parse tree
	 */
	void exitCallFuncPara(NybCParser.CallFuncParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#ctrlFlowStmt}.
	 * @param ctx the parse tree
	 */
	void enterCtrlFlowStmt(NybCParser.CtrlFlowStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#ctrlFlowStmt}.
	 * @param ctx the parse tree
	 */
	void exitCtrlFlowStmt(NybCParser.CtrlFlowStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(NybCParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(NybCParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NybCParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterValueExpression(NybCParser.ValueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NybCParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitValueExpression(NybCParser.ValueExpressionContext ctx);
}