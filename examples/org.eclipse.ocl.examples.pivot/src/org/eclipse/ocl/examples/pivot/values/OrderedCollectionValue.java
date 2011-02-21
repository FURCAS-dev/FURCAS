/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: OrderedCollectionValue.java,v 1.3 2011/02/21 08:37:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values;

import org.eclipse.ocl.examples.pivot.InvalidValueException;


public interface OrderedCollectionValue extends CollectionValue
{
    OrderedCollectionValue append(Value object) throws InvalidValueException;
    Value at(int index) throws InvalidValueException;
	Value first() throws InvalidValueException;
    OrderedCollectionValue insertAt(int index, Value object) throws InvalidValueException;
    IntegerValue indexOf(Value object) throws InvalidValueException;
    Value last() throws InvalidValueException;
    OrderedCollectionValue prepend(Value object) throws InvalidValueException;
	OrderedCollectionValue reverse() throws InvalidValueException;
}
