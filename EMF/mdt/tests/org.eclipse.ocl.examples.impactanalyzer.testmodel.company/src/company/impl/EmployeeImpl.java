/**
 * <copyright>
 * </copyright>
 *
 * $Id: EmployeeImpl.java,v 1.1 2011/01/20 15:52:51 auhl Exp $
 */
package company.impl;

import company.CompanyPackage;
import company.Department;
import company.Division;
import company.Employee;

import company.Student;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
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
 *   <li>{@link company.impl.EmployeeImpl#getAge <em>Age</em>}</li>
 *   <li>{@link company.impl.EmployeeImpl#getSalary <em>Salary</em>}</li>
 *   <li>{@link company.impl.EmployeeImpl#getEmployer <em>Employer</em>}</li>
 *   <li>{@link company.impl.EmployeeImpl#getManaged <em>Managed</em>}</li>
 *   <li>{@link company.impl.EmployeeImpl#getDirected <em>Directed</em>}</li>
 *   <li>{@link company.impl.EmployeeImpl#getSecretary <em>Secretary</em>}</li>
 *   <li>{@link company.impl.EmployeeImpl#getIntern <em>Intern</em>}</li>
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
     * The default value of the '{@link #getAge() <em>Age</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAge()
     * @generated
     * @ordered
     */
    protected static final int AGE_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getAge() <em>Age</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAge()
     * @generated
     * @ordered
     */
    protected int age = AGE_EDEFAULT;

    /**
     * The default value of the '{@link #getSalary() <em>Salary</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSalary()
     * @generated
     * @ordered
     */
    protected static final int SALARY_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getSalary() <em>Salary</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSalary()
     * @generated
     * @ordered
     */
    protected int salary = SALARY_EDEFAULT;

    /**
     * The cached value of the '{@link #getManaged() <em>Managed</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getManaged()
     * @generated
     * @ordered
     */
    protected Department managed;

    /**
     * The cached value of the '{@link #getSecretary() <em>Secretary</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSecretary()
     * @generated
     * @ordered
     */
    protected Employee secretary;

    /**
     * The cached value of the '{@link #getIntern() <em>Intern</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIntern()
     * @generated
     * @ordered
     */
    protected Student intern;

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
    public int getAge() {
        return age;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAge(int newAge) {
        int oldAge = age;
        age = newAge;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.EMPLOYEE__AGE, oldAge, age));
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getSalary() {
        return salary;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSalary(int newSalary) {
        int oldSalary = salary;
        salary = newSalary;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.EMPLOYEE__SALARY, oldSalary, salary));
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Department getEmployer() {
        if (eContainerFeatureID() != CompanyPackage.EMPLOYEE__EMPLOYER) return null;
        return (Department)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetEmployer(Department newEmployer, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newEmployer, CompanyPackage.EMPLOYEE__EMPLOYER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEmployer(Department newEmployer) {
        if (newEmployer != eInternalContainer() || (eContainerFeatureID() != CompanyPackage.EMPLOYEE__EMPLOYER && newEmployer != null)) {
            if (EcoreUtil.isAncestor(this, newEmployer))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newEmployer != null)
                msgs = ((InternalEObject)newEmployer).eInverseAdd(this, CompanyPackage.DEPARTMENT__EMPLOYEE, Department.class, msgs);
            msgs = basicSetEmployer(newEmployer, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.EMPLOYEE__EMPLOYER, newEmployer, newEmployer));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Department getManaged() {
        return managed;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetManaged(Department newManaged, NotificationChain msgs) {
        Department oldManaged = managed;
        managed = newManaged;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompanyPackage.EMPLOYEE__MANAGED, oldManaged, newManaged);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setManaged(Department newManaged) {
        if (newManaged != managed) {
            NotificationChain msgs = null;
            if (managed != null)
                msgs = ((InternalEObject)managed).eInverseRemove(this, CompanyPackage.DEPARTMENT__BOSS, Department.class, msgs);
            if (newManaged != null)
                msgs = ((InternalEObject)newManaged).eInverseAdd(this, CompanyPackage.DEPARTMENT__BOSS, Department.class, msgs);
            msgs = basicSetManaged(newManaged, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.EMPLOYEE__MANAGED, newManaged, newManaged));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Division getDirected() {
        if (eContainerFeatureID() != CompanyPackage.EMPLOYEE__DIRECTED) return null;
        return (Division)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDirected(Division newDirected, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDirected, CompanyPackage.EMPLOYEE__DIRECTED, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDirected(Division newDirected) {
        if (newDirected != eInternalContainer() || (eContainerFeatureID() != CompanyPackage.EMPLOYEE__DIRECTED && newDirected != null)) {
            if (EcoreUtil.isAncestor(this, newDirected))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDirected != null)
                msgs = ((InternalEObject)newDirected).eInverseAdd(this, CompanyPackage.DIVISION__DIRECTOR, Division.class, msgs);
            msgs = basicSetDirected(newDirected, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.EMPLOYEE__DIRECTED, newDirected, newDirected));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Employee getSecretary() {
        return secretary;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSecretary(Employee newSecretary, NotificationChain msgs) {
        Employee oldSecretary = secretary;
        secretary = newSecretary;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompanyPackage.EMPLOYEE__SECRETARY, oldSecretary, newSecretary);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSecretary(Employee newSecretary) {
        if (newSecretary != secretary) {
            NotificationChain msgs = null;
            if (secretary != null)
                msgs = ((InternalEObject)secretary).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompanyPackage.EMPLOYEE__SECRETARY, null, msgs);
            if (newSecretary != null)
                msgs = ((InternalEObject)newSecretary).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompanyPackage.EMPLOYEE__SECRETARY, null, msgs);
            msgs = basicSetSecretary(newSecretary, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.EMPLOYEE__SECRETARY, newSecretary, newSecretary));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Student getIntern() {
        if (intern != null && intern.eIsProxy()) {
            InternalEObject oldIntern = (InternalEObject)intern;
            intern = (Student)eResolveProxy(oldIntern);
            if (intern != oldIntern) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompanyPackage.EMPLOYEE__INTERN, oldIntern, intern));
            }
        }
        return intern;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Student basicGetIntern() {
        return intern;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIntern(Student newIntern) {
        Student oldIntern = intern;
        intern = newIntern;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.EMPLOYEE__INTERN, oldIntern, intern));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CompanyPackage.EMPLOYEE__EMPLOYER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetEmployer((Department)otherEnd, msgs);
            case CompanyPackage.EMPLOYEE__MANAGED:
                if (managed != null)
                    msgs = ((InternalEObject)managed).eInverseRemove(this, CompanyPackage.DEPARTMENT__BOSS, Department.class, msgs);
                return basicSetManaged((Department)otherEnd, msgs);
            case CompanyPackage.EMPLOYEE__DIRECTED:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDirected((Division)otherEnd, msgs);
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
            case CompanyPackage.EMPLOYEE__EMPLOYER:
                return basicSetEmployer(null, msgs);
            case CompanyPackage.EMPLOYEE__MANAGED:
                return basicSetManaged(null, msgs);
            case CompanyPackage.EMPLOYEE__DIRECTED:
                return basicSetDirected(null, msgs);
            case CompanyPackage.EMPLOYEE__SECRETARY:
                return basicSetSecretary(null, msgs);
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
            case CompanyPackage.EMPLOYEE__EMPLOYER:
                return eInternalContainer().eInverseRemove(this, CompanyPackage.DEPARTMENT__EMPLOYEE, Department.class, msgs);
            case CompanyPackage.EMPLOYEE__DIRECTED:
                return eInternalContainer().eInverseRemove(this, CompanyPackage.DIVISION__DIRECTOR, Division.class, msgs);
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
            case CompanyPackage.EMPLOYEE__AGE:
                return getAge();
            case CompanyPackage.EMPLOYEE__SALARY:
                return getSalary();
            case CompanyPackage.EMPLOYEE__EMPLOYER:
                return getEmployer();
            case CompanyPackage.EMPLOYEE__MANAGED:
                return getManaged();
            case CompanyPackage.EMPLOYEE__DIRECTED:
                return getDirected();
            case CompanyPackage.EMPLOYEE__SECRETARY:
                return getSecretary();
            case CompanyPackage.EMPLOYEE__INTERN:
                if (resolve) return getIntern();
                return basicGetIntern();
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
            case CompanyPackage.EMPLOYEE__AGE:
                setAge((Integer)newValue);
                return;
            case CompanyPackage.EMPLOYEE__SALARY:
                setSalary((Integer)newValue);
                return;
            case CompanyPackage.EMPLOYEE__EMPLOYER:
                setEmployer((Department)newValue);
                return;
            case CompanyPackage.EMPLOYEE__MANAGED:
                setManaged((Department)newValue);
                return;
            case CompanyPackage.EMPLOYEE__DIRECTED:
                setDirected((Division)newValue);
                return;
            case CompanyPackage.EMPLOYEE__SECRETARY:
                setSecretary((Employee)newValue);
                return;
            case CompanyPackage.EMPLOYEE__INTERN:
                setIntern((Student)newValue);
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
            case CompanyPackage.EMPLOYEE__AGE:
                setAge(AGE_EDEFAULT);
                return;
            case CompanyPackage.EMPLOYEE__SALARY:
                setSalary(SALARY_EDEFAULT);
                return;
            case CompanyPackage.EMPLOYEE__EMPLOYER:
                setEmployer((Department)null);
                return;
            case CompanyPackage.EMPLOYEE__MANAGED:
                setManaged((Department)null);
                return;
            case CompanyPackage.EMPLOYEE__DIRECTED:
                setDirected((Division)null);
                return;
            case CompanyPackage.EMPLOYEE__SECRETARY:
                setSecretary((Employee)null);
                return;
            case CompanyPackage.EMPLOYEE__INTERN:
                setIntern((Student)null);
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
            case CompanyPackage.EMPLOYEE__AGE:
                return age != AGE_EDEFAULT;
            case CompanyPackage.EMPLOYEE__SALARY:
                return salary != SALARY_EDEFAULT;
            case CompanyPackage.EMPLOYEE__EMPLOYER:
                return getEmployer() != null;
            case CompanyPackage.EMPLOYEE__MANAGED:
                return managed != null;
            case CompanyPackage.EMPLOYEE__DIRECTED:
                return getDirected() != null;
            case CompanyPackage.EMPLOYEE__SECRETARY:
                return secretary != null;
            case CompanyPackage.EMPLOYEE__INTERN:
                return intern != null;
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
        result.append(", age: ");
        result.append(age);
        result.append(", salary: ");
        result.append(salary);
        result.append(')');
        return result.toString();
    }

} //EmployeeImpl
