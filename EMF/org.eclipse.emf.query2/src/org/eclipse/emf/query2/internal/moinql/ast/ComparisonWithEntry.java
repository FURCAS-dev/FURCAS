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
package org.eclipse.emf.query2.internal.moinql.ast;

/**
 * This class embodies the comparison with entry. It comes in two flavors: type
 * and attribute comparisons.
 */
public abstract class ComparisonWithEntry extends WithEntry {

	abstract public TypeReference getLeftTypeReference();

	abstract public TypeReference getRightTypeReference();

	abstract public AtomicEntry getLeftAtomicEntry();

	abstract public AtomicEntry getRightAtomicEntry();

	abstract public void setLeftType(TypeReference typeRef);

	abstract public void setRightType(TypeReference typeRef);

}
