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
 * $Id: SimpleNameExpScopeAdapter.java,v 1.3 2010/05/09 10:32:43 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;

public class SimpleNameExpScopeAdapter extends EssentialOCLScopeAdapter<SimpleNameExpCS>
{
	public SimpleNameExpScopeAdapter(SimpleNameExpCS csElement) {
		super(csElement);
	}

	@Override
	public TypeCS getType() {
		SimpleNameExpCS target = getTarget();
		NamedElementCS element = target.getElement();
		if (element instanceof TypedElementCS) {
			TypedRefCS type = ((TypedElementCS)element).getType();
			return getLibType(type);
		}
		else if (element instanceof VariableCS) {
			TypeCS type = ((VariableCS)element).getType();
			return getLibType(type);
		}
		return getLibType(element);
	}
}
