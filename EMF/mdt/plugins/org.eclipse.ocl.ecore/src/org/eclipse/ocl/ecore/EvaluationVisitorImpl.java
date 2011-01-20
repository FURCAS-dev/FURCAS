/**
 * <copyright>
 *
 * Copyright (c) 2009,2010 SAP AG and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Axel Uhl - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EvaluationVisitorImpl.java,v 1.1 2010/12/15 17:32:44 ewillink Exp $
 */
package org.eclipse.ocl.ecore;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

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
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.delegate.InvocationBehavior;
import org.eclipse.ocl.ecore.delegate.OCLInvocationDelegate;
import org.eclipse.ocl.ecore.delegate.SettingBehavior;
import org.eclipse.ocl.ecore.utilities.VisitorExtension;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.util.CollectionUtil;


/**
 * @since 3.1
 */
public class EvaluationVisitorImpl
		extends
		org.eclipse.ocl.EvaluationVisitorImpl<
		EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject,
		CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject> implements VisitorExtension<Object> {

	public EvaluationVisitorImpl(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
			Map<? extends EClass, ? extends Set<? extends EObject>> extentMap) {
		super(env, evalEnv, extentMap);
	}

	/**
	 * Callback for a PropertyCallExp visit. Evaluates the source of the
	 * expression and then reflectively gets the value of the property on the
	 * result. For example, in "self.foo", "self" is the source and would be
	 * evaluated first, then the value of the property "foo" would be accessed
	 * on that object.
	 */
	@SuppressWarnings("unchecked")
    public Object visitOppositePropertyCallExp(OppositePropertyCallExp pc) {
		EReference property = pc.getReferredOppositeProperty();
		OCLExpression<EClassifier> source = pc.getSource();
		// evaluate source
		Object context = source.accept(getVisitor());
		// if source is undefined, result is OclInvalid
		if (isUndefined(context)) {
            return getInvalid();
        }
		Object result = ((EvaluationEnvironmentWithHiddenOpposites) getEvaluationEnvironment())
			.navigateOppositeProperty(property, context);
		if ((pc.getType() instanceof CollectionType<?, ?>)
			&& !(result instanceof Collection<?>)) {
			// this was an XSD "unspecified multiplicity".  Now that we know what
			//    the multiplicity is, we can coerce it to a collection value
			CollectionKind kind = ((CollectionType<EClassifier, EOperation>) pc.getType()).getKind();
			Collection<Object> collection = CollectionUtil.createNewCollection(kind);
			if (result != null) {
				collection.add(result);
			}
			result = collection;
		}
		return result;
	}

	/**
	 * Tries to fetch an operation body from where the
	 * {@link OCLInvocationDelegate OCL invocation delegate} stores it. If nothing
	 * is found, this method delegates to the base class implementation which then
	 * performs the usual search in the OCL_NAMESPACE_URI annotation and the
	 * environment's body condition cache.
	 */
	@Override
	protected OCLExpression<EClassifier> getOperationBody(EOperation operation) {
		OCLExpression<EClassifier> result = InvocationBehavior.INSTANCE
			.getCachedOperationBody(operation);
		if (result == null
			&& InvocationBehavior.INSTANCE
				.hasUncompiledOperationBody(operation)) {
			result = InvocationBehavior.INSTANCE.getOperationBody(
				OCL.newInstance(getEnvironment().getFactory()), operation);
		}
		if (result == null) {
			result = super.getOperationBody(operation);
		}
		return result;
	}

	@Override
	protected OCLExpression<EClassifier> getPropertyBody(
			EStructuralFeature property) {
		OCLExpression<EClassifier> result = SettingBehavior.INSTANCE
			.getCachedFeatureBody(property);
		if (result == null
			&& SettingBehavior.INSTANCE.hasUncompiledFeatureBody(property)) {
			result = SettingBehavior.INSTANCE.getFeatureBody(
				OCL.newInstance(getEnvironment().getFactory()), property);
		}
		if (result == null) {
			result = super.getPropertyBody(property);
		}
		return result;
	}

}
