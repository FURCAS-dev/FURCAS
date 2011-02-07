/**
 * <copyright>
 * </copyright>
 *
 * $Id: ValueSetImpl.java,v 1.1 2011/02/07 17:16:10 auhl Exp $
 */
package configuration.businessconfiguration.impl;

import configuration.businessconfiguration.BusinessOption;
import configuration.businessconfiguration.BusinessconfigurationPackage;
import configuration.businessconfiguration.ValueSet;
import configuration.businessconfiguration.ValueSetEntry;

import data.classes.ClassesPackage;
import data.classes.TypeDefinition;
import data.classes.TypedElement;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configuration.businessconfiguration.impl.ValueSetImpl#getOwnedTypeDefinition <em>Owned Type Definition</em>}</li>
 *   <li>{@link configuration.businessconfiguration.impl.ValueSetImpl#isExtensible <em>Extensible</em>}</li>
 *   <li>{@link configuration.businessconfiguration.impl.ValueSetImpl#getConfigurationBusinessOption <em>Configuration Business Option</em>}</li>
 *   <li>{@link configuration.businessconfiguration.impl.ValueSetImpl#getEntries <em>Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueSetImpl extends NamedElementImpl implements ValueSet {
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
     * The default value of the '{@link #isExtensible() <em>Extensible</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isExtensible()
     * @generated
     * @ordered
     */
	protected static final boolean EXTENSIBLE_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isExtensible() <em>Extensible</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isExtensible()
     * @generated
     * @ordered
     */
	protected boolean extensible = EXTENSIBLE_EDEFAULT;

	/**
     * The cached value of the '{@link #getConfigurationBusinessOption() <em>Configuration Business Option</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getConfigurationBusinessOption()
     * @generated
     * @ordered
     */
	protected BusinessOption configurationBusinessOption;

	/**
     * The cached value of the '{@link #getEntries() <em>Entries</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEntries()
     * @generated
     * @ordered
     */
	protected EList<ValueSetEntry> entries;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ValueSetImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return BusinessconfigurationPackage.Literals.VALUE_SET;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, BusinessconfigurationPackage.VALUE_SET__OWNED_TYPE_DEFINITION, oldOwnedTypeDefinition, ownedTypeDefinition));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BusinessconfigurationPackage.VALUE_SET__OWNED_TYPE_DEFINITION, oldOwnedTypeDefinition, newOwnedTypeDefinition);
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
            eNotify(new ENotificationImpl(this, Notification.SET, BusinessconfigurationPackage.VALUE_SET__OWNED_TYPE_DEFINITION, newOwnedTypeDefinition, newOwnedTypeDefinition));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isExtensible() {
        return extensible;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setExtensible(boolean newExtensible) {
        boolean oldExtensible = extensible;
        extensible = newExtensible;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BusinessconfigurationPackage.VALUE_SET__EXTENSIBLE, oldExtensible, extensible));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BusinessOption getConfigurationBusinessOption() {
        if (configurationBusinessOption != null && configurationBusinessOption.eIsProxy()) {
            InternalEObject oldConfigurationBusinessOption = (InternalEObject)configurationBusinessOption;
            configurationBusinessOption = (BusinessOption)eResolveProxy(oldConfigurationBusinessOption);
            if (configurationBusinessOption != oldConfigurationBusinessOption) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, BusinessconfigurationPackage.VALUE_SET__CONFIGURATION_BUSINESS_OPTION, oldConfigurationBusinessOption, configurationBusinessOption));
            }
        }
        return configurationBusinessOption;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BusinessOption basicGetConfigurationBusinessOption() {
        return configurationBusinessOption;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetConfigurationBusinessOption(BusinessOption newConfigurationBusinessOption, NotificationChain msgs) {
        BusinessOption oldConfigurationBusinessOption = configurationBusinessOption;
        configurationBusinessOption = newConfigurationBusinessOption;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BusinessconfigurationPackage.VALUE_SET__CONFIGURATION_BUSINESS_OPTION, oldConfigurationBusinessOption, newConfigurationBusinessOption);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setConfigurationBusinessOption(BusinessOption newConfigurationBusinessOption) {
        if (newConfigurationBusinessOption != configurationBusinessOption) {
            NotificationChain msgs = null;
            if (configurationBusinessOption != null)
                msgs = ((InternalEObject)configurationBusinessOption).eInverseRemove(this, BusinessconfigurationPackage.BUSINESS_OPTION__VALUE_SET, BusinessOption.class, msgs);
            if (newConfigurationBusinessOption != null)
                msgs = ((InternalEObject)newConfigurationBusinessOption).eInverseAdd(this, BusinessconfigurationPackage.BUSINESS_OPTION__VALUE_SET, BusinessOption.class, msgs);
            msgs = basicSetConfigurationBusinessOption(newConfigurationBusinessOption, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BusinessconfigurationPackage.VALUE_SET__CONFIGURATION_BUSINESS_OPTION, newConfigurationBusinessOption, newConfigurationBusinessOption));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ValueSetEntry> getEntries() {
        if (entries == null) {
            entries = new EObjectContainmentWithInverseEList.Resolving<ValueSetEntry>(ValueSetEntry.class, this, BusinessconfigurationPackage.VALUE_SET__ENTRIES, BusinessconfigurationPackage.VALUE_SET_ENTRY__VALUE_SET);
        }
        return entries;
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case BusinessconfigurationPackage.VALUE_SET__OWNED_TYPE_DEFINITION:
                if (ownedTypeDefinition != null)
                    msgs = ((InternalEObject)ownedTypeDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BusinessconfigurationPackage.VALUE_SET__OWNED_TYPE_DEFINITION, null, msgs);
                return basicSetOwnedTypeDefinition((TypeDefinition)otherEnd, msgs);
            case BusinessconfigurationPackage.VALUE_SET__CONFIGURATION_BUSINESS_OPTION:
                if (configurationBusinessOption != null)
                    msgs = ((InternalEObject)configurationBusinessOption).eInverseRemove(this, BusinessconfigurationPackage.BUSINESS_OPTION__VALUE_SET, BusinessOption.class, msgs);
                return basicSetConfigurationBusinessOption((BusinessOption)otherEnd, msgs);
            case BusinessconfigurationPackage.VALUE_SET__ENTRIES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getEntries()).basicAdd(otherEnd, msgs);
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
            case BusinessconfigurationPackage.VALUE_SET__OWNED_TYPE_DEFINITION:
                return basicSetOwnedTypeDefinition(null, msgs);
            case BusinessconfigurationPackage.VALUE_SET__CONFIGURATION_BUSINESS_OPTION:
                return basicSetConfigurationBusinessOption(null, msgs);
            case BusinessconfigurationPackage.VALUE_SET__ENTRIES:
                return ((InternalEList<?>)getEntries()).basicRemove(otherEnd, msgs);
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
            case BusinessconfigurationPackage.VALUE_SET__OWNED_TYPE_DEFINITION:
                if (resolve) return getOwnedTypeDefinition();
                return basicGetOwnedTypeDefinition();
            case BusinessconfigurationPackage.VALUE_SET__EXTENSIBLE:
                return isExtensible();
            case BusinessconfigurationPackage.VALUE_SET__CONFIGURATION_BUSINESS_OPTION:
                if (resolve) return getConfigurationBusinessOption();
                return basicGetConfigurationBusinessOption();
            case BusinessconfigurationPackage.VALUE_SET__ENTRIES:
                return getEntries();
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
            case BusinessconfigurationPackage.VALUE_SET__OWNED_TYPE_DEFINITION:
                setOwnedTypeDefinition((TypeDefinition)newValue);
                return;
            case BusinessconfigurationPackage.VALUE_SET__EXTENSIBLE:
                setExtensible((Boolean)newValue);
                return;
            case BusinessconfigurationPackage.VALUE_SET__CONFIGURATION_BUSINESS_OPTION:
                setConfigurationBusinessOption((BusinessOption)newValue);
                return;
            case BusinessconfigurationPackage.VALUE_SET__ENTRIES:
                getEntries().clear();
                getEntries().addAll((Collection<? extends ValueSetEntry>)newValue);
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
            case BusinessconfigurationPackage.VALUE_SET__OWNED_TYPE_DEFINITION:
                setOwnedTypeDefinition((TypeDefinition)null);
                return;
            case BusinessconfigurationPackage.VALUE_SET__EXTENSIBLE:
                setExtensible(EXTENSIBLE_EDEFAULT);
                return;
            case BusinessconfigurationPackage.VALUE_SET__CONFIGURATION_BUSINESS_OPTION:
                setConfigurationBusinessOption((BusinessOption)null);
                return;
            case BusinessconfigurationPackage.VALUE_SET__ENTRIES:
                getEntries().clear();
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
            case BusinessconfigurationPackage.VALUE_SET__OWNED_TYPE_DEFINITION:
                return ownedTypeDefinition != null;
            case BusinessconfigurationPackage.VALUE_SET__EXTENSIBLE:
                return extensible != EXTENSIBLE_EDEFAULT;
            case BusinessconfigurationPackage.VALUE_SET__CONFIGURATION_BUSINESS_OPTION:
                return configurationBusinessOption != null;
            case BusinessconfigurationPackage.VALUE_SET__ENTRIES:
                return entries != null && !entries.isEmpty();
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
                case BusinessconfigurationPackage.VALUE_SET__OWNED_TYPE_DEFINITION: return ClassesPackage.TYPED_ELEMENT__OWNED_TYPE_DEFINITION;
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
                case ClassesPackage.TYPED_ELEMENT__OWNED_TYPE_DEFINITION: return BusinessconfigurationPackage.VALUE_SET__OWNED_TYPE_DEFINITION;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
        result.append(" (extensible: ");
        result.append(extensible);
        result.append(')');
        return result.toString();
    }

} //ValueSetImpl
