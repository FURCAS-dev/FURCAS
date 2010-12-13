/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package configuration.context_drivers.impl;

import configuration.context_drivers.ContexConfiguration;
import configuration.context_drivers.ContextCategory;
import configuration.context_drivers.ContextCategoryValue;
import configuration.context_drivers.Context_driversPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context Category</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configuration.context_drivers.impl.ContextCategoryImpl#getName <em>Name</em>}</li>
 *   <li>{@link configuration.context_drivers.impl.ContextCategoryImpl#getRootValue <em>Root Value</em>}</li>
 *   <li>{@link configuration.context_drivers.impl.ContextCategoryImpl#getCategoryConfiguration <em>Category Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextCategoryImpl extends EObjectImpl implements ContextCategory {
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
     * The cached value of the '{@link #getRootValue() <em>Root Value</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRootValue()
     * @generated
     * @ordered
     */
	protected ContextCategoryValue rootValue;

	/**
     * The cached value of the '{@link #getCategoryConfiguration() <em>Category Configuration</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCategoryConfiguration()
     * @generated
     * @ordered
     */
	protected EList<ContexConfiguration> categoryConfiguration;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ContextCategoryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Context_driversPackage.Literals.CONTEXT_CATEGORY;
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
            eNotify(new ENotificationImpl(this, Notification.SET, Context_driversPackage.CONTEXT_CATEGORY__NAME, oldName, name));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ContextCategoryValue getRootValue() {
        if (rootValue != null && rootValue.eIsProxy()) {
            InternalEObject oldRootValue = (InternalEObject)rootValue;
            rootValue = (ContextCategoryValue)eResolveProxy(oldRootValue);
            if (rootValue != oldRootValue) {
                InternalEObject newRootValue = (InternalEObject)rootValue;
                NotificationChain msgs =  oldRootValue.eInverseRemove(this, Context_driversPackage.CONTEXT_CATEGORY_VALUE__CONTEXT, ContextCategoryValue.class, null);
                if (newRootValue.eInternalContainer() == null) {
                    msgs =  newRootValue.eInverseAdd(this, Context_driversPackage.CONTEXT_CATEGORY_VALUE__CONTEXT, ContextCategoryValue.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Context_driversPackage.CONTEXT_CATEGORY__ROOT_VALUE, oldRootValue, rootValue));
            }
        }
        return rootValue;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ContextCategoryValue basicGetRootValue() {
        return rootValue;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetRootValue(ContextCategoryValue newRootValue, NotificationChain msgs) {
        ContextCategoryValue oldRootValue = rootValue;
        rootValue = newRootValue;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Context_driversPackage.CONTEXT_CATEGORY__ROOT_VALUE, oldRootValue, newRootValue);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRootValue(ContextCategoryValue newRootValue) {
        if (newRootValue != rootValue) {
            NotificationChain msgs = null;
            if (rootValue != null)
                msgs = ((InternalEObject)rootValue).eInverseRemove(this, Context_driversPackage.CONTEXT_CATEGORY_VALUE__CONTEXT, ContextCategoryValue.class, msgs);
            if (newRootValue != null)
                msgs = ((InternalEObject)newRootValue).eInverseAdd(this, Context_driversPackage.CONTEXT_CATEGORY_VALUE__CONTEXT, ContextCategoryValue.class, msgs);
            msgs = basicSetRootValue(newRootValue, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Context_driversPackage.CONTEXT_CATEGORY__ROOT_VALUE, newRootValue, newRootValue));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ContexConfiguration> getCategoryConfiguration() {
        if (categoryConfiguration == null) {
            categoryConfiguration = new EObjectWithInverseResolvingEList<ContexConfiguration>(ContexConfiguration.class, this, Context_driversPackage.CONTEXT_CATEGORY__CATEGORY_CONFIGURATION, Context_driversPackage.CONTEX_CONFIGURATION__CATEGORY);
        }
        return categoryConfiguration;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case Context_driversPackage.CONTEXT_CATEGORY__ROOT_VALUE:
                if (rootValue != null)
                    msgs = ((InternalEObject)rootValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Context_driversPackage.CONTEXT_CATEGORY__ROOT_VALUE, null, msgs);
                return basicSetRootValue((ContextCategoryValue)otherEnd, msgs);
            case Context_driversPackage.CONTEXT_CATEGORY__CATEGORY_CONFIGURATION:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getCategoryConfiguration()).basicAdd(otherEnd, msgs);
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
            case Context_driversPackage.CONTEXT_CATEGORY__ROOT_VALUE:
                return basicSetRootValue(null, msgs);
            case Context_driversPackage.CONTEXT_CATEGORY__CATEGORY_CONFIGURATION:
                return ((InternalEList<?>)getCategoryConfiguration()).basicRemove(otherEnd, msgs);
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
            case Context_driversPackage.CONTEXT_CATEGORY__NAME:
                return getName();
            case Context_driversPackage.CONTEXT_CATEGORY__ROOT_VALUE:
                if (resolve) return getRootValue();
                return basicGetRootValue();
            case Context_driversPackage.CONTEXT_CATEGORY__CATEGORY_CONFIGURATION:
                return getCategoryConfiguration();
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
            case Context_driversPackage.CONTEXT_CATEGORY__NAME:
                setName((String)newValue);
                return;
            case Context_driversPackage.CONTEXT_CATEGORY__ROOT_VALUE:
                setRootValue((ContextCategoryValue)newValue);
                return;
            case Context_driversPackage.CONTEXT_CATEGORY__CATEGORY_CONFIGURATION:
                getCategoryConfiguration().clear();
                getCategoryConfiguration().addAll((Collection<? extends ContexConfiguration>)newValue);
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
            case Context_driversPackage.CONTEXT_CATEGORY__NAME:
                setName(NAME_EDEFAULT);
                return;
            case Context_driversPackage.CONTEXT_CATEGORY__ROOT_VALUE:
                setRootValue((ContextCategoryValue)null);
                return;
            case Context_driversPackage.CONTEXT_CATEGORY__CATEGORY_CONFIGURATION:
                getCategoryConfiguration().clear();
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
            case Context_driversPackage.CONTEXT_CATEGORY__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case Context_driversPackage.CONTEXT_CATEGORY__ROOT_VALUE:
                return rootValue != null;
            case Context_driversPackage.CONTEXT_CATEGORY__CATEGORY_CONFIGURATION:
                return categoryConfiguration != null && !categoryConfiguration.isEmpty();
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
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //ContextCategoryImpl
