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
 * $Id: DefaultOppositeEndFinder.java,v 1.1 2010/12/15 17:32:44 ewillink Exp $
 */
package org.eclipse.ocl.ecore.opposites;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.internal.OCLEcorePlugin;
import org.eclipse.ocl.ecore.internal.OCLStatusCodes;
import org.eclipse.ocl.util.CollectionUtil;

/**
 * Opposite references declared by the annotation detail
 * {@link EcoreEnvironment#PROPERTY_OPPOSITE_ROLE_NAME_KEY} on an
 * {@link EAnnotation} with {@link EAnnotation#getSource() source}
 * {@link EMOFExtendedMetaData#EMOF_PACKAGE_NS_URI_2_0} are retrieved by
 * scanning and caching the Ecore packages registered in the {@link #registry}
 * which has to be passed to the constructor. Upon each request, the
 * implementation checks for Ecore packages that were added to the registry and
 * need caching.
 * <p>
 * 
 * Navigation across those references is performed either by
 * {@link EObject#eContainer()} in case of containment references or by looking
 * for an {@link ECrossReferenceAdapter} along the containment hierarchy of the
 * source object from which to start the navigation. Only if such an adapter is
 * registered along the composition/containment hierarchy can the navigation be
 * performed successfully. Note also that this will only consider references
 * that have been currently loaded which can give rather random results. For
 * more predictable results, an implementation should be used that relies on a
 * well-defined query scope and a corresponding query engine.
 * 
 * @author Axel Uhl
 * @since 3.1
 * 
 */
public class DefaultOppositeEndFinder
		implements OppositeEndFinder {

	private final EPackage.Registry registry;

	/**
	 * Attaches to an {@link EPackage} to indicate that the {@link EReference}s defined by that
	 * package and defining a "hidden" opposite have been cached as {@link OppositeEndCacheAdapter}
	 * adapters in the referenced classes.
	 */
	private class PackagesHiddenOppositesHaveBeenCached extends AdapterImpl {}

	/**
	 * Attaches to {@link EClass}es to store the "hidden" opposite ends
	 */
	private class OppositeEndCacheAdapter extends AdapterImpl {
		private final Map<String, Set<EReference>> hiddenOpposites = new HashMap<String, Set<EReference>>();
		
		public Set<EReference> get(String oppositeEndName) {
			return hiddenOpposites.get(oppositeEndName);
		}
		
		public void add(String oppositeEndName, EReference ref) {
			Set<EReference> refSet = hiddenOpposites.get(oppositeEndName);
			if (refSet == null) {
				refSet = new HashSet<EReference>();
				hiddenOpposites.put(oppositeEndName, refSet);
			}
			refSet.add(ref);
		}
		
		public Map<String, Set<EReference>> getAll() {
			return Collections.unmodifiableMap(hiddenOpposites);
		}
	}
	
	public static DefaultOppositeEndFinder getInstance() {
		return getInstance(EPackage.Registry.INSTANCE);
	}
	
	public static DefaultOppositeEndFinder getInstance(EPackage.Registry registry) {
		DefaultOppositeEndFinder result = new DefaultOppositeEndFinder(registry);
		return result;
	}

	protected DefaultOppositeEndFinder(EPackage.Registry registry) {
		this.registry = registry;
	}

	public void findOppositeEnds(EClassifier classifier, String name,
			List<EReference> ends) {
		if (classifier instanceof EClass) {
			EClass eClass = (EClass) classifier;
			updateOppositeCache();
			OppositeEndCacheAdapter oppositesOnEClass = getOppositeCache(eClass);
			if (oppositesOnEClass != null) {
				Set<EReference> refs = oppositesOnEClass.get(name);
				if (refs != null) {
					Set<EReference> references = oppositesOnEClass.get(name);
					for (EReference ref : references) {
						ends.add(ref);
					}
				}
			}
			// search in superclasses if nothing found yet
			if (ends.isEmpty()) {
				for (EClassifier sup : eClass.getESuperTypes()) {
					findOppositeEnds(sup, name, ends);
				}
			}
		}
	}

	public Map<String, EReference> getAllOppositeEnds(
			EClassifier classifier) {
		Map<String, EReference> result = new HashMap<String, EReference>();
		if (classifier instanceof EClass) {
			EClass eClass = (EClass) classifier;
			updateOppositeCache();
			OppositeEndCacheAdapter oppositesOnEClass = getOppositeCache(eClass);
			if (oppositesOnEClass != null) {
				Map<String, Set<EReference>> opposites = oppositesOnEClass.getAll();
				for (String oppositeName : opposites.keySet()) {
					Set<EReference> refs = opposites.get(oppositeName);
					if (refs.size() > 0) {
						result.put(oppositeName, refs.iterator().next());
					}
				}
			}
			// add all inherited opposite property definitions
			for (EClassifier sup : eClass.getESuperTypes()) {
				Map<String, EReference> supOppositeEnds = getAllOppositeEnds(sup);
				for (String supOppositeEndName : supOppositeEnds.keySet()) {
					// add superclass's opposite only if not already found in
					// subclass; this implements the "subclass definitions override"
					// behavior
					if (!result.containsKey(supOppositeEndName)) {
						result.put(supOppositeEndName,
							supOppositeEnds.get(supOppositeEndName));
					}
				}
			}
		}
		return result;
	}

	private void updateOppositeCache() {
		Set<String> registryKeys = new HashSet<String>(registry.keySet()); // avoid concurrent modifications
		for (String packageUri : registryKeys) {
			try {
				// This loads all packages in the registry; if you want a smarter implementation,
				// please consider using a smarter implementation; this is a "default" implementation only.
				EPackage ePackage = registry.getEPackage(packageUri);
				boolean packageIsAlreadyCached = false;
				// avoid multiple threads interfering during package's hidden opposites caching
				synchronized (ePackage) {
					for (Adapter a : ePackage.eAdapters()) {
						if (a instanceof PackagesHiddenOppositesHaveBeenCached) {
							packageIsAlreadyCached = true;
							break;
						}
					}
					if (!packageIsAlreadyCached) {
						cachePackage(ePackage);
					}
				}
			} catch (Exception e) {
				// TODO problem resolving the packageUri into an EPackage; could be
				// that the package class doesn't exist in generated form;
				// ignore those for now (although it should somehow be possible
				// to instantiate this package dynamically)
				OCLEcorePlugin.warning(OCLStatusCodes.IGNORED_EXCEPTION_WARNING,
					"couldn't resolve Ecore package with URI " + packageUri + ": " + e.getMessage(), //$NON-NLS-1$ //$NON-NLS-2$
					e);
			}
		}
	}

	private void cachePackage(EPackage ePackage) {
		ePackage.eAdapters().add(new PackagesHiddenOppositesHaveBeenCached());
		for (EClassifier c : ePackage.getEClassifiers()) {
			if (c instanceof EClass) {
				EClass eClass = (EClass) c;
				for (EReference ref : eClass.getEReferences()) {
					EAnnotation ann = ref
						.getEAnnotation(EMOFExtendedMetaData.EMOF_PACKAGE_NS_URI_2_0);
					if (ann != null) {
						String oppositeName = ann.getDetails().get(
							OppositeEndFinder.PROPERTY_OPPOSITE_ROLE_NAME_KEY);
						if (oppositeName != null) {
							cache((EClass) ref.getEType(), oppositeName, ref);
						}
					}
				}
			}
		}
	}

	private void cache(EClass c, String oppositeName, EReference ref) {
		OppositeEndCacheAdapter cache = getOppositeCache(c);
		if (cache == null) {
			cache = new OppositeEndCacheAdapter();
			c.eAdapters().add(cache);
		}
		Set<EReference> set = cache.get(oppositeName);
		if (set == null || !set.contains(ref)) {
			cache.add(oppositeName, ref);
		}
	}

	private OppositeEndCacheAdapter getOppositeCache(EClass c) {
		OppositeEndCacheAdapter adapter = null;
		for (Adapter a : c.eAdapters()) {
			if (a instanceof OppositeEndCacheAdapter) {
				adapter = (OppositeEndCacheAdapter) a;
				break;
			}
		}
		return adapter;
	}

	/**
	 * If on the <code>target</code> or any of its containers up to the
	 * {@link ResourceSet} there is a {@link ECrossReferenceAdapter} registered,
	 * uses it for navigating <code>property</code> in reverse. In this case, a
	 * non- <code>null</code> collection is returned which contains those
	 * {@link EObject}s on which navigating <code>property</code> leads to
	 * <code>target</code>. The "forward" scope is just whatever the
	 * {@link ECrossReferenceAdapter} sees that is expected to be registered on
	 * <code>target</code>
	 * 
	 * @param target
	 *            must be a non-<code>null</code> {@link EObject}
	 */
	public Collection<EObject> navigateOppositePropertyWithForwardScope(
			EReference property, EObject target) {
		return navigateOppositePropertyWithSymmetricScope(property, target);
	}

	public Collection<EObject> navigateOppositePropertyWithBackwardScope(
			EReference property, EObject target) {
		return navigateOppositePropertyWithSymmetricScope(property, target);
	}

	private Collection<EObject> navigateOppositePropertyWithSymmetricScope(
			EReference property, EObject target) {
		Collection<EObject> result = null;
		if (property.isContainment()) {
			EObject resultCandidate = target.eContainer();
			if (resultCandidate != null) {
				// first check if the container is assignment-compatible to the
				// property's owning type:
				if (property.getEContainingClass().isInstance(resultCandidate)) {
					Object propertyValue = resultCandidate.eGet(property);
					if (propertyValue == target
						|| (propertyValue instanceof Collection<?> && ((Collection<?>) propertyValue)
							.contains(target))) {
						result = Collections.singleton(resultCandidate);
					}
				}
			}
		} else {
			ECrossReferenceAdapter crossReferenceAdapter = getCrossReferenceAdapter(target);
			if (crossReferenceAdapter != null) {
				result = CollectionUtil.createNewBag();
				Collection<Setting> settings = crossReferenceAdapter
					.getInverseReferences(target);
				for (Setting setting : settings) {
					if (setting.getEStructuralFeature() == property) {
						result.add(setting.getEObject());
					}
				}
			} else {
				OCLEcorePlugin.warning(OCLStatusCodes.IGNORED_EXCEPTION_WARNING,
					"Trying to reverse-navigate reference of " + target //$NON-NLS-1$
						+ " without ECrossReferenceAdapter attached"); //$NON-NLS-1$
			}
		}
		return result;
	}

	/**
	 * Search for an {@link ECrossReferenceAdapter} up <code>target</code>'s
	 * containmeht hierarchy
	 */
	private ECrossReferenceAdapter getCrossReferenceAdapter(EObject target) {
		ECrossReferenceAdapter result = ECrossReferenceAdapter
			.getCrossReferenceAdapter(target);
		if (result == null && target.eContainer() != null) {
			result = getCrossReferenceAdapter(target.eContainer());
		}
		return result;
	}

	/**
	 * This default implementation uses an {@link AllInstancesContentAdapter} on
	 * <code>context</code>'s root context (see
	 * {@link AllInstancesContentAdapter#getInstanceForRootContextOf(Notifier)})
	 * which is created lazily if it isn't set yet. Note that for larger
	 * resource sets with many resources and elements this won't scale very well
	 * as all resources will be scanned for elements conforming to
	 * <code>cls</code>. Also, no scoping other than tracing to the root context
	 * based on <code>context</code> is performed.
	 */
	public Set<EObject> getAllInstancesSeeing(EClass cls, Notifier context) {
		return AllInstancesContentAdapter.getInstanceForRootContextOf(context)
			.allInstances(cls);
	}

	public Set<EObject> getAllInstancesSeenBy(EClass cls, Notifier context) {
		return getAllInstancesSeeing(cls, context);
	}

}
