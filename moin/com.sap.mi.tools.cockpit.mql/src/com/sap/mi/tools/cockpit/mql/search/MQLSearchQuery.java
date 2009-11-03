package com.sap.mi.tools.cockpit.mql.search;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;

import com.sap.mi.tools.cockpit.mql.Messages;
import com.sap.mi.tools.cockpit.mql.ui.form.QueryDetailsPage;
import com.sap.mi.tools.cockpit.mql.ui.form.QueryDetailsPage.MODE;
import com.sap.tc.moin.repository.mql.MQLResultSet;

/**
 * Represents the query whose execution creates a SearchResult.
 * 
 * @author d003456
 * 
 */
public class MQLSearchQuery implements ISearchQuery {

	protected MQLSearchResult searchResult;

	protected final String query;

	protected MQLResultSet mqlResultSet;

	protected final QueryDetailsPage queryDetailsPage;

	protected long duration;
	
	protected MODE queryMode;

	/**
	 * Text on progress monitor begin task
	 */
	protected static final String START_QUERY = Messages.MQLSearchQuery_0_xmsg;

	/**
	 * Constructor.
	 * 
	 * @param query
	 *            the query to be executed
	 * @param project
	 */
	public MQLSearchQuery(String query, QueryDetailsPage queryDetailsPage, MODE queryMode) {

		this.query = query;
		this.queryDetailsPage = queryDetailsPage;
		this.duration = 0;
		this.queryMode = queryMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchQuery#canRerun()
	 */
	public boolean canRerun() {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchQuery#canRunInBackground()
	 */
	public boolean canRunInBackground() {

		return true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchQuery#getLabel()
	 */
	public String getLabel() {

		return this.searchResult != null ? this.searchResult.getLabel() : ""; //$NON-NLS-1$

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchQuery#getSearchResult()
	 */
	public ISearchResult getSearchResult() {

		if (this.searchResult == null) {
			this.searchResult = new MQLSearchResult();
			this.searchResult.setQuery(this);
			if (this.mqlResultSet != null) {
				this.searchResult.setResult(this.mqlResultSet);
			}
		}
		return this.searchResult;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchQuery#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus run(IProgressMonitor monitor) throws OperationCanceledException {

		return null;
	}

	/**
	 * Returns the MQL query.
	 * 
	 * @return the query
	 */
	public String getQuery() {

		return this.query;

	}

	/**
	 * Returns duration of query in milliseconds.
	 * 
	 * @return the duration
	 */
	public long getDuration() {

		return this.duration;

	}

	/**
	 * Sets duration of query.
	 * 
	 * @param duration
	 *            the duration to set
	 */
	protected void setDuration(long duration) {

		this.duration = duration;

	}
	
	/**
	 * @return the queryMode
	 */
	public final MODE getQueryMode() {
	
		return this.queryMode;
	}

}
