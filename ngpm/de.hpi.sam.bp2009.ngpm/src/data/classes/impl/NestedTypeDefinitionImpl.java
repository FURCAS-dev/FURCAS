/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes.impl;

import data.classes.ClassesPackage;
import data.classes.NestedTypeDefinition;
import data.classes.TypeDefinition;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nested Type Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.NestedTypeDefinitionImpl#getOp <em>Op</em>}</li>
 *   <li>{@link data.classes.impl.NestedTypeDefinitionImpl#getType <em>Type</em>}</li>
 *   <li>{@link data.classes.impl.NestedTypeDefinitionImpl#getOwnedTypeDefinition <em>Owned Type Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NestedTypeDefinitionImpl extends TypeDefinitionImpl implements NestedTypeDefinition {
	/**
     * The default value of the '{@link #getOp() <em>Op</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOp()
     * @generated
     * @ordered
     */
	protected static final String OP_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getOp() <em>Op</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOp()
     * @generated
     * @ordered
     */
	protected String op = OP_EDEFAULT;

	/**
     * The cached value of the '{@link #getType() <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
	protected TypeDefinition type;

	/**
     * The cached value of the '{@link #getOwnedTypeDefinition() <em>Owned Type Definition</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOwnedTypeDefinition()
     * @generated
     * @ordered
     */
	protected TypeDefinition ownedTypeDefinition;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected NestedTypeDefinitionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.NESTED_TYPE_DEFINITION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getOp() {
        return op;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOp(String newOp) {
        String oldOp = op;
        op = newOp;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.NESTED_TYPE_DEFINITION__OP, oldOp, op));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeDefinition getType() {
        if (type != null && type.eIsProxy()) {
            InternalEObject oldType = (InternalEObject)type;
            type = (TypeDefinition)eResolveProxy(oldType);
            if (type != oldType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.NESTED_TYPE_DEFINITION__TYPE, oldType, type));
            }
        }
        return type;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeDefinition basicGetType() {
        return type;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setType(TypeDefinition newType) {
        TypeDefinition oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.NESTED_TYPE_DEFINITION__TYPE, oldType, type));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeDefinition getOwnedTypeDefinition() {
        if (ownedTypeDefinition != null && ownedTypeDefinition.eIsProxy()) {
            InternalEObject oldOwnedTypeDefinition = (InternalEObject)ownedTypeDefinition;
            ownedTypeDefinition = (TypeDefinition)eResolveProxy(oldOwnedTypeDefinition);
            if (ownedTypeDefinition != oldOwnedTypeDefinition) {
                InternalEObject newOwnedTypeDefinition = (InternalEObject)ownedTypeDefinition;
                NotificationChain msgs = oldOwnedTypeDefinition.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.NESTED_TYPE_DEFINITION__OWNED_TYPE_DEFINITION, null, null);
                if (newOwnedTypeDefinition.eInternalContainer() == null) {
                    msgs = newOwnedTypeDefinition.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.NESTED_TYPE_DEFINITION__OWNED_TYPE_DEFINITION, null, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.NESTED_TYPE_DEFINITION__OWNED_TYPE_DEFINITION, oldOwnedTypeDefinition, ownedTypeDefinition));
            }
        }
        return ownedTypeDefinition;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TypeDefinition basicGetOwnedTypeDefinition() {
        return ownedTypeDefinition;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetOwnedTypeDefinition(TypeDefinition newOwnedTypeDefinition, NotificationChain msgs) {
        TypeDefinition oldOwnedTypeDefinition = ownedTypeDefinition;
        ownedTypeDefinition = newOwnedTypeDefinition;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.NESTED_TYPE_DEFINITION__OWNED_TYPE_DEFINITION, oldOwnedTypeDefinition, newOwnedTypeDefinition);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOwnedTypeDefinition(TypeDefinition newOwnedTypeDefinition) {
        if (newOwnedTypeDefinition != ownedTypeDefinition) {
            NotificationChain msgs = null;
            if (ownedTypeDefinition != null)
                msgs = ((InternalEObject)ownedTypeDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.NESTED_TYPE_DEFINITION__OWNED_TYPE_DEFINITION, null, msgs);
            if (newOwnedTypeDefinition != null)
                msgs = ((InternalEObject)newOwnedTypeDefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.NESTED_TYPE_DEFINITION__OWNED_TYPE_DEFINITION, null, msgs);
            msgs = basicSetOwnedTypeDefinition(newOwnedTypeDefinition, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.NESTED_TYPE_DEFINITION__OWNED_TYPE_DEFINITION, newOwnedTypeDefinition, newOwnedTypeDefinition));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ClassesPackage.NESTED_TYPE_DEFINITION__OWNED_TYPE_DEFINITION:
                return basicSetOwnedTypeDefinition(null, msgs);
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
            case ClassesPackage.NESTED_TYPE_DEFINITION__OP:
                return getOp();
            case ClassesPackage.NESTED_TYPE_DEFINITION__TYPE:
                if (resolve) return getType();
                return basicGetType();
            case ClassesPackage.NESTED_TYPE_DEFINITION__OWNED_TYPE_DEFINITION:
                if (resolve) return getOwnedTypeDefinition();
                return basicGetOwnedTypeDefinition();
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
            case ClassesPackage.NESTED_TYPE_DEFINITION__OP:
                setOp((String)newValue);
                return;
            case ClassesPackage.NESTED_TYPE_DEFINITION__TYPE:
                setType((TypeDefinition)newValue);
                return;
            case ClassesPackage.NESTED_TYPE_DEFINITION__OWNED_TYPE_DEFINITION:
                setOwnedTypeDefinition((TypeDefinition)newValue);
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
            case ClassesPackage.NESTED_TYPE_DEFINITION__OP:
                setOp(OP_EDEFAULT);
                return;
            case ClassesPackage.NESTED_TYPE_DEFINITION__TYPE:
                setType((TypeDefinition)null);
                return;
            case ClassesPackage.NESTED_TYPE_DEFINITION__OWNED_TYPE_DEFINITION:
                setOwnedTypeDefinition((TypeDefinition)null);
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
            case ClassesPackage.NESTED_TYPE_DEFINITION__OP:
                return OP_EDEFAULT == null ? op != null : !OP_EDEFAULT.equals(op);
            case ClassesPackage.NESTED_TYPE_DEFINITION__TYPE:
                return type != null;
            case ClassesPackage.NESTED_TYPE_DEFINITION__OWNED_TYPE_DEFINITION:
                return ownedTypeDefinition != null;
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
        result.append(" (op: ");
        result.append(op);
        result.append(')');
        return result.toString();
    }

} //NestedTypeDefinitionImpl
