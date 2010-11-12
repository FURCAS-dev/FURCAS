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
 * $Id: EditorDefinition.java,v 1.2 2010/04/08 06:26:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.editor.EditorDefinition#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.EditorDefinition#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.editor.EditorDefinition#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.editor.EditorPackage#getEditorDefinition()
 * @model
 * @generated
 */
public interface EditorDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see #setLanguage(String)
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getEditorDefinition_Language()
	 * @model required="true"
	 * @generated
	 */
	String getLanguage();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.editor.EditorDefinition#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Extends</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.editor.EditorDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' reference list.
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getEditorDefinition_Extends()
	 * @model
	 * @generated
	 */
	EList<EditorDefinition> getExtends();

	/**
	 * Returns the value of the '<em><b>Node</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.editor.AbstractNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.editor.EditorPackage#getEditorDefinition_Node()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractNode> getNode();

} // EditorDefinition
