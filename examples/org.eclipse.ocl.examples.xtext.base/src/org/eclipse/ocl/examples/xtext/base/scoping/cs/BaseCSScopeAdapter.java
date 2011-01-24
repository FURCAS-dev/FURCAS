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
 * $Id: BaseCSScopeAdapter.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.cs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;

public abstract class BaseCSScopeAdapter<CS extends MonikeredElementCS, P extends MonikeredElement> extends MonikeredElementCSScopeAdapter<CS, P>
{	
	protected BaseCSScopeAdapter(TypeManager typeManager, CS csElement, Class<P> pivotClass) {
		super(typeManager, csElement, pivotClass);
	}

	protected BaseCSScopeAdapter(TypeManager typeManager, EObject csDocumentElement, CS csElement, Class<P> pivotClass) {
		super(typeManager, csDocumentElement, csElement, pivotClass);
	}

	protected Type commonConformantType(Type firstTypeCS, Type secondTypeCS) {
		return firstTypeCS;				// FIXME
	}
	
	protected boolean conformsTo(Type candidateType, Type requiredType) {
		if (candidateType == requiredType) {
			return true;
		}
		if (candidateType instanceof org.eclipse.ocl.examples.pivot.Class) {
			for (org.eclipse.ocl.examples.pivot.Class superType : ((org.eclipse.ocl.examples.pivot.Class) candidateType).getSuperClasses()) {
				if (conformsTo(superType, requiredType)) {
					return true;
				}
			}
		}
	/*	else if (candidateType instanceof LibBoundClassCS) {
			LibBoundClassCS boundCandidateType = (LibBoundClassCS) candidateType;
			LibClassCS superType = boundCandidateType.getBinds();
			if (conformsTo(superType, requiredType, boundCandidateType.getBindings())) {
				return true;
			}
		}
		else if (candidateType instanceof BoundClassifierCS) {
			BoundClassifierCS boundCandidateType = (BoundClassifierCS) candidateType;
			ClassifierCS superType = boundCandidateType.getBinds();
			if (conformsTo(superType, requiredType, boundCandidateType.getBindings())) {
				return true;
			}
		} */
		else {
			candidateType = typeManager.getClassifierType();
			if (candidateType == requiredType) {
				return true;
			}
		}
		return false;
	}

	public List<Type> getConformsTo(ClassCS csClass) {
		List<TypedRefCS> superTypes = csClass.getOwnedSuperType();
		int size = superTypes.size();
		if (size == 0) {
			Type libType = typeManager.getClassifierType();
			return Collections.singletonList(libType);
		} else if (size == 1) {
			Type result = getLibraryType(superTypes.get(0));
			if (result != null) {
				return Collections.singletonList(result);
			}
		}
		else {
			List<Type> results = new ArrayList<Type>(size);
			for (TypedRefCS csTypedRefCS : superTypes) {
				Type result = getLibraryType(csTypedRefCS);
				if (result != null) {
					results.add(result);
				}
			}
			return results;
		}
		return Collections.emptyList();
	}

	/**
	 * Get the library adapter
	 * @param name
	 * @return
	 *
	protected AbstractDocumentScopeAdapter<?,?> getLibraryAdapter() {
		DocumentScopeAdapter documentScopeAdapter = getDocumentScopeAdapter();
		if (documentScopeAdapter instanceof AbstractDocumentScopeAdapter<?,?>) {
			return (AbstractDocumentScopeAdapter<?,?>)documentScopeAdapter;
		}
		else {
			return null;
		}
	} */

	/**
	 * Get a library type by name
	 * @param name
	 * @return
	 *
	protected Type getLibraryType(String name) { // FIXME Change to private
		return getTypeManager().getLibraryType(name, null);
	} */

	public Type getLibraryType(ElementCS csElement) {
		if (csElement == null) {
			return null;
		}
		if (csElement.eIsProxy()) {
			return null;
		}
		if (csElement instanceof ClassCS) {
//			return ElementUtil.specializeClass((ClassCS) csElement);
			return (Type) csElement;				
		}
		else if (csElement instanceof ClassifierCS) {		// DataType
			EObject eObject = ((ClassifierCS) csElement).getPivot();
			if (eObject == EcorePackage.Literals.EBIG_DECIMAL) {
				return typeManager.getRealType();
			}
			else if (eObject == EcorePackage.Literals.EBIG_INTEGER) {
				return typeManager.getIntegerType();
			}
			else if (eObject == EcorePackage.Literals.EBOOLEAN) {
				return typeManager.getBooleanType();
			}
			else if (eObject == EcorePackage.Literals.EBOOLEAN_OBJECT) {
				return typeManager.getBooleanType();
			}
			else if (eObject == EcorePackage.Literals.EDOUBLE) {
				return typeManager.getRealType();
			}
			else if (eObject == EcorePackage.Literals.EDOUBLE_OBJECT) {
				return typeManager.getRealType();
			}
			else if (eObject == EcorePackage.Literals.EINT) {
				return typeManager.getIntegerType();
			}
			else if (eObject == EcorePackage.Literals.EINTEGER_OBJECT) {
				return typeManager.getIntegerType();
			}
			else if (eObject == EcorePackage.Literals.ESTRING) {
				return typeManager.getStringType();
			}
			return (Type) ((ClassifierCS) csElement).getPivot();
		}
	/*	else if (csElement instanceof BoundElementCS<?>) {
			BoundElementCS<?> boundElement = (BoundElementCS<?>)csElement;
			TypeBindingsCS nestedBindings = boundElement.getBindings();
			return getLibraryType(boundElement.getBinds(), nestedBindings);
		} */
		else if (csElement instanceof TypedElementCS) {
			TypedElementCS typedElement = (TypedElementCS)csElement;
			TypedRefCS type = typedElement.getOwnedType();
			String collectionTypeName = ElementUtil.getCollectionTypeName(typedElement);
			Type csType = getLibraryType(type);
			if (collectionTypeName != null) {
				return typeManager.getCollectionType(collectionTypeName, csType);
			}
			else {
				return csType;
			}
		}
		else if (csElement instanceof PrimitiveTypeRefCS) {
			PrimitiveTypeRefCS primitiveTypeRefCS = (PrimitiveTypeRefCS)csElement;
			String name = primitiveTypeRefCS.getName();
			return typeManager.getLibraryType(name);
		}
		else if (csElement instanceof QualifiedTypeRefCS) {
			QualifiedTypeRefCS qualifiedTypeRefCS = (QualifiedTypeRefCS)csElement;
			TypedRefCS type = qualifiedTypeRefCS.getElement();
			return getLibraryType(type);
		}
		else if (csElement instanceof TypedTypeRefCS) {
	//		TypeBindingsCS nestedBindings = bindings;
			TypedTypeRefCS typedTypeRefCS = (TypedTypeRefCS)csElement;
			Type type = typedTypeRefCS.getType();
	/*		if (type instanceof ClassifierCS) {
				ClassifierCS classifierCS = (ClassifierCS)type;
				List<TypeRefCS> typeArguments = typedTypeRefCS.getTypeArguments();
				Collection<TemplateParameterCS> typeParameters = ElementUtil.getTemplateParameters(classifierCS);
				nestedBindings = BaseCSTFactory.eINSTANCE.createTypeBindingsCS();
				nestedBindings.setBoundDocument(bindings.getBoundDocument());
				int iMax = Math.min(typeArguments.size(), typeParameters.size());
				for (int i = 0; i < iMax; i++) {
					TypeBindingCS csTypeBinding = BaseCSTFactory.eINSTANCE.createTypeBindingCS();
					TypeRefCS typeArgument = typeArguments.get(i);
					ClassifierCS typeArgCS = getLibraryType(typeArgument, bindings);
					csTypeBinding.setTypeArgument(typeArgCS);
					csTypeBinding.setTypeParameter(typeParameters.get(i));
					nestedBindings.getBindings().add(csTypeBinding);
				}
				bindings.getNested().add(nestedBindings);
			} */
			return type; //getLibraryType(type);
		}
		else if (csElement instanceof TypeParameterCS) {
			@SuppressWarnings("unused")
			TypeParameterCS typeParameter = (TypeParameterCS)csElement;
	/*		if (bindings != null) {
				for (TypeBindingCS binding : bindings.getBindings()) {
					if (isSameTypeParameter(typeParameter, binding)) {
						return getLibraryType(binding.getTypeArgument(), bindings);
					}
				}
			} */
			throw new UnsupportedOperationException("getLibraryType(TypeParameterCS)"); //$NON-NLS-1$
//			return getLibraryType(typeParameter);
		}
		throw new UnsupportedOperationException("getLibraryType()"); //$NON-NLS-1$
//		return null;
	}

	/*	protected boolean isSameTypeParameter(TypeParameterCS typeParameter, TypeBindingCS binding) {
			TypeParameterCS bindingTypeParameter = binding.getTypeParameter();
			if (bindingTypeParameter == typeParameter) {
				return true;
			}
			return false;
		} */
}
