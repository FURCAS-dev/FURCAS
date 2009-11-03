package com.sap.mi.tools.mmdeploy.internal.view;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Refreshes the view
 * 
 * @author d031150
 */
public final class RefreshAction extends AbstractHandler {
	public RefreshAction() {
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart activePartChecked = HandlerUtil.getActivePartChecked(event);
		if (activePartChecked instanceof MmDeploymentView) {
			MmDeploymentView mView = (MmDeploymentView) activePartChecked;
			mView.refresh();
		}
		return null;
	}
}
