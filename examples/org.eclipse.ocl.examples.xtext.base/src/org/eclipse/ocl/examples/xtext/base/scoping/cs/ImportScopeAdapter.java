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
 * $Id: ImportScopeAdapter.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.cs;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;

public class ImportScopeAdapter extends MonikeredElementCSScopeAdapter<ImportCS, org.eclipse.ocl.examples.pivot.Package>
{
	private URI uri = null;
	private Element importedElement = null;
	
	public ImportScopeAdapter(TypeManager typeManager, ImportCS csElement) {
		super(typeManager, csElement, org.eclipse.ocl.examples.pivot.Package.class);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == null) {
			environmentView.addElementsOfScope(typeManager, importedElement, scopeView);
		}
		else {
			environmentView.addElementsOfScope(typeManager, importedElement, scopeView);
		}
		return scopeView.getOuterScope();
	}

	public void setImportedElement(URI uri, Element importedElement) {
		this.uri = uri;
		this.importedElement = importedElement;
	}

	public Element getImportedElement() {
		return importedElement;
	}

	public URI getURI() {
		return uri;
	}
}
