package com.sap.mi.tools.cockpit.editor.action;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.sap.mi.tools.cockpit.editor.Messages;
import com.sap.mi.tools.cockpit.editor.ui.MOINBrowserView;

/**
 * @author d003456
 * 
 */
public class ToggleTopLevelToPartitions extends Action {

	private MOINBrowserView moinBrowserView;

	/**
	 * Constructor
	 * 
	 * @param moinBrowserView
	 */
	public ToggleTopLevelToPartitions(MOINBrowserView moinBrowserView) {
		super("Partitions", Action.AS_RADIO_BUTTON); //$NON-NLS-1$
		this.moinBrowserView = moinBrowserView;

		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_FILE));
		setText(Messages.ToggleTopLevelToPartitions_0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		MOINBrowserView.isTopLevelNodePartition = true;
		this.moinBrowserView.getContainerPresentationToHierarchical()
				.setEnabled(true);
		this.moinBrowserView.getContainerPresentationToFlat().setEnabled(true);
		
		processOutstandingEvents();
		
		BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
			public void run() {
				IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
				ToggleTopLevelToPartitions.this.moinBrowserView.setBrowserRoots(projects);
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
