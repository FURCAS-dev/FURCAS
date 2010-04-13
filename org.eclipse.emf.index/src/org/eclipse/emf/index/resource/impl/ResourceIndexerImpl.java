/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.resource.impl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.index.EReferenceDescriptor;
import org.eclipse.emf.index.internal.LogFacade;
import org.eclipse.emf.index.resource.IndexFeeder;
import org.eclipse.emf.index.resource.ResourceIndexer;

/**
 * @author Jan K�hnlein - Initial contribution and API
 */
public class ResourceIndexerImpl implements ResourceIndexer {

	public void resourceChanged(URI resourceURI, IndexFeeder indexFeeder) {
		Resource resource = loadResource(resourceURI);
		this.resourceChanged(resource, indexFeeder);
	}

	protected Resource loadResource(URI resourceURI) {
		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			return resourceSet.getResource(resourceURI, true);
		} catch (Exception exc) {
			LogFacade.logError("Error loading resource", exc);
			return null;
		}
	}

	public void resourceChanged(Resource resource, IndexFeeder feeder) {
		if (resource != null) {
			try {
				URIConverter uriConverter = getURIConverter(resource);
				feeder.createResourceDescriptor(resource, getResourceUserData(resource));
				for (Iterator<EObject> i = EcoreUtil.getAllProperContents(resource, false); i.hasNext();) {
					EObject element = i.next();
					if (isIndexElement(element)) {
						feeder.createEObjectDescriptor(element, getEObjectName(element), getEObjectDisplayName(element),
								getEObjectUserData(element));
						URI sourceURI = uriConverter.normalize(EcoreUtil.getURI(element));
						if (sourceURI != null) {
							for (EReference eReference : element.eClass().getEAllReferences()) {
								String eReferenceName = eReference.getName();
								if (isIndexReference(eReference, element)) {
									if (eReference.isMany()) {
										List<?> targets = (List<?>) element.eGet(eReference, false);
										for (int index = 0; index < targets.size(); ++index) {
											Object target = targets.get(index);
											createEReferenceDescriptor(feeder, uriConverter, sourceURI, eReferenceName, index, target);
										}
									} else {
										Object target = element.eGet(eReference, false);
										createEReferenceDescriptor(feeder, uriConverter, sourceURI, eReferenceName,
												EReferenceDescriptor.NO_INDEX, target);
									}
								}
							}
						}
					}
				}
			} catch (Exception exc) {
				LogFacade.logError("Error indexing resource " + resource.getURI(), exc);
			}
		}
	}

	protected URIConverter getURIConverter(Resource resource) {
		ResourceSet resourceSet = resource.getResourceSet();
		return (resourceSet != null) ? resourceSet.getURIConverter() : URIConverter.INSTANCE;
	}

	public void resourceDeleted(URI resourceURI, IndexFeeder feeder) {
		try {
			feeder.deleteResourceDescriptor(resourceURI);
		} catch (Exception exc) {
			LogFacade.logError("Error deleting resource from index " + resourceURI, exc);
		}
	}

	protected void createEReferenceDescriptor(IndexFeeder feeder, URIConverter uriConverter, URI sourceURI, String eReferenceName,
			int index, Object target) {
		if (target instanceof EObject) {
			URI targetURI = uriConverter.normalize(EcoreUtil.getURI((EObject) target));
			if (targetURI != null) {
				feeder.createEReferenceDescriptor(sourceURI, eReferenceName, index, targetURI);
			}
		}
	}

	protected Map<String, Serializable> getResourceUserData(Resource resource) {
		return null;
	}

	protected boolean isIndexElement(EObject element) {
		return true;
	}

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

	protected String getEObjectDisplayName(EObject eObject) {
		String displayName = getEObjectName(eObject);
		if (displayName == null)
			displayName = eObject.eResource().getURIFragment(eObject);
		return displayName;
	}

	protected Map<String, Serializable> getEObjectUserData(EObject eObject) {
		return null;
	}

	protected boolean isIndexReference(EReference eReference, EObject element) {
		return !eReference.isContainment() && !eReference.isDerived() && element.eIsSet(eReference);
	}

}
