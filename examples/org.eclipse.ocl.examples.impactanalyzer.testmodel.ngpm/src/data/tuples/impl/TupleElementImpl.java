/**
 * <copyright>
 * </copyright>
 *
 * $Id: TupleElementImpl.java,v 1.1 2011/02/07 16:49:10 auhl Exp $
 */
package data.tuples.impl;

import data.classes.ClassesPackage;
import data.classes.TypeDefinition;
import data.classes.TypedElement;

import data.tuples.TupleElement;
import data.tuples.TuplesPackage;

import java.lang.reflect.InvocationTargetException;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuple Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.tuples.impl.TupleElementImpl#getOwnedTypeDefinition <em>Owned Type Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TupleElementImpl extends NamedElementImpl implements TupleElement {
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
	protected TupleElementImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return TuplesPackage.Literals.TUPLE_ELEMENT;
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
                NotificationChain msgs =  oldOwnedTypeDefinition.eInverseRemove(this, ClassesPackage.TYPE_DEFINITION__OWNER_TYPED_ELEMENT, TypeDefinition.class, null);
                if (newOwnedTypeDefinition.eInternalContainer() == null) {
                    msgs =  newOwnedTypeDefinition.eInverseAdd(this, ClassesPackage.TYPE_DEFINITION__OWNER_TYPED_ELEMENT, TypeDefinition.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TuplesPackage.TUPLE_ELEMENT__OWNED_TYPE_DEFINITION, oldOwnedTypeDefinition, ownedTypeDefinition));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TuplesPackage.TUPLE_ELEMENT__OWNED_TYPE_DEFINITION, oldOwnedTypeDefinition, newOwnedTypeDefinition);
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
                msgs = ((InternalEObject)ownedTypeDefinition).eInverseRemove(this, ClassesPackage.TYPE_DEFINITION__OWNER_TYPED_ELEMENT, TypeDefinition.class, msgs);
            if (newOwnedTypeDefinition != null)
                msgs = ((InternalEObject)newOwnedTypeDefinition).eInverseAdd(this, ClassesPackage.TYPE_DEFINITION__OWNER_TYPED_ELEMENT, TypeDefinition.class, msgs);
            msgs = basicSetOwnedTypeDefinition(newOwnedTypeDefinition, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TuplesPackage.TUPLE_ELEMENT__OWNED_TYPE_DEFINITION, newOwnedTypeDefinition, newOwnedTypeDefinition));
    }

	/**
     * The cached invocation delegate for the '{@link #conformsTo(data.classes.TypedElement) <em>Conforms To</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #conformsTo(data.classes.TypedElement)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate CONFORMS_TO_TYPED_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.TYPED_ELEMENT.getEOperations().get(0)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean conformsTo(TypedElement typedElement) {
        try {
            return (Boolean)CONFORMS_TO_TYPED_ELEMENT__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{typedElement}));
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #getType() <em>Get Type</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.TYPED_ELEMENT.getEOperations().get(1)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeDefinition getType() {
        try {
            return (TypeDefinition)GET_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TuplesPackage.TUPLE_ELEMENT__OWNED_TYPE_DEFINITION:
                if (ownedTypeDefinition != null)
                    msgs = ((InternalEObject)ownedTypeDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TuplesPackage.TUPLE_ELEMENT__OWNED_TYPE_DEFINITION, null, msgs);
                return basicSetOwnedTypeDefinition((TypeDefinition)otherEnd, msgs);
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
            case TuplesPackage.TUPLE_ELEMENT__OWNED_TYPE_DEFINITION:
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
            case TuplesPackage.TUPLE_ELEMENT__OWNED_TYPE_DEFINITION:
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
            case TuplesPackage.TUPLE_ELEMENT__OWNED_TYPE_DEFINITION:
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
            case TuplesPackage.TUPLE_ELEMENT__OWNED_TYPE_DEFINITION:
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
            case TuplesPackage.TUPLE_ELEMENT__OWNED_TYPE_DEFINITION:
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == TypedElement.class) {
            switch (derivedFeatureID) {
                case TuplesPackage.TUPLE_ELEMENT__OWNED_TYPE_DEFINITION: return ClassesPackage.TYPED_ELEMENT__OWNED_TYPE_DEFINITION;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == TypedElement.class) {
            switch (baseFeatureID) {
                case ClassesPackage.TYPED_ELEMENT__OWNED_TYPE_DEFINITION: return TuplesPackage.TUPLE_ELEMENT__OWNED_TYPE_DEFINITION;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} //TupleElementImpl
