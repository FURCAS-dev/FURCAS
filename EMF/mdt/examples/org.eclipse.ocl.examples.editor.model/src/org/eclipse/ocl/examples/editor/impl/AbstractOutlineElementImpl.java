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
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: AbstractOutlineElementImpl.java,v 1.2 2010/04/08 06:26:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.ocl.examples.editor.AbstractOutlineElement;
import org.eclipse.ocl.examples.editor.EditorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Outline Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class AbstractOutlineElementImpl extends EObjectImpl implements AbstractOutlineElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractOutlineElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EditorPackage.Literals.ABSTRACT_OUTLINE_ELEMENT;
	}

} //AbstractOutlineElementImpl
