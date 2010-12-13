/*******************************************************************************
 * Copyright (c) 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query.index.internal.impl.query;

import org.eclipse.emf.query.index.internal.QueryExecutorInternal;
import org.eclipse.emf.query.index.internal.QueryInternal;
import org.eclipse.emf.query.index.internal.impl.GlobalTables;
import org.eclipse.emf.query.index.query.Query;
import org.eclipse.emf.query.index.query.QueryResult;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class QueryExecutorImpl implements QueryExecutorInternal {

	private final GlobalTables globalTables;
	private boolean valid = true;

	public QueryExecutorImpl(GlobalTables _globalTables) {
		this.globalTables = _globalTables;
	}

	public <T, DescriptorType, QueryType extends Query<T, DescriptorType>> QueryResult<T> execute(QueryType query) {

		return ((QueryInternal<T, DescriptorType>) query).execute(this, this.globalTables);
	}

	public void invalidate() {
		this.valid = false;
	}

	public boolean isValid() {
		return this.valid;
	}

}
