/**
 * <copyright>
 * 
 * Copyright (c) 2007,2010 Eclipse Modeling Project.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: UnresolvedClassifierImpl.java,v 1.1 2010/03/11 11:54:56 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.unresolved.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.ocl.examples.parser.unresolved.UnresolvedClassifier;
import org.eclipse.ocl.examples.parser.unresolved.UnresolvedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class UnresolvedClassifierImpl extends EObjectImpl implements UnresolvedClassifier {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnresolvedClassifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UnresolvedPackage.Literals.UNRESOLVED_CLASSIFIER;
	}

} //UnresolvedClassifierImpl
