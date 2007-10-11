/**
* <copyright>
*
* Copyright (c) 2005, 2007 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
*
* </copyright>
*
* $Id: OCLKWLexer.java,v 1.1 2007/10/11 23:05:00 cdamus Exp $
*/

package org.eclipse.ocl.parser;



public class OCLKWLexer extends OCLKWLexerprs implements OCLParsersym
{
    private char[] inputChars;
    private final int keywordKind[] = new int[63 + 1];

    public int[] getKeywordKinds() { return keywordKind; }

    public int lexer(int curtok, int lasttok)
    {
        int current_kind = getKind(inputChars[curtok]),
            act;

        for (act = tAction(START_STATE, current_kind);
             act > NUM_RULES && act < ACCEPT_ACTION;
             act = tAction(act, current_kind))
        {
            curtok++;
            current_kind = (curtok > lasttok
                                   ? Char_EOF
                                   : getKind(inputChars[curtok]));
        }

        if (act > ERROR_ACTION)
        {
            curtok++;
            act -= ERROR_ACTION;
        }

        return keywordKind[act == ERROR_ACTION  || curtok <= lasttok ? 0 : act];
    }

    public void setInputChars(char[] inputChars) { this.inputChars = inputChars; }


    final static int tokenKind[] = new int[128];
    static
    {
        tokenKind['$'] = Char_DollarSign;

        tokenKind['a'] = Char_a;
        tokenKind['b'] = Char_b;
        tokenKind['c'] = Char_c;
        tokenKind['d'] = Char_d;
        tokenKind['e'] = Char_e;
        tokenKind['f'] = Char_f;
        tokenKind['g'] = Char_g;
        tokenKind['h'] = Char_h;
        tokenKind['i'] = Char_i;
        tokenKind['j'] = Char_j;
        tokenKind['k'] = Char_k;
        tokenKind['l'] = Char_l;
        tokenKind['m'] = Char_m;
        tokenKind['n'] = Char_n;
        tokenKind['o'] = Char_o;
        tokenKind['p'] = Char_p;
        tokenKind['q'] = Char_q;
        tokenKind['r'] = Char_r;
        tokenKind['s'] = Char_s;
        tokenKind['t'] = Char_t;
        tokenKind['u'] = Char_u;
        tokenKind['v'] = Char_v;
        tokenKind['w'] = Char_w;
        tokenKind['x'] = Char_x;
        tokenKind['y'] = Char_y;
        tokenKind['z'] = Char_z;

        tokenKind['A'] = Char_A;
        tokenKind['B'] = Char_B;
        tokenKind['C'] = Char_C;
        tokenKind['D'] = Char_D;
        tokenKind['E'] = Char_E;
        tokenKind['F'] = Char_F;
        tokenKind['G'] = Char_G;
        tokenKind['H'] = Char_H;
        tokenKind['I'] = Char_I;
        tokenKind['J'] = Char_J;
        tokenKind['K'] = Char_K;
        tokenKind['L'] = Char_L;
        tokenKind['M'] = Char_M;
        tokenKind['N'] = Char_N;
        tokenKind['O'] = Char_O;
        tokenKind['P'] = Char_P;
        tokenKind['Q'] = Char_Q;
        tokenKind['R'] = Char_R;
        tokenKind['S'] = Char_S;
        tokenKind['T'] = Char_T;
        tokenKind['U'] = Char_U;
        tokenKind['V'] = Char_V;
        tokenKind['W'] = Char_W;
        tokenKind['X'] = Char_X;
        tokenKind['Y'] = Char_Y;
        tokenKind['Z'] = Char_Z;
    };

    final int getKind(char c)
    {
        return (c < 128 ? tokenKind[c] : 0);
    }


    public OCLKWLexer(char[] inputChars, int identifierKind)
    {
        this.inputChars = inputChars;
        keywordKind[0] = identifierKind;

        //
        // Rule 1:  KeyWord ::= s e l f
        //
		keywordKind[1] = (TK_self);
	  
	
        //
        // Rule 2:  KeyWord ::= i n v
        //
		keywordKind[2] = (TK_inv);
	  
	
        //
        // Rule 3:  KeyWord ::= p r e
        //
		keywordKind[3] = (TK_pre);
	  
	
        //
        // Rule 4:  KeyWord ::= p o s t
        //
		keywordKind[4] = (TK_post);
	  
	
        //
        // Rule 5:  KeyWord ::= b o d y
        //
		keywordKind[5] = (TK_body);
	  
	
        //
        // Rule 6:  KeyWord ::= c o n t e x t
        //
		keywordKind[6] = (TK_context);
	  
	
        //
        // Rule 7:  KeyWord ::= p a c k a g e
        //
		keywordKind[7] = (TK_package);
	  
	
        //
        // Rule 8:  KeyWord ::= e n d p a c k a g e
        //
		keywordKind[8] = (TK_endpackage);
	  
	
        //
        // Rule 9:  KeyWord ::= d e f
        //
		keywordKind[9] = (TK_def);
	  
	
        //
        // Rule 10:  KeyWord ::= d e r i v e
        //
		keywordKind[10] = (TK_derive);
	  
	
        //
        // Rule 11:  KeyWord ::= i n i t
        //
		keywordKind[11] = (TK_init);
	  
	
        //
        // Rule 12:  KeyWord ::= i f
        //
		keywordKind[12] = (TK_if);
	  
	
        //
        // Rule 13:  KeyWord ::= t h e n
        //
		keywordKind[13] = (TK_then);
	  
	
        //
        // Rule 14:  KeyWord ::= e l s e
        //
		keywordKind[14] = (TK_else);
	  
	
        //
        // Rule 15:  KeyWord ::= e n d i f
        //
		keywordKind[15] = (TK_endif);
	  
	
        //
        // Rule 16:  KeyWord ::= a n d
        //
		keywordKind[16] = (TK_and);
	  
	
        //
        // Rule 17:  KeyWord ::= o r
        //
		keywordKind[17] = (TK_or);
	  
	
        //
        // Rule 18:  KeyWord ::= x o r
        //
		keywordKind[18] = (TK_xor);
	  
	
        //
        // Rule 19:  KeyWord ::= n o t
        //
		keywordKind[19] = (TK_not);
	  
	
        //
        // Rule 20:  KeyWord ::= i m p l i e s
        //
		keywordKind[20] = (TK_implies);
	  
	
        //
        // Rule 21:  KeyWord ::= l e t
        //
		keywordKind[21] = (TK_let);
	  
	
        //
        // Rule 22:  KeyWord ::= i n
        //
		keywordKind[22] = (TK_in);
	  
	
        //
        // Rule 23:  KeyWord ::= t r u e
        //
		keywordKind[23] = (TK_true);
	  
	
        //
        // Rule 24:  KeyWord ::= f a l s e
        //
		keywordKind[24] = (TK_false);
	  
	
        //
        // Rule 25:  KeyWord ::= S e t
        //
		keywordKind[25] = (TK_Set);
	  
	
        //
        // Rule 26:  KeyWord ::= B a g
        //
		keywordKind[26] = (TK_Bag);
	  
	
        //
        // Rule 27:  KeyWord ::= S e q u e n c e
        //
		keywordKind[27] = (TK_Sequence);
	  
	
        //
        // Rule 28:  KeyWord ::= C o l l e c t i o n
        //
		keywordKind[28] = (TK_Collection);
	  
	
        //
        // Rule 29:  KeyWord ::= O r d e r e d S e t
        //
		keywordKind[29] = (TK_OrderedSet);
	  
	
        //
        // Rule 30:  KeyWord ::= i t e r a t e
        //
		keywordKind[30] = (TK_iterate);
	  
	
        //
        // Rule 31:  KeyWord ::= f o r A l l
        //
		keywordKind[31] = (TK_forAll);
	  
	
        //
        // Rule 32:  KeyWord ::= e x i s t s
        //
		keywordKind[32] = (TK_exists);
	  
	
        //
        // Rule 33:  KeyWord ::= i s U n i q u e
        //
		keywordKind[33] = (TK_isUnique);
	  
	
        //
        // Rule 34:  KeyWord ::= a n y
        //
		keywordKind[34] = (TK_any);
	  
	
        //
        // Rule 35:  KeyWord ::= o n e
        //
		keywordKind[35] = (TK_one);
	  
	
        //
        // Rule 36:  KeyWord ::= c o l l e c t
        //
		keywordKind[36] = (TK_collect);
	  
	
        //
        // Rule 37:  KeyWord ::= s e l e c t
        //
		keywordKind[37] = (TK_select);
	  
	
        //
        // Rule 38:  KeyWord ::= r e j e c t
        //
		keywordKind[38] = (TK_reject);
	  
	
        //
        // Rule 39:  KeyWord ::= c o l l e c t N e s t e d
        //
		keywordKind[39] = (TK_collectNested);
	  
	
        //
        // Rule 40:  KeyWord ::= s o r t e d B y
        //
		keywordKind[40] = (TK_sortedBy);
	  
	
        //
        // Rule 41:  KeyWord ::= c l o s u r e
        //
		keywordKind[41] = (TK_closure);
	  
	
        //
        // Rule 42:  KeyWord ::= o c l I s K i n d O f
        //
		keywordKind[42] = (TK_oclIsKindOf);
	  
	
        //
        // Rule 43:  KeyWord ::= o c l I s T y p e O f
        //
		keywordKind[43] = (TK_oclIsTypeOf);
	  
	
        //
        // Rule 44:  KeyWord ::= o c l A s T y p e
        //
		keywordKind[44] = (TK_oclAsType);
	  
	
        //
        // Rule 45:  KeyWord ::= o c l I s N e w
        //
		keywordKind[45] = (TK_oclIsNew);
	  
	
        //
        // Rule 46:  KeyWord ::= o c l I s U n d e f i n e d
        //
		keywordKind[46] = (TK_oclIsUndefined);
	  
	
        //
        // Rule 47:  KeyWord ::= o c l I s I n v a l i d
        //
		keywordKind[47] = (TK_oclIsInvalid);
	  
	
        //
        // Rule 48:  KeyWord ::= o c l I s I n S t a t e
        //
		keywordKind[48] = (TK_oclIsInState);
	  
	
        //
        // Rule 49:  KeyWord ::= a l l I n s t a n c e s
        //
		keywordKind[49] = (TK_allInstances);
	  
	
        //
        // Rule 50:  KeyWord ::= S t r i n g
        //
		keywordKind[50] = (TK_String);
	  
	
        //
        // Rule 51:  KeyWord ::= I n t e g e r
        //
		keywordKind[51] = (TK_Integer);
	  
	
        //
        // Rule 52:  KeyWord ::= U n l i m i t e d N a t u r a l
        //
		keywordKind[52] = (TK_UnlimitedNatural);
	  
	
        //
        // Rule 53:  KeyWord ::= R e a l
        //
		keywordKind[53] = (TK_Real);
	  
	
        //
        // Rule 54:  KeyWord ::= B o o l e a n
        //
		keywordKind[54] = (TK_Boolean);
	  
	
        //
        // Rule 55:  KeyWord ::= T u p l e
        //
		keywordKind[55] = (TK_Tuple);
	  
	
        //
        // Rule 56:  KeyWord ::= O c l A n y
        //
		keywordKind[56] = (TK_OclAny);
	  
	
        //
        // Rule 57:  KeyWord ::= O c l V o i d
        //
		keywordKind[57] = (TK_OclVoid);
	  
	
        //
        // Rule 58:  KeyWord ::= I n v a l i d
        //
		keywordKind[58] = (TK_Invalid);
	  
	
        //
        // Rule 59:  KeyWord ::= O c l M e s s a g e
        //
		keywordKind[59] = (TK_OclMessage);
	  
	
        //
        // Rule 60:  KeyWord ::= n u l l
        //
		keywordKind[60] = (TK_null);
	  
	
        //
        // Rule 61:  KeyWord ::= O c l I n v a l i d
        //
		keywordKind[61] = (TK_OclInvalid);
	  
	
        //
        // Rule 62:  KeyWord ::= a t t r
        //
		keywordKind[62] = (TK_attr);
	  
	
        //
        // Rule 63:  KeyWord ::= o p e r
        //
		keywordKind[63] = (TK_oper);
	  
	

        for (int i = 0; i < keywordKind.length; i++)
        {
            if (keywordKind[i] == 0)
                keywordKind[i] = identifierKind;
        }
    }
}

