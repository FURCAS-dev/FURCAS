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
package de.hpi.sam.bp2009.solution.impactAnalyzer.util;

import java.util.Map.Entry;

import org.eclipse.ocl.ecore.OperationCallExp;

/**
 * Keys sets of elements by {@link OperationCallExp} elements and implements the {@link Iterable} interface. The {@link Iterable}
 * view on this data structure iterates all values in this structure where duplicates are possible because each element of type
 * <code>E</code> could occur for more than one {@link OperationCallExp}.
 * <p>
 * 
 * The <code>null</code> key is special and means that a result was computed without tracing back through an operation's
 * <code>self</code> or parameter variable. For example, this is the case for an <code>allInstances()</code> call found inside an
 * operation body. Such results always apply for the immediately-calling {@link OperationCallExp} and need to be added to their
 * results. The special getter {@link #getCombinedResultsFor(OperationCallExp)} adds the values for key <code>null</code> to the
 * values for the key specified. The <code>null</code> key can also be used to manage results not obtained within operation
 * bodies at all.
 * <p>
 * 
 * @author Axel Uhl (D043530)
 */
public interface OperationCallExpKeyedSet extends Iterable<AnnotatedEObject> {
    Iterable<AnnotatedEObject> getCombinedResultsFor(OperationCallExp oce);
    boolean isEmpty();
    Iterable<Entry<OperationCallExp, Iterable<AnnotatedEObject>>> entrySet();
}
