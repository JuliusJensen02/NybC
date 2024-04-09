grammar NybC;

program: programList;

programList :  (functionList| stmtList)+;

functionList : (functionStmt ';')+;


stmtList : (stmt';')+;


functionStmt : 'begin' 'function' IDENT '('declareFuncPara')' ';' stmtList 'end' 'function'
             | 'begin' 'function' IDENT '('declareFuncPara')' ';' stmtList 'end' IDENT
             ;


declareFuncPara: ('var' IDENT (',' declareFuncPara)*)?;

stmt: beginStmt
    | declareStmt
    | assignStmt
    | callStmt
    | ctrlFlowStmt
    ;

beginStmt: 'begin' 'if' condtion';' stmtList 'end' 'if'
         | 'begin' 'if' condtion';' stmtList 'end' 'if'';' extendedIf
         | 'begin' 'loop' condtion';' stmtList 'end' 'loop'
         | 'begin' 'loop' declareStmt';' expression';' assignStmt';' stmtList 'end' 'loop'
         | 'begin' 'loop'';' stmtList';' 'end' 'loop' condtion
         | 'begin' 'switch' switchCond';' switchExpList  'end' 'switch'
         ;

extendedIf: 'begin' 'else'';' stmtList 'end' 'else'
          | 'begin' 'else-if' condtion';' stmtList 'end' 'else-if'
          | 'begin' 'else-if' condtion';' stmtList 'end' 'else-if'';' extendedIf
          ;

switchExpList:switchExp switchExpList
             | ('default'':' stmtList)?
             ;

switchExp: 'case' expression':' stmtList
         ;

switchCond: condtion
          | expression
          ;

condtion: expression
        | callStmt
        ;

declareStmt: 'var' assignStmt
           | 'var' IDENT
           ;

assignStmt: IDENT '=' expression
          | IDENT '=' callStmt
          | IDENT '=' array
          | arrayAccess '=' expression
          ;

array: '[]'
     | '['arrayList']'
     ;

arrayList: (expression(',' arrayList)*)+
         ;

arrayAccess: IDENT'['INT']'
           | IDENT'['IDENT']'
           ;

callStmt: IDENT'('callFuncPara')'
        ;

callFuncPara: (expression(',' callFuncPara)*)?
            ;

ctrlFlowStmt: 'continue'
            | 'break'
            | 'return' expression
            | 'return'
            ;

expression: expression '||' andExpression
          | andExpression
          ;

andExpression: andExpression '&&' eqExpression
             | eqExpression
             ;

eqExpression: eqExpression '==' relExpression
            | eqExpression '!=' relExpression
            | relExpression
            ;

relExpression: relExpression relOps plusExpression
             | plusExpression
             ;

relOps: '<'
      | '>'
      | '<='
      | '>='
      ;

plusExpression: plusExpression '+' multExpression
              | plusExpression '-' multExpression
              | multExpression
              ;

multExpression: multExpression '*' notExpression
              | multExpression '/' notExpression
              | notExpression
              ;

notExpression: '!'parrentExpression
             | parrentExpression
             ;

parrentExpression: '('expression')'
                 | valueExpression
                 | arrayAccess
                 | callStmt
                 ;

valueExpression: IDENT
                | INT
                | FLOAT
                | STRING
                | BOOL
                ;

IDENT: ([_]|[a-zA-Z])([_]|[0-9]|[a-zA-Z])*;
INT: ([0]|[1-9][0-9]*);
FLOAT: ([0-9]+.[0-9]+);
STRING: (["]~(["]|[\n])*["]);
BOOL: ('true'|'false');
LINE_COMMENT: '//' ~[\r\n]* -> skip;
WS: [ \t\r\n]+ -> skip;






