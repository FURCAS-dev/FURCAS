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

import org.eclipse.emf.common.util.URI;

/**
 * An association constraint defines a join constraint by limiting the instances
 * of the involved where entries by imposing the existence of links. There are
 * two forms as denoted by the subtypes.
 * 
 * @author D045917
 */
public interface SpiFqlAssociationConstraint extends SpiFqlJoinConstraint {

	/**
	 * Returns the MRI of the association meta object
	 * 
	 * @return the MRI of the assocation
	 */
	URI getAssocMRI();

	/**
	 * Returns the integer encoding for the from-side
	 * 
	 * @return the integer encoding for the from-side
	 */
	int getFromAssocEnd();

	/**
	 * Returns the query entry for the from-side
	 * 
	 * @retrun the query entry for the from-side
	 */
	SpiFqlQueryEntry getFromEndEntry();

	/**
	 * Indicates if we have storage at the from-side
	 * 
	 * @return true if we have storage at the from-side, otherwise false
	 */
	boolean hasStorageAtFromEnd();

	/**
	 * Indicates if we have storage at the to-side
	 * 
	 * @return true if we have storage at the to-side, otherwise false
	 */
	boolean hasStorageAtToEnd();

	/*
	 * For debugging purposes
	 */

	/**
	 * Returns the name of the association
	 * 
	 * @return the name of the association
	 */
	String getAssocName();

	/**
	 * Returns the name of the association end at the from-side
	 * 
	 * @return the name of the association end at the from-side
	 */
	String getFromAssocEndName();

	/**
	 * Returns the name of the association end at the to-side
	 * 
	 * @return the name of the association end at the to-side
	 */
	String getToAssocEndName();

}
