/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.analytics.impl;

import behavioral.actions.ActionsPackage;
import behavioral.actions.Iterator;

import dataaccess.analytics.AnalyticsPackage;
import dataaccess.analytics.DimensionDefinition;

import dataaccess.analytics.GroupBy;
import dataaccess.expressions.Expression;

import dataaccess.expressions.ExpressionsPackage;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dimension Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.analytics.impl.DimensionDefinitionImpl#getGroupBy <em>Group By</em>}</li>
 *   <li>{@link dataaccess.analytics.impl.DimensionDefinitionImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link dataaccess.analytics.impl.DimensionDefinitionImpl#getIterator <em>Iterator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DimensionDefinitionImpl extends EObjectImpl implements DimensionDefinition {
	/**
     * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getExpression()
     * @generated
     * @ordered
     */
	protected Expression expression;

	/**
     * The cached value of the '{@link #getIterator() <em>Iterator</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIterator()
     * @generated
     * @ordered
     */
	protected Iterator iterator;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected DimensionDefinitionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return AnalyticsPackage.Literals.DIMENSION_DEFINITION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public GroupBy getGroupBy() {
        if (eContainerFeatureID() != AnalyticsPackage.DIMENSION_DEFINITION__GROUP_BY) return null;
        return (GroupBy)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GroupBy basicGetGroupBy() {
        if (eContainerFeatureID() != AnalyticsPackage.DIMENSION_DEFINITION__GROUP_BY) return null;
        return (GroupBy)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetGroupBy(GroupBy newGroupBy, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newGroupBy, AnalyticsPackage.DIMENSION_DEFINITION__GROUP_BY, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setGroupBy(GroupBy newGroupBy) {
        if (newGroupBy != eInternalContainer() || (eContainerFeatureID() != AnalyticsPackage.DIMENSION_DEFINITION__GROUP_BY && newGroupBy != null)) {
            if (EcoreUtil.isAncestor(this, newGroupBy))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newGroupBy != null)
                msgs = ((InternalEObject)newGroupBy).eInverseAdd(this, AnalyticsPackage.GROUP_BY__DIMENSIONS, GroupBy.class, msgs);
            msgs = basicSetGroupBy(newGroupBy, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AnalyticsPackage.DIMENSION_DEFINITION__GROUP_BY, newGroupBy, newGroupBy));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getExpression() {
        if (expression != null && expression.eIsProxy()) {
            InternalEObject oldExpression = (InternalEObject)expression;
            expression = (Expression)eResolveProxy(oldExpression);
            if (expression != oldExpression) {
                InternalEObject newExpression = (InternalEObject)expression;
                NotificationChain msgs =  oldExpression.eInverseRemove(this, ExpressionsPackage.EXPRESSION__DIMENSION, Expression.class, null);
                if (newExpression.eInternalContainer() == null) {
                    msgs =  newExpression.eInverseAdd(this, ExpressionsPackage.EXPRESSION__DIMENSION, Expression.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AnalyticsPackage.DIMENSION_DEFINITION__EXPRESSION, oldExpression, expression));
            }
        }
        return expression;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetExpression() {
        return expression;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs) {
        Expression oldExpression = expression;
        expression = newExpression;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnalyticsPackage.DIMENSION_DEFINITION__EXPRESSION, oldExpression, newExpression);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setExpression(Expression newExpression) {
        if (newExpression != expression) {
            NotificationChain msgs = null;
            if (expression != null)
                msgs = ((InternalEObject)expression).eInverseRemove(this, ExpressionsPackage.EXPRESSION__DIMENSION, Expression.class, msgs);
            if (newExpression != null)
                msgs = ((InternalEObject)newExpression).eInverseAdd(this, ExpressionsPackage.EXPRESSION__DIMENSION, Expression.class, msgs);
            msgs = basicSetExpression(newExpression, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AnalyticsPackage.DIMENSION_DEFINITION__EXPRESSION, newExpression, newExpression));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Iterator getIterator() {
        if (iterator != null && iterator.eIsProxy()) {
            InternalEObject oldIterator = (InternalEObject)iterator;
            iterator = (Iterator)eResolveProxy(oldIterator);
            if (iterator != oldIterator) {
                InternalEObject newIterator = (InternalEObject)iterator;
                NotificationChain msgs =  oldIterator.eInverseRemove(this, ActionsPackage.ITERATOR__DIMENSION, Iterator.class, null);
                if (newIterator.eInternalContainer() == null) {
                    msgs =  newIterator.eInverseAdd(this, ActionsPackage.ITERATOR__DIMENSION, Iterator.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AnalyticsPackage.DIMENSION_DEFINITION__ITERATOR, oldIterator, iterator));
            }
        }
        return iterator;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Iterator basicGetIterator() {
        return iterator;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetIterator(Iterator newIterator, NotificationChain msgs) {
        Iterator oldIterator = iterator;
        iterator = newIterator;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnalyticsPackage.DIMENSION_DEFINITION__ITERATOR, oldIterator, newIterator);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIterator(Iterator newIterator) {
        if (newIterator != iterator) {
            NotificationChain msgs = null;
            if (iterator != null)
                msgs = ((InternalEObject)iterator).eInverseRemove(this, ActionsPackage.ITERATOR__DIMENSION, Iterator.class, msgs);
            if (newIterator != null)
                msgs = ((InternalEObject)newIterator).eInverseAdd(this, ActionsPackage.ITERATOR__DIMENSION, Iterator.class, msgs);
            msgs = basicSetIterator(newIterator, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AnalyticsPackage.DIMENSION_DEFINITION__ITERATOR, newIterator, newIterator));
    }

	/**
     * The cached invocation delegate for the '{@link #getName() <em>Get Name</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_NAME__EINVOCATION_DELEGATE = ((EOperation.Internal)AnalyticsPackage.Literals.DIMENSION_DEFINITION.getEOperations().get(0)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getName() {
        try {
            return (String)GET_NAME__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
            case AnalyticsPackage.DIMENSION_DEFINITION__GROUP_BY:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetGroupBy((GroupBy)otherEnd, msgs);
            case AnalyticsPackage.DIMENSION_DEFINITION__EXPRESSION:
                if (expression != null)
                    msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnalyticsPackage.DIMENSION_DEFINITION__EXPRESSION, null, msgs);
                return basicSetExpression((Expression)otherEnd, msgs);
            case AnalyticsPackage.DIMENSION_DEFINITION__ITERATOR:
                if (iterator != null)
                    msgs = ((InternalEObject)iterator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnalyticsPackage.DIMENSION_DEFINITION__ITERATOR, null, msgs);
                return basicSetIterator((Iterator)otherEnd, msgs);
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
            case AnalyticsPackage.DIMENSION_DEFINITION__GROUP_BY:
                return basicSetGroupBy(null, msgs);
            case AnalyticsPackage.DIMENSION_DEFINITION__EXPRESSION:
                return basicSetExpression(null, msgs);
            case AnalyticsPackage.DIMENSION_DEFINITION__ITERATOR:
                return basicSetIterator(null, msgs);
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
            case AnalyticsPackage.DIMENSION_DEFINITION__GROUP_BY:
                return eInternalContainer().eInverseRemove(this, AnalyticsPackage.GROUP_BY__DIMENSIONS, GroupBy.class, msgs);
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
            case AnalyticsPackage.DIMENSION_DEFINITION__GROUP_BY:
                if (resolve) return getGroupBy();
                return basicGetGroupBy();
            case AnalyticsPackage.DIMENSION_DEFINITION__EXPRESSION:
                if (resolve) return getExpression();
                return basicGetExpression();
            case AnalyticsPackage.DIMENSION_DEFINITION__ITERATOR:
                if (resolve) return getIterator();
                return basicGetIterator();
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
            case AnalyticsPackage.DIMENSION_DEFINITION__GROUP_BY:
                setGroupBy((GroupBy)newValue);
                return;
            case AnalyticsPackage.DIMENSION_DEFINITION__EXPRESSION:
                setExpression((Expression)newValue);
                return;
            case AnalyticsPackage.DIMENSION_DEFINITION__ITERATOR:
                setIterator((Iterator)newValue);
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
            case AnalyticsPackage.DIMENSION_DEFINITION__GROUP_BY:
                setGroupBy((GroupBy)null);
                return;
            case AnalyticsPackage.DIMENSION_DEFINITION__EXPRESSION:
                setExpression((Expression)null);
                return;
            case AnalyticsPackage.DIMENSION_DEFINITION__ITERATOR:
                setIterator((Iterator)null);
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
            case AnalyticsPackage.DIMENSION_DEFINITION__GROUP_BY:
                return basicGetGroupBy() != null;
            case AnalyticsPackage.DIMENSION_DEFINITION__EXPRESSION:
                return expression != null;
            case AnalyticsPackage.DIMENSION_DEFINITION__ITERATOR:
                return iterator != null;
        }
        return super.eIsSet(featureID);
    }

} //DimensionDefinitionImpl
