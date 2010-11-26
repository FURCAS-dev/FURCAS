package org.eclipse.ocl.ecore.parser;

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
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EnvironmentWithHiddenOpposites;
import org.eclipse.ocl.ecore.OppositePropertyCallExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.internal.OCLFactoryImpl;
import org.eclipse.ocl.ecore.utilities.OCLFactoryWithHiddenOpposite;
import org.eclipse.ocl.ecore.utilities.TypeUtil;
import org.eclipse.ocl.expressions.NavigationCallExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.parser.AbstractOCLParser;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.UMLReflectionWithOpposite;


public class OCLAnalyzer
		extends
		org.eclipse.ocl.parser.OCLAnalyzer<EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject,
		CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject> {

	public OCLAnalyzer(AbstractOCLParser parser) {
		super(parser);
	}

	public OCLAnalyzer(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> rootEnvironment,
			String input) {
		super(rootEnvironment, input);
	}

	/**
	 * Attempts to parse a <tt>simpleNameCS</tt> as a property call expression.
	 * 
	 * @param simpleNameCS
	 *            the simple name
	 * @param env
	 *            the current environment
	 * @param source
	 *            the navigation source expression, or <code>null</code> if the
	 *            source is implicit
	 * @param owner
	 *            the owner of the property to be navigated, or
	 *            <code>null</code> if the source is implicit
	 * @param simpleName
	 *            the simple name, as a string
	 * @return the parsed property call, or <code>null</code> if the simple name
	 *         does not resolve to an available property
	 * 
	 * @see #simpleNameCS(SimpleNameCS, Environment, OCLExpression)
	 * 
	 * @since 1.3
	 */
	protected PropertyCallExp<EClassifier, EStructuralFeature> simplePropertyName(
			SimpleNameCS simpleNameCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject,
			CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> env,
			OCLExpression<EClassifier> source, EClassifier owner, String simpleName) {
		NavigationCallExp<EClassifier, EStructuralFeature> result = simplePropertyNameIncludingHiddenOpposites(simpleNameCS, env, source, owner, simpleName);
		if (result instanceof PropertyCallExp<?, ?>) {
			return (PropertyCallExp<EClassifier, EStructuralFeature>) result;
		} else {
			return null;
		}
	}
	
	/**
	 * Attempts to parse a <tt>simpleNameCS</tt> as a property call expression.
	 * 
	 * @param simpleNameCS
	 *            the simple name
	 * @param env
	 *            the current environment
	 * @param source
	 *            the navigation source expression, or <code>null</code> if the
	 *            source is implicit
	 * @param owner
	 *            the owner of the property to be navigated, or
	 *            <code>null</code> if the source is implicit
	 * @param simpleName
	 *            the simple name, as a string
	 * @return the parsed property call, or <code>null</code> if the simple name
	 *         does not resolve to an available property
	 * 
	 * @see #simpleNameCS(SimpleNameCS, Environment, OCLExpression)
	 */
	@Override
	protected NavigationCallExp<EClassifier, EStructuralFeature> simplePropertyNameIncludingHiddenOpposites(
			SimpleNameCS simpleNameCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject,
			CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> env,
			OCLExpression<EClassifier> source, EClassifier owner, String simpleName) {
		if (simpleName == null) {
			return null;
		}
		NavigationCallExp<EClassifier, EStructuralFeature> result = null;

		EStructuralFeature property = lookupProperty(simpleNameCS, env, owner, simpleName);
		if (property != null) {
			if (uml.getOwningClassifier(property) == null) {
				// marks a temporary property that encodes a "hidden" opposite
				if (uml instanceof UMLReflectionWithOpposite<?>) {
					@SuppressWarnings("unchecked")
					UMLReflectionWithOpposite<EStructuralFeature> umlWithOpposite = ((UMLReflectionWithOpposite<EStructuralFeature>) uml);
					result = createOppositePropertyCallExp(simpleNameCS, env,
						source, owner, simpleName, umlWithOpposite.getOpposite(property));
				} else {
					String message = OCLMessages.bind(
						OCLMessages.CantFindOppositeWithUMLReflection_ERROR_, simpleName);
					ERROR(simpleNameCS, "variableExpCS", message);//$NON-NLS-1$
				}
			} else {
				result = createPropertyCallExp(simpleNameCS, env, source,
					owner, simpleName, property);
			}
		}
		return result;
	}

	private PropertyCallExp<EClassifier, EStructuralFeature> createPropertyCallExp(
			SimpleNameCS simpleNameCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject,
			CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> env,
			OCLExpression<EClassifier> source, EClassifier owner, String simpleName, EStructuralFeature property) {
		PropertyCallExp<EClassifier, EStructuralFeature> result;
		TRACE("variableExpCS", "Property: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$

		result = oclFactory.createPropertyCallExp();
		initASTMapping(env, result, simpleNameCS, null);
		result.setReferredProperty(property);
		result.setType(getPropertyType(simpleNameCS, env, owner, property));

		if (source != null) {
			result.setSource(source);
		} else {
			Variable<EClassifier, EParameter> implicitSource = env
				.lookupImplicitSourceForProperty(simpleName);
			VariableExp<EClassifier, EParameter> src = createVariableExp(env, simpleNameCS,
				implicitSource);
			result.setSource(src);
		}

		initPropertyPositions(result, simpleNameCS);
		return result;
	}

	@Override
	protected OCLFactory createOCLFactory(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject,
			CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> env) {
		history = new OCLFactoryWithHistory(env.getOCLFactory());
		return history;
	}

	private OppositePropertyCallExp createOppositePropertyCallExp(
			SimpleNameCS simpleNameCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject,
			CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> env,
			OCLExpression<EClassifier> source, EClassifier owner, String simpleName, EStructuralFeature property) {
		OppositePropertyCallExp result;
		TRACE("variableExpCS", "Opposite Property: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$

		// The following cast is permissible because opposite property calls can only occur in
		// environments that have factories implementing OCLFactoryWithHiddenOpposite, e.g.,
		// the OCLFactory implementation for OCLEcore.
		result = ((OCLFactoryWithHiddenOpposite) oclFactory).createOppositePropertyCallExp();
		initASTMapping(env, result, simpleNameCS, null);
		result.setReferredOppositeProperty((EReference) property);
		result.setType(getOppositePropertyType(simpleNameCS, env, owner, property));

		if (source != null) {
			result.setSource(source);
		} else {
			if (env instanceof EnvironmentWithHiddenOpposites) {
				Variable<EClassifier, EParameter> implicitSource = ((EnvironmentWithHiddenOpposites) env)
					.lookupImplicitSourceForOppositeProperty(simpleName);
				VariableExp<EClassifier, EParameter> src = createVariableExp(env,
					simpleNameCS, implicitSource);
				result.setSource(src);
			}
		}

		initPropertyPositions(result, simpleNameCS);
		return result;
	}

	/**
	 * Obtains the type, in the current environment, of the specified property's
	 * (potentially "hidden") opposite without assuming that there actually exists
	 * an opposite property. The type is determined from the reverse property alone,
	 * e.g., by that property's owner.<p>
	 * 
	 * As a side-effect, the CST node is configured with traceability to the
	 * resulting type and the referenced property.
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
	 * @since 3.1
	 */
	protected EClassifier getOppositePropertyType(CSTNode cstNode,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject,
			CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> env,
			EClassifier owner, EStructuralFeature property) {
		EClassifier propertyType = TypeUtil.getOppositePropertyType(env, owner, property);
		initASTMapping(env, propertyType, cstNode, property);
		return propertyType;
	}

	/**
	 * @since 3.1
	 */
	protected EStructuralFeature lookupOppositeProperty(CSTNode cstNode,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject,
			CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> env,
			EClassifier owner, String name) {
		try {
			EStructuralFeature property = null;
			if (env instanceof EnvironmentWithHiddenOpposites) {
				property = ((EnvironmentWithHiddenOpposites) env)
					.lookupOppositeProperty(owner, name);
			}
			if (cstNode != null) {
				cstNode.setAst(property);
			}
			return property;
		} catch (LookupException e) {
			ERROR(cstNode, null, e.getMessage());
			return e.getAmbiguousMatches().isEmpty()
				? null
				: (EStructuralFeature) e.getAmbiguousMatches().get(0);
		}
	}

}
