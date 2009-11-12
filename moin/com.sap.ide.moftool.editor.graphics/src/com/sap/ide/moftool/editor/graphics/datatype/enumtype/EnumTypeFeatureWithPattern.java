package com.sap.ide.moftool.editor.graphics.datatype.enumtype;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.ide.moftool.editor.core.commands.CreateEnumTypeCommand;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.ide.moftool.editor.core.service.StyleService;
import com.sap.ide.moftool.editor.graphics.IImageConstants;
import com.sap.ide.moftool.editor.graphics.datatype.DataTypeFeaturesWithPattern;
import com.sap.ide.moftool.editor.graphics.datatype.Messages;
import com.sap.ide.moftool.editor.graphics.pattern.IMofCompartmentPatternConfiguration;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.EnumTypeUtil;
import com.sap.mi.gfw.features.IDirectEditingInfo;
import com.sap.mi.gfw.features.context.ICreateContext;
import com.sap.mi.gfw.mapping.IStructureMapping;
import com.sap.mi.gfw.mapping.IStructureMappingMulti;
import com.sap.mi.gfw.mapping.IStructureMappingSingle;
import com.sap.mi.gfw.mapping.data.IDataMapping;
import com.sap.mi.gfw.mapping.data.ITextDataMapping;
import com.sap.mi.gfw.mm.links.PictogramLink;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Property;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.mm.pictograms.Style;
import com.sap.mi.gfw.mm.pictograms.Text;
import com.sap.mi.gfw.util.IColorConstant;
import com.sap.mi.gfw.util.LinkUtil;
import com.sap.tc.moin.repository.Connection;

public class EnumTypeFeatureWithPattern extends DataTypeFeaturesWithPattern{

	public static final String FEATURE_NAME = Messages.EnumTypeFeatureWithPattern_0_xbut;

	public EnumTypeFeatureWithPattern(){
		super();        
		initConfiguration();
	}

	@Override
	protected IStructureMappingMulti[] createCompartmentMappings() {
		return new IStructureMappingMulti[] {new EnumStructuralMapping(getMappingProvider())};
	}

	@Override
	protected IStructureMappingSingle createHeaderMapping() {
		return new EnumStructurMapping(getMappingProvider());
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof EnumerationType;
	}


	@Override
	public Object[] create(ICreateContext context) {

		Namespace parentContainer = null;
		Object businessObject = getBusinessObjectForPictogramElement(context.getTargetContainer());
		// retrieve Mof Package
		if(getContainer() != null){
			parentContainer = getContainer();
		}
		else if(businessObject != null && businessObject != getContainer()){
			parentContainer  =  (Namespace) businessObject;
		} 
		Connection connection =  getFeatureProvider().getConnection();
		// Create the new class
		CreateEnumTypeCommand command = new CreateEnumTypeCommand(NamespaceService.getValidNameForNewSubobject(parentContainer,"NewEnum"), parentContainer, connection); //$NON-NLS-1$
		command.execute();

		// add the graphical representation
		addGraphicalRepresentation(context, command.getEnumType());

		activateHeaderTextAutoDirectEditing();

		// return newly created business object(s)
		return new Object[] { command.getEnumType()};
	}


	@Override
	public String getCreateName() {
		return FEATURE_NAME;
	}

	@Override
	public String getCreateImageId() {
		return IImageConstants.IMG_ENUMERATION_TYPE;
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
	public void completeInfo(IDirectEditingInfo info, Object bo, String keyProperty) {
		if (info == null || bo == null || keyProperty == null) {
			return;
		}
		PictogramElement mainPictogramElement = info.getMainPictogramElement();
		ContainerShape mainCs = (ContainerShape) mainPictogramElement;
		if (mainCs != null) {
			for (Object childShape : mainCs.getChildren()) {
				if (childShape instanceof ContainerShape) {
					ContainerShape compartmentCs = (ContainerShape) childShape;
					for (Object compartmentEntry : compartmentCs.getChildren()) {
						if (compartmentEntry instanceof Shape) {
							Shape compartmentEntryShape = (Shape) compartmentEntry;
							Object firstBusinessObjectForPictogramElement = getBusinessObjectForPictogramElement(compartmentEntryShape);
							if (bo.equals(firstBusinessObjectForPictogramElement)) {
								Property p = LinkUtil.getLinkProperty(compartmentEntryShape);
								String propertyValue = null;
								if (p != null) {
									propertyValue = p.getValue();
								}
								if (keyProperty.equals(propertyValue)) {
									GraphicsAlgorithm ga = (GraphicsAlgorithm) compartmentEntryShape
									.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(1);
									if (ga instanceof Text) {
										// <direct editing>
										if (innerSelectionIsActive) {
											if (bo instanceof EnumerationType) {
												info.setMainPictogramElement(compartmentEntryShape);
											}
										}
										// </direct editing>
										info.setPictogramElement(compartmentEntryShape);
										info.setGraphicsAlgorithm(ga);
										return;
									}
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	protected String getPackageName(IStructureMapping structureMapping, PictogramLink linkForPictogramElement){
		String ret = null;
		IDataMapping dm = structureMapping.getDataMapping();
		List<RefObject> refobjs = linkForPictogramElement.getBusinessObjects();
		if (dm instanceof ITextDataMapping && refobjs.get(0) instanceof EnumerationType) {
			ret = ((EnumDataMapping)dm).getContainerName(linkForPictogramElement);
		}
		return ret;

	}

	@Override
	protected int getAddWidth(DataType type) {
		return EnumTypeUtil.calculateASuitableWidth((EnumerationType)type);
	}

	@Override
	protected Style getTextStyle(ModelElement element) {
		if (element instanceof EnumerationType) {
			return StyleService.getEnumerationLabelStyle(getDiagram());
		}
		return null;
	}

	@Override
	protected Style getCompartmentStyle() {
		return StyleService.getEnumerationTypeStyle(getDiagram());
	}

	@Override
	protected Style getCompartmentSeparatorStyle() {
		return StyleService.getEnumerationTypeSeparatorStyle(getDiagram());
	}
}
