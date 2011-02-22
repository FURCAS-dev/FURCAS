package org.eclipse.emf.query2;

import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query2.internal.moinql.controller.QueryProcessorImpl;

public class QueryProcessorFactory {
	
	private static final QueryProcessorFactory INSTANCE = new QueryProcessorFactory();
	
	public static QueryProcessorFactory getDefault() {
		return INSTANCE;
	}

	public QueryProcessor createQueryProcessor(Index index) {
		return new QueryProcessorImpl(index, false);
	}
	/**
	 * To be used when resultset needs to be sorted.Sorting disabled by default
	 * @param index
	 * @param isSortingNeeded
	 * @return
	 */
	public QueryProcessor createQueryProcessor(Index index,boolean isSortingNeeded){
		return new QueryProcessorImpl(index,isSortingNeeded);
	}
}
