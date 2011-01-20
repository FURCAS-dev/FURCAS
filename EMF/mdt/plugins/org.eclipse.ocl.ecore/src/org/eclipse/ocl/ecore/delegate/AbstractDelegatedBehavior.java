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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.impl.NullLiteralExpImpl;
import org.eclipse.ocl.ecore.internal.OCLExpressionCacheAdapter;

/**
 * A basic implementation of a delegated behavior.
 * 
 * @since 3.0
 */
public abstract class AbstractDelegatedBehavior<E extends EModelElement, R, F>
		implements DelegatedBehavior<E, R, F> {

	private static List<DelegatedBehavior<?, ?, ?>> delegatedBehaviors = null;

	/**
	 * An "identifying" class that helps distinguish between the case where an operation or property
	 * isn't found in the expression cache and hasn't been looked up elsewhere yet from the case where
	 * we looked around for a definition but couldn't find one 
	 * @since 3.1
	 */
	protected static class NullExpression extends NullLiteralExpImpl {}

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
	 * Looks for an {@link OCLExpressionCacheAdapter} attached to <code>n</code>.
	 * If such an adapter is found, its
	 * {@link OCLExpressionCacheAdapter#getExpression() expression} is returned;
	 * otherwise, <code>null</code> is returned. A special expression may be
	 * returned indicating that for <code>n</code> no OCL expression exists and
	 * that an unsuccessful attempt to obtain one has been made before. To check
	 * for this case, callers shall use {@link #hasNoOCLDefinition(OCLExpression)}.
	 * If it returns <code>true</code>, no expression could be found.
	 * 
	 * @since 3.1
	 */
	public OCLExpression getCachedOCLExpression(Notifier n) {
		Adapter a = EcoreUtil.getExistingAdapter(n, OCLExpressionCacheAdapter.class);
		if (a != null) {
			return ((OCLExpressionCacheAdapter) a).getExpression();
		} else {
			return null;
		}
	}
	
	/**
	 * Creates an {@link OCLExpressionCacheAdapter} for expression <code>e</code> and adds
	 * it to <code>n</code>'s adapter list so that {@link #getCachedOCLExpression(Notifier)}
	 * will return <code>e</code> when called for <code>n</code>. To achieve this, any other
	 * {@link OCLExpressionCacheAdapter} in <code>n</code>'s adapter list is removed.
	 * 
	 * @param e if <code>null</code>, any existing cache entry is removed and no new entry
	 * is created. {@link #getCachedOCLExpression(Notifier)} will then return <code>null</code>. 
	 * 
	 * @since 3.1
	 */
	public void cacheOCLExpression(Notifier n, OCLExpression e) {
		for (Iterator<Adapter> i = n.eAdapters().iterator(); i.hasNext(); ) {
			if (i.next() instanceof OCLExpressionCacheAdapter) {
				i.remove();
			}
		}
		if (e != null) {
			OCLExpressionCacheAdapter newAdapter = new OCLExpressionCacheAdapter(
				e);
			n.eAdapters().add(newAdapter);
		}
	}
	
	/**
	 * Tells if an expression returned by {@link #getCachedOCLExpression(Notifier)} indicates
	 * that {@link #cacheThatItHasNoOCLBody(Notifier)} was called before for that notifier.
	 * This documents a previous unsuccessful attempt to obtain an OCL expression for the
	 * notifier and that no attempt needs to be made again. To remove this indication,
	 * call {@link #cacheOCLExpression(Notifier, OCLExpression)} for that notifier with a
	 * <code>null</code> expression.
	 * 
	 * @since 3.1
	 */
	public boolean hasNoOCLDefinition(OCLExpression e) {
		return e instanceof NullExpression;
	}
	
	/**
	 * Remembers an unsuccessful attempt to obtain an OCL expression for the notifier <code>n</code>
	 * such that, when {@link #getCachedOCLExpression(Notifier)} is called for <code>n</code>, the
	 * result passed to {@link #hasNoOCLDefinition(OCLExpression)} will return <code>true</code>.
	 * @since 3.1
	 */
	protected void cacheThatItHasNoOCLBody(Notifier n) {
		cacheOCLExpression(n, new NullExpression());
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
