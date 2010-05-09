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
 * $Id: OCLinEcoreCSTSwitch.java,v 1.4 2010/05/09 09:48:11 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.*;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeOrEnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreAttributeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassifierCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreDocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreOperationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcorePackageCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreReferenceCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreStructuralFeatureCS;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage
 * @generated
 */
public class OCLinEcoreCSTSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OCLinEcoreCSTPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLinEcoreCSTSwitch() {
		if (modelPackage == null) {
			modelPackage = OCLinEcoreCSTPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case OCLinEcoreCSTPackage.ANNOTATION_CS: {
				AnnotationCS annotationCS = (AnnotationCS)theEObject;
				T result = caseAnnotationCS(annotationCS);
				if (result == null) result = caseAnnotationElementCS(annotationCS);
				if (result == null) result = caseModelElementCS(annotationCS);
				if (result == null) result = caseElementCS(annotationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLinEcoreCSTPackage.CONSTRAINT_CS: {
				ConstraintCS constraintCS = (ConstraintCS)theEObject;
				T result = caseConstraintCS(constraintCS);
				if (result == null) result = caseNamedElementCS(constraintCS);
				if (result == null) result = caseModelElementCS(constraintCS);
				if (result == null) result = caseElementCS(constraintCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLinEcoreCSTPackage.DATA_TYPE_CS: {
				DataTypeCS dataTypeCS = (DataTypeCS)theEObject;
				T result = caseDataTypeCS(dataTypeCS);
				if (result == null) result = caseDataTypeOrEnumCS(dataTypeCS);
				if (result == null) result = caseOCLinEcoreClassifierCS(dataTypeCS);
				if (result == null) result = caseClassifierCS(dataTypeCS);
				if (result == null) result = caseNamedElementCS(dataTypeCS);
				if (result == null) result = caseTypeCS(dataTypeCS);
				if (result == null) result = caseModelElementCS(dataTypeCS);
				if (result == null) result = caseElementCS(dataTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLinEcoreCSTPackage.DATA_TYPE_OR_ENUM_CS: {
				DataTypeOrEnumCS dataTypeOrEnumCS = (DataTypeOrEnumCS)theEObject;
				T result = caseDataTypeOrEnumCS(dataTypeOrEnumCS);
				if (result == null) result = caseOCLinEcoreClassifierCS(dataTypeOrEnumCS);
				if (result == null) result = caseClassifierCS(dataTypeOrEnumCS);
				if (result == null) result = caseNamedElementCS(dataTypeOrEnumCS);
				if (result == null) result = caseTypeCS(dataTypeOrEnumCS);
				if (result == null) result = caseModelElementCS(dataTypeOrEnumCS);
				if (result == null) result = caseElementCS(dataTypeOrEnumCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLinEcoreCSTPackage.DOCUMENTATION_CS: {
				DocumentationCS documentationCS = (DocumentationCS)theEObject;
				T result = caseDocumentationCS(documentationCS);
				if (result == null) result = caseAnnotationElementCS(documentationCS);
				if (result == null) result = caseModelElementCS(documentationCS);
				if (result == null) result = caseElementCS(documentationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLinEcoreCSTPackage.ENUM_CS: {
				EnumCS enumCS = (EnumCS)theEObject;
				T result = caseEnumCS(enumCS);
				if (result == null) result = caseDataTypeOrEnumCS(enumCS);
				if (result == null) result = caseNamespaceCS(enumCS);
				if (result == null) result = caseOCLinEcoreClassifierCS(enumCS);
				if (result == null) result = caseClassifierCS(enumCS);
				if (result == null) result = caseNamedElementCS(enumCS);
				if (result == null) result = caseTypeCS(enumCS);
				if (result == null) result = caseModelElementCS(enumCS);
				if (result == null) result = caseElementCS(enumCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_ATTRIBUTE_CS: {
				OCLinEcoreAttributeCS ocLinEcoreAttributeCS = (OCLinEcoreAttributeCS)theEObject;
				T result = caseOCLinEcoreAttributeCS(ocLinEcoreAttributeCS);
				if (result == null) result = caseOCLinEcoreStructuralFeatureCS(ocLinEcoreAttributeCS);
				if (result == null) result = caseAttributeCS(ocLinEcoreAttributeCS);
				if (result == null) result = caseStructuralFeatureCS(ocLinEcoreAttributeCS);
				if (result == null) result = caseFeatureCS(ocLinEcoreAttributeCS);
				if (result == null) result = caseTypedElementCS(ocLinEcoreAttributeCS);
				if (result == null) result = caseNamedElementCS(ocLinEcoreAttributeCS);
				if (result == null) result = caseModelElementCS(ocLinEcoreAttributeCS);
				if (result == null) result = caseElementCS(ocLinEcoreAttributeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS: {
				OCLinEcoreClassCS ocLinEcoreClassCS = (OCLinEcoreClassCS)theEObject;
				T result = caseOCLinEcoreClassCS(ocLinEcoreClassCS);
				if (result == null) result = caseOCLinEcoreClassifierCS(ocLinEcoreClassCS);
				if (result == null) result = caseClassCS(ocLinEcoreClassCS);
				if (result == null) result = caseClassifierCS(ocLinEcoreClassCS);
				if (result == null) result = caseNamespaceCS(ocLinEcoreClassCS);
				if (result == null) result = caseNamedElementCS(ocLinEcoreClassCS);
				if (result == null) result = caseTypeCS(ocLinEcoreClassCS);
				if (result == null) result = caseModelElementCS(ocLinEcoreClassCS);
				if (result == null) result = caseElementCS(ocLinEcoreClassCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASSIFIER_CS: {
				OCLinEcoreClassifierCS ocLinEcoreClassifierCS = (OCLinEcoreClassifierCS)theEObject;
				T result = caseOCLinEcoreClassifierCS(ocLinEcoreClassifierCS);
				if (result == null) result = caseClassifierCS(ocLinEcoreClassifierCS);
				if (result == null) result = caseNamedElementCS(ocLinEcoreClassifierCS);
				if (result == null) result = caseTypeCS(ocLinEcoreClassifierCS);
				if (result == null) result = caseModelElementCS(ocLinEcoreClassifierCS);
				if (result == null) result = caseElementCS(ocLinEcoreClassifierCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_DOCUMENT_CS: {
				OCLinEcoreDocumentCS ocLinEcoreDocumentCS = (OCLinEcoreDocumentCS)theEObject;
				T result = caseOCLinEcoreDocumentCS(ocLinEcoreDocumentCS);
				if (result == null) result = caseDocumentCS(ocLinEcoreDocumentCS);
				if (result == null) result = caseNamespaceCS(ocLinEcoreDocumentCS);
				if (result == null) result = caseNamedElementCS(ocLinEcoreDocumentCS);
				if (result == null) result = caseModelElementCS(ocLinEcoreDocumentCS);
				if (result == null) result = caseElementCS(ocLinEcoreDocumentCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_OPERATION_CS: {
				OCLinEcoreOperationCS ocLinEcoreOperationCS = (OCLinEcoreOperationCS)theEObject;
				T result = caseOCLinEcoreOperationCS(ocLinEcoreOperationCS);
				if (result == null) result = caseOperationCS(ocLinEcoreOperationCS);
				if (result == null) result = caseFeatureCS(ocLinEcoreOperationCS);
				if (result == null) result = caseTypedElementCS(ocLinEcoreOperationCS);
				if (result == null) result = caseNamedElementCS(ocLinEcoreOperationCS);
				if (result == null) result = caseModelElementCS(ocLinEcoreOperationCS);
				if (result == null) result = caseElementCS(ocLinEcoreOperationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_PACKAGE_CS: {
				OCLinEcorePackageCS ocLinEcorePackageCS = (OCLinEcorePackageCS)theEObject;
				T result = caseOCLinEcorePackageCS(ocLinEcorePackageCS);
				if (result == null) result = casePackageCS(ocLinEcorePackageCS);
				if (result == null) result = caseNamespaceCS(ocLinEcorePackageCS);
				if (result == null) result = caseNamedElementCS(ocLinEcorePackageCS);
				if (result == null) result = caseModelElementCS(ocLinEcorePackageCS);
				if (result == null) result = caseElementCS(ocLinEcorePackageCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_REFERENCE_CS: {
				OCLinEcoreReferenceCS ocLinEcoreReferenceCS = (OCLinEcoreReferenceCS)theEObject;
				T result = caseOCLinEcoreReferenceCS(ocLinEcoreReferenceCS);
				if (result == null) result = caseOCLinEcoreStructuralFeatureCS(ocLinEcoreReferenceCS);
				if (result == null) result = caseReferenceCS(ocLinEcoreReferenceCS);
				if (result == null) result = caseStructuralFeatureCS(ocLinEcoreReferenceCS);
				if (result == null) result = caseFeatureCS(ocLinEcoreReferenceCS);
				if (result == null) result = caseTypedElementCS(ocLinEcoreReferenceCS);
				if (result == null) result = caseNamedElementCS(ocLinEcoreReferenceCS);
				if (result == null) result = caseModelElementCS(ocLinEcoreReferenceCS);
				if (result == null) result = caseElementCS(ocLinEcoreReferenceCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_STRUCTURAL_FEATURE_CS: {
				OCLinEcoreStructuralFeatureCS ocLinEcoreStructuralFeatureCS = (OCLinEcoreStructuralFeatureCS)theEObject;
				T result = caseOCLinEcoreStructuralFeatureCS(ocLinEcoreStructuralFeatureCS);
				if (result == null) result = caseStructuralFeatureCS(ocLinEcoreStructuralFeatureCS);
				if (result == null) result = caseFeatureCS(ocLinEcoreStructuralFeatureCS);
				if (result == null) result = caseTypedElementCS(ocLinEcoreStructuralFeatureCS);
				if (result == null) result = caseNamedElementCS(ocLinEcoreStructuralFeatureCS);
				if (result == null) result = caseModelElementCS(ocLinEcoreStructuralFeatureCS);
				if (result == null) result = caseElementCS(ocLinEcoreStructuralFeatureCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OCLinEcoreCSTPackage.POSTCONDITION_CS: {
				PostconditionCS postconditionCS = (PostconditionCS)theEObject;
				T result = casePostconditionCS(postconditionCS);
				if (result == null) result = caseConstraintCS(postconditionCS);
				if (result == null) result = caseNamedElementCS(postconditionCS);
				if (result == null) result = caseModelElementCS(postconditionCS);
				if (result == null) result = caseElementCS(postconditionCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotationCS(AnnotationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OC Lin Ecore Attribute CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OC Lin Ecore Attribute CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLinEcoreAttributeCS(OCLinEcoreAttributeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotationElementCS(AnnotationElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OC Lin Ecore Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OC Lin Ecore Class CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLinEcoreClassCS(OCLinEcoreClassCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Documentation CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Documentation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentationCS(DocumentationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementCS(ElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElementCS(ModelElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumCS(EnumCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureCS(FeatureCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structural Feature CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structural Feature CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuralFeatureCS(StructuralFeatureCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeCS(AttributeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassCS(ClassCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationCS(OperationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OC Lin Ecore Classifier CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OC Lin Ecore Classifier CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLinEcoreClassifierCS(OCLinEcoreClassifierCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OC Lin Ecore Document CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OC Lin Ecore Document CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLinEcoreDocumentCS(OCLinEcoreDocumentCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OC Lin Ecore Operation CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OC Lin Ecore Operation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLinEcoreOperationCS(OCLinEcoreOperationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OC Lin Ecore Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OC Lin Ecore Package CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLinEcorePackageCS(OCLinEcorePackageCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespaceCS(NamespaceCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElementCS(NamedElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageCS(PackageCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceCS(ReferenceCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OC Lin Ecore Reference CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OC Lin Ecore Reference CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLinEcoreReferenceCS(OCLinEcoreReferenceCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OC Lin Ecore Structural Feature CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OC Lin Ecore Structural Feature CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLinEcoreStructuralFeatureCS(OCLinEcoreStructuralFeatureCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Postcondition CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Postcondition CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostconditionCS(PostconditionCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeCS(TypeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierCS(ClassifierCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElementCS(TypedElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraintCS(ConstraintCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeCS(DataTypeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type Or Enum CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type Or Enum CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeOrEnumCS(DataTypeOrEnumCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentCS(DocumentCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //OCLinEcoreCSTSwitch
