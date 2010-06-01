/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.actions.impl;

import behavioral.actions.ActionsPackage;
import behavioral.actions.Foreach;
import behavioral.actions.Iterator;

import data.classes.impl.NamedValueImpl;

import dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage;
import dataaccess.expressions.collectionexpressions.Iterate;

import dataaccess.query.FromClause;
import dataaccess.query.QueryPackage;
import dataaccess.query.Selection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.actions.impl.IteratorImpl#getBoundToFor <em>Bound To For</em>}</li>
 *   <li>{@link behavioral.actions.impl.IteratorImpl#getIterate <em>Iterate</em>}</li>
 *   <li>{@link behavioral.actions.impl.IteratorImpl#getSelection <em>Selection</em>}</li>
 *   <li>{@link behavioral.actions.impl.IteratorImpl#getFromClause <em>From Clause</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IteratorImpl extends NamedValueImpl implements Iterator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IteratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionsPackage.Literals.ITERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Foreach getBoundToFor() {
		if (eContainerFeatureID() != ActionsPackage.ITERATOR__BOUND_TO_FOR) return null;
		return (Foreach)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBoundToFor(Foreach newBoundToFor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newBoundToFor, ActionsPackage.ITERATOR__BOUND_TO_FOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundToFor(Foreach newBoundToFor) {
		if (newBoundToFor != eInternalContainer() || (eContainerFeatureID() != ActionsPackage.ITERATOR__BOUND_TO_FOR && newBoundToFor != null)) {
			if (EcoreUtil.isAncestor(this, newBoundToFor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newBoundToFor != null)
				msgs = ((InternalEObject)newBoundToFor).eInverseAdd(this, ActionsPackage.FOREACH__FOR_VARIABLE, Foreach.class, msgs);
			msgs = basicSetBoundToFor(newBoundToFor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.ITERATOR__BOUND_TO_FOR, newBoundToFor, newBoundToFor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterate getIterate() {
		if (eContainerFeatureID() != ActionsPackage.ITERATOR__ITERATE) return null;
		return (Iterate)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIterate(Iterate newIterate, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newIterate, ActionsPackage.ITERATOR__ITERATE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterate(Iterate newIterate) {
		if (newIterate != eInternalContainer() || (eContainerFeatureID() != ActionsPackage.ITERATOR__ITERATE && newIterate != null)) {
			if (EcoreUtil.isAncestor(this, newIterate))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newIterate != null)
				msgs = ((InternalEObject)newIterate).eInverseAdd(this, CollectionexpressionsPackage.ITERATE__ITERATORS, Iterate.class, msgs);
			msgs = basicSetIterate(newIterate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.ITERATOR__ITERATE, newIterate, newIterate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Selection getSelection() {
		if (eContainerFeatureID() != ActionsPackage.ITERATOR__SELECTION) return null;
		return (Selection)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSelection(Selection newSelection, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSelection, ActionsPackage.ITERATOR__SELECTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelection(Selection newSelection) {
		if (newSelection != eInternalContainer() || (eContainerFeatureID() != ActionsPackage.ITERATOR__SELECTION && newSelection != null)) {
			if (EcoreUtil.isAncestor(this, newSelection))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSelection != null)
				msgs = ((InternalEObject)newSelection).eInverseAdd(this, QueryPackage.SELECTION__ITERATOR, Selection.class, msgs);
			msgs = basicSetSelection(newSelection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.ITERATOR__SELECTION, newSelection, newSelection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromClause getFromClause() {
		if (eContainerFeatureID() != ActionsPackage.ITERATOR__FROM_CLAUSE) return null;
		return (FromClause)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFromClause(FromClause newFromClause, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFromClause, ActionsPackage.ITERATOR__FROM_CLAUSE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromClause(FromClause newFromClause) {
		if (newFromClause != eInternalContainer() || (eContainerFeatureID() != ActionsPackage.ITERATOR__FROM_CLAUSE && newFromClause != null)) {
			if (EcoreUtil.isAncestor(this, newFromClause))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFromClause != null)
				msgs = ((InternalEObject)newFromClause).eInverseAdd(this, QueryPackage.FROM_CLAUSE__ALIAS, FromClause.class, msgs);
			msgs = basicSetFromClause(newFromClause, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.ITERATOR__FROM_CLAUSE, newFromClause, newFromClause));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionsPackage.ITERATOR__BOUND_TO_FOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetBoundToFor((Foreach)otherEnd, msgs);
			case ActionsPackage.ITERATOR__ITERATE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetIterate((Iterate)otherEnd, msgs);
			case ActionsPackage.ITERATOR__SELECTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSelection((Selection)otherEnd, msgs);
			case ActionsPackage.ITERATOR__FROM_CLAUSE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFromClause((FromClause)otherEnd, msgs);
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
			case ActionsPackage.ITERATOR__BOUND_TO_FOR:
				return basicSetBoundToFor(null, msgs);
			case ActionsPackage.ITERATOR__ITERATE:
				return basicSetIterate(null, msgs);
			case ActionsPackage.ITERATOR__SELECTION:
				return basicSetSelection(null, msgs);
			case ActionsPackage.ITERATOR__FROM_CLAUSE:
				return basicSetFromClause(null, msgs);
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
			case ActionsPackage.ITERATOR__BOUND_TO_FOR:
				return eInternalContainer().eInverseRemove(this, ActionsPackage.FOREACH__FOR_VARIABLE, Foreach.class, msgs);
			case ActionsPackage.ITERATOR__ITERATE:
				return eInternalContainer().eInverseRemove(this, CollectionexpressionsPackage.ITERATE__ITERATORS, Iterate.class, msgs);
			case ActionsPackage.ITERATOR__SELECTION:
				return eInternalContainer().eInverseRemove(this, QueryPackage.SELECTION__ITERATOR, Selection.class, msgs);
			case ActionsPackage.ITERATOR__FROM_CLAUSE:
				return eInternalContainer().eInverseRemove(this, QueryPackage.FROM_CLAUSE__ALIAS, FromClause.class, msgs);
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
			case ActionsPackage.ITERATOR__BOUND_TO_FOR:
				return getBoundToFor();
			case ActionsPackage.ITERATOR__ITERATE:
				return getIterate();
			case ActionsPackage.ITERATOR__SELECTION:
				return getSelection();
			case ActionsPackage.ITERATOR__FROM_CLAUSE:
				return getFromClause();
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
			case ActionsPackage.ITERATOR__BOUND_TO_FOR:
				setBoundToFor((Foreach)newValue);
				return;
			case ActionsPackage.ITERATOR__ITERATE:
				setIterate((Iterate)newValue);
				return;
			case ActionsPackage.ITERATOR__SELECTION:
				setSelection((Selection)newValue);
				return;
			case ActionsPackage.ITERATOR__FROM_CLAUSE:
				setFromClause((FromClause)newValue);
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
			case ActionsPackage.ITERATOR__BOUND_TO_FOR:
				setBoundToFor((Foreach)null);
				return;
			case ActionsPackage.ITERATOR__ITERATE:
				setIterate((Iterate)null);
				return;
			case ActionsPackage.ITERATOR__SELECTION:
				setSelection((Selection)null);
				return;
			case ActionsPackage.ITERATOR__FROM_CLAUSE:
				setFromClause((FromClause)null);
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
			case ActionsPackage.ITERATOR__BOUND_TO_FOR:
				return getBoundToFor() != null;
			case ActionsPackage.ITERATOR__ITERATE:
				return getIterate() != null;
			case ActionsPackage.ITERATOR__SELECTION:
				return getSelection() != null;
			case ActionsPackage.ITERATOR__FROM_CLAUSE:
				return getFromClause() != null;
		}
		return super.eIsSet(featureID);
	}

} //IteratorImpl
