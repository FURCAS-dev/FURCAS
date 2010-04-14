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
 * $Id: EcoreNavigatorLabelProvider.java,v 1.5 2009/03/19 16:47:11 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAnnotationEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAnnotationReferencesEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAnnotationSourceEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EAttributeEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClass2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassESuperTypesEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassName2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EClassNameEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataType2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataTypeEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataTypeName2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EDataTypeNameEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnum2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnumEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnumLiteralEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnumName2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EEnumNameEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EOperationEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EPackage2EditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EPackageEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EPackageNameEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EReferenceEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EReferenceNameEditPart;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EStringToStringMapEntryEditPart;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditorPlugin;
import org.eclipse.emf.ecoretools.diagram.part.EcoreVisualIDRegistry;
import org.eclipse.emf.ecoretools.diagram.providers.EcoreElementTypes;
import org.eclipse.emf.ecoretools.diagram.providers.EcoreParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class EcoreNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		EcoreDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		EcoreDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof EcoreNavigatorItem && !isOwnView(((EcoreNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof EcoreNavigatorGroup) {
			EcoreNavigatorGroup group = (EcoreNavigatorGroup) element;
			return EcoreDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof EcoreNavigatorItem) {
			EcoreNavigatorItem navigatorItem = (EcoreNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (EcoreVisualIDRegistry.getVisualID(view)) {
		case EPackageEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.eclipse.org/emf/2002/Ecore?EPackage", EcoreElementTypes.EPackage_79); //$NON-NLS-1$
		case EClassEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/emf/2002/Ecore?EClass", EcoreElementTypes.EClass_1001); //$NON-NLS-1$
		case EPackage2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/emf/2002/Ecore?EPackage", EcoreElementTypes.EPackage_1002); //$NON-NLS-1$
		case EAnnotationEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/emf/2002/Ecore?EAnnotation", EcoreElementTypes.EAnnotation_1003); //$NON-NLS-1$
		case EDataTypeEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/emf/2002/Ecore?EDataType", EcoreElementTypes.EDataType_1004); //$NON-NLS-1$
		case EEnumEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/emf/2002/Ecore?EEnum", EcoreElementTypes.EEnum_1005); //$NON-NLS-1$
		case EAttributeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EAttribute", EcoreElementTypes.EAttribute_2001); //$NON-NLS-1$
		case EOperationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EOperation", EcoreElementTypes.EOperation_2002); //$NON-NLS-1$
		case EClass2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EClass", EcoreElementTypes.EClass_2003); //$NON-NLS-1$
		case EDataType2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EDataType", EcoreElementTypes.EDataType_2004); //$NON-NLS-1$
		case EEnum2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EEnum", EcoreElementTypes.EEnum_2005); //$NON-NLS-1$
		case EEnumLiteralEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EEnumLiteral", EcoreElementTypes.EEnumLiteral_2006); //$NON-NLS-1$
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/emf/2002/Ecore?EStringToStringMapEntry", EcoreElementTypes.EStringToStringMapEntry_2007); //$NON-NLS-1$
		case EAnnotationReferencesEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/emf/2002/Ecore?EAnnotation?references", EcoreElementTypes.EAnnotationReferences_3001); //$NON-NLS-1$
		case EReferenceEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/emf/2002/Ecore?EReference", EcoreElementTypes.EReference_3002); //$NON-NLS-1$
		case EClassESuperTypesEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/emf/2002/Ecore?EClass?eSuperTypes", EcoreElementTypes.EClassESuperTypes_3003); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = EcoreDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && EcoreElementTypes.isKnownElementType(elementType)) {
			image = EcoreElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof EcoreNavigatorGroup) {
			EcoreNavigatorGroup group = (EcoreNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof EcoreNavigatorItem) {
			EcoreNavigatorItem navigatorItem = (EcoreNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (EcoreVisualIDRegistry.getVisualID(view)) {
		case EPackageEditPart.VISUAL_ID:
			return getEPackage_79Text(view);
		case EClassEditPart.VISUAL_ID:
			return getEClass_1001Text(view);
		case EPackage2EditPart.VISUAL_ID:
			return getEPackage_1002Text(view);
		case EAnnotationEditPart.VISUAL_ID:
			return getEAnnotation_1003Text(view);
		case EDataTypeEditPart.VISUAL_ID:
			return getEDataType_1004Text(view);
		case EEnumEditPart.VISUAL_ID:
			return getEEnum_1005Text(view);
		case EAttributeEditPart.VISUAL_ID:
			return getEAttribute_2001Text(view);
		case EOperationEditPart.VISUAL_ID:
			return getEOperation_2002Text(view);
		case EClass2EditPart.VISUAL_ID:
			return getEClass_2003Text(view);
		case EDataType2EditPart.VISUAL_ID:
			return getEDataType_2004Text(view);
		case EEnum2EditPart.VISUAL_ID:
			return getEEnum_2005Text(view);
		case EEnumLiteralEditPart.VISUAL_ID:
			return getEEnumLiteral_2006Text(view);
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			return getEStringToStringMapEntry_2007Text(view);
		case EAnnotationReferencesEditPart.VISUAL_ID:
			return getEAnnotationReferences_3001Text(view);
		case EReferenceEditPart.VISUAL_ID:
			return getEReference_3002Text(view);
		case EClassESuperTypesEditPart.VISUAL_ID:
			return getEClassESuperTypes_3003Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getEPackage_79Text(View view) {
		EPackage domainModelElement = (EPackage) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 79); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEClass_1001Text(View view) {
		IParser parser = EcoreParserProvider
				.getParser(EcoreElementTypes.EClass_1001, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry.getType(EClassNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEPackage_1002Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EPackage_1002, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EPackageNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEAnnotation_1003Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EAnnotation_1003, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EAnnotationSourceEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEDataType_1004Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EDataType_1004, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EDataTypeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEEnum_1005Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EEnum_1005, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry.getType(EEnumNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEAttribute_2001Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EAttribute_2001, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EAttributeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 2001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEOperation_2002Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EOperation_2002, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EOperationEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 2002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEClass_2003Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EClass_2003, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EClassName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEDataType_2004Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EDataType_2004, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EDataTypeName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEEnum_2005Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EEnum_2005, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry.getType(EEnumName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEEnumLiteral_2006Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EEnumLiteral_2006, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EEnumLiteralEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 2006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEStringToStringMapEntry_2007Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EStringToStringMapEntry_2007, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EStringToStringMapEntryEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 2007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEAnnotationReferences_3001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEReference_3002Text(View view) {
		IParser parser = EcoreParserProvider.getParser(EcoreElementTypes.EReference_3002, view.getElement() != null ? view.getElement() : view, EcoreVisualIDRegistry
				.getType(EReferenceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			EcoreDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated NOT
	 */
	private String getEClassESuperTypes_3003Text(View view) {
		String textValue = ""; //$NON-NLS-1$
		EObject sourceElt = ((Edge) view).getSource().getElement();
		EObject targetElt = ((Edge) view).getTarget().getElement();
		if (sourceElt != null && sourceElt instanceof EClass) {
			textValue = textValue.concat(((EClass) sourceElt).getName());
		}
		textValue = textValue.concat(" > "); //$NON-NLS-1$
		if (targetElt != null && targetElt instanceof EClass) {
			textValue = textValue.concat(((EClass) targetElt).getName());
		}
		return textValue;
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return EPackageEditPart.MODEL_ID.equals(EcoreVisualIDRegistry.getModelID(view));
	}

}
