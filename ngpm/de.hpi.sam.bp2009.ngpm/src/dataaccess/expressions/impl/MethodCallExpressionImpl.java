/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.impl;

import data.classes.MethodSignature;
import data.classes.Multiplicity;
import data.classes.Signature;

import dataaccess.expressions.Expression;
import dataaccess.expressions.ExpressionsPackage;
import dataaccess.expressions.MethodCallExpression;
import dataaccess.expressions.ObjectCreationExpression;
import dataaccess.expressions.SignatureCallExpression;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method Call Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.impl.MethodCallExpressionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.MethodCallExpressionImpl#isAsynchronous <em>Asynchronous</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.MethodCallExpressionImpl#getMethodSignature <em>Method Signature</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.MethodCallExpressionImpl#getCreationExpression <em>Creation Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MethodCallExpressionImpl extends ObjectBasedExpressionImpl implements MethodCallExpression {
	/**
     * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getParameters()
     * @generated
     * @ordered
     */
	protected EList<Expression> parameters;

	/**
     * The default value of the '{@link #isAsynchronous() <em>Asynchronous</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isAsynchronous()
     * @generated
     * @ordered
     */
	protected static final boolean ASYNCHRONOUS_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isAsynchronous() <em>Asynchronous</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isAsynchronous()
     * @generated
     * @ordered
     */
	protected boolean asynchronous = ASYNCHRONOUS_EDEFAULT;

	/**
     * The cached value of the '{@link #getMethodSignature() <em>Method Signature</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMethodSignature()
     * @generated
     * @ordered
     */
	protected MethodSignature methodSignature;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected MethodCallExpressionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.METHOD_CALL_EXPRESSION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Expression> getParameters() {
        if (parameters == null) {
            parameters = new EObjectContainmentWithInverseEList.Resolving<Expression>(Expression.class, this, ExpressionsPackage.METHOD_CALL_EXPRESSION__PARAMETERS, ExpressionsPackage.EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL);
        }
        return parameters;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isAsynchronous() {
        return asynchronous;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAsynchronous(boolean newAsynchronous) {
        boolean oldAsynchronous = asynchronous;
        asynchronous = newAsynchronous;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.METHOD_CALL_EXPRESSION__ASYNCHRONOUS, oldAsynchronous, asynchronous));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MethodSignature getMethodSignature() {
        if (methodSignature != null && methodSignature.eIsProxy()) {
            InternalEObject oldMethodSignature = (InternalEObject)methodSignature;
            methodSignature = (MethodSignature)eResolveProxy(oldMethodSignature);
            if (methodSignature != oldMethodSignature) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.METHOD_CALL_EXPRESSION__METHOD_SIGNATURE, oldMethodSignature, methodSignature));
            }
        }
        return methodSignature;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MethodSignature basicGetMethodSignature() {
        return methodSignature;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setMethodSignature(MethodSignature newMethodSignature) {
        MethodSignature oldMethodSignature = methodSignature;
        methodSignature = newMethodSignature;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.METHOD_CALL_EXPRESSION__METHOD_SIGNATURE, oldMethodSignature, methodSignature));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ObjectCreationExpression getCreationExpression() {
        if (eContainerFeatureID() != ExpressionsPackage.METHOD_CALL_EXPRESSION__CREATION_EXPRESSION) return null;
        return (ObjectCreationExpression)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ObjectCreationExpression basicGetCreationExpression() {
        if (eContainerFeatureID() != ExpressionsPackage.METHOD_CALL_EXPRESSION__CREATION_EXPRESSION) return null;
        return (ObjectCreationExpression)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetCreationExpression(ObjectCreationExpression newCreationExpression, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newCreationExpression, ExpressionsPackage.METHOD_CALL_EXPRESSION__CREATION_EXPRESSION, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCreationExpression(ObjectCreationExpression newCreationExpression) {
        if (newCreationExpression != eInternalContainer() || (eContainerFeatureID() != ExpressionsPackage.METHOD_CALL_EXPRESSION__CREATION_EXPRESSION && newCreationExpression != null)) {
            if (EcoreUtil.isAncestor(this, newCreationExpression))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newCreationExpression != null)
                msgs = ((InternalEObject)newCreationExpression).eInverseAdd(this, ExpressionsPackage.OBJECT_CREATION_EXPRESSION__INITIALIZERS, ObjectCreationExpression.class, msgs);
            msgs = basicSetCreationExpression(newCreationExpression, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.METHOD_CALL_EXPRESSION__CREATION_EXPRESSION, newCreationExpression, newCreationExpression));
    }

	/**
     * The cached invocation delegate for the '{@link #getSignature() <em>Get Signature</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSignature()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_SIGNATURE__EINVOCATION_DELEGATE = ((EOperation.Internal)ExpressionsPackage.Literals.SIGNATURE_CALL_EXPRESSION.getEOperations().get(0)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Signature getSignature() {
        try {
            return (Signature)GET_SIGNATURE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #getMultiplicityOfCallTarget() <em>Get Multiplicity Of Call Target</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMultiplicityOfCallTarget()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_MULTIPLICITY_OF_CALL_TARGET__EINVOCATION_DELEGATE = ((EOperation.Internal)ExpressionsPackage.Literals.SIGNATURE_CALL_EXPRESSION.getEOperations().get(1)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Multiplicity getMultiplicityOfCallTarget() {
        try {
            return (Multiplicity)GET_MULTIPLICITY_OF_CALL_TARGET__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__PARAMETERS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameters()).basicAdd(otherEnd, msgs);
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__CREATION_EXPRESSION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetCreationExpression((ObjectCreationExpression)otherEnd, msgs);
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
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__PARAMETERS:
                return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__CREATION_EXPRESSION:
                return basicSetCreationExpression(null, msgs);
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
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__CREATION_EXPRESSION:
                return eInternalContainer().eInverseRemove(this, ExpressionsPackage.OBJECT_CREATION_EXPRESSION__INITIALIZERS, ObjectCreationExpression.class, msgs);
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
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__PARAMETERS:
                return getParameters();
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__ASYNCHRONOUS:
                return isAsynchronous();
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__METHOD_SIGNATURE:
                if (resolve) return getMethodSignature();
                return basicGetMethodSignature();
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__CREATION_EXPRESSION:
                if (resolve) return getCreationExpression();
                return basicGetCreationExpression();
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
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__PARAMETERS:
                getParameters().clear();
                getParameters().addAll((Collection<? extends Expression>)newValue);
                return;
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__ASYNCHRONOUS:
                setAsynchronous((Boolean)newValue);
                return;
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__METHOD_SIGNATURE:
                setMethodSignature((MethodSignature)newValue);
                return;
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__CREATION_EXPRESSION:
                setCreationExpression((ObjectCreationExpression)newValue);
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
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__PARAMETERS:
                getParameters().clear();
                return;
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__ASYNCHRONOUS:
                setAsynchronous(ASYNCHRONOUS_EDEFAULT);
                return;
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__METHOD_SIGNATURE:
                setMethodSignature((MethodSignature)null);
                return;
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__CREATION_EXPRESSION:
                setCreationExpression((ObjectCreationExpression)null);
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
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__PARAMETERS:
                return parameters != null && !parameters.isEmpty();
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__ASYNCHRONOUS:
                return asynchronous != ASYNCHRONOUS_EDEFAULT;
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__METHOD_SIGNATURE:
                return methodSignature != null;
            case ExpressionsPackage.METHOD_CALL_EXPRESSION__CREATION_EXPRESSION:
                return basicGetCreationExpression() != null;
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
        if (baseClass == SignatureCallExpression.class) {
            switch (derivedFeatureID) {
                case ExpressionsPackage.METHOD_CALL_EXPRESSION__PARAMETERS: return ExpressionsPackage.SIGNATURE_CALL_EXPRESSION__PARAMETERS;
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
        if (baseClass == SignatureCallExpression.class) {
            switch (baseFeatureID) {
                case ExpressionsPackage.SIGNATURE_CALL_EXPRESSION__PARAMETERS: return ExpressionsPackage.METHOD_CALL_EXPRESSION__PARAMETERS;
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
        result.append(" (asynchronous: ");
        result.append(asynchronous);
        result.append(')');
        return result.toString();
    }

} //MethodCallExpressionImpl
