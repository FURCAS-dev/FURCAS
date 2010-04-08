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
 * $Id: DelegateEClassifierAdapter.java,v 1.3 2010/04/08 06:27:20 ewillink Exp $
 */
package org.eclipse.ocl.ecore.delegate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * DelegateEClassifierAdapter extends an EClassifier to cache its ValidationDelegate.
 * 
 * @since 3.0
 */
public class DelegateEClassifierAdapter extends AdapterImpl {

	public static DelegateEClassifierAdapter getAdapter(EClassifier eClassifier) {
		DelegateEClassifierAdapter adapter = (DelegateEClassifierAdapter) EcoreUtil
			.getAdapter(eClassifier.eAdapters(), DelegateEClassifierAdapter.class);
		if (adapter == null) {
			adapter = new DelegateEClassifierAdapter();
			eClassifier.eAdapters().add(adapter);
		}
		return adapter;
	}

	protected Map<String, ValidationDelegate> validationDelegateMap;

	public ValidationDelegate getValidationDelegate(String delegateURI) {
		if (validationDelegateMap == null) {
			getValidationDelegates();
		}
		return validationDelegateMap.get(delegateURI);
	}
	
	public Map<String, ValidationDelegate> getValidationDelegates() {
		if (validationDelegateMap == null) {
			EClassifier eClassifier = getTarget();
			validationDelegateMap = new HashMap<String, ValidationDelegate>();
			List<ValidationDelegate.Factory> factories = ValidationBehavior.INSTANCE.getFactories(eClassifier);
			if (eClassifier instanceof EClass) {
				for (EOperation eOperation : ((EClass)eClassifier).getEOperations()) {
					if (EcoreUtil.isInvariant(eOperation)) {					
						List<DelegateDomain> opDelegateDomains = InvocationBehavior.INSTANCE.getDelegateDomains(eOperation);
						for (DelegateDomain opDelegateDomain : opDelegateDomains) {
							ValidationDelegate.Factory opFactory = ValidationBehavior.INSTANCE.getFactory(opDelegateDomain, eClassifier);
							if (!factories.contains(opFactory)) {
								factories.add(opFactory);
							}
						}
					}
				}
			}
			if (!factories.isEmpty()) {
				for (ValidationDelegate.Factory factory : factories) {
					ValidationDelegate validationDelegate = factory.createValidationDelegate(eClassifier);
					if (validationDelegate != null) {
						validationDelegateMap.put(factory.getURI(), validationDelegate);
					}
				}
			} 
		}
		return validationDelegateMap;
	}

	@Override
	public EClassifier getTarget() {
		return (EClassifier) super.getTarget();
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == DelegateEClassifierAdapter.class;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		EClassifier resourceSet = (EClassifier) newTarget;
		super.setTarget(resourceSet);
	}
}
