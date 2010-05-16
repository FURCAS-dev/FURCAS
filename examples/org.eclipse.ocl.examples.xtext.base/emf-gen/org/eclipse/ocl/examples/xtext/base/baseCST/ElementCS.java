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
 * $Id: ElementCS.java,v 1.2 2010/05/16 19:18:01 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.xtext.base.util.Signature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element CS</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getElementCS()
 * @model abstract="true"
 * @generated
 */
public interface ElementCS extends EObject {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getSignature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model sDataType="org.eclipse.ocl.examples.xtext.base.baseCST.Signature"
	 * @generated
	 */
	void getSignature(Signature s);
} // ElementCS
