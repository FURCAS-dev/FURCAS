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
 * $Id: ClassifierCS.java,v 1.2 2010/05/16 19:18:01 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classifier CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS#getTypeParameters <em>Type Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getClassifierCS()
 * @model abstract="true"
 * @generated
 */
public interface ClassifierCS extends NamedElementCS, TypeCS {
	/**
	 * Returns the value of the '<em><b>Type Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Parameters</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getClassifierCS_TypeParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypeParameterCS> getTypeParameters();

} // ClassifierCS
