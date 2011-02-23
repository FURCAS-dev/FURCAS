/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimeDependencyImpl.java,v 1.1 2011/02/07 17:18:46 auhl Exp $
 */
package data.timedependency.impl;

import data.classes.Association;
import data.classes.ClassesPackage;
import data.classes.SapClass;

import data.timedependency.TimeDependency;
import data.timedependency.TimedependencyPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.timedependency.impl.TimeDependencyImpl#getRecordCutoffInMilliseconds <em>Record Cutoff In Milliseconds</em>}</li>
 *   <li>{@link data.timedependency.impl.TimeDependencyImpl#isCanChangePast <em>Can Change Past</em>}</li>
 *   <li>{@link data.timedependency.impl.TimeDependencyImpl#isTimespan <em>Timespan</em>}</li>
 *   <li>{@link data.timedependency.impl.TimeDependencyImpl#getTheClass <em>The Class</em>}</li>
 *   <li>{@link data.timedependency.impl.TimeDependencyImpl#getAssociation <em>Association</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimeDependencyImpl extends EObjectImpl implements TimeDependency {
	/**
     * The default value of the '{@link #getRecordCutoffInMilliseconds() <em>Record Cutoff In Milliseconds</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRecordCutoffInMilliseconds()
     * @generated
     * @ordered
     */
	protected static final int RECORD_CUTOFF_IN_MILLISECONDS_EDEFAULT = 0;

	/**
     * The cached value of the '{@link #getRecordCutoffInMilliseconds() <em>Record Cutoff In Milliseconds</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRecordCutoffInMilliseconds()
     * @generated
     * @ordered
     */
	protected int recordCutoffInMilliseconds = RECORD_CUTOFF_IN_MILLISECONDS_EDEFAULT;

	/**
     * The default value of the '{@link #isCanChangePast() <em>Can Change Past</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isCanChangePast()
     * @generated
     * @ordered
     */
	protected static final boolean CAN_CHANGE_PAST_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isCanChangePast() <em>Can Change Past</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isCanChangePast()
     * @generated
     * @ordered
     */
	protected boolean canChangePast = CAN_CHANGE_PAST_EDEFAULT;

	/**
     * The default value of the '{@link #isTimespan() <em>Timespan</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isTimespan()
     * @generated
     * @ordered
     */
	protected static final boolean TIMESPAN_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isTimespan() <em>Timespan</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isTimespan()
     * @generated
     * @ordered
     */
	protected boolean timespan = TIMESPAN_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected TimeDependencyImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return TimedependencyPackage.Literals.TIME_DEPENDENCY;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getRecordCutoffInMilliseconds() {
        return recordCutoffInMilliseconds;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRecordCutoffInMilliseconds(int newRecordCutoffInMilliseconds) {
        int oldRecordCutoffInMilliseconds = recordCutoffInMilliseconds;
        recordCutoffInMilliseconds = newRecordCutoffInMilliseconds;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TimedependencyPackage.TIME_DEPENDENCY__RECORD_CUTOFF_IN_MILLISECONDS, oldRecordCutoffInMilliseconds, recordCutoffInMilliseconds));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isCanChangePast() {
        return canChangePast;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCanChangePast(boolean newCanChangePast) {
        boolean oldCanChangePast = canChangePast;
        canChangePast = newCanChangePast;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TimedependencyPackage.TIME_DEPENDENCY__CAN_CHANGE_PAST, oldCanChangePast, canChangePast));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isTimespan() {
        return timespan;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTimespan(boolean newTimespan) {
        boolean oldTimespan = timespan;
        timespan = newTimespan;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TimedependencyPackage.TIME_DEPENDENCY__TIMESPAN, oldTimespan, timespan));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getTheClass() {
        if (eContainerFeatureID() != TimedependencyPackage.TIME_DEPENDENCY__THE_CLASS) return null;
        return (SapClass)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SapClass basicGetTheClass() {
        if (eContainerFeatureID() != TimedependencyPackage.TIME_DEPENDENCY__THE_CLASS) return null;
        return (SapClass)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetTheClass(SapClass newTheClass, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newTheClass, TimedependencyPackage.TIME_DEPENDENCY__THE_CLASS, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTheClass(SapClass newTheClass) {
        if (newTheClass != eInternalContainer() || (eContainerFeatureID() != TimedependencyPackage.TIME_DEPENDENCY__THE_CLASS && newTheClass != null)) {
            if (EcoreUtil.isAncestor(this, newTheClass))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newTheClass != null)
                msgs = ((InternalEObject)newTheClass).eInverseAdd(this, ClassesPackage.SAP_CLASS__TIME_DEPENDENCY, SapClass.class, msgs);
            msgs = basicSetTheClass(newTheClass, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TimedependencyPackage.TIME_DEPENDENCY__THE_CLASS, newTheClass, newTheClass));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Association getAssociation() {
        if (eContainerFeatureID() != TimedependencyPackage.TIME_DEPENDENCY__ASSOCIATION) return null;
        return (Association)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Association basicGetAssociation() {
        if (eContainerFeatureID() != TimedependencyPackage.TIME_DEPENDENCY__ASSOCIATION) return null;
        return (Association)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetAssociation(Association newAssociation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newAssociation, TimedependencyPackage.TIME_DEPENDENCY__ASSOCIATION, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAssociation(Association newAssociation) {
        if (newAssociation != eInternalContainer() || (eContainerFeatureID() != TimedependencyPackage.TIME_DEPENDENCY__ASSOCIATION && newAssociation != null)) {
            if (EcoreUtil.isAncestor(this, newAssociation))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newAssociation != null)
                msgs = ((InternalEObject)newAssociation).eInverseAdd(this, ClassesPackage.ASSOCIATION__TIME_DEPENDENCY, Association.class, msgs);
            msgs = basicSetAssociation(newAssociation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TimedependencyPackage.TIME_DEPENDENCY__ASSOCIATION, newAssociation, newAssociation));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TimedependencyPackage.TIME_DEPENDENCY__THE_CLASS:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetTheClass((SapClass)otherEnd, msgs);
            case TimedependencyPackage.TIME_DEPENDENCY__ASSOCIATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetAssociation((Association)otherEnd, msgs);
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
            case TimedependencyPackage.TIME_DEPENDENCY__THE_CLASS:
                return basicSetTheClass(null, msgs);
            case TimedependencyPackage.TIME_DEPENDENCY__ASSOCIATION:
                return basicSetAssociation(null, msgs);
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
            case TimedependencyPackage.TIME_DEPENDENCY__THE_CLASS:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.SAP_CLASS__TIME_DEPENDENCY, SapClass.class, msgs);
            case TimedependencyPackage.TIME_DEPENDENCY__ASSOCIATION:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.ASSOCIATION__TIME_DEPENDENCY, Association.class, msgs);
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
            case TimedependencyPackage.TIME_DEPENDENCY__RECORD_CUTOFF_IN_MILLISECONDS:
                return getRecordCutoffInMilliseconds();
            case TimedependencyPackage.TIME_DEPENDENCY__CAN_CHANGE_PAST:
                return isCanChangePast();
            case TimedependencyPackage.TIME_DEPENDENCY__TIMESPAN:
                return isTimespan();
            case TimedependencyPackage.TIME_DEPENDENCY__THE_CLASS:
                if (resolve) return getTheClass();
                return basicGetTheClass();
            case TimedependencyPackage.TIME_DEPENDENCY__ASSOCIATION:
                if (resolve) return getAssociation();
                return basicGetAssociation();
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
            case TimedependencyPackage.TIME_DEPENDENCY__RECORD_CUTOFF_IN_MILLISECONDS:
                setRecordCutoffInMilliseconds((Integer)newValue);
                return;
            case TimedependencyPackage.TIME_DEPENDENCY__CAN_CHANGE_PAST:
                setCanChangePast((Boolean)newValue);
                return;
            case TimedependencyPackage.TIME_DEPENDENCY__TIMESPAN:
                setTimespan((Boolean)newValue);
                return;
            case TimedependencyPackage.TIME_DEPENDENCY__THE_CLASS:
                setTheClass((SapClass)newValue);
                return;
            case TimedependencyPackage.TIME_DEPENDENCY__ASSOCIATION:
                setAssociation((Association)newValue);
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
            case TimedependencyPackage.TIME_DEPENDENCY__RECORD_CUTOFF_IN_MILLISECONDS:
                setRecordCutoffInMilliseconds(RECORD_CUTOFF_IN_MILLISECONDS_EDEFAULT);
                return;
            case TimedependencyPackage.TIME_DEPENDENCY__CAN_CHANGE_PAST:
                setCanChangePast(CAN_CHANGE_PAST_EDEFAULT);
                return;
            case TimedependencyPackage.TIME_DEPENDENCY__TIMESPAN:
                setTimespan(TIMESPAN_EDEFAULT);
                return;
            case TimedependencyPackage.TIME_DEPENDENCY__THE_CLASS:
                setTheClass((SapClass)null);
                return;
            case TimedependencyPackage.TIME_DEPENDENCY__ASSOCIATION:
                setAssociation((Association)null);
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
            case TimedependencyPackage.TIME_DEPENDENCY__RECORD_CUTOFF_IN_MILLISECONDS:
                return recordCutoffInMilliseconds != RECORD_CUTOFF_IN_MILLISECONDS_EDEFAULT;
            case TimedependencyPackage.TIME_DEPENDENCY__CAN_CHANGE_PAST:
                return canChangePast != CAN_CHANGE_PAST_EDEFAULT;
            case TimedependencyPackage.TIME_DEPENDENCY__TIMESPAN:
                return timespan != TIMESPAN_EDEFAULT;
            case TimedependencyPackage.TIME_DEPENDENCY__THE_CLASS:
                return basicGetTheClass() != null;
            case TimedependencyPackage.TIME_DEPENDENCY__ASSOCIATION:
                return basicGetAssociation() != null;
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
        result.append(" (recordCutoffInMilliseconds: ");
        result.append(recordCutoffInMilliseconds);
        result.append(", canChangePast: ");
        result.append(canChangePast);
        result.append(", timespan: ");
        result.append(timespan);
        result.append(')');
        return result.toString();
    }

} //TimeDependencyImpl
