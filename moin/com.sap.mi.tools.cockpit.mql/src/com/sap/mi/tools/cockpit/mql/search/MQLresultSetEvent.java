/**
 * 
 */
package com.sap.mi.tools.cockpit.mql.search;

import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.SearchResultEvent;

import com.sap.tc.moin.repository.mql.MQLResultSet;

/**
 * @author d003456
 * 
 */
public class MQLresultSetEvent extends SearchResultEvent {

	private static final long serialVersionUID = -4854879076528983266L;

	private MQLResultSet mqlResultSet;

	/**
	 * Constructs a new <code>MQLresultSetEvent</code>.
	 * 
	 * @param searchResult
	 *            the search result concerned
	 */
	public MQLresultSetEvent(ISearchResult searchResult) {

		super(searchResult);
	}

	/**
	 * @return the mqlResultSet
	 */
	public MQLResultSet getMqlResultSet() {

		return this.mqlResultSet;
	}

	/**
	 * @param mqlResultSet
	 *            the mqlResultSet to set
	 */
	public void setMqlResultSet(MQLResultSet mqlResultSet) {

		this.mqlResultSet = mqlResultSet;
	}

}
