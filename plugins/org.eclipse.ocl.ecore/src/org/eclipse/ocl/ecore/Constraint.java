/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: Constraint.java,v 1.6 2008/03/28 20:33:41 cdamus Exp $
 */
package org.eclipse.ocl.ecore;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.utilities.ExpressionInOCL;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.ecore.Constraint#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.eclipse.ocl.ecore.Constraint#getConstrainedElements <em>Constrained Elements</em>}</li>
 *   <li>{@link org.eclipse.ocl.ecore.Constraint#getStereotype <em>Stereotype</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.ecore.EcorePackage#getConstraint()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='WellFormedName'"
 * @generated
 */
public interface Constraint extends ENamedElement {
    /**
     * Returns the value of the '<em><b>Specification</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Specification</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Specification</em>' containment reference.
     * @see #setSpecification(ExpressionInOCL)
     * @see org.eclipse.ocl.ecore.EcorePackage#getConstraint_Specification()
     * @model containment="true" required="true"
     * @generated
     */
    ExpressionInOCL<EClassifier, EParameter> getSpecification();

    /**
     * Sets the value of the '{@link org.eclipse.ocl.ecore.Constraint#getSpecification <em>Specification</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Specification</em>' containment reference.
     * @see #getSpecification()
     * @generated
     */
    void setSpecification(ExpressionInOCL<EClassifier, EParameter> value);

    /**
     * Returns the value of the '<em><b>Constrained Elements</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.emf.ecore.ENamedElement}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Constrained Elements</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Constrained Elements</em>' reference list.
     * @see org.eclipse.ocl.ecore.EcorePackage#getConstraint_ConstrainedElements()
     * @model
     * @generated
     */
    EList<ENamedElement> getConstrainedElements();

    /**
     * Returns the value of the '<em><b>Stereotype</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Stereotype</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Stereotype</em>' attribute.
     * @see #setStereotype(String)
     * @see org.eclipse.ocl.ecore.EcorePackage#getConstraint_Stereotype()
     * @model
     * @generated
     */
    String getStereotype();

    /**
     * Sets the value of the '{@link org.eclipse.ocl.ecore.Constraint#getStereotype <em>Stereotype</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Stereotype</em>' attribute.
     * @see #getStereotype()
     * @generated
     */
    void setStereotype(String value);

} // Constraint
