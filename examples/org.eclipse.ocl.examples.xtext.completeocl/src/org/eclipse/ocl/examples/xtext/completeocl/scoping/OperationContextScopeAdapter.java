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
 * $Id: OperationContextScopeAdapter.java,v 1.6 2010/05/16 19:26:02 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedOperationRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimpleOperationRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeAdapter;

public class OperationContextScopeAdapter extends EssentialOCLScopeAdapter<OperationContextDeclCS>
{
	public OperationContextScopeAdapter(OperationContextDeclCS csElement) {
		super(csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if ((containmentFeature == CompleteOCLCSTPackage.Literals.OPERATION_CONTEXT_DECL_CS__PRES) 
		 || (containmentFeature == CompleteOCLCSTPackage.Literals.OPERATION_CONTEXT_DECL_CS__BODIES) 
		 || (containmentFeature == CompleteOCLCSTPackage.Literals.OPERATION_CONTEXT_DECL_CS__POSTS)) {
			OperationRefCS csOperationRef = getTarget().getOperation();
			while (csOperationRef instanceof QualifiedOperationRefCS) {
				csOperationRef = ((QualifiedOperationRefCS)csOperationRef).getElement();
			}
			if (csOperationRef instanceof SimpleOperationRefCS) {
				SimpleOperationRefCS csSimpleOperationRef = (SimpleOperationRefCS)csOperationRef;
				OperationCS operationContext = csSimpleOperationRef.getOperation();
				EObject classifierContext = operationContext.eContainer();
				environmentView.addNamedElements(operationContext.getParameters(), scopeView.getBindings());
				environmentView.addElementsOfScope(classifierContext, scopeView);
				environmentView.addElement("self", classifierContext, scopeView.getBindings());
			}
		}
		return scopeView.getOuterScope();
	}
}
