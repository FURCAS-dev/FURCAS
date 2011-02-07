/**
 * <copyright>
 * </copyright>
 *
 * $Id: ContextCategoryValueImpl.java,v 1.1 2011/02/07 16:48:25 auhl Exp $
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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context Category Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configuration.context_drivers.impl.ContextCategoryValueImpl#getValue <em>Value</em>}</li>
 *   <li>{@link configuration.context_drivers.impl.ContextCategoryValueImpl#getContext <em>Context</em>}</li>
 *   <li>{@link configuration.context_drivers.impl.ContextCategoryValueImpl#getIncludedValuesConfiguration <em>Included Values Configuration</em>}</li>
 *   <li>{@link configuration.context_drivers.impl.ContextCategoryValueImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link configuration.context_drivers.impl.ContextCategoryValueImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link configuration.context_drivers.impl.ContextCategoryValueImpl#getExcludedValuesConfiguration <em>Excluded Values Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextCategoryValueImpl extends ContextCategoryImpl implements ContextCategoryValue {
	/**
     * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
	protected static final String VALUE_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
	protected String value = VALUE_EDEFAULT;

	/**
     * The cached value of the '{@link #getIncludedValuesConfiguration() <em>Included Values Configuration</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIncludedValuesConfiguration()
     * @generated
     * @ordered
     */
	protected EList<ContexConfiguration> includedValuesConfiguration;

	/**
     * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getChildren()
     * @generated
     * @ordered
     */
	protected EList<ContextCategoryValue> children;

	/**
     * The cached value of the '{@link #getExcludedValuesConfiguration() <em>Excluded Values Configuration</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getExcludedValuesConfiguration()
     * @generated
     * @ordered
     */
	protected EList<ContexConfiguration> excludedValuesConfiguration;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ContextCategoryValueImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Context_driversPackage.Literals.CONTEXT_CATEGORY_VALUE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getValue() {
        return value;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setValue(String newValue) {
        String oldValue = value;
        value = newValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Context_driversPackage.CONTEXT_CATEGORY_VALUE__VALUE, oldValue, value));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ContextCategory getContext() {
        if (eContainerFeatureID() != Context_driversPackage.CONTEXT_CATEGORY_VALUE__CONTEXT) return null;
        return (ContextCategory)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ContextCategory basicGetContext() {
        if (eContainerFeatureID() != Context_driversPackage.CONTEXT_CATEGORY_VALUE__CONTEXT) return null;
        return (ContextCategory)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetContext(ContextCategory newContext, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newContext, Context_driversPackage.CONTEXT_CATEGORY_VALUE__CONTEXT, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setContext(ContextCategory newContext) {
        if (newContext != eInternalContainer() || (eContainerFeatureID() != Context_driversPackage.CONTEXT_CATEGORY_VALUE__CONTEXT && newContext != null)) {
            if (EcoreUtil.isAncestor(this, newContext))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newContext != null)
                msgs = ((InternalEObject)newContext).eInverseAdd(this, Context_driversPackage.CONTEXT_CATEGORY__ROOT_VALUE, ContextCategory.class, msgs);
            msgs = basicSetContext(newContext, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Context_driversPackage.CONTEXT_CATEGORY_VALUE__CONTEXT, newContext, newContext));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ContexConfiguration> getIncludedValuesConfiguration() {
        if (includedValuesConfiguration == null) {
            includedValuesConfiguration = new EObjectWithInverseResolvingEList.ManyInverse<ContexConfiguration>(ContexConfiguration.class, this, Context_driversPackage.CONTEXT_CATEGORY_VALUE__INCLUDED_VALUES_CONFIGURATION, Context_driversPackage.CONTEX_CONFIGURATION__INCLUDED_VALUES);
        }
        return includedValuesConfiguration;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ContextCategoryValue> getChildren() {
        if (children == null) {
            children = new EObjectContainmentWithInverseEList.Resolving<ContextCategoryValue>(ContextCategoryValue.class, this, Context_driversPackage.CONTEXT_CATEGORY_VALUE__CHILDREN, Context_driversPackage.CONTEXT_CATEGORY_VALUE__PARENT);
        }
        return children;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ContextCategoryValue getParent() {
        if (eContainerFeatureID() != Context_driversPackage.CONTEXT_CATEGORY_VALUE__PARENT) return null;
        return (ContextCategoryValue)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ContextCategoryValue basicGetParent() {
        if (eContainerFeatureID() != Context_driversPackage.CONTEXT_CATEGORY_VALUE__PARENT) return null;
        return (ContextCategoryValue)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetParent(ContextCategoryValue newParent, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newParent, Context_driversPackage.CONTEXT_CATEGORY_VALUE__PARENT, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setParent(ContextCategoryValue newParent) {
        if (newParent != eInternalContainer() || (eContainerFeatureID() != Context_driversPackage.CONTEXT_CATEGORY_VALUE__PARENT && newParent != null)) {
            if (EcoreUtil.isAncestor(this, newParent))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParent != null)
                msgs = ((InternalEObject)newParent).eInverseAdd(this, Context_driversPackage.CONTEXT_CATEGORY_VALUE__CHILDREN, ContextCategoryValue.class, msgs);
            msgs = basicSetParent(newParent, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Context_driversPackage.CONTEXT_CATEGORY_VALUE__PARENT, newParent, newParent));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ContexConfiguration> getExcludedValuesConfiguration() {
        if (excludedValuesConfiguration == null) {
            excludedValuesConfiguration = new EObjectWithInverseResolvingEList.ManyInverse<ContexConfiguration>(ContexConfiguration.class, this, Context_driversPackage.CONTEXT_CATEGORY_VALUE__EXCLUDED_VALUES_CONFIGURATION, Context_driversPackage.CONTEX_CONFIGURATION__EXCLUDED_VALUES);
        }
        return excludedValuesConfiguration;
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
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__CONTEXT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetContext((ContextCategory)otherEnd, msgs);
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__INCLUDED_VALUES_CONFIGURATION:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncludedValuesConfiguration()).basicAdd(otherEnd, msgs);
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__CHILDREN:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__PARENT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetParent((ContextCategoryValue)otherEnd, msgs);
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__EXCLUDED_VALUES_CONFIGURATION:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getExcludedValuesConfiguration()).basicAdd(otherEnd, msgs);
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
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__CONTEXT:
                return basicSetContext(null, msgs);
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__INCLUDED_VALUES_CONFIGURATION:
                return ((InternalEList<?>)getIncludedValuesConfiguration()).basicRemove(otherEnd, msgs);
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__CHILDREN:
                return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__PARENT:
                return basicSetParent(null, msgs);
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__EXCLUDED_VALUES_CONFIGURATION:
                return ((InternalEList<?>)getExcludedValuesConfiguration()).basicRemove(otherEnd, msgs);
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
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__CONTEXT:
                return eInternalContainer().eInverseRemove(this, Context_driversPackage.CONTEXT_CATEGORY__ROOT_VALUE, ContextCategory.class, msgs);
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__PARENT:
                return eInternalContainer().eInverseRemove(this, Context_driversPackage.CONTEXT_CATEGORY_VALUE__CHILDREN, ContextCategoryValue.class, msgs);
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
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__VALUE:
                return getValue();
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__CONTEXT:
                if (resolve) return getContext();
                return basicGetContext();
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__INCLUDED_VALUES_CONFIGURATION:
                return getIncludedValuesConfiguration();
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__CHILDREN:
                return getChildren();
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__PARENT:
                if (resolve) return getParent();
                return basicGetParent();
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__EXCLUDED_VALUES_CONFIGURATION:
                return getExcludedValuesConfiguration();
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
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__VALUE:
                setValue((String)newValue);
                return;
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__CONTEXT:
                setContext((ContextCategory)newValue);
                return;
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__INCLUDED_VALUES_CONFIGURATION:
                getIncludedValuesConfiguration().clear();
                getIncludedValuesConfiguration().addAll((Collection<? extends ContexConfiguration>)newValue);
                return;
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__CHILDREN:
                getChildren().clear();
                getChildren().addAll((Collection<? extends ContextCategoryValue>)newValue);
                return;
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__PARENT:
                setParent((ContextCategoryValue)newValue);
                return;
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__EXCLUDED_VALUES_CONFIGURATION:
                getExcludedValuesConfiguration().clear();
                getExcludedValuesConfiguration().addAll((Collection<? extends ContexConfiguration>)newValue);
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
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__VALUE:
                setValue(VALUE_EDEFAULT);
                return;
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__CONTEXT:
                setContext((ContextCategory)null);
                return;
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__INCLUDED_VALUES_CONFIGURATION:
                getIncludedValuesConfiguration().clear();
                return;
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__CHILDREN:
                getChildren().clear();
                return;
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__PARENT:
                setParent((ContextCategoryValue)null);
                return;
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__EXCLUDED_VALUES_CONFIGURATION:
                getExcludedValuesConfiguration().clear();
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
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__VALUE:
                return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__CONTEXT:
                return basicGetContext() != null;
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__INCLUDED_VALUES_CONFIGURATION:
                return includedValuesConfiguration != null && !includedValuesConfiguration.isEmpty();
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__CHILDREN:
                return children != null && !children.isEmpty();
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__PARENT:
                return basicGetParent() != null;
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE__EXCLUDED_VALUES_CONFIGURATION:
                return excludedValuesConfiguration != null && !excludedValuesConfiguration.isEmpty();
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
        result.append(" (value: ");
        result.append(value);
        result.append(')');
        return result.toString();
    }

} //ContextCategoryValueImpl
