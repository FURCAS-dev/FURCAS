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
 * $Id: TupleTypeImpl.java,v 1.10 2010/04/23 05:52:14 ewillink Exp $
 */
package org.eclipse.ocl.uml.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DelegatingEList;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.uml.AnyType;
import org.eclipse.ocl.uml.TupleType;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.ocl.uml.internal.OCLStandardLibraryImpl;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.internal.impl.DataTypeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuple Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public class TupleTypeImpl
		extends DataTypeImpl
		implements TupleType {

	private EList<Operation> operations;

	private EList<Property> properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TupleTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLPackage.Literals.TUPLE_TYPE;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public String getName() {
		if (name == null) {
			StringBuffer myName = new StringBuffer();
			myName.append(SINGLETON_NAME).append('(');

			for (Iterator<Property> iter = oclProperties().iterator(); iter
				.hasNext();) {
				Property next = iter.next();

				myName.append(next.getName());

				Type type = next.getType();
				if (type != null) {
					myName.append(" : "); //$NON-NLS-1$
					myName.append(type.getName());
				}

				if (iter.hasNext()) {
					myName.append(", "); //$NON-NLS-1$
				}
			}

			myName.append(')');
			name = myName.toString();
		}

		return name;
	}

	/**
	 * @generated NOT
	 */
	public EList<Operation> oclOperations() {
		if (operations == null) {
			AnyType prototype = (AnyType) OCLStandardLibraryImpl.INSTANCE
				.getOclAny();

			if (prototype == this) {
				// I *am* the standard library type!
				operations = getOperations();
			} else {
				// the prototype defines my operations for me
				operations = prototype.oclOperations();
			}
		}

		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkTupleTypeName(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return org.eclipse.ocl.types.operations.TupleTypeOperations
			.checkTupleTypeName(this, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkPartNamesUnique(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return org.eclipse.ocl.types.operations.TupleTypeOperations
			.checkPartNamesUnique(this, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkFeaturesOnlyProperties(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return org.eclipse.ocl.types.operations.TupleTypeOperations
			.checkFeaturesOnlyProperties(this, diagnostics, context);
	}

	/**
	 * @generated NOT
	 */
	public EList<Property> oclProperties() {
		if (properties == null) {
			properties = new DelegatingEList<Property>() {

				private static final long serialVersionUID = -4098965170992199523L;

				@Override
				protected List<Property> delegateList() {
					return getOwnedAttributes();
				}
			};
		}
		return properties;
	}

} //TupleTypeImpl
