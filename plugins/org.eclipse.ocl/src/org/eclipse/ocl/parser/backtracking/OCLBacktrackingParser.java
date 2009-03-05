/**
* <copyright>
*
* Copyright (c) 2005, 2009 IBM Corporation, Zeligsoft Inc., Borland Software Corp., and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Elimination of some shift-reduce conflicts
*   E.D.Willink - Remove unnecessary warning suppression
*   E.D.Willink - Bugs 225493, 243976, 259818
*   Zeligsoft - Bug 243976
*   Borland - Bug 242880
*
* </copyright>
*
* $Id: OCLBacktrackingParser.java,v 1.2 2009/03/05 14:12:14 cdamus Exp $
*/

package org.eclipse.ocl.parser.backtracking;

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
import lpg.lpgjavaruntime.BacktrackingParser;
import lpg.lpgjavaruntime.DiagnoseParser;
import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.Monitor;
import lpg.lpgjavaruntime.NotBacktrackParseTableException;
import lpg.lpgjavaruntime.ParseTable;
import lpg.lpgjavaruntime.RuleAction;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.cst.DefExpressionCS;
import org.eclipse.ocl.cst.InitOrDerValueCS;
import org.eclipse.ocl.cst.InvOrDefCS;
import org.eclipse.ocl.cst.OperationCS;
import org.eclipse.ocl.cst.PackageDeclarationCS;
import org.eclipse.ocl.cst.PrePostOrBodyEnum;

	import org.eclipse.ocl.parser.AbstractOCLParser;

/**
 * The backtracking variant of the OCL parser.
 * 
 * @since 1.3
 */
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
			// Rule 67:  impliesExpCS ::= impliesExpCS implies andOrXorExpCS
			//
			case 67:
 
			//
			// Rule 68:  impliesWithLet ::= impliesExpCS implies andOrXorWithLet
			//
			case 68:
 
			//
			// Rule 71:  andOrXorExpCS ::= andOrXorExpCS and equalityExpCS
			//
			case 71:
 
			//
			// Rule 72:  andOrXorExpCS ::= andOrXorExpCS or equalityExpCS
			//
			case 72:
 
			//
			// Rule 73:  andOrXorExpCS ::= andOrXorExpCS xor equalityExpCS
			//
			case 73:
 
			//
			// Rule 74:  andOrXorWithLet ::= andOrXorExpCS and equalityWithLet
			//
			case 74:
 
			//
			// Rule 75:  andOrXorWithLet ::= andOrXorExpCS or equalityWithLet
			//
			case 75:
 
			//
			// Rule 76:  andOrXorWithLet ::= andOrXorExpCS xor equalityWithLet
			//
			case 76: {
				
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
			// Rule 79:  equalityExpCS ::= equalityExpCS = relationalExpCS
			//
			case 79:
 
			//
			// Rule 80:  equalityWithLet ::= equalityExpCS = relationalWithLet
			//
			case 80: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.EQUAL)
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
			// Rule 81:  equalityExpCS ::= equalityExpCS <> relationalExpCS
			//
			case 81:
 
			//
			// Rule 82:  equalityWithLet ::= equalityExpCS <> relationalWithLet
			//
			case 82: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.NOT_EQUAL)
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
			// Rule 85:  relationalExpCS ::= relationalExpCS > ifExpCSPrec
			//
			case 85:
 
			//
			// Rule 86:  relationalWithLet ::= relationalExpCS > additiveWithLet
			//
			case 86: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.GREATER_THAN)
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
			// Rule 87:  relationalExpCS ::= relationalExpCS < ifExpCSPrec
			//
			case 87:
 
			//
			// Rule 88:  relationalWithLet ::= relationalExpCS < additiveWithLet
			//
			case 88: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.LESS_THAN)
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
			// Rule 89:  relationalExpCS ::= relationalExpCS >= ifExpCSPrec
			//
			case 89:
 
			//
			// Rule 90:  relationalWithLet ::= relationalExpCS >= additiveWithLet
			//
			case 90: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.GREATER_THAN_EQUAL)
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
			// Rule 91:  relationalExpCS ::= relationalExpCS <= ifExpCSPrec
			//
			case 91:
 
			//
			// Rule 92:  relationalWithLet ::= relationalExpCS <= additiveWithLet
			//
			case 92: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.LESS_THAN_EQUAL)
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
			// Rule 97:  additiveExpCS ::= additiveExpCS + multiplicativeExpCS
			//
			case 97:
 
			//
			// Rule 98:  additiveWithLet ::= additiveExpCS + multiplicativeWithLet
			//
			case 98: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.PLUS)
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
			// Rule 99:  additiveExpCS ::= additiveExpCS - multiplicativeExpCS
			//
			case 99:
 
			//
			// Rule 100:  additiveWithLet ::= additiveExpCS - multiplicativeWithLet
			//
			case 100: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.MINUS)
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
			// Rule 103:  multiplicativeExpCS ::= multiplicativeExpCS * unaryExpCS
			//
			case 103:
 
			//
			// Rule 104:  multiplicativeWithLet ::= multiplicativeExpCS * unaryWithLet
			//
			case 104: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.TIMES)
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
			// Rule 105:  multiplicativeExpCS ::= multiplicativeExpCS / unaryExpCS
			//
			case 105:
 
			//
			// Rule 106:  multiplicativeWithLet ::= multiplicativeExpCS / unaryWithLet
			//
			case 106: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.DIVIDE)
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
			// Rule 109:  unaryExpCS ::= - unaryExpCS
			//
			case 109: {
				
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
			// Rule 110:  unaryExpCS ::= not unaryExpCS
			//
			case 110: {
				
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
			// Rule 112:  dotArrowExpCS ::= dotArrowExpCS callExpCS
			//
			case 112: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setSource((OCLExpressionCS)dtParser.getSym(1));
				setOffsets(result, (CSTNode)dtParser.getSym(1), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 113:  dotArrowExpCS ::= dotArrowExpCS messageExpCS
			//
			case 113: {
				
				MessageExpCS result = (MessageExpCS)dtParser.getSym(2);
				result.setTarget((OCLExpressionCS)dtParser.getSym(1));
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 114:  dotArrowExpCS ::= NUMERIC_OPERATION ( argumentsCSopt )
			//
			case 114: {
				
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
			// Rule 115:  dotArrowExpCS ::= pathNameCS :: simpleNameCS ( argumentsCSopt )
			//
			case 115: {
				
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
			// Rule 120:  oclExpCS ::= ( oclExpressionCS )
			//
			case 120: {
				
				CSTNode result = (CSTNode)dtParser.getSym(2);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 121:  variableExpCS ::= simpleNameCS isMarkedPreCS
			//
			case 121:
 
			//
			// Rule 122:  variableExpCS ::= keywordAsName1 isMarkedPreCS
			//
			case 122: {
				
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
			// Rule 123:  variableExpCS ::= simpleNameCS [ argumentsCS ] isMarkedPreCS
			//
			case 123:
 
			//
			// Rule 124:  variableExpCS ::= keywordAsName1 [ argumentsCS ] isMarkedPreCS
			//
			case 124: {
				
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
			// Rule 126:  simpleNameCS ::= self
			//
			case 126: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.SELF_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 127:  simpleNameCS ::= IDENTIFIER
			//
			case 127: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 128:  primitiveTypeCS ::= Integer
			//
			case 128: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INTEGER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 129:  primitiveTypeCS ::= UnlimitedNatural
			//
			case 129: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 130:  primitiveTypeCS ::= String
			//
			case 130: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.STRING_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 131:  primitiveTypeCS ::= Real
			//
			case 131: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.REAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 132:  primitiveTypeCS ::= Boolean
			//
			case 132: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.BOOLEAN_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 133:  primitiveTypeCS ::= OclAny
			//
			case 133: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_ANY_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 134:  primitiveTypeCS ::= OclVoid
			//
			case 134: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_VOID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 135:  primitiveTypeCS ::= Invalid
			//
			case 135: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INVALID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 136:  primitiveTypeCS ::= OclMessage
			//
			case 136: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_MESSAGE_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 137:  pathNameCS ::= IDENTIFIER
			//
			case 137: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 138:  pathNameCS ::= pathNameCS :: simpleNameCS
			//
			case 138: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, getTokenText(dtParser.getToken(3)));
				setOffsets(result, result, (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 139:  pathNameCSOpt ::= $Empty
			//
			case 139: {
				
				CSTNode result = createPathNameCS();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 147:  enumLiteralExpCS ::= pathNameCS :: keywordAsName
			//
			case 147:
 
			//
			// Rule 148:  enumLiteralExpCS ::= pathNameCS :: simpleNameCS
			//
			case 148: {
				
				CSTNode result = createEnumLiteralExpCS(
						(PathNameCS)dtParser.getSym(1),
						(SimpleNameCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 149:  collectionLiteralExpCS ::= collectionTypeIdentifierCS { collectionLiteralPartsCSopt }
			//
			case 149: {
				
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
			// Rule 150:  collectionTypeIdentifierCS ::= Set
			//
			case 150: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.SET_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 151:  collectionTypeIdentifierCS ::= Bag
			//
			case 151: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.BAG_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 152:  collectionTypeIdentifierCS ::= Sequence
			//
			case 152: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.SEQUENCE_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 153:  collectionTypeIdentifierCS ::= Collection
			//
			case 153: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.COLLECTION_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 154:  collectionTypeIdentifierCS ::= OrderedSet
			//
			case 154: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 155:  collectionLiteralPartsCSopt ::= $Empty
			//
			case 155:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 157:  collectionLiteralPartsCS ::= collectionLiteralPartCS
			//
			case 157: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 158:  collectionLiteralPartsCS ::= collectionLiteralPartsCS , collectionLiteralPartCS
			//
			case 158: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 160:  collectionLiteralPartCS ::= oclExpressionCS
			//
			case 160: {
				
				CSTNode result = createCollectionLiteralPartCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 161:  collectionRangeCS ::= - INTEGER_RANGE_START oclExpressionCS
			//
			case 161: {
				
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
			// Rule 162:  collectionRangeCS ::= INTEGER_RANGE_START oclExpressionCS
			//
			case 162: {
				
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
			// Rule 163:  collectionRangeCS ::= oclExpressionCS .. oclExpressionCS
			//
			case 163: {
				
				CSTNode result = createCollectionRangeCS(
						(OCLExpressionCS)dtParser.getSym(1),
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 169:  tupleLiteralExpCS ::= Tuple { variableListCS2 }
			//
			case 169: {
				
				CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 170:  integerLiteralExpCS ::= INTEGER_LITERAL
			//
			case 170: {
				
				CSTNode result = createIntegerLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 171:  unlimitedNaturalLiteralExpCS ::= *
			//
			case 171: {
				
				CSTNode result = createUnlimitedNaturalLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 172:  realLiteralExpCS ::= REAL_LITERAL
			//
			case 172: {
				
				CSTNode result = createRealLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 173:  stringLiteralExpCS ::= STRING_LITERAL
			//
			case 173: {
				
				IToken literalToken = getIToken(dtParser.getToken(1));
				StringLiteralExpCS result = createStringLiteralExpCS(literalToken.toString());
				result.setUnescapedStringSymbol(unescape(literalToken));
				setOffsets(result, literalToken);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 174:  booleanLiteralExpCS ::= true
			//
			case 174: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 175:  booleanLiteralExpCS ::= false
			//
			case 175: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 176:  nullLiteralExpCS ::= null
			//
			case 176: {
				
				CSTNode result = createNullLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 177:  invalidLiteralExpCS ::= OclInvalid
			//
			case 177: {
				
				CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 178:  callExpCS ::= -> featureCallExpCS
			//
			case 178:
 
			//
			// Rule 179:  callExpCS ::= -> loopExpCS
			//
			case 179: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 180:  callExpCS ::= . keywordOperationCallExpCS
			//
			case 180:
 
			//
			// Rule 181:  callExpCS ::= . featureCallExpCS
			//
			case 181: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 184:  iteratorExpCS ::= iteratorName ( oclExpressionCS )
			//
			case 184: {
				
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
			// Rule 185:  iteratorExpCS ::= iteratorName ( variableCS | oclExpressionCS )
			//
			case 185: {
				
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
			// Rule 186:  iteratorExpCS ::= iteratorName ( variableCS , variableCS | oclExpressionCS )
			//
			case 186: {
				
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
			// Rule 187:  iterateExpCS ::= iterateName ( variableCS | oclExpressionCS )
			//
			case 187: {
				
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
			// Rule 188:  iterateExpCS ::= iterateName ( variableCS ; variableCS | oclExpressionCS )
			//
			case 188: {
				
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
			// Rule 189:  variableCS ::= IDENTIFIER
			//
			case 189: {
				
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
			// Rule 190:  typedVariableCS ::= IDENTIFIER : typeCS
			//
			case 190: {
				
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
			// Rule 192:  variableCS ::= IDENTIFIER : typeCS = oclExpressionCS
			//
			case 192: {
				
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
			// Rule 193:  variableCS2 ::= IDENTIFIER = oclExpressionCS
			//
			case 193: {
				
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
			// Rule 194:  typeCSopt ::= $Empty
			//
			case 194:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 200:  collectionTypeCS ::= collectionTypeIdentifierCS ( typeCS )
			//
			case 200: {
				
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
			// Rule 201:  tupleTypeCS ::= Tuple ( variableListCSopt )
			//
			case 201: {
				
				CSTNode result = createTupleTypeCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 202:  variableListCSopt ::= $Empty
			//
			case 202:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 204:  variableListCS ::= variableCS
			//
			case 204: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 205:  variableListCS ::= variableListCS , variableCS
			//
			case 205: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 206:  variableListCS2 ::= variableCS2
			//
			case 206:
 
			//
			// Rule 207:  variableListCS2 ::= variableCS
			//
			case 207: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 208:  variableListCS2 ::= variableListCS2 , variableCS2
			//
			case 208:
 
			//
			// Rule 209:  variableListCS2 ::= variableListCS2 , variableCS
			//
			case 209: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 212:  featureCallExpCS ::= unaryName isMarkedPreCS ( argumentsCSopt )
			//
			case 212:
 
			//
			// Rule 213:  operationCallExpCS ::= binaryName isMarkedPreCS ( argumentsCSopt )
			//
			case 213:
 
			//
			// Rule 214:  keywordOperationCallExpCS ::= keywordAsName isMarkedPreCS ( argumentsCSopt )
			//
			case 214: {
				
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
			// Rule 215:  stateExpCS ::= pathNameCSOpt
			//
			case 215: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				StateExpCS result = createStateExpCS(pathNameCS);
				setOffsets(result, pathNameCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 216:  operationCallExpCS ::= oclIsInStateName isMarkedPreCS ( stateExpCS )
			//
			case 216: {
				
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
			// Rule 217:  attrOrNavCallExpCS ::= simpleNameCS isMarkedPreCS
			//
			case 217:
 
			//
			// Rule 218:  attrOrNavCallExpCS ::= keywordAsName isMarkedPreCS
			//
			case 218: {
				
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
			// Rule 219:  attrOrNavCallExpCS ::= simpleNameCS [ argumentsCS ] isMarkedPreCS
			//
			case 219: {
				
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
			// Rule 220:  isMarkedPreCS ::= $Empty
			//
			case 220: {
				
				CSTNode result = createIsMarkedPreCS(false);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 221:  isMarkedPreCS ::= @pre
			//
			case 221: {
				
				CSTNode result = createIsMarkedPreCS(true);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 222:  argumentsCSopt ::= $Empty
			//
			case 222:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 224:  argumentsCS ::= oclExpressionCS
			//
			case 224: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 225:  argumentsCS ::= argumentsCS , oclExpressionCS
			//
			case 225: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 226:  letExpCS ::= let variableListCS in oclExpressionCS
			//
			case 226: {
				
				CSTNode result = createLetExpCS(
						(EList)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 227:  ifExpCS ::= if oclExpressionCS then oclExpressionCS else oclExpressionCS endif
			//
			case 227: {
				
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
			// Rule 228:  messageExpCS ::= ^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 228:
 
			//
			// Rule 229:  messageExpCS ::= ^^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 229: {
				
				CSTNode result = createMessageExpCS(
						getIToken(dtParser.getToken(1)).getKind() == OCLBacktrackingParsersym.TK_CARET,
						(SimpleNameCS)dtParser.getSym(2),
						(EList<OCLMessageArgCS>)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 230:  oclMessageArgumentsCSopt ::= $Empty
			//
			case 230:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 232:  oclMessageArgumentsCS ::= oclMessageArgCS
			//
			case 232: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 233:  oclMessageArgumentsCS ::= oclMessageArgumentsCS , oclMessageArgCS
			//
			case 233: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 234:  oclMessageArgCS ::= oclExpressionCS
			//
			case 234: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 235:  oclMessageArgCS ::= ?
			//
			case 235: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 236:  oclMessageArgCS ::= ? : typeCS
			//
			case 236: {
				
				CSTNode result = createOCLMessageArgCS(
						(TypeCS)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 245:  packageDeclarationCSm ::= packageDeclarationCSm packageDeclarationCS
			//
			case 245: {
				
				PackageDeclarationCS result = (PackageDeclarationCS)dtParser.getSym(2);
				result.setPackageDeclarationCS((PackageDeclarationCS) dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 246:  packageDeclarationCS ::= package pathNameCS contextDeclCSmopt endpackage
			//
			case 246: {
				
				CSTNode result = createPackageDeclarationCS(
						(PathNameCS)dtParser.getSym(2),
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 247:  packageDeclarationCS1 ::= contextDeclCSm
			//
			case 247: {
				
				EList contextDecls = (EList)dtParser.getSym(1);
				CSTNode result = createPackageDeclarationCS(null, contextDecls);
				if (!contextDecls.isEmpty()) {
					setOffsets(result, (CSTNode)contextDecls.get(0), (CSTNode)contextDecls.get(contextDecls.size()-1));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 248:  contextDeclCSmopt ::= $Empty
			//
			case 248:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 250:  contextDeclCSm ::= contextDeclCS
			//
			case 250: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 251:  contextDeclCSm ::= contextDeclCSm contextDeclCS
			//
			case 251: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 255:  propertyContextCS ::= context pathNameCS :: simpleNameCS : typeCS initOrDerValueCS
			//
			case 255: {
				
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
			// Rule 256:  initOrDerValueCS ::= initOrDerValueCSopt init : oclExpressionCS
			//
			case 256: {
				
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
			// Rule 257:  initOrDerValueCS ::= initOrDerValueCSopt derive : oclExpressionCS
			//
			case 257: {
				
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
			// Rule 258:  initOrDerValueCSopt ::= $Empty
			//
			case 258:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 260:  classifierContextDeclCS ::= context pathNameCS invOrDefCSm
			//
			case 260: {
				
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
			// Rule 261:  invOrDefCSm ::= invOrDefCS
			//
			case 261: {
				
				EList<InvOrDefCS> result = new BasicEList<InvOrDefCS>();
				result.add((InvOrDefCS)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 262:  invOrDefCSm ::= invOrDefCSm invOrDefCS
			//
			case 262: {
				
				EList<InvOrDefCS> result = (EList<InvOrDefCS>)dtParser.getSym(1);
				result.add((InvOrDefCS)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 263:  invOrDefCS ::= inv simpleNameCSopt : oclExpressionCS
			//
			case 263: {
				
				CSTNode result = createInvCS(
						(SimpleNameCS)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 264:  invOrDefCS ::= def simpleNameCSopt : defExpressionCS
			//
			case 264: {
				
				CSTNode result = createDefCS(
						(SimpleNameCS)dtParser.getSym(2),
						(DefExpressionCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 265:  defExpressionCS ::= typedVariableCS = oclExpressionCS
			//
			case 265: {
				
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
			// Rule 266:  defExpressionCS ::= operationCS1 = oclExpressionCS
			//
			case 266: {
				
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
			// Rule 267:  operationContextDeclCS ::= context operationCS2 prePostOrBodyDeclCSm
			//
			case 267: {
				
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
			// Rule 268:  prePostOrBodyDeclCSm ::= prePostOrBodyDeclCS
			//
			case 268: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 269:  prePostOrBodyDeclCSm ::= prePostOrBodyDeclCSm prePostOrBodyDeclCS
			//
			case 269: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 270:  prePostOrBodyDeclCS ::= pre simpleNameCSopt : oclExpressionCS
			//
			case 270: {
				
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
			// Rule 271:  prePostOrBodyDeclCS ::= post simpleNameCSopt : oclExpressionCS
			//
			case 271: {
				
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
			// Rule 272:  prePostOrBodyDeclCS ::= body simpleNameCSopt : oclExpressionCS
			//
			case 272: {
				
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
			// Rule 273:  ERROR_Colon ::= ERROR_TOKEN
			//
			case 273: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_COLON);
	  		  break;
			}
	 
			//
			// Rule 274:  ERROR_Empty ::= ERROR_TOKEN
			//
			case 274: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.EXTRA_TOKENS);
	  		  break;
			}
	 
			//
			// Rule 275:  ERROR_IsMarkedPreCS ::= ERROR_TOKEN
			//
			case 275: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_AT_PRE);
				IsMarkedPreCS result = createIsMarkedPreCS(false);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 276:  ERROR_PathNameCS ::= ERROR_TOKEN
			//
			case 276: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_PATH_NAME);
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 277:  ERROR_SimpleNameCS ::= ERROR_TOKEN
			//
			case 277: {
				
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
			// Rule 278:  attrOrNavCallExpCS ::= simpleNameCS [ argumentsCS ERROR_TOKEN
			//
			case 278: {
				
				reportErrorTokenMessage(dtParser.getToken(4), OCLParserErrors.MISSING_RBRACK);
				CSTNode result = createFeatureCallExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3),
						createIsMarkedPreCS(false)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 279:  collectionTypeCS ::= collectionTypeIdentifierCS ( typeCS ERROR_TOKEN
			//
			case 279: {
				
				reportErrorTokenMessage(dtParser.getToken(4), OCLParserErrors.MISSING_RPAREN);
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
			// Rule 280:  collectionTypeCS ::= collectionTypeIdentifierCS ERROR_TOKEN
			//
			case 280: {
				
				reportErrorTokenMessage(dtParser.getToken(2), OCLParserErrors.MISSING_LPAREN);
				Object[] objs = (Object[])dtParser.getSym(1);
				CSTNode result = createCollectionTypeCS(
						(CollectionTypeIdentifierEnum)objs[1],
						null
					);
				setOffsets(result, (IToken)objs[0], getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 281:  dotArrowExpCS ::= pathNameCS :: ERROR_SimpleNameCS ( argumentsCSopt )
			//
			case 281: {
				
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
			// Rule 282:  enumLiteralExpCS ::= pathNameCS :: ERROR_SimpleNameCS
			//
			case 282: {
				
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
			// Rule 283:  featureCallExpCS ::= unaryName ERROR_IsMarkedPreCS ( argumentsCSopt )
			//
			case 283:
 
			//
			// Rule 284:  keywordOperationCallExpCS ::= keywordAsName ERROR_IsMarkedPreCS ( argumentsCSopt )
			//
			case 284:
 
			//
			// Rule 285:  operationCallExpCS ::= binaryName ERROR_IsMarkedPreCS ( argumentsCSopt )
			//
			case 285: {
				
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
				CSTNode result = createOperationCallExpCS(
						simpleNameCS,
						(IsMarkedPreCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4)
					);
				setOffsets(result, simpleNameCS, getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 286:  operationCallExpCS ::= oclIsInStateName ERROR_IsMarkedPreCS ( stateExpCS )
			//
			case 286: {
				
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
			// Rule 287:  ifExpCS ::= if oclExpressionCS then oclExpressionCS else oclExpressionCS ERROR_TOKEN
			//
			case 287: {
				
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
			// Rule 288:  ifExpCS ::= if oclExpressionCS then oclExpressionCS ERROR_TOKEN
			//
			case 288: {
				
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
			// Rule 289:  ifExpCS ::= if oclExpressionCS ERROR_TOKEN
			//
			case 289: {
				
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
			// Rule 290:  ifExpCS ::= if ERROR_TOKEN endif
			//
			case 290: {
				
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
			// Rule 291:  messageExpCS ::= ^ simpleNameCS ERROR_TOKEN
			//
			case 291:
 
			//
			// Rule 292:  messageExpCS ::= ^^ simpleNameCS ERROR_TOKEN
			//
			case 292: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_MESSAGE_ARGUMENTS);
				CSTNode result = createMessageExpCS(
						getIToken(dtParser.getToken(1)).getKind() == OCLBacktrackingParsersym.TK_CARET,
						(SimpleNameCS)dtParser.getSym(2),
						new BasicEList<OCLMessageArgCS>()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 293:  messageExpCS ::= ^ ERROR_SimpleNameCS
			//
			case 293:
 
			//
			// Rule 294:  messageExpCS ::= ^^ ERROR_SimpleNameCS
			//
			case 294: {
				
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(2);
				CSTNode result = createMessageExpCS(
						getIToken(dtParser.getToken(1)).getKind() == OCLBacktrackingParsersym.TK_CARET,
						simpleNameCS,
						new BasicEList<OCLMessageArgCS>()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), simpleNameCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 295:  oclExpCS ::= ERROR_TOKEN
			//
			case 295: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_EXPR);
				CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 296:  oclExpCS ::= ( oclExpressionCS ERROR_TOKEN
			//
			case 296: {
				
				reportErrorTokenMessage(dtParser.getToken(3), OCLParserErrors.MISSING_RPAREN);
				CSTNode result = (CSTNode)dtParser.getSym(2);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 297:  operationCS1 ::= IDENTIFIER ( parametersCSopt ) ERROR_Colon
			//
			case 297: {
				
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
			// Rule 298:  operationCS1 ::= IDENTIFIER ( parametersCSopt ERROR_TOKEN
			//
			case 298: {
				
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
			// Rule 299:  operationCS1 ::= IDENTIFIER ERROR_TOKEN
			//
			case 299: {
				
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
			// Rule 300:  operationCS1 ::= ERROR_TOKEN
			//
			case 300: {
				
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
			// Rule 301:  operationCS2 ::= pathNameCS :: simpleNameCS ( parametersCSopt ) ERROR_Colon
			//
			case 301: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				CSTNode result = createOperationCS(
						pathNameCS,
						(SimpleNameCS)dtParser.getSym(3),
						(EList)dtParser.getSym(5),
						(TypeCS)dtParser.getSym(8)
					);
				setOffsets(result, pathNameCS, getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 302:  operationCS2 ::= pathNameCS :: simpleNameCS ( parametersCSopt ERROR_TOKEN
			//
			case 302: {
				
				reportErrorTokenMessage(dtParser.getToken(6), OCLParserErrors.MISSING_RPAREN);
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				CSTNode result = createOperationCS(
						pathNameCS,
						(SimpleNameCS)dtParser.getSym(3),
						(EList)dtParser.getSym(5),
						null
					);
				setOffsets(result, pathNameCS, getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 303:  operationCS2 ::= pathNameCS :: simpleNameCS ERROR_TOKEN
			//
			case 303: {
				
				reportErrorTokenMessage(dtParser.getToken(4), OCLParserErrors.MISSING_LPAREN);
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				CSTNode result = createOperationCS(
						pathNameCS,
						(SimpleNameCS)dtParser.getSym(3),
						new BasicEList(),
						null
					);
				setOffsets(result, pathNameCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 304:  operationCS2 ::= pathNameCS :: ERROR_SimpleNameCS
			//
			case 304: {
				
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
			// Rule 305:  parametersCS ::= ERROR_TOKEN
			//
			case 305: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_PARAMETERS);
				EList result = new BasicEList();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 306:  parametersCS ::= parametersCS , ERROR_TOKEN
			//
			case 306: {
				
				reportErrorTokenMessage(dtParser.getToken(3), OCLParserErrors.MISSING_PARAMETER);
	  		  break;
			}
	 
			//
			// Rule 309:  tupleLiteralExpCS ::= Tuple ERROR_TOKEN
			//
			case 309: {
				
				reportErrorTokenMessage(dtParser.getToken(7), OCLParserErrors.MISSING_LBRACE);
				CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 310:  variableCS ::= IDENTIFIER ERROR_TOKEN
			//
			case 310: {
				
				reportErrorTokenMessage(dtParser.getToken(2), OCLParserErrors.MISSING_VARIABLE_TYPE);
				CSTNode result = createVariableCS(
						getTokenText(dtParser.getToken(1)),
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 311:  variableExpCS ::= simpleNameCS [ argumentsCS ERROR_TOKEN
			//
			case 311:
 
			//
			// Rule 312:  variableExpCS ::= keywordAsName1 [ argumentsCS ERROR_TOKEN
			//
			case 312: {
				
				reportErrorTokenMessage(dtParser.getToken(4), OCLParserErrors.MISSING_RBRACK);
				CSTNode result = createVariableExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3),
						createIsMarkedPreCS(false)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 313:  variableListCS ::= ERROR_TOKEN
			//
			case 313:
 
			//
			// Rule 314:  variableListCS2 ::= ERROR_TOKEN
			//
			case 314: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_VARIABLES);
				EList result = new BasicEList();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 315:  classifierContextDeclCS ::= context pathNameCS ERROR_TOKEN
			//
			case 315: {
				
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
			// Rule 316:  defExpressionCS ::= typedVariableCS ERROR_TOKEN
			//
			case 316: {
				
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
			// Rule 317:  defExpressionCS ::= IDENTIFIER ERROR_Colon
			//
			case 317: {
				
				VariableCS variableCS = createVariableCS(
							getTokenText(dtParser.getToken(1)),
							null,
							null
						);
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
			// Rule 318:  initOrDerValueCS ::= initOrDerValueCSopt init ERROR_Colon
			//
			case 318: {
				
				CSTNode result = createInitValueCS(
						(InitOrDerValueCS)dtParser.getSym(1),
						null
					);
				if (dtParser.getSym(1) != null) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(3)));
				} else {
					setOffsets(result, getIToken(dtParser.getToken(2)), getIToken(dtParser.getToken(3)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 319:  initOrDerValueCS ::= initOrDerValueCSopt derive ERROR_Colon
			//
			case 319: {
				
				CSTNode result = createDerValueCS(
						(InitOrDerValueCS)dtParser.getSym(1),
						null
					);
				if (dtParser.getSym(1) != null) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(3)));
				} else {
					setOffsets(result, getIToken(dtParser.getToken(2)), getIToken(dtParser.getToken(3)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 320:  invOrDefCS ::= inv simpleNameCS ERROR_Colon
			//
			case 320: {
				
				CSTNode result = createInvCS(
						(SimpleNameCS)dtParser.getSym(2),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 321:  invOrDefCS ::= def simpleNameCS ERROR_Colon
			//
			case 321: {
				
				CSTNode result = createDefCS(
						(SimpleNameCS)dtParser.getSym(2),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 322:  packageDeclarationCS ::= package pathNameCS contextDeclCSmopt ERROR_Empty endpackage
			//
			case 322: {
				
				CSTNode result = createPackageDeclarationCS(
						(PathNameCS)dtParser.getSym(2),
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 323:  packageDeclarationCS ::= package pathNameCS contextDeclCSmopt ERROR_TOKEN
			//
			case 323: {
				
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
			// Rule 324:  packageDeclarationCS ::= package ERROR_PathNameCS
			//
			case 324: {
				
				CSTNode result = createPackageDeclarationCS(
						(PathNameCS)dtParser.getSym(2),
						new BasicEList()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 325:  prePostOrBodyDeclCS ::= pre simpleNameCS ERROR_Colon
			//
			case 325: {
				
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
			// Rule 326:  prePostOrBodyDeclCS ::= post simpleNameCS ERROR_Colon
			//
			case 326: {
				
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
			// Rule 327:  prePostOrBodyDeclCS ::= body simpleNameCS ERROR_Colon
			//
			case 327: {
				
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
			// Rule 328:  propertyContextCS ::= context pathNameCS :: ERROR_SimpleNameCS
			//
			case 328: {
				
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

