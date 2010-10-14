/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.generics.impl;

import data.classes.SapClass;

import data.classes.impl.SapClassImpl;

import data.generics.ActualTypeParameter;
import data.generics.ClassParameterization;
import data.generics.FormalTypeParameter;
import data.generics.GenericsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Formal Type Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.generics.impl.FormalTypeParameterImpl#getParameterOf <em>Parameter Of</em>}</li>
 *   <li>{@link data.generics.impl.FormalTypeParameterImpl#getTypeConstraint <em>Type Constraint</em>}</li>
 *   <li>{@link data.generics.impl.FormalTypeParameterImpl#getActualTypeParameters <em>Actual Type Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FormalTypeParameterImpl extends SapClassImpl implements FormalTypeParameter {
	/**
     * The cached value of the '{@link #getTypeConstraint() <em>Type Constraint</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeConstraint()
     * @generated
     * @ordered
     */
	protected SapClass typeConstraint;

	/**
     * The cached value of the '{@link #getActualTypeParameters() <em>Actual Type Parameters</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getActualTypeParameters()
     * @generated
     * @ordered
     */
	protected EList<ActualTypeParameter> actualTypeParameters;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected FormalTypeParameterImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return GenericsPackage.Literals.FORMAL_TYPE_PARAMETER;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ClassParameterization getParameterOf() {
        if (eContainerFeatureID() != GenericsPackage.FORMAL_TYPE_PARAMETER__PARAMETER_OF) return null;
        return (ClassParameterization)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ClassParameterization basicGetParameterOf() {
        if (eContainerFeatureID() != GenericsPackage.FORMAL_TYPE_PARAMETER__PARAMETER_OF) return null;
        return (ClassParameterization)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetParameterOf(ClassParameterization newParameterOf, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newParameterOf, GenericsPackage.FORMAL_TYPE_PARAMETER__PARAMETER_OF, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setParameterOf(ClassParameterization newParameterOf) {
        if (newParameterOf != eInternalContainer() || (eContainerFeatureID() != GenericsPackage.FORMAL_TYPE_PARAMETER__PARAMETER_OF && newParameterOf != null)) {
            if (EcoreUtil.isAncestor(this, newParameterOf))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParameterOf != null)
                msgs = ((InternalEObject)newParameterOf).eInverseAdd(this, GenericsPackage.CLASS_PARAMETERIZATION__FORMAL_TYPE_PARAMETERS, ClassParameterization.class, msgs);
            msgs = basicSetParameterOf(newParameterOf, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.FORMAL_TYPE_PARAMETER__PARAMETER_OF, newParameterOf, newParameterOf));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getTypeConstraint() {
        if (typeConstraint != null && typeConstraint.eIsProxy()) {
            InternalEObject oldTypeConstraint = (InternalEObject)typeConstraint;
            typeConstraint = (SapClass)eResolveProxy(oldTypeConstraint);
            if (typeConstraint != oldTypeConstraint) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenericsPackage.FORMAL_TYPE_PARAMETER__TYPE_CONSTRAINT, oldTypeConstraint, typeConstraint));
            }
        }
        return typeConstraint;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass basicGetTypeConstraint() {
        return typeConstraint;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTypeConstraint(SapClass newTypeConstraint) {
        SapClass oldTypeConstraint = typeConstraint;
        typeConstraint = newTypeConstraint;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.FORMAL_TYPE_PARAMETER__TYPE_CONSTRAINT, oldTypeConstraint, typeConstraint));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ActualTypeParameter> getActualTypeParameters() {
        if (actualTypeParameters == null) {
            actualTypeParameters = new EObjectWithInverseResolvingEList<ActualTypeParameter>(ActualTypeParameter.class, this, GenericsPackage.FORMAL_TYPE_PARAMETER__ACTUAL_TYPE_PARAMETERS, GenericsPackage.ACTUAL_TYPE_PARAMETER__FORMAL_TYPE_PARAMETER);
        }
        return actualTypeParameters;
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
            case GenericsPackage.FORMAL_TYPE_PARAMETER__PARAMETER_OF:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetParameterOf((ClassParameterization)otherEnd, msgs);
            case GenericsPackage.FORMAL_TYPE_PARAMETER__ACTUAL_TYPE_PARAMETERS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getActualTypeParameters()).basicAdd(otherEnd, msgs);
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
            case GenericsPackage.FORMAL_TYPE_PARAMETER__PARAMETER_OF:
                return basicSetParameterOf(null, msgs);
            case GenericsPackage.FORMAL_TYPE_PARAMETER__ACTUAL_TYPE_PARAMETERS:
                return ((InternalEList<?>)getActualTypeParameters()).basicRemove(otherEnd, msgs);
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
            case GenericsPackage.FORMAL_TYPE_PARAMETER__PARAMETER_OF:
                return eInternalContainer().eInverseRemove(this, GenericsPackage.CLASS_PARAMETERIZATION__FORMAL_TYPE_PARAMETERS, ClassParameterization.class, msgs);
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
            case GenericsPackage.FORMAL_TYPE_PARAMETER__PARAMETER_OF:
                if (resolve) return getParameterOf();
                return basicGetParameterOf();
            case GenericsPackage.FORMAL_TYPE_PARAMETER__TYPE_CONSTRAINT:
                if (resolve) return getTypeConstraint();
                return basicGetTypeConstraint();
            case GenericsPackage.FORMAL_TYPE_PARAMETER__ACTUAL_TYPE_PARAMETERS:
                return getActualTypeParameters();
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
            case GenericsPackage.FORMAL_TYPE_PARAMETER__PARAMETER_OF:
                setParameterOf((ClassParameterization)newValue);
                return;
            case GenericsPackage.FORMAL_TYPE_PARAMETER__TYPE_CONSTRAINT:
                setTypeConstraint((SapClass)newValue);
                return;
            case GenericsPackage.FORMAL_TYPE_PARAMETER__ACTUAL_TYPE_PARAMETERS:
                getActualTypeParameters().clear();
                getActualTypeParameters().addAll((Collection<? extends ActualTypeParameter>)newValue);
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
            case GenericsPackage.FORMAL_TYPE_PARAMETER__PARAMETER_OF:
                setParameterOf((ClassParameterization)null);
                return;
            case GenericsPackage.FORMAL_TYPE_PARAMETER__TYPE_CONSTRAINT:
                setTypeConstraint((SapClass)null);
                return;
            case GenericsPackage.FORMAL_TYPE_PARAMETER__ACTUAL_TYPE_PARAMETERS:
                getActualTypeParameters().clear();
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
            case GenericsPackage.FORMAL_TYPE_PARAMETER__PARAMETER_OF:
                return basicGetParameterOf() != null;
            case GenericsPackage.FORMAL_TYPE_PARAMETER__TYPE_CONSTRAINT:
                return typeConstraint != null;
            case GenericsPackage.FORMAL_TYPE_PARAMETER__ACTUAL_TYPE_PARAMETERS:
                return actualTypeParameters != null && !actualTypeParameters.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //FormalTypeParameterImpl
