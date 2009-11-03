package com.sap.mi.tools.cockpit.editor.action;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
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
public class ToggleTopLevelToMetaModelNames extends Action {

	MOINBrowserView moinBrowserView;

	/**
	 * Constructor
	 * 
	 * @param moinBrowserView
	 */
	public ToggleTopLevelToMetaModelNames(MOINBrowserView moinBrowserView) {
		super("Meta Model Names", Action.AS_RADIO_BUTTON); //$NON-NLS-1$
		this.moinBrowserView = moinBrowserView;

		setText(Messages.ToggleTopLevelToMetaModelNames_0);
		setImageDescriptor(MOINBrowser.getDefault().getImageDescriptor(
				MOINBrowser.METAMODEL_IMAGE));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		MOINBrowserView.isTopLevelNodePartition = false;
		this.moinBrowserView.getContainerPresentationToHierarchical()
				.setEnabled(false);
		this.moinBrowserView.getContainerPresentationToFlat().setEnabled(false);
		
		processOutstandingEvents();
		
		BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
			public void run() {
				IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
				ToggleTopLevelToMetaModelNames.this.moinBrowserView.setBrowserRoots(projects);
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

