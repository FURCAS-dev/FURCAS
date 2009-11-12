package com.sap.ide.moftool.editor.graphics.datatype.enumtype;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;

import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.graphics.datatype.Messages;
import com.sap.ide.moftool.editor.graphics.pattern.compartment.ExpandCompartmentsCustomFeature;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.EnumTypeUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.pattern.DefaultJamFeatureProviderWithPatterns;

public class CreateLabelForEnumTypeCustomFeature extends AbstractCustomFeature{

	private static final String NAME = Messages.CreateLabelForEnumTypeCustomFeature_0_xbut;
	private static final String DESCRIPTION = Messages.CreateLabelForEnumTypeCustomFeature_1_xmsg;

	public CreateLabelForEnumTypeCustomFeature(IFeatureProvider fp) {
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
				if (bo instanceof EnumerationType) {
					if (pe instanceof ContainerShape) {
						return true;
					}
				}
			}
		}
		return ret;
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		// allow add Label to a selected Enumeration Type
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		PictogramElement firstPE = pes[0];
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(firstPE);
			if (bo instanceof EnumerationType) {
				ret = !ModelElementService.isForeignObject(getDiagram(), (EnumerationType)bo);
			}
		}
		return ret;
	}

	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		PictogramElement firstPE = pes[0];
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof EnumerationType) {
				// add new Label
				EnumerationType enumType = (EnumerationType)bo;
				int index = EnumTypeUtil.addNewLabel(enumType);
				getFeatureProvider().updateIfPossible(new UpdateContext(firstPE));
				
				// expand enumeration node after creating a new label
				ExpandCompartmentsCustomFeature expandFeature = new ExpandCompartmentsCustomFeature(getFeatureProvider());
				expandFeature.execute(context); 
				
				// switch to direct editing
				if (getFeatureProvider() instanceof DefaultJamFeatureProviderWithPatterns) {
					DefaultJamFeatureProviderWithPatterns fp = (DefaultJamFeatureProviderWithPatterns) getFeatureProvider();
					fp.activateDirectEditingForPatterns(firstPE, enumType, Integer.toString(index));

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
