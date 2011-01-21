// $ANTLR 3.1.1 C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g 2011-01-17 11:53:22

package com.sap.furcas.parser.tcs.stable;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.impl.PredicateSemantic;
import com.sap.furcas.runtime.parser.impl.SemanticDisambRuleData;
import com.sap.furcas.runtime.tcs.RuleNameFinder;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import org.antlr.runtime.Token;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class SyntaxConfigurationParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "LCURLY", "COMA", "RCURLY", "COLON", "SHARP", "SEMI", "MULTI_LINE_COMMENT", "COMMENT", "RPAREN", "STAR", "SLASH", "NE", "DLCOLON", "DLSQUARE", "QMARK", "LE", "DRSQUARE", "DLCURLY", "RSQUARE", "PLUS", "LPAREN", "PIPE", "DOLLAR", "MINUS", "GT", "GE", "POINT", "LT", "LARROW", "AROBAS", "LSQUARE", "EQ", "RARROW", "EXCL", "DRCURLY", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "FLOAT", "'bind'", "'Configuration'", "'to'"
    };
    public static final int DOLLAR=29;
    public static final int DLCURLY=24;
    public static final int LT=34;
    public static final int STAR=16;
    public static final int LSQUARE=37;
    public static final int POINT=33;
    public static final int AROBAS=36;
    public static final int ESC=47;
    public static final int DLCOLON=19;
    public static final int DRCURLY=41;
    public static final int DRSQUARE=23;
    public static final int LARROW=35;
    public static final int FLOAT=48;
    public static final int EXCL=40;
    public static final int EOF=-1;
    public static final int LPAREN=27;
    public static final int RPAREN=15;
    public static final int NAME=4;
    public static final int T__51=51;
    public static final int SLASH=17;
    public static final int PLUS=26;
    public static final int PIPE=28;
    public static final int DIGIT=44;
    public static final int NL=42;
    public static final int EQ=38;
    public static final int COMMENT=14;
    public static final int T__50=50;
    public static final int NE=18;
    public static final int GE=32;
    public static final int SHARP=11;
    public static final int DLSQUARE=20;
    public static final int T__49=49;
    public static final int RARROW=39;
    public static final int LCURLY=7;
    public static final int INT=6;
    public static final int RSQUARE=25;
    public static final int MINUS=30;
    public static final int COMA=8;
    public static final int SEMI=12;
    public static final int MULTI_LINE_COMMENT=13;
    public static final int ALPHA=45;
    public static final int COLON=10;
    public static final int WS=43;
    public static final int SNAME=46;
    public static final int RCURLY=9;
    public static final int GT=31;
    public static final int QMARK=21;
    public static final int LE=22;
    public static final int STRING=5;

    // delegates
    // delegators


        public SyntaxConfigurationParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public SyntaxConfigurationParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return SyntaxConfigurationParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g"; }


       private static final String syntaxUUID = "SyntaxConfiguration";
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
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:208:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:209:3: ( (ast= NAME ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:210:3: (ast= NAME )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:210:3: (ast= NAME )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:210:4: ast= NAME
            {
            ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifier69); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              ret = unescapeString( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

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


    // $ANTLR start "identifierOrKeyword"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:218:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'bind' | 'Configuration' | 'to' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:219:3: ( (ast= NAME | 'bind' | 'Configuration' | 'to' ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:220:3: (ast= NAME | 'bind' | 'Configuration' | 'to' )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:220:3: (ast= NAME | 'bind' | 'Configuration' | 'to' )
            int alt1=4;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt1=1;
                }
                break;
            case 49:
                {
                alt1=2;
                }
                break;
            case 50:
                {
                alt1=3;
                }
                break;
            case 51:
                {
                alt1=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:220:4: ast= NAME
                    {
                    ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword100); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = unescapeString( ast.getText());

                    }

                    }
                    break;
                case 2 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:222:5: 'bind'
                    {
                    match(input,49,FOLLOW_49_in_identifierOrKeyword108); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "bind";
                    }

                    }
                    break;
                case 3 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:223:5: 'Configuration'
                    {
                    match(input,50,FOLLOW_50_in_identifierOrKeyword116); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "Configuration";
                    }

                    }
                    break;
                case 4 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:224:5: 'to'
                    {
                    match(input,51,FOLLOW_51_in_identifierOrKeyword124); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "to";
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

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
    // $ANTLR end "identifierOrKeyword"


    // $ANTLR start "plainStringSymbol"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:231:1: plainStringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object plainStringSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:232:3: ( (ast= STRING ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:233:3: (ast= STRING )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:233:3: (ast= STRING )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:233:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_plainStringSymbol155); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              ret = unescapeString( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

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
    // $ANTLR end "plainStringSymbol"


    // $ANTLR start "integerSymbol"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:241:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:242:3: ( (ast= INT ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:243:3: (ast= INT )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:243:3: (ast= INT )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:243:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol186); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              ret = Integer.valueOf( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

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


    // $ANTLR start "main"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:251:1: main returns [Object ret2] : ( (ret= furcas_interfaceconfiguration_configuration ) EOF ) ;
    public final Object main() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:252:3: ( ( (ret= furcas_interfaceconfiguration_configuration ) EOF ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:253:3: ( (ret= furcas_interfaceconfiguration_configuration ) EOF )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:253:3: ( (ret= furcas_interfaceconfiguration_configuration ) EOF )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:253:4: (ret= furcas_interfaceconfiguration_configuration ) EOF
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:253:4: (ret= furcas_interfaceconfiguration_configuration )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:253:5: ret= furcas_interfaceconfiguration_configuration
            {
            pushFollow(FOLLOW_furcas_interfaceconfiguration_configuration_in_main214);
            ret=furcas_interfaceconfiguration_configuration();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main217); if (state.failed) return ret2;

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

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


    // $ANTLR start "furcas_interfaceconfiguration_configuration"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:260:1: furcas_interfaceconfiguration_configuration returns [Object ret2] : ( 'Configuration' (temp= identifier )? LCURLY ( ( (temp= furcas_interfaceconfiguration_binding ( ( COMA ) temp= furcas_interfaceconfiguration_binding )* ) ) ) RCURLY ) ;
    public final Object furcas_interfaceconfiguration_configuration() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","interfaceconfiguration","Configuration");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:266:3: ( ( 'Configuration' (temp= identifier )? LCURLY ( ( (temp= furcas_interfaceconfiguration_binding ( ( COMA ) temp= furcas_interfaceconfiguration_binding )* ) ) ) RCURLY ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:267:3: ( 'Configuration' (temp= identifier )? LCURLY ( ( (temp= furcas_interfaceconfiguration_binding ( ( COMA ) temp= furcas_interfaceconfiguration_binding )* ) ) ) RCURLY )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:267:3: ( 'Configuration' (temp= identifier )? LCURLY ( ( (temp= furcas_interfaceconfiguration_binding ( ( COMA ) temp= furcas_interfaceconfiguration_binding )* ) ) ) RCURLY )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:267:4: 'Configuration' (temp= identifier )? LCURLY ( ( (temp= furcas_interfaceconfiguration_binding ( ( COMA ) temp= furcas_interfaceconfiguration_binding )* ) ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.4/@templateSequence/@elements.0");
            }
            match(input,50,FOLLOW_50_in_furcas_interfaceconfiguration_configuration248); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.4/@templateSequence/@elements.1");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:267:305: (temp= identifier )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NAME) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:267:307: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_furcas_interfaceconfiguration_configuration255);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "name", temp);
                      setParent(temp,ret,"name");
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.4/@templateSequence/@elements.2");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_furcas_interfaceconfiguration_configuration264); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.4/@templateSequence/@elements.3");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:268:342: ( ( (temp= furcas_interfaceconfiguration_binding ( ( COMA ) temp= furcas_interfaceconfiguration_binding )* ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:268:343: ( (temp= furcas_interfaceconfiguration_binding ( ( COMA ) temp= furcas_interfaceconfiguration_binding )* ) )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:268:343: ( (temp= furcas_interfaceconfiguration_binding ( ( COMA ) temp= furcas_interfaceconfiguration_binding )* ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:268:344: (temp= furcas_interfaceconfiguration_binding ( ( COMA ) temp= furcas_interfaceconfiguration_binding )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.4/@templateSequence/@elements.3/@blockSequence/@elements.0");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:268:506: (temp= furcas_interfaceconfiguration_binding ( ( COMA ) temp= furcas_interfaceconfiguration_binding )* )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:268:508: temp= furcas_interfaceconfiguration_binding ( ( COMA ) temp= furcas_interfaceconfiguration_binding )*
            {
            pushFollow(FOLLOW_furcas_interfaceconfiguration_binding_in_furcas_interfaceconfiguration_configuration275);
            temp=furcas_interfaceconfiguration_binding();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "bindings", temp);
              setParent(temp,ret,"bindings");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:269:34: ( ( COMA ) temp= furcas_interfaceconfiguration_binding )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==COMA) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:269:35: ( COMA ) temp= furcas_interfaceconfiguration_binding
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:269:52: ( COMA )
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:269:53: COMA
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.4/@templateSequence/@elements.3/@blockSequence/@elements.0/@propertyArgs.0/@separatorSequence/@elements.0");
            	    }
            	    match(input,COMA,FOLLOW_COMA_in_furcas_interfaceconfiguration_configuration284); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_furcas_interfaceconfiguration_binding_in_furcas_interfaceconfiguration_configuration292);
            	    temp=furcas_interfaceconfiguration_binding();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "bindings", temp);
            	      setParent(temp,ret,"bindings");
            	    }

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.4/@templateSequence/@elements.4");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_furcas_interfaceconfiguration_configuration305); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

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
    // $ANTLR end "furcas_interfaceconfiguration_configuration"


    // $ANTLR start "furcas_interfaceconfiguration_binding"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:278:1: furcas_interfaceconfiguration_binding returns [Object ret2] : ( 'bind' (temp= identifier ) COLON (temp= identifierOrKeyword ) ( ( SHARP (temp= identifier ) ) | ) 'to' (temp= identifier ) COLON (temp= identifierOrKeyword ) ( ( SHARP (temp= identifier ) ) | ) SEMI ) ;
    public final Object furcas_interfaceconfiguration_binding() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","interfaceconfiguration","Binding");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:284:3: ( ( 'bind' (temp= identifier ) COLON (temp= identifierOrKeyword ) ( ( SHARP (temp= identifier ) ) | ) 'to' (temp= identifier ) COLON (temp= identifierOrKeyword ) ( ( SHARP (temp= identifier ) ) | ) SEMI ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:285:3: ( 'bind' (temp= identifier ) COLON (temp= identifierOrKeyword ) ( ( SHARP (temp= identifier ) ) | ) 'to' (temp= identifier ) COLON (temp= identifierOrKeyword ) ( ( SHARP (temp= identifier ) ) | ) SEMI )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:285:3: ( 'bind' (temp= identifier ) COLON (temp= identifierOrKeyword ) ( ( SHARP (temp= identifier ) ) | ) 'to' (temp= identifier ) COLON (temp= identifierOrKeyword ) ( ( SHARP (temp= identifier ) ) | ) SEMI )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:285:4: 'bind' (temp= identifier ) COLON (temp= identifierOrKeyword ) ( ( SHARP (temp= identifier ) ) | ) 'to' (temp= identifier ) COLON (temp= identifierOrKeyword ) ( ( SHARP (temp= identifier ) ) | ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.5/@templateSequence/@elements.0");
            }
            match(input,49,FOLLOW_49_in_furcas_interfaceconfiguration_binding346); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.5/@templateSequence/@elements.1");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:285:296: (temp= identifier )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:285:298: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_furcas_interfaceconfiguration_binding353);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setOclRef(ret, "requireingSyntax", "name", temp, "OCL:TCS::ConcreteSyntax.allInstances()->select(cs | cs.name = ? )");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.5/@templateSequence/@elements.2");
            }
            match(input,COLON,FOLLOW_COLON_in_furcas_interfaceconfiguration_binding360); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.5/@templateSequence/@elements.3");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:285:744: (temp= identifierOrKeyword )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:285:746: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_furcas_interfaceconfiguration_binding368);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setOclRef(ret, "requiredTemplate", null, temp, "OCL:  requireingSyntax.requiredTemplates ->select(t | t.oclIsTypeOf(TCS::RequiredInterfaceTemplate) and t.metaReference.name = ? and"+"					if(not self.mode.oclIsUndefined()) then"+"                                            	t.oclAsType(FURCAS::TCS::RequiredInterfaceTemplate).mode = self.mode"+"                                            else"+"                                            	t.oclAsType(FURCAS::TCS::RequiredInterfaceTemplate).mode.oclIsUndefined()"+"                                            endif)");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.5/@templateSequence/@elements.4");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:285:1497: ( ( SHARP (temp= identifier ) ) | )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==SHARP) ) {
                alt4=1;
            }
            else if ( (LA4_0==51) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:285:1498: ( SHARP (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:285:1514: ( SHARP (temp= identifier ) )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:285:1515: SHARP (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.5/@templateSequence/@elements.4/@thenSequence/@elements.0");
                    }
                    match(input,SHARP,FOLLOW_SHARP_in_furcas_interfaceconfiguration_binding381); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.5/@templateSequence/@elements.4/@thenSequence/@elements.1");
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:285:1860: (temp= identifier )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:285:1862: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_furcas_interfaceconfiguration_binding389);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "mode", temp);
                      setParent(temp,ret,"mode");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:286:64: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.5/@templateSequence/@elements.5");
            }
            match(input,51,FOLLOW_51_in_furcas_interfaceconfiguration_binding408); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.5/@templateSequence/@elements.6");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:287:307: (temp= identifier )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:287:309: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_furcas_interfaceconfiguration_binding415);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setOclRef(ret, "providingSyntax", "name", temp, "OCL:TCS::ConcreteSyntax.allInstances()->select(cs | cs.name = ? )");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.5/@templateSequence/@elements.7");
            }
            match(input,COLON,FOLLOW_COLON_in_furcas_interfaceconfiguration_binding422); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.5/@templateSequence/@elements.8");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:287:754: (temp= identifierOrKeyword )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:287:756: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_furcas_interfaceconfiguration_binding430);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setOclRef(ret, "providedTemplate", null, temp, "OCL:  providingSyntax.templates ->select(t |  t.metaReference.name = ? and"+"					if(not self.mode.oclIsUndefined()) then"+"                                            	t.oclAsType(FURCAS::TCS::ClassTemplate).mode = self.mode"+"                                            else"+"                                            	t.oclAsType(FURCAS::TCS::ClassTemplate).mode.oclIsUndefined()"+"                                            endif)");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.5/@templateSequence/@elements.9");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:287:1425: ( ( SHARP (temp= identifier ) ) | )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==SHARP) ) {
                alt5=1;
            }
            else if ( (LA5_0==SEMI) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:287:1426: ( SHARP (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:287:1442: ( SHARP (temp= identifier ) )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:287:1443: SHARP (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.5/@templateSequence/@elements.9/@thenSequence/@elements.0");
                    }
                    match(input,SHARP,FOLLOW_SHARP_in_furcas_interfaceconfiguration_binding443); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.5/@templateSequence/@elements.9/@thenSequence/@elements.1");
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:287:1788: (temp= identifier )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:287:1790: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_furcas_interfaceconfiguration_binding451);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "mode", temp);
                      setParent(temp,ret,"mode");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:288:64: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_9JvgQCInEeCXTpS2cKIxRw#/10/@templates.5/@templateSequence/@elements.10");
            }
            match(input,SEMI,FOLLOW_SEMI_in_furcas_interfaceconfiguration_binding471); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

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
    // $ANTLR end "furcas_interfaceconfiguration_binding"

    // Delegated rules


 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_identifierOrKeyword100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_identifierOrKeyword108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_identifierOrKeyword116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_identifierOrKeyword124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_plainStringSymbol155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_interfaceconfiguration_configuration_in_main214 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_furcas_interfaceconfiguration_configuration248 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_identifier_in_furcas_interfaceconfiguration_configuration255 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_furcas_interfaceconfiguration_configuration264 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_furcas_interfaceconfiguration_binding_in_furcas_interfaceconfiguration_configuration275 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_COMA_in_furcas_interfaceconfiguration_configuration284 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_furcas_interfaceconfiguration_binding_in_furcas_interfaceconfiguration_configuration292 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_RCURLY_in_furcas_interfaceconfiguration_configuration305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_furcas_interfaceconfiguration_binding346 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_furcas_interfaceconfiguration_binding353 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_furcas_interfaceconfiguration_binding360 = new BitSet(new long[]{0x000E000000000010L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_furcas_interfaceconfiguration_binding368 = new BitSet(new long[]{0x0008000000000800L});
    public static final BitSet FOLLOW_SHARP_in_furcas_interfaceconfiguration_binding381 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_furcas_interfaceconfiguration_binding389 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_furcas_interfaceconfiguration_binding408 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_furcas_interfaceconfiguration_binding415 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_furcas_interfaceconfiguration_binding422 = new BitSet(new long[]{0x000E000000000010L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_furcas_interfaceconfiguration_binding430 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_SHARP_in_furcas_interfaceconfiguration_binding443 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_furcas_interfaceconfiguration_binding451 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_SEMI_in_furcas_interfaceconfiguration_binding471 = new BitSet(new long[]{0x0000000000000002L});

}