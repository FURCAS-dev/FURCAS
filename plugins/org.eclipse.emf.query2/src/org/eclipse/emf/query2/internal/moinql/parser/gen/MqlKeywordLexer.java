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

import lpg.lpgjavaruntime.*;


public class MqlKeywordLexer extends MqlKeywordLexerprs implements MqlParserGensym
{
    private char[] inputChars;
    private final int keywordKind[] = new int[17 + 1];

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


    public MqlKeywordLexer(char[] inputChars, int identifierKind)
    {
        this.inputChars = inputChars;
        keywordKind[0] = identifierKind;

        //
        // Rule 1:  MqlKeyWord ::= s e l e c t
        //
		keywordKind[1] = (TK_select);
	  
	
        //
        // Rule 2:  MqlKeyWord ::= t y p e
        //
		keywordKind[2] = (TK_type);
	  
	
        //
        // Rule 3:  MqlKeyWord ::= n o t
        //
		keywordKind[3] = (TK_not);
	  
	
        //
        // Rule 4:  MqlKeyWord ::= i n
        //
		keywordKind[4] = (TK_in);
	  
	
        //
        // Rule 5:  MqlKeyWord ::= o r
        //
		keywordKind[5] = (TK_or);
	  
	
        //
        // Rule 6:  MqlKeyWord ::= a n d
        //
		keywordKind[6] = (TK_and);
	  
	
        //
        // Rule 7:  MqlKeyWord ::= n u l l
        //
		keywordKind[7] = (TK_null);
	  
	
        //
        // Rule 8:  MqlKeyWord ::= t r u e
        //
		keywordKind[8] = (TK_true);
	  
	
        //
        // Rule 9:  MqlKeyWord ::= f a l s e
        //
		keywordKind[9] = (TK_false);
	  
	
        //
        // Rule 10:  MqlKeyWord ::= f r o m
        //
		keywordKind[10] = (TK_from);
	  
	
        //
        // Rule 11:  MqlKeyWord ::= w h e r e
        //
		keywordKind[11] = (TK_where);
	  
	
        //
        // Rule 12:  MqlKeyWord ::= a s
        //
		keywordKind[12] = (TK_as);
	  
	
        //
        // Rule 13:  MqlKeyWord ::= w i t h o u t s u b t y p e s
        //
		keywordKind[13] = (TK_withoutsubtypes);
	  
	
        //
        // Rule 14:  MqlKeyWord ::= r e s o u r c e s
        //
		keywordKind[14] = (TK_resources);
	  
	
        //
        // Rule 15:  MqlKeyWord ::= e l e m e n t s
        //
		keywordKind[15] = (TK_elements);
	  
	
        //
        // Rule 16:  MqlKeyWord ::= f o r
        //
		keywordKind[16] = (TK_for);
	  
	
        //
        // Rule 17:  MqlKeyWord ::= l i k e
        //
		keywordKind[17] = (TK_like);
	  
	

        for (int i = 0; i < keywordKind.length; i++)
        {
            if (keywordKind[i] == 0)
                keywordKind[i] = identifierKind;
        }
    }
}

