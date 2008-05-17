/**
 * <copyright>
 *
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc. and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *   E.D.Willink - refactored to separate from OCLAnalyzer and OCLParser
 *
 * </copyright>
 *
 * $Id: AbstractOCLAnalyzer.java,v 1.12 2008/05/17 20:41:35 cdamus Exp $
 */
package org.eclipse.ocl.parser;

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
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.cst.BooleanLiteralExpCS;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.ClassifierContextDeclCS;
import org.eclipse.ocl.cst.CollectionLiteralExpCS;
import org.eclipse.ocl.cst.CollectionLiteralPartCS;
import org.eclipse.ocl.cst.CollectionRangeCS;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.cst.ContextDeclCS;
import org.eclipse.ocl.cst.DefCS;
import org.eclipse.ocl.cst.DefExpressionCS;
import org.eclipse.ocl.cst.DotOrArrowEnum;
import org.eclipse.ocl.cst.EnumLiteralExpCS;
import org.eclipse.ocl.cst.FeatureCallExpCS;
import org.eclipse.ocl.cst.IfExpCS;
import org.eclipse.ocl.cst.InitOrDerValueCS;
import org.eclipse.ocl.cst.IntegerLiteralExpCS;
import org.eclipse.ocl.cst.InvCS;
import org.eclipse.ocl.cst.InvOrDefCS;
import org.eclipse.ocl.cst.InvalidLiteralExpCS;
import org.eclipse.ocl.cst.IterateExpCS;
import org.eclipse.ocl.cst.IteratorExpCS;
import org.eclipse.ocl.cst.LetExpCS;
import org.eclipse.ocl.cst.LiteralExpCS;
import org.eclipse.ocl.cst.LoopExpCS;
import org.eclipse.ocl.cst.MessageExpCS;
import org.eclipse.ocl.cst.MessageExpKind;
import org.eclipse.ocl.cst.NullLiteralExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OCLMessageArgCS;
import org.eclipse.ocl.cst.OperationCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.OperationContextDeclCS;
import org.eclipse.ocl.cst.PackageDeclarationCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.PrePostOrBodyDeclCS;
import org.eclipse.ocl.cst.PrePostOrBodyEnum;
import org.eclipse.ocl.cst.PrimitiveLiteralExpCS;
import org.eclipse.ocl.cst.PrimitiveTypeCS;
import org.eclipse.ocl.cst.PropertyContextCS;
import org.eclipse.ocl.cst.RealLiteralExpCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.cst.StateExpCS;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TupleLiteralExpCS;
import org.eclipse.ocl.cst.TupleTypeCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.cst.VariableExpCS;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionLiteralPart;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.EnumLiteralExp;
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
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.lpg.AbstractAnalyzer;
import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.options.ParsingOptions;
import org.eclipse.ocl.options.ProblemOption;
import org.eclipse.ocl.types.BagType;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.MessageType;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * The <code>AbstractOCLAnalyzer</code> supports semantic analysis of a CST produced by
 * an <code>AbstractOCLParser</code> to create the Essential OCL AST. It is necessary that
 * syntactic parsing and semantic analysis are performed in two steps
 * because LPG is a bottom up parser and cannot provide enough contextual
 * information to create the AST on the first pass.
 * 
 * Derived classes should extend the abstract support for EssentialOCL to full support
 * for whatever language in which EssentialOCL is embedded.
 * 
 * @since 1.2
 */
public abstract class AbstractOCLAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
		extends AbstractAnalyzer
{
   /** Prefix used by OCL to escape names that clash with keywords. */
    private static final String OCL_ESCAPE_PREFIX = "_"; //$NON-NLS-1$
    private static final int OCL_ESCAPE_LENGTH = OCL_ESCAPE_PREFIX.length();

    /*
	 * Factories for creating OCL AST nodes
	 */	 	
	protected OCLFactory oclFactory;
		
	protected UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> uml;
	
	protected final EnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	environmentFactory;

	public AbstractOCLAnalyzer(AbstractOCLParser parser) {
		super(parser);
		
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env = getOCLEnvironment();
		
		this.environmentFactory = env.getFactory();
		oclFactory = createOCLFactory(env);
        uml = env.getUMLReflection();
	}
	
	/**
	 * Creates/obtains the {@link OCLFactory} that I use to create OCL AST
	 * elements.
	 * 
	 * @param env my OCL environment
	 * 
	 * @return an appropriate factory
	 */
	protected OCLFactory createOCLFactory(
	        Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
	    return env.getOCLFactory();
	}

	@SuppressWarnings("unchecked")
	public Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getOCLEnvironment() {
		return getEnvironment().getAdapter(Environment.class);
	}
    
	@Override
	public AbstractOCLParser getParser() {
		return (AbstractOCLParser) super.getParser();
	}

	protected C getBoolean() {
        return getStandardLibrary().getBoolean();
    }
	
	protected C getOclVoid() {
		return getStandardLibrary().getOclVoid();
	}
    
	protected OCLStandardLibrary<C> getStandardLibrary() {
        return getOCLEnvironment().getOCLStandardLibrary();
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
			
			case OCLParsersym.TK_self:
			case OCLParsersym.TK_inv:
			case OCLParsersym.TK_pre:
			case OCLParsersym.TK_post:
			case OCLParsersym.TK_body:
			case OCLParsersym.TK_context:
			case OCLParsersym.TK_package:
			case OCLParsersym.TK_endpackage:
			case OCLParsersym.TK_def:
			case OCLParsersym.TK_derive:
			case OCLParsersym.TK_init:
			case OCLParsersym.TK_if:
			case OCLParsersym.TK_then:
			case OCLParsersym.TK_else:
			case OCLParsersym.TK_endif:
			case OCLParsersym.TK_and:
			case OCLParsersym.TK_or:
			case OCLParsersym.TK_xor:
			case OCLParsersym.TK_not:
			case OCLParsersym.TK_implies:
			case OCLParsersym.TK_let:
			case OCLParsersym.TK_in:
			case OCLParsersym.TK_true:
			case OCLParsersym.TK_false:
			case OCLParsersym.TK_Set:
			case OCLParsersym.TK_Bag:
			case OCLParsersym.TK_Sequence:
			case OCLParsersym.TK_Collection:
			case OCLParsersym.TK_OrderedSet:
			case OCLParsersym.TK_iterate:
			case OCLParsersym.TK_forAll:
			case OCLParsersym.TK_exists:
			case OCLParsersym.TK_isUnique:
			case OCLParsersym.TK_any:
			case OCLParsersym.TK_one:
			case OCLParsersym.TK_collect:
			case OCLParsersym.TK_select:
			case OCLParsersym.TK_reject:
			case OCLParsersym.TK_collectNested:
			case OCLParsersym.TK_sortedBy:
			case OCLParsersym.TK_closure:
			case OCLParsersym.TK_oclIsKindOf:
			case OCLParsersym.TK_oclIsTypeOf:
			case OCLParsersym.TK_oclAsType:
			case OCLParsersym.TK_oclIsNew:
			case OCLParsersym.TK_oclIsUndefined:
			case OCLParsersym.TK_oclIsInvalid:
			case OCLParsersym.TK_oclIsInState:
			case OCLParsersym.TK_allInstances:
			case OCLParsersym.TK_String:
			case OCLParsersym.TK_Integer:
            case OCLParsersym.TK_UnlimitedNatural:
			case OCLParsersym.TK_Real:
			case OCLParsersym.TK_Boolean:
			case OCLParsersym.TK_Tuple:
			case OCLParsersym.TK_OclAny:
			case OCLParsersym.TK_OclVoid:
			case OCLParsersym.TK_Invalid:
			case OCLParsersym.TK_OclMessage:
			case OCLParsersym.TK_null:
			case OCLParsersym.TK_OclInvalid:
			case OCLParsersym.TK_IDENTIFIER:
			case OCLParsersym.TK_EOF_TOKEN:
				return true;

		}
		return false;
	}
	
	/**
	 * Constructs the string representation of an operation call.
	 * 
	 * @param operName the operation name
	 * @param args the arguments in the operation call
	 * 
	 * @return the string representation
	 */
	protected String operationString(
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
	
	/**
	 * Sets the specified navigation call's qualifiers, if they are compatible
	 * with the navigated association end or association class.
	 * 
	 * @param rule the rule name that parsed the qualifiers
	 * @param nc the navigation call expression
	 * @param qualifiers the qualifiers to set
	 * @throws TerminateException 
	 */
	protected void setQualifiers(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			String rule,
			NavigationCallExp<C, P> nc,
			List<OCLExpression<C>> qualifiers) {
		
		if (nc instanceof PropertyCallExp) {
			P source = ((PropertyCallExp<C, P>) nc)
				.getReferredProperty();
			List<P> expectedQualifiers = uml.getQualifiers(source);
			
			if (expectedQualifiers.size() != qualifiers.size()) {
				ERROR(qualifiers, rule, OCLMessages.bind(
						OCLMessages.MismatchedQualifiers_ERROR_,
						nc.toString()));
				return;
			} else {
				if (!qualifiers.isEmpty()) {
					int iQualifierMax = expectedQualifiers.size();
					for (int iQualifier = 0; iQualifier < iQualifierMax; iQualifier++) {
						P expectedQualifier = expectedQualifiers.get(iQualifier);
						OCLExpression<C> qualifier = qualifiers.get(iQualifier);
						C expectedType = getOCLType(env, expectedQualifier);
						C qualifierType = qualifier.getType();
						if (!TypeUtil.compatibleTypeMatch(env, expectedType, qualifierType)) {
							ERROR(qualifier, rule, OCLMessages.bind(
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
				ERROR(qualifiers, rule, OCLMessages.bind(
						OCLMessages.AssociationClassQualifierCount_ERROR_,
						nc.toString()));
			}
			
			if (qualifiers.isEmpty()) {
				// already registered error
				return;
			}
			
			Object qualifier = qualifiers.get(0);
			if (!(qualifier instanceof PropertyCallExp)) {
				ERROR(qualifier, rule, OCLMessages.bind(
						OCLMessages.AssociationClassQualifierType_ERROR_,
						nc.toString()));
			} else {
				AssociationClassCallExp<C, P> acc =
					(AssociationClassCallExp<C, P>) nc;
				C assocClass = acc.getReferredAssociationClass();
				
				C sourceType = getElementType(nc.getSource().getType());
				
				@SuppressWarnings("unchecked")
				P property = ((PropertyCallExp<C, P>) qualifier)
						.getReferredProperty();

				// maybe look-up didn't find a property
				if (property != null) {
					C refAssocClass = uml.getAssociationClass(property);
					if (refAssocClass == null) {
						ERROR(qualifier, rule, OCLMessages.bind(
								OCLMessages.AssociationClassQualifierType_ERROR_,
								nc.toString()));
					} else {
						if (uml.getAttributes(sourceType).contains(property)
								&& (refAssocClass == assocClass)) {
							acc.setNavigationSource(property);
							
							CollectionKind kind = getCollectionKind(
							        getOCLType(env, property));
							if (kind != null) {
								acc.setType(getCollectionType(env, kind, assocClass));
							} else {
								acc.setType(assocClass);
							}
						} else {
							ERROR(qualifier, rule, OCLMessages.bind(
									OCLMessages.AssociationClassQualifierType_ERROR_,
									nc.toString()));
						}
					}
				}
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
	 * @param cstNode context of the call
	 * @throws TerminateException 
	 */
	protected void checkNotReflexive(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			String rule,
			AssociationClassCallExp<C, P> acc) {
		
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
				ERROR(acc, rule, OCLMessages.bind(
						OCLMessages.AssociationClassAmbiguous_ERROR_,
						acc.toString()));
			}
		}
	}
	
	/**
	 * Generate a VariableDeclaration AST node, and add it to the environment.
	 * Variable declarations are generated for "self", let expression variables, and
	 * iterator and iterate variables, both implicit and explicit.
	 * For implicit variables, the name is generated by the Environment.
	 * @throws TerminateException 
	 */
	protected Variable<C, PM>
	genVariableDeclaration(CSTNode cstNode, String rule,
				Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
				String name, C type, 
				OCLExpression<C> initExp,
				boolean explicitFlag, boolean addToEnvironment, boolean isSelf) {
			
		Variable<C, PM> vdcl = oclFactory.createVariable();
		initASTMapping(env, vdcl, cstNode);
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
					ERROR(cstNode, rule, message);
				} else {
					ERROR(cstNode, rule, OCLMessages.VariableDeclaration_ERROR_);
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
	 * @param env the current environment
	 * @param operationCallExpCS the operation call CST node
	 * @param rule the name of the concrete syntax rule that we are processing
	 * @param operName the operation name
	 * @param source the operation's source expression
	 * @param ownerType the type that defines the operation, in which we will
	 *     look it up.  This can differ from the type of the source expression
	 *     in the case of an implicit collect iterator
	 * @param args the operation arguments
	 * @throws TerminateException 
	 */ 
	protected OperationCallExp<C, O>
	genOperationCallExp(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			OperationCallExpCS operationCallExpCS,
			String rule,
			String operName,
			OCLExpression<C> source,
			C ownerType,
			List<OCLExpression<C>> args) {

		OperationCallExp<C, O> result;
		
		result = oclFactory.createOperationCallExp();
		initASTMapping(env, result, operationCallExpCS);
		result.setSource(source);	   
		
		// Performs method signature checking		
		O oper = lookupOperation(operationCallExpCS, env, ownerType, operName, args);
		if (oper == null) { 
			String message = OCLMessages.bind(OCLMessages.OperationNotFound_ERROR_,
					operationString(env, operName, args),
					(ownerType == null)? null : uml.getName(ownerType));
			ERROR(operationCallExpCS, rule, message);
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
					ERROR(operationCallExpCS, rule, OCLMessages.BadArg_ERROR_);
		   		} else {
		   			callargs.add(arg);
		   		}
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
	   					operationCallExpCS, env, ownerType, opcode, args);
		   	if (resultType == null) {
		   		resultType = getOCLType(env, oper);	   		
		   	}
		   	
			// resolve collection or tuple type against the cache in the environment
			resultType = TypeUtil.resolveType(env, resultType);
			
		   	result.setType(resultType);
		}
			
		return result;
	}

	/**
	 * PackageDeclarationCS
	 * 
	 * @param packageDeclarationCS the <code>PackageDeclarationCS</code> <code>CSTNode</code>
	 * @param constraints the constraints list to populate
	 * @throws TerminateException 
	 */
	protected void packageDeclarationCS(
			PackageDeclarationCS packageDeclarationCS,
			List<CT> constraints) {
		
        PathNameCS pathNameCS = packageDeclarationCS.getPathNameCS();
		EList<String> pathname = (pathNameCS == null)? null : pathNameCS.getSequenceOfNames();
		
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env;
        
        if (pathname == null) {
            env = getOCLEnvironment();
            pathname = ECollections.emptyEList();
        } else {
            try {
				env = createPackageContext(getOCLEnvironment(), pathname);
			} catch (LookupException e) {
    			ERROR(pathNameCS, "packageDeclarationCS", //$NON-NLS-1$
    					e.getMessage());
				return;
			}
            
    		if (env == null) {
    			ERROR(pathNameCS, "packageDeclarationCS", //$NON-NLS-1$
    					OCLMessages.bind(
    							OCLMessages.PackageNotFound_ERROR_,
    							makeString(pathname)));
    			return;
    		}
        }
        
		TRACE("packageDeclarationCS", "Package ", pathname); //$NON-NLS-2$//$NON-NLS-1$

		EList<ContextDeclCS> contextDecls = packageDeclarationCS.getContextDecls();
        
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
	 * @throws TerminateException 
	 */
	protected void contextDeclCS(
			ContextDeclCS contextDeclCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			List<CT> constraints) {
		
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
	 * @throws TerminateException 
	 */
	protected void operationContextDeclCS(
			OperationContextDeclCS operationContextDeclCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			List<CT> constraints) {

		env = operationCS(operationContextDeclCS.getOperationCS(), env);
		
		if (env != null) {
			CT astNode;
			for (PrePostOrBodyDeclCS decl : operationContextDeclCS.getPrePostOrBodyDecls()) {
				astNode = prePostOrBodyDeclCS(env, decl);
				
				if (astNode != null) {
					constraints.add(astNode);
				}
			}
		}
	}

	/**
	 * OperationCS
	 * 
	 * @param operationCS the <code>OperationCS</code> <code>CSTNode</code>
	 * @param env the classifier context environment
	 * @return the operation context environment, or <code>null</code> if the
	 *     operation could not be resolved
	 * @throws TerminateException 
	 */
	protected Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	operationCS(OperationCS operationCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		
		O operation = null;
		C classifier = null;
		EList<String> operationName = new BasicEList<String>();
		operationName.addAll(operationCS.getPathNameCS().getSequenceOfNames());
		operationName.add(operationCS.getSimpleNameCS().getValue());

		if (operationName.size() > 1) {
			int lastName = operationName.size() - 1;
			List<String> className = new java.util.ArrayList<String>(
				operationName.subList(0, lastName));
			classifier = lookupClassifier(operationCS, env, className);
			
			if (classifier != null) {
				// create the classifier context as parent for the operation context
				env = environmentFactory.createClassifierContext(env, classifier);
				
				// ensure that the classifier context has a 'self' variable
				if (env.lookupLocal(SELF_VARIABLE_NAME) == null) {
					genVariableDeclaration(operationCS, "operationCS", env,//$NON-NLS-1$
						SELF_VARIABLE_NAME, classifier, null, true, true, true);
				}
				
				// find the context operation
				List<Variable<C, PM>> contextParms =
					parametersCS(operationCS.getParameters(), env);
				operation = lookupOperation(operationCS, env, 
					classifier, operationName.get(lastName), contextParms);

				if (operation == null) {
					String message = OCLMessages.bind(
						OCLMessages.UnrecognizedContext_ERROR_,
						makeString(operationName));
					ERROR(operationCS, "operationContextDeclCS", message);//$NON-NLS-1$
					return null;
				}
			}
		}

		if (operation == null) {
			String message = OCLMessages.bind(
				OCLMessages.UnrecognizedContext_ERROR_,
				makeString(operationName));
			ERROR(operationCS, "operationContextDeclCS", message);//$NON-NLS-1$
			return null;
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

	protected Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	createOperationContext(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			OperationContextDeclCS operationContextCS,
			O operation) {
		
		// create the operation context
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> result =
			environmentFactory.createOperationContext(env, operation);
		
		// create a self variable for this operation
		if (result.lookupLocal(SELF_VARIABLE_NAME) == null) {
			genVariableDeclaration(operationContextCS, "operationContextDeclCS", result, //$NON-NLS-1$
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
	 * @throws TerminateException 
	 */
	protected List<Variable<C, PM>>
	parametersCS(
			List<VariableCS> parameters,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {

		return variableDeclarationListCS(parameters, env, false);
	}

	/**
	 * PrePostOrBodyDeclCS
	 * 
	 * @param prePostOrBodyDeclCS the <code>PrePostOrBodyDeclCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @param operation the context <code>EOperation</code>
	 * @return the parsed <code>Constraint</code>
	 * @throws TerminateException 
	 */
	protected CT prePostOrBodyDeclCS(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			PrePostOrBodyDeclCS prePostOrBodyDeclCS) {

		Variable<C, PM> resultVar = null;
		
		O operation = env.getContextOperation();
		
		OperationContextDeclCS operationContext =
		    (OperationContextDeclCS) prePostOrBodyDeclCS.eContainer();
		
		// create a disposable child operation context for this environment
		env = createOperationContext(env, operationContext, operation);
		
		C operationType = getOCLType(env, operation);
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
						prePostOrBodyDeclCS, "prePostOrBodyDeclCS0", env, //$NON-NLS-1$
						Environment.RESULT_VARIABLE_NAME, operationType, null, true, true, false);
				}

				break;

			case PrePostOrBodyEnum.BODY:
				stereotype = UMLReflection.BODY;
				 
				// likewise, body conditions have an implicit variable "result"
				// when using the UML-style post-condition-like form of body
				// condition constraint
				if ((operationType != null) && (env.lookupLocal(Environment.RESULT_VARIABLE_NAME) == null)) {
					resultVar = genVariableDeclaration(
						prePostOrBodyDeclCS, "prePostOrBodyDeclCS", env, //$NON-NLS-1$
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
			astNode = createConstraint();
			initASTMapping(env, astNode, prePostOrBodyDeclCS);
			
			SimpleNameCS simpleNameCS = prePostOrBodyDeclCS.getSimpleNameCS();
			if (simpleNameCS != null) {
                uml.setConstraintName(astNode, simpleNameCS.getValue());
			}
			
			List<EObject> constrainedElement = uml.getConstrainedElements(astNode);
			constrainedElement.add((EObject) operation);
			
			C owner = uml.getOwningClassifier(operation);
			if (owner != env.getSelfVariable().getType()) {
				// implicitly redefining the operation in a specializing classifier
				constrainedElement.add((EObject) env.getSelfVariable().getType());
				
				if (operationContext != null) {
    	            // check settings for using inherited feature context in
				    // concrete syntax (note that the OLCHelper brings us in
				    // here, too, which is why we check for the context CST)
	                ProblemHandler.Severity sev = getEnvironment().getValue(
	                    ProblemOption.INHERITED_FEATURE_CONTEXT);
    	            if (!sev.isOK()) {
    	                getEnvironment().problem(sev, ProblemHandler.Phase.ANALYZER,
    	                    OCLMessages.bind(OCLMessages.NonStd_InheritedFeatureContext_,
    	                        formatQualifiedName(owner),
    	                        formatName(operation)),
    	                    "prePostOrBodyDeclCS", //$NON-NLS-1$
    	                    null);
    	            }
				}
			}
			
			ExpressionInOCL<C, PM> spec = createExpressionInOCL();
			initASTMapping(env, spec, prePostOrBodyDeclCS);
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
	 * 
	 * @return the context property, or <code>null</code> if it could not be
	 *     resolved 
	 */
	protected P propertyContextCS(
			PropertyContextCS propertyContextCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			List<CT> constraints) {

		EList<String> pathName = propertyContextCS.getPathNameCS().getSequenceOfNames();
		C owner = lookupClassifier(propertyContextCS, env, pathName);
		
		if (owner == null) {
			String message = OCLMessages.bind(
				OCLMessages.UnrecognizedContext_ERROR_,
				makeString(pathName));
			ERROR(propertyContextCS, "propertyContextCS", message);//$NON-NLS-1$
			return null;
		}

		owner = uml.asOCLType(owner);
		
		// create the classifier context as parent for the property context
		env = environmentFactory.createClassifierContext(env, owner);
		
		SimpleNameCS simplenameCS = propertyContextCS.getSimpleNameCS();
		String simpleName = simplenameCS.getValue();
		P property = lookupProperty(simplenameCS, env, owner, simpleName);
		
		EList<String> propertyName = new BasicEList<String>();
		propertyName.addAll(pathName);
		propertyName.add(simpleName);
		
		if (property == null) {
			String message = OCLMessages.bind(
				OCLMessages.UnrecognizedContext_ERROR_,
				makeString(propertyName));
			ERROR(propertyContextCS, "propertyContextCS", message);//$NON-NLS-1$
			return null;
		}
		
		C type = typeCS(propertyContextCS.getTypeCS(), env);
		C propertyType = TypeUtil.getPropertyType(env, owner, property);
		if ((type == null) || !TypeUtil.exactTypeMatch(env, propertyType, type)) {
			String message = OCLMessages.bind(
				OCLMessages.UnrecognizedContext_ERROR_,
				makeString(propertyName));
			ERROR(propertyContextCS.getTypeCS(), "propertyContextCS", message);//$NON-NLS-1$
			
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
				ERROR(initOrDerValueCS, "propertyContextCS", message);//$NON-NLS-1$
			}
			
			astNode = initOrDerValueCS(env, other);
			constraints.add(astNode);
		}
		
		return property;
	}
	
	protected Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	createPropertyContext(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			PropertyContextCS propertyContextCS,
			P property) {
		
		// create the classifier context as parent for the property context
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> result =
			environmentFactory.createAttributeContext(env, property);
		
		// ensure that the classifier context has a 'self' variable
		if (result.lookupLocal(SELF_VARIABLE_NAME) == null) {
			genVariableDeclaration(propertyContextCS, "propertyContextCS", result, //$NON-NLS-1$
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
	 * @throws TerminateException 
	 */
	protected CT initOrDerValueCS(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			InitOrDerValueCS initOrDerValueCS) {

		P property = env.getContextProperty();
		
		PropertyContextCS propertyContext = null;
		for (EObject container = initOrDerValueCS.eContainer(); container != null;
		        container = container.eContainer()) {
		    if (container instanceof PropertyContextCS) {
		        propertyContext = (PropertyContextCS) container;
		        break;
		    }
		}
		
		// create a disposable property context for this environment
		env = createPropertyContext(env, propertyContext, property);
		
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
		
		CT astNode = createConstraint();
		initASTMapping(env, astNode, initOrDerValueCS);

		List<EObject> constrainedElement = uml.getConstrainedElements(astNode);
		constrainedElement.add((EObject) property);
		
		C owner = uml.getOwningClassifier(property);
		if (owner != env.getSelfVariable().getType()) {
			// implicitly redefining the property in a specializing classifier
			constrainedElement.add((EObject) env.getSelfVariable().getType());
            
            if (propertyContext != null) {
                // check settings for using inherited feature context in
                // concrete syntax (note that the OLCHelper brings us in
                // here, too, which is why we check for the context CST)
                
                ProblemHandler.Severity sev = getEnvironment().getValue(
                    ProblemOption.INHERITED_FEATURE_CONTEXT);
                if (!sev.isOK()) {
                    getEnvironment().problem(sev, ProblemHandler.Phase.ANALYZER,
                        OCLMessages.bind(OCLMessages.NonStd_InheritedFeatureContext_,
                            formatQualifiedName(owner),
                            formatName(property)),
                        "initOrDerValueCS", //$NON-NLS-1$
                        null);
                }
            }
		}
		
		ExpressionInOCL<C, PM> spec = createExpressionInOCL();
		initASTMapping(env, spec, initOrDerValueCS);
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
	 * 
	 * @param the classifier context environment, or <code>null</code> of the
	 *     classifier could not be resolved
	 * @throws TerminateException 
	 */
	protected Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	classifierContextDeclCS(
			ClassifierContextDeclCS classifierContextDeclCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			List<CT> constraints) {
		
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> result = null;
		
		EList<String> pathName = classifierContextDeclCS.getPathNameCS().getSequenceOfNames();
		C type = lookupClassifier(classifierContextDeclCS, env, pathName);
		
		if (type == null) {
			String message = OCLMessages.bind(
				OCLMessages.UnrecognizedContext_ERROR_,
				makeString(pathName));
			ERROR(classifierContextDeclCS, "classifierContextDeclCS", message);//$NON-NLS-1$
			return null;
		}

		type = uml.asOCLType(type);

		result = environmentFactory.createClassifierContext(env, type);
		
        if (result.getSelfVariable() == null) {
            // ensure that the classifier context has a "self" variable
    		genVariableDeclaration(classifierContextDeclCS, "classifierContextDeclCS", result, //$NON-NLS-1$
    			SELF_VARIABLE_NAME, type, null, true, true, true);
        }
        
		TRACE("classifierContextDeclCS", "context", pathName);  //$NON-NLS-2$//$NON-NLS-1$
		
        // reverse the chain of constraint declarations to process them in the
        // forward order
		List<InvOrDefCS> constraintDecls = new BasicEList.FastCompare<InvOrDefCS>(4);
        InvOrDefCS invOrDefCS = classifierContextDeclCS.getInvOrDefCS();
        while (invOrDefCS != null) {
            constraintDecls.add(0, invOrDefCS);
            invOrDefCS = invOrDefCS.getInvOrDefCS();
        }
        
        // now, parse them
		for (InvOrDefCS decl : constraintDecls) {
			CT constraint = invOrDefCS(decl, result);
			if (constraint != null) {
				constraints.add(constraint);
			}
		}		
		
		return result;
	}
	
	protected Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	createClassifierContext(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			ClassifierContextDeclCS classifierContextDeclCS,
			C classifier) {
		
		// create the classifier context as parent for the property context
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> result =
			environmentFactory.createClassifierContext(env, classifier);
		
		// ensure that the classifier context has a 'self' variable
		if (result.lookupLocal(SELF_VARIABLE_NAME) == null) {
			genVariableDeclaration(classifierContextDeclCS, "propertyContextCS", result, //$NON-NLS-1$
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
	 * @throws TerminateException 
	 */
	protected CT invOrDefCS(
			InvOrDefCS invOrDefCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		
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
	 * @throws TerminateException 
	 */
	protected CT invCS(
			InvCS invCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		
		OCLExpression<C> oclExpression =
			oclExpressionCS(invCS.getExpressionCS(), env);

		CT astNode = createConstraint();
		initASTMapping(env, astNode, invCS);
		
		SimpleNameCS simpleNameCS = invCS.getSimpleNameCS();

		if (simpleNameCS != null) {
            uml.setConstraintName(astNode, simpleNameCS.getValue());
		}
		
		C type = env.getContextClassifier();
		List<EObject> constrainedElement = uml.getConstrainedElements(astNode);
		constrainedElement.add((EObject) type);
		
		ExpressionInOCL<C, PM> spec = createExpressionInOCL();
		initASTMapping(env, spec, invCS);
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
	 * @throws TerminateException 
	 */
	protected CT defCS(
			DefCS defCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> contextEnv;
		DefExpressionCS defExpr = defCS.getDefExpressionCS();
		
		EObject feature = null;
		OCLExpression<C> expression = null;
		
		CT astNode = createConstraint();
		initASTMapping(env, astNode, defCS);
		
		Variable<C, PM> variable = null;
		C operType = null;
		C contextClassifier = env.getContextClassifier();
		
		SimpleNameCS simpleNameCS = defCS.getSimpleNameCS();

		if (simpleNameCS != null) {
            uml.setConstraintName(astNode, simpleNameCS.getValue());
		}
		
		List<EObject> constrainedElement = uml.getConstrainedElements(astNode);
		constrainedElement.add((EObject) contextClassifier);
		
		ExpressionInOCL<C, PM> spec = createExpressionInOCL();
		initASTMapping(env, spec, defCS);
        uml.setSpecification(astNode, spec);
        uml.setStereotype(astNode, UMLReflection.DEFINITION);
		
		try {
			if (defExpr.getVariableCS() != null) {
				// context of the expression is the classifier
				contextEnv = env;
				
				variable = variableDeclarationCS(defExpr.getVariableCS(), contextEnv, false);
				
				P existing = lookupProperty(defExpr.getVariableCS(),
				        env,
						contextClassifier,
						variable.getName());
				if (existing != null) {
					ERROR(defCS, "defCS", //$NON-NLS-1$
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
				
                if (getEnvironment().getValue(ParsingOptions.DEFINITION_CONSTRAINS_FEATURE)) {
                    constrainedElement.add(feature);
                }
                
				expression = oclExpressionCS(defExpr.getExpressionCS(), contextEnv);
			} else if (defExpr.getOperationCS() != null) {
				// context of the expression is the new operation
				OperationCS operCS = defExpr.getOperationCS();
				contextEnv = environmentFactory.createEnvironment(env);
								
				List<Variable<C, PM>> params = variableDeclarationListCS(
						operCS.getParameters(), contextEnv, true);
				operType = typeCS(operCS.getTypeCS(), contextEnv);
				
				String operName = operCS.getSimpleNameCS().getValue();
				
				O existing = lookupOperation(operCS, env, contextClassifier, operName, params);
				if (existing != null) {
					ERROR(defCS, "defCS", //$NON-NLS-1$
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
                if (getEnvironment().getValue(ParsingOptions.DEFINITION_CONSTRAINS_FEATURE)) {
                    constrainedElement.add(feature);
                }
				
				expression = oclExpressionCS(defExpr.getExpressionCS(), contextEnv);
			}
			
			if ((feature != null) && (expression != null)) {
				C featureType = getOCLType(env, feature);
				C bodyType = expression.getType();
				
				if ((featureType == null)
						|| !TypeUtil.compatibleTypeMatch(env, bodyType, featureType)) {
					
					expression = null;  // trigger undefinition of the feature
					astNode = null;		// fail to return an AST node
					String message = OCLMessages.bind(
							OCLMessages.DefinitionConstraintConformance_ERROR_,
				            uml.getName(bodyType),
				            uml.getName(featureType));
					ERROR(defCS, "defCS", message);//$NON-NLS-1$
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
	 * @throws TerminateException 
	 */
	protected Variable<C, PM>
	variableDeclarationCS(
			VariableCS variableDeclarationCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			boolean addToEnvironment) {
		
		
		String varName = variableDeclarationCS.getName();
		C type = null;
		if (variableDeclarationCS.getTypeCS() != null) {
            type = typeCS(variableDeclarationCS.getTypeCS(), env);
        }

	  	OCLExpression<C> expr = null;
	  	if (variableDeclarationCS.getInitExpression() != null) {
            expr = oclExpressionCS(variableDeclarationCS.getInitExpression(), env);
        }
	
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
			variableDeclarationCS, "variableDeclarationCS", env, varName, type, expr, //$NON-NLS-1$
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
	 * @throws TerminateException 
	 */
	protected List<Variable<C, PM>>
	variableDeclarationListCS(
			List<VariableCS> variableDeclarationCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			boolean addToEnvironment) {
		
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
	 * @throws TerminateException 
	 */
	protected C typeCS(
			TypeCS typeCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {

		C astNode = null;

		if (typeCS instanceof PrimitiveTypeCS) {
			astNode = primitiveTypeCS(((PrimitiveTypeCS)typeCS).getType(), env);
		} else if (typeCS instanceof PathNameCS) {
			astNode = lookupClassifier(typeCS, env, ((PathNameCS)typeCS).getSequenceOfNames());
			if (astNode == null) {
				String message = OCLMessages.bind(
						OCLMessages.UnrecognizedType_ERROR_,
						formatPath(((PathNameCS)typeCS).getSequenceOfNames()));
				ERROR(typeCS, "typeCS", message);//$NON-NLS-1$
				astNode = getOclVoid();
			}
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
	 * @throws TerminateException 
	 */
	protected StateExp<C, S>
	stateExpCS(
			OCLExpression<C> source,
			StateExpCS stateExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {

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
			state = lookupState(stateExpCS, env, sourceType, statePath);
			if (state == null) {
				ERROR(stateExpCS, "stateExpCS", //$NON-NLS-1$
						OCLMessages.bind(OCLMessages.NoSuchState_ERROR_,
								statePath,
								sourceType == null? null : uml.getName(sourceType)));
				// FIXME Set state to some unresolvedState to avoid NPEs etc
			}
		}
		
		StateExp<C, S> astNode = oclFactory.createStateExp();
		initASTMapping(env, astNode, stateExpCS);
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
	 * @throws TerminateException 
	 */
	protected C collectionTypeCS(
			CollectionTypeCS collectionTypeCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {

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
	 */
	protected CollectionKind collectionTypeIdentifierCS(
			CollectionTypeIdentifierEnum collectionTypeIdentifier) {
	
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
	 * @throws TerminateException 
	 */
	protected C tupleTypeCS(
			TupleTypeCS tupleTypeCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		
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
				ERROR(vdcl, "tupleTypeCS", message);//$NON-NLS-1$
				vdcl.setName(null);
			} else {
				names.add(name);
			}
			
			if (vdcl.getInitExpression() != null) {
				String message = OCLMessages.bind(
						OCLMessages.InitExpNotAllowed_ERROR_,
						name);
				ERROR(vdcl, "tupleTypeCS", message);//$NON-NLS-1$
			}

			if (vdcl.getType() == null) {
				String message = OCLMessages.bind(
						OCLMessages.DeclarationType_ERROR_,
						name);
				ERROR(vdcl, "tupleTypeCS", message);//$NON-NLS-1$
				vdcl.setType(getOclVoid());
			}

			if (nodeName == null) {
				nodeName = "Tuple("; //$NON-NLS-1$
			} else {
				nodeName += ", "; //$NON-NLS-1$
			}

			nodeName += vdcl.getName() + ":" + uml.getName(vdcl.getType()); //$NON-NLS-1$
		}

		return getTupleType(tupleTypeCS, env, vdcls);
	}

	/**
	 * OCLExpressionCS
	 * 
	 * @param oclExpressionCS the <code>OCLExpressionCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>OCLExpression</code>
	 * @throws TerminateException 
	 */
	protected OCLExpression<C> oclExpressionCS(
			OCLExpressionCS oclExpressionCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		
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
	 * @throws TerminateException 
	 */
	protected OCLExpression<C> variableExpCS(
			VariableExpCS variableExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {

		SimpleNameCS simpleNameCS = variableExpCS.getSimpleNameCS();
		OCLExpression<C> astNode = simpleNameCS(simpleNameCS, env, null);
		List<OCLExpression<C>> qualifiers = qualifiersCS(variableExpCS.getArguments(), env, astNode);

		if (variableExpCS.getIsMarkedPreCS().isPre()) {
			if (astNode instanceof FeatureCallExp) {
				((FeatureCallExp<C>) astNode).setMarkedPre(true);
			} else {
				ERROR(astNode, "variableExpCS", OCLMessages.IllegalAtPre_ERROR_);//$NON-NLS-1$
			}
		}
		
		if (!qualifiers.isEmpty()) {
			if (astNode instanceof NavigationCallExp) {
			    @SuppressWarnings("unchecked")
			    NavigationCallExp<C, P> callNode = (NavigationCallExp<C, P>) astNode;
				setQualifiers(env, "variableExpCS", callNode, qualifiers); //$NON-NLS-1$
			} else if ((astNode instanceof LoopExp)
					&& ((LoopExp<?, ?>) astNode).getBody() instanceof NavigationCallExp) {
				// might have parsed an implicit collect expression
                @SuppressWarnings("unchecked")
                NavigationCallExp<C, P> callNode = (NavigationCallExp<C, P>) ((LoopExp<C, ?>) astNode)
                        .getBody();
				setQualifiers(env, "variableExpCS", callNode, qualifiers);//$NON-NLS-1$
			} else {
				ERROR(variableExpCS, "variableExpCS", //$NON-NLS-1$
						OCLMessages.bind(
								OCLMessages.IllegalQualifiers_ERROR_,
								computeInputString(variableExpCS)));
			}
		} else if (astNode instanceof AssociationClassCallExp) {
            @SuppressWarnings("unchecked")
            AssociationClassCallExp<C, P> callNode = (AssociationClassCallExp<C, P>) astNode;
			checkNotReflexive(env, "variableExpCS", callNode);//$NON-NLS-1$
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
	 * @throws TerminateException 
	 */
	protected List<OCLExpression<C>> qualifiersCS(
			List<OCLExpressionCS> arguments,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			OCLExpression<C> navigation) {

		if (arguments.isEmpty()) {
			return Collections.emptyList();
		}
		
		List<OCLExpression<C>> qualifiers =
			new java.util.ArrayList<OCLExpression<C>>();

		if (navigation instanceof LoopExp) {
		    @SuppressWarnings("unchecked")
		    LoopExp<C, ?> loopNode = (LoopExp<C, ?>) navigation;
			navigation = loopNode.getBody();
		}
		
		if (navigation instanceof AssociationClassCallExp) {
            @SuppressWarnings("unchecked")
			AssociationClassCallExp<C, P> acc =
				(AssociationClassCallExp<C, P>) navigation;
			OCLExpression<C> source = acc.getSource();
			
			OCLExpressionCS arg = arguments.get(0);

			if (!(arg instanceof VariableExpCS)) {
				ERROR(arg, "qualifiersCS",//$NON-NLS-1$
					OCLMessages.bind(OCLMessages.ParseCSTNodeType_ERROR_,
							"VariableExpCS",//$NON-NLS-1$
							arg.eClass().getName()));
			} else {
				SimpleNameCS qualifier = ((VariableExpCS)arg).getSimpleNameCS();
				String simpleName = qualifier.getValue();
				
	 			C sourceType = source != null ? source.getType() : null;
	 			P property = lookupProperty(qualifier, env, sourceType, simpleName);
				
				if (property == null) {
					String message = OCLMessages.bind(
							OCLMessages.UnrecognizedVar_ERROR_,
							simpleName);
						ERROR(sourceType, "qualifiersCS", message);//$NON-NLS-1$
				} else {
					TRACE("qualifierCS", "Reference: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$
					PropertyCallExp<C, P> ref = oclFactory.createPropertyCallExp();
					initASTMapping(env, ref, arg);
					ref.setReferredProperty(property);
					ref.setType(TypeUtil.getPropertyType(env, sourceType, property));
					
					if (source == null) {
						VariableExp<C, PM> src = oclFactory.createVariableExp();
						initASTMapping(env, src, arg);
						Variable<C, PM> implicitSource = env.lookupImplicitSourceForProperty(simpleName);
						src.setType(implicitSource.getType());
						src.setReferredVariable(implicitSource);
					}
		
					initStartEndPositions(ref, qualifier);
					initPropertyPositions(ref, qualifier);
					qualifiers.add(ref);
				}
			}
		} else {
			for (OCLExpressionCS arg : arguments) {
				OCLExpression<C> qualExp = oclExpressionCS(arg, env);
				
				if (qualExp != null) {
					qualifiers.add(qualExp);
				}
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
	 * @throws TerminateException 
	 */
	protected IfExp<C> ifExpCS(
			IfExpCS ifExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {

		OCLExpression<C> condition =
			oclExpressionCS(ifExpCS.getCondition(), env);
		OCLExpression<C> thenExpression =
			oclExpressionCS(ifExpCS.getThenExpression(), env);
		OCLExpression<C> elseExpression =
			oclExpressionCS(ifExpCS.getElseExpression(), env);

		TRACE("ifExpCS", " "); //$NON-NLS-2$//$NON-NLS-1$
	
		IfExp<C> astNode = oclFactory.createIfExp();
		
		if (isErrorNode(condition)) {
			// don't validate the condition type
		} else if (condition.getType() != getBoolean()) {
			ERROR(ifExpCS.getCondition(), "ifExpCS", OCLMessages.bind( //$NON-NLS-1$
					OCLMessages.BooleanForIf_ERROR_,
					computeInputString(ifExpCS.getCondition())));
		}
				
		initASTMapping(env, astNode, ifExpCS);
		astNode.setCondition(condition);
		astNode.setThenExpression(thenExpression);
		astNode.setElseExpression(elseExpression);
		
		if ((thenExpression != null) && (elseExpression != null)) {
			C commonType = getCommonSuperType(ifExpCS, "ifExpCS", env, //$NON-NLS-1$
					thenExpression.getType(),
					elseExpression.getType());
			astNode.setType(commonType);
			
			if (isErrorNode(thenExpression)) {
				// propagate error stigma to the if expression
				markAsErrorNode(astNode);
			}
			if (isErrorNode(elseExpression)) {
				// propagate error stigma to the if expression
				markAsErrorNode(astNode);
			}
		} else {
			astNode.setType(getOclVoid());
		}
		
		initStartEndPositions(astNode, ifExpCS);
	
		return astNode;
	}

	/**
	 * LetExpCS
	 * 
	 * @param letExpCS the <code>LetExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>LetExpCS</code>
	 * @throws TerminateException 
	 */
	@SuppressWarnings("unchecked")
	protected LetExp<C, PM> letExpCS(
			LetExpCS letExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		
		return (LetExp<C, PM>) letExpCSRecursive(letExpCS, 0, env);
	}

	/**
	 * Constructs the LetExp
	 * 
	 * @param letExpCS the <code>LetExpCS</code> <code>CSTNode</code>
	 * @param index the index of the VariableDeclarationCS to parse
	 * @param env the OCL environment
	 * @return the parsed <code>OCLExpression</code>
	 * @throws TerminateException 
	 */
	protected OCLExpression<C>
	letExpCSRecursive(
			LetExpCS letExpCS,
			int index,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {

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
				ERROR(variableDeclaration, "letExpCS", message);//$NON-NLS-1$
				variableDeclaration.setType(getOclVoid());
			}
			
			if (variableDeclaration.getInitExpression() == null) {
				String message = OCLMessages.bind(
						OCLMessages.DeclarationNoInitExp_ERROR_,
						varName);
				ERROR(variableDeclaration, "letExpCS", message);//$NON-NLS-1$
			}
					
			OCLExpression<C> letSubExp = letExpCSRecursive(letExpCS, ++index, env);
			LetExp<C, PM> letExp = oclFactory.createLetExp(); 
			initASTMapping(env, letExp, letExpCS);
			letExp.setVariable(variableDeclaration);
			letExp.setIn(letSubExp);
			if (letSubExp != null) {
				letExp.setType(letSubExp.getType());
			} else {
				letExp.setType(getOclVoid());
			}
			
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
	 * @throws TerminateException 
	 */
	protected OCLExpression<C> simpleNameCS(
			SimpleNameCS simpleNameCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			OCLExpression<C> source) {

		if ((source != null) && isErrorNode(source)) {
			// don't attempt to parse navigation from an unparseable source
			return source; // return the same unparseable token
		}
		
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
			classifier = lookupClassifier(simpleNameCS, env, names);
		}
		
		if (classifier != null) {
			/* Variable is a classifier. Classifiers are used in
			 * allInstances, isKindOf, isTypeOf, asTypeOf operations
			 */
			
			TypeExp<C> texp = typeCS(simpleNameCS, env, classifier);
			astNode = texp;	 		
		} else if (source == null && (vdcl = env.lookup(simpleName)) != null)  { 
			// Either a use of a declared variable or self

			TRACE("variableExpCS", "Variable Expression: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$
			
			VariableExp<C, PM> vexp = oclFactory.createVariableExp();	
			initASTMapping(env, vexp, simpleNameCS);
			vexp.setReferredVariable(vdcl);
			
			vexp.setType(vdcl.getType());
			astNode = vexp;
		} else if ((property = lookupProperty(simpleNameCS, env, sourceElementType, simpleName)) != null) {
			
			TRACE("variableExpCS", "Property: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$
			propertyCall = oclFactory.createPropertyCallExp();
			initASTMapping(env, propertyCall, simpleNameCS);
			propertyCall.setReferredProperty(property);
			propertyCall.setType(
					TypeUtil.getPropertyType(env, sourceElementType, property));
			if (source != null) {
				propertyCall.setSource(source);
			} else {
				VariableExp<C, PM> src = oclFactory.createVariableExp();
				initASTMapping(env, src, simpleNameCS);
				Variable<C, PM> implicitSource =
					env.lookupImplicitSourceForProperty(simpleName);
				src.setType(implicitSource.getType());
				src.setReferredVariable(implicitSource);
				
				propertyCall.setSource(src);
			}

			initPropertyPositions(propertyCall, simpleNameCS);
			astNode = propertyCall;
						
		} else if ((assocClass = lookupAssociationClassReference(simpleNameCS, env, sourceElementType, simpleName)) != null) {
			TRACE("variableExpCS", "Association class: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$
			acref = oclFactory.createAssociationClassCallExp();
			initASTMapping(env, acref, simpleNameCS);
			acref.setReferredAssociationClass(assocClass);
			
			if (source != null) {
				acref.setSource(source);
			} else {
				VariableExp<C, PM> src = oclFactory.createVariableExp();
				initASTMapping(env, src, simpleNameCS);
				Variable<C, PM> implicitSource =
					env.lookupImplicitSourceForAssociationClass(simpleName);
				src.setType(implicitSource.getType());
				src.setReferredVariable(implicitSource);
				
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
					
					CollectionKind kind = getCollectionKind(getOCLType(env, end));
					if (kind != null) {
						acrefType = getCollectionType(env, kind, assocClass);
					} else {
						acrefType = assocClass;
					}
				}
			}
			
			if (acrefType == null) {
				// for non-navigable association classes, assume set type
				acrefType = getSetType(simpleNameCS, env, assocClass);
			}
			acref.setType(acrefType);

			initPropertyPositions(acref, simpleNameCS);
			astNode = acref;
		} else {
			if ((source != null) && (vdcl = env.lookup(simpleName)) != null) {
				String message = OCLMessages.bind(
						OCLMessages.VarInNavExp_ERROR_,
						simpleName);
					ERROR(simpleNameCS, "variableExpCS", message);//$NON-NLS-1$
			} else {
				String message = OCLMessages.bind(
						OCLMessages.UnrecognizedVar_ERROR_,
						simpleName);
					ERROR(simpleNameCS, "variableExpCS", message);//$NON-NLS-1$
			}
			
			astNode = createDummyInvalidLiteralExp();
		}
		
		/*
		 * If the source type is a collection, then need there is an implicit COLLECT operator.
		 * Note that this rule is not called after "->".  Check for FeatureCallExp
		 * in case we created a dummy InvalidLiteralExp.
		 */
		if ((source != null) && (source.getType() instanceof CollectionType)
			&& (astNode instanceof FeatureCallExp)) {
			astNode = createImplicitCollect(
				source,
				(FeatureCallExp<C>) astNode,
				env,
				simpleNameCS);
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
	 * @throws TerminateException 
	 */
	protected IteratorExp<C, PM> createImplicitCollect(OCLExpression<C> source,
			FeatureCallExp<C> propertyCall,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			CSTNode cstNode) {
		
		@SuppressWarnings("unchecked")
		C sourceElementType = ((CollectionType<C, O>) source.getType())
			.getElementType();
		
		IteratorExp<C, PM> result = oclFactory.createIteratorExp();
		initASTMapping(env, result, cstNode);		
		Variable<C, PM> itervar =
			genVariableDeclaration(cstNode, "modelPropertyCallCS", env,//$NON-NLS-1$
						null, sourceElementType, null, false, true, false);

		List<Variable<C, PM>> iters = result.getIterator();
		iters.add(itervar);
		result.setBody(propertyCall);
		result.setName("collect");//$NON-NLS-1$
		VariableExp<C, PM> vexp = oclFactory.createVariableExp();
		initASTMapping(env, vexp, cstNode);
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
		
		// the result of a collect() is flattened, so if the value
		//   that we are collecting is a Collection type, the resulting
		//   type must be flattened by taking its element type (recursively)
		C bodyType = propertyCall.getType();
		if (bodyType instanceof CollectionType) {
			@SuppressWarnings("unchecked")
			CollectionType<C, O> ct = (CollectionType<C, O>) bodyType;
			
			bodyType = CollectionUtil.getFlattenedElementType(ct);
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
	 */
	protected C primitiveTypeCS(SimpleTypeEnum simpleType,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		
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
	 */
	protected LiteralExp<C>  primitiveLiteralExpCS(
			PrimitiveLiteralExpCS primitiveLiteralExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {

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
	 */
	protected IntegerLiteralExp<C> integerLiteralExpCS(
			IntegerLiteralExpCS integerLiteralExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
	
		IntegerLiteralExp<C> astNode = oclFactory.createIntegerLiteralExp();
		initASTMapping(env, astNode, integerLiteralExpCS);
		astNode.setIntegerSymbol(integerLiteralExpCS.getIntegerSymbol());
		astNode.setType(env.getOCLStandardLibrary().getInteger());
		
		TRACE("integerLiteralExpCS", "Integer: " + integerLiteralExpCS.getSymbol());//$NON-NLS-2$//$NON-NLS-1$
			
		return astNode;
	}

    /**
     * UnlimitedNaturalLiteralExpCS
     * 
     * @param unlimitedNaturalLiteralExpCS the <code>UnlimitedNaturalLiteralExpCS</code> <code>CSTNode</code>
     * @param env the OCL environment
     * @return the parsed <code>UnlimitedNaturalLiteralExp</code>
     */
    protected UnlimitedNaturalLiteralExp<C> unlimitedNaturalLiteralExpCS(
            UnlimitedNaturalLiteralExpCS unlimitedNaturalLiteralExpCS,
            Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
    
        UnlimitedNaturalLiteralExp<C> astNode = oclFactory.createUnlimitedNaturalLiteralExp();
        initASTMapping(env, astNode, unlimitedNaturalLiteralExpCS);
        astNode.setIntegerSymbol(unlimitedNaturalLiteralExpCS.getIntegerSymbol());
        astNode.setType(env.getOCLStandardLibrary().getUnlimitedNatural());
        TRACE("unlimitedNaturalLiteralExpCS", "UnlimitedNatural: " + unlimitedNaturalLiteralExpCS.getSymbol());//$NON-NLS-2$//$NON-NLS-1$
            
        return astNode;
    }
		
	/**
	 * RealLiteralExpCS
	 * 
	 * @param realLiteralExpCS the <code>RealLiteralExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>RealLiteralExp</code>
	 */
	protected RealLiteralExp<C> realLiteralExpCS(
			RealLiteralExpCS realLiteralExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {

		RealLiteralExp<C> astNode = oclFactory.createRealLiteralExp();
		initASTMapping(env, astNode, realLiteralExpCS);
		astNode.setRealSymbol(realLiteralExpCS.getRealSymbol());
		astNode.setType(env.getOCLStandardLibrary().getReal());
		
		TRACE("realLiteralExpCS", "Real: " + realLiteralExpCS.getSymbol());//$NON-NLS-2$//$NON-NLS-1$
			
		return astNode;
	}
	
	/**
	 * StringLiteralExpCS
	 * 
	 * @param stringLiteralExpCS the <code>StringLiteralExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>StringLiteralExp</code>
	 */
	protected StringLiteralExp<C> stringLiteralExpCS(
			StringLiteralExpCS stringLiteralExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {

		StringLiteralExp<C> astNode = oclFactory.createStringLiteralExp();
		initASTMapping(env, astNode, stringLiteralExpCS);
		String stringLiteral = stringLiteralExpCS.getStringSymbol();
		if (stringLiteral.length() <= 2) {
			astNode.setStringSymbol("");//$NON-NLS-1$
		} else {
			astNode.setStringSymbol(processStringEscapes(
                stringLiteral.substring(1, stringLiteral.length()-1)));
		}
		astNode.setType(env.getOCLStandardLibrary().getString());
		
		TRACE("stringLiteralExpCS", "String: " + stringLiteralExpCS.getSymbol());//$NON-NLS-2$//$NON-NLS-1$
			
		return astNode;
	}
    
	/**
	 * Processes escape sequences in string literals.  Currently, only the
	 * non-standard " '' " escape for single-quotes is supported.
	 * 
	 * @param stringLiteral a string literal
	 * 
	 * @return the string, with any escape sequences converted
	 */
    private String processStringEscapes(String stringLiteral) {
        String result = stringLiteral;
        
        int length = stringLiteral.length();
        
        for (int i = 0; i < length; i++) {
            // optimize for the case that there is no escape:  don't create
            // any new string object or buffer unless we need one
            if (stringLiteral.charAt(i) == '\'') {  // known BMP code point
                StringBuilder buf = new StringBuilder(length);
                
                // found an escape.  Copy content up to this point
                buf.append(stringLiteral, 0, i);
                
                // continue processing to the end, appending to the buffer
                for (; i < length; i++) {
                    char c = stringLiteral.charAt(i);
                    
                    if (c != '\'') {  // known BMP code point
                        buf.append(c);
                    } else {
                        i++;  // next char
                        
                        if (i >= length) {
                            // trailing single-quote is not an escape (although,
                            // the lexer couldn't have parsed it, anyway)
                            buf.append('\'');
                        } else {
                            c = stringLiteral.charAt(i);
                            
                            switch (c) {
                                case '\'':  // known BMP code point
                                    // append the escaped single-quote
                                    buf.append('\'');
                                    break;
                                default:
                                    // parser shouldn't have produced this
                                    buf.append('\'');  // include the escape
                                    buf.append(c);
                                    break;
                            }
                        }
                    }
                }
                
                result = buf.toString();  // convert the buffer
            }
        }
		
		if (!result.equals(stringLiteral)) {
			// check settings for using non-standard closure iterator
            ProblemHandler.Severity sev = getEnvironment().getValue(
                ProblemOption.STRING_SINGLE_QUOTE_ESCAPE);
			if ((sev != null) && (sev != ProblemHandler.Severity.OK)) {
                getEnvironment().problem(sev, ProblemHandler.Phase.ANALYZER,
                    OCLMessages.bind(OCLMessages.NonStd_SQuote_Escape_, stringLiteral),
                    "stringLiteralExpCS", //$NON-NLS-1$
                    null);
            }
		}
        
        return result;
    }
	
	/**
	 * BooleanLiteralExpCS
	 * 
	 * @param booleanLiteralExpCS the <code>BooleanLiteralExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>BooleanLiteralExp</code>
	 */
	protected BooleanLiteralExp<C> booleanLiteralExpCS(
			BooleanLiteralExpCS booleanLiteralExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		
		BooleanLiteralExp<C> astNode = oclFactory.createBooleanLiteralExp(); 
		initASTMapping(env, astNode, booleanLiteralExpCS);
		astNode.setBooleanSymbol(booleanLiteralExpCS.getBooleanSymbol());
		astNode.setType(env.getOCLStandardLibrary().getBoolean());
		TRACE("booleanLiteralExpCS", "Boolean: " + booleanLiteralExpCS.getSymbol());//$NON-NLS-2$//$NON-NLS-1$
			
		return astNode;
	}
	
	/**
	 * NullLiteralExpCS
	 * 
	 * @param nullLiteralExpCS the <code>NullLiteralExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>NullLiteralExp</code>
	 */
	protected NullLiteralExp<C> nullLiteralExpCS(
			NullLiteralExpCS nullLiteralExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		
		NullLiteralExp<C> astNode = oclFactory.createNullLiteralExp(); 
		initASTMapping(env, astNode, nullLiteralExpCS);
		astNode.setType(env.getOCLStandardLibrary().getOclVoid());
		
		TRACE("nullLiteralExpCS", "OclVoid: null");//$NON-NLS-2$//$NON-NLS-1$
			
		return astNode;
	}
	
	/**
	 * InvalidLiteralExpCS
	 * 
	 * @param invalidLiteralExpCS the <code>InvalidLiteralExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>InvalidLiteralExp</code>
	 */
	protected InvalidLiteralExp<C> invalidLiteralExpCS(
			InvalidLiteralExpCS invalidLiteralExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		
		InvalidLiteralExp<C> astNode = oclFactory.createInvalidLiteralExp(); 
		initASTMapping(env, astNode, invalidLiteralExpCS);
		astNode.setType(env.getOCLStandardLibrary().getInvalid());
		
		TRACE("invalidLiteralExpCS", "Invalid: OclInvalid");//$NON-NLS-2$//$NON-NLS-1$
			
		return astNode;
	}
	
	/**
	 * LiteralExpCS
	 * 
	 * @param literalExpCS the <code>LiteralExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>LiteralExp</code>
	 * @throws TerminateException 
	 */
	protected OCLExpression<C> literalExpCS(
			LiteralExpCS literalExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {

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
	 * @throws TerminateException 
	 */
	protected TupleLiteralExp<C, P> tupleLiteralExpCS(
			TupleLiteralExpCS tupleLiteralExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		
		TupleLiteralExp<C, P> astNode;
			
		HashSet<String> names = new HashSet<String>();
		String nodeName = null;
		String name;

		astNode = oclFactory.createTupleLiteralExp();
		initASTMapping(env, astNode, tupleLiteralExpCS);
		EList<TupleLiteralPart<C, P>> tupleParts = astNode.getPart();
		TRACE("tupleLiteralExpCS", "Tuple");//$NON-NLS-2$//$NON-NLS-1$

		EList<VariableCS> tupleLiteralPartListCS =
			tupleLiteralExpCS.getVariables();
		EList<TupleLiteralPart<C, P>> tupleLiteralParts =
			tupleLiteralPartListCS(tupleLiteralPartListCS, env);
		for (TupleLiteralPart<C, P> part : tupleLiteralParts) {
			tupleParts.add(part);
			name = part.getName();
			TRACE("tupleLiteralExpCS", " name = " + name);//$NON-NLS-2$//$NON-NLS-1$

			if (names.contains(name)) {
				String message = OCLMessages.bind(
						OCLMessages.DuplicateNameInTuple_ERROR_,
						name);
				ERROR(part, "tupleLiteralPartCS", message);//$NON-NLS-1$
				part.setName(null);
			} else {
				names.add(name);
			}
			
			if (part.getValue() == null) {
				String message = OCLMessages.bind(
					OCLMessages.MissingTypeInTupleLiteralPart_ERROR_,
					name, computeInputString(tupleLiteralExpCS));
				ERROR(tupleLiteralExpCS, "tupleLiteralExpCS", message);//$NON-NLS-1$
			}

			if (part.getType() == null) {
				if (part.getValue() != null) {
					// type is implied from init expression
					part.setType(part.getValue().getType());
				} else {
					part.setType(getOclVoid());
				}
			}

			if (nodeName == null) {
				nodeName = "Tuple{"; //$NON-NLS-1$
			} else {
				nodeName += ", "; //$NON-NLS-1$
			}

			nodeName += part.getName() + ":" + uml.getName(part.getType()); //$NON-NLS-1$
		}

		C tt = getTupleType(tupleLiteralExpCS, env, tupleParts);
		
		astNode.setType(tt);
		
		for (TupleLiteralPart<C, P> part : tupleParts) {
		    // don't need to worry about ambiguity in the tuple type definition
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
	 * @throws TerminateException 
	 */
	protected EList<TupleLiteralPart<C, P>> tupleLiteralPartListCS(
		List<VariableCS> variableDeclarations,
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		
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
	 * @throws TerminateException 
	 */
	protected TupleLiteralPart<C, P> tupleLiteralPartCS(
			VariableCS variableDeclarationCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		
		String varName = variableDeclarationCS.getName();
		C type = null;
		if (variableDeclarationCS.getTypeCS() != null) {
            type = typeCS(variableDeclarationCS.getTypeCS(), env);
        }

	  	OCLExpression<C> expr = null;
	  	if (variableDeclarationCS.getInitExpression() != null) {
            expr = oclExpressionCS(variableDeclarationCS.getInitExpression(), env);
        }
	
		TupleLiteralPart<C, P> astNode = oclFactory.createTupleLiteralPart();
		initASTMapping(env, astNode, variableDeclarationCS);
		astNode.setName(varName);
		astNode.setType(type);
		astNode.setValue(expr);

		initStartEndPositions(astNode, variableDeclarationCS);

		if (variableDeclarationCS.getTypeCS() != null) {
			initTypePositions(astNode, variableDeclarationCS.getTypeCS());
		}
		
		if ((expr != null) && isErrorNode(expr)) {
			// propagate error stigma to the tuple literal
			markAsErrorNode(astNode);
		}

		return astNode;
	}

	/**
	 * EnumLiteralExpCS
	 * 
	 * @param enumLiteralExpCS the <code>EnumLiteralExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>EnumLiteralExp</code>
	 * @throws TerminateException 
	 */
	protected OCLExpression<C> enumLiteralExpCS(
			EnumLiteralExpCS enumLiteralExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {

		OCLExpression<C> astNode = null;

		EList<String> sequenceOfNames = new BasicEList<String>(
                enumLiteralExpCS.getPathNameCS().getSequenceOfNames());
		String lastToken = enumLiteralExpCS.getSimpleNameCS().getValue();

		EL literal = null;
        P attribute = null;
		C enumType = lookupClassifier(enumLiteralExpCS, env, sequenceOfNames);
		if (enumType == null) {
			
			// Check to see whether the pathname corresponds to a type
			sequenceOfNames.add(lastToken);
			C type = lookupClassifier(enumLiteralExpCS, env, sequenceOfNames);
			if (type == null) {
				String message = OCLMessages.bind(
						OCLMessages.UnrecognizedType_ERROR_,
						sequenceOfNames);
				ERROR(enumLiteralExpCS, "enumerationOrClassLiteralExpCS", message);//$NON-NLS-1$
			} else {
                astNode = typeCS(enumLiteralExpCS, env, type);
			}
		} else {
            if (uml.isEnumeration(enumType)) {
                // look first for an enumeration literal with this name, rather
                //    than a static attribute
                literal = uml.getEnumerationLiteral(enumType, lastToken);
                if ((literal == null) && isEscaped(lastToken)) {
                    literal = uml.getEnumerationLiteral(enumType,
                        unescape(lastToken));
                }
                if (literal == null) {
                    // try looking for a static attribute
                    attribute = lookupProperty(enumLiteralExpCS, env, enumType, lastToken);
                }
            } else {
                // look for a static attribute
                attribute = lookupProperty(enumLiteralExpCS, env, enumType, lastToken);
            }
            
            if (literal != null) {
    			astNode = oclFactory.createEnumLiteralExp();
    			initASTMapping(env, astNode, enumLiteralExpCS);
    			
    			@SuppressWarnings("unchecked")
    			EnumLiteralExp<C, EL> litExp = (EnumLiteralExp<C, EL>) astNode;
    			litExp.setReferredEnumLiteral(literal);
    			astNode = litExp;
    			astNode.setType(enumType);
            } else if (attribute != null) {
                if (!uml.isStatic(attribute)) {
                    String message = OCLMessages.bind(
                        OCLMessages.NonStaticAttribute_ERROR_,
                        lastToken);
                    ERROR(attribute, "enumerationOrClassLiteralExpCS", message);//$NON-NLS-1$
                }
                
                PropertyCallExp<C, P> pcExp = oclFactory.createPropertyCallExp();
        		initASTMapping(env, pcExp, enumLiteralExpCS);
                astNode = pcExp;
                
                TypeExp<C> typeExp = typeCS(enumLiteralExpCS, env, enumType);
                initStartEndPositions(typeExp, enumLiteralExpCS.getPathNameCS());
                
                pcExp.setSource(typeExp);
                pcExp.setReferredProperty(attribute);
                pcExp.setType(TypeUtil.getPropertyType(env, enumType, attribute));
                
                initPropertyPositions(pcExp, enumLiteralExpCS.getSimpleNameCS());
            } else {
                // try looking for a nested classifier
                sequenceOfNames.add(lastToken);
                
                C type = lookupClassifier(enumLiteralExpCS, env, sequenceOfNames);
                if (type == null) {
                    String message = OCLMessages.bind(
                        OCLMessages.UnrecognizedEnum_ERROR_,
                        lastToken);
                    ERROR(enumLiteralExpCS, "enumerationOrClassLiteralExpCS", message);//$NON-NLS-1$
                } else {
                    astNode = typeCS(enumLiteralExpCS, env, type);
                }
            }
		}
		
		if (astNode == null) {
			astNode = createDummyInvalidLiteralExp();
		}
		
		String traceText = new String();
		for (String next : sequenceOfNames) {
			traceText += next + "::"; //$NON-NLS-1$
		}
		traceText += lastToken;
		TRACE("enumerationOrClassLiteralExpCS", traceText); //$NON-NLS-1$
			
		return astNode;
	}
    
	protected TypeExp<C> typeCS(CSTNode cstNode,
        Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
        C type) {
        
        TypeExp<C> astNode = oclFactory.createTypeExp();
		initASTMapping(env, astNode, cstNode);
        astNode.setReferredType(type);
        astNode.setType(getTypeType(cstNode, env, type));
        
        return astNode;
    }

	/**
	 * CollectionLiteralExpCS
	 * 
	 * @param collectionLiteralExpCS the <code>CollectionLiteralExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment
	 * @return the parsed <code>CollectionLiteralExp</code>
	 * @throws TerminateException 
	 */
	protected CollectionLiteralExp<C> collectionLiteralExpCS(
			CollectionLiteralExpCS collectionLiteralExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {

		CollectionLiteralExp<C> astNode;

		astNode = null;
		CollectionKind kind = null;
		CollectionLiteralPart<C> collectionLiteralPartExp = null;
		List<CollectionLiteralPart<C>> collectionParts = null;
		C type = null;
		C resultType = null;
		
		kind = collectionTypeIdentifierCS(collectionLiteralExpCS.getCollectionType());
		
		astNode = oclFactory.createCollectionLiteralExp();
		initASTMapping(env, astNode, collectionLiteralExpCS);
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
			
			if (isErrorNode(collectionLiteralPartExp)) {
				// propagate error stigma to the collection literal
				markAsErrorNode(astNode);
			}
	
			while (i.hasNext()) {
					collectionLiteralPartExp = collectionLiteralPartCS(
						i.next(), env);
					
					C type1 = collectionLiteralPartExp.getType();					
					type = getCommonSuperType(colPart, "collectionLiteralExpCS", env, type, type1); //$NON-NLS-1$
					collectionParts.add(collectionLiteralPartExp);
					
					if (isErrorNode(collectionLiteralPartExp)) {
						// propagate error stigma to the collection literal
						markAsErrorNode(astNode);
					}
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
	 * @throws TerminateException 
	 */
	protected CollectionLiteralPart<C> collectionLiteralPartCS(
			CollectionLiteralPartCS collectionLiteralPartCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {

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
			
			collRange = oclFactory.createCollectionRange();
			
			initASTMapping(env, collRange, collectionLiteralPartCS);
			collRange.setFirst(expr1);
			collRange.setLast(expr2);
			collRange.setType(expr1.getType());
			
			if (expr1.getType() != expr2.getType()) {
				ERROR(collectionLiteralPartCS, "collectionLiteralPartCS", //$NON-NLS-1$
					OCLMessages.bind(
							OCLMessages.FirstLastTypeMismatch_ERROR_,
							computeInputString(collectionLiteralPartCS)));
			}
			astNode = collRange;
			
			if (isErrorNode(expr1) || isErrorNode(expr2)) {
				// propagate error stigma to the collection literal part
				markAsErrorNode(astNode);
			}
			
			TRACE("collectionLiteralPartCS", "collection range");//$NON-NLS-2$//$NON-NLS-1$
		} else {
			collItem = oclFactory.createCollectionItem();
			
			initASTMapping(env, collItem, collectionLiteralPartCS);
			collItem.setType(expr1.getType());
			collItem.setItem(expr1);
			astNode = collItem;
			
			if (isErrorNode(expr1)) {
				// propagate error stigma to the collection literal part
				markAsErrorNode(astNode);
			}
			
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
	 * @throws TerminateException 
	 */
	protected OCLExpression<C> propertyCallExpCS(
			CallExpCS propertyCallExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		
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
	 * @throws TerminateException 
	 */
	protected LoopExp<C, PM> loopExpCS(
			LoopExpCS loopExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		
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
	 * @throws TerminateException 
	 */
	protected OCLExpression<C> getCollectionSourceExpression(
			OCLExpressionCS oclExpressionCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
	
		OCLExpression<C> astNode = oclExpressionCS(oclExpressionCS, env);
		if (astNode == null) {
			astNode = createDummyInvalidLiteralExp();
		}
		
		/* The source must be a collection type.
   	  	 */
		if (!(astNode.getType() instanceof CollectionType)) {
			CollectionLiteralExp<C> astNode1 = oclFactory.createCollectionLiteralExp();
			initASTMapping(env, astNode1, oclExpressionCS);
			astNode1.setKind(CollectionKind.SET_LITERAL);
			List<CollectionLiteralPart<C>> collectionParts = astNode1.getPart();
			CollectionItem<C> collItem = oclFactory.createCollectionItem();
			initASTMapping(env, collItem, oclExpressionCS);
			collItem.setType(astNode.getType());
			collItem.setItem(astNode);				
			collectionParts.add(collItem);
			
			C type = getCollectionType(env, astNode1.getKind(), astNode.getType());
			
			astNode1.setType(type);
			
			if (isErrorNode(astNode)) {
				// propagate error mark to the collection literal
				markAsErrorNode(astNode1);
			}
			
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
	 * @throws TerminateException 
	 */
	protected IteratorExp<C, PM> iteratorExpCS(
			IteratorExpCS iteratorExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		
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
				
			astNode = oclFactory.createIteratorExp();
			initASTMapping(env, astNode, iteratorExpCS);
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

			astNode = oclFactory.createIteratorExp();
			initASTMapping(env, astNode, iteratorExpCS);
			astNode.setName(name);
			iterators = astNode.getIterator();	
			// Synthesize the iterator expression.
			@SuppressWarnings("unchecked")
			CollectionType<C, O> ct = (CollectionType<C, O>) source.getType();
			vdcl = genVariableDeclaration(iteratorExpCS, "iteratorExpCS", env, null, //$NON-NLS-1$
				ct.getElementType(),
				null, false, true, false);
			iterators.add(vdcl);
		}
		
		OCLExpressionCS exprCS = iteratorExpCS.getBody();

		if ((source != null) && isErrorNode(source)) {
			// don't attempt to parse iterator body for an unparseable source
			expr = createDummyInvalidLiteralExp();
			// don't parse call expressions sourced on this result
			markAsErrorNode(astNode);
		} else {
			expr = oclExpressionCS(exprCS, env);
		}
	
		TRACE("oclIteratorExpCS: ", name);//$NON-NLS-1$
		
		if (name.equals("forAll") || name.equals("exists") || name.equals("one") || name.equals("isUnique")) {//$NON-NLS-4$//$NON-NLS-3$//$NON-NLS-2$//$NON-NLS-1$
			astNode.setType(env.getOCLStandardLibrary().getBoolean());
		} else if (name.equals("select") || name.equals("reject") ) {//$NON-NLS-2$//$NON-NLS-1$
			astNode.setType(source.getType());
		} else if (name.equals("collect")) {//$NON-NLS-1$
			// The result type for collect must be flattened
			C elementType = expr.getType();
			if (elementType instanceof CollectionType) {
				@SuppressWarnings("unchecked")
				CollectionType<C, O> ct = (CollectionType<C, O>) elementType;
				elementType = CollectionUtil.getFlattenedElementType(ct);
			}
			if (source.getType() instanceof SequenceType || 
							source.getType() instanceof OrderedSetType) {
				astNode.setType(getSequenceType(exprCS, env, elementType));
			} else {
				astNode.setType(getBagType(exprCS, env, elementType));
			}
		} else if (name.equals("collectNested")) {//$NON-NLS-1$
			if (source.getType() instanceof SequenceType || 
							source.getType() instanceof OrderedSetType) {
				astNode.setType(getSequenceType(exprCS, env, expr.getType()));
			} else {
				astNode.setType(getBagType(exprCS, env, expr.getType()));
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
				
				astNode.setType(getSequenceType(exprCS, env, ct.getElementType()));
			} else { // set, ordered set
				@SuppressWarnings("unchecked")
				CollectionType<C, O> ct = (CollectionType<C, O>) source.getType();
				
				astNode.setType(getOrderedSetType(exprCS, env, ct.getElementType()));
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
			
			astNode.setType(getSetType(exprCS, env, bodyType));
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
	 * @throws TerminateException 
	 */
	protected IterateExp<C, PM> iterateExpCS(
			IterateExpCS iterateExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
	
		IterateExp<C, PM> astNode = null;

		OCLExpression<C> source =
			getCollectionSourceExpression(iterateExpCS.getSource(), env);
		if (source == null) {
            return null;
        }
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
			
			vdcl = genVariableDeclaration(iterateExpCS, "iterateExpCS", env, null, //$NON-NLS-1$
					ct.getElementType(),
					null, false, true, false);	
		} 
		
		if (vdcl.getType() == null) {
			@SuppressWarnings("unchecked")
			CollectionType<C, O> ct = (CollectionType<C, O>) source.getType();
			
			vdcl.setType(ct.getElementType());
		}
	
		TRACE("iterateExpCS", "iterate");//$NON-NLS-2$//$NON-NLS-1$
		astNode = oclFactory.createIterateExp();
		initASTMapping(env, astNode, iterateExpCS);
		astNode.setName("iterate");			//$NON-NLS-1$

		if ((source != null) && isErrorNode(source)) {
			// don't attempt to parse iterate body for an unparseable source
			expr = createDummyInvalidLiteralExp();
			// don't parse call expressions sourced on this result
			markAsErrorNode(astNode);
		} else {
			expr = oclExpressionCS(iterateExpCS.getBody(), env);
		}
		
		List<Variable<C, PM>> iterator = astNode.getIterator();
		iterator.add(vdcl);
		astNode.setSource(source);
		astNode.setResult(vdcl1);
		astNode.setBody(expr);
		
		if (vdcl1.getType() == null) {
			String message = OCLMessages.bind(
					OCLMessages.DeclarationType_ERROR_,
					vdcl1.getName());
			ERROR(vdcl, "iterateExpCS", message);//$NON-NLS-1$
			vdcl1.setType(getOclVoid());
		}
		
		astNode.setType(vdcl1.getType());
		
		if (vdcl1.getInitExpression() == null) {
			String message = OCLMessages.bind(
					OCLMessages.DeclarationNoInitExp_ERROR_,
					vdcl1.getName());
			ERROR(vdcl1, "iterateExpCS", message);//$NON-NLS-1$
		}
		
		if (vdcl.getInitExpression() != null) {
			String message = OCLMessages.bind(
					OCLMessages.DeclarationInitExp_ERROR_,
					vdcl1.getName());
			ERROR(vdcl, "iterateExpCS", message);//$NON-NLS-1$
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
	 * @throws TerminateException 
	 */
	protected OCLExpression<C> modelPropertyCallExpCS(
			FeatureCallExpCS modelPropertyCallExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		
		OCLExpression<C> astNode = null;
		
		if (modelPropertyCallExpCS instanceof OperationCallExpCS) {
			astNode = operationCallExpCS((OperationCallExpCS)modelPropertyCallExpCS, env);
		} else {
			OCLExpression<C> source =
				oclExpressionCS(modelPropertyCallExpCS.getSource(), env);
			astNode = simpleNameCS(modelPropertyCallExpCS.getSimpleNameCS(), env, source);

			List<OCLExpression<C>> qualifiers = qualifiersCS(modelPropertyCallExpCS.getArguments(), env, astNode);

			if (modelPropertyCallExpCS.getIsMarkedPreCS().isPre()) {
				if (astNode instanceof FeatureCallExp) {
					((FeatureCallExp<C>) astNode).setMarkedPre(true);
				} else {
					ERROR(astNode, "modelPropertyCallExpCS", OCLMessages.IllegalAtPre_ERROR_);//$NON-NLS-1$
				}
			}

			if (!qualifiers.isEmpty()) {
				if (astNode instanceof NavigationCallExp) {
	                @SuppressWarnings("unchecked")
	                NavigationCallExp<C, P> callNode = (NavigationCallExp<C, P>) astNode;
					setQualifiers(env, "modelPropertyCallExpCS",//$NON-NLS-1$
						callNode, qualifiers);
				} else if ((astNode instanceof LoopExp)
						&& (getLoopBody(astNode) instanceof NavigationCallExp)) {
					// might have parsed an implicit collect expression
					
					@SuppressWarnings("unchecked")
					NavigationCallExp<C, P> nav =
						(NavigationCallExp<C, P>) getLoopBody(astNode);
					
					setQualifiers(env, "modelPropertyCallExpCS",//$NON-NLS-1$
						nav, qualifiers);
				} else {
					ERROR(modelPropertyCallExpCS, "modelPropertyCallExpCS", //$NON-NLS-1$
							OCLMessages.bind(
									OCLMessages.IllegalQualifiers_ERROR_,
									computeInputString(modelPropertyCallExpCS)));
				}
			} else if (astNode instanceof AssociationClassCallExp) {
	            @SuppressWarnings("unchecked")
	            AssociationClassCallExp<C, P> callNode = (AssociationClassCallExp<C, P>) astNode;
				checkNotReflexive(env, "modelPropertyCallExpCS", callNode);//$NON-NLS-1$
			}
		}

		return astNode;
	}
	
	@SuppressWarnings("unchecked")
	protected OCLExpression<C> getLoopBody(OCLExpression<C> expr) {
		return ((LoopExp<C, ?>) expr).getBody();
	}

	/**
	 * OperationCallExpCS
	 * 
	 * @param operationCallExpCS the <code>OperationCallExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment 
	 * @return the parsed <code>OCLExpression</code>
	 * @throws TerminateException 
	 */
	protected OCLExpression<C> operationCallExpCS(
			OperationCallExpCS operationCallExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		
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
                
                C sourceType = lookupClassifier(sourceCS, env, pathName.getSequenceOfNames());
                if (sourceType == null) {
                    String message = OCLMessages.bind(
                            OCLMessages.UnrecognizedType_ERROR_,
                            pathName.getSequenceOfNames());
                    ERROR(sourceCS, "operatonCallExpCS", message);//$NON-NLS-1$
                } else {
                    source = typeCS(sourceCS, env, sourceType);
                }
            } else {
                source = oclExpressionCS(operationCallExpCS.getSource(), env);
            }
		}
		
		String operationName = operationCallExpCS.getSimpleNameCS().getValue();

		if (PredefinedType.OCL_IS_IN_STATE_NAME.equals(operationName)) {
			if (operationCallExpCS.getArguments().size() != 1) {
				String message = OCLMessages.bind(
								OCLMessages.IsInStateSignature_ERROR_,
								computeInputString(operationCallExpCS));
				ERROR(operationCallExpCS, "operationCallExpCS", message);//$NON-NLS-1$
			}
			
			if (!operationCallExpCS.getArguments().isEmpty()) {
				OCLExpressionCS arg = operationCallExpCS.getArguments().get(0);
				
				if (arg instanceof StateExpCS) {
					args.add(stateExpCS(source, (StateExpCS) arg, env));
				} else {
					String message = OCLMessages.bind(
									OCLMessages.IsInStateSignature_ERROR_,
									computeInputString(operationCallExpCS));
					ERROR(arg, "operationCallExpCS", message);//$NON-NLS-1$
				}
			}
		} else {
			for (OCLExpressionCS arg : operationCallExpCS.getArguments()) {
				OCLExpression<C> argExpr = oclExpressionCS(arg, env);
				if (argExpr == null) {
					argExpr = createDummyInvalidLiteralExp();
					initASTMapping(env, argExpr, arg);
				}
				args.add(argExpr);
			}
		}
		
		if (source == null) {  // create an implicit source
			VariableExp<C, PM> vexp = oclFactory.createVariableExp();
			initASTMapping(env, vexp, operationCallExpCS);
			Variable<C, PM> implicitSource = lookupImplicitSourceForOperation(
					operationCallExpCS, env, args, operationName);
			
			if (implicitSource == null) {
				String errMessage = name + "(";//$NON-NLS-1$
				for (int i = 0; i < args.size(); i++) {
					if (i > 0) {
                        errMessage += ", ";//$NON-NLS-1$
                    }
					errMessage += uml.getName(args.get(i).getType());
				}
				errMessage += ")";//$NON-NLS-1$
				String message = OCLMessages.bind(
						OCLMessages.IllegalSignature_ERROR_,
						errMessage);
				ERROR(operationCallExpCS, "operationCallExpCS", message); //$NON-NLS-1$
			}
			
			if (implicitSource != null) {
				vexp.setType(implicitSource.getType());
				vexp.setReferredVariable(implicitSource);
			} else {
				vexp.setType(getOclVoid());
			}
			
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
        
		astNode = genOperationCallExp(env, operationCallExpCS, "operationCallExpCS", operationName,//$NON-NLS-1$
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
                ERROR(astNode, "operationCallExpCS", message);//$NON-NLS-1$
            }
        }
        
		astNode.setMarkedPre(operationCallExpCS.getIsMarkedPreCS().isPre());

		initPropertyPositions(astNode, operationCallExpCS.getSimpleNameCS());

		OCLExpression<C> result = astNode;
		
		if (isImplicitCollect) {
			result = createImplicitCollect(source, astNode, env, operationCallExpCS);			
	   	}

		if ((source != null) && isErrorNode(source)) {
			// don't attempt to parse navigation from an unparseable source
			markAsErrorNode(result);
		}
			
		return result;
	}
	
	/**
	 * MessageExpCS
	 * 
	 * @param messageExpCS the <code>MessageExpCS</code> <code>CSTNode</code>
	 * @param env the OCL environment 
	 * @return the parsed <code>OCLExpression</code>
	 * @throws TerminateException 
	 */
	protected OCLExpression<C> messageExpCS(
			MessageExpCS messageExpCS,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
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
					arg = oclFactory.createUnspecifiedValueExp();
					initASTMapping(env, arg, argCS);
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
		
		O calledOperation = lookupOperation(messageExpCS, env, target.getType(), name, arguments);
		C receivedSignal = lookupSignal(messageExpCS, env, target.getType(), name, arguments);
		
		if ((calledOperation == null) && (receivedSignal == null)) {
			ERROR(messageExpCS, "messageExpCS", OCLMessages.bind(OCLMessages.UnrecognizedMessageType_ERROR_, name)); //$NON-NLS-1$
		} else if ((calledOperation != null) && (receivedSignal != null)) {
			ERROR(messageExpCS, "messageExpCS", OCLMessages.bind(OCLMessages.AmbiguousMessageType_ERROR_, name)); //$NON-NLS-1$
		}
		
		result = oclFactory.createMessageExp();
		initASTMapping(env, result, messageExpCS);
		initStartEndPositions(result, messageExpCS);
		initPropertyPositions(result, messageExpCS.getSimpleNameCS());
		result.setTarget(target);
		result.getArgument().addAll(arguments);
		
		EObject behavioralFeature = null;
		if (calledOperation != null) {
			COA callAction = uml.createCallOperationAction(calledOperation);
			initASTMapping(env, callAction, messageExpCS.getSimpleNameCS());
			result.setCalledOperation(callAction);
			behavioralFeature = (EObject) calledOperation;
		} else if (receivedSignal != null) {
			SSA sendAction = uml.createSendSignalAction(receivedSignal);
			initASTMapping(env, sendAction, messageExpCS.getSimpleNameCS());
			result.setSentSignal(sendAction);
			behavioralFeature = (EObject) receivedSignal;
		}
		
		if (messageExpCS.getKind() == MessageExpKind.HAS_SENT_LITERAL) {
			result.setType(env.getOCLStandardLibrary().getBoolean());
		} else if ((behavioralFeature != null) && uml.isOperation(behavioralFeature)) {
			result.setType(
					getSequenceType(messageExpCS, env,
							getOperationMessageType(messageExpCS, env, calledOperation)));
		} else if (receivedSignal != null){
			result.setType(
					getSequenceType(messageExpCS, env,
							getSignalMessageType(messageExpCS, env, receivedSignal)));
		} else {
			result.setType(getOclVoid());
		}
		
		return result;
	}

	protected C getCommonSuperType(CSTNode cstNode, String rule,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C type1, C type2) {
		
		C commonType = TypeUtil.commonSuperType(cstNode, env, type1, type2);
		
		if (commonType == null) {
			commonType = env.getOCLStandardLibrary().getOclVoid();
		}
		
		return commonType;
	}
	
	protected C getOCLType(
	        Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
            Object metaElement) {
	    return TypeUtil.resolveType(env, uml.getOCLType(metaElement));
	}
	
	protected C getSetType(CSTNode cstNode,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C elementType) {
		
		return TypeUtil.resolveSetType(env, elementType);
	}
	
	protected C getOrderedSetType(CSTNode cstNode,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C elementType) {
		
		return TypeUtil.resolveOrderedSetType(env, elementType);
	}
	
	protected C getBagType(CSTNode cstNode,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C elementType) {
		
		return TypeUtil.resolveBagType(env, elementType);
	}
	
	protected C getSequenceType(CSTNode cstNode,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C elementType) {
		
		return TypeUtil.resolveSequenceType(env, elementType);
	}
	
	protected C getCollectionType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			CollectionKind kind, C elementType) {
		
		return TypeUtil.resolveCollectionType(env, kind, elementType);
	}
	
	protected C getTupleType(CSTNode cstNode,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			EList<? extends TypedElement<C>> parts) {
		return TypeUtil.resolveTupleType(env, parts);
	}
	
	protected C getTypeType(CSTNode cstNode,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C type) {
		return TypeUtil.resolveTypeType(env, type);
	}
	
	protected C getOperationMessageType(CSTNode cstNode,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			O operation) {
		return TypeUtil.resolveOperationMessageType(env, operation);
	}
	
	protected C getSignalMessageType(CSTNode cstNode,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C signal) {
		return TypeUtil.resolveSignalMessageType(env, signal);
	}
	
	@SuppressWarnings("unchecked")
	protected C getElementType(C possibleCollectionType) {
		if (possibleCollectionType instanceof CollectionType) {
			return ((CollectionType<C, O>) possibleCollectionType).getElementType();
		}
		
		return possibleCollectionType;
	}
	
	@SuppressWarnings("unchecked")
	protected CollectionKind getCollectionKind(C possibleCollectionType) {
		if (possibleCollectionType instanceof CollectionType) {
			return ((CollectionType<C, O>) possibleCollectionType).getKind();
		}
		
		return null;
	}
	
	/**
	 * Creates a dummy expression of invalid-literal type to be a placeholder
	 * for a (sub)expression that could not be parsed.  The resulting
	 * expression is {@linkplain #markAsErrorNode(OCLExpression) marked}
	 * as an error place-holder expression.
	 * 
	 * @return the dummy invalid-literal expression
	 * 
	 * @see #markAsErrorNode(OCLExpression)
	 */
	protected InvalidLiteralExp<C> createDummyInvalidLiteralExp() {
		InvalidLiteralExp<C> result = oclFactory.createInvalidLiteralExp();
		result.setType(getStandardLibrary().getInvalid());
		
		markAsErrorNode(result);
		
		return result;
	}
	
	/**
	 * <p>
	 * Queries whether the specified expression is a placeholder that was
	 * created for an expression that failed to parse. An example is the
	 * expression returned by {@link #createDummyInvalidLiteralExp()}.
	 * </p><p>
	 * The default implementation simply returns <code>false</code>;
	 * subclasses should override if necessary, in conjunction with the
	 * {@link #markAsErrorNode(TypedElement)} method.
	 * </p>
	 * 
	 * @param expr
	 *            a (sub)expression
	 * @return whether the <tt>expr</tt> is a placeholder for an unparseable
	 *         (sub)expression
	 * 
	 * @see #markAsErrorNode(TypedElement)
	 * 
	 * @since 1.2
	 */
	protected boolean isErrorNode(TypedElement<C> expr) {
		return false;
	}
	
	/**
	 * <p>
	 * Marks the specified (sub)expression as a placeholder for an expression
	 * that could not be parsed. A subsequent invocation of the
	 * {@link #isErrorNode(TypedElement)} method should recognize an
	 * expression thus marked.  Subsequent attempts to mark an expression
	 * that is already marked have no effect.
	 * </p><p>
	 * The default implementation does nothing; subclasses should override
	 * if necessary, in conjunction with the <tt>isErrorPlaceholder</tt>
	 * method.
	 * </p>
	 * 
	 * @param expr
	 *            an expression that takes the place of a (sub)expression that
	 *            could not be parsed
	 * 
	 * @see #isErrorNode(TypedElement)
	 * 
	 * @since 1.2
	 */
	protected void markAsErrorNode(TypedElement<C> expr) {
		// implemented by subclasses
	}

	protected Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	createPackageContext( 
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parent,
			List<String> packageName) throws LookupException {
		@SuppressWarnings("unchecked")
		EnvironmentFactory.Lookup<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> lookup =
			OCLUtil.getAdapter(environmentFactory, EnvironmentFactory.Lookup.class);
		return lookup.tryCreatePackageContext(parent, packageName);
	}

    @SuppressWarnings("unchecked")
	protected C lookupClassifier(CSTNode cstNode, 
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			List<String> className) {
		try {
			Environment.Lookup<PK, C, O, P> lookup = OCLUtil.getAdapter(env,
			    Environment.Lookup.class);
			return lookup.tryLookupClassifier(className);
		} catch (LookupException e) {
			ERROR(cstNode, null, e.getMessage());
			return e.getAmbiguousMatches().isEmpty() ? env
                .getOCLStandardLibrary().getOclVoid()
                : (C) e.getAmbiguousMatches().get(0);
		}
	}

	protected Variable<C, PM> lookupImplicitSourceForOperation(CSTNode cstNode,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			List<OCLExpression<C>> args, String operationName) {
		return env.lookupImplicitSourceForOperation(operationName, args);
	}

    @SuppressWarnings("unchecked")
	protected O lookupOperation(CSTNode cstNode, 
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C owner, String name, List<? extends TypedElement<C>> args) {
        try {
            Environment.Lookup<PK, C, O, P> lookup = OCLUtil.getAdapter(env,
                Environment.Lookup.class);
            return lookup.tryLookupOperation(owner, name, args);
        } catch (LookupException e) {
            ERROR(cstNode, null, e.getMessage());
            return e.getAmbiguousMatches().isEmpty() ? null
                : (O) e.getAmbiguousMatches().get(0);
        }
	}

    @SuppressWarnings("unchecked")
    protected P lookupProperty(CSTNode cstNode, 
            Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
            C owner, String name) {
        try {
            Environment.Lookup<PK, C, O, P> lookup = OCLUtil.getAdapter(env,
                Environment.Lookup.class);
            return lookup.tryLookupProperty(owner, name);
        } catch (LookupException e) {
            ERROR(cstNode, null, e.getMessage());
            return e.getAmbiguousMatches().isEmpty() ? null
                : (P) e.getAmbiguousMatches().get(0);
        }
    }

    @SuppressWarnings("unchecked")
    protected C lookupAssociationClassReference(CSTNode cstNode, 
            Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
            C owner, String name) {
        try {
            Environment.Lookup<PK, C, O, P> lookup = OCLUtil.getAdapter(env,
                Environment.Lookup.class);
            return lookup.tryLookupAssociationClassReference(owner, name);
        } catch (LookupException e) {
            ERROR(cstNode, null, e.getMessage());
            return e.getAmbiguousMatches().isEmpty() ? null
                : (C) e.getAmbiguousMatches().get(0);
        }
    }

    @SuppressWarnings("unchecked")
    protected C lookupSignal(CSTNode cstNode, 
            Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
            C owner, String name, List<? extends TypedElement<C>> args) {
        try {
            Environment.Lookup<PK, C, O, P> lookup = OCLUtil.getAdapter(env,
                Environment.Lookup.class);
            return lookup.tryLookupSignal(owner, name, args);
        } catch (LookupException e) {
            ERROR(cstNode, null, e.getMessage());
            return e.getAmbiguousMatches().isEmpty() ? null
                : (C) e.getAmbiguousMatches().get(0);
        }
    }

    @SuppressWarnings("unchecked")
	protected S lookupState(CSTNode cstNode, 
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C sourceType, List<String> statePath) {
		try {
			return env.lookupState(sourceType, statePath);
        } catch (LookupException e) {
            ERROR(cstNode, null, e.getMessage());
            return e.getAmbiguousMatches().isEmpty() ? null
                : (S) e.getAmbiguousMatches().get(0);
		} catch (SemanticException e) {
			ERROR(cstNode, "stateExpCS", //$NON-NLS-1$
					e.getMessage());
			return null;
		}
	}
    
    /**
     * Creates an <tt>ExpressionInOcl</tt> instance.  Subclasses may override.
     * 
     * @return an new expression-in-OCL
     */
    protected ExpressionInOCL<C, PM> createExpressionInOCL() {
        return uml.createExpressionInOCL();
    }
    
    /**
     * Creates an <tt>Constraint</tt> instance.  Subclasses may override.
     * 
     * @return an new constraint
     */
    protected CT createConstraint() {
        return uml.createConstraint();
    }
	
	/**
	 * Initialize the mapping of an object (typically an astNode) to its originating cstNode,
	 * so that AST-based analysis may report error messages exploiting the CST context, or
	 * to support incremental AST/CST update.
	 * 
	 * @param env
	 * @param astNode
	 * @param cstNode
	 */
	protected void initASTMapping(Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			Object astNode, CSTNode cstNode) {
		
		OCLUtil.getAdapter(env, BasicEnvironment.class).initASTMapping(astNode, cstNode);
	}
    
    /**
     * Queries whether the specified name is escaped with an initial underscore
     * (<code>'_'</code>) character.
     * 
     * @param name a name
     * @return whether it begins with the underscore escape prefix
     */
    public static boolean isEscaped(String name) {
        return (name != null) && name.startsWith(OCL_ESCAPE_PREFIX);
    }
    
    /**
     * Obtains the unescaped name (assuming that it
     * {@linkplain #isEscaped(String) is escaped}) for another attempt to look
     * it up.
     * 
     * @param name an OCL-escaped name
     * @return the unescaped name
     */
    public static String unescape(String name) {
        return name.substring(OCL_ESCAPE_LENGTH);
    }
    
    /**
     * Checks whether the names are equal, accounting for
     * possibility of underscore-escaped names.
     * 
     * @param name a possibly underscore-escaped name
     * @param elementName name of an element in the model
     * 
     * @return whether the element name is equivalent to this name
     */
    public static boolean equalName(String name, String elementName) {
        boolean result = name.equals(elementName);
        if (!result && isEscaped(name)) {
            result = unescape(name).equals(elementName);
        }
        
        return result;
    }
}
