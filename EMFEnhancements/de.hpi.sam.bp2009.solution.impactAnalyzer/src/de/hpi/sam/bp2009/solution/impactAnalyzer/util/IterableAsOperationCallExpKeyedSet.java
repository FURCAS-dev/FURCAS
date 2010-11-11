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

import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;

import org.eclipse.ocl.ecore.OperationCallExp;

/**
 * Encapsulates an {@link Iterable} of {@link AnnotatedEObject}s as if it could be queried for the specific
 * operation call expression through which a subset of it was traced. However, it returns the entire iterable's
 * contents from {@link #getCombinedResultsFor(OperationCallExp)}, and {@link #entrySet()} behaves as if
 * the entire iterable were associated with the <code>null</code> key.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class IterableAsOperationCallExpKeyedSet implements OperationCallExpKeyedSet {
    private final Iterable<AnnotatedEObject> iterable;
    
    public IterableAsOperationCallExpKeyedSet(Iterable<AnnotatedEObject> iterable) {
        this.iterable = iterable;
    }

    public Iterator<AnnotatedEObject> iterator() {
        return iterable.iterator();
    }

    public Iterable<AnnotatedEObject> getCombinedResultsFor(OperationCallExp oce) {
        return iterable;
    }

    public boolean isEmpty() {
        return !iterator().hasNext();
    }

    public Iterable<Entry<OperationCallExp, Iterable<AnnotatedEObject>>> entrySet() {
        if (isEmpty()) {
            return Collections.emptySet();
        } else {
            Entry<OperationCallExp, Iterable<AnnotatedEObject>> iterableForNullKey = new EntryIterableWithIterableForNullKey(iterable);
            return Collections.singleton(iterableForNullKey);
        }
    }

}
