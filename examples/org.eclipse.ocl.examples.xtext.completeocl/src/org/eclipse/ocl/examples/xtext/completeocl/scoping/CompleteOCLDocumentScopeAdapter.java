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
 * $Id: CompleteOCLDocumentScopeAdapter.java,v 1.5 2010/05/09 17:08:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.scoping;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLLinkingService;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreDocumentCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.scoping.StandardDocumentScopeAdapter;

public class CompleteOCLDocumentScopeAdapter extends StandardDocumentScopeAdapter<CompleteOCLDocumentCS>
{
	protected static final Logger log = Logger.getLogger(CompleteOCLLinkingService.class);

	public CompleteOCLDocumentScopeAdapter(CompleteOCLDocumentCS csElement) {
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
					environmentView.addElement(anImport.getName(), anImport.getNamespace());
				}
			}
		}
		return true;
	}

	@Override
	public Logger getLogger() {
		return log;
	}
}
