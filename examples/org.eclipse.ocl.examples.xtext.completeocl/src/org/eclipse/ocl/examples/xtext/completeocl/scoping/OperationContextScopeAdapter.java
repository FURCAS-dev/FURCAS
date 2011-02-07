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
 * $Id: OperationContextScopeAdapter.java,v 1.8 2011/01/30 11:12:08 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedOperationRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimpleOperationRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.ModelElementCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;

public class OperationContextScopeAdapter extends ModelElementCSScopeAdapter<OperationContextDeclCS, Operation>
{
	public OperationContextScopeAdapter(TypeManager typeManager, OperationContextDeclCS csElement) {
		super(typeManager, csElement, Operation.class);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if ((containmentFeature == CompleteOCLCSTPackage.Literals.OPERATION_CONTEXT_DECL_CS__PRES) 
		 || (containmentFeature == CompleteOCLCSTPackage.Literals.OPERATION_CONTEXT_DECL_CS__BODIES) 
		 || (containmentFeature == CompleteOCLCSTPackage.Literals.OPERATION_CONTEXT_DECL_CS__POSTS)) {
			OperationRefCS csOperationRef = target.getOperation();
			while (csOperationRef instanceof QualifiedOperationRefCS) {
				csOperationRef = ((QualifiedOperationRefCS)csOperationRef).getElement();
			}
			if (csOperationRef instanceof SimpleOperationRefCS) {
				SimpleOperationRefCS csSimpleOperationRef = (SimpleOperationRefCS)csOperationRef;
				OperationCS operationContext = csSimpleOperationRef.getOperation();
				ModelElementCS classifierContext = (ModelElementCS) operationContext.eContainer();
				environmentView.addNamedElements(operationContext.getOwnedParameter());
				environmentView.addElementsOfScope(classifierContext, scopeView);
				environmentView.addElement(Environment.SELF_VARIABLE_NAME, classifierContext);
			}
		}
		return scopeView.getOuterScope();
	}
}
