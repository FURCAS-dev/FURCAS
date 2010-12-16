/**
 * /*******************************************************************************
 *  * Copyright (c) 2006, 2009 SAP AG and others.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *  * Contributors:
 *  *     SAP AG - initial API and implementation
 *  ******************************************************************************/
 
package org.eclipse.emf.query2.test.mm.Company;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Division</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.Division#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.Division#getDepartment <em>Department</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.Division#getDirector <em>Director</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.Division#getBudget <em>Budget</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.Division#getCommuting <em>Commuting</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getDivision()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/test/company[1.0.0]' metaObject='Company.Division' metaObjectMofId='473C6EB6D6B7E0EE939411DCC52900199904B925' isStructureType='false'"
 * @generated
 */
public interface Division extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getDivision_Name()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.Company.Division#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Department</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.Company.Department}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.query2.test.mm.Company.Department#getDivision <em>Division</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Department</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Department</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getDivision_Department()
	 * @see org.eclipse.emf.query2.test.mm.Company.Department#getDivision
	 * @model opposite="division" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/test/company[1.0.0]' metaObject='Company.Divides' metaObjectMofId='473C6EB6D6B7E0F7939411DC867200199904B925' storedEnd='1' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	EList<Department> getDepartment();

	/**
	 * Returns the value of the '<em><b>Director</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.query2.test.mm.Company.Employee#getDirected <em>Directed</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Director</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Director</em>' reference.
	 * @see #setDirector(Employee)
	 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getDivision_Director()
	 * @see org.eclipse.emf.query2.test.mm.Company.Employee#getDirected
	 * @model opposite="directed" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/test/company[1.0.0]' metaObject='Company.Directs' metaObjectMofId='473C6EB6D6BA51D0939411DCBE8300199904B925' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	Employee getDirector();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.Company.Division#getDirector <em>Director</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Director</em>' reference.
	 * @see #getDirector()
	 * @generated
	 */
	void setDirector(Employee value);

	/**
	 * Returns the value of the '<em><b>Budget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Budget</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Budget</em>' attribute.
	 * @see #setBudget(int)
	 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getDivision_Budget()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int getBudget();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.Company.Division#getBudget <em>Budget</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Budget</em>' attribute.
	 * @see #getBudget()
	 * @generated
	 */
	void setBudget(int value);

	/**
	 * Returns the value of the '<em><b>Commuting</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Commuting</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commuting</em>' reference.
	 * @see #setCommuting(Transport)
	 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getDivision_Commuting()
	 * @model
	 * @generated
	 */
	Transport getCommuting();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.Company.Division#getCommuting <em>Commuting</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Commuting</em>' reference.
	 * @see #getCommuting()
	 * @generated
	 */
	void setCommuting(Transport value);

} // Division
