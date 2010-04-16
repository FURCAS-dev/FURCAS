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
 * $Id: AbstractConversion.java,v 1.1 2010/04/16 18:05:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeOrEnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DetailCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EAttributeRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EObjectRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EReferenceRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumLiteralCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ImportCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTFactory;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ObjectRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OperationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.WildcardTypeRefCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.util.OCLinEcoreCSTSwitch;

public class AbstractConversion extends EcoreUtil
{	// extends EcoreUtil solely to gain access to protected GEN_MODEL_PACKAGE_NS_URI
	public static boolean isId(String name) {
		int n = name.length();
		if (n == 0)
			return false;
		if (!Character.isJavaIdentifierStart(name.charAt(0)))
			return false;
		for (int i = 1; i < n; i++)
			if (!Character.isJavaIdentifierPart(name.charAt(i)))
				return false;
		return true;
	}
	
	private List<String> errors = null;

	protected <T> T basicGet(EObject eObject, EAttribute eFeature, Class<T> resultClass) {
		if (!eObject.eIsSet(eFeature)) {
			return null;
		}
		@SuppressWarnings("unchecked")
		T result = (T) eObject.eGet(eFeature);
		return result;
	}

	protected void error(String string) {
		if (errors == null) {
			errors = new ArrayList<String>();
		}
		errors.add(string);
	}

	public List<String> getErrors() {
		return errors;
	}
}