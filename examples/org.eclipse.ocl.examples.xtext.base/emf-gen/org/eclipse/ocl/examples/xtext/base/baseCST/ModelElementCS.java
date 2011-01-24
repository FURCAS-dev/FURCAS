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
 * $Id: ModelElementCS.java,v 1.2 2011/01/24 20:59:31 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.util.Pivotable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS#getOwnedAnnotation <em>Owned Annotation</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS#getPivot <em>Pivot</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS#getOriginalXmiId <em>Original Xmi Id</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS#getError <em>Error</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getModelElementCS()
 * @model abstract="true" superTypes="org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS org.eclipse.ocl.examples.pivot.Pivotable"
 * @generated
 */
public interface ModelElementCS extends ElementCS, Pivotable {
	/**
	 * Returns the value of the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Annotation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Annotation</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getModelElementCS_OwnedAnnotation()
	 * @model containment="true"
	 * @generated
	 */
	EList<AnnotationElementCS> getOwnedAnnotation();

	/**
	 * Returns the value of the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pivot</em>' reference.
	 * @see #setPivot(Element)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getModelElementCS_Pivot()
	 * @model resolveProxies="false" transient="true"
	 * @generated
	 */
	Element getPivot();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS#getPivot <em>Pivot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pivot</em>' reference.
	 * @see #getPivot()
	 * @generated
	 */
	void setPivot(Element value);

	/**
	 * Returns the value of the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Xmi Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Xmi Id</em>' attribute.
	 * @see #setOriginalXmiId(String)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getModelElementCS_OriginalXmiId()
	 * @model transient="true"
	 * @generated
	 */
	String getOriginalXmiId();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS#getOriginalXmiId <em>Original Xmi Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Xmi Id</em>' attribute.
	 * @see #getOriginalXmiId()
	 * @generated
	 */
	void setOriginalXmiId(String value);

	/**
	 * Returns the value of the '<em><b>Error</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error</em>' attribute list.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getModelElementCS_Error()
	 * @model unique="false" transient="true"
	 * @generated
	 */
	EList<String> getError();

} // ModelElementCS
