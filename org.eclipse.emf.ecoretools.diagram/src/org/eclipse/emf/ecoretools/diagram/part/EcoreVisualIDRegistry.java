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
 * $Id: EcoreVisualIDRegistry.java,v 1.6 2009/05/06 14:19:20 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.diagram.Messages;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAnnotationDetailsEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAnnotationEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAnnotationSourceEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAttributeEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClass2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassAttributes2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassAttributesEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassName2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassNameEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassOperations2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassOperationsEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataType2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataTypeEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataTypeInstanceClass2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataTypeInstanceClassEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataTypeName2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataTypeNameEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnum2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnumEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnumLiteralEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnumLiterals2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnumLiteralsEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnumName2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnumNameEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EOperationEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EPackage2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EPackageContentsEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EPackageEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EPackageNameEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EReferenceEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EReferenceLowerBoundUpperBoundEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EReferenceNameEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EStringToStringMapEntryEditPart;
import org.eclipse.emf.ecoretools.diagram.expressions.EcoreAbstractExpression;
import org.eclipse.emf.ecoretools.diagram.expressions.EcoreOCLFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented by
 * a domain model object.
 * 
 * @generated
 */
public class EcoreVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.eclipse.emf.ecoretools.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static EcoreAbstractExpression EDataType_1004_Constraint; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static EcoreAbstractExpression EDataType_2004_Constraint; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (EPackageEditPart.MODEL_ID.equals(view.getType())) {
				return EPackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.emf.ecoretools.diagram.part.EcoreVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				EcoreDiagramEditorPlugin.getInstance().logError(Messages.EcoreVisualIDRegistry_UnableToParseView + type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (EcorePackage.eINSTANCE.getEPackage().isSuperTypeOf(domainElement.eClass()) && isDiagram((EPackage) domainElement)) {
			return EPackageEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.eclipse.emf.ecoretools.diagram.part.EcoreVisualIDRegistry.getModelID(containerView);
		if (!EPackageEditPart.MODEL_ID.equals(containerModelID) && !"ecore".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (EPackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.emf.ecoretools.diagram.part.EcoreVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = EPackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case EClassAttributesEditPart.VISUAL_ID:
			if (EcorePackage.eINSTANCE.getEAttribute().isSuperTypeOf(domainElement.eClass())) {
				return EAttributeEditPart.VISUAL_ID;
			}
			break;
		case EClassOperationsEditPart.VISUAL_ID:
			if (EcorePackage.eINSTANCE.getEOperation().isSuperTypeOf(domainElement.eClass())) {
				return EOperationEditPart.VISUAL_ID;
			}
			break;
		case EPackageContentsEditPart.VISUAL_ID:
			if (EcorePackage.eINSTANCE.getEClass().isSuperTypeOf(domainElement.eClass())) {
				return EClass2EditPart.VISUAL_ID;
			}
			if (EcorePackage.eINSTANCE.getEDataType().isSuperTypeOf(domainElement.eClass()) && isEDataType_2004((EDataType) domainElement)) {
				return EDataType2EditPart.VISUAL_ID;
			}
			if (EcorePackage.eINSTANCE.getEEnum().isSuperTypeOf(domainElement.eClass())) {
				return EEnum2EditPart.VISUAL_ID;
			}
			break;
		case EClassAttributes2EditPart.VISUAL_ID:
			if (EcorePackage.eINSTANCE.getEAttribute().isSuperTypeOf(domainElement.eClass())) {
				return EAttributeEditPart.VISUAL_ID;
			}
			break;
		case EClassOperations2EditPart.VISUAL_ID:
			if (EcorePackage.eINSTANCE.getEOperation().isSuperTypeOf(domainElement.eClass())) {
				return EOperationEditPart.VISUAL_ID;
			}
			break;
		case EEnumLiteralsEditPart.VISUAL_ID:
			if (EcorePackage.eINSTANCE.getEEnumLiteral().isSuperTypeOf(domainElement.eClass())) {
				return EEnumLiteralEditPart.VISUAL_ID;
			}
			break;
		case EAnnotationDetailsEditPart.VISUAL_ID:
			if (EcorePackage.eINSTANCE.getEStringToStringMapEntry().isSuperTypeOf(domainElement.eClass())) {
				return EStringToStringMapEntryEditPart.VISUAL_ID;
			}
			break;
		case EEnumLiterals2EditPart.VISUAL_ID:
			if (EcorePackage.eINSTANCE.getEEnumLiteral().isSuperTypeOf(domainElement.eClass())) {
				return EEnumLiteralEditPart.VISUAL_ID;
			}
			break;
		case EPackageEditPart.VISUAL_ID:
			if (EcorePackage.eINSTANCE.getEClass().isSuperTypeOf(domainElement.eClass())) {
				return EClassEditPart.VISUAL_ID;
			}
			if (EcorePackage.eINSTANCE.getEPackage().isSuperTypeOf(domainElement.eClass())) {
				return EPackage2EditPart.VISUAL_ID;
			}
			if (EcorePackage.eINSTANCE.getEAnnotation().isSuperTypeOf(domainElement.eClass())) {
				return EAnnotationEditPart.VISUAL_ID;
			}
			if (EcorePackage.eINSTANCE.getEDataType().isSuperTypeOf(domainElement.eClass()) && isEDataType_1004((EDataType) domainElement)) {
				return EDataTypeEditPart.VISUAL_ID;
			}
			if (EcorePackage.eINSTANCE.getEEnum().isSuperTypeOf(domainElement.eClass())) {
				return EEnumEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.emf.ecoretools.diagram.part.EcoreVisualIDRegistry.getModelID(containerView);
		if (!EPackageEditPart.MODEL_ID.equals(containerModelID) && !"ecore".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (EPackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.emf.ecoretools.diagram.part.EcoreVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = EPackageEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case EClassEditPart.VISUAL_ID:
			if (EClassNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EClassAttributesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EClassOperationsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EPackage2EditPart.VISUAL_ID:
			if (EPackageNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EPackageContentsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EAnnotationEditPart.VISUAL_ID:
			if (EAnnotationSourceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EAnnotationDetailsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EDataTypeEditPart.VISUAL_ID:
			if (EDataTypeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EDataTypeInstanceClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EEnumEditPart.VISUAL_ID:
			if (EEnumNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EEnumLiterals2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EClass2EditPart.VISUAL_ID:
			if (EClassName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EClassAttributes2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EClassOperations2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EDataType2EditPart.VISUAL_ID:
			if (EDataTypeName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EDataTypeInstanceClass2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EEnum2EditPart.VISUAL_ID:
			if (EEnumName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EEnumLiteralsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EClassAttributesEditPart.VISUAL_ID:
			if (EAttributeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EClassOperationsEditPart.VISUAL_ID:
			if (EOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EPackageContentsEditPart.VISUAL_ID:
			if (EClass2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EDataType2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EEnum2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EClassAttributes2EditPart.VISUAL_ID:
			if (EAttributeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EClassOperations2EditPart.VISUAL_ID:
			if (EOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EEnumLiteralsEditPart.VISUAL_ID:
			if (EEnumLiteralEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EAnnotationDetailsEditPart.VISUAL_ID:
			if (EStringToStringMapEntryEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EEnumLiterals2EditPart.VISUAL_ID:
			if (EEnumLiteralEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EPackageEditPart.VISUAL_ID:
			if (EClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EPackage2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EAnnotationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EDataTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EEnumEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EReferenceEditPart.VISUAL_ID:
			if (EReferenceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EReferenceLowerBoundUpperBoundEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (EcorePackage.eINSTANCE.getEReference().isSuperTypeOf(domainElement.eClass())) {
			return EReferenceEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(EPackage element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean isEDataType_1004(EDataType domainElement) {
		if (EDataType_1004_Constraint == null) { // lazy initialization
			EDataType_1004_Constraint = EcoreOCLFactory.getExpression("not oclIsKindOf(ecore::EEnum)", EcorePackage.eINSTANCE.getEDataType()); //$NON-NLS-1$
		}
		Object result = EDataType_1004_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isEDataType_2004(EDataType domainElement) {
		if (EDataType_2004_Constraint == null) { // lazy initialization
			EDataType_2004_Constraint = EcoreOCLFactory.getExpression("not oclIsKindOf(ecore::EEnum)", EcorePackage.eINSTANCE.getEDataType()); //$NON-NLS-1$
		}
		Object result = EDataType_2004_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

}
