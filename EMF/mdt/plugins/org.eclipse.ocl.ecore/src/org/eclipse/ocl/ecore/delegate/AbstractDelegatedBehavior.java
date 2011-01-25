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
 * $Id: AbstractDelegatedBehavior.java,v 1.4 2011/01/23 22:18:53 auhl Exp $
 */
package org.eclipse.ocl.ecore.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.impl.NullLiteralExpImpl;

/**
 * A basic implementation of a delegated behavior.
 * 
 * @since 3.0
 */
public abstract class AbstractDelegatedBehavior<E extends EModelElement, R, F>
		implements DelegatedBehavior<E, R, F> {

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
	 * An "identifying" instance that helps distinguish between the case where an OCL expression
	 * isn't found in the expression cache and hasn't been looked up elsewhere yet from the case where
	 * we looked around for a definition but couldn't find one 
	 * @since 3.1
	 */
	public static final OCLExpression NO_OCL_DEFINITION = new NullLiteralExpImpl() {};
	
	/**
	 * Return true if <code>e</code> is a reserved expression used to cache a miss and so
	 * avoid repeating the miss processing on subsequent accesses.
	 * 
	 * @since 3.1
	 */
	public static boolean isNoOCLDefinition(OCLExpression e) {
		return e == NO_OCL_DEFINITION;
	}

	/**
	 * Caches a single OCL expression in an adapter that can be attached, e.g., to an Ecore object
	 * without {@link Notification#isTouch() "modifying"} the object to which the adapter gets attached.
	 * 
	 * @since 3.1
	 */
	protected static class ExpressionCacheAdapter extends AdapterImpl
	{	
		/**
		 * Creates an {@link OCLExpressionCacheAdapter} for expression <code>e</code> and adds
		 * it to <code>modelElement</code>'s adapter list so that {@link #getCachedOCLExpression(Notifier)}
		 * will return <code>e</code> when called for <code>modelElement</code>. To achieve this, any other
		 * {@link OCLExpressionCacheAdapter} in <code>modelElement</code>'s adapter list is removed.
		 * 
		 * @param e if <code>null</code>, any existing cache entry is removed and no new entry
		 * is created. {@link #getCachedOCLExpression(Notifier)} will then return <code>null</code>. 
		 */
		public static void cacheOCLExpression(EModelElement modelElement, OCLExpression e) {
			for (Iterator<Adapter> i = modelElement.eAdapters().iterator(); i.hasNext(); ) {
				if (i.next().isAdapterForType(ExpressionCacheAdapter.class)) {
					i.remove();
				}
			}
			if (e != null) {
				ExpressionCacheAdapter newAdapter = new ExpressionCacheAdapter(e);
				modelElement.eAdapters().add(newAdapter);
			}
		}	

		/**
		 * Looks for an {@link OCLExpressionCacheAdapter} attached to <code>modelElement</code>.
		 * If such an adapter is found, its cached expression is returned. The cached expression
		 * may be a reserved expression indicating that no OCL expression exists and that an
		 * unsuccessful attempt to obtain one has been made before.
		 * {@link #isNoOCLDefinition(OCLExpression)} should be used to check for the reserved expression.
		 * null is returned if no cached expression is available.
		 */
		public static OCLExpression getCachedOCLExpression(EModelElement modelElement) {
			Adapter a = EcoreUtil.getExistingAdapter(modelElement, ExpressionCacheAdapter.class);
			if (a != null) {
				return ((ExpressionCacheAdapter) a).getExpression();
			} else {
				return null;
			}
		}
		
		private final OCLExpression expression;
		
		public ExpressionCacheAdapter(OCLExpression expression) {
			this.expression = expression;
		}
		
		public OCLExpression getExpression() {
			return expression;
		}
		
		@Override
		public boolean isAdapterForType(Object type) {
			return type == ExpressionCacheAdapter.class;
		}
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
