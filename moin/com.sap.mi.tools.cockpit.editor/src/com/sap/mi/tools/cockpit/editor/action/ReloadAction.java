package com.sap.mi.tools.cockpit.editor.action;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;

import com.sap.mi.tools.cockpit.editor.MOINBrowser;
import com.sap.mi.tools.cockpit.editor.Messages;
import com.sap.mi.tools.cockpit.editor.ui.MOINBrowserView;

/**
 * @author d003456
 * 
 */
public class ReloadAction extends Action {

	private MOINBrowserView moinBrowserView;

	/**
	 * Constructor
	 * 
	 * @param moinBrowserView
	 */
	public ReloadAction(MOINBrowserView moinBrowserView) {
		super();
		this.moinBrowserView = moinBrowserView;

		setToolTipText(Messages.ReloadAction_0_xtol);
		setText(Messages.ReloadAction_1_xfld);
		setImageDescriptor(MOINBrowser.getDefault().getImageDescriptor(
				MOINBrowser.REFRESH_IMAGE));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		
		processOutstandingEvents();
		
		BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
			public void run() {
				ReloadAction.this.moinBrowserView.reload();
			}
		});
	}
	
	private void processOutstandingEvents() {
		Display display = Display.getCurrent();
		if (display != null && !display.isDisposed()) {
			display.update();
		}
	}
}
