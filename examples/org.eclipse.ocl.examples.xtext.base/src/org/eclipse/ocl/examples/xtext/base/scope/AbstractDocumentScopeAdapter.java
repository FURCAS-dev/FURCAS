/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: AbstractDocumentScopeAdapter.java,v 1.5 2010/05/29 15:30:45 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scope;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTFactory;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundDocumentCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;

public abstract class AbstractDocumentScopeAdapter<T extends DocumentCS>
	extends AbstractScopeAdapter<T>
	implements DocumentScopeAdapter
{
	private BoundDocumentCS boundDocument = null;
	private long modificationCount = 0;

	public AbstractDocumentScopeAdapter(T csElement) {
		super(csElement);
	}

	public void endModification() {}

	public String getAlias(PackageCS csPackage) {
		for (ImportCS csImport : getTarget().getImports()) {
			if (csPackage.getOriginalObject() == csImport.getNamespace().getOriginalObject()) {
				return csImport.getName();
			}
		}
		return csPackage.getName();
	}

	public BoundDocumentCS getBoundDocument() {
		if (boundDocument == null) {
			Resource eResource = getTarget().eResource();
			ResourceSet resourceSet = eResource.getResourceSet();
			for (Resource resource : resourceSet.getResources()) {
				if (resource.getContents().size() == 1) {
					EObject content = resource.getContents().get(0);
					if (content instanceof BoundDocumentCS) {
						boundDocument = (BoundDocumentCS) content;
						break;
					}
				}
			}
			if (boundDocument == null) {
				URI uri = URI.createURI("bound-document.xmi"); //$NON-NLS-1$
				Resource resource = resourceSet.createResource(uri);
				resourceSet.getResources().add(resource);
				boundDocument = BaseCSTFactory.eINSTANCE.createBoundDocumentCS();
				resource.getContents().add(boundDocument);
			}
		}
		return boundDocument;
	}

	@Override
	public AbstractDocumentScopeAdapter<?> getDocumentScopeAdapter() {
		return this;
	}

	public abstract Logger getLogger();
	
	public long getModificationCount() {
		return modificationCount;
	}

	public void startModification() {
		modificationCount++;
	}
}
