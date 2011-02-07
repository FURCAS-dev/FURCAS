/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
/**
   * This file is generated for MOIN-MQL with LPG. 
   */

package org.eclipse.emf.query2.internal.moinql.parser.gen;

import org.eclipse.emf.query2.exception.BaseException;
import org.eclipse.emf.query2.internal.moinql.parser.AstException;
import org.eclipse.emf.query2.internal.moinql.parser.LPGMessages;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.*;
import org.eclipse.emf.query2.internal.report.ProcessErrorImpl;
import org.eclipse.emf.query2.internal.report.ProcessWarningImpl;
import org.eclipse.emf.query2.report.LocalizedProcessException;
import org.eclipse.emf.query2.report.ProcessMessages;
import org.eclipse.emf.query2.report.ProcessReport;

import lpg.lpgjavaruntime.*;


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
            // Rule 7:  pathName -> identifierWithOptContainerPrefix
            //
            case 7:
                break; 
            //
            // Rule 8:  identifierWithOptContainerPrefix -> sPathName
            //
            case 8:
                break; 
            //
            // Rule 9:  typePathName -> pathName
            //
            case 9:
                break; 
            //
            // Rule 10:  query ::= selectClause fromClause whereClauseM
            //
            case 10: {
                setResult(
                    new MqlQuery(getLeftIToken(), getRightIToken(),
                                 (SelectClause)getRhsSym(1),
                                 (FromClause)getRhsSym(2),
                                 (IwhereClauseM)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 11:  query ::= $Empty
            //
            case 11: {
                setResult(null);
                break;
            } 
            //
            // Rule 12:  selectClause ::= select selectEntryN
            //
            case 12: {
                setResult(
                    new SelectClause(getLeftIToken(), getRightIToken(),
                                     (IselectEntryN)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 13:  selectEntryN ::= selectEntry , selectEntryN
            //
            case 13: {
                setResult(
                    new SelectEntryN(getLeftIToken(), getRightIToken(),
                                     (IselectEntry)getRhsSym(1),
                                     (IselectEntryN)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 14:  selectEntryN -> selectEntry
            //
            case 14:
                break; 
            //
            // Rule 15:  selectEntry ::= identifier
            //
            case 15: {
                setResult(
                    new SelectAlias(getLeftIToken(), getRightIToken(),
                                    (Ident)getRhsSym(1))
                );
                break;
            } 
            //
            // Rule 16:  selectEntry ::= identifier . identifier
            //
            case 16: {
                setResult(
                    new SelectAttribute(getLeftIToken(), getRightIToken(),
                                        (Ident)getRhsSym(1),
                                        (Ident)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 17:  fromClause ::= from fromEntryN
            //
            case 17: {
                setResult(
                    new FromClause(getLeftIToken(), getRightIToken(),
                                   (IfromEntryN)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 18:  fromEntryN ::= fromEntry , fromEntryN
            //
            case 18: {
                setResult(
                    new FromEntryN(getLeftIToken(), getRightIToken(),
                                   (FromEntry)getRhsSym(1),
                                   (IfromEntryN)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 19:  fromEntryN -> fromEntry
            //
            case 19:
                break; 
            //
            // Rule 20:  fromEntry ::= typeClause as identifier scopeClauseOpt
            //
            case 20: {
                setResult(
                    new FromEntry(getLeftIToken(), getRightIToken(),
                                  (TypeQName)getRhsSym(1),
                                  (Ident)getRhsSym(3),
                                  (ScopeClause)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 21:  typeClause -> typeClauseQName
            //
            case 21:
                break; 
            //
            // Rule 22:  typeClauseQName ::= fragmentaddress withoutsubtypesOpt
            //
            case 22: {
                setResult(
                    new TypeQName(getLeftIToken(), getRightIToken(),
                                  (FragmentAddress)getRhsSym(1),
                                  (Withoutsubtypes)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 23:  withoutsubtypesOpt ::= $Empty
            //
            case 23: {
                setResult(null);
                break;
            } 
            //
            // Rule 24:  withoutsubtypesOpt ::= withoutsubtypes typeSetClauseOpt
            //
            case 24: {
                setResult(
                    new Withoutsubtypes(getLeftIToken(), getRightIToken(),
                                        (TypeSetClause)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 25:  typeSetClauseOpt ::= $Empty
            //
            case 25: {
                setResult(null);
                break;
            } 
            //
            // Rule 26:  typeSetClauseOpt ::= { typePathNameN }
            //
            case 26: {
                setResult(
                    new TypeSetClause(getLeftIToken(), getRightIToken(),
                                      (ItypePathNameN)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 27:  typePathNameM ::= $Empty
            //
            case 27: {
                setResult(null);
                break;
            } 
            //
            // Rule 28:  typePathNameM -> typePathNameN
            //
            case 28:
                break; 
            //
            // Rule 29:  typePathNameN -> fragmentaddress
            //
            case 29:
                break; 
            //
            // Rule 30:  typePathNameN ::= fragmentaddress , typePathNameN
            //
            case 30: {
                setResult(
                    new TypePathNameN(getLeftIToken(), getRightIToken(),
                                      (FragmentAddress)getRhsSym(1),
                                      (ItypePathNameN)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 31:  elementPathNameM ::= $Empty
            //
            case 31: {
                setResult(null);
                break;
            } 
            //
            // Rule 32:  elementPathNameM -> elementPathNameN
            //
            case 32:
                break; 
            //
            // Rule 33:  elementPathNameN -> fragmentaddress
            //
            case 33:
                break; 
            //
            // Rule 34:  elementPathNameN ::= fragmentaddress , elementPathNameN
            //
            case 34: {
                setResult(
                    new ElementPathNameN(getLeftIToken(), getRightIToken(),
                                         (FragmentAddress)getRhsSym(1),
                                         (IelementPathNameN)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 35:  fragmentaddress ::= FRAGMENTADDRESS
            //
            case 35: {
                setResult(
                    new FragmentAddress(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 36:  uriM ::= $Empty
            //
            case 36: {
                setResult(null);
                break;
            } 
            //
            // Rule 37:  uriM -> uriN
            //
            case 37:
                break; 
            //
            // Rule 38:  uriN -> uri
            //
            case 38:
                break; 
            //
            // Rule 39:  uriN ::= uri , uriN
            //
            case 39: {
                setResult(
                    new UriN(getLeftIToken(), getRightIToken(),
                             (Uri)getRhsSym(1),
                             (IuriN)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 40:  uri ::= URI
            //
            case 40: {
                setResult(
                    new Uri(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 41:  scopeClauseOpt ::= $Empty
            //
            case 41: {
                setResult(null);
                break;
            } 
            //
            // Rule 42:  scopeClauseOpt ::= notOpt in scopeClause
            //
            case 42: {
                setResult(
                    new ScopeClause(getLeftIToken(), getRightIToken(),
                                    (Not)getRhsSym(1),
                                    (IscopeClause)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 43:  scopeClause ::= resources { uriM }
            //
            case 43: {
                setResult(
                    new PartitionScope(getLeftIToken(), getRightIToken(),
                                       (IuriM)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 44:  scopeClause ::= elements { elementPathNameM }
            //
            case 44: {
                setResult(
                    new InElements(getLeftIToken(), getRightIToken(),
                                   (IelementPathNameM)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 45:  whereClauseM ::= $Empty
            //
            case 45: {
                setResult(null);
                break;
            } 
            //
            // Rule 46:  whereClauseM -> whereClauseN
            //
            case 46:
                break; 
            //
            // Rule 47:  whereClauseN -> whereClause
            //
            case 47:
                break; 
            //
            // Rule 48:  whereClauseN ::= whereClause whereClauseN
            //
            case 48: {
                setResult(
                    new WhereClauseN(getLeftIToken(), getRightIToken(),
                                     (WhereClause)getRhsSym(1),
                                     (IwhereClauseN)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 49:  whereClause ::= where whereEntry
            //
            case 49: {
                setResult(
                    new WhereClause(getLeftIToken(), getRightIToken(),
                                    (IwhereEntry)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 50:  whereEntry -> localWhereEntry
            //
            case 50:
                break; 
            //
            // Rule 51:  whereEntry -> joinWhereEntry
            //
            case 51:
                break; 
            //
            // Rule 52:  localWhereEntry ::= for identifier ( localWhereCondition )
            //
            case 52: {
                setResult(
                    new LocalWhereEntry(getLeftIToken(), getRightIToken(),
                                        (Ident)getRhsSym(2),
                                        (IlocalWhereCondition)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 53:  localWhereCondition -> negativeWhereCondition
            //
            case 53:
                break; 
            //
            // Rule 54:  localWhereCondition ::= localWhereCondition and negativeWhereCondition
            //
            case 54: {
                setResult(
                    new AndWhereCondition(getLeftIToken(), getRightIToken(),
                                          (IlocalWhereCondition)getRhsSym(1),
                                          (InegativeWhereCondition)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 55:  localWhereCondition ::= localWhereCondition or negativeWhereCondition
            //
            case 55: {
                setResult(
                    new OrWhereCondition(getLeftIToken(), getRightIToken(),
                                         (IlocalWhereCondition)getRhsSym(1),
                                         (InegativeWhereCondition)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 56:  negativeWhereCondition ::= not negativeWhereCondition
            //
            case 56: {
                setResult(
                    new NotWhereCondition(getLeftIToken(), getRightIToken(),
                                          (InegativeWhereCondition)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 57:  negativeWhereCondition -> operationCondition
            //
            case 57:
                break; 
            //
            // Rule 58:  operationCondition ::= identifier operationPart
            //
            case 58: {
                setResult(
                    new OperationCondition(getLeftIToken(), getRightIToken(),
                                           (Ident)getRhsSym(1),
                                           (IoperationPart)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 59:  operationCondition ::= ( localWhereCondition )
            //
            case 59: {
                setResult(
                    new ParenthesizedLocalWhereCondition(getLeftIToken(), getRightIToken(),
                                                         (IlocalWhereCondition)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 60:  operationPart ::= < literal
            //
            case 60: {
                setResult(
                    new OpSmaller(getLeftIToken(), getRightIToken(),
                                  (Iliteral)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 61:  operationPart ::= > literal
            //
            case 61: {
                setResult(
                    new OpGreater(getLeftIToken(), getRightIToken(),
                                  (Iliteral)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 62:  operationPart ::= <= literal
            //
            case 62: {
                setResult(
                    new OpSmallerEqual(getLeftIToken(), getRightIToken(),
                                       (Iliteral)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 63:  operationPart ::= >= literal
            //
            case 63: {
                setResult(
                    new OpGreaterEqual(getLeftIToken(), getRightIToken(),
                                       (Iliteral)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 64:  operationPart ::= = literal
            //
            case 64: {
                setResult(
                    new OpEqual(getLeftIToken(), getRightIToken(),
                                (Iliteral)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 65:  operationPart ::= <> literal
            //
            case 65: {
                setResult(
                    new OpNotEqual(getLeftIToken(), getRightIToken(),
                                   (Iliteral)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 66:  operationPart ::= like literal
            //
            case 66: {
                setResult(
                    new OpLike(getLeftIToken(), getRightIToken(),
                               (Iliteral)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 67:  operationPart ::= not like literal
            //
            case 67: {
                setResult(
                    new NotLike(getLeftIToken(), getRightIToken(),
                                (Iliteral)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 68:  literal ::= INTEGER_LITERAL
            //
            case 68: {
                setResult(
                    new IntegerLiteral(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 69:  literal ::= REAL_LITERAL
            //
            case 69: {
                setResult(
                    new RealLiteral(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 70:  literal ::= STRING_LITERAL
            //
            case 70: {
                setResult(
                    new StringLiteral(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 71:  literal ::= true
            //
            case 71: {
                setResult(
                    new TrueLiteral(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 72:  literal ::= false
            //
            case 72: {
                setResult(
                    new FalseLiteral(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 73:  literal ::= null
            //
            case 73: {
                setResult(
                    new NullLiteral(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 74:  joinWhereEntry ::= identifier . navigationStep joinPart
            //
            case 74: {
                setResult(
                    new JoinWhereEntry(getLeftIToken(), getRightIToken(),
                                       (Ident)getRhsSym(1),
                                       (InavigationStep)getRhsSym(3),
                                       (IjoinPart)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 75:  joinWhereEntry ::= identifier = identifier
            //
            case 75: {
                setResult(
                    new AliasComparisonClause(getLeftIToken(), getRightIToken(),
                                              (Ident)getRhsSym(1),
                                              (Ident)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 76:  navigationStep ::= identifier
            //
            case 76: {
                setResult(
                    new NameBasedNavigation(getLeftIToken(), getRightIToken(),
                                            (Ident)getRhsSym(1))
                );
                break;
            } 
            //
            // Rule 77:  joinPart -> nonLinkPredicate
            //
            case 77:
                break; 
            //
            // Rule 78:  joinPart ::= notOpt in ( query )
            //
            case 78: {
                setResult(
                    new LinkPredicate(getLeftIToken(), getRightIToken(),
                                      (Not)getRhsSym(1),
                                      (MqlQuery)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 79:  nonLinkPredicate ::= = comparisonPostElementEquals
            //
            case 79: {
                setResult(
                    new AssocOrComparisonPredicate(getLeftIToken(), getRightIToken(),
                                                   (IcomparisonPostElementEquals)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 80:  nonLinkPredicate ::= < comparisonPostElementOtherOperation
            //
            case 80: {
                setResult(
                    new ComparisonSmallerPredicate(getLeftIToken(), getRightIToken(),
                                                   (IcomparisonPostElementOtherOperation)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 81:  nonLinkPredicate ::= > comparisonPostElementOtherOperation
            //
            case 81: {
                setResult(
                    new ComparisonGreaterPredicate(getLeftIToken(), getRightIToken(),
                                                   (IcomparisonPostElementOtherOperation)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 82:  nonLinkPredicate ::= <= comparisonPostElementOtherOperation
            //
            case 82: {
                setResult(
                    new ComparisonSmallerEqualPredicate(getLeftIToken(), getRightIToken(),
                                                        (IcomparisonPostElementOtherOperation)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 83:  nonLinkPredicate ::= >= comparisonPostElementOtherOperation
            //
            case 83: {
                setResult(
                    new ComparisonGreaterEqualPredicate(getLeftIToken(), getRightIToken(),
                                                        (IcomparisonPostElementOtherOperation)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 84:  nonLinkPredicate ::= <> comparisonPostElementOtherOperation
            //
            case 84: {
                setResult(
                    new ComparisonNotEqualPredicate(getLeftIToken(), getRightIToken(),
                                                    (IcomparisonPostElementOtherOperation)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 85:  nonLinkPredicate ::= like literal
            //
            case 85: {
                setResult(
                    new ComparisonLikePredicate(getLeftIToken(), getRightIToken(),
                                                (Iliteral)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 86:  nonLinkPredicate ::= not like literal
            //
            case 86: {
                setResult(
                    new ComparisonNotLikePredicate(getLeftIToken(), getRightIToken(),
                                                   (Iliteral)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 87:  comparisonPostElementEquals ::= literal
            //
            case 87: {
                setResult(
                    new LiteralEqualsComparisonInPredicate(getLeftIToken(), getRightIToken(),
                                                           (Iliteral)getRhsSym(1))
                );
                break;
            } 
            //
            // Rule 88:  comparisonPostElementEquals ::= identifier comparisonPostFix
            //
            case 88: {
                setResult(
                    new IdentifierEqualsComparisonInPredicate(getLeftIToken(), getRightIToken(),
                                                              (Ident)getRhsSym(1),
                                                              (ComparisonPredicate)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 89:  comparisonPostElementOtherOperation ::= literal
            //
            case 89: {
                setResult(
                    new LiteralComparisonInPredicate(getLeftIToken(), getRightIToken(),
                                                     (Iliteral)getRhsSym(1))
                );
                break;
            } 
            //
            // Rule 90:  comparisonPostElementOtherOperation ::= identifier . identifier
            //
            case 90: {
                setResult(
                    new IdentifierComparisonInPredicate(getLeftIToken(), getRightIToken(),
                                                        (Ident)getRhsSym(1),
                                                        (Ident)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 91:  comparisonPostFix ::= $Empty
            //
            case 91: {
                setResult(null);
                break;
            } 
            //
            // Rule 92:  comparisonPostFix ::= . identifier
            //
            case 92: {
                setResult(
                    new ComparisonPredicate(getLeftIToken(), getRightIToken(),
                                            (Ident)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 93:  notOpt ::= $Empty
            //
            case 93: {
                setResult(null);
                break;
            } 
            //
            // Rule 94:  notOpt ::= not
            //
            case 94: {
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



