/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes.impl;

import data.classes.ClassesPackage;
import data.classes.MethodSignature;
import data.classes.SapClass;
import data.classes.TypeAdapter;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Adapter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.TypeAdapterImpl#getTo <em>To</em>}</li>
 *   <li>{@link data.classes.impl.TypeAdapterImpl#getAdapted <em>Adapted</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeAdapterImpl extends SignatureOwnerImpl implements TypeAdapter {
	/**
     * The cached value of the '{@link #getTo() <em>To</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTo()
     * @generated
     * @ordered
     */
	protected SapClass to;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected TypeAdapterImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.TYPE_ADAPTER;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getTo() {
        if (to != null && to.eIsProxy()) {
            InternalEObject oldTo = (InternalEObject)to;
            to = (SapClass)eResolveProxy(oldTo);
            if (to != oldTo) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.TYPE_ADAPTER__TO, oldTo, to));
            }
        }
        return to;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass basicGetTo() {
        return to;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetTo(SapClass newTo, NotificationChain msgs) {
        SapClass oldTo = to;
        to = newTo;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.TYPE_ADAPTER__TO, oldTo, newTo);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTo(SapClass newTo) {
        if (newTo != to) {
            NotificationChain msgs = null;
            if (to != null)
                msgs = ((InternalEObject)to).eInverseRemove(this, ClassesPackage.SAP_CLASS__ADAPTED_BY, SapClass.class, msgs);
            if (newTo != null)
                msgs = ((InternalEObject)newTo).eInverseAdd(this, ClassesPackage.SAP_CLASS__ADAPTED_BY, SapClass.class, msgs);
            msgs = basicSetTo(newTo, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.TYPE_ADAPTER__TO, newTo, newTo));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getAdapted() {
        if (eContainerFeatureID() != ClassesPackage.TYPE_ADAPTER__ADAPTED) return null;
        return (SapClass)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SapClass basicGetAdapted() {
        if (eContainerFeatureID() != ClassesPackage.TYPE_ADAPTER__ADAPTED) return null;
        return (SapClass)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetAdapted(SapClass newAdapted, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newAdapted, ClassesPackage.TYPE_ADAPTER__ADAPTED, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAdapted(SapClass newAdapted) {
        if (newAdapted != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.TYPE_ADAPTER__ADAPTED && newAdapted != null)) {
            if (EcoreUtil.isAncestor(this, newAdapted))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newAdapted != null)
                msgs = ((InternalEObject)newAdapted).eInverseAdd(this, ClassesPackage.SAP_CLASS__ADAPTERS, SapClass.class, msgs);
            msgs = basicSetAdapted(newAdapted, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.TYPE_ADAPTER__ADAPTED, newAdapted, newAdapted));
    }

	/**
     * The cached invocation delegate for the '{@link #conformsTo(data.classes.SapClass) <em>Conforms To</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #conformsTo(data.classes.SapClass)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate CONFORMS_TO_SAP_CLASS__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.TYPE_ADAPTER.getEOperations().get(0)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean conformsTo(SapClass type) {
        try {
            return (Boolean)CONFORMS_TO_SAP_CLASS__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{type}));
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #conformsToExcluding(data.classes.SapClass, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Conforms To Excluding</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #conformsToExcluding(data.classes.SapClass, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate CONFORMS_TO_EXCLUDING_SAP_CLASS_ELIST_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.TYPE_ADAPTER.getEOperations().get(1)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean conformsToExcluding(SapClass type, EList<SapClass> excludingConforming, EList<SapClass> excludingTo) {
        try {
            return (Boolean)CONFORMS_TO_EXCLUDING_SAP_CLASS_ELIST_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(3, new Object[]{type, excludingConforming, excludingTo}));
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #allSignatures() <em>All Signatures</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #allSignatures()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate ALL_SIGNATURES__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.TYPE_ADAPTER.getEOperations().get(2)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<MethodSignature> allSignatures() {
        try {
            return (EList<MethodSignature>)ALL_SIGNATURES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #allSignaturesExcluding(org.eclipse.emf.common.util.EList) <em>All Signatures Excluding</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #allSignaturesExcluding(org.eclipse.emf.common.util.EList)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate ALL_SIGNATURES_EXCLUDING_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.TYPE_ADAPTER.getEOperations().get(3)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<MethodSignature> allSignaturesExcluding(EList<SapClass> excluding) {
        try {
            return (EList<MethodSignature>)ALL_SIGNATURES_EXCLUDING_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{excluding}));
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
            case ClassesPackage.TYPE_ADAPTER__TO:
                if (to != null)
                    msgs = ((InternalEObject)to).eInverseRemove(this, ClassesPackage.SAP_CLASS__ADAPTED_BY, SapClass.class, msgs);
                return basicSetTo((SapClass)otherEnd, msgs);
            case ClassesPackage.TYPE_ADAPTER__ADAPTED:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetAdapted((SapClass)otherEnd, msgs);
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
            case ClassesPackage.TYPE_ADAPTER__TO:
                return basicSetTo(null, msgs);
            case ClassesPackage.TYPE_ADAPTER__ADAPTED:
                return basicSetAdapted(null, msgs);
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
            case ClassesPackage.TYPE_ADAPTER__ADAPTED:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.SAP_CLASS__ADAPTERS, SapClass.class, msgs);
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
            case ClassesPackage.TYPE_ADAPTER__TO:
                if (resolve) return getTo();
                return basicGetTo();
            case ClassesPackage.TYPE_ADAPTER__ADAPTED:
                if (resolve) return getAdapted();
                return basicGetAdapted();
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
            case ClassesPackage.TYPE_ADAPTER__TO:
                setTo((SapClass)newValue);
                return;
            case ClassesPackage.TYPE_ADAPTER__ADAPTED:
                setAdapted((SapClass)newValue);
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
            case ClassesPackage.TYPE_ADAPTER__TO:
                setTo((SapClass)null);
                return;
            case ClassesPackage.TYPE_ADAPTER__ADAPTED:
                setAdapted((SapClass)null);
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
            case ClassesPackage.TYPE_ADAPTER__TO:
                return to != null;
            case ClassesPackage.TYPE_ADAPTER__ADAPTED:
                return basicGetAdapted() != null;
        }
        return super.eIsSet(featureID);
    }

} //TypeAdapterImpl
