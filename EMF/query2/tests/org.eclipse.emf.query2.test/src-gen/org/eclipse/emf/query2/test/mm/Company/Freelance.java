/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.test.mm.Company;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Freelance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.Freelance#getAssignment <em>Assignment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getFreelance()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/test/company[1.0.0]' metaObject='Company.Freelance' metaObjectMofId='473C6EB6D6B7E0E7939411DC988800199904B925' isStructureType='false' ova='secretary'"
 * @generated
 */
public interface Freelance extends Employee {
	/**
	 * Returns the value of the '<em><b>Assignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignment</em>' attribute.
	 * @see #setAssignment(int)
	 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getFreelance_Assignment()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int getAssignment();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.Company.Freelance#getAssignment <em>Assignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assignment</em>' attribute.
	 * @see #getAssignment()
	 * @generated
	 */
	void setAssignment(int value);

} // Freelance
