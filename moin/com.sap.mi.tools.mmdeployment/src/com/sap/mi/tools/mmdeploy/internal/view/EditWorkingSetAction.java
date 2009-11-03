package com.sap.mi.tools.mmdeploy.internal.view;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.IWorkingSetEditWizard;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Launches the edit working set dialog
 * 
 * @author d031150
 */
public final class EditWorkingSetAction extends AbstractHandler {

	public EditWorkingSetAction() {
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
		Object treeObject = selection.getFirstElement();
		IAdapterManager adapterManager = Platform.getAdapterManager();
		IWorkingSet set = (IWorkingSet) adapterManager.getAdapter(treeObject, IWorkingSet.class);
		IWorkingSetManager workingSetManager = PlatformUI.getWorkbench().getWorkingSetManager();
		MmDeploymentView view = (MmDeploymentView) HandlerUtil.getActivePartChecked(event);

		IWorkingSetEditWizard wizard = workingSetManager.createWorkingSetEditWizard(set);
		WizardDialog dialog = new WizardDialog(view.getSite().getShell(), wizard);
		if (dialog.open() == Window.OK)
			view.expand(treeObject);

		return null;
	}

}
