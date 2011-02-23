/**
 * <copyright>
 * </copyright>
 *
 * $Id: ObjectCreationExpressionImpl.java,v 1.1 2011/02/07 17:20:40 auhl Exp $
 */
package dataaccess.expressions.impl;

import data.classes.SapClass;

import dataaccess.expressions.ExpressionsPackage;
import dataaccess.expressions.MethodCallExpression;
import dataaccess.expressions.ObjectCreationExpression;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Creation Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.impl.ObjectCreationExpressionImpl#getClassToInstantiate <em>Class To Instantiate</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.ObjectCreationExpressionImpl#getInitializers <em>Initializers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectCreationExpressionImpl extends ExpressionImpl implements ObjectCreationExpression {
	/**
     * The cached value of the '{@link #getClassToInstantiate() <em>Class To Instantiate</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getClassToInstantiate()
     * @generated
     * @ordered
     */
	protected SapClass classToInstantiate;

	/**
     * The cached value of the '{@link #getInitializers() <em>Initializers</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getInitializers()
     * @generated
     * @ordered
     */
	protected EList<MethodCallExpression> initializers;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ObjectCreationExpressionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.OBJECT_CREATION_EXPRESSION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getClassToInstantiate() {
        if (classToInstantiate != null && classToInstantiate.eIsProxy()) {
            InternalEObject oldClassToInstantiate = (InternalEObject)classToInstantiate;
            classToInstantiate = (SapClass)eResolveProxy(oldClassToInstantiate);
            if (classToInstantiate != oldClassToInstantiate) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.OBJECT_CREATION_EXPRESSION__CLASS_TO_INSTANTIATE, oldClassToInstantiate, classToInstantiate));
            }
        }
        return classToInstantiate;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass basicGetClassToInstantiate() {
        return classToInstantiate;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setClassToInstantiate(SapClass newClassToInstantiate) {
        SapClass oldClassToInstantiate = classToInstantiate;
        classToInstantiate = newClassToInstantiate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OBJECT_CREATION_EXPRESSION__CLASS_TO_INSTANTIATE, oldClassToInstantiate, classToInstantiate));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<MethodCallExpression> getInitializers() {
        if (initializers == null) {
            initializers = new EObjectContainmentWithInverseEList.Resolving<MethodCallExpression>(MethodCallExpression.class, this, ExpressionsPackage.OBJECT_CREATION_EXPRESSION__INITIALIZERS, ExpressionsPackage.METHOD_CALL_EXPRESSION__CREATION_EXPRESSION);
        }
        return initializers;
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
            case ExpressionsPackage.OBJECT_CREATION_EXPRESSION__INITIALIZERS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getInitializers()).basicAdd(otherEnd, msgs);
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
            case ExpressionsPackage.OBJECT_CREATION_EXPRESSION__INITIALIZERS:
                return ((InternalEList<?>)getInitializers()).basicRemove(otherEnd, msgs);
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
            case ExpressionsPackage.OBJECT_CREATION_EXPRESSION__CLASS_TO_INSTANTIATE:
                if (resolve) return getClassToInstantiate();
                return basicGetClassToInstantiate();
            case ExpressionsPackage.OBJECT_CREATION_EXPRESSION__INITIALIZERS:
                return getInitializers();
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
            case ExpressionsPackage.OBJECT_CREATION_EXPRESSION__CLASS_TO_INSTANTIATE:
                setClassToInstantiate((SapClass)newValue);
                return;
            case ExpressionsPackage.OBJECT_CREATION_EXPRESSION__INITIALIZERS:
                getInitializers().clear();
                getInitializers().addAll((Collection<? extends MethodCallExpression>)newValue);
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
            case ExpressionsPackage.OBJECT_CREATION_EXPRESSION__CLASS_TO_INSTANTIATE:
                setClassToInstantiate((SapClass)null);
                return;
            case ExpressionsPackage.OBJECT_CREATION_EXPRESSION__INITIALIZERS:
                getInitializers().clear();
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
            case ExpressionsPackage.OBJECT_CREATION_EXPRESSION__CLASS_TO_INSTANTIATE:
                return classToInstantiate != null;
            case ExpressionsPackage.OBJECT_CREATION_EXPRESSION__INITIALIZERS:
                return initializers != null && !initializers.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //ObjectCreationExpressionImpl
