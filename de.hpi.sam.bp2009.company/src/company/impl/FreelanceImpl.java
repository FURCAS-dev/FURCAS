/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package company.impl;

import company.CompanyPackage;
import company.Freelance;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Freelance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link company.impl.FreelanceImpl#getAssignment <em>Assignment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FreelanceImpl extends EmployeeImpl implements Freelance {
    /**
         * The default value of the '{@link #getAssignment() <em>Assignment</em>}' attribute.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @see #getAssignment()
         * @generated
         * @ordered
         */
    protected static final long ASSIGNMENT_EDEFAULT = 0L;

    /**
         * The cached value of the '{@link #getAssignment() <em>Assignment</em>}' attribute.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @see #getAssignment()
         * @generated
         * @ordered
         */
    protected long assignment = ASSIGNMENT_EDEFAULT;

    /**
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    protected FreelanceImpl() {
                super();
        }

    /**
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    @Override
    protected EClass eStaticClass() {
                return CompanyPackage.Literals.FREELANCE;
        }

    /**
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    public long getAssignment() {
                return assignment;
        }

    /**
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    public void setAssignment(long newAssignment) {
                long oldAssignment = assignment;
                assignment = newAssignment;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.FREELANCE__ASSIGNMENT, oldAssignment, assignment));
        }

    /**
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
                switch (featureID) {
                        case CompanyPackage.FREELANCE__ASSIGNMENT:
                                return getAssignment();
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
                        case CompanyPackage.FREELANCE__ASSIGNMENT:
                                setAssignment((Long)newValue);
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
                        case CompanyPackage.FREELANCE__ASSIGNMENT:
                                setAssignment(ASSIGNMENT_EDEFAULT);
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
                        case CompanyPackage.FREELANCE__ASSIGNMENT:
                                return assignment != ASSIGNMENT_EDEFAULT;
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
                result.append(" (assignment: ");
                result.append(assignment);
                result.append(')');
                return result.toString();
        }

} //FreelanceImpl
