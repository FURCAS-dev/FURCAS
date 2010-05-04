/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package company.impl;

import company.CompanyPackage;
import company.Department;
import company.Division;
import company.Employee;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

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
    protected static final long AGE_EDEFAULT = 0L;

    /**
     * The cached value of the '{@link #getAge() <em>Age</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAge()
     * @generated
     * @ordered
     */
    protected long age = AGE_EDEFAULT;

    /**
     * The default value of the '{@link #getSalary() <em>Salary</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSalary()
     * @generated
     * @ordered
     */
    protected static final long SALARY_EDEFAULT = 0L;

    /**
     * The cached value of the '{@link #getSalary() <em>Salary</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSalary()
     * @generated
     * @ordered
     */
    protected long salary = SALARY_EDEFAULT;

    /**
     * The cached value of the '{@link #getEmployer() <em>Employer</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEmployer()
     * @generated
     * @ordered
     */
    protected Department employer;

    /**
     * The cached value of the '{@link #getManaged() <em>Managed</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getManaged()
     * @generated
     * @ordered
     */
    protected Department managed;

    /**
     * The cached value of the '{@link #getDirected() <em>Directed</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDirected()
     * @generated
     * @ordered
     */
    protected Division directed;

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
    public long getAge() {
        return age;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAge(long newAge) {
        long oldAge = age;
        age = newAge;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.EMPLOYEE__AGE, oldAge, age));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public long getSalary() {
        return salary;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSalary(long newSalary) {
        long oldSalary = salary;
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
        return employer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetEmployer(Department newEmployer, NotificationChain msgs) {
        Department oldEmployer = employer;
        employer = newEmployer;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompanyPackage.EMPLOYEE__EMPLOYER, oldEmployer, newEmployer);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEmployer(Department newEmployer) {
        if (newEmployer != employer) {
            NotificationChain msgs = null;
            if (employer != null)
                msgs = ((InternalEObject)employer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompanyPackage.EMPLOYEE__EMPLOYER, null, msgs);
            if (newEmployer != null)
                msgs = ((InternalEObject)newEmployer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompanyPackage.EMPLOYEE__EMPLOYER, null, msgs);
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
                msgs = ((InternalEObject)managed).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompanyPackage.EMPLOYEE__MANAGED, null, msgs);
            if (newManaged != null)
                msgs = ((InternalEObject)newManaged).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompanyPackage.EMPLOYEE__MANAGED, null, msgs);
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
        return directed;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDirected(Division newDirected, NotificationChain msgs) {
        Division oldDirected = directed;
        directed = newDirected;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompanyPackage.EMPLOYEE__DIRECTED, oldDirected, newDirected);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDirected(Division newDirected) {
        if (newDirected != directed) {
            NotificationChain msgs = null;
            if (directed != null)
                msgs = ((InternalEObject)directed).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompanyPackage.EMPLOYEE__DIRECTED, null, msgs);
            if (newDirected != null)
                msgs = ((InternalEObject)newDirected).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompanyPackage.EMPLOYEE__DIRECTED, null, msgs);
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
                setAge((Long)newValue);
                return;
            case CompanyPackage.EMPLOYEE__SALARY:
                setSalary((Long)newValue);
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
                return employer != null;
            case CompanyPackage.EMPLOYEE__MANAGED:
                return managed != null;
            case CompanyPackage.EMPLOYEE__DIRECTED:
                return directed != null;
            case CompanyPackage.EMPLOYEE__SECRETARY:
                return secretary != null;
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
