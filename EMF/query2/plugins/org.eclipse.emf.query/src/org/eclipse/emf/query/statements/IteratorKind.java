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

package org.eclipse.emf.query.statements;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * An enumeration of iteration methodologies for EObjects.
 * 
 * @author Yasser Lulu 
 */
public enum IteratorKind implements Enumerator {
    /**
     * Iterate in a &quot;flat&quot; fashion without traversing the contents
     *  of the EObjects.
     */
    FLAT_LITERAL("FLAT"), //$NON-NLS-1$

    /**
     * Iterate in a &quot;hierarchical&quot; fashion traversing the containment
     *  subtree of each EObject.
     */
    HIERARCHICAL_LITERAL("HIERARCHICAL"); //$NON-NLS-1$

    public static final int FLAT = FLAT_LITERAL.getValue();
    public static final int HIERARCHICAL = HIERARCHICAL_LITERAL.getValue();

    private static final List<IteratorKind> values = java.util.Arrays.asList(values());

    public static final List<IteratorKind> VALUES = Collections.unmodifiableList(values);

    private final String name;
    
    private IteratorKind(String name) {
        this.name = name;
    }

    public static IteratorKind get(int val) {
        if (val >= values.size() || val < 0) {
            return null;
        }
        return values.get(val);
    }

    public static IteratorKind get(String name) {
        for (IteratorKind next : values()) {
            if (next.getName().equals(name)) {
                return next;
            }
        }
        return null;
    }

    public static int getTotalCount() {
        return values.size();
    }
    
    public String getLiteral() {
    	return getName();
    }
    
    public String getName() {
    	return name;
    }
    
    public int getValue() {
    	return ordinal();
    }
}
