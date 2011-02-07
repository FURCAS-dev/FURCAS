/**
 * <copyright>
 * </copyright>
 *
 * $Id: AssociationEndSignatureImplementationImpl.java,v 1.1 2011/02/07 16:43:32 auhl Exp $
 */
package data.classes.impl;

import data.classes.AssociationEnd;
import data.classes.AssociationEndSignatureImplementation;
import data.classes.ClassesPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association End Signature Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.AssociationEndSignatureImplementationImpl#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AssociationEndSignatureImplementationImpl extends SignatureImplementationImpl implements AssociationEndSignatureImplementation {
	/**
     * The cached value of the '{@link #getEnd() <em>End</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEnd()
     * @generated
     * @ordered
     */
	protected AssociationEnd end;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected AssociationEndSignatureImplementationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.ASSOCIATION_END_SIGNATURE_IMPLEMENTATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AssociationEnd getEnd() {
        if (end != null && end.eIsProxy()) {
            InternalEObject oldEnd = (InternalEObject)end;
            end = (AssociationEnd)eResolveProxy(oldEnd);
            if (end != oldEnd) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__END, oldEnd, end));
            }
        }
        return end;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AssociationEnd basicGetEnd() {
        return end;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetEnd(AssociationEnd newEnd, NotificationChain msgs) {
        AssociationEnd oldEnd = end;
        end = newEnd;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__END, oldEnd, newEnd);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setEnd(AssociationEnd newEnd) {
        if (newEnd != end) {
            NotificationChain msgs = null;
            if (end != null)
                msgs = ((InternalEObject)end).eInverseRemove(this, ClassesPackage.ASSOCIATION_END__SIGNATURE_IMPLEMENTATIONS, AssociationEnd.class, msgs);
            if (newEnd != null)
                msgs = ((InternalEObject)newEnd).eInverseAdd(this, ClassesPackage.ASSOCIATION_END__SIGNATURE_IMPLEMENTATIONS, AssociationEnd.class, msgs);
            msgs = basicSetEnd(newEnd, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__END, newEnd, newEnd));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ClassesPackage.ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__END:
                if (end != null)
                    msgs = ((InternalEObject)end).eInverseRemove(this, ClassesPackage.ASSOCIATION_END__SIGNATURE_IMPLEMENTATIONS, AssociationEnd.class, msgs);
                return basicSetEnd((AssociationEnd)otherEnd, msgs);
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
            case ClassesPackage.ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__END:
                return basicSetEnd(null, msgs);
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
            case ClassesPackage.ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__END:
                if (resolve) return getEnd();
                return basicGetEnd();
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
            case ClassesPackage.ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__END:
                setEnd((AssociationEnd)newValue);
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
            case ClassesPackage.ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__END:
                setEnd((AssociationEnd)null);
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
            case ClassesPackage.ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__END:
                return end != null;
        }
        return super.eIsSet(featureID);
    }

} //AssociationEndSignatureImplementationImpl
