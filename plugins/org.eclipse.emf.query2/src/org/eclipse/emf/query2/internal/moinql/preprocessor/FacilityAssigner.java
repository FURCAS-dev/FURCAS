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

import java.util.Collection;

import org.eclipse.emf.query2.QueryPreprocessorException;
import org.eclipse.emf.query2.internal.fql.SpiFacilityQueryLanguage;
import org.eclipse.emf.query2.internal.moinql.ast.InternalQuery;


/**
 * The assigner is responsible for assigning the facility query services to the
 * different parts of the internal query. If more than one query service is
 * registered (i.e. more than one facility connected), the internal query is
 * transformed such that it considers all registered facilities.
 */
public interface FacilityAssigner {

	/**
	 * Assign the registered facility services to the Atomic Parts of the
	 * internal query
	 */
	InternalQuery assign(InternalQuery internalQuery, Collection<SpiFacilityQueryLanguage> fqlProcessors) throws QueryPreprocessorException;

}
