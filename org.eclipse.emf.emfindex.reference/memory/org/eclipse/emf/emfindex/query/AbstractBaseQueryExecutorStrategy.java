/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query;

import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.emfindex.BaseDescriptor;
import org.eclipse.emf.emfindex.query.spi.QueryExecutorStrategy;
import org.eclipse.emf.emfindex.query.spi.QueryExecutorWithStrategies;

/**
 * Base class for all query executor strategies matching user data.
 * 
 * @author koehnlein
 */
public abstract class AbstractBaseQueryExecutorStrategy<DescriptorType extends BaseDescriptor, QueryType extends AbstractBaseDescriptorQuery<DescriptorType>, IndexType>
		implements QueryExecutorStrategy<DescriptorType, QueryType, IndexType> {

	public void init(QueryExecutorWithStrategies queryExecutor) {
	}
	
	protected boolean match(QueryType query, DescriptorType candidate) {
		Map<String, Serializable> userDataEquals = query.getUserDataEquals();
		if (userDataEquals != null) {
			for (Entry<String, Serializable> entry : userDataEquals.entrySet()) {
				if (!entry.getValue().equals(candidate.getUserData(entry.getKey()))) {
					return false;
				}
			}
		}
		return internalMatch(query, candidate);
	}

	protected abstract boolean internalMatch(QueryType query, DescriptorType candidate);
}