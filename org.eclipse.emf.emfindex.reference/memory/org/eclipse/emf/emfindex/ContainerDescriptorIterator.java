/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex;

import java.util.Iterator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.emfindex.util.AbstractPruningIterator;

/**
 * @author koehnlein
 */
public class ContainerDescriptorIterator extends AbstractPruningIterator<ContainerDescriptor> {

	public ContainerDescriptorIterator(Iterable<?> initialContents) {
		super(initialContents);
	}

	public ContainerDescriptorIterator(Object initialElement) {
		super(initialElement);
	}

	@Override
	protected Iterator<?> getChildrenIterator(Object next) {
		if (next instanceof Resource) {
			return ((Resource) next).getContents().iterator();
		}
		return null;
	}

	@Override
	protected boolean isReturnType(Object next) {
		return next instanceof ContainerDescriptor;
	}

}
