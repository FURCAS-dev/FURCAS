/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.ecore.opposites;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.ocl.ecore.EcoreEnvironment;
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
 * @since 3.0
 * 
 */
public class DefaultOppositeEndFinder
		implements OppositeEndFinder {

	Logger logger = Logger.getLogger(DefaultOppositeEndFinder.class.getName());

	private final EPackage.Registry registry;

	/**
	 * A cache based on the {@link #registry} that is lazily initialized and
	 * upon access cross-checked for the arrival of new packages in the
	 * {@link #registry registry}. New packages are scanned for
	 * {@link EReference}s that contain a standard {@link EAnnotation
	 * annotation} with source
	 * {@link EcoreEnvironment#PROPERTY_OPPOSITE_ROLE_NAME_KEY}. The classes
	 * that are the {@link ETypedElement#getEType() type} of the reference are
	 * stored as key of this map. The value is a map that for each annotation of
	 * such a reference maps the name stored in the annotation to the forward
	 * reference annotated with that opposite name. As there may be multiple
	 * references using the same opposite name, a set is used. This allows the
	 * finder to identify ambiguities.
	 */
	private Map<EClass, Map<String, Set<EReference>>> oppositeCache;

	/**
	 * Caches the subclasses of all classes held by the Ecore package registry
	 */
	private Map<EClass, Set<EClass>> subclasses;

	/**
	 * remembers which packages from the {@link #registry} have already been
	 * cached in {@link #oppositeCache}.
	 */
	private Set<EPackage> cachedPackages;

	private static DefaultOppositeEndFinder instance;

	public static DefaultOppositeEndFinder getInstance() {
		if (instance == null) {
			instance = new DefaultOppositeEndFinder();
		}
		return instance;
	}

	protected DefaultOppositeEndFinder() {
		this(EPackage.Registry.INSTANCE);
	}

	public DefaultOppositeEndFinder(EPackage.Registry registry) {
		this.registry = registry;
		cachedPackages = new HashSet<EPackage>();
		subclasses = new HashMap<EClass, Set<EClass>>();
		oppositeCache = new HashMap<EClass, Map<String, Set<EReference>>>();
	}

	public void findOppositeEnds(EClassifier classifier, String name,
			List<EStructuralFeature> ends) {
		if (classifier instanceof EClass) {
			EClass eClass = (EClass) classifier;
			updateOppositeCache();
			Map<String, Set<EReference>> oppositesOnEClass = oppositeCache
				.get(eClass);
			if (oppositesOnEClass != null
				&& oppositesOnEClass.containsKey(name)) {
				Set<EReference> references = oppositesOnEClass.get(name);
				for (EReference ref : references) {
					ends.add(ref);
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

	public Map<String, EStructuralFeature> getAllOppositeEnds(
			EClassifier classifier) {
		Map<String, EStructuralFeature> result = new HashMap<String, EStructuralFeature>();
		if (classifier instanceof EClass) {
			EClass eClass = (EClass) classifier;
			updateOppositeCache();
			Map<String, Set<EReference>> oppositesOnEClass = oppositeCache
				.get(eClass);
			if (oppositesOnEClass != null && !oppositesOnEClass.isEmpty()) {
				for (String oppositeName : oppositesOnEClass.keySet()) {
					Set<EReference> refs = oppositesOnEClass.get(oppositeName);
					if (refs.size() > 0) {
						result.put(oppositeName, refs.iterator().next());
					}
				}
			}
			// add all inherited opposite property definitions
			for (EClassifier sup : eClass.getESuperTypes()) {
				Map<String, EStructuralFeature> supOppositeEnds = getAllOppositeEnds(sup);
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
		Set<String> registryKeys = new HashSet<String>(registry.keySet()); // avoid
																			// concurrent
																			// modifications
		for (String packageUri : registryKeys) {
			try {
				EPackage ePackage = registry.getEPackage(packageUri);
				if (!cachedPackages.contains(ePackage)) {
					cachedPackages.add(ePackage);
					cachePackage(ePackage);
				}
			} catch (Exception e) {
				// problem resolving the packageUri into an EPackage; could be
				// that the package class
				// doesn't exist in generated form; ignore those for now
				// (although it should somehow
				// be possible to instantiate this package dynamically TODO
				logger
					.warning("couldn't resolve Ecore package with URI " + packageUri + ": " + e.getMessage()); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}

	private void cachePackage(EPackage ePackage) {
		for (EClassifier c : ePackage.getEClassifiers()) {
			if (c instanceof EClass) {
				cacheSubclassRelations((EClass) c);
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

	private void cacheSubclassRelations(EClass c) {
		for (EClass sup : c.getESuperTypes()) {
			cacheSubclassForSuperclass(c, sup);
		}
	}

	private void cacheSubclassForSuperclass(EClass sub, EClass sup) {
		Set<EClass> subclassesOfSup = subclasses.get(sup);
		if (subclassesOfSup == null) {
			subclassesOfSup = new HashSet<EClass>();
			subclasses.put(sup, subclassesOfSup);
		}
		subclassesOfSup.add(sub);
		for (EClass supsup : sup.getESuperTypes()) {
			cacheSubclassForSuperclass(sub, supsup);
		}
	}

	private void cache(EClass c, String oppositeName, EReference ref) {
		Map<String, Set<EReference>> map = oppositeCache.get(c);
		if (map == null) {
			map = new HashMap<String, Set<EReference>>();
			oppositeCache.put(c, map);
		}
		Set<EReference> set = map.get(oppositeName);
		if (set == null) {
			set = new HashSet<EReference>();
			map.put(oppositeName, set);
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
				logger
					.warning("Trying to reverse-navigate reference of " + target //$NON-NLS-1$
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

	public Collection<EClass> getAllSubclasses(EClass c) {
		updateOppositeCache();
		Collection<EClass> result = subclasses.get(c);
		if (result == null) {
			result = Collections.emptySet();
		} else {
			result = Collections.unmodifiableCollection(result);
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
