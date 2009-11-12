package com.sap.ide.moftool.editor.graphics.clazz.attribute;

import java.text.MessageFormat;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.graphics.ClassDiagramFeatureProvider;
import com.sap.ide.moftool.editor.graphics.clazz.Messages;
import com.sap.ide.moftool.editor.graphics.pattern.AbstractMofCompartmentPattern;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ClassUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IDeleteContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.features.jam.DefaultDeleteFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.pattern.IPattern;

public class DeleteAttributeFeature extends DefaultDeleteFeature {

	private static final String NAME = Messages.DeleteAttributeFeature_0_xbut;
	private static final String DESCRIPTION = Messages.DeleteAttributeFeature_1_xmsg;
	private static String attName;
	private boolean mAskUser = true;

	public DeleteAttributeFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean isAvailable(IContext context) {
		if (context instanceof IDeleteContext) {
			Attribute attribute = getAttributeFromContext((IDeleteContext)context);
			if (attribute != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean canDelete(IDeleteContext context) {
		Attribute attribute = getAttributeFromContext(context);
		if (attribute != null) {
			attName = attribute.getName();
			return !ModelElementService.isForeignObject(getDiagram(), attribute);
		}
		return false;
	}

	@Override
	public void delete(IDeleteContext context) {
		Attribute attribute = getAttributeFromContext(context);
		if (attribute != null) {
			// Delete the attribute from class
			ClassUtil.deleteAttribute(attribute.getName(), (MofClass)attribute.getContainer());
			PictogramElement pe = context.getPictogramElement();
			if (pe != null) {
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
//			return "Do you really want to delete " + attName +"?";
			return MessageFormat.format(Messages.DeleteAttributeFeature_2_xmsg, new Object[]{attName});
		}
		else {
			return null;
		}
	}
	
	private Attribute getAttributeFromContext(IDeleteContext context) {
		PictogramElement pe = context.getPictogramElement();
		if (pe != null) {
			Object bo = getBusinessObjectForPictogramElement(pe);
			if (bo instanceof Attribute) {
				return (Attribute)bo;
			}
		}
		return null;
	}
}
