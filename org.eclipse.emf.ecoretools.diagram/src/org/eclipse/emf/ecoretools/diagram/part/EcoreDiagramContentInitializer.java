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
 * $Id: EcoreDiagramContentInitializer.java,v 1.5 2009/02/02 08:39:07 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.part;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAnnotationDetailsEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAnnotationEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAttributeEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClass2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassAttributes2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassAttributesEditPart;
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
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.osgi.util.NLS;

/**
 * @generated
 */
public class EcoreDiagramContentInitializer {

	/**
	 * @generated
	 */
	private Map myDomain2NotationMap = new HashMap();

	/**
	 * @generated
	 */
	private Collection myLinkDescriptors = new LinkedList();

	private boolean initEPackageContent = true;

	/**
	 * @generated
	 */
	public void initDiagramContent(Diagram diagram) {
		if (!EPackageEditPart.MODEL_ID.equals(diagram.getType())) {
			EcoreDiagramEditorPlugin.getInstance().logError(org.eclipse.emf.ecoretools.diagram.Messages.EcoreDiagramContentInitializer_IncorrectDiagramAsParameter + diagram.getType());
			return;
		}
		if (false == diagram.getElement() instanceof EPackage) {
			EcoreDiagramEditorPlugin.getInstance().logError(NLS.bind(org.eclipse.emf.ecoretools.diagram.Messages.EcoreDiagramContentInitializer_IncorrectElementSpecified, diagram.getElement()));
			return;
		}
		createEPackage_79Children(diagram);
		createLinks(diagram);
	}

	/**
	 * @generated
	 */
	private void createEClass_1001Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EcoreDiagramUpdater.getEClass_1001OutgoingLinks(view));
		createEClassAttributes_5001Children(getCompartment(view, EClassAttributesEditPart.VISUAL_ID));
		createEClassOperations_5002Children(getCompartment(view, EClassOperationsEditPart.VISUAL_ID));

	}

	/**
	 * @generated
	 */
	private void createEPackage_1002Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EcoreDiagramUpdater.getEPackage_1002OutgoingLinks(view));
		createEPackageContents_5003Children(getCompartment(view, EPackageContentsEditPart.VISUAL_ID));

	}

	/**
	 * @generated
	 */
	private void createEAnnotation_1003Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EcoreDiagramUpdater.getEAnnotation_1003OutgoingLinks(view));
		createEAnnotationDetails_5007Children(getCompartment(view, EAnnotationDetailsEditPart.VISUAL_ID));

	}

	/**
	 * @generated
	 */
	private void createEDataType_1004Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EcoreDiagramUpdater.getEDataType_1004OutgoingLinks(view));

	}

	/**
	 * @generated
	 */
	private void createEEnum_1005Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EcoreDiagramUpdater.getEEnum_1005OutgoingLinks(view));
		createEEnumLiterals_5008Children(getCompartment(view, EEnumLiterals2EditPart.VISUAL_ID));

	}

	/**
	 * @generated
	 */
	private void createEAttribute_2001Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EcoreDiagramUpdater.getEAttribute_2001OutgoingLinks(view));

	}

	/**
	 * @generated
	 */
	private void createEOperation_2002Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EcoreDiagramUpdater.getEOperation_2002OutgoingLinks(view));

	}

	/**
	 * @generated
	 */
	private void createEClass_2003Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EcoreDiagramUpdater.getEClass_2003OutgoingLinks(view));
		createEClassAttributes_5004Children(getCompartment(view, EClassAttributes2EditPart.VISUAL_ID));
		createEClassOperations_5005Children(getCompartment(view, EClassOperations2EditPart.VISUAL_ID));

	}

	/**
	 * @generated
	 */
	private void createEDataType_2004Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EcoreDiagramUpdater.getEDataType_2004OutgoingLinks(view));

	}

	/**
	 * @generated
	 */
	private void createEEnum_2005Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EcoreDiagramUpdater.getEEnum_2005OutgoingLinks(view));
		createEEnumLiterals_5006Children(getCompartment(view, EEnumLiteralsEditPart.VISUAL_ID));

	}

	/**
	 * @generated
	 */
	private void createEEnumLiteral_2006Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EcoreDiagramUpdater.getEEnumLiteral_2006OutgoingLinks(view));

	}

	/**
	 * @generated
	 */
	private void createEStringToStringMapEntry_2007Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EcoreDiagramUpdater.getEStringToStringMapEntry_2007OutgoingLinks(view));

	}

	/**
	 * @generated
	 */
	private void createEClassAttributes_5001Children(View view) {
		Collection childNodeDescriptors = EcoreDiagramUpdater.getEClassAttributes_5001SemanticChildren(view);
		for (Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (EcoreNodeDescriptor) it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createEClassOperations_5002Children(View view) {
		Collection childNodeDescriptors = EcoreDiagramUpdater.getEClassOperations_5002SemanticChildren(view);
		for (Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (EcoreNodeDescriptor) it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createEPackageContents_5003Children(View view) {
		Collection childNodeDescriptors = EcoreDiagramUpdater.getEPackageContents_5003SemanticChildren(view);
		for (Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (EcoreNodeDescriptor) it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createEClassAttributes_5004Children(View view) {
		Collection childNodeDescriptors = EcoreDiagramUpdater.getEClassAttributes_5004SemanticChildren(view);
		for (Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (EcoreNodeDescriptor) it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createEClassOperations_5005Children(View view) {
		Collection childNodeDescriptors = EcoreDiagramUpdater.getEClassOperations_5005SemanticChildren(view);
		for (Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (EcoreNodeDescriptor) it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createEEnumLiterals_5006Children(View view) {
		Collection childNodeDescriptors = EcoreDiagramUpdater.getEEnumLiterals_5006SemanticChildren(view);
		for (Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (EcoreNodeDescriptor) it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createEAnnotationDetails_5007Children(View view) {
		Collection childNodeDescriptors = EcoreDiagramUpdater.getEAnnotationDetails_5007SemanticChildren(view);
		for (Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (EcoreNodeDescriptor) it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createEEnumLiterals_5008Children(View view) {
		Collection childNodeDescriptors = EcoreDiagramUpdater.getEEnumLiterals_5008SemanticChildren(view);
		for (Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (EcoreNodeDescriptor) it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createEPackage_79Children(View view) {
		Collection childNodeDescriptors = EcoreDiagramUpdater.getEPackage_79SemanticChildren(view);
		for (Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (EcoreNodeDescriptor) it.next());
		}
	}

	/**
	 * @generated NOT
	 */
	private void createNode(View parentView, EcoreNodeDescriptor nodeDescriptor) {
		Node node = ViewService
				.createNode(parentView, nodeDescriptor.getModelElement(), EcoreVisualIDRegistry.getType(nodeDescriptor.getVisualID()), EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		switch (nodeDescriptor.getVisualID()) {
		case EClassEditPart.VISUAL_ID:
			createEClass_1001Children(node);
			return;
		case EPackage2EditPart.VISUAL_ID:
			if (initEPackageContent) {
				createEPackage_1002Children(node);
			}
			return;
		case EAnnotationEditPart.VISUAL_ID:
			createEAnnotation_1003Children(node);
			return;
		case EDataTypeEditPart.VISUAL_ID:
			createEDataType_1004Children(node);
			return;
		case EEnumEditPart.VISUAL_ID:
			createEEnum_1005Children(node);
			return;
		case EAttributeEditPart.VISUAL_ID:
			createEAttribute_2001Children(node);
			return;
		case EOperationEditPart.VISUAL_ID:
			createEOperation_2002Children(node);
			return;
		case EClass2EditPart.VISUAL_ID:
			createEClass_2003Children(node);
			return;
		case EDataType2EditPart.VISUAL_ID:
			createEDataType_2004Children(node);
			return;
		case EEnum2EditPart.VISUAL_ID:
			createEEnum_2005Children(node);
			return;
		case EEnumLiteralEditPart.VISUAL_ID:
			createEEnumLiteral_2006Children(node);
			return;
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			createEStringToStringMapEntry_2007Children(node);
			return;
		}
	}

	/**
	 * @generated
	 */
	private void createLinks(Diagram diagram) {
		for (boolean continueLinkCreation = true; continueLinkCreation;) {
			continueLinkCreation = false;
			Collection additionalDescriptors = new LinkedList();
			for (Iterator it = myLinkDescriptors.iterator(); it.hasNext();) {
				EcoreLinkDescriptor nextLinkDescriptor = (EcoreLinkDescriptor) it.next();
				if (!myDomain2NotationMap.containsKey(nextLinkDescriptor.getSource()) || !myDomain2NotationMap.containsKey(nextLinkDescriptor.getDestination())) {
					continue;
				}
				Edge edge = (Edge) ViewService.getInstance().createEdge(nextLinkDescriptor.getSemanticAdapter(), diagram, EcoreVisualIDRegistry.getType(nextLinkDescriptor.getVisualID()),
						ViewUtil.APPEND, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				if (edge != null) {
					edge.setSource((View) myDomain2NotationMap.get(nextLinkDescriptor.getSource()));
					edge.setTarget((View) myDomain2NotationMap.get(nextLinkDescriptor.getDestination()));
					it.remove();
					if (nextLinkDescriptor.getModelElement() != null) {
						myDomain2NotationMap.put(nextLinkDescriptor.getModelElement(), edge);
					}
					continueLinkCreation = true;
					switch (nextLinkDescriptor.getVisualID()) {
					case EReferenceEditPart.VISUAL_ID:
						additionalDescriptors.addAll(EcoreDiagramUpdater.getEReference_3002OutgoingLinks(edge));
						break;
					}
				}
			}
			myLinkDescriptors.addAll(additionalDescriptors);
		}
	}

	/**
	 * @generated
	 */
	private Node getCompartment(View node, int visualID) {
		String type = EcoreVisualIDRegistry.getType(visualID);
		for (Iterator it = node.getChildren().iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (nextView instanceof Node && type.equals(nextView.getType())) {
				return (Node) nextView;
			}
		}
		return null;
	}

	/**
	 * @return the initEPackageContent
	 */
	public boolean isInitEPackageContent() {
		return initEPackageContent;
	}

	/**
	 * @param initEPackageContent
	 *            the initEPackageContent to set
	 */
	public void setInitEPackageContent(boolean initEPackageContent) {
		this.initEPackageContent = initEPackageContent;
	}

}
