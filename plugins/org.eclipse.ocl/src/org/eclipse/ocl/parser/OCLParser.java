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
*   E.D.Willink - Bugs 225493, 243976, 259818, 282882, 287993, 288040
*   Borland - Bug 242880
*
* </copyright>
*
* $Id: OCLParser.java,v 1.13 2009/10/02 20:56:31 ewillink Exp $
*/

package org.eclipse.ocl.parser;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.cst.DotOrArrowEnum;
import org.eclipse.ocl.cst.IntegerLiteralExpCS;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.cst.MessageExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OCLMessageArgCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.cst.StateExpCS;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;

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
			// Rule 46:  binaryName ::= binaryIdentifier
			//
			case 46:
 
			//
			// Rule 47:  keywordAsName ::= keywordAsIdentifier
			//
			case 47:
 
			//
			// Rule 48:  keywordAsName1 ::= keywordAsIdentifier1
			//
			case 48:
 
			//
			// Rule 49:  unaryName ::= unaryIdentifier
			//
			case 49: {
				
				SimpleNameCS result = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 50:  iterateName ::= iterate
			//
			case 50:
 
			//
			// Rule 51:  iteratorName ::= iteratorIdentifier
			//
			case 51:
 
			//
			// Rule 52:  oclIsInStateName ::= oclIsInState
			//
			case 52: {
				
				SimpleNameCS result = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 55:  operationCS1 ::= IDENTIFIER ( parametersCSopt ) : typeCSopt
			//
			case 55: {
				
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
			// Rule 56:  operationCS2 ::= pathNameCS :: simpleNameCS ( parametersCSopt ) : typeCSopt
			//
			case 56: {
				
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
			// Rule 57:  parametersCSopt ::= $Empty
			//
			case 57:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 59:  parametersCS ::= variableCS
			//
			case 59: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 60:  parametersCS ::= parametersCS , variableCS
			//
			case 60: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 61:  simpleNameCSopt ::= $Empty
			//
			case 61:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 67:  impliesExpCS ::= impliesExpCS implies xorExpCS
			//
			case 67:
 
			//
			// Rule 68:  impliesWithLet ::= impliesExpCS implies xorWithLet
			//
			case 68:
 
			//
			// Rule 71:  xorExpCS ::= xorExpCS xor orExpCS
			//
			case 71:
 
			//
			// Rule 72:  xorWithLet ::= xorExpCS xor orWithLet
			//
			case 72:
 
			//
			// Rule 75:  orExpCS ::= orExpCS or andExpCS
			//
			case 75:
 
			//
			// Rule 76:  orWithLet ::= orExpCS or andWithLet
			//
			case 76:
 
			//
			// Rule 79:  andExpCS ::= andExpCS and equalityExpCS
			//
			case 79:
 
			//
			// Rule 80:  andWithLet ::= andExpCS and equalityWithLet
			//
			case 80:
 
			//
			// Rule 83:  equalityExpCS ::= equalityExpCS = relationalExpCS
			//
			case 83:
 
			//
			// Rule 84:  equalityWithLet ::= equalityExpCS = relationalWithLet
			//
			case 84:
 
			//
			// Rule 85:  equalityExpCS ::= equalityExpCS <> relationalExpCS
			//
			case 85:
 
			//
			// Rule 86:  equalityWithLet ::= equalityExpCS <> relationalWithLet
			//
			case 86:
 
			//
			// Rule 89:  relationalExpCS ::= relationalExpCS > ifExpCSPrec
			//
			case 89:
 
			//
			// Rule 90:  relationalWithLet ::= relationalExpCS > additiveWithLet
			//
			case 90:
 
			//
			// Rule 91:  relationalExpCS ::= relationalExpCS < ifExpCSPrec
			//
			case 91:
 
			//
			// Rule 92:  relationalWithLet ::= relationalExpCS < additiveWithLet
			//
			case 92:
 
			//
			// Rule 93:  relationalExpCS ::= relationalExpCS >= ifExpCSPrec
			//
			case 93:
 
			//
			// Rule 94:  relationalWithLet ::= relationalExpCS >= additiveWithLet
			//
			case 94:
 
			//
			// Rule 95:  relationalExpCS ::= relationalExpCS <= ifExpCSPrec
			//
			case 95:
 
			//
			// Rule 96:  relationalWithLet ::= relationalExpCS <= additiveWithLet
			//
			case 96:
 
			//
			// Rule 101:  additiveExpCS ::= additiveExpCS + multiplicativeExpCS
			//
			case 101:
 
			//
			// Rule 102:  additiveWithLet ::= additiveExpCS + multiplicativeWithLet
			//
			case 102:
 
			//
			// Rule 103:  additiveExpCS ::= additiveExpCS - multiplicativeExpCS
			//
			case 103:
 
			//
			// Rule 104:  additiveWithLet ::= additiveExpCS - multiplicativeWithLet
			//
			case 104:
 
			//
			// Rule 107:  multiplicativeExpCS ::= multiplicativeExpCS * unaryExpCS
			//
			case 107:
 
			//
			// Rule 108:  multiplicativeWithLet ::= multiplicativeExpCS * unaryWithLet
			//
			case 108:
 
			//
			// Rule 109:  multiplicativeExpCS ::= multiplicativeExpCS / unaryExpCS
			//
			case 109:
 
			//
			// Rule 110:  multiplicativeWithLet ::= multiplicativeExpCS / unaryWithLet
			//
			case 110: {
				
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
			// Rule 113:  unaryExpCS ::= - unaryExpCS
			//
			case 113: {
				
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
			// Rule 114:  unaryExpCS ::= not unaryExpCS
			//
			case 114: {
				
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
			// Rule 116:  dotArrowExpCS ::= dotArrowExpCS callExpCS
			//
			case 116: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setSource((OCLExpressionCS)dtParser.getSym(1));
				setOffsets(result, (CSTNode)dtParser.getSym(1), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 117:  dotArrowExpCS ::= dotArrowExpCS messageExpCS
			//
			case 117: {
				
				MessageExpCS result = (MessageExpCS)dtParser.getSym(2);
				result.setTarget((OCLExpressionCS)dtParser.getSym(1));
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 118:  dotArrowExpCS ::= NUMERIC_OPERATION ( argumentsCSopt )
			//
			case 118: {
				
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
			// Rule 119:  dotArrowExpCS ::= pathNameCS :: simpleNameCS ( argumentsCSopt )
			//
			case 119: {
				
				OperationCallExpCS result = createOperationCallExpCS(
						(PathNameCS)dtParser.getSym(1),
						(SimpleNameCS)dtParser.getSym(3),
						(EList)dtParser.getSym(5)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(6)));
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 124:  oclExpCS ::= ( oclExpressionCS )
			//
			case 124: {
				
				CSTNode result = (CSTNode)dtParser.getSym(2);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 125:  variableExpCS ::= simpleNameCS isMarkedPreCS
			//
			case 125:
 
			//
			// Rule 126:  variableExpCS ::= keywordAsName1 isMarkedPreCS
			//
			case 126: {
				
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
			// Rule 127:  variableExpCS ::= simpleNameCS [ argumentsCS ] isMarkedPreCS
			//
			case 127:
 
			//
			// Rule 128:  variableExpCS ::= keywordAsName1 [ argumentsCS ] isMarkedPreCS
			//
			case 128: {
				
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
			// Rule 130:  simpleNameCS ::= self
			//
			case 130: {
				
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
			// Rule 142:  pathNameCS ::= simpleIdentifierCS
			//
			case 142: {
				
				SimpleNameCS simpleName = (SimpleNameCS)dtParser.getSym(1);
				PathNameCS result = createPathNameCS(simpleName);
				setOffsets(result, simpleName);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 143:  pathNameCS ::= pathNameCS :: simpleNameCS
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
			// Rule 144:  pathNameCSOpt ::= $Empty
			//
			case 144: {
				
				CSTNode result = createPathNameCS();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 152:  enumLiteralExpCS ::= pathNameCS :: keywordAsName
			//
			case 152:
 
			//
			// Rule 153:  enumLiteralExpCS ::= pathNameCS :: simpleNameCS
			//
			case 153: {
				
				CSTNode result = createEnumLiteralExpCS(
						(PathNameCS)dtParser.getSym(1),
						(SimpleNameCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 154:  collectionLiteralExpCS ::= collectionTypeIdentifierCS { collectionLiteralPartsCSopt }
			//
			case 154: {
				
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
			// Rule 155:  collectionTypeIdentifierCS ::= Set
			//
			case 155: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.SET_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 156:  collectionTypeIdentifierCS ::= Bag
			//
			case 156: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.BAG_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 157:  collectionTypeIdentifierCS ::= Sequence
			//
			case 157: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.SEQUENCE_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 158:  collectionTypeIdentifierCS ::= Collection
			//
			case 158: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.COLLECTION_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 159:  collectionTypeIdentifierCS ::= OrderedSet
			//
			case 159: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 160:  collectionLiteralPartsCSopt ::= $Empty
			//
			case 160:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 162:  collectionLiteralPartsCS ::= collectionLiteralPartCS
			//
			case 162: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 163:  collectionLiteralPartsCS ::= collectionLiteralPartsCS , collectionLiteralPartCS
			//
			case 163: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 165:  collectionLiteralPartCS ::= oclExpressionCS
			//
			case 165: {
				
				CSTNode result = createCollectionLiteralPartCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 166:  collectionRangeCS ::= - INTEGER_RANGE_START oclExpressionCS
			//
			case 166: {
				
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
			// Rule 167:  collectionRangeCS ::= INTEGER_RANGE_START oclExpressionCS
			//
			case 167: {
				
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
			// Rule 168:  collectionRangeCS ::= oclExpressionCS .. oclExpressionCS
			//
			case 168: {
				
				CSTNode result = createCollectionRangeCS(
						(OCLExpressionCS)dtParser.getSym(1),
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 174:  tupleLiteralExpCS ::= Tuple { variableListCS2 }
			//
			case 174: {
				
				CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 175:  integerLiteralExpCS ::= INTEGER_LITERAL
			//
			case 175: {
				
				CSTNode result = createIntegerLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 176:  unlimitedNaturalLiteralExpCS ::= *
			//
			case 176: {
				
				CSTNode result = createUnlimitedNaturalLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 177:  realLiteralExpCS ::= REAL_LITERAL
			//
			case 177: {
				
				CSTNode result = createRealLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 178:  stringLiteralExpCS ::= STRING_LITERAL
			//
			case 178: {
				
				IToken literalToken = getIToken(dtParser.getToken(1));
				StringLiteralExpCS result = createStringLiteralExpCS(literalToken.toString());
				result.setUnescapedStringSymbol(unescape(literalToken));
				setOffsets(result, literalToken);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 179:  booleanLiteralExpCS ::= true
			//
			case 179: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 180:  booleanLiteralExpCS ::= false
			//
			case 180: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 181:  nullLiteralExpCS ::= null
			//
			case 181: {
				
				CSTNode result = createNullLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 182:  invalidLiteralExpCS ::= invalid
			//
			case 182: {
				
				CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 183:  callExpCS ::= -> featureCallExpCS
			//
			case 183:
 
			//
			// Rule 184:  callExpCS ::= -> loopExpCS
			//
			case 184: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 185:  callExpCS ::= . keywordOperationCallExpCS
			//
			case 185:
 
			//
			// Rule 186:  callExpCS ::= . featureCallExpCS
			//
			case 186: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 189:  iteratorExpCS ::= iteratorName ( oclExpressionCS )
			//
			case 189: {
				
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
				CSTNode result = createIteratorExpCS(
						simpleNameCS,
						null,
						null,
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, simpleNameCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 190:  iteratorExpCS ::= iteratorName ( variableCS | oclExpressionCS )
			//
			case 190: {
				
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
				CSTNode result = createIteratorExpCS(
						simpleNameCS,
						(VariableCS)dtParser.getSym(3),
						null,
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, simpleNameCS, getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 191:  iteratorExpCS ::= iteratorName ( variableCS , variableCS | oclExpressionCS )
			//
			case 191: {
				
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
				CSTNode result = createIteratorExpCS(
						simpleNameCS,
						(VariableCS)dtParser.getSym(3),
						(VariableCS)dtParser.getSym(5),
						(OCLExpressionCS)dtParser.getSym(7)
					);
				setOffsets(result, simpleNameCS, getIToken(dtParser.getToken(8)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 192:  iterateExpCS ::= iterateName ( variableCS | oclExpressionCS )
			//
			case 192: {
				
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
				CSTNode result = createIterateExpCS(
						simpleNameCS,
						(VariableCS)dtParser.getSym(3),
						null,
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, simpleNameCS, getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 193:  iterateExpCS ::= iterateName ( variableCS ; variableCS | oclExpressionCS )
			//
			case 193: {
				
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
				CSTNode result = createIterateExpCS(
						simpleNameCS,
						(VariableCS)dtParser.getSym(3),
						(VariableCS)dtParser.getSym(5),
						(OCLExpressionCS)dtParser.getSym(7)
					);
				setOffsets(result, simpleNameCS, getIToken(dtParser.getToken(8)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 194:  variableCS ::= IDENTIFIER
			//
			case 194: {
				
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
			// Rule 195:  typedVariableCS ::= IDENTIFIER : typeCS
			//
			case 195: {
				
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
			// Rule 197:  variableCS ::= IDENTIFIER : typeCS = oclExpressionCS
			//
			case 197: {
				
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
			// Rule 198:  variableCS2 ::= IDENTIFIER = oclExpressionCS
			//
			case 198: {
				
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
			// Rule 199:  typeCSopt ::= $Empty
			//
			case 199:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 205:  collectionTypeCS ::= collectionTypeIdentifierCS ( typeCS )
			//
			case 205: {
				
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
			// Rule 206:  tupleTypeCS ::= Tuple ( variableListCSopt )
			//
			case 206: {
				
				CSTNode result = createTupleTypeCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 207:  variableListCSopt ::= $Empty
			//
			case 207:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 209:  variableListCS ::= variableCS
			//
			case 209: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 210:  variableListCS ::= variableListCS , variableCS
			//
			case 210: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 211:  variableListCS2 ::= variableCS2
			//
			case 211:
 
			//
			// Rule 212:  variableListCS2 ::= variableCS
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
			// Rule 214:  variableListCS2 ::= variableListCS2 , variableCS
			//
			case 214: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 217:  featureCallExpCS ::= unaryName isMarkedPreCS ( argumentsCSopt )
			//
			case 217:
 
			//
			// Rule 218:  operationCallExpCS ::= binaryName isMarkedPreCS ( argumentsCSopt )
			//
			case 218:
 
			//
			// Rule 219:  keywordOperationCallExpCS ::= keywordAsName isMarkedPreCS ( argumentsCSopt )
			//
			case 219: {
				
				CSTNode result = createOperationCallExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(IsMarkedPreCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 220:  stateExpCS ::= pathNameCSOpt
			//
			case 220: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				StateExpCS result = createStateExpCS(pathNameCS);
				setOffsets(result, pathNameCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 221:  operationCallExpCS ::= oclIsInStateName isMarkedPreCS ( stateExpCS )
			//
			case 221: {
				
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
				CSTNode result = createOperationCallExpCS(
						simpleNameCS,
						(IsMarkedPreCS)dtParser.getSym(2),
						(StateExpCS)dtParser.getSym(4)
					);
				setOffsets(result, simpleNameCS, getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 222:  attrOrNavCallExpCS ::= simpleNameCS isMarkedPreCS
			//
			case 222:
 
			//
			// Rule 223:  attrOrNavCallExpCS ::= keywordAsName isMarkedPreCS
			//
			case 223: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(2);
				CSTNode result = createFeatureCallExpCS(
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
			// Rule 224:  attrOrNavCallExpCS ::= simpleNameCS [ argumentsCS ] isMarkedPreCS
			//
			case 224: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(5);
				CSTNode result = createFeatureCallExpCS(
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
			// Rule 225:  isMarkedPreCS ::= $Empty
			//
			case 225: {
				
				dtParser.setSym1(null);
	  		  break;
			}
	 
			//
			// Rule 226:  isMarkedPreCS ::= @pre
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
			// Rule 233:  messageExpCS ::= ^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 233:
 
			//
			// Rule 234:  messageExpCS ::= ^^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 234: {
				
				CSTNode result = createMessageExpCS(
						getIToken(dtParser.getToken(1)).getKind() == OCLParsersym.TK_CARET,
						(SimpleNameCS)dtParser.getSym(2),
						(EList<OCLMessageArgCS>)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
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
			// Rule 260:  propertyContextCS ::= context pathNameCS :: simpleNameCS : typeCS initOrDerValueCSm
			//
			case 260: {
				
				EList<InitOrDerValueCS> list = (EList<InitOrDerValueCS>)dtParser.getSym(7);
				CSTNode result = createPropertyContextCS(
						(PathNameCS)dtParser.getSym(2),
						(SimpleNameCS)dtParser.getSym(4),
						(TypeCS)dtParser.getSym(6),
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
	
	
			default:
				break;
		}
		return;
	}
}

