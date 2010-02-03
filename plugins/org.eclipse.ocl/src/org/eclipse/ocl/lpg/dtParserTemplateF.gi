--
-- In a parser using this template, the following macro may be redefined:
--
--     $additional_interfaces
--     $ast_class
--
-- B E G I N N I N G   O F   T E M P L A T E   dtParserTemplateF
--
%options programming_language=java,margin=4
%options table,error_maps,scopes
%options prefix=TK_
%options action-block=("*.java", "/.", "./")
%options ParseTable=lpg.runtime.ParseTable

--
-- This template requires that the name of the EOF token be set
-- to EOF_TOKEN to be consistent with LexerTemplateD and LexerTemplateE
--
%EOF
    EOF_TOKEN
%End

%ERROR
    ERROR_TOKEN
%End

%Define
	$Header
	/.
				//
				// Rule $rule_number:  $rule_text
				//
				./

    $BeginAction
    /.$Header$case $rule_number: {./

    $EndAction
    /.                break;
                }./

    $BeginJava
    /.$BeginAction
                    $symbol_declarations./

    $EndJava /.$EndAction./

    $NoAction
    /.$Header$case $rule_number:
                    break;./

    $BadAction
    /.$Header$case $rule_number:
                    throw new Error("No action specified for rule " + $rule_number);./

    $NullAction
    /.$Header$case $rule_number:
                    setResult(null);
                    break;./

    $BeginActions
    /.
		@SuppressWarnings("unchecked")
        public void ruleAction(int ruleNumber)
        {
            switch (ruleNumber)
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

    $entry_declarations
    /.
        public $ast_class parse$entry_name()
        {
            return parse$entry_name(null, $default_repair_count);
        }
            
        public $ast_class parse$entry_name(Monitor monitor)
        {
            return parse$entry_name(monitor, $default_repair_count);
        }
            
        public $ast_class parse$entry_name(int error_repair_count)
        {
            return parse$entry_name(null, error_repair_count);
        }
            
        public void resetParse$entry_name()
        {
            dtParser.resetParserEntry($sym_type.$entry_marker);
        }
        
        public $ast_class parse$entry_name(Monitor monitor, int error_repair_count)
        {
            dtParser.setMonitor(monitor);
            
            try
            {
                return ($ast_class) dtParser.parseEntry($sym_type.$entry_marker);
            }
            catch (BadParseException e)
            {
                prsStream.reset(e.error_token); // point to error token

                DiagnoseParser diagnoseParser = new DiagnoseParser(prsStream, prsTable);
                diagnoseParser.diagnoseEntry($sym_type.$entry_marker, e.error_token);
            }

            return null;
        }
    ./

    --
    -- Macros that may be needed in a parser using this template
    --
	$additional_interfaces /../
	$ast_class /.$ast_type./
	$unimplemented_symbols_warning /.false./
	
	-- Added Macros for the modified template
	$default_repair_count /.0./
	$super_parser_class /.AbstractParser./ -- The super class to which the genereated parser inherits
	$super_lexer_class /.AbstractLexer./
	$prs_stream_class /.PrsStream./

    --
    -- Old deprecated macros that should NEVER be used.
    --
    $setSym1 /. /* macro setSym1 is deprecated. Use function setResult */ getParser().setSym1./
    $setResult /. /* macro setResult is deprecated. Use function setResult */ getParser().setSym1./
    $getSym /. /* macro getSym is deprecated. Use function getRhsSym */ getParser().getSym./
    $getToken /. /* macro getToken is deprecated. Use function getRhsTokenIndex */ getParser().getToken./
    $getIToken /. /* macro getIToken is deprecated. Use function getRhsIToken */ prsStream.getIToken./
    $getLeftSpan /. /* macro getLeftSpan is deprecated. Use function getLeftSpan */ getParser().getFirstToken./
    $getRightSpan /. /* macro getRightSpan is deprecated. Use function getRightSpan */ getParser().getLastToken./
%End

%Globals
    /.import lpg.runtime.*;
    ./
%End

%Headers
    /.
    public class $action_type extends $super_parser_class implements RuleAction$additional_interfaces
    {
        private $prs_stream_class prsStream = null;
        
        private boolean unimplementedSymbolsWarning = $unimplemented_symbols_warning;

        private static ParseTable prsTable = new $prs_type();
		@Override
        public ParseTable getParseTable() { return prsTable; }

        private DeterministicParser dtParser = null;
        public DeterministicParser getParser() { return dtParser; }

 		@Override
        protected void setResult(Object object) { dtParser.setSym1(object); }
 		@Override
        protected Object getRhsSym(int i) { return dtParser.getSym(i); }

		@Override
        protected int getRhsTokenIndex(int i) { return dtParser.getToken(i); }
		@Override
        protected IToken getRhsIToken(int i) { return prsStream.getIToken(getRhsTokenIndex(i)); }
        
		@Override
        protected int getRhsFirstTokenIndex(int i) { return dtParser.getFirstToken(i); }
		@Override
        protected IToken getRhsFirstIToken(int i) { return prsStream.getIToken(getRhsFirstTokenIndex(i)); }

		@Override
        protected int getRhsLastTokenIndex(int i) { return dtParser.getLastToken(i); }
		@Override
        protected IToken getRhsLastIToken(int i) { return prsStream.getIToken(getRhsLastTokenIndex(i)); }

		@Override
        protected int getLeftSpan() { return dtParser.getFirstToken(); }
		@Override
        protected IToken getLeftIToken()  { return prsStream.getIToken(getLeftSpan()); }

		@Override
        protected int getRightSpan() { return dtParser.getLastToken(); }
		@Override
        protected IToken getRightIToken() { return prsStream.getIToken(getRightSpan()); }

		@Override
        protected int getRhsErrorTokenIndex(int i)
        {
            int index = dtParser.getToken(i);
            IToken err = prsStream.getIToken(index);
            return (err instanceof ErrorToken ? index : 0);
        }
		@Override
        protected ErrorToken getRhsErrorIToken(int i)
        {
            int index = dtParser.getToken(i);
            IToken err = prsStream.getIToken(index);
            return (ErrorToken) (err instanceof ErrorToken ? err : null);
        }

		@SuppressWarnings("nls")
		@Override
		public void reset(ILexStream lexStream)
        {
            prsStream = new $prs_stream_class(getEnvironment(), lexStream);
            dtParser.reset(prsStream);

            try
            {
                prsStream.remapTerminalSymbols(orderedTerminalSymbols(), prsTable.getEoftSymbol());
            }
            catch(NullExportedSymbolsException e) {
            }
            catch(NullTerminalSymbolsException e) {
            }
            catch(UnimplementedTerminalsException e)
            {
                if (unimplementedSymbolsWarning) {
                    java.util.ArrayList<?> unimplemented_symbols = e.getSymbols();
                    System.out.println("The Lexer will not scan the following token(s):");
                    for (int i = 0; i < unimplemented_symbols.size(); i++)
                    {
                        Integer id = (Integer) unimplemented_symbols.get(i);
                        System.out.println("    " + $sym_type.orderedTerminalSymbols[id.intValue()]);               
                    }
                    System.out.println();
                }
            }
            catch(UndefinedEofSymbolException e)
            {
                throw new Error(new UndefinedEofSymbolException
                                    ("The Lexer does not implement the Eof symbol " +
                                     $sym_type.orderedTerminalSymbols[prsTable.getEoftSymbol()]));
            }
        }

		@SuppressWarnings("nls")
        public $action_type($super_lexer_class lexer)
        {
        		super(lexer);        		
            try
            {
                dtParser = new DeterministicParser(prsStream, prsTable, this);
            }
            catch (NotDeterministicParseTableException e)
            {
				throw new Error(new NotDeterministicParseTableException
                                    ("Regenerate $prs_type.java with -NOBACKTRACK option"));
            }
            catch (BadParseSymFileException e)
            {
                throw new Error(new BadParseSymFileException("Bad Parser Symbol File -- $sym_type.java. Regenerate $prs_type.java"));
            }
            
	        ILexStream lexStream = lexer.getILexStream();
	        if (lexStream != null) {
	        	reset(lexStream);
	        }
        }		

		@Override
        public int numTokenKinds() { return $sym_type.numTokenKinds; }
		@Override
        public String[] orderedTerminalSymbols() { return $sym_type.orderedTerminalSymbols; }
        public String getTokenKindName(int kind) { return $sym_type.orderedTerminalSymbols[kind]; }            
        public int getEOFTokenKind() { return prsTable.getEoftSymbol(); }
		@Override
        public $prs_stream_class getIPrsStream() { return prsStream; }

		@Override
        public $ast_class parser()
        {
            return parser(null, $default_repair_count);
        }
            
		@Override
        public $ast_class parser(Monitor monitor)
        {
            return parser(monitor, $default_repair_count);
        }
            
		@Override
        public $ast_class parser(int error_repair_count)
        {
            return parser(null, error_repair_count);
        }
            
		@Override
        public $ast_class parser(Monitor monitor, int error_repair_count)
        {
            dtParser.setMonitor(monitor);

            try
            {
                return ($ast_class) dtParser.parse();
            }
            catch (BadParseException e)
            {
                prsStream.reset(e.error_token); // point to error token

                DiagnoseParser diagnoseParser = new DiagnoseParser(prsStream, prsTable);
                diagnoseParser.diagnose(e.error_token);
            }

            return null;
        }

        //
        // Additional entry points, if any
        //
        $entry_declarations
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
