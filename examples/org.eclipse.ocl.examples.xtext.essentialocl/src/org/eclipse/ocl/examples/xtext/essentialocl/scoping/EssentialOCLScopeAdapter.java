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
 * $Id: EssentialOCLScopeAdapter.java,v 1.3 2010/05/09 10:32:43 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameExpCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.scoping.OCLstdlibScopeAdapter;

public abstract class EssentialOCLScopeAdapter<T extends ElementCS> extends OCLstdlibScopeAdapter<T>
{	
	protected EssentialOCLScopeAdapter(T csElement) {
		super(csElement);
	}	

	@Override
	public ClassifierCS getLibType(TypeCS csType) {
		if (csType instanceof PrimitiveTypeCS) {
			return getLibType(((PrimitiveTypeCS)csType).getName());
		}
		else if (csType instanceof SimpleNameExpCS) {
			return getLibType(((SimpleNameExpCS)csType).getElement());
		}
		else {
			return super.getLibType(csType);
		}
	}
}
