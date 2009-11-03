/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.contexts.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.bridge.Namespace;

import org.oslo.ocl20.semantics.impl.SemanticsVisitableImpl;

import org.oslo.ocl20.semantics.model.contexts.Constraint;
import org.oslo.ocl20.semantics.model.contexts.ContextDeclaration;
import org.oslo.ocl20.semantics.model.contexts.ContextsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Context Declaration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.oslo.ocl20.semantics.model.contexts.impl.ContextDeclarationImpl#getReferredNamespace
 * <em>Referred Namespace</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.contexts.impl.ContextDeclarationImpl#getConstraint <em>
 * Constraint</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ContextDeclarationImpl extends SemanticsVisitableImpl implements ContextDeclaration {
	/**
	 * The cached value of the '{@link #getReferredNamespace() <em>Referred Namespace</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReferredNamespace()
	 * @generated
	 * @ordered
	 */
	protected Namespace referredNamespace;

	/**
	 * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList constraint;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ContextDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ContextsPackage.Literals.CONTEXT_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Namespace getReferredNamespace() {
		if (referredNamespace != null && referredNamespace.eIsProxy()) {
			InternalEObject oldReferredNamespace = (InternalEObject) referredNamespace;
			referredNamespace = (Namespace) eResolveProxy(oldReferredNamespace);
			if (referredNamespace != oldReferredNamespace) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
					    ContextsPackage.CONTEXT_DECLARATION__REFERRED_NAMESPACE, oldReferredNamespace,
					    referredNamespace));
			}
		}
		return referredNamespace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Namespace basicGetReferredNamespace() {
		return referredNamespace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setReferredNamespace(Namespace newReferredNamespace) {
		Namespace oldReferredNamespace = referredNamespace;
		referredNamespace = newReferredNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ContextsPackage.CONTEXT_DECLARATION__REFERRED_NAMESPACE, oldReferredNamespace, referredNamespace));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList getConstraint() {
		if (constraint == null) {
			constraint = new EObjectContainmentWithInverseEList(Constraint.class, this,
			    ContextsPackage.CONTEXT_DECLARATION__CONSTRAINT, ContextsPackage.CONSTRAINT__CONTEXT);
		}
		return constraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object accept(OclVisitor visitor, Object data) {
		return ((OclVisitor) visitor).visit(this, data);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ContextsPackage.CONTEXT_DECLARATION__CONSTRAINT:
				return ((InternalEList) getConstraint()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ContextsPackage.CONTEXT_DECLARATION__CONSTRAINT:
				return ((InternalEList) getConstraint()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ContextsPackage.CONTEXT_DECLARATION__REFERRED_NAMESPACE:
				if (resolve)
					return getReferredNamespace();
				return basicGetReferredNamespace();
			case ContextsPackage.CONTEXT_DECLARATION__CONSTRAINT:
				return getConstraint();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ContextsPackage.CONTEXT_DECLARATION__REFERRED_NAMESPACE:
				setReferredNamespace((Namespace) newValue);
				return;
			case ContextsPackage.CONTEXT_DECLARATION__CONSTRAINT:
				getConstraint().clear();
				getConstraint().addAll((Collection) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ContextsPackage.CONTEXT_DECLARATION__REFERRED_NAMESPACE:
				setReferredNamespace((Namespace) null);
				return;
			case ContextsPackage.CONTEXT_DECLARATION__CONSTRAINT:
				getConstraint().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ContextsPackage.CONTEXT_DECLARATION__REFERRED_NAMESPACE:
				return referredNamespace != null;
			case ContextsPackage.CONTEXT_DECLARATION__CONSTRAINT:
				return constraint != null && !constraint.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ContextDeclarationImpl
