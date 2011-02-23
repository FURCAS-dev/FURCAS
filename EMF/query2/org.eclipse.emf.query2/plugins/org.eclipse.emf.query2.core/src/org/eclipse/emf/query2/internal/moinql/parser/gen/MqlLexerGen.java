/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
/**
   * This file is generated for MOIN-MQL with LPG. 
   */

package org.eclipse.emf.query2.internal.moinql.parser.gen;

import org.eclipse.emf.query2.exception.BaseException;
import org.eclipse.emf.query2.exception.BaseRuntimeException;
import org.eclipse.emf.query2.internal.moinql.parser.AstException;
import org.eclipse.emf.query2.internal.moinql.parser.LPGMessages;
import org.eclipse.emf.query2.internal.report.ProcessErrorImpl;
import org.eclipse.emf.query2.report.LocalizedProcessException;
import org.eclipse.emf.query2.report.ProcessReport;

import lpg.lpgjavaruntime.*;


public class MqlLexerGen extends LpgLexStream implements MqlParserGensym, MqlLexerGensym, RuleAction
{
    private static ParseTable prs = new MqlLexerGenprs();
    private PrsStream prsStream;
    private LexParser lexParser = new LexParser(this, prs, this);

    public PrsStream getPrsStream() { return prsStream; }
    public int getToken(int i) { return lexParser.getToken(i); }
    public int getRhsFirstTokenIndex(int i) { return lexParser.getFirstToken(i); }
    public int getRhsLastTokenIndex(int i) { return lexParser.getLastToken(i); }

    public int getLeftSpan() { return lexParser.getFirstToken(); }
    public int getRightSpan() { return lexParser.getLastToken(); }

    public MqlLexerGen(String filename, int tab) throws java.io.IOException 
    {
        super(filename, tab);
    }

    public MqlLexerGen(char[] input_chars, String filename, int tab)
    {
        super(input_chars, filename, tab);
    }

    public MqlLexerGen(char[] input_chars, String filename)
    {
        this(input_chars, filename, 1);
    }

    public MqlLexerGen() {}

    public String[] orderedExportedSymbols() { return MqlParserGensym.orderedTerminalSymbols; }
    public LexStream getLexStream() { return (LexStream) this; }

    public void lexer(PrsStream prsStream)
    {
        lexer(null, prsStream);
    }
    
    public void lexer(Monitor monitor, PrsStream prsStream)
    {
        if (getInputChars() == null)
            throw new NullPointerException(LPGMessages.LPG_LEXSTREAM_NOT_INITIALIZED.toString());

        this.prsStream = prsStream;

        prsStream.makeToken(0, 0, 0); // Token list must start with a bad token
            
        lexParser.parseCharacters(monitor);  // Lex the input characters
            
        int i = getStreamIndex();
        prsStream.makeToken(i, i, TK_EOF_TOKEN); // and end with the end of file token
        prsStream.setStreamLength(prsStream.getSize());
            
        return;
    }

    //
    // The Lexer contains an array of characters as the input stream to be parsed.
    // There are methods to retrieve and classify characters.
    // The lexparser "token" is implemented simply as the index of the next character in the array.
    // The Lexer extends the abstract class LpgLexStream with an implementation of the abstract
    // method getKind.  The template defines the Lexer class and the lexer() method.
    // A driver creates the action class, "Lexer", passing an Option object to the constructor.
    //
    MqlKeywordLexer kwLexer;
    boolean printTokens;
    private final static int ECLIPSE_TAB_VALUE = 4;

    public int [] getKeywordKinds() { return kwLexer.getKeywordKinds(); }

    public MqlLexerGen(String filename) throws java.io.IOException
    {
        this(filename, ECLIPSE_TAB_VALUE);
        this.kwLexer = new MqlKeywordLexer(getInputChars(), TK_IDENTIFIER);
    }

    public void initialize(char [] content, String filename)
    {
        super.initialize(content, filename);
        if (this.kwLexer == null)
             this.kwLexer = new MqlKeywordLexer(getInputChars(), TK_IDENTIFIER);
        else this.kwLexer.setInputChars(getInputChars());
    }
    
    final void makeToken(int kind)
    {
        int startOffset = getLeftSpan(),
            endOffset = getRightSpan();
        makeToken(startOffset, endOffset, kind);
        if (printTokens) printValue(startOffset, endOffset);
    }

    final void makeComment(int kind)
    {
        int startOffset = getLeftSpan(),
            endOffset = getRightSpan();
        super.getPrsStream().makeAdjunct(startOffset, endOffset, kind);
    }

    final void skipToken()
    {
        if (printTokens) printValue(getLeftSpan(), getRightSpan());
    }
    
    final void checkForKeyWord()
    {
        int startOffset = getLeftSpan(),
            endOffset = getRightSpan(),
        kwKind = kwLexer.lexer(startOffset, endOffset);
        makeToken(startOffset, endOffset, kwKind);
        if (printTokens) printValue(startOffset, endOffset);
    }
    
    final void printValue(int startOffset, int endOffset)
    {
        String s = new String(getInputChars(), startOffset, endOffset - startOffset + 1);
        System.out.print(s);
    }

    //
    //
    //
    public final static int tokenKind[] =
    {
        Char_CtlCharNotWS,    // 000    0x00
        Char_CtlCharNotWS,    // 001    0x01
        Char_CtlCharNotWS,    // 002    0x02
        Char_CtlCharNotWS,    // 003    0x03
        Char_CtlCharNotWS,    // 004    0x04
        Char_CtlCharNotWS,    // 005    0x05
        Char_CtlCharNotWS,    // 006    0x06
        Char_CtlCharNotWS,    // 007    0x07
        Char_CtlCharNotWS,    // 008    0x08
        Char_HT,              // 009    0x09
        Char_LF,              // 010    0x0A
        Char_CtlCharNotWS,    // 011    0x0B
        Char_FF,              // 012    0x0C
        Char_CR,              // 013    0x0D
        Char_CtlCharNotWS,    // 014    0x0E
        Char_CtlCharNotWS,    // 015    0x0F
        Char_CtlCharNotWS,    // 016    0x10
        Char_CtlCharNotWS,    // 017    0x11
        Char_CtlCharNotWS,    // 018    0x12
        Char_CtlCharNotWS,    // 019    0x13
        Char_CtlCharNotWS,    // 020    0x14
        Char_CtlCharNotWS,    // 021    0x15
        Char_CtlCharNotWS,    // 022    0x16
        Char_CtlCharNotWS,    // 023    0x17
        Char_CtlCharNotWS,    // 024    0x18
        Char_CtlCharNotWS,    // 025    0x19
        Char_CtlCharNotWS,    // 026    0x1A
        Char_CtlCharNotWS,    // 027    0x1B
        Char_CtlCharNotWS,    // 028    0x1C
        Char_CtlCharNotWS,    // 029    0x1D
        Char_CtlCharNotWS,    // 030    0x1E
        Char_CtlCharNotWS,    // 031    0x1F
        Char_Space,           // 032    0x20
        Char_Exclamation,     // 033    0x21
        Char_DoubleQuote,     // 034    0x22
        Char_Sharp,           // 035    0x23
        Char_DollarSign,      // 036    0x24
        Char_Percent,         // 037    0x25
        Char_Ampersand,       // 038    0x26
        Char_SingleQuote,     // 039    0x27
        Char_LeftParen,       // 040    0x28
        Char_RightParen,      // 041    0x29
        Char_Star,            // 042    0x2A
        Char_Plus,            // 043    0x2B
        Char_Comma,           // 044    0x2C
        Char_Minus,           // 045    0x2D
        Char_Dot,             // 046    0x2E
        Char_Slash,           // 047    0x2F
        Char_0,               // 048    0x30
        Char_1,               // 049    0x31
        Char_2,               // 050    0x32
        Char_3,               // 051    0x33
        Char_4,               // 052    0x34
        Char_5,               // 053    0x35
        Char_6,               // 054    0x36
        Char_7,               // 055    0x37
        Char_8,               // 056    0x38
        Char_9,               // 057    0x39
        Char_Colon,           // 058    0x3A
        Char_SemiColon,       // 059    0x3B
        Char_LessThan,        // 060    0x3C
        Char_Equal,           // 061    0x3D
        Char_GreaterThan,     // 062    0x3E
        Char_QuestionMark,    // 063    0x3F
        Char_AtSign,          // 064    0x40
        Char_A,               // 065    0x41
        Char_B,               // 066    0x42
        Char_C,               // 067    0x43
        Char_D,               // 068    0x44
        Char_E,               // 069    0x45
        Char_F,               // 070    0x46
        Char_G,               // 071    0x47
        Char_H,               // 072    0x48
        Char_I,               // 073    0x49
        Char_J,               // 074    0x4A
        Char_K,               // 075    0x4B
        Char_L,               // 076    0x4C
        Char_M,               // 077    0x4D
        Char_N,               // 078    0x4E
        Char_O,               // 079    0x4F
        Char_P,               // 080    0x50
        Char_Q,               // 081    0x51
        Char_R,               // 082    0x52
        Char_S,               // 083    0x53
        Char_T,               // 084    0x54
        Char_U,               // 085    0x55
        Char_V,               // 086    0x56
        Char_W,               // 087    0x57
        Char_X,               // 088    0x58
        Char_Y,               // 089    0x59
        Char_Z,               // 090    0x5A
        Char_LeftBracket,     // 091    0x5B
        Char_BackSlash,       // 092    0x5C
        Char_RightBracket,    // 093    0x5D
        Char_Caret,           // 094    0x5E
        Char__,               // 095    0x5F
        Char_BackQuote,       // 096    0x60
        Char_a,               // 097    0x61
        Char_b,               // 098    0x62
        Char_c,               // 099    0x63
        Char_d,               // 100    0x64
        Char_e,               // 101    0x65
        Char_f,               // 102    0x66
        Char_g,               // 103    0x67
        Char_h,               // 104    0x68
        Char_i,               // 105    0x69
        Char_j,               // 106    0x6A
        Char_k,               // 107    0x6B
        Char_l,               // 108    0x6C
        Char_m,               // 109    0x6D
        Char_n,               // 110    0x6E
        Char_o,               // 111    0x6F
        Char_p,               // 112    0x70
        Char_q,               // 113    0x71
        Char_r,               // 114    0x72
        Char_s,               // 115    0x73
        Char_t,               // 116    0x74
        Char_u,               // 117    0x75
        Char_v,               // 118    0x76
        Char_w,               // 119    0x77
        Char_x,               // 120    0x78
        Char_y,               // 121    0x79
        Char_z,               // 122    0x7A
        Char_LeftBrace,       // 123    0x7B
        Char_VerticalBar,     // 124    0x7C
        Char_RightBrace,      // 125    0x7D
        Char_Tilde,           // 126    0x7E
        Char_CtlCharNotWS,    // 127    0x7F

        Char_Acute,           // for the acute accent 0xb4
        Char_AfterASCIINotAcute,  // for all chars in range 0x80..0xfffe excluding the acute accent
        Char_EOF              // for '\uffff' or 65535 
    };
            
    public final int getKind(int i)  // Classify character at ith location
    {
        char c = (i >= getStreamLength() ? '\uffff' : getCharValue(i));
        return (c < 128)? // ASCII Character
                  tokenKind[c] :
                  (c == '\uffff')?
                       Char_EOF :
                       (c == '\u00b4')?
                       Char_Acute :
                           Char_AfterASCIINotAcute;
    }

// lexer/parser errors
private LocalizedProcessException getErrorException(int index, String tokenText) {
    LocalizedProcessException result;
    switch (index) {
        case LEX_ERROR_CODE:
            result = new LocalizedProcessException( LPGMessages.LPG_LEX_ERROR_CODE, tokenText);
            break;
        case INVALID_CODE:
            result = new LocalizedProcessException( LPGMessages.LPG_INVALID_CODE, tokenText);
            break;
        case EOF_CODE:
            result = new LocalizedProcessException( LPGMessages.LPG_EOF_CODE);
            break;
        case INVALID_TOKEN_CODE:
            result = new LocalizedProcessException( LPGMessages.LPG_INVALID_TOKEN_CODE, tokenText);
            break;
        default:
            result = new LocalizedProcessException( LPGMessages.LPG_INVALID_ERRORCODE, index, tokenText); 
    }
    return result;
}

private ProcessReport report = null;

@Override
public void reportError(int i, String code) {
    throw new AstException(LPGMessages.LPG_LEXBUG_WRONG_REPORTERR);
}

@Override
public void reportError(int left_loc, int right_loc) {
    // calculate the error code for lexing (only 3 possibilities)
    int errorCode = (right_loc >= getStreamLength() ? EOF_CODE : left_loc == right_loc ? LEX_ERROR_CODE
        : INVALID_TOKEN_CODE),
    // define the end location
    end_loc = (left_loc == right_loc ? right_loc : right_loc - 1);

    // define the error message text
    String tokenText = (errorCode == EOF_CODE ? "" : errorCode == INVALID_TOKEN_CODE ? //$NON-NLS-1$
        new String(getInputChars(), left_loc, right_loc - left_loc) : String.valueOf(getCharValue(left_loc)));

    // formulate error
    LocalizedProcessException exception = getErrorException(errorCode, tokenText);
    // add an error to the report
    this.report.reportError(new ProcessErrorImpl(exception,
        getLineNumberOfCharAt(left_loc), getColumnOfCharAt(left_loc), getLineNumberOfCharAt(end_loc),
        getColumnOfCharAt(end_loc), left_loc, end_loc));
}

@Override
public void reportError(int errorCode, String locationInfo, String tokenText) {
    throw new AstException(LPGMessages.LPG_LEXBUG_WRONG_REPORTERR);
}

@Override
public void reportError(int errorCode, String locationInfo, int leftToken, int rightToken, String tokenText) {
    throw new AstException(LPGMessages.LPG_LEXBUG_WRONG_REPORTERR);
} 

	/* MQL-specific constructor */
	public MqlLexerGen(char[] chars, String resourceName, ProcessReport _report, int tabLength) {
		this(chars, resourceName, tabLength);
		report = _report;
		kwLexer = new MqlKeywordLexer(getInputChars(), TK_IDENTIFIER);
	}
    

    public void ruleAction( int ruleNumber)
    {
        switch(ruleNumber)
        {
 
            //
            // Rule 1:  Token ::= fragmentaddress
            //
            case 1: { 
				makeToken(TK_FRAGMENTADDRESS);
	            break;
            }
	 
            //
            // Rule 2:  Token ::= uri
            //
            case 2: { 
				makeToken(TK_URI);
	            break;
            }
	 
            //
            // Rule 3:  Token ::= Identifier
            //
            case 3: { 
				checkForKeyWord();
	            break;
            }
	 
            //
            // Rule 4:  Token ::= String
            //
            case 4: { 
				makeToken(TK_STRING_LITERAL);
	            break;
            }
	 
            //
            // Rule 5:  Token ::= IntegerLiteral
            //
            case 5: { 
				makeToken(TK_INTEGER_LITERAL);
	            break;
            }
	 
            //
            // Rule 6:  Token ::= RealLiteral
            //
            case 6: { 
				makeToken(TK_REAL_LITERAL);
	            break;
            }
	 
            //
            // Rule 7:  Token ::= SLC
            //
            case 7: { 
				skipToken();
	            break;
            }
	 
            //
            // Rule 8:  Token ::= / * Inside Stars /
            //
            case 8: { 
                skipToken();
                break;
            }
     
            //
            // Rule 9:  Token ::= WS
            //
            case 9: { 
				skipToken();
	            break;
            }
	 
            //
            // Rule 10:  Token ::= (
            //
            case 10: { 
				makeToken(TK_LPAREN);
	            break;
            }
	 
            //
            // Rule 11:  Token ::= )
            //
            case 11: { 
				makeToken(TK_RPAREN);
	            break;
            }
	 
            //
            // Rule 12:  Token ::= >
            //
            case 12: { 
				makeToken(TK_GREATER);
	            break;
            }
	 
            //
            // Rule 13:  Token ::= <
            //
            case 13: { 
				makeToken(TK_LESS);
	            break;
            }
	 
            //
            // Rule 14:  Token ::= =
            //
            case 14: { 
				makeToken(TK_EQUAL);
	            break;
            }
	 
            //
            // Rule 15:  Token ::= > =
            //
            case 15: { 
				makeToken(TK_GREATER_EQUAL);
	            break;
            }
	 
            //
            // Rule 16:  Token ::= < =
            //
            case 16: { 
				makeToken(TK_LESS_EQUAL);
	            break;
            }
	 
            //
            // Rule 17:  Token ::= < >
            //
            case 17: { 
				makeToken(TK_NOT_EQUAL);
	            break;
            }
	 
            //
            // Rule 18:  Token ::= {
            //
            case 18: { 
				makeToken(TK_LBRACE);
	            break;
            }
	 
            //
            // Rule 19:  Token ::= }
            //
            case 19: { 
				makeToken(TK_RBRACE);
	            break;
            }
	 
            //
            // Rule 20:  Token ::= ,
            //
            case 20: { 
				makeToken(TK_COMMA);
	            break;
            }
	 
            //
            // Rule 21:  Token ::= :
            //
            case 21: { 
				makeToken(TK_COLON);
	            break;
            }
	 
            //
            // Rule 22:  Token ::= : :
            //
            case 22: { 
				makeToken(TK_COLONCOLON);
	            break;
            }
	 
            //
            // Rule 23:  Token ::= .
            //
            case 23: { 
				makeToken(TK_DOT);
	            break;
            }
	 
            //
            // Rule 24:  Token ::= !
            //
            case 24: { 
				makeToken(TK_EXCLAMATION);
	            break;
            }
	 
            //
            // Rule 25:  Token ::= #
            //
            case 25: { 
				makeToken(TK_SHARP);
	            break;
            }
	
    
            default:
                break;
        }
        return;
    }
}

