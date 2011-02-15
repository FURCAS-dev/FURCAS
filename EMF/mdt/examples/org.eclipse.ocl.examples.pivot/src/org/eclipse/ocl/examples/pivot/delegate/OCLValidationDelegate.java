/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLValidationDelegate.java,v 1.2 2011/02/11 20:00:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.StandardLibrary;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.osgi.util.NLS;

/**
 * An implementation of the dynamic validation delegate API, maintaining a cache
 * of compiled constraints and invariants.
 * 
 * @since 3.0
 */
public class OCLValidationDelegate implements ValidationDelegate
{	
	protected final OCLDelegateDomain delegateDomain;
	protected final EClassifier eClassifier;
	  
	/**
	 * Initializes me with the classifier whose DelegateEClassifierAdapter delegates to me.
	 * 
	 * @param classifier
	 *            my classifier
	 */
	public OCLValidationDelegate(OCLDelegateDomain delegateDomain, EClassifier classifier) {
		this.delegateDomain = delegateDomain;
		this.eClassifier = classifier;
	}

	protected boolean check(Object object, String constraint, ExpressionInOcl query) {
		OCL ocl = delegateDomain.getOCL();
		StandardLibrary stdlib = ocl.getEnvironment().getOCLStandardLibrary();
		if (query.getType() != stdlib.getBooleanType()) {
			String message = NLS.bind(OCLMessages.ValidationConstraintIsNotBoolean_ERROR_, constraint);
			throw new OCLDelegateException(message);
		}
		Value result = ocl.evaluate(object, query);
		if ((result == null) || result.isInvalid()) {
			String message = NLS.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, constraint);
			throw new OCLDelegateException(message);
		}
		if (result.isNull()) {
			String message = NLS.bind(OCLMessages.ValidationResultIsNull_ERROR_, constraint);
			throw new OCLDelegateException(message);
		}
		if (result.asBooleanValue() == null) {
			String message = NLS.bind(OCLMessages.ValidationResultIsNotBoolean_ERROR_, constraint);
			throw new OCLDelegateException(message);
		}		
		return result.isTrue();
	}

	@Override
	public String toString() {
		return "<" + delegateDomain.getURI() + ":validate> " + eClassifier.getEPackage().getName() + "::" + eClassifier.getName(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	public boolean validate(EClass eClass, EObject eObject,
			Map<Object, Object> context, EOperation invariant, String expression) {
		TypeManager typeManager = delegateDomain.getOCL().getTypeManager();
		Resource ecoreMetaModel = invariant.eResource();
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreMetaModel, typeManager);
		Operation operation = ecore2Pivot.getCreated(Operation.class, invariant);
		ExpressionInOcl query = InvocationBehavior.INSTANCE.getExpressionInOcl(typeManager, operation);
		return check(eObject, invariant.getName(), query);
	}

	public boolean validate(EClass eClass, EObject eObject,
			Map<Object, Object> context, String constraint, String expression) {
		TypeManager typeManager = delegateDomain.getOCL().getTypeManager();
		ExpressionInOcl query = ValidationBehavior.INSTANCE.getExpressionInOcl(
			typeManager, eClass, constraint);
		return check(eObject, constraint, query);
	}

	public boolean validate(EDataType eDataType, Object value,
			Map<Object, Object> context, String constraint, String expression) {
		TypeManager typeManager = delegateDomain.getOCL().getTypeManager();
		ExpressionInOcl query = ValidationBehavior.INSTANCE.getExpressionInOcl(
			typeManager, eDataType, constraint);
		return check(value, constraint, query);
	}
}
