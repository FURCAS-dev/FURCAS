/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.internal.bql.api;

import org.eclipse.emf.query2.EmfHelper;
import org.eclipse.emf.query2.internal.fql.SpiFacilityQueryLanguage;
import org.eclipse.emf.query2.internal.fql.SpiFqlQueryResultSet;
import org.eclipse.emf.query2.internal.index.SpiFacilityQueryClientScope;
import org.eclipse.emf.query2.internal.index.SpiMQLQueryService;

/**
 * @author D045917
 * @deprecated please implement {@link SpiMQLQueryService} instead
 */
@Deprecated
public interface SpiBasicQueryProcessor extends SpiFacilityQueryLanguage {

	/**
	 * Selects objects with primitive attributes from a select expression.
	 * 
	 * @param clientScope
	 * @param selectExpression
	 * @param partitions
	 *            partition scope
	 * @param maxResultSetSize
	 * @return objects
	 */
	public SpiFqlQueryResultSet execute(EmfHelper _emfHelper, SpiFacilityQueryClientScope queryClientScope,
			SpiSelectExpression selectExpression, int maxResultSetSize, int numberOfRequestedRows);

}