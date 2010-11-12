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
 * $Id: EditorFactory.java,v 1.2 2010/04/08 06:26:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.editor.EditorPackage
 * @generated
 */
public interface EditorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EditorFactory eINSTANCE = org.eclipse.ocl.examples.editor.impl.EditorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Ecore Label Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecore Label Element</em>'.
	 * @generated
	 */
	EcoreLabelElement createEcoreLabelElement();

	/**
	 * Returns a new object of class '<em>Ecore Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecore Node</em>'.
	 * @generated
	 */
	EcoreNode createEcoreNode();

	/**
	 * Returns a new object of class '<em>Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Definition</em>'.
	 * @generated
	 */
	EditorDefinition createEditorDefinition();

	/**
	 * Returns a new object of class '<em>Folding Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Folding Behavior</em>'.
	 * @generated
	 */
	FoldingBehavior createFoldingBehavior();

	/**
	 * Returns a new object of class '<em>Java Label Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Label Element</em>'.
	 * @generated
	 */
	JavaLabelElement createJavaLabelElement();

	/**
	 * Returns a new object of class '<em>Java Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Node</em>'.
	 * @generated
	 */
	JavaNode createJavaNode();

	/**
	 * Returns a new object of class '<em>Label Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Label Behavior</em>'.
	 * @generated
	 */
	LabelBehavior createLabelBehavior();

	/**
	 * Returns a new object of class '<em>Outline Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Outline Behavior</em>'.
	 * @generated
	 */
	OutlineBehavior createOutlineBehavior();

	/**
	 * Returns a new object of class '<em>Outline Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Outline Element</em>'.
	 * @generated
	 */
	OutlineElement createOutlineElement();

	/**
	 * Returns a new object of class '<em>Outline Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Outline Group</em>'.
	 * @generated
	 */
	OutlineGroup createOutlineGroup();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EditorPackage getEditorPackage();

} //EditorFactory
