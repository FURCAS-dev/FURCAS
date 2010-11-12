/**
* Essential OCL Lexer
* <copyright>
*
* Copyright (c) 2005, 2010 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
*   Borland - Bug 242880
*   E.D.Willink - Bug 292112, 295166
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Introducing new LPG templates (299396)
*
* </copyright>
*
* $Id: OCLLexer.java,v 1.20 2010/02/09 21:04:08 ewillink Exp $
*/
/**
* Complete OCL Lexer
* <copyright>
*
* Copyright (c) 2005, 2009 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Bug 292112, 292594
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Introducing new LPG templates (299396)
*
* </copyright>
*/

package org.eclipse.ocl.parser;

import lpg.runtime.*;
import org.eclipse.ocl.lpg.AbstractLexer;

import java.io.Reader;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.ocl.lpg.DerivedPrsStream;
import org.eclipse.ocl.lpg.DerivedLexStream;
import org.eclipse.ocl.util.OCLUtil;

@SuppressWarnings("nls")
public class OCLLexer extends AbstractLexer implements RuleAction
{
    private OCLLexerLpgLexStream lexStream;
    
    private static ParseTable prs = new OCLLexerprs();
    @Override
    public ParseTable getParseTable() { return prs; }

    private LexParser lexParser = new LexParser();
    @Override
    public LexParser getParser() { return lexParser; }

    public int getToken(int i) { return lexParser.getToken(i); }
    public int getRhsFirstTokenIndex(int i) { return lexParser.getFirstToken(i); }
    public int getRhsLastTokenIndex(int i) { return lexParser.getLastToken(i); }

    public int getLeftSpan() { return lexParser.getToken(1); }
    public int getRightSpan() { return lexParser.getLastToken(); }

    @Override
    public void resetKeywordLexer()
    {
        if (kwLexer == null)
              this.kwLexer = new OCLKWLexer(lexStream.getInputChars(), OCLParsersym.TK_IDENTIFIER);
        else this.kwLexer.setInputChars(lexStream.getInputChars());
    }

    @Override
    public void reset(char[] input_chars, String filename)
    {
        reset(input_chars, filename, 1);
    }
    
    @Override
    public void reset(char[] input_chars, String filename, int tab)
    {
        lexStream = new OCLLexerLpgLexStream(getOCLEnvironment(), input_chars, filename, tab);
        lexParser.reset(lexStream, prs, this);
        resetKeywordLexer();
    }

    
    public OCLLexer(Environment<?,?,?,?,?,?,?,?,?,?,?,?> environment) {
        super(OCLUtil.getAdapter(environment, BasicEnvironment.class));
        oclEnvironment = environment;
    }

	public OCLLexer(Environment<?,?,?,?,?,?,?,?,?,?,?,?> environment, char[] chars) {
		this(environment, chars, "OCL", ECLIPSE_TAB_VALUE);
	}

    public OCLLexer(Environment<?,?,?,?,?,?,?,?,?,?,?,?> environment, char[] input_chars, String filename, int tab) {
        super(OCLUtil.getAdapter(environment, BasicEnvironment.class));
        oclEnvironment = environment;
        reset(input_chars, filename, tab);            
    }

	private final Environment<?,?,?,?,?,?,?,?,?,?,?,?> oclEnvironment;
    
	public Environment<?,?,?,?,?,?,?,?,?,?,?,?> getOCLEnvironment() {
    	return oclEnvironment;
    }

    @Override
    public DerivedLexStream getILexStream() { return lexStream; }

    /**
     * @deprecated replaced by {@link #getILexStream()}
     */
    @Deprecated
    @Override
    public ILexStream getLexStream() { return lexStream; }

    private void initializeLexer(DerivedPrsStream prsStream, int start_offset, int end_offset)
    {
        if (lexStream.getInputChars() == null)
            throw new NullPointerException("LexStream was not initialized");
        lexStream.setPrsStream(prsStream);
        prsStream.makeToken(start_offset, end_offset, 0); // Token list must start with a bad token
    }

    private void addEOF(DerivedPrsStream prsStream, int end_offset)
    {
        prsStream.makeToken(end_offset, end_offset, OCLParsersym.TK_EOF_TOKEN); // and end with the end of file token
        prsStream.setStreamLength(prsStream.getSize());
    }

    @Override
    public void lexer(DerivedPrsStream prsStream)
    {
        lexer(null, prsStream);
    }
    
    @Override
    public void lexer(Monitor monitor, DerivedPrsStream prsStream)
    {
        initializeLexer(prsStream, 0, -1);
        lexParser.parseCharacters(monitor);  // Lex the input characters
        addEOF(prsStream, lexStream.getStreamIndex());
    }

    @Override
    public void lexer(DerivedPrsStream prsStream, int start_offset, int end_offset)
    {
        lexer(null, prsStream, start_offset, end_offset);
    }
    
    @Override
    public void lexer(Monitor monitor, DerivedPrsStream prsStream, int start_offset, int end_offset)
    {
        if (start_offset <= 1)
             initializeLexer(prsStream, 0, -1);
        else initializeLexer(prsStream, start_offset - 1, start_offset - 1);

        lexParser.parseCharacters(monitor, start_offset, end_offset);

        addEOF(prsStream, (end_offset >= lexStream.getStreamIndex() ? lexStream.getStreamIndex() : end_offset + 1));
    }

    /**
     * If a parse stream was not passed to this Lexical analyser then we
     * simply report a lexical error. Otherwise, we produce a bad token.
     */
    @Override
    public void reportLexicalError(int startLoc, int endLoc) {
        IPrsStream prs_stream = lexStream.getIPrsStream();
        if (prs_stream == null)
            lexStream.reportLexicalError(startLoc, endLoc);
        else {
            //
            // Remove any token that may have been processed that fall in the
            // range of the lexical error... then add one error token that spans
            // the error range.
            //
            for (int i = prs_stream.getSize() - 1; i > 0; i--) {
                if (prs_stream.getStartOffset(i) >= startLoc)
                     prs_stream.removeLastToken();
                else break;
            }
            prs_stream.makeToken(startLoc, endLoc, 0); // add an error token to the prsStream
        }        
    }

    //
    // The Lexer contains an array of characters as the input stream to be parsed.
    // There are methods to retrieve and classify characters.
    // The lexparser "token" is implemented simply as the index of the next character in the array.
    // The Lexer extends the abstract class LpgLexStream with an implementation of the abstract
    // method getKind.  The template defines the Lexer class and the lexer() method.
    // A driver creates the action class, "Lexer", passing an Option object to the constructor.
    //
    OCLKWLexer kwLexer;
    boolean printTokens;
    private final static int ECLIPSE_TAB_VALUE = 4;

    @Override
    public int [] getKeywordKinds() { return kwLexer.getKeywordKinds(); }


    /**
     * @deprecated function replaced by {@link #reset(char [] content, String filename)}
     */
    @Deprecated
    public void initialize(char [] content, String filename)
    {
        reset(content, filename);
    }
    
    final void makeToken(int left_token, int right_token, int kind)
    {
        lexStream.makeToken(left_token, right_token, kind);
    }
    
    final void makeToken(int kind)
    {
        int startOffset = getLeftSpan(),
            endOffset = getRightSpan();
        lexStream.makeToken(startOffset, endOffset, kind);
        if (printTokens) printValue(startOffset, endOffset);
    }

    final void makeComment(int kind)
    {
        int startOffset = getLeftSpan(),
            endOffset = getRightSpan();
        lexStream.getIPrsStream().makeAdjunct(startOffset, endOffset, kind);
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
        lexStream.makeToken(startOffset, endOffset, kwKind);
        if (printTokens) printValue(startOffset, endOffset);
    }
    
    //
    // This flavor of checkForKeyWord is necessary when the default kind
    // (which is returned when the keyword filter doesn't match) is something
    // other than _IDENTIFIER.
    //
    final void checkForKeyWord(int defaultKind)
    {
        int startOffset = getLeftSpan(),
            endOffset = getRightSpan(),
            kwKind = kwLexer.lexer(startOffset, endOffset);
        if (kwKind == OCLParsersym.TK_IDENTIFIER)
            kwKind = defaultKind;
        lexStream.makeToken(startOffset, endOffset, kwKind);
        if (printTokens) printValue(startOffset, endOffset);
    }
    
    final void printValue(int startOffset, int endOffset)
    {
        String s = new String(lexStream.getInputChars(), startOffset, endOffset - startOffset + 1);
        System.out.print(s);
    }

    //
    //
    //
    static class OCLLexerLpgLexStream extends DerivedLexStream
    {
    public final static int tokenKind[] =
    {
        OCLLexersym.Char_CtlCharNotWS,    // 000    0x00
        OCLLexersym.Char_CtlCharNotWS,    // 001    0x01
        OCLLexersym.Char_CtlCharNotWS,    // 002    0x02
        OCLLexersym.Char_CtlCharNotWS,    // 003    0x03
        OCLLexersym.Char_CtlCharNotWS,    // 004    0x04
        OCLLexersym.Char_CtlCharNotWS,    // 005    0x05
        OCLLexersym.Char_CtlCharNotWS,    // 006    0x06
        OCLLexersym.Char_CtlCharNotWS,    // 007    0x07
        OCLLexersym.Char_CtlCharNotWS,    // 008    0x08
        OCLLexersym.Char_HT,              // 009    0x09
        OCLLexersym.Char_LF,              // 010    0x0A
        OCLLexersym.Char_CtlCharNotWS,    // 011    0x0B
        OCLLexersym.Char_FF,              // 012    0x0C
        OCLLexersym.Char_CR,              // 013    0x0D
        OCLLexersym.Char_CtlCharNotWS,    // 014    0x0E
        OCLLexersym.Char_CtlCharNotWS,    // 015    0x0F
        OCLLexersym.Char_CtlCharNotWS,    // 016    0x10
        OCLLexersym.Char_CtlCharNotWS,    // 017    0x11
        OCLLexersym.Char_CtlCharNotWS,    // 018    0x12
        OCLLexersym.Char_CtlCharNotWS,    // 019    0x13
        OCLLexersym.Char_CtlCharNotWS,    // 020    0x14
        OCLLexersym.Char_CtlCharNotWS,    // 021    0x15
        OCLLexersym.Char_CtlCharNotWS,    // 022    0x16
        OCLLexersym.Char_CtlCharNotWS,    // 023    0x17
        OCLLexersym.Char_CtlCharNotWS,    // 024    0x18
        OCLLexersym.Char_CtlCharNotWS,    // 025    0x19
        OCLLexersym.Char_CtlCharNotWS,    // 026    0x1A
        OCLLexersym.Char_CtlCharNotWS,    // 027    0x1B
        OCLLexersym.Char_CtlCharNotWS,    // 028    0x1C
        OCLLexersym.Char_CtlCharNotWS,    // 029    0x1D
        OCLLexersym.Char_CtlCharNotWS,    // 030    0x1E
        OCLLexersym.Char_CtlCharNotWS,    // 031    0x1F
        OCLLexersym.Char_Space,           // 032    0x20
        OCLLexersym.Char_Exclamation,     // 033    0x21
        OCLLexersym.Char_DoubleQuote,     // 034    0x22
        OCLLexersym.Char_Sharp,           // 035    0x23
        OCLLexersym.Char_DollarSign,      // 036    0x24
        OCLLexersym.Char_Percent,         // 037    0x25
        OCLLexersym.Char_Ampersand,       // 038    0x26
        OCLLexersym.Char_SingleQuote,     // 039    0x27
        OCLLexersym.Char_LeftParen,       // 040    0x28
        OCLLexersym.Char_RightParen,      // 041    0x29
        OCLLexersym.Char_Star,            // 042    0x2A
        OCLLexersym.Char_Plus,            // 043    0x2B
        OCLLexersym.Char_Comma,           // 044    0x2C
        OCLLexersym.Char_Minus,           // 045    0x2D
        OCLLexersym.Char_Dot,             // 046    0x2E
        OCLLexersym.Char_Slash,           // 047    0x2F
        OCLLexersym.Char_0,               // 048    0x30
        OCLLexersym.Char_1,               // 049    0x31
        OCLLexersym.Char_2,               // 050    0x32
        OCLLexersym.Char_3,               // 051    0x33
        OCLLexersym.Char_4,               // 052    0x34
        OCLLexersym.Char_5,               // 053    0x35
        OCLLexersym.Char_6,               // 054    0x36
        OCLLexersym.Char_7,               // 055    0x37
        OCLLexersym.Char_8,               // 056    0x38
        OCLLexersym.Char_9,               // 057    0x39
        OCLLexersym.Char_Colon,           // 058    0x3A
        OCLLexersym.Char_SemiColon,       // 059    0x3B
        OCLLexersym.Char_LessThan,        // 060    0x3C
        OCLLexersym.Char_Equal,           // 061    0x3D
        OCLLexersym.Char_GreaterThan,     // 062    0x3E
        OCLLexersym.Char_QuestionMark,    // 063    0x3F
        OCLLexersym.Char_AtSign,          // 064    0x40
        OCLLexersym.Char_A,               // 065    0x41
        OCLLexersym.Char_B,               // 066    0x42
        OCLLexersym.Char_C,               // 067    0x43
        OCLLexersym.Char_D,               // 068    0x44
        OCLLexersym.Char_E,               // 069    0x45
        OCLLexersym.Char_F,               // 070    0x46
        OCLLexersym.Char_G,               // 071    0x47
        OCLLexersym.Char_H,               // 072    0x48
        OCLLexersym.Char_I,               // 073    0x49
        OCLLexersym.Char_J,               // 074    0x4A
        OCLLexersym.Char_K,               // 075    0x4B
        OCLLexersym.Char_L,               // 076    0x4C
        OCLLexersym.Char_M,               // 077    0x4D
        OCLLexersym.Char_N,               // 078    0x4E
        OCLLexersym.Char_O,               // 079    0x4F
        OCLLexersym.Char_P,               // 080    0x50
        OCLLexersym.Char_Q,               // 081    0x51
        OCLLexersym.Char_R,               // 082    0x52
        OCLLexersym.Char_S,               // 083    0x53
        OCLLexersym.Char_T,               // 084    0x54
        OCLLexersym.Char_U,               // 085    0x55
        OCLLexersym.Char_V,               // 086    0x56
        OCLLexersym.Char_W,               // 087    0x57
        OCLLexersym.Char_X,               // 088    0x58
        OCLLexersym.Char_Y,               // 089    0x59
        OCLLexersym.Char_Z,               // 090    0x5A
        OCLLexersym.Char_LeftBracket,     // 091    0x5B
        OCLLexersym.Char_BackSlash,       // 092    0x5C
        OCLLexersym.Char_RightBracket,    // 093    0x5D
        OCLLexersym.Char_Caret,           // 094    0x5E
        OCLLexersym.Char__,               // 095    0x5F
        OCLLexersym.Char_BackQuote,       // 096    0x60
        OCLLexersym.Char_a,               // 097    0x61
        OCLLexersym.Char_b,               // 098    0x62
        OCLLexersym.Char_c,               // 099    0x63
        OCLLexersym.Char_d,               // 100    0x64
        OCLLexersym.Char_e,               // 101    0x65
        OCLLexersym.Char_f,               // 102    0x66
        OCLLexersym.Char_g,               // 103    0x67
        OCLLexersym.Char_h,               // 104    0x68
        OCLLexersym.Char_i,               // 105    0x69
        OCLLexersym.Char_j,               // 106    0x6A
        OCLLexersym.Char_k,               // 107    0x6B
        OCLLexersym.Char_l,               // 108    0x6C
        OCLLexersym.Char_m,               // 109    0x6D
        OCLLexersym.Char_n,               // 110    0x6E
        OCLLexersym.Char_o,               // 111    0x6F
        OCLLexersym.Char_p,               // 112    0x70
        OCLLexersym.Char_q,               // 113    0x71
        OCLLexersym.Char_r,               // 114    0x72
        OCLLexersym.Char_s,               // 115    0x73
        OCLLexersym.Char_t,               // 116    0x74
        OCLLexersym.Char_u,               // 117    0x75
        OCLLexersym.Char_v,               // 118    0x76
        OCLLexersym.Char_w,               // 119    0x77
        OCLLexersym.Char_x,               // 120    0x78
        OCLLexersym.Char_y,               // 121    0x79
        OCLLexersym.Char_z,               // 122    0x7A
        OCLLexersym.Char_LeftBrace,       // 123    0x7B
        OCLLexersym.Char_VerticalBar,     // 124    0x7C
        OCLLexersym.Char_RightBrace,      // 125    0x7D
        OCLLexersym.Char_Tilde,           // 126    0x7E
        OCLLexersym.Char_CtlCharNotWS,    // 127    0x7F

        OCLLexersym.Char_Acute,           // for the acute accent 0xb4
        OCLLexersym.Char_AfterASCIINotAcute,      // for all chars in range 0x80..0xfffe excluding the acute accent
        OCLLexersym.Char_EOF              // for '\uffff' or 65535 
    };
            
    @Override
    public final int getKind(int i)  // Classify character at ith location
    {
        char c = (i >= getStreamLength() ? '\uffff' : getCharValue(i));
        return (c < 128) // ASCII Character
                  ? tokenKind[c] 
                  : (c == '\uffff')
                      ?OCLLexersym.Char_EOF
                      : (c == '\u00b4')
                            ? OCLLexersym.Char_EOF
                            : OCLLexersym.Char_AfterASCIINotAcute;
    }

    @Override
    public String[] orderedExportedSymbols() { return OCLParsersym.orderedTerminalSymbols; }

    public OCLLexerLpgLexStream(Environment<?,?,?,?,?,?,?,?,?,?,?,?> environment, String filename, int tab) throws java.io.IOException
    {
        super(OCLUtil.getAdapter(environment, BasicEnvironment.class), filename, tab);
    }

    public OCLLexerLpgLexStream(Environment<?,?,?,?,?,?,?,?,?,?,?,?> environment, char[] input_chars, String filename, int tab)
    {
        super(OCLUtil.getAdapter(environment, BasicEnvironment.class), input_chars, filename, tab);
    }

    public OCLLexerLpgLexStream(Environment<?,?,?,?,?,?,?,?,?,?,?,?> environment, char[] input_chars, String filename)
    {
        super(OCLUtil.getAdapter(environment, BasicEnvironment.class), input_chars, filename, 1);
    }
    }

    
// Some OCL additions to make lexer work with an input reader
/**
 * @since 3.0
 */
public OCLLexer(Environment<?,?,?,?,?,?,?,?,?,?,?,?> environment, Reader reader, String filename) throws java.io.IOException {
	super(OCLUtil.getAdapter(environment, BasicEnvironment.class));
	oclEnvironment = environment;
	reset(reader, filename);
}

// OCL addition to reset the lexer stream from an input reader
/**
 * @since 3.0
 */
@Override
public void reset(Reader reader, String filename) throws java.io.IOException {
	char[] input_chars = getInputChars(reader);
    reset(input_chars, filename, ECLIPSE_TAB_VALUE);
}

    public void ruleAction(int ruleNumber)
    {
        switch(ruleNumber)
        {

            //
            // Rule 1:  Token ::= Identifier
            //
            case 1: { 
				checkForKeyWord();
	              break;
            }
	
            //
            // Rule 2:  Token ::= " SLNotDQ "
            //
            case 2: { 
				makeToken(OCLParsersym.TK_IDENTIFIER);
	              break;
            }
	
            //
            // Rule 3:  Token ::= _ SingleQuote SLNotSQOpt SingleQuote
            //
            case 3: { 
				makeToken(OCLParsersym.TK_QUOTED_IDENTIFIER);
	              break;
            }
	
            //
            // Rule 4:  Token ::= SingleQuote SLNotSQOpt SingleQuote
            //
            case 4: { 
				makeToken(OCLParsersym.TK_STRING_LITERAL);
	              break;
            }
	
            //
            // Rule 5:  Token ::= Acute SLNotSQOpt Acute
            //
            case 5: { 
				makeToken(OCLParsersym.TK_STRING_LITERAL);
	              break;
            }
	
            //
            // Rule 6:  Token ::= BackQuote SLNotSQOpt Acute
            //
            case 6: { 
				makeToken(OCLParsersym.TK_STRING_LITERAL);
	              break;
            }
	
            //
            // Rule 7:  Token ::= IntegerLiteral
            //
            case 7:
                break; 
	
            //
            // Rule 8:  Token ::= IntegerLiteral DotToken
            //
            case 8:
                break; 
	
            //
            // Rule 9:  Token ::= IntegerLiteral DotDotToken
            //
            case 9:
                break; 
	
            //
            // Rule 10:  Token ::= RealLiteral
            //
            case 10: { 
				makeToken(OCLParsersym.TK_REAL_LITERAL);
	              break;
            }
	
            //
            // Rule 11:  Token ::= SLC
            //
            case 11: { 
				makeComment(OCLParsersym.TK_SINGLE_LINE_COMMENT);
	              break;
            }
	
            //
            // Rule 12:  Token ::= / * Inside Stars /
            //
            case 12: { 
                makeComment(OCLParsersym.TK_MULTI_LINE_COMMENT);
                  break;
            }
    
            //
            // Rule 13:  Token ::= WS
            //
            case 13: { 
				skipToken();
	              break;
            }
	
            //
            // Rule 14:  Token ::= +
            //
            case 14: { 
				makeToken(OCLParsersym.TK_PLUS);
	              break;
            }
	
            //
            // Rule 15:  Token ::= -
            //
            case 15: { 
				makeToken(OCLParsersym.TK_MINUS);
	              break;
            }
	
            //
            // Rule 16:  Token ::= *
            //
            case 16: { 
				makeToken(OCLParsersym.TK_MULTIPLY);
	              break;
            }
	
            //
            // Rule 17:  Token ::= /
            //
            case 17: { 
				makeToken(OCLParsersym.TK_DIVIDE);
	              break;
            }
	
            //
            // Rule 18:  Token ::= (
            //
            case 18: { 
				makeToken(OCLParsersym.TK_LPAREN);
	              break;
            }
	
            //
            // Rule 19:  Token ::= )
            //
            case 19: { 
				makeToken(OCLParsersym.TK_RPAREN);
	              break;
            }
	
            //
            // Rule 20:  Token ::= >
            //
            case 20: { 
				makeToken(OCLParsersym.TK_GREATER);
	              break;
            }
	
            //
            // Rule 21:  Token ::= <
            //
            case 21: { 
				makeToken(OCLParsersym.TK_LESS);
	              break;
            }
	
            //
            // Rule 22:  Token ::= =
            //
            case 22: { 
				makeToken(OCLParsersym.TK_EQUAL);
	              break;
            }
	
            //
            // Rule 23:  Token ::= > =
            //
            case 23: { 
				makeToken(OCLParsersym.TK_GREATER_EQUAL);
	              break;
            }
	
            //
            // Rule 24:  Token ::= < =
            //
            case 24: { 
				makeToken(OCLParsersym.TK_LESS_EQUAL);
	              break;
            }
	
            //
            // Rule 25:  Token ::= < >
            //
            case 25: { 
				makeToken(OCLParsersym.TK_NOT_EQUAL);
	              break;
            }
	
            //
            // Rule 26:  Token ::= [
            //
            case 26: { 
				makeToken(OCLParsersym.TK_LBRACKET);
	              break;
            }
	
            //
            // Rule 27:  Token ::= ]
            //
            case 27: { 
				makeToken(OCLParsersym.TK_RBRACKET);
	              break;
            }
	
            //
            // Rule 28:  Token ::= {
            //
            case 28: { 
				makeToken(OCLParsersym.TK_LBRACE);
	              break;
            }
	
            //
            // Rule 29:  Token ::= }
            //
            case 29: { 
				makeToken(OCLParsersym.TK_RBRACE);
	              break;
            }
	
            //
            // Rule 30:  Token ::= - >
            //
            case 30: { 
				makeToken(OCLParsersym.TK_ARROW);
	              break;
            }
	
            //
            // Rule 31:  Token ::= |
            //
            case 31: { 
				makeToken(OCLParsersym.TK_BAR);
	              break;
            }
	
            //
            // Rule 32:  Token ::= ,
            //
            case 32: { 
				makeToken(OCLParsersym.TK_COMMA);
	              break;
            }
	
            //
            // Rule 33:  Token ::= :
            //
            case 33: { 
				makeToken(OCLParsersym.TK_COLON);
	              break;
            }
	
            //
            // Rule 34:  Token ::= : :
            //
            case 34: { 
				makeToken(OCLParsersym.TK_COLONCOLON);
	              break;
            }
	
            //
            // Rule 35:  Token ::= ;
            //
            case 35: { 
				makeToken(OCLParsersym.TK_SEMICOLON);
	              break;
            }
	
            //
            // Rule 36:  Token ::= DotToken
            //
            case 36:
                break; 
	
            //
            // Rule 37:  DotToken ::= .
            //
            case 37: { 
				makeToken(OCLParsersym.TK_DOT);
	              break;
            }
	
            //
            // Rule 38:  Token ::= DotDotToken
            //
            case 38:
                break; 
	
            //
            // Rule 39:  DotDotToken ::= . .
            //
            case 39: { 
				makeToken(OCLParsersym.TK_DOTDOT);
	              break;
            }
	
            //
            // Rule 40:  IntegerLiteral ::= Integer
            //
            case 40: { 
				makeToken(OCLParsersym.TK_INTEGER_LITERAL);
	              break;
            }
	
            //
            // Rule 265:  Token ::= @
            //
            case 265: { 
				makeToken(OCLParsersym.TK_AT);
	              break;
            }
	
            //
            // Rule 266:  Token ::= ^
            //
            case 266: { 
				makeToken(OCLParsersym.TK_CARET);
	              break;
            }
	
            //
            // Rule 267:  Token ::= ^ ^
            //
            case 267: { 
				makeToken(OCLParsersym.TK_CARETCARET);
	              break;
            }
	
            //
            // Rule 268:  Token ::= ?
            //
            case 268: { 
				makeToken(OCLParsersym.TK_QUESTIONMARK);
	              break;
            }
	
    
            default:
                break;
        }
        return;
    }
}

