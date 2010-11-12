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
 * $Id: OutlineGroup.java,v 1.2 2010/04/08 06:26:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Outline Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.editor.OutlineGroup#getImage <em>Image</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.OutlineGroup#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.OutlineGroup#getElements <em>Elements</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.OutlineGroup#isHidden <em>Hidden</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.editor.EditorPackage#getOutlineGroup()
 * @model
 * @generated
 */
public interface OutlineGroup extends AbstractOutlineElement {
	/**
	 * Returns the value of the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image</em>' attribute.
	 * @see #setImage(String)
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getOutlineGroup_Image()
	 * @model unique="false"
	 * @generated
	 */
	String getImage();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.editor.OutlineGroup#getImage <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image</em>' attribute.
	 * @see #getImage()
	 * @generated
	 */
	void setImage(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getOutlineGroup_Name()
	 * @model default="" unique="false" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.editor.OutlineGroup#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.editor.AbstractOutlineElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see #isSetElements()
	 * @see #unsetElements()
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getOutlineGroup_Elements()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
	EList<AbstractOutlineElement> getElements();

	/**
	 * Unsets the value of the '{@link org.eclipse.ocl.examples.editor.OutlineGroup#getElements <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElements()
	 * @see #getElements()
	 * @generated
	 */
	void unsetElements();

	/**
	 * Returns whether the value of the '{@link org.eclipse.ocl.examples.editor.OutlineGroup#getElements <em>Elements</em>}' containment reference list is set.
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
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getOutlineGroup_Hidden()
	 * @model default="false"
	 * @generated
	 */
	boolean isHidden();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.editor.OutlineGroup#isHidden <em>Hidden</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hidden</em>' attribute.
	 * @see #isHidden()
	 * @generated
	 */
	void setHidden(boolean value);

} // OutlineGroup
