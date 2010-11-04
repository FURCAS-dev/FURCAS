grammar XPath_ANTLR3;options {
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
 XPath_ANTLR3Lexer lex = new 
 XPath_ANTLR3Lexer(input);
						CommonTokenStream tokens = new CommonTokenStream(lex);
						tokens.discardTokenType(WS);
						tokens.discardTokenType(COMMENT);
						tokens.discardTokenType(NL);
						
 XPath_ANTLR3Parser parser = new 
 XPath_ANTLR3Parser(tokens);
						parser.main();
					}
}

main returns[Object ret2] @init {}
	:	((ret=expression) EOF)
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

expression returns[Object ret2] @init {}
	:	ret=priority_9
  {
   ret2=ret;
  }

	;

variableExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("VariableExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(DOLLAR temp=identifier {ei.set(ret, "name", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

pathExpression returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("PathExpression", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(((SLASH ((temp=step {ei.set(ret, "steps", temp);} (((SLASH) temp=step {ei.set(ret, "steps", temp);}))*))?) {ei.set(ret, "isAbsolute", java.lang.Boolean.TRUE);}| (((temp=step {ei.set(ret, "steps", temp);} (((SLASH) temp=step {ei.set(ret, "steps", temp);}))*))) {ei.set(ret, "isAbsolute", java.lang.Boolean.FALSE);}))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

step returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Step", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(((temp=axis {ei.set(ret, "axis", temp);} temp=nodeTest {ei.set(ret, "nodeTest", temp);})| (POINT)| (POINTPOINT)) ((temp=predicate {ei.set(ret, "predicates", temp);} ((temp=predicate {ei.set(ret, "predicates", temp);}))*))?)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

predicate returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Predicate", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(LSQUARE temp=expression {ei.set(ret, "expression", temp);} RSQUARE)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

operatorCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OperatorCallExp", false, false) : null;}
	:
  {
   ei.set(ret, "name", opName);
   ei.set(ret, "left", left);
   // post actions performed in calling rule (i.e., priority_<n>)
   ei.leaveContext(false);
   ret2=ret;
  }

	;

functionCallExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("FunctionCallExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "name", temp);} LPAREN ((temp=expression {ei.set(ret, "arguments", temp);} (((',') temp=expression {ei.set(ret, "arguments", temp);}))*))? RPAREN)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

literalExp returns[Object ret2] @init {}
	:	((ret=integerExp| ret=stringExp))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

integerExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("IntegerExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=integerSymbol {ei.set(ret, "symbol", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

stringExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("StringExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=stringSymbol {ei.set(ret, "symbol", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

nodeTest returns[Object ret2] @init {}
	:	((ret=nameTest| ret=wildCardTest| ret=isNodeTest| ret=isTextTest))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

nameTest returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("NameTest", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "name", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

wildCardTest returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("WildCardTest", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(STAR)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

isNodeTest returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("IsNodeTest", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('node' LPAREN RPAREN)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

isTextTest returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("IsTextTest", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('text' LPAREN RPAREN)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

axis returns[Object ret2] @init {}
	:	((ret=ancestorAxis| ret=ancestorOrSelfAxis| ret=attributeAxis| ret=childAxis| ret=descendantAxis| ret=descendantOrSelfAxis| ret=followingAxis| ret=followingSiblingAxis| ret=namespaceAxis| ret=parentAxis| ret=precedingAxis| ret=precedingSiblingAxis| ret=selfAxis))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

ancestorAxis returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("AncestorAxis", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('ancestor' COLONS)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

ancestorOrSelfAxis returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("AncestorOrSelfAxis", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('ancestor-or-self' COLONS)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

attributeAxis returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("AttributeAxis", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	((('attribute' COLONS)| (AROBAS)))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

childAxis returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("ChildAxis", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	((('child' COLONS)| ()))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

descendantAxis returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("DescendantAxis", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('descendant' COLONS)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

descendantOrSelfAxis returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("DescendantOrSelfAxis", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('descendant-or-self' COLONS)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

followingAxis returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("FollowingAxis", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('following' COLONS)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

followingSiblingAxis returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("FollowingSiblingAxis", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('following-sibling' COLONS)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

namespaceAxis returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("NamespaceAxis", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('namespace' COLONS)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

parentAxis returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("ParentAxis", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('parent' COLONS)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

precedingAxis returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("PrecedingAxis", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('preceding' COLONS)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

precedingSiblingAxis returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("PrecedingSiblingAxis", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('preceding-sibling' COLONS)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

selfAxis returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("SelfAxis", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('self' COLONS)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

priority_0 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(ret=primary_expression)
  {
   ret2=ret;
  }

	;

priority_1 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(ret=priority_0)
  {
   ret2=ret;
  }

	;

priority_2 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(ret=priority_1 ((PIPE {opName = "|";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_1 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});})))*)
  {
   ret2=ret;
  }

	;

priority_3 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	((MINUS {opName = "-";} (ret=operatorCallExp[opName, right, firstToken] right=priority_2 {ei.set(ret, "left", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (ret=priority_2))
  {
   ret2=ret;
  }

	;

priority_4 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(ret=priority_3 (((STAR {opName = "*";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_3 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| ('div' {opName = "div";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_3 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| ('mod' {opName = "mod";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_3 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))))*)
  {
   ret2=ret;
  }

	;

priority_5 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(ret=priority_4 (((PLUS {opName = "+";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_4 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (MINUS {opName = "-";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_4 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))))*)
  {
   ret2=ret;
  }

	;

priority_6 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(ret=priority_5 (((LT {opName = "<";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_5 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (LE {opName = "<=";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_5 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (GT {opName = ">";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_5 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (GE {opName = ">=";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_5 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))))*)
  {
   ret2=ret;
  }

	;

priority_7 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(ret=priority_6 (((EQ {opName = "=";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_6 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (EXCLEQ {opName = "!=";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_6 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))))*)
  {
   ret2=ret;
  }

	;

priority_8 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(ret=priority_7 (('and' {opName = "and";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_7 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});})))*)
  {
   ret2=ret;
  }

	;

priority_9 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(ret=priority_8 (('or' {opName = "or";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_8 {ei.set(ret, "right", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});})))*)
  {
   ret2=ret;
  }

	;

primary_expression returns[Object ret2] @init {}
	:	(ret=functionCallExp| ret=variableExp| ret=pathExpression| ret=literalExp| (LPAREN ret=expression RPAREN))
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

	FLOAT	:	DIGIT+ (('.' DIGIT)=>'.' DIGIT+)?	;	// cannot accept DIGIT '.' because it would conflict with Navigation

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
	

DOLLAR @init {}
	:	'$'
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

COLONS @init {}
	:	'::'
  {
   
  }

	;

POINT @init {}
	:	'.'
  {
   
  }

	;

POINTPOINT @init {}
	:	'..'
  {
   
  }

	;

AROBAS @init {}
	:	'@'
  {
   
  }

	;

SLASH @init {}
	:	'/'
  {
   
  }

	;

PIPE @init {}
	:	'|'
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

SLASHSLASH @init {}
	:	'//'
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

EXCLEQ @init {}
	:	'!='
  {
   
  }

	;

COMMENT @init {}
	:	(('--' (~('\r'| '\n'))*))
  {
   
  }

	;
