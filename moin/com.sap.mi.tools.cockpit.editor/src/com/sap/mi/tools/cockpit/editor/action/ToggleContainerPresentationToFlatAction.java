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
public class ToggleContainerPresentationToFlatAction extends Action {

	private MOINBrowserView moinBrowserView;

	/**
	 * Constructor
	 * 
	 * @param moinBrowserView
	 */
	public ToggleContainerPresentationToFlatAction(
			MOINBrowserView moinBrowserView) {

		super("Flat", Action.AS_RADIO_BUTTON); //$NON-NLS-1$
		this.moinBrowserView = moinBrowserView;
		setText(Messages.ToggleContainerPresentationToFlatAction_0_xmit);
		setImageDescriptor(MOINBrowser.getDefault().getImageDescriptor(
				MOINBrowser.FLAT_CONTAINER_PRESENTATION_IMAGE));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		this.setChecked(true);
		this.moinBrowserView.getContainerPresentationToHierarchical()
				.setChecked(false);
		MOINBrowserView.isContainerPresentationHierarchical = false;

		processOutstandingEvents();
		
		BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
			public void run() {
				ToggleContainerPresentationToFlatAction.this.moinBrowserView
						.refresh();
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
