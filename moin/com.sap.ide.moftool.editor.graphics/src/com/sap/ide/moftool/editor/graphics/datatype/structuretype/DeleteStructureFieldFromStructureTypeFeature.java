package com.sap.ide.moftool.editor.graphics.datatype.structuretype;

import java.text.MessageFormat;

import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;

import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.graphics.ClassDiagramFeatureProvider;
import com.sap.ide.moftool.editor.graphics.datatype.Messages;
import com.sap.ide.moftool.editor.graphics.pattern.AbstractMofCompartmentPattern;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.StructureTypeUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IDeleteContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.features.jam.DefaultDeleteFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.pattern.IPattern;

public class DeleteStructureFieldFromStructureTypeFeature extends DefaultDeleteFeature {

	private static final String NAME = Messages.DeleteStructureFieldFromStructureTypeFeature_0_xbut;
	private static final String DESCRIPTION = Messages.DeleteStructureFieldFromStructureTypeFeature_1_xmsg;
	private String fieldName;
	private boolean mAskUser = true;

	public DeleteStructureFieldFromStructureTypeFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean isAvailable(IContext context) {
		if (context instanceof IDeleteContext) {
			StructureField field = getStructureFieldFromContext((IDeleteContext)context);
			if (field != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean canDelete(IDeleteContext context) {
		StructureField field = getStructureFieldFromContext(context);
		if (field != null) {
			fieldName = field.getName();
			return !ModelElementService.isForeignObject(getDiagram(), field);
		}
		return false;
	}

	public void delete(IDeleteContext context) {
		StructureField field = getStructureFieldFromContext(context);
		if (field != null) {
			StructureTypeUtil.deleteField(field, (StructureType)field.getContainer());
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
	public String getName() {
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
//			return "Do you really want to delete " + fieldName + "?";
			return MessageFormat.format(Messages.DeleteStructureFieldFromStructureTypeFeature_2_xmsg, fieldName);
		}
		else {
			return null;
		}
	}

	private StructureField getStructureFieldFromContext(IDeleteContext context) {
		PictogramElement pe = context.getPictogramElement();
		if (pe != null) {
			Object bo = getBusinessObjectForPictogramElement(pe);
			if (bo instanceof StructureField) {
				return (StructureField)bo;
			}
		}
		return null;
	}
}
