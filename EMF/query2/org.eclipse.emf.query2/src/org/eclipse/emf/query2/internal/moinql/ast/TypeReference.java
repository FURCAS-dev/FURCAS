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

/**
 * This interface stands for a type reference.
 */
public interface TypeReference {

	String toString(int indent, StringBuilder accumSb);

	AtomicEntry getAtomicEntry();

	AtomicEntryReference getAtomicEntryReference();
}
