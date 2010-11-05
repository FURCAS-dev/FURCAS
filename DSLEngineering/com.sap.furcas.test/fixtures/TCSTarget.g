grammar TCS_ANTLR3;@header {package org.eclipse.gmt.tcs.injector;}@lexer::header {package org.eclipse.gmt.tcs.injector;}@lexer::members {

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
 TCS_ANTLR3Lexer lex = new 
 TCS_ANTLR3Lexer(input);
						CommonTokenStream tokens = new CommonTokenStream(lex);
						tokens.discardTokenType(WS);
						tokens.discardTokenType(COMMENT);
						tokens.discardTokenType(NL);
						
 TCS_ANTLR3Parser parser = new 
 TCS_ANTLR3Parser(tokens);
						parser.main();
					}
}

main returns[Object ret2] @init {}
	:	((ret=concreteSyntax) EOF)
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
	:	(ast=NAME {ret = ast.getText(); ei.setToken((Object)ast);}| 'syntax' {ret = "syntax";}| 'k' {ret = "k";}| 'keywords' {ret = "keywords";}| 'symbols' {ret = "symbols";}| 'lexer' {ret = "lexer";}| 'primitiveTemplate' {ret = "primitiveTemplate";}| 'for' {ret = "for";}| 'default' {ret = "default";}| 'using' {ret = "using";}| 'orKeyword' {ret = "orKeyword";}| 'value' {ret = "value";}| 'serializer' {ret = "serializer";}| 'enumerationTemplate' {ret = "enumerationTemplate";}| 'auto' {ret = "auto";}| 'template' {ret = "template";}| 'disambiguate' {ret = "disambiguate";}| 'multi' {ret = "multi";}| 'main' {ret = "main";}| 'deep' {ret = "deep";}| 'abstract' {ret = "abstract";}| 'operatored' {ret = "operatored";}| 'context' {ret = "context";}| 'addToContext' {ret = "addToContext";}| 'nonPrimary' {ret = "nonPrimary";}| 'prefix' {ret = "prefix";}| 'operatorTemplate' {ret = "operatorTemplate";}| 'operators' {ret = "operators";}| 'source' {ret = "source";}| 'storeOpTo' {ret = "storeOpTo";}| 'storeRightTo' {ret = "storeRightTo";}| 'disambiguateV3' {ret = "disambiguateV3";}| 'function' {ret = "function";}| 'refersTo' {ret = "refersTo";}| 'lookIn' {ret = "lookIn";}| 'all' {ret = "all";}| 'createIn' {ret = "createIn";}| 'as' {ret = "as";}| 'refersToKey' {ret = "refersToKey";}| 'true' {ret = "true";}| 'false' {ret = "false";}| 'separator' {ret = "separator";}| 'autoCreate' {ret = "autoCreate";}| 'always' {ret = "always";}| 'ifmissing' {ret = "ifmissing";}| 'never' {ret = "never";}| 'importContext' {ret = "importContext";}| 'forcedLower' {ret = "forcedLower";}| 'createAs' {ret = "createAs";}| 'mode' {ret = "mode";}| 'nbNL' {ret = "nbNL";}| 'indentIncr' {ret = "indentIncr";}| 'startNL' {ret = "startNL";}| 'startNbNL' {ret = "startNbNL";}| 'endNL' {ret = "endNL";}| 'leftSpace' {ret = "leftSpace";}| 'leftNone' {ret = "leftNone";}| 'rightSpace' {ret = "rightSpace";}| 'rightNone' {ret = "rightNone";}| 'priority' {ret = "priority";}| 'postfix' {ret = "postfix";}| 'left' {ret = "left";}| 'right' {ret = "right";}| 'and' {ret = "and";}| 'isDefined' {ret = "isDefined";}| 'one' {ret = "one";}| 'token' {ret = "token";}| 'word' {ret = "word";}| 'start' {ret = "start";}| 'part' {ret = "part";}| 'end' {ret = "end";}| 'words' {ret = "words";}| 'endOfLine' {ret = "endOfLine";}| 'drop' {ret = "drop";}| 'multiLine' {ret = "multiLine";}| 'esc' {ret = "esc";}| 'octal' {ret = "octal";}| 'hex' {ret = "hex";})
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

concreteSyntax returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("ConcreteSyntax", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('syntax' temp=identifier {ei.set(ret, "name", temp);} ((LPAREN 'k' EQ temp=integerSymbol {ei.set(ret, "k", temp);} RPAREN) {}| () {}) LCURLY ((((temp=template {ei.set(ret, "templates", temp);} ((temp=template {ei.set(ret, "templates", temp);}))*))? (('keywords' LCURLY ((((temp=keyword {ei.set(ret, "keywords", temp);} ((temp=keyword {ei.set(ret, "keywords", temp);}))*))?)) RCURLY) {}| () {}) (('symbols' LCURLY ((((temp=symbol {ei.set(ret, "symbols", temp);} ((temp=symbol {ei.set(ret, "symbols", temp);}))*))?)) RCURLY) {}| () {}) ((temp=operatorList {ei.set(ret, "operatorLists", temp);} ((temp=operatorList {ei.set(ret, "operatorLists", temp);}))*))? ((temp=token {ei.set(ret, "tokens", temp);} ((temp=token {ei.set(ret, "tokens", temp);}))*))? (('lexer' EQ temp=stringSymbol {ei.set(ret, "lexer", temp);} SEMI) {}| () {}))) RCURLY)
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

template returns[Object ret2] @init {}
	:	((ret=primitiveTemplate| ret=enumerationTemplate| ret=classTemplate| ret=operatorTemplate| ret=functionTemplate))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

primitiveTemplate returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("PrimitiveTemplate", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('primitiveTemplate' temp=identifier {ei.set(ret, "templateName", temp);} 'for' ((temp=identifier {ei.set(ret, "names", temp);} (((DLCOLON) temp=identifier {ei.set(ret, "names", temp);}))*)) (('default') {ei.set(ret, "isDefault", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isDefault", java.lang.Boolean.FALSE);}) 'using' temp=identifier {ei.set(ret, "tokenName", temp);} (('orKeyword') {ei.set(ret, "orKeyword", java.lang.Boolean.TRUE);}| () {ei.set(ret, "orKeyword", java.lang.Boolean.FALSE);}) COLON 'value' EQ temp=stringSymbol {ei.set(ret, "value", temp);} ((COMA 'serializer' EQ temp=stringSymbol {ei.set(ret, "serializer", temp);}) {}| () {}) SEMI)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

enumerationTemplate returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("EnumerationTemplate", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('enumerationTemplate' ((temp=identifier {ei.set(ret, "names", temp);} (((DLCOLON) temp=identifier {ei.set(ret, "names", temp);}))*)) (('auto') {ei.set(ret, "automatic", java.lang.Boolean.TRUE);}| () {ei.set(ret, "automatic", java.lang.Boolean.FALSE);}) ((((COLON ((((temp=enumLiteralMapping {ei.set(ret, "mappings", temp);} (((COMA) temp=enumLiteralMapping {ei.set(ret, "mappings", temp);}))*))?)) SEMI))) {}| (SEMI) {}))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

enumLiteralMapping returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("EnumLiteralMapping", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=enumLiteralVal {ei.set(ret, "literal", temp);} EQ temp=sequenceElement {ei.set(ret, "element", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

classTemplate returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("ClassTemplate", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('template' ((temp=identifier {ei.set(ret, "names", temp);} (((DLCOLON) temp=identifier {ei.set(ret, "names", temp);}))*)) ((SHARP temp=identifier {ei.set(ret, "mode", temp);}) {}| () {}) ((LPAREN 'disambiguate' EQ temp=stringSymbol {ei.set(ret, "disambiguate", temp);} RPAREN) {}| () {}) (('multi') {ei.set(ret, "isMulti", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isMulti", java.lang.Boolean.FALSE);}) (('main') {ei.set(ret, "isMain", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isMain", java.lang.Boolean.FALSE);}) (((('deep') {ei.set(ret, "isDeep", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isDeep", java.lang.Boolean.FALSE);}) 'abstract') {ei.set(ret, "isAbstract", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isAbstract", java.lang.Boolean.FALSE);}) (('operatored' ((LPAREN temp=identifier {ei.setRef(ret, "operatorList", "OperatorList", "name", temp, null, "never", null, false, null);} RPAREN) {}| () {})) {ei.set(ret, "isOperatored", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isOperatored", java.lang.Boolean.FALSE);}) (('context') {ei.set(ret, "isContext", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isContext", java.lang.Boolean.FALSE);}) (('addToContext') {ei.set(ret, "isAddToContext", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isAddToContext", java.lang.Boolean.FALSE);}) (('nonPrimary') {ei.set(ret, "isNonPrimary", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isNonPrimary", java.lang.Boolean.FALSE);}) (('prefix' ((COLON ((temp=sequence {ei.set(ret, "prefixSequence", temp);}))))) {}| () {}) ((((COLON ((temp=sequence {ei.set(ret, "templateSequence", temp);})) SEMI))) {}| (SEMI) {}))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

operatorTemplate returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OperatorTemplate", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('operatorTemplate' ((temp=identifier {ei.set(ret, "names", temp);} (((DLCOLON) temp=identifier {ei.set(ret, "names", temp);}))*)) LPAREN 'operators' EQ ((temp=identifier {ei.setRef(ret, "operators", "Operator", "name", temp, null, "never", null, false, null);} ((temp=identifier {ei.setRef(ret, "operators", "Operator", "name", temp, null, "never", null, false, null);}))*))? COMA 'source' EQ temp=identifier {ei.set(ret, "source", temp);} ((COMA 'storeOpTo' EQ temp=identifier {ei.set(ret, "storeOpTo", temp);}) {}| () {}) ((COMA 'storeRightTo' EQ temp=identifier {ei.set(ret, "storeRightTo", temp);}) {}| () {}) ((COMA 'disambiguate' EQ temp=stringSymbol {ei.set(ret, "disambiguate", temp);}) {}| () {}) ((COMA 'disambiguateV3' EQ temp=stringSymbol {ei.set(ret, "disambiguateV3", temp);}) {}| () {}) RPAREN (('context') {ei.set(ret, "isContext", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isContext", java.lang.Boolean.FALSE);}) ((((COLON ((temp=sequence {ei.set(ret, "otSequence", temp);})) SEMI))) {}| (SEMI) {}))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

functionTemplate returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("FunctionTemplate", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('function' temp=identifier {ei.set(ret, "functionName", temp);} LPAREN ((temp=identifier {ei.set(ret, "names", temp);} (((DLCOLON) temp=identifier {ei.set(ret, "names", temp);}))*)) RPAREN ((COLON ((temp=sequence {ei.set(ret, "functionSequence", temp);})) SEMI)))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

sequence returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Sequence", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(((temp=sequenceElement {ei.set(ret, "elements", temp);} ((temp=sequenceElement {ei.set(ret, "elements", temp);}))*))?)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

sequenceElement returns[Object ret2] @init {}
	:	((ret=literalRef| ret=property| ret=customSeparator| ret=block| ret=conditionalElement| ret=propertyInit| ret=alternative| ret=functionCall))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

literalRef returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("LiteralRef", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=stringSymbol {ei.setRef(ret, "referredLiteral", "Literal", "value", temp, "#all", "ifmissing", "Keyword", false, null);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

property returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Property", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifierOrKeyword {ei.set(ret, "name", temp);} ((LCURLY ((temp=propertyArg {ei.set(ret, "propertyArgs", temp);} (((COMA) temp=propertyArg {ei.set(ret, "propertyArgs", temp);}))*))? RCURLY) {}| () {}))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

customSeparator returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("CustomSeparator", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(LT temp=identifier {ei.set(ret, "name", temp);} GT)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

block returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Block", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(LSQUARE temp=sequence {ei.set(ret, "blockSequence", temp);} RSQUARE ((LCURLY ((temp=blockArg {ei.set(ret, "blockArgs", temp);} (((COMA) temp=blockArg {ei.set(ret, "blockArgs", temp);}))*))? RCURLY) {}| () {}))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

conditionalElement returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("ConditionalElement", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(LPAREN temp=expression {ei.set(ret, "condition", temp);} QMARK temp=sequence {ei.set(ret, "thenSequence", temp);} ((COLON temp=sequence {ei.set(ret, "elseSequence", temp);}) {}| () {}) RPAREN)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

propertyInit returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("PropertyInit", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(DLCURLY temp=identifier {ei.set(ret, "name", temp);} LARROW temp=value {ei.set(ret, "value", temp);} DRCURLY)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

alternative returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Alternative", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(DLSQUARE ((temp=sequence {ei.set(ret, "sequences", temp);} (((PIPE) temp=sequence {ei.set(ret, "sequences", temp);}))+)) DRSQUARE ((STAR) {ei.set(ret, "isMulti", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isMulti", java.lang.Boolean.FALSE);}))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

functionCall returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("FunctionCall", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(DOLLAR temp=identifier {ei.setRef(ret, "calledFunction", "FunctionTemplate", "functionName", temp, null, "never", null, false, null);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

propertyArg returns[Object ret2] @init {}
	:	((ret=refersToPArg| ret=lookInPArg| ret=createInPArg| ret=asPArg| ret=refersToKeyPArg| ret=separatorPArg| ret=autoCreatePArg| ret=importContextPArg| ret=forcedLowerPArg| ret=createAsPArg| ret=modePArg))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

refersToPArg returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("RefersToPArg", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('refersTo' EQ temp=identifierOrKeyword {ei.set(ret, "propertyName", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

lookInPArg returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("LookInPArg", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('lookIn' EQ ((SHARP 'all') {ei.set(ret, "propertyName", "#all");}| (((temp=identifierOrKeyword {ei.set(ret, "propertyName", temp);} (((POINT) temp=identifierOrKeyword {ei.set(ret, "propertyName", temp);}))*))) {}))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

createInPArg returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("CreateInPArg", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('createIn' EQ ((temp=identifierOrKeyword {ei.set(ret, "propertyName", temp);} (((POINT) temp=identifierOrKeyword {ei.set(ret, "propertyName", temp);}))*)))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

asPArg returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("AsPArg", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('as' EQ temp=identifier {ei.set(ret, "value", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

refersToKeyPArg returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("RefersToKeyPArg", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('refersToKey' EQ (('true') {ei.set(ret, "value", java.lang.Boolean.TRUE);}| ('false') {ei.set(ret, "value", java.lang.Boolean.FALSE);}))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

separatorPArg returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("SeparatorPArg", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('separator' EQ temp=sequence {ei.set(ret, "separatorSequence", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

autoCreatePArg returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("AutoCreatePArg", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('autoCreate' EQ temp=autoCreateKind {ei.set(ret, "value", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

autoCreateKind returns[Object ret2] @init {java.lang.Object ret=null;}
	:	(('always') {ret = ei.createEnumLiteral("always");}| ('ifmissing') {ret = ei.createEnumLiteral("ifmissing");}| ('never') {ret = ei.createEnumLiteral("never");})
  {
   ret2=ret;
  }

	;

importContextPArg returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("ImportContextPArg", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('importContext')
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

forcedLowerPArg returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("ForcedLowerPArg", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('forcedLower' EQ temp=integerSymbol {ei.set(ret, "value", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

createAsPArg returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("CreateAsPArg", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('createAs' EQ temp=identifierOrKeyword {ei.set(ret, "name", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

modePArg returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("ModePArg", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('mode' EQ temp=identifierOrKeyword {ei.set(ret, "mode", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

blockArg returns[Object ret2] @init {}
	:	((ret=nbNLBArg| ret=indentIncrBArg| ret=startNLBArg| ret=startNbNLBArg| ret=endNLBArg))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

nbNLBArg returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("NbNLBArg", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('nbNL' EQ temp=integerSymbol {ei.set(ret, "value", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

indentIncrBArg returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("IndentIncrBArg", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('indentIncr' EQ temp=integerSymbol {ei.set(ret, "value", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

startNLBArg returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("StartNLBArg", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('startNL' EQ (('true') {ei.set(ret, "value", java.lang.Boolean.TRUE);}| ('false') {ei.set(ret, "value", java.lang.Boolean.FALSE);}))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

startNbNLBArg returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("StartNbNLBArg", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('startNbNL' EQ temp=integerSymbol {ei.set(ret, "value", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

endNLBArg returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("EndNLBArg", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('endNL' EQ (('true') {ei.set(ret, "value", java.lang.Boolean.TRUE);}| ('false') {ei.set(ret, "value", java.lang.Boolean.FALSE);}))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

symbol returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Symbol", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "name", temp);} EQ temp=stringSymbol {ei.set(ret, "value", temp);} ((COLON ((temp=spaceKind {ei.set(ret, "spaces", temp);} (((COMA) temp=spaceKind {ei.set(ret, "spaces", temp);}))*))?) {}| () {}) SEMI)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

spaceKind returns[Object ret2] @init {java.lang.Object ret=null;}
	:	(('leftSpace') {ret = ei.createEnumLiteral("leftSpace");}| ('leftNone') {ret = ei.createEnumLiteral("leftNone");}| ('rightSpace') {ret = ei.createEnumLiteral("rightSpace");}| ('rightNone') {ret = ei.createEnumLiteral("rightNone");})
  {
   ret2=ret;
  }

	;

keyword returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Keyword", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "name", temp);} EQ temp=stringSymbol {ei.set(ret, "value", temp);} SEMI)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

operatorList returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OperatorList", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('operators' ((temp=identifier {ei.set(ret, "name", temp);}) {}| () {}) LCURLY ((((temp=priority {ei.set(ret, "priorities", temp);} ((temp=priority {ei.set(ret, "priorities", temp);}))*))?)) RCURLY)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

priority returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Priority", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('priority' temp=integerSymbol {ei.set(ret, "value", temp);} (() {ei.set(ret, "associativity", new org.eclipse.m2m.atl.engine.vm.nativelib.ASMEnumLiteral("left"));}| (COMA temp=associativity {ei.set(ret, "associativity", temp);}) {}) LCURLY ((((temp=operator {ei.set(ret, "operators", temp);} ((temp=operator {ei.set(ret, "operators", temp);}))*))?)) RCURLY)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

operator returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Operator", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	((('postfix') {ei.set(ret, "isPostfix", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isPostfix", java.lang.Boolean.FALSE);}) temp=identifier {ei.set(ret, "name", temp);} EQ ((((temp=identifier {ei.setRef(ret, "literal", "Literal", "name", temp, null, "never", null, false, null);})| (temp=stringSymbol {ei.setRef(ret, "literal", "Literal", "value", temp, "#all", "ifmissing", "Keyword", false, null);}))) {}| () {}) COMA temp=integerSymbol {ei.set(ret, "arity", temp);} SEMI)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

associativity returns[Object ret2] @init {java.lang.Object ret=null;}
	:	(('left') {ret = ei.createEnumLiteral("left");}| ('right') {ret = ei.createEnumLiteral("right");})
  {
   ret2=ret;
  }

	;

expression returns[Object ret2] @init {}
	:	(ret=andExp)
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

andExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("AndExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(((temp=atomExp {ei.set(ret, "expressions", temp);} ((('and') temp=atomExp {ei.set(ret, "expressions", temp);}))*))?)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

atomExp returns[Object ret2] @init {}
	:	((ret=equalsExp| ret=booleanPropertyExp| ret=isDefinedExp| ret=oneExp))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

equalsExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("EqualsExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifierOrKeyword {ei.set(ret, "propertyName", temp);} EQ temp=value {ei.set(ret, "value", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

booleanPropertyExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("BooleanPropertyExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifierOrKeyword {ei.set(ret, "propertyName", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

isDefinedExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("IsDefinedExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('isDefined' LPAREN temp=identifierOrKeyword {ei.set(ret, "propertyName", temp);} RPAREN)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

oneExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OneExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('one' LPAREN temp=identifierOrKeyword {ei.set(ret, "propertyName", temp);} RPAREN)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

value returns[Object ret2] @init {}
	:	((ret=stringVal| ret=integerVal| ret=negativeIntegerVal| ret=enumLiteralVal))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

stringVal returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("StringVal", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=stringSymbol {ei.set(ret, "symbol", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

integerVal returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("IntegerVal", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=integerSymbol {ei.set(ret, "symbol", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

negativeIntegerVal returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("NegativeIntegerVal", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(MINUS temp=integerSymbol {ei.set(ret, "symbol", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

enumLiteralVal returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("EnumLiteralVal", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(SHARP temp=identifierOrKeyword {ei.set(ret, "name", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

token returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Token", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('token' temp=identifier {ei.set(ret, "name", temp);} COLON temp=orPattern {ei.set(ret, "pattern", temp);} SEMI)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

orPattern returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OrPattern", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(((temp=simplePattern {ei.set(ret, "simplePatterns", temp);} (((PIPE) temp=simplePattern {ei.set(ret, "simplePatterns", temp);}))*)))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

simplePattern returns[Object ret2] @init {}
	:	((ret=rulePattern| ret=stringPattern| ret=classPattern))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

rulePattern returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("RulePattern", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=rule {ei.set(ret, "rule", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

rule returns[Object ret2] @init {}
	:	((ret=wordRule| ret=endOfLineRule| ret=multiLineRule))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

wordRule returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("WordRule", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('word' LPAREN 'start' EQ temp=orPattern {ei.set(ret, "start", temp);} COMA 'part' EQ temp=orPattern {ei.set(ret, "part", temp);} ((COMA 'end' EQ temp=orPattern {ei.set(ret, "end", temp);}) {}| () {}) ((COMA 'words' EQ LPAREN ((temp=word {ei.set(ret, "words", temp);} (((COMA) temp=word {ei.set(ret, "words", temp);}))*))? RPAREN) {}| () {}) RPAREN)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

word returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Word", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=stringSymbol {ei.set(ret, "name", temp);} COLON temp=identifier {ei.set(ret, "token", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

endOfLineRule returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("EndOfLineRule", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('endOfLine' LPAREN 'start' EQ (('drop') {ei.set(ret, "dropStart", java.lang.Boolean.TRUE);}| () {ei.set(ret, "dropStart", java.lang.Boolean.FALSE);}) temp=stringPattern {ei.set(ret, "start", temp);} RPAREN)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

multiLineRule returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("MultiLineRule", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('multiLine' LPAREN 'start' EQ (('drop') {ei.set(ret, "dropStart", java.lang.Boolean.TRUE);}| () {ei.set(ret, "dropStart", java.lang.Boolean.FALSE);}) temp=stringPattern {ei.set(ret, "start", temp);} COMA 'end' EQ (('drop') {ei.set(ret, "dropEnd", java.lang.Boolean.TRUE);}| () {ei.set(ret, "dropEnd", java.lang.Boolean.FALSE);}) temp=stringPattern {ei.set(ret, "end", temp);} ((COMA 'esc' EQ temp=stringPattern {ei.set(ret, "esc", temp);} ((COMA LPAREN ((temp=mapping {ei.set(ret, "escMappings", temp);} (((COMA) temp=mapping {ei.set(ret, "escMappings", temp);}))*))? RPAREN) {}| () {})) {}| () {}) RPAREN)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

mapping returns[Object ret2] @init {}
	:	((ret=simpleMapping| ret=wildcardMapping| ret=octalMapping| ret=hexadecimalMapping))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

simpleMapping returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("SimpleMapping", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "key", temp);} RARROW temp=identifier {ei.set(ret, "value", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

wildcardMapping returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("WildcardMapping", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(POINT RARROW POINT)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

octalMapping returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OctalMapping", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('octal')
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

hexadecimalMapping returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("HexadecimalMapping", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('hex')
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

stringPattern returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("StringPattern", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=stringSymbol {ei.set(ret, "name", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

classPattern returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("ClassPattern", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(LSQUARE temp=identifier {ei.set(ret, "name", temp);} RSQUARE)
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
		|	'\''!
			(	ESC
			|	'\n' {newline();}
			|	~('\\'|'\''|'\n')
			)*
			'\''!
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
	:	'"'!
		(	ESC
		|	'\n' {newline();}
		|	~('\\'|'"'|'\n')
		)*
		'"'!
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

DLSQUARE @init {}
	:	'[['
  {
   
  }

	;

DRSQUARE @init {}
	:	']]'
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

DLCURLY @init {}
	:	'{{'
  {
   
  }

	;

DRCURLY @init {}
	:	'}}'
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

DLCOLON @init {}
	:	'::'
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

DOLLAR @init {}
	:	'$'
  {
   
  }

	;

AROBAS @init {}
	:	'@'
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
	:	(('--' (~('\r'| '\n'))*))
  {
   
  }

	;
