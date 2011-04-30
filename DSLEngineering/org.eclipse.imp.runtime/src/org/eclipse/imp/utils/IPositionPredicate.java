/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

/**
 * 
 */
package org.eclipse.imp.utils;

import org.eclipse.jface.text.Position;

/**
 * Interface that represents a single-argument predicate taking a textual Position.
 * Used by AnnotationUtils to detect annotations associated with a particular range
 * or location in source text.
 * @author rfuhrer
 */
public interface IPositionPredicate {
    boolean matchPosition(Position p);
}