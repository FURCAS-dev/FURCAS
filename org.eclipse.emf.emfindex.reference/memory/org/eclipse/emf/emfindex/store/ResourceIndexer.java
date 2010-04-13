/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.store;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * A helper class for indexing the contents of a resource.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public class ResourceIndexer {

	public void resourceChanged(URI resourceURI, IndexUpdater updater) {
		Resource resource = loadResource(resourceURI);
		resourceChanged(resource, updater);
	}

	public void resourceChanged(Resource resource, IndexUpdater updater) {
		URIConverter uriConverter = getURIConverter(resource);
		URI normalizedURI = uriConverter.normalize(resource.getURI());
		createResourceDescriptor(resource, updater, normalizedURI, uriConverter);
		createEObjectDescriptors(resource, updater, normalizedURI, uriConverter);
		createEReferenceDescriptors(resource, updater, normalizedURI, uriConverter);
	}

	public void resourceDeleted(URI resourceURI, IndexUpdater updater) {
		updater.deleteResource(resourceURI);
	}

	public void createResourceDescriptor(Resource resource, IndexUpdater updater, URI resourceURI,
			URIConverter uriConverter) {
		// delete everything stored in the existing resource descriptor
		updater.deleteResource(resourceURI);
		updater.createOrUpdateResource(null, resourceURI, System.currentTimeMillis(), userData(resource));
	}

	public void createEObjectDescriptors(Resource resource, IndexUpdater updater, URI resourceURI,
			URIConverter uriConverter) {
		recursivelyCreateEObjectDescriptors(resource, resource.getContents(), updater, resourceURI);
	}

	public void createEReferenceDescriptors(Resource resource, IndexUpdater updater, URI resourceURI,
			URIConverter uriConverter) {
		recursivelyCreateEReferenceDescriptors(resource, resource.getContents(), updater, uriConverter, resourceURI);
	}

	protected Resource loadResource(URI resourceURI) {
		ResourceSet resourceSet = new ResourceSetImpl();
		return resourceSet.getResource(resourceURI, true);
	}

	private void recursivelyCreateEObjectDescriptors(Resource resource, EList<EObject> contents, IndexUpdater updater,
			URI resourceURI) {
		for (EObject eObject : contents) {
			if (isIndexElement(eObject, resource)) {
				String fragment = resource.getURIFragment(eObject);
				String name = getEObjectName(eObject);
				EClass eClass = eObject.eClass();
				Map<String, String> userData = userData(eObject);
				updater.createOrUpdateEObject(resourceURI, fragment, name, eClass, userData);
			}
			if (isIndexChildren(eObject, resource)) {
				recursivelyCreateEObjectDescriptors(resource, eObject.eContents(), updater, resourceURI);
			}
		}
	}

	private void recursivelyCreateEReferenceDescriptors(Resource resource, EList<EObject> contents,
			IndexUpdater updater, URIConverter uriConverter, URI resourceURI) {
		for (EObject eObject : contents) {
			String sourceFragment = resource.getURIFragment(eObject);
			if (isIndexReferences(eObject, resource)) {
				for (EReference eReference : eObject.eClass().getEAllReferences()) {
					if (isIndexReference(eReference, eObject)) {
						if (eReference.isMany()) {
							List<?> targets = (List<?>) eObject.eGet(eReference, false);
							for (int index = 0; index < targets.size(); ++index) {
								Object target;
								if (targets instanceof BasicEList<?>) {
									target = ((BasicEList<?>) targets).basicGet(index);
								} else {
									target = targets.get(index);
								}
								createEReferenceDescriptor(sourceFragment, eObject, eReference, target, updater,
										resourceURI);
							}
						} else {
							Object target = eObject.eGet(eReference, false);
							createEReferenceDescriptor(sourceFragment, eObject, eReference, target, updater,
									resourceURI);
						}
					}
				}
			}
			if (isIndexChildren(eObject, resource)) {
				recursivelyCreateEReferenceDescriptors(resource, eObject.eContents(), updater, uriConverter,
						resourceURI);
			}
		}
	}

	private void createEReferenceDescriptor(String sourceFragment, EObject eObject, EReference eReference,
			Object target, IndexUpdater updater, URI resourceURI) {
		if (target instanceof EObject) {
			URI targetFragmentURI = EcoreUtil.getURI((EObject) target);
			updater.createOrUpdateEReference(resourceURI, sourceFragment, targetFragmentURI, eReference, userData(
					eObject, eReference));
		}
	}

	/**
	 * Subclasses can override this method to provide a specific {@link URIConverter}.
	 */
	protected URIConverter getURIConverter(Resource resource) {
		ResourceSet resourceSet = resource.getResourceSet();
		return (resourceSet != null) ? resourceSet.getURIConverter() : URIConverter.INSTANCE;
	}

	/**
	 * Subclasses can override this method to extract userData from the {@link Resource} that is added to the
	 * {@link ResourceDescriptor}.
	 */
	protected Map<String, String> userData(Resource resource) {
		return null;
	}

	/**
	 * Subclasses can override this method to extract userData from the {@link EObject} that is added to the
	 * {@link EObjectDescriptor}.
	 */
	protected Map<String, String> userData(EObject eObject) {
		return null;
	}

	/**
	 * Subclasses can override this method to extract userData from the {@link EReference} value of the {@link EObject}
	 * that is added to the {@link EReferenceDescriptor}.
	 */
	protected Map<String, String> userData(EObject eObject, EReference eReference) {
		return null;
	}

	/**
	 * Subclasses can override this method to extract the name form an {@link EObject}.
	 */
	@SuppressWarnings("unchecked")
	protected String getEObjectName(EObject eObject) {
		EStructuralFeature nameFeature = eObject.eClass().getEStructuralFeature("name");
		if (nameFeature != null && nameFeature.getEType() instanceof EDataType) {
			if (!nameFeature.isMany()) {
				Object nameFeatureValue = eObject.eGet(nameFeature);
				return (nameFeatureValue == null) ? null : nameFeatureValue.toString();
			} else {
				List names = (List) eObject.eGet(nameFeature);
				StringBuilder b = new StringBuilder();
				for (Iterator nameIter = names.iterator(); nameIter.hasNext();) {
					b.append(nameIter.next().toString());
				}
				return b.toString();
			}
		}
		return null;
	}

	/**
	 * Subclasses can override this method to decide if an {@link EObject} should be indexed.
	 */
	protected boolean isIndexElement(EObject eObject, Resource resource) {
		return eObject.eResource() == resource;
	}

	/**
	 * Subclasses can override this method to decide if the {@link EReference}s of an {@link EObject} should be indexed.
	 */
	protected boolean isIndexReferences(EObject eObject, Resource resource) {
		return true;
	}

	/**
	 * Subclasses can override this method to decide if an {@link EReference} of an {@link EObject} should be indexed.
	 */
	protected boolean isIndexReference(EReference eReference, EObject element) {
		return !eReference.isContainment() && !eReference.isDerived() && element.eIsSet(eReference);
	}

	/**
	 * Subclasses can override this method to decide if any children of an {@link EObject} should be indexed.
	 */
	protected boolean isIndexChildren(EObject eObject, Resource resource) {
		return true;
	}

}
