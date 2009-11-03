package com.sap.mi.gfw.eclipse.internal.action;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.action.Action;

import com.sap.mi.gfw.eclipse.Messages;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.eclipse.internal.util.ui.UIUtil;
import com.sap.mi.gfw.features.ISaveImageFeature;
import com.sap.mi.gfw.features.context.ISaveImageContext;

public class SaveImageAction extends Action {

	private ISaveImageFeature saveImageFeature;

	private ISaveImageContext context;

	private DiagramEditor graphicsEditor;

	public SaveImageAction(ISaveImageFeature saveImageFeature, ISaveImageContext context, DiagramEditor graphicsEditor) {
		super();
		this.saveImageFeature = saveImageFeature;
		this.context = context;
		this.graphicsEditor = graphicsEditor;
		setText(Messages.SaveImageAction_0_xmsg);
		setToolTipText(Messages.SaveImageAction_1_xmsg);
	}

	@Override
	public boolean isEnabled() {
		return saveImageFeature.canSave(context);
	}

	@Override
	public void run() {
		saveImageFeature.preSave(context);

		// get viewer and start save-image-dialog
		GraphicalViewer viewer = (GraphicalViewer) graphicsEditor.getAdapter(GraphicalViewer.class);
		UIUtil.startSaveAsImageDialog(viewer);

		saveImageFeature.postSave(context);
	}
}