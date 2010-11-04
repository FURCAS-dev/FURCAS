grammar SimpleTCS_ANTLR3;

@header {package org.eclipse.gmt.tcs.injector;}

@lexer::header {package org.eclipse.gmt.tcs.injector;}

@lexer::members {

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
 SimpleTCS_ANTLR3Lexer lex = new 
 SimpleTCS_ANTLR3Lexer(input);
						CommonTokenStream tokens = new CommonTokenStream(lex);
						tokens.discardTokenType(WS);
						tokens.discardTokenType(COMMENT);
						tokens.discardTokenType(NL);
						
 SimpleTCS_ANTLR3Parser parser = new 
 SimpleTCS_ANTLR3Parser(tokens);
						parser.main();
					}
}

main returns[Object ret2] @init {}
	:	((ret=bibTextFile) EOF)
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

bibTextFile returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("BibTextFile", true, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	(((((temp=bibTextEntry {ei.set(ret, "entries", temp);} ((temp=bibTextEntry {ei.set(ret, "entries", temp);}))*))?)))
  {
   ei.leaveContext(true);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

bibTextEntry returns[Object ret2] @init {}
	:	((ret=article| ret=author))
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

article returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Article", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('article' LCURLY ((temp=identifier {ei.set(ret, "key", temp);} COMA temp=identifier {ei.setRef(ret, "author", "Author", "name", temp, null, "never", null, false, null);} COMA ((temp=attribute {ei.set(ret, "attributes", temp);} (((COMA) temp=attribute {ei.set(ret, "attributes", temp);}))*))?)) RCURLY)
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

attribute returns[Object ret2] @init {}
	:	(ret=year)
  {
   ei.addToContext(ret, false);
   ret2=ret;
  }

	;

author returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Author", false, true) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('author' '=' temp=identifier {ei.set(ret, "name", temp);} '.')
  {
   ei.leaveContext(false);
   if(input.LT(-1) != null) ei.setLocation(ret, firstToken.getLine() + ":" + (firstToken.getCharPositionInLine() + 1) + "-" + ((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndLine() + ":" + (((org.eclipse.gmt.tcs.injector.wrappers.antlr3.ANTLR3LocationToken)input.LT(-1)).getEndColumn() + 1));ei.setCommentsBefore(ret, new Object[] {input, firstToken});
	   ei.setCommentsAfter(ret, new Object[] {input, input.LT(-1)});
   ret2=ret;
  }

	;

year returns[Object ret2] @init {Object ret=(backtracking==0) ? ei.create("Year", false, false) : null;org.antlr.runtime.Token firstToken=input.LT(1);}
	:	('year' '=' temp=identifier {ei.set(ret, "value", temp);})
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

	

COMA @init {}
	:	','
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

COMMENT @init {}
	:	(('--' (~('\r'| '\n'))*))
  {
   
  }

	;
