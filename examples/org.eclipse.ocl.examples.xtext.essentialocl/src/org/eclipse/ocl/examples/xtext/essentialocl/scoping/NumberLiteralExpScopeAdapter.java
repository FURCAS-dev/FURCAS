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
 * $Id: NumberLiteralExpScopeAdapter.java,v 1.1 2010/05/03 05:38:06 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.scope.FilteredAccesses;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS;
import org.eclipse.xtext.resource.IEObjectDescription;

public class NumberLiteralExpScopeAdapter extends EssentialOCLScopeAdapter<NumberLiteralExpCS>
{
	private TypeCS type = null;
	
	public NumberLiteralExpScopeAdapter(NumberLiteralExpCS csElement) {
		super(csElement);
	}
	
	@Override
	public TypeCS getType() {
		if (type == null) {
			String text = getText();
			if (text.contains(".") || text.contains("E") || text.contains("e")) {
				type = getLibType("Real");
			}
			else if (text.contains("-")) {
				type = getLibType("Integer");
			}
			else {
				type = getLibType("UnlimitedNatural");
			}
		}
		return type;
	}
}
