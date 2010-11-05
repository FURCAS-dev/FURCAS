/**
* Essential OCL Grammar
* <copyright>
*
* Copyright (c) 2005, 2010 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Elimination of some shift-reduce conflicts
*   E.D.Willink - Remove unnecessary warning suppression
*   E.D.Willink - Bugs 184048, 225493, 243976, 259818, 282882, 287993, 288040, 292112, 295166
*   Borland - Bug 242880
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias):
*        - 242153: LPG v 2.0.17 adoption.
*        - 299396: Introducing new LPG templates
*        - 300534: Removing the use of deprecated macros.
* </copyright>
*
* $Id: OCLBacktrackingParser.java,v 1.22 2010/02/09 21:04:08 ewillink Exp $
*/
/**
* Complete OCL Grammar
* <copyright>
*
* Copyright (c) 2005, 2009 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Bug 259818, 285633, 292112
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias):
*        - 242153: LPG v 2.0.17 adoption.
*        - 299396: Introducing new LPG templates
*        - 300534: Removing the use of deprecated macros.
* </copyright>
*/

package org.eclipse.ocl.parser.backtracking;

import lpg.runtime.*;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.BooleanLiteralExpCS;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.CollectionLiteralExpCS;
import org.eclipse.ocl.cst.CollectionLiteralPartCS;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.cst.FeatureCallExpCS;
import org.eclipse.ocl.cst.IfExpCS;
import org.eclipse.ocl.cst.IntegerLiteralExpCS;
import org.eclipse.ocl.cst.InvalidLiteralExpCS;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.cst.IterateExpCS;
import org.eclipse.ocl.cst.IteratorExpCS;
import org.eclipse.ocl.cst.LetExpCS;
import org.eclipse.ocl.cst.NullLiteralExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.PrimitiveTypeCS;
import org.eclipse.ocl.cst.RealLiteralExpCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TupleLiteralExpCS;
import org.eclipse.ocl.cst.TupleTypeCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.cst.VariableExpCS;	
import org.eclipse.ocl.lpg.DerivedPrsStream;

import lpg.runtime.BadParseException;
import lpg.runtime.BadParseSymFileException;
import lpg.runtime.DiagnoseParser;
import lpg.runtime.ErrorToken;
import lpg.runtime.IToken;
import lpg.runtime.ILexStream;
import lpg.runtime.Monitor;
import lpg.runtime.NullExportedSymbolsException;
import lpg.runtime.NullTerminalSymbolsException;
import lpg.runtime.ParseTable;
import lpg.runtime.RuleAction;
import lpg.runtime.UndefinedEofSymbolException;
import lpg.runtime.UnimplementedTerminalsException;	

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.cst.ClassifierContextDeclCS;
import org.eclipse.ocl.cst.ContextDeclCS;
import org.eclipse.ocl.cst.DefCS;
import org.eclipse.ocl.cst.DefExpressionCS;
import org.eclipse.ocl.cst.DerValueCS;
import org.eclipse.ocl.cst.InitValueCS;
import org.eclipse.ocl.cst.InitOrDerValueCS;
import org.eclipse.ocl.cst.InvCS;
import org.eclipse.ocl.cst.InvOrDefCS;
import org.eclipse.ocl.cst.MessageExpCS;
import org.eclipse.ocl.cst.OCLMessageArgCS;
import org.eclipse.ocl.cst.OperationCS;
import org.eclipse.ocl.cst.OperationContextDeclCS;
import org.eclipse.ocl.cst.PackageDeclarationCS;
import org.eclipse.ocl.cst.PrePostOrBodyDeclCS;
import org.eclipse.ocl.cst.PrePostOrBodyEnum;
import org.eclipse.ocl.cst.PropertyContextCS;

	import org.eclipse.ocl.parser.AbstractOCLParser;

public class OCLBacktrackingParser extends AbstractOCLParser implements RuleAction
{
    private DerivedPrsStream prsStream = null;
    
    private boolean unimplementedSymbolsWarning = false;

    private static ParseTable prsTable = new OCLBacktrackingParserprs();
    @Override
    public ParseTable getParseTable() { return prsTable; }

    private BacktrackingParser btParser = null;
    public BacktrackingParser getParser() { return btParser; }

    @Override
    protected void setResult(Object object) { btParser.setSym1(object); }
    @Override
    protected Object getRhsSym(int i) { return btParser.getSym(i); }

    @Override
    protected int getRhsTokenIndex(int i) { return btParser.getToken(i); }
    @Override
    protected IToken getRhsIToken(int i) { return prsStream.getIToken(getRhsTokenIndex(i)); }
    
    @Override
    protected int getRhsFirstTokenIndex(int i) { return btParser.getFirstToken(i); }
    @Override
    protected IToken getRhsFirstIToken(int i) { return prsStream.getIToken(getRhsFirstTokenIndex(i)); }

    @Override
    protected int getRhsLastTokenIndex(int i) { return btParser.getLastToken(i); }
    @Override
    protected IToken getRhsLastIToken(int i) { return prsStream.getIToken(getRhsLastTokenIndex(i)); }

    @Override
    protected int getLeftSpan() { return btParser.getFirstToken(); }
    @Override
    protected IToken getLeftIToken()  { return prsStream.getIToken(getLeftSpan()); }

    @Override
    protected int getRightSpan() { return btParser.getLastToken(); }
    @Override
    protected IToken getRightIToken() { return prsStream.getIToken(getRightSpan()); }

    @Override
    protected int getRhsErrorTokenIndex(int i)
    {
        int index = btParser.getToken(i);
        IToken err = prsStream.getIToken(index);
        return (err instanceof ErrorToken ? index : 0);
    }
    @Override
    protected ErrorToken getRhsErrorIToken(int i)
    {
        int index = btParser.getToken(i);
        IToken err = prsStream.getIToken(index);
        return (ErrorToken) (err instanceof ErrorToken ? err : null);
    }

	@SuppressWarnings("nls")
    @Override
    public void reset(ILexStream lexStream)
    {
        prsStream = new DerivedPrsStream(getEnvironment(), lexStream);
        btParser.reset(prsStream);

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
                    System.out.println("    " + OCLBacktrackingParsersym.orderedTerminalSymbols[id.intValue()]);               
                }
                System.out.println();
            }
        }
        catch(UndefinedEofSymbolException e)
        {
            throw new Error(new UndefinedEofSymbolException
                                ("The Lexer does not implement the Eof symbol " +
                                 OCLBacktrackingParsersym.orderedTerminalSymbols[prsTable.getEoftSymbol()]));
        } 
    }
    
    @SuppressWarnings("nls")
    public OCLBacktrackingParser(OCLBacktrackingLexer lexer)        
    {
    		super(lexer);
        try
        {
            btParser = new BacktrackingParser(prsStream, prsTable, this);
        }
        catch (NotBacktrackParseTableException e)
        {
            throw new Error(new NotBacktrackParseTableException
                                ("Regenerate OCLBacktrackingParserprs.java with -BACKTRACK option"));
        }
        catch (BadParseSymFileException e)
        {
            throw new Error(new BadParseSymFileException("Bad Parser Symbol File -- OCLBacktrackingParsersym.java"));
        }
        
        ILexStream lexStream = lexer.getILexStream();
        if (lexStream != null) {
        	reset(lexStream);
        }
    }
    
    @Override
    public int numTokenKinds() { return OCLBacktrackingParsersym.numTokenKinds; }
    @Override
    public String[] orderedTerminalSymbols() { return OCLBacktrackingParsersym.orderedTerminalSymbols; }
    public String getTokenKindName(int kind) { return OCLBacktrackingParsersym.orderedTerminalSymbols[kind]; }
    public int getEOFTokenKind() { return prsTable.getEoftSymbol(); }
    @Override
    public DerivedPrsStream getIPrsStream() { return prsStream; }

    @Override
    public CSTNode parser()
    {
        return parser(null, getDefaultRepairCount());
    }
    
    @Override
    public CSTNode parser(Monitor monitor)
    {
        return parser(monitor, getDefaultRepairCount());
    }
    
    @Override
    public CSTNode parser(int error_repair_count)
    {
        return parser(null, error_repair_count);
    }

    @Override
    public CSTNode parser(Monitor monitor, int error_repair_count)
    {
        btParser.setMonitor(monitor);
        
        try
        {
        	if (error_repair_count > 0)
            	return (CSTNode) btParser.fuzzyParse(error_repair_count);
            else
            	return (CSTNode) btParser.parse(error_repair_count);
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
    


public Environment<?,?,?,?,?,?,?,?,?,?,?,?> getOCLEnvironment() {
	return getLexer().getOCLEnvironment();
}
	
@Override
public OCLBacktrackingLexer getLexer() {
	return (OCLBacktrackingLexer) super.getLexer();
}



// Some methods for backwards compatibility 
/**
* <p>
* Before 3.0, this method was used with the now-deprecated  "dollar"getToken macro (which
* provided token index in the prsStream) to obtain an IToken f a rule given the index of the
* right hand side token in the said rule. In 3.0 a convenience method has been introduced
* in order to directly return the IToken, given the index of the right hand side token in the rule.
* </p> 
*
* <p>
* In an action-block of a rule, instead of doing <code>getIToken("dollar"getToken(i))</code> 
* you should do <code>getRhsTokenText(i)</code>
* </p>
* @param i the right hand side token index
* @return the correspondent IToken.
*
* @since 3.0	
*/
@Deprecated
protected IToken getIToken(int i) {
	return prsStream.getIToken(i);
}

/**
* <p>
* Before 3.0, this method was used with the now-deprecated "dollar"getToken macro (which
* provided token index in the prsStream) to obtain an IToken f a rule given the index of the
* right hand side token in the said rule. In 3.0 a convenience method has been introduced
* in order to directly return the IToken, given the index of the right hand side token in the rule.
* </p> 
* 
* <p>
* In an action-block of a rule, instead of doing <code>getTokenText("dollar"getToken(i))</code> 
* you should do <code>getRhsTokenText(i)</code>
* </p>
* @param i the right hand side token index
* @result the text of the correspondent right hand side IToken.
*/
@Deprecated
protected String getTokenText(int i) {
	return prsStream.getTokenText(i);
}

/**
* A convenience method to obtain the text of a right hand side IToken.
*  
* @param i the right hand side token index
* @result the text of the correspondent right hand side IToken.
*
* @since 3.0
*/
protected String getRhsTokenText(int i) { 
	return prsStream.getTokenText(getRhsTokenIndex(i));
}

// Some methods for backwards compatibility

/**
 * Report error message for given error_token.
 * 
 * @param error_token
 *            the error taken index
 * @param msg
 *            the message to report
 * 
 * @since 1.3
 */
protected final void reportErrorTokenMessage(int error_token, String msg) {
	getIPrsStream().reportErrorTokenMessage(error_token, msg); 
}

	@SuppressWarnings("unchecked")
    public void ruleAction(int ruleNumber)
    {
        switch (ruleNumber)
        {

            //
            // Rule 16:  conceptualOperationNameCS ::= conceptualOperationName
            //
            case 16: {
               //#line 296 "../../lpg/btParserTemplateF.gi"
				
                IToken iToken = getRhsIToken(1);
                SimpleNameCS result = createConceptualOperationNameCS(iToken);
                setOffsets(result, iToken);
                setResult(result);
                      break;
            }
     
            //
            // Rule 28:  tupleKeywordCS ::= Tuple
            //
            
            case 28:

            //
            // Rule 29:  reservedKeywordCS ::= reservedKeyword
            //
            case 29: {
               //#line 319 "../../lpg/btParserTemplateF.gi"
				
                IToken iToken = getRhsIToken(1);
                SimpleNameCS result = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            iToken
                        );
                setOffsets(result, iToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 33:  selfKeywordCS ::= self
            //
            case 33: {
               //#line 338 "../../lpg/btParserTemplateF.gi"
				
                IToken iToken = getRhsIToken(1);
                SimpleNameCS result = createSimpleNameCS(
                        SimpleTypeEnum.SELF_LITERAL,
                        iToken
                    );
                setOffsets(result, iToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 34:  simpleNameCS ::= IDENTIFIER
            //
            case 34: {
               //#line 350 "../../lpg/btParserTemplateF.gi"
				
                IToken iToken = getRhsIToken(1);
                SimpleNameCS result = createSimpleNameCS(
                        SimpleTypeEnum.IDENTIFIER_LITERAL,
                        iToken
                    );
                setOffsets(result, iToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 36:  QuotedSimpleNameCS ::= QUOTED_IDENTIFIER
            //
            case 36: {
               //#line 362 "../../lpg/btParserTemplateF.gi"
				
                IToken iToken = getRhsIToken(1);
                SimpleNameCS result = createQuotedSimpleNameCS(
                        SimpleTypeEnum.IDENTIFIER_LITERAL,
                        iToken
                    );
                setOffsets(result, iToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 37:  QuotedSimpleNameCS ::= QuotedSimpleNameCS STRING_LITERAL
            //
            case 37: {
               //#line 373 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS string = (SimpleNameCS)getRhsSym(1);
                IToken literalToken = getRhsIToken(2);
                SimpleNameCS result = extendQuotedSimpleNameCS(string, literalToken);
                setOffsets(result, string, literalToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 40:  pathNameCS ::= simpleNameCS
            //
            case 40: {
               //#line 386 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS simpleName = (SimpleNameCS)getRhsSym(1);
                PathNameCS result = createPathNameCS(simpleName);
                setOffsets(result, simpleName);
                setResult(result);
                      break;
            }
    
            //
            // Rule 41:  pathNameCS ::= pathNameCS :: unreservedSimpleNameCS
            //
            case 41: {
               //#line 394 "../../lpg/btParserTemplateF.gi"
				
                PathNameCS result = (PathNameCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                result = extendPathNameCS(result, simpleNameCS);
                setOffsets(result, result, simpleNameCS);
                setResult(result);
                      break;
            }
    
            //
            // Rule 42:  primitiveTypeCS ::= Boolean
            //
            case 42: {
               //#line 407 "../../lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.BOOLEAN_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 43:  primitiveTypeCS ::= Integer
            //
            case 43: {
               //#line 417 "../../lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.INTEGER_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 44:  primitiveTypeCS ::= Real
            //
            case 44: {
               //#line 427 "../../lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.REAL_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 45:  primitiveTypeCS ::= String
            //
            case 45: {
               //#line 437 "../../lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.STRING_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 46:  primitiveTypeCS ::= UnlimitedNatural
            //
            case 46: {
               //#line 447 "../../lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 47:  primitiveTypeCS ::= OclAny
            //
            case 47: {
               //#line 458 "../../lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_ANY_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 48:  primitiveTypeCS ::= OclInvalid
            //
            case 48: {
               //#line 468 "../../lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_INVALID_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 49:  primitiveTypeCS ::= OclVoid
            //
            case 49: {
               //#line 478 "../../lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_VOID_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 50:  CollectionTypeIdentifierCS ::= Set
            //
            case 50: {
               //#line 489 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.SET_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 51:  CollectionTypeIdentifierCS ::= Bag
            //
            case 51: {
               //#line 499 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.BAG_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 52:  CollectionTypeIdentifierCS ::= Sequence
            //
            case 52: {
               //#line 509 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.SEQUENCE_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 53:  CollectionTypeIdentifierCS ::= Collection
            //
            case 53: {
               //#line 519 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.COLLECTION_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 54:  CollectionTypeIdentifierCS ::= OrderedSet
            //
            case 54: {
               //#line 529 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 59:  collectionTypeCS ::= CollectionTypeIdentifierCS ( typeCS )
            //
            case 59: {
               //#line 545 "../../lpg/btParserTemplateF.gi"
				
                CollectionTypeCS result = (CollectionTypeCS)getRhsSym(1);
                result.setTypeCS((TypeCS)getRhsSym(3));
                setOffsets(result, result, getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 60:  tupleTypeCS ::= Tuple ( tupleTypePartsCSopt )
            //
            case 60: {
               //#line 554 "../../lpg/btParserTemplateF.gi"
				
                 TupleTypeCS result = createTupleTypeCS((EList<VariableCS>)getRhsSym(3));
                setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 61:  tupleTypePartsCSopt ::= $Empty
            //
            case 61: {
               //#line 562 "../../lpg/btParserTemplateF.gi"
				
                setResult(new BasicEList<VariableCS>());
                      break;
            }
    
            //
            // Rule 63:  tupleTypePartsCS ::= typedUninitializedVariableCS
            //
            case 63: {
               //#line 569 "../../lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 64:  tupleTypePartsCS ::= tupleTypePartsCS , typedUninitializedVariableCS
            //
            case 64: {
               //#line 576 "../../lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                result.add((VariableCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 65:  untypedUninitializedVariableCS ::= simpleNameCS
            //
            case 65: {
               //#line 587 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                VariableCS result = createVariableCS(name, null, null);
                setOffsets(result, name);
                setResult(result);
                      break;
            }
    
            //
            // Rule 66:  typedUninitializedVariableCS ::= simpleNameCS : typeCS
            //
            case 66: {
               //#line 596 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                TypeCS type = (TypeCS)getRhsSym(3);
                VariableCS result = createVariableCS(name, type, null);
                setOffsets(result, name, type);
                setResult(result);
                      break;
            }
    
            //
            // Rule 67:  untypedInitializedVariableCS ::= simpleNameCS = OclExpressionCS
            //
            case 67: {
               //#line 606 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                OCLExpressionCS initExpression = (OCLExpressionCS)getRhsSym(3);
                VariableCS result = createVariableCS(name, null, initExpression);
                setOffsets(result, name, initExpression);
                setResult(result);
                      break;
            }
    
            //
            // Rule 68:  typedInitializedVariableCS ::= simpleNameCS : typeCS = OclExpressionCS
            //
            case 68: {
               //#line 616 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                TypeCS type = (TypeCS)getRhsSym(3);
                OCLExpressionCS initExpression = (OCLExpressionCS)getRhsSym(5);
                VariableCS result = createVariableCS(name, type, initExpression);
                setOffsets(result, name, initExpression);
                setResult(result);
                      break;
            }
    
            //
            // Rule 81:  CollectionLiteralExpCS ::= CollectionTypeIdentifierCS { CollectionLiteralPartsCSopt }
            //
            case 81: {
               //#line 649 "../../lpg/btParserTemplateF.gi"
				
                CollectionTypeCS typeCS = (CollectionTypeCS)getRhsSym(1);
                CollectionLiteralExpCS result = createCollectionLiteralExpCS(
                        typeCS,
                        (EList<CollectionLiteralPartCS>)getRhsSym(3)
                    );
                setOffsets(result, typeCS, getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 82:  CollectionLiteralExpCS ::= collectionTypeCS { CollectionLiteralPartsCSopt }
            //
            case 82: {
               //#line 660 "../../lpg/btParserTemplateF.gi"
				
                CollectionTypeCS typeCS = (CollectionTypeCS)getRhsSym(1);
                CollectionLiteralExpCS result = createCollectionLiteralExpCS(
                        typeCS,
                        (EList<CollectionLiteralPartCS>)getRhsSym(3)
                    );
                setOffsets(result, typeCS, getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 83:  CollectionLiteralPartsCSopt ::= $Empty
            //
            case 83: {
               //#line 672 "../../lpg/btParserTemplateF.gi"
				
                setResult(new BasicEList<CollectionLiteralPartCS>());
                      break;
            }
    
            //
            // Rule 85:  CollectionLiteralPartsCS ::= CollectionLiteralPartCS
            //
            case 85: {
               //#line 679 "../../lpg/btParserTemplateF.gi"
				
                EList<CollectionLiteralPartCS> result = new BasicEList<CollectionLiteralPartCS>();
                result.add((CollectionLiteralPartCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 86:  CollectionLiteralPartsCS ::= CollectionLiteralPartsCS , CollectionLiteralPartCS
            //
            case 86: {
               //#line 686 "../../lpg/btParserTemplateF.gi"
				
                EList<CollectionLiteralPartCS> result = (EList<CollectionLiteralPartCS>)getRhsSym(1);
                result.add((CollectionLiteralPartCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 88:  CollectionLiteralPartCS ::= OclExpressionCS
            //
            case 88: {
               //#line 695 "../../lpg/btParserTemplateF.gi"
				
                CollectionLiteralPartCS result = createCollectionLiteralPartCS(
                        (OCLExpressionCS)getRhsSym(1)
                    );
                setOffsets(result, (CSTNode)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 89:  CollectionRangeCS ::= OclExpressionCS .. OclExpressionCS
            //
            case 89: {
               //#line 705 "../../lpg/btParserTemplateF.gi"
				
                CollectionLiteralPartCS result = createCollectionRangeCS(
                        (OCLExpressionCS)getRhsSym(1),
                        (OCLExpressionCS)getRhsSym(3)
                    );
                setOffsets(result, (CSTNode)getRhsSym(1), (CSTNode)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 97:  TupleLiteralExpCS ::= Tuple { TupleLiteralPartsCS }
            //
            case 97: {
               //#line 724 "../../lpg/btParserTemplateF.gi"
				
                TupleLiteralExpCS result = createTupleLiteralExpCS((EList<VariableCS>)getRhsSym(3));
                setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 98:  TupleLiteralPartsCS ::= initializedVariableCS
            //
            case 98: {
               //#line 732 "../../lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 99:  TupleLiteralPartsCS ::= TupleLiteralPartsCS , initializedVariableCS
            //
            case 99: {
               //#line 739 "../../lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                result.add((VariableCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 100:  IntegerLiteralExpCS ::= INTEGER_LITERAL
            //
            case 100: {
               //#line 747 "../../lpg/btParserTemplateF.gi"
				
                IntegerLiteralExpCS result = createIntegerLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 101:  RealLiteralExpCS ::= REAL_LITERAL
            //
            case 101: {
               //#line 755 "../../lpg/btParserTemplateF.gi"
				
                RealLiteralExpCS result = createRealLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 102:  StringLiteralExpCS ::= STRING_LITERAL
            //
            case 102: {
               //#line 763 "../../lpg/btParserTemplateF.gi"
				
                IToken literalToken = getRhsIToken(1);
                StringLiteralExpCS result = createStringLiteralExpCS(literalToken);
                setOffsets(result, literalToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 103:  StringLiteralExpCS ::= StringLiteralExpCS STRING_LITERAL
            //
            case 103: {
               //#line 771 "../../lpg/btParserTemplateF.gi"
				
                StringLiteralExpCS string = (StringLiteralExpCS)getRhsSym(1);
                IToken literalToken = getRhsIToken(2);
                StringLiteralExpCS result = extendStringLiteralExpCS(string, literalToken);
                setOffsets(result, string, literalToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 104:  BooleanLiteralExpCS ::= true
            //
            case 104: {
               //#line 781 "../../lpg/btParserTemplateF.gi"
				
                BooleanLiteralExpCS result = createBooleanLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 105:  BooleanLiteralExpCS ::= false
            //
            case 105: {
               //#line 788 "../../lpg/btParserTemplateF.gi"
				
                BooleanLiteralExpCS result = createBooleanLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 106:  UnlimitedNaturalLiteralExpCS ::= *
            //
            case 106: {
               //#line 796 "../../lpg/btParserTemplateF.gi"
				
                UnlimitedNaturalLiteralExpCS result = createUnlimitedNaturalLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 107:  InvalidLiteralExpCS ::= invalid
            //
            case 107: {
               //#line 804 "../../lpg/btParserTemplateF.gi"
				
                InvalidLiteralExpCS result = createInvalidLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 108:  NullLiteralExpCS ::= null
            //
            case 108: {
               //#line 812 "../../lpg/btParserTemplateF.gi"
				
                NullLiteralExpCS result = createNullLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
     
            //
            // Rule 109:  TypeLiteralExpCS ::= primitiveTypeCS
            //
            
            case 109:
 
            //
            // Rule 110:  TypeLiteralExpCS ::= collectionTypeCS
            //
            
            case 110:

            //
            // Rule 111:  TypeLiteralExpCS ::= tupleTypeCS
            //
            case 111: {
               //#line 826 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(1);
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                setResult(result);
                      break;
            }
    
            //
            // Rule 116:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( uninitializedVariableCS | OclExpressionCS )
            //
            case 116: {
               //#line 851 "../../lpg/btParserTemplateF.gi"
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IteratorExpCS result = createIteratorExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS)getRhsSym(5),
                        null,
                        (OCLExpressionCS)getRhsSym(7)
                    );
                setOffsets(result, source, getRhsIToken(8));
                setResult(result);
                      break;
            }
    
            //
            // Rule 117:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( simpleNameCS , uninitializedVariableCS | OclExpressionCS )
            //
            case 117: {
               //#line 868 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(5);
                VariableCS variableCS = createVariableCS(name, null, null);
                setOffsets(variableCS, name);
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IteratorExpCS result = createIteratorExpCS(
                        source,
                        simpleNameCS,
                        variableCS,
                        (VariableCS)getRhsSym(7),
                        (OCLExpressionCS)getRhsSym(9)
                    );
                setOffsets(result, source, getRhsIToken(10));
                setResult(result);
                      break;
            }
    
            //
            // Rule 118:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( typedUninitializedVariableCS , uninitializedVariableCS | OclExpressionCS )
            //
            case 118: {
               //#line 888 "../../lpg/btParserTemplateF.gi"
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IteratorExpCS result = createIteratorExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS)getRhsSym(5),
                        (VariableCS)getRhsSym(7),
                        (OCLExpressionCS)getRhsSym(9)
                    );
                setOffsets(result, source, getRhsIToken(10));
                setResult(result);
                      break;
            }
    
            //
            // Rule 119:  IterateExpCS ::= primaryExpCS -> simpleNameCS ( typedInitializedVariableCS | OclExpressionCS )
            //
            case 119: {
               //#line 909 "../../lpg/btParserTemplateF.gi"
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IterateExpCS result = createIterateExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS)getRhsSym(5),
                        null,
                        (OCLExpressionCS)getRhsSym(7)
                    );
                setOffsets(result, source, getRhsIToken(8));
                setResult(result);
                      break;
            }
    
            //
            // Rule 120:  IterateExpCS ::= primaryExpCS -> simpleNameCS ( uninitializedVariableCS ; typedInitializedVariableCS | OclExpressionCS )
            //
            case 120: {
               //#line 925 "../../lpg/btParserTemplateF.gi"
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IterateExpCS result = createIterateExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS)getRhsSym(5),
                        (VariableCS)getRhsSym(7),
                        (OCLExpressionCS)getRhsSym(9)
                    );
                setOffsets(result, source, getRhsIToken(10));
                setResult(result);
                      break;
            }
    
            //
            // Rule 124:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( )
            //
            case 124: {
               //#line 947 "../../lpg/btParserTemplateF.gi"
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                OperationCallExpCS result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS)getRhsSym(3),
                        null,
                        new BasicEList<OCLExpressionCS>()
                    );
                setOffsets(result, source, getRhsIToken(5));
                setResult(result);
                      break;
            }
    
            //
            // Rule 125:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( OclExpressionCS )
            //
            case 125: {
               //#line 961 "../../lpg/btParserTemplateF.gi"
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                OCLExpressionCS arg = (OCLExpressionCS)getRhsSym(5);
                OCLExpressionCS result;
                if (isIterator(simpleNameCS.getValue())) {
                    result = createIteratorExpCS(
                            source,
                            simpleNameCS,
                            null,
                            null,
                            arg
                        );
                }
                else {
                    EList<OCLExpressionCS> args = new BasicEList<OCLExpressionCS>();
                    args.add(arg);
                    result = createArrowOperationCallExpCS(
                            source,
                            simpleNameCS,
                            null,
                            args
                        );
                }
                setOffsets(result, source, getRhsIToken(6));
                setResult(result);
                      break;
            }
    
            //
            // Rule 126:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( notNameExpressionCS , argumentsCS )
            //
            case 126: {
               //#line 991 "../../lpg/btParserTemplateF.gi"
				
                EList<OCLExpressionCS> args = (EList<OCLExpressionCS>)getRhsSym(7);
                args.add(0, (OCLExpressionCS)getRhsSym(5));
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                OperationCallExpCS result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS)getRhsSym(3),
                        null,
                        args
                    );
                setOffsets(result, source, getRhsIToken(8));
                setResult(result);
                      break;
            }
    
            //
            // Rule 127:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( simpleNameCS , argumentsCS )
            //
            case 127: {
               //#line 1007 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(5);
                OCLExpressionCS variableExpCS = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(variableExpCS, simpleNameCS);
                EList<OCLExpressionCS> args = (EList<OCLExpressionCS>)getRhsSym(7);
                args.add(0, variableExpCS);
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                OperationCallExpCS result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS)getRhsSym(3),
                        null,
                        args
                    );
                setOffsets(result, source, getRhsIToken(8));
                setResult(result);
                      break;
            }
     
            //
            // Rule 128:  OperationCallExpCS ::= primaryExpCS . conceptualOperationNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            
            case 128:

            //
            // Rule 129:  OperationCallExpCS ::= primaryExpCS . simpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 129: {
               //#line 1033 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                CallExpCS result = createDotOperationCallExpCS(
                        source,
                        null,
                        simpleNameCS,
                        (IsMarkedPreCS)getRhsSym(4),
                        (EList<OCLExpressionCS>)getRhsSym(6)
                    );
                setOffsets(result, source, getRhsIToken(7));
                setResult(result);
                      break;
            }
    
            //
            // Rule 130:  OperationCallExpCS ::= simpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 130: {
               //#line 1049 "../../lpg/btParserTemplateF.gi"
				
                OperationCallExpCS result = createDotOperationCallExpCS(
                        null,
                        null,
                        (SimpleNameCS)getRhsSym(1),
                        (IsMarkedPreCS)getRhsSym(2),
                        (EList<OCLExpressionCS>)getRhsSym(4)
                    );
                setOffsets(result, getRhsIToken(1), getRhsIToken(5));
                setResult(result);
                      break;
            }
    
            //
            // Rule 131:  OperationCallExpCS ::= pathNameCS :: unreservedSimpleNameCS ( argumentsCSopt )
            //
            case 131: {
               //#line 1063 "../../lpg/btParserTemplateF.gi"
				
                PathNameCS pathNameCS = (PathNameCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                OperationCallExpCS result = createDotOperationCallExpCS(
                        null,
                        pathNameCS,
                        simpleNameCS,
                        null,
                        (EList<OCLExpressionCS>)getRhsSym(5)
                    );
                setOffsets(result, pathNameCS, getRhsIToken(6));
                setResult(result);
                      break;
            }
    
            //
            // Rule 132:  OperationCallExpCS ::= primaryExpCS . pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 132: {
               //#line 1081 "../../lpg/btParserTemplateF.gi"
				
                PathNameCS pathNameCS = (PathNameCS)getRhsSym(3);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(5);
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                CallExpCS result = createDotOperationCallExpCS(
                        source,
                        pathNameCS,
                        simpleNameCS,
                        (IsMarkedPreCS)getRhsSym(6),
                        (EList<OCLExpressionCS>)getRhsSym(8)
                    );
                setOffsets(result, source, getRhsIToken(9));
                setResult(result);
                      break;
            }
    
            //
            // Rule 134:  PropertyCallExpCS ::= pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt
            //
            case 134: {
               //#line 1105 "../../lpg/btParserTemplateF.gi"
				
                PathNameCS pathNameCS = (PathNameCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(4);
                FeatureCallExpCS result = createFeatureCallExpCS(
                        null,
                        pathNameCS,
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        isMarkedPreCS
                    );
                if (isMarkedPreCS != null) {
                    setOffsets(result, pathNameCS, isMarkedPreCS);
                } else {
                    setOffsets(result, pathNameCS, simpleNameCS);
                }
                setResult(result);
                      break;
            }
    
            //
            // Rule 135:  PropertyCallExpCS ::= primaryExpCS . pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt
            //
            case 135: {
               //#line 1126 "../../lpg/btParserTemplateF.gi"
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                PathNameCS pathNameCS = (PathNameCS)getRhsSym(3);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(5);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(6);
                FeatureCallExpCS result = createFeatureCallExpCS(
                        source,
                        pathNameCS,
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        isMarkedPreCS
                    );
                if (isMarkedPreCS != null) {
                    setOffsets(result, source, isMarkedPreCS);
                } else {
                    setOffsets(result, source, simpleNameCS);
                }
                setResult(result);
                      break;
            }
    
            //
            // Rule 136:  AssociationClassCallExpCS ::= primaryExpCS . simpleNameCS isMarkedPreCSopt
            //
            case 136: {
               //#line 1149 "../../lpg/btParserTemplateF.gi"
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(4);
                FeatureCallExpCS result = createFeatureCallExpCS(
                        source,
                        null,
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        isMarkedPreCS
                    );
                if (isMarkedPreCS != null) {
                    setOffsets(result, source, isMarkedPreCS);
                } else {
                    setOffsets(result, source, simpleNameCS);
                }
                setResult(result);
                      break;
            }
    
            //
            // Rule 137:  AssociationClassCallExpCS ::= primaryExpCS . simpleNameCS [ argumentsCS ] isMarkedPreCSopt
            //
            case 137: {
               //#line 1170 "../../lpg/btParserTemplateF.gi"
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(7);
                FeatureCallExpCS result = createFeatureCallExpCS(
                        source,
                        null,
                        simpleNameCS,
                        (EList<OCLExpressionCS>)getRhsSym(5),
                        isMarkedPreCS
                    );
                if (isMarkedPreCS != null) {
                    setOffsets(result, source, isMarkedPreCS);
                } else {
                    setOffsets(result, source, getRhsIToken(6));
                }
                setResult(result);
                      break;
            }
    
            //
            // Rule 138:  AssociationClassCallExpCS ::= simpleNameCS [ argumentsCS ] isMarkedPreCSopt
            //
            case 138: {
               //#line 1193 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(1);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(5);
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        (EList<OCLExpressionCS>)getRhsSym(3),
                        isMarkedPreCS
                    );
                if (isMarkedPreCS != null) {
                    setOffsets(result, simpleNameCS, isMarkedPreCS);
                } else {
                    setOffsets(result, simpleNameCS, getRhsIToken(4));
                }
                setResult(result);
                      break;
            }
    
            //
            // Rule 139:  isMarkedPreCSopt ::= $Empty
            //
            case 139: {
               //#line 1211 "../../lpg/btParserTemplateF.gi"
				
                setResult(null);
                      break;
            }
    
            //
            // Rule 140:  argumentsCSopt ::= $Empty
            //
            case 140: {
               //#line 1217 "../../lpg/btParserTemplateF.gi"
				
                setResult(new BasicEList<OCLExpressionCS>());
                      break;
            }
    
            //
            // Rule 142:  argumentsCS ::= OclExpressionCS
            //
            case 142: {
               //#line 1224 "../../lpg/btParserTemplateF.gi"
				
                EList<OCLExpressionCS> result = new BasicEList<OCLExpressionCS>();
                result.add((OCLExpressionCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 143:  argumentsCS ::= argumentsCS , OclExpressionCS
            //
            case 143: {
               //#line 1231 "../../lpg/btParserTemplateF.gi"
				
                EList<OCLExpressionCS> result = (EList<OCLExpressionCS>)getRhsSym(1);
                result.add((OCLExpressionCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 146:  VariableExpCS ::= selfKeywordCS
            //
            case 146: {
               //#line 1256 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(1);
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                setResult(result);
                      break;
            }
    
            //
            // Rule 147:  SimpleNameExpCS ::= simpleNameCS
            //
            case 147: {
               //#line 1271 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(1);
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                setResult(result);
                      break;
            }
     
            //
            // Rule 153:  impliesNotNameNotLetCS ::= impliesNotLetCS implies xorNotLetCS
            //
            
            case 153:
 
            //
            // Rule 155:  impliesWithLetCS ::= impliesNotLetCS implies xorWithLetCS
            //
            
            case 155:
 
            //
            // Rule 159:  xorNotNameNotLetCS ::= xorNotLetCS xor orNotLetCS
            //
            
            case 159:
 
            //
            // Rule 161:  xorWithLetCS ::= xorNotLetCS xor orWithLetCS
            //
            
            case 161:
 
            //
            // Rule 165:  orNotNameNotLetCS ::= orNotLetCS or andNotLetCS
            //
            
            case 165:
 
            //
            // Rule 167:  orWithLetCS ::= orNotLetCS or andWithLetCS
            //
            
            case 167:
 
            //
            // Rule 171:  andNotNameNotLetCS ::= andNotLetCS and equalityNotLetCS
            //
            
            case 171:
 
            //
            // Rule 173:  andWithLetCS ::= andNotLetCS and equalityWithLetCS
            //
            
            case 173:
 
            //
            // Rule 177:  equalityNotNameNotLetCS ::= equalityNotLetCS = relationalNotLetCS
            //
            
            case 177:
 
            //
            // Rule 178:  equalityNotNameNotLetCS ::= equalityNotLetCS <> relationalNotLetCS
            //
            
            case 178:
 
            //
            // Rule 180:  equalityWithLetCS ::= equalityNotLetCS = relationalWithLetCS
            //
            
            case 180:
 
            //
            // Rule 181:  equalityWithLetCS ::= equalityNotLetCS <> relationalWithLetCS
            //
            
            case 181:
 
            //
            // Rule 185:  relationalNotNameNotLetCS ::= relationalNotLetCS > additiveNotLetCS
            //
            
            case 185:
 
            //
            // Rule 186:  relationalNotNameNotLetCS ::= relationalNotLetCS < additiveNotLetCS
            //
            
            case 186:
 
            //
            // Rule 187:  relationalNotNameNotLetCS ::= relationalNotLetCS >= additiveNotLetCS
            //
            
            case 187:
 
            //
            // Rule 188:  relationalNotNameNotLetCS ::= relationalNotLetCS <= additiveNotLetCS
            //
            
            case 188:
 
            //
            // Rule 190:  relationalWithLetCS ::= relationalNotLetCS > additiveWithLetCS
            //
            
            case 190:
 
            //
            // Rule 191:  relationalWithLetCS ::= relationalNotLetCS < additiveWithLetCS
            //
            
            case 191:
 
            //
            // Rule 192:  relationalWithLetCS ::= relationalNotLetCS >= additiveWithLetCS
            //
            
            case 192:
 
            //
            // Rule 193:  relationalWithLetCS ::= relationalNotLetCS <= additiveWithLetCS
            //
            
            case 193:
 
            //
            // Rule 197:  additiveNotNameNotLetCS ::= additiveNotLetCS + multiplicativeNotLetCS
            //
            
            case 197:
 
            //
            // Rule 198:  additiveNotNameNotLetCS ::= additiveNotLetCS - multiplicativeNotLetCS
            //
            
            case 198:
 
            //
            // Rule 200:  additiveWithLetCS ::= additiveNotLetCS + multiplicativeWithLetCS
            //
            
            case 200:
 
            //
            // Rule 201:  additiveWithLetCS ::= additiveNotLetCS - multiplicativeWithLetCS
            //
            
            case 201:
 
            //
            // Rule 205:  multiplicativeNotNameNotLetCS ::= multiplicativeNotLetCS * unaryNotLetCS
            //
            
            case 205:
 
            //
            // Rule 206:  multiplicativeNotNameNotLetCS ::= multiplicativeNotLetCS / unaryNotLetCS
            //
            
            case 206:
 
            //
            // Rule 208:  multiplicativeWithLetCS ::= multiplicativeNotLetCS * unaryWithLetCS
            //
            
            case 208:

            //
            // Rule 209:  multiplicativeWithLetCS ::= multiplicativeNotLetCS / unaryWithLetCS
            //
            case 209: {
               //#line 1380 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS simpleNameCS = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            getRhsIToken(2)
                        );
                setOffsets(simpleNameCS, getRhsIToken(2));
                OCLExpressionCS left = (OCLExpressionCS)getRhsSym(1);
                OCLExpressionCS right = (OCLExpressionCS)getRhsSym(3);
                EList<OCLExpressionCS> args = new BasicEList<OCLExpressionCS>();
                args.add(right);
                OperationCallExpCS result = createOperationCallExpCS(
                        left,
                        simpleNameCS,
                        args
                    );
                setOffsets(result, left, right);
                setResult(result);
                      break;
            }
     
            //
            // Rule 213:  unaryNotNameNotLetCS ::= - unaryNotLetCS
            //
            
            case 213:
 
            //
            // Rule 214:  unaryNotNameNotLetCS ::= not unaryNotLetCS
            //
            
            case 214:
 
            //
            // Rule 216:  unaryWithLetCS ::= - unaryWithLetCS
            //
            
            case 216:

            //
            // Rule 217:  unaryWithLetCS ::= not unaryWithLetCS
            //
            case 217: {
               //#line 1411 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS simpleNameCS = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            getRhsIToken(1)
                        );
                setOffsets(simpleNameCS, getRhsIToken(1));
                OCLExpressionCS expr = (OCLExpressionCS)getRhsSym(2);
                OperationCallExpCS result = createOperationCallExpCS(
                        expr,
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>()
                    );
                setOffsets(result, simpleNameCS, expr);
                setResult(result);
                      break;
            }
    
            //
            // Rule 224:  primaryNotNameCS ::= ( OclExpressionCS )
            //
            case 224: {
               //#line 1437 "../../lpg/btParserTemplateF.gi"
				
                OCLExpressionCS result = (OCLExpressionCS)getRhsSym(2);
                if (result instanceof OperationCallExpCS) {
                    ((OperationCallExpCS)result).setIsAtomic(true);
                }
                setOffsets(result, getRhsIToken(1), getRhsIToken(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 225:  IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS endif
            //
            case 225: {
               //#line 1448 "../../lpg/btParserTemplateF.gi"
				
                IfExpCS result = createIfExpCS(
                        (OCLExpressionCS)getRhsSym(2),
                        (OCLExpressionCS)getRhsSym(4),
                        (OCLExpressionCS)getRhsSym(6)
                    );
                setOffsets(result, getRhsIToken(1), getRhsIToken(7));
                setResult(result);
                      break;
            }
    
            //
            // Rule 226:  LetExpCS ::= let letVariablesCS in OclExpressionCS
            //
            case 226: {
               //#line 1460 "../../lpg/btParserTemplateF.gi"
				
                OCLExpressionCS expr = (OCLExpressionCS)getRhsSym(4);
                LetExpCS result = createLetExpCS(
                        (EList<VariableCS>)getRhsSym(2),
                        expr
                    );
                setOffsets(result, getRhsIToken(1), expr);
                setResult(result);
                      break;
            }
    
            //
            // Rule 227:  letVariablesCS ::= typedInitializedVariableCS
            //
            case 227: {
               //#line 1472 "../../lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 228:  letVariablesCS ::= letVariablesCS , typedInitializedVariableCS
            //
            case 228: {
               //#line 1479 "../../lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                result.add((VariableCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 246:  unreservedSimpleNameCSopt ::= $Empty
            //
            case 246:
                setResult(null);
                break;

            //
            // Rule 248:  primitiveTypeCS ::= OclMessage
            //
            case 248: {
               //#line 136 "../../lpg/btParserTemplateF.gi"
				
				PrimitiveTypeCS result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_MESSAGE_LITERAL,
						getRhsTokenText(1)
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 249:  typeCSopt ::= $Empty
            //
            case 249:
                setResult(null);
                break;

            //
            // Rule 251:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS isMarkedPreCS ( argumentsCSopt )
            //
            case 251: {
               //#line 155 "../../lpg/btParserTemplateF.gi"
				
				OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
				OperationCallExpCS result = createArrowOperationCallExpCS(
						source,
						(SimpleNameCS)getRhsSym(3),
						(IsMarkedPreCS)getRhsSym(4),
						(EList<OCLExpressionCS>)getRhsSym(6)
					);
				setOffsets(result, source, getRhsIToken(7));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 252:  AssociationClassCallExpCS ::= simpleNameCS isMarkedPreCS
            //
            case 252: {
               //#line 170 "../../lpg/btParserTemplateF.gi"
				
				SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(1);
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(2);
				VariableExpCS result = createVariableExpCS(
						simpleNameCS,
						new BasicEList<OCLExpressionCS>(),
						isMarkedPreCS
					);
				setOffsets(result, simpleNameCS, isMarkedPreCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 253:  isMarkedPreCS ::= @ pre
            //
            case 253: {
               //#line 184 "../../lpg/btParserTemplateF.gi"
				
				IsMarkedPreCS result = createIsMarkedPreCS();
				setOffsets(result, getRhsIToken(1), getRhsIToken(2));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 255:  OclMessageExpCS ::= primaryExpCS ^^ simpleNameCS ( OclMessageArgumentsCSopt )
            //
            
            case 255:

            //
            // Rule 256:  OclMessageExpCS ::= primaryExpCS ^ simpleNameCS ( OclMessageArgumentsCSopt )
            //
            case 256: {
               //#line 195 "../../lpg/btParserTemplateF.gi"
				
				OCLExpressionCS target = (OCLExpressionCS)getRhsSym(1);
				MessageExpCS result = createMessageExpCS(
						target,
						getRhsIToken(2).getKind() == OCLBacktrackingParsersym.TK_CARET,
						(SimpleNameCS)getRhsSym(3),
						(EList<OCLMessageArgCS>)getRhsSym(5)
					);
				setOffsets(result, target, getRhsIToken(6));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 257:  OclMessageArgumentsCSopt ::= $Empty
            //
            case 257: {
               //#line 209 "../../lpg/btParserTemplateF.gi"
				
                setResult(new BasicEList<OCLMessageArgCS>());
                      break;
            }
    
            //
            // Rule 259:  OclMessageArgumentsCS ::= OclMessageArgCS
            //
            case 259: {
               //#line 216 "../../lpg/btParserTemplateF.gi"
				
				EList<OCLMessageArgCS> result = new BasicEList<OCLMessageArgCS>();
				result.add((OCLMessageArgCS)getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 260:  OclMessageArgumentsCS ::= OclMessageArgumentsCS , OclMessageArgCS
            //
            case 260: {
               //#line 223 "../../lpg/btParserTemplateF.gi"
				
				EList<OCLMessageArgCS> result = (EList<OCLMessageArgCS>)getRhsSym(1);
				result.add((OCLMessageArgCS)getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 261:  OclMessageArgCS ::= ?
            //
            case 261: {
               //#line 231 "../../lpg/btParserTemplateF.gi"
				
				OCLMessageArgCS result = createOCLMessageArgCS(
						null,
						null
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 262:  OclMessageArgCS ::= ? : typeCS
            //
            case 262: {
               //#line 241 "../../lpg/btParserTemplateF.gi"
				
				OCLMessageArgCS result = createOCLMessageArgCS(
						(TypeCS)getRhsSym(3),
						null
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 263:  OclMessageArgCS ::= OclExpressionCS
            //
            case 263: {
               //#line 251 "../../lpg/btParserTemplateF.gi"
				
				OCLMessageArgCS result = createOCLMessageArgCS(
						null,
						(OCLExpressionCS)getRhsSym(1)
					);
				setOffsets(result, (CSTNode)getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 266:  packageDeclarationsCS ::= packageDeclarationsCS packageDeclarationCS_A
            //
            case 266: {
               //#line 271 "../../lpg/btParserTemplateF.gi"
				
                PackageDeclarationCS result = (PackageDeclarationCS)getRhsSym(2);
                result.setPackageDeclarationCS((PackageDeclarationCS) getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 269:  packageDeclarationCS_A ::= package pathNameCS contextDeclsCSopt endpackage
            //
            case 269: {
               //#line 281 "../../lpg/btParserTemplateF.gi"
				
                PackageDeclarationCS result = createPackageDeclarationCS(
                        (PathNameCS)getRhsSym(2),
                        (EList<ContextDeclCS>)getRhsSym(3)
                    );
                setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 270:  packageDeclarationCS_B ::= contextDeclsCS
            //
            case 270: {
               //#line 292 "../../lpg/btParserTemplateF.gi"
				
                EList<ContextDeclCS> contextDecls = (EList<ContextDeclCS>)getRhsSym(1);
                PackageDeclarationCS result = createPackageDeclarationCS(null, contextDecls);
                if (!contextDecls.isEmpty()) {
                    setOffsets(result, contextDecls.get(0), contextDecls.get(contextDecls.size()-1));
                }
                setResult(result);
                      break;
            }
    
            //
            // Rule 271:  contextDeclsCSopt ::= $Empty
            //
            case 271: {
               //#line 303 "../../lpg/btParserTemplateF.gi"
				
                setResult(new BasicEList<ContextDeclCS>());
                      break;
            }
    
            //
            // Rule 273:  contextDeclsCS ::= contextDeclCS
            //
            case 273: {
               //#line 310 "../../lpg/btParserTemplateF.gi"
				
                EList<ContextDeclCS> result = new BasicEList<ContextDeclCS>();
                result.add((ContextDeclCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 274:  contextDeclsCS ::= contextDeclsCS contextDeclCS
            //
            case 274: {
               //#line 317 "../../lpg/btParserTemplateF.gi"
				
                EList<ContextDeclCS> result = (EList<ContextDeclCS>)getRhsSym(1);
                result.add((ContextDeclCS)getRhsSym(2));
                setResult(result);
                      break;
            }
    
            //
            // Rule 278:  propertyContextDeclCS ::= context pathNameCS :: unreservedSimpleNameCS : typeCS initOrDerValuesCS
            //
            case 278: {
               //#line 330 "../../lpg/btParserTemplateF.gi"
				
                PathNameCS pathNameCS = (PathNameCS)getRhsSym(2);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(4);
                EList<InitOrDerValueCS> list = (EList<InitOrDerValueCS>)getRhsSym(7);
                PropertyContextCS result = createPropertyContextCS(
                        pathNameCS,
                        simpleNameCS,
                        (TypeCS)getRhsSym(6),
                        list
                    );
                setOffsets(result, getRhsIToken(1), list.get(list.size()-1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 279:  initOrDerValuesCS ::= initOrDerValueCS
            //
            case 279: {
               //#line 346 "../../lpg/btParserTemplateF.gi"
				
                EList<InitOrDerValueCS> result = new BasicEList<InitOrDerValueCS>();
                result.add((InitOrDerValueCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 280:  initOrDerValuesCS ::= initOrDerValuesCS initOrDerValueCS
            //
            case 280: {
               //#line 353 "../../lpg/btParserTemplateF.gi"
				
                EList<InitOrDerValueCS> result = (EList<InitOrDerValueCS>)getRhsSym(1);
                result.add((InitOrDerValueCS)getRhsSym(2));
                setResult(result);
                      break;
            }
    
            //
            // Rule 281:  initOrDerValueCS ::= init : OclExpressionCS
            //
            case 281: {
               //#line 361 "../../lpg/btParserTemplateF.gi"
				
                InitValueCS result = createInitValueCS((OCLExpressionCS)getRhsSym(3));
                setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 282:  initOrDerValueCS ::= derive : OclExpressionCS
            //
            case 282: {
               //#line 368 "../../lpg/btParserTemplateF.gi"
				
                DerValueCS result = createDerValueCS((OCLExpressionCS)getRhsSym(3));
                setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 283:  classifierContextDeclCS ::= context pathNameCS invOrDefsCS
            //
            case 283: {
               //#line 376 "../../lpg/btParserTemplateF.gi"
				
				EList<InvOrDefCS> list = (EList<InvOrDefCS>)getRhsSym(3);
				ClassifierContextDeclCS result = createClassifierContextDeclCS(
						null,
						(PathNameCS)getRhsSym(2),
						list
					);
				setOffsets(result, getRhsIToken(1), list.get(list.size()-1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 284:  classifierContextDeclCS ::= context simpleNameCS : pathNameCS invOrDefsCS
            //
            case 284: {
               //#line 388 "../../lpg/btParserTemplateF.gi"
				
				EList<InvOrDefCS> list = (EList<InvOrDefCS>)getRhsSym(5);
				ClassifierContextDeclCS result = createClassifierContextDeclCS(
						(SimpleNameCS)getRhsSym(2),
						(PathNameCS)getRhsSym(4),
						list
					);
				setOffsets(result, getRhsIToken(1), list.get(list.size()-1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 285:  invOrDefsCS ::= invOrDefCS
            //
            case 285: {
               //#line 401 "../../lpg/btParserTemplateF.gi"
				
                EList<InvOrDefCS> result = new BasicEList<InvOrDefCS>();
                result.add((InvOrDefCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 286:  invOrDefsCS ::= invOrDefsCS invOrDefCS
            //
            case 286: {
               //#line 408 "../../lpg/btParserTemplateF.gi"
				
                EList<InvOrDefCS> result = (EList<InvOrDefCS>)getRhsSym(1);
                result.add((InvOrDefCS)getRhsSym(2));
                setResult(result);
                      break;
            }
    
            //
            // Rule 287:  invOrDefCS ::= inv unreservedSimpleNameCSopt : OclExpressionCS
            //
            case 287: {
               //#line 416 "../../lpg/btParserTemplateF.gi"
				
				InvCS result = createInvCS(
						(SimpleNameCS)getRhsSym(2),
						(OCLExpressionCS)getRhsSym(4)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 288:  invOrDefCS ::= def unreservedSimpleNameCSopt : defExpressionCS
            //
            case 288: {
               //#line 426 "../../lpg/btParserTemplateF.gi"
				
                DefExpressionCS defExpressionCS = (DefExpressionCS)getRhsSym(4);
                DefCS result = createDefCS(
                        false,
                        (SimpleNameCS)getRhsSym(2),
                        defExpressionCS
                    );
                setOffsets(result, getRhsIToken(1), defExpressionCS);
                setResult(result);
                      break;
            }
    
            //
            // Rule 289:  invOrDefCS ::= static def unreservedSimpleNameCSopt : defExpressionCS
            //
            case 289: {
               //#line 438 "../../lpg/btParserTemplateF.gi"
				
                DefExpressionCS defExpressionCS = (DefExpressionCS)getRhsSym(5);
                DefCS result = createDefCS(
                        true,
                        (SimpleNameCS)getRhsSym(3),
                        defExpressionCS
                    );
                setOffsets(result, getRhsIToken(1), defExpressionCS);
                setResult(result);
                      break;
            }
    
            //
            // Rule 290:  defExpressionCS ::= typedUninitializedVariableCS = OclExpressionCS
            //
            case 290: {
               //#line 451 "../../lpg/btParserTemplateF.gi"
				
				VariableCS variableCS = (VariableCS)getRhsSym(1);
				OCLExpressionCS expressionCS = (OCLExpressionCS)getRhsSym(3);
				DefExpressionCS result = createDefExpressionCS(
						variableCS,
						null,
						expressionCS
					);
				setOffsets(result, variableCS, expressionCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 291:  defExpressionCS ::= operationCS1 = OclExpressionCS
            //
            case 291: {
               //#line 464 "../../lpg/btParserTemplateF.gi"
				
				DefExpressionCS result = createDefExpressionCS(
						null,
						(OperationCS)getRhsSym(1),
						(OCLExpressionCS)getRhsSym(3)
					);
				setOffsets(result, (CSTNode)getRhsSym(1), (CSTNode)getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 292:  operationContextDeclCS ::= context operationCS2 prePostOrBodyDeclsCS
            //
            case 292: {
               //#line 476 "../../lpg/btParserTemplateF.gi"
				
				EList<PrePostOrBodyDeclCS> prePostOrBodyDecls = (EList<PrePostOrBodyDeclCS>)getRhsSym(3);
				OperationContextDeclCS result = createOperationContextDeclCS(
						(OperationCS)getRhsSym(2),
						prePostOrBodyDecls
					);
				setOffsets(result, getRhsIToken(1), prePostOrBodyDecls.get(prePostOrBodyDecls.size()-1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 293:  prePostOrBodyDeclsCS ::= prePostOrBodyDeclCS
            //
            case 293: {
               //#line 488 "../../lpg/btParserTemplateF.gi"
				
                EList<PrePostOrBodyDeclCS> result = new BasicEList<PrePostOrBodyDeclCS>();
                result.add((PrePostOrBodyDeclCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 294:  prePostOrBodyDeclsCS ::= prePostOrBodyDeclsCS prePostOrBodyDeclCS
            //
            case 294: {
               //#line 495 "../../lpg/btParserTemplateF.gi"
				
                EList<PrePostOrBodyDeclCS> result = (EList<PrePostOrBodyDeclCS>)getRhsSym(1);
                result.add((PrePostOrBodyDeclCS)getRhsSym(2));
                setResult(result);
                      break;
            }
    
            //
            // Rule 295:  prePostOrBodyDeclCS ::= pre unreservedSimpleNameCSopt : OclExpressionCS
            //
            case 295: {
               //#line 503 "../../lpg/btParserTemplateF.gi"
				
                PrePostOrBodyDeclCS result = createPrePostOrBodyDeclCS(
                        PrePostOrBodyEnum.PRE_LITERAL,
                        (SimpleNameCS)getRhsSym(2),
                        (OCLExpressionCS)getRhsSym(4)
                    );
                setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 296:  prePostOrBodyDeclCS ::= post unreservedSimpleNameCSopt : OclExpressionCS
            //
            case 296: {
               //#line 514 "../../lpg/btParserTemplateF.gi"
				
                PrePostOrBodyDeclCS result = createPrePostOrBodyDeclCS(
                        PrePostOrBodyEnum.POST_LITERAL,
                        (SimpleNameCS)getRhsSym(2),
                        (OCLExpressionCS)getRhsSym(4)
                    );
                setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 297:  prePostOrBodyDeclCS ::= body unreservedSimpleNameCSopt : OclExpressionCS
            //
            case 297: {
               //#line 525 "../../lpg/btParserTemplateF.gi"
				
                PrePostOrBodyDeclCS result = createPrePostOrBodyDeclCS(
                        PrePostOrBodyEnum.BODY_LITERAL,
                        (SimpleNameCS)getRhsSym(2),
                        (OCLExpressionCS)getRhsSym(4)
                    );
                setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 298:  operationCS1 ::= simpleNameCS ( parametersCSopt ) : typeCSopt
            //
            case 298: {
               //#line 537 "../../lpg/btParserTemplateF.gi"
				
				OperationCS result = createOperationCS(
						getRhsIToken(1),
						(EList<VariableCS>)getRhsSym(3),
						(TypeCS)getRhsSym(6)
					);
				if (getRhsSym(6) != null) {
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(6));
				} else {
					setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 299:  operationCS2 ::= pathNameCS :: unreservedSimpleNameCS ( parametersCSopt ) : typeCSopt
            //
            case 299: {
               //#line 553 "../../lpg/btParserTemplateF.gi"
				
				PathNameCS pathNameCS = (PathNameCS)getRhsSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
				TypeCS typeCS = (TypeCS)getRhsSym(8);
				OperationCS result = createOperationCS(
						pathNameCS,
						simpleNameCS,
						(EList<VariableCS>)getRhsSym(5),
						typeCS
					);
				if (typeCS != null) {
					setOffsets(result, pathNameCS, typeCS);
				} else {
					setOffsets(result, pathNameCS, getRhsIToken(7));
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 300:  parametersCSopt ::= $Empty
            //
            case 300: {
               //#line 573 "../../lpg/btParserTemplateF.gi"
				
                setResult(new BasicEList<VariableCS>());
                      break;
            }
    
            //
            // Rule 302:  parametersCS ::= VariableDeclarationCS
            //
            case 302: {
               //#line 580 "../../lpg/btParserTemplateF.gi"
				
				EList<VariableCS> result = new BasicEList<VariableCS>();
				result.add((VariableCS)getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 303:  parametersCS ::= parametersCS , VariableDeclarationCS
            //
            case 303: {
               //#line 587 "../../lpg/btParserTemplateF.gi"
				
				EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
				result.add((VariableCS)getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 304:  ERROR_Colon ::= ERROR_TOKEN
            //
            case 304: {
               //#line 48 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(1), OCLParserErrors.MISSING_COLON);
	                  break;
            }
	
            //
            // Rule 305:  ERROR_Empty ::= ERROR_TOKEN
            //
            case 305: {
               //#line 53 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(1), OCLParserErrors.EXTRA_TOKENS);
	                  break;
            }
	
            //
            // Rule 306:  ERROR_SimpleNameCS ::= ERROR_TOKEN
            //
            case 306: {
               //#line 63 "../../lpg/btParserTemplateF.gi"
									
				reportErrorTokenMessage(getRhsTokenIndex(1), OCLParserErrors.MISSING_SIMPLE_NAME);
                IToken iToken = getRhsIToken(1);
				SimpleNameCS result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						iToken
					);
				setOffsets(result, iToken);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 308:  collectionTypeCS ::= CollectionTypeIdentifierCS ( typeCS ERROR_TOKEN
            //
            case 308: {
               //#line 82 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(4), OCLParserErrors.MISSING_RPAREN);
				CollectionTypeCS result = (CollectionTypeCS)getRhsSym(1); 
				result.setTypeCS((TypeCS)getRhsSym(3));
				setOffsets(result, result, getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 309:  TupleLiteralExpCS ::= Tuple ERROR_TOKEN
            //
            case 309: {
               //#line 116 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(2), OCLParserErrors.MISSING_LBRACE);
				TupleLiteralExpCS result = createTupleLiteralExpCS((EList<VariableCS>)getRhsSym(3));
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 310:  TupleLiteralPartsCS ::= ERROR_TOKEN
            //
            case 310: {
               //#line 125 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(1), OCLParserErrors.MISSING_VARIABLES);
				EList<VariableCS> result = new BasicEList<VariableCS>();
				setResult(result);
	                  break;
            }
	
            //
            // Rule 311:  AssociationClassCallExpCS ::= simpleNameCS [ argumentsCS ERROR_TOKEN
            //
            case 311: {
               //#line 136 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(4), OCLParserErrors.MISSING_RBRACK);
				VariableExpCS result = createVariableExpCS(
						(SimpleNameCS)getRhsSym(1),
						(EList<OCLExpressionCS>)getRhsSym(3),
						null
					);
				setOffsets(result, (CSTNode)getRhsSym(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 312:  IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS ERROR_TOKEN
            //
            case 312: {
               //#line 152 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(7), OCLParserErrors.MISSING_ENDIF);
				IfExpCS result = createIfExpCS(
						(OCLExpressionCS)getRhsSym(2),
						(OCLExpressionCS)getRhsSym(4),
						(OCLExpressionCS)getRhsSym(6)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(7));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 313:  IfExpCS ::= if OclExpressionCS then OclExpressionCS ERROR_TOKEN
            //
            case 313: {
               //#line 164 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(5), OCLParserErrors.MISSING_ELSE_ENDIF);
				IfExpCS result = createIfExpCS(
						(OCLExpressionCS)getRhsSym(2),
						(OCLExpressionCS)getRhsSym(4),
						createInvalidLiteralExpCS(getRhsTokenText(5))
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 314:  IfExpCS ::= if OclExpressionCS ERROR_TOKEN
            //
            case 314: {
               //#line 176 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(3), OCLParserErrors.MISSING_THEN_ELSE_ENDIF);
				IfExpCS result = createIfExpCS(
						(OCLExpressionCS)getRhsSym(2),
						createInvalidLiteralExpCS(getRhsTokenText(3)),
						createInvalidLiteralExpCS(getRhsTokenText(3))
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 315:  IfExpCS ::= if ERROR_TOKEN endif
            //
            case 315: {
               //#line 188 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(3), OCLParserErrors.MISSING_THEN_ELSE);
				IfExpCS result = createIfExpCS(
						createInvalidLiteralExpCS(getRhsTokenText(2)),
						createInvalidLiteralExpCS(getRhsTokenText(2)),
						createInvalidLiteralExpCS(getRhsTokenText(2))
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 316:  primaryExpCS ::= ( OclExpressionCS ERROR_TOKEN
            //
            case 316: {
               //#line 201 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(3), OCLParserErrors.MISSING_RPAREN);
				OCLExpressionCS result = (OCLExpressionCS)getRhsSym(2);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 317:  OclMessageExpCS ::= primaryExpCS ^^ simpleNameCS ERROR_TOKEN
            //
            
            case 317:

            //
            // Rule 318:  OclMessageExpCS ::= primaryExpCS ^ simpleNameCS ERROR_TOKEN
            //
            case 318: {
               //#line 42 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(2), OCLParserErrors.MISSING_MESSAGE_ARGUMENTS);
				OCLExpressionCS target = (OCLExpressionCS)getRhsSym(1);
				MessageExpCS result = createMessageExpCS(
						target,
						getRhsIToken(2).getKind() == OCLBacktrackingParsersym.TK_CARET,
						(SimpleNameCS)getRhsSym(3),
						new BasicEList<OCLMessageArgCS>()
					);
				setOffsets(result, target, getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 319:  classifierContextDeclCS ::= context pathNameCS ERROR_TOKEN
            //
            case 319: {
               //#line 60 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(3), OCLParserErrors.MISSING_INV_OR_DEF);
				ClassifierContextDeclCS result = createClassifierContextDeclCS(
						null,
						(PathNameCS)getRhsSym(2),
						new BasicEList<InvOrDefCS>()
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 320:  defExpressionCS ::= typedUninitializedVariableCS ERROR_TOKEN
            //
            case 320: {
               //#line 73 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(2), OCLParserErrors.MISSING_EQUALS);
				VariableCS variableCS = (VariableCS)getRhsSym(1);
				DefExpressionCS result = createDefExpressionCS(
						variableCS,
						null,
						null
					);
				setOffsets(result, variableCS, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 321:  defExpressionCS ::= simpleNameCS ERROR_Colon
            //
            case 321: {
               //#line 86 "../../lpg/btParserTemplateF.gi"
				
				SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
				VariableCS variableCS = createVariableCS(name, null, null);
				setOffsets(variableCS, name, getRhsIToken(2));
				DefExpressionCS result = createDefExpressionCS(
						variableCS,
						null,
						null
					);
				setOffsets(result, variableCS, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 322:  invOrDefCS ::= inv unreservedSimpleNameCS ERROR_Colon
            //
            case 322: {
               //#line 101 "../../lpg/btParserTemplateF.gi"
				
				InvCS result = createInvCS(
						(SimpleNameCS)getRhsSym(2),
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 323:  invOrDefCS ::= def unreservedSimpleNameCS ERROR_Colon
            //
            case 323: {
               //#line 111 "../../lpg/btParserTemplateF.gi"
				
                DefCS result = createDefCS(
                        false,
                        (SimpleNameCS)getRhsSym(2),
                        null
                    );
                setOffsets(result, getRhsIToken(1), getRhsIToken(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 324:  invOrDefCS ::= static def unreservedSimpleNameCS ERROR_Colon
            //
            case 324: {
               //#line 122 "../../lpg/btParserTemplateF.gi"
				
                DefCS result = createDefCS(
                        true,
                        (SimpleNameCS)getRhsSym(3),
                        null
                    );
                setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 325:  operationCS1 ::= simpleNameCS ( parametersCSopt ) ERROR_Colon
            //
            case 325: {
               //#line 134 "../../lpg/btParserTemplateF.gi"
				
				OperationCS result = createOperationCS(
						getRhsIToken(1),
						new BasicEList<VariableCS>(),
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 326:  operationCS1 ::= simpleNameCS ERROR_TOKEN
            //
            case 326: {
               //#line 145 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(2), OCLParserErrors.MISSING_LPAREN);
				OperationCS result = createOperationCS(
						getRhsIToken(1),
						new BasicEList<VariableCS>(),
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 327:  operationCS1 ::= ERROR_TOKEN
            //
            case 327: {
               //#line 157 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(1), OCLParserErrors.MISSING_IDENTIFIER);
				OperationCS result = createOperationCS(
						getRhsIToken(1),
						new BasicEList<VariableCS>(),
						null
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 328:  operationCS2 ::= pathNameCS :: unreservedSimpleNameCS ( parametersCSopt ) ERROR_Colon
            //
            case 328: {
               //#line 169 "../../lpg/btParserTemplateF.gi"
				
				PathNameCS pathNameCS = (PathNameCS)getRhsSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
				OperationCS result = createOperationCS(
						pathNameCS,
						simpleNameCS,
						(EList<VariableCS>)getRhsSym(5),
						null
					);
				setOffsets(result, pathNameCS, getRhsIToken(7));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 329:  operationCS2 ::= pathNameCS :: ERROR_SimpleNameCS
            //
            case 329: {
               //#line 183 "../../lpg/btParserTemplateF.gi"
				
				PathNameCS pathNameCS = (PathNameCS)getRhsSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
				OperationCS result = createOperationCS(
						pathNameCS,
						simpleNameCS,
						new BasicEList<VariableCS>(),
						null
					);
				setOffsets(result, pathNameCS, simpleNameCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 330:  prePostOrBodyDeclCS ::= pre unreservedSimpleNameCS ERROR_Colon
            //
            case 330: {
               //#line 198 "../../lpg/btParserTemplateF.gi"
				
				PrePostOrBodyDeclCS result = createPrePostOrBodyDeclCS(
						PrePostOrBodyEnum.PRE_LITERAL,
						(SimpleNameCS)getRhsSym(2),
						createInvalidLiteralExpCS(getRhsTokenText(3))
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 331:  prePostOrBodyDeclCS ::= post unreservedSimpleNameCS ERROR_Colon
            //
            case 331: {
               //#line 209 "../../lpg/btParserTemplateF.gi"
				
				PrePostOrBodyDeclCS result = createPrePostOrBodyDeclCS(
						PrePostOrBodyEnum.POST_LITERAL,
						(SimpleNameCS)getRhsSym(2),
						createInvalidLiteralExpCS(getRhsTokenText(3))
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 332:  prePostOrBodyDeclCS ::= body unreservedSimpleNameCS ERROR_Colon
            //
            case 332: {
               //#line 220 "../../lpg/btParserTemplateF.gi"
				
				PrePostOrBodyDeclCS result = createPrePostOrBodyDeclCS(
						PrePostOrBodyEnum.BODY_LITERAL,
						(SimpleNameCS)getRhsSym(2),
						createInvalidLiteralExpCS(getRhsTokenText(3))
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 333:  initOrDerValueCS ::= init ERROR_Colon
            //
            case 333: {
               //#line 232 "../../lpg/btParserTemplateF.gi"
				
				InitValueCS result = createInitValueCS(null);
				setOffsets(result, getRhsIToken(2), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 334:  initOrDerValueCS ::= derive ERROR_Colon
            //
            case 334: {
               //#line 239 "../../lpg/btParserTemplateF.gi"
				
				DerValueCS result = createDerValueCS(null);
				setOffsets(result, getRhsIToken(2), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 335:  packageDeclarationCS_A ::= package pathNameCS contextDeclsCSopt ERROR_Empty endpackage
            //
            case 335: {
               //#line 247 "../../lpg/btParserTemplateF.gi"
				
				PackageDeclarationCS result = createPackageDeclarationCS(
						(PathNameCS)getRhsSym(2),
						(EList<ContextDeclCS>)getRhsSym(3)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 336:  packageDeclarationCS_A ::= package pathNameCS contextDeclsCSopt ERROR_TOKEN
            //
            case 336: {
               //#line 257 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(4), OCLParserErrors.MISSING_ENDPACKAGE);
				PackageDeclarationCS result = createPackageDeclarationCS(
						(PathNameCS)getRhsSym(2),
						(EList<ContextDeclCS>)getRhsSym(3)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
    
            default:
                break;
        }
        return;
    }
}

