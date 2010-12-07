/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
/*
 * Created on 16.02.2006
 */
package org.eclipse.emf.query2.internal.moinql.ast;

import org.eclipse.emf.query2.internal.fql.SpiFqlLocalConstraint;
import org.eclipse.emf.query2.internal.fql.SpiFqlQueryEntry;

/**
 * A WhereClause provides a means to put constraints on primitive typed
 * attribute values. A where-clause may put any number of constraints on the
 * attributes of one alias and connect them logically via and/or.
 */
public abstract class WhereClause implements SpiFqlLocalConstraint {

	protected AtomicEntry atomicEntry;

	abstract public String toString(int indent, StringBuilder accumSb);

	public AtomicEntry getAtomicEntry() {

		return this.atomicEntry;
	}

	public void setAtomicEntry(AtomicEntry alias) {

		this.atomicEntry = alias;
	}

	/*
	 * FQL
	 */

	public SpiFqlQueryEntry getFqlQueryEntry() {

		return this.atomicEntry;
	}

}
