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
 * $Id: LibClassCS.java,v 1.3 2010/05/24 08:59:14 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lib Class CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS#getConformsTo <em>Conforms To</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage#getLibClassCS()
 * @model
 * @generated
 */
public interface LibClassCS extends LibClassifierCS {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' attribute.
	 * @see #setClass(Class)
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage#getLibClassCS_Class()
	 * @model
	 * @generated
	 */
	Class<?> getClass_();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS#getClass_ <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' attribute.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(Class<?> value);

	/**
	 * Returns the value of the '<em><b>Conforms To</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conforms To</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conforms To</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage#getLibClassCS_ConformsTo()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypedRefCS> getConformsTo();

} // LibClassCS
