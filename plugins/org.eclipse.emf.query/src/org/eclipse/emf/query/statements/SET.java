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

import org.eclipse.emf.query.internal.statements.QueryClause;

/**
 * The set clause is used in conjunction with the {@link org.eclipse.emf.query.statements.UPDATE}
 *  statement to perform some operation on the result EObjects.
 * 
 * @author Yasser Lulu 
 */
public abstract class SET extends QueryClause {
    public SET() {
        super();
    }

    public abstract boolean set(EObject eObject);

}
