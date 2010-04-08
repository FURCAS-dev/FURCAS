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
 * $Id: EcoreLabelElement.java,v 1.2 2010/04/08 06:26:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.editor.util.TextProvider;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Label Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.editor.EcoreLabelElement#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.EcoreLabelElement#getEnd <em>End</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.EcoreLabelElement#isHideIfBlank <em>Hide If Blank</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.EcoreLabelElement#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.EcoreLabelElement#getSeparator <em>Separator</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.EcoreLabelElement#getSuffix <em>Suffix</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.EcoreLabelElement#getTextProvider <em>Text Provider</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.editor.EditorPackage#getEcoreLabelElement()
 * @model
 * @generated
 */
public interface EcoreLabelElement extends AbstractLabelElement {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' reference list.
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getEcoreLabelElement_Path()
	 * @model
	 * @generated
	 */
	EList<EReference> getPath();

	/**
	 * Returns the value of the '<em><b>End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' reference.
	 * @see #setEnd(EStructuralFeature)
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getEcoreLabelElement_End()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getEnd();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.editor.EcoreLabelElement#getEnd <em>End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' reference.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Hide If Blank</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hide If Blank</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hide If Blank</em>' attribute.
	 * @see #setHideIfBlank(boolean)
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getEcoreLabelElement_HideIfBlank()
	 * @model default="false"
	 * @generated
	 */
	boolean isHideIfBlank();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.editor.EcoreLabelElement#isHideIfBlank <em>Hide If Blank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hide If Blank</em>' attribute.
	 * @see #isHideIfBlank()
	 * @generated
	 */
	void setHideIfBlank(boolean value);

	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see #setPrefix(String)
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getEcoreLabelElement_Prefix()
	 * @model default=""
	 * @generated
	 */
	String getPrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.editor.EcoreLabelElement#getPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see #getPrefix()
	 * @generated
	 */
	void setPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Separator</b></em>' attribute.
	 * The default value is <code>" "</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Separator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Separator</em>' attribute.
	 * @see #setSeparator(String)
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getEcoreLabelElement_Separator()
	 * @model default=" "
	 * @generated
	 */
	String getSeparator();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.editor.EcoreLabelElement#getSeparator <em>Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Separator</em>' attribute.
	 * @see #getSeparator()
	 * @generated
	 */
	void setSeparator(String value);

	/**
	 * Returns the value of the '<em><b>Suffix</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suffix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suffix</em>' attribute.
	 * @see #setSuffix(String)
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getEcoreLabelElement_Suffix()
	 * @model default=""
	 * @generated
	 */
	String getSuffix();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.editor.EcoreLabelElement#getSuffix <em>Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suffix</em>' attribute.
	 * @see #getSuffix()
	 * @generated
	 */
	void setSuffix(String value);

	/**
	 * Returns the value of the '<em><b>Text Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Provider</em>' attribute.
	 * @see #setTextProvider(Class)
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getEcoreLabelElement_TextProvider()
	 * @model unique="false"
	 * @generated
	 */
	Class<TextProvider> getTextProvider();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.editor.EcoreLabelElement#getTextProvider <em>Text Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Provider</em>' attribute.
	 * @see #getTextProvider()
	 * @generated
	 */
	void setTextProvider(Class<TextProvider> value);

} // LabelElement
