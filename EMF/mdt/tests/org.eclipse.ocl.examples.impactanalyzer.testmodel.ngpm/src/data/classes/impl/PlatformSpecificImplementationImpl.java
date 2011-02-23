/**
 * <copyright>
 * </copyright>
 *
 * $Id: PlatformSpecificImplementationImpl.java,v 1.1 2011/02/07 17:16:10 auhl Exp $
 */
package data.classes.impl;

import data.classes.ClassesPackage;
import data.classes.PlatformSpecificImplementation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Platform Specific Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.PlatformSpecificImplementationImpl#getTargetPlatform <em>Target Platform</em>}</li>
 *   <li>{@link data.classes.impl.PlatformSpecificImplementationImpl#getImplementation <em>Implementation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlatformSpecificImplementationImpl extends EObjectImpl implements PlatformSpecificImplementation {
	/**
     * The default value of the '{@link #getTargetPlatform() <em>Target Platform</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTargetPlatform()
     * @generated
     * @ordered
     */
	protected static final String TARGET_PLATFORM_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getTargetPlatform() <em>Target Platform</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTargetPlatform()
     * @generated
     * @ordered
     */
	protected String targetPlatform = TARGET_PLATFORM_EDEFAULT;

	/**
     * The default value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImplementation()
     * @generated
     * @ordered
     */
	protected static final String IMPLEMENTATION_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImplementation()
     * @generated
     * @ordered
     */
	protected String implementation = IMPLEMENTATION_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PlatformSpecificImplementationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.PLATFORM_SPECIFIC_IMPLEMENTATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getTargetPlatform() {
        return targetPlatform;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTargetPlatform(String newTargetPlatform) {
        String oldTargetPlatform = targetPlatform;
        targetPlatform = newTargetPlatform;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.PLATFORM_SPECIFIC_IMPLEMENTATION__TARGET_PLATFORM, oldTargetPlatform, targetPlatform));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getImplementation() {
        return implementation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setImplementation(String newImplementation) {
        String oldImplementation = implementation;
        implementation = newImplementation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.PLATFORM_SPECIFIC_IMPLEMENTATION__IMPLEMENTATION, oldImplementation, implementation));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ClassesPackage.PLATFORM_SPECIFIC_IMPLEMENTATION__TARGET_PLATFORM:
                return getTargetPlatform();
            case ClassesPackage.PLATFORM_SPECIFIC_IMPLEMENTATION__IMPLEMENTATION:
                return getImplementation();
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
            case ClassesPackage.PLATFORM_SPECIFIC_IMPLEMENTATION__TARGET_PLATFORM:
                setTargetPlatform((String)newValue);
                return;
            case ClassesPackage.PLATFORM_SPECIFIC_IMPLEMENTATION__IMPLEMENTATION:
                setImplementation((String)newValue);
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
            case ClassesPackage.PLATFORM_SPECIFIC_IMPLEMENTATION__TARGET_PLATFORM:
                setTargetPlatform(TARGET_PLATFORM_EDEFAULT);
                return;
            case ClassesPackage.PLATFORM_SPECIFIC_IMPLEMENTATION__IMPLEMENTATION:
                setImplementation(IMPLEMENTATION_EDEFAULT);
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
            case ClassesPackage.PLATFORM_SPECIFIC_IMPLEMENTATION__TARGET_PLATFORM:
                return TARGET_PLATFORM_EDEFAULT == null ? targetPlatform != null : !TARGET_PLATFORM_EDEFAULT.equals(targetPlatform);
            case ClassesPackage.PLATFORM_SPECIFIC_IMPLEMENTATION__IMPLEMENTATION:
                return IMPLEMENTATION_EDEFAULT == null ? implementation != null : !IMPLEMENTATION_EDEFAULT.equals(implementation);
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
        result.append(" (targetPlatform: ");
        result.append(targetPlatform);
        result.append(", implementation: ");
        result.append(implementation);
        result.append(')');
        return result.toString();
    }

} //PlatformSpecificImplementationImpl
