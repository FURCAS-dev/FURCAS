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
 * $Id: EcorePaletteFactory.java,v 1.4 2009/02/02 08:39:07 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecoretools.diagram.providers.EcoreElementTypes;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

/**
 * @generated
 */
public class EcorePaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createObjects1Group());
		paletteRoot.add(createConnections2Group());
	}

	/**
	 * Creates "Objects" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createObjects1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Objects1Group_title);
		paletteContainer.setDescription(Messages.Objects1Group_desc);
		paletteContainer.add(createEPackage1CreationTool());
		paletteContainer.add(createEClass2CreationTool());
		paletteContainer.add(createEDataType3CreationTool());
		paletteContainer.add(createEEnum4CreationTool());
		paletteContainer.add(createEAnnotation5CreationTool());
		paletteContainer.add(new PaletteSeparator());
		paletteContainer.add(createEOperation7CreationTool());
		paletteContainer.add(createEAttribute8CreationTool());
		paletteContainer.add(createEEnumLiteral9CreationTool());
		paletteContainer.add(createDetailsEntry10CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Connections" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Connections2Group_title);
		paletteContainer.setDescription(Messages.Connections2Group_desc);
		paletteContainer.add(createEReference1CreationTool());
		paletteContainer.add(createInheritance2CreationTool());
		paletteContainer.add(createEAnnotationlink3CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEPackage1CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(EcoreElementTypes.EPackage_1002);
		NodeToolEntry entry = new NodeToolEntry(Messages.EPackage1CreationTool_title, Messages.EPackage1CreationTool_desc, types);
		entry.setSmallIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/EPackage.gif")); //$NON-NLS-1$
		entry.setLargeIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/EPackage_24.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEClass2CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(EcoreElementTypes.EClass_1001);
		types.add(EcoreElementTypes.EClass_2003);
		NodeToolEntry entry = new NodeToolEntry(Messages.EClass2CreationTool_title, Messages.EClass2CreationTool_desc, types);
		entry.setSmallIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/EClass.gif")); //$NON-NLS-1$
		entry.setLargeIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/EClass_24.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEDataType3CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(EcoreElementTypes.EDataType_2004);
		types.add(EcoreElementTypes.EDataType_1004);
		NodeToolEntry entry = new NodeToolEntry(Messages.EDataType3CreationTool_title, Messages.EDataType3CreationTool_desc, types);
		entry.setSmallIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/EDataType.gif")); //$NON-NLS-1$
		entry.setLargeIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/EDataType_24.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEEnum4CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
		types.add(EcoreElementTypes.EEnum_2005);
		types.add(EcoreElementTypes.EEnum_1005);
		NodeToolEntry entry = new NodeToolEntry(Messages.EEnum4CreationTool_title, Messages.EEnum4CreationTool_desc, types);
		entry.setSmallIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/EEnum.gif")); //$NON-NLS-1$
		entry.setLargeIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/EEnum_24.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEAnnotation5CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(EcoreElementTypes.EAnnotation_1003);
		NodeToolEntry entry = new NodeToolEntry(Messages.EAnnotation5CreationTool_title, Messages.EAnnotation5CreationTool_desc, types);
		entry.setSmallIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/EAnnotation.gif")); //$NON-NLS-1$
		entry.setLargeIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/EAnnotation_24.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEOperation7CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(EcoreElementTypes.EOperation_2002);
		NodeToolEntry entry = new NodeToolEntry(Messages.EOperation7CreationTool_title, Messages.EOperation7CreationTool_desc, types);
		entry.setSmallIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/EOperation.gif")); //$NON-NLS-1$
		entry.setLargeIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/EOperation_24.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEAttribute8CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(EcoreElementTypes.EAttribute_2001);
		NodeToolEntry entry = new NodeToolEntry(Messages.EAttribute8CreationTool_title, Messages.EAttribute8CreationTool_desc, types);
		entry.setSmallIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/EAttribute.gif")); //$NON-NLS-1$
		entry.setLargeIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/EAttribute_24.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEEnumLiteral9CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(EcoreElementTypes.EEnumLiteral_2006);
		NodeToolEntry entry = new NodeToolEntry(Messages.EEnumLiteral9CreationTool_title, Messages.EEnumLiteral9CreationTool_desc, types);
		entry.setSmallIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/EEnumLiteral.gif")); //$NON-NLS-1$
		entry.setLargeIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/EEnumLiteral_24.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDetailsEntry10CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(EcoreElementTypes.EStringToStringMapEntry_2007);
		NodeToolEntry entry = new NodeToolEntry(Messages.DetailsEntry10CreationTool_title, Messages.DetailsEntry10CreationTool_desc, types);
		entry.setSmallIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/EStringToStringMapEntry.gif")); //$NON-NLS-1$
		entry.setLargeIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/EStringToStringMapEntry_24.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEReference1CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(EcoreElementTypes.EReference_3002);
		LinkToolEntry entry = new LinkToolEntry(Messages.EReference1CreationTool_title, Messages.EReference1CreationTool_desc, types);
		entry.setSmallIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/EReference.gif")); //$NON-NLS-1$
		entry.setLargeIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/EReference_24.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInheritance2CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(EcoreElementTypes.EClassESuperTypes_3003);
		LinkToolEntry entry = new LinkToolEntry(Messages.Inheritance2CreationTool_title, Messages.Inheritance2CreationTool_desc, types);
		entry.setSmallIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/Inheritance.gif")); //$NON-NLS-1$
		entry.setLargeIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/Inheritance_24.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEAnnotationlink3CreationTool() {
		List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
		types.add(EcoreElementTypes.EAnnotationReferences_3001);
		LinkToolEntry entry = new LinkToolEntry(Messages.EAnnotationlink3CreationTool_title, Messages.EAnnotationlink3CreationTool_desc, types);
		entry.setSmallIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/AnnotationLink.gif")); //$NON-NLS-1$
		entry.setLargeIcon(EcoreDiagramEditorPlugin.findImageDescriptor("/org.eclipse.emf.ecoretools.diagram/icons/AnnotationLink_24.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description, List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description, List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
