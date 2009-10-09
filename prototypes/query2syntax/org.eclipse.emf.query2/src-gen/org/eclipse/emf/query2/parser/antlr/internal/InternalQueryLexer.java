package org.eclipse.emf.query2.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.parser.antlr.Lexer;

public class InternalQueryLexer extends Lexer {
    public static final int RULE_ID=5;
    public static final int RULE_SINGED_LONG=7;
    public static final int T29=29;
    public static final int T28=28;
    public static final int T27=27;
    public static final int T26=26;
    public static final int T25=25;
    public static final int Tokens=41;
    public static final int T24=24;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=9;
    public static final int T23=23;
    public static final int T40=40;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_STRING=4;
    public static final int RULE_SIGNED_DOUBLE=6;
    public static final int T38=38;
    public static final int T11=11;
    public static final int T37=37;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T39=39;
    public static final int T14=14;
    public static final int T34=34;
    public static final int RULE_WS=10;
    public static final int T15=15;
    public static final int T33=33;
    public static final int T16=16;
    public static final int T36=36;
    public static final int T17=17;
    public static final int T35=35;
    public static final int T18=18;
    public static final int T30=30;
    public static final int T19=19;
    public static final int T32=32;
    public static final int T31=31;
    public InternalQueryLexer() {;} 
    public InternalQueryLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:10:5: ( 'import' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:10:7: 'import'
            {
            match("import"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T11

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:11:5: ( ':' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:11:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:12:5: ( 'select' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:12:7: 'select'
            {
            match("select"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:13:5: ( ',' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:13:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:14:5: ( 'from' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:14:7: 'from'
            {
            match("from"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:15:5: ( 'where' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:15:7: 'where'
            {
            match("where"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:16:5: ( '.' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:16:7: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:17:5: ( 'withoutsubtypes' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:17:7: 'withoutsubtypes'
            {
            match("withoutsubtypes"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public final void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:18:5: ( 'as' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:18:7: 'as'
            {
            match("as"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public final void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:19:5: ( 'not' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:19:7: 'not'
            {
            match("not"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start T21
    public final void mT21() throws RecognitionException {
        try {
            int _type = T21;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:20:5: ( 'in' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:20:7: 'in'
            {
            match("in"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start T22
    public final void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:21:5: ( 'resources' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:21:7: 'resources'
            {
            match("resources"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:22:5: ( '{' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:22:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:23:5: ( '}' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:23:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:24:5: ( 'elements' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:24:7: 'elements'
            {
            match("elements"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public final void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:25:5: ( 'or' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:25:7: 'or'
            {
            match("or"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public final void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:26:5: ( 'and' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:26:7: 'and'
            {
            match("and"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start T28
    public final void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:27:5: ( '(' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:27:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:28:5: ( ')' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:28:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public final void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:29:5: ( 'true' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:29:7: 'true'
            {
            match("true"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start T31
    public final void mT31() throws RecognitionException {
        try {
            int _type = T31;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:30:5: ( 'false' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:30:7: 'false'
            {
            match("false"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T31

    // $ANTLR start T32
    public final void mT32() throws RecognitionException {
        try {
            int _type = T32;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:31:5: ( 'null' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:31:7: 'null'
            {
            match("null"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T32

    // $ANTLR start T33
    public final void mT33() throws RecognitionException {
        try {
            int _type = T33;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:32:5: ( '=' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:32:7: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start T34
    public final void mT34() throws RecognitionException {
        try {
            int _type = T34;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:33:5: ( '<' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:33:7: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T34

    // $ANTLR start T35
    public final void mT35() throws RecognitionException {
        try {
            int _type = T35;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:34:5: ( '>' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:34:7: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T35

    // $ANTLR start T36
    public final void mT36() throws RecognitionException {
        try {
            int _type = T36;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:35:5: ( '<=' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:35:7: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T36

    // $ANTLR start T37
    public final void mT37() throws RecognitionException {
        try {
            int _type = T37;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:36:5: ( '>=' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:36:7: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T37

    // $ANTLR start T38
    public final void mT38() throws RecognitionException {
        try {
            int _type = T38;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:37:5: ( '!=' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:37:7: '!='
            {
            match("!="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T38

    // $ANTLR start T39
    public final void mT39() throws RecognitionException {
        try {
            int _type = T39;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:38:5: ( 'like' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:38:7: 'like'
            {
            match("like"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T39

    // $ANTLR start T40
    public final void mT40() throws RecognitionException {
        try {
            int _type = T40;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:39:5: ( 'notlike' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:39:7: 'notlike'
            {
            match("notlike"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T40

    // $ANTLR start RULE_SINGED_LONG
    public final void mRULE_SINGED_LONG() throws RecognitionException {
        try {
            int _type = RULE_SINGED_LONG;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2175:18: ( ( '-' )? ( '0' .. '9' )+ )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2175:20: ( '-' )? ( '0' .. '9' )+
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2175:20: ( '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2175:20: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2175:25: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2175:26: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_SINGED_LONG

    // $ANTLR start RULE_SIGNED_DOUBLE
    public final void mRULE_SIGNED_DOUBLE() throws RecognitionException {
        try {
            int _type = RULE_SIGNED_DOUBLE;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2177:20: ( ( '-' )? ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2177:22: ( '-' )? ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2177:22: ( '-' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='-') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2177:22: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2177:27: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2177:28: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2177:39: ( '.' ( '0' .. '9' )+ )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='.') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2177:40: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2177:44: ( '0' .. '9' )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2177:45: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_SIGNED_DOUBLE

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2179:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2179:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2179:11: ( '^' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='^') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2179:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2179:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='Z')||LA8_0=='_'||(LA8_0>='a' && LA8_0<='z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ID

    // $ANTLR start RULE_STRING
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2181:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2181:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2181:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\"') ) {
                alt11=1;
            }
            else if ( (LA11_0=='\'') ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2181:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2181:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2181:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop9:
                    do {
                        int alt9=3;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='\\') ) {
                            alt9=1;
                        }
                        else if ( ((LA9_0>='\u0000' && LA9_0<='!')||(LA9_0>='#' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFE')) ) {
                            alt9=2;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2181:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2181:62: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2181:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2181:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop10:
                    do {
                        int alt10=3;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0=='\\') ) {
                            alt10=1;
                        }
                        else if ( ((LA10_0>='\u0000' && LA10_0<='&')||(LA10_0>='(' && LA10_0<='[')||(LA10_0>=']' && LA10_0<='\uFFFE')) ) {
                            alt10=2;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2181:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2181:129: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_STRING

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2183:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2183:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2183:24: ( options {greedy=false; } : . )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='*') ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1=='/') ) {
                        alt12=2;
                    }
                    else if ( ((LA12_1>='\u0000' && LA12_1<='.')||(LA12_1>='0' && LA12_1<='\uFFFE')) ) {
                        alt12=1;
                    }


                }
                else if ( ((LA12_0>='\u0000' && LA12_0<=')')||(LA12_0>='+' && LA12_0<='\uFFFE')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2183:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            match("*/"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ML_COMMENT

    // $ANTLR start RULE_SL_COMMENT
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2185:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2185:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2185:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\uFFFE')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2185:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2185:40: ( ( '\\r' )? '\\n' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\n'||LA15_0=='\r') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2185:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2185:41: ( '\\r' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='\r') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2185:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_SL_COMMENT

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2187:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2187:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2187:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\t' && LA16_0<='\n')||LA16_0=='\r'||LA16_0==' ') ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    public void mTokens() throws RecognitionException {
        // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | RULE_SINGED_LONG | RULE_SIGNED_DOUBLE | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS )
        int alt17=37;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:70: T26
                {
                mT26(); 

                }
                break;
            case 17 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:74: T27
                {
                mT27(); 

                }
                break;
            case 18 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:78: T28
                {
                mT28(); 

                }
                break;
            case 19 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:82: T29
                {
                mT29(); 

                }
                break;
            case 20 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:86: T30
                {
                mT30(); 

                }
                break;
            case 21 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:90: T31
                {
                mT31(); 

                }
                break;
            case 22 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:94: T32
                {
                mT32(); 

                }
                break;
            case 23 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:98: T33
                {
                mT33(); 

                }
                break;
            case 24 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:102: T34
                {
                mT34(); 

                }
                break;
            case 25 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:106: T35
                {
                mT35(); 

                }
                break;
            case 26 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:110: T36
                {
                mT36(); 

                }
                break;
            case 27 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:114: T37
                {
                mT37(); 

                }
                break;
            case 28 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:118: T38
                {
                mT38(); 

                }
                break;
            case 29 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:122: T39
                {
                mT39(); 

                }
                break;
            case 30 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:126: T40
                {
                mT40(); 

                }
                break;
            case 31 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:130: RULE_SINGED_LONG
                {
                mRULE_SINGED_LONG(); 

                }
                break;
            case 32 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:147: RULE_SIGNED_DOUBLE
                {
                mRULE_SIGNED_DOUBLE(); 

                }
                break;
            case 33 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:166: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 34 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:174: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 35 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:186: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 36 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:202: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 37 :
                // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1:218: RULE_WS
                {
                mRULE_WS(); 

                }
                break;

        }

    }


    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA17_eotS =
        "\1\uffff\1\31\1\uffff\1\31\1\uffff\2\31\1\uffff\3\31\2\uffff\2\31"+
        "\2\uffff\1\31\1\uffff\1\55\1\57\1\uffff\1\31\1\uffff\1\61\4\uffff"+
        "\1\65\6\31\1\74\5\31\1\102\1\31\4\uffff\1\31\5\uffff\6\31\1\uffff"+
        "\1\113\1\115\3\31\1\uffff\5\31\1\126\2\31\1\uffff\1\31\1\uffff\1"+
        "\132\2\31\1\135\1\136\2\31\1\141\1\uffff\1\31\1\143\1\31\1\uffff"+
        "\2\31\2\uffff\1\147\1\150\1\uffff\1\31\1\uffff\3\31\2\uffff\1\31"+
        "\1\156\3\31\1\uffff\1\31\1\163\1\31\1\165\1\uffff\1\31\1\uffff\4"+
        "\31\1\173\1\uffff";
    static final String DFA17_eofS =
        "\174\uffff";
    static final String DFA17_minS =
        "\1\11\1\155\1\uffff\1\145\1\uffff\1\141\1\150\1\uffff\1\156\1\157"+
        "\1\145\2\uffff\1\154\1\162\2\uffff\1\162\1\uffff\2\75\1\uffff\1"+
        "\151\1\60\1\56\2\uffff\1\52\1\uffff\1\60\1\160\2\154\1\157\1\164"+
        "\1\145\1\60\1\144\1\164\1\154\1\163\1\145\1\60\1\165\4\uffff\1\153"+
        "\5\uffff\1\157\1\145\1\163\1\155\1\150\1\162\1\uffff\2\60\1\154"+
        "\1\157\1\155\1\uffff\2\145\1\162\1\143\1\145\1\60\1\157\1\145\1"+
        "\uffff\1\151\1\uffff\1\60\1\165\1\145\2\60\2\164\1\60\1\uffff\1"+
        "\165\1\60\1\153\1\uffff\1\162\1\156\2\uffff\2\60\1\uffff\1\164\1"+
        "\uffff\1\145\1\143\1\164\2\uffff\1\163\1\60\1\145\1\163\1\165\1"+
        "\uffff\1\163\1\60\1\142\1\60\1\uffff\1\164\1\uffff\1\171\1\160\1"+
        "\145\1\163\1\60\1\uffff";
    static final String DFA17_maxS =
        "\1\175\1\156\1\uffff\1\145\1\uffff\1\162\1\151\1\uffff\1\163\1\165"+
        "\1\145\2\uffff\1\154\1\162\2\uffff\1\162\1\uffff\2\75\1\uffff\1"+
        "\151\2\71\2\uffff\1\57\1\uffff\1\172\1\160\2\154\1\157\1\164\1\145"+
        "\1\172\1\144\1\164\1\154\1\163\1\145\1\172\1\165\4\uffff\1\153\5"+
        "\uffff\1\157\1\145\1\163\1\155\1\150\1\162\1\uffff\2\172\1\154\1"+
        "\157\1\155\1\uffff\2\145\1\162\1\143\1\145\1\172\1\157\1\145\1\uffff"+
        "\1\151\1\uffff\1\172\1\165\1\145\2\172\2\164\1\172\1\uffff\1\165"+
        "\1\172\1\153\1\uffff\1\162\1\156\2\uffff\2\172\1\uffff\1\164\1\uffff"+
        "\1\145\1\143\1\164\2\uffff\1\163\1\172\1\145\1\163\1\165\1\uffff"+
        "\1\163\1\172\1\142\1\172\1\uffff\1\164\1\uffff\1\171\1\160\1\145"+
        "\1\163\1\172\1\uffff";
    static final String DFA17_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\2\uffff\1\7\3\uffff\1\15\1\16\2\uffff\1"+
        "\22\1\23\1\uffff\1\27\2\uffff\1\34\3\uffff\1\41\1\42\1\uffff\1\45"+
        "\17\uffff\1\32\1\30\1\33\1\31\1\uffff\1\37\1\40\1\44\1\43\1\13\6"+
        "\uffff\1\11\5\uffff\1\20\10\uffff\1\21\1\uffff\1\12\10\uffff\1\5"+
        "\3\uffff\1\26\2\uffff\1\24\1\35\2\uffff\1\25\1\uffff\1\6\3\uffff"+
        "\1\1\1\3\5\uffff\1\36\4\uffff\1\17\1\uffff\1\14\5\uffff\1\10";
    static final String DFA17_specialS =
        "\174\uffff}>";
    static final String[] DFA17_transitionS = {
            "\2\34\2\uffff\1\34\22\uffff\1\34\1\25\1\32\4\uffff\1\32\1\17"+
            "\1\20\2\uffff\1\4\1\27\1\7\1\33\12\30\1\2\1\uffff\1\23\1\22"+
            "\1\24\2\uffff\32\31\3\uffff\2\31\1\uffff\1\10\3\31\1\15\1\5"+
            "\2\31\1\1\2\31\1\26\1\31\1\11\1\16\2\31\1\12\1\3\1\21\2\31\1"+
            "\6\3\31\1\13\1\uffff\1\14",
            "\1\36\1\35",
            "",
            "\1\37",
            "",
            "\1\40\20\uffff\1\41",
            "\1\43\1\42",
            "",
            "\1\45\4\uffff\1\44",
            "\1\46\5\uffff\1\47",
            "\1\50",
            "",
            "",
            "\1\51",
            "\1\52",
            "",
            "",
            "\1\53",
            "",
            "\1\54",
            "\1\56",
            "",
            "\1\60",
            "\12\30",
            "\1\62\1\uffff\12\30",
            "",
            "",
            "\1\64\4\uffff\1\63",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\103",
            "",
            "",
            "",
            "",
            "\1\104",
            "",
            "",
            "",
            "",
            "",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\13\31\1\114\16\31",
            "\1\116",
            "\1\117",
            "\1\120",
            "",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\127",
            "\1\130",
            "",
            "\1\131",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\133",
            "\1\134",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\137",
            "\1\140",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "\1\142",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\144",
            "",
            "\1\145",
            "\1\146",
            "",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "\1\151",
            "",
            "\1\152",
            "\1\153",
            "\1\154",
            "",
            "",
            "\1\155",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\157",
            "\1\160",
            "\1\161",
            "",
            "\1\162",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\164",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "\1\166",
            "",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | RULE_SINGED_LONG | RULE_SIGNED_DOUBLE | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS );";
        }
    }
 

}