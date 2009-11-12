package com.sap.ide.moftool.editor.graphics.clazz.operation;

import java.text.MessageFormat;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Operation;

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

public class DeleteOperationFeature extends DefaultDeleteFeature {

	private static final String NAME = Messages.DeleteOperationFeature_0_xbut;
	private static final String DESCRIPTION = Messages.DeleteOperationFeature_1_xmsg;
	private static String opName;
	private boolean mAskUser = true;

	public DeleteOperationFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean isAvailable(IContext context) {
		if (context instanceof IDeleteContext) {
			Operation operation = getOperationFromContext((IDeleteContext)context);
			if (operation != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean canDelete(IDeleteContext context) {
		Operation operation = getOperationFromContext(context);
		if (operation != null) {
			opName = operation.getName();
			return !ModelElementService.isForeignObject(getDiagram(), operation);
		}
		return false;
	}

	public void delete(IDeleteContext context) {
		Operation operation = getOperationFromContext(context);
		if (operation != null) {
			ClassUtil.deleteOperation(operation.getName(), (MofClass)operation.getContainer());
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
//			return "Do you really want to delete " + opName + "?";
			return MessageFormat.format(Messages.DeleteOperationFeature_2_xmsg, new Object[]{opName});
		} else {
			return null;
		}
	}

	private Operation getOperationFromContext(IDeleteContext context) {
		PictogramElement pe = context.getPictogramElement();
		if (pe != null) {
			Object bo = getBusinessObjectForPictogramElement(pe);
			if (bo instanceof Operation) {
				return (Operation)bo;
			}
		}
		return null;
	}
}
