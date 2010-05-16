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
 * $Id: ImportScopeAdapter.java,v 1.3 2010/05/16 19:18:01 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;

public class ImportScopeAdapter extends AbstractScopeAdapter<ImportCS>
{
	private URI uri = null;
	private EObject importedElement = null;
	
	public ImportScopeAdapter(ImportCS csElement) {
		super(csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == null) {
			environmentView.addElementsOfScope(importedElement, scopeView);
		}
		else {
			environmentView.addElementsOfScope(importedElement, scopeView);
		}
		return scopeView.getOuterScope();
	}

	public void setImportedElement(URI uri, EObject importedElement) {
		this.uri = uri;
		this.importedElement = importedElement;
	}

	public EObject getImportedElement() {
		return importedElement;
	}

	public URI getURI() {
		return uri;
	}
}
