// Generated from C:/Users/Bruger/OneDrive - Aalborg Universitet/Software/SW4/NybCProject/src/NybC.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class NybCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, BOOL=23, IDENT=24, INT=25, 
		FLOAT=26, STRING=27, BOPS=28, UOPS=29, LINE_COMMENT=30, WS=31;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_functionStmt = 2, RULE_beginStmt = 3, 
		RULE_extendedIf = 4, RULE_declareStmt = 5, RULE_assignStmt = 6, RULE_array = 7, 
		RULE_arrayAccess = 8, RULE_callStmt = 9, RULE_ctrlFlowStmt = 10, RULE_expression = 11, 
		RULE_valueExpression = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stmt", "functionStmt", "beginStmt", "extendedIf", "declareStmt", 
			"assignStmt", "array", "arrayAccess", "callStmt", "ctrlFlowStmt", "expression", 
			"valueExpression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'begin'", "'function'", "'('", "'var'", "','", "')'", "'end'", 
			"'if'", "'loop'", "'switch'", "'case'", "':'", "'default'", "'else'", 
			"'else-if'", "'='", "'['", "']'", "'continue'", "'break'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "BOOL", 
			"IDENT", "INT", "FLOAT", "STRING", "BOPS", "UOPS", "LINE_COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "NybC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NybCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NybCVisitor ) return ((NybCVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26);
				stmt();
				}
				}
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 24117284L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public BeginStmtContext beginStmt() {
			return getRuleContext(BeginStmtContext.class,0);
		}
		public DeclareStmtContext declareStmt() {
			return getRuleContext(DeclareStmtContext.class,0);
		}
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public CallStmtContext callStmt() {
			return getRuleContext(CallStmtContext.class,0);
		}
		public CtrlFlowStmtContext ctrlFlowStmt() {
			return getRuleContext(CtrlFlowStmtContext.class,0);
		}
		public FunctionStmtContext functionStmt() {
			return getRuleContext(FunctionStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NybCVisitor ) return ((NybCVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				beginStmt();
				setState(32);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				declareStmt();
				setState(35);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				assignStmt();
				setState(38);
				match(T__0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(40);
				callStmt();
				setState(41);
				match(T__0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(43);
				ctrlFlowStmt();
				setState(44);
				match(T__0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(46);
				functionStmt();
				setState(47);
				match(T__0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionStmtContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(NybCParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(NybCParser.IDENT, i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public FunctionStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NybCVisitor ) return ((NybCVisitor<? extends T>)visitor).visitFunctionStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionStmtContext functionStmt() throws RecognitionException {
		FunctionStmtContext _localctx = new FunctionStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionStmt);
		int _la;
		try {
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				match(T__1);
				setState(52);
				match(T__2);
				setState(53);
				match(IDENT);
				setState(54);
				match(T__3);
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(55);
					match(T__4);
					setState(56);
					match(IDENT);
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__5) {
						{
						{
						setState(57);
						match(T__5);
						setState(58);
						match(T__4);
						setState(59);
						match(IDENT);
						}
						}
						setState(64);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(67);
				match(T__6);
				setState(68);
				match(T__0);
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(69);
					stmt();
					}
					}
					setState(72); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 24117284L) != 0) );
				setState(74);
				match(T__7);
				setState(75);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				match(T__1);
				setState(78);
				match(T__2);
				setState(79);
				match(IDENT);
				setState(80);
				match(T__3);
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(81);
					match(T__4);
					setState(82);
					match(IDENT);
					setState(88);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__5) {
						{
						{
						setState(83);
						match(T__5);
						setState(84);
						match(T__4);
						setState(85);
						match(IDENT);
						}
						}
						setState(90);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(93);
				match(T__6);
				setState(94);
				match(T__0);
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(95);
					stmt();
					}
					}
					setState(98); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 24117284L) != 0) );
				setState(100);
				match(T__7);
				setState(101);
				match(IDENT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BeginStmtContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<ExtendedIfContext> extendedIf() {
			return getRuleContexts(ExtendedIfContext.class);
		}
		public ExtendedIfContext extendedIf(int i) {
			return getRuleContext(ExtendedIfContext.class,i);
		}
		public DeclareStmtContext declareStmt() {
			return getRuleContext(DeclareStmtContext.class,0);
		}
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public BeginStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beginStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NybCVisitor ) return ((NybCVisitor<? extends T>)visitor).visitBeginStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeginStmtContext beginStmt() throws RecognitionException {
		BeginStmtContext _localctx = new BeginStmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_beginStmt);
		int _la;
		try {
			int _alt;
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(T__1);
				setState(106);
				match(T__8);
				setState(107);
				match(T__3);
				setState(108);
				expression(0);
				setState(109);
				match(T__6);
				setState(110);
				match(T__0);
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(111);
					stmt();
					}
					}
					setState(114); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 24117284L) != 0) );
				setState(116);
				match(T__7);
				setState(117);
				match(T__8);
				setState(122);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(118);
						match(T__0);
						setState(119);
						extendedIf();
						}
						} 
					}
					setState(124);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				match(T__1);
				setState(126);
				match(T__9);
				setState(127);
				match(T__3);
				setState(128);
				expression(0);
				setState(129);
				match(T__6);
				setState(130);
				match(T__0);
				setState(132); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(131);
					stmt();
					}
					}
					setState(134); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 24117284L) != 0) );
				setState(136);
				match(T__7);
				setState(137);
				match(T__9);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				match(T__1);
				setState(140);
				match(T__9);
				setState(141);
				match(T__3);
				setState(142);
				declareStmt();
				setState(143);
				match(T__0);
				setState(144);
				expression(0);
				setState(145);
				match(T__0);
				setState(146);
				assignStmt();
				setState(147);
				match(T__6);
				setState(148);
				match(T__0);
				setState(150); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(149);
					stmt();
					}
					}
					setState(152); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 24117284L) != 0) );
				setState(154);
				match(T__7);
				setState(155);
				match(T__9);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(157);
				match(T__1);
				setState(158);
				match(T__9);
				setState(159);
				match(T__0);
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(160);
					stmt();
					}
					}
					setState(163); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 24117284L) != 0) );
				setState(165);
				match(T__7);
				setState(166);
				match(T__9);
				setState(167);
				match(T__3);
				setState(168);
				expression(0);
				setState(169);
				match(T__6);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(171);
				match(T__1);
				setState(172);
				match(T__10);
				setState(173);
				match(T__3);
				setState(174);
				expression(0);
				setState(175);
				match(T__6);
				setState(176);
				match(T__0);
				setState(185); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(177);
					match(T__11);
					setState(178);
					expression(0);
					setState(179);
					match(T__12);
					setState(181); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(180);
						stmt();
						}
						}
						setState(183); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 24117284L) != 0) );
					}
					}
					setState(187); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__11 );
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(189);
					match(T__13);
					setState(190);
					match(T__12);
					setState(192); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(191);
						stmt();
						}
						}
						setState(194); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 24117284L) != 0) );
					}
				}

				setState(198);
				match(T__7);
				setState(199);
				match(T__10);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExtendedIfContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<ExtendedIfContext> extendedIf() {
			return getRuleContexts(ExtendedIfContext.class);
		}
		public ExtendedIfContext extendedIf(int i) {
			return getRuleContext(ExtendedIfContext.class,i);
		}
		public ExtendedIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extendedIf; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NybCVisitor ) return ((NybCVisitor<? extends T>)visitor).visitExtendedIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtendedIfContext extendedIf() throws RecognitionException {
		ExtendedIfContext _localctx = new ExtendedIfContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_extendedIf);
		int _la;
		try {
			int _alt;
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				match(T__1);
				setState(204);
				match(T__14);
				setState(205);
				match(T__0);
				setState(207); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(206);
					stmt();
					}
					}
					setState(209); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 24117284L) != 0) );
				setState(211);
				match(T__7);
				setState(212);
				match(T__14);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				match(T__1);
				setState(215);
				match(T__15);
				setState(216);
				match(T__3);
				setState(217);
				expression(0);
				setState(218);
				match(T__6);
				setState(219);
				match(T__0);
				setState(221); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(220);
					stmt();
					}
					}
					setState(223); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 24117284L) != 0) );
				setState(225);
				match(T__7);
				setState(226);
				match(T__15);
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(227);
						match(T__0);
						setState(228);
						extendedIf();
						}
						} 
					}
					setState(233);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclareStmtContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NybCParser.IDENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public DeclareStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declareStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NybCVisitor ) return ((NybCVisitor<? extends T>)visitor).visitDeclareStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclareStmtContext declareStmt() throws RecognitionException {
		DeclareStmtContext _localctx = new DeclareStmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declareStmt);
		try {
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				match(T__4);
				setState(237);
				match(IDENT);
				setState(238);
				match(T__16);
				setState(239);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				match(T__4);
				setState(241);
				match(IDENT);
				setState(242);
				match(T__16);
				setState(243);
				array();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(244);
				match(T__4);
				setState(245);
				match(IDENT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignStmtContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NybCParser.IDENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NybCVisitor ) return ((NybCVisitor<? extends T>)visitor).visitAssignStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignStmt);
		try {
			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				match(IDENT);
				setState(249);
				match(T__16);
				setState(250);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				match(IDENT);
				setState(252);
				match(T__16);
				setState(253);
				array();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(254);
				arrayAccess();
				setState(255);
				match(T__16);
				setState(256);
				expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NybCVisitor ) return ((NybCVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(T__17);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 796917776L) != 0)) {
				{
				{
				setState(261);
				expression(0);
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(262);
					match(T__5);
					setState(263);
					expression(0);
					}
					}
					setState(268);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(274);
			match(T__18);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAccessContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(NybCParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(NybCParser.IDENT, i);
		}
		public TerminalNode INT() { return getToken(NybCParser.INT, 0); }
		public ArrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NybCVisitor ) return ((NybCVisitor<? extends T>)visitor).visitArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAccessContext arrayAccess() throws RecognitionException {
		ArrayAccessContext _localctx = new ArrayAccessContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arrayAccess);
		try {
			setState(284);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(276);
				match(IDENT);
				setState(277);
				match(T__17);
				setState(278);
				match(INT);
				setState(279);
				match(T__18);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(280);
				match(IDENT);
				setState(281);
				match(T__17);
				setState(282);
				match(IDENT);
				setState(283);
				match(T__18);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallStmtContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NybCParser.IDENT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CallStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NybCVisitor ) return ((NybCVisitor<? extends T>)visitor).visitCallStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallStmtContext callStmt() throws RecognitionException {
		CallStmtContext _localctx = new CallStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_callStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(IDENT);
			setState(287);
			match(T__3);
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 796917776L) != 0)) {
				{
				setState(288);
				expression(0);
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(289);
					match(T__5);
					setState(290);
					expression(0);
					}
					}
					setState(295);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(298);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CtrlFlowStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CtrlFlowStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctrlFlowStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NybCVisitor ) return ((NybCVisitor<? extends T>)visitor).visitCtrlFlowStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CtrlFlowStmtContext ctrlFlowStmt() throws RecognitionException {
		CtrlFlowStmtContext _localctx = new CtrlFlowStmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ctrlFlowStmt);
		try {
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(300);
				match(T__19);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(301);
				match(T__20);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(302);
				match(T__21);
				setState(303);
				expression(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(304);
				match(T__21);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode UOPS() { return getToken(NybCParser.UOPS, 0); }
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public CallStmtContext callStmt() {
			return getRuleContext(CallStmtContext.class,0);
		}
		public TerminalNode BOPS() { return getToken(NybCParser.BOPS, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NybCVisitor ) return ((NybCVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(308);
				match(T__3);
				setState(309);
				expression(0);
				setState(310);
				match(T__6);
				}
				break;
			case 2:
				{
				setState(312);
				match(UOPS);
				setState(313);
				expression(4);
				}
				break;
			case 3:
				{
				setState(314);
				valueExpression();
				}
				break;
			case 4:
				{
				setState(315);
				arrayAccess();
				}
				break;
			case 5:
				{
				setState(316);
				callStmt();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(324);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(319);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(320);
					match(BOPS);
					setState(321);
					expression(6);
					}
					} 
				}
				setState(326);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueExpressionContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NybCParser.IDENT, 0); }
		public TerminalNode INT() { return getToken(NybCParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(NybCParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(NybCParser.STRING, 0); }
		public TerminalNode BOOL() { return getToken(NybCParser.BOOL, 0); }
		public ValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NybCVisitor ) return ((NybCVisitor<? extends T>)visitor).visitValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueExpressionContext valueExpression() throws RecognitionException {
		ValueExpressionContext _localctx = new ValueExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_valueExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 260046848L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u014a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0001\u0000\u0004\u0000\u001c\b\u0000\u000b\u0000\f\u0000"+
		"\u001d\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u00012\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002=\b\u0002\n\u0002\f\u0002@\t\u0002\u0003\u0002B\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0004\u0002G\b\u0002\u000b\u0002\f\u0002H\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002W\b\u0002\n\u0002\f\u0002Z\t\u0002\u0003\u0002\\\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0004\u0002a\b\u0002\u000b\u0002\f\u0002b\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002h\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004"+
		"\u0003q\b\u0003\u000b\u0003\f\u0003r\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u0003y\b\u0003\n\u0003\f\u0003|\t\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0004\u0003\u0085\b\u0003\u000b\u0003\f\u0003\u0086\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0004\u0003\u0097\b\u0003\u000b\u0003\f\u0003\u0098\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0004\u0003\u00a2\b\u0003\u000b\u0003\f\u0003\u00a3\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0004\u0003\u00b6\b\u0003\u000b\u0003\f"+
		"\u0003\u00b7\u0004\u0003\u00ba\b\u0003\u000b\u0003\f\u0003\u00bb\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0004\u0003\u00c1\b\u0003\u000b\u0003\f"+
		"\u0003\u00c2\u0003\u0003\u00c5\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003\u00ca\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0004\u0004\u00d0\b\u0004\u000b\u0004\f\u0004\u00d1\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0004\u0004\u00de\b\u0004\u000b\u0004\f"+
		"\u0004\u00df\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"\u00e6\b\u0004\n\u0004\f\u0004\u00e9\t\u0004\u0003\u0004\u00eb\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00f7\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0103\b\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0109\b\u0007"+
		"\n\u0007\f\u0007\u010c\t\u0007\u0005\u0007\u010e\b\u0007\n\u0007\f\u0007"+
		"\u0111\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u011d\b\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\t\u0124\b\t\n\t\f\t\u0127\t\t\u0003\t\u0129\b"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0132"+
		"\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u013e"+
		"\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0143\b\u000b"+
		"\n\u000b\f\u000b\u0146\t\u000b\u0001\f\u0001\f\u0001\f\u0000\u0001\u0016"+
		"\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000"+
		"\u0001\u0001\u0000\u0017\u001b\u016b\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u00021\u0001\u0000\u0000\u0000\u0004g\u0001\u0000\u0000\u0000\u0006\u00c9"+
		"\u0001\u0000\u0000\u0000\b\u00ea\u0001\u0000\u0000\u0000\n\u00f6\u0001"+
		"\u0000\u0000\u0000\f\u0102\u0001\u0000\u0000\u0000\u000e\u0104\u0001\u0000"+
		"\u0000\u0000\u0010\u011c\u0001\u0000\u0000\u0000\u0012\u011e\u0001\u0000"+
		"\u0000\u0000\u0014\u0131\u0001\u0000\u0000\u0000\u0016\u013d\u0001\u0000"+
		"\u0000\u0000\u0018\u0147\u0001\u0000\u0000\u0000\u001a\u001c\u0003\u0002"+
		"\u0001\u0000\u001b\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000"+
		"\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000"+
		"\u0000\u0000\u001e\u0001\u0001\u0000\u0000\u0000\u001f \u0003\u0006\u0003"+
		"\u0000 !\u0005\u0001\u0000\u0000!2\u0001\u0000\u0000\u0000\"#\u0003\n"+
		"\u0005\u0000#$\u0005\u0001\u0000\u0000$2\u0001\u0000\u0000\u0000%&\u0003"+
		"\f\u0006\u0000&\'\u0005\u0001\u0000\u0000\'2\u0001\u0000\u0000\u0000("+
		")\u0003\u0012\t\u0000)*\u0005\u0001\u0000\u0000*2\u0001\u0000\u0000\u0000"+
		"+,\u0003\u0014\n\u0000,-\u0005\u0001\u0000\u0000-2\u0001\u0000\u0000\u0000"+
		"./\u0003\u0004\u0002\u0000/0\u0005\u0001\u0000\u000002\u0001\u0000\u0000"+
		"\u00001\u001f\u0001\u0000\u0000\u00001\"\u0001\u0000\u0000\u00001%\u0001"+
		"\u0000\u0000\u00001(\u0001\u0000\u0000\u00001+\u0001\u0000\u0000\u0000"+
		"1.\u0001\u0000\u0000\u00002\u0003\u0001\u0000\u0000\u000034\u0005\u0002"+
		"\u0000\u000045\u0005\u0003\u0000\u000056\u0005\u0018\u0000\u00006A\u0005"+
		"\u0004\u0000\u000078\u0005\u0005\u0000\u00008>\u0005\u0018\u0000\u0000"+
		"9:\u0005\u0006\u0000\u0000:;\u0005\u0005\u0000\u0000;=\u0005\u0018\u0000"+
		"\u0000<9\u0001\u0000\u0000\u0000=@\u0001\u0000\u0000\u0000><\u0001\u0000"+
		"\u0000\u0000>?\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001"+
		"\u0000\u0000\u0000A7\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000"+
		"BC\u0001\u0000\u0000\u0000CD\u0005\u0007\u0000\u0000DF\u0005\u0001\u0000"+
		"\u0000EG\u0003\u0002\u0001\u0000FE\u0001\u0000\u0000\u0000GH\u0001\u0000"+
		"\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0001"+
		"\u0000\u0000\u0000JK\u0005\b\u0000\u0000KL\u0005\u0003\u0000\u0000Lh\u0001"+
		"\u0000\u0000\u0000MN\u0005\u0002\u0000\u0000NO\u0005\u0003\u0000\u0000"+
		"OP\u0005\u0018\u0000\u0000P[\u0005\u0004\u0000\u0000QR\u0005\u0005\u0000"+
		"\u0000RX\u0005\u0018\u0000\u0000ST\u0005\u0006\u0000\u0000TU\u0005\u0005"+
		"\u0000\u0000UW\u0005\u0018\u0000\u0000VS\u0001\u0000\u0000\u0000WZ\u0001"+
		"\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000"+
		"Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000[Q\u0001\u0000\u0000"+
		"\u0000[\\\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0005\u0007"+
		"\u0000\u0000^`\u0005\u0001\u0000\u0000_a\u0003\u0002\u0001\u0000`_\u0001"+
		"\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000"+
		"bc\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000de\u0005\b\u0000\u0000"+
		"ef\u0005\u0018\u0000\u0000fh\u0001\u0000\u0000\u0000g3\u0001\u0000\u0000"+
		"\u0000gM\u0001\u0000\u0000\u0000h\u0005\u0001\u0000\u0000\u0000ij\u0005"+
		"\u0002\u0000\u0000jk\u0005\t\u0000\u0000kl\u0005\u0004\u0000\u0000lm\u0003"+
		"\u0016\u000b\u0000mn\u0005\u0007\u0000\u0000np\u0005\u0001\u0000\u0000"+
		"oq\u0003\u0002\u0001\u0000po\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000"+
		"\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0001\u0000"+
		"\u0000\u0000tu\u0005\b\u0000\u0000uz\u0005\t\u0000\u0000vw\u0005\u0001"+
		"\u0000\u0000wy\u0003\b\u0004\u0000xv\u0001\u0000\u0000\u0000y|\u0001\u0000"+
		"\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{\u00ca"+
		"\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000}~\u0005\u0002\u0000"+
		"\u0000~\u007f\u0005\n\u0000\u0000\u007f\u0080\u0005\u0004\u0000\u0000"+
		"\u0080\u0081\u0003\u0016\u000b\u0000\u0081\u0082\u0005\u0007\u0000\u0000"+
		"\u0082\u0084\u0005\u0001\u0000\u0000\u0083\u0085\u0003\u0002\u0001\u0000"+
		"\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000"+
		"\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000"+
		"\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0089\u0005\b\u0000\u0000\u0089"+
		"\u008a\u0005\n\u0000\u0000\u008a\u00ca\u0001\u0000\u0000\u0000\u008b\u008c"+
		"\u0005\u0002\u0000\u0000\u008c\u008d\u0005\n\u0000\u0000\u008d\u008e\u0005"+
		"\u0004\u0000\u0000\u008e\u008f\u0003\n\u0005\u0000\u008f\u0090\u0005\u0001"+
		"\u0000\u0000\u0090\u0091\u0003\u0016\u000b\u0000\u0091\u0092\u0005\u0001"+
		"\u0000\u0000\u0092\u0093\u0003\f\u0006\u0000\u0093\u0094\u0005\u0007\u0000"+
		"\u0000\u0094\u0096\u0005\u0001\u0000\u0000\u0095\u0097\u0003\u0002\u0001"+
		"\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000"+
		"\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000"+
		"\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009b\u0005\b\u0000\u0000"+
		"\u009b\u009c\u0005\n\u0000\u0000\u009c\u00ca\u0001\u0000\u0000\u0000\u009d"+
		"\u009e\u0005\u0002\u0000\u0000\u009e\u009f\u0005\n\u0000\u0000\u009f\u00a1"+
		"\u0005\u0001\u0000\u0000\u00a0\u00a2\u0003\u0002\u0001\u0000\u00a1\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\b\u0000\u0000\u00a6\u00a7\u0005"+
		"\n\u0000\u0000\u00a7\u00a8\u0005\u0004\u0000\u0000\u00a8\u00a9\u0003\u0016"+
		"\u000b\u0000\u00a9\u00aa\u0005\u0007\u0000\u0000\u00aa\u00ca\u0001\u0000"+
		"\u0000\u0000\u00ab\u00ac\u0005\u0002\u0000\u0000\u00ac\u00ad\u0005\u000b"+
		"\u0000\u0000\u00ad\u00ae\u0005\u0004\u0000\u0000\u00ae\u00af\u0003\u0016"+
		"\u000b\u0000\u00af\u00b0\u0005\u0007\u0000\u0000\u00b0\u00b9\u0005\u0001"+
		"\u0000\u0000\u00b1\u00b2\u0005\f\u0000\u0000\u00b2\u00b3\u0003\u0016\u000b"+
		"\u0000\u00b3\u00b5\u0005\r\u0000\u0000\u00b4\u00b6\u0003\u0002\u0001\u0000"+
		"\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000"+
		"\u00b8\u00ba\u0001\u0000\u0000\u0000\u00b9\u00b1\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000"+
		"\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\u00c4\u0001\u0000\u0000\u0000"+
		"\u00bd\u00be\u0005\u000e\u0000\u0000\u00be\u00c0\u0005\r\u0000\u0000\u00bf"+
		"\u00c1\u0003\u0002\u0001\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c5\u0001\u0000\u0000\u0000\u00c4"+
		"\u00bd\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005\b\u0000\u0000\u00c7\u00c8"+
		"\u0005\u000b\u0000\u0000\u00c8\u00ca\u0001\u0000\u0000\u0000\u00c9i\u0001"+
		"\u0000\u0000\u0000\u00c9}\u0001\u0000\u0000\u0000\u00c9\u008b\u0001\u0000"+
		"\u0000\u0000\u00c9\u009d\u0001\u0000\u0000\u0000\u00c9\u00ab\u0001\u0000"+
		"\u0000\u0000\u00ca\u0007\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005\u0002"+
		"\u0000\u0000\u00cc\u00cd\u0005\u000f\u0000\u0000\u00cd\u00cf\u0005\u0001"+
		"\u0000\u0000\u00ce\u00d0\u0003\u0002\u0001\u0000\u00cf\u00ce\u0001\u0000"+
		"\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000"+
		"\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d4\u0005\b\u0000\u0000\u00d4\u00d5\u0005\u000f\u0000"+
		"\u0000\u00d5\u00eb\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005\u0002\u0000"+
		"\u0000\u00d7\u00d8\u0005\u0010\u0000\u0000\u00d8\u00d9\u0005\u0004\u0000"+
		"\u0000\u00d9\u00da\u0003\u0016\u000b\u0000\u00da\u00db\u0005\u0007\u0000"+
		"\u0000\u00db\u00dd\u0005\u0001\u0000\u0000\u00dc\u00de\u0003\u0002\u0001"+
		"\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000"+
		"\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000"+
		"\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005\b\u0000\u0000"+
		"\u00e2\u00e7\u0005\u0010\u0000\u0000\u00e3\u00e4\u0005\u0001\u0000\u0000"+
		"\u00e4\u00e6\u0003\b\u0004\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e9\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e8\u0001\u0000\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000\u0000\u00e9"+
		"\u00e7\u0001\u0000\u0000\u0000\u00ea\u00cb\u0001\u0000\u0000\u0000\u00ea"+
		"\u00d6\u0001\u0000\u0000\u0000\u00eb\t\u0001\u0000\u0000\u0000\u00ec\u00ed"+
		"\u0005\u0005\u0000\u0000\u00ed\u00ee\u0005\u0018\u0000\u0000\u00ee\u00ef"+
		"\u0005\u0011\u0000\u0000\u00ef\u00f7\u0003\u0016\u000b\u0000\u00f0\u00f1"+
		"\u0005\u0005\u0000\u0000\u00f1\u00f2\u0005\u0018\u0000\u0000\u00f2\u00f3"+
		"\u0005\u0011\u0000\u0000\u00f3\u00f7\u0003\u000e\u0007\u0000\u00f4\u00f5"+
		"\u0005\u0005\u0000\u0000\u00f5\u00f7\u0005\u0018\u0000\u0000\u00f6\u00ec"+
		"\u0001\u0000\u0000\u0000\u00f6\u00f0\u0001\u0000\u0000\u0000\u00f6\u00f4"+
		"\u0001\u0000\u0000\u0000\u00f7\u000b\u0001\u0000\u0000\u0000\u00f8\u00f9"+
		"\u0005\u0018\u0000\u0000\u00f9\u00fa\u0005\u0011\u0000\u0000\u00fa\u0103"+
		"\u0003\u0016\u000b\u0000\u00fb\u00fc\u0005\u0018\u0000\u0000\u00fc\u00fd"+
		"\u0005\u0011\u0000\u0000\u00fd\u0103\u0003\u000e\u0007\u0000\u00fe\u00ff"+
		"\u0003\u0010\b\u0000\u00ff\u0100\u0005\u0011\u0000\u0000\u0100\u0101\u0003"+
		"\u0016\u000b\u0000\u0101\u0103\u0001\u0000\u0000\u0000\u0102\u00f8\u0001"+
		"\u0000\u0000\u0000\u0102\u00fb\u0001\u0000\u0000\u0000\u0102\u00fe\u0001"+
		"\u0000\u0000\u0000\u0103\r\u0001\u0000\u0000\u0000\u0104\u010f\u0005\u0012"+
		"\u0000\u0000\u0105\u010a\u0003\u0016\u000b\u0000\u0106\u0107\u0005\u0006"+
		"\u0000\u0000\u0107\u0109\u0003\u0016\u000b\u0000\u0108\u0106\u0001\u0000"+
		"\u0000\u0000\u0109\u010c\u0001\u0000\u0000\u0000\u010a\u0108\u0001\u0000"+
		"\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u010e\u0001\u0000"+
		"\u0000\u0000\u010c\u010a\u0001\u0000\u0000\u0000\u010d\u0105\u0001\u0000"+
		"\u0000\u0000\u010e\u0111\u0001\u0000\u0000\u0000\u010f\u010d\u0001\u0000"+
		"\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u0112\u0001\u0000"+
		"\u0000\u0000\u0111\u010f\u0001\u0000\u0000\u0000\u0112\u0113\u0005\u0013"+
		"\u0000\u0000\u0113\u000f\u0001\u0000\u0000\u0000\u0114\u0115\u0005\u0018"+
		"\u0000\u0000\u0115\u0116\u0005\u0012\u0000\u0000\u0116\u0117\u0005\u0019"+
		"\u0000\u0000\u0117\u011d\u0005\u0013\u0000\u0000\u0118\u0119\u0005\u0018"+
		"\u0000\u0000\u0119\u011a\u0005\u0012\u0000\u0000\u011a\u011b\u0005\u0018"+
		"\u0000\u0000\u011b\u011d\u0005\u0013\u0000\u0000\u011c\u0114\u0001\u0000"+
		"\u0000\u0000\u011c\u0118\u0001\u0000\u0000\u0000\u011d\u0011\u0001\u0000"+
		"\u0000\u0000\u011e\u011f\u0005\u0018\u0000\u0000\u011f\u0128\u0005\u0004"+
		"\u0000\u0000\u0120\u0125\u0003\u0016\u000b\u0000\u0121\u0122\u0005\u0006"+
		"\u0000\u0000\u0122\u0124\u0003\u0016\u000b\u0000\u0123\u0121\u0001\u0000"+
		"\u0000\u0000\u0124\u0127\u0001\u0000\u0000\u0000\u0125\u0123\u0001\u0000"+
		"\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126\u0129\u0001\u0000"+
		"\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0128\u0120\u0001\u0000"+
		"\u0000\u0000\u0128\u0129\u0001\u0000\u0000\u0000\u0129\u012a\u0001\u0000"+
		"\u0000\u0000\u012a\u012b\u0005\u0007\u0000\u0000\u012b\u0013\u0001\u0000"+
		"\u0000\u0000\u012c\u0132\u0005\u0014\u0000\u0000\u012d\u0132\u0005\u0015"+
		"\u0000\u0000\u012e\u012f\u0005\u0016\u0000\u0000\u012f\u0132\u0003\u0016"+
		"\u000b\u0000\u0130\u0132\u0005\u0016\u0000\u0000\u0131\u012c\u0001\u0000"+
		"\u0000\u0000\u0131\u012d\u0001\u0000\u0000\u0000\u0131\u012e\u0001\u0000"+
		"\u0000\u0000\u0131\u0130\u0001\u0000\u0000\u0000\u0132\u0015\u0001\u0000"+
		"\u0000\u0000\u0133\u0134\u0006\u000b\uffff\uffff\u0000\u0134\u0135\u0005"+
		"\u0004\u0000\u0000\u0135\u0136\u0003\u0016\u000b\u0000\u0136\u0137\u0005"+
		"\u0007\u0000\u0000\u0137\u013e\u0001\u0000\u0000\u0000\u0138\u0139\u0005"+
		"\u001d\u0000\u0000\u0139\u013e\u0003\u0016\u000b\u0004\u013a\u013e\u0003"+
		"\u0018\f\u0000\u013b\u013e\u0003\u0010\b\u0000\u013c\u013e\u0003\u0012"+
		"\t\u0000\u013d\u0133\u0001\u0000\u0000\u0000\u013d\u0138\u0001\u0000\u0000"+
		"\u0000\u013d\u013a\u0001\u0000\u0000\u0000\u013d\u013b\u0001\u0000\u0000"+
		"\u0000\u013d\u013c\u0001\u0000\u0000\u0000\u013e\u0144\u0001\u0000\u0000"+
		"\u0000\u013f\u0140\n\u0005\u0000\u0000\u0140\u0141\u0005\u001c\u0000\u0000"+
		"\u0141\u0143\u0003\u0016\u000b\u0006\u0142\u013f\u0001\u0000\u0000\u0000"+
		"\u0143\u0146\u0001\u0000\u0000\u0000\u0144\u0142\u0001\u0000\u0000\u0000"+
		"\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0017\u0001\u0000\u0000\u0000"+
		"\u0146\u0144\u0001\u0000\u0000\u0000\u0147\u0148\u0007\u0000\u0000\u0000"+
		"\u0148\u0019\u0001\u0000\u0000\u0000!\u001d1>AHX[bgrz\u0086\u0098\u00a3"+
		"\u00b7\u00bb\u00c2\u00c4\u00c9\u00d1\u00df\u00e7\u00ea\u00f6\u0102\u010a"+
		"\u010f\u011c\u0125\u0128\u0131\u013d\u0144";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}