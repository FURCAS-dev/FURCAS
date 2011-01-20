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

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
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
 * scanning and caching the Ecore packages that this opposite end finder is
 * aware of at the time of the request. The set of those packages is taken to be
 * the set of {@link EPackage}s resolved by an {@link EPackage.Registry}
 * provided to {@link #getInstance(Registry)}, or the default
 * {@link EPackage.Registry} otherwise. In particular, this won't load any Ecore
 * bundles not yet loaded.
 * <p>
 * 
 * This also means that with this implementation of the {@link OppositeEndFinder}
 * interface it is necessary to resolve a package in the registry on which this
 * opposite end finder is based before issuing a request expecting to find
 * hidden opposites from that package. This can, e.g., be triggered by calling
 * {@link EPackage.Registry#getEPackage(String)} for the package's URI.<p>
 * 
 * Navigation across those references is performed either by
 * {@link EObject#eContainer()} in case of containment references or by looking
 * for an {@link ECrossReferenceAdapter} along the containment hierarchy of the
 * source object from which to start the navigation. Only if such an adapter is
 * registered along the composition/containment hierarchy can the navigation be
 * performed successfully. Note also that this will only consider references
 * that have been currently loaded which can give rather random results. For
 * more predictable results, an implementation should be used that relies on a
 * well-defined query scope and a corresponding query engine.<p>
 * 
 * Instances of this class are cached in a {@link WeakHashMap}, keyed by the
 * {@link EPackage.Registry} object used for {@link #getInstance(Registry)}.
 * This means that if the registry gets eligible for garbage collection then
 * so will this opposite end finder.<p>
 * 
 * @author Axel Uhl
 * @since 3.1
 * 
 */
public class DefaultOppositeEndFinder
		implements OppositeEndFinder {

	private static WeakHashMap<Registry, DefaultOppositeEndFinder> instances =
		new WeakHashMap<Registry, DefaultOppositeEndFinder>();
	
	/**
	 * The set of packages for which the hidden opposites are already cached in
	 * {@link #oppositeCache}.
	 */
	private final Set<EPackage> packages;
	
	private final Map<EClass, Map<String, Set<EReference>>> oppositeCache;

	/**
	 * The package registry in which before each request the set of packages already
	 * resolved is compared to {@link #packages}. Packages that got resolved in the
	 * registry but weren't cached yet are cached before executing the request.
	 */
	private final Registry registry;

	/**
	 * Scans all packages from the default {@link EPackage.Registry} that have already been
	 * loaded. While this is convenient, please keep in mind that this may be fairly random a
	 * definition of a package set as loading of packages happens on demand. You will get more
	 * predictable results using {@link #getInstance(Set<EPackage>)}.
	 */
	public static DefaultOppositeEndFinder getInstance() {
		if (instance == null) {
			instance = new DefaultOppositeEndFinder(EPackage.Registry.INSTANCE);
	/**
	 * Scans all packages from the <code>registry</code> specified that have already been
	 * loaded. While this is convenient, please keep in mind that this may be fairly random a
	 * definition of a package set as loading of packages happens on demand. You will get more
	 * predictable results using {@link #getInstance(Set<EPackage>)}.
	 */
		DefaultOppositeEndFinder result = instances.get(registry);
			instances.put(registry, result);
		}
		return instance;
	}
	
	private Set<EPackage> getLoadedPackages() {
		for (Object key : registry.values()) {
			// if it's not a package descriptor indicating a not yet loaded package, add it
			if (key instanceof EPackage) {
				packages.add((EPackage) key);
				cachePackage((EPackage) key);
			}
		}
		return packages;
	}

	protected DefaultOppositeEndFinder(Registry registry) {
		this.registry = registry;
		this.packages = new HashSet<EPackage>();
		this.oppositeCache = new HashMap<EClass, Map<String,Set<EReference>>>();
	}

	public void findOppositeEnds(EClassifier classifier, String name,
			List<EReference> ends) {
		if (classifier instanceof EClass) {
			EClass eClass = (EClass) classifier;
			updateOppositeCache();
			Map<String, Set<EReference>> oppositesOnEClass = oppositeCache.get(eClass);
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
			Map<String, Set<EReference>> oppositesOnClass = oppositeCache.get(eClass);
			if (oppositesOnClass != null) {
				for (String oppositeName : oppositesOnClass.keySet()) {
					Set<EReference> refs = oppositesOnClass.get(oppositeName);
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

	/**
	 * Lazily initialize the opposite cache for the {@link #packages} for which this opposite
	 * end finder is responsible
	 */
	private synchronized void updateOppositeCache() {
		for (EPackage ePackage : getLoadedPackages()) {
			if (!packages.contains(ePackage)) {
				cachePackage(ePackage);
			}
		}
	}

	private void cachePackage(EPackage ePackage) {
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
		Map<String, Set<EReference>> cache = oppositeCache.get(c);
		if (cache == null) {
			cache = new HashMap<String, Set<EReference>>();
			oppositeCache.put(c, cache);
		}
		Set<EReference> set = cache.get(oppositeName);
		if (set == null) {
			set = new HashSet<EReference>();
			cache.put(oppositeName, set);
		}
		set.add(ref);
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
