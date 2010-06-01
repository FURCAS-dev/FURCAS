/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.collectionexpressions.impl;

import behavioral.actions.ActionsPackage;
import behavioral.actions.Constant;
import behavioral.actions.Iterator;

import dataaccess.expressions.Expression;
import dataaccess.expressions.ExpressionsPackage;

import dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage;
import dataaccess.expressions.collectionexpressions.Iterate;

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
 * An implementation of the model object '<em><b>Iterate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.collectionexpressions.impl.IterateImpl#getIterators <em>Iterators</em>}</li>
 *   <li>{@link dataaccess.expressions.collectionexpressions.impl.IterateImpl#getAccumulator <em>Accumulator</em>}</li>
 *   <li>{@link dataaccess.expressions.collectionexpressions.impl.IterateImpl#getIteratorExpression <em>Iterator Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IterateImpl extends CollectionExpressionImpl implements Iterate {
	/**
	 * The cached value of the '{@link #getIterators() <em>Iterators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterators()
	 * @generated
	 * @ordered
	 */
	protected EList<Iterator> iterators;

	/**
	 * The cached value of the '{@link #getAccumulator() <em>Accumulator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccumulator()
	 * @generated
	 * @ordered
	 */
	protected Constant accumulator;

	/**
	 * The cached value of the '{@link #getIteratorExpression() <em>Iterator Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIteratorExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression iteratorExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IterateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CollectionexpressionsPackage.Literals.ITERATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Iterator> getIterators() {
		if (iterators == null) {
			iterators = new EObjectContainmentWithInverseEList<Iterator>(Iterator.class, this, CollectionexpressionsPackage.ITERATE__ITERATORS, ActionsPackage.ITERATOR__ITERATE);
		}
		return iterators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constant getAccumulator() {
		return accumulator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAccumulator(Constant newAccumulator, NotificationChain msgs) {
		Constant oldAccumulator = accumulator;
		accumulator = newAccumulator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CollectionexpressionsPackage.ITERATE__ACCUMULATOR, oldAccumulator, newAccumulator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccumulator(Constant newAccumulator) {
		if (newAccumulator != accumulator) {
			NotificationChain msgs = null;
			if (accumulator != null)
				msgs = ((InternalEObject)accumulator).eInverseRemove(this, ActionsPackage.CONSTANT__ITERATE, Constant.class, msgs);
			if (newAccumulator != null)
				msgs = ((InternalEObject)newAccumulator).eInverseAdd(this, ActionsPackage.CONSTANT__ITERATE, Constant.class, msgs);
			msgs = basicSetAccumulator(newAccumulator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CollectionexpressionsPackage.ITERATE__ACCUMULATOR, newAccumulator, newAccumulator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getIteratorExpression() {
		return iteratorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIteratorExpression(Expression newIteratorExpression, NotificationChain msgs) {
		Expression oldIteratorExpression = iteratorExpression;
		iteratorExpression = newIteratorExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CollectionexpressionsPackage.ITERATE__ITERATOR_EXPRESSION, oldIteratorExpression, newIteratorExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIteratorExpression(Expression newIteratorExpression) {
		if (newIteratorExpression != iteratorExpression) {
			NotificationChain msgs = null;
			if (iteratorExpression != null)
				msgs = ((InternalEObject)iteratorExpression).eInverseRemove(this, ExpressionsPackage.EXPRESSION__IN_ITERATOR, Expression.class, msgs);
			if (newIteratorExpression != null)
				msgs = ((InternalEObject)newIteratorExpression).eInverseAdd(this, ExpressionsPackage.EXPRESSION__IN_ITERATOR, Expression.class, msgs);
			msgs = basicSetIteratorExpression(newIteratorExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CollectionexpressionsPackage.ITERATE__ITERATOR_EXPRESSION, newIteratorExpression, newIteratorExpression));
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
			case CollectionexpressionsPackage.ITERATE__ITERATORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIterators()).basicAdd(otherEnd, msgs);
			case CollectionexpressionsPackage.ITERATE__ACCUMULATOR:
				if (accumulator != null)
					msgs = ((InternalEObject)accumulator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CollectionexpressionsPackage.ITERATE__ACCUMULATOR, null, msgs);
				return basicSetAccumulator((Constant)otherEnd, msgs);
			case CollectionexpressionsPackage.ITERATE__ITERATOR_EXPRESSION:
				if (iteratorExpression != null)
					msgs = ((InternalEObject)iteratorExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CollectionexpressionsPackage.ITERATE__ITERATOR_EXPRESSION, null, msgs);
				return basicSetIteratorExpression((Expression)otherEnd, msgs);
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
			case CollectionexpressionsPackage.ITERATE__ITERATORS:
				return ((InternalEList<?>)getIterators()).basicRemove(otherEnd, msgs);
			case CollectionexpressionsPackage.ITERATE__ACCUMULATOR:
				return basicSetAccumulator(null, msgs);
			case CollectionexpressionsPackage.ITERATE__ITERATOR_EXPRESSION:
				return basicSetIteratorExpression(null, msgs);
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
			case CollectionexpressionsPackage.ITERATE__ITERATORS:
				return getIterators();
			case CollectionexpressionsPackage.ITERATE__ACCUMULATOR:
				return getAccumulator();
			case CollectionexpressionsPackage.ITERATE__ITERATOR_EXPRESSION:
				return getIteratorExpression();
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
			case CollectionexpressionsPackage.ITERATE__ITERATORS:
				getIterators().clear();
				getIterators().addAll((Collection<? extends Iterator>)newValue);
				return;
			case CollectionexpressionsPackage.ITERATE__ACCUMULATOR:
				setAccumulator((Constant)newValue);
				return;
			case CollectionexpressionsPackage.ITERATE__ITERATOR_EXPRESSION:
				setIteratorExpression((Expression)newValue);
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
			case CollectionexpressionsPackage.ITERATE__ITERATORS:
				getIterators().clear();
				return;
			case CollectionexpressionsPackage.ITERATE__ACCUMULATOR:
				setAccumulator((Constant)null);
				return;
			case CollectionexpressionsPackage.ITERATE__ITERATOR_EXPRESSION:
				setIteratorExpression((Expression)null);
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
			case CollectionexpressionsPackage.ITERATE__ITERATORS:
				return iterators != null && !iterators.isEmpty();
			case CollectionexpressionsPackage.ITERATE__ACCUMULATOR:
				return accumulator != null;
			case CollectionexpressionsPackage.ITERATE__ITERATOR_EXPRESSION:
				return iteratorExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //IterateImpl
