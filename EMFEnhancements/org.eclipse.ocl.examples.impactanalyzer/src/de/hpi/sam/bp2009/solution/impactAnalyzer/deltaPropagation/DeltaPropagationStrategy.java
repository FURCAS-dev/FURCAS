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
package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation;

import java.util.Collection;

import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.Tuple.Pair;

/**
 * For a given OCL expression and a delta for its value, implementations of this interface can
 * decide whether the delta can be propagated and eventually compute the propagated delta.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public interface DeltaPropagationStrategy {
    /**
     * Maps a <tt>delta</tt> of <tt>e</tt>'s value to the delta of one or more other expressions, typically such expressions that
     * contain or use <tt>e</tt>, as in the case where <tt>e</tt> is the body of a <tt>collect</tt> expression or the
     * {@link CallExp#getSource() source} of a {@link CallExp} expression. The case where multiple pairs are returned may happen,
     * e.g., when <tt>e</tt> is the body of an operation which gets called by several {@link OperationCallExp} expressions in the
     * context of the overall expression for which to analyze the change propagation.
     * 
     * @return <tt>null</tt> if the delta cannot be propagated, or zero or more pairs each of which containing the expression to
     *         which the original <tt>delta</tt> propagates monotonically and the mapped, non-<tt>null</tt> non-empty delta in the
     *         {@link Pair#getB b} component of the pair returned. If <tt>delta</tt> propagates to an empty delta for some
     *         other expression, no entry is created for this in the result collection. If a non-<tt>null</tt> but empty collection is returned
     *         this means that the <tt>delta</tt> of <tt>e</tt>'s value has no effect on the overall expression analyzed.
     */
    Collection<Pair<OCLExpression, Collection<Object>>> mapDelta(OCLExpression e, Collection<Object> delta);
}
