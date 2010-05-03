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
 * $Id: OCLstdlibScopeAdapter.java,v 1.1 2010/05/03 05:29:42 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.scoping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractDocumentScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS;

public abstract class OCLstdlibScopeAdapter<T extends ElementCS> extends AbstractScopeAdapter<T>
{	
	protected OCLstdlibScopeAdapter(T csElement) {
		super(csElement);
	}
	
	protected boolean conformsTo(ClassifierCS candidateType, LibClassCS requiredType) {
		if (candidateType == requiredType) {
			return true;
		}
		if (!(candidateType instanceof LibClassCS)) {
			candidateType = getLibType("Classifier");
			if (candidateType == requiredType) {
				return true;
			}
		}
		for (TypedRefCS superType : ((LibClassCS) candidateType).getConformsTo()) {
			ClassifierCS libType = getLibType(superType);
			if (conformsTo(libType, requiredType)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Get a library type by name
	 * @param string
	 * @return
	 */
	public LibClassCS getLibType(String name) {
		AbstractDocumentScopeAdapter<?> documentScopeAdapter = getDocumentScopeAdapter();
		if (documentScopeAdapter instanceof StandardDocumentScopeAdapter<?>) {
			return ((StandardDocumentScopeAdapter<?>)documentScopeAdapter).getLibType(name);
		}
		else {
			return null;
		}
	}

	public List<ClassifierCS> getConformsTo(ClassCS csClass) {
		if (csClass instanceof LibClassCS) {
			List<TypedRefCS> conformsTo = ((LibClassCS) csClass).getConformsTo();
			int size = conformsTo.size();
			if (size == 1) {
				ClassifierCS result = getLibType(conformsTo.get(0));
				if (result != null) {
					return Collections.singletonList(result);
				}
			}
			else if (size > 1) {
				List<ClassifierCS> results = new ArrayList<ClassifierCS>(size);
				for (TypedRefCS csTypedRefCS : conformsTo) {
					ClassifierCS result = getLibType(conformsTo.get(0));
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
				ClassifierCS libType = getLibType("Classifier");
				return Collections.singletonList(libType);
			} else if (size == 1) {
				ClassifierCS result = getLibType(superTypes.get(0));
				if (result != null) {
					return Collections.singletonList(result);
				}
			}
			else {
				List<ClassifierCS> results = new ArrayList<ClassifierCS>(size);
				for (TypedRefCS csTypedRefCS : superTypes) {
					ClassifierCS result = getLibType(superTypes.get(0));
					if (result != null) {
						results.add(result);
					}
				}
				return results;
			}
		}
		return Collections.emptyList();
	}

	public ClassifierCS getLibType(NamedElementCS element) {
		if (element.eIsProxy()) {
			return null;
		}
		if (element instanceof TypedElementCS) {
			TypedRefCS type = ((TypedElementCS)element).getType();
			if (type instanceof TypedTypeRefCS) {
				TypeCS csType = ((TypedTypeRefCS)type).getType();
				return getLibType(csType);
			}
		}
		return null;
	}

	public ClassifierCS getLibType(TypeCS csType) {
		if (csType instanceof ClassCS) {
			return (ClassCS)csType;
		}
		else if (csType instanceof ClassifierCS) {		// DataType
			EObject eObject = ((ClassifierCS) csType).getOriginalObject();
			if (eObject == EcorePackage.Literals.EBIG_DECIMAL) {
				return getLibType("Real");
			}
			else if (eObject == EcorePackage.Literals.EBIG_INTEGER) {
				return getLibType("Integer");
			}
			else if (eObject == EcorePackage.Literals.EBOOLEAN) {
				return getLibType("Boolean");
			}
			else if (eObject == EcorePackage.Literals.EBOOLEAN_OBJECT) {
				return getLibType("Boolean");
			}
			else if (eObject == EcorePackage.Literals.EDOUBLE) {
				return getLibType("Real");
			}
			else if (eObject == EcorePackage.Literals.EDOUBLE_OBJECT) {
				return getLibType("Real");
			}
			else if (eObject == EcorePackage.Literals.EINT) {
				return getLibType("Integer");
			}
			else if (eObject == EcorePackage.Literals.EINTEGER_OBJECT) {
				return getLibType("Integer");
			}
			else if (eObject == EcorePackage.Literals.ESTRING) {
				return getLibType("String");
			}
			return (ClassifierCS)csType;
		}
		else {
			return null;
		}
	}

	public ClassifierCS getLibType(TypeRefCS csTypeRef) {
		if (csTypeRef instanceof TypedTypeRefCS) {
			return getLibType(((TypedTypeRefCS)csTypeRef).getType());
		}
		else {
			return null;
		}
	}
}
