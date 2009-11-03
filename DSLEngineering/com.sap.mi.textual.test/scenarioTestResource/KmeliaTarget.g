grammar Kmelia_ANTLR3;@header {package org.eclipse.gmt.tcs.injector;}@lexer::header {package org.eclipse.gmt.tcs.injector;}@lexer::members {

	private void newline() {}

	public org.eclipse.gmt.tcs.injector.TCSInjector ei = null;

	public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
		ei.reportError((Exception)e);
	}

	public Token emit() {
		org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken ret = null;

		ret = new org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken(input, type, channel, tokenStartCharIndex, getCharIndex()-1);
		ret.setLine(tokenStartLine);
		ret.setText(text);
	  	ret.setCharPositionInLine(tokenStartCharPositionInLine);
		ret.setEndLine(getLine());
		ret.setEndColumn(getCharPositionInLine());
		emit(ret);

		return ret;
	}

} @members {
 public org.eclipse.gmt.tcs.injector.TCSInjector ei = null;
 
//	public void reportError(RecognitionException ex) {
//		ei.reportError((Exception)ex);
//	}
	
//	public void emitErrorMessage(String s) {
//		ei.reportError(s);
//	}

	public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
		ei.reportError((Exception)e);
	}

	//TODO: what about warnings?
//	public void reportWarning(String s) {
//		ei.reportWarning(s);
//	}
	
 public static void main(String[] args) throws Exception {
						CharStream input = new ANTLRFileStream(args[0]);
 Kmelia_ANTLR3Lexer lex = new 
 Kmelia_ANTLR3Lexer(input);
						CommonTokenStream tokens = new CommonTokenStream(lex);
						tokens.discardTokenType(WS);
						tokens.discardTokenType(COMMENT);
						tokens.discardTokenType(NL);
						
 Kmelia_ANTLR3Parser parser = new 
 Kmelia_ANTLR3Parser(tokens);
						parser.main();
					}
}

main returns[Object ret2] @init {}
	:	((ret=component) EOF)
  {
   ret2=ret;
  }

	;

identifier returns[Object ret2] @init {java.lang.Object ret=null;}
	:	ast=NAME {ret = ast.getText(); ei.setToken((Object)ast);}
  {
   ret2=ret;
  }

	;

stringSymbol returns[Object ret2] @init {java.lang.Object ret=null;}
	:	ast=STRING {ret = ast.getText(); ei.setToken((Object)ast);}
  {
   ret2=ret;
  }

	;

integerSymbol returns[Object ret2] @init {java.lang.Object ret=null;}
	:	ast=INT {ret = Integer.valueOf(ast.getText()); ei.setToken((Object)ast);}
  {
   ret2=ret;
  }

	;

floatSymbol returns[Object ret2] @init {java.lang.Object ret=null;}
	:	ast=FLOAT {ret = Double.valueOf(ast.getText()); ei.setToken((Object)ast);}
  {
   ret2=ret;
  }

	;

component returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Component", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('COMPONENT' temp=identifier {ei.set(ret, "name", temp);} 'INTERFACE' 'provides' COLON LCURLY ((temp=identifier {ei.setRef(ret, "provides", "Service", "name", temp, null, "never", null, false, null);} (((COMA) temp=identifier {ei.setRef(ret, "provides", "Service", "name", temp, null, "never", null, false, null);}))*))? RCURLY 'requires' COLON LCURLY ((temp=identifier {ei.setRef(ret, "requires", "Service", "name", temp, null, "never", null, false, null);} (((COMA) temp=identifier {ei.setRef(ret, "requires", "Service", "name", temp, null, "never", null, false, null);}))*))? RCURLY 'SERVICES' ((temp=service {ei.set(ret, "services", temp);} ((temp=service {ei.set(ret, "services", temp);}))*))? 'END_SERVICES')
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

service returns[Object ret2] @init {}
	:	((ret=externalService| ret=internalService))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

externalService returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("ExternalService", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	((('required') {ei.set(ret, "isRequired", java.lang.Boolean.TRUE);}| ('provided') {ei.set(ret, "isRequired", java.lang.Boolean.FALSE);}) 'external' temp=identifier {ei.set(ret, "name", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

internalService returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("InternalService", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	((('required') {ei.set(ret, "isRequired", java.lang.Boolean.TRUE);}| ('provided') {ei.set(ret, "isRequired", java.lang.Boolean.FALSE);}) temp=identifier {ei.set(ret, "name", temp);} LPAREN ((temp=parameter {ei.set(ret, "parameters", temp);} (((COMA) temp=parameter {ei.set(ret, "parameters", temp);}))*))? RPAREN ((COLON temp=identifier {ei.set(ret, "returnType", temp);}) {}| () {}) ((temp=body {ei.set(ret, "body", temp);}) {}| () {}) 'end')
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

parameter returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Parameter", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "name", temp);} COLON temp=identifier {ei.set(ret, "type", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

body returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Body", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=interface_ {ei.set(ret, "interface", temp);} (('Behavior' temp=behavior {ei.set(ret, "behavior", temp);}) {}| () {}))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

interface_ returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Interface", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('Interface')
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

behavior returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Behavior", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('init' temp=identifier {ei.setRef(ret, "initialState", "State", "name", temp, null, "ifmissing", null, false, "#context.states");} 'final' ((temp=identifier {ei.setRef(ret, "finalStates", "State", "name", temp, null, "ifmissing", null, false, "#context.states");} (((COMA) temp=identifier {ei.setRef(ret, "finalStates", "State", "name", temp, null, "ifmissing", null, false, "#context.states");}))*)) LCURLY ((temp=transition {ei.set(ret, "transitions", temp);} (((COMA) temp=transition {ei.set(ret, "transitions", temp);}))*)) RCURLY)
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

state returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("State", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "name", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

transition returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Transition", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.setRef(ret, "source", "State", "name", temp, null, "ifmissing", null, false, "#context.states");} MINUSMINUS ((temp=action {ei.set(ret, "actions", temp);} (((COMA) temp=action {ei.set(ret, "actions", temp);}))*))? RLARROW temp=identifier {ei.setRef(ret, "target", "State", "name", temp, null, "ifmissing", null, false, "#context.states");})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

action returns[Object ret2] @init {}
	:	((ret=functionCall| ret=communication))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

functionCall returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("FunctionCall", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "name", temp);} LPAREN ((temp=expression {ei.set(ret, "arguments", temp);} (((COMA) temp=expression {ei.set(ret, "arguments", temp);}))*))? RPAREN)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

communication returns[Object ret2] @init {}
	:	(ret=serviceCall)
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

serviceCall returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("ServiceCall", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "channel", temp);} EXCLEXCL temp=identifier {ei.set(ret, "name", temp);} LPAREN RPAREN)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

expression returns[Object ret2] @init {}
	:	(ret=stringExp)
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

stringExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("StringExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "value", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

	
// testLiterals = false;

NL
	:	(	'\r' '\n'
		|	'\n' '\r'	//Improbable
		|	'\r'
		|	'\n'
		)
	{newline();}
	;

WS
	:	(	' '
		|	'\t'
		)
	;

fragment
DIGIT
	:	'0'..'9'
	;

fragment
ALPHA
	:	'a'..'z'
	|	'A'..'Z'
	|	'_'
	//For Unicode compatibility (from 0000 to 00ff)
	|	'\u00C0' .. '\u00D6'
	|	'\u00D8' .. '\u00F6'
	|	'\u00F8' .. '\u00FF'
	;

fragment
SNAME
//	options {
//		testLiterals = true;
//	}
	:	(ALPHA) (ALPHA | DIGIT)*
;

NAME
	:	(
			SNAME
//			s:SNAME {if(s.getType() != SNAME) $setType(s.getType());}
		|	'"'!
			(	ESC
			|	'\n' {newline();}
			|	~('\\'|'\"'|'\n')
			)*
			'"'!
			{setText(ei.unescapeString(getText(), 1));}
		)
	;

INT
	:	(DIGIT)+
//		(('.' DIGIT)=> '.' (DIGIT)+ {$setType(FLOAT);})?
	;

	FLOAT	:	DIGIT+ '.' DIGIT*	;

fragment
ESC
	:	'\\'!
		(	'n' //{setText("\n");}
		|	'r' //{setText("\r");}
		|	't' //{setText("\t");}
		|	'b' //{setText("\b");}
		|	'f' //{setText("\f");}
		|	'"' //{setText("\"");}
		|	'\'' //{setText("\'");}
		|	'\\' //{setText("\\");}
		|	(
				('0'..'3')
				(
//					options {
//						warnWhenFollowAmbig = false;
//					}
				:	('0'..'7')
					(
//						options {
//							warnWhenFollowAmbig = false;
//						}
					:	'0'..'7'
					)?
				)?
			|	('4'..'7')
				(
//					options {
//						warnWhenFollowAmbig = false;
//					}
				:	('0'..'7')
				)?
			)
				{
//					String s = getText();
//					int i;
//					int ret = 0;
//					String ans;
//					for (i=0; i<s.length(); ++i)
//						ret = ret*8 + s.charAt(i) - '0';
//					ans = String.valueOf((char) ret);
//					setText(ans);
				}
		)
	;

STRING
	:	'\''!
		(	ESC
		|	'\n' {newline();}
		|	~('\\'|'\''|'\n')
		)*
		'\''!
			{setText(ei.unescapeString(getText(), 1));}
	;

	

LSQUARE @init {}
	:	'['
  {
   
  }

	;

RSQUARE @init {}
	:	']'
  {
   
  }

	;

EXCL @init {}
	:	'!'
  {
   
  }

	;

EXCLEXCL @init {}
	:	'!!'
  {
   
  }

	;

COMA @init {}
	:	','
  {
   
  }

	;

LPAREN @init {}
	:	'('
  {
   
  }

	;

RPAREN @init {}
	:	')'
  {
   
  }

	;

LCURLY @init {}
	:	'{'
  {
   
  }

	;

RCURLY @init {}
	:	'}'
  {
   
  }

	;

SEMI @init {}
	:	';'
  {
   
  }

	;

COLON @init {}
	:	':'
  {
   
  }

	;

PIPE @init {}
	:	'|'
  {
   
  }

	;

SHARP @init {}
	:	'#'
  {
   
  }

	;

QMARK @init {}
	:	'?'
  {
   
  }

	;

COLONCOLON @init {}
	:	'::'
  {
   
  }

	;

POINT @init {}
	:	'.'
  {
   
  }

	;

MINUSMINUS @init {}
	:	'--'
  {
   
  }

	;

RLARROW @init {}
	:	'-->'
  {
   
  }

	;

RARROW @init {}
	:	'->'
  {
   
  }

	;

MINUS @init {}
	:	'-'
  {
   
  }

	;

STAR @init {}
	:	'*'
  {
   
  }

	;

SLASH @init {}
	:	'/'
  {
   
  }

	;

PLUS @init {}
	:	'+'
  {
   
  }

	;

EQ @init {}
	:	'='
  {
   
  }

	;

GT @init {}
	:	'>'
  {
   
  }

	;

LT @init {}
	:	'<'
  {
   
  }

	;

GE @init {}
	:	'>='
  {
   
  }

	;

LE @init {}
	:	'<='
  {
   
  }

	;

NE @init {}
	:	'<>'
  {
   
  }

	;

LARROW @init {}
	:	'<-'
  {
   
  }

	;

COMMENT @init {}
	:	((('#' (~('\r'| '\n'))*))| (('/*' (options {greedy = false;} : ('\n'| ~ '\n'))* '*/')))
  {
   
  }

	;
