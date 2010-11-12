/**
 * <copyright>
 * 
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: EmployeeImpl.java,v 1.3 2010/08/24 16:16:55 ewillink Exp $
 */
package company.impl;

import company.Company;
import company.CompanyPackage;
import company.Employee;

import company.util.CompanyValidator;

import java.lang.reflect.InvocationTargetException;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Employee</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link company.impl.EmployeeImpl#getName <em>Name</em>}</li>
 *   <li>{@link company.impl.EmployeeImpl#getManager <em>Manager</em>}</li>
 *   <li>{@link company.impl.EmployeeImpl#getCompany <em>Company</em>}</li>
 *   <li>{@link company.impl.EmployeeImpl#getDirectReports <em>Direct Reports</em>}</li>
 *   <li>{@link company.impl.EmployeeImpl#getAllReports <em>All Reports</em>}</li>
 *   <li>{@link company.impl.EmployeeImpl#getReportingChain <em>Reporting Chain</em>}</li>
 *   <li>{@link company.impl.EmployeeImpl#isHasNameAsAttribute <em>Has Name As Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmployeeImpl extends EObjectImpl implements Employee {
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
	 * The cached value of the '{@link #getManager() <em>Manager</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManager()
	 * @generated
	 * @ordered
	 */
	protected Employee manager;

	/**
	 * The cached setting delegate for the '{@link #getDirectReports() <em>Direct Reports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectReports()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate DIRECT_REPORTS__ESETTING_DELEGATE = ((EStructuralFeature.Internal)CompanyPackage.Literals.EMPLOYEE__DIRECT_REPORTS).getSettingDelegate();

	/**
	 * The cached setting delegate for the '{@link #getAllReports() <em>All Reports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllReports()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate ALL_REPORTS__ESETTING_DELEGATE = ((EStructuralFeature.Internal)CompanyPackage.Literals.EMPLOYEE__ALL_REPORTS).getSettingDelegate();

	/**
	 * The cached setting delegate for the '{@link #getReportingChain() <em>Reporting Chain</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReportingChain()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate REPORTING_CHAIN__ESETTING_DELEGATE = ((EStructuralFeature.Internal)CompanyPackage.Literals.EMPLOYEE__REPORTING_CHAIN).getSettingDelegate();

	/**
	 * The cached setting delegate for the '{@link #isHasNameAsAttribute() <em>Has Name As Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasNameAsAttribute()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate HAS_NAME_AS_ATTRIBUTE__ESETTING_DELEGATE = ((EStructuralFeature.Internal)CompanyPackage.Literals.EMPLOYEE__HAS_NAME_AS_ATTRIBUTE).getSettingDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EmployeeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompanyPackage.Literals.EMPLOYEE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.EMPLOYEE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee getManager() {
		if (manager != null && manager.eIsProxy()) {
			InternalEObject oldManager = (InternalEObject)manager;
			manager = (Employee)eResolveProxy(oldManager);
			if (manager != oldManager) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompanyPackage.EMPLOYEE__MANAGER, oldManager, manager));
			}
		}
		return manager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Employee basicGetManager() {
		return manager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManager(Employee newManager) {
		Employee oldManager = manager;
		manager = newManager;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.EMPLOYEE__MANAGER, oldManager, manager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Company getCompany() {
		if (eContainerFeatureID() != CompanyPackage.EMPLOYEE__COMPANY) return null;
		return (Company)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompany(Company newCompany, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCompany, CompanyPackage.EMPLOYEE__COMPANY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompany(Company newCompany) {
		if (newCompany != eInternalContainer() || (eContainerFeatureID() != CompanyPackage.EMPLOYEE__COMPANY && newCompany != null)) {
			if (EcoreUtil.isAncestor(this, newCompany))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCompany != null)
				msgs = ((InternalEObject)newCompany).eInverseAdd(this, CompanyPackage.COMPANY__EMPLOYEES, Company.class, msgs);
			msgs = basicSetCompany(newCompany, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.EMPLOYEE__COMPANY, newCompany, newCompany));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Employee> getDirectReports() {
		return (EList<Employee>)DIRECT_REPORTS__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Employee> getAllReports() {
		return (EList<Employee>)ALL_REPORTS__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Employee> getReportingChain() {
		return (EList<Employee>)REPORTING_CHAIN__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasNameAsAttribute() {
		return (Boolean)HAS_NAME_AS_ATTRIBUTE__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * The cached invocation delegate for the '{@link #reportsTo(company.Employee) <em>Reports To</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #reportsTo(company.Employee)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate REPORTS_TO_EMPLOYEE__EINVOCATION_DELEGATE = ((EOperation.Internal)CompanyPackage.Literals.EMPLOYEE___REPORTS_TO__EMPLOYEE).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean reportsTo(Employee manager) {
		try {
			return (Boolean)REPORTS_TO_EMPLOYEE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{manager}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached validation expression for the '{@link #noManagerImpliesDirectReports(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>No Manager Implies Direct Reports</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #noManagerImpliesDirectReports(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NO_MANAGER_IMPLIES_DIRECT_REPORTS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "manager.oclIsUndefined() implies directReports->size() > 0"; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean noManagerImpliesDirectReports(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			CompanyValidator.validate
				(CompanyPackage.Literals.EMPLOYEE,
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL", //$NON-NLS-1$
				 CompanyPackage.Literals.EMPLOYEE___NO_MANAGER_IMPLIES_DIRECT_REPORTS__DIAGNOSTICCHAIN_MAP,
				 NO_MANAGER_IMPLIES_DIRECT_REPORTS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 CompanyValidator.DIAGNOSTIC_SOURCE,
				 CompanyValidator.EMPLOYEE__NO_MANAGER_IMPLIES_DIRECT_REPORTS);
	}

	/**
	 * The cached invocation delegate for the '{@link #hasNameAsOperation() <em>Has Name As Operation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #hasNameAsOperation()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate HAS_NAME_AS_OPERATION__EINVOCATION_DELEGATE = ((EOperation.Internal)CompanyPackage.Literals.EMPLOYEE___HAS_NAME_AS_OPERATION).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean hasNameAsOperation() {
		try {
			return (Boolean)HAS_NAME_AS_OPERATION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompanyPackage.EMPLOYEE__COMPANY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCompany((Company)otherEnd, msgs);
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
			case CompanyPackage.EMPLOYEE__COMPANY:
				return basicSetCompany(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CompanyPackage.EMPLOYEE__COMPANY:
				return eInternalContainer().eInverseRemove(this, CompanyPackage.COMPANY__EMPLOYEES, Company.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CompanyPackage.EMPLOYEE__NAME:
				return getName();
			case CompanyPackage.EMPLOYEE__MANAGER:
				if (resolve) return getManager();
				return basicGetManager();
			case CompanyPackage.EMPLOYEE__COMPANY:
				return getCompany();
			case CompanyPackage.EMPLOYEE__DIRECT_REPORTS:
				return getDirectReports();
			case CompanyPackage.EMPLOYEE__ALL_REPORTS:
				return getAllReports();
			case CompanyPackage.EMPLOYEE__REPORTING_CHAIN:
				return getReportingChain();
			case CompanyPackage.EMPLOYEE__HAS_NAME_AS_ATTRIBUTE:
				return isHasNameAsAttribute();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CompanyPackage.EMPLOYEE__NAME:
				setName((String)newValue);
				return;
			case CompanyPackage.EMPLOYEE__MANAGER:
				setManager((Employee)newValue);
				return;
			case CompanyPackage.EMPLOYEE__COMPANY:
				setCompany((Company)newValue);
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
			case CompanyPackage.EMPLOYEE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CompanyPackage.EMPLOYEE__MANAGER:
				setManager((Employee)null);
				return;
			case CompanyPackage.EMPLOYEE__COMPANY:
				setCompany((Company)null);
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
			case CompanyPackage.EMPLOYEE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CompanyPackage.EMPLOYEE__MANAGER:
				return manager != null;
			case CompanyPackage.EMPLOYEE__COMPANY:
				return getCompany() != null;
			case CompanyPackage.EMPLOYEE__DIRECT_REPORTS:
				return DIRECT_REPORTS__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case CompanyPackage.EMPLOYEE__ALL_REPORTS:
				return ALL_REPORTS__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case CompanyPackage.EMPLOYEE__REPORTING_CHAIN:
				return REPORTING_CHAIN__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case CompanyPackage.EMPLOYEE__HAS_NAME_AS_ATTRIBUTE:
				return HAS_NAME_AS_ATTRIBUTE__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case CompanyPackage.EMPLOYEE___REPORTS_TO__EMPLOYEE:
				return reportsTo((Employee)arguments.get(0));
			case CompanyPackage.EMPLOYEE___NO_MANAGER_IMPLIES_DIRECT_REPORTS__DIAGNOSTICCHAIN_MAP:
				return noManagerImpliesDirectReports((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case CompanyPackage.EMPLOYEE___HAS_NAME_AS_OPERATION:
				return hasNameAsOperation();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(')');
		return result.toString();
	}

} //EmployeeImpl
