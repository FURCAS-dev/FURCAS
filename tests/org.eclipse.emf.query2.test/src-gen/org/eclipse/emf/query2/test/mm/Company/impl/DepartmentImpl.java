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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Department</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.impl.DepartmentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.impl.DepartmentImpl#getMaxJuniors <em>Max Juniors</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.impl.DepartmentImpl#getBudget <em>Budget</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.impl.DepartmentImpl#getEmployee <em>Employee</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.impl.DepartmentImpl#getBoss <em>Boss</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.Company.impl.DepartmentImpl#getDivision <em>Division</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DepartmentImpl extends EObjectImpl implements Department {
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
	 * The default value of the '{@link #getMaxJuniors() <em>Max Juniors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxJuniors()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_JUNIORS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxJuniors() <em>Max Juniors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxJuniors()
	 * @generated
	 * @ordered
	 */
	protected int maxJuniors = MAX_JUNIORS_EDEFAULT;

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
	 * The cached value of the '{@link #getEmployee() <em>Employee</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmployee()
	 * @generated
	 * @ordered
	 */
	protected EList<Employee> employee;

	/**
	 * The cached value of the '{@link #getBoss() <em>Boss</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoss()
	 * @generated
	 * @ordered
	 */
	protected Employee boss;

	/**
	 * The cached value of the '{@link #getDivision() <em>Division</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDivision()
	 * @generated
	 * @ordered
	 */
	protected Division division;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DepartmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompanyPackage.Literals.DEPARTMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.DEPARTMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxJuniors() {
		return maxJuniors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxJuniors(int newMaxJuniors) {
		int oldMaxJuniors = maxJuniors;
		maxJuniors = newMaxJuniors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.DEPARTMENT__MAX_JUNIORS, oldMaxJuniors, maxJuniors));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.DEPARTMENT__BUDGET, oldBudget, budget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Employee> getEmployee() {
		if (employee == null) {
			employee = new EObjectWithInverseResolvingEList<Employee>(Employee.class, this, CompanyPackage.DEPARTMENT__EMPLOYEE, CompanyPackage.EMPLOYEE__EMPLOYER);
		}
		return employee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee getBoss() {
		if (boss != null && boss.eIsProxy()) {
			InternalEObject oldBoss = (InternalEObject)boss;
			boss = (Employee)eResolveProxy(oldBoss);
			if (boss != oldBoss) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompanyPackage.DEPARTMENT__BOSS, oldBoss, boss));
			}
		}
		return boss;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee basicGetBoss() {
		return boss;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBoss(Employee newBoss, NotificationChain msgs) {
		Employee oldBoss = boss;
		boss = newBoss;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompanyPackage.DEPARTMENT__BOSS, oldBoss, newBoss);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoss(Employee newBoss) {
		if (newBoss != boss) {
			NotificationChain msgs = null;
			if (boss != null)
				msgs = ((InternalEObject)boss).eInverseRemove(this, CompanyPackage.EMPLOYEE__MANAGED, Employee.class, msgs);
			if (newBoss != null)
				msgs = ((InternalEObject)newBoss).eInverseAdd(this, CompanyPackage.EMPLOYEE__MANAGED, Employee.class, msgs);
			msgs = basicSetBoss(newBoss, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.DEPARTMENT__BOSS, newBoss, newBoss));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Division getDivision() {
		if (division != null && division.eIsProxy()) {
			InternalEObject oldDivision = (InternalEObject)division;
			division = (Division)eResolveProxy(oldDivision);
			if (division != oldDivision) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompanyPackage.DEPARTMENT__DIVISION, oldDivision, division));
			}
		}
		return division;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Division basicGetDivision() {
		return division;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDivision(Division newDivision, NotificationChain msgs) {
		Division oldDivision = division;
		division = newDivision;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompanyPackage.DEPARTMENT__DIVISION, oldDivision, newDivision);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDivision(Division newDivision) {
		if (newDivision != division) {
			NotificationChain msgs = null;
			if (division != null)
				msgs = ((InternalEObject)division).eInverseRemove(this, CompanyPackage.DIVISION__DEPARTMENT, Division.class, msgs);
			if (newDivision != null)
				msgs = ((InternalEObject)newDivision).eInverseAdd(this, CompanyPackage.DIVISION__DEPARTMENT, Division.class, msgs);
			msgs = basicSetDivision(newDivision, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.DEPARTMENT__DIVISION, newDivision, newDivision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int calcExpenses() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case CompanyPackage.DEPARTMENT__EMPLOYEE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEmployee()).basicAdd(otherEnd, msgs);
			case CompanyPackage.DEPARTMENT__BOSS:
				if (boss != null)
					msgs = ((InternalEObject)boss).eInverseRemove(this, CompanyPackage.EMPLOYEE__MANAGED, Employee.class, msgs);
				return basicSetBoss((Employee)otherEnd, msgs);
			case CompanyPackage.DEPARTMENT__DIVISION:
				if (division != null)
					msgs = ((InternalEObject)division).eInverseRemove(this, CompanyPackage.DIVISION__DEPARTMENT, Division.class, msgs);
				return basicSetDivision((Division)otherEnd, msgs);
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
			case CompanyPackage.DEPARTMENT__EMPLOYEE:
				return ((InternalEList<?>)getEmployee()).basicRemove(otherEnd, msgs);
			case CompanyPackage.DEPARTMENT__BOSS:
				return basicSetBoss(null, msgs);
			case CompanyPackage.DEPARTMENT__DIVISION:
				return basicSetDivision(null, msgs);
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
			case CompanyPackage.DEPARTMENT__NAME:
				return getName();
			case CompanyPackage.DEPARTMENT__MAX_JUNIORS:
				return getMaxJuniors();
			case CompanyPackage.DEPARTMENT__BUDGET:
				return getBudget();
			case CompanyPackage.DEPARTMENT__EMPLOYEE:
				return getEmployee();
			case CompanyPackage.DEPARTMENT__BOSS:
				if (resolve) return getBoss();
				return basicGetBoss();
			case CompanyPackage.DEPARTMENT__DIVISION:
				if (resolve) return getDivision();
				return basicGetDivision();
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
			case CompanyPackage.DEPARTMENT__NAME:
				setName((String)newValue);
				return;
			case CompanyPackage.DEPARTMENT__MAX_JUNIORS:
				setMaxJuniors((Integer)newValue);
				return;
			case CompanyPackage.DEPARTMENT__BUDGET:
				setBudget((Integer)newValue);
				return;
			case CompanyPackage.DEPARTMENT__EMPLOYEE:
				getEmployee().clear();
				getEmployee().addAll((Collection<? extends Employee>)newValue);
				return;
			case CompanyPackage.DEPARTMENT__BOSS:
				setBoss((Employee)newValue);
				return;
			case CompanyPackage.DEPARTMENT__DIVISION:
				setDivision((Division)newValue);
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
			case CompanyPackage.DEPARTMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CompanyPackage.DEPARTMENT__MAX_JUNIORS:
				setMaxJuniors(MAX_JUNIORS_EDEFAULT);
				return;
			case CompanyPackage.DEPARTMENT__BUDGET:
				setBudget(BUDGET_EDEFAULT);
				return;
			case CompanyPackage.DEPARTMENT__EMPLOYEE:
				getEmployee().clear();
				return;
			case CompanyPackage.DEPARTMENT__BOSS:
				setBoss((Employee)null);
				return;
			case CompanyPackage.DEPARTMENT__DIVISION:
				setDivision((Division)null);
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
			case CompanyPackage.DEPARTMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CompanyPackage.DEPARTMENT__MAX_JUNIORS:
				return maxJuniors != MAX_JUNIORS_EDEFAULT;
			case CompanyPackage.DEPARTMENT__BUDGET:
				return budget != BUDGET_EDEFAULT;
			case CompanyPackage.DEPARTMENT__EMPLOYEE:
				return employee != null && !employee.isEmpty();
			case CompanyPackage.DEPARTMENT__BOSS:
				return boss != null;
			case CompanyPackage.DEPARTMENT__DIVISION:
				return division != null;
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
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", maxJuniors: "); //$NON-NLS-1$
		result.append(maxJuniors);
		result.append(", budget: "); //$NON-NLS-1$
		result.append(budget);
		result.append(')');
		return result.toString();
	}

} //DepartmentImpl
