package com.sap.mi.tools.cockpit.mql.ui.search.action;

import org.eclipse.jface.action.Action;

import com.sap.mi.tools.cockpit.mql.Messages;
import com.sap.mi.tools.cockpit.mql.QueryConsole;
import com.sap.mi.tools.cockpit.mql.search.MQLSearchResult;
import com.sap.mi.tools.cockpit.mql.ui.search.MQLSearchResultPage;

/**
 * @author d003456
 * 
 */
public final class RemoveAllElementsAction extends Action {

	private final MQLSearchResultPage page;

	private final static String REMOVE_ALL_ELEMENTS_ACTION_LABEL = Messages.RemoveAllElementsAction_0_xfld;

	private final static String REMOVE_ALL_ELEMENTS_ACTION_TOOLTIP = Messages.RemoveAllElementsAction_1_xtol;

	/**
	 * Creates RemoveAllMatchesAction.
	 * 
	 * @param page
	 */
	public RemoveAllElementsAction(MQLSearchResultPage page) {

		super(RemoveAllElementsAction.REMOVE_ALL_ELEMENTS_ACTION_LABEL);
		setImageDescriptor(QueryConsole.getDefault().getImageDescriptor(QueryConsole.REMOVE_ALL_IMAGE));
		setToolTipText(RemoveAllElementsAction.REMOVE_ALL_ELEMENTS_ACTION_TOOLTIP);
		this.page = page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		final MQLSearchResult search = this.page.getInput();
		if (search != null) {
			search.removeAllRows();
		}

	}
}
