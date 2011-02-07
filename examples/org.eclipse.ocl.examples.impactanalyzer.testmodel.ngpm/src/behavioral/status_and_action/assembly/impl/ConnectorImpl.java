/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConnectorImpl.java,v 1.1 2011/02/07 16:43:33 auhl Exp $
 */
package behavioral.status_and_action.assembly.impl;

import behavioral.status_and_action.assembly.AssemblyPackage;
import behavioral.status_and_action.assembly.ConnectableElement;
import behavioral.status_and_action.assembly.Connector;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.status_and_action.assembly.impl.ConnectorImpl#getSource <em>Source</em>}</li>
 *   <li>{@link behavioral.status_and_action.assembly.impl.ConnectorImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ConnectorImpl extends SchemaElementImpl implements Connector {
	/**
     * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSource()
     * @generated
     * @ordered
     */
	protected ConnectableElement source;

	/**
     * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTarget()
     * @generated
     * @ordered
     */
	protected ConnectableElement target;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ConnectorImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return AssemblyPackage.Literals.CONNECTOR;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ConnectableElement getSource() {
        if (source != null && source.eIsProxy()) {
            InternalEObject oldSource = (InternalEObject)source;
            source = (ConnectableElement)eResolveProxy(oldSource);
            if (source != oldSource) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssemblyPackage.CONNECTOR__SOURCE, oldSource, source));
            }
        }
        return source;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ConnectableElement basicGetSource() {
        return source;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSource(ConnectableElement newSource) {
        ConnectableElement oldSource = source;
        source = newSource;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AssemblyPackage.CONNECTOR__SOURCE, oldSource, source));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ConnectableElement getTarget() {
        if (target != null && target.eIsProxy()) {
            InternalEObject oldTarget = (InternalEObject)target;
            target = (ConnectableElement)eResolveProxy(oldTarget);
            if (target != oldTarget) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssemblyPackage.CONNECTOR__TARGET, oldTarget, target));
            }
        }
        return target;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ConnectableElement basicGetTarget() {
        return target;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTarget(ConnectableElement newTarget) {
        ConnectableElement oldTarget = target;
        target = newTarget;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AssemblyPackage.CONNECTOR__TARGET, oldTarget, target));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case AssemblyPackage.CONNECTOR__SOURCE:
                if (resolve) return getSource();
                return basicGetSource();
            case AssemblyPackage.CONNECTOR__TARGET:
                if (resolve) return getTarget();
                return basicGetTarget();
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
            case AssemblyPackage.CONNECTOR__SOURCE:
                setSource((ConnectableElement)newValue);
                return;
            case AssemblyPackage.CONNECTOR__TARGET:
                setTarget((ConnectableElement)newValue);
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
            case AssemblyPackage.CONNECTOR__SOURCE:
                setSource((ConnectableElement)null);
                return;
            case AssemblyPackage.CONNECTOR__TARGET:
                setTarget((ConnectableElement)null);
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
            case AssemblyPackage.CONNECTOR__SOURCE:
                return source != null;
            case AssemblyPackage.CONNECTOR__TARGET:
                return target != null;
        }
        return super.eIsSet(featureID);
    }

} //ConnectorImpl
