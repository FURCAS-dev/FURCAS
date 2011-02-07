/**
 * <copyright>
 * </copyright>
 *
 * $Id: TypeDefinitionImpl.java,v 1.1 2011/02/07 17:16:10 auhl Exp $
 */
package data.classes.impl;

import data.classes.ClassesPackage;
import data.classes.NamedValue;
import data.classes.SapClass;
import data.classes.Signature;
import data.classes.TypeDefinition;
import data.classes.TypedElement;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.TypeDefinitionImpl#getSignaturesWithOutput <em>Signatures With Output</em>}</li>
 *   <li>{@link data.classes.impl.TypeDefinitionImpl#getOwnerTypedElement <em>Owner Typed Element</em>}</li>
 *   <li>{@link data.classes.impl.TypeDefinitionImpl#getOwnerSignature <em>Owner Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TypeDefinitionImpl extends MultiplicityImpl implements TypeDefinition {
	/**
     * The cached value of the '{@link #getSignaturesWithOutput() <em>Signatures With Output</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSignaturesWithOutput()
     * @generated
     * @ordered
     */
	protected EList<Signature> signaturesWithOutput;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected TypeDefinitionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.TYPE_DEFINITION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Signature> getSignaturesWithOutput() {
        if (signaturesWithOutput == null) {
            signaturesWithOutput = new EObjectWithInverseResolvingEList<Signature>(Signature.class, this, ClassesPackage.TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT, ClassesPackage.SIGNATURE__OUTPUT);
        }
        return signaturesWithOutput;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypedElement getOwnerTypedElement() {
        if (eContainerFeatureID() != ClassesPackage.TYPE_DEFINITION__OWNER_TYPED_ELEMENT) return null;
        return (TypedElement)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TypedElement basicGetOwnerTypedElement() {
        if (eContainerFeatureID() != ClassesPackage.TYPE_DEFINITION__OWNER_TYPED_ELEMENT) return null;
        return (TypedElement)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetOwnerTypedElement(TypedElement newOwnerTypedElement, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOwnerTypedElement, ClassesPackage.TYPE_DEFINITION__OWNER_TYPED_ELEMENT, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOwnerTypedElement(TypedElement newOwnerTypedElement) {
        if (newOwnerTypedElement != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.TYPE_DEFINITION__OWNER_TYPED_ELEMENT && newOwnerTypedElement != null)) {
            if (EcoreUtil.isAncestor(this, newOwnerTypedElement))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOwnerTypedElement != null)
                msgs = ((InternalEObject)newOwnerTypedElement).eInverseAdd(this, ClassesPackage.TYPED_ELEMENT__OWNED_TYPE_DEFINITION, TypedElement.class, msgs);
            msgs = basicSetOwnerTypedElement(newOwnerTypedElement, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.TYPE_DEFINITION__OWNER_TYPED_ELEMENT, newOwnerTypedElement, newOwnerTypedElement));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Signature getOwnerSignature() {
        if (eContainerFeatureID() != ClassesPackage.TYPE_DEFINITION__OWNER_SIGNATURE) return null;
        return (Signature)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Signature basicGetOwnerSignature() {
        if (eContainerFeatureID() != ClassesPackage.TYPE_DEFINITION__OWNER_SIGNATURE) return null;
        return (Signature)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetOwnerSignature(Signature newOwnerSignature, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOwnerSignature, ClassesPackage.TYPE_DEFINITION__OWNER_SIGNATURE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOwnerSignature(Signature newOwnerSignature) {
        if (newOwnerSignature != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.TYPE_DEFINITION__OWNER_SIGNATURE && newOwnerSignature != null)) {
            if (EcoreUtil.isAncestor(this, newOwnerSignature))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOwnerSignature != null)
                msgs = ((InternalEObject)newOwnerSignature).eInverseAdd(this, ClassesPackage.SIGNATURE__OWNED_TYPE_DEFINITIONS, Signature.class, msgs);
            msgs = basicSetOwnerSignature(newOwnerSignature, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.TYPE_DEFINITION__OWNER_SIGNATURE, newOwnerSignature, newOwnerSignature));
    }

	/**
     * The cached invocation delegate for the '{@link #conformsTo(data.classes.TypeDefinition) <em>Conforms To</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #conformsTo(data.classes.TypeDefinition)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate CONFORMS_TO_TYPE_DEFINITION__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.TYPE_DEFINITION.getEOperations().get(0)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean conformsTo(TypeDefinition typeDef) {
        try {
            return (Boolean)CONFORMS_TO_TYPE_DEFINITION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{typeDef}));
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #conformsToExcluding(data.classes.TypeDefinition, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Conforms To Excluding</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #conformsToExcluding(data.classes.TypeDefinition, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate CONFORMS_TO_EXCLUDING_TYPE_DEFINITION_ELIST_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.TYPE_DEFINITION.getEOperations().get(1)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean conformsToExcluding(TypeDefinition td, EList<SapClass> excludingConforming, EList<SapClass> excludingTo) {
        try {
            return (Boolean)CONFORMS_TO_EXCLUDING_TYPE_DEFINITION_ELIST_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(3, new Object[]{td, excludingConforming, excludingTo}));
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #multiplicityConformsTo(data.classes.TypeDefinition) <em>Multiplicity Conforms To</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #multiplicityConformsTo(data.classes.TypeDefinition)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate MULTIPLICITY_CONFORMS_TO_TYPE_DEFINITION__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.TYPE_DEFINITION.getEOperations().get(2)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean multiplicityConformsTo(TypeDefinition td) {
        try {
            return (Boolean)MULTIPLICITY_CONFORMS_TO_TYPE_DEFINITION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{td}));
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #conformsToIgnoringMultiplicityExcluding(data.classes.TypeDefinition, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Conforms To Ignoring Multiplicity Excluding</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #conformsToIgnoringMultiplicityExcluding(data.classes.TypeDefinition, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate CONFORMS_TO_IGNORING_MULTIPLICITY_EXCLUDING_TYPE_DEFINITION_ELIST_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.TYPE_DEFINITION.getEOperations().get(3)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean conformsToIgnoringMultiplicityExcluding(TypeDefinition td, EList<SapClass> excludingConforming, EList<SapClass> excludingTo) {
        try {
            return (Boolean)CONFORMS_TO_IGNORING_MULTIPLICITY_EXCLUDING_TYPE_DEFINITION_ELIST_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(3, new Object[]{td, excludingConforming, excludingTo}));
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #conformsToIgnoringMultiplicity(data.classes.TypeDefinition) <em>Conforms To Ignoring Multiplicity</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #conformsToIgnoringMultiplicity(data.classes.TypeDefinition)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate CONFORMS_TO_IGNORING_MULTIPLICITY_TYPE_DEFINITION__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.TYPE_DEFINITION.getEOperations().get(4)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean conformsToIgnoringMultiplicity(TypeDefinition typeDef) {
        try {
            return (Boolean)CONFORMS_TO_IGNORING_MULTIPLICITY_TYPE_DEFINITION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{typeDef}));
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #getTypeUsage() <em>Get Type Usage</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeUsage()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_TYPE_USAGE__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.TYPE_DEFINITION.getEOperations().get(5)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<TypedElement> getTypeUsage() {
        try {
            return (EList<TypedElement>)GET_TYPE_USAGE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #getInnermost() <em>Get Innermost</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getInnermost()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_INNERMOST__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.TYPE_DEFINITION.getEOperations().get(6)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeDefinition getInnermost() {
        try {
            return (TypeDefinition)GET_INNERMOST__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #getNestingLevel() <em>Get Nesting Level</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNestingLevel()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_NESTING_LEVEL__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.TYPE_DEFINITION.getEOperations().get(7)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getNestingLevel() {
        try {
            return (Integer)GET_NESTING_LEVEL__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #getNamedValuesInScope() <em>Get Named Values In Scope</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNamedValuesInScope()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_NAMED_VALUES_IN_SCOPE__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.TYPE_DEFINITION.getEOperations().get(8)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<NamedValue> getNamedValuesInScope() {
        try {
            return (EList<NamedValue>)GET_NAMED_VALUES_IN_SCOPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
            case ClassesPackage.TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSignaturesWithOutput()).basicAdd(otherEnd, msgs);
            case ClassesPackage.TYPE_DEFINITION__OWNER_TYPED_ELEMENT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOwnerTypedElement((TypedElement)otherEnd, msgs);
            case ClassesPackage.TYPE_DEFINITION__OWNER_SIGNATURE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOwnerSignature((Signature)otherEnd, msgs);
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
            case ClassesPackage.TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT:
                return ((InternalEList<?>)getSignaturesWithOutput()).basicRemove(otherEnd, msgs);
            case ClassesPackage.TYPE_DEFINITION__OWNER_TYPED_ELEMENT:
                return basicSetOwnerTypedElement(null, msgs);
            case ClassesPackage.TYPE_DEFINITION__OWNER_SIGNATURE:
                return basicSetOwnerSignature(null, msgs);
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
            case ClassesPackage.TYPE_DEFINITION__OWNER_TYPED_ELEMENT:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.TYPED_ELEMENT__OWNED_TYPE_DEFINITION, TypedElement.class, msgs);
            case ClassesPackage.TYPE_DEFINITION__OWNER_SIGNATURE:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.SIGNATURE__OWNED_TYPE_DEFINITIONS, Signature.class, msgs);
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
            case ClassesPackage.TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT:
                return getSignaturesWithOutput();
            case ClassesPackage.TYPE_DEFINITION__OWNER_TYPED_ELEMENT:
                if (resolve) return getOwnerTypedElement();
                return basicGetOwnerTypedElement();
            case ClassesPackage.TYPE_DEFINITION__OWNER_SIGNATURE:
                if (resolve) return getOwnerSignature();
                return basicGetOwnerSignature();
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
            case ClassesPackage.TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT:
                getSignaturesWithOutput().clear();
                getSignaturesWithOutput().addAll((Collection<? extends Signature>)newValue);
                return;
            case ClassesPackage.TYPE_DEFINITION__OWNER_TYPED_ELEMENT:
                setOwnerTypedElement((TypedElement)newValue);
                return;
            case ClassesPackage.TYPE_DEFINITION__OWNER_SIGNATURE:
                setOwnerSignature((Signature)newValue);
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
            case ClassesPackage.TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT:
                getSignaturesWithOutput().clear();
                return;
            case ClassesPackage.TYPE_DEFINITION__OWNER_TYPED_ELEMENT:
                setOwnerTypedElement((TypedElement)null);
                return;
            case ClassesPackage.TYPE_DEFINITION__OWNER_SIGNATURE:
                setOwnerSignature((Signature)null);
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
            case ClassesPackage.TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT:
                return signaturesWithOutput != null && !signaturesWithOutput.isEmpty();
            case ClassesPackage.TYPE_DEFINITION__OWNER_TYPED_ELEMENT:
                return basicGetOwnerTypedElement() != null;
            case ClassesPackage.TYPE_DEFINITION__OWNER_SIGNATURE:
                return basicGetOwnerSignature() != null;
        }
        return super.eIsSet(featureID);
    }

} //TypeDefinitionImpl
