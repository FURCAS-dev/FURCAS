grammar KM3_ANTLR3;@header {package org.eclipse.gmt.tcs.injector;}@lexer::header {package org.eclipse.gmt.tcs.injector;}@lexer::members {

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
 KM3_ANTLR3Lexer lex = new 
 KM3_ANTLR3Lexer(input);
						CommonTokenStream tokens = new CommonTokenStream(lex);
						tokens.discardTokenType(WS);
						tokens.discardTokenType(COMMENT);
						tokens.discardTokenType(NL);
						
 KM3_ANTLR3Parser parser = new 
 KM3_ANTLR3Parser(tokens);
						parser.main();
					}
}

main returns[Object ret2] @init {}
	:	((ret=metamodel) EOF)
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

metamodel returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Metamodel", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(((((temp=package_ {ei.set(ret, "contents", temp);} ((temp=package_ {ei.set(ret, "contents", temp);}))*))?)))
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

modelElement returns[Object ret2] @init {}
	:	((ret=packageElement| ret=structuralFeature| ret=enumLiteral))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

packageElement returns[Object ret2] @init {}
	:	((ret=classifier| ret=package_))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

classifier returns[Object ret2] @init {}
	:	((ret=dataType| ret=class_))
  {
   ei.addToContext(ret, true);
   ret2=ret;
  }

	;

package_ returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Package", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('package' temp=identifier {ei.set(ret, "name", temp);} LCURLY ((((temp=packageElement {ei.set(ret, "contents", temp);} ((temp=packageElement {ei.set(ret, "contents", temp);}))*))?)) RCURLY)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

dataType returns[Object ret2] @init {}
	:	((ret=enumeration| ret=dataType_abstractContents))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

class_ returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Class", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	((('abstract') {ei.set(ret, "isAbstract", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isAbstract", java.lang.Boolean.FALSE);}) 'class' temp=identifier {ei.set(ret, "name", temp);} (('extends' ((temp=identifier {ei.setRef(ret, "supertypes", "Class", "name", temp, null, "never", null, false, null);} (((COMA) temp=identifier {ei.setRef(ret, "supertypes", "Class", "name", temp, null, "never", null, false, null);}))*))?) {}| () {}) LCURLY ((((temp=structuralFeature {ei.set(ret, "structuralFeatures", temp);} ((temp=structuralFeature {ei.set(ret, "structuralFeatures", temp);}))*))?)) RCURLY)
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

structuralFeature returns[Object ret2] @init {}
	:	((ret=reference| ret=attribute))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

reference returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Reference", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('reference' temp=identifier {ei.set(ret, "name", temp);} multiplicity[ret] (('ordered') {ei.set(ret, "isOrdered", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isOrdered", java.lang.Boolean.FALSE);}) (('container') {ei.set(ret, "isContainer", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isContainer", java.lang.Boolean.FALSE);}) COLON temp=identifier {ei.setRef(ret, "type", "Classifier", "name", temp, null, "never", null, false, null);} (('oppositeOf' temp=identifier {ei.setRef(ret, "opposite", "Reference", "name", temp, "type", "never", null, false, null);}) {}| () {}) SEMI)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

attribute returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Attribute", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	((('unique') {ei.set(ret, "isUnique", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isUnique", java.lang.Boolean.FALSE);}) 'attribute' temp=identifier {ei.set(ret, "name", temp);} multiplicity[ret] (('ordered') {ei.set(ret, "isOrdered", java.lang.Boolean.TRUE);}| () {ei.set(ret, "isOrdered", java.lang.Boolean.FALSE);}) COLON temp=identifier {ei.setRef(ret, "type", "Classifier", "name", temp, null, "never", null, false, null);} SEMI)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

enumeration returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Enumeration", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('enumeration' temp=identifier {ei.set(ret, "name", temp);} LCURLY ((((temp=enumLiteral {ei.set(ret, "literals", temp);} ((temp=enumLiteral {ei.set(ret, "literals", temp);}))*))?)) RCURLY)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

enumLiteral returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("EnumLiteral", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('literal' temp=identifier {ei.set(ret, "name", temp);} SEMI)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

multiplicity[Object ret] @init {}
	:	((() {ei.set(ret, "lower", new java.lang.Integer(1)); ei.set(ret, "upper", new java.lang.Integer(1));}| (((LSQUARE STAR RSQUARE) {ei.set(ret, "lower", new java.lang.Integer(0)); ei.set(ret, "upper", new java.lang.Integer(-1));}| (((LSQUARE temp=integerSymbol {ei.set(ret, "lower", temp);} MINUS STAR RSQUARE) {ei.set(ret, "upper", new java.lang.Integer(-1));}| (LSQUARE temp=integerSymbol {ei.set(ret, "lower", temp);} MINUS temp=integerSymbol {ei.set(ret, "upper", temp);} RSQUARE) {})) {})) {}))
  {
   
  }

	;

dataType_abstractContents returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("DataType", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('datatype' temp=identifier {ei.set(ret, "name", temp);} SEMI)
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
//	{
//	if($getText.equals("true")) $setType(BOOLEAN);
//	if($getText.equals("false")) $setType(BOOLEAN);
//	}
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
		(	'n' {setText("\n");}
		|	'r' {setText("\r");}
		|	't' {setText("\t");}
		|	'b' {setText("\b");}
		|	'f' {setText("\f");}
		|	'"' {setText("\"");}
		|	'\'' {setText("\'");}
		|	'\\' {setText("\\");}
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
					String s = getText();
					int i;
					int ret = 0;
					String ans;
					for (i=0; i<s.length(); ++i)
						ret = ret*8 + s.charAt(i) - '0';
					ans = String.valueOf((char) ret);
					setText(ans);
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

COLONS @init {}
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
