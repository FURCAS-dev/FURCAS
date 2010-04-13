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
package org.eclipse.emf.query2.internal.fql;

import java.util.Set;

import org.eclipse.emf.common.util.URI;

/**
 * An FqlEntryType embodies a query entry which denotes the entire set of
 * instances of the provided types. It permits explicit scoping, which can be
 * inclusive or exclusive. Moreover, the types may either refer to Classes Or
 * StructureTypes
 * 
 * @author D045917
 */
public interface SpiFqlEntryType extends SpiFqlQueryEntry {

	/**
	 * The scope of a type is given by a set of PRIs which can be empty, but not
	 * null.
	 */
	Set<URI> getScope();

	/**
	 * If true, the scope is inclusive, so all instances have to be taken from
	 * within the provided scope. Otherwise, all instances are taken outside the
	 * provided scope (within the client scope as indicated by the connection at
	 * execution time)
	 */
	boolean isScopeInclusive();

	/**
	 * There are two possible type categories: CLASS and STRUCTURETYPE
	 */
	SpiFqlFromTypeCategory getTypeCategory();

}
