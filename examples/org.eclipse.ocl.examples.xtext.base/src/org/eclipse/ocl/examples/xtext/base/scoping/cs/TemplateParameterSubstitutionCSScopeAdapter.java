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
 * $Id: TemplateParameterSubstitutionCSScopeAdapter.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.cs;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;

public class TemplateParameterSubstitutionCSScopeAdapter extends ModelElementCSScopeAdapter<TemplateParameterSubstitutionCS, TemplateParameterSubstitution>
{
	public TemplateParameterSubstitutionCSScopeAdapter(TypeManager typeManager, TemplateParameterSubstitutionCS csElement) {
		super(typeManager, csElement, TemplateParameterSubstitution.class);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		/*if (containmentFeature == BaseCSTPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__FORMAL_TEMPLATE_PARAMETER) {
			TemplateBindingCS templateBinding = getTarget().getOwningTemplateBinding();
			TemplateBindableElementCS templateBindableElement = templateBinding.getOwningTemplateBindableElement();
			if (!(templateBindableElement instanceof TypedTypeRefCS)) {
				return null;
			}
			TypeCS type = ((TypedTypeRefCS)templateBindableElement).getType();
			if (!(type instanceof ClassifierCS)) {
				return null;
			}
			TemplateSignatureCS templateSignature = ((ClassifierCS)type).getOwnedTemplateSignature();
			if (templateSignature == null) {
				return null;
			}
			environmentView.addNamedElements(BaseCSTPackage.Literals.TEMPLATE_PARAMETER_CS, templateSignature.getOwnedTemplateParameter());
			return null;
		}
		else*/ if (containmentFeature == BaseCSTPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER) {
			return scopeView.getOuterScope().getOuterScope();
		}
		else {
//			TypeCS type = getTarget().getType();
//			environmentView.addElementsOfScope(type, scopeView);
			return scopeView.getOuterScope();
		}
	}
}
