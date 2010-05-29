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
 * $Id: OCLstdlibScopeAdapter.java,v 1.8 2010/05/29 15:31:39 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.scoping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTFactory;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.DocumentScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.util.ElementUtil;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibBoundClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS;

public abstract class OCLstdlibScopeAdapter<T extends ElementCS> extends AbstractScopeAdapter<T>
{	
	protected OCLstdlibScopeAdapter(T csElement) {
		super(csElement);
	}

	protected OCLstdlibScopeAdapter(EObject csDocumentElement, T csElement) {
		super(csDocumentElement, csElement);
	}

	protected ClassifierCS commonConformantType(ClassifierCS firstTypeCS, ClassifierCS secondTypeCS) {
		return firstTypeCS;				// FIXME
	}
	
	protected boolean conformsTo(ClassifierCS candidateType, ClassifierCS requiredType, TypeBindingsCS bindings) {
		if (candidateType == requiredType) {
			return true;
		}
		if (candidateType instanceof LibClassCS) {
			for (TypedRefCS superType : ((LibClassCS) candidateType).getConformsTo()) {
				ClassifierCS libType = getLibraryType(superType, bindings);
				if (conformsTo(libType, requiredType, bindings)) {
					return true;
				}
			}
		}
		else if (candidateType instanceof LibBoundClassCS) {
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
		}
		else {
			candidateType = getLibraryClassifierType();
			if (candidateType == requiredType) {
				return true;
			}
		}
		return false;
	}

	public List<ClassifierCS> getConformsTo(ClassCS csClass, TypeBindingsCS bindings) {
		if (csClass instanceof LibClassCS) {
			List<TypedRefCS> conformsTo = ((LibClassCS) csClass).getConformsTo();
			int size = conformsTo.size();
			if (size == 1) {
				ClassifierCS result = getLibraryType(conformsTo.get(0), bindings);
				if (result != null) {
					return Collections.singletonList(result);
				}
			}
			else if (size > 1) {
				List<ClassifierCS> results = new ArrayList<ClassifierCS>(size);
				for (TypedRefCS csTypedRefCS : conformsTo) {
					ClassifierCS result = getLibraryType(csTypedRefCS, bindings);
					if (result != null) {
						results.add(result);
					}
				}
				return results;
			}
		}
		else {
			List<TypedRefCS> superTypes = csClass.getSuperTypes();
			int size = superTypes.size();
			if (size == 0) {
				ClassifierCS libType = getLibraryClassifierType();
				return Collections.singletonList(libType);
			} else if (size == 1) {
				ClassifierCS result = getLibraryType(superTypes.get(0), bindings);
				if (result != null) {
					return Collections.singletonList(result);
				}
			}
			else {
				List<ClassifierCS> results = new ArrayList<ClassifierCS>(size);
				for (TypedRefCS csTypedRefCS : superTypes) {
					ClassifierCS result = getLibraryType(csTypedRefCS, bindings);
					if (result != null) {
						results.add(result);
					}
				}
				return results;
			}
		}
		return Collections.emptyList();
	}

	public ClassifierCS getLibraryBooleanType() {
		return getLibraryType("Boolean");
	}

	public ClassifierCS getLibraryClassifierType() {
		return getLibraryType("Classifier");
	}

	public ClassifierCS getLibraryCollectionType() {
		return getLibraryType("Collection");
	}

	public ClassifierCS getLibraryIntegerType() {
		return getLibraryType("Integer");
	}

	public ClassifierCS getLibraryOclAnyType() {
		return getLibraryType("OclAny");
	}

	public ClassifierCS getLibraryOclInvalidType() {
		return getLibraryType("OclInvalid");
	}

	public ClassifierCS getLibraryOclVoidType() {
		return getLibraryType("OclVoid");
	}

	public ClassifierCS getLibraryRealType() {
		return getLibraryType("Real");
	}

	public ClassifierCS getLibrarySetType(TypeCS type) {
		return getLibraryType("Set");				// FIXME parameters
	}

	public ClassifierCS getLibraryStringType() {
		return getLibraryType("String");
	}

	public ClassifierCS getLibraryTupleType() {
		return getLibraryType("Tuple");
	}

	/**
	 * Get the library adapter
	 * @param name
	 * @return
	 */
	protected StandardDocumentScopeAdapter<?> getLibraryAdapter() {
		DocumentScopeAdapter documentScopeAdapter = getDocumentScopeAdapter();
		if (documentScopeAdapter instanceof StandardDocumentScopeAdapter<?>) {
			return (StandardDocumentScopeAdapter<?>)documentScopeAdapter;
		}
		else {
			return null;
		}
	}

	/**
	 * Get a library type by name
	 * @param name
	 * @return
	 */
	protected ClassifierCS getLibraryType(String name) { // FIXME Change to private
		return getLibraryAdapter().getLibType(name);
	}

	public ClassifierCS getLibraryType(String collectionTypeName, ClassifierCS elementTypeCS) {
		StandardDocumentScopeAdapter<?> libraryAdapter = getLibraryAdapter();
		return libraryAdapter.getLibraryType(collectionTypeName, elementTypeCS);
	}

	public ClassifierCS getLibraryType(ElementCS csElement, TypeBindingsCS bindings) {
		if (csElement == null) {
			return null;
		}
		if (csElement.eIsProxy()) {
			return null;
		}
		if (csElement instanceof ClassCS) {
			return ElementUtil.specializeClass((ClassCS) csElement, bindings);
		}
		else if (csElement instanceof ClassifierCS) {		// DataType
			StandardDocumentScopeAdapter<?> libraryAdapter = getLibraryAdapter();
			EObject eObject = ((ClassifierCS) csElement).getOriginalObject();
			if (eObject == EcorePackage.Literals.EBIG_DECIMAL) {
				return libraryAdapter.getLibType("Real");
			}
			else if (eObject == EcorePackage.Literals.EBIG_INTEGER) {
				return libraryAdapter.getLibType("Integer");
			}
			else if (eObject == EcorePackage.Literals.EBOOLEAN) {
				return libraryAdapter.getLibType("Boolean");
			}
			else if (eObject == EcorePackage.Literals.EBOOLEAN_OBJECT) {
				return libraryAdapter.getLibType("Boolean");
			}
			else if (eObject == EcorePackage.Literals.EDOUBLE) {
				return libraryAdapter.getLibType("Real");
			}
			else if (eObject == EcorePackage.Literals.EDOUBLE_OBJECT) {
				return libraryAdapter.getLibType("Real");
			}
			else if (eObject == EcorePackage.Literals.EINT) {
				return libraryAdapter.getLibType("Integer");
			}
			else if (eObject == EcorePackage.Literals.EINTEGER_OBJECT) {
				return libraryAdapter.getLibType("Integer");
			}
			else if (eObject == EcorePackage.Literals.ESTRING) {
				return libraryAdapter.getLibType("String");
			}
			return (ClassifierCS)csElement;
		}
		else if (csElement instanceof BoundElementCS<?>) {
			BoundElementCS<?> boundElement = (BoundElementCS<?>)csElement;
			TypeBindingsCS nestedBindings = boundElement.getBindings();
			return getLibraryType(boundElement.getBinds(), nestedBindings);
		}
		else if (csElement instanceof TypedElementCS) {
			TypedElementCS typedElement = (TypedElementCS)csElement;
			TypedRefCS type = typedElement.getType();
			String collectionTypeName = ElementUtil.getCollectionTypeName(typedElement);
			ClassifierCS csType = getLibraryType(type, bindings);
			if (collectionTypeName != null) {
				return getLibraryType(collectionTypeName, csType);
			}
			else {
				return csType;
			}
		}
		else if (csElement instanceof PrimitiveTypeRefCS) {
			PrimitiveTypeRefCS primitiveTypeRefCS = (PrimitiveTypeRefCS)csElement;
			String name = primitiveTypeRefCS.getName();
			return getLibraryType(name);
		}
		else if (csElement instanceof QualifiedTypeRefCS) {
			QualifiedTypeRefCS qualifiedTypeRefCS = (QualifiedTypeRefCS)csElement;
			TypedRefCS type = qualifiedTypeRefCS.getElement();
			return getLibraryType(type, bindings);
		}
		else if (csElement instanceof TypedTypeRefCS) {
			TypeBindingsCS nestedBindings = bindings;
			TypedTypeRefCS typedTypeRefCS = (TypedTypeRefCS)csElement;
			TypeCS type = typedTypeRefCS.getType();
			if (type instanceof ClassifierCS) {
				ClassifierCS classifierCS = (ClassifierCS)type;
				List<TypeRefCS> typeArguments = typedTypeRefCS.getTypeArguments();
				List<TypeParameterCS> typeParameters = classifierCS.getTypeParameters();
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
			} 
			return getLibraryType(type, nestedBindings);
		}
		else if (csElement instanceof TypeParameterCS) {
			TypeParameterCS typeParameter = (TypeParameterCS)csElement;
			if (bindings != null) {
				for (TypeBindingCS binding : bindings.getBindings()) {
					if (isSameTypeParameter(typeParameter, binding)) {
						return getLibraryType(binding.getTypeArgument(), bindings);
					}
				}
			}
			throw new UnsupportedOperationException("getLibraryType(TypeParameterCS)");
//			return getLibraryType(typeParameter);
		}
		throw new UnsupportedOperationException("getLibraryType()");
//		return null;
	}

	protected boolean isSameTypeParameter(TypeParameterCS typeParameter, TypeBindingCS binding) {
		TypeParameterCS bindingTypeParameter = binding.getTypeParameter();
		if (bindingTypeParameter == typeParameter) {
			return true;
		}
		return false;
	}

	public ClassifierCS getLibraryUnlimitedNaturalType() {
		return getLibraryType("UnlimitedNatural");
	}
}
