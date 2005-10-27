/******************************************************************************
 * Copyright (c) 2002, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.query.conditions.eobjects;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

/**
 * <p>
 * This class represnts a simple implementation of {@link org.eclipse.emf.query.conditions.eobjects.IEObjectSource}
 *  that is constructed with one EObject or a collection of EObjects.
 * </p>
 * <p>
 * This class is intended to be used by clients that need to pass their input
 *  to a query statement for execution.
 * </p>
 * 
 * @author Yasser Lulu 
 */
public class EObjectSource implements IEObjectSource {
    private EObject eObject;
    private Set set;

    /**
     * Initializes me with a single sub-tree from which to get objects.
     * 
     * @param eObject the root of a sub-tree to query
     */
    public EObjectSource(EObject eObject) {
        this.eObject = eObject;
    }

    /**
     * Initializes me with (potentially) multiple sub-trees from which to get
     * objects.
     * 
     * @param eObjects the roots (zero or more) of sub-trees to query
     */
    public EObjectSource(Collection eObjects) {
        if (eObjects instanceof Set) {
            set = (Set) eObjects;
        } else {
            set = new HashSet();
            set.addAll(eObjects);
        }
    }

    public Set getEObjects() {
        if (set == null) {
            set = new HashSet();
            set.add(eObject);
        }
        return set;
    }
}
