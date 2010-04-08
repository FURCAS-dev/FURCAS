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
 * $Id: LabelBehavior.java,v 1.2 2010/04/08 06:26:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.editor.util.FormatProvider;
import org.eclipse.ocl.examples.editor.util.ImageProvider;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Label Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.editor.LabelBehavior#getImage <em>Image</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.LabelBehavior#getImageProvider <em>Image Provider</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.LabelBehavior#getFormat <em>Format</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.LabelBehavior#getFormatProvider <em>Format Provider</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.LabelBehavior#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.editor.EditorPackage#getLabelBehavior()
 * @model
 * @generated
 */
public interface LabelBehavior extends Behavior {
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
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getLabelBehavior_Image()
	 * @model unique="false"
	 * @generated
	 */
	String getImage();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.editor.LabelBehavior#getImage <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image</em>' attribute.
	 * @see #getImage()
	 * @generated
	 */
	void setImage(String value);

	/**
	 * Returns the value of the '<em><b>Image Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Provider</em>' attribute.
	 * @see #setImageProvider(Class)
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getLabelBehavior_ImageProvider()
	 * @model unique="false"
	 * @generated
	 */
	Class<ImageProvider> getImageProvider();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.editor.LabelBehavior#getImageProvider <em>Image Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Provider</em>' attribute.
	 * @see #getImageProvider()
	 * @generated
	 */
	void setImageProvider(Class<ImageProvider> value);

	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see #setFormat(String)
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getLabelBehavior_Format()
	 * @model default="" unique="false" required="true"
	 * @generated
	 */
	String getFormat();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.editor.LabelBehavior#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(String value);

	/**
	 * Returns the value of the '<em><b>Format Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format Provider</em>' attribute.
	 * @see #setFormatProvider(Class)
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getLabelBehavior_FormatProvider()
	 * @model unique="false"
	 * @generated
	 */
	Class<FormatProvider> getFormatProvider();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.editor.LabelBehavior#getFormatProvider <em>Format Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format Provider</em>' attribute.
	 * @see #getFormatProvider()
	 * @generated
	 */
	void setFormatProvider(Class<FormatProvider> value);

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.editor.AbstractLabelElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getLabelBehavior_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractLabelElement> getElements();

} // LabelBehavior
