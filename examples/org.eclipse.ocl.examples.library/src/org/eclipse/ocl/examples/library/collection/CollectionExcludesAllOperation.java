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
 * $Id: CollectionExcludesAllOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.collection;

import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * CollectionExcludesAllOperation realises the Collection::excludesAll() library operation.
 * 
 * @since 3.1
 */
public class CollectionExcludesAllOperation extends AbstractCollectionPairedOperation
{
	public static final CollectionExcludesAllOperation INSTANCE = new CollectionExcludesAllOperation();

	@Override
	protected BooleanValue evaluateCollection(ValueFactory valueFactory, CollectionValue sourceVal, CollectionValue argVal) {
		return sourceVal.excludesAll(argVal);
	}
}
