package com.sap.mi.tools.cockpit.editor.action;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.mi.tools.cockpit.editor.Messages;
import com.sap.mi.tools.cockpit.editor.ui.MOINBrowserView;

/**
 * @author d003456
 * 
 */
public class ShowPropertiesViewAction extends Action {

	private MOINBrowserView moinBrowserView;

	/**
	 * Constructor.
	 * 
	 * @param moinBrowserView
	 */
	public ShowPropertiesViewAction(MOINBrowserView moinBrowserView) {
		super();
		this.moinBrowserView = moinBrowserView;
		setToolTipText(Messages.ShowPropertiesView_0_xtol);
		setText(Messages.ShowPropertiesView_1_xmit);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().showView(IPageLayout.ID_PROP_SHEET);
			this.moinBrowserView.setFocus();
		} catch (PartInitException e) {
			ModelManagerUI.getEditorManager().getActiveStatusLineManager()
					.setErrorMessage(
							Messages.ShowPropertiesView_2_ymsg
									+ e.getLocalizedMessage());
		}
	}
}
