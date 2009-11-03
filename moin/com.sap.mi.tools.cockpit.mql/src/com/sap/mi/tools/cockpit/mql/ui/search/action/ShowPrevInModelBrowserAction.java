package com.sap.mi.tools.cockpit.mql.ui.search.action;

import org.eclipse.jface.action.Action;

import com.sap.mi.tools.cockpit.mql.Messages;
import com.sap.mi.tools.cockpit.mql.QueryConsole;
import com.sap.mi.tools.cockpit.mql.ui.search.MQLSearchResultPage;

/**
 * @author d003456
 * 
 */
public class ShowPrevInModelBrowserAction extends Action {

	private final static String SHOW_PREV_IN_MODEL_BROWSER_ACTION_LABEL = Messages.ShowPrevInModelBrowserAction_0_xmit;

	private final MQLSearchResultPage page;

	/**
	 * Creates {@link ShowPrevInModelBrowserAction}.
	 * 
	 * @param page
	 *            the MQLSearchResultPage page
	 */
	public ShowPrevInModelBrowserAction(MQLSearchResultPage page) {

		super(ShowPrevInModelBrowserAction.SHOW_PREV_IN_MODEL_BROWSER_ACTION_LABEL);
		this.page = page;
		setText(ShowPrevInModelBrowserAction.SHOW_PREV_IN_MODEL_BROWSER_ACTION_LABEL);
		setToolTipText(ShowPrevInModelBrowserAction.SHOW_PREV_IN_MODEL_BROWSER_ACTION_LABEL);
		setImageDescriptor(QueryConsole.getDefault().getImageDescriptor(QueryConsole.PREVIOUS_IMAGE));
		setDisabledImageDescriptor(QueryConsole.getDefault().getImageDescriptor(QueryConsole.PREVIOUS_IMAGE_DISABLED));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		this.page.navigateNext(false);
		this.page.getShowInModelBrowserAction().run();
	}

}
