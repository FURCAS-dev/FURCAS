package org.eclipse.ocl.examples.xtext.essentialocl.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEssentialOCLLexer extends Lexer {
    public static final int T__42=42;
    public static final int T__28=28;
    public static final int T__57=57;
    public static final int T__23=23;
    public static final int T__51=51;
    public static final int T__47=47;
    public static final int T__69=69;
    public static final int T__50=50;
    public static final int T__21=21;
    public static final int RULE_ML_SINGLE_QUOTED_STRING=9;
    public static final int T__19=19;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__67=67;
    public static final int T__39=39;
    public static final int T__30=30;
    public static final int T__46=46;
    public static final int T__52=52;
    public static final int T__68=68;
    public static final int T__17=17;
    public static final int T__62=62;
    public static final int RULE_INT=7;
    public static final int T__27=27;
    public static final int T__24=24;
    public static final int T__49=49;
    public static final int RULE_SINGLE_QUOTED_STRING=4;
    public static final int T__61=61;
    public static final int RULE_DOUBLE_QUOTED_STRING=8;
    public static final int T__59=59;
    public static final int T__48=48;
    public static final int T__54=54;
    public static final int T__34=34;
    public static final int T__56=56;
    public static final int T__15=15;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int T__58=58;
    public static final int T__64=64;
    public static final int RULE_SIMPLE_ID=5;
    public static final int T__44=44;
    public static final int T__66=66;
    public static final int T__33=33;
    public static final int T__22=22;
    public static final int T__45=45;
    public static final int T__29=29;
    public static final int T__55=55;
    public static final int RULE_ESCAPED_ID=6;
    public static final int T__63=63;
    public static final int RULE_WS=13;
    public static final int T__43=43;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__37=37;
    public static final int RULE_DOCUMENTATION=10;
    public static final int T__26=26;
    public static final int RULE_ANY_OTHER=14;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=12;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int T__18=18;

    // delegates
    // delegators

    public InternalEssentialOCLLexer() {;} 
    public InternalEssentialOCLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalEssentialOCLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:11:7: ( 'e' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:11:9: 'e'
            {
            match('e'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:12:7: ( 'E' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:12:9: 'E'
            {
            match('E'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:13:7: ( '+' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:13:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:14:7: ( '-' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:14:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:15:7: ( 'not' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:15:9: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:16:7: ( '*' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:16:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:17:7: ( '/' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:17:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:18:7: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:18:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:19:7: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:19:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:20:7: ( '>=' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:20:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:21:7: ( '<=' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:21:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:22:7: ( '=' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:22:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:23:7: ( '<>' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:23:9: '<>'
            {
            match("<>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:24:7: ( 'and' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:24:9: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:25:7: ( 'or' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:25:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:26:7: ( 'xor' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:26:9: 'xor'
            {
            match("xor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:27:7: ( 'implies' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:27:9: 'implies'
            {
            match("implies"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:28:7: ( '.' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:28:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:29:7: ( '->' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:29:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:30:7: ( 'Tuple' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:30:9: 'Tuple'
            {
            match("Tuple"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:31:7: ( 'Boolean' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:31:9: 'Boolean'
            {
            match("Boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:32:7: ( 'Integer' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:32:9: 'Integer'
            {
            match("Integer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:33:7: ( 'Real' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:33:9: 'Real'
            {
            match("Real"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:34:7: ( 'String' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:34:9: 'String'
            {
            match("String"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:35:7: ( 'UnlimitedNatural' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:35:9: 'UnlimitedNatural'
            {
            match("UnlimitedNatural"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:36:7: ( 'OclAny' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:36:9: 'OclAny'
            {
            match("OclAny"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:37:7: ( 'OclInvalid' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:37:9: 'OclInvalid'
            {
            match("OclInvalid"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:38:7: ( 'OclVoid' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:38:9: 'OclVoid'
            {
            match("OclVoid"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:39:7: ( 'Set' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:39:9: 'Set'
            {
            match("Set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:40:7: ( 'Bag' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:40:9: 'Bag'
            {
            match("Bag"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:41:7: ( 'Sequence' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:41:9: 'Sequence'
            {
            match("Sequence"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:42:7: ( 'Collection' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:42:9: 'Collection'
            {
            match("Collection"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:43:7: ( 'OrderedSet' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:43:9: 'OrderedSet'
            {
            match("OrderedSet"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:44:7: ( '(' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:44:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:45:7: ( ')' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:45:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:46:7: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:46:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:47:7: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:47:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:48:7: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:48:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:49:7: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:49:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:50:7: ( '..' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:50:9: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:51:7: ( 'invalid' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:51:9: 'invalid'
            {
            match("invalid"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:52:7: ( 'null' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:52:9: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:53:7: ( '::' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:53:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:54:7: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:54:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:55:7: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:55:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:56:7: ( 'if' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:56:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:57:7: ( 'then' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:57:9: 'then'
            {
            match("then"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:58:7: ( 'else' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:58:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:59:7: ( 'endif' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:59:9: 'endif'
            {
            match("endif"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:60:7: ( 'let' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:60:9: 'let'
            {
            match("let"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:61:7: ( 'in' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:61:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:62:7: ( 'self' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:62:9: 'self'
            {
            match("self"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:63:7: ( 'true' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:63:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:64:7: ( 'false' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:64:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:65:7: ( '|' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:65:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:66:7: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:66:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "RULE_DOUBLE_QUOTED_STRING"
    public final void mRULE_DOUBLE_QUOTED_STRING() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE_QUOTED_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9237:27: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9237:29: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9237:33: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\\') ) {
                    alt1=1;
                }
                else if ( ((LA1_0>='\u0000' && LA1_0<='!')||(LA1_0>='#' && LA1_0<='[')||(LA1_0>=']' && LA1_0<='\uFFFF')) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9237:34: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9237:79: ~ ( ( '\\\\' | '\"' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOUBLE_QUOTED_STRING"

    // $ANTLR start "RULE_SINGLE_QUOTED_STRING"
    public final void mRULE_SINGLE_QUOTED_STRING() throws RecognitionException {
        try {
            int _type = RULE_SINGLE_QUOTED_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9239:27: ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9239:29: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9239:34: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\\') ) {
                    alt2=1;
                }
                else if ( ((LA2_0>='\u0000' && LA2_0<='&')||(LA2_0>='(' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFF')) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9239:35: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9239:80: ~ ( ( '\\\\' | '\\'' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SINGLE_QUOTED_STRING"

    // $ANTLR start "RULE_ML_SINGLE_QUOTED_STRING"
    public final void mRULE_ML_SINGLE_QUOTED_STRING() throws RecognitionException {
        try {
            int _type = RULE_ML_SINGLE_QUOTED_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9241:30: ( '/\\'' ( options {greedy=false; } : . )* '\\'/' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9241:32: '/\\'' ( options {greedy=false; } : . )* '\\'/'
            {
            match("/'"); 

            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9241:38: ( options {greedy=false; } : . )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\'') ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1=='/') ) {
                        alt3=2;
                    }
                    else if ( ((LA3_1>='\u0000' && LA3_1<='.')||(LA3_1>='0' && LA3_1<='\uFFFF')) ) {
                        alt3=1;
                    }


                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='&')||(LA3_0>='(' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9241:66: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match("'/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_SINGLE_QUOTED_STRING"

    // $ANTLR start "RULE_SIMPLE_ID"
    public final void mRULE_SIMPLE_ID() throws RecognitionException {
        try {
            int _type = RULE_SIMPLE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9243:16: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9243:18: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9243:42: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SIMPLE_ID"

    // $ANTLR start "RULE_ESCAPED_ID"
    public final void mRULE_ESCAPED_ID() throws RecognitionException {
        try {
            int _type = RULE_ESCAPED_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9245:17: ( '_' RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9245:19: '_' RULE_SINGLE_QUOTED_STRING
            {
            match('_'); 
            mRULE_SINGLE_QUOTED_STRING(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ESCAPED_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9247:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9247:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9247:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9247:13: '0' .. '9'
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_DOCUMENTATION"
    public final void mRULE_DOCUMENTATION() throws RecognitionException {
        try {
            int _type = RULE_DOCUMENTATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9249:20: ( '/**' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9249:22: '/**' ( options {greedy=false; } : . )* '*/'
            {
            match("/**"); 

            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9249:28: ( options {greedy=false; } : . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='*') ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1=='/') ) {
                        alt6=2;
                    }
                    else if ( ((LA6_1>='\u0000' && LA6_1<='.')||(LA6_1>='0' && LA6_1<='\uFFFF')) ) {
                        alt6=1;
                    }


                }
                else if ( ((LA6_0>='\u0000' && LA6_0<=')')||(LA6_0>='+' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9249:56: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOCUMENTATION"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9251:17: ( '/*' ~ ( '*' ) ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9251:19: '/*' ~ ( '*' ) ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            if ( (input.LA(1)>='\u0000' && input.LA(1)<=')')||(input.LA(1)>='+' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9251:31: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFF')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9251:59: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9253:17: ( '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9253:19: '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("--"); 

            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9253:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9253:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9253:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9253:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9253:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9253:41: '\\r'
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9255:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9255:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9255:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9257:16: ( . )
            // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:9257:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | RULE_DOUBLE_QUOTED_STRING | RULE_SINGLE_QUOTED_STRING | RULE_ML_SINGLE_QUOTED_STRING | RULE_SIMPLE_ID | RULE_ESCAPED_ID | RULE_INT | RULE_DOCUMENTATION | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=67;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:10: T__15
                {
                mT__15(); 

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:16: T__16
                {
                mT__16(); 

                }
                break;
            case 3 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:22: T__17
                {
                mT__17(); 

                }
                break;
            case 4 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:28: T__18
                {
                mT__18(); 

                }
                break;
            case 5 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:34: T__19
                {
                mT__19(); 

                }
                break;
            case 6 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:40: T__20
                {
                mT__20(); 

                }
                break;
            case 7 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:46: T__21
                {
                mT__21(); 

                }
                break;
            case 8 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:52: T__22
                {
                mT__22(); 

                }
                break;
            case 9 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:58: T__23
                {
                mT__23(); 

                }
                break;
            case 10 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:64: T__24
                {
                mT__24(); 

                }
                break;
            case 11 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:70: T__25
                {
                mT__25(); 

                }
                break;
            case 12 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:76: T__26
                {
                mT__26(); 

                }
                break;
            case 13 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:82: T__27
                {
                mT__27(); 

                }
                break;
            case 14 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:88: T__28
                {
                mT__28(); 

                }
                break;
            case 15 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:94: T__29
                {
                mT__29(); 

                }
                break;
            case 16 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:100: T__30
                {
                mT__30(); 

                }
                break;
            case 17 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:106: T__31
                {
                mT__31(); 

                }
                break;
            case 18 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:112: T__32
                {
                mT__32(); 

                }
                break;
            case 19 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:118: T__33
                {
                mT__33(); 

                }
                break;
            case 20 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:124: T__34
                {
                mT__34(); 

                }
                break;
            case 21 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:130: T__35
                {
                mT__35(); 

                }
                break;
            case 22 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:136: T__36
                {
                mT__36(); 

                }
                break;
            case 23 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:142: T__37
                {
                mT__37(); 

                }
                break;
            case 24 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:148: T__38
                {
                mT__38(); 

                }
                break;
            case 25 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:154: T__39
                {
                mT__39(); 

                }
                break;
            case 26 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:160: T__40
                {
                mT__40(); 

                }
                break;
            case 27 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:166: T__41
                {
                mT__41(); 

                }
                break;
            case 28 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:172: T__42
                {
                mT__42(); 

                }
                break;
            case 29 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:178: T__43
                {
                mT__43(); 

                }
                break;
            case 30 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:184: T__44
                {
                mT__44(); 

                }
                break;
            case 31 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:190: T__45
                {
                mT__45(); 

                }
                break;
            case 32 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:196: T__46
                {
                mT__46(); 

                }
                break;
            case 33 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:202: T__47
                {
                mT__47(); 

                }
                break;
            case 34 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:208: T__48
                {
                mT__48(); 

                }
                break;
            case 35 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:214: T__49
                {
                mT__49(); 

                }
                break;
            case 36 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:220: T__50
                {
                mT__50(); 

                }
                break;
            case 37 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:226: T__51
                {
                mT__51(); 

                }
                break;
            case 38 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:232: T__52
                {
                mT__52(); 

                }
                break;
            case 39 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:238: T__53
                {
                mT__53(); 

                }
                break;
            case 40 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:244: T__54
                {
                mT__54(); 

                }
                break;
            case 41 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:250: T__55
                {
                mT__55(); 

                }
                break;
            case 42 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:256: T__56
                {
                mT__56(); 

                }
                break;
            case 43 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:262: T__57
                {
                mT__57(); 

                }
                break;
            case 44 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:268: T__58
                {
                mT__58(); 

                }
                break;
            case 45 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:274: T__59
                {
                mT__59(); 

                }
                break;
            case 46 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:280: T__60
                {
                mT__60(); 

                }
                break;
            case 47 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:286: T__61
                {
                mT__61(); 

                }
                break;
            case 48 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:292: T__62
                {
                mT__62(); 

                }
                break;
            case 49 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:298: T__63
                {
                mT__63(); 

                }
                break;
            case 50 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:304: T__64
                {
                mT__64(); 

                }
                break;
            case 51 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:310: T__65
                {
                mT__65(); 

                }
                break;
            case 52 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:316: T__66
                {
                mT__66(); 

                }
                break;
            case 53 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:322: T__67
                {
                mT__67(); 

                }
                break;
            case 54 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:328: T__68
                {
                mT__68(); 

                }
                break;
            case 55 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:334: T__69
                {
                mT__69(); 

                }
                break;
            case 56 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:340: T__70
                {
                mT__70(); 

                }
                break;
            case 57 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:346: RULE_DOUBLE_QUOTED_STRING
                {
                mRULE_DOUBLE_QUOTED_STRING(); 

                }
                break;
            case 58 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:372: RULE_SINGLE_QUOTED_STRING
                {
                mRULE_SINGLE_QUOTED_STRING(); 

                }
                break;
            case 59 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:398: RULE_ML_SINGLE_QUOTED_STRING
                {
                mRULE_ML_SINGLE_QUOTED_STRING(); 

                }
                break;
            case 60 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:427: RULE_SIMPLE_ID
                {
                mRULE_SIMPLE_ID(); 

                }
                break;
            case 61 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:442: RULE_ESCAPED_ID
                {
                mRULE_ESCAPED_ID(); 

                }
                break;
            case 62 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:458: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 63 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:467: RULE_DOCUMENTATION
                {
                mRULE_DOCUMENTATION(); 

                }
                break;
            case 64 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:486: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 65 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:502: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 66 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:518: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 67 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl.ui/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/ui/contentassist/antlr/internal/InternalEssentialOCL.g:1:526: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\1\60\1\61\1\uffff\1\65\1\57\1\uffff\1\73\1\75\1\100\1"+
        "\uffff\4\57\1\111\10\57\3\uffff\1\131\4\uffff\4\57\2\uffff\2\54"+
        "\1\57\4\uffff\2\57\7\uffff\2\57\12\uffff\1\57\1\161\2\57\1\165\1"+
        "\166\2\uffff\13\57\11\uffff\5\57\7\uffff\2\57\1\u008a\1\57\2\uffff"+
        "\1\u008c\1\uffff\1\u008d\2\57\2\uffff\2\57\1\u0092\3\57\1\u0096"+
        "\7\57\1\u00a0\2\57\1\u00a3\1\57\1\uffff\1\u00a5\2\uffff\4\57\1\uffff"+
        "\1\57\1\u00ab\1\57\1\uffff\7\57\1\u00b4\1\u00b5\1\uffff\1\u00b6"+
        "\1\57\1\uffff\1\u00b8\1\uffff\2\57\1\u00bb\2\57\1\uffff\10\57\3"+
        "\uffff\1\u00c6\1\uffff\2\57\1\uffff\2\57\1\u00cb\2\57\1\u00ce\4"+
        "\57\1\uffff\1\u00d3\1\u00d4\1\u00d5\1\u00d6\1\uffff\2\57\1\uffff"+
        "\1\57\1\u00da\2\57\4\uffff\1\u00dd\2\57\1\uffff\2\57\1\uffff\5\57"+
        "\1\u00e7\1\u00e8\1\u00e9\1\57\3\uffff\4\57\1\u00ef\1\uffff";
    static final String DFA12_eofS =
        "\u00f0\uffff";
    static final String DFA12_minS =
        "\1\0\2\60\1\uffff\1\55\1\157\1\uffff\1\47\2\75\1\uffff\1\156\1"+
        "\162\1\157\1\146\1\56\1\165\1\141\1\156\2\145\1\156\1\143\1\157"+
        "\3\uffff\1\72\4\uffff\1\150\2\145\1\141\2\uffff\2\0\1\47\4\uffff"+
        "\1\163\1\144\7\uffff\1\164\1\154\2\uffff\1\0\7\uffff\1\144\1\60"+
        "\1\162\1\160\2\60\2\uffff\1\160\1\157\1\147\1\164\1\141\1\162\1"+
        "\161\2\154\1\144\1\154\11\uffff\1\145\1\165\1\164\2\154\7\uffff"+
        "\1\145\1\151\1\60\1\154\2\uffff\1\60\1\uffff\1\60\1\154\1\141\2"+
        "\uffff\2\154\1\60\1\145\1\154\1\151\1\60\1\165\1\151\1\101\1\145"+
        "\1\154\1\156\1\145\1\60\1\146\1\163\1\60\1\146\1\uffff\1\60\2\uffff"+
        "\1\151\1\154\2\145\1\uffff\1\147\1\60\1\156\1\uffff\1\145\1\155"+
        "\2\156\1\157\1\162\1\145\2\60\1\uffff\1\60\1\145\1\uffff\1\60\1"+
        "\uffff\1\145\1\151\1\60\1\141\1\145\1\uffff\1\147\1\156\1\151\1"+
        "\171\1\166\1\151\1\145\1\143\3\uffff\1\60\1\uffff\1\163\1\144\1"+
        "\uffff\1\156\1\162\1\60\1\143\1\164\1\60\1\141\2\144\1\164\1\uffff"+
        "\4\60\1\uffff\2\145\1\uffff\1\154\1\60\1\123\1\151\4\uffff\1\60"+
        "\1\144\1\151\1\uffff\1\145\1\157\1\uffff\1\116\1\144\1\164\1\156"+
        "\1\141\3\60\1\164\3\uffff\1\165\1\162\1\141\1\154\1\60\1\uffff";
    static final String DFA12_maxS =
        "\1\uffff\2\172\1\uffff\1\76\1\165\1\uffff\1\52\1\75\1\76\1\uffff"+
        "\1\156\1\162\1\157\1\156\1\56\1\165\1\157\1\156\1\145\1\164\1\156"+
        "\1\162\1\157\3\uffff\1\72\4\uffff\1\162\2\145\1\141\2\uffff\2\uffff"+
        "\1\47\4\uffff\1\163\1\144\7\uffff\1\164\1\154\2\uffff\1\uffff\7"+
        "\uffff\1\144\1\172\1\162\1\160\2\172\2\uffff\1\160\1\157\1\147\1"+
        "\164\1\141\1\162\1\164\2\154\1\144\1\154\11\uffff\1\145\1\165\1"+
        "\164\2\154\7\uffff\1\145\1\151\1\172\1\154\2\uffff\1\172\1\uffff"+
        "\1\172\1\154\1\141\2\uffff\2\154\1\172\1\145\1\154\1\151\1\172\1"+
        "\165\1\151\1\126\1\145\1\154\1\156\1\145\1\172\1\146\1\163\1\172"+
        "\1\146\1\uffff\1\172\2\uffff\1\151\1\154\2\145\1\uffff\1\147\1\172"+
        "\1\156\1\uffff\1\145\1\155\2\156\1\157\1\162\1\145\2\172\1\uffff"+
        "\1\172\1\145\1\uffff\1\172\1\uffff\1\145\1\151\1\172\1\141\1\145"+
        "\1\uffff\1\147\1\156\1\151\1\171\1\166\1\151\1\145\1\143\3\uffff"+
        "\1\172\1\uffff\1\163\1\144\1\uffff\1\156\1\162\1\172\1\143\1\164"+
        "\1\172\1\141\2\144\1\164\1\uffff\4\172\1\uffff\2\145\1\uffff\1\154"+
        "\1\172\1\123\1\151\4\uffff\1\172\1\144\1\151\1\uffff\1\145\1\157"+
        "\1\uffff\1\116\1\144\1\164\1\156\1\141\3\172\1\164\3\uffff\1\165"+
        "\1\162\1\141\1\154\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\3\uffff\1\3\2\uffff\1\6\3\uffff\1\14\15\uffff\1\42\1\43\1\44\1"+
        "\uffff\1\46\1\47\1\54\1\55\4\uffff\1\67\1\70\3\uffff\1\74\1\76\1"+
        "\102\1\103\2\uffff\1\74\1\1\1\2\1\3\1\23\1\101\1\4\2\uffff\1\6\1"+
        "\73\1\uffff\1\7\1\12\1\10\1\13\1\15\1\11\1\14\6\uffff\1\50\1\22"+
        "\13\uffff\1\42\1\43\1\44\1\53\1\45\1\46\1\47\1\54\1\55\5\uffff\1"+
        "\67\1\70\1\71\1\72\1\75\1\76\1\102\4\uffff\1\77\1\100\1\uffff\1"+
        "\17\3\uffff\1\63\1\56\23\uffff\1\5\1\uffff\1\16\1\20\4\uffff\1\36"+
        "\3\uffff\1\35\11\uffff\1\62\2\uffff\1\60\1\uffff\1\52\5\uffff\1"+
        "\27\10\uffff\1\57\1\65\1\64\1\uffff\1\61\2\uffff\1\24\12\uffff\1"+
        "\66\4\uffff\1\30\2\uffff\1\32\4\uffff\1\21\1\51\1\25\1\26\3\uffff"+
        "\1\34\2\uffff\1\37\11\uffff\1\33\1\41\1\40\5\uffff\1\31";
    static final String DFA12_specialS =
        "\1\1\45\uffff\1\2\1\3\22\uffff\1\0\u00b5\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\54\2\53\2\54\1\53\22\54\1\53\1\54\1\46\4\54\1\47\1\30\1"+
            "\31\1\6\1\3\1\32\1\4\1\17\1\7\12\52\1\33\1\45\1\11\1\12\1\10"+
            "\2\54\1\51\1\21\1\27\1\51\1\2\3\51\1\22\5\51\1\26\2\51\1\23"+
            "\1\24\1\20\1\25\5\51\1\36\1\54\1\37\1\54\1\50\1\54\1\13\3\51"+
            "\1\1\1\43\2\51\1\16\2\51\1\41\1\51\1\5\1\14\3\51\1\42\1\40\3"+
            "\51\1\15\2\51\1\34\1\44\1\35\uff82\54",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\13\57\1\55\1\57"+
            "\1\56\14\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\1\64\20\uffff\1\63",
            "\1\66\5\uffff\1\67",
            "",
            "\1\71\2\uffff\1\72",
            "\1\74",
            "\1\76\1\77",
            "",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\107\6\uffff\1\105\1\106",
            "\1\110",
            "\1\112",
            "\1\114\15\uffff\1\113",
            "\1\115",
            "\1\116",
            "\1\120\16\uffff\1\117",
            "\1\121",
            "\1\122\16\uffff\1\123",
            "\1\124",
            "",
            "",
            "",
            "\1\130",
            "",
            "",
            "",
            "",
            "\1\136\11\uffff\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "",
            "",
            "\0\145",
            "\0\146",
            "\1\147",
            "",
            "",
            "",
            "",
            "\1\152",
            "\1\153",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\154",
            "\1\155",
            "",
            "",
            "\52\157\1\156\uffd5\157",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\160",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\162",
            "\1\163",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\25\57\1\164\4\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\176\2\uffff\1\175",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0088",
            "\1\u0089",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u008b",
            "",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u008e",
            "\1\u008f",
            "",
            "",
            "\1\u0090",
            "\1\u0091",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099\7\uffff\1\u009a\14\uffff\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00a1",
            "\1\u00a2",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00a4",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "",
            "\1\u00aa",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00ac",
            "",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00b7",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\1\u00b9",
            "\1\u00ba",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00bc",
            "\1\u00bd",
            "",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "",
            "",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\1\u00c7",
            "\1\u00c8",
            "",
            "\1\u00c9",
            "\1\u00ca",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00cc",
            "\1\u00cd",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\1\u00d7",
            "\1\u00d8",
            "",
            "\1\u00d9",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00db",
            "\1\u00dc",
            "",
            "",
            "",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00de",
            "\1\u00df",
            "",
            "\1\u00e0",
            "\1\u00e1",
            "",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u00ea",
            "",
            "",
            "",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | RULE_DOUBLE_QUOTED_STRING | RULE_SINGLE_QUOTED_STRING | RULE_ML_SINGLE_QUOTED_STRING | RULE_SIMPLE_ID | RULE_ESCAPED_ID | RULE_INT | RULE_DOCUMENTATION | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_58 = input.LA(1);

                        s = -1;
                        if ( (LA12_58=='*') ) {s = 110;}

                        else if ( ((LA12_58>='\u0000' && LA12_58<=')')||(LA12_58>='+' && LA12_58<='\uFFFF')) ) {s = 111;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='e') ) {s = 1;}

                        else if ( (LA12_0=='E') ) {s = 2;}

                        else if ( (LA12_0=='+') ) {s = 3;}

                        else if ( (LA12_0=='-') ) {s = 4;}

                        else if ( (LA12_0=='n') ) {s = 5;}

                        else if ( (LA12_0=='*') ) {s = 6;}

                        else if ( (LA12_0=='/') ) {s = 7;}

                        else if ( (LA12_0=='>') ) {s = 8;}

                        else if ( (LA12_0=='<') ) {s = 9;}

                        else if ( (LA12_0=='=') ) {s = 10;}

                        else if ( (LA12_0=='a') ) {s = 11;}

                        else if ( (LA12_0=='o') ) {s = 12;}

                        else if ( (LA12_0=='x') ) {s = 13;}

                        else if ( (LA12_0=='i') ) {s = 14;}

                        else if ( (LA12_0=='.') ) {s = 15;}

                        else if ( (LA12_0=='T') ) {s = 16;}

                        else if ( (LA12_0=='B') ) {s = 17;}

                        else if ( (LA12_0=='I') ) {s = 18;}

                        else if ( (LA12_0=='R') ) {s = 19;}

                        else if ( (LA12_0=='S') ) {s = 20;}

                        else if ( (LA12_0=='U') ) {s = 21;}

                        else if ( (LA12_0=='O') ) {s = 22;}

                        else if ( (LA12_0=='C') ) {s = 23;}

                        else if ( (LA12_0=='(') ) {s = 24;}

                        else if ( (LA12_0==')') ) {s = 25;}

                        else if ( (LA12_0==',') ) {s = 26;}

                        else if ( (LA12_0==':') ) {s = 27;}

                        else if ( (LA12_0=='{') ) {s = 28;}

                        else if ( (LA12_0=='}') ) {s = 29;}

                        else if ( (LA12_0=='[') ) {s = 30;}

                        else if ( (LA12_0==']') ) {s = 31;}

                        else if ( (LA12_0=='t') ) {s = 32;}

                        else if ( (LA12_0=='l') ) {s = 33;}

                        else if ( (LA12_0=='s') ) {s = 34;}

                        else if ( (LA12_0=='f') ) {s = 35;}

                        else if ( (LA12_0=='|') ) {s = 36;}

                        else if ( (LA12_0==';') ) {s = 37;}

                        else if ( (LA12_0=='\"') ) {s = 38;}

                        else if ( (LA12_0=='\'') ) {s = 39;}

                        else if ( (LA12_0=='_') ) {s = 40;}

                        else if ( (LA12_0=='A'||LA12_0=='D'||(LA12_0>='F' && LA12_0<='H')||(LA12_0>='J' && LA12_0<='N')||(LA12_0>='P' && LA12_0<='Q')||(LA12_0>='V' && LA12_0<='Z')||(LA12_0>='b' && LA12_0<='d')||(LA12_0>='g' && LA12_0<='h')||(LA12_0>='j' && LA12_0<='k')||LA12_0=='m'||(LA12_0>='p' && LA12_0<='r')||(LA12_0>='u' && LA12_0<='w')||(LA12_0>='y' && LA12_0<='z')) ) {s = 41;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 42;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 43;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='?' && LA12_0<='@')||LA12_0=='\\'||LA12_0=='^'||LA12_0=='`'||(LA12_0>='~' && LA12_0<='\uFFFF')) ) {s = 44;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_38 = input.LA(1);

                        s = -1;
                        if ( ((LA12_38>='\u0000' && LA12_38<='\uFFFF')) ) {s = 101;}

                        else s = 44;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA12_39 = input.LA(1);

                        s = -1;
                        if ( ((LA12_39>='\u0000' && LA12_39<='\uFFFF')) ) {s = 102;}

                        else s = 44;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}