package com.sap.ide.moftool.editor.graphics.datatype.structuretype;

import com.sap.tc.moin.repository.mmi.model.StructureType;

import com.sap.ide.moftool.editor.core.commands.CreateStructureFieldCommand;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.graphics.datatype.Messages;
import com.sap.ide.moftool.editor.graphics.pattern.compartment.ExpandCompartmentsCustomFeature;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.StructureTypeUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.pattern.DefaultJamFeatureProviderWithPatterns;

public class CreateStructureFieldForStructureTypeFeature  extends AbstractCustomFeature{

	private static final String NAME = Messages.CreateStructureFieldForStructureTypeFeature_0_xbut;
	private static final String DESCRIPTION = Messages.CreateStructureFieldForStructureTypeFeature_1_xmsg;

	public CreateStructureFieldForStructureTypeFeature(IFeatureProvider fp) {
		super(fp);       
	}

	@Override
	public boolean isAvailable(IContext context) {
		boolean ret = false;
		if (context instanceof ICustomContext) {
			PictogramElement[] pes = ((ICustomContext) context).getPictogramElements();
			if (pes != null && pes.length == 1) {
				PictogramElement pe = pes[0];
				Object bo = getBusinessObjectForPictogramElement(pe);
				if (bo instanceof StructureType) {
					return true;
				}
			}
		}
		return ret;
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		// allow add Structure Field to a selected Structure Type
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		PictogramElement firstPE = pes[0];
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(firstPE);
			if (bo instanceof StructureType) {
				ret = !ModelElementService.isForeignObject(getDiagram(), (StructureType)bo);
			}
		}
		return ret;
	}

	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		PictogramElement firstPE = pes[0];
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof StructureType) {
				// add new Label
				StructureType structureType = (StructureType) bo;

				CreateStructureFieldCommand command = new CreateStructureFieldCommand(
						StructureTypeUtil.getNextStructureFieldName(structureType), structureType, getConnection());
				command.execute();
				getFeatureProvider().updateIfPossible(new UpdateContext(firstPE));
				
				// expand structure node after creating a new field
				ExpandCompartmentsCustomFeature expandFeature = new ExpandCompartmentsCustomFeature(getFeatureProvider());
				expandFeature.execute(context); 
				
				// switch to direct editing
				if (getFeatureProvider() instanceof DefaultJamFeatureProviderWithPatterns) {
					DefaultJamFeatureProviderWithPatterns fp = (DefaultJamFeatureProviderWithPatterns) getFeatureProvider();
					fp.activateDirectEditingForPatterns(firstPE, command.getStructureField());

				}
			}
		}

	}

	public String getName() {
		return NAME;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

}
