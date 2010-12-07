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

package org.eclipse.emf.query.handlers;

import org.eclipse.emf.ecore.EObject;

/**
 * An abstract class that represents a prune handler. It is used by EObjectConditions 
 * to check if a given <code>EObject</code> has children -recursively- that are worth evaluating,
 * or, if all the contained EObjects for the given <code>EObject</code> will never satisfy the 
 * <code>EObjectCondition</code> at all, and hence there is no need to check them at all.
 * 
 * It is important for clients to know that 
 * pruning is treated as a hint only and is used solely to improve query performance
 * and should not be relied on for correctness of the <code>EObjectCondition</code> evaluation.
 * An <code>EObjectCondition</code> could not be consulted at all on pruning issue, and, its 
 * response -if it get consulted- might not be honoured by the query -especially
 * when having an <code>EObjectCondition</code> logically combined with another.
 * 
 * Clearly this <code>PruneHandler</code> is an <code>EObjectCondition</code> and a metamodel specific, and that's
 * why there is no default implementation other than the trivial cases of prune-always
 * or never-prune. <code>EObjectCondition</code> that use a <code>PruneHandler</code> usually default to using
 * the PruneHandler.NEVER so as to visit and evaluate every child in the <code>EObject</code> containment tree,
 * in this sense, providing a <code>PruneHandler</code> by clients is optional, nevertheless, it is 
 * there to allow clients to provide their own implementation as a way to enhance
 * performance of queries by not visiting useless branches.
 * 
 * This class is intended to be subclassed by clients.        
 */
public abstract class PruneHandler {

	/**
	 * A simple <code>PruneHandler</code> implementation that will always prune
	 * regardless of the nature of the <code>EObjectCondition</code> used or the argument
	 * eObject passed. The shouldPrune(EObject) will always return <code>true</code>.  
	 */
	public static final PruneHandler ALWAYS = new PruneHandler() {

		@Override
		public boolean shouldPrune(EObject eObject) {
			return true;
		}
	};

	/**
	 * A simple <code>PruneHandler</code> implementation that will never prune
	 * regardless of the nature of the <code>EObjectCondition</code> used or the argument
	 * eObject passed. The shouldPrune(EObject) will always return <code>false</code>. 
	 */
	public static final PruneHandler NEVER = new PruneHandler() {

		@Override
		public boolean shouldPrune(EObject eObject) {
			return false;
		}
	};

	/**
	 * Answers whether the children -recursively- of the argument <code>EObject</code> are
	 * not worth evaluating by a given <code>EObjectCondition</code>
	 *   
	 * @param eObject The <code>EObject</code> whose children are being checked. 
	 * @return boolean <code>true</code> if this prune handler finds out that the argument
	 * eObject's children -recursively- will always evaluate to <code>false</code> by the 
	 * respective <code>EObjectCondition</code> that this <code>PruneHandler</code> is written to help.   
	 */
	public abstract boolean shouldPrune(EObject eObject);
}