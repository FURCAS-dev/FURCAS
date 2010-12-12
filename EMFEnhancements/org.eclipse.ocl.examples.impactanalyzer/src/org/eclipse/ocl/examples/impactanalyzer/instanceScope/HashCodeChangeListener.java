/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.instanceScope;

import org.eclipse.ocl.examples.impactanalyzer.util.SemanticIdentity;

public interface HashCodeChangeListener {
    /**
     * Invoked before <code>step</code>'s {@link SemanticIdentity} changes its hash code. When this method is called for a step,
     * the {@link #afterHashCodeChange(NavigationStep, int)} is guaranteed to be called on the same listener later, immediately
     * after the hash code has changed. Receiving this call gives the receiver the opportunity to remove the step from hashed
     * structures in order to re-insert it later when the hash code has assumed the new value.
     * 
     * @param token
     *            a token value identifying the root cause of the change by a monotonously-increasing number. This can be used in
     *            cyclic {@link NavigationStep} graphs to decide that a root cause has already been handled by a listener when it
     *            comes by a second time.
     */
    void beforeHashCodeChange(NavigationStep step, int token);

    /**
     * Called after the <code>step</code>'s {@link SemanticIdentity} hash code has changed. This gives hash structures the
     * opportunity to enter the step again.
     * 
     * @param token
     *            a token value identifying the root cause of the change by a monotonously-increasing number. This can be used in
     *            cyclic {@link NavigationStep} graphs to decide that a root cause has already been handled by a listener when it
     *            comes by a second time.
     */
    void afterHashCodeChange(NavigationStep step, int token);
}
