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
 * $Id: CollectionAsSequenceOperation.java,v 1.2 2011/01/24 19:56:30 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * CollectionAsSequenceOperation realises the Collection::asSequence() library operation.
 * 
 * @since 3.1
 */
public class CollectionAsSequenceOperation extends AbstractCollectionUnaryOperation
{
	public static final CollectionAsSequenceOperation INSTANCE = new CollectionAsSequenceOperation();

	@Override
	protected Value evaluateCollection(ValueFactory valueFactory, CollectionValue sourceVal) {
		return sourceVal.asSequenceValue();
	}
}
