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
 * $Id: LibIterationCS.java,v 1.4 2011/01/24 22:28:25 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lib Iteration CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS#getOwnedIterator <em>Owned Iterator</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS#getOwnedAccumulator <em>Owned Accumulator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage#getLibIterationCS()
 * @model
 * @generated
 */
public interface LibIterationCS
		extends OperationCS, JavaImplementationCS {

	/**
	 * Returns the value of the '<em><b>Owned Iterator</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Iterator</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Iterator</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage#getLibIterationCS_OwnedIterator()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterCS> getOwnedIterator();

	/**
	 * Returns the value of the '<em><b>Owned Accumulator</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Accumulator</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Accumulator</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage#getLibIterationCS_OwnedAccumulator()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterCS> getOwnedAccumulator();

} // LibIterationCS
