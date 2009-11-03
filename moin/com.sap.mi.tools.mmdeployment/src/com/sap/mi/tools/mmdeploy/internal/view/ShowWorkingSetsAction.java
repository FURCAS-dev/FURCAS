package com.sap.mi.tools.mmdeploy.internal.view;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.UIElement;

/**
 * Toggles whether to show working sets
 * 
 * @author d031150
 */
public final class ShowWorkingSetsAction extends AbstractHandler implements IElementUpdater {

	private static final String COMMAND_ID = "com.sap.mi.tools.mmdeploy.commands.showWorkingSets"; //$NON-NLS-1$

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart activePartChecked = HandlerUtil.getActivePartChecked(event);
		if (activePartChecked instanceof MmDeploymentView) {
			MmDeploymentView view = (MmDeploymentView) activePartChecked;

			boolean show = !MmDeploymentView.showWorkingSets();
			view.setShowWorkingSets(show);

			// update all menu items for our command so that toggled state is
			// reflected
			update(view);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public void updateElement(UIElement element, Map parameters) {
		boolean show = MmDeploymentView.showWorkingSets();
		element.setChecked(show);
	}

	static void update(IWorkbenchPart part) {
		IWorkbenchPartSite site = part.getSite();
		ICommandService commandService = (ICommandService) site.getService(ICommandService.class);
		commandService.refreshElements(COMMAND_ID, Collections.emptyMap());
	}

}
