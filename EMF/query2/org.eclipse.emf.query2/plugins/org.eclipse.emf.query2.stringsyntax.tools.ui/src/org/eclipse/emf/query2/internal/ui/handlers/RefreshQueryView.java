package org.eclipse.emf.query2.internal.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.query2.internal.ui.QueryView;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

public class RefreshQueryView extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart part = HandlerUtil.getActivePart(event);
		if (part instanceof QueryView) {
			QueryView view = (QueryView) part;
			String parameter = event.getParameter("refreshDirty"); //$NON-NLS-1$
			if (Boolean.valueOf(parameter)) {
				view.refresh(true);
			}else {
				view.refresh(false);
			}
			
		}
		return null;
	}

}
