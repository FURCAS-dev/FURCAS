/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: OCLParser.java,v 1.4 2007/03/15 21:19:40 cdamus Exp $
 */

package org.eclipse.ocl.internal.parser;

import static org.eclipse.ocl.Environment.SELF_VARIABLE_NAME;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionLiteralPart;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.FeatureCallExp;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.LiteralExp;
import org.eclipse.ocl.expressions.LoopExp;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.NavigationCallExp;
import org.eclipse.ocl.expressions.NullLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StateExp;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.internal.OCLPlugin;
import org.eclipse.ocl.internal.cst.BooleanLiteralExpCS;
import org.eclipse.ocl.internal.cst.CSTNode;
import org.eclipse.ocl.internal.cst.CSTPackage;
import org.eclipse.ocl.internal.cst.CallExpCS;
import org.eclipse.ocl.internal.cst.ClassifierContextDeclCS;
import org.eclipse.ocl.internal.cst.CollectionLiteralExpCS;
import org.eclipse.ocl.internal.cst.CollectionLiteralPartCS;
import org.eclipse.ocl.internal.cst.CollectionRangeCS;
import org.eclipse.ocl.internal.cst.CollectionTypeCS;
import org.eclipse.ocl.internal.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.internal.cst.ContextDeclCS;
import org.eclipse.ocl.internal.cst.DefCS;
import org.eclipse.ocl.internal.cst.DefExpressionCS;
import org.eclipse.ocl.internal.cst.DotOrArrowEnum;
import org.eclipse.ocl.internal.cst.EnumLiteralExpCS;
import org.eclipse.ocl.internal.cst.FeatureCallExpCS;
import org.eclipse.ocl.internal.cst.IfExpCS;
import org.eclipse.ocl.internal.cst.InitOrDerValueCS;
import org.eclipse.ocl.internal.cst.IntegerLiteralExpCS;
import org.eclipse.ocl.internal.cst.InvCS;
import org.eclipse.ocl.internal.cst.InvOrDefCS;
import org.eclipse.ocl.internal.cst.InvalidLiteralExpCS;
import org.eclipse.ocl.internal.cst.IterateExpCS;
import org.eclipse.ocl.internal.cst.IteratorExpCS;
import org.eclipse.ocl.internal.cst.LetExpCS;
import org.eclipse.ocl.internal.cst.LiteralExpCS;
import org.eclipse.ocl.internal.cst.LoopExpCS;
import org.eclipse.ocl.internal.cst.MessageExpCS;
import org.eclipse.ocl.internal.cst.MessageExpKind;
import org.eclipse.ocl.internal.cst.NullLiteralExpCS;
import org.eclipse.ocl.internal.cst.OCLExpressionCS;
import org.eclipse.ocl.internal.cst.OCLMessageArgCS;
import org.eclipse.ocl.internal.cst.OperationCS;
import org.eclipse.ocl.internal.cst.OperationCallExpCS;
import org.eclipse.ocl.internal.cst.OperationContextDeclCS;
import org.eclipse.ocl.internal.cst.PackageDeclarationCS;
import org.eclipse.ocl.internal.cst.PathNameCS;
import org.eclipse.ocl.internal.cst.PrePostOrBodyDeclCS;
import org.eclipse.ocl.internal.cst.PrePostOrBodyEnum;
import org.eclipse.ocl.internal.cst.PrimitiveLiteralExpCS;
import org.eclipse.ocl.internal.cst.PrimitiveTypeCS;
import org.eclipse.ocl.internal.cst.PropertyContextCS;
import org.eclipse.ocl.internal.cst.RealLiteralExpCS;
import org.eclipse.ocl.internal.cst.SimpleNameCS;
import org.eclipse.ocl.internal.cst.SimpleTypeEnum;
import org.eclipse.ocl.internal.cst.StateExpCS;
import org.eclipse.ocl.internal.cst.StringLiteralExpCS;
import org.eclipse.ocl.internal.cst.TupleLiteralExpCS;
import org.eclipse.ocl.internal.cst.TupleTypeCS;
import org.eclipse.ocl.internal.cst.TypeCS;
import org.eclipse.ocl.internal.cst.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.internal.cst.VariableCS;
import org.eclipse.ocl.internal.cst.VariableExpCS;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.types.BagType;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.MessageType;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.CallingASTNode;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypeFactory;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * The <code>OCLLpgParser</code> parses an OCL expression into a CST.
 * Once the CST is created, the <code>OCLParser</code> walks the CST
 * and creates the OCL AST. It is necessary that this be done in two steps
 * because LPG is a bottom up parser and cannot provide enough contextual
 * information to create the AST on the first pass.
 * 
 * @author Christian Vogt (cvogt)
 */
public class OCLParser<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
		extends OCLLPGParser {

	public static final String errorMessages[] = {
	    /* LEX_ERROR_CODE */                     OCLMessages.OCLParseErrorCodes_LEX_ERROR,
	    /* ERROR_CODE */                         OCLMessages.OCLParseErrorCodes_ERROR,
	    /* BEFORE_CODE */                        OCLMessages.OCLParseErrorCodes_BEFORE,
	    /* INSERTION_CODE */                     OCLMessages.OCLParseErrorCodes_INSERTION,
	    /* INVALID_CODE */                       OCLMessages.OCLParseErrorCodes_INVALID,
	    /* SUBSTITUTION_CODE, SECONDARY_CODE */  OCLMessages.OCLParseErrorCodes_SUBSTITUTION_SECONDARY,
	    /* DELETION_CODE */                      OCLMessages.OCLParseErrorCodes_DELETION,
	    /* MERGE_CODE */                         OCLMessages.OCLParseErrorCodes_MERGE,
	    /* MISPLACED_CODE */                     OCLMessages.OCLParseErrorCodes_MISPLACED,
	    /* SCOPE_CODE */                         OCLMessages.OCLParseErrorCodes_SCOPE,
	    /* EOF_CODE */                           OCLMessages.OCLParseErrorCodes_EOF,
	    /* INVALID_TOKEN_CODE */                 OCLMessages.OCLParseErrorCodes_INVALID_TOKEN
	};

	/*
	 * Factories for creating OCL AST nodes
	 */	 	
	TypeFactory typeFactory;
		
	UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> uml;
	
	private EnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	environmentFactory;
 
	private Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	environment;
 
	private boolean traceflag = false;	
		
	private String errorString = ""; //$NON-NLS-1$

	private int charOffset = 0;

	private int errorReportLineOffset = 0;

	public OCLParser(OCLLexer lexStream,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> environment) {
		super(lexStream);
		lexStream.lexer(this);
		
		this.environmentFactory = environment.getFactory();
		this.environment = environment;
		
		typeFactory = environment.getTypeFactory();
        uml = environment.getUMLReflection();
	}

	public void setTraceFlag(boolean flag) {
		traceflag = flag;
	}
	
	public boolean getTraceFlag() {
		return traceflag;
	}
	
	private void TRACE( String rule, String message) {
		if (traceflag) {
			OCLPlugin.trace(rule + ": " + message);//$NON-NLS-1$
		}
	}
			
	private void TRACE(String rule, String message, EList<String> namelist) {		  			
		TRACE(rule, message + makeString(namelist)); 
	}
	
	/**
	 * Sets the character index offset of the input.
	 * 
	 * @param offset
	 */
	public void setCharacterOffset(int offset) {
		charOffset = offset;
	}

	/**
	 * Sets the line offset for reporting errors.
	 * Eg. if an error occured at line 2, but the offset was
	 * set to -1, then line 1 will be reported.
	 * 
	 * @param offset
	 */
	public void setErrorReportLineOffset(int offset) {
		errorReportLineOffset = offset;
	}

	/**
	 * Returns true if the token kind is an identifier or keyword,
	 * othewise false.
	 * 
	 * @param tokenKind the token kind to compare
	 * @return true if the token kind is an identifier or keyword,
	 * 				otherwise false
	 */
	static public boolean isIdentifierOrKeyword(int tokenKind) {
		switch(tokenKind) {
			
			case OCLLPGParsersym.TK_self:
			case OCLLPGParsersym.TK_inv:
			case OCLLPGParsersym.TK_pre:
			case OCLLPGParsersym.TK_post:
			case OCLLPGParsersym.TK_body:
			case OCLLPGParsersym.TK_context:
			case OCLLPGParsersym.TK_package:
			case OCLLPGParsersym.TK_endpackage:
			case OCLLPGParsersym.TK_def:
			case OCLLPGParsersym.TK_derive:
			case OCLLPGParsersym.TK_init:
			case OCLLPGParsersym.TK_if:
			case OCLLPGParsersym.TK_then:
			case OCLLPGParsersym.TK_else:
			case OCLLPGParsersym.TK_endif:
			case OCLLPGParsersym.TK_and:
			case OCLLPGParsersym.TK_or:
			case OCLLPGParsersym.TK_xor:
			case OCLLPGParsersym.TK_not:
			case OCLLPGParsersym.TK_implies:
			case OCLLPGParsersym.TK_let:
			case OCLLPGParsersym.TK_in:
			case OCLLPGParsersym.TK_true:
			case OCLLPGParsersym.TK_false:
			case OCLLPGParsersym.TK_Set:
			case OCLLPGParsersym.TK_Bag:
			case OCLLPGParsersym.TK_Sequence:
			case OCLLPGParsersym.TK_Collection:
			case OCLLPGParsersym.TK_OrderedSet:
			case OCLLPGParsersym.TK_iterate:
			case OCLLPGParsersym.TK_forAll:
			case OCLLPGParsersym.TK_exists:
			case OCLLPGParsersym.TK_isUnique:
			case OCLLPGParsersym.TK_any:
			case OCLLPGParsersym.TK_one:
			case OCLLPGParsersym.TK_collect:
			case OCLLPGParsersym.TK_select:
			case OCLLPGParsersym.TK_reject:
			case OCLLPGParsersym.TK_collectNested:
			case OCLLPGParsersym.TK_sortedBy:
			case OCLLPGParsersym.TK_closure:
			case OCLLPGParsersym.TK_oclIsKindOf:
			case OCLLPGParsersym.TK_oclIsTypeOf:
			case OCLLPGParsersym.TK_oclAsType:
			case OCLLPGParsersym.TK_oclIsNew:
			case OCLLPGParsersym.TK_oclIsUndefined:
			case OCLLPGParsersym.TK_oclIsInvalid:
			case OCLLPGParsersym.TK_oclIsInState:
			case OCLLPGParsersym.TK_allInstances:
			case OCLLPGParsersym.TK_String:
			case OCLLPGParsersym.TK_Integer:
            case OCLLPGParsersym.TK_UnlimitedNatural:
			case OCLLPGParsersym.TK_Real:
			case OCLLPGParsersym.TK_Boolean:
			case OCLLPGParsersym.TK_Tuple:
			case OCLLPGParsersym.TK_OclAny:
			case OCLLPGParsersym.TK_OclVoid:
			case OCLLPGParsersym.TK_Invalid:
			case OCLLPGParsersym.TK_OclMessage:
			case OCLLPGParsersym.TK_null:
			case OCLLPGParsersym.TK_OclInvalid:
			case OCLLPGParsersym.TK_IDENTIFIER:
			case OCLLPGParsersym.TK_EOF_TOKEN:
				return true;

		}
		return false;
	}

	/**
	 * Initializes the start and end positions of the specified AST node
	 * from the given CST node
	 *
	 * @param astNode an AST node
	 * @param cstNode a CST node
	 */
	private void initStartEndPositions(ASTNode astNode, CSTNode cstNode) {
		astNode.setStartPosition(cstNode.getStartOffset() + charOffset);
		astNode.setEndPosition(cstNode.getEndOffset() + charOffset + 1);
		// +1 because end offset is exclusive
	}

	/**
	 * Initializes the start and end positions of the property name in the
	 * specified calling AST node.
	 *
	 * @param callingASTNode a calling AST node
	 * @param cstNode a CST node
	 */
	private void initPropertyPositions(CallingASTNode callingASTNode, CSTNode cstNode) {
		callingASTNode.setPropertyStartPosition(cstNode.getStartOffset() + charOffset);
		callingASTNode.setPropertyEndPosition(cstNode.getEndOffset() + charOffset + 1);
		// +1 because end offset is exclusive
	}

	/**
	 * Initializes the type start and end positions of the specified typed AST node
	 * from the given CST node
	 *
	 * @param typedASTNode a typed AST node
	 * @param cstNode a CST node
	 */
	private void initTypePositions(TypedASTNode typedASTNode, CSTNode cstNode) {
		typedASTNode.setTypeStartPosition(cstNode.getStartOffset() + charOffset);
		typedASTNode.setTypeEndPosition(cstNode.getEndOffset() + charOffset + 1);
		// +1 because end offset is exclusive
	}

	/**
	 * Creates a string by joining the given string list elements
	 * with spaces.
	 * 
	 * @param namelist list of names to make string out of
	 * @return string representation of the list of string elements
	 */
	private String makeString(EList<String> namelist) {
		String msg = "";//$NON-NLS-1$
		for (int i = 0; i < namelist.size(); i++) {
			msg += " " + namelist.get(i);//$NON-NLS-1$
		}
		return msg;
	}

	/**
	 * Creates a string by joining the given string list elements
	 * with ::.
	 * 
	 * @param namelist list of names to make string out of
	 * @return the qualified name comprising the list of name elements
	 */
	private String makeName(EList<String> namelist) {
		StringBuffer msg = new StringBuffer();
		for (int i = 0; i < namelist.size(); i++) {
			if (i > 0) msg.append("::");//$NON-NLS-1$
			msg.append(namelist.get(i));
		}
		return msg.toString();
	}
	
	/**
	 * Constructs the string representation of an operation call.
	 * 
	 * @param operName the operation name
	 * @param args the arguments in the operation call
	 * 
	 * @return the string representation
	 */
	private String operationString(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			String operName,
			List<? extends TypedElement<C>> args) {
		StringBuffer result = new StringBuffer();
		
		result.append(operName);
		result.append('(');
		
		for (Iterator<? extends TypedElement<C>> iter = args.iterator();
				iter.hasNext();) {
			
			TypedElement<C> arg = iter.next();
			C type = arg.getType();
			
			result.append((type == null)? (String) null : uml.getName(type));
			
			if (iter.hasNext()) {
				result.append(", "); //$NON-NLS-1$
			}
		}
		
		result.append(')');
		
		return result.toString();
	}
    
    private OCLStandardLibrary<C> getStandardLibrary() {
        return environment.getOCLStandardLibrary();
    }
    
    private C getBoolean() {
        return getStandardLibrary().getBoolean();
    }
	
	/**
	 * Sets the specified navigation call's qualifiers, if they are compatible
	 * with the navigated association end or association class.
	 * 
	 * @param rule the rule name that parsed the qualifiers
	 * @param nc the navigation call expression
	 * @param qualifiers the qualifiers to set
	 * 
	 * @throws SemanticException if the qualifiers do not conform
	 */
	private void setQualifiers(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			String rule,
			NavigationCallExp<C, P> nc,
			List<OCLExpression<C>> qualifiers) throws SemanticException {
		
		if (nc instanceof PropertyCallExp) {
			P source = ((PropertyCallExp<C, P>) nc)
				.getReferredProperty();
			List<P> expectedQualifiers = uml.getQualifiers(source);
			
			if (expectedQualifiers.size() != qualifiers.size()) {
				ERROR(rule, OCLMessages.bind(
						OCLMessages.MismatchedQualifiers_ERROR_,
						nc.toString()));
			} else {
				if (!qualifiers.isEmpty()) {
					Iterator<P> eiter = expectedQualifiers.iterator();
					Iterator<OCLExpression<C>> qiter =
						qualifiers.iterator();
					
					while (eiter.hasNext()) {
						C expectedType = uml.getOCLType(eiter.next());
						OCLExpression<C> qualifier = qiter.next();
						
						C qualifierType = qualifier.getType();
						if (TypeUtil.typeCompare(env, expectedType, qualifierType) < 0) {
							ERROR(rule, OCLMessages.bind(
									OCLMessages.MismatchedQualifiers_ERROR_,
									nc.toString()));
						}
					}
					
					if (uml.isMany(source)) {
						C ncType = nc.getType();
						
						if (ncType instanceof CollectionType) {
							// qualifying the navigation results in a non-collection
							//    type
							@SuppressWarnings("unchecked")
							CollectionType<C, O> ct = (CollectionType) ncType;
							
							nc.setType(ct.getElementType());
						}
					}
				}
			}
		} else if (nc instanceof AssociationClassCallExp) {
			if (qualifiers.size() != 1) {
				ERROR(rule, OCLMessages.bind(
						OCLMessages.AssociationClassQualifierCount_ERROR_,
						nc.toString()));
			}
			
			Object qualifier = qualifiers.get(0);
			if (!(qualifier instanceof PropertyCallExp)) {
				ERROR(rule, OCLMessages.bind(
						OCLMessages.AssociationClassQualifierType_ERROR_,
						nc.toString()));
			}
			
			AssociationClassCallExp<C, P> acc =
				(AssociationClassCallExp<C, P>) nc;
			C assocClass = acc.getReferredAssociationClass();
			
			C sourceType = getElementType(nc.getSource().getType());
			
			@SuppressWarnings("unchecked")
			P property = ((PropertyCallExp<C, P>) qualifier)
					.getReferredProperty();
			
			C refAssocClass = uml.getAssociationClass(property);
			if (refAssocClass == null) {
				ERROR(rule, OCLMessages.bind(
						OCLMessages.AssociationClassQualifierType_ERROR_,
						nc.toString()));
			}
			
			if (uml.getAttributes(sourceType).contains(property)
					&& (refAssocClass == assocClass)) {
				acc.setNavigationSource(property);
				
				CollectionKind kind = getCollectionKind(uml.getOCLType(property));
				if (kind != null) {
					acc.setType(getCollectionType(env, kind, assocClass));
				} else {
					acc.setType(assocClass);
				}
			} else {
				ERROR(rule, OCLMessages.bind(
						OCLMessages.AssociationClassQualifierType_ERROR_,
						nc.toString()));
			}
		}
			
		// all's well
		nc.getQualifier().addAll(qualifiers);
	}
	
	/**
	 * Asserts that the specified association class is not a reflexive
	 * association.
	 * 
	 * @param env the current environment
	 * @param rule the rule that we are matching
	 * @param acc the association class call expression
	 * 
	 * @throws SemanticException if the association class is reflexive
	 */
	private void checkNotReflexive(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			String rule,
			AssociationClassCallExp<C, P> acc)
			throws SemanticException {
		
		C assocClass = acc.getReferredAssociationClass();
		
		List<P> ends;
		if (uml.isAssociationClass(assocClass)) {
			ends = uml.getMemberEnds(assocClass);
		} else {
			ends = Collections.emptyList();
		}
		
		if (ends.size() == 2) {
			P end1 = ends.get(0);
			P end2 = ends.get(1);
			
			if (TypeUtil.getPropertyType(env, assocClass, end1)
					== TypeUtil.getPropertyType(env, assocClass, end2)) {
				ERROR(rule, OCLMessages.bind(
						OCLMessages.AssociationClassAmbiguous_ERROR_,
						acc.toString()));
			}
		}
	}

	/**
	 * Hub for all semantic parsing messages -- 
	 * Should be changed if want to continue parsing, and not terminate
	 * on first exception.
	 */
	public static void ERR(String message) throws SemanticException {
		throw new SemanticException(message);
	}
		
	private void ERROR(String rule, String errorMessage) throws SemanticException {
		String error = OCLMessages.bind(
				OCLMessages.ErrorMessage_ERROR_,
				rule,
				errorMessage);
		errorString += error;
		ERR(error);
	}
	
	/**
	 * Generate a VariableDeclaration AST node, and add it to the environment.
	 * Variable declarations are generated for "self", let expression variables, and
	 * iterator and iterate variables, both implicit and explicit.
	 * For implicit variables, the name is generated by the Environment.
	 */
	private Variable<C, PM>
	genVariableDeclaration(String rule,
				Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
				String name, C type, 
				OCLExpression<C> initExp,
				boolean explicitFlag, boolean addToEnvironment, boolean isSelf) throws SemanticException {
			
		Variable<C, PM> vdcl = ExpressionsFactory.eINSTANCE.createVariable();		
 		vdcl.setName(name);
 		vdcl.setType(TypeUtil.resolveType(env, type));
 		vdcl.setInitExpression(initExp);
 		
 		if (addToEnvironment) {
 			boolean result = env.addElement(name, vdcl, explicitFlag);
 			if (!result) {
				if (name != null) {
					String message = OCLMessages.bind(
							OCLMessages.VariableUsed_ERROR_,
							name);
					ERROR(rule, message);
				} else {
					ERROR(rule, OCLMessages.VariableDeclaration_ERROR_);
				}
 			}
 			
 			if (isSelf) {
 				env.setSelfVariable(vdcl);
 			}
 		}
 		
 		if (addToEnvironment) {
 			TRACE(rule, "adding variable declaration for " + vdcl.getName());//$NON-NLS-1$
 		}	
 		return vdcl;
	}

	/**
	 * Generate an OperationCallExp node. 
	 * operName is the input name of the operation, which
	 * must be matched against the datatype of the operation source.
	 * 
	 * @param env the current environemtn
	 * @param rule the name of the concrete syntax rule that we are processing
	 * @param operName the operation name
	 * @param source the operation's source expression
	 * @param ownerType the type that defines the operation, in which we will
	 *     look it up.  This can differ from the type of the source expression
	 *     in the case of an implicit collect iterator
	 * @param args the operation arguments
	 */ 
	private OperationCallExp<C, O>
	genOperationCallExp(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			String rule,
			String operName,
			OCLExpression<C> source,
			C ownerType,
			List<OCLExpression<C>> args)
		throws SemanticException {

		OperationCallExp<C, O> result;
		
		result = ExpressionsFactory.eINSTANCE.createOperationCallExp();
		result.setSource(source);	   
		
		// Performs method signature checking		
		O oper = env.lookupOperation(ownerType, operName, args);
		if (oper == null) { 
			String message = OCLMessages.bind(OCLMessages.OperationNotFound_ERROR_,
					operationString(env, operName, args),
					(ownerType == null)? null : uml.getName(ownerType));
			ERROR(rule, message);
			result.setType(env.getOCLStandardLibrary().getOclVoid());
		} else {
		  	TRACE(rule, uml.getName(oper));
			result.setReferredOperation(oper);
		}
							
		// Set up arguments
		List<OCLExpression<C>> callargs = result.getArgument();
		if (args != null) {
		   	for (OCLExpression<C> arg : args) {
		   		if (arg == null) {
					ERROR(rule, OCLMessages.BadArg_ERROR_);
		   			continue;
		   		}
		   		
		   		callargs.add(arg);
		   	}
		}
				
		// Compute the result type, and perform conformance checking.
		if (oper != null) {
			C resultType = null;
			
			int opcode = 0;
		   	if (ownerType instanceof PredefinedType) { 
		   		opcode = OCLStandardLibraryUtil.getOperationCode(operName);
		   	} else if (TypeUtil.isOclAnyOperation(env, oper)) {
		   		// source is a user class, enumeration, or data type and the
		   		//    operation is defined by OclAny, not the source type
		   		opcode = OCLStandardLibraryUtil.getOclAnyOperationCode(operName);
		   	}
		   	
	   		result.setOperationCode(opcode);
	   		resultType = OCLStandardLibraryUtil.getResultTypeOf(
	   			env, ownerType, opcode, args);
		   	
		   	if (resultType == null) {
		   		resultType = uml.getOCLType(oper);	   		
		   	}
		   	
			// resolve collection or tuple type against the cache in the environment
			resultType = TypeUtil.resolveType(env, resultType);
			
		   	result.setType(resultType);
		}
			
		return result;
	}
	
	/**
	 * Runs the parser and throws an <code>LpgException</code>
	 * if any parse errors are encountered.
	 * 
	 * @return the parsed CST
	 * @throws ParserException if unable to parse the expression
	 */
	private EObject runParser() throws ParserException {
		EObject cstNode = parser();
		if (errorString.length() > 0) {
			String error = errorString;
			errorString = ""; //$NON-NLS-1$
			throw new ParserException(error);
		}
		return cstNode;
	}

	/**
	 * Parses the input as a PackageDeclarationCS.
	 * 
	 * @param constraints 
	 * @return the parsed constraints
	 * @throws ParserException if unable to parse the expression
	 */
	public final List<CT> parsePackageDeclarationCS(List<CT> constraints) throws ParserException {
		EObject cstNode = runParser();
		
		if ((cstNode != null) && !(cstNode instanceof PackageDeclarationCS)) {
			ERROR("parsePackageDeclarationCS",//$NON-NLS-1$
					OCLMessages.bind(OCLMessages.ParseCSTNodeType_ERROR_,
							"PackageDeclarationCS",//$NON-NLS-1$
							cstNode.eClass().getName()));
		}
		
		PackageDeclarationCS pkgdecl = (PackageDeclarationCS) cstNode;
		while (pkgdecl != null) {
			packageDeclarationCS(pkgdecl, constraints);
			pkgdecl = pkgdecl.getPackageDeclarationCS();
		}
		
		return constraints;
	}

	/**
	 * Parses the input as an InvOrDefCS.
	 * 
	 * @return the parsed OCL constraint
	 * @throws ParserException if unable to parse the expression
	 */
	public final CT parseInvOrDefCS() throws ParserException {
		
		EObject cstNode = runParser();
		if (cstNode != null) {
			if (cstNode instanceof InvOrDefCS) {
				return invOrDefCS((InvOrDefCS)cstNode, environment);
			}

			ERROR("parseInvOrDefCS",//$NON-NLS-1$
					OCLMessages.bind(OCLMessages.ParseCSTNodeType_ERROR_,
							"InvOrDefCS",//$NON-NLS-1$
							cstNode.eClass().getName()));
		}
		return null;
	}

	/**
	 * Parses the input as a PrePostOrBodyDeclCS.
	 * 
	 * @param operation the constrained EOperation
	 * @return the parsed OCL constraint
	 * @throws ParserException if unable to parse the expression
	 */
	public final CT parsePrePostOrBodyDeclCS() throws ParserException {
		
		EObject cstNode = runParser();
		if (cstNode != null) {
			if (cstNode instanceof PrePostOrBodyDeclCS) {
				return prePostOrBodyDeclCS(
						environment,
						(PrePostOrBodyDeclCS)cstNode);
			}
		}

		ERROR("parsePrePostOrBodyDeclCS",//$NON-NLS-1$
				OCLMessages.bind(OCLMessages.ParseCSTNodeType_ERROR_,
						"PrePostOrBodyDeclCS",//$NON-NLS-1$
						cstNode.eClass().getName()));
		return null;
	}

	/**
	 * Parses the input as an InitOrDerValueCS.
	 * 
	 * @param property the constrained EStructuralFeature
	 * @return the parsed OCL constraint
	 * @throws ParserException if unable to parse the expression
	 */
	public final CT parseInitOrDerValueCS() throws ParserException {
		
		EObject cstNode = runParser();
		if (cstNode != null) {
			if (cstNode instanceof InitOrDerValueCS) {
				return initOrDerValueCS(
						environment,
						(InitOrDerValueCS)cstNode);
			}
		}

		ERROR("parseInitOrDerValueCS",//$NON-NLS-1$
				OCLMessages.bind(OCLMessages.ParseCSTNodeType_ERROR_,
						"InitOrDerValueCS",//$NON-NLS-1$
						cstNode.eClass().getName()));
		return null;
	}

	/**
	 * Parses the input as a VariableDeclarationCS.
	 * 
	 * @param addToEnvironment boolean whether or not to add the
	 *                         the parsed variable to the environment
	 * @return the parsed variable declaration
	 * @throws ParserException if unable to parse the expression
	 */
	public final Variable<C, PM>
	parseVariableDeclarationCS(boolean addToEnvironment) throws ParserException {
		
		EObject cstNode = runParser();
		if (cstNode != null) {
			if (cstNode instanceof VariableCS) {
				return variableDeclarationCS((VariableCS)cstNode, environment, true);
			}

			ERROR("parseVariableDeclarationCS",//$NON-NLS-1$
					OCLMessages.bind(OCLMessages.ParseCSTNodeType_ERROR_,
							"VariableDeclarationCS",//$NON-NLS-1$
							cstNode.eClass().getName()));
		}
		return null;
	}

	/**
	 * Called when encountering a single bad character. Do not report
	 * this error at this point.
	 */
	public void reportError(int left_char, int right_char) {
		// empty
	}

	/**
	 * Reports the parse error by setting the error to <code>errorString</code>
	 * 
	 * @param errorCode the error code
	 * @param locationInfo
	 * @param leftToken the token to the left of the error
	 * @param rightToken the token to the right of the error
	 * @param tokenText the text of the bad token
	 */
	public void reportError(int errorCode, String locationInfo, int leftToken, int rightToken, String tokenText) {

		int leftTokenLoc = (leftToken > rightToken ? rightToken : leftToken);
		int rightTokenLoc = rightToken;

        if (getLine(leftTokenLoc) + errorReportLineOffset <= 0) {
        	errorString = OCLMessages.InvalidOCL_ERROR_;
		} else {
			String locInfo = OCLMessages.bind(OCLMessages.ErrorReport_RowColumn,
					new Object[]{
						new Integer((getLine(leftTokenLoc) + errorReportLineOffset)),
						new Integer(getColumn(leftTokenLoc)),
						new Integer((getEndLine(rightTokenLoc) + errorReportLineOffset)),
						new Integer(getEndColumn(rightTokenLoc))
				});
	
			switch (errorCode) {
				case EOF_CODE:
				case MISPLACED_CODE:
				case DELETION_CODE:
				case INVALID_TOKEN_CODE:
					errorString = OCLMessages.bind(
						errorMessages[errorCode],
						locInfo,
						'"' + computeInputString(
							getIToken(leftToken).getStartOffset(),
							getIToken(rightToken).getEndOffset())) + '"';
					break;
	
				case MERGE_CODE:
				case BEFORE_CODE:
				case INSERTION_CODE:
				case SUBSTITUTION_CODE: // includes SECONDARY_CODE
					errorString = OCLMessages.bind(
						errorMessages[errorCode],
						new Object[]{
							locInfo,
							tokenText,
							'"' + computeInputString(
								getIToken(leftToken).getStartOffset(),
								getIToken(rightToken).getEndOffset()) + '"'
						});
					break;
	
				default:
					errorString = OCLMessages.bind(errorMessages[errorCode], locInfo, tokenText);
					break;
			}
		}
	}

	/**
	 * Returns a single line string representation of the input chars
	 * for the given range.
	 * 
	 * @param left left most char index
	 * @param right right most char index
	 * @return a single line string representation of the input chars
	 */
	private String computeInputString(int left, int right) {
		StringBuffer result = new StringBuffer(right - left + 1);
		char[] chars = getInputChars();

		for (int i = left; i <= right; i++) {
			if (chars[i] == '\t') {
				result.append(' ');
			} else if (chars[i] == '\n' || chars[i] == '\r' || chars[i] == '\f') {
				if (i > 0) {
					if (!Character.isWhitespace(chars[i-1])) {
						result.append(' ');
					}
				}
			} else {
				result.append(chars[i]);
			}
				
		}
		return result.toString();
	}
	
	/**
	 * Obtains the text from which the specified CST <code>node</code> was parsed.
	 * 
	 * @param node a concrete syntax node
	 * 
	 * @return its text
	 */
	private String computeInputString(CSTNode node) {
		return computeInputString(node.getStartOffset(), node.getEndOffset());
	}

	/**
	 * Empty.
	 */
	public void reportError(int errorCode, String locationInfo, String tokenText) {
		// empty
	}

	/**
	 * Dumps the error code and token info.
	 * 
	 * @param i token index
	 * @param code error code
	 */
	public void reportError(int i, String code) {
		errorString = code
			+ " (" + getKind(i) + ") : "  //$NON-NLS-1$//$NON-NLS-2$
			+ getStartOffset(i)
			+ ":" + getLineNumberOfTokenAt(i) //$NON-NLS-1$
			+ ":" + getColumnOfTokenAt(i) //$NON-NLS-1$
			+ ":" + getTokenLength(i) //$NON-NLS-1$
			+ " " + getTokenText(i); //$NON-NLS-1$
	}

	/**
	 * PackageDeclarationCS
	 * 
	 * @param packageDeclarationCS the <code>PackageDeclarationCS</code> <code>CSTNode</code>
	 * @param constraints the constraints list to populate
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final void packageDeclarationCS(
			PackageDeclarationCS packageDeclarationCS,
			List<CT> constraints) throws SemanticException {
		
		EList<ContextDeclCS> contextDecls = packageDeclarationCS.getContextDecls();
        
        PathNameCS pathNameCS = packageDeclarationCS.getPathNameCS();
		EList<String> pathname = (pathNameCS == null)? null : pathNameCS.getSequenceOfNames();
		
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env;
        
        if (pathname == null) {
            env = environment;
            pathname = ECollections.emptyEList();
        } else {
            env = environmentFactory.createPackageContext(environment, pathname);
            
    		if (env == null) {
    			ERROR("packageDeclarationCS", //$NON-NLS-1$
    					OCLMessages.bind(
    							OCLMessages.PackageNotFound_ERROR_,
    							makeString(pathname)));
    		}
        }
        
		TRACE("packageDeclarationCS", "Package ", pathname); //$NON-NLS-2$//$NON-NLS-1$

		for (ContextDeclCS decl : contextDecls) {
			contextDeclCS(decl, env, constraints);
		}
	}

	/**
	 * ContextDeclCS
	 * 
	 * @param contextDeclCS the <code>ContextDeclCS</code> <code>CSTNode</code>
	 * @param env the package environment
	 * @param constraints the constraints list to populate
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final void contextDeclCS(
			ContextDeclCS contextDeclCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			List<CT> constraints
		) throws SemanticException {
		
		if (contextDeclCS instanceof OperationContextDeclCS) {
			operationContextDeclCS((OperationContextDeclCS)contextDeclCS, env, constraints);
		} else if (contextDeclCS instanceof PropertyContextCS) {
			propertyContextCS((PropertyContextCS)contextDeclCS, env, constraints);
		} else if (contextDeclCS instanceof ClassifierContextDeclCS) {
			classifierContextDeclCS((ClassifierContextDeclCS)contextDeclCS, env, constraints);
		}
	}

	/**
	 * OperationContextDeclCS
	 * 
	 * @param operationContextDeclCS the <code>OperationContextDeclCS</code> <code>CSTNode</code>
	 * @param env the package environment
	 * @param constraints the constraints list to populate
	 * @throws SemanticException if te expression contains semantic errors
	 */
	protected final void operationContextDeclCS(
			OperationContextDeclCS operationContextDeclCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			List<CT> constraints
		) throws SemanticException {

		env = operationCS(operationContextDeclCS.getOperationCS(), env);
		
		CT astNode;
		for (PrePostOrBodyDeclCS decl : operationContextDeclCS.getPrePostOrBodyDecls()) {
			astNode = prePostOrBodyDeclCS(env, decl);
			constraints.add(astNode);
		}
	}

	/**
	 * OperationCS
	 * 
	 * @param operationCS the <code>OperationCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed context <code>EOperation</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	operationCS(OperationCS operationCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env)
			throws SemanticException {
		
		O operation = null;
		C classifier = null;
		EList<String> operationName = new BasicEList<String>();
		operationName.addAll(operationCS.getPathNameCS().getSequenceOfNames());
		operationName.add(operationCS.getSimpleNameCS().getValue());

		if (operationName.size() > 1) {
			int lastName = operationName.size() - 1;
			List<String> className = new java.util.ArrayList<String>(
				operationName.subList(0, lastName));
			classifier = env.lookupClassifier(className);
			
			if (classifier != null) {
				// create the classifier context as parent for the operation context
				env = environmentFactory.createClassifierContext(env, classifier);
				
				// ensure that the classifier context has a 'self' variable
				if (env.lookupLocal(SELF_VARIABLE_NAME) == null) {
					genVariableDeclaration("operationCS", env,//$NON-NLS-1$
						SELF_VARIABLE_NAME, classifier, null, true, true, true);
				}
				
				// find the context operation
				List<Variable<C, PM>> contextParms =
					parametersCS(operationCS.getParameters(), env);
				operation = env.lookupOperation(
					classifier, operationName.get(lastName), contextParms);

				if (operation == null) {
					String message = OCLMessages.bind(
						OCLMessages.UnrecognizedContext_ERROR_,
						makeString(operationName));
					ERROR("operationContextDeclCS", message);//$NON-NLS-1$
				}
			}
		}

		if (operation == null) {
			String message = OCLMessages.bind(
				OCLMessages.UnrecognizedContext_ERROR_,
				makeString(operationName));
			ERROR("operationContextDeclCS", message);//$NON-NLS-1$
		}
		
		TRACE("operationCS", "context", operationName);//$NON-NLS-2$//$NON-NLS-1$

		// this ensures that parameters are correctly renamed according to the
		//   context declaration (thus ensuring that they do not mask attributes
		//   of the context classifier)
		return createOperationContext(
				env,
				(OperationContextDeclCS) operationCS.eContainer(),
				operation);
	}

	private Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	createOperationContext(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			OperationContextDeclCS operationContextCS,
			O operation) throws SemanticException {
		
		// create the operation context
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> result =
			environmentFactory.createOperationContext(env, operation);
		
		// create a self variable for this operation
		if (result.lookupLocal(SELF_VARIABLE_NAME) == null) {
			genVariableDeclaration("operationContextDeclCS", result, //$NON-NLS-1$
					SELF_VARIABLE_NAME, env.getContextClassifier(), null, true, true, true);
		}
		
		if (operationContextCS != null) {
			List<VariableCS> contextParms = operationContextCS.getOperationCS().getParameters();
			// now, because the environment factory will have defined
			//   variables for operation parameters, let's replace any that
			//   are renamed by the context declaration
			List<PM> parms = uml.getParameters(operation);
			for (int i = 0; i < parms.size(); i++) {
				String contextParmName = contextParms.get(i).getName();
				String innateParmName = uml.getName(parms.get(i));
				
				if (!contextParmName.equals(innateParmName)) {
					Variable<C, PM> var = result.lookupLocal(innateParmName);
					
					// delete this variable
					result.deleteElement(innateParmName);
					
					// replace it with this one
					var.setName(contextParmName);
					result.addElement(contextParmName, var, true);
				}
			}
		}
		
		return result;
	}
	
	/**
	 * ParametersCS
	 * 
	 * @param parameters the list of parameters as <code>VariableDeclarationCS</code> objects
	 * @param env the OCL expression
	 * @return a list of <code>VariableDeclaration</code>s
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final List<Variable<C, PM>>
	parametersCS(
			List<VariableCS> parameters,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env)
			throws SemanticException {

		return variableDeclarationListCS(parameters, env, false);
	}

	/**
	 * PrePostOrBodyDeclCS
	 * 
	 * @param prePostOrBodyDeclCS the <code>PrePostOrBodyDeclCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @param operation the context <code>EOperation</code>
	 * @return the parsed <code>Constraint</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final CT prePostOrBodyDeclCS(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			PrePostOrBodyDeclCS prePostOrBodyDeclCS) throws SemanticException {

		Variable<C, PM> resultVar = null;
		
		O operation = env.getContextOperation();
		
		// create a disposable child operation context for this environment
		env = createOperationContext(
				env,
				(OperationContextDeclCS) prePostOrBodyDeclCS.eContainer(),
				operation);
		
		C operationType = uml.getOCLType(operation);
        if (operationType instanceof VoidType) {
            operationType = null;  // a void operation has no result
        }
        
		String stereotype = null;
		
		switch (prePostOrBodyDeclCS.getKind().getValue()) {
			case PrePostOrBodyEnum.PRE:
				stereotype = UMLReflection.PRECONDITION;
				break;

			case PrePostOrBodyEnum.POST:
				stereotype = UMLReflection.POSTCONDITION;
				
				// postconditions have an implicit variable "result" of the
				// same type as the operation
				if ((operationType != null) && (env.lookupLocal(Environment.RESULT_VARIABLE_NAME) == null)) {
					resultVar = genVariableDeclaration(
						"prePostOrBodyDeclCS0", env, //$NON-NLS-1$
						Environment.RESULT_VARIABLE_NAME, operationType, null, true, true, false);
				}

				break;

			case PrePostOrBodyEnum.BODY:
				stereotype = UMLReflection.BODY;
				 
				// likewise, body conditions have an implicit variable "result"
				if ((operationType != null) && (env.lookupLocal(Environment.RESULT_VARIABLE_NAME) == null)) {
					resultVar = genVariableDeclaration(
						"prePostOrBodyDeclCS", env, //$NON-NLS-1$
						Environment.RESULT_VARIABLE_NAME, operationType, null, true, true, false);
				}

				break;
		}

		CT astNode;
		
		try {
			OCLExpression<C> oclExpression =
				oclExpressionCS(prePostOrBodyDeclCS.getExpressionCS(), env);
			
			/* create a constraint astNode  -- must reference the type of self...
			   also, can have a name n.  type of constraint is pre/post/body...
			*/
			astNode = uml.createConstraint();
			
			SimpleNameCS simpleNameCS = prePostOrBodyDeclCS.getSimpleNameCS();
			if (simpleNameCS != null) {
                uml.setConstraintName(astNode, simpleNameCS.getValue());
			}
			
			List<EObject> constrainedElement = uml.getConstrainedElements(astNode);
			constrainedElement.add((EObject) operation);
			
			ExpressionInOCL<C, PM> spec = uml.createExpressionInOCL();
			spec.setBodyExpression(oclExpression);
			
			spec.setContextVariable(env.getSelfVariable());
			spec.setResultVariable(resultVar);
			
			// compute the parameter variables
			List<PM> parameters = uml.getParameters(operation);
			Collection<Variable<C, PM>> vars = env.getVariables();
			for (Variable<C, PM> var : vars) {
				if (parameters.contains(var.getRepresentedParameter())) {
					spec.getParameterVariable().add(var);
				}
			}
			
            uml.setSpecification(astNode, spec);
            uml.setStereotype(astNode, stereotype);
			
			if (UMLReflection.BODY.equals(stereotype)) {
				env.setBodyCondition(operation, astNode);
			}
		} finally {
			if (resultVar != null) {
				// don't want this variable to linger for the next time the environment
				//   is used, e.g. to parse a pre-condition
				env.deleteElement(Environment.RESULT_VARIABLE_NAME);
			}
		}

		return astNode;
	}

	/**
	 * PropertyContextCS
	 * 
	 * @param propertyContextCS the <code>PropertyContextCS</code> <code>CSTNode</code>
	 * @param env the package environment
	 * @param constraints the constraints list to populate
	 * @throws SemanticException if te expression contains semantic errors
	 */
	protected final P propertyContextCS(
			PropertyContextCS propertyContextCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			List<CT> constraints) throws SemanticException {

		EList<String> pathName = propertyContextCS.getPathNameCS().getSequenceOfNames();
		C owner = env.lookupClassifier(pathName);
		
		if (owner == null) {
			String message = OCLMessages.bind(
				OCLMessages.UnrecognizedContext_ERROR_,
				makeString(pathName));
			ERROR("propertyContextCS", message);//$NON-NLS-1$
		}

		owner = uml.asOCLType(owner);
		
		// create the classifier context as parent for the property context
		env = environmentFactory.createClassifierContext(env, owner);
		
		String simpleName = propertyContextCS.getSimpleNameCS().getValue();
		P property = env.lookupProperty(owner, simpleName);
		
		EList<String> propertyName = new BasicEList<String>();
		propertyName.addAll(pathName);
		propertyName.add(simpleName);
		
		if (property == null) {
			String message = OCLMessages.bind(
				OCLMessages.UnrecognizedContext_ERROR_,
				makeString(propertyName));
			ERROR("propertyContextCS", message);//$NON-NLS-1$
		}
		
		C type = typeCS(propertyContextCS.getTypeCS(), env);
		C propertyType = TypeUtil.getPropertyType(env, owner, property);
		if ((type == null) || TypeUtil.typeCompare(env, propertyType, type) != 0) {
			String message = OCLMessages.bind(
				OCLMessages.UnrecognizedContext_ERROR_,
				makeString(propertyName));
			ERROR("propertyContextCS", message);//$NON-NLS-1$
		}
		
		TRACE("propertyContextCS", "context", propertyName);  //$NON-NLS-2$//$NON-NLS-1$
		
		// create the property context
		env = environmentFactory.createAttributeContext(env, property);
		
		CT astNode;
		InitOrDerValueCS initOrDerValueCS = propertyContextCS.getInitOrDerValueCS();
		astNode = initOrDerValueCS(env, initOrDerValueCS);
		constraints.add(astNode);
		
		InitOrDerValueCS other = initOrDerValueCS.getInitOrDerValueCS();
		if (other != null) {
			if ((initOrDerValueCS.eClass() == other.eClass())
					|| (other.getInitOrDerValueCS() != null)) {
				String message = OCLMessages.bind(
						OCLMessages.PropertyConstraints_ERROR_,
						makeString(propertyName));
				ERROR("propertyContextCS", message);//$NON-NLS-1$
			}
			
			astNode = initOrDerValueCS(env, other);
			constraints.add(astNode);
		}
		
		return property;
	}
	
	private Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	createPropertyContext(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			PropertyContextCS propertyContextCS,
			P property) throws SemanticException {
		
		// create the classifier context as parent for the property context
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> result =
			environmentFactory.createAttributeContext(env, property);
		
		// ensure that the classifier context has a 'self' variable
		if (result.lookupLocal(SELF_VARIABLE_NAME) == null) {
			genVariableDeclaration("propertyContextCS", result, //$NON-NLS-1$
				SELF_VARIABLE_NAME, env.getContextClassifier(), null, true, true, true);
		}
		
		return result;
	}

	/**
	 * InitOrDerValueCS
	 * 
	 * @param initOrDerValueCS the <code>InitOrDerValueCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @param property the context <code>EStructuralFeature</code>
	 * @return the parsed <code>Constraint</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final CT initOrDerValueCS(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			InitOrDerValueCS initOrDerValueCS) throws SemanticException {

		P property = env.getContextProperty();
		
		// create a disposable property context for this environment
		env = createPropertyContext(
				env,
				(PropertyContextCS) initOrDerValueCS.eContainer(),
				property);
		
		String stereotype = null;
				
		switch (initOrDerValueCS.eClass().getClassifierID()) {
			case CSTPackage.INIT_VALUE_CS:
				stereotype = UMLReflection.INITIAL;
				break;

			case CSTPackage.DER_VALUE_CS:
				stereotype = UMLReflection.DERIVATION;
				break;
		}

		OCLExpression<C> oclExpression =
			oclExpressionCS(initOrDerValueCS.getExpressionCS(), env);
		
		CT astNode = uml.createConstraint();

		List<EObject> constrainedElement = uml.getConstrainedElements(astNode);
		constrainedElement.add((EObject) property);
		
		ExpressionInOCL<C, PM> spec = uml.createExpressionInOCL();
		spec.setBodyExpression(oclExpression);
		
		spec.setContextVariable(env.getSelfVariable());
		
        uml.setSpecification(astNode, spec);
        uml.setStereotype(astNode, stereotype);
		
		if (UMLReflection.DERIVATION.equals(stereotype)) {
			env.setDeriveConstraint(property, astNode);
		} else {
			env.setInitConstraint(property, astNode);
		}

		return astNode;
	}

	/**
	 * ClassifierContextDeclCS
	 * 
	 * @param classifierContextDeclCS the <code>ClassifierContextDeclCS</code> <code>CSTNode</code>
	 * @param env the package environment
	 * @param constraints the constraints list to populate
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	classifierContextDeclCS(
			ClassifierContextDeclCS classifierContextDeclCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			List<CT> constraints) throws SemanticException {
		
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> result = null;
		
		EList<String> pathName = classifierContextDeclCS.getPathNameCS().getSequenceOfNames();
		C type = env.lookupClassifier(pathName);
		
		if (type == null) {
			String message = OCLMessages.bind(
				OCLMessages.UnrecognizedContext_ERROR_,
				makeString(pathName));
			ERROR("classifierContextDeclCS", message);//$NON-NLS-1$
		}

		type = uml.asOCLType(type);

		result = environmentFactory.createClassifierContext(env, type);
		
        if (result.getSelfVariable() == null) {
            // ensure that the classifier context has a "self" variable
    		genVariableDeclaration("classifierContextDeclCS", result, //$NON-NLS-1$
    			SELF_VARIABLE_NAME, type, null, true, true, true);
        }
        
		TRACE("classifierContextDeclCS", "context", pathName);  //$NON-NLS-2$//$NON-NLS-1$
		
		InvOrDefCS invOrDefCS = classifierContextDeclCS.getInvOrDefCS();
		while (invOrDefCS != null) {
			CT astNode = invOrDefCS(invOrDefCS, result);
			constraints.add(astNode);
			
			invOrDefCS = invOrDefCS.getInvOrDefCS();
		}		
		
		return result;
	}
	
	private Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	createClassifierContext(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			ClassifierContextDeclCS classifierContextDeclCS,
			C classifier) throws SemanticException {
		
		// create the classifier context as parent for the property context
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> result =
			environmentFactory.createClassifierContext(env, classifier);
		
		// ensure that the classifier context has a 'self' variable
		if (result.lookupLocal(SELF_VARIABLE_NAME) == null) {
			genVariableDeclaration("propertyContextCS", result, //$NON-NLS-1$
				SELF_VARIABLE_NAME, env.getContextClassifier(), null, true, true, true);
		}
		
		return result;
	}

	/**
	 * InvOrDefCS
	 * 
	 * @param invOrDefCS the <code>InvOrDefCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>Constraint</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final CT invOrDefCS(
			InvOrDefCS invOrDefCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env)
			throws SemanticException {
		
		C classifier = env.getContextClassifier();
		
		// create a disposable classifier context for this environment
		env = createClassifierContext(
				env,
				(ClassifierContextDeclCS) invOrDefCS.eContainer(),
				classifier);
		
		CT astNode = null;
		if (invOrDefCS instanceof InvCS) {
			astNode = invCS((InvCS)invOrDefCS, env);
		} else if (invOrDefCS instanceof DefCS) {
			astNode = defCS((DefCS) invOrDefCS, env);
		}
		return astNode;
	}

	/**
	 * InvCS
	 * 
	 * @param invCS the <code>InvCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>Constraint</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final CT invCS(
			InvCS invCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env)
			throws SemanticException {
		
		OCLExpression<C> oclExpression =
			oclExpressionCS(invCS.getExpressionCS(), env);

		CT astNode = uml.createConstraint();
		
		SimpleNameCS simpleNameCS = invCS.getSimpleNameCS();

		if (simpleNameCS != null) {
            uml.setConstraintName(astNode, simpleNameCS.getValue());
		}
		
		C type = env.getContextClassifier();
		List<EObject> constrainedElement = uml.getConstrainedElements(astNode);
		constrainedElement.add((EObject) type);
		
		ExpressionInOCL<C, PM> spec = uml.createExpressionInOCL();
		spec.setBodyExpression(oclExpression);
		
		spec.setContextVariable(env.getSelfVariable());
		
        uml.setSpecification(astNode, spec);
        uml.setStereotype(astNode, UMLReflection.INVARIANT);
		return astNode;
	}

	/**
	 * DefCS
	 * 
	 * @param defCS the <code>DefCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>Constraint</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final CT defCS(
			DefCS defCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env)
			throws SemanticException {
		
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> contextEnv;
		DefExpressionCS defExpr = defCS.getDefExpressionCS();
		
		EObject feature = null;
		OCLExpression<C> expression = null;
		
		CT astNode = uml.createConstraint();
		
		Variable<C, PM> variable = null;
		C operType = null;
		C contextClassifier = env.getContextClassifier();
		
		SimpleNameCS simpleNameCS = defCS.getSimpleNameCS();

		if (simpleNameCS != null) {
            uml.setConstraintName(astNode, simpleNameCS.getValue());
		}
		
		List<EObject> constrainedElement = uml.getConstrainedElements(astNode);
		constrainedElement.add((EObject) contextClassifier);
		
		ExpressionInOCL<C, PM> spec = uml.createExpressionInOCL();
        uml.setSpecification(astNode, spec);
        uml.setStereotype(astNode, UMLReflection.DEFINITION);
		
		try {
			if (defExpr.getVariableCS() != null) {
				// context of the expression is the classifier
				contextEnv = env;
				
				variable = variableDeclarationCS(defExpr.getVariableCS(), contextEnv, false);
				
				P existing = env.lookupProperty(
						contextClassifier,
						variable.getName());
				if (existing != null) {
					ERROR("defCS", //$NON-NLS-1$
						OCLMessages.bind(OCLMessages.DuplicateProperty_ERROR_,
							variable.getName(),
                            uml.getName(contextEnv.getContextClassifier())));
				}
				
				spec.setContextVariable(env.getSelfVariable());
				
				// define the property now, so that recursive references to
				//    it will resolve correctly
				feature = (EObject) env.defineAttribute(
						contextClassifier,
						variable,
						astNode);
				constrainedElement.add(feature);
				
				expression = oclExpressionCS(defExpr.getExpressionCS(), contextEnv);
			} else if (defExpr.getOperationCS() != null) {
				// context of the expression is the new operation
				contextEnv = environmentFactory.createEnvironment(env);
				
				OperationCS operCS = defExpr.getOperationCS();
				
				List<Variable<C, PM>> params = variableDeclarationListCS(
						operCS.getParameters(), contextEnv, true);
				operType = typeCS(operCS.getTypeCS(), contextEnv);
				
				String operName = operCS.getSimpleNameCS().getValue();
				
				O existing = env.lookupOperation(
						contextClassifier,
						operName,
						params);
				if (existing != null) {
					ERROR("defCS", //$NON-NLS-1$
						OCLMessages.bind(OCLMessages.DuplicateOperation_ERROR_,
							operationString(env, operName, params),
                            uml.getName(contextEnv.getContextClassifier())));
				}
				
				spec.setContextVariable(env.getSelfVariable());
				spec.getParameterVariable().addAll(params);
				
				// define the operation now, so that recursive references to
				//    it will resolve correctly
				feature = (EObject) env.defineOperation(
						contextClassifier,
						defExpr.getOperationCS().getSimpleNameCS().getValue(),
						operType,
						params,
						astNode);
				constrainedElement.add(feature);
				
				expression = oclExpressionCS(defExpr.getExpressionCS(), contextEnv);
			}
			
			if ((feature != null) && (expression != null)) {
				C featureType = uml.getOCLType(feature);
				C bodyType = expression.getType();
				
				if ((featureType == null)
						|| TypeUtil.typeCompare(env, bodyType, featureType) > 0) {
					
					expression = null;  // trigger undefinition of the feature
					
					String message = OCLMessages.bind(
							OCLMessages.DefinitionConstraintConformance_ERROR_,
                            uml.getName(bodyType),
                            uml.getName(featureType));
					ERROR("defCS", message);//$NON-NLS-1$
				}
				
				spec.setBodyExpression(expression);
			}
		} finally {		
			if ((feature != null) && (expression == null)) {
				// failed to parse the body expression?  Undefine the feature
				env.undefine(feature);
			}
		}
		
		return astNode;
	}
	
	/**
	 * VariableDeclarationCS
	 * 
	 * @param variableDeclarationCS the <code>VariableDeclarationCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @param addToEnvironment boolean whether or not to add the
	 *                         the parsed variable to the environment
	 * @return the parsed <code>VariableDeclaration</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final Variable<C, PM>
	variableDeclarationCS(
			VariableCS variableDeclarationCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			boolean addToEnvironment
		) throws SemanticException {
		
		
		String varName = variableDeclarationCS.getName();
		C type = null;
		if (variableDeclarationCS.getTypeCS() != null)
			type = typeCS(variableDeclarationCS.getTypeCS(), env);

	  	OCLExpression<C> expr = null;
	  	if (variableDeclarationCS.getInitExpression() != null)
	  		expr = oclExpressionCS(variableDeclarationCS.getInitExpression(), env);
	
	  	// handle the generic typing of OclMessages
	  	if (expr != null) {
	  		C exprType = expr.getType();
	  		while (exprType instanceof CollectionType) {
				@SuppressWarnings("unchecked")
	  			CollectionType<C, O> ct = (CollectionType<C, O>) exprType;
				
	  			exprType = ct.getElementType();
	  		}
	  		
	  		if (exprType instanceof MessageType) {
	  			C varType = type;
	  			
	  			if (varType instanceof CollectionType) {
		  			do {
						@SuppressWarnings("unchecked")
		  				CollectionType<C, O> collType = (CollectionType<C, O>) varType;
		  				varType = collType.getElementType();
		  				
		  				if (varType == env.getOCLStandardLibrary().getOclMessage()) {
		  					// substitute the actual type for the generic type
		  					collType.setElementType(exprType);
		  					break;
		  				}
		  			} while (varType instanceof CollectionType);
	  			} else if (type == env.getOCLStandardLibrary().getOclMessage()) {
	  				// substitute the actual type for the generic type
	  				type = exprType;
	  			}
	  		}
	  	}
	  	
		Variable<C, PM> astNode = genVariableDeclaration(
			"variableDeclarationCS", env, varName, type, expr, //$NON-NLS-1$
			true, addToEnvironment, false);

		initStartEndPositions(astNode, variableDeclarationCS);

		if (variableDeclarationCS.getTypeCS() != null) {
			initTypePositions(astNode, variableDeclarationCS.getTypeCS());
		}

		return astNode;
	}

	/**
	 * VariableDeclarationListCS
	 * 
	 * @param variableDeclarationCS list of <code>VariableDeclarationCS</code>s
	 * @param env the OCL environment
	 * @param addToEnvironment boolean whether or not to add the
	 *                         the parsed variable to the environment
	 * @return list of <code>VariableDeclaration</code>s
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final List<Variable<C, PM>>
	variableDeclarationListCS(
			List<VariableCS> variableDeclarationCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			boolean addToEnvironment
		) throws SemanticException {
		
		List<Variable<C, PM>> variableDeclarations =
			new java.util.ArrayList<Variable<C, PM>>();
		
		for (VariableCS next : variableDeclarationCS) {
			variableDeclarations.add(
					variableDeclarationCS(next, env, addToEnvironment));
		}
		return variableDeclarations;
	}

	/**
	 * TypeCS
	 * 
	 * @param typeCS the <code>TypeCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return an <code>EClassifier</code> representing the type
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final C typeCS(
			TypeCS typeCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env)
			throws SemanticException {

		C astNode = null;

		if (typeCS instanceof PrimitiveTypeCS) {
			astNode = primitiveTypeCS(((PrimitiveTypeCS)typeCS).getType(), env);
		} else if (typeCS instanceof PathNameCS) {
			astNode = env.lookupClassifier(((PathNameCS)typeCS).getSequenceOfNames());
		} else if (typeCS instanceof CollectionTypeCS ||
				typeCS instanceof TupleTypeCS) {
			if (typeCS instanceof CollectionTypeCS) {
				astNode = collectionTypeCS((CollectionTypeCS)typeCS, env);
	
			} else if (typeCS instanceof TupleTypeCS) {
				astNode = tupleTypeCS((TupleTypeCS)typeCS, env);
			}
		}

		return astNode;
	}
	
	/**
	 * stateExpCS
	 * 
	 * @param source the source expression of the oclIsInState operation
	 * @param stateExpCS the <code>StateExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return a <code>StateExp</code> representing the state
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final StateExp<C, S>
	stateExpCS(
			OCLExpression<C> source,
			StateExpCS stateExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env)
			throws SemanticException {

		C sourceType = null;
		if (source != null) {
			sourceType = source.getType();
		}
		
		S state = null;
		
		EList<String> statePath = stateExpCS.getSequenceOfNames();
		
		if (!statePath.isEmpty()) {
			// to support content-assist, we can parse an expression that
			//   has no state, to provide suggestions for the first part
			//   of the name.  Validation of the expression will assert
			//   the presence of some referred state
			state = env.lookupState(sourceType, statePath);
	
			if (state == null) {
				ERROR("stateExpCS", //$NON-NLS-1$
						OCLMessages.bind(OCLMessages.NoSuchState_ERROR_,
								statePath,
								sourceType == null? null : uml.getName(sourceType)));
			}
		}
		
		StateExp<C, S> astNode = ExpressionsFactory.eINSTANCE.createStateExp();
		astNode.setReferredState(state);
		astNode.setType(env.getOCLStandardLibrary().getState());
		astNode.setName(makeName(statePath));
		initStartEndPositions(astNode, stateExpCS);
		
		return astNode;
	}
	
	/**
	 * CollectionTypeCS
	 * 
	 * @param collectionTypeCS the <code>CollectionTypeCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return an <code>EClassifier</code> representing the collection type
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final C collectionTypeCS(
			CollectionTypeCS collectionTypeCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) throws SemanticException {

		CollectionKind kind = collectionTypeIdentifierCS(collectionTypeCS.getCollectionTypeIdentifier());
		C type = typeCS(collectionTypeCS.getTypeCS(), env);
	
		C result = getCollectionType(env, kind, type);
		
		@SuppressWarnings("unchecked")
		CollectionType<C, O> astNode = (CollectionType<C, O>) result;
		initTypePositions(astNode, collectionTypeCS.getTypeCS());
		
		return result;
	}
	
	/**
	 * CollectionTypeIdentifierCS
	 * 
	 * @param collectionTypeIdentifier the <code>CollectionTypeIdentifierEnum</code> representing
	 *                                 the collection type
	 * @return the parsed <code>CollectionType</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final CollectionKind collectionTypeIdentifierCS(
			CollectionTypeIdentifierEnum collectionTypeIdentifier
		) throws SemanticException {
	
		CollectionKind astNode = null;

		switch (collectionTypeIdentifier.getValue()) {
			case CollectionTypeIdentifierEnum.SET:
	
				astNode = CollectionKind.SET_LITERAL;
				TRACE("collectionTypeIdentifierCS", "SET");//$NON-NLS-2$//$NON-NLS-1$
	
				break;
	
			case CollectionTypeIdentifierEnum.BAG:

				astNode = CollectionKind.BAG_LITERAL;
				TRACE("collectionTypeIdentifierCS", "BAG"); //$NON-NLS-2$//$NON-NLS-1$
						
				break;

			case CollectionTypeIdentifierEnum.SEQUENCE:

				astNode = CollectionKind.SEQUENCE_LITERAL;
				TRACE("collectionTypeIdentifierCS", "SEQUENCE"); //$NON-NLS-2$//$NON-NLS-1$
						
				break;

			case CollectionTypeIdentifierEnum.COLLECTION:

				astNode = CollectionKind.COLLECTION_LITERAL;
				TRACE("collectionTypeIdentifierCS", "COLLECTION"); //$NON-NLS-2$//$NON-NLS-1$
						
				break;

			case CollectionTypeIdentifierEnum.ORDERED_SET:

				astNode = CollectionKind.ORDERED_SET_LITERAL;
				TRACE("collectionTypeIdentifierCS", "ORDERED_SET"); //$NON-NLS-2$//$NON-NLS-1$
						
				break;
		}

		return astNode;
	}

	/**
	 * TupleTypeCS
	 * 
	 * @param tupleTypeCS the <code>TupleTypeCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>TupleTypeCS</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final C tupleTypeCS(
			TupleTypeCS tupleTypeCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {
		
		Set<String> names = new HashSet<String>();
		String nodeName = null;
		EList<Variable<C, PM>> vdcls = new BasicEList<Variable<C, PM>>();
		String name;

		List<Variable<C, PM>> variableDeclarations =
			variableDeclarationListCS(tupleTypeCS.getVariables(), env, false);

		for (Variable<C, PM> vdcl : variableDeclarations) {
			vdcls.add(vdcl);
			name = vdcl.getName();
			TRACE("tupleTypeCS", " name = " + name);//$NON-NLS-2$//$NON-NLS-1$

			if (names.contains(name)) {
				String message = OCLMessages.bind(
						OCLMessages.DuplicateNameInTuple_ERROR_,
						name);
				ERROR("tupleTypeCS", message);//$NON-NLS-1$
				vdcl.setName(null);
			} else {
				names.add(name);
			}
			
			if (vdcl.getInitExpression() != null) {
				String message = OCLMessages.bind(
						OCLMessages.InitExpNotAllowed_ERROR_,
						name);
				ERROR("tupleTypeCS", message);//$NON-NLS-1$
			}

			if (vdcl.getType() == null) {
				String message = OCLMessages.bind(
						OCLMessages.DeclarationType_ERROR_,
						name);
				ERROR("tupleTypeCS", message);//$NON-NLS-1$
			}

			if (nodeName == null) {
				nodeName = "Tuple("; //$NON-NLS-1$
			} else {
				nodeName += ", "; //$NON-NLS-1$
			}

			nodeName += vdcl.getName() + ":" + uml.getName(vdcl.getType()); //$NON-NLS-1$
		}

		return getTupleType(env, vdcls);
	}

	/**
	 * OCLExpressionCS
	 * 
	 * @param oclExpressionCS the <code>OCLExpressionCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>OCLExpression</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final OCLExpression<C> oclExpressionCS(
			OCLExpressionCS oclExpressionCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {
		
		OCLExpression<C> astNode = null;

		if (oclExpressionCS instanceof IfExpCS) {
			astNode = ifExpCS((IfExpCS)oclExpressionCS, env);
		} else if (oclExpressionCS instanceof CallExpCS) {
			astNode = propertyCallExpCS((CallExpCS)oclExpressionCS, env);
		} else if (oclExpressionCS instanceof VariableExpCS) {
			astNode = variableExpCS((VariableExpCS)oclExpressionCS, env);
		} else if (oclExpressionCS instanceof LiteralExpCS) {
			astNode = literalExpCS((LiteralExpCS)oclExpressionCS, env);
		} else if (oclExpressionCS instanceof LetExpCS) {
			astNode = letExpCS((LetExpCS)oclExpressionCS, env);
		} else if (oclExpressionCS instanceof MessageExpCS) {
			astNode = messageExpCS((MessageExpCS)oclExpressionCS, env);
		}
		
		if (astNode != null) {
			astNode.setType(TypeUtil.resolveType(env, astNode.getType())); 
			initStartEndPositions(astNode, oclExpressionCS);
		}
		
		return astNode;
	}

	/**
	 * VariableExpCS
	 * 
	 * @param variableExpCS the <code>VariableExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>OCLExpression</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final OCLExpression<C> variableExpCS(
			VariableExpCS variableExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {

		OCLExpression<C> astNode =
			simpleNameCS(variableExpCS.getSimpleNameCS(), env, null);
		List<OCLExpression<C>> qualifiers =
			qualifiersCS(variableExpCS.getArguments(), env, astNode);

		if (variableExpCS.getIsMarkedPreCS().isPre()) {
			if (astNode instanceof FeatureCallExp) {
				((FeatureCallExp<C>) astNode).setMarkedPre(true);
			} else {
				ERROR("variableExpCS", OCLMessages.IllegalAtPre_ERROR_);//$NON-NLS-1$
			}
		}
		
		if (!qualifiers.isEmpty()) {
			if (astNode instanceof NavigationCallExp) {
				setQualifiers(env, "variableExpCS", //$NON-NLS-1$
					(NavigationCallExp<C, P>) astNode,
					qualifiers);
			} else if ((astNode instanceof LoopExp)
					&& ((LoopExp<C, PM>) astNode).getBody() instanceof NavigationCallExp) {
				// might have parsed an implicit collect expression
				setQualifiers(env, "variableExpCS",//$NON-NLS-1$
					(NavigationCallExp<C, P>)
						((LoopExp<C, PM>) astNode).getBody(), qualifiers);
			} else {
				ERROR("variableExpCS", //$NON-NLS-1$
						OCLMessages.bind(
								OCLMessages.IllegalQualifiers_ERROR_,
								computeInputString(variableExpCS)));
			}
		} else if (astNode instanceof AssociationClassCallExp) {
			checkNotReflexive(env, "variableExpCS", //$NON-NLS-1$
				(AssociationClassCallExp<C, P>) astNode);
		}
		
		return astNode;
	}

	/**
	 * QualifiersCS
	 * 
	 * @param arguments the <code>OCLExpressionCS</code> arguments list
	 * @param env the OCL environment
	 * @param navigation
	 * @return the parsed <code>OCLExpression</code>s list
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final List<OCLExpression<C>> qualifiersCS(
			List<OCLExpressionCS> arguments,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			OCLExpression<C> navigation
		) throws SemanticException {

		if (arguments.isEmpty()) {
			return Collections.emptyList();
		}
		List<OCLExpression<C>> qualifiers =
			new java.util.ArrayList<OCLExpression<C>>();

		if (navigation instanceof LoopExp) {
			navigation = ((LoopExp<C, PM>) navigation).getBody();
		}
		
		if (navigation instanceof AssociationClassCallExp) {
			AssociationClassCallExp<C, P> acc =
				(AssociationClassCallExp<C, P>) navigation;
			OCLExpression<C> source = acc.getSource();
			
			OCLExpressionCS arg = arguments.get(0);

			if (!(arg instanceof VariableExpCS)) {
				ERROR("qualifiersCS",//$NON-NLS-1$
					OCLMessages.bind(OCLMessages.ParseCSTNodeType_ERROR_,
							"VariableExpCS",//$NON-NLS-1$
							arg.eClass().getName()));
			}

			SimpleNameCS qualifier = ((VariableExpCS)arg).getSimpleNameCS();
			String simpleName = qualifier.getValue();
			
			P property = env.lookupProperty(source.getType(), simpleName);
			
			if (property == null) {
				String message = OCLMessages.bind(
						OCLMessages.UnrecognizedVar_ERROR_,
						simpleName);
					ERROR("qualifiersCS", message);//$NON-NLS-1$
			}

			TRACE("qualifierCS", "Reference: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$
			PropertyCallExp<C, P> ref =
				ExpressionsFactory.eINSTANCE.createPropertyCallExp();
			ref.setReferredProperty(property);
			ref.setType(TypeUtil.getPropertyType(env, source.getType(), property));
			
			if (source == null) {
				VariableExp<C, PM> src =
					ExpressionsFactory.eINSTANCE.createVariableExp();
				Variable<C, PM> implicitSource =
					env.lookupImplicitSourceForProperty(simpleName);
				src.setType(implicitSource.getType());
				src.setReferredVariable(implicitSource);
				src.setName(implicitSource.getName());
			}

			initStartEndPositions(ref, qualifier);
			initPropertyPositions(ref, qualifier);
			qualifiers.add(ref);
		} else {
			for (OCLExpressionCS arg : arguments) {
				qualifiers.add(oclExpressionCS(arg, env));
			}
		}
		return qualifiers;
	}

	/**
	 * IfExpCS
	 * 
	 * @param ifExpCS the <code>IfExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>IfExpCS</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final IfExp<C> ifExpCS(
			IfExpCS ifExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {

		OCLExpression<C> condition =
			oclExpressionCS(ifExpCS.getCondition(), env);
		OCLExpression<C> thenExpression =
			oclExpressionCS(ifExpCS.getThenExpression(), env);
		OCLExpression<C> elseExpression =
			oclExpressionCS(ifExpCS.getElseExpression(), env);

		TRACE("ifExpCS", " "); //$NON-NLS-2$//$NON-NLS-1$
	
        if (condition.getType() != getBoolean()) {
			ERROR("ifExpCS", OCLMessages.bind( //$NON-NLS-1$
					OCLMessages.BooleanForIf_ERROR_,
					computeInputString(ifExpCS.getCondition())));
		}
				
		IfExp<C> astNode = ExpressionsFactory.eINSTANCE.createIfExp();
		astNode.setCondition(condition);
		astNode.setThenExpression(thenExpression);
		astNode.setElseExpression(elseExpression);
		astNode.setType(TypeUtil.commonSuperType(
				env,
				thenExpression.getType(),
				elseExpression.getType()));

		initStartEndPositions(astNode, ifExpCS);
	
		return astNode;
	}

	/**
	 * LetExpCS
	 * 
	 * @param letExpCS the <code>LetExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>LetExpCS</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final LetExp<C, PM> letExpCS(
			LetExpCS letExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {
		
		return (LetExp<C, PM>) letExpCSRecursive(letExpCS, 0, env);
	}

	/**
	 * Constructs the LetExp
	 * 
	 * @param letExpCS the <code>LetExpCS</code> <code>CSTNode</code>
	 * @param index the index of the VariableDeclarationCS to parse
	 * @param env the OCL environment
	 * @return the parsed <code>OCLExpression</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final OCLExpression<C>
	letExpCSRecursive(
			LetExpCS letExpCS,
			int index,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {

		OCLExpression<C> astNode;

		if (index < letExpCS.getVariables().size()) {
			Variable<C, PM> variableDeclaration =
				variableDeclarationCS(letExpCS.getVariables().get(index),
					env, true);
	
			String varName = variableDeclaration.getName();
	
			if (variableDeclaration.getType() == null) {
				String message = OCLMessages.bind(
						OCLMessages.DeclarationType_ERROR_,
						varName);
				ERROR("letExpCS", message);//$NON-NLS-1$
			}
			if (variableDeclaration.getInitExpression() == null) {
				String message = OCLMessages.bind(
						OCLMessages.DeclarationNoInitExp_ERROR_,
						varName);
				ERROR("letExpCS", message);//$NON-NLS-1$
			}
					
			OCLExpression<C> letSubExp =
				letExpCSRecursive(letExpCS, ++index, env);
	
			LetExp<C, PM> letExp =
				ExpressionsFactory.eINSTANCE.createLetExp(); 
			letExp.setVariable(variableDeclaration);
			letExp.setIn(letSubExp);
			letExp.setType(letSubExp.getType());		
			astNode = letExp;
			env.deleteElement(varName);
		} else {
			astNode = oclExpressionCS(letExpCS.getInExpression(), env);
		}

		return astNode;
	}

	/**
	 * SimpleNameCS
	 * 
	 * @param simpleNameCS the <code>SimpleNameCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @param source the source of the <code>SimpleNameCS</code>
	 * @return the parsed <code>OCLExpression</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final OCLExpression<C> simpleNameCS(
			SimpleNameCS simpleNameCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			OCLExpression<C> source
		) throws SemanticException {

		OCLExpression<C> astNode;

		String simpleName = null;
		
		astNode = null;
		P property = null;
		C classifier = null;
		PropertyCallExp<C, P> propertyCall = null;
		C assocClass = null;
		AssociationClassCallExp<C, P> acref = null;
		Variable<C, PM> vdcl = null;

		/* A name can be a variable defined by a Variable declaration, the special
		  variable "self", an attribute or a reference to another object.
		  If the source is not null, then the last token was a "." or "->"
		  The source is used to establish the navigation.
		  If no type is provided, then either the name is a the use of a variable,
		  or there is an implicit variable declaration (self or an iterator)
		  that is the source.		  		   
		 */
		switch (simpleNameCS.getType().getValue()) {
			case SimpleTypeEnum.SELF:
			case SimpleTypeEnum.KEYWORD:
			case SimpleTypeEnum.IDENTIFIER:
				simpleName = simpleNameCS.getValue();
				break;
			case SimpleTypeEnum.INTEGER:
			case SimpleTypeEnum.STRING:
			case SimpleTypeEnum.REAL:
			case SimpleTypeEnum.BOOLEAN:
			case SimpleTypeEnum.OCL_ANY:
			case SimpleTypeEnum.OCL_VOID:
			case SimpleTypeEnum.INVALID:
			case SimpleTypeEnum.OCL_MESSAGE:
				// if we have a source, then this is a feature call
				if (source == null) {
					classifier = primitiveTypeCS(simpleNameCS.getType(), env);
					simpleName = uml.getName(classifier);
				}
				break;
		}

					
		/*
		 * The source may be a collection type (for example, in self.children.name, children
		 * may be a set.)_  In this case, we have to get the element type of children, so
		 * that the attribute name can be found.
		 * The source type can also be a tuple type. In this case, we need to get the 
		 * EClass of the tuple.
		 * 
		 */ 
		C sourceElementType = null;
		if (source != null) {
			sourceElementType = source.getType();
			if (sourceElementType instanceof CollectionType) {
				@SuppressWarnings("unchecked")
				CollectionType<C, O> ct = (CollectionType<C, O>) sourceElementType;
				
				sourceElementType = ct.getElementType();
			} 
		}
		
		List<String> names = new java.util.ArrayList<String>();
		names.add(simpleName);
		
		// if we have a source, then this is a feature call
		if ((classifier == null) && (source == null)) {
				classifier = env.lookupClassifier(names);
		}
		
		if (classifier != null) {
			/* Variable is a classifier. Classifiers are used in
			 * allInstances, isKindOf, isTypeOf, asTypeOf operators
			 */
			
			TypeExp<C> texp =
				ExpressionsFactory.eINSTANCE.createTypeExp();
			texp.setReferredType(classifier);
			
			texp.setType(getTypeType(env, classifier));
			astNode = texp;			 		
		} else if (source == null && (vdcl = env.lookup(simpleName)) != null)  { 
			// Either a use of a declared variable or self

			TRACE("variableExpCS", "Variable Expression: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$
			
			/*if (source != null) {
				ERROR("simpleVariableExp", "Can't have a variable in the middle of a navigation path:"
								+ simpleName);
			}*/
			VariableExp<C, PM> vexp = 
				ExpressionsFactory.eINSTANCE.createVariableExp();	
			vexp.setReferredVariable(vdcl);
			vexp.setName(vdcl.getName());
			vexp.setType(vdcl.getType());
			astNode = vexp;
		} else if ((property = env.lookupProperty( sourceElementType, simpleName)) != null) {
			
			TRACE("variableExpCS", "Property: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$
			propertyCall = ExpressionsFactory.eINSTANCE.createPropertyCallExp();
			propertyCall.setReferredProperty(property);
			propertyCall.setType(
					TypeUtil.getPropertyType(env, sourceElementType, property));
			if (source != null) {
				propertyCall.setSource(source);
			} else {
				VariableExp<C, PM> src =
					ExpressionsFactory.eINSTANCE.createVariableExp();
				Variable<C, PM> implicitSource =
					env.lookupImplicitSourceForProperty(simpleName);
				src.setType(implicitSource.getType());
				src.setReferredVariable(implicitSource);
				src.setName(implicitSource.getName());
				propertyCall.setSource(src);
			}

			initPropertyPositions(propertyCall, simpleNameCS);
			astNode = propertyCall;
						
		} else if ((assocClass = env.lookupAssociationClassReference(sourceElementType, simpleName)) != null) {
			TRACE("variableExpCS", "Association class: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$
			acref = ExpressionsFactory.eINSTANCE.createAssociationClassCallExp();
			acref.setReferredAssociationClass(assocClass);
			
			if (source != null) {
				acref.setSource(source);
			} else {
				VariableExp<C, PM> src =
					ExpressionsFactory.eINSTANCE.createVariableExp();
				Variable<C, PM> implicitSource =
					env.lookupImplicitSourceForAssociationClass(simpleName);
				src.setType(implicitSource.getType());
				src.setReferredVariable(implicitSource);
				src.setName(implicitSource.getName());
				acref.setSource(src);
			}
			
			// infer the navigation source and type of the association class
			//   call expression from the association class end that is
			//   implicitly navigated (in case it is not explicit as a qualifier)
			C acrefType = null;
			C sourceType = getElementType(acref.getSource().getType());
			List<P> ends = uml.getMemberEnds(assocClass);
			List<P> available = uml.getAttributes(sourceType);
			
			for (P end : ends) {
				if (available.contains(end)) {
					// this is the navigation source
					acref.setNavigationSource(end);
					
					CollectionKind kind = getCollectionKind(uml.getOCLType(end));
					if (kind != null) {
						acrefType = getCollectionType(env, kind, assocClass);
					} else {
						acrefType = assocClass;
					}
				}
			}
			
			if (acrefType == null) {
				// for non-navigable association classes, assume set type
				acrefType = getSetType(env, assocClass);
			}
			acref.setType(acrefType);

			initPropertyPositions(acref, simpleNameCS);
			astNode = acref;
			
		} else {
			if (source != null && (vdcl = env.lookup(simpleName)) != null) {
				String message = OCLMessages.bind(
						OCLMessages.VarInNavExp_ERROR_,
						simpleName);
					ERROR("variableExpCS", message);//$NON-NLS-1$
			} else {
				String message = OCLMessages.bind(
						OCLMessages.UnrecognizedVar_ERROR_,
						simpleName);
					ERROR("variableExpCS", message);//$NON-NLS-1$
			}
		}
		
		/*
		 * If the source type is a collection, then need there is an implicit COLLECT operator.
		 * Note that this rule is not called after "->".
		 */
		if (source != null && source.getType() instanceof CollectionType) {
			astNode = createImplicitCollect(
				source,
				(FeatureCallExp<C>) astNode,
				env);
		}

		return astNode;
	}

	/**
	 * Creates an implicit <code>collect</code> iterator expression for a
	 * property call on a collection-type source expression.
	 * 
	 * @param source the property call source expression
	 * @param propertyCall the property call expression
	 * @param env the current environment
	 * 
	 * @return the collect expression
	 * 
	 * @throws SemanticException on failure to create the collect iterator variable
	 */
	private IteratorExp<C, PM> createImplicitCollect(OCLExpression<C> source,
			FeatureCallExp<C> propertyCall,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) throws SemanticException {
		
		@SuppressWarnings("unchecked")
		C sourceElementType = ((CollectionType<C, O>) source.getType())
			.getElementType();
		
		IteratorExp<C, PM> result = ExpressionsFactory.eINSTANCE.createIteratorExp();
		
		Variable<C, PM> itervar =
			genVariableDeclaration("modelPropertyCallCS", env,//$NON-NLS-1$
						null, sourceElementType, null, false, true, false);

		List<Variable<C, PM>> iters = result.getIterator();
		iters.add(itervar);
		result.setBody(propertyCall);
		result.setName("collect");//$NON-NLS-1$
		VariableExp<C, PM> vexp =
			ExpressionsFactory.eINSTANCE.createVariableExp();
		vexp.setType(itervar.getType());
		vexp.setReferredVariable(itervar);
		vexp.setName(itervar.getName());
		
		/* adjust the source variable for the body expression to be the
		   newly generated implicit iterator variable */
		propertyCall.setSource(vexp);
		
		if (!(propertyCall instanceof OperationCallExp)) {
			// the overall start and end positions are the property positions
			propertyCall.setStartPosition(propertyCall.getPropertyStartPosition());
			propertyCall.setEndPosition(propertyCall.getPropertyEndPosition());
		}
		
		result.setSource(source);
		
		// the result of a collect() is flattened, so if the property
		//   that we are collecting is a Collection type, the resulting
		//   type must be flattened by taking its element type
		C bodyType = propertyCall.getType();
		if (bodyType instanceof CollectionType) {
			@SuppressWarnings("unchecked")
			CollectionType<C, O> ct = (CollectionType<C, O>) bodyType;
			
			bodyType = ct.getElementType();
		}
		
		if (source.getType() instanceof SequenceType ||
				source.getType() instanceof OrderedSetType) {
			C c = getCollectionType(
					env,
					CollectionKind.SEQUENCE_LITERAL,
					bodyType);
			result.setType(c);
		} else {
			C c = getCollectionType(
					env,
					CollectionKind.BAG_LITERAL,
					bodyType);
			result.setType(c);
		}
		
		env.deleteElement(itervar.getName());
		
		return result;
	}
	
	/**
	 * PrimitiveTypeCS
	 * 
	 * @param simpleType the <code>SimpleTypeEnum</code> representing the primitive type
	 * @return an <code>EClassifie</code> representing the primitive type
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final C primitiveTypeCS(SimpleTypeEnum simpleType,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env)
			throws SemanticException {
		
		C astNode = null;

		switch (simpleType) {
			case INTEGER_LITERAL:
				astNode = env.getOCLStandardLibrary().getInteger();
				break;
	
            case UNLIMITED_NATURAL_LITERAL:
                astNode = env.getOCLStandardLibrary().getUnlimitedNatural();
                break;
    
			case STRING_LITERAL:
				astNode = env.getOCLStandardLibrary().getString();
				break;
	
			case REAL_LITERAL:
				astNode = env.getOCLStandardLibrary().getReal();
				break;
	
			case BOOLEAN_LITERAL:
				astNode = env.getOCLStandardLibrary().getBoolean();
				break;
	
			case OCL_ANY_LITERAL:
				astNode = env.getOCLStandardLibrary().getOclAny();
				break;
	
			case OCL_VOID_LITERAL:
				astNode = env.getOCLStandardLibrary().getOclVoid();
				break;
				
			case INVALID_LITERAL:
				astNode = env.getOCLStandardLibrary().getInvalid();
				break;
				
			case OCL_MESSAGE_LITERAL:
				astNode = env.getOCLStandardLibrary().getOclMessage();
				break;
		}
		return astNode;
	}

	/**
	 * PrimitiveLiteralExpCS
	 * 
	 * @param primitiveLiteralExpCS the <code>PrimitiveLiteralExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>LiteralExp</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final LiteralExp<C>  primitiveLiteralExpCS(
			PrimitiveLiteralExpCS primitiveLiteralExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {

		LiteralExp<C> astNode = null;
		
		if (primitiveLiteralExpCS instanceof IntegerLiteralExpCS) {
			astNode = integerLiteralExpCS((IntegerLiteralExpCS)primitiveLiteralExpCS, env);
        } else if (primitiveLiteralExpCS instanceof UnlimitedNaturalLiteralExpCS) {
            astNode = unlimitedNaturalLiteralExpCS((UnlimitedNaturalLiteralExpCS)primitiveLiteralExpCS, env);
		} else if (primitiveLiteralExpCS instanceof RealLiteralExpCS) {
			astNode = realLiteralExpCS((RealLiteralExpCS)primitiveLiteralExpCS, env);
		} else if (primitiveLiteralExpCS instanceof StringLiteralExpCS) {
			astNode = stringLiteralExpCS((StringLiteralExpCS)primitiveLiteralExpCS, env);
		} else if (primitiveLiteralExpCS instanceof BooleanLiteralExpCS) {
			astNode = booleanLiteralExpCS((BooleanLiteralExpCS)primitiveLiteralExpCS, env);
		}

		return astNode;
	}

	/**
	 * IntegerLiteralExpCS
	 * 
	 * @param integerLiteralExpCS the <code>IntegerLiteralExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>IntegerLiteralExp</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final IntegerLiteralExp<C> integerLiteralExpCS(
			IntegerLiteralExpCS integerLiteralExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {
	
		IntegerLiteralExp<C> astNode = ExpressionsFactory.eINSTANCE.createIntegerLiteralExp();
		astNode.setIntegerSymbol(integerLiteralExpCS.getIntegerSymbol());
		astNode.setType(env.getOCLStandardLibrary().getInteger());
		astNode.setName(PrimitiveType.INTEGER_NAME);
		TRACE("integerLiteralExpCS", "Integer: " + integerLiteralExpCS.getSymbol());//$NON-NLS-2$//$NON-NLS-1$
			
		return astNode;
	}

    /**
     * UnlimitedNaturalLiteralExpCS
     * 
     * @param unlimitedNaturalLiteralExpCS the <code>UnlimitedNaturalLiteralExpCS</code> <code>CSTNode</code>
     * @param env the OCL environment
     * @return the parsed <code>UnlimitedNaturalLiteralExp</code>
     * @throws SemanticException if the expression contains semantic errors
     */
    protected final UnlimitedNaturalLiteralExp<C> unlimitedNaturalLiteralExpCS(
            UnlimitedNaturalLiteralExpCS unlimitedNaturalLiteralExpCS,
            Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
        ) throws SemanticException {
    
        UnlimitedNaturalLiteralExp<C> astNode = ExpressionsFactory.eINSTANCE.createUnlimitedNaturalLiteralExp();
        astNode.setIntegerSymbol(unlimitedNaturalLiteralExpCS.getIntegerSymbol());
        astNode.setType(env.getOCLStandardLibrary().getUnlimitedNatural());
        astNode.setName(PrimitiveType.UNLIMITED_NATURAL_NAME);
        TRACE("unlimitedNaturalLiteralExpCS", "UnlimitedNatural: " + unlimitedNaturalLiteralExpCS.getSymbol());//$NON-NLS-2$//$NON-NLS-1$
            
        return astNode;
    }
		
	/**
	 * RealLiteralExpCS
	 * 
	 * @param realLiteralExpCS the <code>RealLiteralExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>RealLiteralExp</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final RealLiteralExp<C> realLiteralExpCS(
			RealLiteralExpCS realLiteralExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {

		RealLiteralExp<C> astNode =
			ExpressionsFactory.eINSTANCE.createRealLiteralExp();
		astNode.setRealSymbol(realLiteralExpCS.getRealSymbol());
		astNode.setType(env.getOCLStandardLibrary().getReal());
		astNode.setName(PrimitiveType.REAL_NAME);
		TRACE("realLiteralExpCS", "Real: " + realLiteralExpCS.getSymbol());//$NON-NLS-2$//$NON-NLS-1$
			
		return astNode;
	}
	
	/**
	 * StringLiteralExpCS
	 * 
	 * @param stringLiteralExpCS the <code>StringLiteralExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>StringLiteralExp</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final StringLiteralExp<C> stringLiteralExpCS(
			StringLiteralExpCS stringLiteralExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {

		StringLiteralExp<C> astNode =
			ExpressionsFactory.eINSTANCE.createStringLiteralExp();
		String stringLiteral = stringLiteralExpCS.getStringSymbol();
		if (stringLiteral.length() <= 2) {
			astNode.setStringSymbol("");//$NON-NLS-1$
		} else {
			astNode.setStringSymbol(stringLiteral.substring(1, stringLiteral.length()-1));
		}
		astNode.setType(env.getOCLStandardLibrary().getString());
		astNode.setName(PrimitiveType.STRING_NAME);
		TRACE("stringLiteralExpCS", "String: " + stringLiteralExpCS.getSymbol());//$NON-NLS-2$//$NON-NLS-1$
			
		return astNode;
	}
	
	/**
	 * BooleanLiteralExpCS
	 * 
	 * @param booleanLiteralExpCS the <code>BooleanLiteralExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>BooleanLiteralExp</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final BooleanLiteralExp<C> booleanLiteralExpCS(
			BooleanLiteralExpCS booleanLiteralExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {
		
		BooleanLiteralExp<C> astNode =
			ExpressionsFactory.eINSTANCE.createBooleanLiteralExp(); 
		astNode.setBooleanSymbol(booleanLiteralExpCS.getBooleanSymbol());
		astNode.setType(env.getOCLStandardLibrary().getBoolean());
		astNode.setName(PrimitiveType.BOOLEAN_NAME);
		TRACE("booleanLiteralExpCS", "Boolean: " + booleanLiteralExpCS.getSymbol());//$NON-NLS-2$//$NON-NLS-1$
			
		return astNode;
	}
	
	/**
	 * NullLiteralExpCS
	 * 
	 * @param nullLiteralExpCS the <code>NullLiteralExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>NullLiteralExp</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final NullLiteralExp<C> nullLiteralExpCS(
			NullLiteralExpCS nullLiteralExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {
		
		NullLiteralExp<C> astNode = ExpressionsFactory.eINSTANCE.createNullLiteralExp(); 
		astNode.setType(env.getOCLStandardLibrary().getOclVoid());
		astNode.setName("OclVoid");//$NON-NLS-1$
		TRACE("nullLiteralExpCS", "OclVoid: null");//$NON-NLS-2$//$NON-NLS-1$
			
		return astNode;
	}
	
	/**
	 * InvalidLiteralExpCS
	 * 
	 * @param invalidLiteralExpCS the <code>InvalidLiteralExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>InvalidLiteralExp</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final InvalidLiteralExp<C> invalidLiteralExpCS(
			InvalidLiteralExpCS nullLiteralExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {
		
		InvalidLiteralExp<C> astNode =
			ExpressionsFactory.eINSTANCE.createInvalidLiteralExp(); 
		astNode.setType(env.getOCLStandardLibrary().getInvalid());
		astNode.setName("Invalid");//$NON-NLS-1$
		TRACE("invalidLiteralExpCS", "Invalid: OclInvalid");//$NON-NLS-2$//$NON-NLS-1$
			
		return astNode;
	}
	
	/**
	 * LiteralExpCS
	 * 
	 * @param literalExpCS the <code>LiteralExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>LiteralExp</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final OCLExpression<C> literalExpCS(
			LiteralExpCS literalExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {

		OCLExpression<C> astNode = null;

		if (literalExpCS instanceof PrimitiveLiteralExpCS) {
			astNode = primitiveLiteralExpCS((PrimitiveLiteralExpCS)literalExpCS, env);
		} else if (literalExpCS instanceof CollectionLiteralExpCS) {
			astNode = collectionLiteralExpCS((CollectionLiteralExpCS)literalExpCS, env);
		} else if (literalExpCS instanceof TupleLiteralExpCS) {
			astNode = tupleLiteralExpCS((TupleLiteralExpCS)literalExpCS, env);
		} else if (literalExpCS instanceof EnumLiteralExpCS) {
			astNode = enumLiteralExpCS((EnumLiteralExpCS)literalExpCS, env);
		} else if (literalExpCS instanceof NullLiteralExpCS) {
			astNode = nullLiteralExpCS((NullLiteralExpCS)literalExpCS, env);
		} else if (literalExpCS instanceof InvalidLiteralExpCS) {
			astNode = invalidLiteralExpCS((InvalidLiteralExpCS)literalExpCS, env);
		}

		return astNode;
	}

	
	/**
	 * TupleLiteralExpCS
	 * 
	 * @param tupleLiteralExpCS the <code>TupleLiteralExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>TupleLiteralExp</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final TupleLiteralExp<C, P> tupleLiteralExpCS(
			TupleLiteralExpCS tupleLiteralExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {
		
		TupleLiteralExp<C, P> astNode;
			
		HashSet<String> names = new HashSet<String>();
		String nodeName = null;
		String name;

		astNode = ExpressionsFactory.eINSTANCE.createTupleLiteralExp();
		EList<TupleLiteralPart<C, P>> tupleParts = astNode.getPart();
		TRACE("tupleLiteralExpCS", "Tuple");//$NON-NLS-2$//$NON-NLS-1$

		EList<TupleLiteralPart<C, P>> tupleLiteralParts =
			tupleLiteralPartListCS(tupleLiteralExpCS.getVariables(), env);

		for (TupleLiteralPart<C, P> part : tupleLiteralParts) {
			tupleParts.add(part);
			name = part.getName();
			TRACE("tupleLiteralExpCS", " name = " + name);//$NON-NLS-2$//$NON-NLS-1$

			if (names.contains(name)) {
				String message = OCLMessages.bind(
						OCLMessages.DuplicateNameInTuple_ERROR_,
						name);
				ERROR("tupleLiteralPartCS", message);//$NON-NLS-1$
				part.setName(null);
			} else {
				names.add(name);
			}
			
			if (part.getValue() == null) {
				String message = OCLMessages.bind(
					OCLMessages.MissingTypeInTupleLiteralPart_ERROR_,
					name, computeInputString(tupleLiteralExpCS));
				ERROR("tupleLiteralExpCS", message);//$NON-NLS-1$
			}

			if (part.getType() == null) {
				// type is implied from init expression
				part.setType(part.getValue().getType());
			}

			if (nodeName == null) {
				nodeName = "Tuple{"; //$NON-NLS-1$
			} else {
				nodeName += ", "; //$NON-NLS-1$
			}

			nodeName += part.getName() + ":" + uml.getName(part.getType()); //$NON-NLS-1$
		}

		C tt = getTupleType(env, tupleParts);
		
		astNode.setType(tt);
		
		for (TupleLiteralPart<C, P> part : tupleParts) {
			part.setAttribute(env.lookupProperty(tt, part.getName()));
		}
		
		return astNode;
	}

	/**
	 * tupleLiteralPartListCS
	 * 
	 * @param variableDeclarations list of <code>VariableDeclarationCS</code>es
	 * @param env the OCL environment
	 * 
	 * @return list of <code>TupleLiteralPart</code>s
	 * @throws SemanticException if the expression contains semantic errors
	 */
	private EList<TupleLiteralPart<C, P>> tupleLiteralPartListCS(
		List<VariableCS> variableDeclarations,
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env)
			throws SemanticException {
		
		EList<TupleLiteralPart<C, P>> result = new BasicEList<TupleLiteralPart<C, P>>();
		
		for (Iterator<VariableCS> i = variableDeclarations.iterator(); i.hasNext(); ) {
			result.add(tupleLiteralPartCS(i.next(), env));
		}
		
		return result;
	}
	
	/**
	 * tupleLiteralPartCS
	 * 
	 * @param variableDeclarationCS the <code>VariableDeclarationCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @param addToEnvironment boolean whether or not to add the
	 *                         the parsed variable to the environment
	 * @return the parsed <code>VariableDeclaration</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	private TupleLiteralPart<C, P> tupleLiteralPartCS(
			VariableCS variableDeclarationCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) throws SemanticException {
		
		String varName = variableDeclarationCS.getName();
		C type = null;
		if (variableDeclarationCS.getTypeCS() != null)
			type = typeCS(variableDeclarationCS.getTypeCS(), env);

	  	OCLExpression<C> expr = null;
	  	if (variableDeclarationCS.getInitExpression() != null)
	  		expr = oclExpressionCS(variableDeclarationCS.getInitExpression(), env);
	
		TupleLiteralPart<C, P> astNode =
			ExpressionsFactory.eINSTANCE.createTupleLiteralPart();
		astNode.setName(varName);
		astNode.setType(type);
		astNode.setValue(expr);

		initStartEndPositions(astNode, variableDeclarationCS);

		if (variableDeclarationCS.getTypeCS() != null) {
			initTypePositions(astNode, variableDeclarationCS.getTypeCS());
		}

		return astNode;
	}

	/**
	 * EnumLiteralExpCS
	 * 
	 * @param enumLiteralExpCS the <code>EnumLiteralExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>EnumLiteralExp</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final OCLExpression<C> enumLiteralExpCS(
			EnumLiteralExpCS enumLiteralExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {

		OCLExpression<C> astNode = null;

		EList<String> sequenceOfNames = new BasicEList<String>(
                enumLiteralExpCS.getPathNameCS().getSequenceOfNames());
		String lastToken = enumLiteralExpCS.getSimpleNameCS().getValue();

		EL literal = null;
        P attribute = null;
		C enumType = env.lookupClassifier(sequenceOfNames);
		if (enumType == null) {
			
			// Check to see whether the pathname corresponds to a type
			sequenceOfNames.add(lastToken);
			C type = env.lookupClassifier(sequenceOfNames);
			if (type == null) {
				String message = OCLMessages.bind(
						OCLMessages.UnrecognizedType_ERROR_,
						sequenceOfNames);
				ERROR("enumerationOrClassLiteralExpCS", message);//$NON-NLS-1$
			} else {
                astNode = typeCS(type, env);
			}
		} else {
            if (uml.isEnumeration(enumType)) {
                // look first for an enumeration literal with this name, rather
                //    than a static attribute
                literal = uml.getEnumerationLiteral(enumType, lastToken);
                if (literal == null) {
                    // try looking for a static attribute
                    attribute = env.lookupProperty(enumType, lastToken);
                }
            } else {
                // look for a static attribute
                attribute = env.lookupProperty(enumType, lastToken);
            }
            
            if (literal != null) {
    			astNode = ExpressionsFactory.eINSTANCE.createEnumLiteralExp();
    			
    			EnumLiteralExp<C, EL> litExp = (EnumLiteralExp<C, EL>) astNode;
    			litExp.setReferredEnumLiteral(literal);
    			astNode = litExp;
    			if (enumType == null || literal == null) {
    				astNode.setType(env.getOCLStandardLibrary().getInvalid());
    			} else {
    				astNode.setType(enumType);
    			}
            } else if (attribute != null) {
                if (!uml.isStatic(attribute)) {
                    String message = OCLMessages.bind(
                        OCLMessages.NonStaticAttribute_ERROR_,
                        lastToken);
                    ERROR("enumerationOrClassLiteralExpCS", message);//$NON-NLS-1$
                }
                
                PropertyCallExp<C, P> pcExp = ExpressionsFactory.eINSTANCE.createPropertyCallExp();
                astNode = pcExp;
                
                TypeExp<C> typeExp = typeCS(enumType, env);
                initStartEndPositions(typeExp, enumLiteralExpCS.getPathNameCS());
                
                pcExp.setSource(typeExp);
                pcExp.setReferredProperty(attribute);
                pcExp.setType(TypeUtil.getPropertyType(env, enumType, attribute));
                pcExp.setName(lastToken);
                
                initPropertyPositions(pcExp, enumLiteralExpCS.getSimpleNameCS());
            } else {
                // try looking for a nested classifier
                sequenceOfNames.add(lastToken);
                
                C type = env.lookupClassifier(sequenceOfNames);
                if (type == null) {
                    String message = OCLMessages.bind(
                        OCLMessages.UnrecognizedEnum_ERROR_,
                        lastToken);
                    ERROR("enumerationOrClassLiteralExpCS", message);//$NON-NLS-1$
                } else {
                    astNode = typeCS(type, env);
                }
            }
		}
		String traceText = new String();
		for (String next : sequenceOfNames) {
			traceText += next + "::"; //$NON-NLS-1$
		}
		traceText += lastToken;
		TRACE("enumerationOrClassLiteralExpCS", traceText); //$NON-NLS-1$
			
		return astNode;
	}
    
    private TypeExp<C> typeCS(C type,
        Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
        
        TypeExp<C> astNode = ExpressionsFactory.eINSTANCE.createTypeExp();
        astNode.setReferredType(type);
        astNode.setType(getTypeType(env, type));
        
        return astNode;
    }

	/**
	 * CollectionLiteralExpCS
	 * 
	 * @param collectionLiteralExpCS the <code>CollectionLiteralExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>CollectionLiteralExp</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final CollectionLiteralExp<C> collectionLiteralExpCS(
			CollectionLiteralExpCS collectionLiteralExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {

		CollectionLiteralExp<C> astNode;

		astNode = null;
		CollectionKind kind = null;
		CollectionLiteralPart<C> collectionLiteralPartExp = null;
		List<CollectionLiteralPart<C>> collectionParts = null;
		C type = null;
		C resultType = null;
		
		kind = collectionTypeIdentifierCS(collectionLiteralExpCS.getCollectionType());
		
		astNode = ExpressionsFactory.eINSTANCE.createCollectionLiteralExp();
		astNode.setKind(kind);
		collectionParts = astNode.getPart();
		
		EList<CollectionLiteralPartCS> collectionLiteralPartsCS =
			collectionLiteralExpCS.getCollectionLiteralParts();
		
		if (!collectionLiteralPartsCS.isEmpty()) {
			Iterator<CollectionLiteralPartCS> i = collectionLiteralPartsCS.iterator();
			
			CollectionLiteralPartCS colPart = i.next();
			collectionLiteralPartExp = collectionLiteralPartCS(colPart, env);
			collectionParts.add(collectionLiteralPartExp);				
			type = collectionLiteralPartExp.getType();
	
			while (i.hasNext()) {
					collectionLiteralPartExp = collectionLiteralPartCS(
						i.next(), env);
					C type1 = collectionLiteralPartExp.getType();					
					type = TypeUtil.commonSuperType(env, type, type1);
					collectionParts.add(collectionLiteralPartExp);
			}
		}
		
		if (collectionParts.isEmpty()) {
			// absolute wildcard element type
			resultType = getCollectionType(env, kind,
					env.getOCLStandardLibrary().getOclVoid());
		} else {
			resultType = getCollectionType(env, kind, type);
		}
		
		astNode.setType(resultType);
		 
		return astNode;
	}

	/**
	 * CollectionLiteralPartCS
	 * 
	 * @param collectionLiteralPartCS the <code>CollectionLiteralPartCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>CollectionLiteralPart</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final CollectionLiteralPart<C> collectionLiteralPartCS(
			CollectionLiteralPartCS collectionLiteralPartCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {

		CollectionLiteralPart<C> astNode;

		astNode = null;
		OCLExpression<C> expr1 = null;
		OCLExpression<C> expr2 = null;
		CollectionRange<C> collRange = null;
		CollectionItem<C> collItem = null;

		expr1 = oclExpressionCS(collectionLiteralPartCS.getExpressionCS(), env);

		if (collectionLiteralPartCS instanceof CollectionRangeCS) {
			CollectionRangeCS collectionRangeCS = (CollectionRangeCS)collectionLiteralPartCS;
			expr2 = oclExpressionCS(collectionRangeCS.getLastExpressionCS(), env);
			
			collRange = ExpressionsFactory.eINSTANCE.createCollectionRange();
			collRange.setFirst(expr1);
			collRange.setLast(expr2);
			collRange.setType(expr1.getType());
			
			if (expr1.getType() != expr2.getType()) {
				ERROR("collectionLiteralPartCS", //$NON-NLS-1$
					OCLMessages.bind(
							OCLMessages.FirstLastTypeMismatch_ERROR_,
							computeInputString(collectionLiteralPartCS)));
			}
			astNode = collRange;
			TRACE("collectionLiteralPartCS", "collection range");//$NON-NLS-2$//$NON-NLS-1$
		} else {
			collItem = ExpressionsFactory.eINSTANCE.createCollectionItem();
			collItem.setType(expr1.getType());
			collItem.setItem(expr1);
			astNode = collItem;
			TRACE("collectionLiteralPartCS", "collection item");//$NON-NLS-2$//$NON-NLS-1$
		}
			
		return astNode;
	}
	
	/**
	 * PropertyCallExpCS
	 * 
	 * @param propertyCallExpCS the <code>PropertyCallExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>OCLExpression</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final OCLExpression<C> propertyCallExpCS(
			CallExpCS propertyCallExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {
		
		OCLExpression<C> astNode = null;
		
		if (propertyCallExpCS instanceof LoopExpCS) {
			astNode = loopExpCS((LoopExpCS)propertyCallExpCS, env);
		} else if (propertyCallExpCS instanceof FeatureCallExpCS) {
			astNode = modelPropertyCallExpCS((FeatureCallExpCS)propertyCallExpCS, env);
		}

		initStartEndPositions(astNode, propertyCallExpCS);
		return astNode;
	}
	
	/**
	 * LoopExpCS
	 * 
	 * @param loopExpCS the <code>LoopExpCS</code> <code>CSTNode</code> 
	 * @param env the OCL environment
	 * @return the parsed <code>LoopExp</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final LoopExp<C, PM> loopExpCS(
			LoopExpCS loopExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {
		
		LoopExp<C, PM> astNode = null;
		
		if (loopExpCS instanceof IteratorExpCS) {
			astNode = iteratorExpCS((IteratorExpCS)loopExpCS, env);
		} else if (loopExpCS instanceof IterateExpCS) {
			astNode = iterateExpCS((IterateExpCS)loopExpCS, env);
		}

		return astNode;
	}

	/**
	 * OCLExpressionCS
	 * 
	 * @param oclExpressionCS the <code>OCLExpressionCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>OCLExpression</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final OCLExpression<C> getCollectionSourceExpression(
			OCLExpressionCS oclExpressionCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
			) throws SemanticException {
	
		OCLExpression<C> astNode =
			oclExpressionCS(oclExpressionCS, env);

		/* The source must be a collection type.
   	  	 */
		if (!(astNode.getType() instanceof CollectionType)) {
			CollectionLiteralExp<C> astNode1 =
				ExpressionsFactory.eINSTANCE.createCollectionLiteralExp();
			astNode1.setKind(CollectionKind.SET_LITERAL);
			List<CollectionLiteralPart<C>> collectionParts =
				astNode1.getPart();
			CollectionItem<C> collItem =
				ExpressionsFactory.eINSTANCE.createCollectionItem();
			collItem.setType(astNode.getType());
			collItem.setItem(astNode);				
			collectionParts.add(collItem);
			
			C type = getCollectionType(env, astNode1.getKind(), astNode.getType());
			
			astNode1.setType(type);
			astNode = astNode1;
		}

   	  	return astNode;
	}
	
	/**
	 * IteratorExpCS
	 * 
	 * @param iteratorExpCS the <code>IteratorExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>IteratorExp</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final IteratorExp<C, PM> iteratorExpCS(
			IteratorExpCS iteratorExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {
		
		IteratorExp<C, PM> astNode;
		
		OCLExpression<C> source =
			getCollectionSourceExpression(iteratorExpCS.getSource(), env);
		String name = iteratorExpCS.getSimpleNameCS().getValue();

		Variable<C, PM> vdcl = null;
		Variable<C, PM> vdcl1 = null;
		OCLExpression<C> expr = null;
		List<Variable<C, PM>> iterators = null;
	
		
		if (iteratorExpCS.getVariable1() != null) {
			vdcl = variableDeclarationCS(iteratorExpCS.getVariable1(), env, true);
				
			astNode = ExpressionsFactory.eINSTANCE.createIteratorExp();
			astNode.setName(name);
			iterators = astNode.getIterator();	
			if (vdcl.getType() == null) {
				C sourceType = source.getType();
				if (sourceType instanceof CollectionType) {
					@SuppressWarnings("unchecked")
					CollectionType<C, O> ct = (CollectionType<C, O>) sourceType;
					
					vdcl.setType(ct.getElementType());
				}
			}
			iterators.add(vdcl);
						
			if (iteratorExpCS.getVariable2() != null) {
				vdcl1 = variableDeclarationCS(iteratorExpCS.getVariable2(), env, true);
				
				if (vdcl1.getType() == null) {
					C sourceType = source.getType();
					if (sourceType instanceof CollectionType) {
						@SuppressWarnings("unchecked")
						CollectionType<C, O> ct = (CollectionType<C, O>) sourceType;
						
						vdcl1.setType(ct.getElementType());
					}
				}
				iterators.add(vdcl1);
			}

		} else  {

			astNode = ExpressionsFactory.eINSTANCE.createIteratorExp();
			astNode.setName(name);
			iterators = astNode.getIterator();	
			// Synthesize the iterator expression.
			@SuppressWarnings("unchecked")
			CollectionType<C, O> ct = (CollectionType<C, O>) source.getType();
			vdcl = genVariableDeclaration("iteratorExpCS", env, null, //$NON-NLS-1$
				ct.getElementType(),
				null, false, true, false);
			iterators.add(vdcl);
		}
		
		expr = oclExpressionCS(iteratorExpCS.getBody(), env);
	
		TRACE("oclIteratorExpCS: ", name);//$NON-NLS-1$
		
		if (name.equals("forAll") || name.equals("exists") || name.equals("one") || name.equals("isUnique")) {//$NON-NLS-4$//$NON-NLS-3$//$NON-NLS-2$//$NON-NLS-1$
			astNode.setType(env.getOCLStandardLibrary().getBoolean());
		} else if (name.equals("select") || name.equals("reject") ) {//$NON-NLS-2$//$NON-NLS-1$
			astNode.setType(source.getType());
		} else if (name.equals("collect")) {//$NON-NLS-1$
			// The result type for collect must be flattened
			C elementType = expr.getType();
			while (elementType instanceof CollectionType) {
				@SuppressWarnings("unchecked")
				CollectionType<C, O> ct = (CollectionType<C, O>) elementType;
				elementType = ct.getElementType();
			}
			if (source.getType() instanceof SequenceType || 
							source.getType() instanceof OrderedSetType) {
				astNode.setType(getSequenceType(env, elementType));
			} else {
				astNode.setType(getBagType(env, elementType));
			}
		} else if (name.equals("collectNested")) {//$NON-NLS-1$
			if (source.getType() instanceof SequenceType || 
							source.getType() instanceof OrderedSetType) {
				astNode.setType(getSequenceType(env, expr.getType()));
			} else {
				astNode.setType(getBagType(env, expr.getType()));
			}
		} else if (name.equals("any")) {//$NON-NLS-1$
			@SuppressWarnings("unchecked")
			CollectionType<C, O> ct = (CollectionType<C, O>) source.getType();
			
			astNode.setType(ct.getElementType());
		} else if (name.equals("sortedBy")) {//$NON-NLS-1$
			if ((source.getType() instanceof SequenceType) ||
					source.getType() instanceof BagType) {
				@SuppressWarnings("unchecked")
				CollectionType<C, O> ct = (CollectionType<C, O>) source.getType();
				
				astNode.setType(getSequenceType(env, ct.getElementType()));
			} else { // set, ordered set
				@SuppressWarnings("unchecked")
				CollectionType<C, O> ct = (CollectionType<C, O>) source.getType();
				
				astNode.setType(getOrderedSetType(env, ct.getElementType()));
			}
		} else if (name.equals("closure")) {//$NON-NLS-1$
			// get the body element type if it is a collection-type
			//   expression
			C bodyType = expr.getType();
			if (bodyType instanceof CollectionType) {
				@SuppressWarnings("unchecked")
				CollectionType<C, O> ct = (CollectionType<C, O>) bodyType;
				
				bodyType = ct.getElementType();
			}
			
			astNode.setType(getSetType(env, bodyType));
		}
				
		astNode.setBody(expr);
		astNode.setSource(source);
		
		env.deleteElement(vdcl.getName());
		if (vdcl1 != null) {
			env.deleteElement(vdcl1.getName());
		}

		return astNode;
	}
	
	/**
	 * IterateExpCS
	 * 
	 * @param iterateExpCS the <code>IterateExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>IterateExp</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final IterateExp<C, PM> iterateExpCS(
			IterateExpCS iterateExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {
	
		IterateExp<C, PM> astNode = null;

		OCLExpression<C> source =
			getCollectionSourceExpression(iterateExpCS.getSource(), env);
		Variable<C, PM> vdcl = null;
		Variable<C, PM> vdcl1 = null;
		OCLExpression<C> expr = null;

		vdcl = variableDeclarationCS(iterateExpCS.getVariable1(), env, true);
		
		if (iterateExpCS.getVariable2() != null) {
			vdcl1 = variableDeclarationCS(iterateExpCS.getVariable2(), env, true);
		}
	
		/* If there is only one variable declaration, then it is the result, vdcl1. 
	   		The missing variable declaration is treated as the implicit iterator vdcl.
	 	*/
		if (vdcl1 == null) {
			vdcl1 = vdcl;
			vdcl = null;
		}	
	
		if (vdcl == null) { // synthesize a new variable declaration.		
			@SuppressWarnings("unchecked")
			CollectionType<C, O> ct = (CollectionType<C, O>) source.getType();
			
			vdcl = genVariableDeclaration("iterateExpCS", env, null, //$NON-NLS-1$
					ct.getElementType(),
					null, false, true, false);	
		} 
		if ( vdcl.getType() == null) {
			@SuppressWarnings("unchecked")
			CollectionType<C, O> ct = (CollectionType<C, O>) source.getType();
			
			vdcl.setType(ct.getElementType());
		}

		expr = oclExpressionCS(iterateExpCS.getBody(), env);

	
		TRACE("iterateExpCS", "iterate");//$NON-NLS-2$//$NON-NLS-1$
		astNode = ExpressionsFactory.eINSTANCE.createIterateExp();
		astNode.setName("iterate");			//$NON-NLS-1$
		List<Variable<C, PM>> iterator = astNode.getIterator();
		iterator.add(vdcl);
		astNode.setSource(source);
		astNode.setResult(vdcl1);
		astNode.setBody(expr);
		
		
		if (vdcl1.getType() == null) {
			String message = OCLMessages.bind(
					OCLMessages.DeclarationType_ERROR_,
					vdcl1.getName());
			ERROR("iterateExpCS", message);//$NON-NLS-1$
		}
		
		astNode.setType(vdcl1.getType());
		
		if (vdcl1.getInitExpression() == null) {
			String message = OCLMessages.bind(
					OCLMessages.DeclarationNoInitExp_ERROR_,
					vdcl1.getName());
			ERROR("iterateExpCS", message);//$NON-NLS-1$
		}
		if (vdcl.getInitExpression() != null) {
			String message = OCLMessages.bind(
					OCLMessages.DeclarationInitExp_ERROR_,
					vdcl1.getName());
			ERROR("iterateExpCS", message);//$NON-NLS-1$
		} 
		
		env.deleteElement(vdcl.getName());
		env.deleteElement(vdcl1.getName());
			
		return astNode;
	}

	/**
	 * ModelPropertyCallExpCS
	 * 
	 * @param modelPropertyCallExpCS the <code>ModelPropertyCallExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>OCLExpression</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final OCLExpression<C> modelPropertyCallExpCS(
			FeatureCallExpCS modelPropertyCallExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {
		
		OCLExpression<C> astNode = null;
		
		if (modelPropertyCallExpCS instanceof OperationCallExpCS) {
			astNode = operationCallExpCS((OperationCallExpCS)modelPropertyCallExpCS, env);
		} else {
			OCLExpression<C> source =
				oclExpressionCS(modelPropertyCallExpCS.getSource(), env);
			astNode = simpleNameCS(modelPropertyCallExpCS.getSimpleNameCS(), env, source);

			List<OCLExpression<C>> qualifiers =
				qualifiersCS(modelPropertyCallExpCS.getArguments(), env, astNode);

			if (modelPropertyCallExpCS.getIsMarkedPreCS().isPre()) {
				if (astNode instanceof FeatureCallExp) {
					((FeatureCallExp<C>) astNode).setMarkedPre(true);
				} else {
					ERROR("modelPropertyCallExpCS", OCLMessages.IllegalAtPre_ERROR_);//$NON-NLS-1$
				}
			}

			if (!qualifiers.isEmpty()) {
				if (astNode instanceof NavigationCallExp) {
					setQualifiers(env, "modelPropertyCallExpCS",//$NON-NLS-1$
						(NavigationCallExp<C, P>) astNode,
						qualifiers);
				} else if ((astNode instanceof LoopExp)
						&& getLoopBody(astNode) instanceof NavigationCallExp) {
					// might have parsed an implicit collect expression
					
					@SuppressWarnings("unchecked")
					NavigationCallExp<C, P> nav =
						(NavigationCallExp<C, P>) getLoopBody(astNode);
					
					setQualifiers(env, "modelPropertyCallExpCS",//$NON-NLS-1$
						nav, qualifiers);
				} else {
					ERROR("modelPropertyCallExpCS", //$NON-NLS-1$
							OCLMessages.bind(
									OCLMessages.IllegalQualifiers_ERROR_,
									computeInputString(modelPropertyCallExpCS)));
				}
			} else if (astNode instanceof AssociationClassCallExp) {
				checkNotReflexive(env, "modelPropertyCallExpCS",//$NON-NLS-1$
					(AssociationClassCallExp<C, P>) astNode);
			}
		}

		return astNode;
	}
	
	@SuppressWarnings("unchecked")
	private OCLExpression<C> getLoopBody(OCLExpression<C> expr) {
		return ((LoopExp<C, PM>) expr).getBody();
	}

	/**
	 * OperationCallExpCS
	 * 
	 * @param operationCallExpCS the <code>OperationCallExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment 
	 * @return the parsed <code>OCLExpression</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final OCLExpression<C> operationCallExpCS(
			OperationCallExpCS operationCallExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env
		) throws SemanticException {
		
		OperationCallExp<C, O> astNode = null;

		List<OCLExpression<C>> args = new java.util.ArrayList<OCLExpression<C>>();
		//boolean isMarkedPre = false;

		String name = operationCallExpCS.getSimpleNameCS().getValue();
		int operator = operationCallExpCS.getAccessor().getValue();
		
		/*
		 * The type of the operation is specified by a path expression
		 * or self, or by an explicit source expression.  The source expression
		 * may be a collection type (-> operation) or a regular navigation expression
		 * (. operation)
		 */
		OCLExpression<C> source = null;
		if (operator == DotOrArrowEnum.ARROW) {
			source = getCollectionSourceExpression(operationCallExpCS.getSource(), env);
		} else {
            OCLExpressionCS sourceCS = operationCallExpCS.getSource();
            
            if (sourceCS instanceof PathNameCS) {
                // static operation call
                PathNameCS pathName = (PathNameCS) sourceCS;
                
                C sourceType = env.lookupClassifier(pathName.getSequenceOfNames());
                if (sourceType == null) {
                    String message = OCLMessages.bind(
                            OCLMessages.UnrecognizedType_ERROR_,
                            pathName.getSequenceOfNames());
                    ERROR("operatonCallExpCS", message);//$NON-NLS-1$
                } else {
                    source = typeCS(sourceType, env);
                }
            } else {
                source = oclExpressionCS(operationCallExpCS.getSource(), env);
            }
		}
		
		String operationName = operationCallExpCS.getSimpleNameCS().getValue();

		if (PredefinedType.OCL_IS_IN_STATE_NAME.equals(operationName)) {
			if (operationCallExpCS.getArguments().size() != 1) {
				ERROR("operationCallExpCS", //$NON-NLS-1$
						OCLMessages.bind(
								OCLMessages.IsInStateSignature_ERROR_,
								computeInputString(operationCallExpCS)));
			}
			
			OCLExpressionCS arg = operationCallExpCS.getArguments().get(0);
			if (!(arg instanceof StateExpCS)) {
				ERROR("operationCallExpCS", //$NON-NLS-1$
						OCLMessages.bind(
								OCLMessages.IsInStateSignature_ERROR_,
								computeInputString(operationCallExpCS)));
			}
			
			args.add(stateExpCS(source, (StateExpCS) arg, env));
		} else {
			for (OCLExpressionCS arg : operationCallExpCS.getArguments()) {
				args.add(oclExpressionCS(arg, env));
			}
		}
		
		if (source == null) {  // create an implicit source
			VariableExp<C, PM> vexp =
				ExpressionsFactory.eINSTANCE.createVariableExp();
			Variable<C, PM> implicitSource = 
					env.lookupImplicitSourceForOperation(operationName, args);
			
			if (implicitSource == null) {
				String errMessage = name + "(";//$NON-NLS-1$
				for (int i = 0; i < args.size(); i++) {
					if (i > 0)
						errMessage += ", ";//$NON-NLS-1$
					errMessage += uml.getName(args.get(i).getType());
				}
				errMessage += ")";//$NON-NLS-1$
				String message = OCLMessages.bind(
						OCLMessages.IllegalSignature_ERROR_,
						errMessage);
				ERR(message);  // this throws, so we won't proceed
			}
			
			vexp.setType(implicitSource.getType());
			vexp.setReferredVariable(implicitSource);
			vexp.setName(implicitSource.getName());
			source = vexp;
		}

		/*
		 * If the source type is a collection and operator is ".",
		 * then there is an implicit COLLECT operator.
		 */
		C operationSourceType = source.getType();
		boolean isImplicitCollect = (operator == DotOrArrowEnum.DOT)
				&& (operationSourceType instanceof CollectionType);
		
		if (isImplicitCollect) {
			@SuppressWarnings("unchecked")
			CollectionType<C, O> ct = (CollectionType<C, O>) operationSourceType;
			
			operationSourceType = ct.getElementType();
		}
		
        // if the sourceType is a TypeType then this must be a static operation
        boolean isStatic = operationSourceType instanceof TypeType;
        
		astNode = genOperationCallExp(env, "operationCallExpCS", operationName,//$NON-NLS-1$
				source, operationSourceType, args);
		
        if (isStatic) {
            @SuppressWarnings("unchecked")
            TypeType<C, O> typeType = (TypeType<C, O>) operationSourceType;
            O operation = astNode.getReferredOperation();
        
            // operation must either be defined by the TypeType (e.g., allInstances())
            //    or be a static operation of the referred classifier
            if (!(typeType.oclOperations().contains(operation)
                    || uml.isStatic(operation))) {
                
                String message = OCLMessages.bind(
                    OCLMessages.NonStaticOperation_ERROR_,
                    operationName);
                ERROR("operationCallExpCS", message);//$NON-NLS-1$
            }
        }
        
		astNode.setMarkedPre(operationCallExpCS.getIsMarkedPreCS().isPre());

		initPropertyPositions(astNode, operationCallExpCS.getSimpleNameCS());

		OCLExpression<C> result = astNode;
		
		if (isImplicitCollect) {
			result = createImplicitCollect(source, astNode, env);			
	   	}
			
		return result;
	}
	
	/**
	 * MessageExpCS
	 * 
	 * @param messageExpCS the <code>MessageExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment 
	 * @return the parsed <code>OCLExpression</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final OCLExpression<C> messageExpCS(
			MessageExpCS messageExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) throws SemanticException {
		MessageExp<C, COA, SSA> result;
		
		OCLExpression<C> target =
			oclExpressionCS(messageExpCS.getTarget(), env);
		String name = messageExpCS.getSimpleNameCS().getValue();
		
		EList<OCLMessageArgCS> argsCS = messageExpCS.getArguments();
		EList<OCLExpression<C>> arguments;
		
		if (argsCS.isEmpty()) {
			arguments = ECollections.emptyEList();
		} else {
			arguments = new BasicEList<OCLExpression<C>>();
			
			for (OCLMessageArgCS argCS : argsCS) {
				OCLExpression<C> arg;
				
				if (argCS.getExpression() == null) {
					// unspecified value
					arg = ExpressionsFactory.eINSTANCE.createUnspecifiedValueExp();
					initStartEndPositions(arg, argCS);
					if (argCS.getTypeCS() == null) {
						// OclVoid matches any parameter type in an operation signature
						arg.setType(env.getOCLStandardLibrary().getOclVoid());
					} else {
						arg.setType(typeCS(argCS.getTypeCS(), env));
						initTypePositions(
							(UnspecifiedValueExp<C>) arg,
							argCS.getTypeCS());
					}
				} else {
					arg = oclExpressionCS(argCS.getExpression(), env);
				}
				
				arguments.add(arg);
			}
		}
		
		O calledOperation = env.lookupOperation(target.getType(), name, arguments);
		C receivedSignal = env.lookupSignal(target.getType(), name, arguments);
		
		if ((calledOperation == null) && (receivedSignal == null)) {
			ERROR("messageExpCS", OCLMessages.bind(OCLMessages.UnrecognizedMessageType_ERROR_, name)); //$NON-NLS-1$
		} else if ((calledOperation != null) && (receivedSignal != null)) {
			ERROR("messageExpCS", OCLMessages.bind(OCLMessages.AmbiguousMessageType_ERROR_, name)); //$NON-NLS-1$
		}
		
		result = ExpressionsFactory.eINSTANCE.createMessageExp();
		initStartEndPositions(result, messageExpCS);
		initPropertyPositions(result, messageExpCS.getSimpleNameCS());
		result.setTarget(target);
		result.getArgument().addAll(arguments);
		
		EObject behavioralFeature;
		if (calledOperation != null) {
			COA callAction = uml.createCallOperationAction(calledOperation);
			result.setCalledOperation(callAction);
			behavioralFeature = (EObject) calledOperation;
		} else {
			SSA sendAction = uml.createSendSignalAction(receivedSignal);
			result.setSentSignal(sendAction);
			behavioralFeature = (EObject) receivedSignal;
		}
		
		if (messageExpCS.getKind() == MessageExpKind.HAS_SENT_LITERAL) {
			result.setType(env.getOCLStandardLibrary().getBoolean());
		} else if (uml.isOperation(behavioralFeature)) {
			result.setType(
					getSequenceType(env,
							getOperationMessageType(env, calledOperation)));
		} else {
			result.setType(
					getSequenceType(env,
							getSignalMessageType(env, receivedSignal)));
		}
		
		return result;
	}
	
	private C getSetType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C elementType) {
		
		return TypeUtil.resolveSetType(env, elementType);
	}
	
	private C getOrderedSetType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C elementType) {
		
		return TypeUtil.resolveOrderedSetType(env, elementType);
	}
	
	private C getBagType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C elementType) {
		
		return TypeUtil.resolveBagType(env, elementType);
	}
	
	private C getSequenceType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C elementType) {
		
		return TypeUtil.resolveSequenceType(env, elementType);
	}
	
	private C getCollectionType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			CollectionKind kind, C elementType) {
		
		return TypeUtil.resolveCollectionType(env, kind, elementType);
	}
	
	private C getTupleType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			EList<? extends TypedElement<C>> parts) {
		return TypeUtil.resolveTupleType(env, parts);
	}
	
	@SuppressWarnings("unchecked")
	private C getTypeType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C type) {
		return TypeUtil.resolveTypeType(env, type);
	}
	
	@SuppressWarnings("unchecked")
	private C getOperationMessageType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			O operation) {
		return TypeUtil.resolveOperationMessageType(env, operation);
	}
	
	@SuppressWarnings("unchecked")
	private C getSignalMessageType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C signal) {
		return TypeUtil.resolveSignalMessageType(env, signal);
	}
	
	@SuppressWarnings("unchecked")
	private C getElementType(C possibleCollectionType) {
		if (possibleCollectionType instanceof CollectionType) {
			return ((CollectionType<C, O>) possibleCollectionType).getElementType();
		}
		
		return possibleCollectionType;
	}
	
	@SuppressWarnings("unchecked")
	private CollectionKind getCollectionKind(C possibleCollectionType) {
		if (possibleCollectionType instanceof CollectionType) {
			return ((CollectionType<C, O>) possibleCollectionType).getKind();
		}
		
		return null;
	}
}
