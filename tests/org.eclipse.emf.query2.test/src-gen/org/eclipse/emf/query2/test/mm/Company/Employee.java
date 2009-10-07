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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.Employee#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.Employee#getAge <em>Age</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.Employee#getSalary <em>Salary</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.Employee#getEmployer <em>Employer</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.Employee#getManaged <em>Managed</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.Employee#getDirected <em>Directed</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.Employee#getSecretary <em>Secretary</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getEmployee()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/test/company[1.0.0]' metaObject='Company.Employee' metaObjectMofId='473C6EB6D6B7E0D6939411DC9D9E00199904B925' isStructureType='false' ova='secretary'"
 * @generated
 */
public interface Employee extends EObject {
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
	 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getEmployee_Name()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.Company.Employee#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Age</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Age</em>' attribute.
	 * @see #setAge(int)
	 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getEmployee_Age()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int getAge();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.Company.Employee#getAge <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Age</em>' attribute.
	 * @see #getAge()
	 * @generated
	 */
	void setAge(int value);

	/**
	 * Returns the value of the '<em><b>Salary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Salary</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Salary</em>' attribute.
	 * @see #setSalary(int)
	 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getEmployee_Salary()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int getSalary();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.Company.Employee#getSalary <em>Salary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Salary</em>' attribute.
	 * @see #getSalary()
	 * @generated
	 */
	void setSalary(int value);

	/**
	 * Returns the value of the '<em><b>Employer</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.query2.test.mm.Company.Department#getEmployee <em>Employee</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Employer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Employer</em>' reference.
	 * @see #setEmployer(Department)
	 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getEmployee_Employer()
	 * @see org.eclipse.emf.query2.test.mm.Company.Department#getEmployee
	 * @model opposite="employee" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/test/company[1.0.0]' metaObject='Company.WorksIn' metaObjectMofId='473C6EB6D6B7E0F1939411DCB3E500199904B925' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	Department getEmployer();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.Company.Employee#getEmployer <em>Employer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Employer</em>' reference.
	 * @see #getEmployer()
	 * @generated
	 */
	void setEmployer(Department value);

	/**
	 * Returns the value of the '<em><b>Managed</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.query2.test.mm.Company.Department#getBoss <em>Boss</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Managed</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Managed</em>' reference.
	 * @see #setManaged(Department)
	 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getEmployee_Managed()
	 * @see org.eclipse.emf.query2.test.mm.Company.Department#getBoss
	 * @model opposite="boss" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/test/company[1.0.0]' metaObject='Company.Manages' metaObjectMofId='473C6EB6D6B7E0F4939411DC9A9200199904B925' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	Department getManaged();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.Company.Employee#getManaged <em>Managed</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Managed</em>' reference.
	 * @see #getManaged()
	 * @generated
	 */
	void setManaged(Department value);

	/**
	 * Returns the value of the '<em><b>Directed</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.query2.test.mm.Company.Division#getDirector <em>Director</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Directed</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Directed</em>' reference.
	 * @see #setDirected(Division)
	 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getEmployee_Directed()
	 * @see org.eclipse.emf.query2.test.mm.Company.Division#getDirector
	 * @model opposite="director" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/test/company[1.0.0]' metaObject='Company.Directs' metaObjectMofId='473C6EB6D6BA51D0939411DCBE8300199904B925' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	Division getDirected();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.Company.Employee#getDirected <em>Directed</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Directed</em>' reference.
	 * @see #getDirected()
	 * @generated
	 */
	void setDirected(Division value);

	/**
	 * Returns the value of the '<em><b>Secretary</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secretary</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secretary</em>' containment reference.
	 * @see #setSecretary(Employee)
	 * @see org.eclipse.emf.query2.test.mm.Company.CompanyPackage#getEmployee_Secretary()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='473C6EB6D6B7E0D5939411DCB2A400199904B925'"
	 * @generated
	 */
	Employee getSecretary();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.Company.Employee#getSecretary <em>Secretary</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secretary</em>' containment reference.
	 * @see #getSecretary()
	 * @generated
	 */
	void setSecretary(Employee value);

} // Employee
