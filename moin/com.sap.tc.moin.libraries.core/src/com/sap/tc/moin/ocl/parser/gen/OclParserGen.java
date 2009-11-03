/**
   * This file is generated for MOIN-OCL with LPG. 
   */

package com.sap.tc.moin.ocl.parser.gen;

import com.sap.tc.moin.ocl.parser.gen.oclAst.*;
import lpg.lpgjavaruntime.*;

import com.sap.tc.moin.repository.shared.util.parsers.AstException;
import com.sap.tc.moin.repository.shared.util.ProcessErrorImpl;
import com.sap.tc.moin.repository.shared.util.ProcessWarningImpl;
import com.sap.tc.moin.repository.shared.util.ProcessMessages;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.exception.MoinBaseException;
import com.sap.tc.moin.repository.shared.util.parsers.LPGMessages;
import com.sap.tc.moin.repository.shared.util.LocalizedProcessException;

public class OclParserGen extends PrsStream implements RuleAction
{
    private static ParseTable prs = new OclParserGenprs();
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

    public OclParserGen(LexStream lexStream)
    {
        super(lexStream);

        try
        {
            super.remapTerminalSymbols(orderedTerminalSymbols(), OclParserGenprs.EOFT_SYMBOL);
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
                sb.append(OclParserGensym.orderedTerminalSymbols[id.intValue()]);
                sb.append(", "); //$NON-NLS-1$               
            }                       
            throw new RuntimeException(LPGMessages.LPG_WILL_NOT_SCAN.format(sb.toString()));
        }
        catch(UndefinedEofSymbolException e)
        {
            throw new RuntimeException(new UndefinedEofSymbolException
                                (LPGMessages.LPG_LEX_DOESNTIMPLEMENT_EOF.format(
                                 OclParserGensym.orderedTerminalSymbols[OclParserGenprs.EOFT_SYMBOL])));
        } 
    }

    public String[] orderedTerminalSymbols() { return OclParserGensym.orderedTerminalSymbols; }
    public String getTokenKindName(int kind) { return OclParserGensym.orderedTerminalSymbols[kind]; }            
    public int getEOFTokenKind() { return OclParserGenprs.EOFT_SYMBOL; }
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
                                (LPGMessages.LPG_REGENERATE_NOBACKTRACK.format( "OclParserGenprs.java" ))); //$NON-NLS-1$
        }
        catch (BadParseSymFileException e)
        {
            throw new RuntimeException(new BadParseSymFileException(LPGMessages.LPG_BAD_SYMFILE.format("OclParserGensym.java", "OclParserGenprs.java")));  //$NON-NLS-1$  //$NON-NLS-2$
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

  // special OCL constructor
  public OclParserGen(LexStream lexStream, ProcessReport _report)
    {
        super(lexStream);
        this.report = _report;
        parserGenStart(lexStream, OclParserGenprs.EOFT_SYMBOL, OclParserGensym.orderedTerminalSymbols);
    }

    public void ruleAction(int ruleNumber)
    {
        switch (ruleNumber)
        {
 
            //
            // Rule 1:  identifier ::= IDENTIFIER
            //
            case 1: {
                setResult(
                    new Ident(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 2:  identifierOpt ::= $Empty
            //
            case 2: {
                setResult(null);
                break;
            } 
            //
            // Rule 3:  identifierOpt -> identifier
            //
            case 3:
                break; 
            //
            // Rule 4:  sPathName ::= identifier
            //
            case 4: {
                setResult(
                    new PathNameIdent(getLeftIToken(), getRightIToken(),
                                      (Ident)getRhsSym(1))
                );
                break;
            } 
            //
            // Rule 5:  sPathName ::= identifier :: sPathName
            //
            case 5: {
                setResult(
                    new PathNames(getLeftIToken(), getRightIToken(),
                                  (Ident)getRhsSym(1),
                                  (IsPathName)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 6:  pathName -> identifierWithOptContainerPrefix
            //
            case 6:
                break; 
            //
            // Rule 7:  identifierWithOptContainerPrefix -> sPathName
            //
            case 7:
                break; 
            //
            // Rule 8:  identifierWithOptContainerPrefix ::= identifier # sPathName
            //
            case 8: {
                setResult(
                    new ContainerNamePrefix(getLeftIToken(), getRightIToken(),
                                            (Ident)getRhsSym(1),
                                            (IsPathName)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 9:  typePathName -> typeLiteral
            //
            case 9:
                break; 
            //
            // Rule 10:  typePathName -> pathName
            //
            case 10:
                break; 
            //
            // Rule 11:  variableDeclaration ::= identifier withTypeExpressionOpt
            //
            case 11: {
                setResult(
                    new VariableDeclaration(getLeftIToken(), getRightIToken(),
                                            (Ident)getRhsSym(1),
                                            (WithTypeExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 12:  withTypeExpression ::= : typePathName
            //
            case 12: {
                setResult(
                    new WithTypeExpression(getLeftIToken(), getRightIToken(),
                                           (ItypePathName)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 13:  withTypeExpressionOpt -> withTypeExpression
            //
            case 13:
                break; 
            //
            // Rule 14:  withTypeExpressionOpt ::= $Empty
            //
            case 14: {
                setResult(null);
                break;
            } 
            //
            // Rule 15:  variableDeclarationWithType ::= identifier withTypeExpression
            //
            case 15: {
                setResult(
                    new VariableDeclarationWithType(getLeftIToken(), getRightIToken(),
                                                    (Ident)getRhsSym(1),
                                                    (WithTypeExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 16:  variableDeclarationWithTypeM ::= $Empty
            //
            case 16: {
                setResult(null);
                break;
            } 
            //
            // Rule 17:  variableDeclarationWithTypeM -> variableDeclarationWithTypeN
            //
            case 17:
                break; 
            //
            // Rule 18:  variableDeclarationWithTypeN -> variableDeclarationWithType
            //
            case 18:
                break; 
            //
            // Rule 19:  variableDeclarationWithTypeN ::= variableDeclarationWithType , variableDeclarationWithTypeN
            //
            case 19: {
                setResult(
                    new VariableDeclarationWithTypeN(getLeftIToken(), getRightIToken(),
                                                     (VariableDeclarationWithType)getRhsSym(1),
                                                     (IvariableDeclarationWithTypeN)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 20:  typeLiteral -> collectionType
            //
            case 20:
                break; 
            //
            // Rule 21:  typeLiteral -> tupleType
            //
            case 21:
                break; 
            //
            // Rule 22:  typeLiteral -> primitiveType
            //
            case 22:
                break; 
            //
            // Rule 23:  primitiveType ::= Integer
            //
            case 23: {
                setResult(
                    new PrimTypeInteger(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 24:  primitiveType ::= String
            //
            case 24: {
                setResult(
                    new PrimTypeString(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 25:  primitiveType ::= Real
            //
            case 25: {
                setResult(
                    new PrimTypeReal(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 26:  primitiveType ::= Float
            //
            case 26: {
                setResult(
                    new PrimTypeFloat(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 27:  primitiveType ::= Double
            //
            case 27: {
                setResult(
                    new PrimTypeDouble(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 28:  primitiveType ::= Boolean
            //
            case 28: {
                setResult(
                    new PrimTypeBoolean(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 29:  primitiveType ::= OclAny
            //
            case 29: {
                setResult(
                    new PrimTypeOclAny(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 30:  primitiveType ::= OclVoid
            //
            case 30: {
                setResult(
                    new PrimTypeOclVoid(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 31:  primitiveType ::= OclInvalid
            //
            case 31: {
                setResult(
                    new PrimTypeOclInvalid(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 32:  collectionType ::= collectionKind ( typePathName )
            //
            case 32: {
                setResult(
                    new CollectionType(getLeftIToken(), getRightIToken(),
                                       (IcollectionKind)getRhsSym(1),
                                       (ItypePathName)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 33:  collectionKind ::= Set
            //
            case 33: {
                setResult(
                    new SetKind(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 34:  collectionKind ::= Bag
            //
            case 34: {
                setResult(
                    new BagKind(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 35:  collectionKind ::= Sequence
            //
            case 35: {
                setResult(
                    new SequenceKind(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 36:  collectionKind ::= OrderedSet
            //
            case 36: {
                setResult(
                    new OrderedSetKind(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 37:  collectionKind ::= Collection
            //
            case 37: {
                setResult(
                    new CollectionKind(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 38:  tupleType ::= Tuple ( variableDeclarationWithTypeM )
            //
            case 38: {
                setResult(
                    new TupleType(getLeftIToken(), getRightIToken(),
                                  (IvariableDeclarationWithTypeM)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 39:  oclFile -> packageDeclarationN
            //
            case 39:
                break; 
            //
            // Rule 40:  oclFile -> contextDeclarationN
            //
            case 40:
                break; 
            //
            // Rule 41:  oclFile ::= contextBody
            //
            case 41: {
                setResult(
                    new ContextBodyOclFile(getLeftIToken(), getRightIToken(),
                                           (IcontextBody)getRhsSym(1))
                );
                break;
            } 
            //
            // Rule 42:  oclFile ::= oclExpression
            //
            case 42: {
                setResult(
                    new OclFileOclExpression(getLeftIToken(), getRightIToken(),
                                             (IoclExpression)getRhsSym(1))
                );
                break;
            } 
            //
            // Rule 43:  oclFile ::= $Empty
            //
            case 43: {
                setResult(null);
                break;
            } 
            //
            // Rule 44:  contextBody -> initOrDerValue
            //
            case 44:
                break; 
            //
            // Rule 45:  contextBody -> invOrDef
            //
            case 45:
                break; 
            //
            // Rule 46:  contextBody -> prePostOrBodyDecl
            //
            case 46:
                break; 
            //
            // Rule 47:  packageDeclarationN -> packageDeclaration
            //
            case 47:
                break; 
            //
            // Rule 48:  packageDeclarationN ::= packageDeclarationN packageDeclaration
            //
            case 48: {
                setResult(
                    new PackageDeclarations(getLeftIToken(), getRightIToken(),
                                            (IpackageDeclarationN)getRhsSym(1),
                                            (PackageDeclaration)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 49:  packageDeclaration ::= package sPathName contextDeclarationM endpackage
            //
            case 49: {
                setResult(
                    new PackageDeclaration(getLeftIToken(), getRightIToken(),
                                           (IsPathName)getRhsSym(2),
                                           (IcontextDeclarationM)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 50:  contextDeclarationM ::= $Empty
            //
            case 50: {
                setResult(null);
                break;
            } 
            //
            // Rule 51:  contextDeclarationM -> contextDeclarationN
            //
            case 51:
                break; 
            //
            // Rule 52:  contextDeclarationN -> contextDeclaration
            //
            case 52:
                break; 
            //
            // Rule 53:  contextDeclarationN ::= contextDeclarationN contextDeclaration
            //
            case 53: {
                setResult(
                    new ContextDeclarations(getLeftIToken(), getRightIToken(),
                                            (IcontextDeclarationN)getRhsSym(1),
                                            (IcontextDeclaration)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 54:  contextDeclaration -> attrOrAssocContext
            //
            case 54:
                break; 
            //
            // Rule 55:  contextDeclaration -> classifierContextDecl
            //
            case 55:
                break; 
            //
            // Rule 56:  contextDeclaration -> operationContextDecl
            //
            case 56:
                break; 
            //
            // Rule 57:  attrOrAssocContext ::= context sPathName withTypeExpression initOrDerValueN
            //
            case 57: {
                setResult(
                    new AttrOrAssocContextDecl(getLeftIToken(), getRightIToken(),
                                               (IsPathName)getRhsSym(2),
                                               (WithTypeExpression)getRhsSym(3),
                                               (IinitOrDerValueN)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 58:  initOrDerValueN -> initOrDerValue
            //
            case 58:
                break; 
            //
            // Rule 59:  initOrDerValueN ::= initOrDerValueN initOrDerValue
            //
            case 59: {
                setResult(
                    new InitOrDerValueN(getLeftIToken(), getRightIToken(),
                                        (IinitOrDerValueN)getRhsSym(1),
                                        (IinitOrDerValue)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 60:  initOrDerValue ::= init : oclExpression
            //
            case 60: {
                setResult(
                    new InitValue(getLeftIToken(), getRightIToken(),
                                  (IoclExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 61:  initOrDerValue ::= derive : oclExpression
            //
            case 61: {
                setResult(
                    new DeriveValue(getLeftIToken(), getRightIToken(),
                                    (IoclExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 62:  classifierContextDecl ::= context sPathName invOrDefN
            //
            case 62: {
                setResult(
                    new ClassifierContextDecl(getLeftIToken(), getRightIToken(),
                                              (IsPathName)getRhsSym(2),
                                              (IinvOrDefN)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 63:  invOrDefN -> invOrDef
            //
            case 63:
                break; 
            //
            // Rule 64:  invOrDefN ::= invOrDefN invOrDef
            //
            case 64: {
                setResult(
                    new InvOrDefs(getLeftIToken(), getRightIToken(),
                                  (IinvOrDefN)getRhsSym(1),
                                  (IinvOrDef)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 65:  invOrDef ::= inv identifierOpt : oclExpression
            //
            case 65: {
                setResult(
                    new InvDeclaration(getLeftIToken(), getRightIToken(),
                                       (Ident)getRhsSym(2),
                                       (IoclExpression)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 66:  invOrDef ::= def identifierOpt : defExpression
            //
            case 66: {
                setResult(
                    new DefDeclaration(getLeftIToken(), getRightIToken(),
                                       (Ident)getRhsSym(2),
                                       (IdefExpression)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 67:  invOrDef ::= exp identifierOpt : oclExpression
            //
            case 67: {
                setResult(
                    new ExpDeclaration(getLeftIToken(), getRightIToken(),
                                       (Ident)getRhsSym(2),
                                       (IoclExpression)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 68:  defExpression -> variableAssignmentWithType
            //
            case 68:
                break; 
            //
            // Rule 69:  defExpression ::= operation = oclExpression
            //
            case 69: {
                setResult(
                    new OperationDefExpression(getLeftIToken(), getRightIToken(),
                                               (OperationDecl)getRhsSym(1),
                                               (IoclExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 70:  operationContextDecl ::= context operation prePostOrBodyDeclN
            //
            case 70: {
                setResult(
                    new OperationContextDecl(getLeftIToken(), getRightIToken(),
                                             (OperationDecl)getRhsSym(2),
                                             (IprePostOrBodyDeclN)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 71:  prePostOrBodyDeclN -> prePostOrBodyDecl
            //
            case 71:
                break; 
            //
            // Rule 72:  prePostOrBodyDeclN ::= prePostOrBodyDeclN prePostOrBodyDecl
            //
            case 72: {
                setResult(
                    new PrePostOrBodyDecls(getLeftIToken(), getRightIToken(),
                                           (IprePostOrBodyDeclN)getRhsSym(1),
                                           (IprePostOrBodyDecl)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 73:  prePostOrBodyDecl ::= pre identifierOpt : oclExpression
            //
            case 73: {
                setResult(
                    new PreConditionDecl(getLeftIToken(), getRightIToken(),
                                         (Ident)getRhsSym(2),
                                         (IoclExpression)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 74:  prePostOrBodyDecl ::= post identifierOpt : oclExpression
            //
            case 74: {
                setResult(
                    new PostConditionDecl(getLeftIToken(), getRightIToken(),
                                          (Ident)getRhsSym(2),
                                          (IoclExpression)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 75:  prePostOrBodyDecl ::= body identifierOpt : oclExpression
            //
            case 75: {
                setResult(
                    new BodyDecl(getLeftIToken(), getRightIToken(),
                                 (Ident)getRhsSym(2),
                                 (IoclExpression)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 76:  operation ::= sPathName ( variableDeclarationWithTypeM ) withTypeExpression
            //
            case 76: {
                setResult(
                    new OperationDecl(getLeftIToken(), getRightIToken(),
                                      (IsPathName)getRhsSym(1),
                                      (IvariableDeclarationWithTypeM)getRhsSym(3),
                                      (WithTypeExpression)getRhsSym(5))
                );
                break;
            } 
            //
            // Rule 77:  oclExpression -> letExpression
            //
            case 77:
                break; 
            //
            // Rule 78:  oclExpression -> logicalExpression
            //
            case 78:
                break; 
            //
            // Rule 79:  letExpression ::= let variableAssignmentN in oclExpression
            //
            case 79: {
                setResult(
                    new LetExpression(getLeftIToken(), getRightIToken(),
                                      (IvariableAssignmentN)getRhsSym(2),
                                      (IoclExpression)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 80:  variableAssignmentM ::= $Empty
            //
            case 80: {
                setResult(null);
                break;
            } 
            //
            // Rule 81:  variableAssignmentM -> variableAssignmentN
            //
            case 81:
                break; 
            //
            // Rule 82:  variableAssignmentN -> variableAssignment
            //
            case 82:
                break; 
            //
            // Rule 83:  variableAssignmentN ::= variableAssignment , variableAssignmentN
            //
            case 83: {
                setResult(
                    new VariableAssignmentN(getLeftIToken(), getRightIToken(),
                                            (VariableAssignment)getRhsSym(1),
                                            (IvariableAssignmentN)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 84:  variableAssignment ::= identifier withTypeExpressionOpt = oclExpression
            //
            case 84: {
                setResult(
                    new VariableAssignment(getLeftIToken(), getRightIToken(),
                                           (Ident)getRhsSym(1),
                                           (WithTypeExpression)getRhsSym(2),
                                           (IoclExpression)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 85:  variableAssignmentWithType ::= identifier withTypeExpression = oclExpression
            //
            case 85: {
                setResult(
                    new VariableAssignmentWithType(getLeftIToken(), getRightIToken(),
                                                   (Ident)getRhsSym(1),
                                                   (WithTypeExpression)getRhsSym(2),
                                                   (IoclExpression)getRhsSym(4))
                );
                break;
            } 
            //
            // Rule 86:  varPathName ::= self
            //
            case 86: {
                setResult(
                    new Self(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 87:  varPathName ::= typeLiteral
            //
            case 87: {
                setResult(
                    new TypeLiteral(getLeftIToken(), getRightIToken(),
                                    (ItypeLiteral)getRhsSym(1))
                );
                break;
            } 
            //
            // Rule 88:  varPathName ::= pathName timeExpressionOpt associationQualifierOpt
            //
            case 88: {
                setResult(
                    new Variable(getLeftIToken(), getRightIToken(),
                                 (IpathName)getRhsSym(1),
                                 (TimeExpressionOpt)getRhsSym(2),
                                 (AssociationQualifier)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 89:  logicalExpression -> booleanExpression
            //
            case 89:
                break; 
            //
            // Rule 90:  logicalExpression ::= logicalExpression implies booleanExpression
            //
            case 90: {
                setResult(
                    new LogicalExpression(getLeftIToken(), getRightIToken(),
                                          (IlogicalExpression)getRhsSym(1),
                                          (IbooleanExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 91:  booleanExpression -> relationalExpression
            //
            case 91:
                break; 
            //
            // Rule 92:  booleanExpression ::= booleanExpression and relationalExpression
            //
            case 92: {
                setResult(
                    new AndBooleanExpression(getLeftIToken(), getRightIToken(),
                                             (IbooleanExpression)getRhsSym(1),
                                             (IrelationalExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 93:  booleanExpression ::= booleanExpression or relationalExpression
            //
            case 93: {
                setResult(
                    new OrBooleanExpression(getLeftIToken(), getRightIToken(),
                                            (IbooleanExpression)getRhsSym(1),
                                            (IrelationalExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 94:  booleanExpression ::= booleanExpression xor relationalExpression
            //
            case 94: {
                setResult(
                    new XorBooleanExpression(getLeftIToken(), getRightIToken(),
                                             (IbooleanExpression)getRhsSym(1),
                                             (IrelationalExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 95:  relationalExpression -> compareableExpression
            //
            case 95:
                break; 
            //
            // Rule 96:  relationalExpression ::= relationalExpression = compareableExpression
            //
            case 96: {
                setResult(
                    new EqualRelationalExpression(getLeftIToken(), getRightIToken(),
                                                  (IrelationalExpression)getRhsSym(1),
                                                  (IcompareableExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 97:  relationalExpression ::= relationalExpression <> compareableExpression
            //
            case 97: {
                setResult(
                    new NotEqualRelationalExpression(getLeftIToken(), getRightIToken(),
                                                     (IrelationalExpression)getRhsSym(1),
                                                     (IcompareableExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 98:  relationalExpression ::= relationalExpression > compareableExpression
            //
            case 98: {
                setResult(
                    new GreaterRelationalExpression(getLeftIToken(), getRightIToken(),
                                                    (IrelationalExpression)getRhsSym(1),
                                                    (IcompareableExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 99:  relationalExpression ::= relationalExpression < compareableExpression
            //
            case 99: {
                setResult(
                    new LessRelationalExpression(getLeftIToken(), getRightIToken(),
                                                 (IrelationalExpression)getRhsSym(1),
                                                 (IcompareableExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 100:  relationalExpression ::= relationalExpression >= compareableExpression
            //
            case 100: {
                setResult(
                    new GreaterEqualRelationalExpression(getLeftIToken(), getRightIToken(),
                                                         (IrelationalExpression)getRhsSym(1),
                                                         (IcompareableExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 101:  relationalExpression ::= relationalExpression <= compareableExpression
            //
            case 101: {
                setResult(
                    new LessEqualRelationalExpression(getLeftIToken(), getRightIToken(),
                                                      (IrelationalExpression)getRhsSym(1),
                                                      (IcompareableExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 102:  compareableExpression -> additiveExpression
            //
            case 102:
                break; 
            //
            // Rule 103:  compareableExpression -> ifExpression
            //
            case 103:
                break; 
            //
            // Rule 104:  ifExpression ::= if oclExpression then oclExpression else oclExpression endif
            //
            case 104: {
                setResult(
                    new IfExpression(getLeftIToken(), getRightIToken(),
                                     (IoclExpression)getRhsSym(2),
                                     (IoclExpression)getRhsSym(4),
                                     (IoclExpression)getRhsSym(6))
                );
                break;
            } 
            //
            // Rule 105:  additiveExpression -> multiplicativeExpression
            //
            case 105:
                break; 
            //
            // Rule 106:  additiveExpression ::= additiveExpression + multiplicativeExpression
            //
            case 106: {
                setResult(
                    new PlusAdditiveExpression(getLeftIToken(), getRightIToken(),
                                               (IadditiveExpression)getRhsSym(1),
                                               (ImultiplicativeExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 107:  additiveExpression ::= additiveExpression - multiplicativeExpression
            //
            case 107: {
                setResult(
                    new MinusAdditiveExpression(getLeftIToken(), getRightIToken(),
                                                (IadditiveExpression)getRhsSym(1),
                                                (ImultiplicativeExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 108:  multiplicativeExpression -> unaryExpression
            //
            case 108:
                break; 
            //
            // Rule 109:  multiplicativeExpression ::= multiplicativeExpression * unaryExpression
            //
            case 109: {
                setResult(
                    new MultMultiplicativeExpression(getLeftIToken(), getRightIToken(),
                                                     (ImultiplicativeExpression)getRhsSym(1),
                                                     (IunaryExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 110:  multiplicativeExpression ::= multiplicativeExpression / unaryExpression
            //
            case 110: {
                setResult(
                    new DivideMultiplicativeExpression(getLeftIToken(), getRightIToken(),
                                                       (ImultiplicativeExpression)getRhsSym(1),
                                                       (IunaryExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 111:  unaryExpression -> postfixExpression
            //
            case 111:
                break; 
            //
            // Rule 112:  unaryExpression ::= - unaryExpression
            //
            case 112: {
                setResult(
                    new MinusUnaryExpression(getLeftIToken(), getRightIToken(),
                                             (IunaryExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 113:  unaryExpression ::= not unaryExpression
            //
            case 113: {
                setResult(
                    new NotUnaryExpression(getLeftIToken(), getRightIToken(),
                                           (IunaryExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 114:  postfixExpression -> primaryExpression
            //
            case 114:
                break; 
            //
            // Rule 115:  postfixExpression ::= postfixExpression propertyInvocation
            //
            case 115: {
                setResult(
                    new PostfixExpression(getLeftIToken(), getRightIToken(),
                                          (IpostfixExpression)getRhsSym(1),
                                          (IpropertyInvocation)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 116:  primaryExpression -> nonEnumLiteral
            //
            case 116:
                break; 
            //
            // Rule 117:  primaryExpression -> operationCall
            //
            case 117:
                break; 
            //
            // Rule 118:  primaryExpression -> varPathName
            //
            case 118:
                break; 
            //
            // Rule 119:  primaryExpression ::= ( oclExpression )
            //
            case 119: {
                setResult(
                    new ParenthesizedPrimaryExpression(getLeftIToken(), getRightIToken(),
                                                       (IoclExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 120:  propertyInvocation ::= . propertyCall
            //
            case 120: {
                setResult(
                    new ObjectPropertyInvocation(getLeftIToken(), getRightIToken(),
                                                 (IpropertyCall)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 121:  propertyInvocation ::= -> propertyCall
            //
            case 121: {
                setResult(
                    new CollectionPropertyInvocation(getLeftIToken(), getRightIToken(),
                                                     (IpropertyCall)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 122:  propertyInvocation ::= -> loopExp
            //
            case 122: {
                setResult(
                    new LoopPropertyInvocation(getLeftIToken(), getRightIToken(),
                                               (IloopExp)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 123:  propertyCall -> operationCall
            //
            case 123:
                break; 
            //
            // Rule 124:  propertyCall -> attrOrNavCall
            //
            case 124:
                break; 
            //
            // Rule 125:  operationCall ::= pathName timeExpressionOpt arguments
            //
            case 125: {
                setResult(
                    new OperationCall(getLeftIToken(), getRightIToken(),
                                      (IpathName)getRhsSym(1),
                                      (TimeExpressionOpt)getRhsSym(2),
                                      (Iarguments)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 126:  operationCall ::= oclIsUndefined timeExpressionOpt arguments
            //
            case 126: {
                setResult(
                    new CallOclIsUndefined(getLeftIToken(), getRightIToken(),
                                           (TimeExpressionOpt)getRhsSym(2),
                                           (Iarguments)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 127:  operationCall ::= oclIsInvalid timeExpressionOpt arguments
            //
            case 127: {
                setResult(
                    new CallOclIsInvalid(getLeftIToken(), getRightIToken(),
                                         (TimeExpressionOpt)getRhsSym(2),
                                         (Iarguments)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 128:  operationCall ::= allInstances timeExpressionOpt arguments
            //
            case 128: {
                setResult(
                    new CallAllInstances(getLeftIToken(), getRightIToken(),
                                         (TimeExpressionOpt)getRhsSym(2),
                                         (Iarguments)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 129:  operationCall ::= oclAsType timeExpressionOpt arguments
            //
            case 129: {
                setResult(
                    new CallOclAsType(getLeftIToken(), getRightIToken(),
                                      (TimeExpressionOpt)getRhsSym(2),
                                      (Iarguments)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 130:  operationCall ::= oclIsKindOf timeExpressionOpt arguments
            //
            case 130: {
                setResult(
                    new CallOclIsKindOf(getLeftIToken(), getRightIToken(),
                                        (TimeExpressionOpt)getRhsSym(2),
                                        (Iarguments)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 131:  operationCall ::= oclIsTypeOf timeExpressionOpt arguments
            //
            case 131: {
                setResult(
                    new CallOclIsTypeOf(getLeftIToken(), getRightIToken(),
                                        (TimeExpressionOpt)getRhsSym(2),
                                        (Iarguments)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 132:  operationCall ::= = timeExpressionOpt arguments
            //
            case 132: {
                setResult(
                    new CallEqual(getLeftIToken(), getRightIToken(),
                                  (TimeExpressionOpt)getRhsSym(2),
                                  (Iarguments)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 133:  operationCall ::= <> timeExpressionOpt arguments
            //
            case 133: {
                setResult(
                    new CallNotEqual(getLeftIToken(), getRightIToken(),
                                     (TimeExpressionOpt)getRhsSym(2),
                                     (Iarguments)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 134:  operationCall ::= + timeExpressionOpt arguments
            //
            case 134: {
                setResult(
                    new CallPlus(getLeftIToken(), getRightIToken(),
                                 (TimeExpressionOpt)getRhsSym(2),
                                 (Iarguments)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 135:  operationCall ::= * timeExpressionOpt arguments
            //
            case 135: {
                setResult(
                    new CallMult(getLeftIToken(), getRightIToken(),
                                 (TimeExpressionOpt)getRhsSym(2),
                                 (Iarguments)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 136:  operationCall ::= / timeExpressionOpt arguments
            //
            case 136: {
                setResult(
                    new CallDivide(getLeftIToken(), getRightIToken(),
                                   (TimeExpressionOpt)getRhsSym(2),
                                   (Iarguments)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 137:  operationCall ::= > timeExpressionOpt arguments
            //
            case 137: {
                setResult(
                    new CallGreater(getLeftIToken(), getRightIToken(),
                                    (TimeExpressionOpt)getRhsSym(2),
                                    (Iarguments)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 138:  operationCall ::= < timeExpressionOpt arguments
            //
            case 138: {
                setResult(
                    new CallLess(getLeftIToken(), getRightIToken(),
                                 (TimeExpressionOpt)getRhsSym(2),
                                 (Iarguments)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 139:  operationCall ::= >= timeExpressionOpt arguments
            //
            case 139: {
                setResult(
                    new CallGreaterEqual(getLeftIToken(), getRightIToken(),
                                         (TimeExpressionOpt)getRhsSym(2),
                                         (Iarguments)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 140:  operationCall ::= <= timeExpressionOpt arguments
            //
            case 140: {
                setResult(
                    new CallLessEqual(getLeftIToken(), getRightIToken(),
                                      (TimeExpressionOpt)getRhsSym(2),
                                      (Iarguments)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 141:  operationCall ::= and timeExpressionOpt arguments
            //
            case 141: {
                setResult(
                    new CallAnd(getLeftIToken(), getRightIToken(),
                                (TimeExpressionOpt)getRhsSym(2),
                                (Iarguments)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 142:  operationCall ::= or timeExpressionOpt arguments
            //
            case 142: {
                setResult(
                    new CallOr(getLeftIToken(), getRightIToken(),
                               (TimeExpressionOpt)getRhsSym(2),
                               (Iarguments)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 143:  operationCall ::= xor timeExpressionOpt arguments
            //
            case 143: {
                setResult(
                    new CallXor(getLeftIToken(), getRightIToken(),
                                (TimeExpressionOpt)getRhsSym(2),
                                (Iarguments)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 144:  arguments ::= ( )
            //
            case 144: {
                setResult(
                    new NoArguments(getLeftIToken(), getRightIToken())
                );
                break;
            } 
            //
            // Rule 145:  arguments ::= ( argumentN )
            //
            case 145: {
                setResult(
                    new MultipleArguments(getLeftIToken(), getRightIToken(),
                                          (IargumentN)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 146:  attrOrNavCall ::= pathName timeExpressionOpt associationQualifierOpt
            //
            case 146: {
                setResult(
                    new AttrOrNavCall(getLeftIToken(), getRightIToken(),
                                      (IpathName)getRhsSym(1),
                                      (TimeExpressionOpt)getRhsSym(2),
                                      (AssociationQualifier)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 147:  associationQualifierOpt ::= $Empty
            //
            case 147: {
                setResult(null);
                break;
            } 
            //
            // Rule 148:  associationQualifierOpt -> associationQualifier
            //
            case 148:
                break; 
            //
            // Rule 149:  associationQualifier ::= [ pathName ]
            //
            case 149: {
                setResult(
                    new AssociationQualifier(getLeftIToken(), getRightIToken(),
                                             (IpathName)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 150:  loopExp -> iteratorExp
            //
            case 150:
                break; 
            //
            // Rule 151:  loopExp -> iterateExp
            //
            case 151:
                break; 
            //
            // Rule 152:  iteratorExp ::= forAll ( iterContents )
            //
            case 152: {
                setResult(
                    new IteratorForAll(getLeftIToken(), getRightIToken(),
                                       (IiterContents)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 153:  iteratorExp ::= exists ( iterContents )
            //
            case 153: {
                setResult(
                    new IteratorExists(getLeftIToken(), getRightIToken(),
                                       (IiterContents)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 154:  iteratorExp ::= isUnique ( iterContents )
            //
            case 154: {
                setResult(
                    new IteratorIsUnique(getLeftIToken(), getRightIToken(),
                                         (IiterContents)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 155:  iteratorExp ::= one ( iterContents )
            //
            case 155: {
                setResult(
                    new IteratorOne(getLeftIToken(), getRightIToken(),
                                    (IiterContents)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 156:  iteratorExp ::= any ( iterContents )
            //
            case 156: {
                setResult(
                    new IteratorAny(getLeftIToken(), getRightIToken(),
                                    (IiterContents)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 157:  iteratorExp ::= collect ( iterContents )
            //
            case 157: {
                setResult(
                    new IteratorCollect(getLeftIToken(), getRightIToken(),
                                        (IiterContents)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 158:  iteratorExp ::= select ( iterContents )
            //
            case 158: {
                setResult(
                    new IteratorSelect(getLeftIToken(), getRightIToken(),
                                       (IiterContents)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 159:  iteratorExp ::= reject ( iterContents )
            //
            case 159: {
                setResult(
                    new IteratorReject(getLeftIToken(), getRightIToken(),
                                       (IiterContents)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 160:  iteratorExp ::= collectNested ( iterContents )
            //
            case 160: {
                setResult(
                    new IteratorCollectNested(getLeftIToken(), getRightIToken(),
                                              (IiterContents)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 161:  iteratorExp ::= sortedBy ( iterContents )
            //
            case 161: {
                setResult(
                    new IteratorSortedBy(getLeftIToken(), getRightIToken(),
                                         (IiterContents)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 162:  iterContents -> oclExpression
            //
            case 162:
                break; 
            //
            // Rule 163:  iterContents ::= variableDeclaration | oclExpression
            //
            case 163: {
                setResult(
                    new IteratorOneVarDecl(getLeftIToken(), getRightIToken(),
                                           (VariableDeclaration)getRhsSym(1),
                                           (IoclExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 164:  iterContents ::= variableDeclaration , variableDeclaration | oclExpression
            //
            case 164: {
                setResult(
                    new IteratorTwoVarDecl(getLeftIToken(), getRightIToken(),
                                           (VariableDeclaration)getRhsSym(1),
                                           (VariableDeclaration)getRhsSym(3),
                                           (IoclExpression)getRhsSym(5))
                );
                break;
            } 
            //
            // Rule 165:  iterateExp ::= iterate ( variableAssignment | oclExpression )
            //
            case 165: {
                setResult(
                    new IterateVarDecl(getLeftIToken(), getRightIToken(),
                                       (VariableAssignment)getRhsSym(3),
                                       (IoclExpression)getRhsSym(5))
                );
                break;
            } 
            //
            // Rule 166:  timeExpressionOpt ::= $Empty
            //
            case 166: {
                setResult(null);
                break;
            } 
            //
            // Rule 167:  nonEnumLiteral -> primitiveLiteral
            //
            case 167:
                break; 
            //
            // Rule 168:  nonEnumLiteral -> collectionLiteral
            //
            case 168:
                break; 
            //
            // Rule 169:  nonEnumLiteral -> tupleLiteral
            //
            case 169:
                break; 
            //
            // Rule 170:  nonEnumLiteral -> nullLiteral
            //
            case 170:
                break; 
            //
            // Rule 171:  nonEnumLiteral -> invalidLiteral
            //
            case 171:
                break; 
            //
            // Rule 172:  collectionLiteral ::= collectionKind { collectionLiteralPartM }
            //
            case 172: {
                setResult(
                    new CollectionLiteral(getLeftIToken(), getRightIToken(),
                                          (IcollectionKind)getRhsSym(1),
                                          (IcollectionLiteralPartM)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 173:  collectionLiteralPartM ::= $Empty
            //
            case 173: {
                setResult(null);
                break;
            } 
            //
            // Rule 174:  collectionLiteralPartM -> collectionLiteralPartN
            //
            case 174:
                break; 
            //
            // Rule 175:  collectionLiteralPartN -> collectionLiteralPart
            //
            case 175:
                break; 
            //
            // Rule 176:  collectionLiteralPartN ::= collectionLiteralPartN , collectionLiteralPart
            //
            case 176: {
                setResult(
                    new CollectionLiteralParts(getLeftIToken(), getRightIToken(),
                                               (IcollectionLiteralPartN)getRhsSym(1),
                                               (IcollectionLiteralPart)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 177:  collectionLiteralPart ::= oclExpression collectionRangeOpt
            //
            case 177: {
                setResult(
                    new CollectionLiteralExpression(getLeftIToken(), getRightIToken(),
                                                    (IoclExpression)getRhsSym(1),
                                                    (CollectionRange)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 178:  collectionLiteralPart ::= minusOpt integerLiteralRange oclExpression
            //
            case 178: {
                setResult(
                    new CollectionLiteralIntegerRange(getLeftIToken(), getRightIToken(),
                                                      (Minus)getRhsSym(1),
                                                      (IntegerLiteralRange)getRhsSym(2),
                                                      (IoclExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 179:  integerLiteralRange ::= INTEGER_RANGE_START
            //
            case 179: {
                setResult(
                    new IntegerLiteralRange(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 180:  minusOpt ::= $Empty
            //
            case 180: {
                setResult(null);
                break;
            } 
            //
            // Rule 181:  minusOpt ::= -
            //
            case 181: {
                setResult(
                    new Minus(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 182:  collectionRangeOpt ::= $Empty
            //
            case 182: {
                setResult(null);
                break;
            } 
            //
            // Rule 183:  collectionRangeOpt ::= .. oclExpression
            //
            case 183: {
                setResult(
                    new CollectionRange(getLeftIToken(), getRightIToken(),
                                        (IoclExpression)getRhsSym(2))
                );
                break;
            } 
            //
            // Rule 184:  primitiveLiteral -> integerLiteral
            //
            case 184:
                break; 
            //
            // Rule 185:  primitiveLiteral -> realLiteral
            //
            case 185:
                break; 
            //
            // Rule 186:  primitiveLiteral -> stringLiteral
            //
            case 186:
                break; 
            //
            // Rule 187:  primitiveLiteral -> booleanLiteral
            //
            case 187:
                break; 
            //
            // Rule 188:  integerLiteral ::= INTEGER_LITERAL
            //
            case 188: {
                setResult(
                    new IntegerLiteral(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 189:  realLiteral ::= REAL_LITERAL
            //
            case 189: {
                setResult(
                    new RealLiteral(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 190:  stringLiteral ::= STRING_LITERAL
            //
            case 190: {
                setResult(
                    new StringLiteral(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 191:  booleanLiteral ::= true
            //
            case 191: {
                setResult(
                    new BooleanLiteralTrue(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 192:  booleanLiteral ::= false
            //
            case 192: {
                setResult(
                    new BooleanLiteralFalse(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 193:  nullLiteral ::= null
            //
            case 193: {
                setResult(
                    new NullLiteral(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 194:  invalidLiteral ::= invalid
            //
            case 194: {
                setResult(
                    new InvalidLiteral(getRhsIToken(1))
                );
                break;
            } 
            //
            // Rule 195:  tupleLiteral ::= Tuple { variableAssignmentM }
            //
            case 195: {
                setResult(
                    new TupleLiteral(getLeftIToken(), getRightIToken(),
                                     (IvariableAssignmentM)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 196:  ocl -> oclFile
            //
            case 196:
                break; 
            //
            // Rule 197:  timeExpressionOpt ::= ATPRE
            //
            case 197: {
                setResult(
                    new TimeExpressionOpt(getLeftIToken(), getRightIToken())
                );
                break;
            } 
            //
            // Rule 198:  argumentN -> oclExpression
            //
            case 198:
                break; 
            //
            // Rule 199:  argumentN ::= argumentN , oclExpression
            //
            case 199: {
                setResult(
                    new Arguments(getLeftIToken(), getRightIToken(),
                                  (IargumentN)getRhsSym(1),
                                  (IoclExpression)getRhsSym(3))
                );
                break;
            } 
            //
            // Rule 200:  iterateExp ::= iterate ( variableDeclaration ; variableAssignment | oclExpression )
            //
            case 200: {
                setResult(
                    new IterateVarDeclAndAcc(getLeftIToken(), getRightIToken(),
                                             (VariableDeclaration)getRhsSym(3),
                                             (VariableAssignment)getRhsSym(5),
                                             (IoclExpression)getRhsSym(7))
                );
                break;
            }
    
            default:
                break;
        }
        return;
    }
}



