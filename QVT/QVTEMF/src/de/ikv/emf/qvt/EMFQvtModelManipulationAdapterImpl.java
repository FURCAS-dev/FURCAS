/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.emf.qvt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.oslo.ocl20.bridge4emf.OclModelElementTypeImpl;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.OclModelElementType;
import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.semantics.bridge.impl.PropertyImpl;
import org.oslo.ocl20.semantics.model.types.CollectionType;
import org.oslo.ocl20.standard.lib.OclAny;
import org.oslo.ocl20.standard.lib.OclAnyModelElement;

import de.ikv.medini.qvt.QvtModelManipulationAdapter;
import de.ikv.medini.qvt.QvtProcessorImpl;
import de.ikv.medini.qvt.Trace;
import de.ikv.medini.qvt.model.qvtbase.TypedModel;

public class EMFQvtModelManipulationAdapterImpl implements QvtModelManipulationAdapter {

	private QvtProcessorImpl qvtProcessorImpl;

	public EMFQvtModelManipulationAdapterImpl(QvtProcessorImpl qvtProcessorImpl) {
		this.qvtProcessorImpl = qvtProcessorImpl;
	}

	public OclAnyModelElement createOclAnyModelElement(OclModelElementType oclModelElementType, TypedModel typedModel) {
		OclModelElementTypeImpl emfOclModelElementType = (OclModelElementTypeImpl) oclModelElementType;
		EObject newInstance = emfOclModelElementType.getImplementation().getEPackage().getEFactoryInstance().create(
		    (EClass) emfOclModelElementType.getImplementation());
		// find resource to put into !!
		EMFQvtProcessorImpl emfQvtProcessorImpl = (EMFQvtProcessorImpl) this.qvtProcessorImpl;
		emfQvtProcessorImpl.getTargetResource().getContents().add(newInstance);
		try {
			EcoreUtil.setID(newInstance, EcoreUtil.generateUUID());
		} catch (Exception e) {

		}
		return (OclAnyModelElement) this.qvtProcessorImpl.getStdLibAdapter().OclAny(newInstance);
	}

	public void setOrAddValueForFeauture(OclAnyModelElement modelElement, Property property, OclAny value) {
		EObject source = (EObject) modelElement.asJavaObject();
		Resource res = source.eResource();
		Object javaObject = value.asJavaObject();
		EStructuralFeature feature = (EStructuralFeature) property.getDelegate();
		if (!feature.isChangeable() && feature instanceof EReference && ((EReference) feature).getEOpposite() != null
		        && ((EReference) feature).getEOpposite().isChangeable() && javaObject instanceof EObject) {
			EObject x = source;
			source = (EObject) javaObject;
			javaObject = x;
			feature = ((EReference) feature).getEOpposite();
		}
		if (javaObject instanceof Integer && feature.getEType().getName().equals("ELong")) {
			javaObject = new Long((Integer) javaObject);
		}
		if (feature.isMany()) {
			List list = (List) source.eGet(feature);
			if (javaObject instanceof List) {
				list.clear();
				list.addAll((List) javaObject);
			} else {
				list.add(javaObject);
			}
		} else {
			Object oldValue = source.eGet(feature);
			Resource oldResource=null;
			if (oldValue instanceof EObject) {
				oldResource=((EObject) oldValue).eResource();		
			}
			source.eSet(feature, javaObject);
			if (oldValue instanceof EObject) {
				this.fixEmfBug((EObject) oldValue, oldResource);
			}
		}

		/*
		 * The following statements are required, perhaps due to an error in EMF (see
		 * BasicEObjectImpl.eBasicSetContainer -> eSetDirectResource(null) is never called)
		 */
		if (source.eResource() != null) {
			res = source.eResource();
		}
		this.fixEmfBug(source, res);
		if (value.asJavaObject() instanceof EObject) {
			EObject valueElement = (EObject) value.asJavaObject();
			this.fixEmfBug(valueElement, valueElement.eResource());
		}
	}

	private void fixEmfBug(EObject source, Resource res) {
		if (res != null) {
			if (source.eContainer() != null) {
				res.getContents().remove(source);
			} else {
				res.getContents().add(source);
			}
		}
	}

	public OclAny findElementInTarget(OclAny modelElement1) {
		return modelElement1;
		// EMFQvtProcessorImpl emfQvtProcessorImpl = (EMFQvtProcessorImpl) qvtProcessorImpl;
		// Iterator all = emfQvtProcessorImpl.getTargetResource().getAllContents();
		// while (all.hasNext()) {
		// // TODO ugly !!!
		// Object javaObject = modelElement1.asJavaObject();
		// if (javaObject instanceof EObject) {
		// String id = EcoreUtil.getID((EObject) javaObject);
		// if (id != null) {
		// Object currentObject = all.next();
		// if (id.equals(EcoreUtil.getID((EObject) currentObject))) {
		// return (OclAnyModelElement) qvtProcessorImpl.getStdLibAdapter().OclAny((EObject)
		// currentObject);
		// }
		// }
		// } else {
		// return modelElement1;
		// }
		// }
		// return null;
	}

	public void deleteElementInTarget(OclAny modelElement1) {
		EMFQvtProcessorImpl emfQvtProcessorImpl = (EMFQvtProcessorImpl) this.qvtProcessorImpl;
		Object javaObject = modelElement1.asJavaObject();
		if (javaObject instanceof EObject) {
			EcoreUtil.remove((EObject) javaObject);
			List allObjects = new ArrayList();
			Iterator all = emfQvtProcessorImpl.getTargetResource().getAllContents();
			while (all.hasNext()) {
				allObjects.add(all.next());
			}
			all = allObjects.iterator();
			while (all.hasNext()) {
				EObject currentObject = (EObject) all.next();
				List allStructuralFeatures = currentObject.eClass().getEAllStructuralFeatures();
				for (Iterator allStructuralFeaturesIter = allStructuralFeatures.iterator(); allStructuralFeaturesIter
				        .hasNext();) {
					EStructuralFeature currentStructuralFeature = (EStructuralFeature) allStructuralFeaturesIter.next();
					if (currentStructuralFeature.isChangeable()) {
						EMFQvtModelManipulationAdapterImpl.remove(currentObject, currentStructuralFeature, javaObject);
					}
				}
			}
		}
	}

	/**
	 * Removes the value from the feature of the object.
	 * 
	 * @param eObject
	 *            the object holding the value.
	 * @param eStructuralFeature
	 *            the feature of the object holding the value.
	 * @param value
	 *            the value to remove.
	 */
	public static void remove(EObject eObject, EStructuralFeature eStructuralFeature, Object value) {
		if (eStructuralFeature.isMany()) {
			((List) eObject.eGet(eStructuralFeature)).remove(value);
		} else {
			if (eObject.eGet(eStructuralFeature) != null && eObject.eGet(eStructuralFeature).equals(value)) {
				eObject.eUnset(eStructuralFeature);
			}
		}
	}

	public boolean isModified(OclAnyModelElement modelElement, Trace oldTrace) {
		// always return false because this is not supported by EMF repository.
		return false;
	}

	public void unsetOrRemoveValuesForFeature(OclAnyModelElement modelElement, Property property, Collection oclValues) {
		if (oclValues.isEmpty()) {
			return;
		}

		EObject source = (EObject) modelElement.asJavaObject();
		Collection javaValuesToRemove = EMFQvtModelManipulationAdapterImpl.asJavaObjects(oclValues);
		EStructuralFeature structuralFeature = (EStructuralFeature) ((PropertyImpl) property).getDelegate();

		if (property.getType() instanceof CollectionType) {
			Collection currentValues = (Collection) source.eGet(structuralFeature);
			currentValues.removeAll(javaValuesToRemove);
		}
	}

	protected static Collection asJavaObjects(Collection oclValues) {
		ArrayList result = new ArrayList();

		for (Iterator iter = oclValues.iterator(); iter.hasNext();) {
			result.add(((OclAny) iter.next()).asJavaObject());
		}

		return result;
	}

	public boolean isOpposite(Property property1, Property property2) {
		EStructuralFeature feature1 = (EStructuralFeature) property1.getDelegate();
		EStructuralFeature feature2 = (EStructuralFeature) property2.getDelegate();
		if (feature1 instanceof EReference && feature2 instanceof EReference) {
			EReference reference = (EReference) feature1;
			EReference opposite = reference.getEOpposite();
			return feature2.equals(opposite);
		}
		return false;
	}

	public boolean areAllReferencesWithin(OclAny element, Set targetElements) {
		Set javaElements = new HashSet();
		EObject eObj = (EObject) element.asJavaObject();
		for (Iterator iter = targetElements.iterator(); iter.hasNext();) {
			OclAny targetElement = (OclAny) iter.next();
			javaElements.add(targetElement.asJavaObject());
		}
		for (Object element2 : eObj.eClass().getEAllReferences()) {
			EReference ref = (EReference) element2;
			Object refTarget = eObj.eGet(ref);
			if (refTarget instanceof EList) {
				for (Iterator iterator = ((EList) refTarget).iterator(); iterator.hasNext();) {
					Object javaTarget = iterator.next();
					if (javaTarget instanceof EObject && !javaElements.contains(javaTarget)) {
						return false;
					}
				}
			} else if (refTarget instanceof EObject && !javaElements.contains(refTarget)) {
				return false;
			}
		}
		return true;
	}

	public boolean unsetOrRemoveValueForFeauture(OclAnyModelElement modelElement, Property property, OclAny value) {
		EObject source = (EObject) modelElement.asJavaObject();
		Resource res = source.eResource();
		Resource valueResource = null;
		if (value != null && value.asJavaObject() instanceof EObject) {
			EObject valueElement = (EObject) value.asJavaObject();
			valueResource = valueElement.eResource();
		}
		EStructuralFeature feature = (EStructuralFeature) property.getDelegate();
		if (value != null && value.asJavaObject() instanceof Collection) {
			return false;
		}
		try {
			if (property.getType() instanceof CollectionType) {
				List list = (List) source.eGet(feature);
				return list.remove(value.asJavaObject());
			} else {
				if (source.eGet(feature) == value.asJavaObject()) {
					source.eUnset(feature);
					return true;
				} else {
					return false;
				}
			}
		} finally {
			/*
			 * The following statements are required, perhaps due to an error in EMF (see
			 * BasicEObjectImpl.eBasicSetContainer -> eSetDirectResource(null) is never called)
			 */
			if (source.eResource() != null) {
				res = source.eResource();
			}
			this.fixEmfBug(source, res);
			if (value.asJavaObject() instanceof EObject) {
				EObject valueElement = (EObject) value.asJavaObject();
				this.fixEmfBug(valueElement, valueResource);
			}
		}

	}

	public boolean isChangeable(Property property) {
		EStructuralFeature feature = (EStructuralFeature) property.getDelegate();
		return feature.isChangeable();
	}

	public boolean isAbstract(Classifier type) {
		if (type instanceof OclModelElementTypeImpl) {
			EClassifier emfType = ((OclModelElementTypeImpl) type).getImplementation();
			return emfType instanceof EClass && ((EClass) emfType).isAbstract();
		}
		return false;
	}
}
