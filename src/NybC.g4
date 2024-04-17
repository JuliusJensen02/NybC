grammar NybC;

program: (stmt)+;

stmt: beginStmt';'
    | declareStmt';'
    | assignStmt';'
    | callStmt';'
    | ctrlFlowStmt';'
    | functionStmt';'
    ;

functionStmt : 'begin' 'function' IDENT '('('var' IDENT (',' 'var' IDENT)*)?')' ';' (stmt)+ 'end' 'function'
             | 'begin' 'function' IDENT '('('var' IDENT (',' 'var' IDENT)*)?')' ';' (stmt)+ 'end' IDENT
             ;

beginStmt: 'begin' 'if''(' expression')'';' (stmt)+ 'end' 'if'(';' extendedIf)*
         | 'begin' 'loop''(' expression')'';' (stmt)+ 'end' 'loop'
         | 'begin' 'loop''(' declareStmt';' expression';' assignStmt')'';' (stmt)+ 'end' 'loop'
         | 'begin' 'loop'';' (stmt)+ 'end' 'loop''(' expression ')'
         | 'begin' 'switch''(' expression ')'';' ('case' expression':' (stmt)+)+('default'':' (stmt)+)?  'end' 'switch'
         ;

extendedIf: 'begin' 'else'';' (stmt)+ 'end' 'else'
          | 'begin' 'else-if''(' expression')'';' (stmt)+ 'end' 'else-if'(';' extendedIf)*
          ;

declareStmt: 'var' IDENT '=' expression
           | 'var' IDENT '=' array
           | 'var' IDENT
           ;

assignStmt: IDENT '=' expression
          | IDENT '=' array
          | arrayAccess '=' expression
          ;

array: '['(expression(',' expression)*)*']'
     ;

arrayAccess: IDENT'['INT']'
           | IDENT'['IDENT']'
           ;

callStmt: IDENT'('(expression(',' expression)*)?')'
        ;

ctrlFlowStmt: 'continue'
            | 'break'
            | 'return' expression
            | 'return'
            ;

expression: '(' expression ')'
            | expression BOPS expression
            | UOPS expression
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

BOOL: ( 'true' | 'false' );
IDENT: ([_]|[a-zA-Z])([_]|[0-9]|[a-zA-Z])*;
INT: ([0]|[1-9][0-9]*);
FLOAT: ([0-9]+'.'[0-9]+);
STRING: (["]~(["]|[\n])*["]);
BOPS: ('+' | '-' | '*' | '/' | '<' | '>' | '<=' | '>=' | '||' | '&&' | '==' | '!='); UOPS: ('!' | '+' | '-');
LINE_COMMENT: '//' ~[\r\n]* -> skip;
WS: [ \t\r\n]+ -> skip;






