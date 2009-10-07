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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Department</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.Department#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.Department#getMaxJuniors <em>Max Juniors</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.Department#getBudget <em>Budget</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.Department#getEmployee <em>Employee</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.Department#getBoss <em>Boss</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.Department#getDivision <em>Division</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getDepartment()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/test/company[1.0.0]' metaObject='Company.Department' metaObjectMofId='473C6EB6D6B7E0E1939411DCA5E700199904B925' isStructureType='false'"
 * @generated
 */
public interface Department extends EObject {
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
	 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getDepartment_Name()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.Company.Department#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Max Juniors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Juniors</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Juniors</em>' attribute.
	 * @see #setMaxJuniors(int)
	 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getDepartment_MaxJuniors()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int getMaxJuniors();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.Company.Department#getMaxJuniors <em>Max Juniors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Juniors</em>' attribute.
	 * @see #getMaxJuniors()
	 * @generated
	 */
	void setMaxJuniors(int value);

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
	 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getDepartment_Budget()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int getBudget();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.Company.Department#getBudget <em>Budget</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Budget</em>' attribute.
	 * @see #getBudget()
	 * @generated
	 */
	void setBudget(int value);

	/**
	 * Returns the value of the '<em><b>Employee</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.Company.Employee}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.query2.test.mm.Company.Employee#getEmployer <em>Employer</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Employee</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Employee</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getDepartment_Employee()
	 * @see org.eclipse.emf.query2.test.mm.Company.Employee#getEmployer
	 * @model opposite="employer" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/test/company[1.0.0]' metaObject='Company.WorksIn' metaObjectMofId='473C6EB6D6B7E0F1939411DCB3E500199904B925' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	EList<Employee> getEmployee();

	/**
	 * Returns the value of the '<em><b>Boss</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.query2.test.mm.Company.Employee#getManaged <em>Managed</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boss</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boss</em>' reference.
	 * @see #setBoss(Employee)
	 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getDepartment_Boss()
	 * @see org.eclipse.emf.query2.test.mm.Company.Employee#getManaged
	 * @model opposite="managed" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/test/company[1.0.0]' metaObject='Company.Manages' metaObjectMofId='473C6EB6D6B7E0F4939411DC9A9200199904B925' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	Employee getBoss();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.Company.Department#getBoss <em>Boss</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boss</em>' reference.
	 * @see #getBoss()
	 * @generated
	 */
	void setBoss(Employee value);

	/**
	 * Returns the value of the '<em><b>Division</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.query2.test.mm.Company.Division#getDepartment <em>Department</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Division</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Division</em>' reference.
	 * @see #setDivision(Division)
	 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getDepartment_Division()
	 * @see org.eclipse.emf.query2.test.mm.Company.Division#getDepartment
	 * @model opposite="department"
	 * @generated
	 */
	Division getDivision();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.Company.Department#getDivision <em>Division</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Division</em>' reference.
	 * @see #getDivision()
	 * @generated
	 */
	void setDivision(Division value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int calcExpenses();

} // Department
