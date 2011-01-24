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
 * $Id: ExpressionInOclScopeAdapter.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.pivot;

import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;

public class ExpressionInOclScopeAdapter extends AbstractPivotScopeAdapter<ExpressionInOcl>
{
	public ExpressionInOclScopeAdapter(TypeManager typeManager, ExpressionInOcl pivotElement) {
		super(typeManager, pivotElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		Variable contextVariable = target.getContextVariable();
		if (contextVariable != null) {
			environmentView.addNamedElement(contextVariable);
			Type type = contextVariable.getType();
			environmentView.addElementsOfScope(typeManager, type, scopeView);
		}
		Variable resultVariable = target.getResultVariable();
		if (resultVariable != null) {
			environmentView.addNamedElement(resultVariable);
		}
		return scopeView.getOuterScope();
	}
}
