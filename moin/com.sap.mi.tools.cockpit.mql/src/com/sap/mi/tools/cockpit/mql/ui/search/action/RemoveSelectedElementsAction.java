/**
 * 
 */
package com.sap.mi.tools.cockpit.mql.ui.search.action;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.Action;

import com.sap.mi.tools.cockpit.mql.Messages;
import com.sap.mi.tools.cockpit.mql.QueryConsole;
import com.sap.mi.tools.cockpit.mql.ui.search.MQLSearchResultPage;

/**
 * @author d003456
 * 
 */
public final class RemoveSelectedElementsAction extends Action {

	private final MQLSearchResultPage page;

	private final static String REMOVE_SELECTED_ELEMENTS_ACTION_LABEL = Messages.RemoveSelectedElementsAction_0_xfld;

	private final static String REMOVE_SELECTED_ELEMENTS_ACTION_TOOLTIP = Messages.RemoveSelectedElementsAction_1_xtol;

	/**
	 * Creates RemoveSelectedMatchesAction.
	 * 
	 * @param page
	 *            the MQLSearchResultPage page
	 */
	public RemoveSelectedElementsAction(MQLSearchResultPage page) {

		super(RemoveSelectedElementsAction.REMOVE_SELECTED_ELEMENTS_ACTION_LABEL);
		Assert.isNotNull(page);
		this.page = page;
		setText(RemoveSelectedElementsAction.REMOVE_SELECTED_ELEMENTS_ACTION_LABEL);
		setToolTipText(RemoveSelectedElementsAction.REMOVE_SELECTED_ELEMENTS_ACTION_TOOLTIP);
		setImageDescriptor(QueryConsole.getDefault().getImageDescriptor(QueryConsole.REMOVE_IMAGE));
		setDisabledImageDescriptor(QueryConsole.getDefault().getImageDescriptor(QueryConsole.REMOVE_IMAGE_DISABLED));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		this.page.removeSelectedElements();

	}
}
