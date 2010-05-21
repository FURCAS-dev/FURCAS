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
 * $Id: NumberLiteralExpScopeAdapter.java,v 1.4 2010/05/21 20:12:10 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS;

public class NumberLiteralExpScopeAdapter extends ExpScopeAdapter<NumberLiteralExpCS>
{
	private ClassifierCS type = null;
	
	public NumberLiteralExpScopeAdapter(NumberLiteralExpCS csElement) {
		super(csElement);
	}
	
	@Override
	public ClassifierCS getSynthesizedType(TypeBindingsCS bindings) {
		if (type == null) {
			String text = getText();
			if (text.contains(".") || text.contains("E") || text.contains("e")) {
				type = getLibraryRealType();
			}
			else if (text.contains("-")) {
				type = getLibraryIntegerType();
			}
			else {
				type = getLibraryUnlimitedNaturalType();
			}
		}
		return type;
	}
}
