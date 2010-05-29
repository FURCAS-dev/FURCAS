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
 * $Id: EssentialOCLScopeAdapter.java,v 1.6 2010/05/29 15:31:44 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import java.util.List;

import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.util.ElementUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleTypeCS;
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
		else if (csElement instanceof TupleTypeCS) {			
			TupleTypeCS tupleType = (TupleTypeCS)csElement;
			return tupleType;
		}
		else if (csElement instanceof NameExpCS) {
			return getLibraryType(((NameExpCS)csElement).getNamedElement(), bindings);
		}
		else if (csElement instanceof VariableCS) {
			TypeCS type = ((VariableCS)csElement).getType();
			return getLibraryType(type, bindings);
		}
		else if (csElement instanceof TypeParameterCS) {
			TypeBindingCS typeBinding = ElementUtil.getTypeBinding((TypeParameterCS)csElement, bindings);
			if (typeBinding == null) {
				List<TypedRefCS> extendedTypes = ((TypeParameterCS)csElement).getExtends();
				if (extendedTypes.isEmpty()) {
					return getLibraryOclAnyType();
				}
				if (extendedTypes.size() == 1) {
					return getLibraryType(extendedTypes.get(0), bindings);
				}
				return getLibraryType(extendedTypes.get(0), bindings);	// FIXME Multi-extension
			}
			ClassifierCS typeArgument = typeBinding.getTypeArgument();
			if (typeArgument == null) {
				return null;
			}
			return getLibraryType(typeArgument, bindings);
		}
		else {
			return super.getLibraryType(csElement, bindings);
		}
	}
}
