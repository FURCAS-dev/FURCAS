/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: LibClassCS.java,v 1.5 2011/02/15 10:37:08 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST;

import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lib Class CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS#getMetaTypeName <em>Meta Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage#getLibClassCS()
 * @model
 * @generated
 */
public interface LibClassCS
		extends ClassCS {

	/**
	 * Returns the value of the '<em><b>Meta Type Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Type Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Type Name</em>' reference.
	 * @see #setMetaTypeName(MetaTypeName)
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage#getLibClassCS_MetaTypeName()
	 * @model transient="true"
	 * @generated
	 */
	MetaTypeName getMetaTypeName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS#getMetaTypeName <em>Meta Type Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Type Name</em>' reference.
	 * @see #getMetaTypeName()
	 * @generated
	 */
	void setMetaTypeName(MetaTypeName value);

} // LibClassCS
