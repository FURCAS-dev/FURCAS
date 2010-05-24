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
 * $Id: ElementUtil.java,v 1.4 2010/05/24 08:59:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.cst.PrimitiveTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTFactory;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundDocumentCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundOperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;

public class ElementUtil
{
	public static boolean conformsTo(EStructuralFeature eStructuralFeature, EClassifier contentType) {
		if (eStructuralFeature == null) {			// Wildcard match all
			return true;
		}
		EClassifier targetType = eStructuralFeature.getEType();
		if (targetType == contentType) {
			return true;
		}
		if (!(targetType instanceof EClass)) {
			return false;
		}
		if (!(contentType instanceof EClass)) {
			return false;
		}
		return ((EClass) targetType).isSuperTypeOf((EClass) contentType);
	}

	public static String getCollectionTypeName(TypedElementCS csTypedElement) {
		String multiplicity = csTypedElement.getMultiplicity();
		if (multiplicity != null) {
			if ("?".equals(multiplicity)) { //$NON-NLS-1$
				return null;
			}
		}
		else {
			int upper = csTypedElement.getUpper();
			if (upper == 1) {
				return null;
			}
		}
		EList<String> qualifiers = csTypedElement.getQualifiers();
		boolean isOrdered = true;
		boolean isUnique = true;
		if (qualifiers.contains("!ordered")) { //$NON-NLS-1$
			isOrdered = false;
		}
		else if (qualifiers.contains("ordered")) { //$NON-NLS-1$
			isOrdered = true;
		}
		if (qualifiers.contains("!unique")) { //$NON-NLS-1$
			isUnique = false;
		}
		else if (qualifiers.contains("unique")) { //$NON-NLS-1$
			isUnique = true;
		}
		if (isOrdered) {
			return isUnique ? "OrderedSet" : "Sequence"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		else {
			return isUnique ? "Set" : "Bag"; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	public static <T extends NamedElementCS> T getNamedElementCS(Collection<T> namedElements, String name) {
		for (T namedElement : namedElements) {
			if (name.equals(namedElement.getName())) {
				return namedElement;
			}
		}
		return null;
	}

	public static CompositeNode getParserNode(EObject eObject) {
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(eObject);
		return nodeAdapter != null ? nodeAdapter.getParserNode() : null;
	}

	public static ScopeAdapter getScopeAdapter(EObject element) {
		return AbstractScopeAdapter.getScopeAdapter(element);
	}

	public static TypeBindingCS getTypeBinding(TypeParameterCS typeParameter, TypeBindingsCS bindings) {
		if (bindings != null) {
			for (TypeBindingCS binding : bindings.getBindings()) {
				if (binding.getTypeParameter() == typeParameter) {
					return binding;
				}
			}
		}
		return null;
	}
	
	public static boolean isValidIdentifier(String value) {
		int iMax = value.length();
		for (int i = 0; i < iMax; i++) {
			char c = value.charAt(i);
			if (('A' <= c) && (c <= 'Z')) {					
			}
			else if (('a' <= c) && (c <= 'z')) {					
			}
			else if (c == '_') {					
			}
			else if (('0' <= c) && (c <= '9') && (i > 0)) {					
			}
			else {
				return false;
			}
		}
		return true;
	}

	public static ClassifierCS specializeClass(ClassCS csClass, TypeBindingsCS bindings) {
		if (csClass.getTypeParameters().isEmpty()) {
			return csClass;				
		}
		Signature s = new Signature();
		csClass.getSignature(s, bindings);
		String name = s.toString();
		BoundDocumentCS boundDocument = bindings.getBoundDocument();
		ClassifierCS boundClassifier = boundDocument.getClassifier(name);
		if (boundClassifier != null) {
			return boundClassifier;
		}
		BoundClassifierCS boundElement = BaseCSTFactory.eINSTANCE.createBoundClassCS();
		boundElement.setName(name);
		boundElement.setBinds(csClass);
		boundElement.setBindings(bindings);
		boundDocument.getClassifiers().add(boundElement);
		return boundElement;
	}

	public static OperationCS specializeOperation(OperationCS csOperation, TypeBindingsCS bindings) {
		ClassCS owner = csOperation.getOwner();
		List<OperationCS> boundOperations = null;
		if (owner.getTypeParameters().isEmpty()) {
			if (csOperation.getTypeParameters().isEmpty()) {
				return csOperation;
			}
			BoundDocumentCS boundDocument = bindings.getBoundDocument();
			String ownerName = owner.getSignature();
			ClassCS boundClass = (ClassCS) boundDocument.getClassifier(ownerName);
			if (boundClass == null) {
				BoundClassCS boundElement = BaseCSTFactory.eINSTANCE.createBoundClassCS();
				boundElement.setName(ownerName);
				boundElement.setBinds(owner);
				boundElement.setBindings(bindings);
				boundDocument.getClassifiers().add(boundElement);
				boundClass = boundElement;
			}
			boundOperations = boundClass.getOperations();
		}
		else {
			ScopeAdapter scopeAdapter = AbstractScopeAdapter.getScopeAdapter(owner);
			ClassifierCS boundClass = scopeAdapter.getSynthesizedType(bindings);
			boundOperations = ((ClassCS) boundClass).getOperations();
		}
		Signature s = new Signature();
		csOperation.getSignature(s, bindings);
		String name = s.toString();
		for (OperationCS boundOperation : boundOperations) {
			if (boundOperation.getName().equals(name)) {
				return boundOperation;
			}
		}
		BoundOperationCS boundElement = BaseCSTFactory.eINSTANCE.createBoundOperationCS();
		boundElement.setName(name);
		boundElement.setBinds(csOperation);
		boundElement.setBindings(bindings);
		boundElement.setType(specializeType(csOperation.getType(), bindings));
		boundElement.getQualifiers().addAll(csOperation.getQualifiers());
		if (csOperation.eIsSet(BaseCSTPackage.Literals.TYPED_ELEMENT_CS__LOWER)) {
			boundElement.setLower(csOperation.getLower());
		}
		if (csOperation.eIsSet(BaseCSTPackage.Literals.TYPED_ELEMENT_CS__UPPER)) {
			boundElement.setUpper(csOperation.getUpper());
		}
		if (csOperation.eIsSet(BaseCSTPackage.Literals.TYPED_ELEMENT_CS__MULTIPLICITY)) {
			boundElement.setMultiplicity(csOperation.getMultiplicity());
		}
		for (ParameterCS csParameter : csOperation.getParameters()) {
			ParameterCS boundParameter = BaseCSTFactory.eINSTANCE.createParameterCS();
			boundParameter.setName(csParameter.getName());
			boundParameter.setType(specializeType(csParameter.getType(), bindings));
			boundParameter.getQualifiers().addAll(csParameter.getQualifiers());
			if (csOperation.eIsSet(BaseCSTPackage.Literals.TYPED_ELEMENT_CS__LOWER)) {
				boundParameter.setLower(csParameter.getLower());
			}
			if (csOperation.eIsSet(BaseCSTPackage.Literals.TYPED_ELEMENT_CS__UPPER)) {
				boundParameter.setUpper(csParameter.getUpper());
			}
			if (csOperation.eIsSet(BaseCSTPackage.Literals.TYPED_ELEMENT_CS__MULTIPLICITY)) {
				boundParameter.setMultiplicity(csParameter.getMultiplicity());
			}
			boundElement.getParameters().add(boundParameter);
		}
		boundOperations.add(boundElement);
		return boundElement;
	}
	
	public static TypedRefCS specializeType(TypedRefCS csTypeRef, TypeBindingsCS bindings) {
		if (csTypeRef instanceof PrimitiveTypeRefCS) {
			PrimitiveTypeRefCS boundType = BaseCSTFactory.eINSTANCE.createPrimitiveTypeRefCS();
			boundType.setName(((PrimitiveTypeRefCS)csTypeRef).getName());
			return boundType;
		}
		if (csTypeRef instanceof TypedTypeRefCS) {
			TypeCS csType = ((TypedTypeRefCS)csTypeRef).getType();
			TypedTypeRefCS boundType = BaseCSTFactory.eINSTANCE.createTypedTypeRefCS();
			boundType.setType(csType);
			if (csType instanceof ClassifierCS) {
				List<TypeParameterCS> typeParameters = ((ClassifierCS)csType).getTypeParameters();
				List<TypeRefCS> typeArguments = boundType.getTypeArguments();
				specializeTypeParameters(typeArguments, typeParameters, bindings);
			}
			return boundType;
		}
		return null;
	}
	
	public static TypedRefCS specializeType(TypeCS csType, TypeBindingsCS bindings) {
		if (csType instanceof PrimitiveTypeCS) {
			PrimitiveTypeRefCS boundType = BaseCSTFactory.eINSTANCE.createPrimitiveTypeRefCS();
			boundType.setName(((PrimitiveTypeCS)csType).getValue());
			return boundType;
		}
		if (csType instanceof ClassifierCS) {
			ClassifierCS csClassifier = (ClassifierCS)csType;
			TypedTypeRefCS boundType = BaseCSTFactory.eINSTANCE.createTypedTypeRefCS();
			boundType.setType(csClassifier);
			List<TypeParameterCS> typeParameters = csClassifier.getTypeParameters();
			List<TypeRefCS> typeArguments = boundType.getTypeArguments();
			specializeTypeParameters(typeArguments, typeParameters, bindings);
			return boundType;
		}
		return null;
	}

	public static void specializeTypeParameters(List<TypeRefCS> typeArguments,
			List<TypeParameterCS> typeParameters, TypeBindingsCS bindings) {
		for (TypeParameterCS csTypeParameter : typeParameters) {
			TypeBindingCS csTypeBinding = getTypeBinding(csTypeParameter, bindings);
			if (csTypeBinding != null) {
				typeArguments.add(specializeType(csTypeBinding.getTypeArgument(), bindings));
			}
		}
	}
}
