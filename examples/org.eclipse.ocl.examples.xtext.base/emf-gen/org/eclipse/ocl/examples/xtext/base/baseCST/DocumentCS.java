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
 * $Id: DocumentCS.java,v 1.2 2010/05/16 19:18:01 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS#getLibraries <em>Libraries</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS#getBoundClassifiers <em>Bound Classifiers</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS#getBoundOperations <em>Bound Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getDocumentCS()
 * @model abstract="true"
 * @generated
 */
public interface DocumentCS extends NamespaceCS {

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getDocumentCS_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<ImportCS> getImports();

	/**
	 * Returns the value of the '<em><b>Libraries</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Libraries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Libraries</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getDocumentCS_Libraries()
	 * @model containment="true"
	 * @generated
	 */
	EList<LibraryCS> getLibraries();

	/**
	 * Returns the value of the '<em><b>Bound Classifiers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.baseCST.BoundClassifierCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound Classifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Classifiers</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getDocumentCS_BoundClassifiers()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	EList<BoundClassifierCS> getBoundClassifiers();

	/**
	 * Returns the value of the '<em><b>Bound Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.baseCST.BoundOperationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Operations</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getDocumentCS_BoundOperations()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	EList<BoundOperationCS> getBoundOperations();
} // DocumentCS
