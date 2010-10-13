%options escape=$
%options la=1
%options table=java
%options error-maps
%options scopes
%options margin=4
%options noserialize
%options backtrack
%options template=btParserTemplateD.g
%options ast-type=Node
%options programming_language=java
%options ParseTable=lpg.lpgjavaruntime.ParseTable
%options verbose

$Globals
	/.
import com.sap.tc.moin.repository.shared.util.parsers.AstException;
import com.sap.tc.moin.repository.shared.util.ProcessErrorImpl;
import com.sap.tc.moin.repository.shared.util.ProcessWarningImpl;
import com.sap.tc.moin.repository.shared.util.ProcessMessages;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.exception.MoinBaseException;
import com.sap.tc.moin.repository.shared.util.parsers.LPGMessages;
import com.sap.tc.moin.repository.shared.util.LocalizedProcessException;
	./
$End

$Identifier
	IDENTIFIER
$End

$Terminals

	STRING_LITERAL
	INTEGER_LITERAL
	REAL_LITERAL
	
	GREATER       ::= '>'
	LESS          ::= '<'
	EQUAL         ::= '='
	GREATER_EQUAL ::= '>='
	LESS_EQUAL    ::= '<='
	NOT_EQUAL     ::= '<>'

	LPAREN   ::= '('
	RPAREN   ::= ')'
	LBRACE   ::= '{'
	RBRACE   ::= '}'
	LBRACKET ::= '['
	RBRACKET ::= ']'
	
	COMMA      ::= ','
	COLON      ::= ':'
	COLONCOLON ::= '::'
	DOT        ::= '.'
	EXCLAMATION ::= '!'
	
	SHARP ::= '#'

$End

$Headers
/.
	// lexer/parser errors
    private LocalizedProcessException getErrorException(int index, String tokenText ) {
        LocalizedProcessException result;
        switch (index) {
            case LEX_ERROR_CODE:
                result = new LocalizedProcessException( LPGMessages.LPG_LEX_ERROR_CODE, tokenText );
                break;
            case ERROR_CODE:
                result = new LocalizedProcessException( LPGMessages.LPG_ERROR_CODE, tokenText );
                break;
            case BEFORE_CODE:
                result = new LocalizedProcessException( LPGMessages.LPG_BEFORE_CODE, tokenText );
                break;
            case INSERTION_CODE:
                result = new LocalizedProcessException( LPGMessages.LPG_INSERTION_CODE, tokenText );
                break;
            case INVALID_CODE:
                result = new LocalizedProcessException( LPGMessages.LPG_INVALID_CODE, tokenText );
                break;
            case SUBSTITUTION_CODE:
                result = new LocalizedProcessException( LPGMessages.LPG_SUBSTITUTION_SECONDARY_CODE, tokenText );
                break;
            case DELETION_CODE:
                result = new LocalizedProcessException( LPGMessages.LPG_DELETION_CODE, tokenText );
                break;
            case MERGE_CODE:
                result = new LocalizedProcessException( LPGMessages.LPG_MERGE_CODE, tokenText );
                break;
            case MISPLACED_CODE:
                result = new LocalizedProcessException( LPGMessages.LPG_MISPLACED_CODE, tokenText );
                break;
            case SCOPE_CODE:
                result = new LocalizedProcessException( LPGMessages.LPG_SCOPE_CODE, tokenText );
                break;
            case EOF_CODE:
                result = new LocalizedProcessException( LPGMessages.LPG_EOF_CODE );
                break;
            case INVALID_TOKEN_CODE:
                result = new LocalizedProcessException( LPGMessages.LPG_INVALID_TOKEN_CODE, tokenText );
                break;
            default:
                result = new LocalizedProcessException( LPGMessages.LPG_INVALID_ERRORCODE, index, tokenText ); 
        }
        return result;
    }
    
    private ProcessReport report = null;

    public void dumpTokens()
    {
        throw new AstException(LPGMessages.LPG_PARSERBUG_WRONG_REPORTERR);
    }

    public void dumpToken(int i)
    {
        throw new AstException(LPGMessages.LPG_PARSERBUG_WRONG_REPORTERR);
    }
    
    @Override
    public void reportError(int i, String code) {
        throw new AstException(LPGMessages.LPG_PARSERBUG_WRONG_REPORTERR);
    }

    @Override
    public void reportError(int left_char, int right_char) {
        throw new AstException(LPGMessages.LPG_PARSERBUG_WRONG_REPORTERR);
    }

    @Override
    public void reportError(int errorCode, String locationInfo, String tokenText) {
        throw new AstException(LPGMessages.LPG_PARSERBUG_WRONG_REPORTERR);
    }

    @Override
    public void reportError(int errorCode, String locationInfo, int leftToken, int rightToken, String tokenText) {
        if (leftToken == rightToken) {
      	  if (errorCode == DELETION_CODE || errorCode == MISPLACED_CODE) {
        	    tokenText = getTokenText(leftToken);
	        } else {
    	        tokenText = getTokenText(leftToken) + " -> " + tokenText; //$NON-NLS-1$
        	}
	    } else {
        if (errorCode == DELETION_CODE || errorCode == MISPLACED_CODE) {
            tokenText = getTokenText(leftToken) + " ... " + getTokenText(rightToken); //$NON-NLS-1$
        } else {
            tokenText = getTokenText(leftToken) + " ... " + getTokenText(rightToken) + " -> " + tokenText; //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

        int start = getStartOffset(leftToken);
        int end = getEndOffset(rightToken);
        int startLine = getLineNumberOfTokenAt(leftToken);
        int startColumn = getColumnOfTokenAt(leftToken);
        int endLine = getEndLineNumberOfTokenAt(rightToken);
        int endColumn = getEndColumnOfTokenAt(rightToken);

        // formulate error
        LocalizedProcessException errorException = getErrorException(errorCode, tokenText);

        // add an error to the report
        this.report.reportError(new ProcessErrorImpl(errorException, startLine, startColumn, endLine,
            endColumn, start, end));
    }
    
	private void parserGenStart(LexStream lexStream, int eoftSymbol, String[] orderedTerminalSymbols) {
	    try
	    {
	        super.remapTerminalSymbols(orderedTerminalSymbols(), eoftSymbol);
	    }
	    catch(NullExportedSymbolsException e) {
	        this.report.reportWarning(new ProcessWarningImpl(null,ProcessMessages.PROCESS_EXCEPTION, e.getMessage( )));
	    }
	    catch(NullTerminalSymbolsException e) {
	        this.report.reportWarning(new ProcessWarningImpl(null,ProcessMessages.PROCESS_EXCEPTION, e.getMessage( )));
	    }
	    catch(UnimplementedTerminalsException e)
	    {
	        java.util.ArrayList unimplemented_symbols = e.getSymbols();
        
	        StringBuilder symbols = new StringBuilder();
	        for (int i = 0; i < unimplemented_symbols.size(); i++)
	        {
	            Integer id = (Integer) unimplemented_symbols.get(i);
	            symbols.append(orderedTerminalSymbols[id.intValue()]);
	            symbols.append(", "); //$NON-NLS-1$              
	        }
	        this.report.reportWarning( new ProcessWarningImpl( e.getStackTrace( ), LPGMessages.LPG_TOKEN_IGNORED, symbols.toString() ) );
   
	    }
	    catch(UndefinedEofSymbolException e)
    	{
	        throw new AstException(new UndefinedEofSymbolException
	            (LPGMessages.LPG_LEX_DOESNTIMPLEMENT_EOF.format(
	                orderedTerminalSymbols[eoftSymbol])));
	    } 
	}  
./
$End

$Rules
   
    -- identifiers
    identifierM ::= $empty
    identifierM -> identifierN
    identifierN -> identifier
    identifierN $IdentifierN ::= identifier ',' identifierN
    
    identifier $Ident ::= IDENTIFIER
    
    identifierOpt ::= $empty
    identifierOpt -> identifier
 
  	--  a path name is a path of identifiers
  	sPathName $PathNameIdent ::= identifier
  	sPathName $PathNames ::= identifier '::' sPathName
  	
  	-- a full path name optionally allows a container name or identifier
  	pathName -> identifierWithOptContainerPrefix 
  	
  	identifierWithOptContainerPrefix -> sPathName 
  	identifierWithOptContainerPrefix $ContainerNamePrefix ::= identifier '#' sPathName 
  	
  	-- a type path name is either a type literal or a full path name
  	typePathName -> typeLiteral
  	typePathName -> pathName
  	
  	typePathNameOpt ::= $Empty
  	typePathNameOpt -> typePathName
  	
  	-- a variable declaration implies the definition of an identifier, optionally with a type
	variableDeclaration $VariableDeclaration ::= identifier withTypeExpressionOpt

	-- with type expression
	withTypeExpression $WithTypeExpression ::= ':' typePathName
	withTypeExpressionOpt -> withTypeExpression
	withTypeExpressionOpt ::= $empty

    -- a variable declaration with type requires the type constraint 
    variableDeclarationWithType $VariableDeclarationWithType ::= identifier withTypeExpression
    
    -- multiple variable declarations with type
  	variableDeclarationWithTypeM ::= $empty
	variableDeclarationWithTypeM -> variableDeclarationWithTypeN
	variableDeclarationWithTypeN -> variableDeclarationWithType
	variableDeclarationWithTypeN $VariableDeclarationWithTypeN ::= variableDeclarationWithType ',' variableDeclarationWithTypeN

	-- multiple variable declarations
	variableDeclarationM ::= $empty
    variableDeclarationM -> variableDeclarationN
	variableDeclarationN -> variableDeclaration
	variableDeclarationN $VariableDeclarationN ::= variableDeclaration ',' variableDeclarationN
  	
	-----------
    -- Types --
    -----------
	
	-- a type literal
	typeLiteral -> collectionType
    typeLiteral -> tupleType
    typeLiteral -> primitiveType
    
 	-- these are built-in types for OCL
	primitiveType $PrimTypeInteger ::= Integer
	primitiveType $PrimTypeString ::= String
	primitiveType $PrimTypeReal ::= Real
	primitiveType $PrimTypeFloat ::= Float
	primitiveType $PrimTypeDouble ::= Double
	primitiveType $PrimTypeBoolean ::= Boolean
	primitiveType $PrimTypeOclAny ::= OclAny
	primitiveType $PrimTypeOclVoid ::= OclVoid
	primitiveType $PrimTypeOclInvalid ::= OclInvalid

	-- collection type
	collectionType $CollectionType ::= collectionKind '(' typePathName ')'
	
	-- collection kind (also used in literals)
	collectionKind $SetKind ::= Set
	collectionKind $BagKind ::= Bag
	collectionKind $SequenceKind ::= Sequence
	collectionKind $OrderedSetKind ::= OrderedSet
	collectionKind $CollectionKind ::= Collection
	
	-- tuple type 
	tupleType $TupleType ::= Tuple '(' variableDeclarationWithTypeM ')'

$End

$Trailers
	/. 
	./
$End
