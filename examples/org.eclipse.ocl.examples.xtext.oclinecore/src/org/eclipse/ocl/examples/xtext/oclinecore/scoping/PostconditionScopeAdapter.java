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
 * $Id: PostconditionScopeAdapter.java,v 1.1 2010/05/09 09:50:12 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.scope.FilteredAccesses;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeAdapter;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PostconditionCS;

public class PostconditionScopeAdapter extends EssentialOCLScopeAdapter<PostconditionCS>
{
	public PostconditionScopeAdapter(PostconditionCS csElement) {
		super(csElement);
	}

	@Override
	public void createContents(FilteredAccesses filteredAccesses, EStructuralFeature containmentFeature) {
		if (containmentFeature == OCLinEcoreCSTPackage.Literals.CONSTRAINT_CS__EXPR_VALUE) {
			PostconditionCS csPost = getTarget();
			OperationCS csOperation = (OperationCS) csPost.eContainer();
			VariableCS csResult = null; //csOperation.getResultVariable();
			filteredAccesses.addElement("result", csResult);		
		}
	}
}
