/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: AbstractRootCSScopeAdapter.java,v 1.2 2011/01/24 21:00:30 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scope;

import java.util.Map;

import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootCS;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.MonikeredElementCSScopeAdapter;

public abstract class AbstractRootCSScopeAdapter<CS extends RootCS & MonikeredElementCS, P extends MonikeredElement>
	extends MonikeredElementCSScopeAdapter<CS, P>
	implements RootCSScopeAdapter
{
	private long modificationCount = 0;

	public AbstractRootCSScopeAdapter(TypeManager typeManager, CS csElement, Class<P> pivotClass) {
		super(typeManager, csElement, pivotClass);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		if (environmentView.accepts(PivotPackage.Literals.TYPE)) {
			for (Type type : typeManager.getGlobalTypes()) {
				environmentView.addNamedElement(type);
			}
		}
		if (environmentView.accepts(PivotPackage.Literals.NAMESPACE)) {
			for (Map.Entry<String, Namespace> entry : typeManager.getGlobalNamespaces()) {
				environmentView.addElement(entry.getKey(), entry.getValue());
			}
		}
		return super.computeLookup(environmentView, scopeView);
	}

	public void endModification() {}

	public String getAlias(PackageCS csPackage) {
		for (ImportCS csImport : target.getOwnedImport()) {
			if (csPackage.getPivot() == csImport.getNamespace()) {
				return csImport.getName();
			}
		}
		return csPackage.getName();
	}

/*	public BoundDocumentCS getBoundDocument() {
		if (boundDocument == null) {
			Resource eResource = csElement.eResource();
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
	} */
	
	public long getModificationCount() {
		return modificationCount;
	}

	@Override
	public AbstractRootCSScopeAdapter<?,?> getRootScopeAdapter() {
		return this;
	}

	public void startModification() {
		modificationCount++;
	}
}
