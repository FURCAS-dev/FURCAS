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
 * $Id: ElementUtil.java,v 1.3 2011/02/15 10:36:55 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.utilities;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeCSAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.ModelElementCSScopeAdapter;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class ElementUtil
{
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
		List<String> qualifiers = csTypedElement.getQualifier();
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

	public static TemplateParameter getFormalTemplateParameter(TemplateParameterSubstitutionCS csTemplateParameterSubstitution) {
		TemplateBindingCS csTemplateBinding = csTemplateParameterSubstitution.getOwningTemplateBinding();
		int index = csTemplateBinding.getOwnedParameterSubstitution().indexOf(csTemplateParameterSubstitution);
		if (index < 0) {
			return null;
		}
		TemplateBinding templateBinding = (TemplateBinding) csTemplateBinding.getPivot();
		TemplateSignature templateSignature = templateBinding.getSignature();
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
		if (templateParameters.size() <= index) {
			return null;
		}
		return templateParameters.get(index);
	}

	public static ILeafNode getLeafNode(INode node) {
		ILeafNode leafNode = null;
		if (node instanceof ILeafNode) {
			return (ILeafNode) node;
		}
		else {
			for (ILeafNode lNode : node.getLeafNodes()) {
				if (!lNode.isHidden()) {
					leafNode = lNode;
					return leafNode;
				}
			}
		}
		return null;
	}

	public static <T extends NamedElementCS> T getNamedElementCS(Collection<T> namedElements, String name) {
		for (T namedElement : namedElements) {
			if (name.equals(namedElement.getName())) {
				return namedElement;
			}
		}
		return null;
	}

	public static ScopeAdapter getScopeAdapter(TypeManager typeManager, Element element) {
		return ModelElementCSScopeAdapter.getScopeAdapter(typeManager, element);
	}

	public static ScopeAdapter getScopeAdapter(ModelElementCS csElement) {
		return ModelElementCSScopeAdapter.getScopeAdapter(csElement);
	}

	public static ScopeCSAdapter getScopeCSAdapter(ElementCS csElement) {
		return ModelElementCSScopeAdapter.getScopeCSAdapter(csElement);
	}

/*	public static Collection<TemplateParameterSubstitutionCS> getTemplateParameterSubstitutions(ParameterizedTypeRefCS templateableElement) {
		if (templateableElement != null) {
			TemplateBindingCS ownedTemplateBinding = templateableElement.getOwnedTemplateBinding();
//			if (ownedTemplateBinding != null) {
//				return ownedTemplateBinding.getOwnedTemplateParameter();
//			}
		}
		return ECollections.emptyEList();
	} */

	public static String getText(ElementCS csElement) {
/*		NodeAdapter nodeAdapter = NodeModelUtils.getNodeAdapter(csElement);
		if (nodeAdapter == null) {
			return null;
		}
		ICompositeNode compositeNode = nodeAdapter.getParserNode();
		if (compositeNode == null) {
			return null;
		}
		String string = null;
		StringBuffer s = null;
		for (ILeafNode leaf : compositeNode.getLeafNodes()) {
			if (!leaf.isHidden()) {
				String text = leaf.getText();
				if (s != null) {
					s.append(text);
				}
				else if (string != null) {
					s = new StringBuffer();
					s.append(string);
					s.append(text);
				}
				else {
					string = text;
				}
			}
		}
		return s != null ? s.toString() : string; */
		return NodeModelUtils.getTextWithoutHidden(NodeModelUtils.getNode(csElement));
	}
	
/*	public static TypeBindingCS getTypeBinding(TypeParameterCS typeParameter, TypeBindingsCS bindings) {
		if (bindings != null) {
			for (TypeBindingCS binding : bindings.getBindings()) {
				if (binding.getTypeParameter() == typeParameter) {
					return binding;
				}
			}
		}
		return null;
	} */

	public static boolean isInOperation(ElementCS csElement) {
		for (EObject eObject = csElement; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof OperationCS) {
				return true;
			}
			else if (eObject instanceof ClassCS) {
				return false;
			}
		}
		return false;
	}

	public static boolean isSpecialization(TemplateBindingCS csTemplateBinding) {
		TypedTypeRefCS csTypedTypeRef = csTemplateBinding.getOwningTemplateBindableElement();
		Element type = csTypedTypeRef.getPivot();
		for (TemplateParameterSubstitutionCS csTemplateParameterSubstitution : csTemplateBinding.getOwnedParameterSubstitution()) {
			ParameterableElementCS ownedActualParameter = csTemplateParameterSubstitution.getOwnedActualParameter();
			if (ownedActualParameter instanceof WildcardTypeRefCS) {
				return true;
			}
			org.eclipse.ocl.examples.pivot.Class actualParameterClass = (org.eclipse.ocl.examples.pivot.Class) ownedActualParameter.getPivot();
			TemplateParameter owningTemplateParameter = actualParameterClass.getOwningTemplateParameter();
			if (owningTemplateParameter == null) {
				return true;
			}
			TemplateSignature signature = owningTemplateParameter.getSignature();
			TemplateableElement template = signature.getTemplate();
			if (template != type) {
				return true;
			}
		}
		return false;
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

/*	public static Type specializeClass(ClassCS csClass) {
//		if (ElementUtil.getTemplateParameters(csClass).isEmpty()) {
			return (Type) csClass;				
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
		boundDocument.getOwnedType().add(boundElement);
		return boundElement; 
	} */

/*	public static OperationCS specializeOperation(OperationCS csOperation, TypeBindingsCS bindings) {
		ClassCS owner = csOperation.getOwner();
		List<OperationCS> boundOperations = null;
		if (getTemplateParameters(owner).isEmpty()) {
			if (getTemplateParameters(csOperation).isEmpty()) {
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
				boundDocument.getOwnedType().add(boundElement);
				boundClass = boundElement;
			}
			boundOperations = boundClass.getOwnedOperation();
		}
		else {
			ScopeAdapter scopeAdapter = AbstractScopeAdapter.getScopeAdapter(owner);
			ClassifierCS boundClass = scopeAdapter.getSynthesizedType(bindings);
			boundOperations = ((ClassCS) boundClass).getOwnedOperation();
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
		boundElement.setOwnedType(specializeType(csOperation.getOwnedType(), bindings));
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
		for (ParameterCS csParameter : csOperation.getOwnedParameter()) {
			ParameterCS boundParameter = BaseCSTFactory.eINSTANCE.createParameterCS();
			boundParameter.setName(csParameter.getName());
			boundParameter.setOwnedType(specializeType(csParameter.getOwnedType(), bindings));
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
			boundElement.getOwnedParameter().add(boundParameter);
		}
		boundOperations.add(boundElement);
		return boundElement;
	} */
	
/*	public static TypedRefCS specializeType(TypedRefCS csTypeRef, TypeBindingsCS bindings) {
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
				Collection<TemplateParameterCS> typeParameters = getTemplateParameters((ClassifierCS)csType);
				List<TypeRefCS> typeArguments = boundType.getTypeArguments();
				specializeTypeParameters(typeArguments, typeParameters, bindings);
			}
			return boundType;
		}
		return null;
	} */
	
/*	public static TypedRefCS specializeType(TypeCS csType, TypeBindingsCS bindings) {
		if (csType instanceof PrimitiveTypeCS) {
			PrimitiveTypeRefCS boundType = BaseCSTFactory.eINSTANCE.createPrimitiveTypeRefCS();
			boundType.setName(((PrimitiveTypeCS)csType).getValue());
			return boundType;
		}
		if (csType instanceof ClassifierCS) {
			ClassifierCS csClassifier = (ClassifierCS)csType;
			TypedTypeRefCS boundType = BaseCSTFactory.eINSTANCE.createTypedTypeRefCS();
			boundType.setType(csClassifier);
			Collection<TemplateParameterCS> typeParameters = getTemplateParameters(csClassifier);
			List<TypeRefCS> typeArguments = boundType.getTypeArguments();
			specializeTypeParameters(typeArguments, typeParameters, bindings);
			return boundType;
		}
		return null;
	} */

/*	public static void specializeTypeParameters(List<TypeRefCS> typeArguments,
			List<TypeParameterCS> typeParameters, TypeBindingsCS bindings) {
		for (TypeParameterCS csTypeParameter : typeParameters) {
			TypeBindingCS csTypeBinding = getTypeBinding(csTypeParameter, bindings);
			if (csTypeBinding != null) {
				typeArguments.add(specializeType(csTypeBinding.getTypeArgument(), bindings));
			}
		}
	} */
}
