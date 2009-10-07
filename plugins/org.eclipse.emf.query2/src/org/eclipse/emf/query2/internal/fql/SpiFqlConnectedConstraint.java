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

/**
 * An FqlConnectedCondition stands for a logical AND or OR connection of several
 * nested conditions (all on the same where entry)
 * 
 * @author D045917
 */
public interface SpiFqlConnectedConstraint extends SpiFqlLocalConstraint {

	/**
	 * Returns at least 2 or more nested conditions which are logically
	 * connected.
	 */
	SpiFqlLocalConstraint[] getNestedConstraint();

	/**
	 * If true, the logical connection is OR, otherwise it is AND
	 */
	boolean isOrConnected();
}
