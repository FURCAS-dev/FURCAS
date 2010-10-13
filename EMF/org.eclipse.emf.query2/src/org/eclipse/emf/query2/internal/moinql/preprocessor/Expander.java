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
 * Created on 02.03.2006
 */
package org.eclipse.emf.query2.internal.moinql.preprocessor;

import org.eclipse.emf.query2.QueryPreprocessorException;
import org.eclipse.emf.query2.internal.moinql.ast.InternalQuery;

/**
 * The expander transforms the internal query such that its <i>leafs</i> are
 * interpretable by a facility query language. If a particular part of the MQL
 * query is not supported the
 * {@link org.eclipse.emf.query2.QueryNotSupportedException} is thrown
 */
public interface Expander {

	/**
	 * Expands the internal query structure
	 */
	InternalQuery expand(InternalQuery internalQuery) throws QueryPreprocessorException;

}
