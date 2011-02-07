/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConstraintImpl.java,v 1.1 2011/02/07 16:49:09 auhl Exp $
 */
package data.constraints.impl;

import data.classes.ClassesPackage;
import data.classes.Context;
import data.classes.SapClass;

import data.constraints.Constraint;
import data.constraints.ConstraintsPackage;
import data.constraints.SeverityInState;

import dataaccess.expressions.Expression;

import java.util.Collection;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.constraints.impl.ConstraintImpl#getTheContext <em>The Context</em>}</li>
 *   <li>{@link data.constraints.impl.ConstraintImpl#getConstrainedType <em>Constrained Type</em>}</li>
 *   <li>{@link data.constraints.impl.ConstraintImpl#getSeverityInState <em>Severity In State</em>}</li>
 *   <li>{@link data.constraints.impl.ConstraintImpl#getConstraintExpression <em>Constraint Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintImpl extends NamedElementImpl implements Constraint {
	/**
     * The cached value of the '{@link #getSeverityInState() <em>Severity In State</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSeverityInState()
     * @generated
     * @ordered
     */
	protected EList<SeverityInState> severityInState;

	/**
     * The cached value of the '{@link #getConstraintExpression() <em>Constraint Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getConstraintExpression()
     * @generated
     * @ordered
     */
	protected Expression constraintExpression;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ConstraintImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ConstraintsPackage.Literals.CONSTRAINT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Context getTheContext() {
        if (eContainerFeatureID() != ConstraintsPackage.CONSTRAINT__THE_CONTEXT) return null;
        return (Context)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Context basicGetTheContext() {
        if (eContainerFeatureID() != ConstraintsPackage.CONSTRAINT__THE_CONTEXT) return null;
        return (Context)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetTheContext(Context newTheContext, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newTheContext, ConstraintsPackage.CONSTRAINT__THE_CONTEXT, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTheContext(Context newTheContext) {
        if (newTheContext != eInternalContainer() || (eContainerFeatureID() != ConstraintsPackage.CONSTRAINT__THE_CONTEXT && newTheContext != null)) {
            if (EcoreUtil.isAncestor(this, newTheContext))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newTheContext != null)
                msgs = ((InternalEObject)newTheContext).eInverseAdd(this, ClassesPackage.CONTEXT__CONSTRAINTS, Context.class, msgs);
            msgs = basicSetTheContext(newTheContext, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConstraintsPackage.CONSTRAINT__THE_CONTEXT, newTheContext, newTheContext));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getConstrainedType() {
        if (eContainerFeatureID() != ConstraintsPackage.CONSTRAINT__CONSTRAINED_TYPE) return null;
        return (SapClass)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SapClass basicGetConstrainedType() {
        if (eContainerFeatureID() != ConstraintsPackage.CONSTRAINT__CONSTRAINED_TYPE) return null;
        return (SapClass)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetConstrainedType(SapClass newConstrainedType, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newConstrainedType, ConstraintsPackage.CONSTRAINT__CONSTRAINED_TYPE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setConstrainedType(SapClass newConstrainedType) {
        if (newConstrainedType != eInternalContainer() || (eContainerFeatureID() != ConstraintsPackage.CONSTRAINT__CONSTRAINED_TYPE && newConstrainedType != null)) {
            if (EcoreUtil.isAncestor(this, newConstrainedType))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newConstrainedType != null)
                msgs = ((InternalEObject)newConstrainedType).eInverseAdd(this, ClassesPackage.SAP_CLASS__CONSTRAINTS, SapClass.class, msgs);
            msgs = basicSetConstrainedType(newConstrainedType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConstraintsPackage.CONSTRAINT__CONSTRAINED_TYPE, newConstrainedType, newConstrainedType));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SeverityInState> getSeverityInState() {
        if (severityInState == null) {
            severityInState = new EObjectContainmentEList.Resolving<SeverityInState>(SeverityInState.class, this, ConstraintsPackage.CONSTRAINT__SEVERITY_IN_STATE);
        }
        return severityInState;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getConstraintExpression() {
        if (constraintExpression != null && constraintExpression.eIsProxy()) {
            InternalEObject oldConstraintExpression = (InternalEObject)constraintExpression;
            constraintExpression = (Expression)eResolveProxy(oldConstraintExpression);
            if (constraintExpression != oldConstraintExpression) {
                InternalEObject newConstraintExpression = (InternalEObject)constraintExpression;
                NotificationChain msgs = oldConstraintExpression.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConstraintsPackage.CONSTRAINT__CONSTRAINT_EXPRESSION, null, null);
                if (newConstraintExpression.eInternalContainer() == null) {
                    msgs = newConstraintExpression.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConstraintsPackage.CONSTRAINT__CONSTRAINT_EXPRESSION, null, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConstraintsPackage.CONSTRAINT__CONSTRAINT_EXPRESSION, oldConstraintExpression, constraintExpression));
            }
        }
        return constraintExpression;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetConstraintExpression() {
        return constraintExpression;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetConstraintExpression(Expression newConstraintExpression, NotificationChain msgs) {
        Expression oldConstraintExpression = constraintExpression;
        constraintExpression = newConstraintExpression;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConstraintsPackage.CONSTRAINT__CONSTRAINT_EXPRESSION, oldConstraintExpression, newConstraintExpression);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setConstraintExpression(Expression newConstraintExpression) {
        if (newConstraintExpression != constraintExpression) {
            NotificationChain msgs = null;
            if (constraintExpression != null)
                msgs = ((InternalEObject)constraintExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConstraintsPackage.CONSTRAINT__CONSTRAINT_EXPRESSION, null, msgs);
            if (newConstraintExpression != null)
                msgs = ((InternalEObject)newConstraintExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConstraintsPackage.CONSTRAINT__CONSTRAINT_EXPRESSION, null, msgs);
            msgs = basicSetConstraintExpression(newConstraintExpression, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConstraintsPackage.CONSTRAINT__CONSTRAINT_EXPRESSION, newConstraintExpression, newConstraintExpression));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ConstraintsPackage.CONSTRAINT__THE_CONTEXT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetTheContext((Context)otherEnd, msgs);
            case ConstraintsPackage.CONSTRAINT__CONSTRAINED_TYPE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetConstrainedType((SapClass)otherEnd, msgs);
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
            case ConstraintsPackage.CONSTRAINT__THE_CONTEXT:
                return basicSetTheContext(null, msgs);
            case ConstraintsPackage.CONSTRAINT__CONSTRAINED_TYPE:
                return basicSetConstrainedType(null, msgs);
            case ConstraintsPackage.CONSTRAINT__SEVERITY_IN_STATE:
                return ((InternalEList<?>)getSeverityInState()).basicRemove(otherEnd, msgs);
            case ConstraintsPackage.CONSTRAINT__CONSTRAINT_EXPRESSION:
                return basicSetConstraintExpression(null, msgs);
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
            case ConstraintsPackage.CONSTRAINT__THE_CONTEXT:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.CONTEXT__CONSTRAINTS, Context.class, msgs);
            case ConstraintsPackage.CONSTRAINT__CONSTRAINED_TYPE:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.SAP_CLASS__CONSTRAINTS, SapClass.class, msgs);
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
            case ConstraintsPackage.CONSTRAINT__THE_CONTEXT:
                if (resolve) return getTheContext();
                return basicGetTheContext();
            case ConstraintsPackage.CONSTRAINT__CONSTRAINED_TYPE:
                if (resolve) return getConstrainedType();
                return basicGetConstrainedType();
            case ConstraintsPackage.CONSTRAINT__SEVERITY_IN_STATE:
                return getSeverityInState();
            case ConstraintsPackage.CONSTRAINT__CONSTRAINT_EXPRESSION:
                if (resolve) return getConstraintExpression();
                return basicGetConstraintExpression();
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
            case ConstraintsPackage.CONSTRAINT__THE_CONTEXT:
                setTheContext((Context)newValue);
                return;
            case ConstraintsPackage.CONSTRAINT__CONSTRAINED_TYPE:
                setConstrainedType((SapClass)newValue);
                return;
            case ConstraintsPackage.CONSTRAINT__SEVERITY_IN_STATE:
                getSeverityInState().clear();
                getSeverityInState().addAll((Collection<? extends SeverityInState>)newValue);
                return;
            case ConstraintsPackage.CONSTRAINT__CONSTRAINT_EXPRESSION:
                setConstraintExpression((Expression)newValue);
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
            case ConstraintsPackage.CONSTRAINT__THE_CONTEXT:
                setTheContext((Context)null);
                return;
            case ConstraintsPackage.CONSTRAINT__CONSTRAINED_TYPE:
                setConstrainedType((SapClass)null);
                return;
            case ConstraintsPackage.CONSTRAINT__SEVERITY_IN_STATE:
                getSeverityInState().clear();
                return;
            case ConstraintsPackage.CONSTRAINT__CONSTRAINT_EXPRESSION:
                setConstraintExpression((Expression)null);
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
            case ConstraintsPackage.CONSTRAINT__THE_CONTEXT:
                return basicGetTheContext() != null;
            case ConstraintsPackage.CONSTRAINT__CONSTRAINED_TYPE:
                return basicGetConstrainedType() != null;
            case ConstraintsPackage.CONSTRAINT__SEVERITY_IN_STATE:
                return severityInState != null && !severityInState.isEmpty();
            case ConstraintsPackage.CONSTRAINT__CONSTRAINT_EXPRESSION:
                return constraintExpression != null;
        }
        return super.eIsSet(featureID);
    }

} //ConstraintImpl
