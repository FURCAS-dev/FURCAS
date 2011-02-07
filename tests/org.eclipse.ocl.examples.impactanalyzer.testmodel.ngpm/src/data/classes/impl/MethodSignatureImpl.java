/**
 * <copyright>
 * </copyright>
 *
 * $Id: MethodSignatureImpl.java,v 1.1 2011/02/07 17:16:10 auhl Exp $
 */
package data.classes.impl;

import behavioral.events.EventProducer;
import behavioral.events.EventsPackage;

import data.classes.ClassesPackage;
import data.classes.ConverterBetweenParametrizations;
import data.classes.MethodSignature;
import data.classes.SignatureImplementation;
import data.classes.SignatureOwner;

import java.lang.reflect.InvocationTargetException;

import localization.TranslatableText;

import modelmanagement.ModelmanagementPackage;
import modelmanagement.NamedElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method Signature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.MethodSignatureImpl#getName <em>Name</em>}</li>
 *   <li>{@link data.classes.impl.MethodSignatureImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link data.classes.impl.MethodSignatureImpl#getProducer <em>Producer</em>}</li>
 *   <li>{@link data.classes.impl.MethodSignatureImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link data.classes.impl.MethodSignatureImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link data.classes.impl.MethodSignatureImpl#getConverter <em>Converter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MethodSignatureImpl extends SignatureImpl implements MethodSignature {
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
     * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
	protected TranslatableText description;

	/**
     * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImplementation()
     * @generated
     * @ordered
     */
	protected SignatureImplementation implementation;

	/**
     * The cached value of the '{@link #getConverter() <em>Converter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getConverter()
     * @generated
     * @ordered
     */
	protected ConverterBetweenParametrizations converter;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected MethodSignatureImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.METHOD_SIGNATURE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.METHOD_SIGNATURE__NAME, oldName, name));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TranslatableText getDescription() {
        return description;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetDescription(TranslatableText newDescription, NotificationChain msgs) {
        TranslatableText oldDescription = description;
        description = newDescription;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.METHOD_SIGNATURE__DESCRIPTION, oldDescription, newDescription);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDescription(TranslatableText newDescription) {
        if (newDescription != description) {
            NotificationChain msgs = null;
            if (description != null)
                msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.METHOD_SIGNATURE__DESCRIPTION, null, msgs);
            if (newDescription != null)
                msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.METHOD_SIGNATURE__DESCRIPTION, null, msgs);
            msgs = basicSetDescription(newDescription, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.METHOD_SIGNATURE__DESCRIPTION, newDescription, newDescription));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EventProducer getProducer() {
        if (eContainerFeatureID() != ClassesPackage.METHOD_SIGNATURE__PRODUCER) return null;
        return (EventProducer)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventProducer basicGetProducer() {
        if (eContainerFeatureID() != ClassesPackage.METHOD_SIGNATURE__PRODUCER) return null;
        return (EventProducer)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetProducer(EventProducer newProducer, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newProducer, ClassesPackage.METHOD_SIGNATURE__PRODUCER, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setProducer(EventProducer newProducer) {
        if (newProducer != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.METHOD_SIGNATURE__PRODUCER && newProducer != null)) {
            if (EcoreUtil.isAncestor(this, newProducer))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newProducer != null)
                msgs = ((InternalEObject)newProducer).eInverseAdd(this, EventsPackage.EVENT_PRODUCER__NOTIFICATION_SIGNATURES, EventProducer.class, msgs);
            msgs = basicSetProducer(newProducer, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.METHOD_SIGNATURE__PRODUCER, newProducer, newProducer));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SignatureImplementation getImplementation() {
        if (implementation != null && implementation.eIsProxy()) {
            InternalEObject oldImplementation = (InternalEObject)implementation;
            implementation = (SignatureImplementation)eResolveProxy(oldImplementation);
            if (implementation != oldImplementation) {
                InternalEObject newImplementation = (InternalEObject)implementation;
                NotificationChain msgs =  oldImplementation.eInverseRemove(this, ClassesPackage.SIGNATURE_IMPLEMENTATION__IMPLEMENTS_, SignatureImplementation.class, null);
                if (newImplementation.eInternalContainer() == null) {
                    msgs =  newImplementation.eInverseAdd(this, ClassesPackage.SIGNATURE_IMPLEMENTATION__IMPLEMENTS_, SignatureImplementation.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.METHOD_SIGNATURE__IMPLEMENTATION, oldImplementation, implementation));
            }
        }
        return implementation;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SignatureImplementation basicGetImplementation() {
        return implementation;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetImplementation(SignatureImplementation newImplementation, NotificationChain msgs) {
        SignatureImplementation oldImplementation = implementation;
        implementation = newImplementation;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.METHOD_SIGNATURE__IMPLEMENTATION, oldImplementation, newImplementation);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setImplementation(SignatureImplementation newImplementation) {
        if (newImplementation != implementation) {
            NotificationChain msgs = null;
            if (implementation != null)
                msgs = ((InternalEObject)implementation).eInverseRemove(this, ClassesPackage.SIGNATURE_IMPLEMENTATION__IMPLEMENTS_, SignatureImplementation.class, msgs);
            if (newImplementation != null)
                msgs = ((InternalEObject)newImplementation).eInverseAdd(this, ClassesPackage.SIGNATURE_IMPLEMENTATION__IMPLEMENTS_, SignatureImplementation.class, msgs);
            msgs = basicSetImplementation(newImplementation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.METHOD_SIGNATURE__IMPLEMENTATION, newImplementation, newImplementation));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SignatureOwner getOwner() {
        if (eContainerFeatureID() != ClassesPackage.METHOD_SIGNATURE__OWNER) return null;
        return (SignatureOwner)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SignatureOwner basicGetOwner() {
        if (eContainerFeatureID() != ClassesPackage.METHOD_SIGNATURE__OWNER) return null;
        return (SignatureOwner)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetOwner(SignatureOwner newOwner, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOwner, ClassesPackage.METHOD_SIGNATURE__OWNER, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOwner(SignatureOwner newOwner) {
        if (newOwner != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.METHOD_SIGNATURE__OWNER && newOwner != null)) {
            if (EcoreUtil.isAncestor(this, newOwner))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOwner != null)
                msgs = ((InternalEObject)newOwner).eInverseAdd(this, ClassesPackage.SIGNATURE_OWNER__OWNED_SIGNATURES, SignatureOwner.class, msgs);
            msgs = basicSetOwner(newOwner, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.METHOD_SIGNATURE__OWNER, newOwner, newOwner));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ConverterBetweenParametrizations getConverter() {
        if (converter != null && converter.eIsProxy()) {
            InternalEObject oldConverter = (InternalEObject)converter;
            converter = (ConverterBetweenParametrizations)eResolveProxy(oldConverter);
            if (converter != oldConverter) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.METHOD_SIGNATURE__CONVERTER, oldConverter, converter));
            }
        }
        return converter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ConverterBetweenParametrizations basicGetConverter() {
        return converter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetConverter(ConverterBetweenParametrizations newConverter, NotificationChain msgs) {
        ConverterBetweenParametrizations oldConverter = converter;
        converter = newConverter;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.METHOD_SIGNATURE__CONVERTER, oldConverter, newConverter);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setConverter(ConverterBetweenParametrizations newConverter) {
        if (newConverter != converter) {
            NotificationChain msgs = null;
            if (converter != null)
                msgs = ((InternalEObject)converter).eInverseRemove(this, ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CONVERSION_METHOD, ConverterBetweenParametrizations.class, msgs);
            if (newConverter != null)
                msgs = ((InternalEObject)newConverter).eInverseAdd(this, ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CONVERSION_METHOD, ConverterBetweenParametrizations.class, msgs);
            msgs = basicSetConverter(newConverter, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.METHOD_SIGNATURE__CONVERTER, newConverter, newConverter));
    }

	/**
     * The cached invocation delegate for the '{@link #isAbstract() <em>Is Abstract</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isAbstract()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate IS_ABSTRACT__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.METHOD_SIGNATURE.getEOperations().get(0)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isAbstract() {
        try {
            return (Boolean)IS_ABSTRACT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
            case ClassesPackage.METHOD_SIGNATURE__PRODUCER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetProducer((EventProducer)otherEnd, msgs);
            case ClassesPackage.METHOD_SIGNATURE__IMPLEMENTATION:
                if (implementation != null)
                    msgs = ((InternalEObject)implementation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.METHOD_SIGNATURE__IMPLEMENTATION, null, msgs);
                return basicSetImplementation((SignatureImplementation)otherEnd, msgs);
            case ClassesPackage.METHOD_SIGNATURE__OWNER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOwner((SignatureOwner)otherEnd, msgs);
            case ClassesPackage.METHOD_SIGNATURE__CONVERTER:
                if (converter != null)
                    msgs = ((InternalEObject)converter).eInverseRemove(this, ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CONVERSION_METHOD, ConverterBetweenParametrizations.class, msgs);
                return basicSetConverter((ConverterBetweenParametrizations)otherEnd, msgs);
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
            case ClassesPackage.METHOD_SIGNATURE__DESCRIPTION:
                return basicSetDescription(null, msgs);
            case ClassesPackage.METHOD_SIGNATURE__PRODUCER:
                return basicSetProducer(null, msgs);
            case ClassesPackage.METHOD_SIGNATURE__IMPLEMENTATION:
                return basicSetImplementation(null, msgs);
            case ClassesPackage.METHOD_SIGNATURE__OWNER:
                return basicSetOwner(null, msgs);
            case ClassesPackage.METHOD_SIGNATURE__CONVERTER:
                return basicSetConverter(null, msgs);
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
            case ClassesPackage.METHOD_SIGNATURE__PRODUCER:
                return eInternalContainer().eInverseRemove(this, EventsPackage.EVENT_PRODUCER__NOTIFICATION_SIGNATURES, EventProducer.class, msgs);
            case ClassesPackage.METHOD_SIGNATURE__OWNER:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.SIGNATURE_OWNER__OWNED_SIGNATURES, SignatureOwner.class, msgs);
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
            case ClassesPackage.METHOD_SIGNATURE__NAME:
                return getName();
            case ClassesPackage.METHOD_SIGNATURE__DESCRIPTION:
                return getDescription();
            case ClassesPackage.METHOD_SIGNATURE__PRODUCER:
                if (resolve) return getProducer();
                return basicGetProducer();
            case ClassesPackage.METHOD_SIGNATURE__IMPLEMENTATION:
                if (resolve) return getImplementation();
                return basicGetImplementation();
            case ClassesPackage.METHOD_SIGNATURE__OWNER:
                if (resolve) return getOwner();
                return basicGetOwner();
            case ClassesPackage.METHOD_SIGNATURE__CONVERTER:
                if (resolve) return getConverter();
                return basicGetConverter();
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
            case ClassesPackage.METHOD_SIGNATURE__NAME:
                setName((String)newValue);
                return;
            case ClassesPackage.METHOD_SIGNATURE__DESCRIPTION:
                setDescription((TranslatableText)newValue);
                return;
            case ClassesPackage.METHOD_SIGNATURE__PRODUCER:
                setProducer((EventProducer)newValue);
                return;
            case ClassesPackage.METHOD_SIGNATURE__IMPLEMENTATION:
                setImplementation((SignatureImplementation)newValue);
                return;
            case ClassesPackage.METHOD_SIGNATURE__OWNER:
                setOwner((SignatureOwner)newValue);
                return;
            case ClassesPackage.METHOD_SIGNATURE__CONVERTER:
                setConverter((ConverterBetweenParametrizations)newValue);
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
            case ClassesPackage.METHOD_SIGNATURE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case ClassesPackage.METHOD_SIGNATURE__DESCRIPTION:
                setDescription((TranslatableText)null);
                return;
            case ClassesPackage.METHOD_SIGNATURE__PRODUCER:
                setProducer((EventProducer)null);
                return;
            case ClassesPackage.METHOD_SIGNATURE__IMPLEMENTATION:
                setImplementation((SignatureImplementation)null);
                return;
            case ClassesPackage.METHOD_SIGNATURE__OWNER:
                setOwner((SignatureOwner)null);
                return;
            case ClassesPackage.METHOD_SIGNATURE__CONVERTER:
                setConverter((ConverterBetweenParametrizations)null);
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
            case ClassesPackage.METHOD_SIGNATURE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case ClassesPackage.METHOD_SIGNATURE__DESCRIPTION:
                return description != null;
            case ClassesPackage.METHOD_SIGNATURE__PRODUCER:
                return basicGetProducer() != null;
            case ClassesPackage.METHOD_SIGNATURE__IMPLEMENTATION:
                return implementation != null;
            case ClassesPackage.METHOD_SIGNATURE__OWNER:
                return basicGetOwner() != null;
            case ClassesPackage.METHOD_SIGNATURE__CONVERTER:
                return converter != null;
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
        if (baseClass == NamedElement.class) {
            switch (derivedFeatureID) {
                case ClassesPackage.METHOD_SIGNATURE__NAME: return ModelmanagementPackage.NAMED_ELEMENT__NAME;
                case ClassesPackage.METHOD_SIGNATURE__DESCRIPTION: return ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;
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
        if (baseClass == NamedElement.class) {
            switch (baseFeatureID) {
                case ModelmanagementPackage.NAMED_ELEMENT__NAME: return ClassesPackage.METHOD_SIGNATURE__NAME;
                case ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION: return ClassesPackage.METHOD_SIGNATURE__DESCRIPTION;
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
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //MethodSignatureImpl
