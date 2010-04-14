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
 * $Id: EcoreViewProvider.java,v 1.5 2009/02/02 08:39:06 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAnnotationDetailsEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAnnotationEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAnnotationReferencesEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAnnotationSourceEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAttributeEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClass2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassAttributes2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassAttributesEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassESuperTypesEditPart;
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
import org.eclipse.emf.ecoretools.diagram.part.EcoreVisualIDRegistry;
import org.eclipse.emf.ecoretools.diagram.view.factories.EAnnotationDetailsViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EAnnotationReferencesViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EAnnotationSourceViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EAnnotationViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EAttributeViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EClass2ViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EClassAttributes2ViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EClassAttributesViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EClassESuperTypesViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EClassName2ViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EClassNameViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EClassOperations2ViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EClassOperationsViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EClassViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EDataType2ViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EDataTypeInstanceClass2ViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EDataTypeInstanceClassViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EDataTypeName2ViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EDataTypeNameViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EDataTypeViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EEnum2ViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EEnumLiteralViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EEnumLiterals2ViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EEnumLiteralsViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EEnumName2ViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EEnumNameViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EEnumViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EOperationViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EPackage2ViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EPackageContentsViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EPackageNameViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EPackageViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EReferenceLowerBoundUpperBoundViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EReferenceNameViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EReferenceViewFactory;
import org.eclipse.emf.ecoretools.diagram.view.factories.EStringToStringMapEntryViewFactory;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EcoreViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (EPackageEditPart.MODEL_ID.equals(diagramKind) && EcoreVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return EPackageViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		EObject domainElement = getSemanticElement(semanticAdapter);
		int visualID;
		if (semanticHint == null) {
			// Semantic hint is not specified. Can be a result of call from
			// CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will
			// be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return null;
			}
			visualID = EcoreVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} else {
			visualID = EcoreVisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram
				// element.
				// In addition we check that visualID returned by
				// VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if (!EcoreElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be
					// the same as in element type
				}
				if (domainElement != null && visualID != EcoreVisualIDRegistry.getNodeVisualID(containerView, domainElement)) {
					return null; // visual id for node EClass should match
					// visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be
				// present (except pure design elements).
				// This method is called with EObjectAdapter as parameter from:
				// - ViewService.createNode(View container, EObject eObject,
				// String type, PreferencesHint preferencesHint)
				// - generated ViewFactory.decorateView() for parent element
				if (!EPackageEditPart.MODEL_ID.equals(EcoreVisualIDRegistry.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case EClassEditPart.VISUAL_ID:
				case EAnnotationEditPart.VISUAL_ID:
				case EAttributeEditPart.VISUAL_ID:
				case EOperationEditPart.VISUAL_ID:
				case EDataType2EditPart.VISUAL_ID:
				case EEnum2EditPart.VISUAL_ID:
				case EEnumLiteralEditPart.VISUAL_ID:
				case EStringToStringMapEntryEditPart.VISUAL_ID:
				case EPackage2EditPart.VISUAL_ID:
				case EDataTypeEditPart.VISUAL_ID:
				case EEnumEditPart.VISUAL_ID:
				case EClass2EditPart.VISUAL_ID:
					if (domainElement == null || visualID != EcoreVisualIDRegistry.getNodeVisualID(containerView, domainElement)) {
						return null; // visual id in semantic hint should match
						// visual id for domain element
					}
					break;
				case EClassNameEditPart.VISUAL_ID:
				case EClassAttributesEditPart.VISUAL_ID:
				case EClassOperationsEditPart.VISUAL_ID:
					if (EClassEditPart.VISUAL_ID != EcoreVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EPackageNameEditPart.VISUAL_ID:
				case EPackageContentsEditPart.VISUAL_ID:
					if (EPackage2EditPart.VISUAL_ID != EcoreVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EAnnotationSourceEditPart.VISUAL_ID:
				case EAnnotationDetailsEditPart.VISUAL_ID:
					if (EAnnotationEditPart.VISUAL_ID != EcoreVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EDataTypeNameEditPart.VISUAL_ID:
				case EDataTypeInstanceClassEditPart.VISUAL_ID:
					if (EDataTypeEditPart.VISUAL_ID != EcoreVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EEnumNameEditPart.VISUAL_ID:
				case EEnumLiterals2EditPart.VISUAL_ID:
					if (EEnumEditPart.VISUAL_ID != EcoreVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EClassName2EditPart.VISUAL_ID:
				case EClassAttributes2EditPart.VISUAL_ID:
				case EClassOperations2EditPart.VISUAL_ID:
					if (EClass2EditPart.VISUAL_ID != EcoreVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EDataTypeName2EditPart.VISUAL_ID:
				case EDataTypeInstanceClass2EditPart.VISUAL_ID:
					if (EDataType2EditPart.VISUAL_ID != EcoreVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EEnumName2EditPart.VISUAL_ID:
				case EEnumLiteralsEditPart.VISUAL_ID:
					if (EEnum2EditPart.VISUAL_ID != EcoreVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EReferenceNameEditPart.VISUAL_ID:
				case EReferenceLowerBoundUpperBoundEditPart.VISUAL_ID:
					if (EReferenceEditPart.VISUAL_ID != EcoreVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				default:
					return null;
				}
			}
		}
		return getNodeViewClass(containerView, visualID);
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(View containerView, int visualID) {
		if (containerView == null || !EcoreVisualIDRegistry.canCreateNode(containerView, visualID)) {
			return null;
		}
		switch (visualID) {
		case EClassEditPart.VISUAL_ID:
			return EClassViewFactory.class;
		case EClassNameEditPart.VISUAL_ID:
			return EClassNameViewFactory.class;
		case EPackage2EditPart.VISUAL_ID:
			return EPackage2ViewFactory.class;
		case EPackageNameEditPart.VISUAL_ID:
			return EPackageNameViewFactory.class;
		case EAnnotationEditPart.VISUAL_ID:
			return EAnnotationViewFactory.class;
		case EAnnotationSourceEditPart.VISUAL_ID:
			return EAnnotationSourceViewFactory.class;
		case EDataTypeEditPart.VISUAL_ID:
			return EDataTypeViewFactory.class;
		case EDataTypeNameEditPart.VISUAL_ID:
			return EDataTypeNameViewFactory.class;
		case EDataTypeInstanceClassEditPart.VISUAL_ID:
			return EDataTypeInstanceClassViewFactory.class;
		case EEnumEditPart.VISUAL_ID:
			return EEnumViewFactory.class;
		case EEnumNameEditPart.VISUAL_ID:
			return EEnumNameViewFactory.class;
		case EAttributeEditPart.VISUAL_ID:
			return EAttributeViewFactory.class;
		case EOperationEditPart.VISUAL_ID:
			return EOperationViewFactory.class;
		case EClass2EditPart.VISUAL_ID:
			return EClass2ViewFactory.class;
		case EClassName2EditPart.VISUAL_ID:
			return EClassName2ViewFactory.class;
		case EDataType2EditPart.VISUAL_ID:
			return EDataType2ViewFactory.class;
		case EDataTypeName2EditPart.VISUAL_ID:
			return EDataTypeName2ViewFactory.class;
		case EDataTypeInstanceClass2EditPart.VISUAL_ID:
			return EDataTypeInstanceClass2ViewFactory.class;
		case EEnum2EditPart.VISUAL_ID:
			return EEnum2ViewFactory.class;
		case EEnumName2EditPart.VISUAL_ID:
			return EEnumName2ViewFactory.class;
		case EEnumLiteralEditPart.VISUAL_ID:
			return EEnumLiteralViewFactory.class;
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			return EStringToStringMapEntryViewFactory.class;
		case EClassAttributesEditPart.VISUAL_ID:
			return EClassAttributesViewFactory.class;
		case EClassOperationsEditPart.VISUAL_ID:
			return EClassOperationsViewFactory.class;
		case EPackageContentsEditPart.VISUAL_ID:
			return EPackageContentsViewFactory.class;
		case EClassAttributes2EditPart.VISUAL_ID:
			return EClassAttributes2ViewFactory.class;
		case EClassOperations2EditPart.VISUAL_ID:
			return EClassOperations2ViewFactory.class;
		case EEnumLiteralsEditPart.VISUAL_ID:
			return EEnumLiteralsViewFactory.class;
		case EAnnotationDetailsEditPart.VISUAL_ID:
			return EAnnotationDetailsViewFactory.class;
		case EEnumLiterals2EditPart.VISUAL_ID:
			return EEnumLiterals2ViewFactory.class;
		case EReferenceNameEditPart.VISUAL_ID:
			return EReferenceNameViewFactory.class;
		case EReferenceLowerBoundUpperBoundEditPart.VISUAL_ID:
			return EReferenceLowerBoundUpperBoundViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (!EcoreElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
			return null; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null) {
			return null; // our hint is visual id and must be specified
		}
		if (semanticHint != null && !semanticHint.equals(elementTypeHint)) {
			return null; // if semantic hint is specified it should be the same
			// as in element type
		}
		int visualID = EcoreVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null && visualID != EcoreVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
			return null; // visual id for link EClass should match visual id
			// from element type
		}
		return getEdgeViewClass(visualID);
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(int visualID) {
		switch (visualID) {
		case EAnnotationReferencesEditPart.VISUAL_ID:
			return EAnnotationReferencesViewFactory.class;
		case EReferenceEditPart.VISUAL_ID:
			return EReferenceViewFactory.class;
		case EClassESuperTypesEditPart.VISUAL_ID:
			return EClassESuperTypesViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}

}
