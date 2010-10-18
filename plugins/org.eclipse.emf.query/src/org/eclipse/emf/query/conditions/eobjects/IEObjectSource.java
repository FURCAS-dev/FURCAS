/**
 * <copyright>
 *
 * Copyright (c) 2002, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.query.conditions.eobjects;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;

/**
 * An interface the represents an <code>EObject</code> source/supplier. These
 * EObjects are to be used in queries and subjected to evaluation by
 * EObjectCondition. Primarily used to abstract away the identity of source of
 * the EObjects used in queries.
 */
public interface IEObjectSource {

	/**
	 * A getter for the EObjects supplied by this <code>IEObjectSource</code>
	 * 
	 * @return Set The set of EObjects this <code>IEObjectSource</code>
	 *         furnishes
	 */
	Set<? extends EObject> getEObjects();
}