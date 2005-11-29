/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.ocl.uml.internal.impl;

import org.eclipse.emf.ocl.uml.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ocl.uml.CallAction;
import org.eclipse.emf.ocl.uml.Constraint;
import org.eclipse.emf.ocl.uml.SendAction;
import org.eclipse.emf.ocl.uml.UmlFactory;
import org.eclipse.emf.ocl.uml.UmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlFactoryImpl
	extends EFactoryImpl
	implements UmlFactory {

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case UmlPackage.CALL_ACTION: return createCallAction();
			case UmlPackage.CONSTRAINT: return createConstraint();
			case UmlPackage.SEND_ACTION: return createSendAction();
			case UmlPackage.ASSOCIATION_CLASS_END: return createAssociationClassEnd();
			case UmlPackage.ASSOCIATION_CLASS: return createAssociationClass();
			case UmlPackage.SIGNAL: return createSignal();
			case UmlPackage.ASSOCIATION_END: return createAssociationEnd();
			case UmlPackage.QUALIFIER: return createQualifier();
			case UmlPackage.OPERATION: return createOperation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallAction createCallAction() {
		CallActionImpl callAction = new CallActionImpl();
		return callAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint createConstraint() {
		ConstraintImpl constraint = new ConstraintImpl();
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SendAction createSendAction() {
		SendActionImpl sendAction = new SendActionImpl();
		return sendAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationClassEnd createAssociationClassEnd() {
		AssociationClassEndImpl associationClassEnd = new AssociationClassEndImpl();
		return associationClassEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationClass createAssociationClass() {
		AssociationClassImpl associationClass = new AssociationClassImpl();
		return associationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signal createSignal() {
		SignalImpl signal = new SignalImpl();
		return signal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationEnd createAssociationEnd() {
		AssociationEndImpl associationEnd = new AssociationEndImpl();
		return associationEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Qualifier createQualifier() {
		QualifierImpl qualifier = new QualifierImpl();
		return qualifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation createOperation() {
		OperationImpl operation = new OperationImpl();
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlPackage getUmlPackage() {
		return (UmlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static UmlPackage getPackage() {
		return UmlPackage.eINSTANCE;
	}

} //UmlFactoryImpl
