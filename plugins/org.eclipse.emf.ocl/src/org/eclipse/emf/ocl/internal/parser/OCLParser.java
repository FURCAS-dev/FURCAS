/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * $Id: OCLParser.java,v 1.6 2006/04/07 20:00:23 cdamus Exp $
 */

package org.eclipse.emf.ocl.internal.parser;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ocl.expressions.AssociationClassCallExp;
import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionItem;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.expressions.CollectionLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionLiteralPart;
import org.eclipse.emf.ocl.expressions.CollectionRange;
import org.eclipse.emf.ocl.expressions.EnumLiteralExp;
import org.eclipse.emf.ocl.expressions.ExpressionsFactory;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.FeatureCallExp;
import org.eclipse.emf.ocl.expressions.IfExp;
import org.eclipse.emf.ocl.expressions.IntegerLiteralExp;
import org.eclipse.emf.ocl.expressions.InvalidLiteralExp;
import org.eclipse.emf.ocl.expressions.IterateExp;
import org.eclipse.emf.ocl.expressions.IteratorExp;
import org.eclipse.emf.ocl.expressions.LetExp;
import org.eclipse.emf.ocl.expressions.LiteralExp;
import org.eclipse.emf.ocl.expressions.LoopExp;
import org.eclipse.emf.ocl.expressions.MessageExp;
import org.eclipse.emf.ocl.expressions.NavigationCallExp;
import org.eclipse.emf.ocl.expressions.NullLiteralExp;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.RealLiteralExp;
import org.eclipse.emf.ocl.expressions.StateExp;
import org.eclipse.emf.ocl.expressions.StringLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralPart;
import org.eclipse.emf.ocl.expressions.TypeExp;
import org.eclipse.emf.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.expressions.VariableExp;
import org.eclipse.emf.ocl.internal.cst.BooleanLiteralExpCS;
import org.eclipse.emf.ocl.internal.cst.CSTNode;
import org.eclipse.emf.ocl.internal.cst.CSTPackage;
import org.eclipse.emf.ocl.internal.cst.CallExpCS;
import org.eclipse.emf.ocl.internal.cst.ClassifierContextDeclCS;
import org.eclipse.emf.ocl.internal.cst.CollectionLiteralExpCS;
import org.eclipse.emf.ocl.internal.cst.CollectionLiteralPartCS;
import org.eclipse.emf.ocl.internal.cst.CollectionRangeCS;
import org.eclipse.emf.ocl.internal.cst.CollectionTypeCS;
import org.eclipse.emf.ocl.internal.cst.CollectionTypeIdentifierEnum;
import org.eclipse.emf.ocl.internal.cst.ContextDeclCS;
import org.eclipse.emf.ocl.internal.cst.DefCS;
import org.eclipse.emf.ocl.internal.cst.DefExpressionCS;
import org.eclipse.emf.ocl.internal.cst.DotOrArrowEnum;
import org.eclipse.emf.ocl.internal.cst.EnumLiteralExpCS;
import org.eclipse.emf.ocl.internal.cst.FeatureCallExpCS;
import org.eclipse.emf.ocl.internal.cst.IfExpCS;
import org.eclipse.emf.ocl.internal.cst.InitOrDerValueCS;
import org.eclipse.emf.ocl.internal.cst.IntegerLiteralExpCS;
import org.eclipse.emf.ocl.internal.cst.InvCS;
import org.eclipse.emf.ocl.internal.cst.InvOrDefCS;
import org.eclipse.emf.ocl.internal.cst.InvalidLiteralExpCS;
import org.eclipse.emf.ocl.internal.cst.IterateExpCS;
import org.eclipse.emf.ocl.internal.cst.IteratorExpCS;
import org.eclipse.emf.ocl.internal.cst.LetExpCS;
import org.eclipse.emf.ocl.internal.cst.LiteralExpCS;
import org.eclipse.emf.ocl.internal.cst.LoopExpCS;
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
import org.eclipse.emf.ocl.internal.cst.PrimitiveLiteralExpCS;
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
import org.eclipse.emf.ocl.internal.l10n.OCLMessages;
import org.eclipse.emf.ocl.parser.EcoreEnvironmentFactory;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.EnvironmentFactory;
import org.eclipse.emf.ocl.parser.ParserException;
import org.eclipse.emf.ocl.parser.SemanticException;
import org.eclipse.emf.ocl.types.BagType;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.MessageType;
import org.eclipse.emf.ocl.types.OrderedSetType;
import org.eclipse.emf.ocl.types.SequenceType;
import org.eclipse.emf.ocl.types.SetType;
import org.eclipse.emf.ocl.types.TupleType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.impl.AnyTypeImpl;
import org.eclipse.emf.ocl.types.impl.TypeTypeImpl;
import org.eclipse.emf.ocl.types.impl.TypeUtil;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.emf.ocl.uml.CallOperationAction;
import org.eclipse.emf.ocl.uml.Constraint;
import org.eclipse.emf.ocl.uml.SendSignalAction;
import org.eclipse.emf.ocl.uml.UMLFactory;
import org.eclipse.emf.ocl.uml.UMLPackage;
import org.eclipse.emf.ocl.utilities.ASTNode;
import org.eclipse.emf.ocl.utilities.CallingASTNode;
import org.eclipse.emf.ocl.utilities.PredefinedType;
import org.eclipse.emf.ocl.utilities.TypedASTNode;
import org.eclipse.osgi.util.NLS;

/**
 * The <code>OCLLpgParser</code> parses an OCL expression into a CST.
 * Once the CST is created, the <code>OCLParser</code> walks the CST
 * and creates the OCL AST. It is necessary that this be done in two steps
 * because LPG is a bottom up parser and cannot provide enough contextual
 * information to create the AST on the first pass.
 * 
 * @author Christian Vogt (cvogt)
 */
public class OCLParser extends OCLLPGParser {

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
	TypesPackage typesPackage = TypesPackage.eINSTANCE;
	TypesFactory typesFactory = typesPackage.getTypesFactory();
		
	ExpressionsPackage expressionsPackage = ExpressionsPackage.eINSTANCE;
	ExpressionsFactory expressionsFactory = expressionsPackage.getExpressionsFactory();
		   		 
	UMLPackage umlPackage = UMLPackage.eINSTANCE;
	UMLFactory umlFactory = umlPackage.getUMLFactory();
	
	private EnvironmentFactory environmentFactory;
 
	private boolean traceflag = true;	
		
	private String errorString = ""; //$NON-NLS-1$

	private int charOffset = 0;

	private int errorReportLineOffset = 0;

	public OCLParser(OCLLexer lexStream) {
		this(lexStream, EcoreEnvironmentFactory.ECORE_INSTANCE);
	}

	public OCLParser(OCLLexer lexStream, EnvironmentFactory environmentFactory) {
		super(lexStream);
		lexStream.lexer(this);
		this.environmentFactory = environmentFactory;
	}

	public void setTraceFlag(boolean flag) {
		traceflag = flag;
	}
	
	public boolean getTraceFlag() {
		return traceflag;
	}
	
	private void TRACE( String rule, String message) {
		if (traceflag) {
			System.out.println(rule + ": " + message);//$NON-NLS-1$
		}
	}
			
	private void TRACE(String rule, String message, EList namelist) {		  			
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
	private String makeString(EList namelist) {
		String msg = "";//$NON-NLS-1$
		for (int i = 0; i < namelist.size(); i++) {
			msg += " " + (String) namelist.get(i);//$NON-NLS-1$
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
	private String makeName(EList namelist) {
		StringBuffer msg = new StringBuffer();
		for (int i = 0; i < namelist.size(); i++) {
			if (i > 0) msg.append("::");//$NON-NLS-1$
			msg.append((String) namelist.get(i));
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
	private String operationString(String operName, EList args) {
		StringBuffer result = new StringBuffer();
		
		result.append(operName);
		result.append('(');
		
		for (Iterator iter = args.iterator(); iter.hasNext();) {
			OCLExpression arg = (OCLExpression) iter.next();
			EClassifier type = arg.getType();
			
			result.append((type == null)? (String) null : type.getName());
			
			if (iter.hasNext()) {
				result.append(", "); //$NON-NLS-1$
			}
		}
		
		result.append(')');
		
		return result.toString();
	}
	
	/**
	 * Removes the "s surrounding a quoted string, if any.
	 * 
	 * @param quoted a possibly quoted string
	 * @return <code>quoted</code> without the surrounding quotes, or just
	 *	 <code>quoted</code> verbatim if there were none
	 */
	private String unquote(String quoted) {
		String result = quoted;
	
		if ((result != null) && (result.length() > 1)) {
			int max = result.length() - 1;
	
			if ((result.charAt(0) == '"') && (quoted.charAt(max) == '"')) {
				result = result.substring(1, max);
				}
				// this is a regexp, so the backslash needs to be
									//   re-escaped, thus "\\" is rendered in a Java
														//   string literal as "\\\\"
				result = result.replaceAll("\\\\\"", "\"");  //$NON-NLS-2$//$NON-NLS-1$
		}
	
		return result;
	}
	
	/**
	 * Sets the specified navigation call's qualifiers, if they are compatible
	 * with the navigated association end or association class.
	 * 
	 * @param env the OCL environment
	 * @param rule the rule name that parsed the qualifiers
	 * @param nc the navigation call expression
	 * @param qualifiers the qualifiers to set
	 * 
	 * @throws SemanticException if the qualifiers do not conform
	 */
	private void setQualifiers(Environment env, String rule,
			NavigationCallExp nc, EList qualifiers) throws SemanticException {
		
		if (nc instanceof PropertyCallExp) {
			EStructuralFeature source = ((PropertyCallExp) nc).getReferredProperty();
			List expectedQualifiers = env.getQualifiers(source);
			
			if (expectedQualifiers.size() != qualifiers.size()) {
				ERROR(rule, OCLMessages.MismatchedQualifiers_ERROR_);
			} else {
				Iterator eiter = expectedQualifiers.iterator();
				Iterator qiter = qualifiers.iterator();
				
				while (eiter.hasNext()) {
					EClassifier expectedType = TypeUtil.getOCLType(
							(ETypedElement) eiter.next());
					OCLExpression qualifier = (OCLExpression) qiter.next();
					
					EClassifier qualifierType = qualifier.getType();
					if (TypeUtil.typeCompare(expectedType, qualifierType) < 0) {
						ERROR(rule, OCLMessages.MismatchedQualifiers_ERROR_);
					}
				}
			}
		} else if (nc instanceof AssociationClassCallExp) {
			if (qualifiers.size() != 1) {
				ERROR(rule, OCLMessages.AssociationClassQualifierCount_ERROR_);
			}
			
			Object qualifier = qualifiers.get(0);
			if (!(qualifier instanceof PropertyCallExp)) {
				ERROR(rule, OCLMessages.AssociationClassQualifierType_ERROR_);
			}
			
			AssociationClassCallExp acc = (AssociationClassCallExp) nc;
			EClass assocClass = acc.getReferredAssociationClass();
			
			// can assume an EClass, otherwise we wouldn't have found an
			//   association class call expression
			EClass sourceType = (EClass) nc.getSource().getType();
			EStructuralFeature property = ((PropertyCallExp) qualifier).getReferredProperty();
			
			if (!(property instanceof EReference)) {
				ERROR(rule, OCLMessages.AssociationClassQualifierType_ERROR_);
			}
			
			EReference ref = (EReference) property;
			EClass refAssocClass = env.getAssociationClass(ref);
			if ((refAssocClass != null)
					&& sourceType.getEAllReferences().contains(ref)
					&& (refAssocClass == assocClass)) {
				acc.setNavigationSource(ref);
			} else {
				ERROR(rule, OCLMessages.AssociationClassQualifierType_ERROR_);
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
	private void checkNotReflexive(Environment env, String rule,
			AssociationClassCallExp acc) throws SemanticException {
		
		EClass assocClass = acc.getReferredAssociationClass();
		
		List ends;
		if (env.isAssociationClass(assocClass)) {
			ends = env.getMemberEnds(assocClass);
		} else {
			ends = ECollections.EMPTY_ELIST;
		}
		
		if (ends.size() == 2) {
			EReference end1 = (EReference) ends.get(0);
			EReference end2 = (EReference) ends.get(1);
			
			if (end1.getEReferenceType() == end2.getEReferenceType()) {
				ERROR(rule, OCLMessages.AssociationClassAmbiguous_ERROR_);
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
		String error = NLS.bind(OCLMessages.ErrorMessage_ERROR_, new Object[] {
				rule, errorMessage });
		errorString += error;
		ERR(error);
		
		/*if (traceflag) {
			System.out.println(error);
		}*/
		
	}
		
	private void ERROR(String rule, String errorMessage, EList namelist) throws SemanticException {		  			
		String msg = errorMessage;
		for (int i = 0; i < namelist.size(); i++) {
			msg += " " + (String) namelist.get(i);//$NON-NLS-1$
		}
		ERROR(rule, msg); 
	}
	
	
	/**
	 * Generate a VariableDeclaration AST node, and add it to the environment.
	 * Variable declarations are generated for "self", let expression variables, and
	 * iterator and iterate variables, both implicit and explicit.
	 * For implicit variables, the name is generated by the Environment.
	 */
	private Variable genVariableDeclaration(String rule, Environment env, String name, 
				EClassifier type, OCLExpression initExp, boolean explicitFlag,
				boolean addToEnvironment, boolean isSelf) throws SemanticException {
			
		Variable vdcl = expressionsFactory.createVariable();		
 		vdcl.setName(name);
 		vdcl.setType(type);
 		vdcl.setInitExpression(initExp);
 		
 		if (addToEnvironment) {
 			boolean result = env.addElement(name, vdcl, explicitFlag);
 			if (!result) {
				if (name != null) {
					String message = NLS.bind(OCLMessages.VariableUsed_ERROR_,
							new Object[] { name });
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
	private OperationCallExp genOperationCallExp(
			Environment env,
			String rule,
			String operName,
			OCLExpression source,
			EClassifier ownerType,
			EList args)
		throws SemanticException {

		OperationCallExp result;
		
		result = expressionsFactory.createOperationCallExp();
		result.setSource(source);	   
		
		// Performs method signature checking		
		EOperation oper = env.lookupOperation(ownerType, operName, args);
		if (oper == null) { 
			String message = NLS.bind(OCLMessages.OperationNotFound_ERROR_,
					operationString(operName, args),
					(ownerType == null)? null : ownerType.getName());
			ERROR(rule, message);
			result.setType(Types.OCL_VOID);
		} else {
		  	TRACE(rule, oper.getName());
			result.setReferredOperation(oper);
		}
							
		// Set up arguments
		EList callargs = result.getArgument();
		if (args != null) {
		   	for (int i = 0; i < args.size(); i++) {
		   		OCLExpression arg = (OCLExpression) args.get(i);
		   		if (arg == null) {
					ERROR(rule, OCLMessages.BadArg_ERROR_);
		   			continue;
		   		}
		   		
		   		callargs.add(args.get(i));
		   	}
		}
				
		// Compute the result type, and perform conformance checking.
		if (oper != null) {
			EClassifier resultType = null;
			
		   	if (ownerType instanceof PredefinedType) { 
		   		PredefinedType predef = (PredefinedType) ownerType;
		   		int opcode = predef.getOperationCodeFor(operName);
		   		result.setOperationCode(opcode);
				resultType = predef.getResultTypeFor(ownerType, opcode, args);
		   	} else {
		   		// source is an EClass, an enumeration, or a user data type
		   		int opcode = AnyTypeImpl.getOperationCode(operName);
		   		result.setOperationCode(opcode);
		   		resultType = AnyTypeImpl.getResultType(ownerType, opcode, args);
		   	}
		   	if (resultType == null)
		   		resultType = TypeUtil.getOCLType(oper);	   		
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
	public final EList parsePackageDeclarationCS(EList constraints) throws ParserException {
		EObject cstNode = runParser();
		if (cstNode != null) {
			if (cstNode instanceof PackageDeclarationCS) {
				packageDeclarationCS((PackageDeclarationCS)cstNode, constraints);
				return constraints;
			}

			ERROR("parsePackageDeclarationCS",//$NON-NLS-1$
					NLS.bind(OCLMessages.ParseCSTNodeType_ERROR_,
							"PackageDeclarationCS",//$NON-NLS-1$
							cstNode.eClass().getName()));
		}
		
		return constraints;
	}

	/**
	 * Parses the input as an InvOrDefCS.
	 * 
	 * @param env the OCL environment
	 * @return the parsed OCL constraint
	 * @throws ParserException if unable to parse the expression
	 */
	public final Constraint parseInvOrDefCS(Environment env) throws ParserException {
		EObject cstNode = runParser();
		if (cstNode != null) {
			if (cstNode instanceof InvOrDefCS) {
				return invOrDefCS((InvOrDefCS)cstNode, env);
			}

			ERROR("parseInvOrDefCS",//$NON-NLS-1$
					NLS.bind(OCLMessages.ParseCSTNodeType_ERROR_,
							"InvOrDefCS",//$NON-NLS-1$
							cstNode.eClass().getName()));
		}
		return null;
	}

	/**
	 * Parses the input as a PrePostOrBodyDeclCS.
	 * 
	 * @param env the OCL environment
	 * @param operation the constrained EOperation
	 * @return the parsed OCL constraint
	 * @throws ParserException if unable to parse the expression
	 */
	public final Constraint parsePrePostOrBodyDeclCS(Environment env, EOperation operation) throws ParserException {
		EObject cstNode = runParser();
		if (cstNode != null) {
			if (cstNode instanceof PrePostOrBodyDeclCS) {
				return prePostOrBodyDeclCS((PrePostOrBodyDeclCS)cstNode, env, operation);
			}
		}

		ERROR("parsePrePostOrBodyDeclCS",//$NON-NLS-1$
				NLS.bind(OCLMessages.ParseCSTNodeType_ERROR_,
						"PrePostOrBodyDeclCS",//$NON-NLS-1$
						cstNode.eClass().getName()));
		return null;
	}

	/**
	 * Parses the input as an InitOrDerValueCS.
	 * 
	 * @param env the OCL environment
	 * @param property the constrained EStructuralFeature
	 * @return the parsed OCL constraint
	 * @throws ParserException if unable to parse the expression
	 */
	public final Constraint parseInitOrDerValueCS(Environment env, EStructuralFeature property) throws ParserException {
		EObject cstNode = runParser();
		if (cstNode != null) {
			if (cstNode instanceof InitOrDerValueCS) {
				return initOrDerValueCS((InitOrDerValueCS)cstNode, env, property);
			}
		}

		ERROR("parseInitOrDerValueCS",//$NON-NLS-1$
				NLS.bind(OCLMessages.ParseCSTNodeType_ERROR_,
						"InitOrDerValueCS",//$NON-NLS-1$
						cstNode.eClass().getName()));
		return null;
	}

	/**
	 * Parses the input as a VariableDeclarationCS.
	 * 
	 * @param env the OCL environment
	 * @param addToEnvironment boolean whether or not to add the
	 *                         the parsed variable to the environment
	 * @return the parsed variable declaration
	 * @throws ParserException if unable to parse the expression
	 */
	public final Variable parseVariableDeclarationCS(
			Environment env,
			boolean addToEnvironment) throws ParserException {
		EObject cstNode = runParser();
		if (cstNode != null) {
			if (cstNode instanceof VariableCS) {
				return variableDeclarationCS((VariableCS)cstNode, env, true);
			}

			ERROR("parseVariableDeclarationCS",//$NON-NLS-1$
					NLS.bind(OCLMessages.ParseCSTNodeType_ERROR_,
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
			String locInfo = NLS.bind(OCLMessages.ErrorReport_RowColumn,
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
					errorString = NLS.bind(
						errorMessages[errorCode],
						locInfo,
						computeInputString(
							getIToken(leftToken).getStartOffset(),
							getIToken(rightToken).getEndOffset()));
					break;
	
				case MERGE_CODE:
				case BEFORE_CODE:
				case INSERTION_CODE:
				case SUBSTITUTION_CODE: // includes SECONDARY_CODE
					errorString = NLS.bind(
						errorMessages[errorCode],
						new Object[]{
							locInfo,
							tokenText,
							computeInputString(
								getIToken(leftToken).getStartOffset(),
								getIToken(rightToken).getEndOffset())
						});
					break;
	
				default:
					errorString = NLS.bind(errorMessages[errorCode], locInfo, tokenText);
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
		String result = ""; //$NON-NLS-1$
		char[] chars = getInputChars();

		for (int i = left; i <= right; i++) {
			if (chars[i] == '\t') {
				result += ' ';
			} else if (chars[i] == '\n' || chars[i] == '\r' || chars[i] == '\f') {
				if (i > 0) {
					if (!Character.isWhitespace(chars[i-1])) {
						result += ' ';
					}
				}
			} else {
				result += chars[i];
			}
				
		}
		return '"' + result + '"';
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
			EList constraints
		) throws SemanticException {
		
		EList contextDecls = packageDeclarationCS.getContextDecls();
		EList pathname = packageDeclarationCS.getPathNameCS().getSequenceOfNames();
		
		Environment env = environmentFactory.createPackageContext(pathname);
		if (env == null) {
			ERROR("packageDeclarationCS", OCLMessages.PackageNotFound_ERROR_, //$NON-NLS-1$
			pathname);
		}
		TRACE("packageDeclarationCS", "Package ", pathname); //$NON-NLS-2$//$NON-NLS-1$

		for (Iterator i = contextDecls.iterator(); i.hasNext(); ) {
			contextDeclCS((ContextDeclCS)i.next(), env, constraints);
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
			Environment env,
			EList constraints
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
			Environment env,
			EList constraints
		) throws SemanticException {

		Environment operationEnv = environmentFactory.createEnvironment(env);
		
		EOperation operation = operationCS(operationContextDeclCS.getOperationCS(), env);
		
		Constraint astNode;
		for (Iterator i = operationContextDeclCS.getPrePostOrBodyDecls().iterator(); i.hasNext(); ) {
			astNode = prePostOrBodyDeclCS((PrePostOrBodyDeclCS)i.next(), operationEnv, operation);
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
	protected final EOperation operationCS(
			OperationCS operationCS,
			Environment env
		) throws SemanticException {
	
		EOperation operation = null;
		EClassifier classifier = null;
		EList operationName = new BasicEList();
		operationName.addAll(operationCS.getPathNameCS().getSequenceOfNames());
		operationName.add(operationCS.getSimpleNameCS().getValue());

		if (operationName.size() > 1) {
			int lastName = operationName.size() - 1;
			Vector className = new Vector(
				operationName.subList(0, lastName));
			classifier = env.lookupPathName(className);
			
			if (classifier != null) {
				EList params = parametersCS(operationCS.getParameters(), env);
				operation = env.lookupOperation(
					classifier, (String) operationName.get(lastName), params);
			}
		}

		if (operation == null) {
			String message = NLS.bind(
				OCLMessages.UnrecognizedContext_ERROR_,
				new Object[] { makeString(operationName) });
			ERROR("operationContextDeclCS", message);//$NON-NLS-1$
		}
			
		genVariableDeclaration("\noperationCS", env,//$NON-NLS-1$
			"self", classifier, null, true, true, true);//$NON-NLS-1$
							
		TRACE("operationCS", "context", operationName);//$NON-NLS-2$//$NON-NLS-1$

		return operation;
	}

	/**
	 * ParametersCS
	 * 
	 * @param parameters the list of parameters as <code>VariableDeclarationCS</code> objects
	 * @param env the OCL expression
	 * @return a list of <code>VariableDeclaration</code>s
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final EList parametersCS(
			EList parameters,
			Environment env
		) throws SemanticException {

		return variableDeclarationListCS(parameters, env, true);
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
	protected final Constraint prePostOrBodyDeclCS(
			PrePostOrBodyDeclCS prePostOrBodyDeclCS,
			Environment env,
			EOperation operation
		) throws SemanticException {

		EClassifier operationType = TypeUtil.getOCLType(operation);
		String stereotype = null;
		
		switch (prePostOrBodyDeclCS.getKind().getValue()) {
			case PrePostOrBodyEnum.PRE:
				stereotype = Constraint.PRECONDITION;
				break;

			case PrePostOrBodyEnum.POST:
				stereotype = Constraint.POSTCONDITION;
				
				// postconditions have an implicit variable "result" of the
				// same type as the operation
				if ((operationType != null) && (env.lookup("result") == null)) { //$NON-NLS-1$
					genVariableDeclaration(
						"prePostOrBodyDeclCS0", env, //$NON-NLS-1$
						"result", operationType, null, true, true, false); //$NON-NLS-1$
				}

				break;

			case PrePostOrBodyEnum.BODY:
				stereotype = Constraint.BODY;
				 
				// likewise, body conditions have an implicit variable "result"
				if ((operationType != null) && (env.lookup("result") == null)) {//$NON-NLS-1$
					genVariableDeclaration(
						"prePostOrBodyDeclCS", env,//$NON-NLS-1$
						"result", operationType, null, true, true, false);//$NON-NLS-1$
				}

				break;
		}

		OCLExpression oclExpression = oclExpressionCS(prePostOrBodyDeclCS.getExpressionCS(), env);
		
		/* create a constraint astNode  -- must reference the type of self...
		   also, can have a name n.  type of constraint is pre/post/body...
		*/
		Constraint astNode = umlFactory.createConstraint();

		SimpleNameCS simpleNameCS = prePostOrBodyDeclCS.getSimpleNameCS();
		if (simpleNameCS != null) {
			astNode.setName(unquote(simpleNameCS.getValue()));
		}
		
		EList constrainedElement = astNode.getConstrainedElement();
		constrainedElement.add(operation);
		astNode.setBody(oclExpression);
		astNode.setStereotype(stereotype);

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
	protected final void propertyContextCS(
			PropertyContextCS propertyContextCS,
			Environment env,
			EList constraints
		) throws SemanticException {

		Environment propertyEnv = environmentFactory.createEnvironment(env);
		
		EList pathName = propertyContextCS.getPathNameCS().getSequenceOfNames();
		EClassifier owner = env.lookupPathName(pathName);
		
		if (owner == null) {
			String message = NLS.bind(
				OCLMessages.UnrecognizedContext_ERROR_,
				new Object[] { makeString(pathName) });
			ERROR("propertyContextCS", message);//$NON-NLS-1$
		}

		owner = TypeUtil.getOCLType(owner);
		
		String simpleName = propertyContextCS.getSimpleNameCS().getValue();
		EStructuralFeature property = env.lookupProperty(owner, simpleName);
		
		EList propertyName = new BasicEList();
		propertyName.addAll(pathName);
		propertyName.add(simpleName);
		
		if (property == null) {
			String message = NLS.bind(
				OCLMessages.UnrecognizedContext_ERROR_,
				new Object[] { makeString(propertyName) });
			ERROR("propertyContextCS", message);//$NON-NLS-1$
		}
		
		EClassifier type = typeCS(propertyContextCS.getTypeCS(), env);
		EClassifier propertyType = TypeUtil.getOCLType(property);
		if ((type == null) || TypeUtil.typeCompare(propertyType, type) != 0) {
			String message = NLS.bind(
				OCLMessages.UnrecognizedContext_ERROR_,
				new Object[] { makeString(propertyName) });
			ERROR("propertyContextCS", message);//$NON-NLS-1$
		}

		genVariableDeclaration("\npropertyContextCS", env, //$NON-NLS-1$
			"self", owner, null, true, true, true); //$NON-NLS-1$
							
		TRACE("propertyContextCS", "context", propertyName);  //$NON-NLS-2$//$NON-NLS-1$
		
		Constraint astNode;
		InitOrDerValueCS initOrDerValueCS = propertyContextCS.getInitOrDerValueCS();
		astNode = initOrDerValueCS(initOrDerValueCS, propertyEnv, property);
		constraints.add(astNode);
		
		InitOrDerValueCS other = initOrDerValueCS.getInitOrDerValueCS();
		if (other != null) {
			if ((initOrDerValueCS.eClass() == other.eClass())
					|| (other.getInitOrDerValueCS() != null)) {
				String message = NLS.bind(
						OCLMessages.PropertyConstraints_ERROR_,
						new Object[] { makeString(propertyName) });
				ERROR("propertyContextCS", message);//$NON-NLS-1$
			}
			
			astNode = initOrDerValueCS(other, propertyEnv, property);
			constraints.add(astNode);
		}
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
	protected final Constraint initOrDerValueCS(
			InitOrDerValueCS initOrDerValueCS,
			Environment env,
			EStructuralFeature property
		) throws SemanticException {

		String stereotype = null;
		String annotation = null;
		
		switch (initOrDerValueCS.eClass().getClassifierID()) {
			case CSTPackage.INIT_VALUE_CS:
				stereotype = Constraint.INITIAL;
				annotation = Environment.ANNOTATION_URI_INIT;
				break;

			case CSTPackage.DER_VALUE_CS:
				stereotype = Constraint.DERIVATION;
				annotation = Environment.ANNOTATION_URI_DERIVE;
				break;
		}

		OCLExpression oclExpression = oclExpressionCS(
				initOrDerValueCS.getExpressionCS(), env);
		
		Constraint astNode = umlFactory.createConstraint();

		EList constrainedElement = astNode.getConstrainedElement();
		constrainedElement.add(property);
		astNode.setBody(oclExpression);
		astNode.setStereotype(stereotype);
		
		EAnnotation ann = property.getEAnnotation(annotation);
		if (ann == null) {
			ann = EcoreFactory.eINSTANCE.createEAnnotation();
			ann.setSource(annotation);
			property.getEAnnotations().add(ann);
		}
		
		if (ann.getContents().isEmpty()) {
			ann.getContents().add(astNode);
		} else {
			// replace existing initial or derived value expression
			ann.getContents().set(0, astNode);
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
	protected final void classifierContextDeclCS(
			ClassifierContextDeclCS classifierContextDeclCS,
			Environment env,
			EList constraints
		) throws SemanticException {

		EList pathName = classifierContextDeclCS.getPathNameCS().getSequenceOfNames();
		EClassifier type = env.lookupPathName(pathName);
		
		if (type == null) {
			String message = NLS.bind(
				OCLMessages.UnrecognizedContext_ERROR_,
				new Object[] { makeString(pathName) });
			ERROR("classifierContextDeclCS", message);//$NON-NLS-1$
		}

		type = TypeUtil.getOCLType(type);

		genVariableDeclaration("\nclassifierContextDeclCS", env, //$NON-NLS-1$
			"self", type, null, true, true, true); //$NON-NLS-1$
							
		TRACE("classifierContextDeclCS", "context", pathName);  //$NON-NLS-2$//$NON-NLS-1$
		
		Constraint astNode = invOrDefCS(classifierContextDeclCS.getInvOrDefCS(), env);
		astNode.setInstanceVarName("self"); //$NON-NLS-1$
		constraints.add(astNode);
	}

	/**
	 * InvOrDefCS
	 * 
	 * @param invOrDefCS the <code>InvOrDefCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>Constraint</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final Constraint invOrDefCS(
			InvOrDefCS invOrDefCS,
			Environment env
		) throws SemanticException {
		
		Constraint astNode = null;
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
	protected final Constraint invCS(
			InvCS invCS,
			Environment env
		) throws SemanticException {

		OCLExpression oclExpression = oclExpressionCS(invCS.getExpressionCS(), env);

		/* create a constraint astNode  -- must reference the type of self...
		   also, can have a name n.  type of constraint is inv...
		   constraints can be of different types ??  inv or pre/post?
		*/
		Constraint astNode = umlFactory.createConstraint();
		
		SimpleNameCS simpleNameCS = invCS.getSimpleNameCS();

		if (simpleNameCS != null) {
			astNode.setName(unquote(simpleNameCS.getValue()));
		}
		
		EClassifier type = env.getSelfVariable().getType();
		EList constrainedElement = astNode.getConstrainedElement();
		constrainedElement.add(type);
		astNode.setBody(oclExpression);
		astNode.setStereotype(Constraint.INVARIANT);
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
	protected final Constraint defCS(
			DefCS defCS,
			Environment env
		) throws SemanticException {

		Environment contextEnv;
		DefExpressionCS defExpr = defCS.getDefExpressionCS();
		
		ENamedElement feature = null;
		OCLExpression expression = null;
		
		if (defExpr.getVariableCS() != null) {
			// context of the expression is the classifier
			contextEnv = env;
			
			Variable variable = variableDeclarationCS(
					defExpr.getVariableCS(), contextEnv, false);
			
			feature = env.lookupProperty(
					contextEnv.getContextClassifier(),
					variable.getName());
			if (feature != null) {
				ERROR("defCS", //$NON-NLS-1$
					NLS.bind(OCLMessages.DuplicateProperty_ERROR_,
						variable.getName(),
						contextEnv.getContextClassifier().getName()));
			}
			
			expression = oclExpressionCS(defExpr.getExpressionCS(), contextEnv);
			feature = TypeUtil.defineProperty(
					contextEnv.getContextClassifier(),
					variable);
		} else if (defExpr.getOperationCS() != null) {
			// context of the expression is the new operation
			contextEnv = environmentFactory.createEnvironment(env);
			
			OperationCS operCS = defExpr.getOperationCS();
			
			EList params = variableDeclarationListCS(
					operCS.getParameters(), contextEnv, true);
			EClassifier type = typeCS(operCS.getTypeCS(), contextEnv);
			
			String operName = operCS.getSimpleNameCS().getValue();
			EList args = new BasicEList(params.size());
			for (Iterator iter = params.iterator(); iter.hasNext();) {
				// unspecified value for a fake argument of the appropriate type
				UnspecifiedValueExp arg = expressionsFactory.createUnspecifiedValueExp();
				arg.setType(((Variable) iter.next()).getType());
				args.add(arg);
			}
			feature = env.lookupOperation(
					contextEnv.getContextClassifier(),
					operName,
					args);
			if (feature != null) {
				ERROR("defCS", //$NON-NLS-1$
					NLS.bind(OCLMessages.DuplicateOperation_ERROR_,
						operationString(operName, args),
						contextEnv.getContextClassifier().getName()));
			}
			
			expression = oclExpressionCS(defExpr.getExpressionCS(), contextEnv);
			feature = TypeUtil.defineOperation(
					contextEnv.getContextClassifier(),
					unquote(operCS.getSimpleNameCS().getValue()),
					params, type);
		}

		Constraint astNode = umlFactory.createConstraint();
		
		SimpleNameCS simpleNameCS = defCS.getSimpleNameCS();

		if (simpleNameCS != null) {
			astNode.setName(unquote(simpleNameCS.getValue()));
		}
		
		EClassifier type = env.getSelfVariable().getType();
		EList constrainedElement = astNode.getConstrainedElement();
		constrainedElement.add(type);
		constrainedElement.add(feature);
		astNode.setBody(expression);
		astNode.setStereotype(Constraint.DEFINITION);
		
		EAnnotation ann = feature.getEAnnotation(Environment.ANNOTATION_URI_DEFINE);
		if (ann == null) {
			ann = EcoreFactory.eINSTANCE.createEAnnotation();
			ann.setSource(Environment.ANNOTATION_URI_DEFINE);
			feature.getEAnnotations().add(ann);
		}
		
		if (ann.getContents().isEmpty()) {
			ann.getContents().add(astNode);
		} else {
			// replace existing definition
			ann.getContents().set(0, astNode);
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
	protected final Variable  variableDeclarationCS(
			VariableCS variableDeclarationCS,
			Environment env,
			boolean addToEnvironment
		) throws SemanticException {
		
		
		String varName = unquote(variableDeclarationCS.getName());
		EClassifier type = null;
		if (variableDeclarationCS.getTypeCS() != null)
			type = typeCS(variableDeclarationCS.getTypeCS(), env);

	  	OCLExpression expr = null;
	  	if (variableDeclarationCS.getInitExpression() != null)
	  		expr = oclExpressionCS(variableDeclarationCS.getInitExpression(), env);
	
	  	// handle the generic typing of OclMessages
	  	if (expr != null) {
	  		EClassifier exprType = expr.getType();
	  		while (exprType instanceof CollectionType) {
	  			exprType = ((CollectionType) exprType).getElementType();
	  		}
	  		
	  		if (exprType instanceof MessageType) {
	  			EClassifier varType = type;
	  			
	  			if (varType instanceof CollectionType) {
		  			do {
		  				CollectionType collType = (CollectionType) varType;
		  				varType = collType.getElementType();
		  				
		  				if (varType == Types.OCL_MESSAGE) {
		  					// substitute the actual type for the generic type
		  					collType.setElementType(exprType);
		  					break;
		  				}
		  			} while (varType instanceof CollectionType);
	  			} else if (type == Types.OCL_MESSAGE) {
	  				// substitute the actual type for the generic type
	  				type = exprType;
	  			}
	  		}
	  	}
	  	
		Variable astNode = genVariableDeclaration(
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
	protected final EList variableDeclarationListCS(
			EList variableDeclarationCS,
			Environment env,
			boolean addToEnvironment
		) throws SemanticException {
		
		EList variableDeclarations = new BasicEList();
		
		for (Iterator i = variableDeclarationCS.iterator(); i.hasNext(); ) {
			variableDeclarations.add(
				variableDeclarationCS(
					(VariableCS)i.next(),
					env,
					addToEnvironment
				));
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
	protected final EClassifier typeCS(
			TypeCS typeCS,
			Environment env
		) throws SemanticException {

		EClassifier astNode = null;

		if (typeCS instanceof PrimitiveTypeCS) {
			astNode = primitiveTypeCS(((PrimitiveTypeCS)typeCS).getType());

		} else if (typeCS instanceof PathNameCS) {
			astNode = env.lookupPathName(((PathNameCS)typeCS).getSequenceOfNames());

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
	protected final StateExp stateExpCS(
			OCLExpression source,
			StateExpCS stateExpCS,
			Environment env) throws SemanticException {

		EClassifier sourceType = null;
		if (source != null) {
			sourceType = source.getType();
		}
		
		EObject state = null;
		
		EList statePath = stateExpCS.getSequenceOfNames();
		int lastName = statePath.size() - 1;
		
		if (lastName >= 0) {
			// to support content-assist, we can parse an expression that
			//   has no state, to provide suggestions for the first part
			//   of the name.  Validation of the expression will assert
			//   the presence of some referred state
			String stateName = (String) statePath.get(lastName);
			EList states = env.getStates(sourceType, statePath.subList(0, lastName));
			for (Iterator iter = states.iterator(); (state == null) && iter.hasNext();) {
				EObject next = (EObject) iter.next();
				
				if (stateName.equals(env.getStateName(next))) {
					state = next;
				}
			}
	
			if (state == null) {
				ERROR("stateExpCS", //$NON-NLS-1$
						NLS.bind(OCLMessages.NoSuchState_ERROR_,
								statePath,
								sourceType == null? null : sourceType.getName()));
			}
		}
		
		StateExp astNode = expressionsFactory.createStateExp();
		astNode.setReferredState(state);
		astNode.setType(Types.STATE);
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
	protected final EClassifier collectionTypeCS(
			CollectionTypeCS collectionTypeCS,
			Environment env
		) throws SemanticException {

		CollectionType astNode = collectionTypeIdentifierCS(collectionTypeCS.getCollectionTypeIdentifier());
		EClassifier type = typeCS(collectionTypeCS.getTypeCS(), env);
	
		astNode.setElementType(type);
		astNode.setName(astNode.getName() + "(" + type.getName() + ")" );//$NON-NLS-2$//$NON-NLS-1$

		initTypePositions(astNode, collectionTypeCS.getTypeCS());
			
		return astNode;
	}
	
	/**
	 * CollectionTypeIdentifierCS
	 * 
	 * @param collectionTypeIdentifier the <code>CollectionTypeIdentifierEnum</code> representing
	 *                                 the collection type
	 * @return the parsed <code>CollectionType</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final CollectionType collectionTypeIdentifierCS(
			CollectionTypeIdentifierEnum collectionTypeIdentifier
		) throws SemanticException {
	
		CollectionType astNode = null;

		switch (collectionTypeIdentifier.getValue()) {
			case CollectionTypeIdentifierEnum.SET:
	
				astNode = typesFactory.createSetType();
				astNode.setName("Set");//$NON-NLS-1$
				TRACE("collectionTypeIdentifierCS", "SET");//$NON-NLS-2$//$NON-NLS-1$
	
				break;
	
			case CollectionTypeIdentifierEnum.BAG:

				astNode = typesFactory.createBagType();
				astNode.setName("Bag");  //$NON-NLS-1$
				TRACE("collectionTypeIdentifierCS", "BAG"); //$NON-NLS-2$//$NON-NLS-1$
						
				break;

			case CollectionTypeIdentifierEnum.SEQUENCE:

				astNode = typesFactory.createSequenceType();
				astNode.setName("Sequence");//$NON-NLS-1$
				TRACE("collectionTypeIdentifierCS", "SEQUENCE"); //$NON-NLS-2$//$NON-NLS-1$
						
				break;

			case CollectionTypeIdentifierEnum.COLLECTION:

				astNode = typesFactory.createCollectionType();
				astNode.setName("Collection"); //$NON-NLS-1$
				TRACE("collectionTypeIdentifierCS", "COLLECTION"); //$NON-NLS-2$//$NON-NLS-1$
						
				break;

			case CollectionTypeIdentifierEnum.ORDERED_SET:

				astNode = typesFactory.createOrderedSetType();
				astNode.setName("OrderedSet");//$NON-NLS-1$
				TRACE("collectionTypeIdentifierCS", "ORDERED_SET"); //$NON-NLS-2$//$NON-NLS-1$
						
				break;
		}

		astNode.setElementType(Types.OCL_VOID);

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
	protected final EClassifier tupleTypeCS(
			TupleTypeCS tupleTypeCS,
			Environment env
		) throws SemanticException {
		
		HashSet names = new HashSet();
		String nodeName = null;
		EList vdcls = new BasicEList();
		String name;

		EList variableDeclarations = variableDeclarationListCS(tupleTypeCS.getVariables(), env, false);

		for (Iterator i = variableDeclarations.iterator(); i.hasNext(); ) {
			Variable vdcl = (Variable)i.next();
			
			vdcls.add(vdcl);
			name = vdcl.getName();
			TRACE("tupleTypeCS", " name = " + name);//$NON-NLS-2$//$NON-NLS-1$

			if (names.contains(name)) {
				String message = NLS.bind(
				OCLMessages.DuplicateNameInTuple_ERROR_,
				new Object[] { name });
				ERROR("tupleTypeCS", message);//$NON-NLS-1$
				vdcl.setName(null);
			} else {
				names.add(name);
			}
			
			if (vdcl.getInitExpression() != null) {
				String message = NLS.bind(
				OCLMessages.InitExpNotAllowed_ERROR_,
				new Object[] { name });
				ERROR("tupleTypeCS", message);//$NON-NLS-1$
			}

			if (vdcl.getType() == null) {
				String message = NLS.bind(
					OCLMessages.MissingTypeDecl_ERROR_,
					new Object[] { name });
					ERROR("tupleTypeCS", message);//$NON-NLS-1$
			}

			if (nodeName == null) {
				nodeName = "Tuple("; //$NON-NLS-1$
			} else {
				nodeName += ", "; //$NON-NLS-1$
			}

			nodeName += vdcl.getName() + ":" + vdcl.getType().getName(); //$NON-NLS-1$
		}

		EClassifier astNode = typesFactory.createTupleType(vdcls);
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
	protected final OCLExpression oclExpressionCS(
			OCLExpressionCS oclExpressionCS,
			Environment env
		) throws SemanticException {
		
		OCLExpression astNode = null;

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

		if (astNode != null)
			initStartEndPositions(astNode, oclExpressionCS);
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
	protected final OCLExpression variableExpCS(
			VariableExpCS variableExpCS,
			Environment env
		) throws SemanticException {

		OCLExpression astNode = simpleNameCS(variableExpCS.getSimpleNameCS(), env, null);
		EList qualifiers = qualifiersCS(variableExpCS.getArguments(), env, astNode);

		if (variableExpCS.getIsMarkedPreCS().isPre()) {
			if (astNode instanceof FeatureCallExp) {
				((FeatureCallExp) astNode).setMarkedPre(true);
			} else {
				ERROR("variableExpCS", OCLMessages.IllegalAtPre_ERROR_);//$NON-NLS-1$
			}
		}
		
		if (!qualifiers.isEmpty()) {
			if (astNode instanceof NavigationCallExp) {
				setQualifiers(env, "variableExpCS", (NavigationCallExp) astNode, qualifiers);//$NON-NLS-1$
			} else if ((astNode instanceof LoopExp)
					&& ((LoopExp) astNode).getBody() instanceof NavigationCallExp) {
				// might have parsed an implicit collect expression
				setQualifiers(env, "variableExpCS",//$NON-NLS-1$
					(NavigationCallExp) ((LoopExp) astNode).getBody(), qualifiers);
			} else {
				ERROR("variableExpCS", OCLMessages.IllegalQualifiers_ERROR_);//$NON-NLS-1$
			}
		} else if (astNode instanceof AssociationClassCallExp) {
			checkNotReflexive(env, "variableExpCS", (AssociationClassCallExp) astNode); //$NON-NLS-1$
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
	protected final EList qualifiersCS(
			EList arguments,
			Environment env,
			OCLExpression navigation
		) throws SemanticException {

		if (arguments.isEmpty()) {
			return ECollections.EMPTY_ELIST;
		}
		EList qualifiers = new BasicEList();

		if (navigation instanceof LoopExp) {
			navigation = ((LoopExp) navigation).getBody();
		}
		
		if (navigation instanceof AssociationClassCallExp) {
			AssociationClassCallExp acc = (AssociationClassCallExp) navigation;
			OCLExpression source = acc.getSource();
			
			OCLExpressionCS arg = (OCLExpressionCS)arguments.get(0);

			if (!(arg instanceof VariableExpCS)) {
				ERROR("qualifiersCS",//$NON-NLS-1$
					NLS.bind(OCLMessages.ParseCSTNodeType_ERROR_,
							"VariableExpCS",//$NON-NLS-1$
							arg.eClass().getName()));
			}

			SimpleNameCS qualifier = ((VariableExpCS)arg).getSimpleNameCS();
			String simpleName = qualifier.getValue();
			
			EStructuralFeature property = env.lookupProperty(source.getType(), simpleName);
			
			if (!(property instanceof EReference)) {
				String message = NLS.bind(OCLMessages.UnrecognizedVar_ERROR_,
					new Object[] { simpleName });
					ERROR("qualifiersCS", message);//$NON-NLS-1$
			}

			EReference reference = (EReference) property;
			
			TRACE("qualifierCS", "Reference: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$
			PropertyCallExp ref = expressionsFactory.createPropertyCallExp();
			ref.setReferredProperty(reference);
			ref.setType(TypeUtil.getOCLType(reference));
			
			if (source == null) {
				VariableExp src = expressionsFactory.createVariableExp();
				Variable implicitSource = env.lookupImplicitSourceForProperty(simpleName);
				src.setType(implicitSource.getType());
				src.setReferredVariable(implicitSource);
				src.setName(implicitSource.getName());
			}

			initStartEndPositions(ref, qualifier);
			initPropertyPositions(ref, qualifier);
			qualifiers.add(ref);
		} else {
			for (Iterator i = arguments.iterator(); i.hasNext(); ) {
				qualifiers.add(oclExpressionCS((OCLExpressionCS)i.next(), env));
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
	protected final IfExp ifExpCS(
			IfExpCS ifExpCS,
			Environment env
		) throws SemanticException {

		OCLExpression condition = oclExpressionCS(ifExpCS.getCondition(), env);
		OCLExpression thenExpression = oclExpressionCS(ifExpCS.getThenExpression(), env);
		OCLExpression elseExpression = oclExpressionCS(ifExpCS.getElseExpression(), env);

		TRACE("ifExpCS", " "); //$NON-NLS-2$//$NON-NLS-1$
	
		if (condition.getType() != Types.OCL_BOOLEAN && 
				condition != Types.OCL_VOID) {
			ERROR("ifExpCS", OCLMessages.BooleanForIf_ERROR_);//$NON-NLS-1$
		}
				
		IfExp astNode = expressionsFactory.createIfExp();
		astNode.setCondition(condition);
		astNode.setThenExpression(thenExpression);
		astNode.setElseExpression(elseExpression);
		astNode.setType(TypeUtil.commonSuperType(thenExpression.getType(), elseExpression.getType()));

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
	protected final LetExp letExpCS(
			LetExpCS letExpCS,
			Environment env
		) throws SemanticException {
		
		return (LetExp)letExpCSRecursive(letExpCS, 0, env);
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
	protected final OCLExpression letExpCSRecursive(
			LetExpCS letExpCS,
			int index,
			Environment env
		) throws SemanticException {

		OCLExpression astNode;

		if (index < letExpCS.getVariables().size()) {
			Variable variableDeclaration = variableDeclarationCS(
				(VariableCS)letExpCS.getVariables().get(index), env, true);
	
			String varName = variableDeclaration.getName();
	
			if (variableDeclaration.getType() == null) {
				String message = NLS.bind(OCLMessages.NoType_ERROR_,
				new Object[] { varName });
				ERROR("letExpCS", message);//$NON-NLS-1$
			}
			if (variableDeclaration.getInitExpression() == null) {
				String message = NLS.bind(OCLMessages.NoInitExp_ERROR_,
				new Object[] { varName });
				ERROR("letExpCS", message);//$NON-NLS-1$
			}
					
			OCLExpression letSubExp = letExpCSRecursive(letExpCS, ++index, env);
	
			LetExp letExp = expressionsFactory.createLetExp(); 
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
	protected final OCLExpression simpleNameCS(
			SimpleNameCS simpleNameCS,
			Environment env,
			OCLExpression source
		) throws SemanticException {

		OCLExpression astNode;

		String simpleName = null;
		
		astNode = null;
		EStructuralFeature property = null;
		EClassifier classifier = null;
		PropertyCallExp propertyCall = null;
		EClass assocClass = null;
		AssociationClassCallExp acref = null;
		Variable vdcl = null;

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
				simpleName = unquote(simpleNameCS.getValue());
				break;
			case SimpleTypeEnum.INTEGER:
			case SimpleTypeEnum.STRING:
			case SimpleTypeEnum.REAL:
			case SimpleTypeEnum.BOOLEAN:
			case SimpleTypeEnum.OCL_ANY:
			case SimpleTypeEnum.OCL_VOID:
			case SimpleTypeEnum.INVALID:
			case SimpleTypeEnum.OCL_MESSAGE:
				classifier = primitiveTypeCS(simpleNameCS.getType());
				simpleName = classifier.getName();
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
		EClassifier sourceElementType = null;
		if (source != null) {
			sourceElementType = source.getType();
			if (sourceElementType instanceof CollectionType) {
				sourceElementType = ((CollectionType) sourceElementType).getElementType();
			} 
		}
		
		Vector names = new Vector();
		names.addElement(simpleName);
		if (classifier == null) {
				classifier = env.lookupPathName(names);
		}
		if (classifier != null) {
			/* Variable is a classifier. Classifiers are used in
			 * allInstances, isKindOf, isTypeOf, asTypeOf operators
			 */
			
			TypeExp texp = expressionsFactory.createTypeExp();
			texp.setReferredType(classifier);
			texp.setType(TypeTypeImpl.createType(classifier));
			astNode = texp;			 		
		} else if (source == null && (vdcl = env.lookup(simpleName)) != null)  { 
			// Either a use of a declared variable or self

			TRACE("variableExpCS", "Variable Expression: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$
			
			/*if (source != null) {
				ERROR("simpleVariableExp", "Can't have a variable in the middle of a navigation path:"
								+ simpleName);
			}*/
			VariableExp vexp = expressionsFactory.createVariableExp();	
			vexp.setReferredVariable(vdcl);
			vexp.setName(vdcl.getName());
			vexp.setType( vdcl.getType());
			astNode = vexp;
		} else if ((property = env.lookupProperty( sourceElementType, simpleName)) != null) {
			
			TRACE("variableExpCS", "Property: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$
			propertyCall = expressionsFactory.createPropertyCallExp();
			propertyCall.setReferredProperty(property);
			propertyCall.setType(TypeUtil.getOCLType(property));
			if (source != null) {
				propertyCall.setSource(source);
			} else {
				VariableExp src = expressionsFactory.createVariableExp();
				Variable implicitSource = env.lookupImplicitSourceForProperty(simpleName);
				src.setType(implicitSource.getType());
				src.setReferredVariable(implicitSource);
				src.setName(implicitSource.getName());
				propertyCall.setSource(src);
			}

			initPropertyPositions(propertyCall, simpleNameCS);
			astNode = propertyCall;
						
		} else if ((assocClass = env.lookupAssociationClassReference(sourceElementType, simpleName)) != null) {
			TRACE("variableExpCS", "Association class: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$
			acref = expressionsFactory.createAssociationClassCallExp();
			acref.setReferredAssociationClass(assocClass);
			acref.setType(assocClass);
			
			if (source != null) {
				acref.setSource(source);
			} else {
				VariableExp src = expressionsFactory.createVariableExp();
				Variable implicitSource = env.lookupImplicitSourceForAssociationClass(simpleName);
				src.setType(implicitSource.getType());
				src.setReferredVariable(implicitSource);
				src.setName(implicitSource.getName());
				acref.setSource(src);
			}

			initPropertyPositions(acref, simpleNameCS);
			astNode = acref;
			
		} else {
			if (source != null && (vdcl = env.lookup(simpleName)) != null) {
				String message = NLS.bind(OCLMessages.VarInNavExp_ERROR_,
					new Object[] { simpleName });
					ERROR("variableExpCS", message);//$NON-NLS-1$
			} else {
				String message = NLS.bind(OCLMessages.UnrecognizedVar_ERROR_,
					new Object[] { simpleName });
					ERROR("variableExpCS", message);//$NON-NLS-1$
			}
		}
		
		/*
		 * If the source type is a collection, then need there is an implicit COLLECT operator.
		 * Note that this rule is not called after "->".
		 */
		if (source != null && source.getType() instanceof CollectionType) {
			astNode = createImplicitCollect(source, (FeatureCallExp) astNode, env);
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
	private IteratorExp createImplicitCollect(OCLExpression source,
			FeatureCallExp propertyCall, Environment env) throws SemanticException {
		
		EClassifier sourceElementType = ((CollectionType) source.getType()).getElementType();
		
		IteratorExp result = expressionsFactory.createIteratorExp();
		
		Variable itervar = genVariableDeclaration("modelPropertyCallCS", env,//$NON-NLS-1$
						null, sourceElementType, null, false, true, false);

		EList iters = result.getIterator();
		iters.add(itervar);
		result.setBody(propertyCall);
		result.setName("collect");//$NON-NLS-1$
		VariableExp vexp = expressionsFactory.createVariableExp();
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
		EClassifier bodyType = propertyCall.getType();
		if (bodyType instanceof CollectionType) {
			bodyType = ((CollectionType) bodyType).getElementType();
		}
		
		if (source.getType() instanceof SequenceType ||
				source.getType() instanceof OrderedSetType) {
			result.setType(typesFactory.createSequenceType(bodyType));
		} else {
			result.setType(typesFactory.createBagType(bodyType));
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
	protected final EClassifier primitiveTypeCS(SimpleTypeEnum simpleType) throws SemanticException {
		EClassifier astNode = null;

		switch (simpleType.getValue()) {
			case SimpleTypeEnum.INTEGER:
				astNode = Types.OCL_INTEGER;
				break;
	
			case SimpleTypeEnum.STRING:
				astNode = Types.OCL_STRING;
				break;
	
			case SimpleTypeEnum.REAL:
				astNode = Types.OCL_REAL;
				break;
	
			case SimpleTypeEnum.BOOLEAN:
				astNode = Types.OCL_BOOLEAN;
				break;
	
			case SimpleTypeEnum.OCL_ANY:
				astNode = Types.OCL_ANY_TYPE;
				break;
	
			case SimpleTypeEnum.OCL_VOID:
				astNode = Types.OCL_VOID;
				break;
				
			case SimpleTypeEnum.INVALID:
				astNode = Types.INVALID;
				break;
				
			case SimpleTypeEnum.OCL_MESSAGE:
				astNode = Types.OCL_MESSAGE;
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
	protected final LiteralExp  primitiveLiteralExpCS(
			PrimitiveLiteralExpCS primitiveLiteralExpCS,
			Environment env
		) throws SemanticException {

		LiteralExp astNode = null;
		
		if (primitiveLiteralExpCS instanceof IntegerLiteralExpCS) {
			astNode = integerLiteralExpCS((IntegerLiteralExpCS)primitiveLiteralExpCS, env);
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
	protected final IntegerLiteralExp integerLiteralExpCS(
			IntegerLiteralExpCS integerLiteralExpCS,
			Environment env
		) throws SemanticException {
	
		IntegerLiteralExp astNode = expressionsFactory.createIntegerLiteralExp();
		astNode.setIntegerSymbol(integerLiteralExpCS.getIntegerSymbol());
		astNode.setType(Types.OCL_INTEGER);
		astNode.setName("Integer"); //$NON-NLS-1$
		TRACE("integerLiteralExpCS", "Integer: " + integerLiteralExpCS.getSymbol());//$NON-NLS-2$//$NON-NLS-1$
			
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
	protected final RealLiteralExp realLiteralExpCS(
			RealLiteralExpCS realLiteralExpCS,
			Environment env
		) throws SemanticException {

		RealLiteralExp astNode = expressionsFactory.createRealLiteralExp();
		astNode.setRealSymbol(realLiteralExpCS.getRealSymbol());
		astNode.setType(Types.OCL_REAL);
		astNode.setName("Real");//$NON-NLS-1$
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
	protected final StringLiteralExp stringLiteralExpCS(
			StringLiteralExpCS stringLiteralExpCS,
			Environment env
		) throws SemanticException {

		StringLiteralExp astNode = expressionsFactory.createStringLiteralExp();
		String stringLiteral = stringLiteralExpCS.getStringSymbol();
		if (stringLiteral.length() <= 2) {
			astNode.setStringSymbol("");//$NON-NLS-1$
		} else {
			astNode.setStringSymbol(stringLiteral.substring(1, stringLiteral.length()-1));
		}
		astNode.setType(Types.OCL_STRING);
		astNode.setName("String");//$NON-NLS-1$
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
	protected final BooleanLiteralExp booleanLiteralExpCS(
			BooleanLiteralExpCS booleanLiteralExpCS,
			Environment env
		) throws SemanticException {
		
		BooleanLiteralExp astNode = expressionsFactory.createBooleanLiteralExp(); 
		astNode.setBooleanSymbol(booleanLiteralExpCS.getBooleanSymbol());
		astNode.setType(Types.OCL_BOOLEAN);
		astNode.setName("Boolean");//$NON-NLS-1$
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
	protected final NullLiteralExp nullLiteralExpCS(
			NullLiteralExpCS nullLiteralExpCS,
			Environment env
		) throws SemanticException {
		
		NullLiteralExp astNode = expressionsFactory.createNullLiteralExp(); 
		astNode.setType(Types.OCL_VOID);
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
	protected final InvalidLiteralExp invalidLiteralExpCS(
			InvalidLiteralExpCS nullLiteralExpCS,
			Environment env
		) throws SemanticException {
		
		InvalidLiteralExp astNode = expressionsFactory.createInvalidLiteralExp(); 
		astNode.setType(Types.INVALID);
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
	protected final OCLExpression literalExpCS(
			LiteralExpCS literalExpCS,
			Environment env
		) throws SemanticException {

		OCLExpression astNode = null;

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
	protected final TupleLiteralExp tupleLiteralExpCS(
			TupleLiteralExpCS tupleLiteralExpCS,
			Environment env
		) throws SemanticException {
		
		TupleLiteralExp astNode;
			
		HashSet names = new HashSet();
		String nodeName = null;
		String name;

		astNode = expressionsFactory.createTupleLiteralExp();
		EList tupleParts = astNode.getPart();
		TRACE("tupleLiteralExpCS", "Tuple");//$NON-NLS-2$//$NON-NLS-1$

		EList tupleLiteralParts = tupleLiteralPartListCS(
				tupleLiteralExpCS.getVariables(), env);

		for (Iterator i = tupleLiteralParts.iterator(); i.hasNext(); ) {
			TupleLiteralPart part = (TupleLiteralPart) i.next();

			tupleParts.add(part);
			name = part.getName();
			TRACE("tupleLiteralExpCS", " name = " + name);//$NON-NLS-2$//$NON-NLS-1$

			if (names.contains(name)) {
				String message = NLS.bind(
				OCLMessages.DuplicateNameInTuple_ERROR_,
					new Object[] { name });
				ERROR("tupleLiteralPartCS", message);//$NON-NLS-1$
				part.setName(null);
			} else {
				names.add(name);
			}
			
			if (part.getValue() == null) {
				String message = NLS.bind(
					OCLMessages.MissingTypeInTupleLiteralPart_ERROR_, new Object[] { name });
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

			nodeName += part.getName() + ":" + part.getType().getName(); //$NON-NLS-1$
		}

		TupleType tt = typesFactory.createTupleType(tupleParts);
		astNode.setType(tt);
		
		for (Iterator iter = tupleParts.iterator(); iter.hasNext();) {
			TupleLiteralPart part = (TupleLiteralPart) iter.next();
			
			part.setAttribute(tt.getEStructuralFeature(part.getName()));
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
	private EList tupleLiteralPartListCS(EList variableDeclarations, Environment env)
			throws SemanticException {
		
		EList result = new BasicEList();
		
		for (Iterator i = variableDeclarations.iterator(); i.hasNext(); ) {
			result.add(tupleLiteralPartCS((VariableCS)i.next(), env));
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
	private TupleLiteralPart tupleLiteralPartCS(
			VariableCS variableDeclarationCS,
			Environment env) throws SemanticException {
		
		String varName = unquote(variableDeclarationCS.getName());
		EClassifier type = null;
		if (variableDeclarationCS.getTypeCS() != null)
			type = typeCS(variableDeclarationCS.getTypeCS(), env);

	  	OCLExpression expr = null;
	  	if (variableDeclarationCS.getInitExpression() != null)
	  		expr = oclExpressionCS(variableDeclarationCS.getInitExpression(), env);
	
		TupleLiteralPart astNode = expressionsFactory.createTupleLiteralPart();
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
	protected final OCLExpression enumLiteralExpCS(
			EnumLiteralExpCS enumLiteralExpCS,
			Environment env
		) throws SemanticException {

		OCLExpression astNode;

		EList sequenceOfNames = enumLiteralExpCS.getPathNameCS().getSequenceOfNames();
		String lastToken = enumLiteralExpCS.getSimpleNameCS().getValue();

		EEnumLiteral literal = null;		
		EClassifier enumType = env.lookupPathName(sequenceOfNames);
		if (enumType == null || !(enumType instanceof EEnum)) {
			TypeExp typeExp = expressionsFactory.createTypeExp();
			
			// Check to see whether the pathname corresponds to a type
			sequenceOfNames.add(lastToken);
			EClassifier type = env.lookupPathName(sequenceOfNames);
			if (type == null) {		
				String message = NLS.bind(OCLMessages.UnrecognizedType_ERROR_,
					new Object[] { sequenceOfNames });
				ERROR("enumerationOrClassLiteralExpCS", message);//$NON-NLS-1$
			} else {
				typeExp.setReferredType(type);
				typeExp.setType(TypeTypeImpl.createType(type));
			}
			
			astNode = typeExp;
		} else { // is an enum
			astNode = expressionsFactory.createEnumLiteralExp();
			literal = ((EEnum) enumType).getEEnumLiteral(lastToken);
			if (literal == null) {
				String message = NLS.bind(OCLMessages.UnrecognizedEnum_ERROR_,
					new Object[] { lastToken });
				ERROR("enumerationOrClassLiteralExpCS", message);//$NON-NLS-1$
			}
			EnumLiteralExp litExp = (EnumLiteralExp) astNode;
			litExp.setReferredEnumLiteral(literal);
			astNode = litExp;
			if (enumType == null || literal == null) {
				astNode.setType(Types.INVALID);
			} else {
				astNode.setType(enumType);
			}			
		}
		String traceText = new String();
		for (Iterator i = sequenceOfNames.iterator(); i.hasNext(); ) {
			traceText += (String)i.next() + "::"; //$NON-NLS-1$
		}
		traceText += lastToken;
		TRACE("enumerationOrClassLiteralExpCS", traceText); //$NON-NLS-1$
			
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
	protected final CollectionLiteralExp collectionLiteralExpCS(
			CollectionLiteralExpCS collectionLiteralExpCS,
			Environment env
		) throws SemanticException {

		CollectionLiteralExp astNode;

		astNode = null;
		CollectionKind kind = null;
		CollectionLiteralPart collectionLiteralPartExp = null;
		EList collectionParts = null;
		EClassifier type = null;
		CollectionType resultType = null;
		
		resultType = collectionTypeIdentifierCS(collectionLiteralExpCS.getCollectionType());

		switch(collectionLiteralExpCS.getCollectionType().getValue()) {
			case CollectionTypeIdentifierEnum.SET:
				kind = CollectionKind.SET_LITERAL;
				break;

			case CollectionTypeIdentifierEnum.BAG:
				kind = CollectionKind.BAG_LITERAL;	
				break;
			
			case CollectionTypeIdentifierEnum.SEQUENCE:
				kind = CollectionKind.SEQUENCE_LITERAL;
				break;
			
			case CollectionTypeIdentifierEnum.ORDERED_SET:
				kind = CollectionKind.ORDERED_SET_LITERAL;
				break;
		}

		astNode = expressionsFactory.createCollectionLiteralExp();
		astNode.setKind(kind);
		collectionParts = astNode.getPart();
		
		EList collectionLiteralPartsCS = collectionLiteralExpCS.getCollectionLiteralParts();
		
		if (!collectionLiteralPartsCS.isEmpty()) {
			Iterator i = collectionLiteralPartsCS.iterator();
			
			CollectionLiteralPartCS colPart = (CollectionLiteralPartCS)i.next();
			collectionLiteralPartExp = collectionLiteralPartCS(colPart, env);
			collectionParts.add(collectionLiteralPartExp);				
			type = collectionLiteralPartExp.getType();
	
			while (i.hasNext()) {
					collectionLiteralPartExp = collectionLiteralPartCS(
						(CollectionLiteralPartCS)i.next(), env);
					EClassifier type1 = collectionLiteralPartExp.getType();					
					type = TypeUtil.commonSuperType(type, type1);
					collectionParts.add(collectionLiteralPartExp);
			}
		}
		
		if (collectionParts.isEmpty()) {
			// absolute wildcard element type
			resultType.setElementType(AnyTypeImpl.UML_CLASSIFIER);
			resultType.setName(resultType.getName() + "()");//$NON-NLS-1$
		} else {
			resultType.setElementType(type);
			resultType.setName(resultType.getName() + "(" + type.getName() + ")" );//$NON-NLS-2$//$NON-NLS-1$
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
	protected final CollectionLiteralPart collectionLiteralPartCS(
			CollectionLiteralPartCS collectionLiteralPartCS,
			Environment env
		) throws SemanticException {

		CollectionLiteralPart astNode;

		astNode = null;
		OCLExpression expr1 = null;
		OCLExpression expr2 = null;
		CollectionRange collRange = null;
		CollectionItem collItem = null;

		expr1 = oclExpressionCS(collectionLiteralPartCS.getExpressionCS(), env);

		if (collectionLiteralPartCS instanceof CollectionRangeCS) {
			CollectionRangeCS collectionRangeCS = (CollectionRangeCS)collectionLiteralPartCS;
			expr2 = oclExpressionCS(collectionRangeCS.getLastExpressionCS(), env);
			
			collRange = expressionsFactory.createCollectionRange();
			collRange.setFirst(expr1);
			collRange.setLast(expr2);
			collRange.setType(expr1.getType());
			// TODO:  What types are allowed in ranges.  Only Integers?
			if (expr1.getType() != expr2.getType()) {
				ERROR("collectionLiteralPartCS", //$NON-NLS-1$
					OCLMessages.FirstLastTypeMismatch_ERROR_);
			}
			astNode = collRange;
			TRACE("collectionLiteralPartCS", "collection range");//$NON-NLS-2$//$NON-NLS-1$
		} else {
			collItem = expressionsFactory.createCollectionItem();
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
	protected final OCLExpression propertyCallExpCS(
			CallExpCS propertyCallExpCS,
			Environment env
		) throws SemanticException {
		
		OCLExpression astNode = null;
		
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
	protected final LoopExp loopExpCS(
			LoopExpCS loopExpCS,
			Environment env
		) throws SemanticException {
		
		LoopExp astNode = null;
		
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
	protected final OCLExpression getCollectionSourceExpression(
			OCLExpressionCS oclExpressionCS,
			Environment env
			) throws SemanticException {
	
		OCLExpression astNode = oclExpressionCS(oclExpressionCS, env);

		/* The source must be a collection type.
   	  	 */
		if (!(astNode.getType() instanceof CollectionType)) {
			CollectionLiteralExp astNode1 = expressionsFactory.createCollectionLiteralExp();
			astNode1.setKind(CollectionKind.SET_LITERAL);
			EList collectionParts = astNode1.getPart();
			CollectionItem collItem = expressionsFactory.createCollectionItem();
			collItem.setType(astNode.getType());
			collItem.setItem(astNode);				
			collectionParts.add(collItem);
			SetType type = typesFactory.createSetType(astNode.getType());
			type.setName("Set(" + type.getName() + ")" );//$NON-NLS-2$//$NON-NLS-1$
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
	protected final IteratorExp iteratorExpCS(
			IteratorExpCS iteratorExpCS,
			Environment env
		) throws SemanticException {
		
		IteratorExp astNode;
		
		OCLExpression source = getCollectionSourceExpression(iteratorExpCS.getSource(), env);
		String name = iteratorExpCS.getSimpleNameCS().getValue();

		Variable vdcl = null;
		Variable vdcl1 = null;
		OCLExpression expr = null;
		EList iterators = null;
	
		
		if (iteratorExpCS.getVariable1() != null) {
			vdcl = variableDeclarationCS(iteratorExpCS.getVariable1(), env, true);
				
			astNode = expressionsFactory.createIteratorExp();
			astNode.setName(name);
			iterators = astNode.getIterator();	
			if (vdcl.getType() == null) {
				EClassifier sourceType = source.getType();
				if (sourceType instanceof CollectionType) {
					vdcl.setType(((CollectionType) sourceType).getElementType());
				}
			}
			iterators.add(vdcl);
						
			if (iteratorExpCS.getVariable2() != null) {
				vdcl1 = variableDeclarationCS(iteratorExpCS.getVariable2(), env, true);
				
				if (vdcl1.getType() == null) {
					EClassifier sourceType = source.getType();
					if (sourceType instanceof CollectionType) {
						vdcl1.setType(((CollectionType) sourceType).getElementType());
					}
				}
				iterators.add(vdcl1);
			}

		} else  {

			astNode = expressionsFactory.createIteratorExp();
			astNode.setName(name);
			iterators = astNode.getIterator();	
			// Synthesize the iterator expression.
			vdcl = genVariableDeclaration("iteratorExpCS", env, null, //$NON-NLS-1$
				((CollectionType) source.getType()).getElementType(), null, false, true, false);
			iterators.add(vdcl);
		}
		
		expr = oclExpressionCS(iteratorExpCS.getBody(), env);
	
		TRACE("oclIteratorExpCS: ", name);//$NON-NLS-1$
		
		if (name.equals("forAll") || name.equals("exists") || name.equals("one") || name.equals("isUnique")) {//$NON-NLS-4$//$NON-NLS-3$//$NON-NLS-2$//$NON-NLS-1$
			astNode.setType(Types.OCL_BOOLEAN);
		} else if (name.equals("select") || name.equals("reject") ) {//$NON-NLS-2$//$NON-NLS-1$
			astNode.setType(source.getType());
		} else if (name.equals("collect")) {//$NON-NLS-1$
			// The result type for collect must be flattened
			EClassifier elementType = expr.getType();
			while (elementType instanceof CollectionType) {
				elementType = ((CollectionType) elementType).getElementType();
			}
			if (source.getType() instanceof SequenceType || 
							source.getType() instanceof OrderedSetType) {
				astNode.setType(typesFactory.createSequenceType(elementType));
			} else {
				astNode.setType(typesFactory.createBagType(elementType));
			}
		} else if (name.equals("collectNested")) {//$NON-NLS-1$
			if (source.getType() instanceof SequenceType || 
							source.getType() instanceof OrderedSetType) {
				astNode.setType(typesFactory.createSequenceType(expr.getType()));
			} else {
				astNode.setType(typesFactory.createBagType(expr.getType()));
			}
		} else if (name.equals("any")) {//$NON-NLS-1$
			astNode.setType(((CollectionType) source.getType()).getElementType());
		} else if (name.equals("sortedBy")) {//$NON-NLS-1$
			if ((source.getType() instanceof SequenceType) ||
					source.getType() instanceof BagType) {
				SequenceType osType = typesFactory.createSequenceType();
				osType.setElementType(((CollectionType) source.getType()).getElementType());
				astNode.setType(osType);
			} else { // set, ordered set
				OrderedSetType osType = typesFactory.createOrderedSetType();
				osType.setElementType(((CollectionType) source.getType()).getElementType());
				astNode.setType(osType);
			}
		} else if (name.equals("closure")) {//$NON-NLS-1$
			// get the body element type if it is a collection-type
			//   expression
			EClassifier bodyType = expr.getType();
			if (bodyType instanceof CollectionType) {
				bodyType = ((CollectionType) bodyType).getElementType();
			}
			
			astNode.setType(typesFactory.createSetType(bodyType));
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
	protected final IterateExp iterateExpCS(
			IterateExpCS iterateExpCS,
			Environment env
		) throws SemanticException {
	
		IterateExp astNode = null;

		OCLExpression source = getCollectionSourceExpression(iterateExpCS.getSource(), env);
		Variable vdcl = null;
		Variable vdcl1 = null;
		OCLExpression expr = null;

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
			vdcl = genVariableDeclaration("iterateExpCS", env, null, //$NON-NLS-1$
					((CollectionType) source.getType()).getElementType(), null, false, true, false);	
		} 
		if ( vdcl.getType() == null) {
			vdcl.setType(((CollectionType) source.getType()).getElementType());
		}

		expr = oclExpressionCS(iterateExpCS.getBody(), env);

	
		TRACE("iterateExpCS", "iterate");//$NON-NLS-2$//$NON-NLS-1$
		astNode = expressionsFactory.createIterateExp();
		astNode.setName("iterate");			//$NON-NLS-1$
		EList iterator = astNode.getIterator();
		iterator.add(vdcl);
		astNode.setSource(source);
		astNode.setResult(vdcl1);
		astNode.setBody(expr);
		
		
		if (vdcl1.getType() == null) {
			String message = NLS.bind(OCLMessages.DeclarationType_ERROR_,
				new Object[] { vdcl1.getName() });
			ERROR("iterateExpCS", message);//$NON-NLS-1$
		}
		
		astNode.setType(vdcl1.getType());
		
		if (vdcl1.getInitExpression() == null) {
			String message = NLS.bind(OCLMessages.DeclarationNoInitExp_ERROR_,
				new Object[] { vdcl1.getName() });
			ERROR("iterateExpCS", message);//$NON-NLS-1$
		}
		if (vdcl.getInitExpression() != null) {
			String message = NLS.bind(OCLMessages.DeclarationInitExp_ERROR_,
				new Object[] { vdcl1.getName() });
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
	protected final OCLExpression modelPropertyCallExpCS(
			FeatureCallExpCS modelPropertyCallExpCS,
			Environment env
		) throws SemanticException {
		
		OCLExpression astNode = null;
		
		if (modelPropertyCallExpCS instanceof OperationCallExpCS) {
			astNode = operationCallExpCS((OperationCallExpCS)modelPropertyCallExpCS, env);
		} else {
			OCLExpression source = oclExpressionCS(modelPropertyCallExpCS.getSource(), env);
			astNode = simpleNameCS(modelPropertyCallExpCS.getSimpleNameCS(), env, source);

			EList qualifiers = qualifiersCS(modelPropertyCallExpCS.getArguments(), env, astNode);

			if (modelPropertyCallExpCS.getIsMarkedPreCS().isPre()) {
				if (astNode instanceof FeatureCallExp) {
					((FeatureCallExp) astNode).setMarkedPre(true);
				} else {
					ERROR("modelPropertyCallExpCS", OCLMessages.IllegalAtPre_ERROR_);//$NON-NLS-1$
				}
			}

			if (!qualifiers.isEmpty()) {
				if (astNode instanceof NavigationCallExp) {
					setQualifiers(env, "modelPropertyCallExpCS",//$NON-NLS-1$
						(NavigationCallExp) astNode, qualifiers);
				} else if ((astNode instanceof LoopExp)
						&& ((LoopExp) astNode).getBody() instanceof NavigationCallExp) {
					// might have parsed an implicit collect expression
					setQualifiers(env, "modelPropertyCallExpCS",//$NON-NLS-1$
						(NavigationCallExp) ((LoopExp) astNode).getBody(), qualifiers);
				} else {
					ERROR("modelPropertyCallExpCS", OCLMessages.IllegalQualifiers_ERROR_);//$NON-NLS-1$
				}
			} else if (astNode instanceof AssociationClassCallExp) {
				checkNotReflexive(env, "modelPropertyCallExpCS",//$NON-NLS-1$
					(AssociationClassCallExp) astNode);
			}
		}

		return astNode;
	}

	/**
	 * OperationCallExpCS
	 * 
	 * @param operationCallExpCS the <code>OperationCallExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment 
	 * @return the parsed <code>OCLExpression</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final OCLExpression operationCallExpCS(
			OperationCallExpCS operationCallExpCS,
			Environment env
		) throws SemanticException {
		
		OCLExpression astNode = null;

		EList args = new BasicEList();
		//boolean isMarkedPre = false;

		int operator = operationCallExpCS.getAccessor().getValue();
		
		/*
		 * The type of the operation is specified by a path expression
		 * or self, or by an explicit source expression.  The source expression
		 * may be a collection type (-> operation) or a regular navigation expression
		 * (. operation)
		 */
		OCLExpression source;
		if (operator == DotOrArrowEnum.ARROW) {
			source = getCollectionSourceExpression(operationCallExpCS.getSource(), env);
		} else {
			source = oclExpressionCS(operationCallExpCS.getSource(), env);
		}
		
		String operationName = operationCallExpCS.getSimpleNameCS().getValue();

		if (PredefinedType.OCL_IS_IN_STATE_NAME.equals(operationName)) {
			if (operationCallExpCS.getArguments().size() != 1) {
				ERROR("operationCallExpCS", OCLMessages.IsInStateSignature_ERROR_); //$NON-NLS-1$
			}
			
			OCLExpressionCS arg = (OCLExpressionCS) operationCallExpCS.getArguments().get(0);
			if (!(arg instanceof StateExpCS)) {
				ERROR("operationCallExpCS", OCLMessages.IsInStateSignature_ERROR_); //$NON-NLS-1$
			}
			
			args.add(stateExpCS(source, (StateExpCS) arg, env));
		} else {
			for (Iterator i = operationCallExpCS.getArguments().iterator(); i.hasNext(); ) {
				args.add(oclExpressionCS((OCLExpressionCS)i.next(), env));
			}
		}
		
		if (source == null) {  // create an implicit source
			VariableExp vexp = expressionsFactory.createVariableExp();
			Variable implicitSource = 
					env.lookupImplicitSourceForOperation(operationName, args);
			vexp.setType(implicitSource.getType());
			vexp.setReferredVariable(implicitSource);
			vexp.setName(implicitSource.getName());
			source = vexp;
		}

		/*
		 * If the source type is a collection and operator is ".",
		 * then there is an implicit COLLECT operator.
		 */
		EClassifier operationSourceType = source.getType();
		boolean isImplicitCollect = (operator == DotOrArrowEnum.DOT)
				&& (operationSourceType instanceof CollectionType);
		
		if (isImplicitCollect) {
			operationSourceType = ((CollectionType) operationSourceType).getElementType();
		}
		
		astNode = genOperationCallExp(env, "operationCallExpCS", operationName,//$NON-NLS-1$
				source, operationSourceType, args);
		
		((OperationCallExp) astNode).setMarkedPre(operationCallExpCS.getIsMarkedPreCS().isPre());

		initPropertyPositions((OperationCallExp) astNode, operationCallExpCS.getSimpleNameCS());

		if (isImplicitCollect) {
			astNode = createImplicitCollect(source, ((OperationCallExp) astNode), env);			
	   	}
			
		return astNode;
	}
	
	/**
	 * MessageExpCS
	 * 
	 * @param messageExpCS the <code>MessageExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment 
	 * @return the parsed <code>OCLExpression</code>
	 * @throws SemanticException if the expression contains semantic errors
	 */
	protected final OCLExpression messageExpCS(
			MessageExpCS messageExpCS,
			Environment env) throws SemanticException {
		MessageExp result;
		
		OCLExpression target = oclExpressionCS(messageExpCS.getTarget(), env);
		String name = messageExpCS.getSimpleNameCS().getValue();
		
		EList argsCS = messageExpCS.getArguments();
		EList arguments;
		
		if (argsCS.isEmpty()) {
			arguments = ECollections.EMPTY_ELIST;
		} else {
			arguments = new BasicEList();
			
			for (Iterator iter = argsCS.iterator(); iter.hasNext();) {
				OCLMessageArgCS argCS = (OCLMessageArgCS) iter.next();
				OCLExpression arg;
				
				if (argCS.getExpression() == null) {
					// unspecified value
					arg = expressionsFactory.createUnspecifiedValueExp();
					initStartEndPositions(arg, argCS);
					if (argCS.getTypeCS() == null) {
						// OclVoid matches any parameter type in an operation signature
						arg.setType(Types.OCL_VOID);
					} else {
						arg.setType(typeCS(argCS.getTypeCS(), env));
						initTypePositions((UnspecifiedValueExp) arg, argCS.getTypeCS());
					}
				} else {
					arg = oclExpressionCS(argCS.getExpression(), env);
				}
				
				arguments.add(arg);
			}
		}
		
		EOperation calledOperation = env.lookupOperation(target.getType(), name, arguments);
		EClass receivedSignal = env.lookupSignal(target.getType(), name, arguments);
		
		if ((calledOperation == null) && (receivedSignal == null)) {
			ERROR("messageExpCS", NLS.bind(OCLMessages.UnrecognizedMessageType_ERROR_, name)); //$NON-NLS-1$
		} else if ((calledOperation != null) && (receivedSignal != null)) {
			ERROR("messageExpCS", NLS.bind(OCLMessages.AmbiguousMessageType_ERROR_, name)); //$NON-NLS-1$
		}
		
		result = expressionsFactory.createMessageExp();
		initStartEndPositions(result, messageExpCS);
		initPropertyPositions(result, messageExpCS.getSimpleNameCS());
		result.setTarget(target);
		result.getArgument().addAll(arguments);
		
		ENamedElement behavioralFeature;
		if (calledOperation != null) {
			CallOperationAction callAction = umlFactory.createCallOperationAction();
			callAction.setOperation(calledOperation);
			result.setCalledOperation(callAction);
			behavioralFeature = calledOperation;
		} else {
			SendSignalAction sendAction = umlFactory.createSendSignalAction();
			sendAction.setSignal(receivedSignal);
			result.setSentSignal(sendAction);
			behavioralFeature = receivedSignal;
		}
		
		if (messageExpCS.getKind() == MessageExpKind.HAS_SENT_LITERAL) {
			result.setType(Types.OCL_BOOLEAN);
		} else {
			result.setType(typesFactory.createSequenceType(
					typesFactory.createMessageType(behavioralFeature)));
		}
		
		return result;
	}
}
