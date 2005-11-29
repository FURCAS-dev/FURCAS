/**
 * <copyright>
 *
 * Copyright (c) 2002-2005 IBM Corporation and others.
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

package org.eclipse.emf.query.statements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * An enumeration of iteration methodologies for EObjects.
 * 
 * @author Yasser Lulu 
 */
public final class IteratorKind extends AbstractEnumerator {
    private static int value;
    private static final List values = new ArrayList();

    /**
     * Iterate in a &quot;flat&quot; fashion without traversing the contents
     *  of the EObjects.
     */
    public static final IteratorKind FLAT_LITERAL = new IteratorKind("FLAT"); //$NON-NLS-1$

    /**
     * Iterate in a &quot;hierarchical&quot; fashion traversing the containment
     *  subtree of each EObject.
     */
    public static final IteratorKind HIERARCHICAL_LITERAL = new IteratorKind("HIERARCHICAL"); //$NON-NLS-1$

    public static final int FLAT = FLAT_LITERAL.getValue();
    public static final int HIERARCHICAL = HIERARCHICAL_LITERAL.getValue();

    public static final List VALUES = Collections.unmodifiableList(values);
    private static final IteratorKind[] VALUES_ARRAY =
        (IteratorKind[]) VALUES.toArray(new IteratorKind[VALUES.size()]);

    private IteratorKind(String name) {
        super(value++, name);
        values.add(this);
    }

    public static IteratorKind get(int val) {
        if (val >= VALUES_ARRAY.length || val < 0) {
            return null;
        }
        return VALUES_ARRAY[val];
    }

    public static IteratorKind get(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            if (VALUES_ARRAY[i].getName().equals(name)) {
                return VALUES_ARRAY[i];
            }
        }
        return null;
    }

    public static int getTotalCount() {
        return VALUES_ARRAY.length;
    }
}
