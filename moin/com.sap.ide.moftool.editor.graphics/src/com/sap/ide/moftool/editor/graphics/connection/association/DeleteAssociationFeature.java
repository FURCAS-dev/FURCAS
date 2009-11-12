package com.sap.ide.moftool.editor.graphics.connection.association;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.core.commands.DeleteAssociationCommand;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.graphics.connection.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IRemoveFeature;
import com.sap.mi.gfw.features.context.IDeleteContext;
import com.sap.mi.gfw.features.context.IRemoveContext;
import com.sap.mi.gfw.features.context.impl.RemoveContext;
import com.sap.mi.gfw.features.jam.DefaultDeleteFeature;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class DeleteAssociationFeature  extends DefaultDeleteFeature {

	private boolean mAskUser = true;
	
	public DeleteAssociationFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public boolean canDelete(IDeleteContext context) {
		boolean ret = false;
		PictogramElement pe = context.getPictogramElement();        
		if (pe instanceof Connection) {
			Connection connection = (Connection)pe;
			Object bo = getBusinessObjectForPictogramElement(connection);
			if (bo instanceof Association) { 
				ret = !ModelElementService.isForeignObject(getDiagram(), (Association)bo);
			}
		}
		return ret;
	}

	@Override
	public void delete(IDeleteContext context) {
		Association association = null;
		PictogramElement pe = context.getPictogramElement();

		if (pe instanceof Connection && getUserDecision()) {
			Connection connection = (Connection) pe;

			Object bo = getBusinessObjectForPictogramElement(connection);
			if (bo instanceof Association) {
				association = (Association)bo;
				// delete Association from business model
				DeleteAssociationCommand command = new DeleteAssociationCommand(association, getConnection());
		        command.execute();
			}

			// remove pictogram element from diagram
			Anchor start = connection.getStart();
			Anchor end = connection.getEnd();
			MofClass source = null;
			Object object = getBusinessObjectForPictogramElement(start.getParent());
			if (object instanceof MofClass) {
				source = (MofClass)object;
			}
			object = getBusinessObjectForPictogramElement(end.getParent());
			MofClass target = null;
			if (object instanceof MofClass) {
				target = (MofClass)object;
			}
			if (source != null && target != null) {
				// remove connection from editor
				IRemoveContext rc = new RemoveContext(pe);
				IFeatureProvider featureProvider = getFeatureProvider();
				IRemoveFeature removeFeature = featureProvider.getRemoveFeature(rc);
				if (removeFeature != null) {
					removeFeature.remove(rc);
				}
				updatePictogramElement(start.getParent());
				updatePictogramElement(end.getParent());
			}
		}
	}

	public void setAskUser(boolean ask) {
		mAskUser = ask;
	}

	@Override
	protected String getQuestionToUser() {
		if (mAskUser) {
			return Messages.DeleteAssociationFeature_0_xmsg;
		}
		else {
			return null;
		}
	}
}
