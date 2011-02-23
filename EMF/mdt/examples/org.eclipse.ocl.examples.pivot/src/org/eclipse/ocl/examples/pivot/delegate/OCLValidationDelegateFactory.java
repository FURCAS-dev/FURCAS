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
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLValidationDelegateFactory.java,v 1.2 2011/02/11 20:00:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;

/**
 * Factory for OCL derived-classifier validation delegates.
 * 
 * @since 3.0
 */
public class OCLValidationDelegateFactory extends AbstractOCLDelegateFactory
		implements ValidationDelegate.Factory, EValidator.ValidationDelegate {	// EValidator.ValidationDelegate.Descriptor

	public OCLValidationDelegateFactory() {}

	public OCLValidationDelegateFactory(OCLDelegateDomain delegateDomain) {
		super(delegateDomain);
	}

	public ValidationDelegate createValidationDelegate(EClassifier classifier) {
		EPackage ePackage = classifier.getEPackage();
		return new OCLValidationDelegate(getDelegateDomain(ePackage), classifier);
	}

	protected ValidationDelegate getValidationDelegate(EClassifier eClassifier) {
		if (delegateDomain == null) {
			EPackage ePackage = eClassifier.getEPackage();
			DelegateEPackageAdapter epAdapter = DelegateEPackageAdapter.getAdapter(ePackage);
			delegateDomain = (OCLDelegateDomain) epAdapter.getDelegateDomain(delegateURI);
		}
		DelegateEClassifierAdapter ecAdapter = DelegateEClassifierAdapter.getAdapter(eClassifier);
		ValidationDelegate validationDelegate = ecAdapter.getValidationDelegate(delegateURI);
		return validationDelegate;
	}

	public boolean validate(EClass eClass, EObject eObject,
			Map<Object, Object> context, EOperation invariant, String expression) {
		ValidationDelegate validationDelegate = getValidationDelegate(eClass);
		return validationDelegate.validate(eClass, eObject, context, invariant, expression);
	}

	public boolean validate(EClass eClass, EObject eObject,
			Map<Object, Object> context, String constraint, String expression) {
		ValidationDelegate validationDelegate = getValidationDelegate(eClass);
		return validationDelegate.validate(eClass, eObject, context, constraint, expression);
	}

	public boolean validate(EDataType eDataType, Object value,
			Map<Object, Object> context, String constraint, String expression) {
		ValidationDelegate validationDelegate = getValidationDelegate(eDataType);
		return validationDelegate.validate(eDataType, value, context, constraint, expression);
	}
	
	/**
	 * The Global variant of the Factory delegates to a local ResourceSet factory if one
	 * can be located at the EOperation.Internal.InvocationDelegate.Factory.Registry
	 * by the DelegateResourceSetAdapter.
	 */
	public static class Global extends OCLValidationDelegateFactory
	{
		@Override
		public ValidationDelegate createValidationDelegate(EClassifier classifier) {
			ValidationDelegate.Factory.Registry localRegistry = DelegateResourceSetAdapter.getRegistry(
				classifier, ValidationDelegate.Factory.Registry.class, null);
			if (localRegistry != null) {
				ValidationDelegate.Factory factory = localRegistry.getValidationDelegate(delegateURI);
				if (factory != null) {
					return factory.createValidationDelegate(classifier);
				}
			}
			return super.createValidationDelegate(classifier);
		}	
	}
}
