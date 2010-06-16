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

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
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
 *   <li>{@link company.impl.DepartmentImpl#getSubDepartment <em>Sub Department</em>}</li>
 *   <li>{@link company.impl.DepartmentImpl#getParentDepartment <em>Parent Department</em>}</li>
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
	 * The cached value of the '{@link #getSubDepartment() <em>Sub Department</em>}' reference list.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getSubDepartment()
	 * @generated
	 * @ordered
	 */
        protected EList<Department> subDepartment;

                                /**
	 * The cached value of the '{@link #getParentDepartment() <em>Parent Department</em>}' reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getParentDepartment()
	 * @generated
	 * @ordered
	 */
        protected Department parentDepartment;

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
        public EList<Department> getSubDepartment() {
		if (subDepartment == null) {
			subDepartment = new EObjectWithInverseEList<Department>(Department.class, this, CompanyPackage.DEPARTMENT__SUB_DEPARTMENT, CompanyPackage.DEPARTMENT__PARENT_DEPARTMENT);
		}
		return subDepartment;
	}

/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public Department getParentDepartment() {
		return parentDepartment;
	}

/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public NotificationChain basicSetParentDepartment(Department newParentDepartment, NotificationChain msgs) {
		Department oldParentDepartment = parentDepartment;
		parentDepartment = newParentDepartment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompanyPackage.DEPARTMENT__PARENT_DEPARTMENT, oldParentDepartment, newParentDepartment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

/**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setParentDepartment(Department newParentDepartment) {
		if (newParentDepartment != parentDepartment) {
			NotificationChain msgs = null;
			if (parentDepartment != null)
				msgs = ((InternalEObject)parentDepartment).eInverseRemove(this, CompanyPackage.DEPARTMENT__SUB_DEPARTMENT, Department.class, msgs);
			if (newParentDepartment != null)
				msgs = ((InternalEObject)newParentDepartment).eInverseAdd(this, CompanyPackage.DEPARTMENT__SUB_DEPARTMENT, Department.class, msgs);
			msgs = basicSetParentDepartment(newParentDepartment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.DEPARTMENT__PARENT_DEPARTMENT, newParentDepartment, newParentDepartment));
	}

/**
	 * The cached invocation delegate for the '{@link #calcExpenses() <em>Calc Expenses</em>}' operation.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #calcExpenses()
	 * @generated
	 * @ordered
	 */
    protected static final EOperation.Internal.InvocationDelegate CALC_EXPENSES__EINVOCATION_DELEGATE = ((EOperation.Internal)CompanyPackage.Literals.DEPARTMENT.getEOperations().get(0)).getInvocationDelegate();

/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public int calcExpenses() {
		try {
			return (Integer)CALC_EXPENSES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

    /**
	 * The cached invocation delegate for the '{@link #sumBudget() <em>Sum Budget</em>}' operation.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #sumBudget()
	 * @generated
	 * @ordered
	 */
    protected static final EOperation.Internal.InvocationDelegate SUM_BUDGET__EINVOCATION_DELEGATE = ((EOperation.Internal)CompanyPackage.Literals.DEPARTMENT.getEOperations().get(1)).getInvocationDelegate();

    /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public int sumBudget() {
		try {
			return (Integer)SUM_BUDGET__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
			case CompanyPackage.DEPARTMENT__SUB_DEPARTMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubDepartment()).basicAdd(otherEnd, msgs);
			case CompanyPackage.DEPARTMENT__PARENT_DEPARTMENT:
				if (parentDepartment != null)
					msgs = ((InternalEObject)parentDepartment).eInverseRemove(this, CompanyPackage.DEPARTMENT__SUB_DEPARTMENT, Department.class, msgs);
				return basicSetParentDepartment((Department)otherEnd, msgs);
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
			case CompanyPackage.DEPARTMENT__SUB_DEPARTMENT:
				return ((InternalEList<?>)getSubDepartment()).basicRemove(otherEnd, msgs);
			case CompanyPackage.DEPARTMENT__PARENT_DEPARTMENT:
				return basicSetParentDepartment(null, msgs);
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
			case CompanyPackage.DEPARTMENT__SUB_DEPARTMENT:
				return getSubDepartment();
			case CompanyPackage.DEPARTMENT__PARENT_DEPARTMENT:
				return getParentDepartment();
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
			case CompanyPackage.DEPARTMENT__SUB_DEPARTMENT:
				getSubDepartment().clear();
				getSubDepartment().addAll((Collection<? extends Department>)newValue);
				return;
			case CompanyPackage.DEPARTMENT__PARENT_DEPARTMENT:
				setParentDepartment((Department)newValue);
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
			case CompanyPackage.DEPARTMENT__SUB_DEPARTMENT:
				getSubDepartment().clear();
				return;
			case CompanyPackage.DEPARTMENT__PARENT_DEPARTMENT:
				setParentDepartment((Department)null);
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
			case CompanyPackage.DEPARTMENT__SUB_DEPARTMENT:
				return subDepartment != null && !subDepartment.isEmpty();
			case CompanyPackage.DEPARTMENT__PARENT_DEPARTMENT:
				return parentDepartment != null;
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
