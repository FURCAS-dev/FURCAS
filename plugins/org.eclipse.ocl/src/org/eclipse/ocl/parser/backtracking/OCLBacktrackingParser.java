/**
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
*   E.D.Willink - Bugs 184048, 225493, 243976, 259818, 282882, 287993, 288040
*   Borland - Bug 242880
*
* </copyright>
*
* $Id: OCLBacktrackingParser.java,v 1.10 2009/10/10 07:06:40 ewillink Exp $
*/

package org.eclipse.ocl.parser.backtracking;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.cst.IntegerLiteralExpCS;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.cst.MessageExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OCLMessageArgCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;

import lpg.lpgjavaruntime.BadParseException;
import lpg.lpgjavaruntime.BadParseSymFileException;
import lpg.lpgjavaruntime.BacktrackingParser;
import lpg.lpgjavaruntime.DiagnoseParser;
import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.Monitor;
import lpg.lpgjavaruntime.NotBacktrackParseTableException;
import lpg.lpgjavaruntime.ParseTable;
import lpg.lpgjavaruntime.RuleAction;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.cst.DefCS;
import org.eclipse.ocl.cst.DefExpressionCS;
import org.eclipse.ocl.cst.InitOrDerValueCS;
import org.eclipse.ocl.cst.InvOrDefCS;
import org.eclipse.ocl.cst.OperationCS;
import org.eclipse.ocl.cst.PackageDeclarationCS;
import org.eclipse.ocl.cst.PrePostOrBodyEnum;

	import org.eclipse.ocl.parser.AbstractOCLParser;

public class OCLBacktrackingParser extends AbstractOCLParser implements RuleAction
{
	protected static ParseTable prs = new OCLBacktrackingParserprs();
	private BacktrackingParser dtParser;

	public OCLBacktrackingParser(OCLBacktrackingLexer lexer) {
		super(lexer);
	}

	public int getEOFTokenKind() { return OCLBacktrackingParserprs.EOFT_SYMBOL; }

	public Environment<?,?,?,?,?,?,?,?,?,?,?,?> getOCLEnvironment() {
		return getLexer().getOCLEnvironment();
	}
	
	@Override 
	public OCLBacktrackingLexer getLexer() {
		return (OCLBacktrackingLexer)super.getLexer();
	}

	public String getTokenKindName(int kind) { return OCLBacktrackingParsersym.orderedTerminalSymbols[kind]; }			

	@Override
	public String[] orderedTerminalSymbols() { return OCLBacktrackingParsersym.orderedTerminalSymbols; }
		
	@SuppressWarnings("nls")
	@Override
	public CSTNode parseTokensToCST(Monitor monitor, int error_repair_count) {
		ParseTable prsTable = new OCLBacktrackingParserprs();

		try {
			dtParser = new BacktrackingParser(monitor, this, prsTable, this);
		}
		catch (NotBacktrackParseTableException e) {
            throw new RuntimeException("****Error: Regenerate OCLBacktrackingParserprs.java with -BACKTRACK option");
		}
		catch (BadParseSymFileException e) {
			throw new RuntimeException("****Error: Bad Parser Symbol File -- OCLBacktrackingParsersym.java. Regenerate OCLBacktrackingParserprs.java");
		}

		try {
			return (CSTNode) dtParser.parse(error_repair_count);
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
			// Rule 42:  iterateNameCS ::= iterateIdentifier
			//
			case 42:
 
			//
			// Rule 43:  iteratorNameCS ::= iteratorIdentifier
			//
			case 43:
 
			//
			// Rule 44:  reservedKeywordCS ::= reservedKeyword
			//
			case 44:
 
			//
			// Rule 45:  reservedPunctuationCS ::= reservedPunctuation
			//
			case 45: {
				
				SimpleNameCS result = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 65:  operationCS1 ::= notReservedSimpleNameCS ( variableListCSopt ) : typeCSopt
			//
			case 65: {
				
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
			// Rule 66:  operationCS2 ::= qualifiedPathNameCS ( variableListCSopt ) : typeCSopt
			//
			case 66: {
				
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
			// Rule 67:  simpleNameCSopt ::= $Empty
			//
			case 67:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 73:  impliesExpCS ::= impliesExpCS implies xorExpCS
			//
			case 73:
 
			//
			// Rule 74:  impliesWithLet ::= impliesExpCS implies xorWithLet
			//
			case 74:
 
			//
			// Rule 77:  xorExpCS ::= xorExpCS xor orExpCS
			//
			case 77:
 
			//
			// Rule 78:  xorWithLet ::= xorExpCS xor orWithLet
			//
			case 78:
 
			//
			// Rule 81:  orExpCS ::= orExpCS or andExpCS
			//
			case 81:
 
			//
			// Rule 82:  orWithLet ::= orExpCS or andWithLet
			//
			case 82:
 
			//
			// Rule 85:  andExpCS ::= andExpCS and equalityExpCS
			//
			case 85:
 
			//
			// Rule 86:  andWithLet ::= andExpCS and equalityWithLet
			//
			case 86:
 
			//
			// Rule 89:  equalityExpCS ::= equalityExpCS = relationalExpCS
			//
			case 89:
 
			//
			// Rule 90:  equalityWithLet ::= equalityExpCS = relationalWithLet
			//
			case 90:
 
			//
			// Rule 91:  equalityExpCS ::= equalityExpCS <> relationalExpCS
			//
			case 91:
 
			//
			// Rule 92:  equalityWithLet ::= equalityExpCS <> relationalWithLet
			//
			case 92:
 
			//
			// Rule 95:  relationalExpCS ::= relationalExpCS > additiveExpCS
			//
			case 95:
 
			//
			// Rule 96:  relationalWithLet ::= relationalExpCS > additiveWithLet
			//
			case 96:
 
			//
			// Rule 97:  relationalExpCS ::= relationalExpCS < additiveExpCS
			//
			case 97:
 
			//
			// Rule 98:  relationalWithLet ::= relationalExpCS < additiveWithLet
			//
			case 98:
 
			//
			// Rule 99:  relationalExpCS ::= relationalExpCS >= additiveExpCS
			//
			case 99:
 
			//
			// Rule 100:  relationalWithLet ::= relationalExpCS >= additiveWithLet
			//
			case 100:
 
			//
			// Rule 101:  relationalExpCS ::= relationalExpCS <= additiveExpCS
			//
			case 101:
 
			//
			// Rule 102:  relationalWithLet ::= relationalExpCS <= additiveWithLet
			//
			case 102:
 
			//
			// Rule 105:  additiveExpCS ::= additiveExpCS + multiplicativeExpCS
			//
			case 105:
 
			//
			// Rule 106:  additiveWithLet ::= additiveExpCS + multiplicativeWithLet
			//
			case 106:
 
			//
			// Rule 107:  additiveExpCS ::= additiveExpCS - multiplicativeExpCS
			//
			case 107:
 
			//
			// Rule 108:  additiveWithLet ::= additiveExpCS - multiplicativeWithLet
			//
			case 108:
 
			//
			// Rule 111:  multiplicativeExpCS ::= multiplicativeExpCS * unaryExpCS
			//
			case 111:
 
			//
			// Rule 112:  multiplicativeWithLet ::= multiplicativeExpCS * unaryWithLet
			//
			case 112:
 
			//
			// Rule 113:  multiplicativeExpCS ::= multiplicativeExpCS / unaryExpCS
			//
			case 113:
 
			//
			// Rule 114:  multiplicativeWithLet ::= multiplicativeExpCS / unaryWithLet
			//
			case 114: {
				
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
			// Rule 117:  unaryExpCS ::= - unaryExpCS
			//
			case 117: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.MINUS)
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
			// Rule 118:  unaryExpCS ::= not unaryExpCS
			//
			case 118: {
				
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
			// Rule 122:  dotArrowExpCS ::= NUMERIC_OPERATION ( argumentsCSopt )
			//
			case 122: {
				
				// NUMERIC_OPERATION -> Integer '.' Identifier
				String text = getTokenText(dtParser.getToken(1));
				int index = text.indexOf('.');
				String integer = text.substring(0, index);
				String simpleName = text.substring(index + 1);

				// create the IntegerLiteralExpCS
				IToken numericToken = getIToken(dtParser.getToken(1));
				int startOffset = numericToken.getStartOffset();
				int endOffset = startOffset + integer.length() - 1; // inclusive

				IntegerLiteralExpCS integerLiteralExpCS = createIntegerLiteralExpCS(integer);
				integerLiteralExpCS.setStartOffset(startOffset);
				integerLiteralExpCS.setEndOffset(endOffset);
				integerLiteralExpCS.setStartToken(numericToken);
				integerLiteralExpCS.setEndToken(numericToken);

				startOffset = endOffset + 2; // end of integerLiteral + 1('.') + 1(start of simpleName)
				endOffset = getIToken(dtParser.getToken(1)).getEndOffset();

				// create the SimpleNameCS
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							simpleName
						);
				simpleNameCS.setStartOffset(startOffset);
				simpleNameCS.setEndOffset(endOffset);
				simpleNameCS.setStartToken(numericToken);
				simpleNameCS.setEndToken(numericToken);

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
			// Rule 128:  oclExpCS ::= ( oclExpressionCS )
			//
			case 128: {
				
				CSTNode result = (CSTNode)dtParser.getSym(2);
				if (result instanceof OperationCallExpCS) {
					((OperationCallExpCS)result).setIsAtomic(true);
				}
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 129:  associationClassCallExpCS ::= notLiteralNorReservedSimpleNameCS isMarkedPreCSopt
			//
			case 129: {
				
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
			// Rule 130:  associationClassCallExpCS ::= notReservedSimpleNameCS [ argumentsCS ] isMarkedPreCSopt
			//
			case 130: {
				
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
			// Rule 132:  simpleIdentifierCS ::= self
			//
			case 132: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.SELF_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 133:  simpleIdentifierCS ::= IDENTIFIER
			//
			case 133: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 134:  primitiveTypeCS ::= Integer
			//
			case 134: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INTEGER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 135:  primitiveTypeCS ::= UnlimitedNatural
			//
			case 135: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 136:  primitiveTypeCS ::= String
			//
			case 136: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.STRING_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 137:  primitiveTypeCS ::= Real
			//
			case 137: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.REAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 138:  primitiveTypeCS ::= Boolean
			//
			case 138: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.BOOLEAN_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 139:  primitiveTypeCS ::= OclAny
			//
			case 139: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_ANY_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 140:  primitiveTypeCS ::= OclVoid
			//
			case 140: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_VOID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 141:  primitiveTypeCS ::= OclInvalid
			//
			case 141: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_INVALID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 142:  primitiveTypeCS ::= OclMessage
			//
			case 142: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_MESSAGE_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 143:  pathNameCS ::= notReservedSimpleNameCS
			//
			case 143: {
				
				SimpleNameCS simpleName = (SimpleNameCS)dtParser.getSym(1);
				PathNameCS result = createPathNameCS(simpleName);
				setOffsets(result, simpleName);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 144:  qualifiedPathNameCS ::= pathNameCS :: notReservedSimpleNameCS
			//
			case 144: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				SimpleNameCS simpleName = (SimpleNameCS)dtParser.getSym(3);
				result = extendPathNameCS(result, simpleName);
				setOffsets(result, result, simpleName);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 152:  enumLiteralExpCS ::= qualifiedPathNameCS
			//
			case 152: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
				CSTNode result = createEnumLiteralExpCS(
						pathNameCS,
						simpleNameCS
					);
				setOffsets(result, pathNameCS, simpleNameCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 153:  collectionLiteralExpCS ::= collectionTypeIdentifierCS { collectionLiteralPartsCSopt }
			//
			case 153: {
				
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
			// Rule 154:  collectionTypeIdentifierCS ::= Set
			//
			case 154: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.SET_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 155:  collectionTypeIdentifierCS ::= Bag
			//
			case 155: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.BAG_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 156:  collectionTypeIdentifierCS ::= Sequence
			//
			case 156: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.SEQUENCE_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 157:  collectionTypeIdentifierCS ::= Collection
			//
			case 157: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.COLLECTION_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 158:  collectionTypeIdentifierCS ::= OrderedSet
			//
			case 158: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 159:  collectionLiteralPartsCSopt ::= $Empty
			//
			case 159:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 161:  collectionLiteralPartsCS ::= collectionLiteralPartCS
			//
			case 161: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 162:  collectionLiteralPartsCS ::= collectionLiteralPartsCS , collectionLiteralPartCS
			//
			case 162: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 164:  collectionLiteralPartCS ::= oclExpressionCS
			//
			case 164: {
				
				CSTNode result = createCollectionLiteralPartCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 165:  collectionRangeCS ::= - INTEGER_RANGE_START oclExpressionCS
			//
			case 165: {
				
				OCLExpressionCS rangeStart = createRangeStart(
						getTokenText(dtParser.getToken(2)), true);
				CSTNode result = createCollectionRangeCS(
						rangeStart,
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, rangeStart, (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 166:  collectionRangeCS ::= INTEGER_RANGE_START oclExpressionCS
			//
			case 166: {
				
				OCLExpressionCS rangeStart = createRangeStart(
						getTokenText(dtParser.getToken(1)), false);
				CSTNode result = createCollectionRangeCS(
						rangeStart,
						(OCLExpressionCS)dtParser.getSym(2)
					);
				setOffsets(result, rangeStart, (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 167:  collectionRangeCS ::= oclExpressionCS .. oclExpressionCS
			//
			case 167: {
				
				CSTNode result = createCollectionRangeCS(
						(OCLExpressionCS)dtParser.getSym(1),
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 173:  tupleLiteralExpCS ::= Tuple { variableListCS2 }
			//
			case 173: {
				
				CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 174:  integerLiteralExpCS ::= INTEGER_LITERAL
			//
			case 174: {
				
				CSTNode result = createIntegerLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 175:  unlimitedNaturalLiteralExpCS ::= *
			//
			case 175: {
				
				CSTNode result = createUnlimitedNaturalLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 176:  realLiteralExpCS ::= REAL_LITERAL
			//
			case 176: {
				
				CSTNode result = createRealLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 177:  stringLiteralExpCS ::= STRING_LITERAL
			//
			case 177: {
				
				IToken literalToken = getIToken(dtParser.getToken(1));
				StringLiteralExpCS result = createStringLiteralExpCS(literalToken.toString());
				result.setUnescapedStringSymbol(unescape(literalToken));
				setOffsets(result, literalToken);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 178:  booleanLiteralExpCS ::= true
			//
			case 178: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 179:  booleanLiteralExpCS ::= false
			//
			case 179: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 180:  nullLiteralExpCS ::= null
			//
			case 180: {
				
				CSTNode result = createNullLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 181:  invalidLiteralExpCS ::= invalid
			//
			case 181: {
				
				CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 189:  iteratorExpCS ::= dotArrowExpCS -> iteratorNameCS ( oclExpressionCS )
			//
			case 189: {
				
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
			// Rule 190:  iteratorExpCS ::= dotArrowExpCS -> iteratorNameCS ( variableCS | oclExpressionCS )
			//
			case 190: {
				
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
			// Rule 191:  iteratorExpCS ::= dotArrowExpCS -> iteratorNameCS ( variableCS , variableCS | oclExpressionCS )
			//
			case 191: {
				
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
			// Rule 192:  iterateExpCS ::= dotArrowExpCS -> iterateNameCS ( variableCS | oclExpressionCS )
			//
			case 192: {
				
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
			// Rule 193:  iterateExpCS ::= dotArrowExpCS -> iterateNameCS ( variableCS ; variableCS | oclExpressionCS )
			//
			case 193: {
				
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
			// Rule 194:  variableNameCS ::= booleanLiteralExpCS
			//
			case 194:
 
			//
			// Rule 195:  variableNameCS ::= invalidLiteralExpCS
			//
			case 195:
 
			//
			// Rule 196:  variableNameCS ::= nullLiteralExpCS
			//
			case 196:
 
			//
			// Rule 197:  variableNameCS ::= notLiteralNorReservedSimpleNameCS
			//
			case 197: {
				
				SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
				CSTNode result = createVariableCS(name.getValue());
				setOffsets(result, name);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 198:  typedVariableCS ::= variableNameCS : typeCS
			//
			case 198: {
				
				VariableCS result = (VariableCS)dtParser.getSym(1);
				TypeCS type = (TypeCS)dtParser.getSym(3);
				result.setTypeCS(type);
				setOffsets(result, result, type);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 202:  variableCS2 ::= variableNameCS = oclExpressionCS
			//
			case 202:
 
			//
			// Rule 203:  variableCS ::= typedVariableCS = oclExpressionCS
			//
			case 203: {
				
				VariableCS result = (VariableCS)dtParser.getSym(1);
				OCLExpressionCS initExpression = (OCLExpressionCS)dtParser.getSym(3);
				result.setInitExpression(initExpression);
				setOffsets(result, result, initExpression);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 204:  typeCSopt ::= $Empty
			//
			case 204:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 209:  typeCS ::= notReservedSimpleNameCS
			//
			case 209: {
				
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
			// Rule 210:  collectionTypeCS ::= collectionTypeIdentifierCS ( typeCS )
			//
			case 210: {
				
				CollectionTypeCS result = (CollectionTypeCS)dtParser.getSym(1);
				result.setTypeCS((TypeCS)dtParser.getSym(3));
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 211:  tupleTypeCS ::= Tuple ( variableListCSopt )
			//
			case 211: {
				
				CSTNode result = createTupleTypeCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 212:  variableListCSopt ::= $Empty
			//
			case 212:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 214:  variableListCS2 ::= variableCS2
			//
			case 214:
 
			//
			// Rule 215:  variableListCS ::= variableCS
			//
			case 215: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 216:  variableListCS2 ::= variableListCS2 , variableCS2
			//
			case 216:
 
			//
			// Rule 217:  variableListCS ::= variableListCS , variableCS
			//
			case 217: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 218:  operationCallExpCS_B ::= dotArrowExpCS -> notIteratorNorReservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 218: {
				
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
			// Rule 219:  operationCallExpCS_CE ::= dotArrowExpCS . operationOrNotReservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 219: {
				
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
			// Rule 220:  operationCallExpCS_DF ::= notReservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 220: {
				
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
			// Rule 221:  operationCallExpCS_G ::= qualifiedPathNameCS ( argumentsCSopt )
			//
			case 221: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				OperationCallExpCS result = createDotOperationCallExpCS(
						null,
						pathNameCS,
						removeLastSimpleNameCS(pathNameCS),
						null,
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, pathNameCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 222:  operationCallExpCS_IJ ::= dotArrowExpCS . qualifiedPathNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 222: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(3);
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CallExpCS result = createDotOperationCallExpCS(
						source,
						pathNameCS,
						removeLastSimpleNameCS(pathNameCS),
						(IsMarkedPreCS)dtParser.getSym(4),
						(EList)dtParser.getSym(6)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 223:  propertyCallExpCS ::= dotArrowExpCS . notReservedSimpleNameCS isMarkedPreCSopt
			//
			case 223: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(4);
				CSTNode result = createFeatureCallExpCS(
						source,
						(SimpleNameCS)dtParser.getSym(3),
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS != null) {
					setOffsets(result, source, isMarkedPreCS);
				} else {
					setOffsets(result, source, (SimpleNameCS)dtParser.getSym(3));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 224:  propertyCallExpCS ::= dotArrowExpCS . notReservedSimpleNameCS [ argumentsCS ] isMarkedPreCSopt
			//
			case 224: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(7);
				CSTNode result = createFeatureCallExpCS(
						source,
						(SimpleNameCS)dtParser.getSym(3),
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
			// Rule 225:  isMarkedPreCSopt ::= $Empty
			//
			case 225: {
				
				dtParser.setSym1(null);
	  		  break;
			}
	 
			//
			// Rule 226:  isMarkedPreCSopt ::= @pre
			//
			case 226: {
				
				CSTNode result = createIsMarkedPreCS();
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 227:  argumentsCSopt ::= $Empty
			//
			case 227:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 229:  argumentsCS ::= oclExpressionCS
			//
			case 229: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 230:  argumentsCS ::= argumentsCS , oclExpressionCS
			//
			case 230: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 231:  letExpCS ::= let variableListCS in oclExpressionCS
			//
			case 231: {
				
				CSTNode result = createLetExpCS(
						(EList)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 232:  ifExpCS ::= if oclExpressionCS then oclExpressionCS else oclExpressionCS endif
			//
			case 232: {
				
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
			// Rule 233:  oclMessageExpCS ::= dotArrowExpCS ^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 233:
 
			//
			// Rule 234:  oclMessageExpCS ::= dotArrowExpCS ^^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 234: {
				
				OCLExpressionCS target = (OCLExpressionCS)dtParser.getSym(1);
				MessageExpCS result = createMessageExpCS(
						target,
						getIToken(dtParser.getToken(2)).getKind() == OCLBacktrackingParsersym.TK_CARET,
						(SimpleNameCS)dtParser.getSym(3),
						(EList<OCLMessageArgCS>)dtParser.getSym(5)
					);
				setOffsets(result, target, getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 235:  oclMessageArgumentsCSopt ::= $Empty
			//
			case 235:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 237:  oclMessageArgumentsCS ::= oclMessageArgCS
			//
			case 237: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 238:  oclMessageArgumentsCS ::= oclMessageArgumentsCS , oclMessageArgCS
			//
			case 238: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 239:  oclMessageArgCS ::= oclExpressionCS
			//
			case 239: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 240:  oclMessageArgCS ::= ?
			//
			case 240: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 241:  oclMessageArgCS ::= ? : typeCS
			//
			case 241: {
				
				CSTNode result = createOCLMessageArgCS(
						(TypeCS)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 250:  packageDeclarationCSm ::= packageDeclarationCSm packageDeclarationCS
			//
			case 250: {
				
				PackageDeclarationCS result = (PackageDeclarationCS)dtParser.getSym(2);
				result.setPackageDeclarationCS((PackageDeclarationCS) dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 251:  packageDeclarationCS ::= package pathNameCS contextDeclCSmopt endpackage
			//
			case 251: {
				
				CSTNode result = createPackageDeclarationCS(
						(PathNameCS)dtParser.getSym(2),
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 252:  packageDeclarationCS1 ::= contextDeclCSm
			//
			case 252: {
				
				EList contextDecls = (EList)dtParser.getSym(1);
				CSTNode result = createPackageDeclarationCS(null, contextDecls);
				if (!contextDecls.isEmpty()) {
					setOffsets(result, (CSTNode)contextDecls.get(0), (CSTNode)contextDecls.get(contextDecls.size()-1));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 253:  contextDeclCSmopt ::= $Empty
			//
			case 253:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 255:  contextDeclCSm ::= contextDeclCS
			//
			case 255: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 256:  contextDeclCSm ::= contextDeclCSm contextDeclCS
			//
			case 256: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 260:  propertyContextCS ::= context qualifiedPathNameCS : typeCS initOrDerValueCSm
			//
			case 260: {
				
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
			// Rule 261:  initOrDerValueCSm ::= initOrDerValueCS
			//
			case 261: {
				
				EList<InitOrDerValueCS> result = new BasicEList<InitOrDerValueCS>();
				result.add((InitOrDerValueCS)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 262:  initOrDerValueCSm ::= initOrDerValueCSm initOrDerValueCS
			//
			case 262: {
				
				EList<InitOrDerValueCS> result = (EList<InitOrDerValueCS>)dtParser.getSym(1);
				result.add((InitOrDerValueCS)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 263:  initOrDerValueCS ::= init : oclExpressionCS
			//
			case 263: {
				
				CSTNode result = createInitValueCS((OCLExpressionCS)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 264:  initOrDerValueCS ::= derive : oclExpressionCS
			//
			case 264: {
				
				CSTNode result = createDerValueCS((OCLExpressionCS)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 265:  classifierContextDeclCS ::= context pathNameCS invOrDefCSm
			//
			case 265: {
				
				EList<InvOrDefCS> list = (EList<InvOrDefCS>)dtParser.getSym(3);
				CSTNode result = createClassifierContextDeclCS(
						(PathNameCS)dtParser.getSym(2),
						list
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), list.get(list.size()-1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 266:  invOrDefCSm ::= invOrDefCS
			//
			case 266: {
				
				EList<InvOrDefCS> result = new BasicEList<InvOrDefCS>();
				result.add((InvOrDefCS)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 267:  invOrDefCSm ::= invOrDefCSm invOrDefCS
			//
			case 267: {
				
				EList<InvOrDefCS> result = (EList<InvOrDefCS>)dtParser.getSym(1);
				result.add((InvOrDefCS)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 268:  invOrDefCS ::= inv simpleNameCSopt : oclExpressionCS
			//
			case 268: {
				
				CSTNode result = createInvCS(
						(SimpleNameCS)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 269:  defCS ::= def simpleNameCSopt : defExpressionCS
			//
			case 269: {
				
				DefCS result = createDefCS(
						(SimpleNameCS)dtParser.getSym(2),
						(DefExpressionCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 271:  invOrDefCS ::= static defCS
			//
			case 271: {
				
				DefCS result = (DefCS)dtParser.getSym(2);
				result.setStatic(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 272:  defExpressionCS ::= typedVariableCS = oclExpressionCS
			//
			case 272: {
				
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
			// Rule 273:  defExpressionCS ::= operationCS1 = oclExpressionCS
			//
			case 273: {
				
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
			// Rule 274:  operationContextDeclCS ::= context operationCS2 prePostOrBodyDeclCSm
			//
			case 274: {
				
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
			// Rule 275:  prePostOrBodyDeclCSm ::= prePostOrBodyDeclCS
			//
			case 275: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 276:  prePostOrBodyDeclCSm ::= prePostOrBodyDeclCSm prePostOrBodyDeclCS
			//
			case 276: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 277:  prePostOrBodyDeclCS ::= pre simpleNameCSopt : oclExpressionCS
			//
			case 277: {
				
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
			// Rule 278:  prePostOrBodyDeclCS ::= post simpleNameCSopt : oclExpressionCS
			//
			case 278: {
				
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
			// Rule 279:  prePostOrBodyDeclCS ::= body simpleNameCSopt : oclExpressionCS
			//
			case 279: {
				
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
			// Rule 280:  ERROR_Colon ::= ERROR_TOKEN
			//
			case 280: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_COLON);
	  		  break;
			}
	 
			//
			// Rule 281:  ERROR_Empty ::= ERROR_TOKEN
			//
			case 281: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.EXTRA_TOKENS);
	  		  break;
			}
	 
			//
			// Rule 282:  ERROR_IsMarkedPreCS ::= ERROR_TOKEN
			//
			case 282: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_AT_PRE);
				dtParser.setSym1(null);
	  		  break;
			}
	 
			//
			// Rule 283:  ERROR_PathNameCS ::= ERROR_TOKEN
			//
			case 283: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_PATH_NAME);
				CSTNode result = createPathNameCS(createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText(dtParser.getToken(1))));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 284:  ERROR_SimpleNameCS ::= ERROR_TOKEN
			//
			case 284: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_SIMPLE_NAME);
				SimpleNameCS result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 285:  associationClassCallExpCS ::= notReservedSimpleNameCS [ argumentsCS ERROR_TOKEN
			//
			case 285: {
				
				reportErrorTokenMessage(dtParser.getToken(4), OCLParserErrors.MISSING_RBRACK);
				CSTNode result = createVariableExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3),
						null
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 286:  propertyCallExpCS ::= dotArrowExpCS . notReservedSimpleNameCS [ argumentsCS ERROR_TOKEN
			//
			case 286: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CallExpCS result = createFeatureCallExpCS(
						source,
						(SimpleNameCS)dtParser.getSym(3),
						(EList)dtParser.getSym(5),
						null
					);
				setOffsets(result, source, getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 287:  propertyCallExpCS ::= dotArrowExpCS . ERROR_SimpleNameCS [ argumentsCS ] isMarkedPreCSopt
			//
			case 287: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(7);
				CallExpCS result = createFeatureCallExpCS(
						source,
						(SimpleNameCS)dtParser.getSym(3),
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
			// Rule 288:  collectionTypeCS ::= collectionTypeIdentifierCS ( typeCS ERROR_TOKEN
			//
			case 288: {
				
				reportErrorTokenMessage(dtParser.getToken(4), OCLParserErrors.MISSING_RPAREN);
				CollectionTypeCS result = (CollectionTypeCS)dtParser.getSym(1); 
				result.setTypeCS((TypeCS)dtParser.getSym(3));
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 289:  enumLiteralExpCS ::= pathNameCS :: ERROR_SimpleNameCS
			//
			case 289: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
				CSTNode result = createEnumLiteralExpCS(
						pathNameCS,
						simpleNameCS
					);
				setOffsets(result, pathNameCS, simpleNameCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 290:  operationCallExpCS_B ::= dotArrowExpCS -> ERROR_SimpleNameCS ( argumentsCSopt )
			//
			case 290: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CallExpCS result = createArrowOperationCallExpCS(
						source,
						(SimpleNameCS)dtParser.getSym(3),
						(IsMarkedPreCS)null,
						(EList)dtParser.getSym(5)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 291:  operationCallExpCS_CE ::= dotArrowExpCS . ERROR_SimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 291: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CallExpCS result = createDotOperationCallExpCS(
						source,
						null,
						(SimpleNameCS)dtParser.getSym(3),
						(IsMarkedPreCS)dtParser.getSym(4),
						(EList)dtParser.getSym(6)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 292:  operationCallExpCS_CE ::= dotArrowExpCS . operationOrNotReservedSimpleNameCS ERROR_IsMarkedPreCS ( argumentsCSopt )
			//
			case 292: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CallExpCS result = createDotOperationCallExpCS(
						source,
						null,
						(SimpleNameCS)dtParser.getSym(3),
						(IsMarkedPreCS)dtParser.getSym(4),
						(EList)dtParser.getSym(6)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 293:  operationCallExpCS_DF ::= notReservedSimpleNameCS ERROR_IsMarkedPreCS ( argumentsCSopt )
			//
			case 293: {
				
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
			// Rule 294:  operationCallExpCS_G ::= pathNameCS :: ERROR_SimpleNameCS ( argumentsCSopt )
			//
			case 294: {
				
				OperationCallExpCS result = createDotOperationCallExpCS(
						null,
						(PathNameCS)dtParser.getSym(1),
						(SimpleNameCS)dtParser.getSym(3),
						null,
						(EList)dtParser.getSym(5)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 295:  operationCallExpCS_IJ ::= dotArrowExpCS . qualifiedPathNameCS ERROR_IsMarkedPreCS ( argumentsCSopt )
			//
			case 295: {
				
				PathNameCS pathName = (PathNameCS)dtParser.getSym(3);
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CallExpCS result = createDotOperationCallExpCS(
						source,
						pathName,
						removeLastSimpleNameCS(pathName),
						(IsMarkedPreCS)dtParser.getSym(4),
						(EList)dtParser.getSym(6)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 296:  operationCallExpCS_IJ ::= dotArrowExpCS . pathNameCS :: ERROR_SimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 296: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CallExpCS result = createDotOperationCallExpCS(
						source,
						(PathNameCS)dtParser.getSym(3),
						(SimpleNameCS)dtParser.getSym(5),
						(IsMarkedPreCS)dtParser.getSym(6),
						(EList)dtParser.getSym(8)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(9)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 297:  ifExpCS ::= if oclExpressionCS then oclExpressionCS else oclExpressionCS ERROR_TOKEN
			//
			case 297: {
				
				reportErrorTokenMessage(dtParser.getToken(7), OCLParserErrors.MISSING_ENDIF);
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
			// Rule 298:  ifExpCS ::= if oclExpressionCS then oclExpressionCS ERROR_TOKEN
			//
			case 298: {
				
				reportErrorTokenMessage(dtParser.getToken(5), OCLParserErrors.MISSING_ELSE_ENDIF);
				CSTNode result = createIfExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4),
						createInvalidLiteralExpCS(getTokenText(dtParser.getToken(5)))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 299:  ifExpCS ::= if oclExpressionCS ERROR_TOKEN
			//
			case 299: {
				
				reportErrorTokenMessage(dtParser.getToken(3), OCLParserErrors.MISSING_THEN_ELSE_ENDIF);
				CSTNode result = createIfExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						createInvalidLiteralExpCS(getTokenText(dtParser.getToken(3))),
						createInvalidLiteralExpCS(getTokenText(dtParser.getToken(3)))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 300:  ifExpCS ::= if ERROR_TOKEN endif
			//
			case 300: {
				
				reportErrorTokenMessage(dtParser.getToken(3), OCLParserErrors.MISSING_THEN_ELSE);
				CSTNode result = createIfExpCS(
						createInvalidLiteralExpCS(getTokenText(dtParser.getToken(2))),
						createInvalidLiteralExpCS(getTokenText(dtParser.getToken(2))),
						createInvalidLiteralExpCS(getTokenText(dtParser.getToken(2)))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 301:  oclMessageExpCS ::= dotArrowExpCS ^ simpleNameCS ERROR_TOKEN
			//
			case 301:
 
			//
			// Rule 302:  oclMessageExpCS ::= dotArrowExpCS ^^ simpleNameCS ERROR_TOKEN
			//
			case 302: {
				
				reportErrorTokenMessage(dtParser.getToken(2), OCLParserErrors.MISSING_MESSAGE_ARGUMENTS);
				OCLExpressionCS target = (OCLExpressionCS)dtParser.getSym(1);
				MessageExpCS result = createMessageExpCS(
						target,
						getIToken(dtParser.getToken(2)).getKind() == OCLBacktrackingParsersym.TK_CARET,
						(SimpleNameCS)dtParser.getSym(3),
						new BasicEList<OCLMessageArgCS>()
					);
				setOffsets(result, target, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 303:  oclMessageExpCS ::= dotArrowExpCS ^ ERROR_SimpleNameCS
			//
			case 303:
 
			//
			// Rule 304:  oclMessageExpCS ::= dotArrowExpCS ^^ ERROR_SimpleNameCS
			//
			case 304: {
				
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
				OCLExpressionCS target = (OCLExpressionCS)dtParser.getSym(1);
				MessageExpCS result = createMessageExpCS(
						target,
						getIToken(dtParser.getToken(2)).getKind() == OCLBacktrackingParsersym.TK_CARET,
						simpleNameCS,
						new BasicEList<OCLMessageArgCS>()
					);
				setOffsets(result, target, simpleNameCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 305:  oclExpCS ::= ERROR_TOKEN
			//
			case 305: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_EXPR);
				CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 306:  oclExpCS ::= ( oclExpressionCS ERROR_TOKEN
			//
			case 306: {
				
				reportErrorTokenMessage(dtParser.getToken(3), OCLParserErrors.MISSING_RPAREN);
				CSTNode result = (CSTNode)dtParser.getSym(2);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 307:  operationCS1 ::= notReservedSimpleNameCS ( variableListCSopt ) ERROR_Colon
			//
			case 307: {
				
				CSTNode result = createOperationCS(
						getTokenText(dtParser.getToken(1)),
						(EList)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 308:  operationCS1 ::= notReservedSimpleNameCS ( variableListCSopt ERROR_TOKEN
			//
			case 308: {
				
				reportErrorTokenMessage(dtParser.getToken(4), OCLParserErrors.MISSING_RPAREN);
				CSTNode result = createOperationCS(
						getTokenText(dtParser.getToken(1)),
						(EList)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 309:  operationCS1 ::= notReservedSimpleNameCS ERROR_TOKEN
			//
			case 309: {
				
				reportErrorTokenMessage(dtParser.getToken(2), OCLParserErrors.MISSING_LPAREN);
				CSTNode result = createOperationCS(
						getTokenText(dtParser.getToken(1)),
						new BasicEList(),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 310:  operationCS1 ::= ERROR_TOKEN
			//
			case 310: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_IDENTIFIER);
				CSTNode result = createOperationCS(
						getTokenText(dtParser.getToken(1)),
						new BasicEList(),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 311:  operationCS2 ::= qualifiedPathNameCS ( variableListCSopt ) ERROR_Colon
			//
			case 311: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				CSTNode result = createOperationCS(
						pathNameCS,
						removeLastSimpleNameCS(pathNameCS),
						(EList)dtParser.getSym(3),
						null
					);
				setOffsets(result, pathNameCS, getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 312:  operationCS2 ::= qualifiedPathNameCS ( variableListCSopt ERROR_TOKEN
			//
			case 312: {
				
				reportErrorTokenMessage(dtParser.getToken(6), OCLParserErrors.MISSING_RPAREN);
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				CSTNode result = createOperationCS(
						pathNameCS,
						removeLastSimpleNameCS(pathNameCS),
						(EList)dtParser.getSym(3),
						null
					);
				setOffsets(result, pathNameCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 313:  operationCS2 ::= qualifiedPathNameCS ERROR_TOKEN
			//
			case 313: {
				
				reportErrorTokenMessage(dtParser.getToken(4), OCLParserErrors.MISSING_LPAREN);
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				CSTNode result = createOperationCS(
						pathNameCS,
						removeLastSimpleNameCS(pathNameCS),
						new BasicEList(),
						null
					);
				setOffsets(result, pathNameCS, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 314:  operationCS2 ::= pathNameCS :: ERROR_SimpleNameCS
			//
			case 314: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
				CSTNode result = createOperationCS(
						pathNameCS,
						simpleNameCS,
						new BasicEList(),
						null
					);
				setOffsets(result, pathNameCS, simpleNameCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 315:  parametersCS ::= ERROR_TOKEN
			//
			case 315: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_PARAMETERS);
				EList result = new BasicEList();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 316:  parametersCS ::= parametersCS , ERROR_TOKEN
			//
			case 316: {
				
				reportErrorTokenMessage(dtParser.getToken(3), OCLParserErrors.MISSING_PARAMETER);
	  		  break;
			}
	 
			//
			// Rule 319:  tupleLiteralExpCS ::= Tuple ERROR_TOKEN
			//
			case 319: {
				
				reportErrorTokenMessage(dtParser.getToken(7), OCLParserErrors.MISSING_LBRACE);
				CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 320:  variableListCS ::= ERROR_TOKEN
			//
			case 320:
 
			//
			// Rule 321:  variableListCS2 ::= ERROR_TOKEN
			//
			case 321: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_VARIABLES);
				EList result = new BasicEList();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 322:  classifierContextDeclCS ::= context pathNameCS ERROR_TOKEN
			//
			case 322: {
				
				reportErrorTokenMessage(dtParser.getToken(3), OCLParserErrors.MISSING_INV_OR_DEF);
				CSTNode result = createClassifierContextDeclCS(
						(PathNameCS)dtParser.getSym(2),
						new BasicEList<InvOrDefCS>()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 323:  defExpressionCS ::= typedVariableCS ERROR_TOKEN
			//
			case 323: {
				
				reportErrorTokenMessage(dtParser.getToken(2), OCLParserErrors.MISSING_EQUALS);
				VariableCS variableCS = (VariableCS)dtParser.getSym(1);
				CSTNode result = createDefExpressionCS(
						variableCS,
						null,
						null
					);
				setOffsets(result, variableCS, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 324:  defExpressionCS ::= IDENTIFIER ERROR_Colon
			//
			case 324: {
				
				VariableCS variableCS = createVariableCS(getTokenText(dtParser.getToken(1)));
				setOffsets(variableCS, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				CSTNode result = createDefExpressionCS(
						variableCS,
						null,
						null
					);
				setOffsets(result, variableCS, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 325:  initOrDerValueCS ::= init ERROR_Colon
			//
			case 325: {
				
				CSTNode result = createInitValueCS(null);
				setOffsets(result, getIToken(dtParser.getToken(2)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 326:  initOrDerValueCS ::= derive ERROR_Colon
			//
			case 326: {
				
				CSTNode result = createDerValueCS(null);
				setOffsets(result, getIToken(dtParser.getToken(2)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 327:  invOrDefCS ::= inv simpleNameCS ERROR_Colon
			//
			case 327: {
				
				CSTNode result = createInvCS(
						(SimpleNameCS)dtParser.getSym(2),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 328:  invOrDefCS ::= def simpleNameCS ERROR_Colon
			//
			case 328: {
				
				CSTNode result = createDefCS(
						(SimpleNameCS)dtParser.getSym(2),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 329:  packageDeclarationCS ::= package pathNameCS contextDeclCSmopt ERROR_Empty endpackage
			//
			case 329: {
				
				CSTNode result = createPackageDeclarationCS(
						(PathNameCS)dtParser.getSym(2),
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 330:  packageDeclarationCS ::= package pathNameCS contextDeclCSmopt ERROR_TOKEN
			//
			case 330: {
				
				reportErrorTokenMessage(dtParser.getToken(4), OCLParserErrors.MISSING_ENDPACKAGE);
				CSTNode result = createPackageDeclarationCS(
						(PathNameCS)dtParser.getSym(2),
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 331:  packageDeclarationCS ::= package ERROR_PathNameCS
			//
			case 331: {
				
				CSTNode result = createPackageDeclarationCS(
						(PathNameCS)dtParser.getSym(2),
						new BasicEList()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 332:  prePostOrBodyDeclCS ::= pre simpleNameCS ERROR_Colon
			//
			case 332: {
				
				CSTNode result = createPrePostOrBodyDeclCS(
						PrePostOrBodyEnum.PRE_LITERAL,
						(SimpleNameCS)dtParser.getSym(2),
						createInvalidLiteralExpCS(getTokenText(dtParser.getToken(3)))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 333:  prePostOrBodyDeclCS ::= post simpleNameCS ERROR_Colon
			//
			case 333: {
				
				CSTNode result = createPrePostOrBodyDeclCS(
						PrePostOrBodyEnum.POST_LITERAL,
						(SimpleNameCS)dtParser.getSym(2),
						createInvalidLiteralExpCS(getTokenText(dtParser.getToken(3)))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 334:  prePostOrBodyDeclCS ::= body simpleNameCS ERROR_Colon
			//
			case 334: {
				
				CSTNode result = createPrePostOrBodyDeclCS(
						PrePostOrBodyEnum.BODY_LITERAL,
						(SimpleNameCS)dtParser.getSym(2),
						createInvalidLiteralExpCS(getTokenText(dtParser.getToken(3)))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 335:  propertyContextCS ::= context pathNameCS :: ERROR_SimpleNameCS
			//
			case 335: {
				
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(4);
				CSTNode result = createPropertyContextCS(
						(PathNameCS)dtParser.getSym(2),
						simpleNameCS,
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), simpleNameCS);
				dtParser.setSym1(result);
	  		  break;
			}
	
	
			default:
				break;
		}
		return;
	}
}

