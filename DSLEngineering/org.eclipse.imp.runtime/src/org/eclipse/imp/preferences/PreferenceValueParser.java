
////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2007 IBM Corporation.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
//Author: Robert Fuhrer (rfuhrer@watson.ibm.com)
////////////////////////////////////////////////////////////////////////////////

package org.eclipse.imp.preferences;

import org.eclipse.imp.parser.IParser;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Map;
    import java.util.HashMap;
    import java.util.Set;
    import lpg.runtime.*;
 
public class PreferenceValueParser implements PreferenceValueParsersym, RuleAction {
    static class MyLexStream extends LpgLexStream {
        public void initialize(char [] content) {
            super.initialize(content, "");
        }

        public final static int tokenKind[] = {
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

            Char_AfterASCII,      // for all chars in range 128..65534
            Char_EOF              // for '\uffff' or 65535 
        };
                
        public final int getKind(int i) { // Classify character at ith location
            char c = (i >= getStreamLength() ? '\uffff' : getCharValue(i));
            return (c < 128 // ASCII Character
                      ? tokenKind[c]
                      : c == '\uffff'
                           ? PreferenceValueParsersym.Char_EOF
                           : PreferenceValueParsersym.Char_AfterASCII);
        }
        public String[] orderedExportedSymbols() { return PreferenceValueParsersym.orderedTerminalSymbols; }
    };

    private MyLexStream lexStream = new MyLexStream();

    private static ParseTable prs = new PreferenceValueParserprs();
    private DeterministicParser dtParser;

    private void setResult(Object object) { dtParser.setSym1(object); }
    public DeterministicParser getParser() { return dtParser; }

    public Object getRhsSym(int i) { return dtParser.getSym(i); }

    public int getRhsTokenIndex(int i) { return dtParser.getToken(i); }
    public int getRhsFirstTokenIndex(int i) { return dtParser.getFirstToken(i); }
    public int getRhsLastTokenIndex(int i) { return dtParser.getLastToken(i); }

public IToken getLeftIToken() { return new MyToken(dtParser.getFirstToken(), lexStream); }
public IToken getRightIToken() { return new MyToken(dtParser.getLastToken(), lexStream); }

public IToken getRhsIToken(int idx) { return new MyToken(dtParser.getToken(idx), lexStream); }

    public int getLeftSpan() { return dtParser.getFirstToken(); }
    public int getRightSpan() { return dtParser.getLastToken(); }

    public int getEOFTokenKind() { return PreferenceValueParserprs.EOFT_SYMBOL; }
    public LpgLexStream getLexStream() { return lexStream; }

    private String errorMsg= "";

    public String getErrorMessage() { return errorMsg; }

    public ASTNode parser(String input) {
        try {
            lexStream.initialize(input.toCharArray());
            dtParser = new DeterministicParser(lexStream, prs, this);
        } catch (NotDeterministicParseTableException e) {
            System.out.println("****Error: Regenerate PreferenceValueParserprs.java with -NOBACKTRACK option");
            return null;
        } catch (BadParseSymFileException e) {
            System.out.println("****Error: Bad Parser Symbol File -- PreferenceValueParsersym.java. Regenerate PreferenceValueParserprs.java");
            return null;
        }

        try {
            return (ASTNode) dtParser.parse();
        } catch (BadParseException e) {
            errorMsg= "unexpected";
            if (e.error_token < lexStream.getStreamLength())
                errorMsg += " character '" + lexStream.getCharValue(e.error_token) + "' at offset " + e.error_token;
            else
                errorMsg += " end of string";
        }
        return null;
    }

private class MyToken implements IToken {
    private int offset;
    private LpgLexStream lexStream;
    public MyToken(int offset, LpgLexStream ls) {
        this.offset= offset;
        this.lexStream= ls;
    }
    public int getKind() { return lexStream.getKind(lexStream.getInputChars()[offset]); }
    public void setKind(int kind) { }

    public int getStartOffset() { return offset; }
    public void setStartOffset(int startOffset) { }

    public int getEndOffset() { return offset; }
    public void setEndOffset(int endOffset) { }

    public int getTokenIndex() { return offset; }
    public void setTokenIndex(int i) { }

    public int getAdjunctIndex() { return -1; }
    public void setAdjunctIndex(int i) { }

    public IToken[] getPrecedingAdjuncts() { return null; }
    public IToken[] getFollowingAdjuncts() { return null; }

    public IPrsStream getIPrsStream() { return null; }
    public LpgLexStream getILexStream() { return lexStream; }
    public IPrsStream getPrsStream() { return null; }
    public LpgLexStream getLexStream() { return lexStream; }

    public int getLine() { return lexStream.getLine(offset); }
    public int getColumn() { return lexStream.getColumn(offset); }
    public int getEndLine() { return lexStream.getLine(offset); }
    public int getEndColumn() { return lexStream.getColumn(offset); }

    public String getValue(char[] inputChars) { return toString(); }

    public String toString() {
        return new String(new char[] { lexStream.getInputChars()[offset] });
    }
}
    static public abstract class ASTNode implements IAst
    {
        public IAst getNextAst() { return null; }
        protected IToken leftIToken,
                         rightIToken;
        protected IAst parent = null;
        protected void setParent(IAst parent) { this.parent = parent; }
        public IAst getParent() { return parent; }

        public IToken getLeftIToken() { return leftIToken; }
        public IToken getRightIToken() { return rightIToken; }
        public IToken[] getPrecedingAdjuncts() { return leftIToken.getPrecedingAdjuncts(); }
        public IToken[] getFollowingAdjuncts() { return rightIToken.getFollowingAdjuncts(); }

        public String toString()
        {
            return leftIToken.getLexStream().toString(leftIToken.getStartOffset(), rightIToken.getEndOffset());
        }

        public ASTNode(IToken token) { this.leftIToken = this.rightIToken = token; }
        public ASTNode(IToken leftIToken, IToken rightIToken)
        {
            this.leftIToken = leftIToken;
            this.rightIToken = rightIToken;
        }

        void initialize() {}

        /**
         * A list of all children of this node, excluding the null ones.
         */
        public java.util.ArrayList getChildren()
        {
            java.util.ArrayList list = getAllChildren();
            int k = -1;
            for (int i = 0; i < list.size(); i++)
            {
                Object element = list.get(i);
                if (element != null)
                {
                    if (++k != i)
                        list.set(k, element);
                }
            }
            for (int i = list.size() - 1; i > k; i--) // remove extraneous elements
                list.remove(i);
            return list;
        }

        /**
         * A list of all children of this node, including the null ones.
         */
        public abstract java.util.ArrayList getAllChildren();

        public boolean equals(Object o)
        {
            if (o == this) return true;
            if (! (o instanceof ASTNode)) return false;
            ASTNode other = (ASTNode) o;
            return getLeftIToken().getLexStream() == other.getLeftIToken().getLexStream() &&
                   getLeftIToken().getTokenIndex() == other.getLeftIToken().getTokenIndex() &&
                   getRightIToken().getLexStream() == other.getRightIToken().getLexStream() &&
                   getRightIToken().getTokenIndex() == other.getRightIToken().getTokenIndex();
        }

        public int hashCode()
        {
            int hash = 7;
            if (getLeftIToken().getLexStream() != null) hash = hash * 31 + getLeftIToken().getLexStream().hashCode();
            hash = hash * 31 + getLeftIToken().getTokenIndex();
            if (getRightIToken().getLexStream() != null) hash = hash * 31 + getRightIToken().getLexStream().hashCode();
            hash = hash * 31 + getRightIToken().getTokenIndex();
            return hash;
        }
        public abstract void accept(IAstVisitor v);
    }

    static public abstract class AbstractASTNodeList extends ASTNode
    {
        private boolean leftRecursive;
        private java.util.ArrayList list;
        public int size() { return list.size(); }
        public ASTNode getElementAt(int i) { return (ASTNode) list.get(leftRecursive ? i : list.size() - 1 - i); }
        public java.util.ArrayList getArrayList()
        {
            if (! leftRecursive) // reverse the list 
            {
                for (int i = 0, n = list.size() - 1; i < n; i++, n--)
                {
                    Object ith = list.get(i),
                           nth = list.get(n);
                    list.set(i, nth);
                    list.set(n, ith);
                }
                leftRecursive = true;
            }
            return list;
        }
        public void add(ASTNode element)
        {
            list.add(element);
            if (leftRecursive)
                 rightIToken = element.getRightIToken();
            else leftIToken = element.getLeftIToken();
        }

        public AbstractASTNodeList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
        {
            super(leftIToken, rightIToken);
            this.leftRecursive = leftRecursive;
            list = new java.util.ArrayList();
        }

        public AbstractASTNodeList(ASTNode element, boolean leftRecursive)
        {
            this(element.getLeftIToken(), element.getRightIToken(), leftRecursive);
            list.add(element);
        }

        /**
         * Make a copy of the list and return it. Note that we obtain the local list by
         * invoking getArrayList so as to make sure that the list we return is in proper order.
         */
        public java.util.ArrayList getAllChildren()
        {
            return (java.util.ArrayList) getArrayList().clone();
        }

    }

    static public class ASTNodeToken extends ASTNode implements IASTNodeToken
    {
        public ASTNodeToken(IToken token) { super(token); }
        public IToken getIToken() { return leftIToken; }
        public String toString() { return leftIToken.toString(); }

        /**
         * A token class has no children. So, we return the empty list.
         */
        public java.util.ArrayList getAllChildren() { return new java.util.ArrayList(); }

        public boolean equals(Object o)
        {
            if (o == this) return true;
            if (! (o instanceof ASTNodeToken)) return false;
            ASTNodeToken other = (ASTNodeToken) o;
            return getIToken().getLexStream() == other.getIToken().getLexStream() &&
                   getIToken().getTokenIndex() == other.getIToken().getTokenIndex();
        }

        public int hashCode()
        {
            int hash = 7;
            if (getIToken().getLexStream() != null) hash = hash * 31 + getIToken().getLexStream().hashCode();
            hash = hash * 31 + getIToken().getTokenIndex();
            return hash;
        }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *<li>specialNoDollarRBrace0
     *<li>specialNoDollarRBrace1
     *<li>specialNoDollarRBrace2
     *<li>specialNoDollarRBrace3
     *<li>specialNoDollarRBrace4
     *<li>specialNoDollarRBrace5
     *<li>specialNoDollarRBrace6
     *<li>specialNoDollarRBrace7
     *<li>specialNoDollarRBrace8
     *<li>specialNoDollarRBrace9
     *<li>specialNoDollarRBrace10
     *<li>specialNoDollarRBrace11
     *<li>specialNoDollarRBrace12
     *<li>specialNoDollarRBrace13
     *<li>specialNoDollarRBrace14
     *<li>specialNoDollarRBrace15
     *<li>specialNoDollarRBrace16
     *<li>specialNoDollarRBrace17
     *<li>specialNoDollarRBrace18
     *<li>specialNoDollarRBrace19
     *<li>specialNoDollarRBrace20
     *<li>specialNoDollarRBrace21
     *<li>specialNoDollarRBrace22
     *<li>specialNoDollarRBrace23
     *<li>specialNoDollarRBrace24
     *<li>specialNoDollarRBrace25
     *<li>specialNoDollarRBrace26
     *<li>specialNoDollarRBrace27
     *<li>specialNoDollarRBrace28
     *<li>specialNoDollarRBrace29
     *<li>special0
     *<li>special1
     *<li>special2
     *<li>special3
     *<li>special4
     *<li>special5
     *<li>special6
     *<li>special7
     *<li>special8
     *<li>special9
     *<li>special10
     *<li>special11
     *<li>special12
     *<li>special13
     *<li>special14
     *<li>special15
     *<li>special16
     *<li>special17
     *<li>special18
     *<li>special19
     *<li>special20
     *<li>special21
     *<li>special22
     *<li>special23
     *<li>special24
     *<li>special25
     *<li>special26
     *<li>special27
     *<li>special28
     *<li>special29
     *<li>special30
     *<li>special31
     *<li>special32
     *</ul>
     *</b>
     */
    public interface IASTNodeToken
    {
        public IToken getLeftIToken();
        public IToken getRightIToken();

        void accept(IAstVisitor v);
    }

    /**
     * is implemented by:
     *<b>
     *<ul>
     *<li>simpleStringPrefixed
     *<li>valStringNoSubst
     *<li>substPrefixed
     *<li>substitutionList
     *<li>escapedChar
     *<li>specialNoDollarRBrace0
     *<li>specialNoDollarRBrace1
     *<li>specialNoDollarRBrace2
     *<li>specialNoDollarRBrace3
     *<li>specialNoDollarRBrace4
     *<li>specialNoDollarRBrace5
     *<li>specialNoDollarRBrace6
     *<li>specialNoDollarRBrace7
     *<li>specialNoDollarRBrace8
     *<li>specialNoDollarRBrace9
     *<li>specialNoDollarRBrace10
     *<li>specialNoDollarRBrace11
     *<li>specialNoDollarRBrace12
     *<li>specialNoDollarRBrace13
     *<li>specialNoDollarRBrace14
     *<li>specialNoDollarRBrace15
     *<li>specialNoDollarRBrace16
     *<li>specialNoDollarRBrace17
     *<li>specialNoDollarRBrace18
     *<li>specialNoDollarRBrace19
     *<li>specialNoDollarRBrace20
     *<li>specialNoDollarRBrace21
     *<li>specialNoDollarRBrace22
     *<li>specialNoDollarRBrace23
     *<li>specialNoDollarRBrace24
     *<li>specialNoDollarRBrace25
     *<li>specialNoDollarRBrace26
     *<li>specialNoDollarRBrace27
     *<li>specialNoDollarRBrace28
     *<li>specialNoDollarRBrace29
     *</ul>
     *</b>
     */
    public interface Ivalue
    {
        public IToken getLeftIToken();
        public IToken getRightIToken();

        void accept(IAstVisitor v);
    }

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface Idigit extends IASTNodeToken, InonSubstStart, IescapableChar {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IaA extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IbB extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IcC extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IdD extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IeE extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IfF extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IgG extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IhH extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IiI extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IjJ extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IkK extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IlL extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface ImM extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface InN extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IoO extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IpP extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IqQ extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IrR extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IsS extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface ItT extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IuU extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IvV extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IwW extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IxX extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IyY extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IzZ extends IASTNodeToken, Iletter {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface Iletter extends IidentChars, InonSubstStart, IescapableChar {}

    /**
     * is implemented by:
     *<b>
     *<ul>
     *<li>simpleStringPrefixed
     *<li>valStringNoSubst
     *<li>escapedChar
     *<li>specialNoDollarRBrace0
     *<li>specialNoDollarRBrace1
     *<li>specialNoDollarRBrace2
     *<li>specialNoDollarRBrace3
     *<li>specialNoDollarRBrace4
     *<li>specialNoDollarRBrace5
     *<li>specialNoDollarRBrace6
     *<li>specialNoDollarRBrace7
     *<li>specialNoDollarRBrace8
     *<li>specialNoDollarRBrace9
     *<li>specialNoDollarRBrace10
     *<li>specialNoDollarRBrace11
     *<li>specialNoDollarRBrace12
     *<li>specialNoDollarRBrace13
     *<li>specialNoDollarRBrace14
     *<li>specialNoDollarRBrace15
     *<li>specialNoDollarRBrace16
     *<li>specialNoDollarRBrace17
     *<li>specialNoDollarRBrace18
     *<li>specialNoDollarRBrace19
     *<li>specialNoDollarRBrace20
     *<li>specialNoDollarRBrace21
     *<li>specialNoDollarRBrace22
     *<li>specialNoDollarRBrace23
     *<li>specialNoDollarRBrace24
     *<li>specialNoDollarRBrace25
     *<li>specialNoDollarRBrace26
     *<li>specialNoDollarRBrace27
     *<li>specialNoDollarRBrace28
     *<li>specialNoDollarRBrace29
     *</ul>
     *</b>
     */
    public interface IsimpleStringPrefixed extends Ivalue {}

    /**
     * is implemented by:
     *<b>
     *<ul>
     *<li>substPrefixed
     *<li>substitutionList
     *</ul>
     *</b>
     */
    public interface IsubstPrefixed extends Ivalue {}

    /**
     * is implemented by:
     *<b>
     *<ul>
     *<li>valStringNoSubst
     *<li>escapedChar
     *<li>specialNoDollarRBrace0
     *<li>specialNoDollarRBrace1
     *<li>specialNoDollarRBrace2
     *<li>specialNoDollarRBrace3
     *<li>specialNoDollarRBrace4
     *<li>specialNoDollarRBrace5
     *<li>specialNoDollarRBrace6
     *<li>specialNoDollarRBrace7
     *<li>specialNoDollarRBrace8
     *<li>specialNoDollarRBrace9
     *<li>specialNoDollarRBrace10
     *<li>specialNoDollarRBrace11
     *<li>specialNoDollarRBrace12
     *<li>specialNoDollarRBrace13
     *<li>specialNoDollarRBrace14
     *<li>specialNoDollarRBrace15
     *<li>specialNoDollarRBrace16
     *<li>specialNoDollarRBrace17
     *<li>specialNoDollarRBrace18
     *<li>specialNoDollarRBrace19
     *<li>specialNoDollarRBrace20
     *<li>specialNoDollarRBrace21
     *<li>specialNoDollarRBrace22
     *<li>specialNoDollarRBrace23
     *<li>specialNoDollarRBrace24
     *<li>specialNoDollarRBrace25
     *<li>specialNoDollarRBrace26
     *<li>specialNoDollarRBrace27
     *<li>specialNoDollarRBrace28
     *<li>specialNoDollarRBrace29
     *</ul>
     *</b>
     */
    public interface IvalStringNoSubst extends IsimpleStringPrefixed {}

    /**
     * is implemented by:
     *<b>
     *<ul>
     *<li>escapedChar
     *<li>specialNoDollarRBrace0
     *<li>specialNoDollarRBrace1
     *<li>specialNoDollarRBrace2
     *<li>specialNoDollarRBrace3
     *<li>specialNoDollarRBrace4
     *<li>specialNoDollarRBrace5
     *<li>specialNoDollarRBrace6
     *<li>specialNoDollarRBrace7
     *<li>specialNoDollarRBrace8
     *<li>specialNoDollarRBrace9
     *<li>specialNoDollarRBrace10
     *<li>specialNoDollarRBrace11
     *<li>specialNoDollarRBrace12
     *<li>specialNoDollarRBrace13
     *<li>specialNoDollarRBrace14
     *<li>specialNoDollarRBrace15
     *<li>specialNoDollarRBrace16
     *<li>specialNoDollarRBrace17
     *<li>specialNoDollarRBrace18
     *<li>specialNoDollarRBrace19
     *<li>specialNoDollarRBrace20
     *<li>specialNoDollarRBrace21
     *<li>specialNoDollarRBrace22
     *<li>specialNoDollarRBrace23
     *<li>specialNoDollarRBrace24
     *<li>specialNoDollarRBrace25
     *<li>specialNoDollarRBrace26
     *<li>specialNoDollarRBrace27
     *<li>specialNoDollarRBrace28
     *<li>specialNoDollarRBrace29
     *</ul>
     *</b>
     */
    public interface IvalueStringNoSubst extends IvalStringNoSubst {}

    /**
     * is implemented by <b>substitutionList</b>
     */
    public interface IsubstitutionList extends IsubstPrefixed {}

    /**
     * is implemented by <b>substitution</b>
     */
    public interface Isubstitution
    {
        public IToken getLeftIToken();
        public IToken getRightIToken();

        void accept(IAstVisitor v);
    }

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *<li>specialNoDollarRBrace0
     *<li>specialNoDollarRBrace1
     *<li>specialNoDollarRBrace2
     *<li>specialNoDollarRBrace3
     *<li>specialNoDollarRBrace4
     *<li>specialNoDollarRBrace5
     *<li>specialNoDollarRBrace6
     *<li>specialNoDollarRBrace7
     *<li>specialNoDollarRBrace8
     *<li>specialNoDollarRBrace9
     *<li>specialNoDollarRBrace10
     *<li>specialNoDollarRBrace11
     *<li>specialNoDollarRBrace12
     *<li>specialNoDollarRBrace13
     *<li>specialNoDollarRBrace14
     *<li>specialNoDollarRBrace15
     *<li>specialNoDollarRBrace16
     *<li>specialNoDollarRBrace17
     *<li>specialNoDollarRBrace18
     *<li>specialNoDollarRBrace19
     *<li>specialNoDollarRBrace20
     *<li>specialNoDollarRBrace21
     *<li>specialNoDollarRBrace22
     *<li>specialNoDollarRBrace23
     *<li>specialNoDollarRBrace24
     *<li>specialNoDollarRBrace25
     *<li>specialNoDollarRBrace26
     *<li>specialNoDollarRBrace27
     *<li>specialNoDollarRBrace28
     *<li>specialNoDollarRBrace29
     *</ul>
     *</b>
     */
    public interface InonSubstStart extends IvalueStringNoSubst {}

    /**
     * is implemented by <b>escapedChar</b>
     */
    public interface IescapedChar extends IvalueStringNoSubst {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *<li>specialNoDollarRBrace0
     *<li>specialNoDollarRBrace1
     *<li>specialNoDollarRBrace2
     *<li>specialNoDollarRBrace3
     *<li>specialNoDollarRBrace4
     *<li>specialNoDollarRBrace5
     *<li>specialNoDollarRBrace6
     *<li>specialNoDollarRBrace7
     *<li>specialNoDollarRBrace8
     *<li>specialNoDollarRBrace9
     *<li>specialNoDollarRBrace10
     *<li>specialNoDollarRBrace11
     *<li>specialNoDollarRBrace12
     *<li>specialNoDollarRBrace13
     *<li>specialNoDollarRBrace14
     *<li>specialNoDollarRBrace15
     *<li>specialNoDollarRBrace16
     *<li>specialNoDollarRBrace17
     *<li>specialNoDollarRBrace18
     *<li>specialNoDollarRBrace19
     *<li>specialNoDollarRBrace20
     *<li>specialNoDollarRBrace21
     *<li>specialNoDollarRBrace22
     *<li>specialNoDollarRBrace23
     *<li>specialNoDollarRBrace24
     *<li>specialNoDollarRBrace25
     *<li>specialNoDollarRBrace26
     *<li>specialNoDollarRBrace27
     *<li>specialNoDollarRBrace28
     *<li>specialNoDollarRBrace29
     *</ul>
     *</b>
     */
    public interface IspecialNoDollarRBrace extends InonSubstStart, IASTNodeToken {}

    /**
     * is implemented by <b>ident</b>
     */
    public interface Iident
    {
        public IToken getLeftIToken();
        public IToken getRightIToken();

        void accept(IAstVisitor v);
    }

    /**
     * is implemented by <b>optParameter</b>
     */
    public interface IoptParameter
    {
        public IToken getLeftIToken();
        public IToken getRightIToken();

        void accept(IAstVisitor v);
    }

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *</ul>
     *</b>
     */
    public interface IidentChars extends Iident {}

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *<li>special0
     *<li>special1
     *<li>special2
     *<li>special3
     *<li>special4
     *<li>special5
     *<li>special6
     *<li>special7
     *<li>special8
     *<li>special9
     *<li>special10
     *<li>special11
     *<li>special12
     *<li>special13
     *<li>special14
     *<li>special15
     *<li>special16
     *<li>special17
     *<li>special18
     *<li>special19
     *<li>special20
     *<li>special21
     *<li>special22
     *<li>special23
     *<li>special24
     *<li>special25
     *<li>special26
     *<li>special27
     *<li>special28
     *<li>special29
     *<li>special30
     *<li>special31
     *<li>special32
     *</ul>
     *</b>
     */
    public interface IescapableChar
    {
        public IToken getLeftIToken();
        public IToken getRightIToken();

        void accept(IAstVisitor v);
    }

    /**
     * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
     *<b>
     *<ul>
     *<li>special0
     *<li>special1
     *<li>special2
     *<li>special3
     *<li>special4
     *<li>special5
     *<li>special6
     *<li>special7
     *<li>special8
     *<li>special9
     *<li>special10
     *<li>special11
     *<li>special12
     *<li>special13
     *<li>special14
     *<li>special15
     *<li>special16
     *<li>special17
     *<li>special18
     *<li>special19
     *<li>special20
     *<li>special21
     *<li>special22
     *<li>special23
     *<li>special24
     *<li>special25
     *<li>special26
     *<li>special27
     *<li>special28
     *<li>special29
     *<li>special30
     *<li>special31
     *<li>special32
     *</ul>
     *</b>
     */
    public interface Ispecial extends IescapableChar, IASTNodeToken {}

    /**
     *<b>
     *<li>Rule 91:  simpleStringPrefixed ::= valStringNoSubst
     *<li>Rule 92:  simpleStringPrefixed ::= valStringNoSubst substPrefixed
     *</b>
     */
    static public class simpleStringPrefixed extends ASTNode implements IsimpleStringPrefixed
    {
        private IvalStringNoSubst _valStringNoSubst;
        private IsubstPrefixed _substPrefixed;

        /**
         * The value returned by <b>getvalStringNoSubst</b> may be <b>null</b>
         */
        public IvalStringNoSubst getvalStringNoSubst() { return _valStringNoSubst; }
        /**
         * The value returned by <b>getsubstPrefixed</b> may be <b>null</b>
         */
        public IsubstPrefixed getsubstPrefixed() { return _substPrefixed; }

        public simpleStringPrefixed(IToken leftIToken, IToken rightIToken,
                                    IvalStringNoSubst _valStringNoSubst,
                                    IsubstPrefixed _substPrefixed)
        {
            super(leftIToken, rightIToken);

            this._valStringNoSubst = _valStringNoSubst;
            if (_valStringNoSubst != null) ((ASTNode) _valStringNoSubst).setParent(this);
            this._substPrefixed = _substPrefixed;
            if (_substPrefixed != null) ((ASTNode) _substPrefixed).setParent(this);
            initialize();
        }

        /**
         * A list of all children of this node, including the null ones.
         */
        public java.util.ArrayList getAllChildren()
        {
            java.util.ArrayList list = new java.util.ArrayList();
            list.add(_valStringNoSubst);
            list.add(_substPrefixed);
            return list;
        }

        public boolean equals(Object o)
        {
            if (o == this) return true;
            if (! (o instanceof simpleStringPrefixed)) return false;
            if (! super.equals(o)) return false;
            simpleStringPrefixed other = (simpleStringPrefixed) o;
            if (_valStringNoSubst == null)
                if (other._valStringNoSubst != null) return false;
                else; // continue
            else if (! _valStringNoSubst.equals(other._valStringNoSubst)) return false;
            if (_substPrefixed == null)
                if (other._substPrefixed != null) return false;
                else; // continue
            else if (! _substPrefixed.equals(other._substPrefixed)) return false;
            return true;
        }

        public int hashCode()
        {
            int hash = super.hashCode();
            hash = hash * 31 + (_valStringNoSubst == null ? 0 : _valStringNoSubst.hashCode());
            hash = hash * 31 + (_substPrefixed == null ? 0 : _substPrefixed.hashCode());
            return hash;
        }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            boolean checkChildren = v.visit(this);
            if (checkChildren)
            {
                if (_valStringNoSubst != null) _valStringNoSubst.accept(v);
                if (_substPrefixed != null) _substPrefixed.accept(v);
            }
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 93:  valStringNoSubst ::= valueStringNoSubst$
     *</b>
     */
    static public class valStringNoSubst extends ASTNode implements IvalStringNoSubst
    {
        public valStringNoSubst(IToken leftIToken, IToken rightIToken)
        {
            super(leftIToken, rightIToken);

            initialize();
        }

        /**
         * A list of all children of this node, including the null ones.
         */
        public java.util.ArrayList getAllChildren()
        {
            java.util.ArrayList list = new java.util.ArrayList();
            return list;
        }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<em>
     *<li>Rule 94:  substPrefixed ::= substitutionList
     *</em>
     *<p>
     *<b>
     *<li>Rule 95:  substPrefixed ::= substitutionList simpleStringPrefixed
     *</b>
     */
    static public class substPrefixed extends ASTNode implements IsubstPrefixed
    {
        private substitutionList _substitutionList;
        private IsimpleStringPrefixed _simpleStringPrefixed;

        public substitutionList getsubstitutionList() { return _substitutionList; }
        /**
         * The value returned by <b>getsimpleStringPrefixed</b> may be <b>null</b>
         */
        public IsimpleStringPrefixed getsimpleStringPrefixed() { return _simpleStringPrefixed; }

        public substPrefixed(IToken leftIToken, IToken rightIToken,
                             substitutionList _substitutionList,
                             IsimpleStringPrefixed _simpleStringPrefixed)
        {
            super(leftIToken, rightIToken);

            this._substitutionList = _substitutionList;
            ((ASTNode) _substitutionList).setParent(this);
            this._simpleStringPrefixed = _simpleStringPrefixed;
            if (_simpleStringPrefixed != null) ((ASTNode) _simpleStringPrefixed).setParent(this);
            initialize();
        }

        /**
         * A list of all children of this node, including the null ones.
         */
        public java.util.ArrayList getAllChildren()
        {
            java.util.ArrayList list = new java.util.ArrayList();
            list.add(_substitutionList);
            list.add(_simpleStringPrefixed);
            return list;
        }

        public boolean equals(Object o)
        {
            if (o == this) return true;
            if (! (o instanceof substPrefixed)) return false;
            if (! super.equals(o)) return false;
            substPrefixed other = (substPrefixed) o;
            if (! _substitutionList.equals(other._substitutionList)) return false;
            if (_simpleStringPrefixed == null)
                if (other._simpleStringPrefixed != null) return false;
                else; // continue
            else if (! _simpleStringPrefixed.equals(other._simpleStringPrefixed)) return false;
            return true;
        }

        public int hashCode()
        {
            int hash = super.hashCode();
            hash = hash * 31 + (_substitutionList.hashCode());
            hash = hash * 31 + (_simpleStringPrefixed == null ? 0 : _simpleStringPrefixed.hashCode());
            return hash;
        }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            boolean checkChildren = v.visit(this);
            if (checkChildren)
            {
                _substitutionList.accept(v);
                if (_simpleStringPrefixed != null) _simpleStringPrefixed.accept(v);
            }
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 96:  substitutionList ::= substitution
     *<li>Rule 97:  substitutionList ::= substitutionList substitution
     *</b>
     */
    static public class substitutionList extends AbstractASTNodeList implements IsubstitutionList
    {
        public substitution getsubstitutionAt(int i) { return (substitution) getElementAt(i); }

        public substitutionList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
        {
            super(leftIToken, rightIToken, leftRecursive);
        }

        public substitutionList(substitution _substitution, boolean leftRecursive)
        {
            super((ASTNode) _substitution, leftRecursive);
            ((ASTNode) _substitution).setParent(this);
        }

        public void add(substitution _substitution)
        {
            super.add((ASTNode) _substitution);
            ((ASTNode) _substitution).setParent(this);
        }

        public boolean equals(Object o)
        {
            if (o == this) return true;
            if (! (o instanceof substitutionList)) return false;
            if (! super.equals(o)) return false;
            substitutionList other = (substitutionList    ) o;
            if (size() != other.size()) return false;
            for (int i = 0; i < size(); i++)
            {
                substitution element = getsubstitutionAt(i);
                    if (! element.equals(other.getsubstitutionAt(i))) return false;
            }
            return true;
        }

        public int hashCode()
        {
            int hash = super.hashCode();
            for (int i = 0; i < size(); i++)
                hash = hash * 31 + (getsubstitutionAt(i).hashCode());
            return hash;
        }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }
        public void enter(Visitor v)
        {
            boolean checkChildren = v.visit(this);
            if (checkChildren)
            {
                for (int i = 0; i < size(); i++)
                {
                    substitution element = getsubstitutionAt(i);
                    if (! v.preVisit(element)) continue;
                    element.enter(v);
                    v.postVisit(element);
                }
            }
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 104:  substitution ::= $$ {$ ident optParameter }$
     *</b>
     */
    static public class substitution extends ASTNode implements Isubstitution
    {
        private ident _ident;
        private optParameter _optParameter;

        /**
         * The value returned by <b>getident</b> may be <b>null</b>
         */
        public ident getident() { return _ident; }
        /**
         * The value returned by <b>getoptParameter</b> may be <b>null</b>
         */
        public optParameter getoptParameter() { return _optParameter; }

        public substitution(IToken leftIToken, IToken rightIToken,
                            ident _ident,
                            optParameter _optParameter)
        {
            super(leftIToken, rightIToken);

            this._ident = _ident;
            if (_ident != null) ((ASTNode) _ident).setParent(this);
            this._optParameter = _optParameter;
            if (_optParameter != null) ((ASTNode) _optParameter).setParent(this);
            initialize();
        }

        /**
         * A list of all children of this node, including the null ones.
         */
        public java.util.ArrayList getAllChildren()
        {
            java.util.ArrayList list = new java.util.ArrayList();
            list.add(_ident);
            list.add(_optParameter);
            return list;
        }

        public boolean equals(Object o)
        {
            if (o == this) return true;
            if (! (o instanceof substitution)) return false;
            if (! super.equals(o)) return false;
            substitution other = (substitution) o;
            if (_ident == null)
                if (other._ident != null) return false;
                else; // continue
            else if (! _ident.equals(other._ident)) return false;
            if (_optParameter == null)
                if (other._optParameter != null) return false;
                else; // continue
            else if (! _optParameter.equals(other._optParameter)) return false;
            return true;
        }

        public int hashCode()
        {
            int hash = super.hashCode();
            hash = hash * 31 + (_ident == null ? 0 : _ident.hashCode());
            hash = hash * 31 + (_optParameter == null ? 0 : _optParameter.hashCode());
            return hash;
        }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            boolean checkChildren = v.visit(this);
            if (checkChildren)
            {
                if (_ident != null) _ident.accept(v);
                if (_optParameter != null) _optParameter.accept(v);
            }
            v.endVisit(this);
        }
    }

    /**
     *<em>
     *<li>Rule 105:  optParameter ::= $Empty
     *</em>
     *<p>
     *<b>
     *<li>Rule 106:  optParameter ::= :$ value
     *</b>
     */
    static public class optParameter extends ASTNode implements IoptParameter
    {
        private Ivalue _value;

        /**
         * The value returned by <b>getvalue</b> may be <b>null</b>
         */
        public Ivalue getvalue() { return _value; }

        public optParameter(IToken leftIToken, IToken rightIToken,
                            Ivalue _value)
        {
            super(leftIToken, rightIToken);

            this._value = _value;
            if (_value != null) ((ASTNode) _value).setParent(this);
            initialize();
        }

        /**
         * A list of all children of this node, including the null ones.
         */
        public java.util.ArrayList getAllChildren()
        {
            java.util.ArrayList list = new java.util.ArrayList();
            list.add(_value);
            return list;
        }

        public boolean equals(Object o)
        {
            if (o == this) return true;
            if (! (o instanceof optParameter)) return false;
            if (! super.equals(o)) return false;
            optParameter other = (optParameter) o;
            if (_value == null)
                if (other._value != null) return false;
                else; // continue
            else if (! _value.equals(other._value)) return false;
            return true;
        }

        public int hashCode()
        {
            int hash = super.hashCode();
            hash = hash * 31 + (_value == null ? 0 : _value.hashCode());
            return hash;
        }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            boolean checkChildren = v.visit(this);
            if (checkChildren)
                if (_value != null) _value.accept(v);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 107:  ident ::= identChars$
     *</b>
     */
    static public class ident extends ASTNode implements Iident
    {
        public ident(IToken leftIToken, IToken rightIToken)
        {
            super(leftIToken, rightIToken);

            initialize();
        }

        /**
         * A list of all children of this node, including the null ones.
         */
        public java.util.ArrayList getAllChildren()
        {
            java.util.ArrayList list = new java.util.ArrayList();
            return list;
        }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 114:  escapedChar ::= \$ escapableChar
     *</b>
     */
    static public class escapedChar extends ASTNode implements IescapedChar
    {
        private IescapableChar _escapableChar;

        /**
         * The value returned by <b>getescapableChar</b> may be <b>null</b>
         */
        public IescapableChar getescapableChar() { return _escapableChar; }

        public escapedChar(IToken leftIToken, IToken rightIToken,
                           IescapableChar _escapableChar)
        {
            super(leftIToken, rightIToken);

            this._escapableChar = _escapableChar;
            if (_escapableChar != null) ((ASTNode) _escapableChar).setParent(this);
            initialize();
        }

        /**
         * A list of all children of this node, including the null ones.
         */
        public java.util.ArrayList getAllChildren()
        {
            java.util.ArrayList list = new java.util.ArrayList();
            list.add(_escapableChar);
            return list;
        }

        public boolean equals(Object o)
        {
            if (o == this) return true;
            if (! (o instanceof escapedChar)) return false;
            if (! super.equals(o)) return false;
            escapedChar other = (escapedChar) o;
            if (_escapableChar == null)
                if (other._escapableChar != null) return false;
                else; // continue
            else if (! _escapableChar.equals(other._escapableChar)) return false;
            return true;
        }

        public int hashCode()
        {
            int hash = super.hashCode();
            hash = hash * 31 + (_escapableChar == null ? 0 : _escapableChar.hashCode());
            return hash;
        }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            boolean checkChildren = v.visit(this);
            if (checkChildren)
                if (_escapableChar != null) _escapableChar.accept(v);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 118:  specialNoDollarRBrace ::= +
     *</b>
     */
    static public class specialNoDollarRBrace0 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getPlus() { return leftIToken; }

        public specialNoDollarRBrace0(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 119:  specialNoDollarRBrace ::= -
     *</b>
     */
    static public class specialNoDollarRBrace1 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getMinus() { return leftIToken; }

        public specialNoDollarRBrace1(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 120:  specialNoDollarRBrace ::= (
     *</b>
     */
    static public class specialNoDollarRBrace2 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getLeftParen() { return leftIToken; }

        public specialNoDollarRBrace2(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 121:  specialNoDollarRBrace ::= )
     *</b>
     */
    static public class specialNoDollarRBrace3 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getRightParen() { return leftIToken; }

        public specialNoDollarRBrace3(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 122:  specialNoDollarRBrace ::= "
     *</b>
     */
    static public class specialNoDollarRBrace4 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getDoubleQuote() { return leftIToken; }

        public specialNoDollarRBrace4(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 123:  specialNoDollarRBrace ::= !
     *</b>
     */
    static public class specialNoDollarRBrace5 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getExclamation() { return leftIToken; }

        public specialNoDollarRBrace5(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 124:  specialNoDollarRBrace ::= @
     *</b>
     */
    static public class specialNoDollarRBrace6 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getAtSign() { return leftIToken; }

        public specialNoDollarRBrace6(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 125:  specialNoDollarRBrace ::= `
     *</b>
     */
    static public class specialNoDollarRBrace7 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getBackQuote() { return leftIToken; }

        public specialNoDollarRBrace7(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 126:  specialNoDollarRBrace ::= ~
     *</b>
     */
    static public class specialNoDollarRBrace8 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getTilde() { return leftIToken; }

        public specialNoDollarRBrace8(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 127:  specialNoDollarRBrace ::= .
     *</b>
     */
    static public class specialNoDollarRBrace9 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getDot() { return leftIToken; }

        public specialNoDollarRBrace9(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 128:  specialNoDollarRBrace ::= /
     *</b>
     */
    static public class specialNoDollarRBrace10 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getSlash() { return leftIToken; }

        public specialNoDollarRBrace10(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 129:  specialNoDollarRBrace ::= %
     *</b>
     */
    static public class specialNoDollarRBrace11 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getPercent() { return leftIToken; }

        public specialNoDollarRBrace11(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 130:  specialNoDollarRBrace ::= &
     *</b>
     */
    static public class specialNoDollarRBrace12 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getAmpersand() { return leftIToken; }

        public specialNoDollarRBrace12(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 131:  specialNoDollarRBrace ::= ^
     *</b>
     */
    static public class specialNoDollarRBrace13 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getCaret() { return leftIToken; }

        public specialNoDollarRBrace13(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 132:  specialNoDollarRBrace ::= :
     *</b>
     */
    static public class specialNoDollarRBrace14 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getColon() { return leftIToken; }

        public specialNoDollarRBrace14(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 133:  specialNoDollarRBrace ::= ;
     *</b>
     */
    static public class specialNoDollarRBrace15 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getSemiColon() { return leftIToken; }

        public specialNoDollarRBrace15(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 134:  specialNoDollarRBrace ::= '
     *</b>
     */
    static public class specialNoDollarRBrace16 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getSingleQuote() { return leftIToken; }

        public specialNoDollarRBrace16(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 135:  specialNoDollarRBrace ::= |
     *</b>
     */
    static public class specialNoDollarRBrace17 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getVerticalBar() { return leftIToken; }

        public specialNoDollarRBrace17(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 136:  specialNoDollarRBrace ::= {
     *</b>
     */
    static public class specialNoDollarRBrace18 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getLeftBrace() { return leftIToken; }

        public specialNoDollarRBrace18(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 137:  specialNoDollarRBrace ::=  
     *</b>
     */
    static public class specialNoDollarRBrace19 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getSpace() { return leftIToken; }

        public specialNoDollarRBrace19(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 138:  specialNoDollarRBrace ::= [
     *</b>
     */
    static public class specialNoDollarRBrace20 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getLeftBracket() { return leftIToken; }

        public specialNoDollarRBrace20(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 139:  specialNoDollarRBrace ::= ]
     *</b>
     */
    static public class specialNoDollarRBrace21 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getRightBracket() { return leftIToken; }

        public specialNoDollarRBrace21(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 140:  specialNoDollarRBrace ::= ?
     *</b>
     */
    static public class specialNoDollarRBrace22 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getQuestionMark() { return leftIToken; }

        public specialNoDollarRBrace22(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 141:  specialNoDollarRBrace ::= ,
     *</b>
     */
    static public class specialNoDollarRBrace23 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getComma() { return leftIToken; }

        public specialNoDollarRBrace23(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 142:  specialNoDollarRBrace ::= <
     *</b>
     */
    static public class specialNoDollarRBrace24 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getLessThan() { return leftIToken; }

        public specialNoDollarRBrace24(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 143:  specialNoDollarRBrace ::= >
     *</b>
     */
    static public class specialNoDollarRBrace25 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getGreaterThan() { return leftIToken; }

        public specialNoDollarRBrace25(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 144:  specialNoDollarRBrace ::= =
     *</b>
     */
    static public class specialNoDollarRBrace26 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getEqual() { return leftIToken; }

        public specialNoDollarRBrace26(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 145:  specialNoDollarRBrace ::= #
     *</b>
     */
    static public class specialNoDollarRBrace27 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getSharp() { return leftIToken; }

        public specialNoDollarRBrace27(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 146:  specialNoDollarRBrace ::= *
     *</b>
     */
    static public class specialNoDollarRBrace28 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken getStar() { return leftIToken; }

        public specialNoDollarRBrace28(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 147:  specialNoDollarRBrace ::= _
     *</b>
     */
    static public class specialNoDollarRBrace29 extends ASTNodeToken implements IspecialNoDollarRBrace
    {
        public IToken get_() { return leftIToken; }

        public specialNoDollarRBrace29(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 148:  special ::= +
     *</b>
     */
    static public class special0 extends ASTNodeToken implements Ispecial
    {
        public IToken getPlus() { return leftIToken; }

        public special0(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 149:  special ::= -
     *</b>
     */
    static public class special1 extends ASTNodeToken implements Ispecial
    {
        public IToken getMinus() { return leftIToken; }

        public special1(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 150:  special ::= (
     *</b>
     */
    static public class special2 extends ASTNodeToken implements Ispecial
    {
        public IToken getLeftParen() { return leftIToken; }

        public special2(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 151:  special ::= )
     *</b>
     */
    static public class special3 extends ASTNodeToken implements Ispecial
    {
        public IToken getRightParen() { return leftIToken; }

        public special3(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 152:  special ::= "
     *</b>
     */
    static public class special4 extends ASTNodeToken implements Ispecial
    {
        public IToken getDoubleQuote() { return leftIToken; }

        public special4(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 153:  special ::= !
     *</b>
     */
    static public class special5 extends ASTNodeToken implements Ispecial
    {
        public IToken getExclamation() { return leftIToken; }

        public special5(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 154:  special ::= @
     *</b>
     */
    static public class special6 extends ASTNodeToken implements Ispecial
    {
        public IToken getAtSign() { return leftIToken; }

        public special6(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 155:  special ::= `
     *</b>
     */
    static public class special7 extends ASTNodeToken implements Ispecial
    {
        public IToken getBackQuote() { return leftIToken; }

        public special7(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 156:  special ::= ~
     *</b>
     */
    static public class special8 extends ASTNodeToken implements Ispecial
    {
        public IToken getTilde() { return leftIToken; }

        public special8(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 157:  special ::= .
     *</b>
     */
    static public class special9 extends ASTNodeToken implements Ispecial
    {
        public IToken getDot() { return leftIToken; }

        public special9(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 158:  special ::= /
     *</b>
     */
    static public class special10 extends ASTNodeToken implements Ispecial
    {
        public IToken getSlash() { return leftIToken; }

        public special10(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 159:  special ::= %
     *</b>
     */
    static public class special11 extends ASTNodeToken implements Ispecial
    {
        public IToken getPercent() { return leftIToken; }

        public special11(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 160:  special ::= &
     *</b>
     */
    static public class special12 extends ASTNodeToken implements Ispecial
    {
        public IToken getAmpersand() { return leftIToken; }

        public special12(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 161:  special ::= ^
     *</b>
     */
    static public class special13 extends ASTNodeToken implements Ispecial
    {
        public IToken getCaret() { return leftIToken; }

        public special13(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 162:  special ::= :
     *</b>
     */
    static public class special14 extends ASTNodeToken implements Ispecial
    {
        public IToken getColon() { return leftIToken; }

        public special14(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 163:  special ::= ;
     *</b>
     */
    static public class special15 extends ASTNodeToken implements Ispecial
    {
        public IToken getSemiColon() { return leftIToken; }

        public special15(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 164:  special ::= '
     *</b>
     */
    static public class special16 extends ASTNodeToken implements Ispecial
    {
        public IToken getSingleQuote() { return leftIToken; }

        public special16(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 165:  special ::= \
     *</b>
     */
    static public class special17 extends ASTNodeToken implements Ispecial
    {
        public IToken getBackSlash() { return leftIToken; }

        public special17(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 166:  special ::= |
     *</b>
     */
    static public class special18 extends ASTNodeToken implements Ispecial
    {
        public IToken getVerticalBar() { return leftIToken; }

        public special18(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 167:  special ::= {
     *</b>
     */
    static public class special19 extends ASTNodeToken implements Ispecial
    {
        public IToken getLeftBrace() { return leftIToken; }

        public special19(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 168:  special ::=  
     *</b>
     */
    static public class special20 extends ASTNodeToken implements Ispecial
    {
        public IToken getSpace() { return leftIToken; }

        public special20(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 169:  special ::= }
     *</b>
     */
    static public class special21 extends ASTNodeToken implements Ispecial
    {
        public IToken getRightBrace() { return leftIToken; }

        public special21(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 170:  special ::= [
     *</b>
     */
    static public class special22 extends ASTNodeToken implements Ispecial
    {
        public IToken getLeftBracket() { return leftIToken; }

        public special22(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 171:  special ::= ]
     *</b>
     */
    static public class special23 extends ASTNodeToken implements Ispecial
    {
        public IToken getRightBracket() { return leftIToken; }

        public special23(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 172:  special ::= ?
     *</b>
     */
    static public class special24 extends ASTNodeToken implements Ispecial
    {
        public IToken getQuestionMark() { return leftIToken; }

        public special24(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 173:  special ::= ,
     *</b>
     */
    static public class special25 extends ASTNodeToken implements Ispecial
    {
        public IToken getComma() { return leftIToken; }

        public special25(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 174:  special ::= <
     *</b>
     */
    static public class special26 extends ASTNodeToken implements Ispecial
    {
        public IToken getLessThan() { return leftIToken; }

        public special26(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 175:  special ::= >
     *</b>
     */
    static public class special27 extends ASTNodeToken implements Ispecial
    {
        public IToken getGreaterThan() { return leftIToken; }

        public special27(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 176:  special ::= =
     *</b>
     */
    static public class special28 extends ASTNodeToken implements Ispecial
    {
        public IToken getEqual() { return leftIToken; }

        public special28(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 177:  special ::= #
     *</b>
     */
    static public class special29 extends ASTNodeToken implements Ispecial
    {
        public IToken getSharp() { return leftIToken; }

        public special29(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 178:  special ::= *
     *</b>
     */
    static public class special30 extends ASTNodeToken implements Ispecial
    {
        public IToken getStar() { return leftIToken; }

        public special30(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 179:  special ::= _
     *</b>
     */
    static public class special31 extends ASTNodeToken implements Ispecial
    {
        public IToken get_() { return leftIToken; }

        public special31(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    /**
     *<b>
     *<li>Rule 180:  special ::= $
     *</b>
     */
    static public class special32 extends ASTNodeToken implements Ispecial
    {
        public IToken getDollarSign() { return leftIToken; }

        public special32(IToken token) { super(token); initialize(); }

        public void accept(IAstVisitor v)
        {
            if (! v.preVisit(this)) return;
            enter((Visitor) v);
            v.postVisit(this);
        }

        public void enter(Visitor v)
        {
            v.visit(this);
            v.endVisit(this);
        }
    }

    public interface Visitor extends IAstVisitor
    {
        boolean visit(ASTNode n);
        void endVisit(ASTNode n);

        boolean visit(ASTNodeToken n);
        void endVisit(ASTNodeToken n);

        boolean visit(simpleStringPrefixed n);
        void endVisit(simpleStringPrefixed n);

        boolean visit(valStringNoSubst n);
        void endVisit(valStringNoSubst n);

        boolean visit(substPrefixed n);
        void endVisit(substPrefixed n);

        boolean visit(substitutionList n);
        void endVisit(substitutionList n);

        boolean visit(substitution n);
        void endVisit(substitution n);

        boolean visit(optParameter n);
        void endVisit(optParameter n);

        boolean visit(ident n);
        void endVisit(ident n);

        boolean visit(escapedChar n);
        void endVisit(escapedChar n);

        boolean visit(specialNoDollarRBrace0 n);
        void endVisit(specialNoDollarRBrace0 n);

        boolean visit(specialNoDollarRBrace1 n);
        void endVisit(specialNoDollarRBrace1 n);

        boolean visit(specialNoDollarRBrace2 n);
        void endVisit(specialNoDollarRBrace2 n);

        boolean visit(specialNoDollarRBrace3 n);
        void endVisit(specialNoDollarRBrace3 n);

        boolean visit(specialNoDollarRBrace4 n);
        void endVisit(specialNoDollarRBrace4 n);

        boolean visit(specialNoDollarRBrace5 n);
        void endVisit(specialNoDollarRBrace5 n);

        boolean visit(specialNoDollarRBrace6 n);
        void endVisit(specialNoDollarRBrace6 n);

        boolean visit(specialNoDollarRBrace7 n);
        void endVisit(specialNoDollarRBrace7 n);

        boolean visit(specialNoDollarRBrace8 n);
        void endVisit(specialNoDollarRBrace8 n);

        boolean visit(specialNoDollarRBrace9 n);
        void endVisit(specialNoDollarRBrace9 n);

        boolean visit(specialNoDollarRBrace10 n);
        void endVisit(specialNoDollarRBrace10 n);

        boolean visit(specialNoDollarRBrace11 n);
        void endVisit(specialNoDollarRBrace11 n);

        boolean visit(specialNoDollarRBrace12 n);
        void endVisit(specialNoDollarRBrace12 n);

        boolean visit(specialNoDollarRBrace13 n);
        void endVisit(specialNoDollarRBrace13 n);

        boolean visit(specialNoDollarRBrace14 n);
        void endVisit(specialNoDollarRBrace14 n);

        boolean visit(specialNoDollarRBrace15 n);
        void endVisit(specialNoDollarRBrace15 n);

        boolean visit(specialNoDollarRBrace16 n);
        void endVisit(specialNoDollarRBrace16 n);

        boolean visit(specialNoDollarRBrace17 n);
        void endVisit(specialNoDollarRBrace17 n);

        boolean visit(specialNoDollarRBrace18 n);
        void endVisit(specialNoDollarRBrace18 n);

        boolean visit(specialNoDollarRBrace19 n);
        void endVisit(specialNoDollarRBrace19 n);

        boolean visit(specialNoDollarRBrace20 n);
        void endVisit(specialNoDollarRBrace20 n);

        boolean visit(specialNoDollarRBrace21 n);
        void endVisit(specialNoDollarRBrace21 n);

        boolean visit(specialNoDollarRBrace22 n);
        void endVisit(specialNoDollarRBrace22 n);

        boolean visit(specialNoDollarRBrace23 n);
        void endVisit(specialNoDollarRBrace23 n);

        boolean visit(specialNoDollarRBrace24 n);
        void endVisit(specialNoDollarRBrace24 n);

        boolean visit(specialNoDollarRBrace25 n);
        void endVisit(specialNoDollarRBrace25 n);

        boolean visit(specialNoDollarRBrace26 n);
        void endVisit(specialNoDollarRBrace26 n);

        boolean visit(specialNoDollarRBrace27 n);
        void endVisit(specialNoDollarRBrace27 n);

        boolean visit(specialNoDollarRBrace28 n);
        void endVisit(specialNoDollarRBrace28 n);

        boolean visit(specialNoDollarRBrace29 n);
        void endVisit(specialNoDollarRBrace29 n);

        boolean visit(special0 n);
        void endVisit(special0 n);

        boolean visit(special1 n);
        void endVisit(special1 n);

        boolean visit(special2 n);
        void endVisit(special2 n);

        boolean visit(special3 n);
        void endVisit(special3 n);

        boolean visit(special4 n);
        void endVisit(special4 n);

        boolean visit(special5 n);
        void endVisit(special5 n);

        boolean visit(special6 n);
        void endVisit(special6 n);

        boolean visit(special7 n);
        void endVisit(special7 n);

        boolean visit(special8 n);
        void endVisit(special8 n);

        boolean visit(special9 n);
        void endVisit(special9 n);

        boolean visit(special10 n);
        void endVisit(special10 n);

        boolean visit(special11 n);
        void endVisit(special11 n);

        boolean visit(special12 n);
        void endVisit(special12 n);

        boolean visit(special13 n);
        void endVisit(special13 n);

        boolean visit(special14 n);
        void endVisit(special14 n);

        boolean visit(special15 n);
        void endVisit(special15 n);

        boolean visit(special16 n);
        void endVisit(special16 n);

        boolean visit(special17 n);
        void endVisit(special17 n);

        boolean visit(special18 n);
        void endVisit(special18 n);

        boolean visit(special19 n);
        void endVisit(special19 n);

        boolean visit(special20 n);
        void endVisit(special20 n);

        boolean visit(special21 n);
        void endVisit(special21 n);

        boolean visit(special22 n);
        void endVisit(special22 n);

        boolean visit(special23 n);
        void endVisit(special23 n);

        boolean visit(special24 n);
        void endVisit(special24 n);

        boolean visit(special25 n);
        void endVisit(special25 n);

        boolean visit(special26 n);
        void endVisit(special26 n);

        boolean visit(special27 n);
        void endVisit(special27 n);

        boolean visit(special28 n);
        void endVisit(special28 n);

        boolean visit(special29 n);
        void endVisit(special29 n);

        boolean visit(special30 n);
        void endVisit(special30 n);

        boolean visit(special31 n);
        void endVisit(special31 n);

        boolean visit(special32 n);
        void endVisit(special32 n);

    }

    static public abstract class AbstractVisitor implements Visitor
    {
        public abstract void unimplementedVisitor(String s);

        public boolean preVisit(IAst element) { return true; }

        public void postVisit(IAst element) {}

        public boolean visit(ASTNodeToken n) { unimplementedVisitor("visit(ASTNodeToken)"); return true; }
        public void endVisit(ASTNodeToken n) { unimplementedVisitor("endVisit(ASTNodeToken)"); }

        public boolean visit(simpleStringPrefixed n) { unimplementedVisitor("visit(simpleStringPrefixed)"); return true; }
        public void endVisit(simpleStringPrefixed n) { unimplementedVisitor("endVisit(simpleStringPrefixed)"); }

        public boolean visit(valStringNoSubst n) { unimplementedVisitor("visit(valStringNoSubst)"); return true; }
        public void endVisit(valStringNoSubst n) { unimplementedVisitor("endVisit(valStringNoSubst)"); }

        public boolean visit(substPrefixed n) { unimplementedVisitor("visit(substPrefixed)"); return true; }
        public void endVisit(substPrefixed n) { unimplementedVisitor("endVisit(substPrefixed)"); }

        public boolean visit(substitutionList n) { unimplementedVisitor("visit(substitutionList)"); return true; }
        public void endVisit(substitutionList n) { unimplementedVisitor("endVisit(substitutionList)"); }

        public boolean visit(substitution n) { unimplementedVisitor("visit(substitution)"); return true; }
        public void endVisit(substitution n) { unimplementedVisitor("endVisit(substitution)"); }

        public boolean visit(optParameter n) { unimplementedVisitor("visit(optParameter)"); return true; }
        public void endVisit(optParameter n) { unimplementedVisitor("endVisit(optParameter)"); }

        public boolean visit(ident n) { unimplementedVisitor("visit(ident)"); return true; }
        public void endVisit(ident n) { unimplementedVisitor("endVisit(ident)"); }

        public boolean visit(escapedChar n) { unimplementedVisitor("visit(escapedChar)"); return true; }
        public void endVisit(escapedChar n) { unimplementedVisitor("endVisit(escapedChar)"); }

        public boolean visit(specialNoDollarRBrace0 n) { unimplementedVisitor("visit(specialNoDollarRBrace0)"); return true; }
        public void endVisit(specialNoDollarRBrace0 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace0)"); }

        public boolean visit(specialNoDollarRBrace1 n) { unimplementedVisitor("visit(specialNoDollarRBrace1)"); return true; }
        public void endVisit(specialNoDollarRBrace1 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace1)"); }

        public boolean visit(specialNoDollarRBrace2 n) { unimplementedVisitor("visit(specialNoDollarRBrace2)"); return true; }
        public void endVisit(specialNoDollarRBrace2 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace2)"); }

        public boolean visit(specialNoDollarRBrace3 n) { unimplementedVisitor("visit(specialNoDollarRBrace3)"); return true; }
        public void endVisit(specialNoDollarRBrace3 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace3)"); }

        public boolean visit(specialNoDollarRBrace4 n) { unimplementedVisitor("visit(specialNoDollarRBrace4)"); return true; }
        public void endVisit(specialNoDollarRBrace4 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace4)"); }

        public boolean visit(specialNoDollarRBrace5 n) { unimplementedVisitor("visit(specialNoDollarRBrace5)"); return true; }
        public void endVisit(specialNoDollarRBrace5 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace5)"); }

        public boolean visit(specialNoDollarRBrace6 n) { unimplementedVisitor("visit(specialNoDollarRBrace6)"); return true; }
        public void endVisit(specialNoDollarRBrace6 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace6)"); }

        public boolean visit(specialNoDollarRBrace7 n) { unimplementedVisitor("visit(specialNoDollarRBrace7)"); return true; }
        public void endVisit(specialNoDollarRBrace7 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace7)"); }

        public boolean visit(specialNoDollarRBrace8 n) { unimplementedVisitor("visit(specialNoDollarRBrace8)"); return true; }
        public void endVisit(specialNoDollarRBrace8 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace8)"); }

        public boolean visit(specialNoDollarRBrace9 n) { unimplementedVisitor("visit(specialNoDollarRBrace9)"); return true; }
        public void endVisit(specialNoDollarRBrace9 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace9)"); }

        public boolean visit(specialNoDollarRBrace10 n) { unimplementedVisitor("visit(specialNoDollarRBrace10)"); return true; }
        public void endVisit(specialNoDollarRBrace10 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace10)"); }

        public boolean visit(specialNoDollarRBrace11 n) { unimplementedVisitor("visit(specialNoDollarRBrace11)"); return true; }
        public void endVisit(specialNoDollarRBrace11 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace11)"); }

        public boolean visit(specialNoDollarRBrace12 n) { unimplementedVisitor("visit(specialNoDollarRBrace12)"); return true; }
        public void endVisit(specialNoDollarRBrace12 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace12)"); }

        public boolean visit(specialNoDollarRBrace13 n) { unimplementedVisitor("visit(specialNoDollarRBrace13)"); return true; }
        public void endVisit(specialNoDollarRBrace13 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace13)"); }

        public boolean visit(specialNoDollarRBrace14 n) { unimplementedVisitor("visit(specialNoDollarRBrace14)"); return true; }
        public void endVisit(specialNoDollarRBrace14 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace14)"); }

        public boolean visit(specialNoDollarRBrace15 n) { unimplementedVisitor("visit(specialNoDollarRBrace15)"); return true; }
        public void endVisit(specialNoDollarRBrace15 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace15)"); }

        public boolean visit(specialNoDollarRBrace16 n) { unimplementedVisitor("visit(specialNoDollarRBrace16)"); return true; }
        public void endVisit(specialNoDollarRBrace16 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace16)"); }

        public boolean visit(specialNoDollarRBrace17 n) { unimplementedVisitor("visit(specialNoDollarRBrace17)"); return true; }
        public void endVisit(specialNoDollarRBrace17 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace17)"); }

        public boolean visit(specialNoDollarRBrace18 n) { unimplementedVisitor("visit(specialNoDollarRBrace18)"); return true; }
        public void endVisit(specialNoDollarRBrace18 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace18)"); }

        public boolean visit(specialNoDollarRBrace19 n) { unimplementedVisitor("visit(specialNoDollarRBrace19)"); return true; }
        public void endVisit(specialNoDollarRBrace19 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace19)"); }

        public boolean visit(specialNoDollarRBrace20 n) { unimplementedVisitor("visit(specialNoDollarRBrace20)"); return true; }
        public void endVisit(specialNoDollarRBrace20 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace20)"); }

        public boolean visit(specialNoDollarRBrace21 n) { unimplementedVisitor("visit(specialNoDollarRBrace21)"); return true; }
        public void endVisit(specialNoDollarRBrace21 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace21)"); }

        public boolean visit(specialNoDollarRBrace22 n) { unimplementedVisitor("visit(specialNoDollarRBrace22)"); return true; }
        public void endVisit(specialNoDollarRBrace22 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace22)"); }

        public boolean visit(specialNoDollarRBrace23 n) { unimplementedVisitor("visit(specialNoDollarRBrace23)"); return true; }
        public void endVisit(specialNoDollarRBrace23 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace23)"); }

        public boolean visit(specialNoDollarRBrace24 n) { unimplementedVisitor("visit(specialNoDollarRBrace24)"); return true; }
        public void endVisit(specialNoDollarRBrace24 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace24)"); }

        public boolean visit(specialNoDollarRBrace25 n) { unimplementedVisitor("visit(specialNoDollarRBrace25)"); return true; }
        public void endVisit(specialNoDollarRBrace25 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace25)"); }

        public boolean visit(specialNoDollarRBrace26 n) { unimplementedVisitor("visit(specialNoDollarRBrace26)"); return true; }
        public void endVisit(specialNoDollarRBrace26 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace26)"); }

        public boolean visit(specialNoDollarRBrace27 n) { unimplementedVisitor("visit(specialNoDollarRBrace27)"); return true; }
        public void endVisit(specialNoDollarRBrace27 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace27)"); }

        public boolean visit(specialNoDollarRBrace28 n) { unimplementedVisitor("visit(specialNoDollarRBrace28)"); return true; }
        public void endVisit(specialNoDollarRBrace28 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace28)"); }

        public boolean visit(specialNoDollarRBrace29 n) { unimplementedVisitor("visit(specialNoDollarRBrace29)"); return true; }
        public void endVisit(specialNoDollarRBrace29 n) { unimplementedVisitor("endVisit(specialNoDollarRBrace29)"); }

        public boolean visit(special0 n) { unimplementedVisitor("visit(special0)"); return true; }
        public void endVisit(special0 n) { unimplementedVisitor("endVisit(special0)"); }

        public boolean visit(special1 n) { unimplementedVisitor("visit(special1)"); return true; }
        public void endVisit(special1 n) { unimplementedVisitor("endVisit(special1)"); }

        public boolean visit(special2 n) { unimplementedVisitor("visit(special2)"); return true; }
        public void endVisit(special2 n) { unimplementedVisitor("endVisit(special2)"); }

        public boolean visit(special3 n) { unimplementedVisitor("visit(special3)"); return true; }
        public void endVisit(special3 n) { unimplementedVisitor("endVisit(special3)"); }

        public boolean visit(special4 n) { unimplementedVisitor("visit(special4)"); return true; }
        public void endVisit(special4 n) { unimplementedVisitor("endVisit(special4)"); }

        public boolean visit(special5 n) { unimplementedVisitor("visit(special5)"); return true; }
        public void endVisit(special5 n) { unimplementedVisitor("endVisit(special5)"); }

        public boolean visit(special6 n) { unimplementedVisitor("visit(special6)"); return true; }
        public void endVisit(special6 n) { unimplementedVisitor("endVisit(special6)"); }

        public boolean visit(special7 n) { unimplementedVisitor("visit(special7)"); return true; }
        public void endVisit(special7 n) { unimplementedVisitor("endVisit(special7)"); }

        public boolean visit(special8 n) { unimplementedVisitor("visit(special8)"); return true; }
        public void endVisit(special8 n) { unimplementedVisitor("endVisit(special8)"); }

        public boolean visit(special9 n) { unimplementedVisitor("visit(special9)"); return true; }
        public void endVisit(special9 n) { unimplementedVisitor("endVisit(special9)"); }

        public boolean visit(special10 n) { unimplementedVisitor("visit(special10)"); return true; }
        public void endVisit(special10 n) { unimplementedVisitor("endVisit(special10)"); }

        public boolean visit(special11 n) { unimplementedVisitor("visit(special11)"); return true; }
        public void endVisit(special11 n) { unimplementedVisitor("endVisit(special11)"); }

        public boolean visit(special12 n) { unimplementedVisitor("visit(special12)"); return true; }
        public void endVisit(special12 n) { unimplementedVisitor("endVisit(special12)"); }

        public boolean visit(special13 n) { unimplementedVisitor("visit(special13)"); return true; }
        public void endVisit(special13 n) { unimplementedVisitor("endVisit(special13)"); }

        public boolean visit(special14 n) { unimplementedVisitor("visit(special14)"); return true; }
        public void endVisit(special14 n) { unimplementedVisitor("endVisit(special14)"); }

        public boolean visit(special15 n) { unimplementedVisitor("visit(special15)"); return true; }
        public void endVisit(special15 n) { unimplementedVisitor("endVisit(special15)"); }

        public boolean visit(special16 n) { unimplementedVisitor("visit(special16)"); return true; }
        public void endVisit(special16 n) { unimplementedVisitor("endVisit(special16)"); }

        public boolean visit(special17 n) { unimplementedVisitor("visit(special17)"); return true; }
        public void endVisit(special17 n) { unimplementedVisitor("endVisit(special17)"); }

        public boolean visit(special18 n) { unimplementedVisitor("visit(special18)"); return true; }
        public void endVisit(special18 n) { unimplementedVisitor("endVisit(special18)"); }

        public boolean visit(special19 n) { unimplementedVisitor("visit(special19)"); return true; }
        public void endVisit(special19 n) { unimplementedVisitor("endVisit(special19)"); }

        public boolean visit(special20 n) { unimplementedVisitor("visit(special20)"); return true; }
        public void endVisit(special20 n) { unimplementedVisitor("endVisit(special20)"); }

        public boolean visit(special21 n) { unimplementedVisitor("visit(special21)"); return true; }
        public void endVisit(special21 n) { unimplementedVisitor("endVisit(special21)"); }

        public boolean visit(special22 n) { unimplementedVisitor("visit(special22)"); return true; }
        public void endVisit(special22 n) { unimplementedVisitor("endVisit(special22)"); }

        public boolean visit(special23 n) { unimplementedVisitor("visit(special23)"); return true; }
        public void endVisit(special23 n) { unimplementedVisitor("endVisit(special23)"); }

        public boolean visit(special24 n) { unimplementedVisitor("visit(special24)"); return true; }
        public void endVisit(special24 n) { unimplementedVisitor("endVisit(special24)"); }

        public boolean visit(special25 n) { unimplementedVisitor("visit(special25)"); return true; }
        public void endVisit(special25 n) { unimplementedVisitor("endVisit(special25)"); }

        public boolean visit(special26 n) { unimplementedVisitor("visit(special26)"); return true; }
        public void endVisit(special26 n) { unimplementedVisitor("endVisit(special26)"); }

        public boolean visit(special27 n) { unimplementedVisitor("visit(special27)"); return true; }
        public void endVisit(special27 n) { unimplementedVisitor("endVisit(special27)"); }

        public boolean visit(special28 n) { unimplementedVisitor("visit(special28)"); return true; }
        public void endVisit(special28 n) { unimplementedVisitor("endVisit(special28)"); }

        public boolean visit(special29 n) { unimplementedVisitor("visit(special29)"); return true; }
        public void endVisit(special29 n) { unimplementedVisitor("endVisit(special29)"); }

        public boolean visit(special30 n) { unimplementedVisitor("visit(special30)"); return true; }
        public void endVisit(special30 n) { unimplementedVisitor("endVisit(special30)"); }

        public boolean visit(special31 n) { unimplementedVisitor("visit(special31)"); return true; }
        public void endVisit(special31 n) { unimplementedVisitor("endVisit(special31)"); }

        public boolean visit(special32 n) { unimplementedVisitor("visit(special32)"); return true; }
        public void endVisit(special32 n) { unimplementedVisitor("endVisit(special32)"); }


        public boolean visit(ASTNode n)
        {
            if (n instanceof ASTNodeToken) return visit((ASTNodeToken) n);
            else if (n instanceof simpleStringPrefixed) return visit((simpleStringPrefixed) n);
            else if (n instanceof valStringNoSubst) return visit((valStringNoSubst) n);
            else if (n instanceof substPrefixed) return visit((substPrefixed) n);
            else if (n instanceof substitutionList) return visit((substitutionList) n);
            else if (n instanceof substitution) return visit((substitution) n);
            else if (n instanceof optParameter) return visit((optParameter) n);
            else if (n instanceof ident) return visit((ident) n);
            else if (n instanceof escapedChar) return visit((escapedChar) n);
            else if (n instanceof specialNoDollarRBrace0) return visit((specialNoDollarRBrace0) n);
            else if (n instanceof specialNoDollarRBrace1) return visit((specialNoDollarRBrace1) n);
            else if (n instanceof specialNoDollarRBrace2) return visit((specialNoDollarRBrace2) n);
            else if (n instanceof specialNoDollarRBrace3) return visit((specialNoDollarRBrace3) n);
            else if (n instanceof specialNoDollarRBrace4) return visit((specialNoDollarRBrace4) n);
            else if (n instanceof specialNoDollarRBrace5) return visit((specialNoDollarRBrace5) n);
            else if (n instanceof specialNoDollarRBrace6) return visit((specialNoDollarRBrace6) n);
            else if (n instanceof specialNoDollarRBrace7) return visit((specialNoDollarRBrace7) n);
            else if (n instanceof specialNoDollarRBrace8) return visit((specialNoDollarRBrace8) n);
            else if (n instanceof specialNoDollarRBrace9) return visit((specialNoDollarRBrace9) n);
            else if (n instanceof specialNoDollarRBrace10) return visit((specialNoDollarRBrace10) n);
            else if (n instanceof specialNoDollarRBrace11) return visit((specialNoDollarRBrace11) n);
            else if (n instanceof specialNoDollarRBrace12) return visit((specialNoDollarRBrace12) n);
            else if (n instanceof specialNoDollarRBrace13) return visit((specialNoDollarRBrace13) n);
            else if (n instanceof specialNoDollarRBrace14) return visit((specialNoDollarRBrace14) n);
            else if (n instanceof specialNoDollarRBrace15) return visit((specialNoDollarRBrace15) n);
            else if (n instanceof specialNoDollarRBrace16) return visit((specialNoDollarRBrace16) n);
            else if (n instanceof specialNoDollarRBrace17) return visit((specialNoDollarRBrace17) n);
            else if (n instanceof specialNoDollarRBrace18) return visit((specialNoDollarRBrace18) n);
            else if (n instanceof specialNoDollarRBrace19) return visit((specialNoDollarRBrace19) n);
            else if (n instanceof specialNoDollarRBrace20) return visit((specialNoDollarRBrace20) n);
            else if (n instanceof specialNoDollarRBrace21) return visit((specialNoDollarRBrace21) n);
            else if (n instanceof specialNoDollarRBrace22) return visit((specialNoDollarRBrace22) n);
            else if (n instanceof specialNoDollarRBrace23) return visit((specialNoDollarRBrace23) n);
            else if (n instanceof specialNoDollarRBrace24) return visit((specialNoDollarRBrace24) n);
            else if (n instanceof specialNoDollarRBrace25) return visit((specialNoDollarRBrace25) n);
            else if (n instanceof specialNoDollarRBrace26) return visit((specialNoDollarRBrace26) n);
            else if (n instanceof specialNoDollarRBrace27) return visit((specialNoDollarRBrace27) n);
            else if (n instanceof specialNoDollarRBrace28) return visit((specialNoDollarRBrace28) n);
            else if (n instanceof specialNoDollarRBrace29) return visit((specialNoDollarRBrace29) n);
            else if (n instanceof special0) return visit((special0) n);
            else if (n instanceof special1) return visit((special1) n);
            else if (n instanceof special2) return visit((special2) n);
            else if (n instanceof special3) return visit((special3) n);
            else if (n instanceof special4) return visit((special4) n);
            else if (n instanceof special5) return visit((special5) n);
            else if (n instanceof special6) return visit((special6) n);
            else if (n instanceof special7) return visit((special7) n);
            else if (n instanceof special8) return visit((special8) n);
            else if (n instanceof special9) return visit((special9) n);
            else if (n instanceof special10) return visit((special10) n);
            else if (n instanceof special11) return visit((special11) n);
            else if (n instanceof special12) return visit((special12) n);
            else if (n instanceof special13) return visit((special13) n);
            else if (n instanceof special14) return visit((special14) n);
            else if (n instanceof special15) return visit((special15) n);
            else if (n instanceof special16) return visit((special16) n);
            else if (n instanceof special17) return visit((special17) n);
            else if (n instanceof special18) return visit((special18) n);
            else if (n instanceof special19) return visit((special19) n);
            else if (n instanceof special20) return visit((special20) n);
            else if (n instanceof special21) return visit((special21) n);
            else if (n instanceof special22) return visit((special22) n);
            else if (n instanceof special23) return visit((special23) n);
            else if (n instanceof special24) return visit((special24) n);
            else if (n instanceof special25) return visit((special25) n);
            else if (n instanceof special26) return visit((special26) n);
            else if (n instanceof special27) return visit((special27) n);
            else if (n instanceof special28) return visit((special28) n);
            else if (n instanceof special29) return visit((special29) n);
            else if (n instanceof special30) return visit((special30) n);
            else if (n instanceof special31) return visit((special31) n);
            else if (n instanceof special32) return visit((special32) n);
            throw new UnsupportedOperationException("visit(" + n.getClass().toString() + ")");
        }
        public void endVisit(ASTNode n)
        {
            if (n instanceof ASTNodeToken) endVisit((ASTNodeToken) n);
            else if (n instanceof simpleStringPrefixed) endVisit((simpleStringPrefixed) n);
            else if (n instanceof valStringNoSubst) endVisit((valStringNoSubst) n);
            else if (n instanceof substPrefixed) endVisit((substPrefixed) n);
            else if (n instanceof substitutionList) endVisit((substitutionList) n);
            else if (n instanceof substitution) endVisit((substitution) n);
            else if (n instanceof optParameter) endVisit((optParameter) n);
            else if (n instanceof ident) endVisit((ident) n);
            else if (n instanceof escapedChar) endVisit((escapedChar) n);
            else if (n instanceof specialNoDollarRBrace0) endVisit((specialNoDollarRBrace0) n);
            else if (n instanceof specialNoDollarRBrace1) endVisit((specialNoDollarRBrace1) n);
            else if (n instanceof specialNoDollarRBrace2) endVisit((specialNoDollarRBrace2) n);
            else if (n instanceof specialNoDollarRBrace3) endVisit((specialNoDollarRBrace3) n);
            else if (n instanceof specialNoDollarRBrace4) endVisit((specialNoDollarRBrace4) n);
            else if (n instanceof specialNoDollarRBrace5) endVisit((specialNoDollarRBrace5) n);
            else if (n instanceof specialNoDollarRBrace6) endVisit((specialNoDollarRBrace6) n);
            else if (n instanceof specialNoDollarRBrace7) endVisit((specialNoDollarRBrace7) n);
            else if (n instanceof specialNoDollarRBrace8) endVisit((specialNoDollarRBrace8) n);
            else if (n instanceof specialNoDollarRBrace9) endVisit((specialNoDollarRBrace9) n);
            else if (n instanceof specialNoDollarRBrace10) endVisit((specialNoDollarRBrace10) n);
            else if (n instanceof specialNoDollarRBrace11) endVisit((specialNoDollarRBrace11) n);
            else if (n instanceof specialNoDollarRBrace12) endVisit((specialNoDollarRBrace12) n);
            else if (n instanceof specialNoDollarRBrace13) endVisit((specialNoDollarRBrace13) n);
            else if (n instanceof specialNoDollarRBrace14) endVisit((specialNoDollarRBrace14) n);
            else if (n instanceof specialNoDollarRBrace15) endVisit((specialNoDollarRBrace15) n);
            else if (n instanceof specialNoDollarRBrace16) endVisit((specialNoDollarRBrace16) n);
            else if (n instanceof specialNoDollarRBrace17) endVisit((specialNoDollarRBrace17) n);
            else if (n instanceof specialNoDollarRBrace18) endVisit((specialNoDollarRBrace18) n);
            else if (n instanceof specialNoDollarRBrace19) endVisit((specialNoDollarRBrace19) n);
            else if (n instanceof specialNoDollarRBrace20) endVisit((specialNoDollarRBrace20) n);
            else if (n instanceof specialNoDollarRBrace21) endVisit((specialNoDollarRBrace21) n);
            else if (n instanceof specialNoDollarRBrace22) endVisit((specialNoDollarRBrace22) n);
            else if (n instanceof specialNoDollarRBrace23) endVisit((specialNoDollarRBrace23) n);
            else if (n instanceof specialNoDollarRBrace24) endVisit((specialNoDollarRBrace24) n);
            else if (n instanceof specialNoDollarRBrace25) endVisit((specialNoDollarRBrace25) n);
            else if (n instanceof specialNoDollarRBrace26) endVisit((specialNoDollarRBrace26) n);
            else if (n instanceof specialNoDollarRBrace27) endVisit((specialNoDollarRBrace27) n);
            else if (n instanceof specialNoDollarRBrace28) endVisit((specialNoDollarRBrace28) n);
            else if (n instanceof specialNoDollarRBrace29) endVisit((specialNoDollarRBrace29) n);
            else if (n instanceof special0) endVisit((special0) n);
            else if (n instanceof special1) endVisit((special1) n);
            else if (n instanceof special2) endVisit((special2) n);
            else if (n instanceof special3) endVisit((special3) n);
            else if (n instanceof special4) endVisit((special4) n);
            else if (n instanceof special5) endVisit((special5) n);
            else if (n instanceof special6) endVisit((special6) n);
            else if (n instanceof special7) endVisit((special7) n);
            else if (n instanceof special8) endVisit((special8) n);
            else if (n instanceof special9) endVisit((special9) n);
            else if (n instanceof special10) endVisit((special10) n);
            else if (n instanceof special11) endVisit((special11) n);
            else if (n instanceof special12) endVisit((special12) n);
            else if (n instanceof special13) endVisit((special13) n);
            else if (n instanceof special14) endVisit((special14) n);
            else if (n instanceof special15) endVisit((special15) n);
            else if (n instanceof special16) endVisit((special16) n);
            else if (n instanceof special17) endVisit((special17) n);
            else if (n instanceof special18) endVisit((special18) n);
            else if (n instanceof special19) endVisit((special19) n);
            else if (n instanceof special20) endVisit((special20) n);
            else if (n instanceof special21) endVisit((special21) n);
            else if (n instanceof special22) endVisit((special22) n);
            else if (n instanceof special23) endVisit((special23) n);
            else if (n instanceof special24) endVisit((special24) n);
            else if (n instanceof special25) endVisit((special25) n);
            else if (n instanceof special26) endVisit((special26) n);
            else if (n instanceof special27) endVisit((special27) n);
            else if (n instanceof special28) endVisit((special28) n);
            else if (n instanceof special29) endVisit((special29) n);
            else if (n instanceof special30) endVisit((special30) n);
            else if (n instanceof special31) endVisit((special31) n);
            else if (n instanceof special32) endVisit((special32) n);
            throw new UnsupportedOperationException("visit(" + n.getClass().toString() + ")");
        }
    }

    public void ruleAction(int ruleNumber)
    {
        switch (ruleNumber)
        {
 
            //
            // Rule 1:  digit ::= 0
            //
            case 1: {
                setResult(null);
          break;
            } 
            //
            // Rule 2:  digit ::= 1
            //
            case 2: {
                setResult(null);
          break;
            } 
            //
            // Rule 3:  digit ::= 2
            //
            case 3: {
                setResult(null);
          break;
            } 
            //
            // Rule 4:  digit ::= 3
            //
            case 4: {
                setResult(null);
          break;
            } 
            //
            // Rule 5:  digit ::= 4
            //
            case 5: {
                setResult(null);
          break;
            } 
            //
            // Rule 6:  digit ::= 5
            //
            case 6: {
                setResult(null);
          break;
            } 
            //
            // Rule 7:  digit ::= 6
            //
            case 7: {
                setResult(null);
          break;
            } 
            //
            // Rule 8:  digit ::= 7
            //
            case 8: {
                setResult(null);
          break;
            } 
            //
            // Rule 9:  digit ::= 8
            //
            case 9: {
                setResult(null);
          break;
            } 
            //
            // Rule 10:  digit ::= 9
            //
            case 10: {
                setResult(null);
          break;
            } 
            //
            // Rule 11:  aA ::= a
            //
            case 11: {
                setResult(null);
          break;
            } 
            //
            // Rule 12:  aA ::= A
            //
            case 12: {
                setResult(null);
          break;
            } 
            //
            // Rule 13:  bB ::= b
            //
            case 13: {
                setResult(null);
          break;
            } 
            //
            // Rule 14:  bB ::= B
            //
            case 14: {
                setResult(null);
          break;
            } 
            //
            // Rule 15:  cC ::= c
            //
            case 15: {
                setResult(null);
          break;
            } 
            //
            // Rule 16:  cC ::= C
            //
            case 16: {
                setResult(null);
          break;
            } 
            //
            // Rule 17:  dD ::= d
            //
            case 17: {
                setResult(null);
          break;
            } 
            //
            // Rule 18:  dD ::= D
            //
            case 18: {
                setResult(null);
          break;
            } 
            //
            // Rule 19:  eE ::= e
            //
            case 19: {
                setResult(null);
          break;
            } 
            //
            // Rule 20:  eE ::= E
            //
            case 20: {
                setResult(null);
          break;
            } 
            //
            // Rule 21:  fF ::= f
            //
            case 21: {
                setResult(null);
          break;
            } 
            //
            // Rule 22:  fF ::= F
            //
            case 22: {
                setResult(null);
          break;
            } 
            //
            // Rule 23:  gG ::= g
            //
            case 23: {
                setResult(null);
          break;
            } 
            //
            // Rule 24:  gG ::= G
            //
            case 24: {
                setResult(null);
          break;
            } 
            //
            // Rule 25:  hH ::= h
            //
            case 25: {
                setResult(null);
          break;
            } 
            //
            // Rule 26:  hH ::= H
            //
            case 26: {
                setResult(null);
          break;
            } 
            //
            // Rule 27:  iI ::= i
            //
            case 27: {
                setResult(null);
          break;
            } 
            //
            // Rule 28:  iI ::= I
            //
            case 28: {
                setResult(null);
          break;
            } 
            //
            // Rule 29:  jJ ::= j
            //
            case 29: {
                setResult(null);
          break;
            } 
            //
            // Rule 30:  jJ ::= J
            //
            case 30: {
                setResult(null);
          break;
            } 
            //
            // Rule 31:  kK ::= k
            //
            case 31: {
                setResult(null);
          break;
            } 
            //
            // Rule 32:  kK ::= K
            //
            case 32: {
                setResult(null);
          break;
            } 
            //
            // Rule 33:  lL ::= l
            //
            case 33: {
                setResult(null);
          break;
            } 
            //
            // Rule 34:  lL ::= L
            //
            case 34: {
                setResult(null);
          break;
            } 
            //
            // Rule 35:  mM ::= m
            //
            case 35: {
                setResult(null);
          break;
            } 
            //
            // Rule 36:  mM ::= M
            //
            case 36: {
                setResult(null);
          break;
            } 
            //
            // Rule 37:  nN ::= n
            //
            case 37: {
                setResult(null);
          break;
            } 
            //
            // Rule 38:  nN ::= N
            //
            case 38: {
                setResult(null);
          break;
            } 
            //
            // Rule 39:  oO ::= o
            //
            case 39: {
                setResult(null);
          break;
            } 
            //
            // Rule 40:  oO ::= O
            //
            case 40: {
                setResult(null);
          break;
            } 
            //
            // Rule 41:  pP ::= p
            //
            case 41: {
                setResult(null);
          break;
            } 
            //
            // Rule 42:  pP ::= P
            //
            case 42: {
                setResult(null);
          break;
            } 
            //
            // Rule 43:  qQ ::= q
            //
            case 43: {
                setResult(null);
          break;
            } 
            //
            // Rule 44:  qQ ::= Q
            //
            case 44: {
                setResult(null);
          break;
            } 
            //
            // Rule 45:  rR ::= r
            //
            case 45: {
                setResult(null);
          break;
            } 
            //
            // Rule 46:  rR ::= R
            //
            case 46: {
                setResult(null);
          break;
            } 
            //
            // Rule 47:  sS ::= s
            //
            case 47: {
                setResult(null);
          break;
            } 
            //
            // Rule 48:  sS ::= S
            //
            case 48: {
                setResult(null);
          break;
            } 
            //
            // Rule 49:  tT ::= t
            //
            case 49: {
                setResult(null);
          break;
            } 
            //
            // Rule 50:  tT ::= T
            //
            case 50: {
                setResult(null);
          break;
            } 
            //
            // Rule 51:  uU ::= u
            //
            case 51: {
                setResult(null);
          break;
            } 
            //
            // Rule 52:  uU ::= U
            //
            case 52: {
                setResult(null);
          break;
            } 
            //
            // Rule 53:  vV ::= v
            //
            case 53: {
                setResult(null);
          break;
            } 
            //
            // Rule 54:  vV ::= V
            //
            case 54: {
                setResult(null);
          break;
            } 
            //
            // Rule 55:  wW ::= w
            //
            case 55: {
                setResult(null);
          break;
            } 
            //
            // Rule 56:  wW ::= W
            //
            case 56: {
                setResult(null);
          break;
            } 
            //
            // Rule 57:  xX ::= x
            //
            case 57: {
                setResult(null);
          break;
            } 
            //
            // Rule 58:  xX ::= X
            //
            case 58: {
                setResult(null);
          break;
            } 
            //
            // Rule 59:  yY ::= y
            //
            case 59: {
                setResult(null);
          break;
            } 
            //
            // Rule 60:  yY ::= Y
            //
            case 60: {
                setResult(null);
          break;
            } 
            //
            // Rule 61:  zZ ::= z
            //
            case 61: {
                setResult(null);
          break;
            } 
            //
            // Rule 62:  zZ ::= Z
            //
            case 62: {
                setResult(null);
          break;
            } 
            //
            // Rule 63:  letter ::= aA
            //
            case 63:
                break; 
            //
            // Rule 64:  letter ::= bB
            //
            case 64:
                break; 
            //
            // Rule 65:  letter ::= cC
            //
            case 65:
                break; 
            //
            // Rule 66:  letter ::= dD
            //
            case 66:
                break; 
            //
            // Rule 67:  letter ::= eE
            //
            case 67:
                break; 
            //
            // Rule 68:  letter ::= fF
            //
            case 68:
                break; 
            //
            // Rule 69:  letter ::= gG
            //
            case 69:
                break; 
            //
            // Rule 70:  letter ::= hH
            //
            case 70:
                break; 
            //
            // Rule 71:  letter ::= iI
            //
            case 71:
                break; 
            //
            // Rule 72:  letter ::= jJ
            //
            case 72:
                break; 
            //
            // Rule 73:  letter ::= kK
            //
            case 73:
                break; 
            //
            // Rule 74:  letter ::= lL
            //
            case 74:
                break; 
            //
            // Rule 75:  letter ::= mM
            //
            case 75:
                break; 
            //
            // Rule 76:  letter ::= nN
            //
            case 76:
                break; 
            //
            // Rule 77:  letter ::= oO
            //
            case 77:
                break; 
            //
            // Rule 78:  letter ::= pP
            //
            case 78:
                break; 
            //
            // Rule 79:  letter ::= qQ
            //
            case 79:
                break; 
            //
            // Rule 80:  letter ::= rR
            //
            case 80:
                break; 
            //
            // Rule 81:  letter ::= sS
            //
            case 81:
                break; 
            //
            // Rule 82:  letter ::= tT
            //
            case 82:
                break; 
            //
            // Rule 83:  letter ::= uU
            //
            case 83:
                break; 
            //
            // Rule 84:  letter ::= vV
            //
            case 84:
                break; 
            //
            // Rule 85:  letter ::= wW
            //
            case 85:
                break; 
            //
            // Rule 86:  letter ::= xX
            //
            case 86:
                break; 
            //
            // Rule 87:  letter ::= yY
            //
            case 87:
                break; 
            //
            // Rule 88:  letter ::= zZ
            //
            case 88:
                break; 
            //
            // Rule 89:  value ::= simpleStringPrefixed
            //
            case 89:
                break; 
            //
            // Rule 90:  value ::= substPrefixed
            //
            case 90:
                break; 
            //
            // Rule 91:  simpleStringPrefixed ::= valStringNoSubst
            //
            case 91: {
                setResult(
                    new simpleStringPrefixed(getLeftIToken(), getRightIToken(),
                                             (IvalStringNoSubst)getRhsSym(1),
                                             (IsubstPrefixed)null)
                );
          break;
            } 
            //
            // Rule 92:  simpleStringPrefixed ::= valStringNoSubst substPrefixed
            //
            case 92: {
                setResult(
                    new simpleStringPrefixed(getLeftIToken(), getRightIToken(),
                                             (IvalStringNoSubst)getRhsSym(1),
                                             (IsubstPrefixed)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 93:  valStringNoSubst ::= valueStringNoSubst$
            //
            case 93: {
                setResult(
                    new valStringNoSubst(getLeftIToken(), getRightIToken())
                );
          break;
            } 
            //
            // Rule 94:  substPrefixed ::= substitutionList
            //
            case 94:
                break; 
            //
            // Rule 95:  substPrefixed ::= substitutionList simpleStringPrefixed
            //
            case 95: {
                setResult(
                    new substPrefixed(getLeftIToken(), getRightIToken(),
                                      (substitutionList)getRhsSym(1),
                                      (IsimpleStringPrefixed)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 96:  substitutionList ::= substitution
            //
            case 96: {
                setResult(
                    new substitutionList((substitution)getRhsSym(1), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 97:  substitutionList ::= substitutionList substitution
            //
            case 97: {
                ((substitutionList)getRhsSym(1)).add((substitution)getRhsSym(2));
          break;
            } 
            //
            // Rule 98:  valueStringNoSubst ::= nonSubstStart
            //
            case 98:
                break; 
            //
            // Rule 99:  valueStringNoSubst ::= escapedChar
            //
            case 99:
                break; 
            //
            // Rule 100:  valueStringNoSubst ::= valueStringNoSubst escapedChar
            //
            case 100: {
                setResult(null);
          break;
            } 
            //
            // Rule 101:  valueStringNoSubst ::= valueStringNoSubst letter
            //
            case 101: {
                setResult(null);
          break;
            } 
            //
            // Rule 102:  valueStringNoSubst ::= valueStringNoSubst digit
            //
            case 102: {
                setResult(null);
          break;
            } 
            //
            // Rule 103:  valueStringNoSubst ::= valueStringNoSubst specialNoDollarRBrace
            //
            case 103: {
                setResult(null);
          break;
            } 
            //
            // Rule 104:  substitution ::= $$ {$ ident optParameter }$
            //
            case 104: {
                setResult(
                    new substitution(getLeftIToken(), getRightIToken(),
                                     (ident)getRhsSym(3),
                                     (optParameter)getRhsSym(4))
                );
          break;
            } 
            //
            // Rule 105:  optParameter ::= $Empty
            //
            case 105: {
                setResult(null);
          break;
            } 
            //
            // Rule 106:  optParameter ::= :$ value
            //
            case 106: {
                setResult(
                    new optParameter(getLeftIToken(), getRightIToken(),
                                     (Ivalue)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 107:  ident ::= identChars$
            //
            case 107: {
                setResult(
                    new ident(getLeftIToken(), getRightIToken())
                );
          break;
            } 
            //
            // Rule 108:  identChars ::= letter
            //
            case 108:
                break; 
            //
            // Rule 109:  identChars ::= identChars letter
            //
            case 109: {
                setResult(null);
          break;
            } 
            //
            // Rule 110:  identChars ::= identChars digit
            //
            case 110: {
                setResult(null);
          break;
            } 
            //
            // Rule 111:  nonSubstStart ::= letter
            //
            case 111:
                break; 
            //
            // Rule 112:  nonSubstStart ::= digit
            //
            case 112:
                break; 
            //
            // Rule 113:  nonSubstStart ::= specialNoDollarRBrace
            //
            case 113:
                break; 
            //
            // Rule 114:  escapedChar ::= \$ escapableChar
            //
            case 114: {
                setResult(
                    new escapedChar(getLeftIToken(), getRightIToken(),
                                    (IescapableChar)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 115:  escapableChar ::= letter
            //
            case 115:
                break; 
            //
            // Rule 116:  escapableChar ::= digit
            //
            case 116:
                break; 
            //
            // Rule 117:  escapableChar ::= special
            //
            case 117:
                break; 
            //
            // Rule 118:  specialNoDollarRBrace ::= +
            //
            case 118: {
                setResult(
                    new specialNoDollarRBrace0(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 119:  specialNoDollarRBrace ::= -
            //
            case 119: {
                setResult(
                    new specialNoDollarRBrace1(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 120:  specialNoDollarRBrace ::= (
            //
            case 120: {
                setResult(
                    new specialNoDollarRBrace2(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 121:  specialNoDollarRBrace ::= )
            //
            case 121: {
                setResult(
                    new specialNoDollarRBrace3(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 122:  specialNoDollarRBrace ::= "
            //
            case 122: {
                setResult(
                    new specialNoDollarRBrace4(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 123:  specialNoDollarRBrace ::= !
            //
            case 123: {
                setResult(
                    new specialNoDollarRBrace5(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 124:  specialNoDollarRBrace ::= @
            //
            case 124: {
                setResult(
                    new specialNoDollarRBrace6(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 125:  specialNoDollarRBrace ::= `
            //
            case 125: {
                setResult(
                    new specialNoDollarRBrace7(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 126:  specialNoDollarRBrace ::= ~
            //
            case 126: {
                setResult(
                    new specialNoDollarRBrace8(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 127:  specialNoDollarRBrace ::= .
            //
            case 127: {
                setResult(
                    new specialNoDollarRBrace9(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 128:  specialNoDollarRBrace ::= /
            //
            case 128: {
                setResult(
                    new specialNoDollarRBrace10(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 129:  specialNoDollarRBrace ::= %
            //
            case 129: {
                setResult(
                    new specialNoDollarRBrace11(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 130:  specialNoDollarRBrace ::= &
            //
            case 130: {
                setResult(
                    new specialNoDollarRBrace12(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 131:  specialNoDollarRBrace ::= ^
            //
            case 131: {
                setResult(
                    new specialNoDollarRBrace13(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 132:  specialNoDollarRBrace ::= :
            //
            case 132: {
                setResult(
                    new specialNoDollarRBrace14(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 133:  specialNoDollarRBrace ::= ;
            //
            case 133: {
                setResult(
                    new specialNoDollarRBrace15(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 134:  specialNoDollarRBrace ::= '
            //
            case 134: {
                setResult(
                    new specialNoDollarRBrace16(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 135:  specialNoDollarRBrace ::= |
            //
            case 135: {
                setResult(
                    new specialNoDollarRBrace17(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 136:  specialNoDollarRBrace ::= {
            //
            case 136: {
                setResult(
                    new specialNoDollarRBrace18(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 137:  specialNoDollarRBrace ::=  
            //
            case 137: {
                setResult(
                    new specialNoDollarRBrace19(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 138:  specialNoDollarRBrace ::= [
            //
            case 138: {
                setResult(
                    new specialNoDollarRBrace20(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 139:  specialNoDollarRBrace ::= ]
            //
            case 139: {
                setResult(
                    new specialNoDollarRBrace21(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 140:  specialNoDollarRBrace ::= ?
            //
            case 140: {
                setResult(
                    new specialNoDollarRBrace22(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 141:  specialNoDollarRBrace ::= ,
            //
            case 141: {
                setResult(
                    new specialNoDollarRBrace23(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 142:  specialNoDollarRBrace ::= <
            //
            case 142: {
                setResult(
                    new specialNoDollarRBrace24(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 143:  specialNoDollarRBrace ::= >
            //
            case 143: {
                setResult(
                    new specialNoDollarRBrace25(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 144:  specialNoDollarRBrace ::= =
            //
            case 144: {
                setResult(
                    new specialNoDollarRBrace26(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 145:  specialNoDollarRBrace ::= #
            //
            case 145: {
                setResult(
                    new specialNoDollarRBrace27(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 146:  specialNoDollarRBrace ::= *
            //
            case 146: {
                setResult(
                    new specialNoDollarRBrace28(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 147:  specialNoDollarRBrace ::= _
            //
            case 147: {
                setResult(
                    new specialNoDollarRBrace29(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 148:  special ::= +
            //
            case 148: {
                setResult(
                    new special0(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 149:  special ::= -
            //
            case 149: {
                setResult(
                    new special1(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 150:  special ::= (
            //
            case 150: {
                setResult(
                    new special2(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 151:  special ::= )
            //
            case 151: {
                setResult(
                    new special3(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 152:  special ::= "
            //
            case 152: {
                setResult(
                    new special4(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 153:  special ::= !
            //
            case 153: {
                setResult(
                    new special5(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 154:  special ::= @
            //
            case 154: {
                setResult(
                    new special6(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 155:  special ::= `
            //
            case 155: {
                setResult(
                    new special7(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 156:  special ::= ~
            //
            case 156: {
                setResult(
                    new special8(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 157:  special ::= .
            //
            case 157: {
                setResult(
                    new special9(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 158:  special ::= /
            //
            case 158: {
                setResult(
                    new special10(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 159:  special ::= %
            //
            case 159: {
                setResult(
                    new special11(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 160:  special ::= &
            //
            case 160: {
                setResult(
                    new special12(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 161:  special ::= ^
            //
            case 161: {
                setResult(
                    new special13(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 162:  special ::= :
            //
            case 162: {
                setResult(
                    new special14(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 163:  special ::= ;
            //
            case 163: {
                setResult(
                    new special15(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 164:  special ::= '
            //
            case 164: {
                setResult(
                    new special16(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 165:  special ::= \
            //
            case 165: {
                setResult(
                    new special17(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 166:  special ::= |
            //
            case 166: {
                setResult(
                    new special18(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 167:  special ::= {
            //
            case 167: {
                setResult(
                    new special19(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 168:  special ::=  
            //
            case 168: {
                setResult(
                    new special20(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 169:  special ::= }
            //
            case 169: {
                setResult(
                    new special21(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 170:  special ::= [
            //
            case 170: {
                setResult(
                    new special22(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 171:  special ::= ]
            //
            case 171: {
                setResult(
                    new special23(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 172:  special ::= ?
            //
            case 172: {
                setResult(
                    new special24(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 173:  special ::= ,
            //
            case 173: {
                setResult(
                    new special25(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 174:  special ::= <
            //
            case 174: {
                setResult(
                    new special26(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 175:  special ::= >
            //
            case 175: {
                setResult(
                    new special27(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 176:  special ::= =
            //
            case 176: {
                setResult(
                    new special28(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 177:  special ::= #
            //
            case 177: {
                setResult(
                    new special29(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 178:  special ::= *
            //
            case 178: {
                setResult(
                    new special30(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 179:  special ::= _
            //
            case 179: {
                setResult(
                    new special31(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 180:  special ::= $
            //
            case 180: {
                setResult(
                    new special32(getRhsIToken(1))
                );
          break;
            }
    
            default:
                break;
        }
        return;
    }
}

