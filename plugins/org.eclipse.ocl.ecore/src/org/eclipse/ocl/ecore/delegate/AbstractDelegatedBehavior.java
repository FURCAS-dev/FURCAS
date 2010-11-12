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
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.OCLExpression;

/**
 * A basic implementation of a delegated behavior.
 * 
 * @since 3.0
 */
public abstract class AbstractDelegatedBehavior<E extends EModelElement, R, F>
		implements DelegatedBehavior<E, R, F> {

	private static List<DelegatedBehavior<?, ?, ?>> delegatedBehaviors = null;
	private static final Constraint DUMMY_CONSTRAINT = org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createConstraint();

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
     * @since 3.1
	 */
    protected void cacheExpression(EModelElement modelElement, Constraint constraint, String... keys) {
    	EAnnotation a = modelElement.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
    	if (a == null){
    		a = EcoreFactory.eINSTANCE.createEAnnotation();
    		a.setSource(OCLDelegateDomain.OCL_DELEGATE_URI);
    		modelElement.getEAnnotations().add(a);
		}
		for (String key : keys) {
			int indexOfKey = a.getDetails().indexOfKey(key);
			if (indexOfKey >= 0) {
				pad(a.getContents(), indexOfKey);
				a.getContents().add(constraint);
				return;
			}
		}
		a.getDetails().put(keys[0], null);
		pad(a.getContents(), a.getDetails().size()-1);
		a.getContents().add(constraint);
    }

	/**
	 * Looks for a {@link Constraint} element attached to the
	 * {@link OCLDelegateDomain#OCL_DELEGATE_URI} annotation of
	 * <code>modelElement</code> at the same position at which the
	 * {@link OCLDelegateDomain#OCL_DELEGATE_URI} annotation holds a detail
	 * using any of the <code>constraintKeys</code>. For example, if there is a
	 * detail at position 3 with key "body" and "body" is part of
	 * <code>constraintKeys</code> then the contents element at position 3 of
	 * the {@link OCLDelegateDomain#OCL_DELEGATE_URI} annotation is returned if it is
	 * a {@link Constraint} element. If a {@link Constraint} element is found,
	 * the {@link OCLExpression} obtained by calling
	 * {@link Constraint#getSpecification() getSpecification()}.
	 * {@link ExpressionInOCL#getBodyExpression() getBodyExpression()} on the
	 * constraint is returned.
	 * 
	 * @return <code>null</code> if no {@link Constraint} is found in the
	 *         position expected
	 * @since 3.1
	 */
	protected OCLExpression getCachedExpression(EModelElement modelElement,
			String... constraintKeys) {
		EAnnotation anno = modelElement
			.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
		if (anno != null) {
			int pos = -1;
			// find the position of the first constraintKey that is a key in details 
			for (String constraintKey : constraintKeys) {
				pos = anno.getDetails().indexOfKey(constraintKey);
				if (pos >= 0) {
					break;
				}
			}
			if (pos >= 0) {
				if (anno.getContents().size() > pos) {
					EObject contentElement = anno.getContents().get(pos);
					if (contentElement instanceof Constraint && contentElement != DUMMY_CONSTRAINT) {
						return (OCLExpression) ((Constraint) contentElement)
							.getSpecification().getBodyExpression();
					}
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

	/**
	 * pads <code>contents</code> with <code>null</code> elements so that adding
	 * another object to it as position <code>upTo</code> becomes possible.
	 */
    private void pad(EList<EObject> contents, int upTo) {
		for (int i=contents.size(); i<upTo; i++) {
			contents.add(DUMMY_CONSTRAINT); // can't use null in an EList
		}
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
