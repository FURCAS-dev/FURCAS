/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: SettingBehavior.java,v 1.2 2010/04/08 06:27:21 ewillink Exp $
 */
package org.eclipse.ocl.ecore.delegate;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;

/**
 * @since 3.0
 */
public class SettingBehavior extends AbstractDelegatedBehavior<EStructuralFeature, SettingDelegate.Factory.Registry, SettingDelegate.Factory>
{
	public static final SettingBehavior INSTANCE = new SettingBehavior();
	public static final String DERIVATION_CONSTRAINT_KEY = "derivation"; //$NON-NLS-1$
	public static final String INITIAL_CONSTRAINT_KEY = "initial"; //$NON-NLS-1$
	public static final String NAME = "settingDelegates"; //$NON-NLS-1$

	public SettingDelegate.Factory getDefaultFactory() {
		return SettingDelegate.Factory.Registry.INSTANCE.getFactory(getName());
	}

	public SettingDelegate.Factory.Registry getDefaultRegistry() {
		return SettingDelegate.Factory.Registry.INSTANCE;
	}

	public EPackage getEPackage(EStructuralFeature eStructuralFeature) {
		return eStructuralFeature.getEContainingClass().getEPackage();
	}

	public SettingDelegate.Factory getFactory(DelegateDomain delegateDomain, EStructuralFeature eStructuralFeature) {
		SettingDelegate.Factory.Registry registry = DelegateResourceSetAdapter.getRegistry(
			eStructuralFeature, getRegistryClass(), getDefaultRegistry());
	    return registry.getFactory(delegateDomain.getURI());
	}	

	public Class<SettingDelegate.Factory> getFactoryClass() {
		return SettingDelegate.Factory.class;
	}

	/**
	 * Throws an {@link IllegalArgumentException} in case a <code>null</code> {@link OCL} reference is passed
	 * but a valid one is needed because nothing is found in the cache for the <code>structuralFeature</code>
	 * requested. This behavior can be used to attempt a cache lookup without having to create a valid {@link OCL}
	 * object. Catching the exception can then be used to try again with a valid {@link OCL} object.
	 */
	public OCLExpression getFeatureBody(OCL ocl, EStructuralFeature structuralFeature) {
		OCLExpression result = getCachedExpression(structuralFeature, DERIVATION_CONSTRAINT_KEY, INITIAL_CONSTRAINT_KEY);
		if (result != null){
			return result;
		}
		String key = DERIVATION_CONSTRAINT_KEY;
	    EAnnotation eAnnotation = structuralFeature.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
	    if (eAnnotation == null) {
	    	return null;
	    }
	    EMap<String, String> details = eAnnotation.getDetails();
		String expr = details.get(key);
		if (expr == null) {
			key = INITIAL_CONSTRAINT_KEY;
			expr = details.get(key);
			if (expr == null) {
				return null;
			}
		}
		if (ocl == null) {
			// now we would have needed, but it's not there
			throw new IllegalArgumentException("Requiring a valid OCL object since feature body not found in cache"); //$NON-NLS-1$
		}
		OCLExpression body = null;
		try {
			EClass context = structuralFeature.getEContainingClass();
			OCL.Helper helper = ocl.createOCLHelper();
			helper.setAttributeContext(context, structuralFeature);
			Constraint constraint;
			try {
				constraint = helper.createDerivedValueExpression(expr);
			} catch (ParserException e) {
				throw new OCLDelegateException(e.getLocalizedMessage(), e);
			}
			if (constraint == null) {
				return null;
			}
			ExpressionInOCL specification = (ExpressionInOCL) constraint.getSpecification();
			if (specification == null) {
				return null;
			}
			body = (OCLExpression) specification.getBodyExpression();
			return body;
		} finally {
			cacheExpression(structuralFeature, body, key);
		}
	}
	
	public String getName() {
		return NAME;
	}

	public Class<SettingDelegate.Factory.Registry> getRegistryClass() {
		return SettingDelegate.Factory.Registry.class;
	}
}