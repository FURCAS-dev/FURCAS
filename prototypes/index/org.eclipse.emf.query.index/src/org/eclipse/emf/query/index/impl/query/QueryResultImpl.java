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
package org.eclipse.emf.query.index.impl.query;

import java.util.Iterator;

import org.eclipse.emf.query.index.api.query.QueryResult;
import org.eclipse.emf.query.index.internal.QueryExecutorInternal;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class QueryResultImpl<ExtDescriptorType, IntDescriptorType> implements QueryResult<ExtDescriptorType> {

	private final Iterable<IntDescriptorType> descIt;
	private final QueryExecutorInternal queryExecutor;

	QueryResultImpl(QueryExecutorInternal queryExecutor, Iterable<IntDescriptorType> it) {
		this.queryExecutor = queryExecutor;
		this.descIt = it;
	}

	@Override
	public Iterator<ExtDescriptorType> iterator() {
		final Iterator<IntDescriptorType> it = descIt.iterator();
		return new Iterator<ExtDescriptorType>() {

			@Override
			public boolean hasNext() {
				checkValid();
				return it.hasNext();
			}

			@SuppressWarnings("unchecked")
			@Override
			public ExtDescriptorType next() {
				checkValid();
				return (ExtDescriptorType) it.next();
			}

			@Override
			public void remove() {
				checkValid();
				it.remove();
			}
		};
	}

	private void checkValid() {
		if (!this.queryExecutor.isValid()) {
			throw new IllegalStateException("Query result is not valid anymore");
		}
	}

}
