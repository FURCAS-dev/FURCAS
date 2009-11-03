package com.sap.mi.tools.mmdeploy.internal.view;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Raises the properties view
 * 
 * @author d031150
 */
public final class ShowPropertiesAction extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchSite site = HandlerUtil.getActiveSiteChecked(event);
		try {
			return site.getPage().showView(IPageLayout.ID_PROP_SHEET);
		} catch (PartInitException e) {
			throw new ExecutionException(e.getMessage(), e);
		}
	}

}
