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
*
* </copyright>
*
* $Id: OCLParser.java,v 1.18 2009/10/23 21:26:55 ewillink Exp $
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
*   E.D.Willink - Bug 259818, 285633, 292112, 292594
* </copyright>
*/

package org.eclipse.ocl.parser;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.VariableCS;

import lpg.lpgjavaruntime.BadParseException;
import lpg.lpgjavaruntime.BadParseSymFileException;
import lpg.lpgjavaruntime.DeterministicParser;
import lpg.lpgjavaruntime.DiagnoseParser;
import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.Monitor;
import lpg.lpgjavaruntime.NotDeterministicParseTableException;
import lpg.lpgjavaruntime.ParseTable;
import lpg.lpgjavaruntime.RuleAction;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.cst.DefCS;
import org.eclipse.ocl.cst.DefExpressionCS;
import org.eclipse.ocl.cst.InitOrDerValueCS;
import org.eclipse.ocl.cst.InvOrDefCS;
import org.eclipse.ocl.cst.MessageExpCS;
import org.eclipse.ocl.cst.OCLMessageArgCS;
import org.eclipse.ocl.cst.OperationCS;
import org.eclipse.ocl.cst.PackageDeclarationCS;
import org.eclipse.ocl.cst.PrePostOrBodyEnum;

public class OCLParser extends AbstractOCLParser implements RuleAction
{
	protected static ParseTable prs = new OCLParserprs();
	private DeterministicParser dtParser;

	public OCLParser(OCLLexer lexer) {
		super(lexer);
	}

	public int getEOFTokenKind() { return OCLParserprs.EOFT_SYMBOL; }

	public Environment<?,?,?,?,?,?,?,?,?,?,?,?> getOCLEnvironment() {
		return getLexer().getOCLEnvironment();
	}
	
	@Override 
	public OCLLexer getLexer() {
		return (OCLLexer)super.getLexer();
	}

	public String getTokenKindName(int kind) { return OCLParsersym.orderedTerminalSymbols[kind]; }			

	@Override
	public String[] orderedTerminalSymbols() { return OCLParsersym.orderedTerminalSymbols; }
		
	@SuppressWarnings("nls")
	@Override
	public CSTNode parseTokensToCST(Monitor monitor, int error_repair_count) {
		ParseTable prsTable = new OCLParserprs();

		try {
			dtParser = new DeterministicParser(monitor, this, prsTable, this);
		}
		catch (NotDeterministicParseTableException e) {
            throw new RuntimeException("****Error: Regenerate OCLParserprs.java with -NOBACKTRACK option");
		}
		catch (BadParseSymFileException e) {
			throw new RuntimeException("****Error: Bad Parser Symbol File -- OCLParsersym.java. Regenerate OCLParserprs.java");
		}

		try {
			return (CSTNode) dtParser.parse();
		}
		catch (BadParseException e) {
			reset(e.error_token); // point to error token

			DiagnoseParser diagnoseParser = new DiagnoseParser(this, prsTable);
			diagnoseParser.diagnose(e.error_token);
		}

		return null;
	}

    /**
     * Initializes a concrete-syntax node's start and end offsets from the
     * current token in the parser stream.
     * 
     * @param cstNode a concrete-syntax node
     * 
     * @since 1.2
     */
	protected void setOffsets(CSTNode cstNode) {
		IToken firstToken = getIToken(dtParser.getToken(1));
		cstNode.setStartToken(firstToken);
		cstNode.setEndToken(firstToken);
		cstNode.setStartOffset(firstToken.getStartOffset());
		cstNode.setEndOffset(firstToken.getEndOffset()-1);
	}



	@SuppressWarnings("unchecked")
	public void ruleAction(int ruleNumber)
	{
		switch (ruleNumber) {
		
 
			//
			// Rule 37:  binaryKeywordCS ::= binaryKeyword
			//
			case 37:
 
			//
			// Rule 38:  otherKeywordCS ::= otherKeyword
			//
			case 38:
 
			//
			// Rule 39:  unaryKeywordCS ::= unaryKeyword
			//
			case 39:
 
			//
			// Rule 40:  reservedPunctuationCS ::= reservedPunctuation
			//
			case 40: {
				
				SimpleNameCS result = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 44:  iterateNameCS ::= iterateIdentifier
			//
			case 44:
 
			//
			// Rule 45:  iteratorNameCS ::= iteratorIdentifier
			//
			case 45:
 
			//
			// Rule 46:  simpleIdentifierCS ::= otherIdentifier
			//
			case 46: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 48:  simpleIdentifierCS ::= self
			//
			case 48: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.SELF_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 61:  pathNameCS ::= notReservedSimpleNameCS
			//
			case 61: {
				
				SimpleNameCS simpleName = (SimpleNameCS)dtParser.getSym(1);
				PathNameCS result = createPathNameCS(simpleName);
				setOffsets(result, simpleName);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 63:  qualifiedPathNameCS ::= pathNameCS :: notReservedSimpleNameCS
			//
			case 63: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				SimpleNameCS simpleName = (SimpleNameCS)dtParser.getSym(3);
				result = extendPathNameCS(result, simpleName);
				setOffsets(result, result, simpleName);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 64:  primitiveTypeCS ::= Boolean
			//
			case 64: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.BOOLEAN_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 65:  primitiveTypeCS ::= Integer
			//
			case 65: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INTEGER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 66:  primitiveTypeCS ::= Real
			//
			case 66: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.REAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 67:  primitiveTypeCS ::= String
			//
			case 67: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.STRING_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 68:  primitiveTypeCS ::= UnlimitedNatural
			//
			case 68: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 69:  primitiveTypeCS ::= OclAny
			//
			case 69: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_ANY_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 70:  primitiveTypeCS ::= OclInvalid
			//
			case 70: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_INVALID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 71:  primitiveTypeCS ::= OclVoid
			//
			case 71: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_VOID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 72:  CollectionTypeIdentifierCS ::= Bag
			//
			case 72: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.BAG_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 73:  CollectionTypeIdentifierCS ::= Collection
			//
			case 73: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.COLLECTION_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 74:  CollectionTypeIdentifierCS ::= OrderedSet
			//
			case 74: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 75:  CollectionTypeIdentifierCS ::= Sequence
			//
			case 75: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.SEQUENCE_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 76:  CollectionTypeIdentifierCS ::= Set
			//
			case 76: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.SET_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 77:  collectionTypeCS ::= CollectionTypeIdentifierCS ( typeCS )
			//
			case 77: {
				
				CollectionTypeCS result = (CollectionTypeCS)dtParser.getSym(1);
				result.setTypeCS((TypeCS)dtParser.getSym(3));
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 78:  tupleTypeCS ::= Tuple ( variableDeclarationListCSopt )
			//
			case 78: {
				
				CSTNode result = createTupleTypeCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 79:  typeCS ::= notReservedSimpleNameCS
			//
			case 79: {
				
				CSTNode result = (CSTNode)dtParser.getSym(1);
				if (!(result instanceof TypeCS)) {
					PathNameCS pathNameCS = createPathNameCS((SimpleNameCS)result);
					setOffsets(pathNameCS, result);
					result = pathNameCS;
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 87:  typedVariableCS ::= BooleanLiteralExpCS : typeCS
			//
			case 87:
 
			//
			// Rule 88:  typedVariableCS ::= InvalidLiteralExpCS : typeCS
			//
			case 88:
 
			//
			// Rule 89:  typedVariableCS ::= NullLiteralExpCS : typeCS
			//
			case 89:
 
			//
			// Rule 90:  typedVariableCS ::= notLiteralNorReservedSimpleNameCS : typeCS
			//
			case 90: {
				
				SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
				TypeCS type = (TypeCS)dtParser.getSym(3);
				VariableCS result = createVariableCS(name, type, null);
				setOffsets(result, name, type);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 91:  VariableDeclarationCS ::= variableNameCS
			//
			case 91: {
				
				SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
				CSTNode result = createVariableCS(name, null, null);
				setOffsets(result, name);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 93:  VariableDeclarationCS ::= typedVariableCS = OclExpressionCS
			//
			case 93: {
				
				VariableCS result = (VariableCS)dtParser.getSym(1);
				OCLExpressionCS initExpression = (OCLExpressionCS)dtParser.getSym(3);
				result.setInitExpression(initExpression);
				setOffsets(result, result, initExpression);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 94:  variableDeclarationListCS ::= VariableDeclarationCS
			//
			case 94: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 95:  variableDeclarationListCS ::= variableDeclarationListCS , VariableDeclarationCS
			//
			case 95: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 96:  variableDeclarationListCSopt ::= $Empty
			//
			case 96:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 98:  BooleanLiteralExpCS ::= false
			//
			case 98: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 99:  BooleanLiteralExpCS ::= true
			//
			case 99: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 100:  IntegerLiteralExpCS ::= INTEGER_LITERAL
			//
			case 100: {
				
				CSTNode result = createIntegerLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 101:  InvalidLiteralExpCS ::= invalid
			//
			case 101: {
				
				CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 102:  NullLiteralExpCS ::= null
			//
			case 102: {
				
				CSTNode result = createNullLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 103:  RealLiteralExpCS ::= REAL_LITERAL
			//
			case 103: {
				
				CSTNode result = createRealLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 104:  StringLiteralExpCS ::= STRING_LITERAL
			//
			case 104: {
				
				IToken literalToken = getIToken(dtParser.getToken(1));
				StringLiteralExpCS result = createStringLiteralExpCS(literalToken.toString());
				result.setUnescapedStringSymbol(unescape(literalToken));
				setOffsets(result, literalToken);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 105:  UnlimitedNaturalLiteralExpCS ::= *
			//
			case 105: {
				
				CSTNode result = createUnlimitedNaturalLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 111:  CollectionLiteralExpCS ::= CollectionTypeIdentifierCS { CollectionLiteralPartsCSopt }
			//
			case 111: {
				
				CollectionTypeCS typeCS = (CollectionTypeCS)dtParser.getSym(1);
				CSTNode result = createCollectionLiteralExpCS(
						typeCS,
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, typeCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 112:  CollectionRangeCS ::= OclExpressionCS .. OclExpressionCS
			//
			case 112: {
				
				CSTNode result = createCollectionRangeCS(
						(OCLExpressionCS)dtParser.getSym(1),
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 114:  CollectionLiteralPartCS ::= OclExpressionCS
			//
			case 114: {
				
				CSTNode result = createCollectionLiteralPartCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 115:  CollectionLiteralPartsCS ::= CollectionLiteralPartCS
			//
			case 115: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 116:  CollectionLiteralPartsCS ::= CollectionLiteralPartsCS , CollectionLiteralPartCS
			//
			case 116: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 117:  CollectionLiteralPartsCSopt ::= $Empty
			//
			case 117:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 119:  TupleLiteralExpCS ::= Tuple { TupleLiteralPartsCS }
			//
			case 119: {
				
				CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 120:  TupleLiteralPartCS ::= variableNameCS = OclExpressionCS
			//
			case 120: {
				
				SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
				OCLExpressionCS initExpression = (OCLExpressionCS)dtParser.getSym(3);
				VariableCS result = createVariableCS(name, null, initExpression);
				setOffsets(result, name, initExpression);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 121:  TupleLiteralPartCS ::= typedVariableCS = OclExpressionCS
			//
			case 121: {
				
				VariableCS result = (VariableCS)dtParser.getSym(1);
				OCLExpressionCS initExpression = (OCLExpressionCS)dtParser.getSym(3);
				result.setInitExpression(initExpression);
				setOffsets(result, result, initExpression);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 122:  TupleLiteralPartsCS ::= TupleLiteralPartCS
			//
			case 122: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 123:  TupleLiteralPartsCS ::= TupleLiteralPartsCS , TupleLiteralPartCS
			//
			case 123: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 129:  OperationCallExpCS ::= primaryExpCS -> notIteratorNorReservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 129: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CSTNode result = createArrowOperationCallExpCS(
						source,
						(SimpleNameCS)dtParser.getSym(3),
						(IsMarkedPreCS)dtParser.getSym(4),
						(EList)dtParser.getSym(6)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 130:  OperationCallExpCS ::= primaryExpCS . binaryKeywordCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 130:
 
			//
			// Rule 131:  OperationCallExpCS ::= primaryExpCS . unaryKeywordCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 131:
 
			//
			// Rule 132:  OperationCallExpCS ::= primaryExpCS . reservedPunctuationCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 132:
 
			//
			// Rule 133:  OperationCallExpCS ::= primaryExpCS . notReservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 133: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CSTNode result = createDotOperationCallExpCS(
						source,
						null,
						(SimpleNameCS)dtParser.getSym(3),
						(IsMarkedPreCS)dtParser.getSym(4),
						(EList)dtParser.getSym(6)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 134:  OperationCallExpCS ::= literalSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 134:
 
			//
			// Rule 135:  OperationCallExpCS ::= notLiteralNorReservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 135: {
				
				CSTNode result = createDotOperationCallExpCS(
						null,
						null,
						(SimpleNameCS)dtParser.getSym(1),
						(IsMarkedPreCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 136:  OperationCallExpCS ::= qualifiedPathNameCS ( argumentsCSopt )
			//
			case 136: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
				OperationCallExpCS result = createDotOperationCallExpCS(
						null,
						pathNameCS,
						simpleNameCS,
						null,
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, pathNameCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 137:  OperationCallExpCS ::= primaryExpCS . qualifiedPathNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 137: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(3);
				SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CallExpCS result = createDotOperationCallExpCS(
						source,
						pathNameCS,
						simpleNameCS,
						(IsMarkedPreCS)dtParser.getSym(4),
						(EList)dtParser.getSym(6)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 138:  argumentsCS ::= OclExpressionCS
			//
			case 138: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 139:  argumentsCS ::= argumentsCS , OclExpressionCS
			//
			case 139: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 140:  argumentsCSopt ::= $Empty
			//
			case 140:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 142:  isMarkedPreCSopt ::= $Empty
			//
			case 142: {
				
				dtParser.setSym1(null);
	  		  break;
			}
	 
			//
			// Rule 143:  PropertyCallExpCS ::= primaryExpCS . notReservedSimpleNameCS isMarkedPreCSopt
			//
			case 143: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(4);
				CSTNode result = createFeatureCallExpCS(
						source,
						null,
						simpleNameCS,
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS != null) {
					setOffsets(result, source, isMarkedPreCS);
				} else {
					setOffsets(result, source, simpleNameCS);
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 144:  PropertyCallExpCS ::= primaryExpCS . qualifiedPathNameCS isMarkedPreCSopt
			//
			case 144: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(3);
				SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(4);
				CSTNode result = createFeatureCallExpCS(
						source,
						pathNameCS,
						simpleNameCS,
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS != null) {
					setOffsets(result, source, isMarkedPreCS);
				} else {
					setOffsets(result, source, simpleNameCS);
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 145:  PropertyCallExpCS ::= primaryExpCS . pathNameCS [ argumentsCS ] isMarkedPreCSopt
			//
			case 145: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(3);
				SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(7);
				CSTNode result = createFeatureCallExpCS(
						source,
						pathNameCS,
						simpleNameCS,
						(EList)dtParser.getSym(5),
						isMarkedPreCS
					);
				if (isMarkedPreCS != null) {
					setOffsets(result, source, isMarkedPreCS);
				} else {
					setOffsets(result, source, getIToken(dtParser.getToken(6)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 146:  PropertyCallExpCS ::= qualifiedPathNameCS isMarkedPreCSopt
			//
			case 146: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(2);
				CSTNode result = createFeatureCallExpCS(
						null,
						pathNameCS,
						simpleNameCS,
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS != null) {
					setOffsets(result, pathNameCS, isMarkedPreCS);
				} else {
					setOffsets(result, pathNameCS, simpleNameCS);
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 147:  AssociationClassCallExpCS ::= notLiteralNorReservedSimpleNameCS isMarkedPreCSopt
			//
			case 147: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(2);
				CSTNode result = createVariableExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS != null) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(2));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 148:  AssociationClassCallExpCS ::= notReservedSimpleNameCS [ argumentsCS ] isMarkedPreCSopt
			//
			case 148: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(5);
				CSTNode result = createVariableExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3),
						isMarkedPreCS
					);
				if (isMarkedPreCS != null) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(5));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 152:  IterateExpCS ::= primaryExpCS -> iterateNameCS ( VariableDeclarationCS | OclExpressionCS )
			//
			case 152: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
				CSTNode result = createIterateExpCS(
						source,
						simpleNameCS,
						(VariableCS)dtParser.getSym(5),
						null,
						(OCLExpressionCS)dtParser.getSym(7)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(8)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 153:  IterateExpCS ::= primaryExpCS -> iterateNameCS ( VariableDeclarationCS ; VariableDeclarationCS | OclExpressionCS )
			//
			case 153: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
				CSTNode result = createIterateExpCS(
						source,
						simpleNameCS,
						(VariableCS)dtParser.getSym(5),
						(VariableCS)dtParser.getSym(7),
						(OCLExpressionCS)dtParser.getSym(9)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(10)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 154:  IteratorExpCS ::= primaryExpCS -> iteratorNameCS ( OclExpressionCS )
			//
			case 154: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
				CSTNode result = createIteratorExpCS(
						source,
						simpleNameCS,
						null,
						null,
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 155:  IteratorExpCS ::= primaryExpCS -> iteratorNameCS ( VariableDeclarationCS | OclExpressionCS )
			//
			case 155: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
				CSTNode result = createIteratorExpCS(
						source,
						simpleNameCS,
						(VariableCS)dtParser.getSym(5),
						null,
						(OCLExpressionCS)dtParser.getSym(7)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(8)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 156:  IteratorExpCS ::= primaryExpCS -> iteratorNameCS ( VariableDeclarationCS , VariableDeclarationCS | OclExpressionCS )
			//
			case 156: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
				CSTNode result = createIteratorExpCS(
						source,
						simpleNameCS,
						(VariableCS)dtParser.getSym(5),
						(VariableCS)dtParser.getSym(7),
						(OCLExpressionCS)dtParser.getSym(9)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(10)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 161:  IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS endif
			//
			case 161: {
				
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
			// Rule 162:  LetExpCS ::= let variableDeclarationListCS in OclExpressionCS
			//
			case 162: {
				
				OCLExpressionCS expr = (OCLExpressionCS)dtParser.getSym(4);
				CSTNode result = createLetExpCS(
						(EList)dtParser.getSym(2),
						expr
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), expr);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 167:  impliesExpCS ::= impliesExpCS implies xorExpCS
			//
			case 167:
 
			//
			// Rule 168:  impliesLetCS ::= impliesExpCS implies xorLetCS
			//
			case 168:
 
			//
			// Rule 171:  xorExpCS ::= xorExpCS xor orExpCS
			//
			case 171:
 
			//
			// Rule 172:  xorLetCS ::= xorExpCS xor orLetCS
			//
			case 172:
 
			//
			// Rule 175:  orExpCS ::= orExpCS or andExpCS
			//
			case 175:
 
			//
			// Rule 176:  orLetCS ::= orExpCS or andLetCS
			//
			case 176:
 
			//
			// Rule 179:  andExpCS ::= andExpCS and equalityExpCS
			//
			case 179:
 
			//
			// Rule 180:  andLetCS ::= andExpCS and equalityLetCS
			//
			case 180:
 
			//
			// Rule 183:  equalityExpCS ::= equalityExpCS = relationalExpCS
			//
			case 183:
 
			//
			// Rule 184:  equalityLetCS ::= equalityExpCS = relationalLetCS
			//
			case 184:
 
			//
			// Rule 185:  equalityExpCS ::= equalityExpCS <> relationalExpCS
			//
			case 185:
 
			//
			// Rule 186:  equalityLetCS ::= equalityExpCS <> relationalLetCS
			//
			case 186:
 
			//
			// Rule 189:  relationalExpCS ::= relationalExpCS > additiveExpCS
			//
			case 189:
 
			//
			// Rule 190:  relationalLetCS ::= relationalExpCS > additiveLetCS
			//
			case 190:
 
			//
			// Rule 191:  relationalExpCS ::= relationalExpCS < additiveExpCS
			//
			case 191:
 
			//
			// Rule 192:  relationalLetCS ::= relationalExpCS < additiveLetCS
			//
			case 192:
 
			//
			// Rule 193:  relationalExpCS ::= relationalExpCS >= additiveExpCS
			//
			case 193:
 
			//
			// Rule 194:  relationalLetCS ::= relationalExpCS >= additiveLetCS
			//
			case 194:
 
			//
			// Rule 195:  relationalExpCS ::= relationalExpCS <= additiveExpCS
			//
			case 195:
 
			//
			// Rule 196:  relationalLetCS ::= relationalExpCS <= additiveLetCS
			//
			case 196:
 
			//
			// Rule 199:  additiveExpCS ::= additiveExpCS + multiplicativeExpCS
			//
			case 199:
 
			//
			// Rule 200:  additiveLetCS ::= additiveExpCS + multiplicativeLetCS
			//
			case 200:
 
			//
			// Rule 201:  additiveExpCS ::= additiveExpCS - multiplicativeExpCS
			//
			case 201:
 
			//
			// Rule 202:  additiveLetCS ::= additiveExpCS - multiplicativeLetCS
			//
			case 202:
 
			//
			// Rule 205:  multiplicativeExpCS ::= multiplicativeExpCS * unaryExpCS
			//
			case 205:
 
			//
			// Rule 206:  multiplicativeLetCS ::= multiplicativeExpCS * unaryLetCS
			//
			case 206:
 
			//
			// Rule 207:  multiplicativeExpCS ::= multiplicativeExpCS / unaryExpCS
			//
			case 207:
 
			//
			// Rule 208:  multiplicativeLetCS ::= multiplicativeExpCS / unaryLetCS
			//
			case 208: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							getTokenText(dtParser.getToken(2))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				OCLExpressionCS left = (OCLExpressionCS)dtParser.getSym(1);
				OCLExpressionCS right = (OCLExpressionCS)dtParser.getSym(3);
				EList args = new BasicEList();
				args.add(right);
				CSTNode result = createOperationCallExpCS(
						left,
						simpleNameCS,
						args
					);
				setOffsets(result, left, right);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 211:  unaryExpCS ::= - unaryExpCS
			//
			case 211:
 
			//
			// Rule 212:  unaryLetCS ::= - unaryLetCS
			//
			case 212:
 
			//
			// Rule 213:  unaryExpCS ::= not unaryExpCS
			//
			case 213:
 
			//
			// Rule 214:  unaryLetCS ::= not unaryLetCS
			//
			case 214: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				OCLExpressionCS expr = (OCLExpressionCS)dtParser.getSym(2);
				CSTNode result = createOperationCallExpCS(
						expr,
						simpleNameCS,
						new BasicEList()
					);
				setOffsets(result, simpleNameCS, expr);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 218:  primaryExpCS ::= ( OclExpressionCS )
			//
			case 218: {
				
				CSTNode result = (CSTNode)dtParser.getSym(2);
				if (result instanceof OperationCallExpCS) {
					((OperationCallExpCS)result).setIsAtomic(true);
				}
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 239:  simpleNameCSopt ::= $Empty
			//
			case 239:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 241:  primitiveTypeCS ::= OclMessage
			//
			case 241: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_MESSAGE_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 242:  typeCSopt ::= $Empty
			//
			case 242:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 244:  isMarkedPreCSopt ::= @ pre
			//
			case 244: {
				
				CSTNode result = createIsMarkedPreCS();
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 245:  OclMessageExpCS ::= primaryExpCS ^ simpleNameCS ( OclMessageArgumentsCSopt )
			//
			case 245:
 
			//
			// Rule 246:  OclMessageExpCS ::= primaryExpCS ^^ simpleNameCS ( OclMessageArgumentsCSopt )
			//
			case 246: {
				
				OCLExpressionCS target = (OCLExpressionCS)dtParser.getSym(1);
				MessageExpCS result = createMessageExpCS(
						target,
						getIToken(dtParser.getToken(2)).getKind() == OCLParsersym.TK_CARET,
						(SimpleNameCS)dtParser.getSym(3),
						(EList<OCLMessageArgCS>)dtParser.getSym(5)
					);
				setOffsets(result, target, getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 247:  OclMessageArgumentsCSopt ::= $Empty
			//
			case 247:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 249:  OclMessageArgumentsCS ::= OclMessageArgCS
			//
			case 249: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 250:  OclMessageArgumentsCS ::= OclMessageArgumentsCS , OclMessageArgCS
			//
			case 250: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 251:  OclMessageArgCS ::= OclExpressionCS
			//
			case 251: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 252:  OclMessageArgCS ::= ?
			//
			case 252: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 253:  OclMessageArgCS ::= ? : typeCS
			//
			case 253: {
				
				CSTNode result = createOCLMessageArgCS(
						(TypeCS)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 255:  classifierContextDeclCS ::= context pathNameCS invOrDefsCS
			//
			case 255: {
				
				EList<InvOrDefCS> list = (EList<InvOrDefCS>)dtParser.getSym(3);
				CSTNode result = createClassifierContextDeclCS(
						null,
						(PathNameCS)dtParser.getSym(2),
						list
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), list.get(list.size()-1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 256:  classifierContextDeclCS ::= context simpleNameCS : pathNameCS invOrDefsCS
			//
			case 256: {
				
				EList<InvOrDefCS> list = (EList<InvOrDefCS>)dtParser.getSym(5);
				CSTNode result = createClassifierContextDeclCS(
						(SimpleNameCS)dtParser.getSym(2),
						(PathNameCS)dtParser.getSym(4),
						list
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), list.get(list.size()-1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 257:  invOrDefCS ::= inv simpleNameCSopt : OclExpressionCS
			//
			case 257: {
				
				CSTNode result = createInvCS(
						(SimpleNameCS)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 258:  defCS ::= def simpleNameCSopt : defExpressionCS
			//
			case 258: {
				
				DefCS result = createDefCS(
						(SimpleNameCS)dtParser.getSym(2),
						(DefExpressionCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 260:  invOrDefCS ::= static defCS
			//
			case 260: {
				
				DefCS result = (DefCS)dtParser.getSym(2);
				result.setStatic(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 261:  invOrDefsCS ::= invOrDefCS
			//
			case 261: {
				
				EList<InvOrDefCS> result = new BasicEList<InvOrDefCS>();
				result.add((InvOrDefCS)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 262:  invOrDefsCS ::= invOrDefsCS invOrDefCS
			//
			case 262: {
				
				EList<InvOrDefCS> result = (EList<InvOrDefCS>)dtParser.getSym(1);
				result.add((InvOrDefCS)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 263:  defExpressionCS ::= typedVariableCS = OclExpressionCS
			//
			case 263: {
				
				VariableCS variableCS = (VariableCS)dtParser.getSym(1);
				OCLExpressionCS expressionCS = (OCLExpressionCS)dtParser.getSym(3);
				CSTNode result = createDefExpressionCS(
						variableCS,
						null,
						expressionCS
					);
				setOffsets(result, variableCS, expressionCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 264:  defExpressionCS ::= operationCS1 = OclExpressionCS
			//
			case 264: {
				
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
			// Rule 265:  operationContextDeclCS ::= context operationCS2 prePostOrBodyDeclsCS
			//
			case 265: {
				
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
			// Rule 266:  operationCS1 ::= notReservedSimpleNameCS ( parametersCSopt ) : typeCSopt
			//
			case 266: {
				
				CSTNode result = createOperationCS(
						getTokenText(dtParser.getToken(1)),
						(EList)dtParser.getSym(3),
						(TypeCS)dtParser.getSym(6)
					);
				if (dtParser.getSym(6) != null) {
					setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(6));
				} else {
					setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 267:  operationCS2 ::= qualifiedPathNameCS ( parametersCSopt ) : typeCSopt
			//
			case 267: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				TypeCS typeCS = (TypeCS)dtParser.getSym(6);
				CSTNode result = createOperationCS(
						pathNameCS,
						removeLastSimpleNameCS(pathNameCS),
						(EList)dtParser.getSym(3),
						typeCS
					);
				if (typeCS != null) {
					setOffsets(result, pathNameCS, typeCS);
				} else {
					setOffsets(result, pathNameCS, getIToken(dtParser.getToken(5)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 268:  parametersCS ::= VariableDeclarationCS
			//
			case 268: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 269:  parametersCS ::= parametersCS , VariableDeclarationCS
			//
			case 269: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 270:  parametersCSopt ::= $Empty
			//
			case 270:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 272:  prePostOrBodyDeclCS ::= pre simpleNameCSopt : OclExpressionCS
			//
			case 272: {
				
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
			// Rule 273:  prePostOrBodyDeclCS ::= post simpleNameCSopt : OclExpressionCS
			//
			case 273: {
				
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
			// Rule 274:  prePostOrBodyDeclCS ::= body simpleNameCSopt : OclExpressionCS
			//
			case 274: {
				
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
			// Rule 275:  prePostOrBodyDeclsCS ::= prePostOrBodyDeclCS
			//
			case 275: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 276:  prePostOrBodyDeclsCS ::= prePostOrBodyDeclsCS prePostOrBodyDeclCS
			//
			case 276: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 277:  propertyContextCS ::= context qualifiedPathNameCS : typeCS initOrDerValuesCS
			//
			case 277: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(2);
				EList<InitOrDerValueCS> list = (EList<InitOrDerValueCS>)dtParser.getSym(5);
				CSTNode result = createPropertyContextCS(
						pathNameCS,
						removeLastSimpleNameCS(pathNameCS),
						(TypeCS)dtParser.getSym(4),
						list
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), list.get(list.size()-1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 278:  initOrDerValueCS ::= init : OclExpressionCS
			//
			case 278: {
				
				CSTNode result = createInitValueCS((OCLExpressionCS)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 279:  initOrDerValueCS ::= derive : OclExpressionCS
			//
			case 279: {
				
				CSTNode result = createDerValueCS((OCLExpressionCS)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 280:  initOrDerValuesCS ::= initOrDerValueCS
			//
			case 280: {
				
				EList<InitOrDerValueCS> result = new BasicEList<InitOrDerValueCS>();
				result.add((InitOrDerValueCS)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 281:  initOrDerValuesCS ::= initOrDerValuesCS initOrDerValueCS
			//
			case 281: {
				
				EList<InitOrDerValueCS> result = (EList<InitOrDerValueCS>)dtParser.getSym(1);
				result.add((InitOrDerValueCS)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 285:  contextDeclsCS ::= contextDeclCS
			//
			case 285: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 286:  contextDeclsCS ::= contextDeclsCS contextDeclCS
			//
			case 286: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 287:  contextDeclsCSopt ::= $Empty
			//
			case 287:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 289:  packageDeclarationCS ::= package pathNameCS contextDeclsCSopt endpackage
			//
			case 289: {
				
				CSTNode result = createPackageDeclarationCS(
						(PathNameCS)dtParser.getSym(2),
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 290:  packageDeclarationCS1 ::= contextDeclsCS
			//
			case 290: {
				
				EList contextDecls = (EList)dtParser.getSym(1);
				CSTNode result = createPackageDeclarationCS(null, contextDecls);
				if (!contextDecls.isEmpty()) {
					setOffsets(result, (CSTNode)contextDecls.get(0), (CSTNode)contextDecls.get(contextDecls.size()-1));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 292:  packageDeclarationsCS ::= packageDeclarationsCS packageDeclarationCS
			//
			case 292: {
				
				PackageDeclarationCS result = (PackageDeclarationCS)dtParser.getSym(2);
				result.setPackageDeclarationCS((PackageDeclarationCS) dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	
	
			default:
				break;
		}
		return;
	}
}

