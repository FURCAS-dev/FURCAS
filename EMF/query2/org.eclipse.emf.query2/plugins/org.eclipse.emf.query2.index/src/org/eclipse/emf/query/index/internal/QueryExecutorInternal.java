package org.eclipse.emf.query.index.internal;

import org.eclipse.emf.query.index.query.QueryExecutor;
/**
 * Represents QueryExecutor to be used to query the Index
 * 
 */
public interface QueryExecutorInternal extends QueryExecutor {

	public void invalidate();

	public boolean isValid();
}
