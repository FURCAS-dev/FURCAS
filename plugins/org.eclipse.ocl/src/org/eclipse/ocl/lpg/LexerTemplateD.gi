--
-- An instance of this template must have a $Export section and the export_terminals option
--
-- Macros that may be redefined in an instance of this template
--
--     $eof_token
--     $additional_interfaces
--     $super_stream_class -- subclass com.ibm.lpg.LpgLexStream for getKind
--     $prs_stream_class -- use /.PrsStream./ if not subclassing
--
-- B E G I N N I N G   O F   T E M P L A T E   LexerTemplateD
--
%options programming_language=java,margin=4
%options table
%options action-block=("*.java", "/.", "./")
%options ParseTable=lpg.runtime.ParseTable
%options prefix=Char_

--
-- This template requires that the name of the EOF token be set
-- to EOF and that the prefix be "Char_" to be consistent with
-- KeywordTemplateD.
--
%Eof
    EOF
%End

--
-- This template also requires that the name of the parser EOF
-- Token to be exported be set to EOF_TOKEN
--
%Export
    EOF_TOKEN
%End

%Define
    --
    -- Macros that are be needed in an instance of this template
    --
    $eof_token /.$_EOF_TOKEN./
    
    $additional_interfaces /../
    $super_stream_class /.AbstractLexer./
    $prs_stream_class /.AbstractParser./
    $environment_class /.BasicEnvironment./
    $adapt_environment /.environment./
    

    $prs_stream /. // macro prs_stream is deprecated. Use function getPrsStream
                  getPrsStream()./
    $setSym1 /. // macro setSym1 is deprecated. Use function setResult
               lexParser.setSym1./
    $setResult /. // macro setResult is deprecated. Use function setResult
                 lexParser.setSym1./
    $getSym /. // macro getSym is deprecated. Use function getLastToken
              lexParser.getSym./
    $getToken /. // macro getToken is deprecated. Use function getToken
                lexParser.getToken./
    $getLeftSpan /. // macro getLeftSpan is deprecated. Use function getLeftSpan
                   lexParser.getFirstToken./
    $getRightSpan /. // macro getRightSpan is deprecated. Use function getRightSpan
                    lexParser.getLastToken./

    --
    -- Macros useful for specifying actions
    --
    $Header
    /.
                //
                // Rule $rule_number:  $rule_text
                //./

    $DefaultAction
    /. $Header
                case $rule_number: { ./

    $BeginAction /.$DefaultAction./

    $EndAction
    /.          break;
                }./

    $BeginJava
    /.$BeginAction
                $symbol_declarations./

    $EndJava /.$EndAction./

    $NoAction
    /. $Header
                case $rule_number:
                    break; ./

    $BeginActions
    /.
        public void ruleAction( int ruleNumber)
        {
            switch(ruleNumber)
            {./

    $SplitActions
    /.
	            default:
	                ruleAction$rule_number(ruleNumber);
	                break;
	        }
	        return;
	    }
	
	    public void ruleAction$rule_number(int ruleNumber)
	    {
	        switch (ruleNumber)
	        {./

    $EndActions
    /.
                default:
                    break;
            }
            return;
        }./
%End

%Globals
    /.import lpg.runtime.*;
    import org.eclipse.ocl.lpg.AbstractLexer;
    import org.eclipse.ocl.lpg.AbstractParser;
    ./
%End

%Headers
    /.
    @SuppressWarnings("nls")
    public class $action_type extends $super_stream_class implements $exp_type, $sym_type, RuleAction$additional_interfaces
    {
        private static ParseTable prs = new $prs_type();
        //
        // The Lexer contains an array of characters as the input stream to be parsed.
        // There are methods to retrieve and classify characters.
        // The lexparser "token" is implemented simply as the index of the next character in the array.
        // The Lexer extends the abstract class LpgLexStream with an implementation of the abstract
        // method getKind.  The template defines the Lexer class and the lexer() method.
        // A driver creates the action class, "Lexer", passing an Option object to the constructor.
        //
        protected $kw_lexer_class kwLexer;
        protected boolean printTokens;
        private $prs_stream_class parser;
        private LexParser lexParser = new LexParser(this, prs, this);
        
        private final $environment_class oclEnvironment;

        public $action_type($environment_class environment) {
            super($adapt_environment);
            oclEnvironment = environment;
        }
        
		public $action_class($environment_class environment, char[] chars) {
			this(environment, chars, "OCL", ECLIPSE_TAB_VALUE);
			kwLexer = new $kw_lexer_class(getInputChars(), $_IDENTIFIER);
		}

        public $action_type($environment_class environment, char[] input_chars, String filename, int tab)  {
            super($adapt_environment, input_chars, filename, tab);
            oclEnvironment = environment;
        }
        
		public $environment_class getOCLEnvironment() {
        	return oclEnvironment;
        }

        @Override
        public int [] getKeywordKinds() { return kwLexer.getKeywordKinds(); }

        public int getLeftSpan() { return lexParser.getFirstToken(); }
        public $prs_stream_class getParser() { return parser; }
        public int getRhsFirstTokenIndex(int i) { return lexParser.getFirstToken(i); }
        public int getRhsLastTokenIndex(int i) { return lexParser.getLastToken(i); }
        public int getRightSpan() { return lexParser.getLastToken(); }

        @Override
        public int getToken(int i) { return lexParser.getToken(i); }

        @Override
        public void initialize(char [] content, String filename)
        {
            super.initialize(content, filename);
            if (kwLexer == null)
                 kwLexer = new $kw_lexer_class(getInputChars(), $_IDENTIFIER);
            else
                 kwLexer.setInputChars(getInputChars());
        }

        @Override
        public String[] orderedExportedSymbols() { return $exp_type.orderedTerminalSymbols; }
        
	    @Override
	    public void setInputChars(char[] inputChars) {
			super.setInputChars(inputChars);
			kwLexer = new $kw_lexer_class(getInputChars(), $_IDENTIFIER);
		}
        
        @Override
        public void lexToTokens(Monitor monitor, $prs_stream_class parser)
        {
            if (getInputChars() == null)
                throw new NullPointerException("LexStream was not initialized");

            this.parser = parser;

            parser.makeToken(0, 0, 0); // Token list must start with a bad token
                
            lexParser.parseCharacters(monitor);  // Lex the input characters
                
            int i = getStreamIndex();
            parser.makeToken(i, i, $eof_token); // and end with the end of file token
            parser.setStreamLength(parser.getSize());
                
            return;
        }
    ./
%End

%Rules
    /.$BeginActions./
%End

%Trailers
    /.
        $EndActions
    }
    ./
%End

--
-- E N D   O F   T E M P L A T E
--
