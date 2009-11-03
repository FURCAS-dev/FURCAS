package com.sap.mi.tools.cockpit.editor.action;

import org.eclipse.jface.action.Action;

import com.sap.mi.tools.cockpit.editor.MOINBrowser;
import com.sap.mi.tools.cockpit.editor.Messages;
import com.sap.mi.tools.cockpit.editor.ui.MOINBrowserView;

public class CollapseAllAction extends Action {

	private MOINBrowserView moinBrowserView;

	/**
	 * Constructor
	 * 
	 * @param moinBrowserView
	 */
	public CollapseAllAction(MOINBrowserView moinBrowserView) {
		super();
		this.moinBrowserView = moinBrowserView;
		
		setToolTipText(Messages.CollapseAllAction_0_xtol);
		setText(Messages.CollapseAllAction_1_xfld);
		setImageDescriptor(MOINBrowser.getDefault().getImageDescriptor(
				MOINBrowser.COLLAPSE_ALL_IMAGE));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		CollapseAllAction.this.moinBrowserView.collapseAll();
	}
	

}
