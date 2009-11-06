package com.sap.mi.tools.cockpit.mql.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.search.ui.text.RemoveAllEvent;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.tools.cockpit.mql.ui.form.QueryDetailsPage.MODE;
import com.sap.tc.moin.repository.mql.MQLResultException;
import com.sap.tc.moin.repository.mql.MQLResultSet;

/**
 * @author d003456
 * 
 */
public class MQLSearchResult implements ISearchResult {

	private static final Logger tracer = Logger.getLogger(MiLocations.MI_MQLVIEW);

	private MQLSearchQuery query;

	private MQLResultSet mqlResultSet;

	private final MQLresultSetEvent mqlResultSetEvent;

	private final List<ISearchResultListener> searchResultlisteners = new ArrayList<ISearchResultListener>();

	/**
	 * Creates {@link MQLSearchResult}.
	 * 
	 */
	public MQLSearchResult() {

		super();
		this.mqlResultSetEvent = new MQLresultSetEvent(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResult#addListener(org.eclipse.search.ui.ISearchResultListener)
	 */
	public void addListener(ISearchResultListener l) {

		if (!this.searchResultlisteners.contains(l)) {
			this.searchResultlisteners.add(l);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResult#getImageDescriptor()
	 */
	public ImageDescriptor getImageDescriptor() {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResult#getLabel()
	 */
	public String getLabel() {

		return this.query.getQuery();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResult#getQuery()
	 */
	public ISearchQuery getQuery() {

		return this.query;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResult#getTooltip()
	 */
	public String getTooltip() {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResult#removeListener(org.eclipse.search.ui.ISearchResultListener)
	 */
	public void removeListener(ISearchResultListener l) {

		this.searchResultlisteners.remove(l);
	}

	/**
	 * Send the given <code>SearchResultEvent</code> to all registered search result listeners.
	 * 
	 * @param e
	 *            the event to be sent
	 * 
	 * @see ISearchResultListener
	 */
	protected void fireChange(SearchResultEvent e) {

		final Iterator<ISearchResultListener> listeners = this.searchResultlisteners.iterator();
		while (listeners.hasNext()) {
			(listeners.next()).searchResultChanged(e);
		}

	}

	private MQLresultSetEvent getSearchResultEvent(MQLResultSet mqlResultSet) {

		this.mqlResultSetEvent.setMqlResultSet(mqlResultSet);
		return this.mqlResultSetEvent;

	}

	/**
	 * @param query
	 *            the query to set
	 */
	public void setQuery(MQLSearchQuery query) {

		this.query = query;
	}

	/**
	 * @return the result
	 */
	public MQLResultSet getResult() {

		return this.mqlResultSet;
	}

	/**
	 * @param mqlResultSet
	 *            the result to set
	 */
	public void setResult(MQLResultSet mqlResultSet) {

		this.mqlResultSet = mqlResultSet;
		fireChange(getSearchResultEvent(mqlResultSet));
	}

	public int getResultSize() {

		final int res = 0;
		if (this.mqlResultSet != null) {
			return this.mqlResultSet.getSize();
		}
		return res;

	}

	public void removeRows(List<Integer> rowIndexes) {

		if (!getResult().isEmpty() && rowIndexes != null && !rowIndexes.isEmpty()) {
			int i = 0;
			for (final Integer rowIndex : rowIndexes) {
				try {
					getResult().removeRow(rowIndex - i);
				}
				catch (final MQLResultException e) {
					MQLSearchResult.tracer.log(Level.SEVERE, e.getMessage(), e);
					throw new RuntimeException(e);
				}
				i = i + 1;
			}
			fireChange(getSearchResultEvent(getResult()));
		}
	}

	public void removeAllRows() {

		while (!getResult().isEmpty()) {
			try {
				getResult().removeRow(0);
			}
			catch (final MQLResultException e) {
				MQLSearchResult.tracer.log(Level.SEVERE, e.getMessage(), e);
				throw new RuntimeException(e);
			}
		}
		fireChange(new RemoveAllEvent(this));
	}

	public MODE getQueryMode() {

		return this.query.getQueryMode();
	}

}
