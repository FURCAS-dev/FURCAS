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
import configuration.context_drivers.ContextualElement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contex Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configuration.context_drivers.impl.ContexConfigurationImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link configuration.context_drivers.impl.ContexConfigurationImpl#getIncludedValues <em>Included Values</em>}</li>
 *   <li>{@link configuration.context_drivers.impl.ContexConfigurationImpl#getConfiguredElement <em>Configured Element</em>}</li>
 *   <li>{@link configuration.context_drivers.impl.ContexConfigurationImpl#getExcludedValues <em>Excluded Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContexConfigurationImpl extends EObjectImpl implements ContexConfiguration {
	/**
     * The cached value of the '{@link #getCategory() <em>Category</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCategory()
     * @generated
     * @ordered
     */
	protected ContextCategory category;

	/**
     * The cached value of the '{@link #getIncludedValues() <em>Included Values</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIncludedValues()
     * @generated
     * @ordered
     */
	protected EList<ContextCategoryValue> includedValues;

	/**
     * The cached value of the '{@link #getExcludedValues() <em>Excluded Values</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getExcludedValues()
     * @generated
     * @ordered
     */
	protected EList<ContextCategoryValue> excludedValues;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ContexConfigurationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Context_driversPackage.Literals.CONTEX_CONFIGURATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ContextCategory getCategory() {
        if (category != null && category.eIsProxy()) {
            InternalEObject oldCategory = (InternalEObject)category;
            category = (ContextCategory)eResolveProxy(oldCategory);
            if (category != oldCategory) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Context_driversPackage.CONTEX_CONFIGURATION__CATEGORY, oldCategory, category));
            }
        }
        return category;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ContextCategory basicGetCategory() {
        return category;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetCategory(ContextCategory newCategory, NotificationChain msgs) {
        ContextCategory oldCategory = category;
        category = newCategory;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Context_driversPackage.CONTEX_CONFIGURATION__CATEGORY, oldCategory, newCategory);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCategory(ContextCategory newCategory) {
        if (newCategory != category) {
            NotificationChain msgs = null;
            if (category != null)
                msgs = ((InternalEObject)category).eInverseRemove(this, Context_driversPackage.CONTEXT_CATEGORY__CATEGORY_CONFIGURATION, ContextCategory.class, msgs);
            if (newCategory != null)
                msgs = ((InternalEObject)newCategory).eInverseAdd(this, Context_driversPackage.CONTEXT_CATEGORY__CATEGORY_CONFIGURATION, ContextCategory.class, msgs);
            msgs = basicSetCategory(newCategory, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Context_driversPackage.CONTEX_CONFIGURATION__CATEGORY, newCategory, newCategory));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ContextCategoryValue> getIncludedValues() {
        if (includedValues == null) {
            includedValues = new EObjectWithInverseResolvingEList.ManyInverse<ContextCategoryValue>(ContextCategoryValue.class, this, Context_driversPackage.CONTEX_CONFIGURATION__INCLUDED_VALUES, Context_driversPackage.CONTEXT_CATEGORY_VALUE__INCLUDED_VALUES_CONFIGURATION);
        }
        return includedValues;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ContextualElement getConfiguredElement() {
        if (eContainerFeatureID() != Context_driversPackage.CONTEX_CONFIGURATION__CONFIGURED_ELEMENT) return null;
        return (ContextualElement)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ContextualElement basicGetConfiguredElement() {
        if (eContainerFeatureID() != Context_driversPackage.CONTEX_CONFIGURATION__CONFIGURED_ELEMENT) return null;
        return (ContextualElement)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetConfiguredElement(ContextualElement newConfiguredElement, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newConfiguredElement, Context_driversPackage.CONTEX_CONFIGURATION__CONFIGURED_ELEMENT, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setConfiguredElement(ContextualElement newConfiguredElement) {
        if (newConfiguredElement != eInternalContainer() || (eContainerFeatureID() != Context_driversPackage.CONTEX_CONFIGURATION__CONFIGURED_ELEMENT && newConfiguredElement != null)) {
            if (EcoreUtil.isAncestor(this, newConfiguredElement))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newConfiguredElement != null)
                msgs = ((InternalEObject)newConfiguredElement).eInverseAdd(this, Context_driversPackage.CONTEXTUAL_ELEMENT__CONTEXTUAL_ELEMENT_CONFIGURATION, ContextualElement.class, msgs);
            msgs = basicSetConfiguredElement(newConfiguredElement, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Context_driversPackage.CONTEX_CONFIGURATION__CONFIGURED_ELEMENT, newConfiguredElement, newConfiguredElement));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ContextCategoryValue> getExcludedValues() {
        if (excludedValues == null) {
            excludedValues = new EObjectWithInverseResolvingEList.ManyInverse<ContextCategoryValue>(ContextCategoryValue.class, this, Context_driversPackage.CONTEX_CONFIGURATION__EXCLUDED_VALUES, Context_driversPackage.CONTEXT_CATEGORY_VALUE__EXCLUDED_VALUES_CONFIGURATION);
        }
        return excludedValues;
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
            case Context_driversPackage.CONTEX_CONFIGURATION__CATEGORY:
                if (category != null)
                    msgs = ((InternalEObject)category).eInverseRemove(this, Context_driversPackage.CONTEXT_CATEGORY__CATEGORY_CONFIGURATION, ContextCategory.class, msgs);
                return basicSetCategory((ContextCategory)otherEnd, msgs);
            case Context_driversPackage.CONTEX_CONFIGURATION__INCLUDED_VALUES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncludedValues()).basicAdd(otherEnd, msgs);
            case Context_driversPackage.CONTEX_CONFIGURATION__CONFIGURED_ELEMENT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetConfiguredElement((ContextualElement)otherEnd, msgs);
            case Context_driversPackage.CONTEX_CONFIGURATION__EXCLUDED_VALUES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getExcludedValues()).basicAdd(otherEnd, msgs);
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
            case Context_driversPackage.CONTEX_CONFIGURATION__CATEGORY:
                return basicSetCategory(null, msgs);
            case Context_driversPackage.CONTEX_CONFIGURATION__INCLUDED_VALUES:
                return ((InternalEList<?>)getIncludedValues()).basicRemove(otherEnd, msgs);
            case Context_driversPackage.CONTEX_CONFIGURATION__CONFIGURED_ELEMENT:
                return basicSetConfiguredElement(null, msgs);
            case Context_driversPackage.CONTEX_CONFIGURATION__EXCLUDED_VALUES:
                return ((InternalEList<?>)getExcludedValues()).basicRemove(otherEnd, msgs);
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
            case Context_driversPackage.CONTEX_CONFIGURATION__CONFIGURED_ELEMENT:
                return eInternalContainer().eInverseRemove(this, Context_driversPackage.CONTEXTUAL_ELEMENT__CONTEXTUAL_ELEMENT_CONFIGURATION, ContextualElement.class, msgs);
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
            case Context_driversPackage.CONTEX_CONFIGURATION__CATEGORY:
                if (resolve) return getCategory();
                return basicGetCategory();
            case Context_driversPackage.CONTEX_CONFIGURATION__INCLUDED_VALUES:
                return getIncludedValues();
            case Context_driversPackage.CONTEX_CONFIGURATION__CONFIGURED_ELEMENT:
                if (resolve) return getConfiguredElement();
                return basicGetConfiguredElement();
            case Context_driversPackage.CONTEX_CONFIGURATION__EXCLUDED_VALUES:
                return getExcludedValues();
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
            case Context_driversPackage.CONTEX_CONFIGURATION__CATEGORY:
                setCategory((ContextCategory)newValue);
                return;
            case Context_driversPackage.CONTEX_CONFIGURATION__INCLUDED_VALUES:
                getIncludedValues().clear();
                getIncludedValues().addAll((Collection<? extends ContextCategoryValue>)newValue);
                return;
            case Context_driversPackage.CONTEX_CONFIGURATION__CONFIGURED_ELEMENT:
                setConfiguredElement((ContextualElement)newValue);
                return;
            case Context_driversPackage.CONTEX_CONFIGURATION__EXCLUDED_VALUES:
                getExcludedValues().clear();
                getExcludedValues().addAll((Collection<? extends ContextCategoryValue>)newValue);
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
            case Context_driversPackage.CONTEX_CONFIGURATION__CATEGORY:
                setCategory((ContextCategory)null);
                return;
            case Context_driversPackage.CONTEX_CONFIGURATION__INCLUDED_VALUES:
                getIncludedValues().clear();
                return;
            case Context_driversPackage.CONTEX_CONFIGURATION__CONFIGURED_ELEMENT:
                setConfiguredElement((ContextualElement)null);
                return;
            case Context_driversPackage.CONTEX_CONFIGURATION__EXCLUDED_VALUES:
                getExcludedValues().clear();
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
            case Context_driversPackage.CONTEX_CONFIGURATION__CATEGORY:
                return category != null;
            case Context_driversPackage.CONTEX_CONFIGURATION__INCLUDED_VALUES:
                return includedValues != null && !includedValues.isEmpty();
            case Context_driversPackage.CONTEX_CONFIGURATION__CONFIGURED_ELEMENT:
                return basicGetConfiguredElement() != null;
            case Context_driversPackage.CONTEX_CONFIGURATION__EXCLUDED_VALUES:
                return excludedValues != null && !excludedValues.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //ContexConfigurationImpl
