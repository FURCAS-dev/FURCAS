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
 * $Id: OperationContextScopeAdapter.java,v 1.5 2010/05/09 17:08:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedOperationRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimpleOperationRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeAdapter;

public class OperationContextScopeAdapter extends EssentialOCLScopeAdapter<OperationContextDeclCS>
{
	public OperationContextScopeAdapter(OperationContextDeclCS csElement) {
		super(csElement);
	}

	@Override
	public boolean computeInheritedEnvironmentView(EnvironmentView environmentView, EStructuralFeature containmentFeature) {
		if ((containmentFeature == CompleteOCLCSTPackage.Literals.OPERATION_CONTEXT_DECL_CS__PRES) 
		 || (containmentFeature == CompleteOCLCSTPackage.Literals.OPERATION_CONTEXT_DECL_CS__BODIES) 
		 || (containmentFeature == CompleteOCLCSTPackage.Literals.OPERATION_CONTEXT_DECL_CS__POSTS)) {
			OperationRefCS csOperationRef = getTarget().getOperation();
			while (csOperationRef instanceof QualifiedOperationRefCS) {
				csOperationRef = ((QualifiedOperationRefCS)csOperationRef).getOperation();
			}
			if (csOperationRef instanceof SimpleOperationRefCS) {
				SimpleOperationRefCS csSimpleOperationRef = (SimpleOperationRefCS)csOperationRef;
				OperationCS operationContext = csSimpleOperationRef.getOperation();
				ElementCS classifierContext = (ElementCS) operationContext.eContainer();
				environmentView.addNamedElements(operationContext.getParameters());
				environmentView.addElementsOfScope(classifierContext);
				environmentView.addElement("self", classifierContext);
			}
		}
		return true;
	}
}
