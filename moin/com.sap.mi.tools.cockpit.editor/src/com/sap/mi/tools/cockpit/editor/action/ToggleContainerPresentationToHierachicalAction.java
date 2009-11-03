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
public class ToggleContainerPresentationToHierachicalAction extends Action {

	private MOINBrowserView moinBrowserView;
	
	/**
	 * Constructor
	 * 
	 * @param moinBrowserView
	 */
	public ToggleContainerPresentationToHierachicalAction(
			MOINBrowserView moinBrowserView) {
		
		super("Hierarchical", Action.AS_RADIO_BUTTON); //$NON-NLS-1$
		this.moinBrowserView = moinBrowserView;
		setText(Messages.ToggleContainerPresentationToHierachicalAction_0_xmit);
		setImageDescriptor(MOINBrowser.getDefault().getImageDescriptor(MOINBrowser.HIERARCHICAL_CONTAINER_PRESENTATION_IMAGE));
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		this.setChecked(true);
		this.moinBrowserView.getContainerPresentationToFlat().setChecked(false);
		MOINBrowserView.isContainerPresentationHierarchical = true;
		
		processOutstandingEvents();
		
		BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
			public void run() {
				ToggleContainerPresentationToHierachicalAction.this.moinBrowserView.refresh();
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
