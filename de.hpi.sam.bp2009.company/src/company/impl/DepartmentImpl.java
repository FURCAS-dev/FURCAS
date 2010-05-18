/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package company.impl;

import company.CompanyPackage;
import company.Department;
import company.Employee;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Department</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link company.impl.DepartmentImpl#getName <em>Name</em>}</li>
 *   <li>{@link company.impl.DepartmentImpl#getMaxJuniors <em>Max Juniors</em>}</li>
 *   <li>{@link company.impl.DepartmentImpl#getBudget <em>Budget</em>}</li>
 *   <li>{@link company.impl.DepartmentImpl#getEmployee <em>Employee</em>}</li>
 *   <li>{@link company.impl.DepartmentImpl#getBoss <em>Boss</em>}</li>
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
    protected static final long MAX_JUNIORS_EDEFAULT = 0L;

    /**
	 * The cached value of the '{@link #getMaxJuniors() <em>Max Juniors</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getMaxJuniors()
	 * @generated
	 * @ordered
	 */
    protected long maxJuniors = MAX_JUNIORS_EDEFAULT;

    /**
	 * The default value of the '{@link #getBudget() <em>Budget</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getBudget()
	 * @generated
	 * @ordered
	 */
    protected static final long BUDGET_EDEFAULT = 0L;

    /**
	 * The cached value of the '{@link #getBudget() <em>Budget</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getBudget()
	 * @generated
	 * @ordered
	 */
    protected long budget = BUDGET_EDEFAULT;

    /**
	 * The cached value of the '{@link #getEmployee() <em>Employee</em>}' containment reference list.
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
    public long getMaxJuniors() {
		return maxJuniors;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setMaxJuniors(long newMaxJuniors) {
		long oldMaxJuniors = maxJuniors;
		maxJuniors = newMaxJuniors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.DEPARTMENT__MAX_JUNIORS, oldMaxJuniors, maxJuniors));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public long getBudget() {
		return budget;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setBudget(long newBudget) {
		long oldBudget = budget;
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
			employee = new EObjectContainmentWithInverseEList<Employee>(Employee.class, this, CompanyPackage.DEPARTMENT__EMPLOYEE, CompanyPackage.EMPLOYEE__EMPLOYER);
		}
		return employee;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Employee getBoss() {
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
    public long calcExpenses() {
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
				return getBoss();
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
				setMaxJuniors((Long)newValue);
				return;
			case CompanyPackage.DEPARTMENT__BUDGET:
				setBudget((Long)newValue);
				return;
			case CompanyPackage.DEPARTMENT__EMPLOYEE:
				getEmployee().clear();
				getEmployee().addAll((Collection<? extends Employee>)newValue);
				return;
			case CompanyPackage.DEPARTMENT__BOSS:
				setBoss((Employee)newValue);
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
		result.append(", maxJuniors: ");
		result.append(maxJuniors);
		result.append(", budget: ");
		result.append(budget);
		result.append(')');
		return result.toString();
	}

} //DepartmentImpl
