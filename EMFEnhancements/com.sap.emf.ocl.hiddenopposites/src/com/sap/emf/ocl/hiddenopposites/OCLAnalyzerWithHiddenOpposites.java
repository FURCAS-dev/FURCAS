/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.emf.ocl.hiddenopposites;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.FeatureCallExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.parser.AbstractOCLParser;
import org.eclipse.ocl.parser.OCLAnalyzer;
import org.eclipse.ocl.parser.OCLParser;
import org.eclipse.ocl.types.CollectionType;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.ExpressionsFactory;
import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;

public class OCLAnalyzerWithHiddenOpposites
        extends
        OCLAnalyzer<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> {

    public OCLAnalyzerWithHiddenOpposites(AbstractOCLParser parser) {
	super(parser);
    }

    public OCLAnalyzerWithHiddenOpposites(
	    Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> environment,
	    String text) {
	super(environment, text);
    }

    public OCLAnalyzerWithHiddenOpposites(
	    Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> environment) {
	super(environment);
    }

    public OCLAnalyzerWithHiddenOpposites(OCLParser parser) {
	super(parser);
    }

    /**
     * Parses a <tt>simpleNameCS</tt> token. This method is largely a <i>template</i>, delegating to helpers that may be
     * separately overridden to resolve simple names to various kinds of expression.
     * 
     * @param simpleNameCS
     *            the <code>simpleNameCS</code> <code>CSTNode</code>
     * @param env
     *            the OCL environment
     * @param source
     *            the source of the <code>simpleNameCS</code>
     * @return the parsed <code>OCLExpression</code>
     * 
     * @see #simpleAssociationClassName(SimpleNameCS, Environment, OCLExpression, Object, String)
     * @see #simplePropertyName(SimpleNameCS, Environment, OCLExpression, Object, String)
     * @see #simpleTypeName(SimpleNameCS, Environment, OCLExpression, Object, String)
     * @see #simpleVariableName(SimpleNameCS, Environment, OCLExpression, String)
     * @see #simpleUndefinedName(SimpleNameCS, Environment, OCLExpression, String)
     */
    @Override
    protected OCLExpression<EClassifier> simpleNameCS(
	    SimpleNameCS simpleNameCS,
	    Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
	    OCLExpression<EClassifier> source) {

	if ((source != null) && isErrorNode(source)) {
	    // don't attempt to parse navigation from an unparseable source
	    return source; // return the same unparseable token
	}

	String simpleName = null;
	EClassifier classifier = null;

	/*
	 * A name can be a variable defined by a Variable declaration, the special variable "self", an attribute or a
	 * reference to another object. If the source is not null, then the last token was a "." or "->" The source is
	 * used to establish the navigation. If no type is provided, then either the name is a the use of a variable, or
	 * there is an implicit variable declaration (self or an iterator) that is the source.
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
	case SimpleTypeEnum.OCL_INVALID:
	case SimpleTypeEnum.OCL_MESSAGE:
	case SimpleTypeEnum.UNLIMITED_NATURAL:
	    // if we have a source, then this is a feature call
	    if (source == null) {
		classifier = primitiveTypeCS(simpleNameCS.getType(), env);
		simpleName = uml.getName(classifier);
	    }
	    break;
	}

	/*
	 * The source may be a collection type (for example, in self.children.name, children may be a set.)_ In this
	 * case, we have to get the element type of children, so that the attribute name can be found. The source type
	 * can also be a tuple type. In this case, we need to get the EClass of the tuple.
	 */
	EClassifier sourceElementType = null;
	if (source != null) {
	    sourceElementType = source.getType();
	    if (sourceElementType instanceof CollectionType<?, ?>) {
		@SuppressWarnings("unchecked")
		CollectionType<EClassifier, EOperation> ct = (CollectionType<EClassifier, EOperation>) sourceElementType;

		sourceElementType = ct.getElementType();
	    }
	}

	// cascaded alternatives for a simpleNameCS
	OCLExpression<EClassifier> astNode = simpleTypeName(simpleNameCS, env, source, classifier, simpleName);
	if (astNode == null) {
	    astNode = simpleVariableName(simpleNameCS, env, source, simpleName);
	}
	if (astNode == null) {
	    astNode = simplePropertyName(simpleNameCS, env, source, sourceElementType, simpleName);
	}
	if (astNode == null) {
	    astNode = simpleOppositePropertyName(simpleNameCS, env, source, sourceElementType, simpleName);
	}
	if (astNode == null) {
	    astNode = simpleAssociationClassName(simpleNameCS, env, source, sourceElementType, simpleName);
	}
	if (astNode == null) {
	    astNode = simpleUndefinedName(simpleNameCS, env, source, simpleName);
	}

	/*
	 * If the source type is a collection, then need there is an implicit COLLECT operator. Note that this rule is
	 * not called after "->". Check for FeatureCallExp in case we created a dummy InvalidLiteralExp.
	 */
	if ((source != null) && (source.getType() instanceof CollectionType<?, ?>)
	        && (astNode instanceof FeatureCallExp<?>)) {
	    astNode = createImplicitCollect(source, (FeatureCallExp<EClassifier>) astNode, env, simpleNameCS);
	}

	return astNode;
    }

    /**
     * Attempts to parse a <tt>simpleNameCS</tt> as an opposite property call expression. An opposite property call
     * expression can be used in the EMOF case where there is no real opposite property / reference for backward
     * navigation. The opposite property call then references the forward property while its meaning is to
     * backward-navigate by a query with a well-defined scope.
     * 
     * @param simpleNameCS
     *            the simple name
     * @param env
     *            the current environment
     * @param source
     *            the navigation source expression, or <code>null</code> if the source is implicit
     * @param owner
     *            the owner of the property to be navigated, or <code>null</code> if the source is implicit
     * @param simpleName
     *            the simple name, as a string
     * @return the parsed opposite property call, or <code>null</code> if the simple name does not resolve to an
     *         available property that shall be navigated in reverse
     * 
     * @see #simpleNameCS(SimpleNameCS, Environment, OCLExpression)
     * @since 3.0
     */
    protected OppositePropertyCallExp simpleOppositePropertyName(
	    SimpleNameCS simpleNameCS,
	    Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
	    OCLExpression<EClassifier> source, EClassifier owner, String simpleName) {
	if (simpleName == null) {
	    return null;
	}
	OppositePropertyCallExp result = null;

	EReference property = lookupOppositeProperty(simpleNameCS, env, owner, simpleName);
	if (property != null) {
	    TRACE("variableExpCS", "Property: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$

	    result = ExpressionsFactory.eINSTANCE.createOppositePropertyCallExp();
	    initASTMapping(env, result, simpleNameCS, null);
	    result.setReferredOppositeProperty(property);
	    result.setType(getOppositePropertyType(simpleNameCS, env, owner, property));

	    if (source != null) {
		result.setSource(source);
	    } else {
		Variable<EClassifier, EParameter> implicitSource = env.lookupImplicitSourceForProperty(simpleName);
		VariableExp<EClassifier, EParameter> src = createVariableExp(env, simpleNameCS, implicitSource);
		result.setSource(src);
	    }

	    initPropertyPositions(result, simpleNameCS);
	}

	return result;
    }

    protected EReference lookupOppositeProperty(
	    CSTNode cstNode,
	    Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
	    EClassifier owner, String name) {
	try {
	    EcoreEnvironmentWithHiddenOpposites.Lookup lookup = OCLUtilWithHiddenOpposites.getAdapter(env,
		    EcoreEnvironmentWithHiddenOpposites.Lookup.class);
	    EReference property = lookup.tryLookupOppositeProperty(owner, name);

	    if (cstNode != null) {
		cstNode.setAst(property);
	    }

	    return property;
	} catch (LookupException e) {
	    ERROR(cstNode, null, e.getMessage());
	    return e.getAmbiguousMatches().isEmpty() ? null : (EReference) e.getAmbiguousMatches().get(0);
	}
    }

    /**
     * Obtains the type, in the current environment, of the specified property's (potentially "hidden") opposite without
     * assuming that there actually exists an opposite property. The type is determined from the reverse property alone,
     * e.g., by that property's owner.
     * <p>
     * 
     * As a side-effect, the CST node is configured with traceability to the resulting type and the referenced property.
     * 
     * @param cstNode
     *            a property-call or property-context concrete syntax
     * @param env
     *            the current OCL parsing environment
     * @param owner
     *            the contextual classifier of the property reference
     * @param property
     *            the referenced property
     * @return the property's type
     * 
     * @since 3.0
     */
    protected EClassifier getOppositePropertyType(
	    CSTNode cstNode,
	    Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
	    EClassifier owner, EStructuralFeature property) {
	EClassifier propertyType = ((EcoreEnvironmentWithHiddenOpposites) env).getOppositePropertyType(owner, property);
	initASTMapping(env, propertyType, cstNode, property);
	return propertyType;
    }

}
