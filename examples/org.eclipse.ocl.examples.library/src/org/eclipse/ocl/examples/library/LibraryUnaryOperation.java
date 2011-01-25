/**
 * <copyright>
 *
 * Copyright (c) 2009,2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: LibraryUnaryOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library;

import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * @since 3.1
 */
public interface LibraryUnaryOperation extends LibraryOperation {
	/**
	 * Return the result of evaluating the operation on an argument.
	 * An invalid return may be indicated by throwing an exception returning Java null or OCL invalid.
	 *
	 * @param argument the argument
	 * @return the evaluated value
	 */
	Value evaluate(ValueFactory valueFactory, Value argument);
}
