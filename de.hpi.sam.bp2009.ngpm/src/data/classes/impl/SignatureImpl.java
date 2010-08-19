/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes.impl;

import abapmapping.AbapSignatureImplementationAnnotation;

import data.classes.ClassesPackage;
import data.classes.FunctionSignatureTypeDefinition;
import data.classes.NamedValue;
import data.classes.Parameter;
import data.classes.SapClass;
import data.classes.Signature;
import data.classes.TypeDefinition;

import data.constraints.Constraint;

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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.SignatureImpl#isSideEffectFree <em>Side Effect Free</em>}</li>
 *   <li>{@link data.classes.impl.SignatureImpl#getFaults <em>Faults</em>}</li>
 *   <li>{@link data.classes.impl.SignatureImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link data.classes.impl.SignatureImpl#getOwnedTypeDefinitions <em>Owned Type Definitions</em>}</li>
 *   <li>{@link data.classes.impl.SignatureImpl#getInput <em>Input</em>}</li>
 *   <li>{@link data.classes.impl.SignatureImpl#getTypeDefinition <em>Type Definition</em>}</li>
 *   <li>{@link data.classes.impl.SignatureImpl#getPreconditions <em>Preconditions</em>}</li>
 *   <li>{@link data.classes.impl.SignatureImpl#getPostconditions <em>Postconditions</em>}</li>
 *   <li>{@link data.classes.impl.SignatureImpl#getAbapAnnotation <em>Abap Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SignatureImpl extends EObjectImpl implements Signature {
	/**
     * The default value of the '{@link #isSideEffectFree() <em>Side Effect Free</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isSideEffectFree()
     * @generated
     * @ordered
     */
	protected static final boolean SIDE_EFFECT_FREE_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isSideEffectFree() <em>Side Effect Free</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isSideEffectFree()
     * @generated
     * @ordered
     */
	protected boolean sideEffectFree = SIDE_EFFECT_FREE_EDEFAULT;

	/**
     * The cached value of the '{@link #getFaults() <em>Faults</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFaults()
     * @generated
     * @ordered
     */
	protected SapClass faults;

	/**
     * The cached value of the '{@link #getOutput() <em>Output</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOutput()
     * @generated
     * @ordered
     */
	protected TypeDefinition output;

	/**
     * The cached value of the '{@link #getOwnedTypeDefinitions() <em>Owned Type Definitions</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOwnedTypeDefinitions()
     * @generated
     * @ordered
     */
	protected TypeDefinition ownedTypeDefinitions;

	/**
     * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getInput()
     * @generated
     * @ordered
     */
	protected EList<Parameter> input;

	/**
     * The cached value of the '{@link #getTypeDefinition() <em>Type Definition</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeDefinition()
     * @generated
     * @ordered
     */
	protected EList<FunctionSignatureTypeDefinition> typeDefinition;

	/**
     * The cached value of the '{@link #getPreconditions() <em>Preconditions</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPreconditions()
     * @generated
     * @ordered
     */
	protected EList<Constraint> preconditions;

	/**
     * The cached value of the '{@link #getPostconditions() <em>Postconditions</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPostconditions()
     * @generated
     * @ordered
     */
	protected EList<Constraint> postconditions;

	/**
     * The cached value of the '{@link #getAbapAnnotation() <em>Abap Annotation</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAbapAnnotation()
     * @generated
     * @ordered
     */
	protected AbapSignatureImplementationAnnotation abapAnnotation;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SignatureImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.SIGNATURE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isSideEffectFree() {
        return sideEffectFree;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSideEffectFree(boolean newSideEffectFree) {
        boolean oldSideEffectFree = sideEffectFree;
        sideEffectFree = newSideEffectFree;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.SIGNATURE__SIDE_EFFECT_FREE, oldSideEffectFree, sideEffectFree));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getFaults() {
        if (faults != null && faults.eIsProxy()) {
            InternalEObject oldFaults = (InternalEObject)faults;
            faults = (SapClass)eResolveProxy(oldFaults);
            if (faults != oldFaults) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.SIGNATURE__FAULTS, oldFaults, faults));
            }
        }
        return faults;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass basicGetFaults() {
        return faults;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetFaults(SapClass newFaults, NotificationChain msgs) {
        SapClass oldFaults = faults;
        faults = newFaults;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.SIGNATURE__FAULTS, oldFaults, newFaults);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFaults(SapClass newFaults) {
        if (newFaults != faults) {
            NotificationChain msgs = null;
            if (faults != null)
                msgs = ((InternalEObject)faults).eInverseRemove(this, ClassesPackage.SAP_CLASS__SIGNATURES_WITH_FAULT, SapClass.class, msgs);
            if (newFaults != null)
                msgs = ((InternalEObject)newFaults).eInverseAdd(this, ClassesPackage.SAP_CLASS__SIGNATURES_WITH_FAULT, SapClass.class, msgs);
            msgs = basicSetFaults(newFaults, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.SIGNATURE__FAULTS, newFaults, newFaults));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeDefinition getOutput() {
        if (output != null && output.eIsProxy()) {
            InternalEObject oldOutput = (InternalEObject)output;
            output = (TypeDefinition)eResolveProxy(oldOutput);
            if (output != oldOutput) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.SIGNATURE__OUTPUT, oldOutput, output));
            }
        }
        return output;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeDefinition basicGetOutput() {
        return output;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetOutput(TypeDefinition newOutput, NotificationChain msgs) {
        TypeDefinition oldOutput = output;
        output = newOutput;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.SIGNATURE__OUTPUT, oldOutput, newOutput);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOutput(TypeDefinition newOutput) {
        if (newOutput != output) {
            NotificationChain msgs = null;
            if (output != null)
                msgs = ((InternalEObject)output).eInverseRemove(this, ClassesPackage.TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT, TypeDefinition.class, msgs);
            if (newOutput != null)
                msgs = ((InternalEObject)newOutput).eInverseAdd(this, ClassesPackage.TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT, TypeDefinition.class, msgs);
            msgs = basicSetOutput(newOutput, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.SIGNATURE__OUTPUT, newOutput, newOutput));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeDefinition getOwnedTypeDefinitions() {
        if (ownedTypeDefinitions != null && ownedTypeDefinitions.eIsProxy()) {
            InternalEObject oldOwnedTypeDefinitions = (InternalEObject)ownedTypeDefinitions;
            ownedTypeDefinitions = (TypeDefinition)eResolveProxy(oldOwnedTypeDefinitions);
            if (ownedTypeDefinitions != oldOwnedTypeDefinitions) {
                InternalEObject newOwnedTypeDefinitions = (InternalEObject)ownedTypeDefinitions;
                NotificationChain msgs =  oldOwnedTypeDefinitions.eInverseRemove(this, ClassesPackage.TYPE_DEFINITION__OWNER_SIGNATURE, TypeDefinition.class, null);
                if (newOwnedTypeDefinitions.eInternalContainer() == null) {
                    msgs =  newOwnedTypeDefinitions.eInverseAdd(this, ClassesPackage.TYPE_DEFINITION__OWNER_SIGNATURE, TypeDefinition.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.SIGNATURE__OWNED_TYPE_DEFINITIONS, oldOwnedTypeDefinitions, ownedTypeDefinitions));
            }
        }
        return ownedTypeDefinitions;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TypeDefinition basicGetOwnedTypeDefinitions() {
        return ownedTypeDefinitions;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetOwnedTypeDefinitions(TypeDefinition newOwnedTypeDefinitions, NotificationChain msgs) {
        TypeDefinition oldOwnedTypeDefinitions = ownedTypeDefinitions;
        ownedTypeDefinitions = newOwnedTypeDefinitions;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.SIGNATURE__OWNED_TYPE_DEFINITIONS, oldOwnedTypeDefinitions, newOwnedTypeDefinitions);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOwnedTypeDefinitions(TypeDefinition newOwnedTypeDefinitions) {
        if (newOwnedTypeDefinitions != ownedTypeDefinitions) {
            NotificationChain msgs = null;
            if (ownedTypeDefinitions != null)
                msgs = ((InternalEObject)ownedTypeDefinitions).eInverseRemove(this, ClassesPackage.TYPE_DEFINITION__OWNER_SIGNATURE, TypeDefinition.class, msgs);
            if (newOwnedTypeDefinitions != null)
                msgs = ((InternalEObject)newOwnedTypeDefinitions).eInverseAdd(this, ClassesPackage.TYPE_DEFINITION__OWNER_SIGNATURE, TypeDefinition.class, msgs);
            msgs = basicSetOwnedTypeDefinitions(newOwnedTypeDefinitions, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.SIGNATURE__OWNED_TYPE_DEFINITIONS, newOwnedTypeDefinitions, newOwnedTypeDefinitions));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Parameter> getInput() {
        if (input == null) {
            input = new EObjectContainmentWithInverseEList.Resolving<Parameter>(Parameter.class, this, ClassesPackage.SIGNATURE__INPUT, ClassesPackage.PARAMETER__OWNER_SIGNATURE);
        }
        return input;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<FunctionSignatureTypeDefinition> getTypeDefinition() {
        if (typeDefinition == null) {
            typeDefinition = new EObjectWithInverseResolvingEList<FunctionSignatureTypeDefinition>(FunctionSignatureTypeDefinition.class, this, ClassesPackage.SIGNATURE__TYPE_DEFINITION, ClassesPackage.FUNCTION_SIGNATURE_TYPE_DEFINITION__SIGNATURE);
        }
        return typeDefinition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Constraint> getPreconditions() {
        if (preconditions == null) {
            preconditions = new EObjectContainmentEList.Resolving<Constraint>(Constraint.class, this, ClassesPackage.SIGNATURE__PRECONDITIONS);
        }
        return preconditions;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Constraint> getPostconditions() {
        if (postconditions == null) {
            postconditions = new EObjectContainmentEList.Resolving<Constraint>(Constraint.class, this, ClassesPackage.SIGNATURE__POSTCONDITIONS);
        }
        return postconditions;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapSignatureImplementationAnnotation getAbapAnnotation() {
        if (abapAnnotation != null && abapAnnotation.eIsProxy()) {
            InternalEObject oldAbapAnnotation = (InternalEObject)abapAnnotation;
            abapAnnotation = (AbapSignatureImplementationAnnotation)eResolveProxy(oldAbapAnnotation);
            if (abapAnnotation != oldAbapAnnotation) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.SIGNATURE__ABAP_ANNOTATION, oldAbapAnnotation, abapAnnotation));
            }
        }
        return abapAnnotation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapSignatureImplementationAnnotation basicGetAbapAnnotation() {
        return abapAnnotation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAbapAnnotation(AbapSignatureImplementationAnnotation newAbapAnnotation) {
        AbapSignatureImplementationAnnotation oldAbapAnnotation = abapAnnotation;
        abapAnnotation = newAbapAnnotation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.SIGNATURE__ABAP_ANNOTATION, oldAbapAnnotation, abapAnnotation));
    }

	/**
     * The cached invocation delegate for the '{@link #conformsTo(data.classes.Signature) <em>Conforms To</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #conformsTo(data.classes.Signature)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate CONFORMS_TO_SIGNATURE__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SIGNATURE.getEOperations().get(0)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean conformsTo(Signature s) {
        try {
            return (Boolean)CONFORMS_TO_SIGNATURE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{s}));
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #conformsToExcluding(data.classes.Signature, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Conforms To Excluding</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #conformsToExcluding(data.classes.Signature, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate CONFORMS_TO_EXCLUDING_SIGNATURE_ELIST_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SIGNATURE.getEOperations().get(1)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean conformsToExcluding(Signature s, EList<SapClass> excludingConforming, EList<SapClass> excludingTo) {
        try {
            return (Boolean)CONFORMS_TO_EXCLUDING_SIGNATURE_ELIST_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(3, new Object[]{s, excludingConforming, excludingTo}));
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
	protected static final EOperation.Internal.InvocationDelegate GET_NAMED_VALUES_IN_SCOPE__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SIGNATURE.getEOperations().get(2)).getInvocationDelegate();

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
     * The cached invocation delegate for the '{@link #getOwningClass() <em>Get Owning Class</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOwningClass()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_OWNING_CLASS__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SIGNATURE.getEOperations().get(3)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getOwningClass() {
        try {
            return (SapClass)GET_OWNING_CLASS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
            case ClassesPackage.SIGNATURE__FAULTS:
                if (faults != null)
                    msgs = ((InternalEObject)faults).eInverseRemove(this, ClassesPackage.SAP_CLASS__SIGNATURES_WITH_FAULT, SapClass.class, msgs);
                return basicSetFaults((SapClass)otherEnd, msgs);
            case ClassesPackage.SIGNATURE__OUTPUT:
                if (output != null)
                    msgs = ((InternalEObject)output).eInverseRemove(this, ClassesPackage.TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT, TypeDefinition.class, msgs);
                return basicSetOutput((TypeDefinition)otherEnd, msgs);
            case ClassesPackage.SIGNATURE__OWNED_TYPE_DEFINITIONS:
                if (ownedTypeDefinitions != null)
                    msgs = ((InternalEObject)ownedTypeDefinitions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.SIGNATURE__OWNED_TYPE_DEFINITIONS, null, msgs);
                return basicSetOwnedTypeDefinitions((TypeDefinition)otherEnd, msgs);
            case ClassesPackage.SIGNATURE__INPUT:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getInput()).basicAdd(otherEnd, msgs);
            case ClassesPackage.SIGNATURE__TYPE_DEFINITION:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getTypeDefinition()).basicAdd(otherEnd, msgs);
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
            case ClassesPackage.SIGNATURE__FAULTS:
                return basicSetFaults(null, msgs);
            case ClassesPackage.SIGNATURE__OUTPUT:
                return basicSetOutput(null, msgs);
            case ClassesPackage.SIGNATURE__OWNED_TYPE_DEFINITIONS:
                return basicSetOwnedTypeDefinitions(null, msgs);
            case ClassesPackage.SIGNATURE__INPUT:
                return ((InternalEList<?>)getInput()).basicRemove(otherEnd, msgs);
            case ClassesPackage.SIGNATURE__TYPE_DEFINITION:
                return ((InternalEList<?>)getTypeDefinition()).basicRemove(otherEnd, msgs);
            case ClassesPackage.SIGNATURE__PRECONDITIONS:
                return ((InternalEList<?>)getPreconditions()).basicRemove(otherEnd, msgs);
            case ClassesPackage.SIGNATURE__POSTCONDITIONS:
                return ((InternalEList<?>)getPostconditions()).basicRemove(otherEnd, msgs);
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
            case ClassesPackage.SIGNATURE__SIDE_EFFECT_FREE:
                return isSideEffectFree();
            case ClassesPackage.SIGNATURE__FAULTS:
                if (resolve) return getFaults();
                return basicGetFaults();
            case ClassesPackage.SIGNATURE__OUTPUT:
                if (resolve) return getOutput();
                return basicGetOutput();
            case ClassesPackage.SIGNATURE__OWNED_TYPE_DEFINITIONS:
                if (resolve) return getOwnedTypeDefinitions();
                return basicGetOwnedTypeDefinitions();
            case ClassesPackage.SIGNATURE__INPUT:
                return getInput();
            case ClassesPackage.SIGNATURE__TYPE_DEFINITION:
                return getTypeDefinition();
            case ClassesPackage.SIGNATURE__PRECONDITIONS:
                return getPreconditions();
            case ClassesPackage.SIGNATURE__POSTCONDITIONS:
                return getPostconditions();
            case ClassesPackage.SIGNATURE__ABAP_ANNOTATION:
                if (resolve) return getAbapAnnotation();
                return basicGetAbapAnnotation();
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
            case ClassesPackage.SIGNATURE__SIDE_EFFECT_FREE:
                setSideEffectFree((Boolean)newValue);
                return;
            case ClassesPackage.SIGNATURE__FAULTS:
                setFaults((SapClass)newValue);
                return;
            case ClassesPackage.SIGNATURE__OUTPUT:
                setOutput((TypeDefinition)newValue);
                return;
            case ClassesPackage.SIGNATURE__OWNED_TYPE_DEFINITIONS:
                setOwnedTypeDefinitions((TypeDefinition)newValue);
                return;
            case ClassesPackage.SIGNATURE__INPUT:
                getInput().clear();
                getInput().addAll((Collection<? extends Parameter>)newValue);
                return;
            case ClassesPackage.SIGNATURE__TYPE_DEFINITION:
                getTypeDefinition().clear();
                getTypeDefinition().addAll((Collection<? extends FunctionSignatureTypeDefinition>)newValue);
                return;
            case ClassesPackage.SIGNATURE__PRECONDITIONS:
                getPreconditions().clear();
                getPreconditions().addAll((Collection<? extends Constraint>)newValue);
                return;
            case ClassesPackage.SIGNATURE__POSTCONDITIONS:
                getPostconditions().clear();
                getPostconditions().addAll((Collection<? extends Constraint>)newValue);
                return;
            case ClassesPackage.SIGNATURE__ABAP_ANNOTATION:
                setAbapAnnotation((AbapSignatureImplementationAnnotation)newValue);
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
            case ClassesPackage.SIGNATURE__SIDE_EFFECT_FREE:
                setSideEffectFree(SIDE_EFFECT_FREE_EDEFAULT);
                return;
            case ClassesPackage.SIGNATURE__FAULTS:
                setFaults((SapClass)null);
                return;
            case ClassesPackage.SIGNATURE__OUTPUT:
                setOutput((TypeDefinition)null);
                return;
            case ClassesPackage.SIGNATURE__OWNED_TYPE_DEFINITIONS:
                setOwnedTypeDefinitions((TypeDefinition)null);
                return;
            case ClassesPackage.SIGNATURE__INPUT:
                getInput().clear();
                return;
            case ClassesPackage.SIGNATURE__TYPE_DEFINITION:
                getTypeDefinition().clear();
                return;
            case ClassesPackage.SIGNATURE__PRECONDITIONS:
                getPreconditions().clear();
                return;
            case ClassesPackage.SIGNATURE__POSTCONDITIONS:
                getPostconditions().clear();
                return;
            case ClassesPackage.SIGNATURE__ABAP_ANNOTATION:
                setAbapAnnotation((AbapSignatureImplementationAnnotation)null);
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
            case ClassesPackage.SIGNATURE__SIDE_EFFECT_FREE:
                return sideEffectFree != SIDE_EFFECT_FREE_EDEFAULT;
            case ClassesPackage.SIGNATURE__FAULTS:
                return faults != null;
            case ClassesPackage.SIGNATURE__OUTPUT:
                return output != null;
            case ClassesPackage.SIGNATURE__OWNED_TYPE_DEFINITIONS:
                return ownedTypeDefinitions != null;
            case ClassesPackage.SIGNATURE__INPUT:
                return input != null && !input.isEmpty();
            case ClassesPackage.SIGNATURE__TYPE_DEFINITION:
                return typeDefinition != null && !typeDefinition.isEmpty();
            case ClassesPackage.SIGNATURE__PRECONDITIONS:
                return preconditions != null && !preconditions.isEmpty();
            case ClassesPackage.SIGNATURE__POSTCONDITIONS:
                return postconditions != null && !postconditions.isEmpty();
            case ClassesPackage.SIGNATURE__ABAP_ANNOTATION:
                return abapAnnotation != null;
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
        result.append(" (sideEffectFree: ");
        result.append(sideEffectFree);
        result.append(')');
        return result.toString();
    }

} //SignatureImpl
