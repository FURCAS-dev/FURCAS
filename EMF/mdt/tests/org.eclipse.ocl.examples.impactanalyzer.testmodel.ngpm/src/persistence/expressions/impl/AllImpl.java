/**
 * <copyright>
 * </copyright>
 *
 * $Id: AllImpl.java,v 1.1 2011/02/07 17:21:38 auhl Exp $
 */
package persistence.expressions.impl;

import data.classes.SapClass;

import dataaccess.expressions.Expression;

import dataaccess.expressions.impl.ExpressionImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import persistence.expressions.All;
import persistence.expressions.ExpressionsPackage;
import persistence.expressions.SnapshotSelection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>All</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link persistence.expressions.impl.AllImpl#getSnapshot <em>Snapshot</em>}</li>
 *   <li>{@link persistence.expressions.impl.AllImpl#getOfClass <em>Of Class</em>}</li>
 *   <li>{@link persistence.expressions.impl.AllImpl#getSnapshotIdentifier <em>Snapshot Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AllImpl extends ExpressionImpl implements All {
	/**
     * The default value of the '{@link #getSnapshot() <em>Snapshot</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSnapshot()
     * @generated
     * @ordered
     */
	protected static final SnapshotSelection SNAPSHOT_EDEFAULT = SnapshotSelection.DEFAULT;

	/**
     * The cached value of the '{@link #getSnapshot() <em>Snapshot</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSnapshot()
     * @generated
     * @ordered
     */
	protected SnapshotSelection snapshot = SNAPSHOT_EDEFAULT;

	/**
     * The cached value of the '{@link #getOfClass() <em>Of Class</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOfClass()
     * @generated
     * @ordered
     */
	protected SapClass ofClass;

	/**
     * The cached value of the '{@link #getSnapshotIdentifier() <em>Snapshot Identifier</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSnapshotIdentifier()
     * @generated
     * @ordered
     */
	protected Expression snapshotIdentifier;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected AllImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.ALL;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SnapshotSelection getSnapshot() {
        return snapshot;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSnapshot(SnapshotSelection newSnapshot) {
        SnapshotSelection oldSnapshot = snapshot;
        snapshot = newSnapshot == null ? SNAPSHOT_EDEFAULT : newSnapshot;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.ALL__SNAPSHOT, oldSnapshot, snapshot));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getOfClass() {
        if (ofClass != null && ofClass.eIsProxy()) {
            InternalEObject oldOfClass = (InternalEObject)ofClass;
            ofClass = (SapClass)eResolveProxy(oldOfClass);
            if (ofClass != oldOfClass) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.ALL__OF_CLASS, oldOfClass, ofClass));
            }
        }
        return ofClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass basicGetOfClass() {
        return ofClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOfClass(SapClass newOfClass) {
        SapClass oldOfClass = ofClass;
        ofClass = newOfClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.ALL__OF_CLASS, oldOfClass, ofClass));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getSnapshotIdentifier() {
        if (snapshotIdentifier != null && snapshotIdentifier.eIsProxy()) {
            InternalEObject oldSnapshotIdentifier = (InternalEObject)snapshotIdentifier;
            snapshotIdentifier = (Expression)eResolveProxy(oldSnapshotIdentifier);
            if (snapshotIdentifier != oldSnapshotIdentifier) {
                InternalEObject newSnapshotIdentifier = (InternalEObject)snapshotIdentifier;
                NotificationChain msgs =  oldSnapshotIdentifier.eInverseRemove(this, dataaccess.expressions.ExpressionsPackage.EXPRESSION__ALL, Expression.class, null);
                if (newSnapshotIdentifier.eInternalContainer() == null) {
                    msgs =  newSnapshotIdentifier.eInverseAdd(this, dataaccess.expressions.ExpressionsPackage.EXPRESSION__ALL, Expression.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.ALL__SNAPSHOT_IDENTIFIER, oldSnapshotIdentifier, snapshotIdentifier));
            }
        }
        return snapshotIdentifier;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetSnapshotIdentifier() {
        return snapshotIdentifier;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetSnapshotIdentifier(Expression newSnapshotIdentifier, NotificationChain msgs) {
        Expression oldSnapshotIdentifier = snapshotIdentifier;
        snapshotIdentifier = newSnapshotIdentifier;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.ALL__SNAPSHOT_IDENTIFIER, oldSnapshotIdentifier, newSnapshotIdentifier);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSnapshotIdentifier(Expression newSnapshotIdentifier) {
        if (newSnapshotIdentifier != snapshotIdentifier) {
            NotificationChain msgs = null;
            if (snapshotIdentifier != null)
                msgs = ((InternalEObject)snapshotIdentifier).eInverseRemove(this, dataaccess.expressions.ExpressionsPackage.EXPRESSION__ALL, Expression.class, msgs);
            if (newSnapshotIdentifier != null)
                msgs = ((InternalEObject)newSnapshotIdentifier).eInverseAdd(this, dataaccess.expressions.ExpressionsPackage.EXPRESSION__ALL, Expression.class, msgs);
            msgs = basicSetSnapshotIdentifier(newSnapshotIdentifier, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.ALL__SNAPSHOT_IDENTIFIER, newSnapshotIdentifier, newSnapshotIdentifier));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.ALL__SNAPSHOT_IDENTIFIER:
                if (snapshotIdentifier != null)
                    msgs = ((InternalEObject)snapshotIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.ALL__SNAPSHOT_IDENTIFIER, null, msgs);
                return basicSetSnapshotIdentifier((Expression)otherEnd, msgs);
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
            case ExpressionsPackage.ALL__SNAPSHOT_IDENTIFIER:
                return basicSetSnapshotIdentifier(null, msgs);
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
            case ExpressionsPackage.ALL__SNAPSHOT:
                return getSnapshot();
            case ExpressionsPackage.ALL__OF_CLASS:
                if (resolve) return getOfClass();
                return basicGetOfClass();
            case ExpressionsPackage.ALL__SNAPSHOT_IDENTIFIER:
                if (resolve) return getSnapshotIdentifier();
                return basicGetSnapshotIdentifier();
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
            case ExpressionsPackage.ALL__SNAPSHOT:
                setSnapshot((SnapshotSelection)newValue);
                return;
            case ExpressionsPackage.ALL__OF_CLASS:
                setOfClass((SapClass)newValue);
                return;
            case ExpressionsPackage.ALL__SNAPSHOT_IDENTIFIER:
                setSnapshotIdentifier((Expression)newValue);
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
            case ExpressionsPackage.ALL__SNAPSHOT:
                setSnapshot(SNAPSHOT_EDEFAULT);
                return;
            case ExpressionsPackage.ALL__OF_CLASS:
                setOfClass((SapClass)null);
                return;
            case ExpressionsPackage.ALL__SNAPSHOT_IDENTIFIER:
                setSnapshotIdentifier((Expression)null);
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
            case ExpressionsPackage.ALL__SNAPSHOT:
                return snapshot != SNAPSHOT_EDEFAULT;
            case ExpressionsPackage.ALL__OF_CLASS:
                return ofClass != null;
            case ExpressionsPackage.ALL__SNAPSHOT_IDENTIFIER:
                return snapshotIdentifier != null;
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
        result.append(" (snapshot: ");
        result.append(snapshot);
        result.append(')');
        return result.toString();
    }

} //AllImpl
