/**
 * <copyright>
 * </copyright>
 *
 * $Id: CollectionLiteralPartImpl.java,v 1.1 2007/01/25 18:24:38 cdamus Exp $
 */
package org.eclipse.ocl.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.expressions.CollectionLiteralPart;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Literal Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.impl.CollectionLiteralPartImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.impl.CollectionLiteralPartImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionLiteralPartImpl<C> extends EObjectImpl implements CollectionLiteralPart<C> {
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
     * The cached value of the '{@link #getType() <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
	protected C type = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected CollectionLiteralPartImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.COLLECTION_LITERAL_PART;
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
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.COLLECTION_LITERAL_PART__NAME, oldName, name));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	public C getType() {
        if (type != null && ((EObject)type).eIsProxy()) {
            InternalEObject oldType = (InternalEObject)type;
            type = (C)eResolveProxy(oldType);
            if (type != oldType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.COLLECTION_LITERAL_PART__TYPE, oldType, type));
            }
        }
        return type;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public C basicGetType() {
        return type;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setType(C newType) {
        C oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.COLLECTION_LITERAL_PART__TYPE, oldType, type));
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ExpressionsPackage.COLLECTION_LITERAL_PART__NAME:
                return getName();
            case ExpressionsPackage.COLLECTION_LITERAL_PART__TYPE:
                if (resolve) return getType();
                return basicGetType();
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
            case ExpressionsPackage.COLLECTION_LITERAL_PART__NAME:
                setName((String)newValue);
                return;
            case ExpressionsPackage.COLLECTION_LITERAL_PART__TYPE:
                setType((C)newValue);
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
            case ExpressionsPackage.COLLECTION_LITERAL_PART__NAME:
                setName(NAME_EDEFAULT);
                return;
            case ExpressionsPackage.COLLECTION_LITERAL_PART__TYPE:
                setType((C)null);
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
            case ExpressionsPackage.COLLECTION_LITERAL_PART__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case ExpressionsPackage.COLLECTION_LITERAL_PART__TYPE:
                return type != null;
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
        result.append(" (name: "); //$NON-NLS-1$
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //CollectionLiteralPartImpl
