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
package org.eclipse.ocl.examples.impactanalyzer.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.ocl.ecore.OperationCallExp;

/**
 * A simplified implementation of the {@link OperationCallExpKeyedSet} interface which is actually unable to
 * associate the {@link AnnotatedEObject}s with {@link OperationCallExp} expressions but instead just keeps
 * the {@link AnnotatedEObject}s as flat sets.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class FlatSet extends HashSet<AnnotatedEObject> implements OperationCallExpKeyedSet {
    private static final long serialVersionUID = 4506249231724738128L;
    private static final FlatSet EMPTY_SET = new FlatSet();

    /**
     * Only used to create the {@link #EMPTY_SET}
     */
    public FlatSet() {}

    public FlatSet(AnnotatedEObject aeo) {
        add(aeo);
    }

    public FlatSet(Collection<OperationCallExpKeyedSet> sets) {
        for (OperationCallExpKeyedSet set : sets) {
            for (AnnotatedEObject aeo : set) {
                add(aeo);
            }
        }
    }

    /**
     * The combined results is this set itself because it always contains all results for all
     * operation calls, already combined. The <code>oce</code> parameter is ignored here.
     */
    public Iterable<AnnotatedEObject> getCombinedResultsFor(OperationCallExp oce) {
        return this;
    }

    /**
     * The returned iterable's iterator produces a single element with this set contained as iterable value,
     * or an empty iterable in case this set is empty.
     */
    public Iterable<Entry<OperationCallExp, Iterable<AnnotatedEObject>>> entrySet() {
        Set<Entry<OperationCallExp, Iterable<AnnotatedEObject>>> result;
        if (!isEmpty()) {
            result = Collections.emptySet();
        } else {
            Map.Entry<OperationCallExp, Iterable<AnnotatedEObject>> entry = new EntryIterableWithIterableForNullKey(FlatSet.this);
            result = Collections.singleton(entry);
        }
        return result;
    }

    public static OperationCallExpKeyedSet emptySet() {
        return EMPTY_SET;
    }
}
