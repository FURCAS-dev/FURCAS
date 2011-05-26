/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: BaseURIEditorOpener.java,v 1.1 2011/05/15 20:22:16 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui.model;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;

public class BaseURIEditorOpener extends GlobalURIEditorOpener
{
	@Override
	public IEditorPart open(URI uri, boolean select) {
		if (PivotUtil.isPivotURI(uri)) {
			uri = PivotUtil.getNonPivotURI(uri);		// FIXME map AST to CST URI too
		}
		return super.open(uri, select);
	}

	@Override
	public IEditorPart open(URI referenceOwnerURI, EReference reference, int indexInList, boolean select) {
		referenceOwnerURI = PivotUtil.isPivotURI(referenceOwnerURI) ? PivotUtil.getNonPivotURI(referenceOwnerURI) : referenceOwnerURI;
		return super.open(referenceOwnerURI, reference, indexInList, select);
	}
}
