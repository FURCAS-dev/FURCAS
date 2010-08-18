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

package qvtjmi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ocljmi.OclModelElementTypeImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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

public class JMIQvtModelManipulationAdapterImpl implements
		QvtModelManipulationAdapter {

	private QvtProcessorImpl qvtProcessorImpl;

	public JMIQvtModelManipulationAdapterImpl(QvtProcessorImpl qvtProcessorImpl) {
		this.qvtProcessorImpl = qvtProcessorImpl;
	}

	public OclAnyModelElement createOclAnyModelElement(
			OclModelElementType oclModelElementType, TypedModel typedModel) {
		OclModelElementTypeImpl mofOclModelElementType = (OclModelElementTypeImpl) oclModelElementType;
		// TODO normal Package?
		EObject newInstance = getConnection().getJmiHelper().getRefClassForMofClass(
						(EClass) mofOclModelElementType.getImplementation())
				.refCreateInstance();
		// find resource to put into !!
		JMIQvtProcessorImpl mofQvtProcessorImpl = (JMIQvtProcessorImpl) this.qvtProcessorImpl;
		//mofQvtProcessorImpl.getTargetResource().getContents().add(newInstance)
		// ;
		addToPartition(newInstance);
		return (OclAnyModelElement) this.qvtProcessorImpl.getStdLibAdapter()
				.OclAny(newInstance);
	}

	private ResourceSet getConnection() {
		return ((JMIQvtProcessorImpl) this.qvtProcessorImpl)
				.getConnection();
	}

	private void addToPartition(EObject newInstance) {
		((Resource)this.qvtProcessorImpl.getTargetModel()).assignElementIncludingChildren(newInstance);
	}

	public void setOrAddValueForFeauture(OclAnyModelElement modelElement,
			Property property, OclAny value) {
		EObject source = (EObject) modelElement.asJavaObject();
		Resource res = PartitionHelper.getPartition(source);
		Object javaObject = value.asJavaObject();
		EStructuralFeature feature = (EStructuralFeature) property.getDelegate();
		if (!feature.isChangeable() && feature instanceof EReference
				&& ((EReference) feature).getReferencedEnd().getType() != null
				&& ((EReference) feature).getReferencedEnd().isChangeable()
				&& javaObject instanceof EObject) {
			EObject x = source;
			source = (EObject) javaObject;
			javaObject = x;
			EClassifier type = ((EReference) feature)
					.getReferencedEnd().getType();
			for (Object y : type.eContents()) {
				if (y instanceof EReference) {
					if (((EReference) y).getExposedEnd().equals(
							((EReference) feature).getReferencedEnd())) {
						feature = (EStructuralFeature) y;
					}
				}
			}
		}
		if (javaObject instanceof Integer
				&& feature.getEType().getName().equals("Long")) {
			javaObject = new Long((Integer) javaObject);
		}
		if (feature.getUpperBound() > 1 || feature.getUpperBound() == JmiHelper.MULTIPLICITY_BOUND_INFINITE) {
			Collection<Object> list = (Collection<Object>) source.refGetValue(feature);
			if (javaObject instanceof Collection) {
				list.clear();
				if(isCompositeFeature(feature)) {
					//composed elements have to be removed from their composite parent before they are moved
					for (Object object : (Collection)javaObject) {
						if(object instanceof EObject) {
							EObject child = (EObject) object;
							removeCompositeParentLink(child);
							
						}
					}
				}
				list.addAll((Collection) javaObject);
			} else {
				list.add(javaObject);
			}
		} else {
			//TODO delete old element?
//			Object oldValue = source.refGetValue(feature);
//			if(oldValue instanceof EObject){
//				((EObject)oldValue).refDelete();
//			}
			if(javaObject instanceof EObject && isCompositeFeature(feature)) {
				removeCompositeParentLink((EObject) javaObject);
			}
//			Resource oldResource = null;
//			if (oldValue instanceof EObject) {
//				oldResource = PartitionHelper
//						.getPartition((EObject) oldValue);
//			}
			source.refSetValue(feature, javaObject);

		}

	}

	private boolean isCompositeFeature(EStructuralFeature feature) {
		return feature instanceof EAttribute ||
				(feature instanceof EReference &&
						((EReference)feature).getExposedEnd().getAggregation().equals(AggregationKindEnum.COMPOSITE));
	}

	private void removeCompositeParentLink(EObject child) {
		EObject parent = (EObject) child.refImmediateComposite();
			if(parent != null) {
			Collection<EReference> compositeAssociations = getConnection()
					.getJmiHelper().getCompositeAssociations(
							(EClass) parent.refMetaObject(),
							(EClass) child.refMetaObject());
			for (EReference association : compositeAssociations) {
				EReference compositeAssociationEnd = getConnection()
						.getJmiHelper()
						.getCompositeAssociationEnd(association);
				Object composedElement = parent
						.refGetValue(compositeAssociationEnd.getEOpposite());
				EReference refAssoc = getConnection().getJmiHelper().getRefAssociationForAssociation(association);
				if (composedElement != null && (composedElement.equals(child)
						|| (composedElement instanceof Collection && ((Collection) composedElement).contains(child)))) {
					if(getConnection().getJmiHelper().isFirstAssociationEnd(association, compositeAssociationEnd)) {
						refAssoc.refRemoveLink(parent, child);
					} else {
						refAssoc.refRemoveLink(child, parent);
					}
				}
			}
		}
	}

	public OclAny findElementInTarget(OclAny modelElement1) {
		return modelElement1;
		// EMFQvtProcessorImpl emfQvtProcessorImpl = (EMFQvtProcessorImpl)
		// qvtProcessorImpl;
		// Iterator all =
		// emfQvtProcessorImpl.getTargetResource().getAllContents();
		// while (all.hasNext()) {
		// // TODO ugly !!!
		// Object javaObject = modelElement1.asJavaObject();
		// if (javaObject instanceof EObject) {
		// String id = EcoreUtil.getID((EObject) javaObject);
		// if (id != null) {
		// Object currentObject = all.next();
		// if (id.equals(EcoreUtil.getID((EObject) currentObject))) {
		// return (OclAnyModelElement)
		// qvtProcessorImpl.getStdLibAdapter().OclAny((EObject)
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
		JMIQvtProcessorImpl mofQvtProcessorImpl = (JMIQvtProcessorImpl) this.qvtProcessorImpl;
		Object javaObject = modelElement1.asJavaObject();
		((EObject) javaObject).refDelete();
//		if (javaObject instanceof EObject) {
//			EcoreUtil.remove((EObject) javaObject);
//			List allObjects = new ArrayList();
//			Iterator all = mofQvtProcessorImpl.getTargetResource()
//					.getElements().iterator();
//			while (all.hasNext()) {
//				allObjects.add(all.next());
//			}
//			all = allObjects.iterator();
//			while (all.hasNext()) {
//				EObject currentObject = (EObject) all.next();
//				// ***************************************
//				List allStructuralFeatures = new ArrayList();
//				Iterator itx = ((EClass) currentObject.refMetaObject())
//						.getContents().iterator();
//				Object objx;
//				while (itx.hasNext()) {
//					objx = itx.next();
//					if (objx instanceof EStructuralFeature) {
//						allStructuralFeatures.add(objx);
//					}
//				}
//				// List allStructuralFeatures =
//				// currentObject.refClass().getEAllStructuralFeatures();
//				for (Iterator allStructuralFeaturesIter = allStructuralFeatures
//						.iterator(); allStructuralFeaturesIter.hasNext();) {
//					EStructuralFeature currentStructuralFeature = (EStructuralFeature) allStructuralFeaturesIter
//							.next();
//					if (currentStructuralFeature.isChangeable()) {
//						MOFQvtModelManipulationAdapterImpl.remove(
//								currentObject, currentStructuralFeature,
//								javaObject);
//					}
//				}
//			}
		}
//	}

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
	public static void remove(EObject mofObject,
			EStructuralFeature mofStructuralFeature, Object value) {
		if (mofStructuralFeature.getUpperBound() > 1) {
			((Collection) mofObject.refGetValue(mofStructuralFeature)).remove(value);
		} else {
			if (mofObject.refGetValue(mofStructuralFeature) != null
					&& mofObject.refGetValue(mofStructuralFeature)
							.equals(value)) {
				mofObject.refSetValue(mofStructuralFeature, null);
			}
		}
	}

	public boolean isModified(OclAnyModelElement modelElement, Trace oldTrace) {
		// always return false because this is not supported by EMF repository.
		return false;
	}

	public void unsetOrRemoveValuesForFeature(OclAnyModelElement modelElement,
			Property property, Collection oclValues) {
		if (oclValues.isEmpty()) {
			return;
		}

		EObject source = (EObject) modelElement.asJavaObject();
		Collection<Object> javaValuesToRemove = JMIQvtModelManipulationAdapterImpl
				.asJavaObjects(oclValues);
		EStructuralFeature structuralFeature = (EStructuralFeature) ((PropertyImpl) property)
				.getDelegate();

		if (property.getType() instanceof CollectionType) {
			Collection currentValues = (Collection) source
					.refGetValue(structuralFeature);
			currentValues.removeAll(javaValuesToRemove);
		}
	}

	protected static Collection<Object> asJavaObjects(Collection oclValues) {
		ArrayList<Object> result = new ArrayList<Object>();

		for (Iterator iter = oclValues.iterator(); iter.hasNext();) {
			result.add(((OclAny) iter.next()).asJavaObject());
		}

		return result;
	}

	public boolean isOpposite(Property property1, Property property2) {
		EStructuralFeature feature1 = (EStructuralFeature) property1
				.getDelegate();
		EStructuralFeature feature2 = (EStructuralFeature) property2
				.getDelegate();
		if (feature1 instanceof EReference && feature2 instanceof EReference) {
			EReference reference1 = (EReference) feature1;
			EReference reference2 = (EReference) feature2;
			return reference1.getReferencedEnd().equals(
					reference2.getExposedEnd());
		}
		return false;
	}

	public boolean areAllReferencesWithin(OclAny element, Set targetElements) {
		Set<Object> javaElements = new HashSet<Object>();
		EObject mofObj = (EObject) element.asJavaObject();
		for (Iterator iter = targetElements.iterator(); iter.hasNext();) {
			OclAny targetElement = (OclAny) iter.next();
			javaElements.add(targetElement.asJavaObject());
		}

		Collection<Object> moflist = new ArrayList<Object>();
		Iterator itx = ((EClass) mofObj.refMetaObject()).eAllContents();
				
		Object objx;
		while (itx.hasNext()) {
			objx = itx.next();
			if (objx instanceof EReference) {
				moflist.add(objx);
			}
		}
		for (Object element2 : moflist) {
			EReference ref = (EReference) element2;
			Object refTarget = mofObj.refGetValue(ref);
			if (refTarget instanceof Collection) {
				for (Iterator iterator = ((Collection) refTarget).iterator(); iterator
						.hasNext();) {
					Object javaTarget = iterator.next();
					if (javaTarget instanceof EObject
							&& !javaElements.contains(javaTarget)) {
						return false;
					}
				}
			} else if (refTarget instanceof EObject
					&& !javaElements.contains(refTarget)) {
				return false;
			}
		}
		return true;
	}

	public boolean unsetOrRemoveValueForFeauture(
			OclAnyModelElement modelElement, Property property, OclAny value) {
		EObject source = (EObject) modelElement.asJavaObject();
		Resource res = PartitionHelper.getPartition(source);
		Resource valueResource = null;
		if (value != null && value.asJavaObject() instanceof EObject) {
			EObject valueElement = (EObject) value.asJavaObject();
			valueResource = PartitionHelper.getPartition(valueElement);
		}
		EStructuralFeature feature = (EStructuralFeature) property.getDelegate();
		if (value != null && value.asJavaObject() instanceof Collection) {
			return false;
		}
		if (property.getType() instanceof CollectionType) {
			Collection list = (Collection) source.refGetValue(feature);
			return list.remove(value.asJavaObject());
		} else {
			if (source.refGetValue(feature) == value.asJavaObject()) {
				source.refSetValue(feature, null);
				return true;
			} else {
				return false;
			}
		}

	}

	public boolean isChangeable(Property property) {
		EStructuralFeature feature = (EStructuralFeature) property.getDelegate();
		return feature.isChangeable();
	}

	public boolean isAbstract(Classifier type) {
		if (type instanceof OclModelElementTypeImpl) {
			EClassifier mofType = ((OclModelElementTypeImpl) type)
					.getImplementation();
			return mofType instanceof EClass
					&& ((EClass) mofType).isAbstract();
		}
		return false;
	}
}
