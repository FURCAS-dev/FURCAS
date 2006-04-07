/**
* <copyright>
*
* Copyright (c) 2005, 2006 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*
* </copyright>
*
* $Id: OCLLPGParser.java,v 1.3 2006/04/07 20:00:23 cdamus Exp $
*/

package org.eclipse.emf.ocl.internal.parser;


import lpg.lpgjavaruntime.BadParseException;
import lpg.lpgjavaruntime.BadParseSymFileException;
import lpg.lpgjavaruntime.DeterministicParser;
import lpg.lpgjavaruntime.DiagnoseParser;
import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.LexStream;
import lpg.lpgjavaruntime.Monitor;
import lpg.lpgjavaruntime.NotDeterministicParseTableException;
import lpg.lpgjavaruntime.NullExportedSymbolsException;
import lpg.lpgjavaruntime.NullTerminalSymbolsException;
import lpg.lpgjavaruntime.ParseTable;
import lpg.lpgjavaruntime.PrsStream;
import lpg.lpgjavaruntime.RuleAction;
import lpg.lpgjavaruntime.UndefinedEofSymbolException;
import lpg.lpgjavaruntime.UnimplementedTerminalsException;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ocl.internal.cst.BooleanLiteralExpCS;
import org.eclipse.emf.ocl.internal.cst.CSTFactory;
import org.eclipse.emf.ocl.internal.cst.CSTNode;
import org.eclipse.emf.ocl.internal.cst.CallExpCS;
import org.eclipse.emf.ocl.internal.cst.ClassifierContextDeclCS;
import org.eclipse.emf.ocl.internal.cst.CollectionLiteralExpCS;
import org.eclipse.emf.ocl.internal.cst.CollectionLiteralPartCS;
import org.eclipse.emf.ocl.internal.cst.CollectionRangeCS;
import org.eclipse.emf.ocl.internal.cst.CollectionTypeCS;
import org.eclipse.emf.ocl.internal.cst.CollectionTypeIdentifierEnum;
import org.eclipse.emf.ocl.internal.cst.DefCS;
import org.eclipse.emf.ocl.internal.cst.DefExpressionCS;
import org.eclipse.emf.ocl.internal.cst.DerValueCS;
import org.eclipse.emf.ocl.internal.cst.DotOrArrowEnum;
import org.eclipse.emf.ocl.internal.cst.EnumLiteralExpCS;
import org.eclipse.emf.ocl.internal.cst.FeatureCallExpCS;
import org.eclipse.emf.ocl.internal.cst.IfExpCS;
import org.eclipse.emf.ocl.internal.cst.InitOrDerValueCS;
import org.eclipse.emf.ocl.internal.cst.InitValueCS;
import org.eclipse.emf.ocl.internal.cst.IntegerLiteralExpCS;
import org.eclipse.emf.ocl.internal.cst.InvCS;
import org.eclipse.emf.ocl.internal.cst.InvOrDefCS;
import org.eclipse.emf.ocl.internal.cst.InvalidLiteralExpCS;
import org.eclipse.emf.ocl.internal.cst.IsMarkedPreCS;
import org.eclipse.emf.ocl.internal.cst.IterateExpCS;
import org.eclipse.emf.ocl.internal.cst.IteratorExpCS;
import org.eclipse.emf.ocl.internal.cst.LetExpCS;
import org.eclipse.emf.ocl.internal.cst.MessageExpCS;
import org.eclipse.emf.ocl.internal.cst.MessageExpKind;
import org.eclipse.emf.ocl.internal.cst.NullLiteralExpCS;
import org.eclipse.emf.ocl.internal.cst.OCLExpressionCS;
import org.eclipse.emf.ocl.internal.cst.OCLMessageArgCS;
import org.eclipse.emf.ocl.internal.cst.OperationCS;
import org.eclipse.emf.ocl.internal.cst.OperationCallExpCS;
import org.eclipse.emf.ocl.internal.cst.OperationContextDeclCS;
import org.eclipse.emf.ocl.internal.cst.PackageDeclarationCS;
import org.eclipse.emf.ocl.internal.cst.PathNameCS;
import org.eclipse.emf.ocl.internal.cst.PrePostOrBodyDeclCS;
import org.eclipse.emf.ocl.internal.cst.PrePostOrBodyEnum;
import org.eclipse.emf.ocl.internal.cst.PrimitiveTypeCS;
import org.eclipse.emf.ocl.internal.cst.PropertyContextCS;
import org.eclipse.emf.ocl.internal.cst.RealLiteralExpCS;
import org.eclipse.emf.ocl.internal.cst.SimpleNameCS;
import org.eclipse.emf.ocl.internal.cst.SimpleTypeEnum;
import org.eclipse.emf.ocl.internal.cst.StateExpCS;
import org.eclipse.emf.ocl.internal.cst.StringLiteralExpCS;
import org.eclipse.emf.ocl.internal.cst.TupleLiteralExpCS;
import org.eclipse.emf.ocl.internal.cst.TupleTypeCS;
import org.eclipse.emf.ocl.internal.cst.TypeCS;
import org.eclipse.emf.ocl.internal.cst.VariableCS;
import org.eclipse.emf.ocl.internal.cst.VariableExpCS;
import org.eclipse.emf.ocl.parser.ParserException;
import org.eclipse.emf.ocl.types.impl.AnyTypeImpl;
import org.eclipse.emf.ocl.types.impl.PrimitiveTypeImpl;
import org.eclipse.emf.ocl.utilities.PredefinedType;

public class OCLLPGParser extends PrsStream implements RuleAction {
	protected static ParseTable prs = new OCLLPGParserprs();
	private DeterministicParser dtParser;

	public OCLLPGParser(LexStream lexStream) {
		super(lexStream);

		try {
			super.remapTerminalSymbols(orderedTerminalSymbols(), OCLLPGParserprs.EOFT_SYMBOL);
		}
		catch(NullExportedSymbolsException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		}
		catch(NullTerminalSymbolsException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		}
		catch(UnimplementedTerminalsException e) {
			java.util.ArrayList unimplemented_symbols = e.getSymbols();
			String error = "The Lexer will not scan the following token(s):"; //$NON-NLS-1$
			for (int i = 0; i < unimplemented_symbols.size(); i++) {
				Integer id = (Integer) unimplemented_symbols.get(i);
				error += "\t" + OCLLPGParsersym.orderedTerminalSymbols[id.intValue()];	 //$NON-NLS-1$		   
			}
			throw new RuntimeException(error + "\n");	 //$NON-NLS-1$					
		}
		catch(UndefinedEofSymbolException e) {
			throw new RuntimeException("The Lexer does not implement the Eof symbol " + //$NON-NLS-1$
				 OCLLPGParsersym.orderedTerminalSymbols[OCLLPGParserprs.EOFT_SYMBOL]);
		} 
	}

	public String[] orderedTerminalSymbols() { return OCLLPGParsersym.orderedTerminalSymbols; }
	public String getTokenKindName(int kind) { return OCLLPGParsersym.orderedTerminalSymbols[kind]; }			
	public int getEOFTokenKind() { return OCLLPGParserprs.EOFT_SYMBOL; }
	public PrsStream getParseStream() { return this; }

	protected EObject parser() throws ParserException {
		return parser(null, 0);
	}
		
	protected EObject parser(Monitor monitor) throws ParserException {
		return parser(monitor, 0);
	}
		
	protected EObject parser(int error_repair_count) throws ParserException {
		return parser(null, error_repair_count);
	}
		
	protected EObject parser(Monitor monitor, int error_repair_count) throws ParserException {
		ParseTable prsTable = new OCLLPGParserprs();

		try {
			dtParser = new DeterministicParser(monitor, this, prsTable, this);
		}
		catch (NotDeterministicParseTableException e) {
			throw new RuntimeException("****Error: Regenerate OCLLPGParserprs.java with -NOBACKTRACK option"); //$NON-NLS-1$
		}
		catch (BadParseSymFileException e) {
			throw new RuntimeException("****Error: Bad Parser Symbol File -- OCLLPGParsersym.java. Regenerate OCLLPGParserprs.java"); //$NON-NLS-1$
		}

		try {
			return (EObject) dtParser.parse();
		}
		catch (BadParseException e) {
			reset(e.error_token); // point to error token

			DiagnoseParser diagnoseParser = new DiagnoseParser(this, prsTable);
			diagnoseParser.diagnose(e.error_token);
		}

		return null;
	}



	protected PackageDeclarationCS createPackageDeclarationCS(
			PathNameCS pathNameCS,
			EList contextDecls) {
		PackageDeclarationCS result = CSTFactory.eINSTANCE.createPackageDeclarationCS();
		result.setPathNameCS(pathNameCS);
		if (contextDecls != null && !contextDecls.isEmpty())
			result.getContextDecls().addAll(contextDecls);
		return result;
	}
	
	protected PropertyContextCS createPropertyContextCS(
			PathNameCS pathNameCS,
			SimpleNameCS simpleNameCS,
			TypeCS typeCS,
			InitOrDerValueCS initOrDerValueCS) {
		PropertyContextCS result = CSTFactory.eINSTANCE.createPropertyContextCS();
		result.setPathNameCS(pathNameCS);
		result.setSimpleNameCS(simpleNameCS);
		result.setTypeCS(typeCS);
		result.setInitOrDerValueCS(initOrDerValueCS);
		return result;
	}
	
	protected DerValueCS createDerValueCS(
			InitOrDerValueCS initOrDerValueCS,
			OCLExpressionCS oclExpressionCS) {
		DerValueCS result = CSTFactory.eINSTANCE.createDerValueCS();
		result.setInitOrDerValueCS(initOrDerValueCS);
		result.setExpressionCS(oclExpressionCS);
		return result;
	}

	protected InitValueCS createInitValueCS(
			InitOrDerValueCS initOrDerValueCS,
			OCLExpressionCS oclExpressionCS) {
		InitValueCS result = CSTFactory.eINSTANCE.createInitValueCS();
		result.setInitOrDerValueCS(initOrDerValueCS);
		result.setExpressionCS(oclExpressionCS);
		return result;
	}
	
	protected ClassifierContextDeclCS createClassifierContextDeclCS(
			PathNameCS pathNameCS,
			InvOrDefCS invOrDefCS) {
		ClassifierContextDeclCS result = CSTFactory.eINSTANCE.createClassifierContextDeclCS();
		result.setPathNameCS(pathNameCS);
		result.setInvOrDefCS(invOrDefCS);
		return result;
	}
	
	protected InvCS createInvCS(
			SimpleNameCS simpleNameCS,
			OCLExpressionCS oclExpressionCS) {
		InvCS result = CSTFactory.eINSTANCE.createInvCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setExpressionCS(oclExpressionCS);
		return result;
	}
	
	protected DefCS createDefCS(
			SimpleNameCS simpleNameCS,
			DefExpressionCS defExpressionCS) {
		DefCS result = CSTFactory.eINSTANCE.createDefCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setDefExpressionCS(defExpressionCS);
		return result;
	}
	
	protected DefExpressionCS createDefExpressionCS(
			VariableCS variableCS,
			OperationCS operationCS,
			OCLExpressionCS oclExpressionCS) {
		DefExpressionCS result = CSTFactory.eINSTANCE.createDefExpressionCS();
		result.setVariableCS(variableCS);
		result.setOperationCS(operationCS);
		result.setExpressionCS(oclExpressionCS);
		return result;
	}

	protected OperationContextDeclCS createOperationContextDeclCS(
			OperationCS operationCS,
			EList prePostOrBodyDecls) {
		OperationContextDeclCS result = CSTFactory.eINSTANCE.createOperationContextDeclCS();
		result.setOperationCS(operationCS);
		result.getPrePostOrBodyDecls().addAll(prePostOrBodyDecls);
		return result;
	}

	protected PrePostOrBodyDeclCS createPrePostOrBodyDeclCS(
			PrePostOrBodyEnum kind,
			SimpleNameCS simpleNameCS,
			OCLExpressionCS oclExpressionCS) {
		PrePostOrBodyDeclCS result = CSTFactory.eINSTANCE.createPrePostOrBodyDeclCS();
		result.setKind(kind);
		result.setSimpleNameCS(simpleNameCS);
		result.setExpressionCS(oclExpressionCS);
		return result;
	}

	protected OperationCS createOperationCS(
			PathNameCS pathNameCS,
			SimpleNameCS simpleNameCS,
			EList list,
			TypeCS typeCS) {
		OperationCS result = CSTFactory.eINSTANCE.createOperationCS();
		result.setPathNameCS(pathNameCS);
		result.setSimpleNameCS(simpleNameCS);
		result.getParameters().addAll(list);
		result.setTypeCS(typeCS);
		return result;
	}

	protected OperationCallExpCS createOperationCallExpCS(
			OCLExpressionCS oclExpressionCS,
			SimpleNameCS simpleNameCS,
			IsMarkedPreCS isMarkedPreCS,
			EList arguments) {
		OperationCallExpCS result = CSTFactory.eINSTANCE.createOperationCallExpCS();
		result.setSource(oclExpressionCS);
		result.setSimpleNameCS(simpleNameCS);
		result.setIsMarkedPreCS(isMarkedPreCS);
		result.getArguments().addAll(arguments);
		return result;
	}

	protected OperationCallExpCS createOperationCallExpCS(
			OCLExpressionCS oclExpressionCS,
			SimpleNameCS simpleNameCS,
			EList arguments) {
		return createOperationCallExpCS(oclExpressionCS, simpleNameCS,
				createIsMarkedPreCS(false), arguments);
	}

	protected OperationCallExpCS createOperationCallExpCS(
			SimpleNameCS simpleNameCS,
			IsMarkedPreCS isMarkedPreCS,
			EList arguments) {
		return createOperationCallExpCS(null, simpleNameCS, isMarkedPreCS, arguments);
	}

	protected OperationCallExpCS createOperationCallExpCS(
			SimpleNameCS simpleNameCS,
			IsMarkedPreCS isMarkedPreCS,
			StateExpCS stateExpCS) {
		OperationCallExpCS result = CSTFactory.eINSTANCE.createOperationCallExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setIsMarkedPreCS(isMarkedPreCS);
		result.getArguments().add(stateExpCS);
		return result;
	}
	
	private StateExpCS createStateExpCS(PathNameCS pathName) {
		StateExpCS result = CSTFactory.eINSTANCE.createStateExpCS();
		result.getSequenceOfNames().addAll(pathName.getSequenceOfNames());
		return result;
	}

	protected VariableExpCS createVariableExpCS(
			SimpleNameCS simpleNameCS,
			EList arguments,
			IsMarkedPreCS isMarkedPreCS) {
		VariableExpCS result = CSTFactory.eINSTANCE.createVariableExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.getArguments().addAll(arguments);
		result.setIsMarkedPreCS(isMarkedPreCS);
		return result;
	}

	protected SimpleNameCS createSimpleNameCS(
			SimpleTypeEnum type,
			String value) {
		SimpleNameCS result = CSTFactory.eINSTANCE.createSimpleNameCS();
		result.setType(type);
		result.setValue(value);
		return result;
	}

	protected PrimitiveTypeCS createPrimitiveTypeCS(
			SimpleTypeEnum type,
			String value) {
		PrimitiveTypeCS result = CSTFactory.eINSTANCE.createPrimitiveTypeCS();
		result.setType(type);
		result.setValue(value);
		return result;
	}

	private PathNameCS createPathNameCS(String pathName) {
		PathNameCS result = CSTFactory.eINSTANCE.createPathNameCS();
		result.getSequenceOfNames().add(pathName);
		return result;
	}

	private PathNameCS createPathNameCS() {
		return CSTFactory.eINSTANCE.createPathNameCS();
	}

	protected EnumLiteralExpCS createEnumLiteralExpCS(
			PathNameCS pathNameCS,
			SimpleNameCS simpleNameCS) {
		EnumLiteralExpCS result = CSTFactory.eINSTANCE.createEnumLiteralExpCS();
		result.setPathNameCS(pathNameCS);
		result.setSimpleNameCS(simpleNameCS);
		return result;
	}

	protected CollectionLiteralExpCS createCollectionLiteralExpCS(
			CollectionTypeIdentifierEnum type,
			EList collectionLiteralParts) {
		CollectionLiteralExpCS result = CSTFactory.eINSTANCE.createCollectionLiteralExpCS();
		result.setCollectionType(type);
		result.getCollectionLiteralParts().addAll(collectionLiteralParts);
		return result;
	}

	protected CollectionLiteralPartCS createCollectionLiteralPartCS(OCLExpressionCS oclExpressionCS) {
		CollectionLiteralPartCS result = CSTFactory.eINSTANCE.createCollectionLiteralPartCS();
		result.setExpressionCS(oclExpressionCS);
		return result;
	}

	protected CollectionRangeCS createCollectionRangeCS(
			OCLExpressionCS oclExpressionCS,
			OCLExpressionCS lastOCLExpressionCS) {
		CollectionRangeCS result = CSTFactory.eINSTANCE.createCollectionRangeCS();
		result.setExpressionCS(oclExpressionCS);
		result.setLastExpressionCS(lastOCLExpressionCS);
		return result;
	}

	protected TupleLiteralExpCS createTupleLiteralExpCS(EList variables) {
		TupleLiteralExpCS result = CSTFactory.eINSTANCE.createTupleLiteralExpCS();
		result.getVariables().addAll(variables);
		return result;
	}

	protected IntegerLiteralExpCS createIntegerLiteralExpCS(String string) {
		IntegerLiteralExpCS result = CSTFactory.eINSTANCE.createIntegerLiteralExpCS();
		result.setSymbol(string);
		result.setIntegerSymbol(Integer.valueOf(string));
		return result;
	}

	protected RealLiteralExpCS createRealLiteralExpCS(String string) {
		RealLiteralExpCS result = CSTFactory.eINSTANCE.createRealLiteralExpCS();
		result.setSymbol(string);
		result.setRealSymbol(Double.valueOf(string));
		return result;
	}

	protected StringLiteralExpCS createStringLiteralExpCS(String string) {
		StringLiteralExpCS result = CSTFactory.eINSTANCE.createStringLiteralExpCS();
		result.setSymbol(string);
		result.setStringSymbol(string);
		return result;
	}

	protected BooleanLiteralExpCS createBooleanLiteralExpCS(String string) {
		BooleanLiteralExpCS result = CSTFactory.eINSTANCE.createBooleanLiteralExpCS();
		result.setSymbol(string);
		result.setBooleanSymbol(Boolean.valueOf(string));
		return result;
	}

	protected NullLiteralExpCS createNullLiteralExpCS(String string) {
		NullLiteralExpCS result = CSTFactory.eINSTANCE.createNullLiteralExpCS();
		result.setSymbol(string);
		return result;
	}

	protected InvalidLiteralExpCS createInvalidLiteralExpCS(String string) {
		InvalidLiteralExpCS result = CSTFactory.eINSTANCE.createInvalidLiteralExpCS();
		result.setSymbol(string);
		return result;
	}

	protected IteratorExpCS createIteratorExpCS(
			SimpleNameCS simpleNameCS,
			VariableCS variable1,
			VariableCS variable2,
			OCLExpressionCS oclExpressionCS) {
		IteratorExpCS result = CSTFactory.eINSTANCE.createIteratorExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setVariable1(variable1);
		result.setVariable2(variable2);
		result.setBody(oclExpressionCS);
		return result;
	}

	protected IterateExpCS createIterateExpCS(
			SimpleNameCS simpleNameCS,
			VariableCS variable1,
			VariableCS variable2,
			OCLExpressionCS oclExpressionCS) {
		IterateExpCS result = CSTFactory.eINSTANCE.createIterateExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setVariable1(variable1);
		result.setVariable2(variable2);
		result.setBody(oclExpressionCS);
		return result;
	}

	protected VariableCS createVariableCS(
			String varName,
			TypeCS typeCS,
			OCLExpressionCS oclExpressionCS) {
		VariableCS result = CSTFactory.eINSTANCE.createVariableCS();
		result.setName(varName);
		result.setTypeCS(typeCS);
		result.setInitExpression(oclExpressionCS);
		return result;
	}

	protected CollectionTypeCS createCollectionTypeCS(
			CollectionTypeIdentifierEnum collectionType,
			TypeCS typeCS) {
		CollectionTypeCS result = CSTFactory.eINSTANCE.createCollectionTypeCS();
		result.setCollectionTypeIdentifier(collectionType);
		result.setTypeCS(typeCS);
		return result;
	}

	protected TupleTypeCS createTupleTypeCS(EList variables) {
		TupleTypeCS result = CSTFactory.eINSTANCE.createTupleTypeCS();
		result.getVariables().addAll(variables);
		return result;
	}

	protected FeatureCallExpCS createFeatureCallExpCS(
			SimpleNameCS simpleNameCS,
			EList arguments,
			IsMarkedPreCS isMarkedPreCS) {
		FeatureCallExpCS result = CSTFactory.eINSTANCE.createFeatureCallExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.getArguments().addAll(arguments);
		result.setIsMarkedPreCS(isMarkedPreCS);
		return result;
	}

	protected IsMarkedPreCS createIsMarkedPreCS(boolean isMarkedPre) {
		IsMarkedPreCS result = CSTFactory.eINSTANCE.createIsMarkedPreCS();
		result.setPre(isMarkedPre);
		return result;
	}

	protected LetExpCS createLetExpCS(
			EList variables,
			OCLExpressionCS oclExpressionCS) {
		LetExpCS result = CSTFactory.eINSTANCE.createLetExpCS();
		result.getVariables().addAll(variables);
		result.setInExpression(oclExpressionCS);
		return result;
	}

	protected IfExpCS createIfExpCS(
			OCLExpressionCS condition,
			OCLExpressionCS thenExpression,
			OCLExpressionCS elseExpression) {
		IfExpCS result = CSTFactory.eINSTANCE.createIfExpCS();
		result.setCondition(condition);
		result.setThenExpression(thenExpression);
		result.setElseExpression(elseExpression);
		return result;
	}

	protected MessageExpCS createMessageExpCS(
			int kind,
			SimpleNameCS simpleNameCS,
			EList oclMessageArgs) {
		MessageExpCS result = CSTFactory.eINSTANCE.createMessageExpCS();
		result.setKind((kind == OCLLPGParsersym.TK_CARET)?
				MessageExpKind.HAS_SENT_LITERAL : MessageExpKind.SENT_LITERAL);
		result.setSimpleNameCS(simpleNameCS);
		result.getArguments().addAll(oclMessageArgs);
		return result;
	}

	protected OCLMessageArgCS createOCLMessageArgCS(
			TypeCS typeCS,
			OCLExpressionCS oclExpressionCS) {
		OCLMessageArgCS result = CSTFactory.eINSTANCE.createOCLMessageArgCS();
		result.setTypeCS(typeCS);
		result.setExpression(oclExpressionCS);
		return result;
	}
	
	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start and end offsets of the given <code>IToken</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param startEnd <code>IToken</code> to retrieve offsets from
	 */
	protected void setOffsets(CSTNode cstNode, IToken startEnd) {
		cstNode.setStartOffset(startEnd.getStartOffset());
		cstNode.setEndOffset(startEnd.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start and end offsets of the 2nd given <code>CSTNode</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param startEnd <code>CSTNode</code> to retrieve offsets from
	 */
	protected void setOffsets(CSTNode cstNode, CSTNode startEnd) {
		cstNode.setStartOffset(startEnd.getStartOffset());
		cstNode.setEndOffset(startEnd.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start offset of the 2nd given <code>CSTNode</code> and the
	 * end offset of the 3rd given <code>CSTNode</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param start <code>CSTNode</code> to retrieve start offset from
	 * @param end <code>CSTNode</code> to retrieve end offset from
	 */
	protected void setOffsets(CSTNode cstNode, CSTNode start, CSTNode end) {
		cstNode.setStartOffset(start.getStartOffset());
		cstNode.setEndOffset(end.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start offset of the 2nd given <code>CSTNode</code> and the
	 * end offset of the given <code>IToken</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param start <code>CSTNode</code> to retrieve start offset from
	 * @param end <code>IToken</code> to retrieve end offset from
	 */
	protected void setOffsets(CSTNode cstNode, CSTNode start, IToken end) {
		cstNode.setStartOffset(start.getStartOffset());
		cstNode.setEndOffset(end.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start offset of the given <code>IToken</code> and the
	 * end offset of the 2nd given <code>CSTNode</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param start <code>IToken</code> to retrieve start offset from
	 * @param end <code>CSTNode</code> to retrieve end offset from
	 */
	protected void setOffsets(CSTNode cstNode, IToken start, CSTNode end) {
		cstNode.setStartOffset(start.getStartOffset());
		cstNode.setEndOffset(end.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code>
	 * to the start offset of the 1std given <code>IToken</code> and the
	 * end offset of the 2nd given <code>IToken</code>
	 *
	 * @param cstNode <code>CSTNode</code> to set offsets
	 * @param start <code>IToken</code> to retrieve start offset from
	 * @param end <code>IToken</code> to retrieve end offset from
	 */
	protected void setOffsets(CSTNode cstNode, IToken start, IToken end) {
		cstNode.setStartOffset(start.getStartOffset());
		cstNode.setEndOffset(end.getEndOffset());
	}

	public void ruleAction(int ruleNumber)
	{
		switch (ruleNumber) {
		
 
			//
			// Rule 7:  packageDeclarationCS ::= contextDeclCSm
			//
			case 7: {
				
				EList contextDecls = (EList)dtParser.getSym(1);
				CSTNode result = createPackageDeclarationCS(null, contextDecls);
				if (!contextDecls.isEmpty()) {
					setOffsets(result, (CSTNode)contextDecls.get(0), (CSTNode)contextDecls.get(contextDecls.size()-1));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 8:  packageDeclarationCS ::= package pathNameCS contextDeclCSmopt endpackage
			//
			case 8: {
				
				CSTNode result = createPackageDeclarationCS(
						(PathNameCS)dtParser.getSym(2),
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 9:  contextDeclCSmopt ::= $Empty
			//
			case 9:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 11:  contextDeclCSm ::= contextDeclCS
			//
			case 11: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 12:  contextDeclCSm ::= contextDeclCSm contextDeclCS
			//
			case 12: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 16:  propertyContextCS ::= context pathNameCS :: simpleNameCS : typeCS initOrDerValueCS
			//
			case 16: {
				
				CSTNode result = createPropertyContextCS(
						(PathNameCS)dtParser.getSym(2),
						(SimpleNameCS)dtParser.getSym(4),
						(TypeCS)dtParser.getSym(6),
						(InitOrDerValueCS)dtParser.getSym(7)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(7));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 17:  initOrDerValueCS ::= initOrDerValueCSopt init : oclExpressionCS
			//
			case 17: {
				
				CSTNode result = createInitValueCS(
						(InitOrDerValueCS)dtParser.getSym(1),
						(OCLExpressionCS)dtParser.getSym(4)
					);
				if (dtParser.getSym(1) != null) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(4));
				} else {
					setOffsets(result, getIToken(dtParser.getToken(2)), (CSTNode)dtParser.getSym(4));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 18:  initOrDerValueCS ::= initOrDerValueCSopt derive : oclExpressionCS
			//
			case 18: {
				
				CSTNode result = createDerValueCS(
						(InitOrDerValueCS)dtParser.getSym(1),
						(OCLExpressionCS)dtParser.getSym(4)
					);
				if (dtParser.getSym(1) != null) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(4));
				} else {
					setOffsets(result, getIToken(dtParser.getToken(2)), (CSTNode)dtParser.getSym(4));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 19:  initOrDerValueCSopt ::= $Empty
			//
			case 19:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 21:  classifierContextDeclCS ::= context pathNameCS invOrDefCS
			//
			case 21: {
				
				CSTNode result = createClassifierContextDeclCS(
						(PathNameCS)dtParser.getSym(2),
						(InvOrDefCS)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 22:  invOrDefCS ::= inv simpleNameCSopt : oclExpressionCS
			//
			case 22: {
				
				CSTNode result = createInvCS(
						(SimpleNameCS)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 23:  invOrDefCS ::= def simpleNameCSopt : defExpressionCS
			//
			case 23: {
				
				CSTNode result = createDefCS(
						(SimpleNameCS)dtParser.getSym(2),
						(DefExpressionCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 24:  defExpressionCS ::= IDENTIFIER : typeCS = oclExpressionCS
			//
			case 24: {
				
				VariableCS variableCS = createVariableCS(
							getTokenText(dtParser.getToken(1)),
							(TypeCS)dtParser.getSym(3),
							null
						);
				setOffsets(variableCS, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				CSTNode result = createDefExpressionCS(
						variableCS,
						null,
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, variableCS, (CSTNode)dtParser.getSym(5));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 25:  defExpressionCS ::= operationCS = oclExpressionCS
			//
			case 25: {
				
				CSTNode result = createDefExpressionCS(
						null,
						(OperationCS)dtParser.getSym(1),
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 26:  operationContextDeclCS ::= context operationCS prePostOrBodyDeclCSm
			//
			case 26: {
				
				EList prePostOrBodyDecls = (EList)dtParser.getSym(3);
				CSTNode result = createOperationContextDeclCS(
						(OperationCS)dtParser.getSym(2),
						prePostOrBodyDecls
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)prePostOrBodyDecls.get(prePostOrBodyDecls.size()-1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 27:  prePostOrBodyDeclCSm ::= prePostOrBodyDeclCS
			//
			case 27: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 28:  prePostOrBodyDeclCSm ::= prePostOrBodyDeclCSm prePostOrBodyDeclCS
			//
			case 28: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 29:  prePostOrBodyDeclCS ::= pre simpleNameCSopt : oclExpressionCS
			//
			case 29: {
				
				CSTNode result = createPrePostOrBodyDeclCS(
						PrePostOrBodyEnum.PRE_LITERAL,
						(SimpleNameCS)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 30:  prePostOrBodyDeclCS ::= post simpleNameCSopt : oclExpressionCS
			//
			case 30: {
				
				CSTNode result = createPrePostOrBodyDeclCS(
						PrePostOrBodyEnum.POST_LITERAL,
						(SimpleNameCS)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 31:  prePostOrBodyDeclCS ::= body simpleNameCSopt : oclExpressionCS
			//
			case 31: {
				
				CSTNode result = createPrePostOrBodyDeclCS(
						PrePostOrBodyEnum.BODY_LITERAL,
						(SimpleNameCS)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 32:  operationCS ::= simpleNameCS ( parametersCSopt ) : typeCSopt
			//
			case 32: {
				
				CSTNode result = createOperationCS(
						null,
						(SimpleNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3),
						(TypeCS)dtParser.getSym(6)
					);
				if (dtParser.getSym(6) != null) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(6));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(5)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 33:  operationCS ::= pathNameCS :: simpleNameCS ( parametersCSopt ) : typeCSopt
			//
			case 33: {
				
				CSTNode result = createOperationCS(
						(PathNameCS)dtParser.getSym(1),
						(SimpleNameCS)dtParser.getSym(3),
						(EList)dtParser.getSym(5),
						(TypeCS)dtParser.getSym(8)
					);
				if (dtParser.getSym(8) != null) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(8));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(7)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 34:  parametersCSopt ::= $Empty
			//
			case 34:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 36:  parametersCS ::= variableCS
			//
			case 36: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 37:  parametersCS ::= parametersCS , variableCS
			//
			case 37: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 38:  simpleNameCSopt ::= $Empty
			//
			case 38:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 43:  oclExp0CS ::= oclExp0CS implies oclExp1CS
			//
			case 43:
 
			//
			// Rule 45:  oclExp1CS ::= oclExp1CS and oclExp2CS
			//
			case 45:
 
			//
			// Rule 46:  oclExp1CS ::= oclExp1CS or oclExp2CS
			//
			case 46:
 
			//
			// Rule 47:  oclExp1CS ::= oclExp1CS xor oclExp2CS
			//
			case 47: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							getTokenText(dtParser.getToken(2))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 49:  oclExp2CS ::= oclExp2CS = oclExp3CS
			//
			case 49: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							AnyTypeImpl.getOperationName(PredefinedType.EQUAL)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 50:  oclExp2CS ::= oclExp2CS <> oclExp3CS
			//
			case 50: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							AnyTypeImpl.getOperationName(PredefinedType.NOT_EQUAL)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 51:  oclExp2CS ::= oclExp2CS > oclExp3CS
			//
			case 51: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							AnyTypeImpl.getOperationName(PredefinedType.GREATER_THAN)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 52:  oclExp2CS ::= oclExp2CS < oclExp3CS
			//
			case 52: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							AnyTypeImpl.getOperationName(PredefinedType.LESS_THAN)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 53:  oclExp2CS ::= oclExp2CS >= oclExp3CS
			//
			case 53: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							AnyTypeImpl.getOperationName(PredefinedType.GREATER_THAN_EQUAL)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 54:  oclExp2CS ::= oclExp2CS <= oclExp3CS
			//
			case 54: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							AnyTypeImpl.getOperationName(PredefinedType.LESS_THAN_EQUAL)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 58:  oclExp4CS ::= oclExp4CS + oclExp5CS
			//
			case 58: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							PrimitiveTypeImpl.getOperationName(PredefinedType.PLUS)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 59:  oclExp4CS ::= oclExp4CS - oclExp5CS
			//
			case 59: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							PrimitiveTypeImpl.getOperationName(PredefinedType.MINUS)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 61:  oclExp5CS ::= oclExp5CS * oclExp6CS
			//
			case 61: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							PrimitiveTypeImpl.getOperationName(PredefinedType.TIMES)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 62:  oclExp5CS ::= oclExp5CS / oclExp6CS
			//
			case 62: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							PrimitiveTypeImpl.getOperationName(PredefinedType.DIVIDE)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 64:  oclExp6CS ::= - oclExp7CS
			//
			case 64: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							PrimitiveTypeImpl.getOperationName(PredefinedType.MINUS)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						simpleNameCS,
						new BasicEList()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 65:  oclExp6CS ::= not oclExp7CS
			//
			case 65: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						simpleNameCS,
						new BasicEList()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 67:  oclExp7CS ::= oclExp7CS callExpCS
			//
			case 67: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setSource((OCLExpressionCS)dtParser.getSym(1));
				setOffsets(result, (CSTNode)dtParser.getSym(1), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 68:  oclExp7CS ::= oclExp7CS messageExpCS
			//
			case 68: {
				
				MessageExpCS result = (MessageExpCS)dtParser.getSym(2);
				result.setTarget((OCLExpressionCS)dtParser.getSym(1));
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 69:  oclExp7CS ::= NUMERIC_OPERATION ( argumentsCSopt )
			//
			case 69: {
				
				// NUMERIC_OPERATION -> Integer '.' Identifier
				String text = getTokenText(dtParser.getToken(1));
				int index = text.indexOf('.');
				String integer = text.substring(0, index);
				String simpleName = text.substring(index + 1);

				// create the IntegerLiteralExpCS
				int startOffset = getIToken(dtParser.getToken(1)).getStartOffset();
				int endOffset = startOffset + integer.length() - 1; // inclusive

				IntegerLiteralExpCS integerLiteralExpCS = createIntegerLiteralExpCS(integer);
				integerLiteralExpCS.setStartOffset(startOffset);
				integerLiteralExpCS.setEndOffset(endOffset);

				startOffset = endOffset + 2; // end of integerLiteral + 1('.') + 1(start of simpleName)
				endOffset = getIToken(dtParser.getToken(1)).getEndOffset();

				// create the SimpleNameCS
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							simpleName
						);
				simpleNameCS.setStartOffset(startOffset);
				simpleNameCS.setEndOffset(endOffset);

				// create the OperationCallExpCS
				CSTNode result = createOperationCallExpCS(
						integerLiteralExpCS,
						simpleNameCS,
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 73:  oclExpCS ::= ( oclExpressionCS )
			//
			case 73: {
				
				CSTNode result = (CSTNode)dtParser.getSym(2);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 74:  variableExpCS ::= simpleNameCS isMarkedPreCS
			//
			case 74: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(2);
				CSTNode result = createVariableExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(2));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 75:  variableExpCS ::= simpleNameCS [ argumentsCS ] isMarkedPreCS
			//
			case 75: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(5);
				CSTNode result = createVariableExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(5));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 77:  simpleNameCS ::= self
			//
			case 77: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.SELF_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 78:  simpleNameCS ::= IDENTIFIER
			//
			case 78: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 79:  primitiveTypeCS ::= Integer
			//
			case 79: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INTEGER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 80:  primitiveTypeCS ::= String
			//
			case 80: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.STRING_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 81:  primitiveTypeCS ::= Real
			//
			case 81: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.REAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 82:  primitiveTypeCS ::= Boolean
			//
			case 82: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.BOOLEAN_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 83:  primitiveTypeCS ::= OclAny
			//
			case 83: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_ANY_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 84:  primitiveTypeCS ::= OclVoid
			//
			case 84: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_VOID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 85:  primitiveTypeCS ::= Invalid
			//
			case 85: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INVALID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 86:  primitiveTypeCS ::= OclMessage
			//
			case 86: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_MESSAGE_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 87:  pathNameCS ::= IDENTIFIER
			//
			case 87: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 88:  pathNameCS ::= pathNameCS :: simpleNameCS
			//
			case 88: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result.getSequenceOfNames().add(getTokenText(dtParser.getToken(3)));
				setOffsets(result, result, (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 89:  pathNameCSOpt ::= $Empty
			//
			case 89: {
				
				CSTNode result = createPathNameCS();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 97:  enumLiteralExpCS ::= pathNameCS :: simpleNameCS
			//
			case 97: {
				
				CSTNode result = createEnumLiteralExpCS(
						(PathNameCS)dtParser.getSym(1),
						(SimpleNameCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 98:  collectionLiteralExpCS ::= collectionTypeIdentifierCS { collectionLiteralPartsCSopt }
			//
			case 98: {
				
				Object[] objs = (Object[])dtParser.getSym(1);
				CSTNode result = createCollectionLiteralExpCS(
						(CollectionTypeIdentifierEnum)objs[1],
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, (IToken)objs[0], getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 99:  collectionTypeIdentifierCS ::= Set
			//
			case 99: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.SET_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 100:  collectionTypeIdentifierCS ::= Bag
			//
			case 100: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.BAG_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 101:  collectionTypeIdentifierCS ::= Sequence
			//
			case 101: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.SEQUENCE_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 102:  collectionTypeIdentifierCS ::= Collection
			//
			case 102: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.COLLECTION_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 103:  collectionTypeIdentifierCS ::= OrderedSet
			//
			case 103: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 104:  collectionLiteralPartsCSopt ::= $Empty
			//
			case 104:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 106:  collectionLiteralPartsCS ::= collectionLiteralPartCS
			//
			case 106: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 107:  collectionLiteralPartsCS ::= collectionLiteralPartsCS , collectionLiteralPartCS
			//
			case 107: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 109:  collectionLiteralPartCS ::= oclExpressionCS
			//
			case 109: {
				
				CSTNode result = createCollectionLiteralPartCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 110:  collectionRangeCS ::= oclExpressionCS .. oclExpressionCS
			//
			case 110: {
				
				CSTNode result = createCollectionRangeCS(
						(OCLExpressionCS)dtParser.getSym(1),
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 115:  tupleLiteralExpCS ::= Tuple { variableListCS2 }
			//
			case 115: {
				
				CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 116:  integerLiteralExpCS ::= INTEGER_LITERAL
			//
			case 116: {
				
				CSTNode result = createIntegerLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 117:  realLiteralExpCS ::= REAL_LITERAL
			//
			case 117: {
				
				CSTNode result = createRealLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 118:  stringLiteralExpCS ::= STRING_LITERAL
			//
			case 118: {
				
				CSTNode result = createStringLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 119:  booleanLiteralExpCS ::= true
			//
			case 119: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 120:  booleanLiteralExpCS ::= false
			//
			case 120: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 121:  nullLiteralExpCS ::= null
			//
			case 121: {
				
				CSTNode result = createNullLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 122:  invalidLiteralExpCS ::= OclInvalid
			//
			case 122: {
				
				CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 123:  callExpCS ::= -> featureCallExpCS
			//
			case 123:
 
			//
			// Rule 124:  callExpCS ::= -> loopExpCS
			//
			case 124: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 125:  callExpCS ::= . featureCallExpCS
			//
			case 125: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 128:  iteratorExpCS ::= forAll ( iterContents )
			//
			case 128:
 
			//
			// Rule 129:  iteratorExpCS ::= exists ( iterContents )
			//
			case 129:
 
			//
			// Rule 130:  iteratorExpCS ::= isUnique ( iterContents )
			//
			case 130:
 
			//
			// Rule 131:  iteratorExpCS ::= one ( iterContents )
			//
			case 131:
 
			//
			// Rule 132:  iteratorExpCS ::= any ( iterContents )
			//
			case 132:
 
			//
			// Rule 133:  iteratorExpCS ::= collect ( iterContents )
			//
			case 133:
 
			//
			// Rule 134:  iteratorExpCS ::= select ( iterContents )
			//
			case 134:
 
			//
			// Rule 135:  iteratorExpCS ::= reject ( iterContents )
			//
			case 135:
 
			//
			// Rule 136:  iteratorExpCS ::= collectNested ( iterContents )
			//
			case 136:
 
			//
			// Rule 137:  iteratorExpCS ::= sortedBy ( iterContents )
			//
			case 137:
 
			//
			// Rule 138:  iteratorExpCS ::= closure ( iterContents )
			//
			case 138: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				Object[] iterContents = (Object[])dtParser.getSym(3);
				CSTNode result = createIteratorExpCS(
						simpleNameCS,
						(VariableCS)iterContents[0],
						(VariableCS)iterContents[1],
						(OCLExpressionCS)iterContents[2]
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 139:  iterContents ::= oclExpressionCS
			//
			case 139: {
				
				dtParser.setSym1(new Object[] {
						null,
						null,
						dtParser.getSym(1)
					});
	  		  break;
			}
	 
			//
			// Rule 140:  iterContents ::= variableCS | oclExpressionCS
			//
			case 140: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						null,
						dtParser.getSym(3)
					});
	  		  break;
			}
	 
			//
			// Rule 141:  iterContents ::= variableCS , variableCS | oclExpressionCS
			//
			case 141: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						dtParser.getSym(3),
						dtParser.getSym(5)
					});
	  		  break;
			}
	 
			//
			// Rule 142:  iterateExpCS ::= iterate ( variableCS | oclExpressionCS )
			//
			case 142: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createIterateExpCS(
						simpleNameCS,
						(VariableCS)dtParser.getSym(3),
						null,
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 143:  iterateExpCS ::= iterate ( variableCS ; variableCS | oclExpressionCS )
			//
			case 143: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createIterateExpCS(
						simpleNameCS,
						(VariableCS)dtParser.getSym(3),
						(VariableCS)dtParser.getSym(5),
						(OCLExpressionCS)dtParser.getSym(7)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(8)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 144:  variableCS ::= IDENTIFIER
			//
			case 144: {
				
				CSTNode result = createVariableCS(
						getTokenText(dtParser.getToken(1)),
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 145:  variableCS ::= IDENTIFIER : typeCS
			//
			case 145: {
				
				CSTNode result = createVariableCS(
						getTokenText(dtParser.getToken(1)),
						(TypeCS)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 146:  variableCS ::= IDENTIFIER : typeCS = oclExpressionCS
			//
			case 146: {
				
				CSTNode result = createVariableCS(
						getTokenText(dtParser.getToken(1)),
						(TypeCS)dtParser.getSym(3),
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(5));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 147:  variableCS2 ::= IDENTIFIER = oclExpressionCS
			//
			case 147: {
				
				CSTNode result = createVariableCS(
						getTokenText(dtParser.getToken(1)),
						null,
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 148:  typeCSopt ::= $Empty
			//
			case 148:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 154:  collectionTypeCS ::= collectionTypeIdentifierCS ( typeCS )
			//
			case 154: {
				
				Object[] objs = (Object[])dtParser.getSym(1);
				CSTNode result = createCollectionTypeCS(
						(CollectionTypeIdentifierEnum)objs[1],
						(TypeCS)dtParser.getSym(3)
					);
				setOffsets(result, (IToken)objs[0], getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 155:  tupleTypeCS ::= Tuple ( variableListCSopt )
			//
			case 155: {
				
				CSTNode result = createTupleTypeCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 156:  variableListCSopt ::= $Empty
			//
			case 156:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 158:  variableListCS ::= variableCS
			//
			case 158: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 159:  variableListCS ::= variableListCS , variableCS
			//
			case 159: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 160:  variableListCS2 ::= variableCS2
			//
			case 160:
 
			//
			// Rule 161:  variableListCS2 ::= variableCS
			//
			case 161: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 162:  variableListCS2 ::= variableListCS2 , variableCS2
			//
			case 162:
 
			//
			// Rule 163:  variableListCS2 ::= variableListCS2 , variableCS
			//
			case 163: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 166:  operationCallExpCS ::= simpleNameCS isMarkedPreCS ( argumentsCSopt )
			//
			case 166: {
				
				CSTNode result = createOperationCallExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(IsMarkedPreCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 167:  operationCallExpCS ::= oclIsUndefined isMarkedPreCS ( argumentsCSopt )
			//
			case 167:
 
			//
			// Rule 168:  operationCallExpCS ::= oclIsInvalid isMarkedPreCS ( argumentsCSopt )
			//
			case 168:
 
			//
			// Rule 169:  operationCallExpCS ::= oclIsNew isMarkedPreCS ( argumentsCSopt )
			//
			case 169:
 
			//
			// Rule 170:  operationCallExpCS ::= allInstances isMarkedPreCS ( argumentsCSopt )
			//
			case 170:
 
			//
			// Rule 171:  operationCallExpCS ::= oclAsType isMarkedPreCS ( argumentsCSopt )
			//
			case 171:
 
			//
			// Rule 172:  operationCallExpCS ::= oclIsKindOf isMarkedPreCS ( argumentsCSopt )
			//
			case 172:
 
			//
			// Rule 173:  operationCallExpCS ::= oclIsTypeOf isMarkedPreCS ( argumentsCSopt )
			//
			case 173: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createOperationCallExpCS(
						simpleNameCS,
						(IsMarkedPreCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 174:  operationCallExpCS ::= oclIsInState isMarkedPreCS ( pathNameCSOpt )
			//
			case 174: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));

				PathNameCS pathNameCS = (PathNameCS) dtParser.getSym(4);
				StateExpCS stateExpCS = createStateExpCS(pathNameCS);
				setOffsets(stateExpCS, pathNameCS);
				
				CSTNode result = createOperationCallExpCS(
						simpleNameCS,
						(IsMarkedPreCS)dtParser.getSym(2),
						stateExpCS
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 175:  attrOrNavCallExpCS ::= simpleNameCS isMarkedPreCS
			//
			case 175: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(2);
				CSTNode result = createFeatureCallExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(2));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 176:  attrOrNavCallExpCS ::= simpleNameCS [ argumentsCS ] isMarkedPreCS
			//
			case 176: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(5);
				CSTNode result = createFeatureCallExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(5));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 177:  isMarkedPreCS ::= $Empty
			//
			case 177: {
				
				CSTNode result = createIsMarkedPreCS(false);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 178:  isMarkedPreCS ::= @pre
			//
			case 178: {
				
				CSTNode result = createIsMarkedPreCS(true);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 179:  argumentsCSopt ::= $Empty
			//
			case 179:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 181:  argumentsCS ::= oclExpressionCS
			//
			case 181: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 182:  argumentsCS ::= argumentsCS , oclExpressionCS
			//
			case 182: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 183:  letExpCS ::= let variableCS letExpSubCSopt in oclExpressionCS
			//
			case 183: {
				
				EList variables = (EList)dtParser.getSym(3);
				variables.add(dtParser.getSym(2));
				CSTNode result = createLetExpCS(
						variables,
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(5));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 184:  letExpSubCSopt ::= $Empty
			//
			case 184:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 186:  letExpSubCS ::= , variableCS
			//
			case 186: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 187:  letExpSubCS ::= letExpSubCS , variableCS
			//
			case 187: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 188:  ifExpCS ::= if oclExpressionCS then oclExpressionCS else oclExpressionCS endif
			//
			case 188: {
				
				CSTNode result = createIfExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4),
						(OCLExpressionCS)dtParser.getSym(6)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 189:  messageExpCS ::= ^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 189:
 
			//
			// Rule 190:  messageExpCS ::= ^^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 190: {
				
				CSTNode result = createMessageExpCS(
						getIToken(dtParser.getToken(1)).getKind(),
						(SimpleNameCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 191:  oclMessageArgumentsCSopt ::= $Empty
			//
			case 191:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 193:  oclMessageArgumentsCS ::= oclMessageArgCS
			//
			case 193: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 194:  oclMessageArgumentsCS ::= oclMessageArgumentsCS , oclMessageArgCS
			//
			case 194: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 195:  oclMessageArgCS ::= oclExpressionCS
			//
			case 195: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 196:  oclMessageArgCS ::= ?
			//
			case 196: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 197:  oclMessageArgCS ::= ? : typeCS
			//
			case 197: {
				
				CSTNode result = createOCLMessageArgCS(
						(TypeCS)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	
	
			default:
				break;
		}
		return;
	}
}

