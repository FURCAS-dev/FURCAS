package com.sap.mi.tools.cockpit.mql.ui.search.action;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;

import com.sap.mi.tools.cockpit.mql.Messages;
import com.sap.mi.tools.cockpit.mql.QueryConsole;
import com.sap.mi.tools.cockpit.mql.search.MQLSearchResult;
import com.sap.mi.tools.cockpit.mql.ui.search.MQLSearchResultPage;
import com.sap.mi.tools.cockpit.mql.ui.search.dialog.FilterDialog;

/**
 * @author d003456
 * 
 */
public final class FilterSelectionAction extends Action {

	public static final String ACTION_ID = "MatchFilterSelectionAction"; //$NON-NLS-1$

	private final MQLSearchResultPage page;

	private final static String FILTER_SELECTION_ACTION = Messages.FilterSelectionAction_0_xmit;

	/**
	 * Creates {@link FilterSelectionAction}.
	 * 
	 * @param page
	 */
	public FilterSelectionAction(MQLSearchResultPage page) {

		super(FilterSelectionAction.FILTER_SELECTION_ACTION);
		setId(FilterSelectionAction.ACTION_ID);
		setImageDescriptor(QueryConsole.getDefault().getImageDescriptor(QueryConsole.FILTER_IMAGE));
		Assert.isNotNull(page);
		this.page = page;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		final Shell shell = this.page.getSite().getShell();

		final MQLSearchResult input = this.page.getInput();
		if (input == null) {
			return;
		}

		final Integer limit = this.page.getElementLimit();

		final boolean enableLimitConfiguration = limit != null;
		final int elementLimit = limit != null ? limit.intValue() : -1;

		final FilterDialog dialog = new FilterDialog(shell, enableLimitConfiguration, elementLimit);
		if (dialog.open() == Window.OK) {
			this.page.setElementLimit(new Integer(dialog.getLimit()));
		}
	}

}
