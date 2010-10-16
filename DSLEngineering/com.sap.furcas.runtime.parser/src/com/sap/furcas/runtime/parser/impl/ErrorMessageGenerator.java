/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-04-23 14:54:43 +0200 (Do, 23 Apr 2009) $
 * Revision: $Revision: 6272 $
 * Author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.runtime.parser.impl;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.FailedPredicateException;
import org.antlr.runtime.MismatchedNotSetException;
import org.antlr.runtime.MismatchedRangeException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.MismatchedTreeNodeException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;

import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationToken;



/**
 * Deciphers ANTLR3 error messages and creates an Error class. TODO use
 * externalized Strings an i18n.
 * 
 * @author C5107456
 */
public class ErrorMessageGenerator {

	/**
	 * Gets the parsing error.
	 * 
	 * @param e the exception
	 * @param tokenNames the token names
	 * 
	 * @return the parsing error
	 */
	public static ParsingError getParsingError(RecognitionException e, String[] tokenNames) {
	    
//	    e.printStackTrace();
	    
		String msg = null;
		ANTLR3LocationToken token = null;
		if (e.token instanceof ANTLR3LocationToken) {
            token = (ANTLR3LocationToken) e.token;
        }
		if (e.input instanceof ANTLRStringStream) { // Lexer Exception
			if (e instanceof MismatchedTokenException) {
				MismatchedTokenException mte = (MismatchedTokenException) e;
				msg = "Mismatched character " + getCharErrorDisplay(e.c)
						+ " expecting " + getCharErrorDisplay(mte.expecting);
			} else if (e instanceof NoViableAltException) {
//				NoViableAltException nvae = (NoViableAltException) e;
				// for development, can add
				// "decision=<<"+nvae.grammarDecisionDescription+">>"
				// and "(decision="+nvae.decisionNumber+") and
				// "state "+nvae.stateNumber
				msg = "No viable alternative at character "
						+ getCharErrorDisplay(e.c);
			} else if (e instanceof EarlyExitException) {
//				EarlyExitException eee = (EarlyExitException) e;
				// for development, can add "(decision="+eee.decisionNumber+")"
				msg = "Required (...)+ loop did not match anything at character "
						+ getCharErrorDisplay(e.c);
			} else if (e instanceof MismatchedNotSetException) {
				MismatchedNotSetException mse = (MismatchedNotSetException) e;
				msg = "Mismatched character " + getCharErrorDisplay(e.c)
						+ " expecting set " + mse.expecting;
			} else if (e instanceof MismatchedSetException) {
				MismatchedSetException mse = (MismatchedSetException) e;
				msg = "mismatched character " + getCharErrorDisplay(e.c)
						+ " expecting set " + mse.expecting;
			} else if (e instanceof MismatchedRangeException) {
				MismatchedRangeException mre = (MismatchedRangeException) e;
				msg = "Mismatched character " + getCharErrorDisplay(e.c)
						+ " expecting set " + getCharErrorDisplay(mre.a) + ".."
						+ getCharErrorDisplay(mre.b);
			} else {
				msg = "Unknown Exception";
			}
			
		} else { //  Parser Exception
			if (e instanceof MismatchedTokenException) {
				MismatchedTokenException mte = (MismatchedTokenException) e;
				String tokenName = "<unknown>";
				if (mte.expecting == Token.EOF) {
					tokenName = "EOF";
				} else {
				    if (tokenNames != null && tokenNames.length > mte.index) {
				        tokenName = tokenNames[mte.index];
				    } else {
				        tokenName = "<Bug>";
				    }
					
				}
				msg = "Mismatched input " + getTokenErrorDisplay(e.token)
						+ " expecting " + tokenName;
			} else if (e instanceof MismatchedTreeNodeException) {
				MismatchedTreeNodeException mtne = (MismatchedTreeNodeException) e;
				String tokenName = "<unknown>";
				if (mtne.expecting == Token.EOF) {
					tokenName = "EOF";
				} else {
				    if (tokenNames != null) {
					tokenName = tokenNames[mtne.expecting];
				    } else {
					tokenName = "<Bug>";
				    }
				}
				msg = "Mismatched tree node: " + mtne.node + " expecting "
						+ tokenName;
			} else if (e instanceof NoViableAltException) {
//				NoViableAltException nvae = (NoViableAltException) e;
				// for development, can add
				// "decision=<<"+nvae.grammarDecisionDescription+">>"
				// and "(decision="+nvae.decisionNumber+") and
				// "state "+nvae.stateNumber
				msg = "No viable alternative at input "
						+ getTokenErrorDisplay(e.token);
			} else if (e instanceof EarlyExitException) {
//				EarlyExitException eee = (EarlyExitException) e;
				// for development, can add "(decision="+eee.decisionNumber+")"
				msg = "Required (...)+ loop did not match anything at input "
						+ getTokenErrorDisplay(e.token);
			} else if (e instanceof MismatchedSetException) {
				MismatchedSetException mse = (MismatchedSetException) e;
				msg = "Mismatched input " + getTokenErrorDisplay(e.token)
						+ " expecting set " + mse.expecting;
			} else if (e instanceof MismatchedNotSetException) {
				MismatchedNotSetException mse = (MismatchedNotSetException) e;
				msg = "Mismatched input " + getTokenErrorDisplay(e.token)
						+ " expecting set " + mse.expecting;
			} else if (e instanceof FailedPredicateException) {
				FailedPredicateException fpe = (FailedPredicateException) e;
				msg = "Rule " + fpe.ruleName + " failed predicate: {"
						+ fpe.predicateText + "}?";
			} else {
				msg = "Unknown Exception";
			}

		}

		if (token != null) {
//		    System.out.println(token);
		    return new ParsingError(msg, token);
		} else {
		    TextLocation location = new TextLocation(e.index, -1 , e.line, e.charPositionInLine, e.line, e.charPositionInLine);
		    return new ParsingError(msg, location );
		}
	}


    /**
	 * How should a token be displayed in an error message? The default is to
	 * display just the text, but during development you might want to have a
	 * lot of information spit out. Override in that case to use t.toString()
	 * (which, for CommonToken, dumps everything about the token). This is
	 * better than forcing you to override a method in your token objects
	 * because you don't have to go modify your lexer so that it creates a new
	 * Java type.
	 * 
	 * @param t the t
	 * 
	 * @return the token error display
	 */
	public static String getTokenErrorDisplay(Token t) {
	    if (t!= null) {
		String s = t.getText();
		if (s == null) {
			if (t.getType() == Token.EOF) {
				s = "<EOF>";
			} else {
				s = "<" + t.getType() + ">";
			}
		}
		s = s.replaceAll("\n", "\\\\n");
		s = s.replaceAll("\r", "\\\\r");
		s = s.replaceAll("\t", "\\\\t");
		return "'" + s + "'";
	    } else {
	        return "<Bug2>";
	    }
	}

	/**
	 * Gets the char error display.
	 * 
	 * @param c the c
	 * 
	 * @return the char error display
	 */
	public static String getCharErrorDisplay(int c) {
		String s = String.valueOf((char) c);
		switch (c) {
		case Token.EOF:
			s = "<EOF>";
			break;
		case '\n':
			s = "\\n";
			break;
		case '\t':
			s = "\\t";
			break;
		case '\r':
			s = "\\r";
			break;
		}
		return "'" + s + "'";
	}

}
