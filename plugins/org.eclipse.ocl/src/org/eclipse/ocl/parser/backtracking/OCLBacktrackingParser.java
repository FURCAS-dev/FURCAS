/**
* Essential OCL Grammar
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
*   E.D.Willink - Elimination of some shift-reduce conflicts
*   E.D.Willink - Remove unnecessary warning suppression
*   E.D.Willink - Bugs 184048, 225493, 243976, 259818, 282882, 287993, 288040, 292112
*   Borland - Bug 242880
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias):
*        - 242153: LPG v 2.0.17 adoption.
*        - 299396: Introducing new LPG templates
*        - 300534: Removing the use of deprecated macros.
* </copyright>
*
* $Id: OCLBacktrackingParser.java,v 1.21 2010/02/03 19:54:12 ewillink Exp $
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
            // Rule 37:  pathNameCS ::= simpleNameCS
            //
            case 37: {
               //#line 365 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS simpleName = (SimpleNameCS)getRhsSym(1);
                PathNameCS result = createPathNameCS(simpleName);
                setOffsets(result, simpleName);
                setResult(result);
                      break;
            }
    
            //
            // Rule 38:  pathNameCS ::= pathNameCS :: unreservedSimpleNameCS
            //
            case 38: {
               //#line 373 "../../lpg/btParserTemplateF.gi"
				
                PathNameCS result = (PathNameCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                result = extendPathNameCS(result, simpleNameCS);
                setOffsets(result, result, simpleNameCS);
                setResult(result);
                      break;
            }
    
            //
            // Rule 39:  primitiveTypeCS ::= Boolean
            //
            case 39: {
               //#line 386 "../../lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.BOOLEAN_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 40:  primitiveTypeCS ::= Integer
            //
            case 40: {
               //#line 396 "../../lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.INTEGER_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 41:  primitiveTypeCS ::= Real
            //
            case 41: {
               //#line 406 "../../lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.REAL_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 42:  primitiveTypeCS ::= String
            //
            case 42: {
               //#line 416 "../../lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.STRING_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 43:  primitiveTypeCS ::= UnlimitedNatural
            //
            case 43: {
               //#line 426 "../../lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 44:  primitiveTypeCS ::= OclAny
            //
            case 44: {
               //#line 437 "../../lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_ANY_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 45:  primitiveTypeCS ::= OclInvalid
            //
            case 45: {
               //#line 447 "../../lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_INVALID_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 46:  primitiveTypeCS ::= OclVoid
            //
            case 46: {
               //#line 457 "../../lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_VOID_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 47:  CollectionTypeIdentifierCS ::= Set
            //
            case 47: {
               //#line 468 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.SET_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 48:  CollectionTypeIdentifierCS ::= Bag
            //
            case 48: {
               //#line 478 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.BAG_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 49:  CollectionTypeIdentifierCS ::= Sequence
            //
            case 49: {
               //#line 488 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.SEQUENCE_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 50:  CollectionTypeIdentifierCS ::= Collection
            //
            case 50: {
               //#line 498 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.COLLECTION_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 51:  CollectionTypeIdentifierCS ::= OrderedSet
            //
            case 51: {
               //#line 508 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 56:  collectionTypeCS ::= CollectionTypeIdentifierCS ( typeCS )
            //
            case 56: {
               //#line 524 "../../lpg/btParserTemplateF.gi"
				
                CollectionTypeCS result = (CollectionTypeCS)getRhsSym(1);
                result.setTypeCS((TypeCS)getRhsSym(3));
                setOffsets(result, result, getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 57:  tupleTypeCS ::= Tuple ( tupleTypePartsCSopt )
            //
            case 57: {
               //#line 533 "../../lpg/btParserTemplateF.gi"
				
                 TupleTypeCS result = createTupleTypeCS((EList<VariableCS>)getRhsSym(3));
                setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 58:  tupleTypePartsCSopt ::= $Empty
            //
            case 58: {
               //#line 541 "../../lpg/btParserTemplateF.gi"
				
                setResult(new BasicEList<VariableCS>());
                      break;
            }
    
            //
            // Rule 60:  tupleTypePartsCS ::= typedUninitializedVariableCS
            //
            case 60: {
               //#line 548 "../../lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 61:  tupleTypePartsCS ::= tupleTypePartsCS , typedUninitializedVariableCS
            //
            case 61: {
               //#line 555 "../../lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                result.add((VariableCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 62:  untypedUninitializedVariableCS ::= simpleNameCS
            //
            case 62: {
               //#line 566 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                VariableCS result = createVariableCS(name, null, null);
                setOffsets(result, name);
                setResult(result);
                      break;
            }
    
            //
            // Rule 63:  typedUninitializedVariableCS ::= simpleNameCS : typeCS
            //
            case 63: {
               //#line 575 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                TypeCS type = (TypeCS)getRhsSym(3);
                VariableCS result = createVariableCS(name, type, null);
                setOffsets(result, name, type);
                setResult(result);
                      break;
            }
    
            //
            // Rule 64:  untypedInitializedVariableCS ::= simpleNameCS = OclExpressionCS
            //
            case 64: {
               //#line 585 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                OCLExpressionCS initExpression = (OCLExpressionCS)getRhsSym(3);
                VariableCS result = createVariableCS(name, null, initExpression);
                setOffsets(result, name, initExpression);
                setResult(result);
                      break;
            }
    
            //
            // Rule 65:  typedInitializedVariableCS ::= simpleNameCS : typeCS = OclExpressionCS
            //
            case 65: {
               //#line 595 "../../lpg/btParserTemplateF.gi"
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                TypeCS type = (TypeCS)getRhsSym(3);
                OCLExpressionCS initExpression = (OCLExpressionCS)getRhsSym(5);
                VariableCS result = createVariableCS(name, type, initExpression);
                setOffsets(result, name, initExpression);
                setResult(result);
                      break;
            }
    
            //
            // Rule 78:  CollectionLiteralExpCS ::= CollectionTypeIdentifierCS { CollectionLiteralPartsCSopt }
            //
            case 78: {
               //#line 628 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 79:  CollectionLiteralExpCS ::= collectionTypeCS { CollectionLiteralPartsCSopt }
            //
            case 79: {
               //#line 639 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 80:  CollectionLiteralPartsCSopt ::= $Empty
            //
            case 80: {
               //#line 651 "../../lpg/btParserTemplateF.gi"
				
                setResult(new BasicEList<CollectionLiteralPartCS>());
                      break;
            }
    
            //
            // Rule 82:  CollectionLiteralPartsCS ::= CollectionLiteralPartCS
            //
            case 82: {
               //#line 658 "../../lpg/btParserTemplateF.gi"
				
                EList<CollectionLiteralPartCS> result = new BasicEList<CollectionLiteralPartCS>();
                result.add((CollectionLiteralPartCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 83:  CollectionLiteralPartsCS ::= CollectionLiteralPartsCS , CollectionLiteralPartCS
            //
            case 83: {
               //#line 665 "../../lpg/btParserTemplateF.gi"
				
                EList<CollectionLiteralPartCS> result = (EList<CollectionLiteralPartCS>)getRhsSym(1);
                result.add((CollectionLiteralPartCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 85:  CollectionLiteralPartCS ::= OclExpressionCS
            //
            case 85: {
               //#line 674 "../../lpg/btParserTemplateF.gi"
				
                CollectionLiteralPartCS result = createCollectionLiteralPartCS(
                        (OCLExpressionCS)getRhsSym(1)
                    );
                setOffsets(result, (CSTNode)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 86:  CollectionRangeCS ::= OclExpressionCS .. OclExpressionCS
            //
            case 86: {
               //#line 684 "../../lpg/btParserTemplateF.gi"
				
                CollectionLiteralPartCS result = createCollectionRangeCS(
                        (OCLExpressionCS)getRhsSym(1),
                        (OCLExpressionCS)getRhsSym(3)
                    );
                setOffsets(result, (CSTNode)getRhsSym(1), (CSTNode)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 94:  TupleLiteralExpCS ::= Tuple { TupleLiteralPartsCS }
            //
            case 94: {
               //#line 703 "../../lpg/btParserTemplateF.gi"
				
                TupleLiteralExpCS result = createTupleLiteralExpCS((EList<VariableCS>)getRhsSym(3));
                setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 95:  TupleLiteralPartsCS ::= initializedVariableCS
            //
            case 95: {
               //#line 711 "../../lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 96:  TupleLiteralPartsCS ::= TupleLiteralPartsCS , initializedVariableCS
            //
            case 96: {
               //#line 718 "../../lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                result.add((VariableCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 97:  IntegerLiteralExpCS ::= INTEGER_LITERAL
            //
            case 97: {
               //#line 726 "../../lpg/btParserTemplateF.gi"
				
                IntegerLiteralExpCS result = createIntegerLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 98:  RealLiteralExpCS ::= REAL_LITERAL
            //
            case 98: {
               //#line 734 "../../lpg/btParserTemplateF.gi"
				
                RealLiteralExpCS result = createRealLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 99:  StringLiteralExpCS ::= STRING_LITERAL
            //
            case 99: {
               //#line 742 "../../lpg/btParserTemplateF.gi"
				
                IToken literalToken = getRhsIToken(1);
                StringLiteralExpCS result = createStringLiteralExpCS(literalToken);
                setOffsets(result, literalToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 100:  StringLiteralExpCS ::= StringLiteralExpCS STRING_LITERAL
            //
            case 100: {
               //#line 750 "../../lpg/btParserTemplateF.gi"
				
                StringLiteralExpCS string = (StringLiteralExpCS)getRhsSym(1);
                IToken literalToken = getRhsIToken(2);
                StringLiteralExpCS result = extendStringLiteralExpCS(string, literalToken);
                setOffsets(result, string, literalToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 101:  BooleanLiteralExpCS ::= true
            //
            case 101: {
               //#line 760 "../../lpg/btParserTemplateF.gi"
				
                BooleanLiteralExpCS result = createBooleanLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 102:  BooleanLiteralExpCS ::= false
            //
            case 102: {
               //#line 767 "../../lpg/btParserTemplateF.gi"
				
                BooleanLiteralExpCS result = createBooleanLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 103:  UnlimitedNaturalLiteralExpCS ::= *
            //
            case 103: {
               //#line 775 "../../lpg/btParserTemplateF.gi"
				
                UnlimitedNaturalLiteralExpCS result = createUnlimitedNaturalLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 104:  InvalidLiteralExpCS ::= invalid
            //
            case 104: {
               //#line 783 "../../lpg/btParserTemplateF.gi"
				
                InvalidLiteralExpCS result = createInvalidLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 105:  NullLiteralExpCS ::= null
            //
            case 105: {
               //#line 791 "../../lpg/btParserTemplateF.gi"
				
                NullLiteralExpCS result = createNullLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
     
            //
            // Rule 106:  TypeLiteralExpCS ::= primitiveTypeCS
            //
            
            case 106:
 
            //
            // Rule 107:  TypeLiteralExpCS ::= collectionTypeCS
            //
            
            case 107:

            //
            // Rule 108:  TypeLiteralExpCS ::= tupleTypeCS
            //
            case 108: {
               //#line 805 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 113:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( uninitializedVariableCS | OclExpressionCS )
            //
            case 113: {
               //#line 830 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 114:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( simpleNameCS , uninitializedVariableCS | OclExpressionCS )
            //
            case 114: {
               //#line 847 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 115:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( typedUninitializedVariableCS , uninitializedVariableCS | OclExpressionCS )
            //
            case 115: {
               //#line 867 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 116:  IterateExpCS ::= primaryExpCS -> simpleNameCS ( typedInitializedVariableCS | OclExpressionCS )
            //
            case 116: {
               //#line 888 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 117:  IterateExpCS ::= primaryExpCS -> simpleNameCS ( uninitializedVariableCS ; typedInitializedVariableCS | OclExpressionCS )
            //
            case 117: {
               //#line 904 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 121:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( )
            //
            case 121: {
               //#line 926 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 122:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( OclExpressionCS )
            //
            case 122: {
               //#line 940 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 123:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( notNameExpressionCS , argumentsCS )
            //
            case 123: {
               //#line 970 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 124:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( simpleNameCS , argumentsCS )
            //
            case 124: {
               //#line 986 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 125:  OperationCallExpCS ::= primaryExpCS . conceptualOperationNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            
            case 125:

            //
            // Rule 126:  OperationCallExpCS ::= primaryExpCS . simpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 126: {
               //#line 1012 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 127:  OperationCallExpCS ::= simpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 127: {
               //#line 1028 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 128:  OperationCallExpCS ::= pathNameCS :: unreservedSimpleNameCS ( argumentsCSopt )
            //
            case 128: {
               //#line 1042 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 129:  OperationCallExpCS ::= primaryExpCS . pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 129: {
               //#line 1060 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 131:  PropertyCallExpCS ::= pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt
            //
            case 131: {
               //#line 1084 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 132:  PropertyCallExpCS ::= primaryExpCS . pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt
            //
            case 132: {
               //#line 1105 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 133:  AssociationClassCallExpCS ::= primaryExpCS . simpleNameCS isMarkedPreCSopt
            //
            case 133: {
               //#line 1128 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 134:  AssociationClassCallExpCS ::= primaryExpCS . simpleNameCS [ argumentsCS ] isMarkedPreCSopt
            //
            case 134: {
               //#line 1149 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 135:  AssociationClassCallExpCS ::= simpleNameCS [ argumentsCS ] isMarkedPreCSopt
            //
            case 135: {
               //#line 1172 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 136:  isMarkedPreCSopt ::= $Empty
            //
            case 136: {
               //#line 1190 "../../lpg/btParserTemplateF.gi"
				
                setResult(null);
                      break;
            }
    
            //
            // Rule 137:  argumentsCSopt ::= $Empty
            //
            case 137: {
               //#line 1196 "../../lpg/btParserTemplateF.gi"
				
                setResult(new BasicEList<OCLExpressionCS>());
                      break;
            }
    
            //
            // Rule 139:  argumentsCS ::= OclExpressionCS
            //
            case 139: {
               //#line 1203 "../../lpg/btParserTemplateF.gi"
				
                EList<OCLExpressionCS> result = new BasicEList<OCLExpressionCS>();
                result.add((OCLExpressionCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 140:  argumentsCS ::= argumentsCS , OclExpressionCS
            //
            case 140: {
               //#line 1210 "../../lpg/btParserTemplateF.gi"
				
                EList<OCLExpressionCS> result = (EList<OCLExpressionCS>)getRhsSym(1);
                result.add((OCLExpressionCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 143:  VariableExpCS ::= selfKeywordCS
            //
            case 143: {
               //#line 1235 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 144:  SimpleNameExpCS ::= simpleNameCS
            //
            case 144: {
               //#line 1250 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 150:  impliesNotNameNotLetCS ::= impliesNotLetCS implies xorNotLetCS
            //
            
            case 150:
 
            //
            // Rule 152:  impliesWithLetCS ::= impliesNotLetCS implies xorWithLetCS
            //
            
            case 152:
 
            //
            // Rule 156:  xorNotNameNotLetCS ::= xorNotLetCS xor orNotLetCS
            //
            
            case 156:
 
            //
            // Rule 158:  xorWithLetCS ::= xorNotLetCS xor orWithLetCS
            //
            
            case 158:
 
            //
            // Rule 162:  orNotNameNotLetCS ::= orNotLetCS or andNotLetCS
            //
            
            case 162:
 
            //
            // Rule 164:  orWithLetCS ::= orNotLetCS or andWithLetCS
            //
            
            case 164:
 
            //
            // Rule 168:  andNotNameNotLetCS ::= andNotLetCS and equalityNotLetCS
            //
            
            case 168:
 
            //
            // Rule 170:  andWithLetCS ::= andNotLetCS and equalityWithLetCS
            //
            
            case 170:
 
            //
            // Rule 174:  equalityNotNameNotLetCS ::= equalityNotLetCS = relationalNotLetCS
            //
            
            case 174:
 
            //
            // Rule 175:  equalityNotNameNotLetCS ::= equalityNotLetCS <> relationalNotLetCS
            //
            
            case 175:
 
            //
            // Rule 177:  equalityWithLetCS ::= equalityNotLetCS = relationalWithLetCS
            //
            
            case 177:
 
            //
            // Rule 178:  equalityWithLetCS ::= equalityNotLetCS <> relationalWithLetCS
            //
            
            case 178:
 
            //
            // Rule 182:  relationalNotNameNotLetCS ::= relationalNotLetCS > additiveNotLetCS
            //
            
            case 182:
 
            //
            // Rule 183:  relationalNotNameNotLetCS ::= relationalNotLetCS < additiveNotLetCS
            //
            
            case 183:
 
            //
            // Rule 184:  relationalNotNameNotLetCS ::= relationalNotLetCS >= additiveNotLetCS
            //
            
            case 184:
 
            //
            // Rule 185:  relationalNotNameNotLetCS ::= relationalNotLetCS <= additiveNotLetCS
            //
            
            case 185:
 
            //
            // Rule 187:  relationalWithLetCS ::= relationalNotLetCS > additiveWithLetCS
            //
            
            case 187:
 
            //
            // Rule 188:  relationalWithLetCS ::= relationalNotLetCS < additiveWithLetCS
            //
            
            case 188:
 
            //
            // Rule 189:  relationalWithLetCS ::= relationalNotLetCS >= additiveWithLetCS
            //
            
            case 189:
 
            //
            // Rule 190:  relationalWithLetCS ::= relationalNotLetCS <= additiveWithLetCS
            //
            
            case 190:
 
            //
            // Rule 194:  additiveNotNameNotLetCS ::= additiveNotLetCS + multiplicativeNotLetCS
            //
            
            case 194:
 
            //
            // Rule 195:  additiveNotNameNotLetCS ::= additiveNotLetCS - multiplicativeNotLetCS
            //
            
            case 195:
 
            //
            // Rule 197:  additiveWithLetCS ::= additiveNotLetCS + multiplicativeWithLetCS
            //
            
            case 197:
 
            //
            // Rule 198:  additiveWithLetCS ::= additiveNotLetCS - multiplicativeWithLetCS
            //
            
            case 198:
 
            //
            // Rule 202:  multiplicativeNotNameNotLetCS ::= multiplicativeNotLetCS * unaryNotLetCS
            //
            
            case 202:
 
            //
            // Rule 203:  multiplicativeNotNameNotLetCS ::= multiplicativeNotLetCS / unaryNotLetCS
            //
            
            case 203:
 
            //
            // Rule 205:  multiplicativeWithLetCS ::= multiplicativeNotLetCS * unaryWithLetCS
            //
            
            case 205:

            //
            // Rule 206:  multiplicativeWithLetCS ::= multiplicativeNotLetCS / unaryWithLetCS
            //
            case 206: {
               //#line 1359 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 210:  unaryNotNameNotLetCS ::= - unaryNotLetCS
            //
            
            case 210:
 
            //
            // Rule 211:  unaryNotNameNotLetCS ::= not unaryNotLetCS
            //
            
            case 211:
 
            //
            // Rule 213:  unaryWithLetCS ::= - unaryWithLetCS
            //
            
            case 213:

            //
            // Rule 214:  unaryWithLetCS ::= not unaryWithLetCS
            //
            case 214: {
               //#line 1390 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 221:  primaryNotNameCS ::= ( OclExpressionCS )
            //
            case 221: {
               //#line 1416 "../../lpg/btParserTemplateF.gi"
				
                OCLExpressionCS result = (OCLExpressionCS)getRhsSym(2);
                if (result instanceof OperationCallExpCS) {
                    ((OperationCallExpCS)result).setIsAtomic(true);
                }
                setOffsets(result, getRhsIToken(1), getRhsIToken(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 222:  IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS endif
            //
            case 222: {
               //#line 1427 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 223:  LetExpCS ::= let letVariablesCS in OclExpressionCS
            //
            case 223: {
               //#line 1439 "../../lpg/btParserTemplateF.gi"
				
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
            // Rule 224:  letVariablesCS ::= typedInitializedVariableCS
            //
            case 224: {
               //#line 1451 "../../lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 225:  letVariablesCS ::= letVariablesCS , typedInitializedVariableCS
            //
            case 225: {
               //#line 1458 "../../lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                result.add((VariableCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 243:  unreservedSimpleNameCSopt ::= $Empty
            //
            case 243:
                setResult(null);
                break;

            //
            // Rule 245:  primitiveTypeCS ::= OclMessage
            //
            case 245: {
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
            // Rule 246:  typeCSopt ::= $Empty
            //
            case 246:
                setResult(null);
                break;

            //
            // Rule 248:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS isMarkedPreCS ( argumentsCSopt )
            //
            case 248: {
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
            // Rule 249:  AssociationClassCallExpCS ::= simpleNameCS isMarkedPreCS
            //
            case 249: {
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
            // Rule 250:  isMarkedPreCS ::= @ pre
            //
            case 250: {
               //#line 184 "../../lpg/btParserTemplateF.gi"
				
				IsMarkedPreCS result = createIsMarkedPreCS();
				setOffsets(result, getRhsIToken(1), getRhsIToken(2));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 252:  OclMessageExpCS ::= primaryExpCS ^^ simpleNameCS ( OclMessageArgumentsCSopt )
            //
            
            case 252:

            //
            // Rule 253:  OclMessageExpCS ::= primaryExpCS ^ simpleNameCS ( OclMessageArgumentsCSopt )
            //
            case 253: {
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
            // Rule 254:  OclMessageArgumentsCSopt ::= $Empty
            //
            case 254: {
               //#line 209 "../../lpg/btParserTemplateF.gi"
				
                setResult(new BasicEList<OCLMessageArgCS>());
                      break;
            }
    
            //
            // Rule 256:  OclMessageArgumentsCS ::= OclMessageArgCS
            //
            case 256: {
               //#line 216 "../../lpg/btParserTemplateF.gi"
				
				EList<OCLMessageArgCS> result = new BasicEList<OCLMessageArgCS>();
				result.add((OCLMessageArgCS)getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 257:  OclMessageArgumentsCS ::= OclMessageArgumentsCS , OclMessageArgCS
            //
            case 257: {
               //#line 223 "../../lpg/btParserTemplateF.gi"
				
				EList<OCLMessageArgCS> result = (EList<OCLMessageArgCS>)getRhsSym(1);
				result.add((OCLMessageArgCS)getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 258:  OclMessageArgCS ::= ?
            //
            case 258: {
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
            // Rule 259:  OclMessageArgCS ::= ? : typeCS
            //
            case 259: {
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
            // Rule 260:  OclMessageArgCS ::= OclExpressionCS
            //
            case 260: {
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
            // Rule 263:  packageDeclarationsCS ::= packageDeclarationsCS packageDeclarationCS_A
            //
            case 263: {
               //#line 271 "../../lpg/btParserTemplateF.gi"
				
                PackageDeclarationCS result = (PackageDeclarationCS)getRhsSym(2);
                result.setPackageDeclarationCS((PackageDeclarationCS) getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 266:  packageDeclarationCS_A ::= package pathNameCS contextDeclsCSopt endpackage
            //
            case 266: {
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
            // Rule 267:  packageDeclarationCS_B ::= contextDeclsCS
            //
            case 267: {
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
            // Rule 268:  contextDeclsCSopt ::= $Empty
            //
            case 268: {
               //#line 303 "../../lpg/btParserTemplateF.gi"
				
                setResult(new BasicEList<ContextDeclCS>());
                      break;
            }
    
            //
            // Rule 270:  contextDeclsCS ::= contextDeclCS
            //
            case 270: {
               //#line 310 "../../lpg/btParserTemplateF.gi"
				
                EList<ContextDeclCS> result = new BasicEList<ContextDeclCS>();
                result.add((ContextDeclCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 271:  contextDeclsCS ::= contextDeclsCS contextDeclCS
            //
            case 271: {
               //#line 317 "../../lpg/btParserTemplateF.gi"
				
                EList<ContextDeclCS> result = (EList<ContextDeclCS>)getRhsSym(1);
                result.add((ContextDeclCS)getRhsSym(2));
                setResult(result);
                      break;
            }
    
            //
            // Rule 275:  propertyContextDeclCS ::= context pathNameCS :: unreservedSimpleNameCS : typeCS initOrDerValuesCS
            //
            case 275: {
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
            // Rule 276:  initOrDerValuesCS ::= initOrDerValueCS
            //
            case 276: {
               //#line 346 "../../lpg/btParserTemplateF.gi"
				
                EList<InitOrDerValueCS> result = new BasicEList<InitOrDerValueCS>();
                result.add((InitOrDerValueCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 277:  initOrDerValuesCS ::= initOrDerValuesCS initOrDerValueCS
            //
            case 277: {
               //#line 353 "../../lpg/btParserTemplateF.gi"
				
                EList<InitOrDerValueCS> result = (EList<InitOrDerValueCS>)getRhsSym(1);
                result.add((InitOrDerValueCS)getRhsSym(2));
                setResult(result);
                      break;
            }
    
            //
            // Rule 278:  initOrDerValueCS ::= init : OclExpressionCS
            //
            case 278: {
               //#line 361 "../../lpg/btParserTemplateF.gi"
				
                InitValueCS result = createInitValueCS((OCLExpressionCS)getRhsSym(3));
                setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 279:  initOrDerValueCS ::= derive : OclExpressionCS
            //
            case 279: {
               //#line 368 "../../lpg/btParserTemplateF.gi"
				
                DerValueCS result = createDerValueCS((OCLExpressionCS)getRhsSym(3));
                setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 280:  classifierContextDeclCS ::= context pathNameCS invOrDefsCS
            //
            case 280: {
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
            // Rule 281:  classifierContextDeclCS ::= context simpleNameCS : pathNameCS invOrDefsCS
            //
            case 281: {
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
            // Rule 282:  invOrDefsCS ::= invOrDefCS
            //
            case 282: {
               //#line 401 "../../lpg/btParserTemplateF.gi"
				
                EList<InvOrDefCS> result = new BasicEList<InvOrDefCS>();
                result.add((InvOrDefCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 283:  invOrDefsCS ::= invOrDefsCS invOrDefCS
            //
            case 283: {
               //#line 408 "../../lpg/btParserTemplateF.gi"
				
                EList<InvOrDefCS> result = (EList<InvOrDefCS>)getRhsSym(1);
                result.add((InvOrDefCS)getRhsSym(2));
                setResult(result);
                      break;
            }
    
            //
            // Rule 284:  invOrDefCS ::= inv unreservedSimpleNameCSopt : OclExpressionCS
            //
            case 284: {
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
            // Rule 285:  invOrDefCS ::= def unreservedSimpleNameCSopt : defExpressionCS
            //
            case 285: {
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
            // Rule 286:  invOrDefCS ::= static def unreservedSimpleNameCSopt : defExpressionCS
            //
            case 286: {
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
            // Rule 287:  defExpressionCS ::= typedUninitializedVariableCS = OclExpressionCS
            //
            case 287: {
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
            // Rule 288:  defExpressionCS ::= operationCS1 = OclExpressionCS
            //
            case 288: {
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
            // Rule 289:  operationContextDeclCS ::= context operationCS2 prePostOrBodyDeclsCS
            //
            case 289: {
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
            // Rule 290:  prePostOrBodyDeclsCS ::= prePostOrBodyDeclCS
            //
            case 290: {
               //#line 488 "../../lpg/btParserTemplateF.gi"
				
                EList<PrePostOrBodyDeclCS> result = new BasicEList<PrePostOrBodyDeclCS>();
                result.add((PrePostOrBodyDeclCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 291:  prePostOrBodyDeclsCS ::= prePostOrBodyDeclsCS prePostOrBodyDeclCS
            //
            case 291: {
               //#line 495 "../../lpg/btParserTemplateF.gi"
				
                EList<PrePostOrBodyDeclCS> result = (EList<PrePostOrBodyDeclCS>)getRhsSym(1);
                result.add((PrePostOrBodyDeclCS)getRhsSym(2));
                setResult(result);
                      break;
            }
    
            //
            // Rule 292:  prePostOrBodyDeclCS ::= pre unreservedSimpleNameCSopt : OclExpressionCS
            //
            case 292: {
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
            // Rule 293:  prePostOrBodyDeclCS ::= post unreservedSimpleNameCSopt : OclExpressionCS
            //
            case 293: {
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
            // Rule 294:  prePostOrBodyDeclCS ::= body unreservedSimpleNameCSopt : OclExpressionCS
            //
            case 294: {
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
            // Rule 295:  operationCS1 ::= simpleNameCS ( parametersCSopt ) : typeCSopt
            //
            case 295: {
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
            // Rule 296:  operationCS2 ::= pathNameCS :: unreservedSimpleNameCS ( parametersCSopt ) : typeCSopt
            //
            case 296: {
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
            // Rule 297:  parametersCSopt ::= $Empty
            //
            case 297: {
               //#line 573 "../../lpg/btParserTemplateF.gi"
				
                setResult(new BasicEList<VariableCS>());
                      break;
            }
    
            //
            // Rule 299:  parametersCS ::= VariableDeclarationCS
            //
            case 299: {
               //#line 580 "../../lpg/btParserTemplateF.gi"
				
				EList<VariableCS> result = new BasicEList<VariableCS>();
				result.add((VariableCS)getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 300:  parametersCS ::= parametersCS , VariableDeclarationCS
            //
            case 300: {
               //#line 587 "../../lpg/btParserTemplateF.gi"
				
				EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
				result.add((VariableCS)getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 301:  ERROR_Colon ::= ERROR_TOKEN
            //
            case 301: {
               //#line 48 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(1), OCLParserErrors.MISSING_COLON);
	                  break;
            }
	
            //
            // Rule 302:  ERROR_Empty ::= ERROR_TOKEN
            //
            case 302: {
               //#line 53 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(1), OCLParserErrors.EXTRA_TOKENS);
	                  break;
            }
	
            //
            // Rule 303:  ERROR_SimpleNameCS ::= ERROR_TOKEN
            //
            case 303: {
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
            // Rule 305:  collectionTypeCS ::= CollectionTypeIdentifierCS ( typeCS ERROR_TOKEN
            //
            case 305: {
               //#line 82 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(4), OCLParserErrors.MISSING_RPAREN);
				CollectionTypeCS result = (CollectionTypeCS)getRhsSym(1); 
				result.setTypeCS((TypeCS)getRhsSym(3));
				setOffsets(result, result, getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 306:  TupleLiteralExpCS ::= Tuple ERROR_TOKEN
            //
            case 306: {
               //#line 116 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(2), OCLParserErrors.MISSING_LBRACE);
				TupleLiteralExpCS result = createTupleLiteralExpCS((EList<VariableCS>)getRhsSym(3));
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 307:  TupleLiteralPartsCS ::= ERROR_TOKEN
            //
            case 307: {
               //#line 125 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(1), OCLParserErrors.MISSING_VARIABLES);
				EList<VariableCS> result = new BasicEList<VariableCS>();
				setResult(result);
	                  break;
            }
	
            //
            // Rule 308:  AssociationClassCallExpCS ::= simpleNameCS [ argumentsCS ERROR_TOKEN
            //
            case 308: {
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
            // Rule 309:  IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS ERROR_TOKEN
            //
            case 309: {
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
            // Rule 310:  IfExpCS ::= if OclExpressionCS then OclExpressionCS ERROR_TOKEN
            //
            case 310: {
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
            // Rule 311:  IfExpCS ::= if OclExpressionCS ERROR_TOKEN
            //
            case 311: {
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
            // Rule 312:  IfExpCS ::= if ERROR_TOKEN endif
            //
            case 312: {
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
            // Rule 313:  primaryExpCS ::= ( OclExpressionCS ERROR_TOKEN
            //
            case 313: {
               //#line 201 "../../lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(3), OCLParserErrors.MISSING_RPAREN);
				OCLExpressionCS result = (OCLExpressionCS)getRhsSym(2);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 314:  OclMessageExpCS ::= primaryExpCS ^^ simpleNameCS ERROR_TOKEN
            //
            
            case 314:

            //
            // Rule 315:  OclMessageExpCS ::= primaryExpCS ^ simpleNameCS ERROR_TOKEN
            //
            case 315: {
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
            // Rule 316:  classifierContextDeclCS ::= context pathNameCS ERROR_TOKEN
            //
            case 316: {
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
            // Rule 317:  defExpressionCS ::= typedUninitializedVariableCS ERROR_TOKEN
            //
            case 317: {
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
            // Rule 318:  defExpressionCS ::= simpleNameCS ERROR_Colon
            //
            case 318: {
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
            // Rule 319:  invOrDefCS ::= inv unreservedSimpleNameCS ERROR_Colon
            //
            case 319: {
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
            // Rule 320:  invOrDefCS ::= def unreservedSimpleNameCS ERROR_Colon
            //
            case 320: {
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
            // Rule 321:  invOrDefCS ::= static def unreservedSimpleNameCS ERROR_Colon
            //
            case 321: {
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
            // Rule 322:  operationCS1 ::= simpleNameCS ( parametersCSopt ) ERROR_Colon
            //
            case 322: {
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
            // Rule 323:  operationCS1 ::= simpleNameCS ERROR_TOKEN
            //
            case 323: {
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
            // Rule 324:  operationCS1 ::= ERROR_TOKEN
            //
            case 324: {
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
            // Rule 325:  operationCS2 ::= pathNameCS :: unreservedSimpleNameCS ( parametersCSopt ) ERROR_Colon
            //
            case 325: {
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
            // Rule 326:  operationCS2 ::= pathNameCS :: ERROR_SimpleNameCS
            //
            case 326: {
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
            // Rule 327:  prePostOrBodyDeclCS ::= pre unreservedSimpleNameCS ERROR_Colon
            //
            case 327: {
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
            // Rule 328:  prePostOrBodyDeclCS ::= post unreservedSimpleNameCS ERROR_Colon
            //
            case 328: {
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
            // Rule 329:  prePostOrBodyDeclCS ::= body unreservedSimpleNameCS ERROR_Colon
            //
            case 329: {
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
            // Rule 330:  initOrDerValueCS ::= init ERROR_Colon
            //
            case 330: {
               //#line 232 "../../lpg/btParserTemplateF.gi"
				
				InitValueCS result = createInitValueCS(null);
				setOffsets(result, getRhsIToken(2), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 331:  initOrDerValueCS ::= derive ERROR_Colon
            //
            case 331: {
               //#line 239 "../../lpg/btParserTemplateF.gi"
				
				DerValueCS result = createDerValueCS(null);
				setOffsets(result, getRhsIToken(2), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 332:  packageDeclarationCS_A ::= package pathNameCS contextDeclsCSopt ERROR_Empty endpackage
            //
            case 332: {
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
            // Rule 333:  packageDeclarationCS_A ::= package pathNameCS contextDeclsCSopt ERROR_TOKEN
            //
            case 333: {
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

