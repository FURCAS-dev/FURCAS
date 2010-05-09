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
 * $Id: OCLinEcoreDocumentScopeAdapter.java,v 1.5 2010/05/09 17:08:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.scoping;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreDocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreLinkingService;
import org.eclipse.ocl.examples.xtext.oclstdlib.scoping.StandardDocumentScopeAdapter;

public class OCLinEcoreDocumentScopeAdapter extends StandardDocumentScopeAdapter<OCLinEcoreDocumentCS>
{
	protected static final Logger log = Logger.getLogger(OCLinEcoreLinkingService.class);

	public OCLinEcoreDocumentScopeAdapter(OCLinEcoreDocumentCS csElement) {
		super(csElement);
	}

	@Override
	public boolean computeInheritedEnvironmentView(EnvironmentView environmentView, EStructuralFeature containmentFeature) {
		if (environmentView.accepts(BaseCSTPackage.Literals.PACKAGE_CS)) {
			for (ImportCS anImport : getTarget().getImports()) {
				if (anImport.getName() == null) {
					NamespaceCS namespace = anImport.getNamespace();
					if (namespace instanceof OCLinEcoreDocumentCS) {
						environmentView.addNamedElements(((OCLinEcoreDocumentCS)namespace).getPackages());
					}
				}
				else {
					environmentView.addNamedElement(anImport);
				}
			}
			environmentView.addNamedElements(getTarget().getPackages());		// Overrides imports
		}
		return true;
	}

	@Override
	public Logger getLogger() {
		return log;
	}
}
