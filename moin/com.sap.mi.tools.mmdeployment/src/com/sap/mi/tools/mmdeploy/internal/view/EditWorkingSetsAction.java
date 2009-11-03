package com.sap.mi.tools.mmdeploy.internal.view;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.IWorkingSetSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import com.sap.mi.fwk.ui.mm.MetamodelManagerUI;

/**
 * Launches the select working sets dialog
 * 
 * @author d031150
 */
public class EditWorkingSetsAction extends AbstractHandler {

	public static final String COMMAND_ID = "com.sap.mi.tools.mmdeploy.commands.editWorkingSets"; //$NON-NLS-1$

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart activePartChecked = HandlerUtil.getActivePartChecked(event);
		if (activePartChecked instanceof MmDeploymentView) {
			MmDeploymentView view = (MmDeploymentView) activePartChecked;

			IWorkingSetManager workingSetManager = PlatformUI.getWorkbench().getWorkingSetManager();
			IWorkingSetSelectionDialog dialog = workingSetManager.createWorkingSetSelectionDialog(view.getSite().getShell(), true,
					new String[] { MetamodelManagerUI.ID_METAMODEL_WORKING_SET });
			dialog.open();
		}
		
		return null;
	}
}
