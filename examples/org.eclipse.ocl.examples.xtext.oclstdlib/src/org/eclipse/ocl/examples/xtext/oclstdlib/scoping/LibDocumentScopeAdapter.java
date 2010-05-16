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
 * $Id: LibDocumentScopeAdapter.java,v 1.3 2010/05/16 19:20:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.scoping;

import org.apache.log4j.Logger;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractDocumentScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibDocumentCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.services.OCLstdlibLinkingService;

public class LibDocumentScopeAdapter extends AbstractDocumentScopeAdapter<LibDocumentCS>
{
	protected static final Logger log = Logger.getLogger(OCLstdlibLinkingService.class);

	public LibDocumentScopeAdapter(LibDocumentCS csElement) {
		super(csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		environmentView.addNamedElements(BaseCSTPackage.Literals.PACKAGE_CS, getTarget().getPackages(), scopeView.getBindings());
		return null;
	}

	@Override
	public Logger getLogger() {
		return log;
	}
}
