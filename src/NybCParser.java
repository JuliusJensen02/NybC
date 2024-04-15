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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, IDENT=23, INT=24, FLOAT=25, 
		STRING=26, BOPS=27, UOPS=28, BOOL=29, LINE_COMMENT=30, WS=31;
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
			null, "';'", "'begin'", "'function'", "'('", "','", "')'", "'end'", "'if'", 
			"'loop'", "'switch'", "'case'", "':'", "'default'", "'else'", "'else-if'", 
			"'var'", "'='", "'['", "']'", "'continue'", "'break'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "IDENT", 
			"INT", "FLOAT", "STRING", "BOPS", "UOPS", "BOOL", "LINE_COMMENT", "WS"
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
		public List<FunctionStmtContext> functionStmt() {
			return getRuleContexts(FunctionStmtContext.class);
		}
		public FunctionStmtContext functionStmt(int i) {
			return getRuleContext(FunctionStmtContext.class,i);
		}
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
			setState(28); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(28);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(26);
					functionStmt();
					}
					break;
				case 2:
					{
					setState(27);
					stmt();
					}
					break;
				}
				}
				setState(30); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15794180L) != 0) );
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
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				beginStmt();
				setState(33);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				declareStmt();
				setState(36);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				assignStmt();
				setState(39);
				match(T__0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				callStmt();
				setState(42);
				match(T__0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(44);
				ctrlFlowStmt();
				setState(45);
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
		public List<DeclareStmtContext> declareStmt() {
			return getRuleContexts(DeclareStmtContext.class);
		}
		public DeclareStmtContext declareStmt(int i) {
			return getRuleContext(DeclareStmtContext.class,i);
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
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(T__1);
				setState(50);
				match(T__2);
				setState(51);
				match(IDENT);
				setState(52);
				match(T__3);
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__15) {
					{
					setState(53);
					declareStmt();
					setState(58);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(54);
						match(T__4);
						setState(55);
						declareStmt();
						}
						}
						setState(60);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(63);
				match(T__5);
				setState(64);
				match(T__0);
				setState(66); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(65);
					stmt();
					}
					}
					setState(68); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15794180L) != 0) );
				setState(70);
				match(T__6);
				setState(71);
				match(T__2);
				setState(72);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(T__1);
				setState(75);
				match(T__2);
				setState(76);
				match(IDENT);
				setState(77);
				match(T__3);
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__15) {
					{
					setState(78);
					declareStmt();
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(79);
						match(T__4);
						setState(80);
						declareStmt();
						}
						}
						setState(85);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(88);
				match(T__5);
				setState(89);
				match(T__0);
				setState(91); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(90);
					stmt();
					}
					}
					setState(93); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15794180L) != 0) );
				setState(95);
				match(T__6);
				setState(96);
				match(IDENT);
				setState(97);
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
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(T__1);
				setState(102);
				match(T__7);
				setState(103);
				match(T__3);
				setState(104);
				expression(0);
				setState(105);
				match(T__5);
				setState(106);
				match(T__0);
				setState(108); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(107);
					stmt();
					}
					}
					setState(110); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15794180L) != 0) );
				setState(112);
				match(T__6);
				setState(113);
				match(T__7);
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(114);
						match(T__0);
						setState(115);
						extendedIf();
						}
						} 
					}
					setState(120);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				match(T__1);
				setState(122);
				match(T__8);
				setState(123);
				match(T__3);
				setState(124);
				expression(0);
				setState(125);
				match(T__5);
				setState(126);
				match(T__0);
				setState(128); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(127);
					stmt();
					}
					}
					setState(130); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15794180L) != 0) );
				setState(132);
				match(T__6);
				setState(133);
				match(T__8);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(135);
				match(T__1);
				setState(136);
				match(T__8);
				setState(137);
				match(T__3);
				setState(138);
				declareStmt();
				setState(139);
				match(T__0);
				setState(140);
				expression(0);
				setState(141);
				match(T__0);
				setState(142);
				assignStmt();
				setState(143);
				match(T__5);
				setState(144);
				match(T__0);
				setState(146); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(145);
					stmt();
					}
					}
					setState(148); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15794180L) != 0) );
				setState(150);
				match(T__6);
				setState(151);
				match(T__8);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(153);
				match(T__1);
				setState(154);
				match(T__8);
				setState(155);
				match(T__0);
				setState(157); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(156);
					stmt();
					}
					}
					setState(159); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15794180L) != 0) );
				setState(161);
				match(T__6);
				setState(162);
				match(T__8);
				setState(163);
				match(T__3);
				setState(164);
				expression(0);
				setState(165);
				match(T__5);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(167);
				match(T__1);
				setState(168);
				match(T__9);
				setState(169);
				match(T__3);
				setState(170);
				expression(0);
				setState(171);
				match(T__5);
				setState(172);
				match(T__0);
				setState(181); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(173);
					match(T__10);
					setState(174);
					expression(0);
					setState(175);
					match(T__11);
					setState(177); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(176);
						stmt();
						}
						}
						setState(179); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15794180L) != 0) );
					}
					}
					setState(183); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__10 );
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(185);
					match(T__12);
					setState(186);
					match(T__11);
					setState(188); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(187);
						stmt();
						}
						}
						setState(190); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15794180L) != 0) );
					}
				}

				setState(194);
				match(T__6);
				setState(195);
				match(T__9);
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
			setState(230);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				match(T__1);
				setState(200);
				match(T__13);
				setState(201);
				match(T__0);
				setState(203); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(202);
					stmt();
					}
					}
					setState(205); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15794180L) != 0) );
				setState(207);
				match(T__6);
				setState(208);
				match(T__13);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				match(T__1);
				setState(211);
				match(T__14);
				setState(212);
				match(T__3);
				setState(213);
				expression(0);
				setState(214);
				match(T__5);
				setState(215);
				match(T__0);
				setState(217); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(216);
					stmt();
					}
					}
					setState(219); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15794180L) != 0) );
				setState(221);
				match(T__6);
				setState(222);
				match(T__14);
				setState(227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(223);
						match(T__0);
						setState(224);
						extendedIf();
						}
						} 
					}
					setState(229);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				match(T__15);
				setState(233);
				match(IDENT);
				setState(234);
				match(T__16);
				setState(235);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				match(T__15);
				setState(237);
				match(IDENT);
				setState(238);
				match(T__16);
				setState(239);
				array();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(240);
				match(T__15);
				setState(241);
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
			setState(254);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				match(IDENT);
				setState(245);
				match(T__16);
				setState(246);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				match(IDENT);
				setState(248);
				match(T__16);
				setState(249);
				array();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(250);
				arrayAccess();
				setState(251);
				match(T__16);
				setState(252);
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
			setState(256);
			match(T__17);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 931135504L) != 0)) {
				{
				{
				setState(257);
				expression(0);
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(258);
					match(T__4);
					setState(259);
					expression(0);
					}
					}
					setState(264);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(270);
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
			setState(280);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				match(IDENT);
				setState(273);
				match(T__17);
				setState(274);
				match(INT);
				setState(275);
				match(T__18);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(276);
				match(IDENT);
				setState(277);
				match(T__17);
				setState(278);
				match(IDENT);
				setState(279);
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
			setState(282);
			match(IDENT);
			setState(283);
			match(T__3);
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 931135504L) != 0)) {
				{
				setState(284);
				expression(0);
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(285);
					match(T__4);
					setState(286);
					expression(0);
					}
					}
					setState(291);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(294);
			match(T__5);
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
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				match(T__19);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				match(T__20);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(298);
				match(T__21);
				setState(299);
				expression(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(300);
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
			setState(313);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(304);
				match(T__3);
				setState(305);
				expression(0);
				setState(306);
				match(T__5);
				}
				break;
			case 2:
				{
				setState(308);
				match(UOPS);
				setState(309);
				expression(5);
				}
				break;
			case 3:
				{
				setState(310);
				valueExpression();
				}
				break;
			case 4:
				{
				setState(311);
				arrayAccess();
				}
				break;
			case 5:
				{
				setState(312);
				callStmt();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(320);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(315);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(316);
					match(BOPS);
					setState(317);
					expression(5);
					}
					} 
				}
				setState(322);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
			setState(323);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 662700032L) != 0)) ) {
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
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u0146\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0004\u0000\u001d\b\u0000\u000b"+
		"\u0000\f\u0000\u001e\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00010\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0005\u00029\b\u0002\n\u0002\f\u0002<\t\u0002\u0003"+
		"\u0002>\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0004\u0002C\b\u0002"+
		"\u000b\u0002\f\u0002D\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002R\b\u0002\n\u0002\f\u0002U\t\u0002\u0003\u0002"+
		"W\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0004\u0002\\\b\u0002\u000b"+
		"\u0002\f\u0002]\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002d\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0004\u0003m\b\u0003\u000b\u0003\f\u0003"+
		"n\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003u\b\u0003"+
		"\n\u0003\f\u0003x\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003\u0081\b\u0003\u000b\u0003"+
		"\f\u0003\u0082\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003\u0093\b\u0003\u000b\u0003"+
		"\f\u0003\u0094\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0004\u0003\u009e\b\u0003\u000b\u0003\f\u0003"+
		"\u009f\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003\u00b2"+
		"\b\u0003\u000b\u0003\f\u0003\u00b3\u0004\u0003\u00b6\b\u0003\u000b\u0003"+
		"\f\u0003\u00b7\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003\u00bd\b"+
		"\u0003\u000b\u0003\f\u0003\u00be\u0003\u0003\u00c1\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003\u00c6\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0004\u0004\u00cc\b\u0004\u000b\u0004\f\u0004"+
		"\u00cd\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004\u00da"+
		"\b\u0004\u000b\u0004\f\u0004\u00db\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004\u00e2\b\u0004\n\u0004\f\u0004\u00e5\t\u0004\u0003"+
		"\u0004\u00e7\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005\u00f3\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\u00ff\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005"+
		"\u0007\u0105\b\u0007\n\u0007\f\u0007\u0108\t\u0007\u0005\u0007\u010a\b"+
		"\u0007\n\u0007\f\u0007\u010d\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0119\b\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0120\b\t\n\t\f\t\u0123\t\t"+
		"\u0003\t\u0125\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u012e\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u013a\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u013f"+
		"\b\u000b\n\u000b\f\u000b\u0142\t\u000b\u0001\f\u0001\f\u0001\f\u0000\u0001"+
		"\u0016\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u0000\u0001\u0002\u0000\u0017\u001a\u001d\u001d\u0167\u0000\u001c\u0001"+
		"\u0000\u0000\u0000\u0002/\u0001\u0000\u0000\u0000\u0004c\u0001\u0000\u0000"+
		"\u0000\u0006\u00c5\u0001\u0000\u0000\u0000\b\u00e6\u0001\u0000\u0000\u0000"+
		"\n\u00f2\u0001\u0000\u0000\u0000\f\u00fe\u0001\u0000\u0000\u0000\u000e"+
		"\u0100\u0001\u0000\u0000\u0000\u0010\u0118\u0001\u0000\u0000\u0000\u0012"+
		"\u011a\u0001\u0000\u0000\u0000\u0014\u012d\u0001\u0000\u0000\u0000\u0016"+
		"\u0139\u0001\u0000\u0000\u0000\u0018\u0143\u0001\u0000\u0000\u0000\u001a"+
		"\u001d\u0003\u0004\u0002\u0000\u001b\u001d\u0003\u0002\u0001\u0000\u001c"+
		"\u001a\u0001\u0000\u0000\u0000\u001c\u001b\u0001\u0000\u0000\u0000\u001d"+
		"\u001e\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001e"+
		"\u001f\u0001\u0000\u0000\u0000\u001f\u0001\u0001\u0000\u0000\u0000 !\u0003"+
		"\u0006\u0003\u0000!\"\u0005\u0001\u0000\u0000\"0\u0001\u0000\u0000\u0000"+
		"#$\u0003\n\u0005\u0000$%\u0005\u0001\u0000\u0000%0\u0001\u0000\u0000\u0000"+
		"&\'\u0003\f\u0006\u0000\'(\u0005\u0001\u0000\u0000(0\u0001\u0000\u0000"+
		"\u0000)*\u0003\u0012\t\u0000*+\u0005\u0001\u0000\u0000+0\u0001\u0000\u0000"+
		"\u0000,-\u0003\u0014\n\u0000-.\u0005\u0001\u0000\u0000.0\u0001\u0000\u0000"+
		"\u0000/ \u0001\u0000\u0000\u0000/#\u0001\u0000\u0000\u0000/&\u0001\u0000"+
		"\u0000\u0000/)\u0001\u0000\u0000\u0000/,\u0001\u0000\u0000\u00000\u0003"+
		"\u0001\u0000\u0000\u000012\u0005\u0002\u0000\u000023\u0005\u0003\u0000"+
		"\u000034\u0005\u0017\u0000\u00004=\u0005\u0004\u0000\u00005:\u0003\n\u0005"+
		"\u000067\u0005\u0005\u0000\u000079\u0003\n\u0005\u000086\u0001\u0000\u0000"+
		"\u00009<\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000"+
		"\u0000\u0000;>\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000=5\u0001"+
		"\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000"+
		"?@\u0005\u0006\u0000\u0000@B\u0005\u0001\u0000\u0000AC\u0003\u0002\u0001"+
		"\u0000BA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DB\u0001\u0000"+
		"\u0000\u0000DE\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FG\u0005"+
		"\u0007\u0000\u0000GH\u0005\u0003\u0000\u0000HI\u0005\u0001\u0000\u0000"+
		"Id\u0001\u0000\u0000\u0000JK\u0005\u0002\u0000\u0000KL\u0005\u0003\u0000"+
		"\u0000LM\u0005\u0017\u0000\u0000MV\u0005\u0004\u0000\u0000NS\u0003\n\u0005"+
		"\u0000OP\u0005\u0005\u0000\u0000PR\u0003\n\u0005\u0000QO\u0001\u0000\u0000"+
		"\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000"+
		"\u0000\u0000TW\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000VN\u0001"+
		"\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000"+
		"XY\u0005\u0006\u0000\u0000Y[\u0005\u0001\u0000\u0000Z\\\u0003\u0002\u0001"+
		"\u0000[Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000][\u0001\u0000"+
		"\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0005"+
		"\u0007\u0000\u0000`a\u0005\u0017\u0000\u0000ab\u0005\u0001\u0000\u0000"+
		"bd\u0001\u0000\u0000\u0000c1\u0001\u0000\u0000\u0000cJ\u0001\u0000\u0000"+
		"\u0000d\u0005\u0001\u0000\u0000\u0000ef\u0005\u0002\u0000\u0000fg\u0005"+
		"\b\u0000\u0000gh\u0005\u0004\u0000\u0000hi\u0003\u0016\u000b\u0000ij\u0005"+
		"\u0006\u0000\u0000jl\u0005\u0001\u0000\u0000km\u0003\u0002\u0001\u0000"+
		"lk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000"+
		"\u0000no\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pq\u0005\u0007"+
		"\u0000\u0000qv\u0005\b\u0000\u0000rs\u0005\u0001\u0000\u0000su\u0003\b"+
		"\u0004\u0000tr\u0001\u0000\u0000\u0000ux\u0001\u0000\u0000\u0000vt\u0001"+
		"\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000w\u00c6\u0001\u0000\u0000"+
		"\u0000xv\u0001\u0000\u0000\u0000yz\u0005\u0002\u0000\u0000z{\u0005\t\u0000"+
		"\u0000{|\u0005\u0004\u0000\u0000|}\u0003\u0016\u000b\u0000}~\u0005\u0006"+
		"\u0000\u0000~\u0080\u0005\u0001\u0000\u0000\u007f\u0081\u0003\u0002\u0001"+
		"\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000"+
		"\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000"+
		"\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0085\u0005\u0007\u0000"+
		"\u0000\u0085\u0086\u0005\t\u0000\u0000\u0086\u00c6\u0001\u0000\u0000\u0000"+
		"\u0087\u0088\u0005\u0002\u0000\u0000\u0088\u0089\u0005\t\u0000\u0000\u0089"+
		"\u008a\u0005\u0004\u0000\u0000\u008a\u008b\u0003\n\u0005\u0000\u008b\u008c"+
		"\u0005\u0001\u0000\u0000\u008c\u008d\u0003\u0016\u000b\u0000\u008d\u008e"+
		"\u0005\u0001\u0000\u0000\u008e\u008f\u0003\f\u0006\u0000\u008f\u0090\u0005"+
		"\u0006\u0000\u0000\u0090\u0092\u0005\u0001\u0000\u0000\u0091\u0093\u0003"+
		"\u0002\u0001\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001"+
		"\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001"+
		"\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0097\u0005"+
		"\u0007\u0000\u0000\u0097\u0098\u0005\t\u0000\u0000\u0098\u00c6\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\u0005\u0002\u0000\u0000\u009a\u009b\u0005\t\u0000"+
		"\u0000\u009b\u009d\u0005\u0001\u0000\u0000\u009c\u009e\u0003\u0002\u0001"+
		"\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000"+
		"\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005\u0007\u0000"+
		"\u0000\u00a2\u00a3\u0005\t\u0000\u0000\u00a3\u00a4\u0005\u0004\u0000\u0000"+
		"\u00a4\u00a5\u0003\u0016\u000b\u0000\u00a5\u00a6\u0005\u0006\u0000\u0000"+
		"\u00a6\u00c6\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\u0002\u0000\u0000"+
		"\u00a8\u00a9\u0005\n\u0000\u0000\u00a9\u00aa\u0005\u0004\u0000\u0000\u00aa"+
		"\u00ab\u0003\u0016\u000b\u0000\u00ab\u00ac\u0005\u0006\u0000\u0000\u00ac"+
		"\u00b5\u0005\u0001\u0000\u0000\u00ad\u00ae\u0005\u000b\u0000\u0000\u00ae"+
		"\u00af\u0003\u0016\u000b\u0000\u00af\u00b1\u0005\f\u0000\u0000\u00b0\u00b2"+
		"\u0003\u0002\u0001\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b6\u0001\u0000\u0000\u0000\u00b5\u00ad"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00c0"+
		"\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005\r\u0000\u0000\u00ba\u00bc\u0005"+
		"\f\u0000\u0000\u00bb\u00bd\u0003\u0002\u0001\u0000\u00bc\u00bb\u0001\u0000"+
		"\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00bc\u0001\u0000"+
		"\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c1\u0001\u0000"+
		"\u0000\u0000\u00c0\u00b9\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005\u0007"+
		"\u0000\u0000\u00c3\u00c4\u0005\n\u0000\u0000\u00c4\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c5e\u0001\u0000\u0000\u0000\u00c5y\u0001\u0000\u0000\u0000\u00c5"+
		"\u0087\u0001\u0000\u0000\u0000\u00c5\u0099\u0001\u0000\u0000\u0000\u00c5"+
		"\u00a7\u0001\u0000\u0000\u0000\u00c6\u0007\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c8\u0005\u0002\u0000\u0000\u00c8\u00c9\u0005\u000e\u0000\u0000\u00c9"+
		"\u00cb\u0005\u0001\u0000\u0000\u00ca\u00cc\u0003\u0002\u0001\u0000\u00cb"+
		"\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd"+
		"\u00cb\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005\u0007\u0000\u0000\u00d0"+
		"\u00d1\u0005\u000e\u0000\u0000\u00d1\u00e7\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d3\u0005\u0002\u0000\u0000\u00d3\u00d4\u0005\u000f\u0000\u0000\u00d4"+
		"\u00d5\u0005\u0004\u0000\u0000\u00d5\u00d6\u0003\u0016\u000b\u0000\u00d6"+
		"\u00d7\u0005\u0006\u0000\u0000\u00d7\u00d9\u0005\u0001\u0000\u0000\u00d8"+
		"\u00da\u0003\u0002\u0001\u0000\u00d9\u00d8\u0001\u0000\u0000\u0000\u00da"+
		"\u00db\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00db"+
		"\u00dc\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd"+
		"\u00de\u0005\u0007\u0000\u0000\u00de\u00e3\u0005\u000f\u0000\u0000\u00df"+
		"\u00e0\u0005\u0001\u0000\u0000\u00e0\u00e2\u0003\b\u0004\u0000\u00e1\u00df"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e5\u0001\u0000\u0000\u0000\u00e3\u00e1"+
		"\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u00e7"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e6\u00c7"+
		"\u0001\u0000\u0000\u0000\u00e6\u00d2\u0001\u0000\u0000\u0000\u00e7\t\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e9\u0005\u0010\u0000\u0000\u00e9\u00ea\u0005"+
		"\u0017\u0000\u0000\u00ea\u00eb\u0005\u0011\u0000\u0000\u00eb\u00f3\u0003"+
		"\u0016\u000b\u0000\u00ec\u00ed\u0005\u0010\u0000\u0000\u00ed\u00ee\u0005"+
		"\u0017\u0000\u0000\u00ee\u00ef\u0005\u0011\u0000\u0000\u00ef\u00f3\u0003"+
		"\u000e\u0007\u0000\u00f0\u00f1\u0005\u0010\u0000\u0000\u00f1\u00f3\u0005"+
		"\u0017\u0000\u0000\u00f2\u00e8\u0001\u0000\u0000\u0000\u00f2\u00ec\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f3\u000b\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f5\u0005\u0017\u0000\u0000\u00f5\u00f6\u0005"+
		"\u0011\u0000\u0000\u00f6\u00ff\u0003\u0016\u000b\u0000\u00f7\u00f8\u0005"+
		"\u0017\u0000\u0000\u00f8\u00f9\u0005\u0011\u0000\u0000\u00f9\u00ff\u0003"+
		"\u000e\u0007\u0000\u00fa\u00fb\u0003\u0010\b\u0000\u00fb\u00fc\u0005\u0011"+
		"\u0000\u0000\u00fc\u00fd\u0003\u0016\u000b\u0000\u00fd\u00ff\u0001\u0000"+
		"\u0000\u0000\u00fe\u00f4\u0001\u0000\u0000\u0000\u00fe\u00f7\u0001\u0000"+
		"\u0000\u0000\u00fe\u00fa\u0001\u0000\u0000\u0000\u00ff\r\u0001\u0000\u0000"+
		"\u0000\u0100\u010b\u0005\u0012\u0000\u0000\u0101\u0106\u0003\u0016\u000b"+
		"\u0000\u0102\u0103\u0005\u0005\u0000\u0000\u0103\u0105\u0003\u0016\u000b"+
		"\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0105\u0108\u0001\u0000\u0000"+
		"\u0000\u0106\u0104\u0001\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000"+
		"\u0000\u0107\u010a\u0001\u0000\u0000\u0000\u0108\u0106\u0001\u0000\u0000"+
		"\u0000\u0109\u0101\u0001\u0000\u0000\u0000\u010a\u010d\u0001\u0000\u0000"+
		"\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000"+
		"\u0000\u010c\u010e\u0001\u0000\u0000\u0000\u010d\u010b\u0001\u0000\u0000"+
		"\u0000\u010e\u010f\u0005\u0013\u0000\u0000\u010f\u000f\u0001\u0000\u0000"+
		"\u0000\u0110\u0111\u0005\u0017\u0000\u0000\u0111\u0112\u0005\u0012\u0000"+
		"\u0000\u0112\u0113\u0005\u0018\u0000\u0000\u0113\u0119\u0005\u0013\u0000"+
		"\u0000\u0114\u0115\u0005\u0017\u0000\u0000\u0115\u0116\u0005\u0012\u0000"+
		"\u0000\u0116\u0117\u0005\u0017\u0000\u0000\u0117\u0119\u0005\u0013\u0000"+
		"\u0000\u0118\u0110\u0001\u0000\u0000\u0000\u0118\u0114\u0001\u0000\u0000"+
		"\u0000\u0119\u0011\u0001\u0000\u0000\u0000\u011a\u011b\u0005\u0017\u0000"+
		"\u0000\u011b\u0124\u0005\u0004\u0000\u0000\u011c\u0121\u0003\u0016\u000b"+
		"\u0000\u011d\u011e\u0005\u0005\u0000\u0000\u011e\u0120\u0003\u0016\u000b"+
		"\u0000\u011f\u011d\u0001\u0000\u0000\u0000\u0120\u0123\u0001\u0000\u0000"+
		"\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0121\u0122\u0001\u0000\u0000"+
		"\u0000\u0122\u0125\u0001\u0000\u0000\u0000\u0123\u0121\u0001\u0000\u0000"+
		"\u0000\u0124\u011c\u0001\u0000\u0000\u0000\u0124\u0125\u0001\u0000\u0000"+
		"\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126\u0127\u0005\u0006\u0000"+
		"\u0000\u0127\u0013\u0001\u0000\u0000\u0000\u0128\u012e\u0005\u0014\u0000"+
		"\u0000\u0129\u012e\u0005\u0015\u0000\u0000\u012a\u012b\u0005\u0016\u0000"+
		"\u0000\u012b\u012e\u0003\u0016\u000b\u0000\u012c\u012e\u0005\u0016\u0000"+
		"\u0000\u012d\u0128\u0001\u0000\u0000\u0000\u012d\u0129\u0001\u0000\u0000"+
		"\u0000\u012d\u012a\u0001\u0000\u0000\u0000\u012d\u012c\u0001\u0000\u0000"+
		"\u0000\u012e\u0015\u0001\u0000\u0000\u0000\u012f\u0130\u0006\u000b\uffff"+
		"\uffff\u0000\u0130\u0131\u0005\u0004\u0000\u0000\u0131\u0132\u0003\u0016"+
		"\u000b\u0000\u0132\u0133\u0005\u0006\u0000\u0000\u0133\u013a\u0001\u0000"+
		"\u0000\u0000\u0134\u0135\u0005\u001c\u0000\u0000\u0135\u013a\u0003\u0016"+
		"\u000b\u0005\u0136\u013a\u0003\u0018\f\u0000\u0137\u013a\u0003\u0010\b"+
		"\u0000\u0138\u013a\u0003\u0012\t\u0000\u0139\u012f\u0001\u0000\u0000\u0000"+
		"\u0139\u0134\u0001\u0000\u0000\u0000\u0139\u0136\u0001\u0000\u0000\u0000"+
		"\u0139\u0137\u0001\u0000\u0000\u0000\u0139\u0138\u0001\u0000\u0000\u0000"+
		"\u013a\u0140\u0001\u0000\u0000\u0000\u013b\u013c\n\u0004\u0000\u0000\u013c"+
		"\u013d\u0005\u001b\u0000\u0000\u013d\u013f\u0003\u0016\u000b\u0005\u013e"+
		"\u013b\u0001\u0000\u0000\u0000\u013f\u0142\u0001\u0000\u0000\u0000\u0140"+
		"\u013e\u0001\u0000\u0000\u0000\u0140\u0141\u0001\u0000\u0000\u0000\u0141"+
		"\u0017\u0001\u0000\u0000\u0000\u0142\u0140\u0001\u0000\u0000\u0000\u0143"+
		"\u0144\u0007\u0000\u0000\u0000\u0144\u0019\u0001\u0000\u0000\u0000\"\u001c"+
		"\u001e/:=DSV]cnv\u0082\u0094\u009f\u00b3\u00b7\u00be\u00c0\u00c5\u00cd"+
		"\u00db\u00e3\u00e6\u00f2\u00fe\u0106\u010b\u0118\u0121\u0124\u012d\u0139"+
		"\u0140";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}