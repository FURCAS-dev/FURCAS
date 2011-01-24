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
 * $Id: EssentialOCLCSScopeAdapter.java,v 1.2 2011/01/24 21:31:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.BaseCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetVariableCS;

public abstract class EssentialOCLCSScopeAdapter<CS extends MonikeredElementCS, P extends MonikeredElement> extends BaseCSScopeAdapter<CS, P>
{	
	protected EssentialOCLCSScopeAdapter(TypeManager typeManager, CS csElement, Class<P> pivotClass) {
		super(typeManager, csElement, pivotClass);
	}	

	protected EssentialOCLCSScopeAdapter(TypeManager typeManager, EObject eParent, CS csElement, Class<P> pivotClass) {
		super(typeManager, eParent, csElement, pivotClass);
	}	

	@Override
	public Type getLibraryType(ElementCS csElement) {
		if (csElement instanceof PrimitiveTypeRefCS) {
			return typeManager.getCollectionType(((PrimitiveTypeRefCS)csElement).getName(), null);
		}
		else if (csElement instanceof CollectionTypeCS) {
			CollectionTypeCS collectionType = (CollectionTypeCS)csElement;
			Type elementType = getLibraryType(collectionType.getOwnedType());
			return typeManager.getCollectionType(collectionType.getName(), elementType);
		}
		else if (csElement instanceof TupleTypeCS) {			
			TupleTypeCS tupleType = (TupleTypeCS)csElement;
			return (Type) tupleType.getPivot();
		}
//		else if (csElement instanceof NameExpCS) {
//			return getLibraryType(((NameExpCS)csElement).getNamedElement());
//		}
		else if (csElement instanceof LetVariableCS) {
			TypeRefCS type = ((LetVariableCS)csElement).getOwnedType();
			return getLibraryType(type);
		}
/*		else if (csElement instanceof TypeParameterCS) {
//			TypeBindingCS typeBinding = ElementUtil.getTypeBinding((TypeParameterCS)csElement, bindings);
			if (typeBinding == null) {
				List<TypedRefCS> extendedTypes = ((TypeParameterCS)csElement).getExtends();
				if (extendedTypes.isEmpty()) {
					return getLibraryOclAnyType();
				}
				if (extendedTypes.size() == 1) {
					return getLibraryType(extendedTypes.get(0));
				}
				return getLibraryType(extendedTypes.get(0));	// FIXME Multi-extension
			}
			ClassifierCS typeArgument = typeBinding.getTypeArgument();
			if (typeArgument == null) {
				return null;
			}
			return getLibraryType(typeArgument);
		} */
		else {
			return super.getLibraryType(csElement);
		}
	}
}
