/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: EcoreDiagramUpdater.java,v 1.4 2009/02/02 08:39:08 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAnnotationDetailsEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAnnotationEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAnnotationReferencesEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAttributeEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClass2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassAttributes2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassAttributesEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassESuperTypesEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassOperations2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassOperationsEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataType2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataTypeEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnum2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnumEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnumLiteralEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnumLiterals2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnumLiteralsEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EOperationEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EPackage2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EPackageContentsEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EPackageEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EReferenceEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EStringToStringMapEntryEditPart;
import org.eclipse.emf.ecoretools.diagram.providers.EcoreElementTypes;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EcoreDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null || view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (EcoreVisualIDRegistry.getVisualID(view)) {
		case EClassAttributesEditPart.VISUAL_ID:
			return getEClassAttributes_5001SemanticChildren(view);
		case EClassOperationsEditPart.VISUAL_ID:
			return getEClassOperations_5002SemanticChildren(view);
		case EPackageContentsEditPart.VISUAL_ID:
			return getEPackageContents_5003SemanticChildren(view);
		case EClassAttributes2EditPart.VISUAL_ID:
			return getEClassAttributes_5004SemanticChildren(view);
		case EClassOperations2EditPart.VISUAL_ID:
			return getEClassOperations_5005SemanticChildren(view);
		case EEnumLiteralsEditPart.VISUAL_ID:
			return getEEnumLiterals_5006SemanticChildren(view);
		case EAnnotationDetailsEditPart.VISUAL_ID:
			return getEAnnotationDetails_5007SemanticChildren(view);
		case EEnumLiterals2EditPart.VISUAL_ID:
			return getEEnumLiterals_5008SemanticChildren(view);
		case EPackageEditPart.VISUAL_ID:
			return getEPackage_79SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEClassAttributes_5001SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		EClass modelElement = (EClass) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getEAttributes().iterator(); it.hasNext();) {
			EAttribute childElement = (EAttribute) it.next();
			int visualID = EcoreVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EAttributeEditPart.VISUAL_ID) {
				result.add(new EcoreNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEClassOperations_5002SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		EClass modelElement = (EClass) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getEOperations().iterator(); it.hasNext();) {
			EOperation childElement = (EOperation) it.next();
			int visualID = EcoreVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EOperationEditPart.VISUAL_ID) {
				result.add(new EcoreNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEPackageContents_5003SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		EPackage modelElement = (EPackage) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getEClassifiers().iterator(); it.hasNext();) {
			EClassifier childElement = (EClassifier) it.next();
			int visualID = EcoreVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EClass2EditPart.VISUAL_ID) {
				result.add(new EcoreNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EDataType2EditPart.VISUAL_ID) {
				result.add(new EcoreNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EEnum2EditPart.VISUAL_ID) {
				result.add(new EcoreNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEClassAttributes_5004SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		EClass modelElement = (EClass) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getEAttributes().iterator(); it.hasNext();) {
			EAttribute childElement = (EAttribute) it.next();
			int visualID = EcoreVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EAttributeEditPart.VISUAL_ID) {
				result.add(new EcoreNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEClassOperations_5005SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		EClass modelElement = (EClass) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getEOperations().iterator(); it.hasNext();) {
			EOperation childElement = (EOperation) it.next();
			int visualID = EcoreVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EOperationEditPart.VISUAL_ID) {
				result.add(new EcoreNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEEnumLiterals_5006SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		EEnum modelElement = (EEnum) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getELiterals().iterator(); it.hasNext();) {
			EEnumLiteral childElement = (EEnumLiteral) it.next();
			int visualID = EcoreVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EEnumLiteralEditPart.VISUAL_ID) {
				result.add(new EcoreNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEAnnotationDetails_5007SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		EAnnotation modelElement = (EAnnotation) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getDetails().iterator(); it.hasNext();) {
			Map.Entry childElement = (Map.Entry) it.next();
			int visualID = EcoreVisualIDRegistry.getNodeVisualID(view, (EObject) childElement);
			if (visualID == EStringToStringMapEntryEditPart.VISUAL_ID) {
				result.add(new EcoreNodeDescriptor((EObject) childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEEnumLiterals_5008SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		EEnum modelElement = (EEnum) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getELiterals().iterator(); it.hasNext();) {
			EEnumLiteral childElement = (EEnumLiteral) it.next();
			int visualID = EcoreVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EEnumLiteralEditPart.VISUAL_ID) {
				result.add(new EcoreNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEPackage_79SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		EPackage modelElement = (EPackage) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getEClassifiers().iterator(); it.hasNext();) {
			EClassifier childElement = (EClassifier) it.next();
			int visualID = EcoreVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EClassEditPart.VISUAL_ID) {
				result.add(new EcoreNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EDataTypeEditPart.VISUAL_ID) {
				result.add(new EcoreNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EEnumEditPart.VISUAL_ID) {
				result.add(new EcoreNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getESubpackages().iterator(); it.hasNext();) {
			EPackage childElement = (EPackage) it.next();
			int visualID = EcoreVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EPackage2EditPart.VISUAL_ID) {
				result.add(new EcoreNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getEAnnotations().iterator(); it.hasNext();) {
			EAnnotation childElement = (EAnnotation) it.next();
			int visualID = EcoreVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EAnnotationEditPart.VISUAL_ID) {
				result.add(new EcoreNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (EcoreVisualIDRegistry.getVisualID(view)) {
		case EPackageEditPart.VISUAL_ID:
			return getEPackage_79ContainedLinks(view);
		case EClassEditPart.VISUAL_ID:
			return getEClass_1001ContainedLinks(view);
		case EPackage2EditPart.VISUAL_ID:
			return getEPackage_1002ContainedLinks(view);
		case EAnnotationEditPart.VISUAL_ID:
			return getEAnnotation_1003ContainedLinks(view);
		case EDataTypeEditPart.VISUAL_ID:
			return getEDataType_1004ContainedLinks(view);
		case EEnumEditPart.VISUAL_ID:
			return getEEnum_1005ContainedLinks(view);
		case EAttributeEditPart.VISUAL_ID:
			return getEAttribute_2001ContainedLinks(view);
		case EOperationEditPart.VISUAL_ID:
			return getEOperation_2002ContainedLinks(view);
		case EClass2EditPart.VISUAL_ID:
			return getEClass_2003ContainedLinks(view);
		case EDataType2EditPart.VISUAL_ID:
			return getEDataType_2004ContainedLinks(view);
		case EEnum2EditPart.VISUAL_ID:
			return getEEnum_2005ContainedLinks(view);
		case EEnumLiteralEditPart.VISUAL_ID:
			return getEEnumLiteral_2006ContainedLinks(view);
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			return getEStringToStringMapEntry_2007ContainedLinks(view);
		case EReferenceEditPart.VISUAL_ID:
			return getEReference_3002ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (EcoreVisualIDRegistry.getVisualID(view)) {
		case EClassEditPart.VISUAL_ID:
			return getEClass_1001IncomingLinks(view);
		case EPackage2EditPart.VISUAL_ID:
			return getEPackage_1002IncomingLinks(view);
		case EAnnotationEditPart.VISUAL_ID:
			return getEAnnotation_1003IncomingLinks(view);
		case EDataTypeEditPart.VISUAL_ID:
			return getEDataType_1004IncomingLinks(view);
		case EEnumEditPart.VISUAL_ID:
			return getEEnum_1005IncomingLinks(view);
		case EAttributeEditPart.VISUAL_ID:
			return getEAttribute_2001IncomingLinks(view);
		case EOperationEditPart.VISUAL_ID:
			return getEOperation_2002IncomingLinks(view);
		case EClass2EditPart.VISUAL_ID:
			return getEClass_2003IncomingLinks(view);
		case EDataType2EditPart.VISUAL_ID:
			return getEDataType_2004IncomingLinks(view);
		case EEnum2EditPart.VISUAL_ID:
			return getEEnum_2005IncomingLinks(view);
		case EEnumLiteralEditPart.VISUAL_ID:
			return getEEnumLiteral_2006IncomingLinks(view);
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			return getEStringToStringMapEntry_2007IncomingLinks(view);
		case EReferenceEditPart.VISUAL_ID:
			return getEReference_3002IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (EcoreVisualIDRegistry.getVisualID(view)) {
		case EClassEditPart.VISUAL_ID:
			return getEClass_1001OutgoingLinks(view);
		case EPackage2EditPart.VISUAL_ID:
			return getEPackage_1002OutgoingLinks(view);
		case EAnnotationEditPart.VISUAL_ID:
			return getEAnnotation_1003OutgoingLinks(view);
		case EDataTypeEditPart.VISUAL_ID:
			return getEDataType_1004OutgoingLinks(view);
		case EEnumEditPart.VISUAL_ID:
			return getEEnum_1005OutgoingLinks(view);
		case EAttributeEditPart.VISUAL_ID:
			return getEAttribute_2001OutgoingLinks(view);
		case EOperationEditPart.VISUAL_ID:
			return getEOperation_2002OutgoingLinks(view);
		case EClass2EditPart.VISUAL_ID:
			return getEClass_2003OutgoingLinks(view);
		case EDataType2EditPart.VISUAL_ID:
			return getEDataType_2004OutgoingLinks(view);
		case EEnum2EditPart.VISUAL_ID:
			return getEEnum_2005OutgoingLinks(view);
		case EEnumLiteralEditPart.VISUAL_ID:
			return getEEnumLiteral_2006OutgoingLinks(view);
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			return getEStringToStringMapEntry_2007OutgoingLinks(view);
		case EReferenceEditPart.VISUAL_ID:
			return getEReference_3002OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEPackage_79ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEClass_1001ContainedLinks(View view) {
		EClass modelElement = (EClass) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_EReference_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_EClass_ESuperTypes_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEPackage_1002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEAnnotation_1003ContainedLinks(View view) {
		EAnnotation modelElement = (EAnnotation) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_EAnnotation_References_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEDataType_1004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEEnum_1005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEAttribute_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEOperation_2002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEClass_2003ContainedLinks(View view) {
		EClass modelElement = (EClass) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_EReference_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_EClass_ESuperTypes_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEDataType_2004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEEnum_2005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEEnumLiteral_2006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEStringToStringMapEntry_2007ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEReference_3002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEClass_1001IncomingLinks(View view) {
		EClass modelElement = (EClass) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_EAnnotation_References_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_EReference_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_EClass_ESuperTypes_3003(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEPackage_1002IncomingLinks(View view) {
		EPackage modelElement = (EPackage) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_EAnnotation_References_3001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEAnnotation_1003IncomingLinks(View view) {
		EAnnotation modelElement = (EAnnotation) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_EAnnotation_References_3001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEDataType_1004IncomingLinks(View view) {
		EDataType modelElement = (EDataType) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_EAnnotation_References_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_EReference_3002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEEnum_1005IncomingLinks(View view) {
		EEnum modelElement = (EEnum) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_EAnnotation_References_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_EReference_3002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEAttribute_2001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEOperation_2002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEClass_2003IncomingLinks(View view) {
		EClass modelElement = (EClass) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_EAnnotation_References_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_EReference_3002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_EClass_ESuperTypes_3003(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEDataType_2004IncomingLinks(View view) {
		EDataType modelElement = (EDataType) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_EAnnotation_References_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_EReference_3002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEEnum_2005IncomingLinks(View view) {
		EEnum modelElement = (EEnum) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_EAnnotation_References_3001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_EReference_3002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEEnumLiteral_2006IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEStringToStringMapEntry_2007IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEReference_3002IncomingLinks(View view) {
		EReference modelElement = (EReference) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_EAnnotation_References_3001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEClass_1001OutgoingLinks(View view) {
		EClass modelElement = (EClass) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_EReference_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_EClass_ESuperTypes_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEPackage_1002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEAnnotation_1003OutgoingLinks(View view) {
		EAnnotation modelElement = (EAnnotation) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_EAnnotation_References_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEDataType_1004OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEEnum_1005OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEAttribute_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEOperation_2002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEClass_2003OutgoingLinks(View view) {
		EClass modelElement = (EClass) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_EReference_3002(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_EClass_ESuperTypes_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEDataType_2004OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEEnum_2005OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEEnumLiteral_2006OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEStringToStringMapEntry_2007OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEReference_3002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_EReference_3002(EClass container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getEStructuralFeatures().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof EReference) {
				continue;
			}
			EReference link = (EReference) linkObject;
			if (EReferenceEditPart.VISUAL_ID != EcoreVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			EClassifier dst = link.getEType();
			result.add(new EcoreLinkDescriptor(container, dst, link, EcoreElementTypes.EReference_3002, EReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_EAnnotation_References_3001(EObject target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == EcorePackage.eINSTANCE.getEAnnotation_References()) {
				result.add(new EcoreLinkDescriptor(setting.getEObject(), target, EcoreElementTypes.EAnnotationReferences_3001, EAnnotationReferencesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_EReference_3002(EClassifier target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != EcorePackage.eINSTANCE.getETypedElement_EType() || false == setting.getEObject() instanceof EReference) {
				continue;
			}
			EReference link = (EReference) setting.getEObject();
			if (EReferenceEditPart.VISUAL_ID != EcoreVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof EClass) {
				continue;
			}
			EClass container = (EClass) link.eContainer();
			result.add(new EcoreLinkDescriptor(container, target, link, EcoreElementTypes.EReference_3002, EReferenceEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_EClass_ESuperTypes_3003(EClass target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == EcorePackage.eINSTANCE.getEClass_ESuperTypes()) {
				result.add(new EcoreLinkDescriptor(setting.getEObject(), target, EcoreElementTypes.EClassESuperTypes_3003, EClassESuperTypesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_EAnnotation_References_3001(EAnnotation source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getReferences().iterator(); destinations.hasNext();) {
			EObject destination = (EObject) destinations.next();
			result.add(new EcoreLinkDescriptor(source, destination, EcoreElementTypes.EAnnotationReferences_3001, EAnnotationReferencesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_EClass_ESuperTypes_3003(EClass source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getESuperTypes().iterator(); destinations.hasNext();) {
			EClass destination = (EClass) destinations.next();
			result.add(new EcoreLinkDescriptor(source, destination, EcoreElementTypes.EClassESuperTypes_3003, EClassESuperTypesEditPart.VISUAL_ID));
		}
		return result;
	}

}
