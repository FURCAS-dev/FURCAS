/**
 * <copyright>
 *
 * Copyright (c) 2002-2004 IBM Corporation and others.
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
 * $Id: FunctionPair.java,v 1.4 2008/05/04 17:03:16 emerks Exp $
 */
package org.eclipse.emf.mapping;


import org.eclipse.emf.ecore.EOperation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Pair</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.mapping.FunctionPair#getIn2out <em>In2out</em>}</li>
 *   <li>{@link org.eclipse.emf.mapping.FunctionPair#getOut2in <em>Out2in</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.mapping.MappingPackage#getFunctionPair()
 * @model
 * @generated
 */
public interface FunctionPair extends TypeConverter
{
  /**
   * Returns the value of the '<em><b>In2out</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>In2out</em>' reference.
   * @see #setIn2out(EOperation)
   * @see org.eclipse.emf.mapping.MappingPackage#getFunctionPair_In2out()
   * @model
   * @generated
   */
  EOperation getIn2out();

  /**
   * Sets the value of the '{@link org.eclipse.emf.mapping.FunctionPair#getIn2out <em>In2out</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>In2out</em>' reference.
   * @see #getIn2out()
   * @generated
   */
  void setIn2out(EOperation value);

  /**
   * Returns the value of the '<em><b>Out2in</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Out2in</em>' reference.
   * @see #setOut2in(EOperation)
   * @see org.eclipse.emf.mapping.MappingPackage#getFunctionPair_Out2in()
   * @model
   * @generated
   */
  EOperation getOut2in();

  /**
   * Sets the value of the '{@link org.eclipse.emf.mapping.FunctionPair#getOut2in <em>Out2in</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Out2in</em>' reference.
   * @see #getOut2in()
   * @generated
   */
  void setOut2in(EOperation value);

} // FunctionPair
