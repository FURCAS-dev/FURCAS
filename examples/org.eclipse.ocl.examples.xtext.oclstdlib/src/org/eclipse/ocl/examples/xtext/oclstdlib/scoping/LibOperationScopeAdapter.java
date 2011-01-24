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
 * $Id: LibOperationScopeAdapter.java,v 1.6 2011/01/24 22:28:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.util.Nameable;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.BaseCSScopeAdapter;

public class LibOperationScopeAdapter extends BaseCSScopeAdapter<OperationCS, Operation>
{
	public LibOperationScopeAdapter(TypeManager typeManager, OperationCS csElement) {
		super(typeManager, csElement, Operation.class);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
//		TypeBindingsCS bindings = scopeView.getBindings();
		Operation pivot = getPivot();
		if (pivot != null) {
			if (containmentFeature == BaseCSTPackage.Literals.OPERATION_CS__OWNED_PARAMETER) {
			}
			else {
				environmentView.addNamedElements(pivot.getOwnedParameters());
			}
			environmentView.addElements(PivotUtil.getTypeTemplateParameterables(pivot));
		}
		else {
			TemplateSignatureCS csTemplateSignature = target.getOwnedTemplateSignature();
			if (csTemplateSignature != null) {
				for (TemplateParameterCS csTemplateParameter : csTemplateSignature.getOwnedTemplateParameter()) {
					TemplateParameter templateParameter = (TemplateParameter) csTemplateParameter.getPivot();
					if (templateParameter != null) {
						environmentView.addNamedElement((Nameable) templateParameter.getParameteredElement());
					}
					else {
//						environmentView.addNamedElement((INamedElement) csTemplateParameter.getParameteredElement());
					}
				}
			}
		}
		return scopeView.getOuterScope();
	}
}
