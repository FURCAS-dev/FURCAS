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
 * $Id: OutlineBehavior.java,v 1.2 2010/04/08 06:26:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Outline Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.editor.OutlineBehavior#getElements <em>Elements</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.OutlineBehavior#isHidden <em>Hidden</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.editor.EditorPackage#getOutlineBehavior()
 * @model
 * @generated
 */
public interface OutlineBehavior extends Behavior {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.editor.AbstractOutlineElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see #isSetElements()
	 * @see #unsetElements()
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getOutlineBehavior_Elements()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
	EList<AbstractOutlineElement> getElements();

	/**
	 * Unsets the value of the '{@link org.eclipse.ocl.examples.editor.OutlineBehavior#getElements <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElements()
	 * @see #getElements()
	 * @generated
	 */
	void unsetElements();

	/**
	 * Returns whether the value of the '{@link org.eclipse.ocl.examples.editor.OutlineBehavior#getElements <em>Elements</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Elements</em>' containment reference list is set.
	 * @see #unsetElements()
	 * @see #getElements()
	 * @generated
	 */
	boolean isSetElements();

	/**
	 * Returns the value of the '<em><b>Hidden</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hidden</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hidden</em>' attribute.
	 * @see #setHidden(boolean)
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getOutlineBehavior_Hidden()
	 * @model default="false"
	 * @generated
	 */
	boolean isHidden();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.editor.OutlineBehavior#isHidden <em>Hidden</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hidden</em>' attribute.
	 * @see #isHidden()
	 * @generated
	 */
	void setHidden(boolean value);

} // OutlineBehavior
