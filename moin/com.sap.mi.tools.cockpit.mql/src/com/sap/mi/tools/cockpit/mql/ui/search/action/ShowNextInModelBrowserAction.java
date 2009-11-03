/**
 * 
 */
package com.sap.mi.tools.cockpit.mql.ui.search.action;

import org.eclipse.jface.action.Action;

import com.sap.mi.tools.cockpit.mql.Messages;
import com.sap.mi.tools.cockpit.mql.QueryConsole;
import com.sap.mi.tools.cockpit.mql.ui.search.MQLSearchResultPage;

/**
 * @author d003456
 * 
 */
public class ShowNextInModelBrowserAction extends Action {

	private final static String SHOW_NEXT_IN_MODEL_BROWSER_ACTION_LABEL = Messages.ShowNextInModelBrowserAction_0_xmit;

	private final MQLSearchResultPage page;

	/**
	 * Creates {@link ShowNextInModelBrowserAction}.
	 * 
	 * @param page
	 *            the {@link MQLSearchResultPage} page
	 */
	public ShowNextInModelBrowserAction(MQLSearchResultPage page) {

		super(ShowNextInModelBrowserAction.SHOW_NEXT_IN_MODEL_BROWSER_ACTION_LABEL);
		setText(ShowNextInModelBrowserAction.SHOW_NEXT_IN_MODEL_BROWSER_ACTION_LABEL);
		setToolTipText(ShowNextInModelBrowserAction.SHOW_NEXT_IN_MODEL_BROWSER_ACTION_LABEL);
		setImageDescriptor(QueryConsole.getDefault().getImageDescriptor(QueryConsole.NEXT_IMAGE));
		setDisabledImageDescriptor(QueryConsole.getDefault().getImageDescriptor(QueryConsole.NEXT_IMAGE_DISABLED));
		this.page = page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		this.page.navigateNext(true);
		this.page.getShowInModelBrowserAction().run();
	}

}
