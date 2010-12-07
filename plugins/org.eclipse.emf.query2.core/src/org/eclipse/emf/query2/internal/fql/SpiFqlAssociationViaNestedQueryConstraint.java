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
 * This association-based join constraint is defined between one query entry and
 * a nested query or fixed set of elements. Moreover, this association-based
 * join constraint can be negated!
 * 
 * @author D045917
 */
public interface SpiFqlAssociationViaNestedQueryConstraint extends SpiFqlAssociationConstraint {

	/**
	 * Returns if this association is negated.
	 */
	boolean isNegated();

	/**
	 * Returns the nested query or result of this join constraint.
	 */
	NestedQueryOrResult getNestedQueryOrResult();

	/**
	 * We support two forms for the nested structure: a nested query or a nested
	 * result set.
	 */
	interface NestedQueryOrResult {

	}

	/**
	 * The nested structure entails a query
	 */
	interface NestedFqlQuery extends NestedQueryOrResult {

		SpiFqlQuery getNestedFqlQuery();
	}

	/**
	 * The nested structure entails a set of MRIs
	 */
	interface NestedResult extends NestedQueryOrResult {

		/**
		 * Returns a fixed set of result elements. This method does not return
		 * null.
		 */
		URI[] getNestedResults();
	}

}
