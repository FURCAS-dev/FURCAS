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
 * $Id: DelegateEPackageAdapter.java,v 1.1 2011/01/30 11:16:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * DelegateEClassifierAdapter extends an EClassifier to cache its DelegateDomain
 * that supervises installation of OCL annotations from an OCL document.
 * 
 * @since 3.0
 */
public class DelegateEPackageAdapter extends AdapterImpl {


	public static DelegateEPackageAdapter getAdapter(EPackage ePackage) {
		DelegateEPackageAdapter adapter = (DelegateEPackageAdapter) EcoreUtil.getAdapter(ePackage.eAdapters(), DelegateEPackageAdapter.class);
		if (adapter == null) {
			adapter = new DelegateEPackageAdapter();
			ePackage.eAdapters().add(adapter);
		}
		return adapter;
	}

	/**
	 * The map from delegateURI to known DelegateDomain. A mapping may be
	 * defined by the delegate_domain extension point or by an entry in the
	 * global EPackage.Internal.DelegateDomain.Factory.Registry.Instance or by
	 * an entry in the local
	 * EPackage.Internal.DelegateDomain.Factory.Registry.class ResourceSetImpl
	 * registry.
	 */
	protected Map<String, DelegateDomain> delegateDomainMap = null;

	/**
	 * The map from behaviour name to corresponding DelegateDomain. This is
	 * defined by an http://www.eclipse.org/emf/2002/Ecore EPackage annotation
	 * with the behaviour name as a key and the delegateURIs as a comma
	 * separated list.
	 */
	protected Map<String, List<DelegateDomain>> delegatedBehaviorMap = null;

	protected DelegateDomain createDelegateDomain(String delegateURI) {
		EPackage ePackage = getTarget();
		DelegateDomain.Factory.Registry registry = DelegateResourceSetAdapter.getRegistry(
			ePackage, DelegateDomain.Factory.Registry.class, DelegateDomain.Factory.Registry.INSTANCE);
		DelegateDomain.Factory factory = registry.getFactory(delegateURI);
		if (factory == null) {
			factory = OCLDelegateDomainFactory.INSTANCE;
		}
		return factory.createDelegateDomain(delegateURI, ePackage);
	}

	public DelegateDomain getDelegateDomain(String delegateURI) {
		if (delegateDomainMap == null) {
			getDelegateDomains();
		}
		return delegateDomainMap.get(delegateURI);
	}

	public Map<String, DelegateDomain> getDelegateDomains() {
		if (delegateDomainMap == null) {
			delegatedBehaviorMap = new HashMap<String, List<DelegateDomain>>();
			delegateDomainMap = new HashMap<String, DelegateDomain>();
			EPackage ePackage = getTarget();
			EAnnotation eAnnotation = ePackage.getEAnnotation(EcorePackage.eNS_URI);
			if (eAnnotation != null) {
				for (DelegatedBehavior<?, ?, ?> delegatedBehavior : AbstractDelegatedBehavior.getDelegatedBehaviors()) {
					String behaviorName = delegatedBehavior.getName();
					String delegateURIs = eAnnotation.getDetails().get(behaviorName);
					if (delegateURIs != null) {
						for (StringTokenizer stringTokenizer = new StringTokenizer(delegateURIs); stringTokenizer.hasMoreTokens();) {
							String delegateURI = stringTokenizer.nextToken();
							initializeDelegatedBehavior(delegateURI, delegatedBehavior);
						}
					}
				}
			}
		}
		return delegateDomainMap;
	}

	public List<DelegateDomain> getDelegateDomains(DelegatedBehavior<?, ?, ?> delegatedBehavior) {
		if (delegatedBehaviorMap == null) {
			getDelegateDomains();
		}
		List<DelegateDomain> list = delegatedBehaviorMap.get(delegatedBehavior.getName());
		if (list != null) {
			return list;
		} else {
			return Collections.emptyList();
		}
	}

	@Override
	public EPackage getTarget() {
		return (EPackage) super.getTarget();
	}

	private void initializeDelegatedBehavior(String delegateURI, DelegatedBehavior<?, ?, ?> delegatedBehavior) {
		String behaviorName = delegatedBehavior.getName();
		synchronized (delegateDomainMap) {
			DelegateDomain delegateDomain = delegateDomainMap.get(delegateURI);
			if (delegateDomain == null) {
				delegateDomain = createDelegateDomain(delegateURI);
				delegateDomainMap.put(delegateURI, delegateDomain);
			}
			List<DelegateDomain> delegateBehaviorList = delegatedBehaviorMap.get(behaviorName);
			if (delegateBehaviorList == null) {
				delegateBehaviorList = new ArrayList<DelegateDomain>();
				delegatedBehaviorMap.put(behaviorName, delegateBehaviorList);
			}
			if (!delegateBehaviorList.contains(delegateDomain)) {
				delegateBehaviorList.add(delegateDomain);
			}
		}
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == DelegateEPackageAdapter.class;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		EPackage resourceSet = (EPackage) newTarget;
		super.setTarget(resourceSet);
	}

	public void unloadDelegates() {
		if (delegateDomainMap != null) {
			List<DelegateDomain> delegateDomains;
			synchronized (delegateDomainMap) {
				delegateDomains = new ArrayList<DelegateDomain>(delegateDomainMap.values());
			}
			for (DelegateDomain delegateDomain : delegateDomains) {
				delegateDomain.dispose();
			}
		}
	}
}
