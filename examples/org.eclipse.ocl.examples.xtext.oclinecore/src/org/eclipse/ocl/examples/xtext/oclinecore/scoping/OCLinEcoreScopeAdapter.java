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
 * $Id: OCLinEcoreScopeAdapter.java,v 1.1 2010/08/17 06:51:08 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.scoping;

import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeAdapter;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS;

public class OCLinEcoreScopeAdapter<T extends ElementCS> extends EssentialOCLScopeAdapter<T>
{
	public OCLinEcoreScopeAdapter(T csElement) {
		super(csElement);
	}

	public void addLibContents(EnvironmentView environmentView, ModelElementCS libType, ScopeView scopeView) {
		if (libType == null) {
			return;
		}
		environmentView.addElementsOfScope(libType, scopeView);
		if (libType instanceof LibClassCS) {
			for (TypedRefCS csSuperType : ((LibClassCS) libType).getConformsTo()) {
				addLibContents(environmentView, csSuperType, scopeView);
			}
		}
	}
}
