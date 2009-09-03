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
package org.eclipse.emf.query.index.test.convenience;

import org.eclipse.emf.query.index.api.query.QueryResult;
import org.eclipse.emf.query.index.api.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.impl.query.ResourceQueryImpl;
import org.eclipse.emf.query.index.internal.QueryExecutorInternal;
/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class ConvenientResourceQueryImpl<T> extends ResourceQueryImpl<T> {

	@Override
	public QueryResult<T> createQueryResult(QueryExecutorInternal queryExecutor, Iterable<ResourceDescriptor> result) {
		return null;
	}

}
