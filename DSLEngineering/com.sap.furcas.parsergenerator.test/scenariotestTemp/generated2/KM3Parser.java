// $ANTLR 3.1.1 ./scenariotestTemp/generated2/KM3.g 2010-11-04 23:29:56

package generated2;
import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationToken;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.impl.PredicateSemantic;
import com.sap.furcas.parsergenerator.emf.lookup.RuleNameFinder;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import org.antlr.runtime.Token;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class KM3Parser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "FLOAT", "LCURLY", "RCURLY", "SEMI", "COMA", "COLON", "LSQUARE", "STAR", "RSQUARE", "MINUS", "COMMENT", "EXCL", "LPAREN", "RPAREN", "COLONS", "PIPE", "SHARP", "QMARK", "POINT", "RARROW", "SLASH", "PLUS", "EQ", "GT", "LT", "GE", "LE", "NE", "LARROW", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "'package'", "'datatype'", "'abstract'", "'class'", "'extends'", "'reference'", "'ordered'", "'container'", "'oppositeOf'", "'unique'", "'attribute'", "'enumeration'", "'literal'"
    };
    public static final int LT=31;
    public static final int STAR=14;
    public static final int LSQUARE=13;
    public static final int POINT=25;
    public static final int ESC=41;
    public static final int LARROW=35;
    public static final int FLOAT=7;
    public static final int EXCL=18;
    public static final int EOF=-1;
    public static final int LPAREN=19;
    public static final int COLONS=21;
    public static final int RPAREN=20;
    public static final int NAME=4;
    public static final int T__51=51;
    public static final int SLASH=27;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int PIPE=22;
    public static final int PLUS=28;
    public static final int DIGIT=38;
    public static final int NL=36;
    public static final int EQ=29;
    public static final int COMMENT=17;
    public static final int T__50=50;
    public static final int NE=34;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int GE=32;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int SHARP=23;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RARROW=26;
    public static final int LCURLY=8;
    public static final int INT=6;
    public static final int RSQUARE=15;
    public static final int MINUS=16;
    public static final int COMA=11;
    public static final int SEMI=10;
    public static final int ALPHA=39;
    public static final int COLON=12;
    public static final int WS=37;
    public static final int SNAME=40;
    public static final int RCURLY=9;
    public static final int GT=30;
    public static final int QMARK=24;
    public static final int LE=33;
    public static final int STRING=5;

    // delegates
    // delegators


        public KM3Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public KM3Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return KM3Parser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/KM3.g"; }


       private static final String syntaxUUID = "KM3";
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
    // ./scenariotestTemp/generated2/KM3.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/KM3.g:208:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/KM3.g:209:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/KM3.g:209:3: (ast= NAME )
            // ./scenariotestTemp/generated2/KM3.g:209:4: ast= NAME
            {
            ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifier69); 
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
    // ./scenariotestTemp/generated2/KM3.g:217:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/KM3.g:218:3: ( (ast= STRING ) )
            // ./scenariotestTemp/generated2/KM3.g:219:3: (ast= STRING )
            {
            // ./scenariotestTemp/generated2/KM3.g:219:3: (ast= STRING )
            // ./scenariotestTemp/generated2/KM3.g:219:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_stringSymbol100); 
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
    // ./scenariotestTemp/generated2/KM3.g:227:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/KM3.g:228:3: ( (ast= INT ) )
            // ./scenariotestTemp/generated2/KM3.g:229:3: (ast= INT )
            {
            // ./scenariotestTemp/generated2/KM3.g:229:3: (ast= INT )
            // ./scenariotestTemp/generated2/KM3.g:229:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol131); 
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


    // $ANTLR start "floatSymbol"
    // ./scenariotestTemp/generated2/KM3.g:237:1: floatSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/KM3.g:238:3: ( (ast= FLOAT ) )
            // ./scenariotestTemp/generated2/KM3.g:239:3: (ast= FLOAT )
            {
            // ./scenariotestTemp/generated2/KM3.g:239:3: (ast= FLOAT )
            // ./scenariotestTemp/generated2/KM3.g:239:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatSymbol162); 
            ret = Double.valueOf( ast.getText());


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
    // $ANTLR end "floatSymbol"


    // $ANTLR start "main"
    // ./scenariotestTemp/generated2/KM3.g:247:1: main returns [Object ret2] : ( (ret= km3_metamodel ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/KM3.g:248:3: ( ( (ret= km3_metamodel ) EOF ) )
            // ./scenariotestTemp/generated2/KM3.g:249:3: ( (ret= km3_metamodel ) EOF )
            {
            // ./scenariotestTemp/generated2/KM3.g:249:3: ( (ret= km3_metamodel ) EOF )
            // ./scenariotestTemp/generated2/KM3.g:249:4: (ret= km3_metamodel ) EOF
            {
            // ./scenariotestTemp/generated2/KM3.g:249:4: (ret= km3_metamodel )
            // ./scenariotestTemp/generated2/KM3.g:249:5: ret= km3_metamodel
            {
            pushFollow(FOLLOW_km3_metamodel_in_main190);
            ret=km3_metamodel();

            checkFollows();
            state._fsp--;


            }

            match(input,EOF,FOLLOW_EOF_in_main193); 

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


    // $ANTLR start "km3_metamodel"
    // ./scenariotestTemp/generated2/KM3.g:256:1: km3_metamodel returns [Object ret2] : ( ( ( (temp= km3_package (temp= km3_package )* )? ) ) ) ;
    public final Object km3_metamodel() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("KM3","Metamodel");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/KM3.g:261:3: ( ( ( ( (temp= km3_package (temp= km3_package )* )? ) ) ) )
            // ./scenariotestTemp/generated2/KM3.g:262:3: ( ( ( (temp= km3_package (temp= km3_package )* )? ) ) )
            {
            // ./scenariotestTemp/generated2/KM3.g:262:3: ( ( ( (temp= km3_package (temp= km3_package )* )? ) ) )
            // ./scenariotestTemp/generated2/KM3.g:262:4: ( ( (temp= km3_package (temp= km3_package )* )? ) )
            {
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:262:21: ( ( (temp= km3_package (temp= km3_package )* )? ) )
            // ./scenariotestTemp/generated2/KM3.g:262:22: ( (temp= km3_package (temp= km3_package )* )? )
            {
            // ./scenariotestTemp/generated2/KM3.g:262:22: ( (temp= km3_package (temp= km3_package )* )? )
            // ./scenariotestTemp/generated2/KM3.g:262:23: (temp= km3_package (temp= km3_package )* )?
            {
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:262:40: (temp= km3_package (temp= km3_package )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==42) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./scenariotestTemp/generated2/KM3.g:262:42: temp= km3_package (temp= km3_package )*
                    {
                    pushFollow(FOLLOW_km3_package_in_km3_metamodel231);
                    temp=km3_package();

                    checkFollows();
                    state._fsp--;

                    setProperty(ret, "contents", temp);
                    // ./scenariotestTemp/generated2/KM3.g:262:97: (temp= km3_package )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==42) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/KM3.g:262:99: temp= km3_package
                    	    {
                    	    pushFollow(FOLLOW_km3_package_in_km3_metamodel239);
                    	    temp=km3_package();

                    	    checkFollows();
                    	    state._fsp--;

                    	    setProperty(ret, "contents", temp);

                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;

            }

            _afterSeqEl();

            }


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
    // $ANTLR end "km3_metamodel"


    // $ANTLR start "km3_modelelement"
    // ./scenariotestTemp/generated2/KM3.g:270:1: km3_modelelement returns [Object ret2] : (ret= km3_packageelement | ret= km3_structuralfeature | ret= km3_enumliteral ) ;
    public final Object km3_modelelement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/KM3.g:271:3: ( (ret= km3_packageelement | ret= km3_structuralfeature | ret= km3_enumliteral ) )
            // ./scenariotestTemp/generated2/KM3.g:272:3: (ret= km3_packageelement | ret= km3_structuralfeature | ret= km3_enumliteral )
            {
            // ./scenariotestTemp/generated2/KM3.g:272:3: (ret= km3_packageelement | ret= km3_structuralfeature | ret= km3_enumliteral )
            int alt3=3;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // ./scenariotestTemp/generated2/KM3.g:272:4: ret= km3_packageelement
                    {
                    pushFollow(FOLLOW_km3_packageelement_in_km3_modelelement287);
                    ret=km3_packageelement();

                    checkFollows();
                    state._fsp--;


                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/KM3.g:273:5: ret= km3_structuralfeature
                    {
                    pushFollow(FOLLOW_km3_structuralfeature_in_km3_modelelement295);
                    ret=km3_structuralfeature();

                    checkFollows();
                    state._fsp--;


                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/KM3.g:274:5: ret= km3_enumliteral
                    {
                    pushFollow(FOLLOW_km3_enumliteral_in_km3_modelelement303);
                    ret=km3_enumliteral();

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
    // $ANTLR end "km3_modelelement"


    // $ANTLR start "km3_packageelement"
    // ./scenariotestTemp/generated2/KM3.g:281:1: km3_packageelement returns [Object ret2] : (ret= km3_classifier | ret= km3_package ) ;
    public final Object km3_packageelement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/KM3.g:282:3: ( (ret= km3_classifier | ret= km3_package ) )
            // ./scenariotestTemp/generated2/KM3.g:283:3: (ret= km3_classifier | ret= km3_package )
            {
            // ./scenariotestTemp/generated2/KM3.g:283:3: (ret= km3_classifier | ret= km3_package )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=43 && LA4_0<=45)||LA4_0==53) ) {
                alt4=1;
            }
            else if ( (LA4_0==42) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ./scenariotestTemp/generated2/KM3.g:283:4: ret= km3_classifier
                    {
                    pushFollow(FOLLOW_km3_classifier_in_km3_packageelement330);
                    ret=km3_classifier();

                    checkFollows();
                    state._fsp--;


                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/KM3.g:284:5: ret= km3_package
                    {
                    pushFollow(FOLLOW_km3_package_in_km3_packageelement338);
                    ret=km3_package();

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
    // $ANTLR end "km3_packageelement"


    // $ANTLR start "km3_classifier"
    // ./scenariotestTemp/generated2/KM3.g:291:1: km3_classifier returns [Object ret2] : (ret= km3_datatype | ret= km3_class ) ;
    public final Object km3_classifier() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/KM3.g:292:3: ( (ret= km3_datatype | ret= km3_class ) )
            // ./scenariotestTemp/generated2/KM3.g:293:3: (ret= km3_datatype | ret= km3_class )
            {
            // ./scenariotestTemp/generated2/KM3.g:293:3: (ret= km3_datatype | ret= km3_class )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==43||LA5_0==53) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=44 && LA5_0<=45)) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ./scenariotestTemp/generated2/KM3.g:293:4: ret= km3_datatype
                    {
                    pushFollow(FOLLOW_km3_datatype_in_km3_classifier365);
                    ret=km3_datatype();

                    checkFollows();
                    state._fsp--;


                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/KM3.g:294:5: ret= km3_class
                    {
                    pushFollow(FOLLOW_km3_class_in_km3_classifier373);
                    ret=km3_class();

                    checkFollows();
                    state._fsp--;


                    }
                    break;

            }


            addToCurrentContext(ret);
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
    // $ANTLR end "km3_classifier"


    // $ANTLR start "km3_package"
    // ./scenariotestTemp/generated2/KM3.g:302:1: km3_package returns [Object ret2] : ( 'package' (temp= identifier ) LCURLY ( ( (temp= km3_packageelement (temp= km3_packageelement )* )? ) ) RCURLY ) ;
    public final Object km3_package() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("KM3","Package");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/KM3.g:307:3: ( ( 'package' (temp= identifier ) LCURLY ( ( (temp= km3_packageelement (temp= km3_packageelement )* )? ) ) RCURLY ) )
            // ./scenariotestTemp/generated2/KM3.g:308:3: ( 'package' (temp= identifier ) LCURLY ( ( (temp= km3_packageelement (temp= km3_packageelement )* )? ) ) RCURLY )
            {
            // ./scenariotestTemp/generated2/KM3.g:308:3: ( 'package' (temp= identifier ) LCURLY ( ( (temp= km3_packageelement (temp= km3_packageelement )* )? ) ) RCURLY )
            // ./scenariotestTemp/generated2/KM3.g:308:4: 'package' (temp= identifier ) LCURLY ( ( (temp= km3_packageelement (temp= km3_packageelement )* )? ) ) RCURLY
            {
            _beforeSeqEl();
            match(input,42,FOLLOW_42_in_km3_package403); 
            _afterSeqEl();
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:308:63: (temp= identifier )
            // ./scenariotestTemp/generated2/KM3.g:308:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_km3_package410);
            temp=identifier();

            checkFollows();
            state._fsp--;

            setProperty(ret, "name", temp);

            }

            _afterSeqEl();
            _beforeSeqEl();
            _afterSeqEl();
            _beforeSeqEl();
            match(input,LCURLY,FOLLOW_LCURLY_in_km3_package419); 
            _afterSeqEl();
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:308:222: ( ( (temp= km3_packageelement (temp= km3_packageelement )* )? ) )
            // ./scenariotestTemp/generated2/KM3.g:308:223: ( (temp= km3_packageelement (temp= km3_packageelement )* )? )
            {
            // ./scenariotestTemp/generated2/KM3.g:308:223: ( (temp= km3_packageelement (temp= km3_packageelement )* )? )
            // ./scenariotestTemp/generated2/KM3.g:308:224: (temp= km3_packageelement (temp= km3_packageelement )* )?
            {
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:308:241: (temp= km3_packageelement (temp= km3_packageelement )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=42 && LA7_0<=45)||LA7_0==53) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ./scenariotestTemp/generated2/KM3.g:308:243: temp= km3_packageelement (temp= km3_packageelement )*
                    {
                    pushFollow(FOLLOW_km3_packageelement_in_km3_package430);
                    temp=km3_packageelement();

                    checkFollows();
                    state._fsp--;

                    setProperty(ret, "contents", temp);
                    // ./scenariotestTemp/generated2/KM3.g:308:305: (temp= km3_packageelement )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=42 && LA6_0<=45)||LA6_0==53) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/KM3.g:308:307: temp= km3_packageelement
                    	    {
                    	    pushFollow(FOLLOW_km3_packageelement_in_km3_package438);
                    	    temp=km3_packageelement();

                    	    checkFollows();
                    	    state._fsp--;

                    	    setProperty(ret, "contents", temp);

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            _afterSeqEl();

            }


            }

            _afterSeqEl();
            _beforeSeqEl();
            match(input,RCURLY,FOLLOW_RCURLY_in_km3_package453); 
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
    // $ANTLR end "km3_package"


    // $ANTLR start "km3_datatype_abstractContents"
    // ./scenariotestTemp/generated2/KM3.g:316:1: km3_datatype_abstractContents returns [Object ret2] : ( 'datatype' (temp= identifier ) SEMI ) ;
    public final Object km3_datatype_abstractContents() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("KM3","DataType");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/KM3.g:321:3: ( ( 'datatype' (temp= identifier ) SEMI ) )
            // ./scenariotestTemp/generated2/KM3.g:322:3: ( 'datatype' (temp= identifier ) SEMI )
            {
            // ./scenariotestTemp/generated2/KM3.g:322:3: ( 'datatype' (temp= identifier ) SEMI )
            // ./scenariotestTemp/generated2/KM3.g:322:4: 'datatype' (temp= identifier ) SEMI
            {
            _beforeSeqEl();
            match(input,43,FOLLOW_43_in_km3_datatype_abstractContents494); 
            _afterSeqEl();
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:322:64: (temp= identifier )
            // ./scenariotestTemp/generated2/KM3.g:322:66: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_km3_datatype_abstractContents501);
            temp=identifier();

            checkFollows();
            state._fsp--;

            setProperty(ret, "name", temp);

            }

            _afterSeqEl();
            _beforeSeqEl();
            match(input,SEMI,FOLLOW_SEMI_in_km3_datatype_abstractContents508); 
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
    // $ANTLR end "km3_datatype_abstractContents"


    // $ANTLR start "km3_datatype"
    // ./scenariotestTemp/generated2/KM3.g:330:1: km3_datatype returns [Object ret2] : (ret= km3_enumeration | ret= km3_datatype_abstractContents ) ;
    public final Object km3_datatype() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/KM3.g:331:3: ( (ret= km3_enumeration | ret= km3_datatype_abstractContents ) )
            // ./scenariotestTemp/generated2/KM3.g:332:3: (ret= km3_enumeration | ret= km3_datatype_abstractContents )
            {
            // ./scenariotestTemp/generated2/KM3.g:332:3: (ret= km3_enumeration | ret= km3_datatype_abstractContents )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==53) ) {
                alt8=1;
            }
            else if ( (LA8_0==43) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ./scenariotestTemp/generated2/KM3.g:332:4: ret= km3_enumeration
                    {
                    pushFollow(FOLLOW_km3_enumeration_in_km3_datatype546);
                    ret=km3_enumeration();

                    checkFollows();
                    state._fsp--;


                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/KM3.g:333:5: ret= km3_datatype_abstractContents
                    {
                    pushFollow(FOLLOW_km3_datatype_abstractContents_in_km3_datatype554);
                    ret=km3_datatype_abstractContents();

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
    // $ANTLR end "km3_datatype"


    // $ANTLR start "km3_class"
    // ./scenariotestTemp/generated2/KM3.g:340:1: km3_class returns [Object ret2] : ( ( ( 'abstract' ) | ) 'class' (temp= identifier ) ( ( 'extends' (temp= identifier ( ( COMA ) temp= identifier )* )? ) | ) LCURLY ( ( (temp= km3_structuralfeature (temp= km3_structuralfeature )* )? ) ) RCURLY ) ;
    public final Object km3_class() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("KM3","Class");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/KM3.g:345:3: ( ( ( ( 'abstract' ) | ) 'class' (temp= identifier ) ( ( 'extends' (temp= identifier ( ( COMA ) temp= identifier )* )? ) | ) LCURLY ( ( (temp= km3_structuralfeature (temp= km3_structuralfeature )* )? ) ) RCURLY ) )
            // ./scenariotestTemp/generated2/KM3.g:346:3: ( ( ( 'abstract' ) | ) 'class' (temp= identifier ) ( ( 'extends' (temp= identifier ( ( COMA ) temp= identifier )* )? ) | ) LCURLY ( ( (temp= km3_structuralfeature (temp= km3_structuralfeature )* )? ) ) RCURLY )
            {
            // ./scenariotestTemp/generated2/KM3.g:346:3: ( ( ( 'abstract' ) | ) 'class' (temp= identifier ) ( ( 'extends' (temp= identifier ( ( COMA ) temp= identifier )* )? ) | ) LCURLY ( ( (temp= km3_structuralfeature (temp= km3_structuralfeature )* )? ) ) RCURLY )
            // ./scenariotestTemp/generated2/KM3.g:346:4: ( ( 'abstract' ) | ) 'class' (temp= identifier ) ( ( 'extends' (temp= identifier ( ( COMA ) temp= identifier )* )? ) | ) LCURLY ( ( (temp= km3_structuralfeature (temp= km3_structuralfeature )* )? ) ) RCURLY
            {
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:346:22: ( ( 'abstract' ) | )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==44) ) {
                alt9=1;
            }
            else if ( (LA9_0==45) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ./scenariotestTemp/generated2/KM3.g:346:23: ( 'abstract' )
                    {
                    _enterAlt(0);
                    // ./scenariotestTemp/generated2/KM3.g:346:39: ( 'abstract' )
                    // ./scenariotestTemp/generated2/KM3.g:346:40: 'abstract'
                    {
                    _beforeSeqEl();
                    match(input,44,FOLLOW_44_in_km3_class590); 
                    _afterSeqEl();

                    }

                    setProperty(ret, "isAbstract", java.lang.Boolean.TRUE);
                    _exitAlt();

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/KM3.g:346:158: 
                    {
                    _enterAlt(1);
                    setProperty(ret, "isAbstract", java.lang.Boolean.FALSE);
                    _exitAlt();

                    }
                    break;

            }

            _afterSeqEl();
            _beforeSeqEl();
            match(input,45,FOLLOW_45_in_km3_class608); 
            _afterSeqEl();
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:347:74: (temp= identifier )
            // ./scenariotestTemp/generated2/KM3.g:347:76: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_km3_class615);
            temp=identifier();

            checkFollows();
            state._fsp--;

            setProperty(ret, "name", temp);

            }

            _afterSeqEl();
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:347:160: ( ( 'extends' (temp= identifier ( ( COMA ) temp= identifier )* )? ) | )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==46) ) {
                alt12=1;
            }
            else if ( (LA12_0==LCURLY) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ./scenariotestTemp/generated2/KM3.g:347:161: ( 'extends' (temp= identifier ( ( COMA ) temp= identifier )* )? )
                    {
                    _enterAlt(0);
                    // ./scenariotestTemp/generated2/KM3.g:347:177: ( 'extends' (temp= identifier ( ( COMA ) temp= identifier )* )? )
                    // ./scenariotestTemp/generated2/KM3.g:347:178: 'extends' (temp= identifier ( ( COMA ) temp= identifier )* )?
                    {
                    _beforeSeqEl();
                    match(input,46,FOLLOW_46_in_km3_class627); 
                    _afterSeqEl();
                    _beforeSeqEl();
                    // ./scenariotestTemp/generated2/KM3.g:347:237: (temp= identifier ( ( COMA ) temp= identifier )* )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==NAME) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ./scenariotestTemp/generated2/KM3.g:347:239: temp= identifier ( ( COMA ) temp= identifier )*
                            {
                            pushFollow(FOLLOW_identifier_in_km3_class634);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;

                            setRef(ret, "supertypes", list("KM3","Class"), "name", temp, null, "never", null, false, null);
                            // ./scenariotestTemp/generated2/KM3.g:347:353: ( ( COMA ) temp= identifier )*
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);

                                if ( (LA10_0==COMA) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
                            	case 1 :
                            	    // ./scenariotestTemp/generated2/KM3.g:347:354: ( COMA ) temp= identifier
                            	    {
                            	    _enterSepSeq();
                            	    // ./scenariotestTemp/generated2/KM3.g:347:371: ( COMA )
                            	    // ./scenariotestTemp/generated2/KM3.g:347:372: COMA
                            	    {
                            	    _beforeSeqEl();
                            	    match(input,COMA,FOLLOW_COMA_in_km3_class643); 
                            	    _afterSeqEl();
                            	    _beforeSeqEl();
                            	    _afterSeqEl();

                            	    }

                            	    _exitSepSeq();
                            	    pushFollow(FOLLOW_identifier_in_km3_class653);
                            	    temp=identifier();

                            	    checkFollows();
                            	    state._fsp--;

                            	    setRef(ret, "supertypes", list("KM3","Class"), "name", temp, null, "never", null, false, null);

                            	    }
                            	    break;

                            	default :
                            	    break loop10;
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
                    // ./scenariotestTemp/generated2/KM3.g:347:615: 
                    {
                    _enterAlt(1);
                    _exitAlt();

                    }
                    break;

            }

            _afterSeqEl();
            _beforeSeqEl();
            match(input,LCURLY,FOLLOW_LCURLY_in_km3_class678); 
            _afterSeqEl();
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:348:75: ( ( (temp= km3_structuralfeature (temp= km3_structuralfeature )* )? ) )
            // ./scenariotestTemp/generated2/KM3.g:348:76: ( (temp= km3_structuralfeature (temp= km3_structuralfeature )* )? )
            {
            // ./scenariotestTemp/generated2/KM3.g:348:76: ( (temp= km3_structuralfeature (temp= km3_structuralfeature )* )? )
            // ./scenariotestTemp/generated2/KM3.g:348:77: (temp= km3_structuralfeature (temp= km3_structuralfeature )* )?
            {
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:348:94: (temp= km3_structuralfeature (temp= km3_structuralfeature )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==47||(LA14_0>=51 && LA14_0<=52)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ./scenariotestTemp/generated2/KM3.g:348:96: temp= km3_structuralfeature (temp= km3_structuralfeature )*
                    {
                    pushFollow(FOLLOW_km3_structuralfeature_in_km3_class689);
                    temp=km3_structuralfeature();

                    checkFollows();
                    state._fsp--;

                    setProperty(ret, "structuralFeatures", temp);
                    // ./scenariotestTemp/generated2/KM3.g:348:171: (temp= km3_structuralfeature )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==47||(LA13_0>=51 && LA13_0<=52)) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/KM3.g:348:173: temp= km3_structuralfeature
                    	    {
                    	    pushFollow(FOLLOW_km3_structuralfeature_in_km3_class697);
                    	    temp=km3_structuralfeature();

                    	    checkFollows();
                    	    state._fsp--;

                    	    setProperty(ret, "structuralFeatures", temp);

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            _afterSeqEl();

            }


            }

            _afterSeqEl();
            _beforeSeqEl();
            match(input,RCURLY,FOLLOW_RCURLY_in_km3_class712); 
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
    // $ANTLR end "km3_class"


    // $ANTLR start "km3_structuralfeature"
    // ./scenariotestTemp/generated2/KM3.g:356:1: km3_structuralfeature returns [Object ret2] : (ret= km3_reference | ret= km3_attribute ) ;
    public final Object km3_structuralfeature() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/KM3.g:357:3: ( (ret= km3_reference | ret= km3_attribute ) )
            // ./scenariotestTemp/generated2/KM3.g:358:3: (ret= km3_reference | ret= km3_attribute )
            {
            // ./scenariotestTemp/generated2/KM3.g:358:3: (ret= km3_reference | ret= km3_attribute )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==47) ) {
                alt15=1;
            }
            else if ( ((LA15_0>=51 && LA15_0<=52)) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ./scenariotestTemp/generated2/KM3.g:358:4: ret= km3_reference
                    {
                    pushFollow(FOLLOW_km3_reference_in_km3_structuralfeature750);
                    ret=km3_reference();

                    checkFollows();
                    state._fsp--;


                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/KM3.g:359:5: ret= km3_attribute
                    {
                    pushFollow(FOLLOW_km3_attribute_in_km3_structuralfeature758);
                    ret=km3_attribute();

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
    // $ANTLR end "km3_structuralfeature"


    // $ANTLR start "km3_reference"
    // ./scenariotestTemp/generated2/KM3.g:366:1: km3_reference returns [Object ret2] : ( 'reference' (temp= identifier ) multiplicity[ret] ( ( 'ordered' ) | ) ( ( 'container' ) | ) COLON (temp= identifier ) ( ( 'oppositeOf' (temp= identifier ) ) | ) SEMI ) ;
    public final Object km3_reference() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("KM3","Reference");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/KM3.g:371:3: ( ( 'reference' (temp= identifier ) multiplicity[ret] ( ( 'ordered' ) | ) ( ( 'container' ) | ) COLON (temp= identifier ) ( ( 'oppositeOf' (temp= identifier ) ) | ) SEMI ) )
            // ./scenariotestTemp/generated2/KM3.g:372:3: ( 'reference' (temp= identifier ) multiplicity[ret] ( ( 'ordered' ) | ) ( ( 'container' ) | ) COLON (temp= identifier ) ( ( 'oppositeOf' (temp= identifier ) ) | ) SEMI )
            {
            // ./scenariotestTemp/generated2/KM3.g:372:3: ( 'reference' (temp= identifier ) multiplicity[ret] ( ( 'ordered' ) | ) ( ( 'container' ) | ) COLON (temp= identifier ) ( ( 'oppositeOf' (temp= identifier ) ) | ) SEMI )
            // ./scenariotestTemp/generated2/KM3.g:372:4: 'reference' (temp= identifier ) multiplicity[ret] ( ( 'ordered' ) | ) ( ( 'container' ) | ) COLON (temp= identifier ) ( ( 'oppositeOf' (temp= identifier ) ) | ) SEMI
            {
            _beforeSeqEl();
            match(input,47,FOLLOW_47_in_km3_reference788); 
            _afterSeqEl();
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:372:65: (temp= identifier )
            // ./scenariotestTemp/generated2/KM3.g:372:67: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_km3_reference795);
            temp=identifier();

            checkFollows();
            state._fsp--;

            setProperty(ret, "name", temp);

            }

            _afterSeqEl();
            _beforeSeqEl();
            pushFollow(FOLLOW_multiplicity_in_km3_reference801);
            multiplicity(ret);

            checkFollows();
            state._fsp--;

            _afterSeqEl();
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:372:201: ( ( 'ordered' ) | )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==48) ) {
                alt16=1;
            }
            else if ( (LA16_0==COLON||LA16_0==49) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ./scenariotestTemp/generated2/KM3.g:372:202: ( 'ordered' )
                    {
                    _enterAlt(0);
                    // ./scenariotestTemp/generated2/KM3.g:372:218: ( 'ordered' )
                    // ./scenariotestTemp/generated2/KM3.g:372:219: 'ordered'
                    {
                    _beforeSeqEl();
                    match(input,48,FOLLOW_48_in_km3_reference811); 
                    _afterSeqEl();

                    }

                    setProperty(ret, "isOrdered", java.lang.Boolean.TRUE);
                    _exitAlt();

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/KM3.g:372:335: 
                    {
                    _enterAlt(1);
                    setProperty(ret, "isOrdered", java.lang.Boolean.FALSE);
                    _exitAlt();

                    }
                    break;

            }

            _afterSeqEl();
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:373:35: ( ( 'container' ) | )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==49) ) {
                alt17=1;
            }
            else if ( (LA17_0==COLON) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ./scenariotestTemp/generated2/KM3.g:373:36: ( 'container' )
                    {
                    _enterAlt(0);
                    // ./scenariotestTemp/generated2/KM3.g:373:52: ( 'container' )
                    // ./scenariotestTemp/generated2/KM3.g:373:53: 'container'
                    {
                    _beforeSeqEl();
                    match(input,49,FOLLOW_49_in_km3_reference835); 
                    _afterSeqEl();

                    }

                    setProperty(ret, "isContainer", java.lang.Boolean.TRUE);
                    _exitAlt();

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/KM3.g:373:173: 
                    {
                    _enterAlt(1);
                    setProperty(ret, "isContainer", java.lang.Boolean.FALSE);
                    _exitAlt();

                    }
                    break;

            }

            _afterSeqEl();
            _beforeSeqEl();
            match(input,COLON,FOLLOW_COLON_in_km3_reference854); 
            _afterSeqEl();
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:374:74: (temp= identifier )
            // ./scenariotestTemp/generated2/KM3.g:374:76: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_km3_reference862);
            temp=identifier();

            checkFollows();
            state._fsp--;

            setRef(ret, "type", list("KM3","Classifier"), "name", temp, null, "never", null, false, null);

            }

            _afterSeqEl();
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:374:223: ( ( 'oppositeOf' (temp= identifier ) ) | )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==50) ) {
                alt18=1;
            }
            else if ( (LA18_0==SEMI) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ./scenariotestTemp/generated2/KM3.g:374:224: ( 'oppositeOf' (temp= identifier ) )
                    {
                    _enterAlt(0);
                    // ./scenariotestTemp/generated2/KM3.g:374:240: ( 'oppositeOf' (temp= identifier ) )
                    // ./scenariotestTemp/generated2/KM3.g:374:241: 'oppositeOf' (temp= identifier )
                    {
                    _beforeSeqEl();
                    match(input,50,FOLLOW_50_in_km3_reference874); 
                    _afterSeqEl();
                    _beforeSeqEl();
                    // ./scenariotestTemp/generated2/KM3.g:374:303: (temp= identifier )
                    // ./scenariotestTemp/generated2/KM3.g:374:305: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_km3_reference881);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;

                    setRef(ret, "opposite", list("KM3","Reference"), "name", temp, "type", "never", null, false, null);

                    }

                    _afterSeqEl();

                    }

                    _exitAlt();

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/KM3.g:374:457: 
                    {
                    _enterAlt(1);
                    _exitAlt();

                    }
                    break;

            }

            _afterSeqEl();
            _beforeSeqEl();
            match(input,SEMI,FOLLOW_SEMI_in_km3_reference901); 
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
    // $ANTLR end "km3_reference"


    // $ANTLR start "km3_attribute"
    // ./scenariotestTemp/generated2/KM3.g:383:1: km3_attribute returns [Object ret2] : ( ( ( 'unique' ) | ) 'attribute' (temp= identifier ) multiplicity[ret] ( ( 'ordered' ) | ) COLON (temp= identifier ) SEMI ) ;
    public final Object km3_attribute() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("KM3","Attribute");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/KM3.g:388:3: ( ( ( ( 'unique' ) | ) 'attribute' (temp= identifier ) multiplicity[ret] ( ( 'ordered' ) | ) COLON (temp= identifier ) SEMI ) )
            // ./scenariotestTemp/generated2/KM3.g:389:3: ( ( ( 'unique' ) | ) 'attribute' (temp= identifier ) multiplicity[ret] ( ( 'ordered' ) | ) COLON (temp= identifier ) SEMI )
            {
            // ./scenariotestTemp/generated2/KM3.g:389:3: ( ( ( 'unique' ) | ) 'attribute' (temp= identifier ) multiplicity[ret] ( ( 'ordered' ) | ) COLON (temp= identifier ) SEMI )
            // ./scenariotestTemp/generated2/KM3.g:389:4: ( ( 'unique' ) | ) 'attribute' (temp= identifier ) multiplicity[ret] ( ( 'ordered' ) | ) COLON (temp= identifier ) SEMI
            {
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:389:22: ( ( 'unique' ) | )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==51) ) {
                alt19=1;
            }
            else if ( (LA19_0==52) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ./scenariotestTemp/generated2/KM3.g:389:23: ( 'unique' )
                    {
                    _enterAlt(0);
                    // ./scenariotestTemp/generated2/KM3.g:389:39: ( 'unique' )
                    // ./scenariotestTemp/generated2/KM3.g:389:40: 'unique'
                    {
                    _beforeSeqEl();
                    match(input,51,FOLLOW_51_in_km3_attribute948); 
                    _afterSeqEl();

                    }

                    setProperty(ret, "isUnique", java.lang.Boolean.TRUE);
                    _exitAlt();

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/KM3.g:389:154: 
                    {
                    _enterAlt(1);
                    setProperty(ret, "isUnique", java.lang.Boolean.FALSE);
                    _exitAlt();

                    }
                    break;

            }

            _afterSeqEl();
            _beforeSeqEl();
            match(input,52,FOLLOW_52_in_km3_attribute966); 
            _afterSeqEl();
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:390:78: (temp= identifier )
            // ./scenariotestTemp/generated2/KM3.g:390:80: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_km3_attribute973);
            temp=identifier();

            checkFollows();
            state._fsp--;

            setProperty(ret, "name", temp);

            }

            _afterSeqEl();
            _beforeSeqEl();
            pushFollow(FOLLOW_multiplicity_in_km3_attribute979);
            multiplicity(ret);

            checkFollows();
            state._fsp--;

            _afterSeqEl();
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:390:214: ( ( 'ordered' ) | )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==48) ) {
                alt20=1;
            }
            else if ( (LA20_0==COLON) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ./scenariotestTemp/generated2/KM3.g:390:215: ( 'ordered' )
                    {
                    _enterAlt(0);
                    // ./scenariotestTemp/generated2/KM3.g:390:231: ( 'ordered' )
                    // ./scenariotestTemp/generated2/KM3.g:390:232: 'ordered'
                    {
                    _beforeSeqEl();
                    match(input,48,FOLLOW_48_in_km3_attribute989); 
                    _afterSeqEl();

                    }

                    setProperty(ret, "isOrdered", java.lang.Boolean.TRUE);
                    _exitAlt();

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/KM3.g:390:348: 
                    {
                    _enterAlt(1);
                    setProperty(ret, "isOrdered", java.lang.Boolean.FALSE);
                    _exitAlt();

                    }
                    break;

            }

            _afterSeqEl();
            _beforeSeqEl();
            match(input,COLON,FOLLOW_COLON_in_km3_attribute1008); 
            _afterSeqEl();
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:391:74: (temp= identifier )
            // ./scenariotestTemp/generated2/KM3.g:391:76: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_km3_attribute1016);
            temp=identifier();

            checkFollows();
            state._fsp--;

            setRef(ret, "type", list("KM3","Classifier"), "name", temp, null, "never", null, false, null);

            }

            _afterSeqEl();
            _beforeSeqEl();
            match(input,SEMI,FOLLOW_SEMI_in_km3_attribute1023); 
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
    // $ANTLR end "km3_attribute"


    // $ANTLR start "km3_enumeration"
    // ./scenariotestTemp/generated2/KM3.g:399:1: km3_enumeration returns [Object ret2] : ( 'enumeration' (temp= identifier ) LCURLY ( ( (temp= km3_enumliteral (temp= km3_enumliteral )* )? ) ) RCURLY ) ;
    public final Object km3_enumeration() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("KM3","Enumeration");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/KM3.g:404:3: ( ( 'enumeration' (temp= identifier ) LCURLY ( ( (temp= km3_enumliteral (temp= km3_enumliteral )* )? ) ) RCURLY ) )
            // ./scenariotestTemp/generated2/KM3.g:405:3: ( 'enumeration' (temp= identifier ) LCURLY ( ( (temp= km3_enumliteral (temp= km3_enumliteral )* )? ) ) RCURLY )
            {
            // ./scenariotestTemp/generated2/KM3.g:405:3: ( 'enumeration' (temp= identifier ) LCURLY ( ( (temp= km3_enumliteral (temp= km3_enumliteral )* )? ) ) RCURLY )
            // ./scenariotestTemp/generated2/KM3.g:405:4: 'enumeration' (temp= identifier ) LCURLY ( ( (temp= km3_enumliteral (temp= km3_enumliteral )* )? ) ) RCURLY
            {
            _beforeSeqEl();
            match(input,53,FOLLOW_53_in_km3_enumeration1064); 
            _afterSeqEl();
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:405:67: (temp= identifier )
            // ./scenariotestTemp/generated2/KM3.g:405:69: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_km3_enumeration1071);
            temp=identifier();

            checkFollows();
            state._fsp--;

            setProperty(ret, "name", temp);

            }

            _afterSeqEl();
            _beforeSeqEl();
            match(input,LCURLY,FOLLOW_LCURLY_in_km3_enumeration1078); 
            _afterSeqEl();
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:405:193: ( ( (temp= km3_enumliteral (temp= km3_enumliteral )* )? ) )
            // ./scenariotestTemp/generated2/KM3.g:405:194: ( (temp= km3_enumliteral (temp= km3_enumliteral )* )? )
            {
            // ./scenariotestTemp/generated2/KM3.g:405:194: ( (temp= km3_enumliteral (temp= km3_enumliteral )* )? )
            // ./scenariotestTemp/generated2/KM3.g:405:195: (temp= km3_enumliteral (temp= km3_enumliteral )* )?
            {
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:405:212: (temp= km3_enumliteral (temp= km3_enumliteral )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==54) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ./scenariotestTemp/generated2/KM3.g:405:214: temp= km3_enumliteral (temp= km3_enumliteral )*
                    {
                    pushFollow(FOLLOW_km3_enumliteral_in_km3_enumeration1089);
                    temp=km3_enumliteral();

                    checkFollows();
                    state._fsp--;

                    setProperty(ret, "literals", temp);
                    // ./scenariotestTemp/generated2/KM3.g:405:273: (temp= km3_enumliteral )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==54) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/KM3.g:405:275: temp= km3_enumliteral
                    	    {
                    	    pushFollow(FOLLOW_km3_enumliteral_in_km3_enumeration1097);
                    	    temp=km3_enumliteral();

                    	    checkFollows();
                    	    state._fsp--;

                    	    setProperty(ret, "literals", temp);

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }
                    break;

            }

            _afterSeqEl();

            }


            }

            _afterSeqEl();
            _beforeSeqEl();
            match(input,RCURLY,FOLLOW_RCURLY_in_km3_enumeration1112); 
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
    // $ANTLR end "km3_enumeration"


    // $ANTLR start "km3_enumliteral"
    // ./scenariotestTemp/generated2/KM3.g:413:1: km3_enumliteral returns [Object ret2] : ( 'literal' (temp= identifier ) SEMI ) ;
    public final Object km3_enumliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("KM3","EnumLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/KM3.g:418:3: ( ( 'literal' (temp= identifier ) SEMI ) )
            // ./scenariotestTemp/generated2/KM3.g:419:3: ( 'literal' (temp= identifier ) SEMI )
            {
            // ./scenariotestTemp/generated2/KM3.g:419:3: ( 'literal' (temp= identifier ) SEMI )
            // ./scenariotestTemp/generated2/KM3.g:419:4: 'literal' (temp= identifier ) SEMI
            {
            _beforeSeqEl();
            match(input,54,FOLLOW_54_in_km3_enumliteral1153); 
            _afterSeqEl();
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:419:63: (temp= identifier )
            // ./scenariotestTemp/generated2/KM3.g:419:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_km3_enumliteral1160);
            temp=identifier();

            checkFollows();
            state._fsp--;

            setProperty(ret, "name", temp);

            }

            _afterSeqEl();
            _beforeSeqEl();
            match(input,SEMI,FOLLOW_SEMI_in_km3_enumliteral1167); 
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
    // $ANTLR end "km3_enumliteral"


    // $ANTLR start "multiplicity"
    // ./scenariotestTemp/generated2/KM3.g:427:1: multiplicity[Object ret] : ( ( () | ( ( ( LSQUARE STAR RSQUARE ) | ( ( ( LSQUARE (temp= integerSymbol ) MINUS STAR RSQUARE ) | ( LSQUARE (temp= integerSymbol ) MINUS (temp= integerSymbol ) RSQUARE ) ) ) ) ) ) ) ;
    public final void multiplicity(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // ./scenariotestTemp/generated2/KM3.g:428:3: ( ( ( () | ( ( ( LSQUARE STAR RSQUARE ) | ( ( ( LSQUARE (temp= integerSymbol ) MINUS STAR RSQUARE ) | ( LSQUARE (temp= integerSymbol ) MINUS (temp= integerSymbol ) RSQUARE ) ) ) ) ) ) ) )
            // ./scenariotestTemp/generated2/KM3.g:429:3: ( ( () | ( ( ( LSQUARE STAR RSQUARE ) | ( ( ( LSQUARE (temp= integerSymbol ) MINUS STAR RSQUARE ) | ( LSQUARE (temp= integerSymbol ) MINUS (temp= integerSymbol ) RSQUARE ) ) ) ) ) ) )
            {
            // ./scenariotestTemp/generated2/KM3.g:429:3: ( ( () | ( ( ( LSQUARE STAR RSQUARE ) | ( ( ( LSQUARE (temp= integerSymbol ) MINUS STAR RSQUARE ) | ( LSQUARE (temp= integerSymbol ) MINUS (temp= integerSymbol ) RSQUARE ) ) ) ) ) ) )
            // ./scenariotestTemp/generated2/KM3.g:429:4: ( () | ( ( ( LSQUARE STAR RSQUARE ) | ( ( ( LSQUARE (temp= integerSymbol ) MINUS STAR RSQUARE ) | ( LSQUARE (temp= integerSymbol ) MINUS (temp= integerSymbol ) RSQUARE ) ) ) ) ) )
            {
            _beforeSeqEl();
            // ./scenariotestTemp/generated2/KM3.g:429:22: ( () | ( ( ( LSQUARE STAR RSQUARE ) | ( ( ( LSQUARE (temp= integerSymbol ) MINUS STAR RSQUARE ) | ( LSQUARE (temp= integerSymbol ) MINUS (temp= integerSymbol ) RSQUARE ) ) ) ) ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==COLON||(LA25_0>=48 && LA25_0<=49)) ) {
                alt25=1;
            }
            else if ( (LA25_0==LSQUARE) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ./scenariotestTemp/generated2/KM3.g:429:23: ()
                    {
                    _enterAlt(0);
                    // ./scenariotestTemp/generated2/KM3.g:429:39: ()
                    // ./scenariotestTemp/generated2/KM3.g:429:40: 
                    {
                    }

                    setProperty(ret, "lower", new Integer(1));setProperty(ret, "upper", new Integer(1));
                    _exitAlt();

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/KM3.g:429:144: ( ( ( LSQUARE STAR RSQUARE ) | ( ( ( LSQUARE (temp= integerSymbol ) MINUS STAR RSQUARE ) | ( LSQUARE (temp= integerSymbol ) MINUS (temp= integerSymbol ) RSQUARE ) ) ) ) )
                    {
                    _enterAlt(1);
                    // ./scenariotestTemp/generated2/KM3.g:429:160: ( ( ( LSQUARE STAR RSQUARE ) | ( ( ( LSQUARE (temp= integerSymbol ) MINUS STAR RSQUARE ) | ( LSQUARE (temp= integerSymbol ) MINUS (temp= integerSymbol ) RSQUARE ) ) ) ) )
                    // ./scenariotestTemp/generated2/KM3.g:429:161: ( ( LSQUARE STAR RSQUARE ) | ( ( ( LSQUARE (temp= integerSymbol ) MINUS STAR RSQUARE ) | ( LSQUARE (temp= integerSymbol ) MINUS (temp= integerSymbol ) RSQUARE ) ) ) )
                    {
                    _beforeSeqEl();
                    // ./scenariotestTemp/generated2/KM3.g:429:179: ( ( LSQUARE STAR RSQUARE ) | ( ( ( LSQUARE (temp= integerSymbol ) MINUS STAR RSQUARE ) | ( LSQUARE (temp= integerSymbol ) MINUS (temp= integerSymbol ) RSQUARE ) ) ) )
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==LSQUARE) ) {
                        int LA24_1 = input.LA(2);

                        if ( (LA24_1==INT) ) {
                            alt24=2;
                        }
                        else if ( (LA24_1==STAR) ) {
                            alt24=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 24, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 0, input);

                        throw nvae;
                    }
                    switch (alt24) {
                        case 1 :
                            // ./scenariotestTemp/generated2/KM3.g:429:180: ( LSQUARE STAR RSQUARE )
                            {
                            _enterAlt(0);
                            // ./scenariotestTemp/generated2/KM3.g:429:196: ( LSQUARE STAR RSQUARE )
                            // ./scenariotestTemp/generated2/KM3.g:429:197: LSQUARE STAR RSQUARE
                            {
                            _beforeSeqEl();
                            match(input,LSQUARE,FOLLOW_LSQUARE_in_multiplicity1225); 
                            _afterSeqEl();
                            _beforeSeqEl();
                            match(input,STAR,FOLLOW_STAR_in_multiplicity1230); 
                            _afterSeqEl();
                            _beforeSeqEl();
                            match(input,RSQUARE,FOLLOW_RSQUARE_in_multiplicity1235); 
                            _afterSeqEl();

                            }

                            setProperty(ret, "lower", new Integer(0));setProperty(ret, "upper", new Integer(-1));
                            _exitAlt();

                            }
                            break;
                        case 2 :
                            // ./scenariotestTemp/generated2/KM3.g:429:425: ( ( ( LSQUARE (temp= integerSymbol ) MINUS STAR RSQUARE ) | ( LSQUARE (temp= integerSymbol ) MINUS (temp= integerSymbol ) RSQUARE ) ) )
                            {
                            _enterAlt(1);
                            // ./scenariotestTemp/generated2/KM3.g:429:441: ( ( ( LSQUARE (temp= integerSymbol ) MINUS STAR RSQUARE ) | ( LSQUARE (temp= integerSymbol ) MINUS (temp= integerSymbol ) RSQUARE ) ) )
                            // ./scenariotestTemp/generated2/KM3.g:429:442: ( ( LSQUARE (temp= integerSymbol ) MINUS STAR RSQUARE ) | ( LSQUARE (temp= integerSymbol ) MINUS (temp= integerSymbol ) RSQUARE ) )
                            {
                            _beforeSeqEl();
                            // ./scenariotestTemp/generated2/KM3.g:429:460: ( ( LSQUARE (temp= integerSymbol ) MINUS STAR RSQUARE ) | ( LSQUARE (temp= integerSymbol ) MINUS (temp= integerSymbol ) RSQUARE ) )
                            int alt23=2;
                            int LA23_0 = input.LA(1);

                            if ( (LA23_0==LSQUARE) ) {
                                int LA23_1 = input.LA(2);

                                if ( (LA23_1==INT) ) {
                                    int LA23_2 = input.LA(3);

                                    if ( (LA23_2==MINUS) ) {
                                        int LA23_3 = input.LA(4);

                                        if ( (LA23_3==INT) ) {
                                            alt23=2;
                                        }
                                        else if ( (LA23_3==STAR) ) {
                                            alt23=1;
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 23, 3, input);

                                            throw nvae;
                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 23, 2, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 23, 1, input);

                                    throw nvae;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 23, 0, input);

                                throw nvae;
                            }
                            switch (alt23) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/KM3.g:429:461: ( LSQUARE (temp= integerSymbol ) MINUS STAR RSQUARE )
                                    {
                                    _enterAlt(0);
                                    // ./scenariotestTemp/generated2/KM3.g:429:477: ( LSQUARE (temp= integerSymbol ) MINUS STAR RSQUARE )
                                    // ./scenariotestTemp/generated2/KM3.g:429:478: LSQUARE (temp= integerSymbol ) MINUS STAR RSQUARE
                                    {
                                    _beforeSeqEl();
                                    match(input,LSQUARE,FOLLOW_LSQUARE_in_multiplicity1256); 
                                    _afterSeqEl();
                                    _beforeSeqEl();
                                    // ./scenariotestTemp/generated2/KM3.g:429:537: (temp= integerSymbol )
                                    // ./scenariotestTemp/generated2/KM3.g:429:539: temp= integerSymbol
                                    {
                                    pushFollow(FOLLOW_integerSymbol_in_multiplicity1264);
                                    temp=integerSymbol();

                                    checkFollows();
                                    state._fsp--;

                                    setProperty(ret, "lower", temp);

                                    }

                                    _afterSeqEl();
                                    _beforeSeqEl();
                                    match(input,MINUS,FOLLOW_MINUS_in_multiplicity1271); 
                                    _afterSeqEl();
                                    _beforeSeqEl();
                                    match(input,STAR,FOLLOW_STAR_in_multiplicity1276); 
                                    _afterSeqEl();
                                    _beforeSeqEl();
                                    match(input,RSQUARE,FOLLOW_RSQUARE_in_multiplicity1281); 
                                    _afterSeqEl();

                                    }

                                    setProperty(ret, "upper", new Integer(-1));
                                    _exitAlt();

                                    }
                                    break;
                                case 2 :
                                    // ./scenariotestTemp/generated2/KM3.g:429:793: ( LSQUARE (temp= integerSymbol ) MINUS (temp= integerSymbol ) RSQUARE )
                                    {
                                    _enterAlt(1);
                                    // ./scenariotestTemp/generated2/KM3.g:429:809: ( LSQUARE (temp= integerSymbol ) MINUS (temp= integerSymbol ) RSQUARE )
                                    // ./scenariotestTemp/generated2/KM3.g:429:810: LSQUARE (temp= integerSymbol ) MINUS (temp= integerSymbol ) RSQUARE
                                    {
                                    _beforeSeqEl();
                                    match(input,LSQUARE,FOLLOW_LSQUARE_in_multiplicity1296); 
                                    _afterSeqEl();
                                    _beforeSeqEl();
                                    // ./scenariotestTemp/generated2/KM3.g:429:869: (temp= integerSymbol )
                                    // ./scenariotestTemp/generated2/KM3.g:429:871: temp= integerSymbol
                                    {
                                    pushFollow(FOLLOW_integerSymbol_in_multiplicity1304);
                                    temp=integerSymbol();

                                    checkFollows();
                                    state._fsp--;

                                    setProperty(ret, "lower", temp);

                                    }

                                    _afterSeqEl();
                                    _beforeSeqEl();
                                    match(input,MINUS,FOLLOW_MINUS_in_multiplicity1311); 
                                    _afterSeqEl();
                                    _beforeSeqEl();
                                    // ./scenariotestTemp/generated2/KM3.g:429:998: (temp= integerSymbol )
                                    // ./scenariotestTemp/generated2/KM3.g:429:1000: temp= integerSymbol
                                    {
                                    pushFollow(FOLLOW_integerSymbol_in_multiplicity1319);
                                    temp=integerSymbol();

                                    checkFollows();
                                    state._fsp--;

                                    setProperty(ret, "upper", temp);

                                    }

                                    _afterSeqEl();
                                    _beforeSeqEl();
                                    match(input,RSQUARE,FOLLOW_RSQUARE_in_multiplicity1326); 
                                    _afterSeqEl();

                                    }


                                    _exitAlt();

                                    }
                                    break;

                            }

                            _afterSeqEl();

                            }


                            _exitAlt();

                            }
                            break;

                    }

                    _afterSeqEl();

                    }


                    _exitAlt();

                    }
                    break;

            }

            _afterSeqEl();

            }


              

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "multiplicity"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\12\uffff";
    static final String DFA3_eofS =
        "\12\uffff";
    static final String DFA3_minS =
        "\1\52\11\uffff";
    static final String DFA3_maxS =
        "\1\66\11\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\2\uffff\1\3";
    static final String DFA3_specialS =
        "\12\uffff}>";
    static final String[] DFA3_transitionS = {
            "\4\1\1\uffff\1\6\3\uffff\2\6\1\1\1\11",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "272:3: (ret= km3_packageelement | ret= km3_structuralfeature | ret= km3_enumliteral )";
        }
    }
 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_km3_metamodel_in_main190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_km3_package_in_km3_metamodel231 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_km3_package_in_km3_metamodel239 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_km3_packageelement_in_km3_modelelement287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_km3_structuralfeature_in_km3_modelelement295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_km3_enumliteral_in_km3_modelelement303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_km3_classifier_in_km3_packageelement330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_km3_package_in_km3_packageelement338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_km3_datatype_in_km3_classifier365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_km3_class_in_km3_classifier373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_km3_package403 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_km3_package410 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_km3_package419 = new BitSet(new long[]{0x00203C0000000200L});
    public static final BitSet FOLLOW_km3_packageelement_in_km3_package430 = new BitSet(new long[]{0x00203C0000000200L});
    public static final BitSet FOLLOW_km3_packageelement_in_km3_package438 = new BitSet(new long[]{0x00203C0000000200L});
    public static final BitSet FOLLOW_RCURLY_in_km3_package453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_km3_datatype_abstractContents494 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_km3_datatype_abstractContents501 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_SEMI_in_km3_datatype_abstractContents508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_km3_enumeration_in_km3_datatype546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_km3_datatype_abstractContents_in_km3_datatype554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_km3_class590 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_km3_class608 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_km3_class615 = new BitSet(new long[]{0x0000400000000100L});
    public static final BitSet FOLLOW_46_in_km3_class627 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_identifier_in_km3_class634 = new BitSet(new long[]{0x0000000000000900L});
    public static final BitSet FOLLOW_COMA_in_km3_class643 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_km3_class653 = new BitSet(new long[]{0x0000000000000900L});
    public static final BitSet FOLLOW_LCURLY_in_km3_class678 = new BitSet(new long[]{0x0018800000000200L});
    public static final BitSet FOLLOW_km3_structuralfeature_in_km3_class689 = new BitSet(new long[]{0x0018800000000200L});
    public static final BitSet FOLLOW_km3_structuralfeature_in_km3_class697 = new BitSet(new long[]{0x0018800000000200L});
    public static final BitSet FOLLOW_RCURLY_in_km3_class712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_km3_reference_in_km3_structuralfeature750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_km3_attribute_in_km3_structuralfeature758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_km3_reference788 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_km3_reference795 = new BitSet(new long[]{0x0003000000003000L});
    public static final BitSet FOLLOW_multiplicity_in_km3_reference801 = new BitSet(new long[]{0x0003000000001000L});
    public static final BitSet FOLLOW_48_in_km3_reference811 = new BitSet(new long[]{0x0002000000001000L});
    public static final BitSet FOLLOW_49_in_km3_reference835 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COLON_in_km3_reference854 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_km3_reference862 = new BitSet(new long[]{0x0004000000000400L});
    public static final BitSet FOLLOW_50_in_km3_reference874 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_km3_reference881 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_SEMI_in_km3_reference901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_km3_attribute948 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_km3_attribute966 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_km3_attribute973 = new BitSet(new long[]{0x0001000000003000L});
    public static final BitSet FOLLOW_multiplicity_in_km3_attribute979 = new BitSet(new long[]{0x0001000000001000L});
    public static final BitSet FOLLOW_48_in_km3_attribute989 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COLON_in_km3_attribute1008 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_km3_attribute1016 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_SEMI_in_km3_attribute1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_km3_enumeration1064 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_km3_enumeration1071 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LCURLY_in_km3_enumeration1078 = new BitSet(new long[]{0x0040000000000200L});
    public static final BitSet FOLLOW_km3_enumliteral_in_km3_enumeration1089 = new BitSet(new long[]{0x0040000000000200L});
    public static final BitSet FOLLOW_km3_enumliteral_in_km3_enumeration1097 = new BitSet(new long[]{0x0040000000000200L});
    public static final BitSet FOLLOW_RCURLY_in_km3_enumeration1112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_km3_enumliteral1153 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_km3_enumliteral1160 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_SEMI_in_km3_enumliteral1167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_multiplicity1225 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STAR_in_multiplicity1230 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RSQUARE_in_multiplicity1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_multiplicity1256 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_multiplicity1264 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_MINUS_in_multiplicity1271 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STAR_in_multiplicity1276 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RSQUARE_in_multiplicity1281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_multiplicity1296 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_multiplicity1304 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_MINUS_in_multiplicity1311 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_multiplicity1319 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RSQUARE_in_multiplicity1326 = new BitSet(new long[]{0x0000000000000002L});

}