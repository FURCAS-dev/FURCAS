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
 
package org.eclipse.emf.query2.test.mm.Company.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.query2.test.mm.Company.CompanyPackage;
import org.eclipse.emf.query2.test.mm.Company.Department;
import org.eclipse.emf.query2.test.mm.Company.Division;
import org.eclipse.emf.query2.test.mm.Company.Employee;
import org.eclipse.emf.query2.test.mm.Company.Transport;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Division</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.impl.DivisionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.impl.DivisionImpl#getDepartment <em>Department</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.impl.DivisionImpl#getDirector <em>Director</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.impl.DivisionImpl#getBudget <em>Budget</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.impl.DivisionImpl#getCommuting <em>Commuting</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DivisionImpl extends EObjectImpl implements Division {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDepartment() <em>Department</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartment()
	 * @generated
	 * @ordered
	 */
	protected EList<Department> department;

	/**
	 * The cached value of the '{@link #getDirector() <em>Director</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirector()
	 * @generated
	 * @ordered
	 */
	protected Employee director;

	/**
	 * The default value of the '{@link #getBudget() <em>Budget</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBudget()
	 * @generated
	 * @ordered
	 */
	protected static final int BUDGET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBudget() <em>Budget</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBudget()
	 * @generated
	 * @ordered
	 */
	protected int budget = BUDGET_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCommuting() <em>Commuting</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommuting()
	 * @generated
	 * @ordered
	 */
	protected Transport commuting;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DivisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompanyPackage.Literals.DIVISION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.DIVISION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Department> getDepartment() {
		if (department == null) {
			department = new EObjectWithInverseResolvingEList<Department>(Department.class, this, CompanyPackage.DIVISION__DEPARTMENT, CompanyPackage.DEPARTMENT__DIVISION);
		}
		return department;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee getDirector() {
		if (director != null && director.eIsProxy()) {
			InternalEObject oldDirector = (InternalEObject)director;
			director = (Employee)eResolveProxy(oldDirector);
			if (director != oldDirector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompanyPackage.DIVISION__DIRECTOR, oldDirector, director));
			}
		}
		return director;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee basicGetDirector() {
		return director;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDirector(Employee newDirector, NotificationChain msgs) {
		Employee oldDirector = director;
		director = newDirector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompanyPackage.DIVISION__DIRECTOR, oldDirector, newDirector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirector(Employee newDirector) {
		if (newDirector != director) {
			NotificationChain msgs = null;
			if (director != null)
				msgs = ((InternalEObject)director).eInverseRemove(this, CompanyPackage.EMPLOYEE__DIRECTED, Employee.class, msgs);
			if (newDirector != null)
				msgs = ((InternalEObject)newDirector).eInverseAdd(this, CompanyPackage.EMPLOYEE__DIRECTED, Employee.class, msgs);
			msgs = basicSetDirector(newDirector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.DIVISION__DIRECTOR, newDirector, newDirector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBudget() {
		return budget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBudget(int newBudget) {
		int oldBudget = budget;
		budget = newBudget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.DIVISION__BUDGET, oldBudget, budget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transport getCommuting() {
		if (commuting != null && commuting.eIsProxy()) {
			InternalEObject oldCommuting = (InternalEObject)commuting;
			commuting = (Transport)eResolveProxy(oldCommuting);
			if (commuting != oldCommuting) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompanyPackage.DIVISION__COMMUTING, oldCommuting, commuting));
			}
		}
		return commuting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transport basicGetCommuting() {
		return commuting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommuting(Transport newCommuting) {
		Transport oldCommuting = commuting;
		commuting = newCommuting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.DIVISION__COMMUTING, oldCommuting, commuting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompanyPackage.DIVISION__DEPARTMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDepartment()).basicAdd(otherEnd, msgs);
			case CompanyPackage.DIVISION__DIRECTOR:
				if (director != null)
					msgs = ((InternalEObject)director).eInverseRemove(this, CompanyPackage.EMPLOYEE__DIRECTED, Employee.class, msgs);
				return basicSetDirector((Employee)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompanyPackage.DIVISION__DEPARTMENT:
				return ((InternalEList<?>)getDepartment()).basicRemove(otherEnd, msgs);
			case CompanyPackage.DIVISION__DIRECTOR:
				return basicSetDirector(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CompanyPackage.DIVISION__NAME:
				return getName();
			case CompanyPackage.DIVISION__DEPARTMENT:
				return getDepartment();
			case CompanyPackage.DIVISION__DIRECTOR:
				if (resolve) return getDirector();
				return basicGetDirector();
			case CompanyPackage.DIVISION__BUDGET:
				return getBudget();
			case CompanyPackage.DIVISION__COMMUTING:
				if (resolve) return getCommuting();
				return basicGetCommuting();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CompanyPackage.DIVISION__NAME:
				setName((String)newValue);
				return;
			case CompanyPackage.DIVISION__DEPARTMENT:
				getDepartment().clear();
				getDepartment().addAll((Collection<? extends Department>)newValue);
				return;
			case CompanyPackage.DIVISION__DIRECTOR:
				setDirector((Employee)newValue);
				return;
			case CompanyPackage.DIVISION__BUDGET:
				setBudget((Integer)newValue);
				return;
			case CompanyPackage.DIVISION__COMMUTING:
				setCommuting((Transport)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CompanyPackage.DIVISION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CompanyPackage.DIVISION__DEPARTMENT:
				getDepartment().clear();
				return;
			case CompanyPackage.DIVISION__DIRECTOR:
				setDirector((Employee)null);
				return;
			case CompanyPackage.DIVISION__BUDGET:
				setBudget(BUDGET_EDEFAULT);
				return;
			case CompanyPackage.DIVISION__COMMUTING:
				setCommuting((Transport)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CompanyPackage.DIVISION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CompanyPackage.DIVISION__DEPARTMENT:
				return department != null && !department.isEmpty();
			case CompanyPackage.DIVISION__DIRECTOR:
				return director != null;
			case CompanyPackage.DIVISION__BUDGET:
				return budget != BUDGET_EDEFAULT;
			case CompanyPackage.DIVISION__COMMUTING:
				return commuting != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", budget: ");
		result.append(budget);
		result.append(')');
		return result.toString();
	}

} //DivisionImpl
