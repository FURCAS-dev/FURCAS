package com.sap.ide.moftool.editor.core.service;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.Font;
import com.sap.mi.gfw.mm.pictograms.LineStyleEnum;
import com.sap.mi.gfw.mm.pictograms.OrientationEnum;
import com.sap.mi.gfw.mm.pictograms.Style;
import com.sap.mi.gfw.mm.pictograms.StyleContainer;
import com.sap.mi.gfw.util.ColorConstant;
import com.sap.mi.gfw.util.GaUtil;
import com.sap.mi.gfw.util.IColorConstant;
import com.sap.mi.gfw.util.IPredefinedRenderingStyle;
import com.sap.mi.gfw.util.PackageUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;

/*
 * Hierarchy of styles:
 * Diagram(A)	Connection(A)	ConnectionArrow
 * 								ConnectionAssociationDecorator
 * 				Text			ObjectName
 * 								ObjectContainer
 * 								ConnectionDecorator
 * 								CompartmentElement(A)	Attribute
 * 														Reference
 * 														Operation
 * 														Exception
 * 														StructureTypeField
 * 														EnumerationTypeLabel
 * 				Compartment(A)	InnerCompartment		InnerWrapper
 * 								Class
 * 								StructureType
 * 								EnumerationType
 * 								Separator(A)			ClassSeparator
 * 														StructureTypeSeparator
 * 														EnumerationTypeSeparator
 */

public abstract class StyleService {

	private static final IColorConstant COLOR_SHAPE_OUTLINE = new ColorConstant(98, 131, 167);
	private static final IColorConstant COLOR_SHAPE_BACKGROUND_TOP = new ColorConstant(0xD3, 0xE7, 0xF8);

	private static final IColorConstant COLOR_CONNECTIONS = COLOR_SHAPE_OUTLINE;

	private static final IColorConstant COLOR_CLASS_OUTLINE = COLOR_SHAPE_OUTLINE;
	private static final IColorConstant COLOR_CLASS_BACKGROUND_TOP = COLOR_SHAPE_BACKGROUND_TOP;
	private static final IColorConstant COLOR_STRUCTURE_TYPE_OUTLINE = COLOR_SHAPE_OUTLINE;// IColorConstant.VC_MEDIUM_BLUE;
	private static final IColorConstant COLOR_STRUCTURE_TYPE_BACKGROUND_TOP = COLOR_SHAPE_BACKGROUND_TOP;// IColorConstant.VC_LIGHT_BLUE;
	private static final IColorConstant COLOR_ENUMERATION_TYPE_OUTLINE = COLOR_SHAPE_OUTLINE;// IColorConstant.VC_MEDIUM_GREEN;
	private static final IColorConstant COLOR_ENUMERATION_TYPE_BACKGROUND_TOP = COLOR_SHAPE_BACKGROUND_TOP;// IColorConstant.VC_LIGHT_GREEN;

	private static final String DIAGRAM_STYLE = "diagramStyle"; //$NON-NLS-1$

	private static final String CONNECTION_STYLE = "connectionStyle"; //$NON-NLS-1$
	private static final String CONNECTION_ARROW_STYLE = "connectionArrowStyle"; //$NON-NLS-1$
	private static final String CONNECTION_ASSOCIATION_DECORATOR_STYLE = "connectionAssociationDecoratorStyle"; //$NON-NLS-1$
	private static final String CONNECTION_ELLIPSE_STYLE = "connectionEllipseStyle"; //$NON-NLS-1$

	private static final String TEXT_STYLE = "textStyle"; //$NON-NLS-1$
	private static final String OBJECT_NAME_STYLE = "objectNameStyle"; //$NON-NLS-1$
	private static final String OBJECT_CONTAINER_STYLE = "objectContainerStyle"; //$NON-NLS-1$
	private static final String CONNECTION_DECORATOR_STYLE = "connectionDecoratorStyle"; //$NON-NLS-1$
	private static final String COMPARMENT_ELEMENT_STYLE = "compartmentElementStyle"; //$NON-NLS-1$
	private static final String ATTRIBUTE_STYLE = "attributeStyle"; //$NON-NLS-1$
	private static final String REFERENCE_STYLE = "referenceStyle"; //$NON-NLS-1$
	private static final String OPERATION_STYLE = "operationStyle"; //$NON-NLS-1$
	private static final String EXCEPTION_STYLE = "exceptionStyle"; //$NON-NLS-1$
	private static final String STRUCTURE_FIELD_STYLE = "structureFieldStyle"; //$NON-NLS-1$
	private static final String ENUMERATION_LABEL_STYLE = "enumLabelStyle"; //$NON-NLS-1$

	private static final String COMPARTMENT_STYLE = "compartmentStyle"; //$NON-NLS-1$
	private static final String CLASS_STYLE = "classStyle"; //$NON-NLS-1$
	private static final String STRUCTURE_TYPE_STYLE = "struTypeStyle"; //$NON-NLS-1$
	private static final String ENUMERATION_TYPE_STYLE = "enumTypeStyle"; //$NON-NLS-1$

	private static final String INNER_COMPARTMENT_STYLE = "innerCompartmentStyle"; //$NON-NLS-1$
	private static final String INNER_WRAPPER_STYLE = "innerWrapperStyle"; //$NON-NLS-1$

	private static final String SEPARATOR_STYLE = "separatorStyle"; //$NON-NLS-1$
	private static final String CLASS_SEPARATOR_STYLE = "classSeparatorStyle"; //$NON-NLS-1$
	private static final String STRUCTURE_TYPE_SEPARATOR_STYLE = "struTypeSeparatorStyle"; //$NON-NLS-1$
	private static final String ENUMERATION_TYPE_SEPARATOR_STYLE = "enumTypeSeparatorStyle"; //$NON-NLS-1$

	public static void createInitialStyles(Diagram diagram) {
		// Diagram style
		getDiagramStyle(diagram);
	}

	public static void updateExistingStyles(Diagram diagram) {
		Connection connection = ModelAdapter.getInstance().getConnection(diagram);

		// Diagram style
		Style diagramStyle = findDiagramStyle(diagram);
		if (diagramStyle != null) {
			updateDiagramStyle(diagram, connection, diagramStyle);
		}

		// Connection style
		Style connectionStyle = findConnectionStyle(diagram);
		if (connectionStyle != null) {
			updateConnectionStyle(diagram, connectionStyle);
		}

		// Connection arrow style
		Style connectionArrowStyle = findConnectionArrowStyle(diagram);
		if (connectionArrowStyle != null) {
			updateConnectionArrowStyle(connectionArrowStyle);
		}

		// Connection association decorator style
		Style connectionRhombusStyle = findConnectionAssociationDecoratorStyle(diagram);
		if (connectionRhombusStyle != null) {
			updateConnectionAssociationDecoratorStyle(diagram, connectionRhombusStyle);
		}

		// Connection ellipse style
		Style connectionEllipseStyle = findConnectionEllipseStyle(diagram);
		if (connectionEllipseStyle != null) {
			updateConnectionEllipseStyle(diagram, connectionEllipseStyle);
		}

		// Text style
		Style textStyle = findTextStyle(diagram);
		if (textStyle != null) {
			updateTextStyle(textStyle);
		}

		// Object name style
		Style objectNameStyle = findObjectNameStyle(diagram);
		if (objectNameStyle != null) {
			updateObjectNameStyle(connection, objectNameStyle);
		}

		// Object container style
		Style objectContainerStyle = findObjectContainerStyle(diagram);
		if (objectContainerStyle != null) {
			updateObjectContainerStyle(objectContainerStyle);
		}

		// Connection decorator style
		Style connectionDecoratorStyle = findConnectionDecoratorStyle(diagram);
		if (connectionDecoratorStyle != null) {
			updateConnectionDecoratorStyle(connectionDecoratorStyle);
		}

		// Compartment element style
		Style compartmentElementStyle = findCompartmentElementStyle(diagram);
		if (compartmentElementStyle != null) {
			updateCompartmentElementStyle(compartmentElementStyle);
		}

		// Attribute style
		Style attributeStyle = findAttributeStyle(diagram);
		if (attributeStyle != null) {
			updateAttributeStyle(attributeStyle);
		}

		// Reference style
		Style referenceStyle = findReferenceStyle(diagram);
		if (referenceStyle != null) {
			updateReferenceStyle(connection, referenceStyle);
		}

		// Operation style
		Style operationStyle = findOperationStyle(diagram);
		if (operationStyle != null) {
			updateOperationStyle(operationStyle);
		}

		// Exception style
		Style exceptionStyle = findExceptionStyle(diagram);
		if (exceptionStyle != null) {
			updateExceptionStyle(connection, exceptionStyle);
		}

		// Structure field style
		Style structureFieldStyle = findStructureFieldStyle(diagram);
		if (structureFieldStyle != null) {
			updateStructureFieldStyle(structureFieldStyle);
		}

		// Enumeration label style
		Style enumerationLabelStyle = findEnumerationLabelStyle(diagram);
		if (enumerationLabelStyle != null) {
			updateEnumerationLabelStyle(enumerationLabelStyle);
		}

		// Compartment style
		Style compartmentStyle = findCompartmentStyle(diagram);
		if (compartmentStyle != null) {
			updateCompartmentStyle(compartmentStyle);
		}

		// Class style
		Style classStyle = findClassStyle(diagram);
		if (classStyle != null) {
			updateClassStyle(diagram, classStyle);
		}

		// Structure type style
		Style structureTypeStyle = findStructureTypeStyle(diagram);
		if (structureTypeStyle != null) {
			updateStructureTypeStyle(diagram, structureTypeStyle);
		}

		// Enumeration type style
		Style enumerationTypeStyle = findEnumerationTypeStyle(diagram);
		if (enumerationTypeStyle != null) {
			updateEnumerationTypeStyle(diagram, enumerationTypeStyle);
		}

		// Separator style
		Style separatorStyle = findSeparatorStyle(diagram);
		if (separatorStyle != null) {
			updateSeparatorStyle(separatorStyle);
		}

		// Class separator style
		Style classSeparatorStyle = findClassSeparatorStyle(diagram);
		if (classSeparatorStyle != null) {
			updateClassSeparatorStyle(diagram, classSeparatorStyle);
		}

		// Structure type separator style
		Style structureTypeSeparatorStyle = findStructureTypeSeparatorStyle(diagram);
		if (structureTypeSeparatorStyle != null) {
			updateStructureTypeSeparatorStyle(diagram, structureTypeSeparatorStyle);
		}

		// Enumeration type separator style
		Style enumerationTypeSeparatorStyle = findEnumerationTypeSeparatorStyle(diagram);
		if (enumerationTypeSeparatorStyle != null) {
			updateEnumerationTypeSeparatorStyle(diagram, enumerationTypeSeparatorStyle);
		}

		// Inner compartment style
		Style innerCompartmentStyle = findInnerCompartmentStyle(diagram);
		if (innerCompartmentStyle != null) {
			updateInnerCompartmentStyle(innerCompartmentStyle);
		}

		// Inner wrapper style
		Style innerWrapperStyle = findInnerWrapperStyle(diagram);
		if (innerWrapperStyle != null) {
			updateInnerWrapperStyle(innerWrapperStyle);
		}
	}

	/*
	 * Diagram style Not used directly
	 */

	private static Style findDiagramStyle(StyleContainer container) {
		Style diagramStyle = GaUtil.findStyle(container, DIAGRAM_STYLE);
		return diagramStyle;
	}

	public static Style getDiagramStyle(Diagram diagram) {
		Style diagramStyle = findDiagramStyle(diagram);
		if (diagramStyle == null) {
			// No style exists so far -> create it
			diagramStyle = GaUtil.createStyle(diagram, DIAGRAM_STYLE);
			diagramStyle.setDescription(""); //$NON-NLS-1$
			updateDiagramStyle(diagram, ModelAdapter.getInstance().getConnection(diagram), diagramStyle);
		}
		return diagramStyle;
	}

	private static void updateDiagramStyle(Diagram diagram, Connection connection, Style diagramStyle) {
		diagramStyle.setForeground(GaUtil.manageColor(diagram, IColorConstant.BLACK));
		diagramStyle.setBackground(GaUtil.manageColor(diagram, IColorConstant.WHITE));
		diagramStyle.setTransparency(0d);
		diagramStyle.setFilled(true);
		diagramStyle.setStretchH(false);
		diagramStyle.setStretchV(false);
		diagramStyle.setAngle(0);
		Font font = (Font) PackageUtil.getPictogramsPackage(connection).getFont().refCreateInstance();
		font.setName("Arial"); //$NON-NLS-1$
		font.setSize(8);
		font.setBold(false);
		font.setItalic(false);
		((Partitionable) font).assign___PartitionIncludingChildren((((Partitionable) diagram).get___Partition()));
		Font oldFont = diagramStyle.getFont();
		diagramStyle.setFont(font);
		if (oldFont != null) {// remove old font from the transient partition
			oldFont.refDelete();
		}
		diagramStyle.setHorizontalAlignment(OrientationEnum.ALIGNMENT_LEFT);
		diagramStyle.setVerticalAlignment(OrientationEnum.ALIGNMENT_CENTER);
		diagramStyle.setProportional(false);
		diagramStyle.setLineStyle(LineStyleEnum.SOLID);
		diagramStyle.setLineWidth(1);
		diagramStyle.setLineVisible(true);
	}

	/*
	 * Connection style (parent diagram style) Not used directly
	 */

	private static Style findConnectionStyle(StyleContainer container) {
		Style connectionStyle = GaUtil.findStyle(container, CONNECTION_STYLE);
		return connectionStyle;
	}

	private static Style getConnectionStyle(Diagram diagram) {
		Style connectionStyle = findConnectionStyle(diagram);
		if (connectionStyle == null) {
			StyleContainer container = getDiagramStyle(diagram);
			connectionStyle = createIgnoringStyle(container, CONNECTION_STYLE);
			updateConnectionStyle(diagram, connectionStyle);
		}
		return connectionStyle;
	}

	private static void updateConnectionStyle(Diagram diagram, Style connectionStyle) {
		connectionStyle.setLineWidth(1);
		connectionStyle.setForeground(GaUtil.manageColor(diagram, COLOR_CONNECTIONS));
	}

	public static Style getAssociationStyle(Diagram diagram) {
		return getConnectionStyle(diagram);
	}

	public static Style getGeneralizationStyle(Diagram diagram) {
		return getConnectionStyle(diagram);
	}

	public static Style getDataTypeContainmentStyle(Diagram diagram) {
		return getConnectionStyle(diagram);
	}

	/*
	 * Connection arrow style (parent connection style) Used for composition connection arrows
	 */

	private static Style findConnectionArrowStyle(StyleContainer container) {
		Style connectionArrowStyle = GaUtil.findStyle(container, CONNECTION_ARROW_STYLE);
		return connectionArrowStyle;
	}

	public static Style getConnectionArrowStyle(Diagram diagram) {
		Style connectionArrowStyle = findConnectionArrowStyle(diagram);
		if (connectionArrowStyle == null) {
			StyleContainer container = getConnectionStyle(diagram);
			connectionArrowStyle = createIgnoringStyle(container, CONNECTION_ARROW_STYLE);
			updateConnectionArrowStyle(connectionArrowStyle);
		}
		return connectionArrowStyle;
	}

	private static void updateConnectionArrowStyle(Style connectionStyle) {
		// Nothing to do
	}

	/*
	 * Association decorator style (parent connection style). Used for the line decorators of association ends
	 */

	private static Style findConnectionAssociationDecoratorStyle(StyleContainer container) {
		Style connectionAssociationDecoratorStyle = GaUtil.findStyle(container, CONNECTION_ASSOCIATION_DECORATOR_STYLE);
		return connectionAssociationDecoratorStyle;
	}

	public static Style getConnectionAssociationDecoratorStyle(Diagram diagram) {
		Style connectionAssociationDecoratorStyle = findConnectionAssociationDecoratorStyle(diagram);
		if (connectionAssociationDecoratorStyle == null) {
			StyleContainer container = getConnectionStyle(diagram);
			connectionAssociationDecoratorStyle = createIgnoringStyle(container, CONNECTION_ASSOCIATION_DECORATOR_STYLE);
			updateConnectionAssociationDecoratorStyle(diagram, connectionAssociationDecoratorStyle);
		}
		return connectionAssociationDecoratorStyle;
	}

	private static void updateConnectionAssociationDecoratorStyle(Diagram diagram, Style connectionAssociationDecoratorStyle) {
		connectionAssociationDecoratorStyle.setBackground(GaUtil.manageColor(diagram, COLOR_CONNECTIONS));
		connectionAssociationDecoratorStyle.setFilled(true);
	}

	/*
	 * Connection ellipse style (parent connection style) Used for the ellipse shaped connection end of inner data types (will be that shape
	 * in the future, currently a rectangle is used)
	 */

	private static Style findConnectionEllipseStyle(StyleContainer container) {
		Style connectionEllipseStyle = GaUtil.findStyle(container, CONNECTION_ELLIPSE_STYLE);
		return connectionEllipseStyle;
	}

	public static Style getConnectionEllipseStyle(Diagram diagram) {
		Style connectionEllipseStyle = findConnectionEllipseStyle(diagram);
		if (connectionEllipseStyle == null) {
			StyleContainer container = getConnectionStyle(diagram);
			connectionEllipseStyle = createIgnoringStyle(container, CONNECTION_ELLIPSE_STYLE);
			updateConnectionEllipseStyle(diagram, connectionEllipseStyle);
		}
		return connectionEllipseStyle;
	}

	private static void updateConnectionEllipseStyle(Diagram diagram, Style connectionEllipseStyle) {
		// nothing to do
	}

	/*
	 * Text style (parent diagram style) Not used directly
	 */

	private static Style findTextStyle(StyleContainer container) {
		Style textStyle = GaUtil.findStyle(container, TEXT_STYLE);
		return textStyle;
	}

	private static Style getTextStyle(Diagram diagram) {
		Style textStyle = findTextStyle(diagram);
		if (textStyle == null) {
			StyleContainer container = getDiagramStyle(diagram);
			textStyle = createIgnoringStyle(container, TEXT_STYLE);
			updateTextStyle(textStyle);
		}
		return textStyle;
	}

	private static void updateTextStyle(Style textStyle) {
		// Nothing to do
	}

	/*
	 * Object name style (parent text style) Used for the text field for object names
	 */

	private static Style findObjectNameStyle(StyleContainer container) {
		Style objectNameStyle = GaUtil.findStyle(container, OBJECT_NAME_STYLE);
		return objectNameStyle;
	}

	public static Style getObjectNameStyle(Diagram diagram) {
		Style objectNameStyle = findObjectNameStyle(diagram);
		if (objectNameStyle == null) {
			StyleContainer container = getTextStyle(diagram);
			objectNameStyle = createIgnoringStyle(container, OBJECT_NAME_STYLE);
			updateObjectNameStyle(ModelAdapter.getInstance().getConnection(diagram), objectNameStyle);
		}
		return objectNameStyle;
	}

	private static void updateObjectNameStyle(Connection connection, Style objectNameStyle) {
		updateObjectContainerStyle(objectNameStyle);
		Font font = (Font) PackageUtil.getPictogramsPackage(connection).getFont().refCreateInstance();
		font.setName("Arial"); //$NON-NLS-1$
		font.setSize(8);
		font.setBold(true);
		font.setItalic(false);
		((Partitionable) font).assign___PartitionIncludingChildren((((Partitionable) objectNameStyle).get___Partition()));
		Font oldFont = objectNameStyle.getFont();
		objectNameStyle.setFont(font);
		if (oldFont != null) {// remove old font from the transient partition
			oldFont.refDelete();
		}
	}

	/*
	 * Object container style (parent text style) Used for the text field for object containers (for classes the package, for data types the
	 * containing package or class)
	 */

	private static Style findObjectContainerStyle(StyleContainer container) {
		Style objectContainerStyle = GaUtil.findStyle(container, OBJECT_CONTAINER_STYLE);
		return objectContainerStyle;
	}

	public static Style getObjectContainerStyle(Diagram diagram) {
		Style objectContainerStyle = findObjectContainerStyle(diagram);
		if (objectContainerStyle == null) {
			StyleContainer container = getTextStyle(diagram);
			objectContainerStyle = createIgnoringStyle(container, OBJECT_CONTAINER_STYLE);
			updateObjectContainerStyle(objectContainerStyle);
		}
		return objectContainerStyle;
	}

	private static void updateObjectContainerStyle(Style objectContainerStyle) {
		objectContainerStyle.setHorizontalAlignment(OrientationEnum.ALIGNMENT_CENTER);
	}

	/*
	 * Connection decorator style (parent text style) Used for all connection decorators (association name, association end name,
	 * association end multiplicity)
	 */

	private static Style findConnectionDecoratorStyle(StyleContainer container) {
		Style connectionDecoratorStyle = GaUtil.findStyle(container, CONNECTION_DECORATOR_STYLE);
		return connectionDecoratorStyle;
	}

	public static Style getConnectionDecoratorStyle(Diagram diagram) {
		Style connectionDecoratorStyle = findConnectionDecoratorStyle(diagram);
		if (connectionDecoratorStyle == null) {
			StyleContainer container = getTextStyle(diagram);
			connectionDecoratorStyle = createIgnoringStyle(container, CONNECTION_DECORATOR_STYLE);
			updateConnectionDecoratorStyle(connectionDecoratorStyle);
		}
		return connectionDecoratorStyle;
	}

	private static void updateConnectionDecoratorStyle(Style connectionDecoratorStyle) {
		// Nothing to do
	}

	/*
	 * Compartment element style (parent text style) Not used directly
	 */

	private static Style findCompartmentElementStyle(StyleContainer container) {
		Style compartmentElementStyle = GaUtil.findStyle(container, COMPARMENT_ELEMENT_STYLE);
		return compartmentElementStyle;
	}

	private static Style getCompartmentElementStyle(Diagram diagram) {
		Style compartmentElementStyle = findCompartmentElementStyle(diagram);
		if (compartmentElementStyle == null) {
			StyleContainer container = getTextStyle(diagram);
			compartmentElementStyle = createIgnoringStyle(container, COMPARMENT_ELEMENT_STYLE);
			updateCompartmentElementStyle(compartmentElementStyle);
		}
		return compartmentElementStyle;
	}

	private static void updateCompartmentElementStyle(Style compartmentElementStyle) {
		// Nothing to do
	}

	/*
	 * Attribute style (parent compartment element style) Used for attributes in classes
	 */

	private static Style findAttributeStyle(StyleContainer container) {
		Style attributeStyle = GaUtil.findStyle(container, ATTRIBUTE_STYLE);
		return attributeStyle;
	}

	public static Style getAttributeStyle(Diagram diagram) {
		Style attributeStyle = findAttributeStyle(diagram);
		if (attributeStyle == null) {
			StyleContainer container = getCompartmentElementStyle(diagram);
			attributeStyle = createIgnoringStyle(container, ATTRIBUTE_STYLE);
			updateAttributeStyle(attributeStyle);
		}
		return attributeStyle;
	}

	private static void updateAttributeStyle(Style attributeStyle) {
		// Nothing to do
	}

	/*
	 * Reference style (parent compartment element style) Used for references in classes
	 */

	private static Style findReferenceStyle(StyleContainer container) {
		Style referenceStyle = GaUtil.findStyle(container, REFERENCE_STYLE);
		return referenceStyle;
	}

	public static Style getReferenceStyle(Diagram diagram) {
		Style referenceStyle = findReferenceStyle(diagram);
		if (referenceStyle == null) {
			StyleContainer container = getCompartmentElementStyle(diagram);
			referenceStyle = createIgnoringStyle(container, REFERENCE_STYLE);
			updateReferenceStyle(ModelAdapter.getInstance().getConnection(diagram), referenceStyle);
		}
		return referenceStyle;
	}

	private static void updateReferenceStyle(Connection connection, Style referenceStyle) {
		Font font = (Font) PackageUtil.getPictogramsPackage(connection).getFont().refCreateInstance();
		font.setName("Arial"); //$NON-NLS-1$
		font.setSize(8);
		font.setBold(false);
		font.setItalic(true);
		((Partitionable) font).assign___PartitionIncludingChildren((((Partitionable) referenceStyle).get___Partition()));
		Font oldFont = referenceStyle.getFont();
		referenceStyle.setFont(font);
		if (oldFont != null) {// remove old font from the transient partition
			oldFont.refDelete();
		}
	}

	/*
	 * Operation style (parent compartment element style) Used for operations in classes
	 */

	private static Style findOperationStyle(StyleContainer container) {
		Style operationStyle = GaUtil.findStyle(container, OPERATION_STYLE);
		return operationStyle;
	}

	public static Style getOperationStyle(Diagram diagram) {
		Style operationStyle = findOperationStyle(diagram);
		if (operationStyle == null) {
			StyleContainer container = getCompartmentElementStyle(diagram);
			operationStyle = createIgnoringStyle(container, OPERATION_STYLE);
			updateOperationStyle(operationStyle);
		}
		return operationStyle;
	}

	private static void updateOperationStyle(Style operationStyle) {
		// Nothing to do
	}

	/*
	 * Exception style (parent compartment element style) Used for exceptions in classes
	 */

	private static Style findExceptionStyle(StyleContainer container) {
		Style exceptionStyle = GaUtil.findStyle(container, EXCEPTION_STYLE);
		return exceptionStyle;
	}

	public static Style getExceptionStyle(Diagram diagram) {
		Style exceptionStyle = findExceptionStyle(diagram);
		if (exceptionStyle == null) {
			StyleContainer container = getCompartmentElementStyle(diagram);
			exceptionStyle = createIgnoringStyle(container, EXCEPTION_STYLE);
			updateExceptionStyle(ModelAdapter.getInstance().getConnection(diagram), exceptionStyle);
		}
		return exceptionStyle;
	}

	private static void updateExceptionStyle(Connection connection, Style exceptionStyle) {
		Font font = connection.createElementInPartition(Font.class, exceptionStyle.get___Partition());
		font.setName("Arial"); //$NON-NLS-1$
		font.setSize(8);
		font.setBold(false);
		font.setItalic(true);
		Font oldFont = exceptionStyle.getFont();
		exceptionStyle.setFont(font);
		if (oldFont != null) {// remove old font from the transient partition
			oldFont.refDelete();
		}
	}

	/*
	 * Structure field style (parent compartment element style) Used for structure fields in structure types
	 */

	private static Style findStructureFieldStyle(StyleContainer container) {
		Style structureFieldStyle = GaUtil.findStyle(container, STRUCTURE_FIELD_STYLE);
		return structureFieldStyle;
	}

	public static Style getStructureFieldStyle(Diagram diagram) {
		Style structureFieldStyle = findStructureFieldStyle(diagram);
		if (structureFieldStyle == null) {
			StyleContainer container = getCompartmentElementStyle(diagram);
			structureFieldStyle = createIgnoringStyle(container, STRUCTURE_FIELD_STYLE);
			updateStructureFieldStyle(structureFieldStyle);
		}
		return structureFieldStyle;
	}

	private static void updateStructureFieldStyle(Style structureFieldStyle) {
		// Nothing to do
	}

	/*
	 * Enumeration label style (parent compartment element style) Used for labels in enumeration types
	 */

	private static Style findEnumerationLabelStyle(StyleContainer container) {
		Style enumerationLabelStyle = GaUtil.findStyle(container, ENUMERATION_LABEL_STYLE);
		return enumerationLabelStyle;
	}

	public static Style getEnumerationLabelStyle(Diagram diagram) {
		Style enumerationLabelStyle = findEnumerationLabelStyle(diagram);
		if (enumerationLabelStyle == null) {
			StyleContainer container = getCompartmentElementStyle(diagram);
			enumerationLabelStyle = createIgnoringStyle(container, ENUMERATION_LABEL_STYLE);
			updateEnumerationLabelStyle(enumerationLabelStyle);
		}
		return enumerationLabelStyle;
	}

	private static void updateEnumerationLabelStyle(Style enumerationLabelStyle) {
		// Nothing to do
	}

	/*
	 * Compartment style (parent diagram style) Not used directly
	 */

	private static Style findCompartmentStyle(StyleContainer container) {
		Style compartmentStyle = GaUtil.findStyle(container, COMPARTMENT_STYLE);
		return compartmentStyle;
	}

	private static Style getCompartmentStyle(Diagram diagram) {
		Style compartmentStyle = findCompartmentStyle(diagram);
		if (compartmentStyle == null) {
			StyleContainer container = getDiagramStyle(diagram);
			compartmentStyle = createIgnoringStyle(container, COMPARTMENT_STYLE);
			updateCompartmentStyle(compartmentStyle);
		}
		return compartmentStyle;
	}

	private static void updateCompartmentStyle(Style compartmentStyle) {
		// NOthing to do
	}

	/*
	 * Inner compartment style (parent compartment style) Used for the inner compartments of the MOF compartment pattern
	 */

	private static Style findInnerCompartmentStyle(StyleContainer container) {
		Style innerCompartmentStyle = GaUtil.findStyle(container, INNER_COMPARTMENT_STYLE);
		return innerCompartmentStyle;
	}

	public static Style getInnerCompartmentStyle(Diagram diagram) {
		Style innerCompartmentStyle = findInnerCompartmentStyle(diagram);
		if (innerCompartmentStyle == null) {
			StyleContainer container = getCompartmentStyle(diagram);
			innerCompartmentStyle = createIgnoringStyle(container, INNER_COMPARTMENT_STYLE);
			updateInnerCompartmentStyle(innerCompartmentStyle);
		}
		return innerCompartmentStyle;
	}

	private static void updateInnerCompartmentStyle(Style innerCompartmentStyle) {
		innerCompartmentStyle.setFilled(false);
		innerCompartmentStyle.setLineVisible(false);
	}

	/*
	 * Inner wrapper style (parent inner compartment style) Used for the inner wrapper objects in the compartments of the MOF compartment
	 * pattern (e.g. rectangles around attributes
	 */

	private static Style findInnerWrapperStyle(StyleContainer container) {
		Style innerWrapperStyle = GaUtil.findStyle(container, INNER_WRAPPER_STYLE);
		return innerWrapperStyle;
	}

	public static Style getInnerWrapperStyle(Diagram diagram) {
		Style innerWrapperStyle = findInnerWrapperStyle(diagram);
		if (innerWrapperStyle == null) {
			StyleContainer container = getInnerCompartmentStyle(diagram);
			innerWrapperStyle = createIgnoringStyle(container, INNER_WRAPPER_STYLE);
			updateInnerWrapperStyle(innerWrapperStyle);
		}
		return innerWrapperStyle;
	}

	private static void updateInnerWrapperStyle(Style innerWrapperStyle) {
		// Nothing to do
	}

	/*
	 * Class style (parent compartment style) Used for the class compartment pattern
	 */

	private static Style findClassStyle(StyleContainer container) {
		Style classStyle = GaUtil.findStyle(container, CLASS_STYLE);
		return classStyle;
	}

	public static Style getClassStyle(Diagram diagram) {
		Style classStyle = findClassStyle(diagram);
		if (classStyle == null) {
			StyleContainer container = getCompartmentStyle(diagram);
			classStyle = createIgnoringStyle(container, CLASS_STYLE);
			updateClassStyle(diagram, classStyle);
		}
		return classStyle;
	}

	private static void updateClassStyle(Diagram diagram, Style classStyle) {
		updateClassSeparatorStyle(diagram, classStyle);
		classStyle.setForeground(GaUtil.manageColor(diagram, COLOR_CLASS_OUTLINE));
		classStyle.setBackground(GaUtil.manageColor(diagram, COLOR_CLASS_BACKGROUND_TOP));
		GaUtil.setRenderingStyle(classStyle, IPredefinedRenderingStyle.BLUE_WHITE_ID);
	}

	/*
	 * Structure type style (parent compartment style) Used for the structure type compartment pattern
	 */

	private static Style findStructureTypeStyle(StyleContainer container) {
		Style structureTypeStyle = GaUtil.findStyle(container, STRUCTURE_TYPE_STYLE);
		return structureTypeStyle;
	}

	public static Style getStructureTypeStyle(Diagram diagram) {
		Style structureTypeStyle = findStructureTypeStyle(diagram);
		if (structureTypeStyle == null) {
			StyleContainer container = getCompartmentStyle(diagram);
			structureTypeStyle = createIgnoringStyle(container, STRUCTURE_TYPE_STYLE);
			updateStructureTypeStyle(diagram, structureTypeStyle);
		}
		return structureTypeStyle;
	}

	private static void updateStructureTypeStyle(Diagram diagram, Style structureTypeStyle) {
		updateStructureTypeSeparatorStyle(diagram, structureTypeStyle);
		structureTypeStyle.setForeground(GaUtil.manageColor(diagram, COLOR_STRUCTURE_TYPE_OUTLINE));
		structureTypeStyle.setBackground(GaUtil.manageColor(diagram, COLOR_STRUCTURE_TYPE_BACKGROUND_TOP));
		GaUtil.setRenderingStyle(structureTypeStyle, IPredefinedRenderingStyle.BLUE_WHITE_ID);
	}

	/*
	 * Enumeration type style (parent compartment style) Used for the enumeration type compartment pattern
	 */

	private static Style findEnumerationTypeStyle(StyleContainer container) {
		Style enumerationTypeStyle = GaUtil.findStyle(container, ENUMERATION_TYPE_STYLE);
		return enumerationTypeStyle;
	}

	public static Style getEnumerationTypeStyle(Diagram diagram) {
		Style enumerationTypeStyle = findEnumerationTypeStyle(diagram);
		if (enumerationTypeStyle == null) {
			StyleContainer container = getCompartmentStyle(diagram);
			enumerationTypeStyle = createIgnoringStyle(container, ENUMERATION_TYPE_STYLE);
			updateEnumerationTypeStyle(diagram, enumerationTypeStyle);
		}
		return enumerationTypeStyle;
	}

	private static void updateEnumerationTypeStyle(Diagram diagram, Style enumerationTypeStyle) {
		enumerationTypeStyle.setForeground(GaUtil.manageColor(diagram, COLOR_ENUMERATION_TYPE_OUTLINE));
		enumerationTypeStyle.setBackground(GaUtil.manageColor(diagram, COLOR_ENUMERATION_TYPE_BACKGROUND_TOP));
		GaUtil.setRenderingStyle(enumerationTypeStyle, IPredefinedRenderingStyle.BLUE_WHITE_ID);
	}

	/*
	 * Separator style (parent compartment style) Not used directly
	 */

	private static Style findSeparatorStyle(StyleContainer container) {
		Style separatorStyle = GaUtil.findStyle(container, SEPARATOR_STYLE);
		return separatorStyle;
	}

	private static Style getSeparatorStyle(Diagram diagram) {
		Style separatorStyle = findSeparatorStyle(diagram);
		if (separatorStyle == null) {
			StyleContainer container = getCompartmentStyle(diagram);
			separatorStyle = createIgnoringStyle(container, SEPARATOR_STYLE);
			updateSeparatorStyle(separatorStyle);
		}
		return separatorStyle;
	}

	private static void updateSeparatorStyle(Style separatorStyle) {
		// Nothing to do
	}

	/*
	 * Class separator style (parent separator style) Used for the separator in the class compartment pattern
	 */

	private static Style findClassSeparatorStyle(StyleContainer container) {
		Style classSeparatorStyle = GaUtil.findStyle(container, CLASS_SEPARATOR_STYLE);
		return classSeparatorStyle;
	}

	public static Style getClassSeparatorStyle(Diagram diagram) {
		Style classSeparatorStyle = findClassSeparatorStyle(diagram);
		if (classSeparatorStyle == null) {
			StyleContainer container = getSeparatorStyle(diagram);
			classSeparatorStyle = createIgnoringStyle(container, CLASS_SEPARATOR_STYLE);
			updateClassSeparatorStyle(diagram, classSeparatorStyle);
		}
		return classSeparatorStyle;
	}

	private static void updateClassSeparatorStyle(Diagram diagram, Style classSeparatorStyle) {
		classSeparatorStyle.setForeground(GaUtil.manageColor(diagram, COLOR_CLASS_OUTLINE));
	}

	/*
	 * Structure type separator style (parent separator style) Used for the separator in the structure type compartment pattern
	 */

	private static Style findStructureTypeSeparatorStyle(StyleContainer container) {
		Style structureTypeSeparatorStyle = GaUtil.findStyle(container, STRUCTURE_TYPE_SEPARATOR_STYLE);
		return structureTypeSeparatorStyle;
	}

	public static Style getStructureTypeSeparatorStyle(Diagram diagram) {
		Style structureTypeSeparatorStyle = findStructureTypeSeparatorStyle(diagram);
		if (structureTypeSeparatorStyle == null) {
			StyleContainer container = getSeparatorStyle(diagram);
			structureTypeSeparatorStyle = createIgnoringStyle(container, STRUCTURE_TYPE_SEPARATOR_STYLE);
			updateStructureTypeSeparatorStyle(diagram, structureTypeSeparatorStyle);
		}
		return structureTypeSeparatorStyle;
	}

	private static void updateStructureTypeSeparatorStyle(Diagram diagram, Style structureTypeSeparatorStyle) {
		structureTypeSeparatorStyle.setForeground(GaUtil.manageColor(diagram, COLOR_STRUCTURE_TYPE_OUTLINE));
	}

	/*
	 * Enumeration type separator style (parent separator style) Used for the separator in the enumeration compartment pattern
	 */

	private static Style findEnumerationTypeSeparatorStyle(StyleContainer container) {
		Style enumerationTypeSeparatorStyle = GaUtil.findStyle(container, ENUMERATION_TYPE_SEPARATOR_STYLE);
		return enumerationTypeSeparatorStyle;
	}

	public static Style getEnumerationTypeSeparatorStyle(Diagram diagram) {
		Style enumerationTypeSeparatorStyle = findEnumerationTypeSeparatorStyle(diagram);
		if (enumerationTypeSeparatorStyle == null) {
			StyleContainer container = getSeparatorStyle(diagram);
			enumerationTypeSeparatorStyle = createIgnoringStyle(container, ENUMERATION_TYPE_SEPARATOR_STYLE);
			updateEnumerationTypeSeparatorStyle(diagram, enumerationTypeSeparatorStyle);
		}
		return enumerationTypeSeparatorStyle;
	}

	private static void updateEnumerationTypeSeparatorStyle(Diagram diagram, Style enumerationTypeSeparatorStyle) {
		enumerationTypeSeparatorStyle.setForeground(GaUtil.manageColor(diagram, COLOR_ENUMERATION_TYPE_OUTLINE));
	}

	private static Style createIgnoringStyle(StyleContainer container, String id) {
		Style style = GaUtil.createStyle(container, id);
		style.setDescription(""); //$NON-NLS-1$
		GaUtil.ignoreAll(style);

		return style;
	}
}
