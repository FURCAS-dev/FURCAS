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
 * $Id: PostScopeAdapter.java,v 1.2 2010/05/09 10:37:45 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.scope.FilteredAccesses;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PostCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeAdapter;

public class PostScopeAdapter extends EssentialOCLScopeAdapter<PostCS>
{
	public PostScopeAdapter(PostCS csElement) {
		super(csElement);
	}

	@Override
	public void createContents(FilteredAccesses filteredAccesses, EStructuralFeature containmentFeature) {
		if (containmentFeature == CompleteOCLCSTPackage.Literals.CONSTRAINT_CS__EXPRESSION) {
			PostCS csPost = getTarget();
			OperationContextDeclCS csOperation = (OperationContextDeclCS) csPost.eContainer();
			OperationContextScopeAdapter operationScope = (OperationContextScopeAdapter) getScopeAdapter(csOperation);
			VariableCS csResult = null; //csOperation.getResultVariable();
			filteredAccesses.addElement("result", csResult);		
		}
	}
}
