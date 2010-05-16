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
 * $Id: CompleteOCLCSTFactoryImpl.java,v 1.4 2010/05/16 19:26:02 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.BodyCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTFactory;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DerCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InitCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InvCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.NamedConstraintCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageArgCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PostCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PreCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompleteOCLCSTFactoryImpl extends EFactoryImpl implements CompleteOCLCSTFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompleteOCLCSTFactory init() {
		try {
			CompleteOCLCSTFactory theCompleteOCLCSTFactory = (CompleteOCLCSTFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/ocl/3.0.0/CompleteOCLCST"); 
			if (theCompleteOCLCSTFactory != null) {
				return theCompleteOCLCSTFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CompleteOCLCSTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteOCLCSTFactoryImpl() {
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
			case CompleteOCLCSTPackage.BODY_CS: return createBodyCS();
			case CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS: return createClassifierContextDeclCS();
			case CompleteOCLCSTPackage.COMPLETE_OCL_DOCUMENT_CS: return createCompleteOCLDocumentCS();
			case CompleteOCLCSTPackage.CONSTRAINT_CS: return createConstraintCS();
			case CompleteOCLCSTPackage.DEF_CS: return createDefCS();
			case CompleteOCLCSTPackage.DER_CS: return createDerCS();
			case CompleteOCLCSTPackage.INIT_CS: return createInitCS();
			case CompleteOCLCSTPackage.INV_CS: return createInvCS();
			case CompleteOCLCSTPackage.NAMED_CONSTRAINT_CS: return createNamedConstraintCS();
			case CompleteOCLCSTPackage.OCL_MESSAGE_ARG_CS: return createOclMessageArgCS();
			case CompleteOCLCSTPackage.OCL_MESSAGE_CS: return createOclMessageCS();
			case CompleteOCLCSTPackage.OPERATION_CONTEXT_DECL_CS: return createOperationContextDeclCS();
			case CompleteOCLCSTPackage.PACKAGE_DECLARATION_CS: return createPackageDeclarationCS();
			case CompleteOCLCSTPackage.POST_CS: return createPostCS();
			case CompleteOCLCSTPackage.PRE_CS: return createPreCS();
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS: return createPropertyContextDeclCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageDeclarationCS createPackageDeclarationCS() {
		PackageDeclarationCSImpl packageDeclarationCS = new PackageDeclarationCSImpl();
		return packageDeclarationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyContextDeclCS createPropertyContextDeclCS() {
		PropertyContextDeclCSImpl propertyContextDeclCS = new PropertyContextDeclCSImpl();
		return propertyContextDeclCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitCS createInitCS() {
		InitCSImpl initCS = new InitCSImpl();
		return initCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DerCS createDerCS() {
		DerCSImpl derCS = new DerCSImpl();
		return derCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierContextDeclCS createClassifierContextDeclCS() {
		ClassifierContextDeclCSImpl classifierContextDeclCS = new ClassifierContextDeclCSImpl();
		return classifierContextDeclCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteOCLDocumentCS createCompleteOCLDocumentCS() {
		CompleteOCLDocumentCSImpl completeOCLDocumentCS = new CompleteOCLDocumentCSImpl();
		return completeOCLDocumentCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvCS createInvCS() {
		InvCSImpl invCS = new InvCSImpl();
		return invCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefCS createDefCS() {
		DefCSImpl defCS = new DefCSImpl();
		return defCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationContextDeclCS createOperationContextDeclCS() {
		OperationContextDeclCSImpl operationContextDeclCS = new OperationContextDeclCSImpl();
		return operationContextDeclCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreCS createPreCS() {
		PreCSImpl preCS = new PreCSImpl();
		return preCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostCS createPostCS() {
		PostCSImpl postCS = new PostCSImpl();
		return postCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BodyCS createBodyCS() {
		BodyCSImpl bodyCS = new BodyCSImpl();
		return bodyCS;
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
	public NamedConstraintCS createNamedConstraintCS() {
		NamedConstraintCSImpl namedConstraintCS = new NamedConstraintCSImpl();
		return namedConstraintCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclMessageArgCS createOclMessageArgCS() {
		OclMessageArgCSImpl oclMessageArgCS = new OclMessageArgCSImpl();
		return oclMessageArgCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclMessageCS createOclMessageCS() {
		OclMessageCSImpl oclMessageCS = new OclMessageCSImpl();
		return oclMessageCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteOCLCSTPackage getCompleteOCLCSTPackage() {
		return (CompleteOCLCSTPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CompleteOCLCSTPackage getPackage() {
		return CompleteOCLCSTPackage.eINSTANCE;
	}

} //CompleteOCLCSTFactoryImpl
