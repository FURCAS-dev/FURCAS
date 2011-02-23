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

import org.eclipse.ocl.ecore.OperationCallExp;

/**
 * Produces {@link OperationCallExpKeyedSet} objects, either of type {@link OperationCallExpKeyedSetImpl} in case
 * the <code>isOperationCallSelectionActive</code> argument passed to the constructor was <code>true</code>,
 * or {@link FlatSet} objects otherwise.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class OperationCallExpKeyedSetFactory {
    private final boolean isOperationCallSelectionActive;

    public OperationCallExpKeyedSetFactory(boolean isOperationCallSelectionActive) {
        this.isOperationCallSelectionActive = isOperationCallSelectionActive;
    }
    
    public OperationCallExpKeyedSet createOperationCallExpKeyedSet(OperationCallExp oce, OperationCallExpKeyedSet c) {
        if (isOperationCallSelectionActive) {
            return new OperationCallExpKeyedSetImpl(oce, c);
        } else {
            return c;
        }
    }

    public OperationCallExpKeyedSet createOperationCallExpKeyedSet(AnnotatedEObject aeo) {
        if (isOperationCallSelectionActive) {
            return new OperationCallExpKeyedSetImpl(aeo);
        } else {
            return new FlatSet(aeo);
        }
    }
    
    public OperationCallExpKeyedSet createOperationCallExpKeyedSet(Collection<OperationCallExpKeyedSet> sets) {
        if (isOperationCallSelectionActive) {
            if (sets.isEmpty()) {
                return OperationCallExpKeyedSetImpl.emptySet();
            } else if (sets.size() == 1) {
                return sets.iterator().next();
            } else {
                return new OperationCallExpKeyedSetImpl(sets);
            }
        } else {
            return new FlatSet(sets);
        }
    }

    public OperationCallExpKeyedSet emptySet() {
        if (isOperationCallSelectionActive) {
            return OperationCallExpKeyedSetImpl.emptySet();
        } else {
            return FlatSet.emptySet();
        }
    }
    
}
