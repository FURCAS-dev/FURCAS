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
import data.generics.ParameterizedClassInstantiation;

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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameterized Class Instantiation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.generics.impl.ParameterizedClassInstantiationImpl#getActualTypeParametersForInstantiation <em>Actual Type Parameters For Instantiation</em>}</li>
 *   <li>{@link data.generics.impl.ParameterizedClassInstantiationImpl#getParameterizedClass <em>Parameterized Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterizedClassInstantiationImpl extends SapClassImpl implements ParameterizedClassInstantiation {
	/**
     * The cached value of the '{@link #getActualTypeParametersForInstantiation() <em>Actual Type Parameters For Instantiation</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getActualTypeParametersForInstantiation()
     * @generated
     * @ordered
     */
	protected EList<ActualTypeParameter> actualTypeParametersForInstantiation;

	/**
     * The cached value of the '{@link #getParameterizedClass() <em>Parameterized Class</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getParameterizedClass()
     * @generated
     * @ordered
     */
	protected SapClass parameterizedClass;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ParameterizedClassInstantiationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return GenericsPackage.Literals.PARAMETERIZED_CLASS_INSTANTIATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ActualTypeParameter> getActualTypeParametersForInstantiation() {
        if (actualTypeParametersForInstantiation == null) {
            actualTypeParametersForInstantiation = new EObjectContainmentWithInverseEList.Resolving<ActualTypeParameter>(ActualTypeParameter.class, this, GenericsPackage.PARAMETERIZED_CLASS_INSTANTIATION__ACTUAL_TYPE_PARAMETERS_FOR_INSTANTIATION, GenericsPackage.ACTUAL_TYPE_PARAMETER__PARAMETERIZED_CLASS_INSTANTIATION);
        }
        return actualTypeParametersForInstantiation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getParameterizedClass() {
        if (parameterizedClass != null && parameterizedClass.eIsProxy()) {
            InternalEObject oldParameterizedClass = (InternalEObject)parameterizedClass;
            parameterizedClass = (SapClass)eResolveProxy(oldParameterizedClass);
            if (parameterizedClass != oldParameterizedClass) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenericsPackage.PARAMETERIZED_CLASS_INSTANTIATION__PARAMETERIZED_CLASS, oldParameterizedClass, parameterizedClass));
            }
        }
        return parameterizedClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass basicGetParameterizedClass() {
        return parameterizedClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setParameterizedClass(SapClass newParameterizedClass) {
        SapClass oldParameterizedClass = parameterizedClass;
        parameterizedClass = newParameterizedClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.PARAMETERIZED_CLASS_INSTANTIATION__PARAMETERIZED_CLASS, oldParameterizedClass, parameterizedClass));
    }

	/**
     * The cached invocation delegate for the '{@link #resolveFormalTypeParameter(data.generics.FormalTypeParameter) <em>Resolve Formal Type Parameter</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #resolveFormalTypeParameter(data.generics.FormalTypeParameter)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate RESOLVE_FORMAL_TYPE_PARAMETER_FORMAL_TYPE_PARAMETER__EINVOCATION_DELEGATE = ((EOperation.Internal)GenericsPackage.Literals.PARAMETERIZED_CLASS_INSTANTIATION.getEOperations().get(0)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass resolveFormalTypeParameter(FormalTypeParameter ftp) {
        try {
            return (SapClass)RESOLVE_FORMAL_TYPE_PARAMETER_FORMAL_TYPE_PARAMETER__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{ftp}));
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #getClassParameterization() <em>Get Class Parameterization</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getClassParameterization()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_CLASS_PARAMETERIZATION__EINVOCATION_DELEGATE = ((EOperation.Internal)GenericsPackage.Literals.PARAMETERIZED_CLASS_INSTANTIATION.getEOperations().get(1)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ClassParameterization getClassParameterization() {
        try {
            return (ClassParameterization)GET_CLASS_PARAMETERIZATION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
            case GenericsPackage.PARAMETERIZED_CLASS_INSTANTIATION__ACTUAL_TYPE_PARAMETERS_FOR_INSTANTIATION:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getActualTypeParametersForInstantiation()).basicAdd(otherEnd, msgs);
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
            case GenericsPackage.PARAMETERIZED_CLASS_INSTANTIATION__ACTUAL_TYPE_PARAMETERS_FOR_INSTANTIATION:
                return ((InternalEList<?>)getActualTypeParametersForInstantiation()).basicRemove(otherEnd, msgs);
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
            case GenericsPackage.PARAMETERIZED_CLASS_INSTANTIATION__ACTUAL_TYPE_PARAMETERS_FOR_INSTANTIATION:
                return getActualTypeParametersForInstantiation();
            case GenericsPackage.PARAMETERIZED_CLASS_INSTANTIATION__PARAMETERIZED_CLASS:
                if (resolve) return getParameterizedClass();
                return basicGetParameterizedClass();
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
            case GenericsPackage.PARAMETERIZED_CLASS_INSTANTIATION__ACTUAL_TYPE_PARAMETERS_FOR_INSTANTIATION:
                getActualTypeParametersForInstantiation().clear();
                getActualTypeParametersForInstantiation().addAll((Collection<? extends ActualTypeParameter>)newValue);
                return;
            case GenericsPackage.PARAMETERIZED_CLASS_INSTANTIATION__PARAMETERIZED_CLASS:
                setParameterizedClass((SapClass)newValue);
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
            case GenericsPackage.PARAMETERIZED_CLASS_INSTANTIATION__ACTUAL_TYPE_PARAMETERS_FOR_INSTANTIATION:
                getActualTypeParametersForInstantiation().clear();
                return;
            case GenericsPackage.PARAMETERIZED_CLASS_INSTANTIATION__PARAMETERIZED_CLASS:
                setParameterizedClass((SapClass)null);
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
            case GenericsPackage.PARAMETERIZED_CLASS_INSTANTIATION__ACTUAL_TYPE_PARAMETERS_FOR_INSTANTIATION:
                return actualTypeParametersForInstantiation != null && !actualTypeParametersForInstantiation.isEmpty();
            case GenericsPackage.PARAMETERIZED_CLASS_INSTANTIATION__PARAMETERIZED_CLASS:
                return parameterizedClass != null;
        }
        return super.eIsSet(featureID);
    }

} //ParameterizedClassInstantiationImpl
