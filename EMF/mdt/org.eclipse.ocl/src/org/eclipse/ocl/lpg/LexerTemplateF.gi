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
-- B E G I N N I N G   O F   T E M P L A T E   LexerTemplateF
--
%Options programming_language=java,margin=4
%Options table
%options action-block=("*.java", "/.", "./")
%options ParseTable=lpg.runtime.ParseTable
%Options prefix=Char_

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
    $super_stream_class /.$file_prefix$LpgLexStream./
    $prs_stream_class /.IPrsStream./
    
    --
    -- Some added macros needed by the modified template
    --
    $lex_stream_class /.LpgLexStream./
    $super_lexer_class  /.AbstractLexer./        
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
                //
                ./

    $DefaultAction
    /.$Header$case $rule_number: { ./

    $BeginAction /.$DefaultAction./

    $EndAction
    /.            break;
                }./

    $BeginJava
    /.$BeginAction
                $symbol_declarations./

    $EndJava /.$EndAction./

    $NoAction
    /.$Header$case $rule_number:
                    break; ./

    $BeginActions
    /.
        public void ruleAction(int ruleNumber)
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
    ./
%End

%Headers
    /.
    @SuppressWarnings("nls")
    public class $action_type extends $super_lexer_class implements RuleAction$additional_interfaces
    {
        private $super_stream_class lexStream;
        
        private static ParseTable prs = new $prs_type();
        @Override
        public ParseTable getParseTable() { return prs; }

        private LexParser lexParser = new LexParser();
        @Override
        public LexParser getParser() { return lexParser; }

        public int getToken(int i) { return lexParser.getToken(i); }
        public int getRhsFirstTokenIndex(int i) { return lexParser.getFirstToken(i); }
        public int getRhsLastTokenIndex(int i) { return lexParser.getLastToken(i); }

        public int getLeftSpan() { return lexParser.getToken(1); }
        public int getRightSpan() { return lexParser.getLastToken(); }
  
        @Override
        public void resetKeywordLexer()
        {
            if (kwLexer == null)
                  this.kwLexer = new $kw_lexer_class(lexStream.getInputChars(), $_IDENTIFIER);
            else this.kwLexer.setInputChars(lexStream.getInputChars());
        }

        @Override
        public void reset(char[] input_chars, String filename)
        {
            reset(input_chars, filename, 1);
        }
        
        @Override
        public void reset(char[] input_chars, String filename, int tab)
        {
            lexStream = new $super_stream_class(getOCLEnvironment(), input_chars, filename, tab);
            lexParser.reset(lexStream, prs, this);
            resetKeywordLexer();
        }

        
        public $action_type($environment_class environment) {
            super($adapt_environment);
            oclEnvironment = environment;
        }

		public $action_type($environment_class environment, char[] chars) {
			this(environment, chars, "OCL", ECLIPSE_TAB_VALUE);
		}

        public $action_type($environment_class environment, char[] input_chars, String filename, int tab) {
            super($adapt_environment);
            oclEnvironment = environment;
            reset(input_chars, filename, tab);            
        }

		private final $environment_class oclEnvironment;
        
		public $environment_class getOCLEnvironment() {
        	return oclEnvironment;
        }

        @Override
        public $lex_stream_class getILexStream() { return lexStream; }

        /**
         * @deprecated replaced by {@link #getILexStream()}
         */
        @Deprecated
        @Override
        public ILexStream getLexStream() { return lexStream; }

        private void initializeLexer($prs_stream_class prsStream, int start_offset, int end_offset)
        {
            if (lexStream.getInputChars() == null)
                throw new NullPointerException("LexStream was not initialized");
            lexStream.setPrsStream(prsStream);
            prsStream.makeToken(start_offset, end_offset, 0); // Token list must start with a bad token
        }

        private void addEOF($prs_stream_class prsStream, int end_offset)
        {
            prsStream.makeToken(end_offset, end_offset, $eof_token); // and end with the end of file token
            prsStream.setStreamLength(prsStream.getSize());
        }

        @Override
        public void lexer($prs_stream_class prsStream)
        {
            lexer(null, prsStream);
        }
        
        @Override
        public void lexer(Monitor monitor, $prs_stream_class prsStream)
        {
            initializeLexer(prsStream, 0, -1);
            lexParser.parseCharacters(monitor);  // Lex the input characters
            addEOF(prsStream, lexStream.getStreamIndex());
        }

        @Override
        public void lexer($prs_stream_class prsStream, int start_offset, int end_offset)
        {
            lexer(null, prsStream, start_offset, end_offset);
        }
        
        @Override
        public void lexer(Monitor monitor, $prs_stream_class prsStream, int start_offset, int end_offset)
        {
            if (start_offset <= 1)
                 initializeLexer(prsStream, 0, -1);
            else initializeLexer(prsStream, start_offset - 1, start_offset - 1);

            lexParser.parseCharacters(monitor, start_offset, end_offset);

            addEOF(prsStream, (end_offset >= lexStream.getStreamIndex() ? lexStream.getStreamIndex() : end_offset + 1));
        }

        /**
         * If a parse stream was not passed to this Lexical analyser then we
         * simply report a lexical error. Otherwise, we produce a bad token.
         */
        @Override
        public void reportLexicalError(int startLoc, int endLoc) {
            IPrsStream prs_stream = lexStream.getIPrsStream();
            if (prs_stream == null)
                lexStream.reportLexicalError(startLoc, endLoc);
            else {
                //
                // Remove any token that may have been processed that fall in the
                // range of the lexical error... then add one error token that spans
                // the error range.
                //
                for (int i = prs_stream.getSize() - 1; i > 0; i--) {
                    if (prs_stream.getStartOffset(i) >= startLoc)
                         prs_stream.removeLastToken();
                    else break;
                }
                prs_stream.makeToken(startLoc, endLoc, 0); // add an error token to the prsStream
            }        
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
