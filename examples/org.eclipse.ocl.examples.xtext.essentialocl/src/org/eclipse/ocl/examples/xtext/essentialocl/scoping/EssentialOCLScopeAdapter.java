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
 * $Id: EssentialOCLScopeAdapter.java,v 1.4 2010/05/16 19:19:10 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.scoping.OCLstdlibScopeAdapter;

public abstract class EssentialOCLScopeAdapter<T extends ElementCS> extends OCLstdlibScopeAdapter<T>
{	
	protected EssentialOCLScopeAdapter(T csElement) {
		super(csElement);
	}	

	@Override
	public ClassifierCS getLibraryType(ElementCS csElement, TypeBindingsCS bindings) {
		if (csElement instanceof PrimitiveTypeCS) {
			return getLibraryType(((PrimitiveTypeCS)csElement).getName());
		}
		else if (csElement instanceof CollectionTypeCS) {
			CollectionTypeCS collectionType = (CollectionTypeCS)csElement;
			ClassifierCS elementType = getLibraryType(collectionType.getTypeCS(), bindings);
			return getLibraryType(collectionType.getName(), elementType);
		}
		else if (csElement instanceof SimpleNameExpCS) {
			return getLibraryType(((SimpleNameExpCS)csElement).getElement(), bindings);
		}
		else if (csElement instanceof VariableCS) {
			TypeCS type = ((VariableCS)csElement).getType();
			return getLibraryType(type, bindings);
		}
		else {
			return super.getLibraryType(csElement, bindings);
		}
	}
}
