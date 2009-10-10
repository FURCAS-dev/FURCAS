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
* $Id: OCLBacktrackingParser.java,v 1.11 2009/10/10 11:49:57 ewillink Exp $
*/

package org.eclipse.ocl.parser.backtracking;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
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
			// Rule 127:  oclExpCS ::= ( oclExpressionCS )
			//
			case 127: {
				
				CSTNode result = (CSTNode)dtParser.getSym(2);
				if (result instanceof OperationCallExpCS) {
					((OperationCallExpCS)result).setIsAtomic(true);
				}
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 128:  associationClassCallExpCS ::= notLiteralNorReservedSimpleNameCS isMarkedPreCSopt
			//
			case 128: {
				
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
			// Rule 129:  associationClassCallExpCS ::= notReservedSimpleNameCS [ argumentsCS ] isMarkedPreCSopt
			//
			case 129: {
				
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
			// Rule 131:  simpleIdentifierCS ::= self
			//
			case 131: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.SELF_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 132:  simpleIdentifierCS ::= IDENTIFIER
			//
			case 132: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 133:  primitiveTypeCS ::= Integer
			//
			case 133: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INTEGER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 134:  primitiveTypeCS ::= UnlimitedNatural
			//
			case 134: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 135:  primitiveTypeCS ::= String
			//
			case 135: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.STRING_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 136:  primitiveTypeCS ::= Real
			//
			case 136: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.REAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 137:  primitiveTypeCS ::= Boolean
			//
			case 137: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.BOOLEAN_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 138:  primitiveTypeCS ::= OclAny
			//
			case 138: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_ANY_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 139:  primitiveTypeCS ::= OclVoid
			//
			case 139: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_VOID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 140:  primitiveTypeCS ::= OclInvalid
			//
			case 140: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_INVALID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 141:  primitiveTypeCS ::= OclMessage
			//
			case 141: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_MESSAGE_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 142:  pathNameCS ::= notReservedSimpleNameCS
			//
			case 142: {
				
				SimpleNameCS simpleName = (SimpleNameCS)dtParser.getSym(1);
				PathNameCS result = createPathNameCS(simpleName);
				setOffsets(result, simpleName);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 143:  qualifiedPathNameCS ::= pathNameCS :: notReservedSimpleNameCS
			//
			case 143: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				SimpleNameCS simpleName = (SimpleNameCS)dtParser.getSym(3);
				result = extendPathNameCS(result, simpleName);
				setOffsets(result, result, simpleName);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 151:  enumLiteralExpCS ::= qualifiedPathNameCS
			//
			case 151: {
				
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
			// Rule 152:  collectionLiteralExpCS ::= collectionTypeIdentifierCS { collectionLiteralPartsCSopt }
			//
			case 152: {
				
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
			// Rule 153:  collectionTypeIdentifierCS ::= Set
			//
			case 153: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.SET_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 154:  collectionTypeIdentifierCS ::= Bag
			//
			case 154: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.BAG_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 155:  collectionTypeIdentifierCS ::= Sequence
			//
			case 155: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.SEQUENCE_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 156:  collectionTypeIdentifierCS ::= Collection
			//
			case 156: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.COLLECTION_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 157:  collectionTypeIdentifierCS ::= OrderedSet
			//
			case 157: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 158:  collectionLiteralPartsCSopt ::= $Empty
			//
			case 158:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 160:  collectionLiteralPartsCS ::= collectionLiteralPartCS
			//
			case 160: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 161:  collectionLiteralPartsCS ::= collectionLiteralPartsCS , collectionLiteralPartCS
			//
			case 161: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 163:  collectionLiteralPartCS ::= oclExpressionCS
			//
			case 163: {
				
				CSTNode result = createCollectionLiteralPartCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 164:  collectionRangeCS ::= oclExpressionCS .. oclExpressionCS
			//
			case 164: {
				
				CSTNode result = createCollectionRangeCS(
						(OCLExpressionCS)dtParser.getSym(1),
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 170:  tupleLiteralExpCS ::= Tuple { variableListCS2 }
			//
			case 170: {
				
				CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 171:  integerLiteralExpCS ::= INTEGER_LITERAL
			//
			case 171: {
				
				CSTNode result = createIntegerLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 172:  unlimitedNaturalLiteralExpCS ::= *
			//
			case 172: {
				
				CSTNode result = createUnlimitedNaturalLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 173:  realLiteralExpCS ::= REAL_LITERAL
			//
			case 173: {
				
				CSTNode result = createRealLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 174:  stringLiteralExpCS ::= STRING_LITERAL
			//
			case 174: {
				
				IToken literalToken = getIToken(dtParser.getToken(1));
				StringLiteralExpCS result = createStringLiteralExpCS(literalToken.toString());
				result.setUnescapedStringSymbol(unescape(literalToken));
				setOffsets(result, literalToken);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 175:  booleanLiteralExpCS ::= true
			//
			case 175: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 176:  booleanLiteralExpCS ::= false
			//
			case 176: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 177:  nullLiteralExpCS ::= null
			//
			case 177: {
				
				CSTNode result = createNullLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 178:  invalidLiteralExpCS ::= invalid
			//
			case 178: {
				
				CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 186:  iteratorExpCS ::= dotArrowExpCS -> iteratorNameCS ( oclExpressionCS )
			//
			case 186: {
				
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
			// Rule 187:  iteratorExpCS ::= dotArrowExpCS -> iteratorNameCS ( variableCS | oclExpressionCS )
			//
			case 187: {
				
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
			// Rule 188:  iteratorExpCS ::= dotArrowExpCS -> iteratorNameCS ( variableCS , variableCS | oclExpressionCS )
			//
			case 188: {
				
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
			// Rule 189:  iterateExpCS ::= dotArrowExpCS -> iterateNameCS ( variableCS | oclExpressionCS )
			//
			case 189: {
				
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
			// Rule 190:  iterateExpCS ::= dotArrowExpCS -> iterateNameCS ( variableCS ; variableCS | oclExpressionCS )
			//
			case 190: {
				
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
			// Rule 191:  variableNameCS ::= booleanLiteralExpCS
			//
			case 191:
 
			//
			// Rule 192:  variableNameCS ::= invalidLiteralExpCS
			//
			case 192:
 
			//
			// Rule 193:  variableNameCS ::= nullLiteralExpCS
			//
			case 193:
 
			//
			// Rule 194:  variableNameCS ::= notLiteralNorReservedSimpleNameCS
			//
			case 194: {
				
				SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
				CSTNode result = createVariableCS(name.getValue());
				setOffsets(result, name);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 195:  typedVariableCS ::= variableNameCS : typeCS
			//
			case 195: {
				
				VariableCS result = (VariableCS)dtParser.getSym(1);
				TypeCS type = (TypeCS)dtParser.getSym(3);
				result.setTypeCS(type);
				setOffsets(result, result, type);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 199:  variableCS2 ::= variableNameCS = oclExpressionCS
			//
			case 199:
 
			//
			// Rule 200:  variableCS ::= typedVariableCS = oclExpressionCS
			//
			case 200: {
				
				VariableCS result = (VariableCS)dtParser.getSym(1);
				OCLExpressionCS initExpression = (OCLExpressionCS)dtParser.getSym(3);
				result.setInitExpression(initExpression);
				setOffsets(result, result, initExpression);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 201:  typeCSopt ::= $Empty
			//
			case 201:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 206:  typeCS ::= notReservedSimpleNameCS
			//
			case 206: {
				
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
			// Rule 207:  collectionTypeCS ::= collectionTypeIdentifierCS ( typeCS )
			//
			case 207: {
				
				CollectionTypeCS result = (CollectionTypeCS)dtParser.getSym(1);
				result.setTypeCS((TypeCS)dtParser.getSym(3));
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 208:  tupleTypeCS ::= Tuple ( variableListCSopt )
			//
			case 208: {
				
				CSTNode result = createTupleTypeCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 209:  variableListCSopt ::= $Empty
			//
			case 209:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 211:  variableListCS2 ::= variableCS2
			//
			case 211:
 
			//
			// Rule 212:  variableListCS ::= variableCS
			//
			case 212: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 213:  variableListCS2 ::= variableListCS2 , variableCS2
			//
			case 213:
 
			//
			// Rule 214:  variableListCS ::= variableListCS , variableCS
			//
			case 214: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 215:  operationCallExpCS_B ::= dotArrowExpCS -> notIteratorNorReservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 215: {
				
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
			// Rule 216:  operationCallExpCS_CE ::= dotArrowExpCS . operationOrNotReservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 216: {
				
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
			// Rule 217:  operationCallExpCS_DF ::= notReservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 217: {
				
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
			// Rule 218:  operationCallExpCS_G ::= qualifiedPathNameCS ( argumentsCSopt )
			//
			case 218: {
				
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
			// Rule 219:  operationCallExpCS_IJ ::= dotArrowExpCS . qualifiedPathNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 219: {
				
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
			// Rule 220:  propertyCallExpCS ::= dotArrowExpCS . notReservedSimpleNameCS isMarkedPreCSopt
			//
			case 220: {
				
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
			// Rule 221:  propertyCallExpCS ::= dotArrowExpCS . notReservedSimpleNameCS [ argumentsCS ] isMarkedPreCSopt
			//
			case 221: {
				
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
			// Rule 222:  isMarkedPreCSopt ::= $Empty
			//
			case 222: {
				
				dtParser.setSym1(null);
	  		  break;
			}
	 
			//
			// Rule 223:  isMarkedPreCSopt ::= @pre
			//
			case 223: {
				
				CSTNode result = createIsMarkedPreCS();
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 224:  argumentsCSopt ::= $Empty
			//
			case 224:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 226:  argumentsCS ::= oclExpressionCS
			//
			case 226: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 227:  argumentsCS ::= argumentsCS , oclExpressionCS
			//
			case 227: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 228:  letExpCS ::= let variableListCS in oclExpressionCS
			//
			case 228: {
				
				CSTNode result = createLetExpCS(
						(EList)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 229:  ifExpCS ::= if oclExpressionCS then oclExpressionCS else oclExpressionCS endif
			//
			case 229: {
				
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
			// Rule 230:  oclMessageExpCS ::= dotArrowExpCS ^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 230:
 
			//
			// Rule 231:  oclMessageExpCS ::= dotArrowExpCS ^^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 231: {
				
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
			// Rule 232:  oclMessageArgumentsCSopt ::= $Empty
			//
			case 232:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 234:  oclMessageArgumentsCS ::= oclMessageArgCS
			//
			case 234: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 235:  oclMessageArgumentsCS ::= oclMessageArgumentsCS , oclMessageArgCS
			//
			case 235: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 236:  oclMessageArgCS ::= oclExpressionCS
			//
			case 236: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 237:  oclMessageArgCS ::= ?
			//
			case 237: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 238:  oclMessageArgCS ::= ? : typeCS
			//
			case 238: {
				
				CSTNode result = createOCLMessageArgCS(
						(TypeCS)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 247:  packageDeclarationCSm ::= packageDeclarationCSm packageDeclarationCS
			//
			case 247: {
				
				PackageDeclarationCS result = (PackageDeclarationCS)dtParser.getSym(2);
				result.setPackageDeclarationCS((PackageDeclarationCS) dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 248:  packageDeclarationCS ::= package pathNameCS contextDeclCSmopt endpackage
			//
			case 248: {
				
				CSTNode result = createPackageDeclarationCS(
						(PathNameCS)dtParser.getSym(2),
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 249:  packageDeclarationCS1 ::= contextDeclCSm
			//
			case 249: {
				
				EList contextDecls = (EList)dtParser.getSym(1);
				CSTNode result = createPackageDeclarationCS(null, contextDecls);
				if (!contextDecls.isEmpty()) {
					setOffsets(result, (CSTNode)contextDecls.get(0), (CSTNode)contextDecls.get(contextDecls.size()-1));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 250:  contextDeclCSmopt ::= $Empty
			//
			case 250:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 252:  contextDeclCSm ::= contextDeclCS
			//
			case 252: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 253:  contextDeclCSm ::= contextDeclCSm contextDeclCS
			//
			case 253: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 257:  propertyContextCS ::= context qualifiedPathNameCS : typeCS initOrDerValueCSm
			//
			case 257: {
				
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
			// Rule 258:  initOrDerValueCSm ::= initOrDerValueCS
			//
			case 258: {
				
				EList<InitOrDerValueCS> result = new BasicEList<InitOrDerValueCS>();
				result.add((InitOrDerValueCS)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 259:  initOrDerValueCSm ::= initOrDerValueCSm initOrDerValueCS
			//
			case 259: {
				
				EList<InitOrDerValueCS> result = (EList<InitOrDerValueCS>)dtParser.getSym(1);
				result.add((InitOrDerValueCS)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 260:  initOrDerValueCS ::= init : oclExpressionCS
			//
			case 260: {
				
				CSTNode result = createInitValueCS((OCLExpressionCS)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 261:  initOrDerValueCS ::= derive : oclExpressionCS
			//
			case 261: {
				
				CSTNode result = createDerValueCS((OCLExpressionCS)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 262:  classifierContextDeclCS ::= context pathNameCS invOrDefCSm
			//
			case 262: {
				
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
			// Rule 263:  invOrDefCSm ::= invOrDefCS
			//
			case 263: {
				
				EList<InvOrDefCS> result = new BasicEList<InvOrDefCS>();
				result.add((InvOrDefCS)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 264:  invOrDefCSm ::= invOrDefCSm invOrDefCS
			//
			case 264: {
				
				EList<InvOrDefCS> result = (EList<InvOrDefCS>)dtParser.getSym(1);
				result.add((InvOrDefCS)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 265:  invOrDefCS ::= inv simpleNameCSopt : oclExpressionCS
			//
			case 265: {
				
				CSTNode result = createInvCS(
						(SimpleNameCS)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 266:  defCS ::= def simpleNameCSopt : defExpressionCS
			//
			case 266: {
				
				DefCS result = createDefCS(
						(SimpleNameCS)dtParser.getSym(2),
						(DefExpressionCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 268:  invOrDefCS ::= static defCS
			//
			case 268: {
				
				DefCS result = (DefCS)dtParser.getSym(2);
				result.setStatic(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 269:  defExpressionCS ::= typedVariableCS = oclExpressionCS
			//
			case 269: {
				
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
			// Rule 270:  defExpressionCS ::= operationCS1 = oclExpressionCS
			//
			case 270: {
				
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
			// Rule 271:  operationContextDeclCS ::= context operationCS2 prePostOrBodyDeclCSm
			//
			case 271: {
				
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
			// Rule 272:  prePostOrBodyDeclCSm ::= prePostOrBodyDeclCS
			//
			case 272: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 273:  prePostOrBodyDeclCSm ::= prePostOrBodyDeclCSm prePostOrBodyDeclCS
			//
			case 273: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 274:  prePostOrBodyDeclCS ::= pre simpleNameCSopt : oclExpressionCS
			//
			case 274: {
				
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
			// Rule 275:  prePostOrBodyDeclCS ::= post simpleNameCSopt : oclExpressionCS
			//
			case 275: {
				
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
			// Rule 276:  prePostOrBodyDeclCS ::= body simpleNameCSopt : oclExpressionCS
			//
			case 276: {
				
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
			// Rule 277:  ERROR_Colon ::= ERROR_TOKEN
			//
			case 277: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_COLON);
	  		  break;
			}
	 
			//
			// Rule 278:  ERROR_Empty ::= ERROR_TOKEN
			//
			case 278: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.EXTRA_TOKENS);
	  		  break;
			}
	 
			//
			// Rule 279:  ERROR_IsMarkedPreCS ::= ERROR_TOKEN
			//
			case 279: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_AT_PRE);
				dtParser.setSym1(null);
	  		  break;
			}
	 
			//
			// Rule 280:  ERROR_PathNameCS ::= ERROR_TOKEN
			//
			case 280: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_PATH_NAME);
				CSTNode result = createPathNameCS(createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText(dtParser.getToken(1))));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 281:  ERROR_SimpleNameCS ::= ERROR_TOKEN
			//
			case 281: {
				
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
			// Rule 282:  associationClassCallExpCS ::= notReservedSimpleNameCS [ argumentsCS ERROR_TOKEN
			//
			case 282: {
				
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
			// Rule 283:  propertyCallExpCS ::= dotArrowExpCS . notReservedSimpleNameCS [ argumentsCS ERROR_TOKEN
			//
			case 283: {
				
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
			// Rule 284:  propertyCallExpCS ::= dotArrowExpCS . ERROR_SimpleNameCS [ argumentsCS ] isMarkedPreCSopt
			//
			case 284: {
				
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
			// Rule 285:  collectionTypeCS ::= collectionTypeIdentifierCS ( typeCS ERROR_TOKEN
			//
			case 285: {
				
				reportErrorTokenMessage(dtParser.getToken(4), OCLParserErrors.MISSING_RPAREN);
				CollectionTypeCS result = (CollectionTypeCS)dtParser.getSym(1); 
				result.setTypeCS((TypeCS)dtParser.getSym(3));
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 286:  enumLiteralExpCS ::= pathNameCS :: ERROR_SimpleNameCS
			//
			case 286: {
				
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
			// Rule 287:  operationCallExpCS_B ::= dotArrowExpCS -> ERROR_SimpleNameCS ( argumentsCSopt )
			//
			case 287: {
				
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
			// Rule 288:  operationCallExpCS_CE ::= dotArrowExpCS . ERROR_SimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 288: {
				
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
			// Rule 289:  operationCallExpCS_CE ::= dotArrowExpCS . operationOrNotReservedSimpleNameCS ERROR_IsMarkedPreCS ( argumentsCSopt )
			//
			case 289: {
				
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
			// Rule 290:  operationCallExpCS_DF ::= notReservedSimpleNameCS ERROR_IsMarkedPreCS ( argumentsCSopt )
			//
			case 290: {
				
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
			// Rule 291:  operationCallExpCS_G ::= pathNameCS :: ERROR_SimpleNameCS ( argumentsCSopt )
			//
			case 291: {
				
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
			// Rule 292:  operationCallExpCS_IJ ::= dotArrowExpCS . qualifiedPathNameCS ERROR_IsMarkedPreCS ( argumentsCSopt )
			//
			case 292: {
				
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
			// Rule 293:  operationCallExpCS_IJ ::= dotArrowExpCS . pathNameCS :: ERROR_SimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 293: {
				
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
			// Rule 294:  ifExpCS ::= if oclExpressionCS then oclExpressionCS else oclExpressionCS ERROR_TOKEN
			//
			case 294: {
				
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
			// Rule 295:  ifExpCS ::= if oclExpressionCS then oclExpressionCS ERROR_TOKEN
			//
			case 295: {
				
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
			// Rule 296:  ifExpCS ::= if oclExpressionCS ERROR_TOKEN
			//
			case 296: {
				
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
			// Rule 297:  ifExpCS ::= if ERROR_TOKEN endif
			//
			case 297: {
				
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
			// Rule 298:  oclMessageExpCS ::= dotArrowExpCS ^ simpleNameCS ERROR_TOKEN
			//
			case 298:
 
			//
			// Rule 299:  oclMessageExpCS ::= dotArrowExpCS ^^ simpleNameCS ERROR_TOKEN
			//
			case 299: {
				
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
			// Rule 300:  oclMessageExpCS ::= dotArrowExpCS ^ ERROR_SimpleNameCS
			//
			case 300:
 
			//
			// Rule 301:  oclMessageExpCS ::= dotArrowExpCS ^^ ERROR_SimpleNameCS
			//
			case 301: {
				
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
			// Rule 302:  oclExpCS ::= ERROR_TOKEN
			//
			case 302: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_EXPR);
				CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 303:  oclExpCS ::= ( oclExpressionCS ERROR_TOKEN
			//
			case 303: {
				
				reportErrorTokenMessage(dtParser.getToken(3), OCLParserErrors.MISSING_RPAREN);
				CSTNode result = (CSTNode)dtParser.getSym(2);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 304:  operationCS1 ::= notReservedSimpleNameCS ( variableListCSopt ) ERROR_Colon
			//
			case 304: {
				
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
			// Rule 305:  operationCS1 ::= notReservedSimpleNameCS ( variableListCSopt ERROR_TOKEN
			//
			case 305: {
				
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
			// Rule 306:  operationCS1 ::= notReservedSimpleNameCS ERROR_TOKEN
			//
			case 306: {
				
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
			// Rule 307:  operationCS1 ::= ERROR_TOKEN
			//
			case 307: {
				
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
			// Rule 308:  operationCS2 ::= qualifiedPathNameCS ( variableListCSopt ) ERROR_Colon
			//
			case 308: {
				
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
			// Rule 309:  operationCS2 ::= qualifiedPathNameCS ( variableListCSopt ERROR_TOKEN
			//
			case 309: {
				
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
			// Rule 310:  operationCS2 ::= qualifiedPathNameCS ERROR_TOKEN
			//
			case 310: {
				
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
			// Rule 311:  operationCS2 ::= pathNameCS :: ERROR_SimpleNameCS
			//
			case 311: {
				
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
			// Rule 312:  parametersCS ::= ERROR_TOKEN
			//
			case 312: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_PARAMETERS);
				EList result = new BasicEList();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 313:  parametersCS ::= parametersCS , ERROR_TOKEN
			//
			case 313: {
				
				reportErrorTokenMessage(dtParser.getToken(3), OCLParserErrors.MISSING_PARAMETER);
	  		  break;
			}
	 
			//
			// Rule 316:  tupleLiteralExpCS ::= Tuple ERROR_TOKEN
			//
			case 316: {
				
				reportErrorTokenMessage(dtParser.getToken(7), OCLParserErrors.MISSING_LBRACE);
				CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 317:  variableListCS ::= ERROR_TOKEN
			//
			case 317:
 
			//
			// Rule 318:  variableListCS2 ::= ERROR_TOKEN
			//
			case 318: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_VARIABLES);
				EList result = new BasicEList();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 319:  classifierContextDeclCS ::= context pathNameCS ERROR_TOKEN
			//
			case 319: {
				
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
			// Rule 320:  defExpressionCS ::= typedVariableCS ERROR_TOKEN
			//
			case 320: {
				
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
			// Rule 321:  defExpressionCS ::= IDENTIFIER ERROR_Colon
			//
			case 321: {
				
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
			// Rule 322:  initOrDerValueCS ::= init ERROR_Colon
			//
			case 322: {
				
				CSTNode result = createInitValueCS(null);
				setOffsets(result, getIToken(dtParser.getToken(2)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 323:  initOrDerValueCS ::= derive ERROR_Colon
			//
			case 323: {
				
				CSTNode result = createDerValueCS(null);
				setOffsets(result, getIToken(dtParser.getToken(2)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 324:  invOrDefCS ::= inv simpleNameCS ERROR_Colon
			//
			case 324: {
				
				CSTNode result = createInvCS(
						(SimpleNameCS)dtParser.getSym(2),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 325:  invOrDefCS ::= def simpleNameCS ERROR_Colon
			//
			case 325: {
				
				CSTNode result = createDefCS(
						(SimpleNameCS)dtParser.getSym(2),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 326:  packageDeclarationCS ::= package pathNameCS contextDeclCSmopt ERROR_Empty endpackage
			//
			case 326: {
				
				CSTNode result = createPackageDeclarationCS(
						(PathNameCS)dtParser.getSym(2),
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 327:  packageDeclarationCS ::= package pathNameCS contextDeclCSmopt ERROR_TOKEN
			//
			case 327: {
				
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
			// Rule 328:  packageDeclarationCS ::= package ERROR_PathNameCS
			//
			case 328: {
				
				CSTNode result = createPackageDeclarationCS(
						(PathNameCS)dtParser.getSym(2),
						new BasicEList()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 329:  prePostOrBodyDeclCS ::= pre simpleNameCS ERROR_Colon
			//
			case 329: {
				
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
			// Rule 330:  prePostOrBodyDeclCS ::= post simpleNameCS ERROR_Colon
			//
			case 330: {
				
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
			// Rule 331:  prePostOrBodyDeclCS ::= body simpleNameCS ERROR_Colon
			//
			case 331: {
				
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
			// Rule 332:  propertyContextCS ::= context pathNameCS :: ERROR_SimpleNameCS
			//
			case 332: {
				
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

