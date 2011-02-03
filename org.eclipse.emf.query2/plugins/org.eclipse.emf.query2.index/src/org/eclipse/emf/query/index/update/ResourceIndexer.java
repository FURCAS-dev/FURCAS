/*******************************************************************************
 * Copyright (c) 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query.index.update;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Indexes the resources.
 * @author Martin Strenge, SAP AG
 * 
 */
public class ResourceIndexer {

	//Static Instance of ResourceIndexer
	public static final ResourceIndexer INSTANCE = new ResourceIndexer();

	public final void resourceChanged(IndexUpdater updater, final Resource... resources) {
		Map<Object, String> typeCache = new IdentityHashMap<Object, String>();
		Map<Resource, URI> resourceCache = new IdentityHashMap<Resource, URI>();
		//for each resource, update the existing indices
		for (Resource resource : resources) {
			if (resource != null) {
				Map<Object, String> objectCache = new IdentityHashMap<Object, String>();
				ResourceSet resourceSet = resource.getResourceSet();
				URIConverter uriConverter = (resourceSet != null) ? resourceSet.getURIConverter() : URIConverter.INSTANCE;
				URI resourceUri;
				if ((resourceUri = resourceCache.get(resource)) == null) {
					resourceCache.put(resource, resourceUri = uriConverter.normalize(resource.getURI()));
				}

				updater.insertResource(resourceUri, this.getVersion(resource), getResourceUserData(resource));

				for (EObject child : resource.getContents()) {
					addContent(updater, uriConverter, resourceCache, typeCache, objectCache, resource, resourceUri, child);
				}
			}
		}
	}

	/**
	 * Adds an EObject to a resource and updates the indices.
	 * 
	 * @param updater Instance of {@link IndexUpdater}
	 * @param uriConverter The converter used to normalize URIs and to open streams
	 * @param resourceCache Stores the resource and uri pair in form of {@link HashMap}
	 * @param typeCache Stores the type and type uri pair in form of {@link HashMap}
	 * @param objectCache Stores the {@link EObject} and fragment in form of {@link HashMap}
	 * @param resource The resource to which the {@link EObject} has to be added.
	 * @param resourceUri uri of the resource to which {@link EObject} has to be added
	 * @param element The {@link EObject} to be added
	 */
	private void addContent(IndexUpdater updater, URIConverter uriConverter, Map<Resource, URI> resourceCache,
			Map<Object, String> typeCache, Map<Object, String> objectCache, Resource resource, URI resourceUri, EObject element) {
		//Make an entry in the Object cache and the local type cache
		if (element.eResource() == resource && isIndexElement(element)) {

			String fragment;
			if ((fragment = objectCache.get(element)) == null) {
				objectCache.put(element, fragment = resource.getURIFragment(element));
			}
			EClass type = element.eClass();
			String typeUri;
			if ((typeUri = typeCache.get(type)) == null) {
				typeCache.put(type, typeUri = EcoreUtil.getURI(type).toString());
			}
			//update the indices.
			updater.insertEObject(resourceUri, fragment, typeUri, getEObjectName(element), getEObjectUserData(element));
			
			//update the references
			for (EReference eReference : element.eClass().getEAllReferences()) {
				if (isIndexReference(eReference, element)) {
					String refString;
					if ((refString = typeCache.get(eReference)) == null) {
						typeCache.put(eReference, refString = EcoreUtil.getURI(eReference).toString());
					}

					if (eReference.isMany()) {
						Object eGet = element.eGet(eReference, false);
						if (eGet instanceof BasicEList) {
							BasicEList<?> targets = (BasicEList<?>) eGet;
							Object[] data = targets.data();
							for (int idx = 0, n = targets.size(); idx < n; ++idx) {
								Object target = data[idx];
								createEReferenceDescriptor(updater, resourceCache, objectCache, uriConverter, resourceUri, fragment,
										refString, target);
							}
						} else {
							List<?> targets = (List<?>) eGet;
							for (int idx = 0, n = targets.size(); idx < n; ++idx) {
								Object target = targets.get(idx);
								createEReferenceDescriptor(updater, resourceCache, objectCache, uriConverter, resourceUri, fragment,
										refString, target);
							}
						}
					} else {
						Object target = element.eGet(eReference, false);
						createEReferenceDescriptor(updater, resourceCache, objectCache, uriConverter, resourceUri, fragment, refString,
								target);
					}
				}
			}
			for (EObject child : element.eContents()) {
				this.addContent(updater, uriConverter, resourceCache, typeCache, objectCache, resource, resourceUri, child);
			}
		}
	}

	/**
	 * Creates a reference and updates the indices.
	 * @param updater Instance of {@link IndexUpdater}
	 * @param resourceCache Stores the resource and uri pair in form of {@link HashMap}
	 * @param objectCache Stores the {@link EObject} and fragment in form of {@link HashMap}
	 * @param uriConverter The converter used to normalize URIs and to open streams
	 * @param srcResourceUri uri of the resource containing source Eobject
	 * @param sourceFragment fragment of source Eobject
	 * @param reference type uri
	 * @param target fragment of the target Eobject
	 */
	private void createEReferenceDescriptor(IndexUpdater updater, Map<Resource, URI> resourceCache, Map<Object, String> objectCache,
			URIConverter uriConverter, URI srcResourceUri, String sourceFragment, String reference, Object target) {
		if (target instanceof EObject) {
			URI resUri;
			Resource eResource = ((EObject) target).eResource();
			String uriFragment;
			if (eResource != null) {
				if ((resUri = resourceCache.get(eResource)) == null) {
					resourceCache.put(eResource, resUri = uriConverter.normalize(eResource.getURI()));
				}
				if ((uriFragment = objectCache.get(target)) == null) {
					objectCache.put(target, uriFragment = eResource.getURIFragment((EObject) target));
				}
			} else {
				URI normalizedUri = uriConverter.normalize(EcoreUtil.getURI((EObject) target));
				uriFragment = normalizedUri.fragment();
				resUri = normalizedUri.trimFragment();
			}
			updater.insertEReference(srcResourceUri, sourceFragment, reference, resUri, uriFragment);
		}
	}

	protected boolean isIndexReference(EReference reference, EObject element) {
		return /* !reference.isContainment() && */!reference.isDerived() && element.eIsSet(reference);
	}

	protected boolean isIndexElement(EObject element) {
		return true;
	}

	/**
	 * @param resource {@link Resource}
	 * @return time stamp of the resource
	 */
	protected long getVersion(Resource resource) {
		return resource.getTimeStamp();
	}

	protected Map<String, String> getEObjectUserData(EObject element) {
		return null;
	}

	/**
	 * Retrieves the name of an EObject
	 * @param element {@link EObject}
	 * @return name of the EObject
	 */
	protected String getEObjectName(EObject element) {
		EStructuralFeature nameFeature = element.eClass().getEStructuralFeature("name"); //$NON-NLS-1$
		if (nameFeature != null && nameFeature.getEType() instanceof EDataType) {
			if (!nameFeature.isMany()) {
				Object nameFeatureValue = element.eGet(nameFeature);
				return (nameFeatureValue == null) ? null : nameFeatureValue.toString();
			} else {
				List<?> names = (List<?>) element.eGet(nameFeature);
				StringBuilder b = new StringBuilder();
				for (Iterator<?> nameIter = names.iterator(); nameIter.hasNext();) {
					b.append(nameIter.next().toString());
				}
				return b.toString();
			}
		}
		return null;
	}

	protected Map<String, String> getResourceUserData(Resource res) {
		return null;
	}
}
