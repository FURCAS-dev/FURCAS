/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.emfindex.util.AbstractPruningIterator;
import org.eclipse.emf.index.ecore.emfindex.EmfindexPackage;

/**
 * @author koehnlein
 */
public class EObjectDescriptorIterator extends AbstractPruningIterator<EObjectDescriptor> {

	public EObjectDescriptorIterator(Iterable<?> initialContents) {
		super(initialContents);
	}

	public EObjectDescriptorIterator(Object initialElement) {
		super(initialElement);
	}

	@Override
	protected Iterator<?> getChildrenIterator(Object next) {
		if (next instanceof Resource) {
			return ((Resource) next).getContents().iterator();
		}
		if (next instanceof ContainerDescriptor
				&& ((EObject) next).eIsSet(EmfindexPackage.Literals.CONTAINER_DESCRIPTOR__RESOURCE_DESCRIPTORS)) {
			return ((ContainerDescriptor) next).getResourceDescriptors().iterator();
		}
		if (next instanceof ResourceDescriptor
				&& ((EObject) next).eIsSet(EmfindexPackage.Literals.RESOURCE_DESCRIPTOR__EOBJECT_DESCRIPTORS)) {
			return ((ResourceDescriptor) next).getEObjectDescriptors().iterator();
		}
		return null;
	}

	@Override
	protected boolean isReturnType(Object next) {
		return next instanceof EObjectDescriptor;
	}

}