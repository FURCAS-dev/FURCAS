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

import org.eclipse.emf.ecore.EObject;

/**
 * The update statement extends the behaviour of the {@link org.eclipse.emf.query.statements.SELECT}
 *  statement to include the {@link org.eclipse.emf.query.statements.SET} clause
 *  that allows some operation to be performed on each of the result EObjects.
 * 
 * @author Yasser Lulu 
 */
public class UPDATE extends SELECT {
    private SET set;   

    public UPDATE(FROM from, WHERE where, SET set) {
        this(true, from, where, set);
    }

    public UPDATE(boolean cancellable, FROM from, WHERE where, SET set) {
        this(UNBOUNDED, cancellable, from, where, set);
    }

    public UPDATE(int maximumResultSize, FROM from, WHERE where, SET set) {
        this(maximumResultSize, true, from, where, set);
    }

    public UPDATE(
        int maximumResultSize,
        boolean cancellable,
        FROM from,
        WHERE where,
        SET set) {
        super(maximumResultSize, cancellable, from, where);
        this.set = set;
    }

    @Override
	protected void addEObject(EObject eObject) {
        if (getSetClause().set(eObject)) {
            super.addEObject(eObject);
        }
    }    

    private SET getSetClause() {
        return set;
    }
}
