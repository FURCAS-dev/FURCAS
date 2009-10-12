/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.internal.shared;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.internal.index.IndexQueryService;

public class EmfHelper {

	ResourceSet rs;

	Index index;

	public Index getIndex() {
		return index;
	}

	public EmfHelper(QueryContext context, Index index) {
		this.rs = context.getResourceSet();
		this.index = index;
	}

	public URI createUri(String uriString) {

		return URI.createURI(uriString);
	}

	public EClass getTypeElement(URI uri) {

		return (EClass) this.getElement(uri); // FIXME check if URI is really a
		// type
	}

	public EObject getElement(URI uri) {

		return this.rs.getEObject(uri, true);
	}

	public EReference getReference(URI uri) {

		return (EReference) this.rs.getEObject(uri, true);
	}

	public Collection<EClass> getAllSubtypes(EClass typeAsMofClass) {

		return IndexQueryService.getAllSubtypes(this.index, typeAsMofClass);
	}

	public EStructuralFeature getFeatureByName(EClass mofClass, String attrName) {

		return mofClass.getEStructuralFeature(attrName);
	}

	public boolean existsResource(URI resource) {
		// boolean b = this.rs.getResource(resource, true) != null;
		// return this.rs.getResource(resource, true) != null;
		return this.rs.getResource(resource, false) != null || this.rs.getURIConverter().exists(resource, null);
	}

	public Resource getResource(URI resource) {

		return this.rs.getResource(resource, true);
	}

	public List<Resource> getLoadedResources() {

		List<Resource> result = new ArrayList<Resource>();
		for (Resource resource : this.rs.getResources()) {
			if (resource.isLoaded()) {
				result.add(resource);
			}
		}
		return result;
	}

	public List<EObject> getElementsInResource(Resource mp) {

		List<EObject> result = new ArrayList<EObject>();
		EObject object = null;
		for (TreeIterator<EObject> it = EcoreUtil.getAllProperContents(mp, false); it.hasNext();) {
			if ((object = it.next()) instanceof EObject && !object.eIsProxy()) {
				result.add(object);
			}
		}
		return result;
	}

	public List<EObject> getReferringElementsWithTypeAndInScope(final EObject fromObject, final EReference endAndMetaObject,
			final Set<URI> priScope, final Set<URI> mrisOfTypes, final Set<URI> elements) {

		return new UsageCrossReferencer(this.rs) {

			@Override
			protected boolean crossReference(EObject object, EReference reference, EObject crossReferencedEObject) {

				if (crossReferencedEObject.equals(fromObject) && reference.equals(endAndMetaObject) && // 
						(mrisOfTypes == null || mrisOfTypes.isEmpty() || mrisOfTypes.contains(EcoreUtil.getURI(object.eClass()))) && //
						(elements == null || elements.isEmpty() || elements.contains(EcoreUtil.getURI(object))) && //  
						priScope.contains(object.eResource().getURI())) {
					return true;
				}
				return false;
			}

			protected void handleCrossReference(EObject eObject) {
				InternalEObject internalEObject = (InternalEObject) eObject;
				EList<EReference> allReferences = internalEObject.eClass().getEAllReferences();

				if (allReferences != null) {
					for (EReference ref : allReferences) {
						Object get = internalEObject.eGet(ref, true);
						if (get == null) {
							continue;
						} else if (get instanceof EObject) {
							this.checkAndAddElement(internalEObject, ref, (EObject) get);
						} else if (get instanceof EList) {
							for (EObject eObj : (EList<EObject>) get) {
								if (eObj.eIsProxy()) {
									eObj = EcoreUtil.resolve(eObj, EmfHelper.this.rs);
								}
								this.checkAndAddElement(internalEObject, ref, eObj);
							}
						}
					}
				}
			}

			private void checkAndAddElement(InternalEObject from, EReference eReference, EObject crossReferencedEObject) {
				if (this.crossReference(from, eReference, crossReferencedEObject)) {
					this.add(from, eReference, crossReferencedEObject);
				}
			}

			public List<EObject> getReferringElements(EObject object) {

				List<EObject> result = new ArrayList<EObject>();
				Collection<Setting> findUsage = this.findUsage(object);
				for (Setting setting : findUsage) {
					result.add(setting.getEObject());
				}
				return result;
			}
		}.getReferringElements(fromObject);
	}

	public EObject resolve(EObject oppositeEObject) {

		return EcoreUtil.resolve(oppositeEObject, this.rs);
	}
}
