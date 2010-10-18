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

import org.eclipse.emf.query2.internal.fql.SpiFqlJoinConstraint;

/**
 * A JoinWhereEntry entails a constraint over multiple From-Entries. There are
 * two possibilities 1) a semantic join over primitive typed attributes or
 * aliases, or 2) a connection via a meta-model association. There are two ways
 * to express the latter, depending on whether attributes from both involved
 * types are required or not. If not, a nested query is used, which may lead to
 * a more efficient handling in the facility.
 */
public abstract class WithEntry implements SpiFqlJoinConstraint {

	abstract public String toString(int indent, StringBuilder accumSb);

}
