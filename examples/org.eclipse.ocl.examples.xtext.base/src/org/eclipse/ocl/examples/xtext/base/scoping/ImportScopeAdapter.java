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
 * $Id: ImportScopeAdapter.java,v 1.2 2010/05/09 17:08:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;

public class ImportScopeAdapter extends AbstractScopeAdapter<ImportCS>
{
	private URI uri = null;
	private ElementCS importedElement = null;
	
	public ImportScopeAdapter(ImportCS csElement) {
		super(csElement);
	}

	@Override
	public boolean computeInheritedEnvironmentView(EnvironmentView environmentView, EStructuralFeature containmentFeature) {
		environmentView.addElementsOfScope(importedElement);
		return false;
	}

	public void setImportedElement(URI uri, ElementCS importedElement) {
		this.uri = uri;
		this.importedElement = importedElement;
	}

	public ElementCS getImportedElement() {
		return importedElement;
	}

	public URI getURI() {
		return uri;
	}
}
