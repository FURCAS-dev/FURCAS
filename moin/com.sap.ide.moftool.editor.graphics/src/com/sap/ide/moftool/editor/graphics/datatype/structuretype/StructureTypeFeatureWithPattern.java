package com.sap.ide.moftool.editor.graphics.datatype.structuretype;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.Generalizes;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.core.commands.CreateStructureTypeCommand;
import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.ide.moftool.editor.core.service.StyleService;
import com.sap.ide.moftool.editor.graphics.IImageConstants;
import com.sap.ide.moftool.editor.graphics.datatype.DataTypeFeaturesWithPattern;
import com.sap.ide.moftool.editor.graphics.datatype.Messages;
import com.sap.ide.moftool.editor.graphics.pattern.IMofCompartmentPatternConfiguration;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.AnchorUtil;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.StructureTypeUtil;
import com.sap.mi.gfw.features.context.ICreateContext;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.context.impl.AddConnectionContext;
import com.sap.mi.gfw.mapping.IStructureMapping;
import com.sap.mi.gfw.mapping.IStructureMappingMulti;
import com.sap.mi.gfw.mapping.IStructureMappingSingle;
import com.sap.mi.gfw.mapping.data.IDataMapping;
import com.sap.mi.gfw.mapping.data.ITextDataMapping;
import com.sap.mi.gfw.mm.links.PictogramLink;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.AnchorContainer;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.mm.pictograms.Style;
import com.sap.mi.gfw.util.IColorConstant;
import com.sap.mi.gfw.util.PeUtil;
import com.sap.tc.moin.repository.Connection;

public class StructureTypeFeatureWithPattern extends DataTypeFeaturesWithPattern {

	public static final String FEATURE_NAME = Messages.StructureTypeFeatureWithPattern_0_xbut;

	public StructureTypeFeatureWithPattern() {
		super();
		initConfiguration();
	}

	@Override
	protected IStructureMappingMulti[] createCompartmentMappings() {
		return new IStructureMappingMulti[] { new StructureTypeStructureFieldMapping(getMappingProvider()) };
	}

	@Override
	protected IStructureMappingSingle createHeaderMapping() {
		return new StructureTypeStructureMapping(getMappingProvider());
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof StructureType;
	}

	@Override
	public Object[] create(ICreateContext context) {

		Namespace parentContainer = null;
		Object businessObject = getBusinessObjectForPictogramElement(context.getTargetContainer());
		// retrieve Mof Package
		if (getContainer() != null) {
			parentContainer = getContainer();
		} else if (businessObject != null && businessObject != getContainer()) {
			parentContainer = (Namespace) businessObject;
		}
		Connection connection = getFeatureProvider().getConnection();
		// Create the new class
		CreateStructureTypeCommand command = new CreateStructureTypeCommand(NamespaceService.getValidNameForNewSubobject(parentContainer,
				"NewStructureType"), parentContainer, connection); //$NON-NLS-1$
		command.execute();

		// add the graphical representation
		addGraphicalRepresentation(context, command.getStructureType());

		activateHeaderTextAutoDirectEditing();

		// return newly created business object(s)
		return new Object[] { command.getStructureType() };
	}

	@Override
	public String getCreateName() {
		return FEATURE_NAME;
	}

	@Override
	public String getCreateImageId() {
		return IImageConstants.IMG_STRUCTURE_TYPE;
	}

	private void initConfiguration() {
		IMofCompartmentPatternConfiguration configuration = getConfiguration();
		configuration.setCornerWidth(0);
		configuration.setCornerHeight(0);
		configuration.setMinimumHeight(0);
		configuration.setMinimumWidth(0);
		configuration.setLineWidth(2);
		configuration.setOuterIndentTop(8);
		configuration.setTextColor(IColorConstant.BLACK);
	}

	@Override
	protected String getPackageName(IStructureMapping structureMapping, PictogramLink linkForPictogramElement) {

		String ret = null;
		IDataMapping dm = structureMapping.getDataMapping();
		List<RefObject> refobjs = linkForPictogramElement.getBusinessObjects();
		if (dm instanceof ITextDataMapping && refobjs.get(0) instanceof StructureType) {
			ret = ((StructureTypeDataMapping) dm).getContainerName(linkForPictogramElement);
		}
		return ret;

	}

	@Override
	protected int getAddWidth(DataType type) {
		return StructureTypeUtil.calculateASuitableWidth((StructureType) type);
	}

	@Override
	protected Style getTextStyle(ModelElement element) {
		if (element instanceof StructureField) {
			return StyleService.getStructureFieldStyle(getDiagram());
		}
		return null;
	}

	@Override
	protected Style getCompartmentStyle() {
		return StyleService.getStructureTypeStyle(getDiagram());
	}

	@Override
	protected Style getCompartmentSeparatorStyle() {
		return StyleService.getStructureTypeSeparatorStyle(getDiagram());
	}

	@Override
	public boolean update(IUpdateContext context) {
		boolean result = false;

		if (super.update(context)) {
			PictogramElement pe = context.getPictogramElement();
			if (pe instanceof ContainerShape) {
				ContainerShape cs = (ContainerShape) pe;
				updateGeneralizations(cs);
			}
			result = true;
		}

		return result;
	}

	private void updateGeneralizations(ContainerShape containerShape) {
		StructureType structureType = (StructureType) getBusinessObjectForPictogramElement(containerShape);
		Generalizes generalizes = MofService.getModelPackage(getConnection()).getGeneralizes();

		// Delete no longer existing generalizations from the diagram
		Collection<com.sap.mi.gfw.mm.pictograms.Connection> allToBeDeletedConnections = new ArrayList<com.sap.mi.gfw.mm.pictograms.Connection>();
		Collection<com.sap.mi.gfw.mm.pictograms.Connection> allConnections = getDiagram().getConnections();
		Iterator<com.sap.mi.gfw.mm.pictograms.Connection> connIt = allConnections.iterator();
		while (connIt.hasNext()) {
			com.sap.mi.gfw.mm.pictograms.Connection connection = connIt.next();
			if (PeUtil.getProperty(connection, MOFToolConstants.CON_PROPERTY_GENERALIZATION) != null) {
				Anchor startAnchor = connection.getStart();
				Anchor endAnchor = connection.getEnd();
				if (startAnchor != null && endAnchor != null) {
					AnchorContainer startParent = startAnchor.getParent();
					AnchorContainer endParent = endAnchor.getParent();
					if (startParent != null && endParent != null) {
						if (containerShape.equals(startParent)) {
							RefObject startObject = (RefObject) getBusinessObjectForPictogramElement(startParent);
							RefObject endObject = (RefObject) getBusinessObjectForPictogramElement(endParent);
							if (startObject != null && endObject != null) {
								if (startObject instanceof StructureType && endObject instanceof StructureType) {
									StructureType startClass = (StructureType) startObject;
									StructureType endClass = (StructureType) endObject;
									if (!generalizes.exists(endClass, startClass)) {
										allToBeDeletedConnections.add(connection);
									}
								}
							} else {
								// One of the classes is NULL -> seems to be invalid
								allToBeDeletedConnections.add(connection);
							}
						}
					}
				}
			}
		}
		// remove connection from editor
		removeGeneralizationConnections(allToBeDeletedConnections);

		// Update existing generalizations and add new ones
		Iterator<Shape> children = getDiagram().getChildren().iterator();
		while (children.hasNext()) {
			Shape otherShape = children.next();
			if (!containerShape.equals(otherShape) && otherShape instanceof ContainerShape) {
				Object bo = getBusinessObjectForPictogramElement(otherShape);
				if (bo instanceof StructureType) {
					StructureType secondStructureType = (StructureType) bo;
					if (generalizes.exists(secondStructureType, structureType)) {
						updateConnection(containerShape, otherShape, generalizes);
					}
					if (generalizes.exists(structureType, secondStructureType)) {
						updateConnection(otherShape, containerShape, generalizes);
					}
				}
			}
		}

	}

	private void removeGeneralizationConnections(Collection<com.sap.mi.gfw.mm.pictograms.Connection> connections) {
		for (Iterator<com.sap.mi.gfw.mm.pictograms.Connection> iter = connections.iterator(); iter.hasNext();) {
			com.sap.mi.gfw.mm.pictograms.Connection connection = iter.next();
			// We cannot use the remove feature here because there is no such feature
			// for generalization connections. This is disabled in feature provider to hide the
			// remove entry in the context menu of generalizations. Reason: generalizations are
			// updated together with the class.
			PeUtil.deletePictogramElement(connection);
		}
	}

	private void updateConnection(AnchorContainer from, AnchorContainer to, Object businessObject) {
		Anchor fromAnchor = AnchorUtil.getChopboxAnchor(from.getAnchors());
		Anchor toAnchor = AnchorUtil.getChopboxAnchor(to.getAnchors());

		AddConnectionContext addConnectionContext = new AddConnectionContext(fromAnchor, toAnchor);
		addConnectionContext.setNewObject(businessObject);
		getFeatureProvider().addIfPossible(addConnectionContext);
	}
}
