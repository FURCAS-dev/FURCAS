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
 * $Id: Annotation.java,v 1.2 2011/01/24 20:42:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Annotation#getOwnedContents <em>Owned Content</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Annotation#getOwnedDetails <em>Owned Detail</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Annotation#getReferences <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getAnnotation()
 * @model
 * @generated
 */
public interface Annotation
		extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Owned Content</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Contents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Content</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getAnnotation_OwnedContent()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Element> getOwnedContents();

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.Element} and appends it to the '<em><b>Owned Content</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.Element} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.Element}.
	 * @see #getOwnedContents()
	 * @generated
	 */
	Element createOwnedContent(EClass eClass);

	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getAnnotation_Reference()
	 * @model
	 * @generated
	 */
	EList<Element> getReferences();

	/**
	 * Returns the value of the '<em><b>Owned Detail</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Detail}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Details</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Detail</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getAnnotation_OwnedDetail()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Detail> getOwnedDetails();

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.Detail} and appends it to the '<em><b>Owned Detail</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.Detail}.
	 * @see #getOwnedDetails()
	 * @generated
	 */
	Detail createOwnedDetail();

} // Annotation
