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
 * $Id: AbstractDocumentScopeAdapter.java,v 1.1 2010/05/03 05:25:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scope;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;

public abstract class AbstractDocumentScopeAdapter<T extends DocumentCS> extends AbstractScopeAdapter<T>
{
	public AbstractDocumentScopeAdapter(T csElement) {
		super(csElement);
	}

	@Override
	public void createContents(FilteredAccesses filteredAccesses, EStructuralFeature containmentFeature) {
		filteredAccesses.addNamedElements(BaseCSTPackage.Literals.NAMESPACE_CS, getTarget().getImports());
		if (filteredAccesses.accepts(BaseCSTPackage.Literals.PACKAGE_CS)) {
			for (ImportCS anImport : getTarget().getImports()) {
				if (anImport.getName() == null) {
					NamespaceCS namespace = anImport.getNamespace();
					if (namespace instanceof PackageCS) {
						filteredAccesses.addNamedElement(namespace);
					}
				}
			}
		}
	}

	public String getAlias(PackageCS csPackage) {
		for (ImportCS csImport : getTarget().getImports()) {
			if (csPackage.getOriginalObject() == csImport.getNamespace().getOriginalObject()) {
				return csImport.getName();
			}
		}
		return csPackage.getName();
	}

	@Override
	public AbstractDocumentScopeAdapter<?> getDocumentScopeAdapter() {
		return this;
	}

	public abstract Logger getLogger();
}
