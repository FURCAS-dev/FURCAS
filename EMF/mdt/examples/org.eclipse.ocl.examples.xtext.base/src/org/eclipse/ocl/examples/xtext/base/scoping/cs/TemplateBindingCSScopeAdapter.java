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
 * $Id: TemplateBindingCSScopeAdapter.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.cs;

import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS;

public class TemplateBindingCSScopeAdapter extends ModelElementCSScopeAdapter<TemplateBindingCS, TemplateBinding>
{
	public TemplateBindingCSScopeAdapter(TypeManager typeManager, TemplateBindingCS csElement) {
		super(typeManager, csElement, TemplateBinding.class);
	}

/*	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		TemplateBindingCS templateBinding = getTarget();
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
	} */
}
