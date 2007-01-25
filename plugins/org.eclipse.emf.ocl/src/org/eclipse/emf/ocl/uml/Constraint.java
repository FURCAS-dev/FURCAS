/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.ocl.uml;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.utilities.Visitable;

/**
 * @deprecated Use the {@link org.eclipse.ocl.ecore.Constraint} interface,
 * instead.
 * 
 * @author Edith Schonberg (edith)
 *
 */
public interface Constraint extends ENamedElement, Visitable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 * Stereotype applied to classifier invariant constraints.
	 * 
	 * @see #getStereotype()
	 */
	public static final String INVARIANT = "invariant"; //$NON-NLS-1$
	
	/**
	 * Stereotype applied to operation precondition constraints.
	 * 
	 * @see #getStereotype()
	 */
	public static final String PRECONDITION = "precondition"; //$NON-NLS-1$
	
	/**
	 * Stereotype applied to operation postcondition constraints.
	 * 
	 * @see #getStereotype()
	 */
	public static final String POSTCONDITION = "postcondition"; //$NON-NLS-1$
	
	/**
	 * Stereotype applied to operation body conditions.
	 * 
	 * @see #getStereotype()
	 */
	public static final String BODY = "body"; //$NON-NLS-1$
	
	/**
	 * Stereotype applied definition expressions.
	 * 
	 * @see #getStereotype()
	 */
	public static final String DEFINITION = "definition"; //$NON-NLS-1$
	
	/**
	 * Stereotype applied initial value expressions.
	 * 
	 * @see #getStereotype()
	 */
	public static final String INITIAL = "initial"; //$NON-NLS-1$
	
	/**
	 * Stereotype applied derived value expressions.
	 * 
	 * @see #getStereotype()
	 */
	public static final String DERIVATION = "derivation"; //$NON-NLS-1$
	
	/**
	 *
	 */
	String getInstanceVarName();
	
	void setInstanceVarName(String instanceVarName);
	
	/**
	 * @model type="ENamedElement" lowerBound=0
	 */
	EList getConstrainedElement();

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
	 * @see org.eclipse.emf.ocl.uml.UMLPackage#getConstraint_Stereotype()
	 * @model
	 * @generated
	 */
	String getStereotype();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.uml.Constraint#getStereotype <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype</em>' attribute.
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(String value);

	/**
	 * @model 
	 */
	OCLExpression getBody();
	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.uml.Constraint#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(OCLExpression value);

}
