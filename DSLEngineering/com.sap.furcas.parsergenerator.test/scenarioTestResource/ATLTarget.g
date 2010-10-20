grammar ATL_ANTLR3;options {
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
 ATL_ANTLR3Lexer lex = new 
 ATL_ANTLR3Lexer(input);
						CommonTokenStream tokens = new CommonTokenStream(lex);
						tokens.discardTokenType(WS);
						tokens.discardTokenType(COMMENT);
						tokens.discardTokenType(NL);
						
 ATL_ANTLR3Parser parser = new 
 ATL_ANTLR3Parser(tokens);
						parser.main();
					}
}

main returns[Object ret2] @init {}
	:	((ret=unit) EOF)
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
	:	(ast=NAME {ret = ast.getText(); ei.setToken((Object)ast);}| 'module' {ret = "module";}| 'create' {ret = "create";}| 'refining' {ret = "refining";}| 'from' {ret = "from";}| 'library' {ret = "library";}| 'query' {ret = "query";}| 'uses' {ret = "uses";}| 'helper' {ret = "helper";}| 'def' {ret = "def";}| 'context' {ret = "context";}| 'nodefault' {ret = "nodefault";}| 'abstract' {ret = "abstract";}| 'rule' {ret = "rule";}| 'extends' {ret = "extends";}| 'using' {ret = "using";}| 'unique' {ret = "unique";}| 'lazy' {ret = "lazy";}| 'entrypoint' {ret = "entrypoint";}| 'endpoint' {ret = "endpoint";}| 'in' {ret = "in";}| 'to' {ret = "to";}| 'mapsTo' {ret = "mapsTo";}| 'distinct' {ret = "distinct";}| 'foreach' {ret = "foreach";}| 'do' {ret = "do";}| 'if' {ret = "if";}| 'else' {ret = "else";}| 'for' {ret = "for";}| 'iterate' {ret = "iterate";}| 'OclUndefined' {ret = "OclUndefined";}| 'true' {ret = "true";}| 'false' {ret = "false";}| 'then' {ret = "then";}| 'endif' {ret = "endif";}| 'super' {ret = "super";}| 'let' {ret = "let";}| 'Bag' {ret = "Bag";}| 'Set' {ret = "Set";}| 'OrderedSet' {ret = "OrderedSet";}| 'Sequence' {ret = "Sequence";}| 'Map' {ret = "Map";}| 'Tuple' {ret = "Tuple";}| 'OclType' {ret = "OclType";}| 'OclAny' {ret = "OclAny";}| 'TupleType' {ret = "TupleType";}| 'Integer' {ret = "Integer";}| 'Real' {ret = "Real";}| 'Boolean' {ret = "Boolean";}| 'String' {ret = "String";}| 'Collection' {ret = "Collection";}| 'not' {ret = "not";}| 'div' {ret = "div";}| 'mod' {ret = "mod";}| 'and' {ret = "and";}| 'or' {ret = "or";}| 'xor' {ret = "xor";}| 'implies' {ret = "implies";})
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

unit returns[Object ret2] @init {}
	:	((ret=module| ret=library| ret=query))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

module returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Module", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('module' temp=identifier {ei.set(ret, "name", temp);} SEMI 'create' ((temp=oclModel {ei.set(ret, "outModels", temp);} (((COMA) temp=oclModel {ei.set(ret, "outModels", temp);}))*)) (('refining') {ei.set(ret, "isRefining", java.lang.Boolean.TRUE);}| ('from') {ei.set(ret, "isRefining", java.lang.Boolean.FALSE);}) ((temp=oclModel {ei.set(ret, "inModels", temp);} (((COMA) temp=oclModel {ei.set(ret, "inModels", temp);}))*)) SEMI ((((temp=libraryRef {ei.set(ret, "libraries", temp);} ((temp=libraryRef {ei.set(ret, "libraries", temp);}))*))? ((temp=moduleElement {ei.set(ret, "elements", temp);} ((temp=moduleElement {ei.set(ret, "elements", temp);}))*))?)))
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

library returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Library", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('library' temp=identifier {ei.set(ret, "name", temp);} SEMI ((((temp=libraryRef {ei.set(ret, "libraries", temp);} ((temp=libraryRef {ei.set(ret, "libraries", temp);}))*))? ((temp=helper {ei.set(ret, "helpers", temp);} ((temp=helper {ei.set(ret, "helpers", temp);}))*))?)))
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

query returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Query", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('query' temp=identifier {ei.set(ret, "name", temp);} EQ temp=oclExpression {ei.set(ret, "body", temp);} SEMI ((((temp=libraryRef {ei.set(ret, "libraries", temp);} ((temp=libraryRef {ei.set(ret, "libraries", temp);}))*))? ((temp=helper {ei.set(ret, "helpers", temp);} ((temp=helper {ei.set(ret, "helpers", temp);}))*))?)))
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

libraryRef returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("LibraryRef", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('uses' temp=identifier {ei.set(ret, "name", temp);} SEMI)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

moduleElement returns[Object ret2] @init {}
	:	((ret=helper| ret=rule))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

helper returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Helper", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('helper' temp=oclFeatureDefinition {ei.set(ret, "definition", temp);} SEMI)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

oclFeatureDefinition returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OclFeatureDefinition", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(((temp=oclContextDefinition {ei.set(ret, "context_", temp);}) {}| () {}) 'def' COLON temp=oclFeature {ei.set(ret, "feature", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

oclContextDefinition returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OclContextDefinition", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('context' temp=oclType {ei.set(ret, "context_", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

oclFeature returns[Object ret2] @init {}
	:	((ret=operation| ret=attribute))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

operation returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Operation", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "name", temp);} LPAREN ((temp=parameter {ei.set(ret, "parameters", temp);} (((COMA) temp=parameter {ei.set(ret, "parameters", temp);}))*))? RPAREN COLON temp=oclType {ei.set(ret, "returnType", temp);} EQ ((temp=oclExpression {ei.set(ret, "body", temp);})))
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

parameter returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Parameter", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "varName", temp);} COLON temp=oclType {ei.set(ret, "type", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

attribute returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Attribute", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "name", temp);} COLON temp=oclType {ei.set(ret, "type", temp);} EQ ((temp=oclExpression {ei.set(ret, "initExpression", temp);})))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

rule returns[Object ret2] @init {}
	:	((ret=calledRule| ret=matchedRule))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

matchedRule returns[Object ret2] @init {}
	:	((ret=lazyMatchedRule| ret=matchedRule_abstractContents))
  {
   ei.addToContext(ret, true);
   ret2=ret;
  }

	;

lazyMatchedRule returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("LazyMatchedRule", true, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	((('unique') {ei.set(ret, "isUnique", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isUnique", java.lang.Boolean.FALSE);}) 'lazy' (('abstract') {ei.set(ret, "isAbstract", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isAbstract", java.lang.Boolean.FALSE);}) (('refining') {ei.set(ret, "isRefining", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isRefining", java.lang.Boolean.FALSE);}) 'rule' temp=identifier {ei.set(ret, "name", temp);} (('extends' temp=identifier {ei.setRef(ret, "superRule", "MatchedRule", "name", temp, null, "never", null, true, null);}) {}| () {}) LCURLY ((temp=inPattern {ei.set(ret, "inPattern", temp);} (('using' LCURLY ((((temp=ruleVariableDeclaration {ei.set(ret, "variables", temp);} ((temp=ruleVariableDeclaration {ei.set(ret, "variables", temp);}))*))?)) RCURLY) {}| () {}) ((temp=outPattern {ei.set(ret, "outPattern", temp);}) {}| () {}) ((temp=actionBlock {ei.set(ret, "actionBlock", temp);}) {}| () {}))) RCURLY)
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

ruleVariableDeclaration returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("RuleVariableDeclaration", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "varName", temp);} COLON temp=oclType {ei.set(ret, "type", temp);} EQ temp=oclExpression {ei.set(ret, "initExpression", temp);} SEMI)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

calledRule returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("CalledRule", true, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	((('entrypoint') {ei.set(ret, "isEntrypoint", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isEntrypoint", java.lang.Boolean.FALSE);}) (('endpoint') {ei.set(ret, "isEndpoint", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isEndpoint", java.lang.Boolean.FALSE);}) 'rule' temp=identifier {ei.set(ret, "name", temp);} LPAREN ((temp=parameter {ei.set(ret, "parameters", temp);} (((COMA) temp=parameter {ei.set(ret, "parameters", temp);}))*))? RPAREN LCURLY (((('using' LCURLY ((((temp=ruleVariableDeclaration {ei.set(ret, "variables", temp);} ((temp=ruleVariableDeclaration {ei.set(ret, "variables", temp);}))*))?)) RCURLY) {}| () {}) ((temp=outPattern {ei.set(ret, "outPattern", temp);}) {}| () {}) ((temp=actionBlock {ei.set(ret, "actionBlock", temp);}) {}| () {}))) RCURLY)
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

inPattern returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("InPattern", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('from' ((((temp=inPatternElement {ei.set(ret, "elements", temp);} (((COMA) temp=inPatternElement {ei.set(ret, "elements", temp);}))*)) ((LPAREN ((temp=oclExpression {ei.set(ret, "filter", temp);})) RPAREN) {}| () {}))))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

inPatternElement returns[Object ret2] @init {}
	:	(ret=simpleInPatternElement)
  {
   ei.addToContext(ret, true);
   ret2=ret;
  }

	;

simpleInPatternElement returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("SimpleInPatternElement", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "varName", temp);} COLON temp=oclType {ei.set(ret, "type", temp);} (('in' ((temp=identifier {ei.setRef(ret, "models", "OclModel", "name", temp, "#all", "never", null, false, null);} (((COMA) temp=identifier {ei.setRef(ret, "models", "OclModel", "name", temp, "#all", "never", null, false, null);}))*))?) {}| () {}))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

outPattern returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OutPattern", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('to' ((((temp=outPatternElement {ei.set(ret, "elements", temp);} (((COMA) temp=outPatternElement {ei.set(ret, "elements", temp);}))*)))))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

outPatternElement returns[Object ret2] @init {}
	:	((ret=simpleOutPatternElement| ret=forEachOutPatternElement))
  {
   ei.addToContext(ret, true);
   ret2=ret;
  }

	;

simpleOutPatternElement returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("SimpleOutPatternElement", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "varName", temp);} COLON temp=oclType {ei.set(ret, "type", temp);} (('in' temp=identifier {ei.setRef(ret, "model", "OclModel", "name", temp, "#all", "never", null, false, null);}) {}| () {}) (('mapsTo' temp=identifier {ei.setRef(ret, "sourceElement", "InPatternElement", "varName", temp, null, "never", null, false, null);}) {}| () {}) ((RARROW LPAREN ((temp=oclExpression {ei.set(ret, "reverseBindings", temp);} (((COMA) temp=oclExpression {ei.set(ret, "reverseBindings", temp);}))*))? RPAREN) {}| () {}) ((LPAREN ((((temp=binding {ei.set(ret, "bindings", temp);} (((COMA) temp=binding {ei.set(ret, "bindings", temp);}))*))?)) RPAREN) {}| () {}))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

forEachOutPatternElement returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("ForEachOutPatternElement", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "varName", temp);} COLON 'distinct' temp=oclType {ei.set(ret, "type", temp);} 'foreach' LPAREN temp=iterator {ei.set(ret, "iterator", temp);} 'in' temp=oclExpression {ei.set(ret, "collection", temp);} RPAREN (('mapsTo' temp=identifier {ei.setRef(ret, "sourceElement", "InPatternElement", "varName", temp, null, "never", null, false, null);}) {}| () {}) ((LPAREN ((((temp=binding {ei.set(ret, "bindings", temp);} (((COMA) temp=binding {ei.set(ret, "bindings", temp);}))*))?)) RPAREN) {}| () {}))
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

binding returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Binding", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifierOrKeyword {ei.set(ret, "propertyName", temp);} LARROW temp=oclExpression {ei.set(ret, "value", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

actionBlock returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("ActionBlock", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('do' LCURLY ((((temp=statement {ei.set(ret, "statements", temp);} ((temp=statement {ei.set(ret, "statements", temp);}))*))?)) RCURLY)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

statement returns[Object ret2] @init {}
	:	((ret=ifStat| ret=expressionStat| ret=bindingStat| ret=forStat))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

bindingStat returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("BindingStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=oclExpression {ei.set(ret, "source", temp);} LARROW temp=oclExpression {ei.set(ret, "value", temp);} SEMI)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

expressionStat returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("ExpressionStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=oclExpression {ei.set(ret, "expression", temp);} SEMI)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

ifStat returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("IfStat", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('if' LPAREN temp=oclExpression {ei.set(ret, "condition", temp);} RPAREN ((((temp=statement {ei.set(ret, "thenStatements", temp);}))) {}| (LCURLY ((((temp=statement {ei.set(ret, "thenStatements", temp);} ((temp=statement {ei.set(ret, "thenStatements", temp);}))*))?)) RCURLY) {}) (('else' ((((temp=statement {ei.set(ret, "elseStatements", temp);}))) {}| (LCURLY ((((temp=statement {ei.set(ret, "elseStatements", temp);} ((temp=statement {ei.set(ret, "elseStatements", temp);}))*))?)) RCURLY) {})) {}| () {}))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

forStat returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("ForStat", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('for' LPAREN temp=iterator {ei.set(ret, "iterator", temp);} 'in' temp=oclExpression {ei.set(ret, "collection", temp);} RPAREN LCURLY ((((temp=statement {ei.set(ret, "statements", temp);} ((temp=statement {ei.set(ret, "statements", temp);}))*))?)) RCURLY)
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

oclModel returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OclModel", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "name", temp);} COLON temp=identifier {ei.setRef(ret, "metamodel", "OclModel", "name", temp, "#all", "ifmissing", null, false, null);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

oclModelElement returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OclModelElement", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.setRef(ret, "model", "OclModel", "name", temp, "#all", "ifmissing", null, false, null);} EXCL temp=identifier {ei.set(ret, "name", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

oclExpression returns[Object ret2] @init {}
	:	(ret=priority_5| ret=letExp)
  {
   ret2=ret;
  }

	;

iteratorExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("IteratorExp", true, false) : null;}
	:	(temp=identifier {ei.set(ret, "name", temp);} LPAREN ((temp=iterator {ei.set(ret, "iterators", temp);} (((COMA) temp=iterator {ei.set(ret, "iterators", temp);}))*)) PIPE ((temp=oclExpression {ei.set(ret, "body", temp);})) RPAREN)
  {
   // discard operator name
   ei.set(ret, "source", left);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ei.leaveContext(true);
   ret2=ret;
  }

	;

iterateExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("IterateExp", true, false) : null;}
	:	('iterate' LPAREN ((temp=iterator {ei.set(ret, "iterators", temp);} (((COMA) temp=iterator {ei.set(ret, "iterators", temp);}))*)) SEMI temp=variableDeclaration {ei.set(ret, "result", temp);} PIPE ((temp=oclExpression {ei.set(ret, "body", temp);})) RPAREN)
  {
   // discard operator name
   ei.set(ret, "source", left);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ei.leaveContext(true);
   ret2=ret;
  }

	;

collectionOperationCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("CollectionOperationCallExp", false, false) : null;}
	:	(temp=identifier {ei.set(ret, "operationName", temp);} LPAREN ((temp=oclExpression {ei.set(ret, "arguments", temp);} (((COMA) temp=oclExpression {ei.set(ret, "arguments", temp);}))*))? RPAREN)
  {
   // discard operator name
   ei.set(ret, "source", left);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ei.leaveContext(false);
   ret2=ret;
  }

	;

operationCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OperationCallExp", false, false) : null;}
	:	(temp=identifierOrKeyword {ei.set(ret, "operationName", temp);} LPAREN ((temp=oclExpression {ei.set(ret, "arguments", temp);} (((COMA) temp=oclExpression {ei.set(ret, "arguments", temp);}))*))? RPAREN)
  {
   // discard operator name
   ei.set(ret, "source", left);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ei.leaveContext(false);
   ret2=ret;
  }

	;

navigationOrAttributeCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("NavigationOrAttributeCallExp", false, false) : null;}
	:	(temp=identifierOrKeyword {ei.set(ret, "name", temp);})
  {
   // discard operator name
   ei.set(ret, "source", left);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ei.leaveContext(false);
   ret2=ret;
  }

	;

operatorCallExp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OperatorCallExp", false, false) : null;}
	:
  {
   ei.set(ret, "operationName", opName);
   ei.set(ret, "source", left);
   // post actions performed in calling rule (i.e., priority_<n>)
   ei.leaveContext(false);
   ret2=ret;
  }

	;

iterator returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Iterator", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "varName", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

oclUndefinedExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OclUndefinedExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('OclUndefined')
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

primitiveExp returns[Object ret2] @init {}
	:	((ret=numericExp| ret=booleanExp| ret=stringExp))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

numericExp returns[Object ret2] @init {}
	:	((ret=integerExp| ret=realExp))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

booleanExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("BooleanExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	((('true') {ei.set(ret, "booleanSymbol", java.lang.Boolean.TRUE);}| ('false') {ei.set(ret, "booleanSymbol", java.lang.Boolean.FALSE);}))
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

integerExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("IntegerExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=integerSymbol {ei.set(ret, "integerSymbol", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

realExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("RealExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=floatSymbol {ei.set(ret, "realSymbol", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

stringExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("StringExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=stringSymbol {ei.set(ret, "stringSymbol", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

ifExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("IfExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('if' temp=oclExpression {ei.set(ret, "condition", temp);} 'then' ((temp=oclExpression {ei.set(ret, "thenExpression", temp);})) 'else' ((temp=oclExpression {ei.set(ret, "elseExpression", temp);})) 'endif')
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

variableExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("VariableExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.setRef(ret, "referredVariable", "VariableDeclaration", "varName", temp, null, "ifmissing", null, false, null);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

superExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("SuperExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('super')
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

letExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("LetExp", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('let' temp=variableDeclaration {ei.set(ret, "variable", temp);} 'in' ((temp=oclExpression {ei.set(ret, "in_", temp);})))
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

variableDeclaration returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("VariableDeclaration", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "varName", temp);} COLON temp=oclType {ei.set(ret, "type", temp);} EQ temp=oclExpression {ei.set(ret, "initExpression", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

enumLiteralExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("EnumLiteralExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(SHARP temp=identifier {ei.set(ret, "name", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

collectionExp returns[Object ret2] @init {}
	:	((ret=bagExp| ret=setExp| ret=orderedSetExp| ret=sequenceExp))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

bagExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("BagExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('Bag' LCURLY ((temp=oclExpression {ei.set(ret, "elements", temp);} (((COMA) temp=oclExpression {ei.set(ret, "elements", temp);}))*))? RCURLY)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

setExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("SetExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('Set' LCURLY ((temp=oclExpression {ei.set(ret, "elements", temp);} (((COMA) temp=oclExpression {ei.set(ret, "elements", temp);}))*))? RCURLY)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

orderedSetExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OrderedSetExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('OrderedSet' LCURLY ((temp=oclExpression {ei.set(ret, "elements", temp);} (((COMA) temp=oclExpression {ei.set(ret, "elements", temp);}))*))? RCURLY)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

sequenceExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("SequenceExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('Sequence' LCURLY ((temp=oclExpression {ei.set(ret, "elements", temp);} (((COMA) temp=oclExpression {ei.set(ret, "elements", temp);}))*))? RCURLY)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

mapExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("MapExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('Map' LCURLY ((temp=mapElement {ei.set(ret, "elements", temp);} (((COMA) temp=mapElement {ei.set(ret, "elements", temp);}))*))? RCURLY)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

mapElement returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("MapElement", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(LPAREN temp=oclExpression {ei.set(ret, "key", temp);} COMA temp=oclExpression {ei.set(ret, "value", temp);} RPAREN)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

tupleExp returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("TupleExp", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('Tuple' LCURLY ((temp=tuplePart {ei.set(ret, "tuplePart", temp);} (((COMA) temp=tuplePart {ei.set(ret, "tuplePart", temp);}))*))? RCURLY)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

tuplePart returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("TuplePart", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifierOrKeyword {ei.set(ret, "varName", temp);} ((COLON temp=oclType {ei.set(ret, "type", temp);}) {}| () {}) EQ temp=oclExpression {ei.set(ret, "initExpression", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

oclType returns[Object ret2] @init {}
	:	((ret=oclModelElement| ret=oclAnyType| ret=tupleType| ret=mapType| ret=primitive| ret=collectionType| ret=oclType_abstractContents))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

oclAnyType returns[Object ret2] @init {}
	:	(ret=oclAnyType_abstractContents)
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

tupleType returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("TupleType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('TupleType' LPAREN ((temp=tupleTypeAttribute {ei.set(ret, "attributes", temp);} (((COMA) temp=tupleTypeAttribute {ei.set(ret, "attributes", temp);}))*))? RPAREN)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

tupleTypeAttribute returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("TupleTypeAttribute", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(temp=identifier {ei.set(ret, "name", temp);} COLON temp=oclType {ei.set(ret, "type", temp);})
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

mapType returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("MapType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('Map' LPAREN temp=oclType {ei.set(ret, "keyType", temp);} COMA temp=oclType {ei.set(ret, "valueType", temp);} RPAREN)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

primitive returns[Object ret2] @init {}
	:	((ret=numericType| ret=booleanType| ret=stringType))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

numericType returns[Object ret2] @init {}
	:	((ret=integerType| ret=realType))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

integerType returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("IntegerType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('Integer')
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

realType returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("RealType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('Real')
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

booleanType returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("BooleanType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('Boolean')
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

stringType returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("StringType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('String')
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

collectionType returns[Object ret2] @init {}
	:	((ret=bagType| ret=setType| ret=orderedSetType| ret=sequenceType| ret=collectionType_abstractContents))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

bagType returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("BagType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('Bag' LPAREN temp=oclType {ei.set(ret, "elementType", temp);} RPAREN)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

setType returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("SetType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('Set' LPAREN temp=oclType {ei.set(ret, "elementType", temp);} RPAREN)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

orderedSetType returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OrderedSetType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('OrderedSet' LPAREN temp=oclType {ei.set(ret, "elementType", temp);} RPAREN)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

sequenceType returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("SequenceType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('Sequence' LPAREN temp=oclType {ei.set(ret, "elementType", temp);} RPAREN)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

priority_0 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(ret=primary_oclExpression (((POINT {opName = ".";} (ret=operationCallExp[opName, ret, firstToken] | ret=navigationOrAttributeCallExp[opName, ret, firstToken] ))| (RARROW {opName = "->";} (ret=iteratorExp[opName, ret, firstToken] | ret=iterateExp[opName, ret, firstToken] | ret=collectionOperationCallExp[opName, ret, firstToken] ))))*)
  {
   ret2=ret;
  }

	;

priority_1 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(('not' {opName = "not";} (ret=operatorCallExp[opName, right, firstToken] right=priority_0 {ei.set(ret, "source", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (MINUS {opName = "-";} (ret=operatorCallExp[opName, right, firstToken] right=priority_0 {ei.set(ret, "source", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (ret=priority_0))
  {
   ret2=ret;
  }

	;

priority_2 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(ret=priority_1 (((STAR {opName = "*";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_1 {ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (SLASH {opName = "/";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_1 {ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| ('div' {opName = "div";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_1 {ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| ('mod' {opName = "mod";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_1 {ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))))*)
  {
   ret2=ret;
  }

	;

priority_3 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(ret=priority_2 (((PLUS {opName = "+";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_2 {ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (MINUS {opName = "-";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_2 {ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))))*)
  {
   ret2=ret;
  }

	;

priority_4 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(ret=priority_3 (((EQ {opName = "=";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_3 {ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (GT {opName = ">";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_3 {ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (LT {opName = "<";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_3 {ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (GE {opName = ">=";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_3 {ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (LE {opName = "<=";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_3 {ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| (NE {opName = "<>";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_3 {ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))))*)
  {
   ret2=ret;
  }

	;

priority_5 returns[Object ret2] @init {java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(ret=priority_4 ((('and' {opName = "and";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_4 {ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| ('or' {opName = "or";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_4 {ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| ('xor' {opName = "xor";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_4 {ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))| ('implies' {opName = "implies";} (ret=operatorCallExp[opName, ret, firstToken] right=priority_4 {ei.set(ret, "arguments", right);if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});}))))*)
  {
   ret2=ret;
  }

	;

matchedRule_abstractContents returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("MatchedRule", true, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	((('nodefault') {ei.set(ret, "isNoDefault", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isNoDefault", java.lang.Boolean.FALSE);}) (('abstract') {ei.set(ret, "isAbstract", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isAbstract", java.lang.Boolean.FALSE);}) (('refining') {ei.set(ret, "isRefining", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isRefining", java.lang.Boolean.FALSE);}) 'rule' temp=identifier {ei.set(ret, "name", temp);} (('extends' temp=identifier {ei.setRef(ret, "superRule", "MatchedRule", "name", temp, null, "never", null, true, null);}) {}| () {}) LCURLY ((temp=inPattern {ei.set(ret, "inPattern", temp);} (('using' LCURLY ((((temp=ruleVariableDeclaration {ei.set(ret, "variables", temp);} ((temp=ruleVariableDeclaration {ei.set(ret, "variables", temp);}))*))?)) RCURLY) {}| () {}) ((temp=outPattern {ei.set(ret, "outPattern", temp);}) {}| () {}) ((temp=actionBlock {ei.set(ret, "actionBlock", temp);}) {}| () {}))) RCURLY)
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

oclType_abstractContents returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OclType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('OclType')
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

oclAnyType_abstractContents returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("OclAnyType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('OclAny')
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

collectionType_abstractContents returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("CollectionType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('Collection' LPAREN temp=oclType {ei.set(ret, "elementType", temp);} RPAREN)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

primary_oclExpression returns[Object ret2] @init {}
	:	(ret=variableExp| ret=oclUndefinedExp| ret=primitiveExp| ret=ifExp| ret=superExp| ret=enumLiteralExp| ret=collectionExp| ret=mapExp| ret=tupleExp| ret=oclType| (LPAREN ret=oclExpression RPAREN))
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
//	:	(ALPHA) (ALPHA | DIGIT | {LA(2) == ':'}?':' ':')*
//TODO:	:	(ALPHA) (ALPHA | DIGIT | {input.LA(2) == ':'}?':' ':')*
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
