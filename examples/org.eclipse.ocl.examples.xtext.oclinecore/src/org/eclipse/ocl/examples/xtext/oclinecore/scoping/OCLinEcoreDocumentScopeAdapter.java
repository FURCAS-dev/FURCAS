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
 * $Id: OCLinEcoreDocumentScopeAdapter.java,v 1.2 2010/05/03 14:43:04 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.scoping;

import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.util.ElementUtil;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractDocumentScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.FilteredAccesses;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreDocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreLinkingService;
import org.eclipse.ocl.examples.xtext.oclstdlib.scoping.StandardDocumentScopeAdapter;
import org.eclipse.xtext.resource.IEObjectDescription;

public class OCLinEcoreDocumentScopeAdapter extends StandardDocumentScopeAdapter<OCLinEcoreDocumentCS>
{
	protected static final Logger log = Logger.getLogger(OCLinEcoreLinkingService.class);

	public OCLinEcoreDocumentScopeAdapter(OCLinEcoreDocumentCS csElement) {
		super(csElement);
	}

	@Override
	public void createContents(FilteredAccesses filteredAccesses, EStructuralFeature containmentFeature) {
		if (filteredAccesses.accepts(BaseCSTPackage.Literals.PACKAGE_CS)) {
			filteredAccesses.addNamedElements(getTarget().getPackages());
			for (ImportCS anImport : getTarget().getImports()) {
				if (anImport.getName() == null) {
					NamespaceCS namespace = anImport.getNamespace();
					if (namespace instanceof OCLinEcoreDocumentCS) {
						filteredAccesses.addNamedElements(((OCLinEcoreDocumentCS)namespace).getPackages());
					}
				}
				else {
					filteredAccesses.addNamedElement(anImport);
				}
			}
		}
	}

	@Override
	public Logger getLogger() {
		return log;
	}
}
