/**
   * This file is generated for MOIN-MQL with LPG. 
   */

package com.sap.tc.moin.repository.core.query.moinql.parser.gen;

import com.sap.tc.moin.repository.core.query.moinql.parser.gen.mqlAst.*;
import lpg.lpgjavaruntime.*;

import com.sap.tc.moin.repository.shared.util.parsers.AstException;
import com.sap.tc.moin.repository.shared.util.ProcessErrorImpl;
import com.sap.tc.moin.repository.shared.util.ProcessWarningImpl;
import com.sap.tc.moin.repository.shared.util.ProcessMessages;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.exception.MoinBaseException;
import com.sap.tc.moin.repository.shared.util.parsers.LPGMessages;
import com.sap.tc.moin.repository.shared.util.LocalizedProcessException;

public class MqlParserGen extends PrsStream implements RuleAction
{
    private static ParseTable prs = new MqlParserGenprs();
    private DeterministicParser dtParser;

    public DeterministicParser getParser() { return dtParser; }
    private void setResult(Object object) { dtParser.setSym1(object); }
    public Object getRhsSym(int i) { return dtParser.getSym(i); }

    public int getRhsTokenIndex(int i) { return dtParser.getToken(i); }
    public IToken getRhsIToken(int i) { return super.getIToken(getRhsTokenIndex(i)); }
    
    public int getRhsFirstTokenIndex(int i) { return dtParser.getFirstToken(i); }
    public IToken getRhsFirstIToken(int i) { return super.getIToken(getRhsFirstTokenIndex(i)); }

    public int getRhsLastTokenIndex(int i) { return dtParser.getLastToken(i); }
    public IToken getRhsLastIToken(int i) { return super.getIToken(getRhsLastTokenIndex(i)); }

    public int getLeftSpan() { return dtParser.getFirstToken(); }
    public IToken getLeftIToken()  { return super.getIToken(getLeftSpan()); }

    public int getRightSpan() { return dtParser.getLastToken(); }
    public IToken getRightIToken() { return super.getIToken(getRightSpan()); }

    public int getRhsErrorTokenIndex(int i)
    {
        int index = dtParser.getToken(i);
        IToken err = super.getIToken(index);
        return (err instanceof ErrorToken ? index : 0);
    }
    public ErrorToken getRhsErrorIToken(int i)
    {
        int index = dtParser.getToken(i);
        IToken err = super.getIToken(index);
        return (ErrorToken) (err instanceof ErrorToken ? err : null);
    }

    public MqlParserGen(LexStream lexStream)
    {
        super(lexStream);

        try
        {
            super.remapTerminalSymbols(orderedTerminalSymbols(), MqlParserGenprs.EOFT_SYMBOL);
        }
        catch(NullExportedSymbolsException e) {
        throw new RuntimeException(e);
        }
        catch(NullTerminalSymbolsException e) {
        throw new RuntimeException(e);
        }
        catch(UnimplementedTerminalsException e)
        {
            StringBuilder sb = new StringBuilder();
            java.util.ArrayList unimplemented_symbols = e.getSymbols();

            for (int i = 0; i < unimplemented_symbols.size(); i++)
            {
                Integer id = (Integer) unimplemented_symbols.get(i);
                sb.append(MqlParserGensym.orderedTerminalSymbols[id.intValue()]);
                sb.append(", "); //$NON-NLS-1$               
            }                       
            throw new RuntimeException(LPGMessages.LPG_WILL_NOT_SCAN.format(sb.toString()));
        }
        catch(UndefinedEofSymbolException e)
        {
            throw new RuntimeException(new UndefinedEofSymbolException
                                (LPGMessages.LPG_LEX_DOESNTIMPLEMENT_EOF.format(
                                 MqlParserGensym.orderedTerminalSymbols[MqlParserGenprs.EOFT_SYMBOL])));
        } 
    }

    public String[] orderedTerminalSymbols() { return MqlParserGensym.orderedTerminalSymbols; }
    public String getTokenKindName(int kind) { return MqlParserGensym.orderedTerminalSymbols[kind]; }            
    public int getEOFTokenKind() { return MqlParserGenprs.EOFT_SYMBOL; }
    public PrsStream getParseStream() { return (PrsStream) this; }

    public Node parser()
    {
        return parser(null, 0);
    }
        
    public Node parser(Monitor monitor)
    {
        return parser(monitor, 0);
    }
        
    public Node parser(int error_repair_count)
    {
        return parser(null, error_repair_count);
    }
        
    public Node parser(Monitor monitor, int error_repair_count)
    {
        try
        {
            dtParser = new DeterministicParser(monitor, (TokenStream)this, prs, (RuleAction)this);
        }
        catch (NotDeterministicParseTableException e)
        {
            throw new RuntimeException(new NotDeterministicParseTableException
                                (LPGMessages.LPG_REGENERATE_NOBACKTRACK.format( "MqlParserGenprs.java" ))); //$NON-NLS-1$
        }
        catch (BadParseSymFileException e)
        {
            throw new RuntimeException(new BadParseSymFileException(LPGMessages.LPG_BAD_SYMFILE.format("MqlParserGensym.java", "MqlParserGenprs.java")));  //$NON-NLS-1$  //$NON-NLS-2$
        }

        try
        {
            return (Node) dtParser.parse();
        }
        catch (BadParseException e)
        {
            reset(e.error_token); // point to error token

            DiagnoseParser diagnoseParser = new DiagnoseParser(this, prs);
            diagnoseParser.diagnose(e.error_token);
        }

        return null;
    }


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

  // special MQL constructor
  public MqlParserGen(LexStream lexStream, ProcessReport _report)
    {
        super(lexStream);
        this.report = _report;
        parserGenStart(lexStream, MqlParserGenprs.EOFT_SYMBOL, MqlParserGensym.orderedTerminalSymbols);
    }

    public void ruleAction(int ruleNumber)
    {
        switch (ruleNumber)
        {
 
            //
            // Rule 1:  identifierM ::= $Empty
            //
            case 1: {
                setResult(null);
                break;
            } 
            //
            // Rule 2:  identifierM -> identifierN
            //
            case 2:
                break; 
            //
            // Rule 3:  identifierN -> identifier
            //
            case 3:
                break; 
            //
            // Rule 4:  identifierN ::= identifier , identifierN
            //
            case 4: {
                setResult(
                    new IdentifierN(getLeftIToken(), getRightIToken(),
                                    (Ident)getRhsSym(1),
                                    (IidentifierN)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 5:  identifier ::= IDENTIFIER
            //
            case 5: {
                setResult(
                    new Ident(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 6:  sPathName ::= identifier
            //
            case 6: {
                setResult(
                    new PathNameIdent(getLeftIToken(), getRightIToken(),
                                      (Ident)getRhsSym(1))
                );
                break;
            } 
            //
            // Rule 7:  sPathName ::= identifier :: sPathName
            //
            case 7: {
                setResult(
                    new PathNames(getLeftIToken(), getRightIToken(),
                                  (Ident)getRhsSym(1),
                                  (IsPathName)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 8:  pathName -> identifierWithOptContainerPrefix
            //
            case 8:
                break; 
            //
            // Rule 9:  identifierWithOptContainerPrefix -> sPathName
            //
            case 9:
                break; 
            //
            // Rule 10:  identifierWithOptContainerPrefix ::= identifier # sPathName
            //
            case 10: {
                setResult(
                    new ContainerNamePrefix(getLeftIToken(), getRightIToken(),
                                            (Ident)getRhsSym(1),
                                            (IsPathName)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 11:  typePathName -> pathName
            //
            case 11:
                break; 
            //
            // Rule 12:  query ::= selectClause fromClause whereClauseM
            //
            case 12: {
                setResult(
                    new MqlQuery(getLeftIToken(), getRightIToken(),
                                 (SelectClause)getRhsSym(1),
                                 (FromClause)getRhsSym(2),
                                 (IwhereClauseM)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 13:  query ::= $Empty
            //
            case 13: {
                setResult(null);
                break;
            } 
            //
            // Rule 14:  selectClause ::= select selectEntryN
            //
            case 14: {
                setResult(
                    new SelectClause(getLeftIToken(), getRightIToken(),
                                     (IselectEntryN)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 15:  selectEntryN ::= selectEntry , selectEntryN
            //
            case 15: {
                setResult(
                    new SelectEntryN(getLeftIToken(), getRightIToken(),
                                     (IselectEntry)getRhsSym(1),
                                     (IselectEntryN)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 16:  selectEntryN -> selectEntry
            //
            case 16:
                break; 
            //
            // Rule 17:  selectEntry ::= identifier
            //
            case 17: {
                setResult(
                    new SelectAlias(getLeftIToken(), getRightIToken(),
                                    (Ident)getRhsSym(1))
                );
                break;
            } 
            //
            // Rule 18:  selectEntry ::= identifier . identifier
            //
            case 18: {
                setResult(
                    new SelectAttribute(getLeftIToken(), getRightIToken(),
                                        (Ident)getRhsSym(1),
                                        (Ident)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 19:  fromClause ::= from fromEntryN
            //
            case 19: {
                setResult(
                    new FromClause(getLeftIToken(), getRightIToken(),
                                   (IfromEntryN)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 20:  fromEntryN ::= fromEntry , fromEntryN
            //
            case 20: {
                setResult(
                    new FromEntryN(getLeftIToken(), getRightIToken(),
                                   (FromEntry)getRhsSym(1),
                                   (IfromEntryN)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 21:  fromEntryN -> fromEntry
            //
            case 21:
                break; 
            //
            // Rule 22:  fromEntry ::= typeClause as identifier scopeClauseOpt
            //
            case 22: {
                setResult(
                    new FromEntry(getLeftIToken(), getRightIToken(),
                                  (ItypeClause)getRhsSym(1),
                                  (Ident)getRhsSym(3),
                                  (ScopeClause)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 23:  typeClause -> typeClauseQName
            //
            case 23:
                break; 
            //
            // Rule 24:  typeClause -> typeClauseMri
            //
            case 24:
                break; 
            //
            // Rule 25:  typeClauseQName ::= typePathName withoutsubtypesOpt
            //
            case 25: {
                setResult(
                    new TypeQName(getLeftIToken(), getRightIToken(),
                                  (ItypePathName)getRhsSym(1),
                                  (Withoutsubtypes)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 26:  typeClauseMri ::= type identifier withoutsubtypesOpt
            //
            case 26: {
                setResult(
                    new TypeMri(getLeftIToken(), getRightIToken(),
                                (Ident)getRhsSym(2),
                                (Withoutsubtypes)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 27:  withoutsubtypesOpt ::= $Empty
            //
            case 27: {
                setResult(null);
                break;
            } 
            //
            // Rule 28:  withoutsubtypesOpt ::= withoutsubtypes typeSetClauseOpt
            //
            case 28: {
                setResult(
                    new Withoutsubtypes(getLeftIToken(), getRightIToken(),
                                        (TypeSetClause)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 29:  typeSetClauseOpt ::= $Empty
            //
            case 29: {
                setResult(null);
                break;
            } 
            //
            // Rule 30:  typeSetClauseOpt ::= { typePathNameN }
            //
            case 30: {
                setResult(
                    new TypeSetClause(getLeftIToken(), getRightIToken(),
                                      (ItypePathNameN)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 31:  typePathNameN -> typePathName
            //
            case 31:
                break; 
            //
            // Rule 32:  typePathNameN ::= typePathName , typePathNameN
            //
            case 32: {
                setResult(
                    new TypePathNameN(getLeftIToken(), getRightIToken(),
                                      (ItypePathName)getRhsSym(1),
                                      (ItypePathNameN)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 33:  scopeClauseOpt ::= $Empty
            //
            case 33: {
                setResult(null);
                break;
            } 
            //
            // Rule 34:  scopeClauseOpt ::= notOpt in scopeClause
            //
            case 34: {
                setResult(
                    new ScopeClause(getLeftIToken(), getRightIToken(),
                                    (Not)getRhsSym(1),
                                    (IscopeClause)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 35:  scopeClause ::= partitions { identifierM }
            //
            case 35: {
                setResult(
                    new PartitionScope(getLeftIToken(), getRightIToken(),
                                       (IidentifierM)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 36:  scopeClause ::= containers { identifierM }
            //
            case 36: {
                setResult(
                    new ContainerScope(getLeftIToken(), getRightIToken(),
                                       (IidentifierM)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 37:  scopeClause ::= elements { identifierM }
            //
            case 37: {
                setResult(
                    new InElements(getLeftIToken(), getRightIToken(),
                                   (IidentifierM)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 38:  whereClauseM ::= $Empty
            //
            case 38: {
                setResult(null);
                break;
            } 
            //
            // Rule 39:  whereClauseM -> whereClauseN
            //
            case 39:
                break; 
            //
            // Rule 40:  whereClauseN -> whereClause
            //
            case 40:
                break; 
            //
            // Rule 41:  whereClauseN ::= whereClause whereClauseN
            //
            case 41: {
                setResult(
                    new WhereClauseN(getLeftIToken(), getRightIToken(),
                                     (WhereClause)getRhsSym(1),
                                     (IwhereClauseN)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 42:  whereClause ::= where whereEntry
            //
            case 42: {
                setResult(
                    new WhereClause(getLeftIToken(), getRightIToken(),
                                    (IwhereEntry)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 43:  whereEntry -> localWhereEntry
            //
            case 43:
                break; 
            //
            // Rule 44:  whereEntry -> joinWhereEntry
            //
            case 44:
                break; 
            //
            // Rule 45:  localWhereEntry ::= for identifier ( localWhereCondition )
            //
            case 45: {
                setResult(
                    new LocalWhereEntry(getLeftIToken(), getRightIToken(),
                                        (Ident)getRhsSym(2),
                                        (IlocalWhereCondition)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 46:  localWhereCondition -> negativeWhereCondition
            //
            case 46:
                break; 
            //
            // Rule 47:  localWhereCondition ::= localWhereCondition and negativeWhereCondition
            //
            case 47: {
                setResult(
                    new AndWhereCondition(getLeftIToken(), getRightIToken(),
                                          (IlocalWhereCondition)getRhsSym(1),
                                          (InegativeWhereCondition)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 48:  localWhereCondition ::= localWhereCondition or negativeWhereCondition
            //
            case 48: {
                setResult(
                    new OrWhereCondition(getLeftIToken(), getRightIToken(),
                                         (IlocalWhereCondition)getRhsSym(1),
                                         (InegativeWhereCondition)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 49:  negativeWhereCondition ::= not negativeWhereCondition
            //
            case 49: {
                setResult(
                    new NotWhereCondition(getLeftIToken(), getRightIToken(),
                                          (InegativeWhereCondition)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 50:  negativeWhereCondition -> operationCondition
            //
            case 50:
                break; 
            //
            // Rule 51:  operationCondition ::= identifier operationPart
            //
            case 51: {
                setResult(
                    new OperationCondition(getLeftIToken(), getRightIToken(),
                                           (Ident)getRhsSym(1),
                                           (IoperationPart)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 52:  operationCondition ::= ( localWhereCondition )
            //
            case 52: {
                setResult(
                    new ParenthesizedLocalWhereCondition(getLeftIToken(), getRightIToken(),
                                                         (IlocalWhereCondition)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 53:  operationPart ::= < literal
            //
            case 53: {
                setResult(
                    new OpSmaller(getLeftIToken(), getRightIToken(),
                                  (Iliteral)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 54:  operationPart ::= > literal
            //
            case 54: {
                setResult(
                    new OpGreater(getLeftIToken(), getRightIToken(),
                                  (Iliteral)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 55:  operationPart ::= <= literal
            //
            case 55: {
                setResult(
                    new OpSmallerEqual(getLeftIToken(), getRightIToken(),
                                       (Iliteral)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 56:  operationPart ::= >= literal
            //
            case 56: {
                setResult(
                    new OpGreaterEqual(getLeftIToken(), getRightIToken(),
                                       (Iliteral)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 57:  operationPart ::= = literal
            //
            case 57: {
                setResult(
                    new OpEqual(getLeftIToken(), getRightIToken(),
                                (Iliteral)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 58:  operationPart ::= <> literal
            //
            case 58: {
                setResult(
                    new OpNotEqual(getLeftIToken(), getRightIToken(),
                                   (Iliteral)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 59:  operationPart ::= like literal
            //
            case 59: {
                setResult(
                    new OpLike(getLeftIToken(), getRightIToken(),
                               (Iliteral)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 60:  operationPart ::= not like literal
            //
            case 60: {
                setResult(
                    new NotLike(getLeftIToken(), getRightIToken(),
                                (Iliteral)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 61:  literal ::= INTEGER_LITERAL
            //
            case 61: {
                setResult(
                    new IntegerLiteral(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 62:  literal ::= REAL_LITERAL
            //
            case 62: {
                setResult(
                    new RealLiteral(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 63:  literal ::= STRING_LITERAL
            //
            case 63: {
                setResult(
                    new StringLiteral(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 64:  literal ::= true
            //
            case 64: {
                setResult(
                    new TrueLiteral(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 65:  literal ::= false
            //
            case 65: {
                setResult(
                    new FalseLiteral(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 66:  literal ::= null
            //
            case 66: {
                setResult(
                    new NullLiteral(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 67:  joinWhereEntry ::= identifier . navigationStep joinPart
            //
            case 67: {
                setResult(
                    new JoinWhereEntry(getLeftIToken(), getRightIToken(),
                                       (Ident)getRhsSym(1),
                                       (InavigationStep)getRhsSym(3),
                                       (IjoinPart)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 68:  joinWhereEntry ::= identifier = identifier
            //
            case 68: {
                setResult(
                    new AliasComparisonClause(getLeftIToken(), getRightIToken(),
                                              (Ident)getRhsSym(1),
                                              (Ident)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 69:  navigationStep ::= identifier navigationDisambiguationOpt
            //
            case 69: {
                setResult(
                    new NameBasedNavigation(getLeftIToken(), getRightIToken(),
                                            (Ident)getRhsSym(1),
                                            (AssocNavigation)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 70:  navigationStep ::= INTEGER_LITERAL [ identifier ]
            //
            case 70: {
                setResult(
                    new MriBasedNavigation(getLeftIToken(), getRightIToken(),
                                           (Ident)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 71:  navigationDisambiguationOpt ::= $Empty
            //
            case 71: {
                setResult(null);
                break;
            } 
            //
            // Rule 72:  navigationDisambiguationOpt ::= [ pathName ]
            //
            case 72: {
                setResult(
                    new AssocNavigation(getLeftIToken(), getRightIToken(),
                                        (IpathName)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 73:  joinPart -> nonLinkPredicate
            //
            case 73:
                break; 
            //
            // Rule 74:  joinPart ::= notOpt in ( query )
            //
            case 74: {
                setResult(
                    new LinkPredicate(getLeftIToken(), getRightIToken(),
                                      (Not)getRhsSym(1),
                                      (MqlQuery)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 75:  nonLinkPredicate ::= = comparisonPostElementEquals
            //
            case 75: {
                setResult(
                    new AssocOrComparisonPredicate(getLeftIToken(), getRightIToken(),
                                                   (IcomparisonPostElementEquals)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 76:  nonLinkPredicate ::= < comparisonPostElementOtherOperation
            //
            case 76: {
                setResult(
                    new ComparisonSmallerPredicate(getLeftIToken(), getRightIToken(),
                                                   (IcomparisonPostElementOtherOperation)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 77:  nonLinkPredicate ::= > comparisonPostElementOtherOperation
            //
            case 77: {
                setResult(
                    new ComparisonGreaterPredicate(getLeftIToken(), getRightIToken(),
                                                   (IcomparisonPostElementOtherOperation)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 78:  nonLinkPredicate ::= <= comparisonPostElementOtherOperation
            //
            case 78: {
                setResult(
                    new ComparisonSmallerEqualPredicate(getLeftIToken(), getRightIToken(),
                                                        (IcomparisonPostElementOtherOperation)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 79:  nonLinkPredicate ::= >= comparisonPostElementOtherOperation
            //
            case 79: {
                setResult(
                    new ComparisonGreaterEqualPredicate(getLeftIToken(), getRightIToken(),
                                                        (IcomparisonPostElementOtherOperation)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 80:  nonLinkPredicate ::= <> comparisonPostElementOtherOperation
            //
            case 80: {
                setResult(
                    new ComparisonNotEqualPredicate(getLeftIToken(), getRightIToken(),
                                                    (IcomparisonPostElementOtherOperation)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 81:  nonLinkPredicate ::= like literal
            //
            case 81: {
                setResult(
                    new ComparisonLikePredicate(getLeftIToken(), getRightIToken(),
                                                (Iliteral)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 82:  nonLinkPredicate ::= not like literal
            //
            case 82: {
                setResult(
                    new ComparisonNotLikePredicate(getLeftIToken(), getRightIToken(),
                                                   (Iliteral)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 83:  comparisonPostElementEquals ::= literal
            //
            case 83: {
                setResult(
                    new LiteralEqualsComparisonInPredicate(getLeftIToken(), getRightIToken(),
                                                           (Iliteral)getRhsSym(1))
                );
                break;
            } 
            //
            // Rule 84:  comparisonPostElementEquals ::= identifier comparisonPostFix
            //
            case 84: {
                setResult(
                    new IdentifierEqualsComparisonInPredicate(getLeftIToken(), getRightIToken(),
                                                              (Ident)getRhsSym(1),
                                                              (ComparisonPredicate)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 85:  comparisonPostElementOtherOperation ::= literal
            //
            case 85: {
                setResult(
                    new LiteralComparisonInPredicate(getLeftIToken(), getRightIToken(),
                                                     (Iliteral)getRhsSym(1))
                );
                break;
            } 
            //
            // Rule 86:  comparisonPostElementOtherOperation ::= identifier . identifier
            //
            case 86: {
                setResult(
                    new IdentifierComparisonInPredicate(getLeftIToken(), getRightIToken(),
                                                        (Ident)getRhsSym(1),
                                                        (Ident)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 87:  comparisonPostFix ::= $Empty
            //
            case 87: {
                setResult(null);
                break;
            } 
            //
            // Rule 88:  comparisonPostFix ::= . identifier
            //
            case 88: {
                setResult(
                    new ComparisonPredicate(getLeftIToken(), getRightIToken(),
                                            (Ident)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 89:  notOpt ::= $Empty
            //
            case 89: {
                setResult(null);
                break;
            } 
            //
            // Rule 90:  notOpt ::= not
            //
            case 90: {
                setResult(
                    new Not(getRhsIToken(1))
                );
                break;
            }
    
            default:
                break;
        }
        return;
    }
}



