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
/*
 * Created on 02.02.2006
 */
package org.eclipse.emf.query2.internal.moinql.engine;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query2.QueryExecutionException;
import org.eclipse.emf.query2.internal.moinql.ast.InternalQuery;


/**
 * The scheduler transforms an internal query based on the current state of the
 * connection. It may have to split the internal query to distribute
 * calculations both on the memory and the non-memory FQL processors. Results of
 * those part calculations have to be combined in memory by the interpreter.
 */
public interface Scheduler {

	/**
	 * Schedules an internal query.
	 */
	InternalQuery schedule(InternalQuery internalQuery, boolean schedulingWanted, boolean globalScopeIncluded, URI[] globalPartitionScope,
			URI[] globalContainerScope, int thresholdForNumberOfRelevantPartitionsForOptimization,
			int thresholdForNumberOfElementsInPartitionForOptimization) throws QueryExecutionException;
}
