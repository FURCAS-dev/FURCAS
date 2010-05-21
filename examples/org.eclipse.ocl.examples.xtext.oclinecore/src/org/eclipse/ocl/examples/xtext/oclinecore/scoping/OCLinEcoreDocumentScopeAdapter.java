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
 * $Id: OCLinEcoreDocumentScopeAdapter.java,v 1.7 2010/05/21 20:13:57 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.scoping;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
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
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		if (environmentView.accepts(BaseCSTPackage.Literals.PACKAGE_CS)) {
			TypeBindingsCS bindings = scopeView.getBindings();
			for (ImportCS anImport : getTarget().getImports()) {
				if (anImport.getName() == null) {
					NamespaceCS namespace = anImport.getNamespace();
					if (namespace instanceof OCLinEcoreDocumentCS) {
						environmentView.addNamedElements(((OCLinEcoreDocumentCS)namespace).getPackages(), bindings);
					}
				}
				else {
					if (environmentView.addNamedElement(anImport, bindings) > 0) {
						EcoreUtil.resolveAll(anImport.getNamespace());
					}
				}
			}
			environmentView.addNamedElements(getTarget().getPackages(), bindings);		// Overrides imports
		}
		return null;
	}

	@Override
	public Logger getLogger() {
		return log;
	}
}
