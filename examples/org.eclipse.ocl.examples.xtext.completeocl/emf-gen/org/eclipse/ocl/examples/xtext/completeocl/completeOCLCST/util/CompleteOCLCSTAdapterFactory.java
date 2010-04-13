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
 * $Id: CompleteOCLCSTAdapterFactory.java,v 1.1 2010/04/13 06:38:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.*;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OclExpressionCS;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage
 * @generated
 */
public class CompleteOCLCSTAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CompleteOCLCSTPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteOCLCSTAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CompleteOCLCSTPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompleteOCLCSTSwitch<Adapter> modelSwitch =
		new CompleteOCLCSTSwitch<Adapter>() {
			@Override
			public Adapter caseBodyCS(BodyCS object) {
				return createBodyCSAdapter();
			}
			@Override
			public Adapter caseClassifierContextDeclCS(ClassifierContextDeclCS object) {
				return createClassifierContextDeclCSAdapter();
			}
			@Override
			public Adapter caseConstraintCS(ConstraintCS object) {
				return createConstraintCSAdapter();
			}
			@Override
			public Adapter caseContextDeclCS(ContextDeclCS object) {
				return createContextDeclCSAdapter();
			}
			@Override
			public Adapter caseDefCS(DefCS object) {
				return createDefCSAdapter();
			}
			@Override
			public Adapter caseDerCS(DerCS object) {
				return createDerCSAdapter();
			}
			@Override
			public Adapter caseDocumentCS(DocumentCS object) {
				return createDocumentCSAdapter();
			}
			@Override
			public Adapter caseImportCS(ImportCS object) {
				return createImportCSAdapter();
			}
			@Override
			public Adapter caseInitCS(InitCS object) {
				return createInitCSAdapter();
			}
			@Override
			public Adapter caseInvCS(InvCS object) {
				return createInvCSAdapter();
			}
			@Override
			public Adapter caseNamedConstraintCS(NamedConstraintCS object) {
				return createNamedConstraintCSAdapter();
			}
			@Override
			public Adapter caseOclMessageArgCS(OclMessageArgCS object) {
				return createOclMessageArgCSAdapter();
			}
			@Override
			public Adapter caseOclMessageCS(OclMessageCS object) {
				return createOclMessageCSAdapter();
			}
			@Override
			public Adapter caseOperationContextDeclCS(OperationContextDeclCS object) {
				return createOperationContextDeclCSAdapter();
			}
			@Override
			public Adapter casePackageDeclarationCS(PackageDeclarationCS object) {
				return createPackageDeclarationCSAdapter();
			}
			@Override
			public Adapter casePostCS(PostCS object) {
				return createPostCSAdapter();
			}
			@Override
			public Adapter casePreCS(PreCS object) {
				return createPreCSAdapter();
			}
			@Override
			public Adapter casePropertyContextDeclCS(PropertyContextDeclCS object) {
				return createPropertyContextDeclCSAdapter();
			}
			@Override
			public Adapter caseOclExpressionCS(OclExpressionCS object) {
				return createOclExpressionCSAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DocumentCS <em>Document CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DocumentCS
	 * @generated
	 */
	public Adapter createDocumentCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ImportCS <em>Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ImportCS
	 * @generated
	 */
	public Adapter createImportCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS <em>Package Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS
	 * @generated
	 */
	public Adapter createPackageDeclarationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS <em>Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS
	 * @generated
	 */
	public Adapter createContextDeclCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS <em>Property Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS
	 * @generated
	 */
	public Adapter createPropertyContextDeclCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InitCS <em>Init CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InitCS
	 * @generated
	 */
	public Adapter createInitCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DerCS <em>Der CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DerCS
	 * @generated
	 */
	public Adapter createDerCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS <em>Classifier Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS
	 * @generated
	 */
	public Adapter createClassifierContextDeclCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InvCS <em>Inv CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InvCS
	 * @generated
	 */
	public Adapter createInvCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS <em>Def CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS
	 * @generated
	 */
	public Adapter createDefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS <em>Operation Context Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS
	 * @generated
	 */
	public Adapter createOperationContextDeclCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PreCS <em>Pre CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PreCS
	 * @generated
	 */
	public Adapter createPreCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PostCS <em>Post CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PostCS
	 * @generated
	 */
	public Adapter createPostCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.BodyCS <em>Body CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.BodyCS
	 * @generated
	 */
	public Adapter createBodyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ConstraintCS <em>Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ConstraintCS
	 * @generated
	 */
	public Adapter createConstraintCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.NamedConstraintCS <em>Named Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.NamedConstraintCS
	 * @generated
	 */
	public Adapter createNamedConstraintCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageArgCS <em>Ocl Message Arg CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageArgCS
	 * @generated
	 */
	public Adapter createOclMessageArgCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageCS <em>Ocl Message CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageCS
	 * @generated
	 */
	public Adapter createOclMessageCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OclExpressionCS <em>Ocl Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OclExpressionCS
	 * @generated
	 */
	public Adapter createOclExpressionCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CompleteOCLCSTAdapterFactory
