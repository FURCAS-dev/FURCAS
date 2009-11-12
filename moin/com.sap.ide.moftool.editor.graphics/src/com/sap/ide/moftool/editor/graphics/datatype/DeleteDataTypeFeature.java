package com.sap.ide.moftool.editor.graphics.datatype;

import java.text.MessageFormat;

import com.sap.tc.moin.repository.mmi.model.DataType;

import com.sap.ide.moftool.editor.core.commands.DeleteModelElementCommand;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IRemoveFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IDeleteContext;
import com.sap.mi.gfw.features.context.IRemoveContext;
import com.sap.mi.gfw.features.context.impl.RemoveContext;
import com.sap.mi.gfw.features.jam.DefaultDeleteFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class DeleteDataTypeFeature extends DefaultDeleteFeature{
	private static final String NAME = Messages.DeleteDataTypeFeature_0_xbut; 
	private static String typeName;
	private boolean mAskUser = true;

	public DeleteDataTypeFeature(IFeatureProvider fp) {
		super(fp);      
	}

	@Override
	public boolean canDelete(IDeleteContext context) {
		boolean ret = super.canDelete(context);
		if (!ret) {
			return false;
		}
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);
		if (bo instanceof DataType ) {
			DataType type = (DataType)bo ;
			typeName = type.getName();
			ret = !ModelElementService.isForeignObject(getDiagram(), type);
		}

		return ret;
	}

	@Override
	public void delete(IDeleteContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);
		if (bo instanceof DataType && getUserDecision()) {
			preDelete(context);

			DataType type = (DataType)bo;
			// delete the type
			DeleteModelElementCommand command = new DeleteModelElementCommand(type, getConnection());
            command.execute();
			// remove Pictogram Element from Diagram
			IRemoveContext rc = new RemoveContext(pe);
			IFeatureProvider featureProvider = getFeatureProvider();
			IRemoveFeature removeFeature = featureProvider.getRemoveFeature(rc);
			if (removeFeature != null) {
				removeFeature.remove(rc);
			}

			postDelete(context);
		}

	}

	@Override
	public boolean isAvailable(IContext context) {
		boolean ret = false;
		if (context instanceof IDeleteContext) {
			PictogramElement pe = ((IDeleteContext)context).getPictogramElement();
			if (pe != null) {
				Object bo = getBusinessObjectForPictogramElement(pe);
				if (bo instanceof DataType) {
					ret = true;
				}
			}
		}
		return ret;
	}


	public String getName(){
		return NAME;
	}

	public void setAskUser(boolean ask) {
		mAskUser = ask;
	}

	@Override
	protected String getQuestionToUser() {
		if (mAskUser) {
//			return "Do you really want to delete " + typeName +"?";
			return MessageFormat.format(Messages.DeleteDataTypeFeature_1_xmsg, new Object[]{typeName});
		}
		else {
			return null;
		}
	}

	@Override
	public void preDelete(IDeleteContext context) {      
	}

	@Override
	public void postDelete(IDeleteContext context) { 
	}
}
