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
 * $Id: OCLinEcoreDocumentCS.java,v 1.1 2010/05/03 05:44:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreDocumentCS#getPackages <em>Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage#getOCLinEcoreDocumentCS()
 * @model
 * @generated
 */
public interface OCLinEcoreDocumentCS extends DocumentCS {

	/**
	 * Returns the value of the '<em><b>Packages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcorePackageCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packages</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage#getOCLinEcoreDocumentCS_Packages()
	 * @model containment="true"
	 * @generated
	 */
	EList<OCLinEcorePackageCS> getPackages();

} // DocumentCS
