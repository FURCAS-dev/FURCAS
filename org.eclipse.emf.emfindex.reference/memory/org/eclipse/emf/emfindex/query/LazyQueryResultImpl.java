/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query;

import java.util.Iterator;

/**
 * @author koehnlein
 */
public class LazyQueryResultImpl<DescriptorType> implements QueryResult<DescriptorType> {

	private Iterable<DescriptorType> result;

	public LazyQueryResultImpl(Iterable<DescriptorType> result) {
		this.result = result;
	}

	public boolean isEmpty() {
		return !iterator().hasNext();
	}

	public Iterator<DescriptorType> iterator() {
		return result.iterator();
	}

}
