/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: VoidTypeImpl.java,v 1.3 2007/05/10 17:48:22 cdamus Exp $
 */
package org.eclipse.ocl.types.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Void Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class VoidTypeImpl<O> extends EObjectImpl implements VoidType<O> {
	private EList<O> operations;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VoidTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.VOID_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		return SINGLETON_NAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<O> oclOperations() {
		if (operations == null) {
			Environment<?, ?, O, ?, ?, ?, ?, ?, ?, ?, ?, ?> env =
				Environment.Registry.INSTANCE.getEnvironmentFor(this);
			
			operations = new BasicEList<O>(
					OCLStandardLibraryUtil.createAnyTypeOperations(env));
		}
		
		return operations;
	}

} //VoidTypeImpl
