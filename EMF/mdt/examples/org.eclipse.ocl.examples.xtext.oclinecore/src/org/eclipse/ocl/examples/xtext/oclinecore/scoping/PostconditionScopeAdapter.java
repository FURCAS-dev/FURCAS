/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: PostconditionScopeAdapter.java,v 1.5 2011/01/24 22:28:40 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.scoping;

import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreConstraintCS;

public class PostconditionScopeAdapter extends EssentialOCLCSScopeAdapter<OCLinEcoreConstraintCS, Constraint>
{
	public PostconditionScopeAdapter(TypeManager typeManager, OCLinEcoreConstraintCS csElement) {
		super(typeManager, csElement, Constraint.class);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
/*		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == OCLinEcoreCSTPackage.Literals.OC_LIN_ECORE_CONSTRAINT_CS__EXPR_VALUE) {
			PostconditionCS csPost = getTarget();
			OperationCS csOperation = (OperationCS) csPost.eContainer();
			VariableCS csResult = null; //csOperation.getResultVariable();
			environmentView.addElement("result", csResult);		
		} */
		return scopeView.getOuterScope();
	}
}
