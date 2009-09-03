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

import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.query.QueryResult;
import org.eclipse.emf.query.index.query.ResourceQuery;
/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class ConvenientUser {

	public void test() {
		final ResourceQuery<ConvenientResourceDescriptor> query = new ConvenientIndexQueryFactory().createResourceQuery();
		query.uri("hallo");

		Index index = null;
		index.executeQueryCommand(new QueryCommand() {

			@Override
			public void execute(QueryExecutor queryExecutor) {
				QueryResult<ConvenientResourceDescriptor> execute = queryExecutor.execute(query);
			}

		});
	}
}
