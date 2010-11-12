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
 * $Id: OCLinEcoreCSTFactoryImpl.java,v 1.4 2010/05/09 09:48:11 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.*;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreAttributeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTFactory;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreDocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreOperationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcorePackageCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreReferenceCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OCLinEcoreCSTFactoryImpl extends EFactoryImpl implements OCLinEcoreCSTFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OCLinEcoreCSTFactory init() {
		try {
			OCLinEcoreCSTFactory theOCLinEcoreCSTFactory = (OCLinEcoreCSTFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/ocl/3.0.0/OCLinEcoreCST"); 
			if (theOCLinEcoreCSTFactory != null) {
				return theOCLinEcoreCSTFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OCLinEcoreCSTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLinEcoreCSTFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OCLinEcoreCSTPackage.ANNOTATION_CS: return createAnnotationCS();
			case OCLinEcoreCSTPackage.CONSTRAINT_CS: return createConstraintCS();
			case OCLinEcoreCSTPackage.DATA_TYPE_CS: return createDataTypeCS();
			case OCLinEcoreCSTPackage.DOCUMENTATION_CS: return createDocumentationCS();
			case OCLinEcoreCSTPackage.ENUM_CS: return createEnumCS();
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_ATTRIBUTE_CS: return createOCLinEcoreAttributeCS();
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_CLASS_CS: return createOCLinEcoreClassCS();
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_DOCUMENT_CS: return createOCLinEcoreDocumentCS();
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_OPERATION_CS: return createOCLinEcoreOperationCS();
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_PACKAGE_CS: return createOCLinEcorePackageCS();
			case OCLinEcoreCSTPackage.OC_LIN_ECORE_REFERENCE_CS: return createOCLinEcoreReferenceCS();
			case OCLinEcoreCSTPackage.POSTCONDITION_CS: return createPostconditionCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationCS createAnnotationCS() {
		AnnotationCSImpl annotationCS = new AnnotationCSImpl();
		return annotationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLinEcoreAttributeCS createOCLinEcoreAttributeCS() {
		OCLinEcoreAttributeCSImpl ocLinEcoreAttributeCS = new OCLinEcoreAttributeCSImpl();
		return ocLinEcoreAttributeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLinEcoreClassCS createOCLinEcoreClassCS() {
		OCLinEcoreClassCSImpl ocLinEcoreClassCS = new OCLinEcoreClassCSImpl();
		return ocLinEcoreClassCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentationCS createDocumentationCS() {
		DocumentationCSImpl documentationCS = new DocumentationCSImpl();
		return documentationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumCS createEnumCS() {
		EnumCSImpl enumCS = new EnumCSImpl();
		return enumCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLinEcoreDocumentCS createOCLinEcoreDocumentCS() {
		OCLinEcoreDocumentCSImpl ocLinEcoreDocumentCS = new OCLinEcoreDocumentCSImpl();
		return ocLinEcoreDocumentCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLinEcoreOperationCS createOCLinEcoreOperationCS() {
		OCLinEcoreOperationCSImpl ocLinEcoreOperationCS = new OCLinEcoreOperationCSImpl();
		return ocLinEcoreOperationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLinEcorePackageCS createOCLinEcorePackageCS() {
		OCLinEcorePackageCSImpl ocLinEcorePackageCS = new OCLinEcorePackageCSImpl();
		return ocLinEcorePackageCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLinEcoreReferenceCS createOCLinEcoreReferenceCS() {
		OCLinEcoreReferenceCSImpl ocLinEcoreReferenceCS = new OCLinEcoreReferenceCSImpl();
		return ocLinEcoreReferenceCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostconditionCS createPostconditionCS() {
		PostconditionCSImpl postconditionCS = new PostconditionCSImpl();
		return postconditionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintCS createConstraintCS() {
		ConstraintCSImpl constraintCS = new ConstraintCSImpl();
		return constraintCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeCS createDataTypeCS() {
		DataTypeCSImpl dataTypeCS = new DataTypeCSImpl();
		return dataTypeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLinEcoreCSTPackage getOCLinEcoreCSTPackage() {
		return (OCLinEcoreCSTPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OCLinEcoreCSTPackage getPackage() {
		return OCLinEcoreCSTPackage.eINSTANCE;
	}

} //OCLinEcoreCSTFactoryImpl
