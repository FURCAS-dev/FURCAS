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
 * $Id: BaseDocument.java,v 1.1 2010/05/29 15:30:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.ui.model;

import org.eclipse.ocl.examples.xtext.base.scope.DocumentScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.util.ElementUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

public class BaseDocument extends XtextDocument
{
	protected XtextResource resource2;
	@Override
	public void setInput(XtextResource resource) {
		this.resource2 = resource;
		super.setInput(resource);
	}

	@Override
	public <T> T modify(IUnitOfWork<T, XtextResource> work) {
		if (DocumentScopeAdapter.WORK.isActive()) {
			DocumentScopeAdapter.WORK.println("ModifyWork " + work.getClass().getName() + " on " + Thread.currentThread().getName());
		}
		DocumentScopeAdapter documentScopeAdapter = getDocumentScopeAdapter();
		try {
			if (documentScopeAdapter != null) {
				documentScopeAdapter.startModification();
			}
			return super.modify(work);
		}
		finally {
			if (documentScopeAdapter != null) {
				documentScopeAdapter.endModification();
			}
		}
	}

	@Override
	public <T> T readOnly(IUnitOfWork<T, XtextResource> work) {
		if (DocumentScopeAdapter.WORK.isActive()) {
			DocumentScopeAdapter.WORK.println("ReadOnlyWork " + work.getClass().getName() + " on " + Thread.currentThread().getName());
		}
		return super.readOnly(work);
	}

	protected DocumentScopeAdapter getDocumentScopeAdapter() {
		if (!resource2.getContents().isEmpty()) {
			ScopeAdapter scopeAdapter = ElementUtil.getScopeAdapter(resource2.getContents().get(0));
			if (scopeAdapter != null) {
				return scopeAdapter.getDocumentScopeAdapter();
			}
		}
		return null;
	}
}
