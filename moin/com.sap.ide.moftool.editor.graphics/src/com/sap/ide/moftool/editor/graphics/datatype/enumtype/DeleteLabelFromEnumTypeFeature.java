package com.sap.ide.moftool.editor.graphics.datatype.enumtype;

import java.text.MessageFormat;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;

import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.graphics.ClassDiagramFeatureProvider;
import com.sap.ide.moftool.editor.graphics.datatype.Messages;
import com.sap.ide.moftool.editor.graphics.pattern.AbstractMofCompartmentPattern;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IDeleteContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.features.jam.DefaultDeleteFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Property;
import com.sap.mi.gfw.pattern.IPattern;
import com.sap.mi.gfw.util.LinkUtil;

public class DeleteLabelFromEnumTypeFeature extends DefaultDeleteFeature {
	private static final String NAME = Messages.DeleteLabelFromEnumTypeFeature_0_xbut;
	private static final String DESCRIPTION = Messages.DeleteLabelFromEnumTypeFeature_1_xmsg;
	private String label ;
	private boolean mAskUser = true;

	public DeleteLabelFromEnumTypeFeature(IFeatureProvider fp) {
		super(fp);      
	}

	@Override
	public boolean isAvailable(IContext context) {     
		boolean ret = false;
		if (context instanceof IDeleteContext) {
			PictogramElement pe = ((IDeleteContext)context).getPictogramElement();
			if (pe != null) {
				Object bo = getBusinessObjectForPictogramElement(pe);
				if (bo instanceof EnumerationType) {
					Property property = LinkUtil.getLinkProperty(pe);
					if (property != null && property.getValue() != null) {
						ret = true;
					} else {
						ret = false;
					}
				}
			}
		}
		return ret;
	}

	@Override
	public boolean canDelete(IDeleteContext context) {
		// allow to delete Label from a selected EnumerationType
		boolean ret = false;
		PictogramElement pe = context.getPictogramElement();
		if (pe != null) {
			Object bo = getBusinessObjectForPictogramElement(pe);
			if (bo instanceof EnumerationType) {
				EnumerationType enumType = (EnumerationType)bo;
				List<String> labels = enumType.getLabels();
				Property property = LinkUtil.getLinkProperty(pe);
				if (property != null && property.getValue() != null) {
					int index = Integer.valueOf(property.getValue()).intValue();
					if (index != -1) {
						label = labels.get(index);
						ret = !ModelElementService.isForeignObject(getDiagram(), enumType);
					} else {
						ret = false;
					}
				}
			}
		}
		return ret;
	}

	@Override
	public void delete(IDeleteContext context) {    
		PictogramElement pe = context.getPictogramElement();
		if (pe != null) {
			Object bo = getBusinessObjectForPictogramElement(pe);
			if (bo instanceof EnumerationType) {
				EnumerationType enumType = (EnumerationType)bo;
				List<String> labels = enumType.getLabels();
				Property property = LinkUtil.getLinkProperty(pe);
				int index = Integer.valueOf(property.getValue()).intValue();
				if (index != -1) {
					labels.remove(index);
				}
				// Update the pictogram element of the pattern root
				IFeatureProvider featureProvider = getFeatureProvider();
				if (featureProvider instanceof ClassDiagramFeatureProvider) {
					IPattern pattern = ((ClassDiagramFeatureProvider)featureProvider).getPatternForPictogramElement(pe);
					if (pattern instanceof AbstractMofCompartmentPattern) {
						AbstractMofCompartmentPattern mofPattern = (AbstractMofCompartmentPattern)pattern;
						getFeatureProvider().updateIfPossible(new UpdateContext(mofPattern.getPatternRoot(pe)));
					}
				}
			}
		}
	}

	@Override
	public String getName(){
		return NAME;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	public void setAskUser(boolean ask) {
		mAskUser = ask;
	}

	@Override
	protected String getQuestionToUser() {
		if (mAskUser) {
//			return "Do you really want to delete " + label +"?";
			return MessageFormat.format(Messages.DeleteLabelFromEnumTypeFeature_2_xmsg, new Object[]{label});
		}
		else {
			return null;
		}
	}
}
