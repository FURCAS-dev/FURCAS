grammar LOTOS_ANTLR3;options {
 backtrack = true;

}@header {package org.eclipse.gmt.tcs.injector;}@lexer::header {package org.eclipse.gmt.tcs.injector;}@lexer::members {

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
 LOTOS_ANTLR3Lexer lex = new 
 LOTOS_ANTLR3Lexer(input);
						CommonTokenStream tokens = new CommonTokenStream(lex);
						tokens.discardTokenType(WS);
						tokens.discardTokenType(COMMENT);
						tokens.discardTokenType(NL);
						
 LOTOS_ANTLR3Parser parser = new 
 LOTOS_ANTLR3Parser(tokens);
						parser.main();
					}
}

main returns[Object ret2] @init {}
	:	((ret=specification) EOF)
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

identifierOrKeyword returns[Object ret2] @init {java.lang.Object ret=null;}
	:	(ast=NAME {ret = ast.getText(); ei.setToken((Object)ast);}| 'specification' {ret = "specification";}| 'exit' {ret = "exit";}| 'noexit' {ret = "noexit";}| 'behaviour' {ret = "behaviour";}| 'endspec' {ret = "endspec";}| 'where' {ret = "where";}| 'process' {ret = "process";}| 'endproc' {ret = "endproc";}| 'let' {ret = "let";}| 'in' {ret = "in";}| 'choice' {ret = "choice";}| 'hide' {ret = "hide";}| 'true' {ret = "true";}| 'false' {ret = "false";}| 'library' {ret = "library";}| 'endlib' {ret = "endlib";}| 'type' {ret = "type";}| 'is' {ret = "is";}| 'sorts' {ret = "sorts";}| 'opns' {ret = "opns";}| 'eqns' {ret = "eqns";}| 'endtype' {ret = "endtype";}| 'forall' {ret = "forall";}| 'ofsort' {ret = "ofsort";}| 'of' {ret = "of";}| 'eq' {ret = "eq";}| 'neq' {ret = "neq";}| 'and' {ret = "and";}| 'or' {ret = "or";})
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

specification returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Specification", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('specification' temp=identifier {ei.set(ret, "name", temp);} ((LSQUARE ((temp=identifier {ei.set(ret, "gates", temp);} (((COMA) temp=identifier {ei.set(ret, "gates", temp);}))*))? RSQUARE) {}| () {}) COLON (('exit') {ei.set(ret, "isExit", java.lang.Boolean.TRUE);}| ('noexit') {ei.set(ret, "isExit", java.lang.Boolean.FALSE);}) ((((temp=type {ei.set(ret, "types", temp);} ((temp=type {ei.set(ret, "types", temp);}))*))?)) 'behaviour' ((((temp=definition {ei.set(ret, "definition", temp);}) {}| () {}))) 'endspec')
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

definition returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Definition", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(((temp=behaviour {ei.set(ret, "behaviour", temp);})) (('where' ((((temp=typeOrProcessDeclaration {ei.set(ret, "declarations", temp);} ((temp=typeOrProcessDeclaration {ei.set(ret, "declarations", temp);}))*))?))) {}| () {}))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

typeOrProcessDeclaration returns[Object ret2] @init {}
	:	((ret=process| ret=type))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

process returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Process", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('process' temp=identifier {ei.set(ret, "name", temp);} ((LSQUARE ((temp=identifier {ei.set(ret, "gates", temp);} (((COMA) temp=identifier {ei.set(ret, "gates", temp);}))*))? RSQUARE) {}| () {}) ((LPAREN ((temp=variableDeclarations {ei.set(ret, "variables", temp);} (((COMA) temp=variableDeclarations {ei.set(ret, "variables", temp);}))*))? RPAREN) {}| () {}) COLON (('exit') {ei.set(ret, "isExit", java.lang.Boolean.TRUE);}| ('noexit') {ei.set(ret, "isExit", java.lang.Boolean.FALSE);}) COLONEQ temp=definition {ei.set(ret, "definition", temp);} 'endproc')
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

behaviour returns[Object ret2] @init {}
	:	(ret=behaviour_priority_3| ret=let| ret=choice| ret=hide)
  {
   ret2=ret;
  }

	;

let returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Let", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('let' temp=variableDeclarations {ei.set(ret, "variables", temp);} EQ temp=value {ei.set(ret, "value", temp);} 'in' ((temp=behaviour {ei.set(ret, "behaviour", temp);})))
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

choice returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Choice", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('choice' temp=variableDeclarations {ei.set(ret, "variables", temp);} LSQUARERSQUARE ((temp=behaviour {ei.set(ret, "behaviour", temp);})))
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

hide returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Hide", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('hide' ((temp=identifier {ei.set(ret, "gates", temp);} (((COMA) temp=identifier {ei.set(ret, "gates", temp);}))*))? 'in' ((temp=behaviour {ei.set(ret, "behaviour", temp);})))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

processCall returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("ProcessCall", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "name", temp);} LSQUARE ((temp=identifier {ei.set(ret, "gates", temp);} (((COMA) temp=identifier {ei.set(ret, "gates", temp);}))*))? RSQUARE ((LPAREN ((temp=value {ei.set(ret, "arguments", temp);} (((COMA) temp=value {ei.set(ret, "arguments", temp);}))*))? RPAREN) {}| () {}))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

simpleParallel[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("SimpleParallel", false, false) : null;}
	:
  {
   // discard operator name
   ei.set(ret, "left", left);
   // post actions performed in calling rule (i.e., priority_<n>)
   ei.leaveContext(false);
   ret2=ret;
  }

	;

gatedParallel[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("GatedParallel", false, false) : null;}
	:	(((temp=identifier {ei.set(ret, "gates", temp);} (((COMA) temp=identifier {ei.set(ret, "gates", temp);}))*))? RSQUAREPIPE)
  {
   // discard operator name
   ei.set(ret, "left", left);
   // post actions performed in calling rule (i.e., priority_<n>)
   ei.leaveContext(false);
   ret2=ret;
  }

	;

guardedBehaviour[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("GuardedBehaviour", false, false) : null;}
	:	(LSQUARE temp=guardExpression {ei.set(ret, "guard", temp);} RSQUARE)
  {
   // discard operator name
   ei.set(ret, "behaviour", left);
   // post actions performed in calling rule (i.e., priority_<n>)
   ei.leaveContext(false);
   ret2=ret;
  }

	;

actionBehaviour[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("ActionBehaviour", true, false) : null;}
	:	(temp=action {ei.set(ret, "action", temp);})
  {
   // discard operator name
   ei.set(ret, "behaviour", left);
   // post actions performed in calling rule (i.e., priority_<n>)
   ei.leaveContext(true);
   ret2=ret;
  }

	;

alternative[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Alternative", false, false) : null;}
	:
  {
   // discard operator name
   ei.set(ret, "left", left);
   // post actions performed in calling rule (i.e., priority_<n>)
   ei.leaveContext(false);
   ret2=ret;
  }

	;

action returns[Object ret2] @init {}
	:	(ret=gateAction)
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

gateAction returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("GateAction", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "gate", temp);} ((((temp=communication {ei.set(ret, "communications", temp);} ((temp=communication {ei.set(ret, "communications", temp);}))*)) ((LSQUARE temp=guardExpression {ei.set(ret, "guard", temp);} RSQUARE) {}| () {})) {}| () {}))
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

communication returns[Object ret2] @init {}
	:	((ret=inComm| ret=outComm))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

inComm returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("InComm", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(QMARK temp=variableDeclarations {ei.set(ret, "declarations", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

outComm returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OutComm", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(EXCL temp=value {ei.set(ret, "value", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

guardExpression returns[Object ret2] @init {}
	:	((ret=equalityTestGuardExp| ret=booleanGuardExp))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

equalityTestGuardExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("EqualityTestGuardExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=value {ei.set(ret, "left", temp);} EQ temp=value {ei.set(ret, "right", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

booleanGuardExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("BooleanGuardExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=value {ei.set(ret, "value", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

value returns[Object ret2] @init {}
	:	ret=value_priority_3
  {
   ret2=ret;
  }

	;

variable returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Variable", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.setRef(ret, "declaration", "Declaration", "name", temp, null, "never", null, false, null);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

operationCall returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OperationCall", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "operationName", temp);} LPAREN ((temp=value {ei.set(ret, "arguments", temp);} (((COMA) temp=value {ei.set(ret, "arguments", temp);}))*))? RPAREN)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

integerVal returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("IntegerVal", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=integerSymbol {ei.set(ret, "value", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

booleanVal returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("BooleanVal", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	((('true') {ei.set(ret, "value", java.lang.Boolean.TRUE);}| ('false') {ei.set(ret, "value", java.lang.Boolean.FALSE);}))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

castVal[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("CastVal", false, false) : null;}
	:	(temp=identifier {ei.set(ret, "toType", temp);})
  {
   // discard operator name
   ei.set(ret, "value", left);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ei.leaveContext(false);
   ret2=ret;
  }

	;

operatorCall[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OperatorCall", false, false) : null;}
	:
  {
   ei.set(ret, "operatorName", opName);
   ei.set(ret, "left", left);
   // post actions performed in calling rule (i.e., priority_<n>)
   ei.leaveContext(false);
   ret2=ret;
  }

	;

variableDeclaration returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("VariableDeclaration", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "name", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

variableDeclarations returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("VariableDeclarations", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(((temp=variableDeclaration {ei.set(ret, "declarations", temp);} (((COMA) temp=variableDeclaration {ei.set(ret, "declarations", temp);}))*))? COLON temp=identifier {ei.set(ret, "type", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

type returns[Object ret2] @init {}
	:	((ret=libraryList| ret=typeDefinition))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

libraryList returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("LibraryList", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('library' ((temp=identifier {ei.set(ret, "names", temp);} (((COMA) temp=identifier {ei.set(ret, "names", temp);}))*))? 'endlib')
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

typeDefinition returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("TypeDefinition", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('type' temp=identifier {ei.set(ret, "name", temp);} 'is' ((temp=identifier {ei.set(ret, "types", temp);} (((COMA) temp=identifier {ei.set(ret, "types", temp);}))*)) (('sorts' ((temp=identifier {ei.set(ret, "sorts", temp);} (((COMA) temp=identifier {ei.set(ret, "sorts", temp);}))*))? 'opns' ((((temp=operations {ei.set(ret, "operations", temp);} ((temp=operations {ei.set(ret, "operations", temp);}))*))?)) 'eqns' ((((temp=equations {ei.set(ret, "equations", temp);} ((temp=equations {ei.set(ret, "equations", temp);}))*))?)))) 'endtype')
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

operations returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Operations", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(((temp=operationDeclaration {ei.set(ret, "declarations", temp);} (((COMA) temp=operationDeclaration {ei.set(ret, "declarations", temp);}))*)) COLON ((temp=identifier {ei.set(ret, "parameterTypes", temp);} (((COMA) temp=identifier {ei.set(ret, "parameterTypes", temp);}))*))? RARROW temp=identifier {ei.set(ret, "returnType", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

operationDeclaration returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OperationDeclaration", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "name", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

equations returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Equations", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('forall' ((temp=variableDeclarations {ei.set(ret, "declarations", temp);} (((COMA) temp=variableDeclarations {ei.set(ret, "declarations", temp);}))*)) ((((temp=ofSort {ei.set(ret, "ofSorts", temp);} ((temp=ofSort {ei.set(ret, "ofSorts", temp);}))*))?)))
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

ofSort returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OfSort", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('ofsort' temp=identifier {ei.set(ret, "name", temp);} ((((temp=equation {ei.set(ret, "equations", temp);} ((temp=equation {ei.set(ret, "equations", temp);}))*))?)))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

equation returns[Object ret2] @init {}
	:	((ret=guardedEquation| ret=simpleEquation))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

simpleEquation returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("SimpleEquation", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=value {ei.set(ret, "left", temp);} EQ temp=value {ei.set(ret, "right", temp);} SEMI)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

guardedEquation returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("GuardedEquation", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=guardExpression {ei.set(ret, "guard", temp);} IMPLIES temp=simpleEquation {ei.set(ret, "equation", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

behaviour_priority_0 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	((ret=actionBehaviour[opName, right, firstToken] SEMI {opName = ";";} (right=behaviour_priority_0 {ei.set(ret, "behaviour", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (ret=primary_behaviour))
  {
   ret2=ret;
  }

	;

behaviour_priority_1 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	((ret=guardedBehaviour[opName, right, firstToken] RARROW {opName = "->";} (right=behaviour_priority_0 {ei.set(ret, "behaviour", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (ret=behaviour_priority_0))
  {
   ret2=ret;
  }

	;

behaviour_priority_2 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(ret=behaviour_priority_1 ((LSQUARERSQUARE {opName = "[]";} (ret=alternative[opName, ret, firstToken] right=behaviour_priority_1 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});})))*)
  {
   ret2=ret;
  }

	;

behaviour_priority_3 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(ret=behaviour_priority_2 (((PIPE3 {opName = "|||";} (ret=simpleParallel[opName, ret, firstToken] right=behaviour_priority_2 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (PIPELSQUARE {opName = "|[";} (ret=gatedParallel[opName, ret, firstToken] right=behaviour_priority_2 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))))*)
  {
   ret2=ret;
  }

	;

value_priority_0 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(ret=primary_value (('of' {opName = "of";} ret=castVal[opName, ret, firstToken] ))*)
  {
   ret2=ret;
  }

	;

value_priority_1 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(ret=value_priority_0 ((PLUS {opName = "+";} (ret=operatorCall[opName, ret, firstToken] right=value_priority_0 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});})))*)
  {
   ret2=ret;
  }

	;

value_priority_2 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(ret=value_priority_1 ((('eq' {opName = "eq";} (ret=operatorCall[opName, ret, firstToken] right=value_priority_1 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (GE {opName = ">=";} (ret=operatorCall[opName, ret, firstToken] right=value_priority_1 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (GT {opName = ">";} (ret=operatorCall[opName, ret, firstToken] right=value_priority_1 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (LE {opName = "<=";} (ret=operatorCall[opName, ret, firstToken] right=value_priority_1 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (LT {opName = "<";} (ret=operatorCall[opName, ret, firstToken] right=value_priority_1 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| ('neq' {opName = "neq";} (ret=operatorCall[opName, ret, firstToken] right=value_priority_1 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))))*)
  {
   ret2=ret;
  }

	;

value_priority_3 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(ret=value_priority_2 ((('and' {opName = "and";} (ret=operatorCall[opName, ret, firstToken] right=value_priority_2 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| ('or' {opName = "or";} (ret=operatorCall[opName, ret, firstToken] right=value_priority_2 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))))*)
  {
   ret2=ret;
  }

	;

primary_behaviour returns[Object ret2] @init {}
	:	(ret=processCall| (LPAREN ret=behaviour RPAREN))
  {
   ret2=ret;
  }

	;

primary_value returns[Object ret2] @init {}
	:	(ret=variable| ret=operationCall| ret=integerVal| ret=booleanVal| (LPAREN ret=value RPAREN))
  {
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

	

LSQUARERSQUARE @init {}
	:	'[]'
  {
   
  }

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

PIPE3 @init {}
	:	'|||'
  {
   
  }

	;

PIPELSQUARE @init {}
	:	'|['
  {
   
  }

	;

RSQUAREPIPE @init {}
	:	']|'
  {
   
  }

	;

COLONEQ @init {}
	:	':='
  {
   
  }

	;

IMPLIES @init {}
	:	'=>'
  {
   
  }

	;

POINT @init {}
	:	'.'
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
	:	(('(*' (options {greedy = false;} : ('\n'| ~ '\n'))* '*)'))
  {
   
  }

	;
