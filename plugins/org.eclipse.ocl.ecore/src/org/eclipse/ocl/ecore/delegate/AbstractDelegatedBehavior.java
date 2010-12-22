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
 * 	 E.D.Willink - Bug 306079
 *
 * </copyright>
 *
 * $Id: AbstractDelegatedBehavior.java,v 1.3 2010/04/08 06:27:21 ewillink Exp $
 */
package org.eclipse.ocl.ecore.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ecore.InvalidLiteralExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.impl.InvalidLiteralExpImpl;
import org.eclipse.ocl.ecore.impl.NullLiteralExpImpl;

/**
 * A basic implementation of a delegated behavior.
 * 
 * @since 3.0
 */
public abstract class AbstractDelegatedBehavior<E extends EModelElement, R, F>
		implements DelegatedBehavior<E, R, F> {

	private static class InvalidExpression extends InvalidLiteralExpImpl {}
	private static class NullExpression extends NullLiteralExpImpl {}
	
	private static List<DelegatedBehavior<?, ?, ?>> delegatedBehaviors = null;

	public static List<DelegatedBehavior<?, ?, ?>> getDelegatedBehaviors() {
		// FIXME Maybe use an extension point here (but need a common
		//  Factory, Registry supertype for a user-defined fourth behavior)
		if (delegatedBehaviors == null) {
			delegatedBehaviors = new ArrayList<DelegatedBehavior<?, ?, ?>>();
			delegatedBehaviors.add(InvocationBehavior.INSTANCE);
			delegatedBehaviors.add(SettingBehavior.INSTANCE);
			delegatedBehaviors.add(ValidationBehavior.INSTANCE);
		}
		return delegatedBehaviors;
	};

    /**
     * Cache the constraintKey expression for modelElement, using the eContents and eDetails of
     * the {@link OCLDelegateDomain#OCL_DELEGATE_URI} EAnnotation to store the
     * constraintKey->expression mapping. Since
     * eDetails is a String to String mapping, the index of the eDetails constraintKey entry
     * is used to identify the index in eContents at which the corresponding expression is found.
     * <p>
     * On exit:
     * <pre>
     * eAnnotation = modelElement.getEAnnotation(OCL_DELEGATE_URI)
     * index = eAnnotation.getDetails().indexOf(constraintKey)
     * eAnnotation != null 
     * index >= 0
     * eAnnotation.getContents().get(index) = expression
     * </pre>
      * If no eDetails entry exists one is created to satisfy the above postconditions.
      * <br>
      * Dummy entries may be added to eContents() to maintain eDetails/eContents alignment.
      * <p>
      * A null expression may be cached to cache a failed creation. Use of a cached
      * null expression returns an {@link InvalidLiteralExp}.
      * 
      * @param modelElement for which an expression is to be cached
      * @param expression to be cached, may be null
      * @param constraintKey distinguishing between multiple expressions
     * @since 3.1
	 */
    protected void cacheExpression(EModelElement modelElement, OCLExpression expression, String constraintKey) {
    	EAnnotation a = modelElement.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
    	if (a == null){
    		a = EcoreFactory.eINSTANCE.createEAnnotation();
    		a.setSource(OCLDelegateDomain.OCL_DELEGATE_URI);
    		modelElement.getEAnnotations().add(a);
		}
    	EMap<String, String> details = a.getDetails();
		int indexOfKey = details.indexOfKey(constraintKey);
		if (indexOfKey < 0) {
			details.put(constraintKey, null);
			indexOfKey = details.size()-1;
		}
		List<EObject> contents = a.getContents();
		EObject cacheValue = expression != null ? expression : new InvalidExpression();
		if (indexOfKey < contents.size()) {
			contents.set(indexOfKey, cacheValue);
		}
		else {
			for (int i = contents.size(); i < indexOfKey; i++) {
				contents.add(new NullExpression()); // can't use null or duplicates in the EList
			}
			contents.add(cacheValue);
		}
    }

	/**
	 * Looks for an {@link OCLExpression} element attached to the
	 * {@link OCLDelegateDomain#OCL_DELEGATE_URI} annotation of
	 * <code>modelElement</code> at the same position at which the
	 * {@link OCLDelegateDomain#OCL_DELEGATE_URI} annotation holds a detail
	 * using any of the <code>constraintKeys</code>. For example, if there is a
	 * detail at position 3 with key "body" and "body" is part of
	 * <code>constraintKeys</code> then the contents element at position 3 of
	 * the {@link OCLDelegateDomain#OCL_DELEGATE_URI} annotation is returned if it is
	 * a {@link OCLEXpression} element.
	 * 
	 * @param modelElement from which to return a cached expression
	 * @param constraintKeys the prioritised list of constraintKeys for to find a cached expression
	 * @return null if none of the constraintKeys are known, or
	 * if no constraint is associated with the first known constraintKey
	 * else an {@link InvalidLiteralExp} if a null constraint was cached against
	 * the first known constraintKey, else the cached expression.
	 * 
	 * @since 3.1
	 */
	protected OCLExpression getCachedExpression(EModelElement modelElement, String... constraintKeys) {
		EAnnotation anno = modelElement.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
		if (anno != null) {
			// find the position of the first constraintKey that is a key in details 
			EList<EObject> contents = anno.getContents();
			EMap<String, String> details = anno.getDetails();
			for (String constraintKey : constraintKeys) {
				int pos = details.indexOfKey(constraintKey);
				if ((0 <= pos) && (pos < contents.size())) {
					EObject contentElement = contents.get(pos);
					if (contentElement instanceof NullExpression) {
						return null;
					}
					return (OCLExpression) contentElement;
				}
			}
		}
		return null;
    }

	public List<DelegateDomain> getDelegateDomains(E eObject) {
		EPackage ePackage = getEPackage(eObject);
		DelegateEPackageAdapter adapter = DelegateEPackageAdapter.getAdapter(ePackage);
		List<DelegateDomain> delegateDomains = new ArrayList<DelegateDomain>();
		for (DelegateDomain delegateDomain : adapter.getDelegateDomains(this)) {
			String uri = delegateDomain.getURI();
			if (eObject.getEAnnotation(uri) != null) {
				delegateDomains.add(delegateDomain);
			}
		}
		return delegateDomains;
	}

	public List<F> getFactories(E eObject) {
		EPackage ePackage = getEPackage(eObject);
		DelegateEPackageAdapter adapter = DelegateEPackageAdapter.getAdapter(ePackage);
		List<F> factories = new ArrayList<F>();
		for (DelegateDomain delegateDomain : adapter.getDelegateDomains(this)) {
			String uri = delegateDomain.getURI();
			if (eObject.getEAnnotation(uri) != null) {
				F factory = getFactory(delegateDomain, eObject);
				if (factory == null) {
					factory = getDefaultFactory();
				}
				if ((factory != null) && !factories.contains(factory)) {
					factories.add(factory);
				}
			}
		}
		return factories;
	}

	protected abstract F getFactory(DelegateDomain delegateDomain, E eObject);

	public F getFactory(E eObject) {
		EPackage ePackage = getEPackage(eObject);
		DelegateEPackageAdapter adapter = DelegateEPackageAdapter.getAdapter(ePackage);
		for (DelegateDomain delegateDomain : adapter.getDelegateDomains(this)) {
			String uri = delegateDomain.getURI();
			if (eObject.getEAnnotation(uri) != null) {
				F factory = getFactory(delegateDomain, eObject);
				if (factory == null) {
					factory = getDefaultFactory();
				}
				return factory;
			}
		}
		return null;
	}

	public void setDelegates(EPackage ePackage, List<String> delegateURIs) {
		final String name = getName();
		EAnnotation eAnnotation = ePackage.getEAnnotation(EcorePackage.eNS_URI);
		if (delegateURIs == null || delegateURIs.isEmpty()) {
			if (eAnnotation != null) {
				eAnnotation.getDetails().remove(name);
			}
		} else {
			if (eAnnotation == null) {
				eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
				eAnnotation.setSource(EcorePackage.eNS_URI);
				ePackage.getEAnnotations().add(eAnnotation);
			}
			StringBuffer value = new StringBuffer();
			for (Iterator<String> i = delegateURIs.iterator(); i.hasNext();) {
				value.append(i.next());
				if (i.hasNext()) {
					value.append(' ');
				}
			}
			eAnnotation.getDetails().put(name, value.toString());
		}
	}

	public String toString() {
		return getName() + " => " + getFactoryClass().getName(); //$NON-NLS-1$
	}
}
