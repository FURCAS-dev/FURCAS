/**
 * <copyright>
 *
 * Copyright (c) 2008,2010 E.D.Willink and others.
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
 * $Id: UnresolvedEnvironment.java,v 1.2 2010/04/08 06:26:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.environment;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;

/**
 * The UnresolvedEnvironment maintains a root package named $unresolved$ within which appropriate
 * EObjects are created to terminate references that cannot be resolved to semantically valid elements.
 */
public class UnresolvedEnvironment
{
	public static final String UNRESOLVED_PACKAGE_NAME = "$unresolved$";
	/**
	 * Return a plausible suggestion for a package namespace for the ePackage within file.
	 */
	public static String computePackageNs(FileHandle file, EPackage ePackage) {
		StringBuilder s = new StringBuilder();
		s.append("http://");
		s.append(file.getProjectHandle().getName());
		s.append("/");
		s.append(file.getProjectRelativeName());
		s.append("/");
		computePackageNs(s, ePackage);
		String string = s.toString();
		return string;
	}

	private static void computePackageNs(StringBuilder s, ENamedElement eNamedElement) {
		EObject eContainer = eNamedElement.eContainer();
		if (eContainer instanceof ENamedElement) {
			computePackageNs(s, (ENamedElement) eContainer);
			s.append(".");
		}
		s.append(eNamedElement.getName());
	}
	
	protected final ICSTRootEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> rootEnvironment;
	private EPackage rootPackage = null;
	
	public UnresolvedEnvironment(ICSTRootEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> rootEnvironment) {
		this.rootEnvironment = rootEnvironment;
	}

	public String computePackageNs(EPackage ePackage) {
		ICSTFileEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> fileEnvironment = rootEnvironment.getFileEnvironment();
		return computePackageNs(fileEnvironment.getFile(), ePackage);
	}

	public EAttribute getUnresolvedEAttribute(EClassifier classifier, String featureName) {
		EClass unresolvedEClass = getUnresolvedEClass(classifier);
		String name =  "attribute$" + featureName;
		EAttribute unresolvedEAttribute = (EAttribute) unresolvedEClass.getEStructuralFeature(name);
		if (unresolvedEAttribute == null) {
			unresolvedEAttribute = EcoreFactory.eINSTANCE.createEAttribute();
			unresolvedEAttribute.setName(name);
			unresolvedEAttribute.setEType(EcorePackage.Literals.ESTRING);
			unresolvedEClass.getEStructuralFeatures().add(unresolvedEAttribute);
		}
		return unresolvedEAttribute;
	}
	
	public EClass getUnresolvedEClass(EClassifier eClass) {
		if (isUnresolved(eClass))
			return (EClass) eClass;
		String name = eClass != null ? "class$" + eClass.getName() : "$class$";
		EPackage unresolvedEPackage = eClass != null ? getUnresolvedEPackage(eClass.getEPackage()) : getUnresolvedEPackage();
		EClass unresolvedEClassifier = (EClass) unresolvedEPackage.getEClassifier(name);
		if (unresolvedEClassifier == null) {
			unresolvedEClassifier = EcoreFactory.eINSTANCE.createEClass();
			unresolvedEClassifier.setName(name);
			unresolvedEPackage.getEClassifiers().add(unresolvedEClassifier);
		}
		return unresolvedEClassifier;
	}

	/**
	 * Return the unresolved class named by the tail of path.
	 */
	public EClass getUnresolvedEClass(List<String> path) {
		if (path == null)
			return getUnresolvedEClass((EClassifier)null);
		EPackage unresolvedEPackage = getUnresolvedEPackage();
		for (int i = 0; i < path.size()-1; i++)
			unresolvedEPackage = getUnresolvedEPackage(unresolvedEPackage, path.get(i));
		String name = "class$" + path.get(path.size()-1);
		EClass unresolvedEClass = (EClass) unresolvedEPackage.getEClassifier(name);
		if (unresolvedEClass == null) {
			unresolvedEClass = EcoreFactory.eINSTANCE.createEClass();
			unresolvedEClass.setName(name);
			unresolvedEPackage.getEClassifiers().add(unresolvedEClass);
		}
		return unresolvedEClass;
	}

	public EDataType getUnresolvedEDataType(EPackage resolvedEPackage, String typeName) {
		EPackage unresolvedEPackage = getUnresolvedEPackage(resolvedEPackage);
		String name =  "datatype$" + typeName;
		EDataType unresolvedEDataType = (EDataType) unresolvedEPackage.getEClassifier(name);
		if (unresolvedEDataType == null) {
			unresolvedEDataType = EcoreFactory.eINSTANCE.createEDataType();
			unresolvedEDataType.setName(name);
			unresolvedEPackage.getEClassifiers().add(unresolvedEDataType);
		}
		return unresolvedEDataType;
	}

	public EOperation getUnresolvedEOperation(EClassifier resolvedEClass, String operationName) {
		EClass unresolvedEClass = getUnresolvedEClass(resolvedEClass);
		String name =  "reference$" + operationName;
		EOperation unresolvedEOperation = EcoreUtils.getNamedElement(unresolvedEClass.getEOperations(), name);
		if (unresolvedEOperation == null) {
			unresolvedEOperation = EcoreFactory.eINSTANCE.createEOperation();
			unresolvedEOperation.setName(name);
			unresolvedEClass.getEOperations().add(unresolvedEOperation);
		}
		return unresolvedEOperation;
	}

	/**
	 * Return the root unresolved package of the unresolved tree.
	 */
	public EPackage getUnresolvedEPackage() {
		if (rootPackage == null) {
			rootPackage = EcoreFactory.eINSTANCE.createEPackage();
			rootPackage.setName(UNRESOLVED_PACKAGE_NAME);
			rootPackage.setNsPrefix("_unresolved_");
			rootPackage.setNsURI(computePackageNs(rootPackage));
		}
		return rootPackage;
	}

	public EPackage getUnresolvedEPackage(List<String> sequenceOfNames) {
		EPackage ePackage = getUnresolvedEPackage();
		for (String name : sequenceOfNames)
			ePackage = getUnresolvedEPackage(ePackage, name);
		return ePackage;
	}

	/**
	 * Return the unresolved package corresponding to ePackage, the root unresolved package if
	 * ePackage null.
	 */
	public EPackage getUnresolvedEPackage(EPackage ePackage) {
		if (ePackage == null)
			return getUnresolvedEPackage();
		if (isUnresolved(ePackage))
			return ePackage;
		EPackage unresolvedParentEPackage = getUnresolvedEPackage(ePackage.getESuperPackage());
		return getUnresolvedEPackage(unresolvedParentEPackage, ePackage.getName());
	}

	/**
	 * Return the unresolved sub-package named name of a specific unresolved package or the root unresolved
	 * package if null.
	 */
	public EPackage getUnresolvedEPackage(EPackage unresolvedPackage, String name) {
		if (unresolvedPackage == null)
			unresolvedPackage = getUnresolvedEPackage();
		EPackage ePackage = EcoreUtils.getNamedElement(unresolvedPackage.getESubpackages(), name);
		if (ePackage == null) {
			ePackage = EcoreFactory.eINSTANCE.createEPackage();
			ePackage.setName(name);
			ePackage.setNsPrefix(name);
			ePackage.setNsURI(computePackageNs(ePackage));
			unresolvedPackage.getESubpackages().add(ePackage);
		}			
		return ePackage;
	}

	public EReference getUnresolvedEReference(EClassifier resolvedEClass, String featureName) {
		EClass unresolvedEClass = getUnresolvedEClass(resolvedEClass);
		String name =  "reference$" + featureName;
		EReference unresolvedEReference = (EReference) unresolvedEClass.getEStructuralFeature(name);
		if (unresolvedEReference == null) {
			unresolvedEReference = EcoreFactory.eINSTANCE.createEReference();
			unresolvedEReference.setName(featureName);
			unresolvedEReference.setEType(unresolvedEClass);
			unresolvedEClass.getEStructuralFeatures().add(unresolvedEReference);
		}
		return unresolvedEReference;
	}
	
	/**
	 * Return true if eObject is an unresolved object. i.e. if eObject has the
	 * root unresolved package as an ancestor.
	 */
	public boolean isUnresolved(EObject eObject) {
		if (rootPackage != null) {
			for ( ; eObject != null; eObject = eObject.eContainer())
				if (eObject == rootPackage)
					return true;
		}
		return false;
	}
}

	

	