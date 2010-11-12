/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 * 
 * </copyright>
 *
 * $Id: PrimitiveTypeImpl.java,v 1.11 2010/04/23 05:52:14 ewillink Exp $
 */
package org.eclipse.ocl.uml.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.uml.PrimitiveType;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.ocl.uml.internal.OCLStandardLibraryImpl;
import org.eclipse.uml2.uml.Operation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public class PrimitiveTypeImpl
		extends org.eclipse.uml2.uml.internal.impl.PrimitiveTypeImpl
		implements PrimitiveType {

	protected EList<Operation> operations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLPackage.Literals.PRIMITIVE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Operation> oclOperations() {
		if (operations == null) {
			PrimitiveType prototype;
			String myName = getName();

			if (BOOLEAN_NAME.equals(myName)) {
				prototype = (PrimitiveType) OCLStandardLibraryImpl.INSTANCE
					.getBoolean();
			} else if (STRING_NAME.equals(myName)) {
				prototype = (PrimitiveType) OCLStandardLibraryImpl.INSTANCE
					.getString();
			} else if (INTEGER_NAME.equals(myName)) {
				prototype = (PrimitiveType) OCLStandardLibraryImpl.INSTANCE
					.getInteger();
			} else if (REAL_NAME.equals(myName)) {
				prototype = (PrimitiveType) OCLStandardLibraryImpl.INSTANCE
					.getReal();
			} else {
				prototype = (PrimitiveType) OCLStandardLibraryImpl.INSTANCE
					.getUnlimitedNatural();
			}

			if (prototype == this) {
				// I *am* the standard library type!
				operations = getOwnedOperations();
			} else {
				// the prototype defines my operations for me
				operations = prototype.oclOperations();
			}
		}

		return operations;
	}

} //PrimitiveTypeImpl
