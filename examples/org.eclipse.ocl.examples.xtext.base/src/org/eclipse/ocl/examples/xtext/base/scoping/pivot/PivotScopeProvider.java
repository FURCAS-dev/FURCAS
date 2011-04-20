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
 * $Id: PivotScopeProvider.java,v 1.3 2011/04/20 19:02:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.pivot;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.scope.BaseScopeView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class PivotScopeProvider extends AbstractDeclarativeScopeProvider
{
	public static final TracingOption LOOKUP = new TracingOption("org.eclipse.ocl.examples.xtext.base", "lookup");  //$NON-NLS-1$//$NON-NLS-2$

	@Override
	public ScopeView getScope(EObject context, EReference reference) {
		ModelElementCS csContext = (ModelElementCS)context;
		ScopeAdapter scopeAdapter = ElementUtil.getScopeCSAdapter(csContext);
		if (scopeAdapter == null) {
			return null;
		}
		CS2PivotResourceAdapter csAdapter = (CS2PivotResourceAdapter) CS2PivotResourceAdapter.findAdapter(csContext.eResource());
		return new BaseScopeView(csAdapter.getTypeManager(), scopeAdapter, null, reference, reference);
	}
}
