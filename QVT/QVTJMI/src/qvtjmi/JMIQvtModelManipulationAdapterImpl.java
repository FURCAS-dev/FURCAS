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

import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.OclModelElementType;
import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.semantics.bridge.impl.PropertyImpl;
import org.oslo.ocl20.semantics.model.types.CollectionType;
import org.oslo.ocl20.standard.lib.OclAny;
import org.oslo.ocl20.standard.lib.OclAnyModelElement;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

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
		RefObject newInstance = getConnection().getJmiHelper().getRefClassForMofClass(
						(MofClass) mofOclModelElementType.getImplementation())
				.refCreateInstance();
		// find resource to put into !!
		JMIQvtProcessorImpl mofQvtProcessorImpl = (JMIQvtProcessorImpl) this.qvtProcessorImpl;
		//mofQvtProcessorImpl.getTargetResource().getContents().add(newInstance)
		// ;
		addToPartition(newInstance);
		return (OclAnyModelElement) this.qvtProcessorImpl.getStdLibAdapter()
				.OclAny(newInstance);
	}

	private Connection getConnection() {
		return ((JMIQvtProcessorImpl) this.qvtProcessorImpl)
				.getConnection();
	}

	private void addToPartition(RefObject newInstance) {
		((ModelPartition)this.qvtProcessorImpl.getTargetModel()).assignElementIncludingChildren(newInstance);
	}

	public void setOrAddValueForFeauture(OclAnyModelElement modelElement,
			Property property, OclAny value) {
		RefObject source = (RefObject) modelElement.asJavaObject();
		ModelPartition res = PartitionHelper.getPartition(source);
		Object javaObject = value.asJavaObject();
		StructuralFeature feature = (StructuralFeature) property.getDelegate();
		if (!feature.isChangeable() && feature instanceof Reference
				&& ((Reference) feature).getReferencedEnd().getType() != null
				&& ((Reference) feature).getReferencedEnd().isChangeable()
				&& javaObject instanceof RefObject) {
			RefObject x = source;
			source = (RefObject) javaObject;
			javaObject = x;
			com.sap.tc.moin.repository.mmi.model.Classifier type = ((Reference) feature)
					.getReferencedEnd().getType();
			for (Object y : type.getContents()) {
				if (y instanceof Reference) {
					if (((Reference) y).getExposedEnd().equals(
							((Reference) feature).getReferencedEnd())) {
						feature = (StructuralFeature) y;
					}
				}
			}
		}
		if (javaObject instanceof Integer
				&& feature.getType().getName().equals("Long")) {
			javaObject = new Long((Integer) javaObject);
		}
		if (feature.getMultiplicity().getUpper() > 1 || feature.getMultiplicity().getUpper() == JmiHelper.MULTIPLICITY_BOUND_INFINITE) {
			Collection<Object> list = (Collection<Object>) source.refGetValue(feature);
			if (javaObject instanceof Collection) {
				list.clear();
				if(isCompositeFeature(feature)) {
					//composed elements have to be removed from their composite parent before they are moved
					for (Object object : (Collection)javaObject) {
						if(object instanceof RefObject) {
							RefObject child = (RefObject) object;
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
//			if(oldValue instanceof RefObject){
//				((RefObject)oldValue).refDelete();
//			}
			if(javaObject instanceof RefObject && isCompositeFeature(feature)) {
				removeCompositeParentLink((RefObject) javaObject);
			}
//			ModelPartition oldResource = null;
//			if (oldValue instanceof RefObject) {
//				oldResource = PartitionHelper
//						.getPartition((RefObject) oldValue);
//			}
			source.refSetValue(feature, javaObject);

		}

	}

	private boolean isCompositeFeature(StructuralFeature feature) {
		return feature instanceof Attribute ||
				(feature instanceof Reference &&
						((Reference)feature).getExposedEnd().getAggregation().equals(AggregationKindEnum.COMPOSITE));
	}

	private void removeCompositeParentLink(RefObject child) {
		RefObject parent = (RefObject) child.refImmediateComposite();
			if(parent != null) {
			Collection<Association> compositeAssociations = getConnection()
					.getJmiHelper().getCompositeAssociations(
							(MofClass) parent.refMetaObject(),
							(MofClass) child.refMetaObject());
			for (Association association : compositeAssociations) {
				AssociationEnd compositeAssociationEnd = getConnection()
						.getJmiHelper()
						.getCompositeAssociationEnd(association);
				Object composedElement = parent
						.refGetValue(compositeAssociationEnd.otherEnd());
				RefAssociation refAssoc = getConnection().getJmiHelper().getRefAssociationForAssociation(association);
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
		((RefObject) javaObject).refDelete();
//		if (javaObject instanceof RefObject) {
//			EcoreUtil.remove((RefObject) javaObject);
//			List allObjects = new ArrayList();
//			Iterator all = mofQvtProcessorImpl.getTargetResource()
//					.getElements().iterator();
//			while (all.hasNext()) {
//				allObjects.add(all.next());
//			}
//			all = allObjects.iterator();
//			while (all.hasNext()) {
//				RefObject currentObject = (RefObject) all.next();
//				// ***************************************
//				List allStructuralFeatures = new ArrayList();
//				Iterator itx = ((MofClass) currentObject.refMetaObject())
//						.getContents().iterator();
//				Object objx;
//				while (itx.hasNext()) {
//					objx = itx.next();
//					if (objx instanceof StructuralFeature) {
//						allStructuralFeatures.add(objx);
//					}
//				}
//				// List allStructuralFeatures =
//				// currentObject.refClass().getEAllStructuralFeatures();
//				for (Iterator allStructuralFeaturesIter = allStructuralFeatures
//						.iterator(); allStructuralFeaturesIter.hasNext();) {
//					StructuralFeature currentStructuralFeature = (StructuralFeature) allStructuralFeaturesIter
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
	public static void remove(RefObject mofObject,
			StructuralFeature mofStructuralFeature, Object value) {
		if (mofStructuralFeature.getMultiplicity().getUpper() > 1) {
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

		RefObject source = (RefObject) modelElement.asJavaObject();
		Collection<Object> javaValuesToRemove = JMIQvtModelManipulationAdapterImpl
				.asJavaObjects(oclValues);
		StructuralFeature structuralFeature = (StructuralFeature) ((PropertyImpl) property)
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
		StructuralFeature feature1 = (StructuralFeature) property1
				.getDelegate();
		StructuralFeature feature2 = (StructuralFeature) property2
				.getDelegate();
		if (feature1 instanceof Reference && feature2 instanceof Reference) {
			Reference reference1 = (Reference) feature1;
			Reference reference2 = (Reference) feature2;
			return reference1.getReferencedEnd().equals(
					reference2.getExposedEnd());
		}
		return false;
	}

	public boolean areAllReferencesWithin(OclAny element, Set targetElements) {
		Set<Object> javaElements = new HashSet<Object>();
		RefObject mofObj = (RefObject) element.asJavaObject();
		for (Iterator iter = targetElements.iterator(); iter.hasNext();) {
			OclAny targetElement = (OclAny) iter.next();
			javaElements.add(targetElement.asJavaObject());
		}

		Collection<Object> moflist = new ArrayList<Object>();
		Iterator itx = ((MofClass) mofObj.refMetaObject()).getContents()
				.iterator();
		Object objx;
		while (itx.hasNext()) {
			objx = itx.next();
			if (objx instanceof Reference) {
				moflist.add(objx);
			}
		}
		for (Object element2 : moflist) {
			Reference ref = (Reference) element2;
			Object refTarget = mofObj.refGetValue(ref);
			if (refTarget instanceof Collection) {
				for (Iterator iterator = ((Collection) refTarget).iterator(); iterator
						.hasNext();) {
					Object javaTarget = iterator.next();
					if (javaTarget instanceof RefObject
							&& !javaElements.contains(javaTarget)) {
						return false;
					}
				}
			} else if (refTarget instanceof RefObject
					&& !javaElements.contains(refTarget)) {
				return false;
			}
		}
		return true;
	}

	public boolean unsetOrRemoveValueForFeauture(
			OclAnyModelElement modelElement, Property property, OclAny value) {
		RefObject source = (RefObject) modelElement.asJavaObject();
		ModelPartition res = PartitionHelper.getPartition(source);
		ModelPartition valueResource = null;
		if (value != null && value.asJavaObject() instanceof RefObject) {
			RefObject valueElement = (RefObject) value.asJavaObject();
			valueResource = PartitionHelper.getPartition(valueElement);
		}
		StructuralFeature feature = (StructuralFeature) property.getDelegate();
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
		StructuralFeature feature = (StructuralFeature) property.getDelegate();
		return feature.isChangeable();
	}

	public boolean isAbstract(Classifier type) {
		if (type instanceof OclModelElementTypeImpl) {
			com.sap.tc.moin.repository.mmi.model.Classifier mofType = ((OclModelElementTypeImpl) type)
					.getImplementation();
			return mofType instanceof MofClass
					&& ((MofClass) mofType).isAbstract();
		}
		return false;
	}
}
