/**
 * 
 * @author Octavian Patrascoiu
 *
 */

// Usercode Section
package de.ikv.medini.qvt.syntax.parser;

import java.io.Reader;
import org.oslo.ocl20.OclProcessorImpl;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory.Location;
import uk.ac.kent.cs.kmf.util.ILog;
      
%%  
// Options Sections
%unicode
%cup
%line
%column
   
// Declarations Section
%{
	private ComplexSymbolFactory sf; 
	public Yylex(Reader r, ComplexSymbolFactory sf){
                this(r);
                this.sf=sf;
    } 

	// Debug flag
	public static boolean lexDebug = false;
	protected void debug(int type) {
    	if (lexDebug) {
    		log.reportMessage(yyline+":"+yycolumn+" Token "+type+" '"+yytext()+"'");		
    	}
	}

	// Output log
	protected ILog log;
	public void setLog(ILog log) {
		this.log = log;
	}
	
    // Create a new java_cup.runtime.Symbol with information about the current token
    protected Symbol symbol(int type) {
    	debug(type);
    	return sf.newSymbol("", type,new Location(yyline+1+OclProcessorImpl.lineDelta,yycolumn+1),new Location(yyline+1+OclProcessorImpl.lineDelta,yycolumn+1+yylength()), yytext());
    }
    protected Symbol symbol(int type, Object value) {
		debug(type);
		return sf.newSymbol("", type, new Location(yyline+1+OclProcessorImpl.lineDelta, yycolumn +1), new Location(yyline+1+OclProcessorImpl.lineDelta,yycolumn+1+yylength()), value);
    }
%}
   
%eofval{
	return symbol(sym.EOF);
%eofval}


// Macro declarations
lineTerminator 		= \r|\n|\r\n|\n\r
whiteSpace     		= [ \t\f\n\r]
comment				= {paragraphComment} | {lineComment} | {lineCommentTwo}
paragraphComment	= "/*" ~"*/"
lineComment			= "--" ~{lineTerminator}
lineCommentTwo		= "//" ~{lineTerminator}

lowerCase			= [a-z]
upperCase			= [A-Z]
digit				= [0-9]
letter				= {lowerCase} | {upperCase} | [_]
alpha				= {letter} | {digit}
integer				= {digit}+
real				= {integer}"\."{integer}[eE][+-]?{integer} | {integer}[eE][+-]?{integer} | {integer}"\."{integer} 
string				= ("'" ~"'")+
simpleName			= {letter}{alpha}*

%%
// Lexical Rules Section 
   
<YYINITIAL> {  
	{whiteSpace}		{ /* just skip what was found, do nothing */ }   
	{comment}			{ /* just skip what was found, do nothing */ }   
	
//################### QVT stuff ###################################################################

	"import"			{ return symbol(sym.IMPORT); }
	"transformation"    { return symbol(sym.TRANSFORMATION); }
	"extends"			{ return symbol(sym.EXTENDS); }
	"key"				{ return symbol(sym.KEY); }
	"top"				{ return symbol(sym.TOP); }
	"relation"			{ return symbol(sym.RELATION); }
	"overrides"			{ return symbol(sym.OVERRIDES); }
	"domain"			{ return symbol(sym.DOMAIN); }
	"implementedby"		{ return symbol(sym.IMPLEMENTEDBY); }
	"primitive"			{ return symbol(sym.PRIMITIVE); }
	"checkonly"			{ return symbol(sym.CHECKONLY); }
	"enforce"			{ return symbol(sym.ENFORCE); }
	"when"				{ return symbol(sym.WHEN); }
	"where"				{ return symbol(sym.WHERE); }
	"query"				{ return symbol(sym.QUERY); }
	"++"				{ return symbol(sym.DOUBLEPLUS); }
	

//################### QVT stuff end ###############################################################


	".."				{ return symbol(sym.DOT_DOT); }
	"::"				{ return symbol(sym.COLON_COLON); }
	"^^"				{ return symbol(sym.UP_UP); }
	"."					{ return symbol(sym.DOT); }
	":"					{ return symbol(sym.COLON); }
	"^"					{ return symbol(sym.UP); }

	"("					{ return symbol(sym.LEFT_PAR); }
	"["					{ return symbol(sym.LEFT_BRK); }
	"{"					{ return symbol(sym.LEFT_BRA); }
	")"					{ return symbol(sym.RIGHT_PAR); }
	"]"					{ return symbol(sym.RIGHT_BRK); }
	"}"					{ return symbol(sym.RIGHT_BRA); }
	
	","					{ return symbol(sym.COMMA); }
	";"					{ return symbol(sym.SEMICOLON); }
	"|"					{ return symbol(sym.BAR); }
	"@"					{ return symbol(sym.AT); }
	"?"					{ return symbol(sym.QUESTION); }

	{real}				{ return symbol(sym.REAL); }
	{integer}			{ return symbol(sym.INTEGER); }

	"implies"			{ return symbol(sym.IMPLIES); }

	"and"				{ return symbol(sym.AND); }
	"or"				{ return symbol(sym.OR); }
	"xor"				{ return symbol(sym.XOR); }
	
	"="					{ return symbol(sym.EQ); }
	"<>"				{ return symbol(sym.NE); }

	"<="				{ return symbol(sym.LE); }
	">="				{ return symbol(sym.GE); }
	"<"					{ return symbol(sym.LT); }
	">"					{ return symbol(sym.GT); }

	"+"					{ return symbol(sym.PLUS); }
	"->"				{ return symbol(sym.MINUS_GT); }
	"-"					{ return symbol(sym.MINUS); }

	"*"					{ return symbol(sym.TIMES); }
	"/"					{ return symbol(sym.DIVIDE); }
	"div"				{ return symbol(sym.INT_DIVIDE); }
	"mod"				{ return symbol(sym.INT_MOD); }

	"Set"				{ return symbol(sym.SET); }
	"Bag"				{ return symbol(sym.BAG); }
	"Sequence"			{ return symbol(sym.SEQUENCE); }
	"Collection"		{ return symbol(sym.COLLECTION); }
	"OrderedSet"		{ return symbol(sym.ORDERED_SET); }
	"TupleType"			{ return symbol(sym.TUPLE_TYPE); }
	"Tuple"				{ return symbol(sym.TUPLE); }
	"iterate"			{ return symbol(sym.ITERATE); }

	"if"				{ return symbol(sym.IF); }
	"then"				{ return symbol(sym.THEN); }
	"else"				{ return symbol(sym.ELSE); }
	"endif"				{ return symbol(sym.ENDIF); }
	"not"				{ return symbol(sym.NOT); }
	"true"				{ return symbol(sym.TRUE); }
	"false"				{ return symbol(sym.FALSE); }
	"undefined"			{ return symbol(sym.UNDEFINED); }
	"let"				{ return symbol(sym.LET); }
	"package"			{ return symbol(sym.PACKAGE); }
	"endpackage"		{ return symbol(sym.ENDPACKAGE); }
	"context"			{ return symbol(sym.CONTEXT); }
	"init"				{ return symbol(sym.INIT); }
	"derive"			{ return symbol(sym.DERIVE); }
	"inv"				{ return symbol(sym.INV); }
	"def"				{ return symbol(sym.DEF); }
	"pre"				{ return symbol(sym.PRE); }
	"post"				{ return symbol(sym.POST); }
	"body"				{ return symbol(sym.BODY); }
	"in"				{ return symbol(sym.IN); }

	{simpleName}		{ return symbol(sym.SIMPLE_NAME); }
	{string}			{ return symbol(sym.STRING); }
}

[^]						{ log.reportError("Illegal character '"+yytext()+"'"); return symbol(sym.BAD);}
