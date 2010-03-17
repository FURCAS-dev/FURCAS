// $ANTLR 3.1.1 C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g 2010-03-17 11:12:54

package generated;
import com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken;
import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.grammar.impl.PredicateSemantic;
import com.sap.mi.textual.moinlookup.util.RuleNameFinder;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import org.antlr.runtime.Token;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CollectionLevelPermissionParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "FLOAT", "DOUBLE", "LCURL", "COLON", "LPAREN", "RPAREN", "SEMICOLON", "RCURL", "LBRACKET", "RBRACKET", "EQUALS", "COMMENT", "MULTI_LINE_COMMENT", "LANGLE", "RANGLE", "EXCL", "EQUALSEQUALS", "ASSIGN", "DOT", "ARROW", "DCOLON", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "RANGE_OR_INT_OR_FLOAT_OR_DOUBLE", "'EQUALS'", "'GREATER_THAN'", "'LESS_THAN'", "'GREATER_OR_EQUALS'", "'LESS_OR_EQUALS'", "'CONTAINS'", "'collection'", "'permissions'", "'default'", "'create'", "','", "'retrieve'", "'update'", "'delete'", "'data-driven'", "'from'", "'as'", "'where'", "'and'"
    };
    public static final int LANGLE=20;
    public static final int FLOAT=7;
    public static final int EQUALS=17;
    public static final int EXCL=22;
    public static final int RANGE_OR_INT_OR_FLOAT_OR_DOUBLE=33;
    public static final int EOF=-1;
    public static final int LPAREN=11;
    public static final int LBRACKET=15;
    public static final int RPAREN=12;
    public static final int DCOLON=27;
    public static final int NAME=4;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int DOUBLE=8;
    public static final int DIGIT=30;
    public static final int NL=28;
    public static final int RBRACKET=16;
    public static final int RANGLE=21;
    public static final int DOT=25;
    public static final int COMMENT=18;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int EQUALSEQUALS=23;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int INT=6;
    public static final int SEMICOLON=13;
    public static final int MULTI_LINE_COMMENT=19;
    public static final int ALPHA=31;
    public static final int COLON=10;
    public static final int LCURL=9;
    public static final int WS=29;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int SNAME=32;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RCURL=14;
    public static final int ASSIGN=24;
    public static final int ARROW=26;
    public static final int STRING=5;

    // delegates
    // delegators


        public CollectionLevelPermissionParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CollectionLevelPermissionParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return CollectionLevelPermissionParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g"; }


       private static final String syntaxUUID = "E0469530A58AE25131AD11DFB1BCF04A8D150765";
       public String getSyntaxUUID() {
            return syntaxUUID;
       }
       /**
         * Unescape string.
         * 
         * @param s the s
         * @param delimLength the delim length
         * 
         * @return the string
         */
        public String unescapeString(String s) {
            StringBuilder ret = new StringBuilder();
            // get rid of the starting and ending delimiters (e.g., '\'', '"')
           int delimLength = 1; // for delimLength > 0, the following code needs to change
           if (s.charAt(0) == '\'' && s.charAt(s.length()-delimLength) == '\'' || s.charAt(0) == '\"' && s.charAt(s.length()-delimLength) == '\"') {
                    s = s.substring(delimLength, s.length()-(delimLength * 2 - 1));
            }
            
            CharacterIterator ci = new StringCharacterIterator(s);
            char c = ci.first();
            while(c != CharacterIterator.DONE) {
                char tc = 0;
                switch(c) {
                case '\\':
                    c = ci.next();
                    switch(c) {
                    case 'n':
                        tc = '\n';
                        break;
                    case 'r':
                        tc = '\r';
                        break;
                    case 't':
                        tc = '\t';
                        break;
                    case 'b':
                        tc = '\b';
                        break;
                    case 'f':
                        tc = '\f';
                        break;
                    case '"':
                        tc = '"';
                        break;
                    case '\'':
                        tc = '\'';
                        break;
                    case '\\':
                        tc = '\\';
                        break;
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                        throw new RuntimeException("octal escape sequences not supported yet");
                    default:
                        throw new RuntimeException("unknown escape sequence: '\\" + c + "'");
                    }
                    break;
                default:
                    tc = c;
                    break;
                }
                ret.append(tc);
                c = ci.next();
            }
            return ret.toString();
        }




    // $ANTLR start "identifier"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:208:3: ( (ast= NAME ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:209:3: (ast= NAME )
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:209:3: (ast= NAME )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:209:4: ast= NAME
            {
            ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifier63); 
            ret = unescapeString( ast.getText());


            }


            ret2=ret;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "identifier"


    // $ANTLR start "stringSymbol"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:217:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:218:3: ( (ast= STRING ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:219:3: (ast= STRING )
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:219:3: (ast= STRING )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:219:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_stringSymbol94); 
            ret = unescapeString( ast.getText());


            }


            ret2=ret;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "stringSymbol"


    // $ANTLR start "integerSymbol"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:227:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:228:3: ( (ast= INT ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:229:3: (ast= INT )
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:229:3: (ast= INT )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:229:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol125); 
            ret = Integer.valueOf( ast.getText());


            }


            ret2=ret;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "integerSymbol"


    // $ANTLR start "longSymbol"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:237:1: longSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object longSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:238:3: ( (ast= INT ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:239:3: (ast= INT )
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:239:3: (ast= INT )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:239:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_longSymbol156); 
            ret = Long.valueOf( ast.getText());


            }


            ret2=ret;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "longSymbol"


    // $ANTLR start "integerAsStringSymbol"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:247:1: integerAsStringSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerAsStringSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:248:3: ( (ast= INT ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:249:3: (ast= INT )
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:249:3: (ast= INT )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:249:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerAsStringSymbol187); 
            ret =  ast.getText();


            }


            ret2=ret;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "integerAsStringSymbol"


    // $ANTLR start "floatAsStringSymbol"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:257:1: floatAsStringSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatAsStringSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:258:3: ( (ast= FLOAT ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:259:3: (ast= FLOAT )
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:259:3: (ast= FLOAT )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:259:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatAsStringSymbol218); 
            ret =  ast.getText();


            }


            ret2=ret;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "floatAsStringSymbol"


    // $ANTLR start "doubleAsStringSymbol"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:267:1: doubleAsStringSymbol returns [Object ret2] : (ast= DOUBLE ) ;
    public final Object doubleAsStringSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:268:3: ( (ast= DOUBLE ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:269:3: (ast= DOUBLE )
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:269:3: (ast= DOUBLE )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:269:4: ast= DOUBLE
            {
            ast=(Token)match(input,DOUBLE,FOLLOW_DOUBLE_in_doubleAsStringSymbol249); 
            ret =  ast.getText();


            }


            ret2=ret;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "doubleAsStringSymbol"


    // $ANTLR start "coghead_operatorenum"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:277:1: coghead_operatorenum returns [Object ret2] : ( ( 'EQUALS' ) | ( 'GREATER_THAN' ) | ( 'LESS_THAN' ) | ( 'GREATER_OR_EQUALS' ) | ( 'LESS_OR_EQUALS' ) | ( 'CONTAINS' ) ) ;
    public final Object coghead_operatorenum() throws RecognitionException {

        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:278:3: ( ( ( 'EQUALS' ) | ( 'GREATER_THAN' ) | ( 'LESS_THAN' ) | ( 'GREATER_OR_EQUALS' ) | ( 'LESS_OR_EQUALS' ) | ( 'CONTAINS' ) ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:279:3: ( ( 'EQUALS' ) | ( 'GREATER_THAN' ) | ( 'LESS_THAN' ) | ( 'GREATER_OR_EQUALS' ) | ( 'LESS_OR_EQUALS' ) | ( 'CONTAINS' ) )
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:279:3: ( ( 'EQUALS' ) | ( 'GREATER_THAN' ) | ( 'LESS_THAN' ) | ( 'GREATER_OR_EQUALS' ) | ( 'LESS_OR_EQUALS' ) | ( 'CONTAINS' ) )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt1=1;
                }
                break;
            case 35:
                {
                alt1=2;
                }
                break;
            case 36:
                {
                alt1=3;
                }
                break;
            case 37:
                {
                alt1=4;
                }
                break;
            case 38:
                {
                alt1=5;
                }
                break;
            case 39:
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:279:4: ( 'EQUALS' )
                    {
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:279:4: ( 'EQUALS' )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:279:5: 'EQUALS'
                    {
                    match(input,34,FOLLOW_34_in_coghead_operatorenum279); 

                    }

                    ret = createEnumLiteral(list("coghead","OperatorEnum"), "EQUALS");

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:280:4: ( 'GREATER_THAN' )
                    {
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:280:4: ( 'GREATER_THAN' )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:280:5: 'GREATER_THAN'
                    {
                    match(input,35,FOLLOW_35_in_coghead_operatorenum287); 

                    }

                    ret = createEnumLiteral(list("coghead","OperatorEnum"), "GREATER_THAN");

                    }
                    break;
                case 3 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:281:4: ( 'LESS_THAN' )
                    {
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:281:4: ( 'LESS_THAN' )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:281:5: 'LESS_THAN'
                    {
                    match(input,36,FOLLOW_36_in_coghead_operatorenum295); 

                    }

                    ret = createEnumLiteral(list("coghead","OperatorEnum"), "LESS_THAN");

                    }
                    break;
                case 4 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:282:4: ( 'GREATER_OR_EQUALS' )
                    {
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:282:4: ( 'GREATER_OR_EQUALS' )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:282:5: 'GREATER_OR_EQUALS'
                    {
                    match(input,37,FOLLOW_37_in_coghead_operatorenum303); 

                    }

                    ret = createEnumLiteral(list("coghead","OperatorEnum"), "GREATER_OR_EQUALS");

                    }
                    break;
                case 5 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:283:4: ( 'LESS_OR_EQUALS' )
                    {
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:283:4: ( 'LESS_OR_EQUALS' )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:283:5: 'LESS_OR_EQUALS'
                    {
                    match(input,38,FOLLOW_38_in_coghead_operatorenum311); 

                    }

                    ret = createEnumLiteral(list("coghead","OperatorEnum"), "LESS_OR_EQUALS");

                    }
                    break;
                case 6 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:284:4: ( 'CONTAINS' )
                    {
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:284:4: ( 'CONTAINS' )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:284:5: 'CONTAINS'
                    {
                    match(input,39,FOLLOW_39_in_coghead_operatorenum319); 

                    }

                    ret = createEnumLiteral(list("coghead","OperatorEnum"), "CONTAINS");

                    }
                    break;

            }


              ret2=ret;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "coghead_operatorenum"


    // $ANTLR start "main"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:291:1: main returns [Object ret2] : ( (ret= coghead_collectionlevelpermission ) EOF ) ;
    public final Object main() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:292:3: ( ( (ret= coghead_collectionlevelpermission ) EOF ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:293:3: ( (ret= coghead_collectionlevelpermission ) EOF )
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:293:3: ( (ret= coghead_collectionlevelpermission ) EOF )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:293:4: (ret= coghead_collectionlevelpermission ) EOF
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:293:4: (ret= coghead_collectionlevelpermission )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:293:5: ret= coghead_collectionlevelpermission
            {
            pushFollow(FOLLOW_coghead_collectionlevelpermission_in_main347);
            ret=coghead_collectionlevelpermission();

            checkFollows();
            state._fsp--;


            }

            match(input,EOF,FOLLOW_EOF_in_main350); 

            }


            ret2=ret;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "main"


    // $ANTLR start "coghead_collectionlevelpermission"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:300:1: coghead_collectionlevelpermission returns [Object ret2] : ( 'collection' 'permissions' LCURL 'default' LCURL ( ( 'create' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | ) ( ( 'retrieve' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | ) ( ( 'update' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | ) ( ( 'delete' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | ) RCURL ( ( 'data-driven' LCURL (temp= coghead_templatedpermission ( ( SEMICOLON ) temp= coghead_templatedpermission )* )? RCURL ) | ) RCURL ) ;
    public final Object coghead_collectionlevelpermission() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","CollectionLevelPermission");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"Permission"}) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:305:3: ( ( 'collection' 'permissions' LCURL 'default' LCURL ( ( 'create' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | ) ( ( 'retrieve' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | ) ( ( 'update' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | ) ( ( 'delete' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | ) RCURL ( ( 'data-driven' LCURL (temp= coghead_templatedpermission ( ( SEMICOLON ) temp= coghead_templatedpermission )* )? RCURL ) | ) RCURL ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:306:3: ( 'collection' 'permissions' LCURL 'default' LCURL ( ( 'create' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | ) ( ( 'retrieve' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | ) ( ( 'update' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | ) ( ( 'delete' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | ) RCURL ( ( 'data-driven' LCURL (temp= coghead_templatedpermission ( ( SEMICOLON ) temp= coghead_templatedpermission )* )? RCURL ) | ) RCURL )
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:306:3: ( 'collection' 'permissions' LCURL 'default' LCURL ( ( 'create' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | ) ( ( 'retrieve' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | ) ( ( 'update' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | ) ( ( 'delete' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | ) RCURL ( ( 'data-driven' LCURL (temp= coghead_templatedpermission ( ( SEMICOLON ) temp= coghead_templatedpermission )* )? RCURL ) | ) RCURL )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:306:4: 'collection' 'permissions' LCURL 'default' LCURL ( ( 'create' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | ) ( ( 'retrieve' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | ) ( ( 'update' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | ) ( ( 'delete' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | ) RCURL ( ( 'data-driven' LCURL (temp= coghead_templatedpermission ( ( SEMICOLON ) temp= coghead_templatedpermission )* )? RCURL ) | ) RCURL
            {
            _beforeSeqEl("E0469530A5521F1031AD11DF8F1BF04A8D150765");
            match(input,40,FOLLOW_40_in_coghead_collectionlevelpermission381); 
            _afterSeqEl();
            _beforeSeqEl("E0469530A552944031AD11DFBAC2F04A8D150765");
            match(input,41,FOLLOW_41_in_coghead_collectionlevelpermission384); 
            _afterSeqEl();
            _beforeSeqEl("E0469530A552944131AD11DFA750F04A8D150765");
            match(input,LCURL,FOLLOW_LCURL_in_coghead_collectionlevelpermission388); 
            _afterSeqEl();
            _beforeSeqEl("E0469530A552944231AD11DFC01EF04A8D150765");
            match(input,42,FOLLOW_42_in_coghead_collectionlevelpermission392); 
            _afterSeqEl();
            _beforeSeqEl("E0469530A552944331AD11DF9C39F04A8D150765");
            match(input,LCURL,FOLLOW_LCURL_in_coghead_collectionlevelpermission396); 
            _afterSeqEl();
            _beforeSeqEl("E0469530A55A5C7031AD11DF95E5F04A8D150765");
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:306:487: ( ( 'create' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==43) ) {
                alt4=1;
            }
            else if ( (LA4_0==RCURL||(LA4_0>=45 && LA4_0<=47)) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:306:488: ( 'create' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON )
                    {
                    _enterAlt(0);
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:306:504: ( 'create' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:306:505: 'create' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON
                    {
                    _beforeSeqEl("E0469530A554901031AD11DFB6A4F04A8D150765");
                    match(input,43,FOLLOW_43_in_coghead_collectionlevelpermission406); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A554B72031AD11DFACD6F04A8D150765");
                    match(input,COLON,FOLLOW_COLON_in_coghead_collectionlevelpermission410); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A554B72131AD11DFCD1DF04A8D150765");
                    match(input,LPAREN,FOLLOW_LPAREN_in_coghead_collectionlevelpermission415); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A558D5D031AD11DFA717F04A8D150765");
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:306:812: (temp= identifier ( ( ',' ) temp= identifier )* )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==NAME) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:306:814: temp= identifier ( ( ',' ) temp= identifier )*
                            {
                            pushFollow(FOLLOW_identifier_in_coghead_collectionlevelpermission423);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;

                            setOclRef(ret, "createRecord", "name", temp, "OCL:#context(Permission).oclAsType(CollectionLevelPermission).theCollection.getApplication().myAccount.roles->select(r | r.name= ?)");
                            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:306:1013: ( ( ',' ) temp= identifier )*
                            loop2:
                            do {
                                int alt2=2;
                                int LA2_0 = input.LA(1);

                                if ( (LA2_0==44) ) {
                                    alt2=1;
                                }


                                switch (alt2) {
                            	case 1 :
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:306:1014: ( ',' ) temp= identifier
                            	    {
                            	    _enterSepSeq();
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:306:1031: ( ',' )
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:306:1032: ','
                            	    {
                            	    _beforeSeqEl("E0469530A5552C5031AD11DFA88FF04A8D150765");
                            	    match(input,44,FOLLOW_44_in_coghead_collectionlevelpermission431); 
                            	    _afterSeqEl();

                            	    }

                            	    _exitSepSeq();
                            	    pushFollow(FOLLOW_identifier_in_coghead_collectionlevelpermission438);
                            	    temp=identifier();

                            	    checkFollows();
                            	    state._fsp--;

                            	    setOclRef(ret, "createRecord", "name", temp, "OCL:#context(Permission).oclAsType(CollectionLevelPermission).theCollection.getApplication().myAccount.roles->select(r | r.name= ?)");

                            	    }
                            	    break;

                            	default :
                            	    break loop2;
                                }
                            } while (true);


                            }
                            break;

                    }

                    _afterSeqEl();
                    _beforeSeqEl("E0469530A559E74031AD11DFB79DF04A8D150765");
                    match(input,RPAREN,FOLLOW_RPAREN_in_coghead_collectionlevelpermission450); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A55A0E5031AD11DFAF77F04A8D150765");
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_coghead_collectionlevelpermission455); 
                    _afterSeqEl();

                    }

                    _exitAlt();

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:306:1535: 
                    {
                    _enterAlt(1);
                    _exitAlt();

                    }
                    break;

            }

            _afterSeqEl();
            _beforeSeqEl("E0469530A55D69B031AD11DFCDF4F04A8D150765");
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:307:77: ( ( 'retrieve' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==45) ) {
                alt7=1;
            }
            else if ( (LA7_0==RCURL||(LA7_0>=46 && LA7_0<=47)) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:307:78: ( 'retrieve' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON )
                    {
                    _enterAlt(0);
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:307:94: ( 'retrieve' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:307:95: 'retrieve' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON
                    {
                    _beforeSeqEl("E0469530A55C584031AD11DF8A5EF04A8D150765");
                    match(input,45,FOLLOW_45_in_coghead_collectionlevelpermission478); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A55C584131AD11DFA979F04A8D150765");
                    match(input,COLON,FOLLOW_COLON_in_coghead_collectionlevelpermission482); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A55C584231AD11DFA8C7F04A8D150765");
                    match(input,LPAREN,FOLLOW_LPAREN_in_coghead_collectionlevelpermission487); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A55CCD7131AD11DFB2DBF04A8D150765");
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:307:404: (temp= identifier ( ( ',' ) temp= identifier )* )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==NAME) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:307:406: temp= identifier ( ( ',' ) temp= identifier )*
                            {
                            pushFollow(FOLLOW_identifier_in_coghead_collectionlevelpermission495);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;

                            setOclRef(ret, "retrieveAllRecords", "name", temp, "OCL:#context(Permission).oclAsType(CollectionLevelPermission).theCollection.getApplication().myAccount.roles->select(r | r.name= ?)");
                            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:307:611: ( ( ',' ) temp= identifier )*
                            loop5:
                            do {
                                int alt5=2;
                                int LA5_0 = input.LA(1);

                                if ( (LA5_0==44) ) {
                                    alt5=1;
                                }


                                switch (alt5) {
                            	case 1 :
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:307:612: ( ',' ) temp= identifier
                            	    {
                            	    _enterSepSeq();
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:307:629: ( ',' )
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:307:630: ','
                            	    {
                            	    _beforeSeqEl("E0469530A55C7F5131AD11DFA7F9F04A8D150765");
                            	    match(input,44,FOLLOW_44_in_coghead_collectionlevelpermission503); 
                            	    _afterSeqEl();

                            	    }

                            	    _exitSepSeq();
                            	    pushFollow(FOLLOW_identifier_in_coghead_collectionlevelpermission510);
                            	    temp=identifier();

                            	    checkFollows();
                            	    state._fsp--;

                            	    setOclRef(ret, "retrieveAllRecords", "name", temp, "OCL:#context(Permission).oclAsType(CollectionLevelPermission).theCollection.getApplication().myAccount.roles->select(r | r.name= ?)");

                            	    }
                            	    break;

                            	default :
                            	    break loop5;
                                }
                            } while (true);


                            }
                            break;

                    }

                    _afterSeqEl();
                    _beforeSeqEl("E0469530A55D1B9031AD11DF9F27F04A8D150765");
                    match(input,RPAREN,FOLLOW_RPAREN_in_coghead_collectionlevelpermission522); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A55D1B9131AD11DFBBA1F04A8D150765");
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_coghead_collectionlevelpermission527); 
                    _afterSeqEl();

                    }

                    _exitAlt();

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:307:1139: 
                    {
                    _enterAlt(1);
                    _exitAlt();

                    }
                    break;

            }

            _afterSeqEl();
            _beforeSeqEl("E0469530A55EC94031AD11DF9836F04A8D150765");
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:308:77: ( ( 'update' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==46) ) {
                alt10=1;
            }
            else if ( (LA10_0==RCURL||LA10_0==47) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:308:78: ( 'update' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON )
                    {
                    _enterAlt(0);
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:308:94: ( 'update' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:308:95: 'update' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON
                    {
                    _beforeSeqEl("E0469530A55DB7D131AD11DF90BEF04A8D150765");
                    match(input,46,FOLLOW_46_in_coghead_collectionlevelpermission550); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A55DB7D231AD11DF8606F04A8D150765");
                    match(input,COLON,FOLLOW_COLON_in_coghead_collectionlevelpermission554); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A55DB7D331AD11DF9D70F04A8D150765");
                    match(input,LPAREN,FOLLOW_LPAREN_in_coghead_collectionlevelpermission559); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A55E2D0131AD11DFB764F04A8D150765");
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:308:402: (temp= identifier ( ( ',' ) temp= identifier )* )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==NAME) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:308:404: temp= identifier ( ( ',' ) temp= identifier )*
                            {
                            pushFollow(FOLLOW_identifier_in_coghead_collectionlevelpermission567);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;

                            setOclRef(ret, "updateAllRecords", "name", temp, "OCL:#context(Permission).oclAsType(CollectionLevelPermission).theCollection.getApplication().myAccount.roles->select(r | r.name= ?)");
                            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:308:607: ( ( ',' ) temp= identifier )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( (LA8_0==44) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:308:608: ( ',' ) temp= identifier
                            	    {
                            	    _enterSepSeq();
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:308:625: ( ',' )
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:308:626: ','
                            	    {
                            	    _beforeSeqEl("E0469530A55DDEE231AD11DFBEFCF04A8D150765");
                            	    match(input,44,FOLLOW_44_in_coghead_collectionlevelpermission575); 
                            	    _afterSeqEl();

                            	    }

                            	    _exitSepSeq();
                            	    pushFollow(FOLLOW_identifier_in_coghead_collectionlevelpermission582);
                            	    temp=identifier();

                            	    checkFollows();
                            	    state._fsp--;

                            	    setOclRef(ret, "updateAllRecords", "name", temp, "OCL:#context(Permission).oclAsType(CollectionLevelPermission).theCollection.getApplication().myAccount.roles->select(r | r.name= ?)");

                            	    }
                            	    break;

                            	default :
                            	    break loop8;
                                }
                            } while (true);


                            }
                            break;

                    }

                    _afterSeqEl();
                    _beforeSeqEl("E0469530A55E541031AD11DFCC2CF04A8D150765");
                    match(input,RPAREN,FOLLOW_RPAREN_in_coghead_collectionlevelpermission594); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A55E7B2031AD11DFA5E6F04A8D150765");
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_coghead_collectionlevelpermission599); 
                    _afterSeqEl();

                    }

                    _exitAlt();

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:308:1133: 
                    {
                    _enterAlt(1);
                    _exitAlt();

                    }
                    break;

            }

            _afterSeqEl();
            _beforeSeqEl("E0469530A56001C031AD11DFB6BFF04A8D150765");
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:309:77: ( ( 'delete' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON ) | )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==47) ) {
                alt13=1;
            }
            else if ( (LA13_0==RCURL) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:309:78: ( 'delete' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON )
                    {
                    _enterAlt(0);
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:309:94: ( 'delete' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:309:95: 'delete' COLON LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN SEMICOLON
                    {
                    _beforeSeqEl("E0469530A55F176031AD11DFCBCFF04A8D150765");
                    match(input,47,FOLLOW_47_in_coghead_collectionlevelpermission622); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A55F176131AD11DF905DF04A8D150765");
                    match(input,COLON,FOLLOW_COLON_in_coghead_collectionlevelpermission626); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A55F176231AD11DFA022F04A8D150765");
                    match(input,LPAREN,FOLLOW_LPAREN_in_coghead_collectionlevelpermission631); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A55F658231AD11DFCA5CF04A8D150765");
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:309:402: (temp= identifier ( ( ',' ) temp= identifier )* )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==NAME) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:309:404: temp= identifier ( ( ',' ) temp= identifier )*
                            {
                            pushFollow(FOLLOW_identifier_in_coghead_collectionlevelpermission639);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;

                            setOclRef(ret, "deleteAllRecords", "name", temp, "OCL:#context(Permission).oclAsType(CollectionLevelPermission).theCollection.getApplication().myAccount.roles->select(r | r.name= ?)");
                            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:309:607: ( ( ',' ) temp= identifier )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==44) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:309:608: ( ',' ) temp= identifier
                            	    {
                            	    _enterSepSeq();
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:309:625: ( ',' )
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:309:626: ','
                            	    {
                            	    _beforeSeqEl("E0469530A55F176531AD11DF8548F04A8D150765");
                            	    match(input,44,FOLLOW_44_in_coghead_collectionlevelpermission647); 
                            	    _afterSeqEl();

                            	    }

                            	    _exitSepSeq();
                            	    pushFollow(FOLLOW_identifier_in_coghead_collectionlevelpermission654);
                            	    temp=identifier();

                            	    checkFollows();
                            	    state._fsp--;

                            	    setOclRef(ret, "deleteAllRecords", "name", temp, "OCL:#context(Permission).oclAsType(CollectionLevelPermission).theCollection.getApplication().myAccount.roles->select(r | r.name= ?)");

                            	    }
                            	    break;

                            	default :
                            	    break loop11;
                                }
                            } while (true);


                            }
                            break;

                    }

                    _afterSeqEl();
                    _beforeSeqEl("E0469530A55FB3A031AD11DF90EAF04A8D150765");
                    match(input,RPAREN,FOLLOW_RPAREN_in_coghead_collectionlevelpermission666); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A55FB3A131AD11DF8C23F04A8D150765");
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_coghead_collectionlevelpermission671); 
                    _afterSeqEl();

                    }

                    _exitAlt();

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:309:1133: 
                    {
                    _enterAlt(1);
                    _exitAlt();

                    }
                    break;

            }

            _afterSeqEl();
            _beforeSeqEl("E0469530A56001C131AD11DF9426F04A8D150765");
            match(input,RCURL,FOLLOW_RCURL_in_coghead_collectionlevelpermission689); 
            _afterSeqEl();
            _beforeSeqEl("E0469530A560C51031AD11DFABB9F04A8D150765");
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:310:159: ( ( 'data-driven' LCURL (temp= coghead_templatedpermission ( ( SEMICOLON ) temp= coghead_templatedpermission )* )? RCURL ) | )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==48) ) {
                alt16=1;
            }
            else if ( (LA16_0==RCURL) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:310:160: ( 'data-driven' LCURL (temp= coghead_templatedpermission ( ( SEMICOLON ) temp= coghead_templatedpermission )* )? RCURL )
                    {
                    _enterAlt(0);
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:310:176: ( 'data-driven' LCURL (temp= coghead_templatedpermission ( ( SEMICOLON ) temp= coghead_templatedpermission )* )? RCURL )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:310:177: 'data-driven' LCURL (temp= coghead_templatedpermission ( ( SEMICOLON ) temp= coghead_templatedpermission )* )? RCURL
                    {
                    _beforeSeqEl("E0469530A5604FE031AD11DF9C94F04A8D150765");
                    match(input,48,FOLLOW_48_in_coghead_collectionlevelpermission699); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A5604FE131AD11DF9899F04A8D150765");
                    match(input,LCURL,FOLLOW_LCURL_in_coghead_collectionlevelpermission703); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A56076F131AD11DFCD10F04A8D150765");
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:310:406: (temp= coghead_templatedpermission ( ( SEMICOLON ) temp= coghead_templatedpermission )* )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==LBRACKET) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:310:408: temp= coghead_templatedpermission ( ( SEMICOLON ) temp= coghead_templatedpermission )*
                            {
                            pushFollow(FOLLOW_coghead_templatedpermission_in_coghead_collectionlevelpermission711);
                            temp=coghead_templatedpermission();

                            checkFollows();
                            state._fsp--;

                            setProperty(ret, "templatedPermissions", temp);
                            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:310:491: ( ( SEMICOLON ) temp= coghead_templatedpermission )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( (LA14_0==SEMICOLON) ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:310:492: ( SEMICOLON ) temp= coghead_templatedpermission
                            	    {
                            	    _enterSepSeq();
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:310:509: ( SEMICOLON )
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:310:510: SEMICOLON
                            	    {
                            	    _beforeSeqEl("E0469530A5604FE331AD11DFBED6F04A8D150765");
                            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_coghead_collectionlevelpermission720); 
                            	    _afterSeqEl();

                            	    }

                            	    _exitSepSeq();
                            	    pushFollow(FOLLOW_coghead_templatedpermission_in_coghead_collectionlevelpermission728);
                            	    temp=coghead_templatedpermission();

                            	    checkFollows();
                            	    state._fsp--;

                            	    setProperty(ret, "templatedPermissions", temp);

                            	    }
                            	    break;

                            	default :
                            	    break loop14;
                                }
                            } while (true);


                            }
                            break;

                    }

                    _afterSeqEl();
                    _beforeSeqEl("E0469530A5609E0031AD11DFCD16F04A8D150765");
                    match(input,RCURL,FOLLOW_RCURL_in_coghead_collectionlevelpermission740); 
                    _afterSeqEl();

                    }

                    _exitAlt();

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:310:818: 
                    {
                    _enterAlt(1);
                    _exitAlt();

                    }
                    break;

            }

            _afterSeqEl();
            _beforeSeqEl("E0469530A560EC2031AD11DF95F5F04A8D150765");
            match(input,RCURL,FOLLOW_RCURL_in_coghead_collectionlevelpermission758); 
            _afterSeqEl();

            }


            ret2 = commitCreation(ret, firstToken, true);

             

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "coghead_collectionlevelpermission"


    // $ANTLR start "coghead_templatedpermission"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:319:1: coghead_templatedpermission returns [Object ret2] : ( LBRACKET (temp= coghead_query ) RBRACKET ( ( 'retrieve' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN ) | ) ( ( 'update' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN ) | ) ( ( 'delete' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN ) | ) ) ;
    public final Object coghead_templatedpermission() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","TemplatedPermission");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:324:3: ( ( LBRACKET (temp= coghead_query ) RBRACKET ( ( 'retrieve' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN ) | ) ( ( 'update' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN ) | ) ( ( 'delete' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN ) | ) ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:325:3: ( LBRACKET (temp= coghead_query ) RBRACKET ( ( 'retrieve' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN ) | ) ( ( 'update' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN ) | ) ( ( 'delete' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN ) | ) )
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:325:3: ( LBRACKET (temp= coghead_query ) RBRACKET ( ( 'retrieve' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN ) | ) ( ( 'update' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN ) | ) ( ( 'delete' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN ) | ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:325:4: LBRACKET (temp= coghead_query ) RBRACKET ( ( 'retrieve' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN ) | ) ( ( 'update' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN ) | ) ( ( 'delete' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN ) | )
            {
            _beforeSeqEl("E0469530A56558F031AD11DF9240F04A8D150765");
            match(input,LBRACKET,FOLLOW_LBRACKET_in_coghead_templatedpermission800); 
            _afterSeqEl();
            _beforeSeqEl("E0469530A565800031AD11DFAB17F04A8D150765");
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:325:148: (temp= coghead_query )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:325:150: temp= coghead_query
            {
            pushFollow(FOLLOW_coghead_query_in_coghead_templatedpermission808);
            temp=coghead_query();

            checkFollows();
            state._fsp--;

            setProperty(ret, "query", temp);

            }

            _afterSeqEl();
            _beforeSeqEl("E0469530A565800131AD11DF8619F04A8D150765");
            match(input,RBRACKET,FOLLOW_RBRACKET_in_coghead_templatedpermission815); 
            _afterSeqEl();
            _beforeSeqEl("E0469530A566917031AD11DFCEDFF04A8D150765");
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:325:365: ( ( 'retrieve' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN ) | )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==45) ) {
                alt19=1;
            }
            else if ( ((LA19_0>=SEMICOLON && LA19_0<=RCURL)||(LA19_0>=46 && LA19_0<=47)) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:325:366: ( 'retrieve' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN )
                    {
                    _enterAlt(0);
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:325:382: ( 'retrieve' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:325:383: 'retrieve' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN
                    {
                    _beforeSeqEl("E0469530A565CE2031AD11DFC5AEF04A8D150765");
                    match(input,45,FOLLOW_45_in_coghead_templatedpermission825); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A565CE2131AD11DF9F1AF04A8D150765");
                    match(input,LPAREN,FOLLOW_LPAREN_in_coghead_templatedpermission829); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A566435031AD11DFBCFCF04A8D150765");
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:325:610: (temp= identifier ( ( ',' ) temp= identifier )* )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==NAME) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:325:612: temp= identifier ( ( ',' ) temp= identifier )*
                            {
                            pushFollow(FOLLOW_identifier_in_coghead_templatedpermission837);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;

                            setOclRef(ret, "retrieve", "name", temp, "OCL:#context(Permission).oclAsType(CollectionLevelPermission).theCollection.getApplication().myAccount.roles->select(r | r.name= ?)");
                            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:325:807: ( ( ',' ) temp= identifier )*
                            loop17:
                            do {
                                int alt17=2;
                                int LA17_0 = input.LA(1);

                                if ( (LA17_0==44) ) {
                                    alt17=1;
                                }


                                switch (alt17) {
                            	case 1 :
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:325:808: ( ',' ) temp= identifier
                            	    {
                            	    _enterSepSeq();
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:325:825: ( ',' )
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:325:826: ','
                            	    {
                            	    _beforeSeqEl("E0469530A565F53031AD11DF8FA0F04A8D150765");
                            	    match(input,44,FOLLOW_44_in_coghead_templatedpermission845); 
                            	    _afterSeqEl();

                            	    }

                            	    _exitSepSeq();
                            	    pushFollow(FOLLOW_identifier_in_coghead_templatedpermission852);
                            	    temp=identifier();

                            	    checkFollows();
                            	    state._fsp--;

                            	    setOclRef(ret, "retrieve", "name", temp, "OCL:#context(Permission).oclAsType(CollectionLevelPermission).theCollection.getApplication().myAccount.roles->select(r | r.name= ?)");

                            	    }
                            	    break;

                            	default :
                            	    break loop17;
                                }
                            } while (true);


                            }
                            break;

                    }

                    _afterSeqEl();
                    _beforeSeqEl("E0469530A5666A6031AD11DF9986F04A8D150765");
                    match(input,RPAREN,FOLLOW_RPAREN_in_coghead_templatedpermission864); 
                    _afterSeqEl();

                    }

                    _exitAlt();

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:325:1239: 
                    {
                    _enterAlt(1);
                    _exitAlt();

                    }
                    break;

            }

            _afterSeqEl();
            _beforeSeqEl("E0469530A567A2E031AD11DFCFF3F04A8D150765");
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:326:77: ( ( 'update' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN ) | )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==46) ) {
                alt22=1;
            }
            else if ( ((LA22_0>=SEMICOLON && LA22_0<=RCURL)||LA22_0==47) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:326:78: ( 'update' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN )
                    {
                    _enterAlt(0);
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:326:94: ( 'update' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:326:95: 'update' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN
                    {
                    _beforeSeqEl("E0469530A566DF9131AD11DFC45EF04A8D150765");
                    match(input,46,FOLLOW_46_in_coghead_templatedpermission887); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A566DF9231AD11DFCE8FF04A8D150765");
                    match(input,LPAREN,FOLLOW_LPAREN_in_coghead_templatedpermission891); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A5672DB231AD11DF877FF04A8D150765");
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:326:320: (temp= identifier ( ( ',' ) temp= identifier )* )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==NAME) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:326:322: temp= identifier ( ( ',' ) temp= identifier )*
                            {
                            pushFollow(FOLLOW_identifier_in_coghead_templatedpermission899);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;

                            setOclRef(ret, "update", "name", temp, "OCL:#context(Permission).oclAsType(CollectionLevelPermission).theCollection.getApplication().myAccount.roles->select(r | r.name= ?)");
                            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:326:515: ( ( ',' ) temp= identifier )*
                            loop20:
                            do {
                                int alt20=2;
                                int LA20_0 = input.LA(1);

                                if ( (LA20_0==44) ) {
                                    alt20=1;
                                }


                                switch (alt20) {
                            	case 1 :
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:326:516: ( ',' ) temp= identifier
                            	    {
                            	    _enterSepSeq();
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:326:533: ( ',' )
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:326:534: ','
                            	    {
                            	    _beforeSeqEl("E0469530A56706A031AD11DF857DF04A8D150765");
                            	    match(input,44,FOLLOW_44_in_coghead_templatedpermission907); 
                            	    _afterSeqEl();

                            	    }

                            	    _exitSepSeq();
                            	    pushFollow(FOLLOW_identifier_in_coghead_templatedpermission914);
                            	    temp=identifier();

                            	    checkFollows();
                            	    state._fsp--;

                            	    setOclRef(ret, "update", "name", temp, "OCL:#context(Permission).oclAsType(CollectionLevelPermission).theCollection.getApplication().myAccount.roles->select(r | r.name= ?)");

                            	    }
                            	    break;

                            	default :
                            	    break loop20;
                                }
                            } while (true);


                            }
                            break;

                    }

                    _afterSeqEl();
                    _beforeSeqEl("E0469530A5677BD031AD11DF8F53F04A8D150765");
                    match(input,RPAREN,FOLLOW_RPAREN_in_coghead_templatedpermission926); 
                    _afterSeqEl();

                    }

                    _exitAlt();

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:326:945: 
                    {
                    _enterAlt(1);
                    _exitAlt();

                    }
                    break;

            }

            _afterSeqEl();
            _beforeSeqEl("E0469530A568B45031AD11DF8075F04A8D150765");
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:327:77: ( ( 'delete' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN ) | )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==47) ) {
                alt25=1;
            }
            else if ( ((LA25_0>=SEMICOLON && LA25_0<=RCURL)) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:327:78: ( 'delete' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN )
                    {
                    _enterAlt(0);
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:327:94: ( 'delete' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:327:95: 'delete' LPAREN (temp= identifier ( ( ',' ) temp= identifier )* )? RPAREN
                    {
                    _beforeSeqEl("E0469530A567F10031AD11DFB635F04A8D150765");
                    match(input,47,FOLLOW_47_in_coghead_templatedpermission949); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A567F10131AD11DFA388F04A8D150765");
                    match(input,LPAREN,FOLLOW_LPAREN_in_coghead_templatedpermission953); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A568663031AD11DFA4A6F04A8D150765");
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:327:320: (temp= identifier ( ( ',' ) temp= identifier )* )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==NAME) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:327:322: temp= identifier ( ( ',' ) temp= identifier )*
                            {
                            pushFollow(FOLLOW_identifier_in_coghead_templatedpermission961);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;

                            setOclRef(ret, "delete", "name", temp, "OCL:#context(Permission).oclAsType(CollectionLevelPermission).theCollection.getApplication().myAccount.roles->select(r | r.name= ?)");
                            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:327:515: ( ( ',' ) temp= identifier )*
                            loop23:
                            do {
                                int alt23=2;
                                int LA23_0 = input.LA(1);

                                if ( (LA23_0==44) ) {
                                    alt23=1;
                                }


                                switch (alt23) {
                            	case 1 :
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:327:516: ( ',' ) temp= identifier
                            	    {
                            	    _enterSepSeq();
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:327:533: ( ',' )
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:327:534: ','
                            	    {
                            	    _beforeSeqEl("E0469530A568181031AD11DFC63DF04A8D150765");
                            	    match(input,44,FOLLOW_44_in_coghead_templatedpermission969); 
                            	    _afterSeqEl();

                            	    }

                            	    _exitSepSeq();
                            	    pushFollow(FOLLOW_identifier_in_coghead_templatedpermission976);
                            	    temp=identifier();

                            	    checkFollows();
                            	    state._fsp--;

                            	    setOclRef(ret, "delete", "name", temp, "OCL:#context(Permission).oclAsType(CollectionLevelPermission).theCollection.getApplication().myAccount.roles->select(r | r.name= ?)");

                            	    }
                            	    break;

                            	default :
                            	    break loop23;
                                }
                            } while (true);


                            }
                            break;

                    }

                    _afterSeqEl();
                    _beforeSeqEl("E0469530A5688D4031AD11DFA4A1F04A8D150765");
                    match(input,RPAREN,FOLLOW_RPAREN_in_coghead_templatedpermission988); 
                    _afterSeqEl();

                    }

                    _exitAlt();

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:327:945: 
                    {
                    _enterAlt(1);
                    _exitAlt();

                    }
                    break;

            }

            _afterSeqEl();

            }


            ret2 = commitCreation(ret, firstToken, false);

             

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "coghead_templatedpermission"


    // $ANTLR start "coghead_query"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:336:1: coghead_query returns [Object ret2] : ( 'from' (temp= coghead_collectiontemplate ( ( ',' ) temp= coghead_collectiontemplate )* ) ) ;
    public final Object coghead_query() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","Query");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:341:3: ( ( 'from' (temp= coghead_collectiontemplate ( ( ',' ) temp= coghead_collectiontemplate )* ) ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:342:3: ( 'from' (temp= coghead_collectiontemplate ( ( ',' ) temp= coghead_collectiontemplate )* ) )
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:342:3: ( 'from' (temp= coghead_collectiontemplate ( ( ',' ) temp= coghead_collectiontemplate )* ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:342:4: 'from' (temp= coghead_collectiontemplate ( ( ',' ) temp= coghead_collectiontemplate )* )
            {
            _beforeSeqEl("E0469530A56AFE4031AD11DF9827F04A8D150765");
            match(input,49,FOLLOW_49_in_coghead_query1042); 
            _afterSeqEl();
            _beforeSeqEl("E0469530A56B255131AD11DFCB86F04A8D150765");
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:342:144: (temp= coghead_collectiontemplate ( ( ',' ) temp= coghead_collectiontemplate )* )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:342:146: temp= coghead_collectiontemplate ( ( ',' ) temp= coghead_collectiontemplate )*
            {
            pushFollow(FOLLOW_coghead_collectiontemplate_in_coghead_query1049);
            temp=coghead_collectiontemplate();

            checkFollows();
            state._fsp--;

            setProperty(ret, "collectionTemplates", temp);
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:342:227: ( ( ',' ) temp= coghead_collectiontemplate )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==44) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:342:228: ( ',' ) temp= coghead_collectiontemplate
            	    {
            	    _enterSepSeq();
            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:342:245: ( ',' )
            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:342:246: ','
            	    {
            	    _beforeSeqEl("E0469530A56AFE4231AD11DFC78AF04A8D150765");
            	    match(input,44,FOLLOW_44_in_coghead_query1057); 
            	    _afterSeqEl();

            	    }

            	    _exitSepSeq();
            	    pushFollow(FOLLOW_coghead_collectiontemplate_in_coghead_query1064);
            	    temp=coghead_collectiontemplate();

            	    checkFollows();
            	    state._fsp--;

            	    setProperty(ret, "collectionTemplates", temp);

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }

            _afterSeqEl();

            }


            ret2 = commitCreation(ret, firstToken, false);

             

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "coghead_query"


    // $ANTLR start "coghead_sortspec"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:350:1: coghead_sortspec returns [Object ret2] : () ;
    public final Object coghead_sortspec() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("coghead","SortSpec");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:355:3: ( () )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:356:3: ()
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:356:3: ()
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:356:4: 
            {
            }


            ret2 = commitCreation(ret, firstToken, false);

             

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "coghead_sortspec"


    // $ANTLR start "coghead_groupbyspec"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:364:1: coghead_groupbyspec returns [Object ret2] : () ;
    public final Object coghead_groupbyspec() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("coghead","GroupBySpec");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:369:3: ( () )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:370:3: ()
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:370:3: ()
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:370:4: 
            {
            }


            ret2 = commitCreation(ret, firstToken, false);

             

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "coghead_groupbyspec"


    // $ANTLR start "coghead_collectiontemplate"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:378:1: coghead_collectiontemplate returns [Object ret2] : ( (temp= identifier ) 'as' (temp= identifier ) ( ( 'where' (temp= coghead_fieldtemplate ( ( 'and' ) temp= coghead_fieldtemplate )* )? ) | ) ) ;
    public final Object coghead_collectiontemplate() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","CollectionTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"ColTempl"}) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:383:3: ( ( (temp= identifier ) 'as' (temp= identifier ) ( ( 'where' (temp= coghead_fieldtemplate ( ( 'and' ) temp= coghead_fieldtemplate )* )? ) | ) ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:384:3: ( (temp= identifier ) 'as' (temp= identifier ) ( ( 'where' (temp= coghead_fieldtemplate ( ( 'and' ) temp= coghead_fieldtemplate )* )? ) | ) )
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:384:3: ( (temp= identifier ) 'as' (temp= identifier ) ( ( 'where' (temp= coghead_fieldtemplate ( ( 'and' ) temp= coghead_fieldtemplate )* )? ) | ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:384:4: (temp= identifier ) 'as' (temp= identifier ) ( ( 'where' (temp= coghead_fieldtemplate ( ( 'and' ) temp= coghead_fieldtemplate )* )? ) | )
            {
            _beforeSeqEl("E0469530A570075331AD11DFA387F04A8D150765");
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:384:63: (temp= identifier )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:384:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_coghead_collectiontemplate1188);
            temp=identifier();

            checkFollows();
            state._fsp--;

            setOclRef(ret, "collection", "name", temp, "OCL:#context(Permission).oclAsType(CollectionLevelPermission).theCollection");

            }

            _afterSeqEl();
            _beforeSeqEl("E0469530A5702E6031AD11DF9EC1F04A8D150765");
            match(input,50,FOLLOW_50_in_coghead_collectiontemplate1194); 
            _afterSeqEl();
            _beforeSeqEl("E0469530A570557131AD11DFCEC5F04A8D150765");
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:384:360: (temp= identifier )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:384:362: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_coghead_collectiontemplate1201);
            temp=identifier();

            checkFollows();
            state._fsp--;

            setProperty(ret, "name", temp);

            }

            _afterSeqEl();
            _beforeSeqEl("E0469530A570F1B031AD11DFB930F04A8D150765");
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:384:488: ( ( 'where' (temp= coghead_fieldtemplate ( ( 'and' ) temp= coghead_fieldtemplate )* )? ) | )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==51) ) {
                alt29=1;
            }
            else if ( (LA29_0==RBRACKET||LA29_0==44) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:384:489: ( 'where' (temp= coghead_fieldtemplate ( ( 'and' ) temp= coghead_fieldtemplate )* )? )
                    {
                    _enterAlt(0);
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:384:505: ( 'where' (temp= coghead_fieldtemplate ( ( 'and' ) temp= coghead_fieldtemplate )* )? )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:384:506: 'where' (temp= coghead_fieldtemplate ( ( 'and' ) temp= coghead_fieldtemplate )* )?
                    {
                    _beforeSeqEl("E0469530A5707C8131AD11DF8327F04A8D150765");
                    match(input,51,FOLLOW_51_in_coghead_collectiontemplate1213); 
                    _afterSeqEl();
                    _beforeSeqEl("E0469530A570CAA031AD11DF876FF04A8D150765");
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:384:647: (temp= coghead_fieldtemplate ( ( 'and' ) temp= coghead_fieldtemplate )* )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==NAME) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:384:649: temp= coghead_fieldtemplate ( ( 'and' ) temp= coghead_fieldtemplate )*
                            {
                            pushFollow(FOLLOW_coghead_fieldtemplate_in_coghead_collectiontemplate1220);
                            temp=coghead_fieldtemplate();

                            checkFollows();
                            state._fsp--;

                            setProperty(ret, "fieldTemplates", temp);
                            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:384:720: ( ( 'and' ) temp= coghead_fieldtemplate )*
                            loop27:
                            do {
                                int alt27=2;
                                int LA27_0 = input.LA(1);

                                if ( (LA27_0==52) ) {
                                    alt27=1;
                                }


                                switch (alt27) {
                            	case 1 :
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:384:721: ( 'and' ) temp= coghead_fieldtemplate
                            	    {
                            	    _enterSepSeq();
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:384:738: ( 'and' )
                            	    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:384:739: 'and'
                            	    {
                            	    _beforeSeqEl("E0469530A5707C8331AD11DFA4F5F04A8D150765");
                            	    match(input,52,FOLLOW_52_in_coghead_collectiontemplate1228); 
                            	    _afterSeqEl();

                            	    }

                            	    _exitSepSeq();
                            	    pushFollow(FOLLOW_coghead_fieldtemplate_in_coghead_collectiontemplate1235);
                            	    temp=coghead_fieldtemplate();

                            	    checkFollows();
                            	    state._fsp--;

                            	    setProperty(ret, "fieldTemplates", temp);

                            	    }
                            	    break;

                            	default :
                            	    break loop27;
                                }
                            } while (true);


                            }
                            break;

                    }

                    _afterSeqEl();

                    }

                    _exitAlt();

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:384:947: 
                    {
                    _enterAlt(1);
                    _exitAlt();

                    }
                    break;

            }

            _afterSeqEl();

            }


            ret2 = commitCreation(ret, firstToken, true);

             

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "coghead_collectiontemplate"


    // $ANTLR start "coghead_fieldtemplate"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:393:1: coghead_fieldtemplate returns [Object ret2] : (ret= coghead_operatortemplate ) ;
    public final Object coghead_fieldtemplate() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:394:3: ( (ret= coghead_operatortemplate ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:395:3: (ret= coghead_operatortemplate )
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:395:3: (ret= coghead_operatortemplate )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:395:4: ret= coghead_operatortemplate
            {
            pushFollow(FOLLOW_coghead_operatortemplate_in_coghead_fieldtemplate1293);
            ret=coghead_operatortemplate();

            checkFollows();
            state._fsp--;


            }


            ret2=ret;
             

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "coghead_fieldtemplate"


    // $ANTLR start "coghead_operatortemplate"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:402:1: coghead_operatortemplate returns [Object ret2] : ( (temp= identifier ) EQUALS (temp= coghead_expression ) ) ;
    public final Object coghead_operatortemplate() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","OperatorTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:407:3: ( ( (temp= identifier ) EQUALS (temp= coghead_expression ) ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:408:3: ( (temp= identifier ) EQUALS (temp= coghead_expression ) )
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:408:3: ( (temp= identifier ) EQUALS (temp= coghead_expression ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:408:4: (temp= identifier ) EQUALS (temp= coghead_expression )
            {
            _beforeSeqEl("E0469530A573FEF131AD11DFABD0F04A8D150765");
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:408:63: (temp= identifier )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:408:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_coghead_operatortemplate1327);
            temp=identifier();

            checkFollows();
            state._fsp--;

            setOclRef(ret, "field", "name", temp, "OCL:#context(ColTempl).oclAsType(CollectionTemplate).collection.schema.entries->select(f | f.name = ?)");

            }

            _afterSeqEl();
            _beforeSeqEl("E0469530A574260031AD11DF93A4F04A8D150765");
            match(input,EQUALS,FOLLOW_EQUALS_in_coghead_operatortemplate1334); 
            _afterSeqEl();
            _beforeSeqEl("E0469530A575106031AD11DFB8F4F04A8D150765");
            _enterInjectorAction();setProperty(ret, "operator", coghead.OperatorEnumEnum.EQUALS);_exitInjectorAction();
            _afterSeqEl();
            _beforeSeqEl("E0469530A575ACA131AD11DFA750F04A8D150765");
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:408:570: (temp= coghead_expression )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:408:572: temp= coghead_expression
            {
            pushFollow(FOLLOW_coghead_expression_in_coghead_operatortemplate1345);
            temp=coghead_expression();

            checkFollows();
            state._fsp--;

            setProperty(ret, "valueOrListOrFunction", temp);

            }

            _afterSeqEl();

            }


            ret2 = commitCreation(ret, firstToken, false);

             

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "coghead_operatortemplate"


    // $ANTLR start "coghead_projection"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:416:1: coghead_projection returns [Object ret2] : () ;
    public final Object coghead_projection() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("coghead","Projection");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:421:3: ( () )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:422:3: ()
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:422:3: ()
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:422:4: 
            {
            }


            ret2 = commitCreation(ret, firstToken, false);

             

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "coghead_projection"


    // $ANTLR start "coghead_expression"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:430:1: coghead_expression returns [Object ret2] : (ret= coghead_xpath_xpathexpression ) ;
    public final Object coghead_expression() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:431:3: ( (ret= coghead_xpath_xpathexpression ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:432:3: (ret= coghead_xpath_xpathexpression )
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:432:3: (ret= coghead_xpath_xpathexpression )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:432:4: ret= coghead_xpath_xpathexpression
            {
            pushFollow(FOLLOW_coghead_xpath_xpathexpression_in_coghead_expression1422);
            ret=coghead_xpath_xpathexpression();

            checkFollows();
            state._fsp--;


            }


            ret2=ret;
             

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "coghead_expression"


    // $ANTLR start "coghead_xpath_xpathexpression"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:439:1: coghead_xpath_xpathexpression returns [Object ret2] : (ret= coghead_xpath_literal ) ;
    public final Object coghead_xpath_xpathexpression() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:440:3: ( (ret= coghead_xpath_literal ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:441:3: (ret= coghead_xpath_literal )
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:441:3: (ret= coghead_xpath_literal )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:441:4: ret= coghead_xpath_literal
            {
            pushFollow(FOLLOW_coghead_xpath_literal_in_coghead_xpath_xpathexpression1449);
            ret=coghead_xpath_literal();

            checkFollows();
            state._fsp--;


            }


            ret2=ret;
             

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "coghead_xpath_xpathexpression"


    // $ANTLR start "coghead_xpath_literal"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:448:1: coghead_xpath_literal returns [Object ret2] : (ret= coghead_xpath_stringliteral | ret= coghead_xpath_numberliteral ) ;
    public final Object coghead_xpath_literal() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:449:3: ( (ret= coghead_xpath_stringliteral | ret= coghead_xpath_numberliteral ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:450:3: (ret= coghead_xpath_stringliteral | ret= coghead_xpath_numberliteral )
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:450:3: (ret= coghead_xpath_stringliteral | ret= coghead_xpath_numberliteral )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==STRING) ) {
                alt30=1;
            }
            else if ( ((LA30_0>=INT && LA30_0<=DOUBLE)) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:450:4: ret= coghead_xpath_stringliteral
                    {
                    pushFollow(FOLLOW_coghead_xpath_stringliteral_in_coghead_xpath_literal1476);
                    ret=coghead_xpath_stringliteral();

                    checkFollows();
                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:451:5: ret= coghead_xpath_numberliteral
                    {
                    pushFollow(FOLLOW_coghead_xpath_numberliteral_in_coghead_xpath_literal1484);
                    ret=coghead_xpath_numberliteral();

                    checkFollows();
                    state._fsp--;


                    }
                    break;

            }


            ret2=ret;
             

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "coghead_xpath_literal"


    // $ANTLR start "coghead_xpath_stringliteral"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:458:1: coghead_xpath_stringliteral returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object coghead_xpath_stringliteral() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","xpath","StringLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:463:3: ( ( (temp= stringSymbol ) ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:464:3: ( (temp= stringSymbol ) )
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:464:3: ( (temp= stringSymbol ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:464:4: (temp= stringSymbol )
            {
            _beforeSeqEl("E0469530A580A92031AD11DFA68EF04A8D150765");
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:464:63: (temp= stringSymbol )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:464:65: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_coghead_xpath_stringliteral1518);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;

            setProperty(ret, "value", temp);

            }

            _afterSeqEl();

            }


            ret2 = commitCreation(ret, firstToken, false);

             

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "coghead_xpath_stringliteral"


    // $ANTLR start "coghead_xpath_numberliteral"
    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:472:1: coghead_xpath_numberliteral returns [Object ret2] : ( ( ( (temp= integerAsStringSymbol ) ) | ( (temp= doubleAsStringSymbol ) ) | ( (temp= floatAsStringSymbol ) ) ) ) ;
    public final Object coghead_xpath_numberliteral() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","xpath","NumberLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:477:3: ( ( ( ( (temp= integerAsStringSymbol ) ) | ( (temp= doubleAsStringSymbol ) ) | ( (temp= floatAsStringSymbol ) ) ) ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:478:3: ( ( ( (temp= integerAsStringSymbol ) ) | ( (temp= doubleAsStringSymbol ) ) | ( (temp= floatAsStringSymbol ) ) ) )
            {
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:478:3: ( ( ( (temp= integerAsStringSymbol ) ) | ( (temp= doubleAsStringSymbol ) ) | ( (temp= floatAsStringSymbol ) ) ) )
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:478:4: ( ( (temp= integerAsStringSymbol ) ) | ( (temp= doubleAsStringSymbol ) ) | ( (temp= floatAsStringSymbol ) ) )
            {
            _beforeSeqEl("E0469530A584C7D131AD11DF9835F04A8D150765");
            // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:478:63: ( ( (temp= integerAsStringSymbol ) ) | ( (temp= doubleAsStringSymbol ) ) | ( (temp= floatAsStringSymbol ) ) )
            int alt31=3;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt31=1;
                }
                break;
            case DOUBLE:
                {
                alt31=2;
                }
                break;
            case FLOAT:
                {
                alt31=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:478:64: ( (temp= integerAsStringSymbol ) )
                    {
                    _enterAlt(0);
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:478:80: ( (temp= integerAsStringSymbol ) )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:478:81: (temp= integerAsStringSymbol )
                    {
                    _beforeSeqEl("E0469530A583413231AD11DFB6C6F04A8D150765");
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:478:140: (temp= integerAsStringSymbol )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:478:142: temp= integerAsStringSymbol
                    {
                    pushFollow(FOLLOW_integerAsStringSymbol_in_coghead_xpath_numberliteral1570);
                    temp=integerAsStringSymbol();

                    checkFollows();
                    state._fsp--;

                    setProperty(ret, "value", temp);

                    }

                    _afterSeqEl();

                    }

                    _exitAlt();

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:479:4: ( (temp= doubleAsStringSymbol ) )
                    {
                    _enterAlt(1);
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:479:20: ( (temp= doubleAsStringSymbol ) )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:479:21: (temp= doubleAsStringSymbol )
                    {
                    _beforeSeqEl("E0469530A58452A231AD11DFA7CAF04A8D150765");
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:479:80: (temp= doubleAsStringSymbol )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:479:82: temp= doubleAsStringSymbol
                    {
                    pushFollow(FOLLOW_doubleAsStringSymbol_in_coghead_xpath_numberliteral1590);
                    temp=doubleAsStringSymbol();

                    checkFollows();
                    state._fsp--;

                    setProperty(ret, "value", temp);

                    }

                    _afterSeqEl();

                    }

                    _exitAlt();

                    }
                    break;
                case 3 :
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:480:4: ( (temp= floatAsStringSymbol ) )
                    {
                    _enterAlt(2);
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:480:20: ( (temp= floatAsStringSymbol ) )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:480:21: (temp= floatAsStringSymbol )
                    {
                    _beforeSeqEl("E0469530A584A0C231AD11DFC035F04A8D150765");
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:480:80: (temp= floatAsStringSymbol )
                    // C:\\Users\\siani\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:480:82: temp= floatAsStringSymbol
                    {
                    pushFollow(FOLLOW_floatAsStringSymbol_in_coghead_xpath_numberliteral1610);
                    temp=floatAsStringSymbol();

                    checkFollows();
                    state._fsp--;

                    setProperty(ret, "value", temp);

                    }

                    _afterSeqEl();

                    }

                    _exitAlt();

                    }
                    break;

            }

            _afterSeqEl();

            }


            ret2 = commitCreation(ret, firstToken, false);

             

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "coghead_xpath_numberliteral"

    // Delegated rules


 

    public static final BitSet FOLLOW_NAME_in_identifier63 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_longSymbol156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerAsStringSymbol187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatAsStringSymbol218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_doubleAsStringSymbol249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_coghead_operatorenum279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_coghead_operatorenum287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_coghead_operatorenum295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_coghead_operatorenum303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_coghead_operatorenum311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_coghead_operatorenum319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_collectionlevelpermission_in_main347 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_coghead_collectionlevelpermission381 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_coghead_collectionlevelpermission384 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LCURL_in_coghead_collectionlevelpermission388 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_coghead_collectionlevelpermission392 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LCURL_in_coghead_collectionlevelpermission396 = new BitSet(new long[]{0x0000E80000004000L});
    public static final BitSet FOLLOW_43_in_coghead_collectionlevelpermission406 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_coghead_collectionlevelpermission410 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_coghead_collectionlevelpermission415 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_identifier_in_coghead_collectionlevelpermission423 = new BitSet(new long[]{0x0000100000001000L});
    public static final BitSet FOLLOW_44_in_coghead_collectionlevelpermission431 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_coghead_collectionlevelpermission438 = new BitSet(new long[]{0x0000100000001000L});
    public static final BitSet FOLLOW_RPAREN_in_coghead_collectionlevelpermission450 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_coghead_collectionlevelpermission455 = new BitSet(new long[]{0x0000E00000004000L});
    public static final BitSet FOLLOW_45_in_coghead_collectionlevelpermission478 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_coghead_collectionlevelpermission482 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_coghead_collectionlevelpermission487 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_identifier_in_coghead_collectionlevelpermission495 = new BitSet(new long[]{0x0000100000001000L});
    public static final BitSet FOLLOW_44_in_coghead_collectionlevelpermission503 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_coghead_collectionlevelpermission510 = new BitSet(new long[]{0x0000100000001000L});
    public static final BitSet FOLLOW_RPAREN_in_coghead_collectionlevelpermission522 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_coghead_collectionlevelpermission527 = new BitSet(new long[]{0x0000C00000004000L});
    public static final BitSet FOLLOW_46_in_coghead_collectionlevelpermission550 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_coghead_collectionlevelpermission554 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_coghead_collectionlevelpermission559 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_identifier_in_coghead_collectionlevelpermission567 = new BitSet(new long[]{0x0000100000001000L});
    public static final BitSet FOLLOW_44_in_coghead_collectionlevelpermission575 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_coghead_collectionlevelpermission582 = new BitSet(new long[]{0x0000100000001000L});
    public static final BitSet FOLLOW_RPAREN_in_coghead_collectionlevelpermission594 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_coghead_collectionlevelpermission599 = new BitSet(new long[]{0x0000800000004000L});
    public static final BitSet FOLLOW_47_in_coghead_collectionlevelpermission622 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_coghead_collectionlevelpermission626 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_coghead_collectionlevelpermission631 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_identifier_in_coghead_collectionlevelpermission639 = new BitSet(new long[]{0x0000100000001000L});
    public static final BitSet FOLLOW_44_in_coghead_collectionlevelpermission647 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_coghead_collectionlevelpermission654 = new BitSet(new long[]{0x0000100000001000L});
    public static final BitSet FOLLOW_RPAREN_in_coghead_collectionlevelpermission666 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_coghead_collectionlevelpermission671 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RCURL_in_coghead_collectionlevelpermission689 = new BitSet(new long[]{0x0001000000004000L});
    public static final BitSet FOLLOW_48_in_coghead_collectionlevelpermission699 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LCURL_in_coghead_collectionlevelpermission703 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_coghead_templatedpermission_in_coghead_collectionlevelpermission711 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_SEMICOLON_in_coghead_collectionlevelpermission720 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_coghead_templatedpermission_in_coghead_collectionlevelpermission728 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_RCURL_in_coghead_collectionlevelpermission740 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RCURL_in_coghead_collectionlevelpermission758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_coghead_templatedpermission800 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_coghead_query_in_coghead_templatedpermission808 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RBRACKET_in_coghead_templatedpermission815 = new BitSet(new long[]{0x0000E00000000002L});
    public static final BitSet FOLLOW_45_in_coghead_templatedpermission825 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_coghead_templatedpermission829 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_identifier_in_coghead_templatedpermission837 = new BitSet(new long[]{0x0000100000001000L});
    public static final BitSet FOLLOW_44_in_coghead_templatedpermission845 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_coghead_templatedpermission852 = new BitSet(new long[]{0x0000100000001000L});
    public static final BitSet FOLLOW_RPAREN_in_coghead_templatedpermission864 = new BitSet(new long[]{0x0000C00000000002L});
    public static final BitSet FOLLOW_46_in_coghead_templatedpermission887 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_coghead_templatedpermission891 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_identifier_in_coghead_templatedpermission899 = new BitSet(new long[]{0x0000100000001000L});
    public static final BitSet FOLLOW_44_in_coghead_templatedpermission907 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_coghead_templatedpermission914 = new BitSet(new long[]{0x0000100000001000L});
    public static final BitSet FOLLOW_RPAREN_in_coghead_templatedpermission926 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_coghead_templatedpermission949 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_coghead_templatedpermission953 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_identifier_in_coghead_templatedpermission961 = new BitSet(new long[]{0x0000100000001000L});
    public static final BitSet FOLLOW_44_in_coghead_templatedpermission969 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_coghead_templatedpermission976 = new BitSet(new long[]{0x0000100000001000L});
    public static final BitSet FOLLOW_RPAREN_in_coghead_templatedpermission988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_coghead_query1042 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_coghead_collectiontemplate_in_coghead_query1049 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_coghead_query1057 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_coghead_collectiontemplate_in_coghead_query1064 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_identifier_in_coghead_collectiontemplate1188 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_coghead_collectiontemplate1194 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_coghead_collectiontemplate1201 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_coghead_collectiontemplate1213 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_coghead_fieldtemplate_in_coghead_collectiontemplate1220 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_52_in_coghead_collectiontemplate1228 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_coghead_fieldtemplate_in_coghead_collectiontemplate1235 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_coghead_operatortemplate_in_coghead_fieldtemplate1293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_coghead_operatortemplate1327 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_EQUALS_in_coghead_operatortemplate1334 = new BitSet(new long[]{0x00000000000001E0L});
    public static final BitSet FOLLOW_coghead_expression_in_coghead_operatortemplate1345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_xpath_xpathexpression_in_coghead_expression1422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_xpath_literal_in_coghead_xpath_xpathexpression1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_xpath_stringliteral_in_coghead_xpath_literal1476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_xpath_numberliteral_in_coghead_xpath_literal1484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_coghead_xpath_stringliteral1518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerAsStringSymbol_in_coghead_xpath_numberliteral1570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_doubleAsStringSymbol_in_coghead_xpath_numberliteral1590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_floatAsStringSymbol_in_coghead_xpath_numberliteral1610 = new BitSet(new long[]{0x0000000000000002L});

}