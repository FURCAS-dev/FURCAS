
/**
  * This file is generated for MOIN-OCL with LPG. 
  */

package com.sap.tc.moin.ocl.parser.gen;

import lpg.lpgjavaruntime.*;

public class OclKeywordLexer extends OclKeywordLexerprs implements OclParserGensym
{
    private char[] inputChars;
    private final int keywordKind[] = new int[59 + 1];

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


    public OclKeywordLexer(char[] inputChars, int identifierKind)
    {
        this.inputChars = inputChars;
        keywordKind[0] = identifierKind;

        //
        // Rule 1:  OclKeyWord ::= s e l f
        //
		keywordKind[1] = (TK_self);
	  
	
        //
        // Rule 2:  OclKeyWord ::= i f
        //
		keywordKind[2] = (TK_if);
	  
	
        //
        // Rule 3:  OclKeyWord ::= t h e n
        //
		keywordKind[3] = (TK_then);
	  
	
        //
        // Rule 4:  OclKeyWord ::= e l s e
        //
		keywordKind[4] = (TK_else);
	  
	
        //
        // Rule 5:  OclKeyWord ::= e n d i f
        //
		keywordKind[5] = (TK_endif);
	  
	
        //
        // Rule 6:  OclKeyWord ::= a n d
        //
		keywordKind[6] = (TK_and);
	  
	
        //
        // Rule 7:  OclKeyWord ::= o r
        //
		keywordKind[7] = (TK_or);
	  
	
        //
        // Rule 8:  OclKeyWord ::= x o r
        //
		keywordKind[8] = (TK_xor);
	  
	
        //
        // Rule 9:  OclKeyWord ::= n o t
        //
		keywordKind[9] = (TK_not);
	  
	
        //
        // Rule 10:  OclKeyWord ::= i m p l i e s
        //
		keywordKind[10] = (TK_implies);
	  
	
        //
        // Rule 11:  OclKeyWord ::= l e t
        //
		keywordKind[11] = (TK_let);
	  
	
        //
        // Rule 12:  OclKeyWord ::= i n
        //
		keywordKind[12] = (TK_in);
	  
	
        //
        // Rule 13:  OclKeyWord ::= t r u e
        //
		keywordKind[13] = (TK_true);
	  
	
        //
        // Rule 14:  OclKeyWord ::= f a l s e
        //
		keywordKind[14] = (TK_false);
	  
	
        //
        // Rule 15:  OclKeyWord ::= S e t
        //
		keywordKind[15] = (TK_Set);
	  
	
        //
        // Rule 16:  OclKeyWord ::= B a g
        //
		keywordKind[16] = (TK_Bag);
	  
	
        //
        // Rule 17:  OclKeyWord ::= S e q u e n c e
        //
		keywordKind[17] = (TK_Sequence);
	  
	
        //
        // Rule 18:  OclKeyWord ::= C o l l e c t i o n
        //
		keywordKind[18] = (TK_Collection);
	  
	
        //
        // Rule 19:  OclKeyWord ::= O r d e r e d S e t
        //
		keywordKind[19] = (TK_OrderedSet);
	  
	
        //
        // Rule 20:  OclKeyWord ::= i t e r a t e
        //
		keywordKind[20] = (TK_iterate);
	  
	
        //
        // Rule 21:  OclKeyWord ::= f o r A l l
        //
		keywordKind[21] = (TK_forAll);
	  
	
        //
        // Rule 22:  OclKeyWord ::= e x i s t s
        //
		keywordKind[22] = (TK_exists);
	  
	
        //
        // Rule 23:  OclKeyWord ::= i s U n i q u e
        //
		keywordKind[23] = (TK_isUnique);
	  
	
        //
        // Rule 24:  OclKeyWord ::= a n y
        //
		keywordKind[24] = (TK_any);
	  
	
        //
        // Rule 25:  OclKeyWord ::= o n e
        //
		keywordKind[25] = (TK_one);
	  
	
        //
        // Rule 26:  OclKeyWord ::= c o l l e c t
        //
		keywordKind[26] = (TK_collect);
	  
	
        //
        // Rule 27:  OclKeyWord ::= s e l e c t
        //
		keywordKind[27] = (TK_select);
	  
	
        //
        // Rule 28:  OclKeyWord ::= r e j e c t
        //
		keywordKind[28] = (TK_reject);
	  
	
        //
        // Rule 29:  OclKeyWord ::= c o l l e c t N e s t e d
        //
		keywordKind[29] = (TK_collectNested);
	  
	
        //
        // Rule 30:  OclKeyWord ::= s o r t e d B y
        //
		keywordKind[30] = (TK_sortedBy);
	  
	
        //
        // Rule 31:  OclKeyWord ::= o c l I s K i n d O f
        //
		keywordKind[31] = (TK_oclIsKindOf);
	  
	
        //
        // Rule 32:  OclKeyWord ::= o c l I s T y p e O f
        //
		keywordKind[32] = (TK_oclIsTypeOf);
	  
	
        //
        // Rule 33:  OclKeyWord ::= o c l A s T y p e
        //
		keywordKind[33] = (TK_oclAsType);
	  
	
        //
        // Rule 34:  OclKeyWord ::= o c l I s U n d e f i n e d
        //
		keywordKind[34] = (TK_oclIsUndefined);
	  
	
        //
        // Rule 35:  OclKeyWord ::= o c l I s I n v a l i d
        //
		keywordKind[35] = (TK_oclIsInvalid);
	  
	
        //
        // Rule 36:  OclKeyWord ::= a l l I n s t a n c e s
        //
		keywordKind[36] = (TK_allInstances);
	  
	
        //
        // Rule 37:  OclKeyWord ::= S t r i n g
        //
		keywordKind[37] = (TK_String);
	  
	
        //
        // Rule 38:  OclKeyWord ::= I n t e g e r
        //
		keywordKind[38] = (TK_Integer);
	  
	
        //
        // Rule 39:  OclKeyWord ::= R e a l
        //
		keywordKind[39] = (TK_Real);
	  
	
        //
        // Rule 40:  OclKeyWord ::= F l o a t
        //
		keywordKind[40] = (TK_Float);
	  
	
        //
        // Rule 41:  OclKeyWord ::= D o a b l e
        //
		keywordKind[41] = (TK_Double);
	  
	
        //
        // Rule 42:  OclKeyWord ::= B o o l e a n
        //
		keywordKind[42] = (TK_Boolean);
	  
	
        //
        // Rule 43:  OclKeyWord ::= T u p l e
        //
		keywordKind[43] = (TK_Tuple);
	  
	
        //
        // Rule 44:  OclKeyWord ::= O c l A n y
        //
		keywordKind[44] = (TK_OclAny);
	  
	
        //
        // Rule 45:  OclKeyWord ::= O c l V o i d
        //
		keywordKind[45] = (TK_OclVoid);
	  
	
        //
        // Rule 46:  OclKeyWord ::= O c l I n v a l i d
        //
		keywordKind[46] = (TK_OclInvalid);
	  
	
        //
        // Rule 47:  OclKeyWord ::= n u l l
        //
		keywordKind[47] = (TK_null);
	  
	
        //
        // Rule 48:  OclKeyWord ::= i n v a l i d
        //
		keywordKind[48] = (TK_invalid);
	  
	
        //
        // Rule 49:  OclKeyWord ::= i n v
        //
		keywordKind[49] = (TK_inv);
	  
	
        //
        // Rule 50:  OclKeyWord ::= p r e
        //
		keywordKind[50] = (TK_pre);
	  
	
        //
        // Rule 51:  OclKeyWord ::= e x p
        //
		keywordKind[51] = (TK_exp);
	  
	
        //
        // Rule 52:  OclKeyWord ::= p o s t
        //
		keywordKind[52] = (TK_post);
	  
	
        //
        // Rule 53:  OclKeyWord ::= b o d y
        //
		keywordKind[53] = (TK_body);
	  
	
        //
        // Rule 54:  OclKeyWord ::= c o n t e x t
        //
		keywordKind[54] = (TK_context);
	  
	
        //
        // Rule 55:  OclKeyWord ::= p a c k a g e
        //
		keywordKind[55] = (TK_package);
	  
	
        //
        // Rule 56:  OclKeyWord ::= e n d p a c k a g e
        //
		keywordKind[56] = (TK_endpackage);
	  
	
        //
        // Rule 57:  OclKeyWord ::= d e f
        //
		keywordKind[57] = (TK_def);
	  
	
        //
        // Rule 58:  OclKeyWord ::= d e r i v e
        //
		keywordKind[58] = (TK_derive);
	  
	
        //
        // Rule 59:  OclKeyWord ::= i n i t
        //
		keywordKind[59] = (TK_init);
	  
	

        for (int i = 0; i < keywordKind.length; i++)
        {
            if (keywordKind[i] == 0)
                keywordKind[i] = identifierKind;
        }
    }
}

