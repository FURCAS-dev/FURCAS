package com.sap.ide.moftool.editor.graphics.connection.generalization;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.graphics.connection.Messages;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ConnectionUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IRemoveFeature;
import com.sap.mi.gfw.features.context.IDeleteContext;
import com.sap.mi.gfw.features.context.IRemoveContext;
import com.sap.mi.gfw.features.context.impl.RemoveContext;
import com.sap.mi.gfw.features.jam.DefaultDeleteFeature;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.util.PeUtil;

public class DeleteGeneralizationFeature extends DefaultDeleteFeature {

	private boolean mAskUser = true;

	public DeleteGeneralizationFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canDelete(IDeleteContext context) {
		boolean ret = false;
		PictogramElement pe = context.getPictogramElement();

		if (pe instanceof Connection) {
			Connection connection = (Connection)pe;
			if (PeUtil.getProperty(connection, MOFToolConstants.CON_PROPERTY_GENERALIZATION) != null) {
				Anchor start = connection.getStart();
				MofClass source = null;
				Object object = getBusinessObjectForPictogramElement(start.getParent());
				if (object instanceof MofClass) {
					source = (MofClass)object;
					ret = !ModelElementService.isForeignObject(getDiagram(), source);
				}
			}

		}
		return ret;
	}

	public void setAskUser(boolean ask) {
		mAskUser = ask;
	}

	@Override
	protected String getQuestionToUser() {
		if (mAskUser) {
			return Messages.DeleteGeneralizationFeature_0_xmsg;
		}
		else {
			return null;
		}
	}

	@Override
	public void delete(IDeleteContext context) {
		PictogramElement pe = context.getPictogramElement();

		if (pe instanceof Connection && getUserDecision()) {
			Connection connection = (Connection) pe;

			Anchor start = connection.getStart();
			Anchor end = connection.getEnd();
			MofClass source = null;
			Object object = getBusinessObjectForPictogramElement(start.getParent());
			if (object instanceof MofClass) {
				source = (MofClass)object;
			}
			MofClass target = null;
			object = getBusinessObjectForPictogramElement(end.getParent());
			if (object instanceof MofClass) {
				target = (MofClass)object;
			}
			if (source != null && target != null) {
				// delete generalization from business model
				ConnectionUtil.deleteGeneralize(getFeatureProvider().getConnection(), source, target);
				// remove connection from editor
				IRemoveContext rc = new RemoveContext(pe);
				IFeatureProvider featureProvider = getFeatureProvider();
				IRemoveFeature removeFeature = featureProvider.getRemoveFeature(rc);
				if (removeFeature != null) {
					removeFeature.remove(rc);
				}
			}
		}
	}
}
