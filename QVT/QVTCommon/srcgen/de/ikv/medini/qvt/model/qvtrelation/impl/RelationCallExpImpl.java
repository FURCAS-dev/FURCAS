/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtrelation.impl;

import de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage;
import de.ikv.medini.qvt.model.qvtrelation.Relation;
import de.ikv.medini.qvt.model.qvtrelation.RelationCallExp;

import de.ikv.medini.qvt.qvt.QvtVisitor;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.oslo.ocl20.semantics.OclVisitor;
import org.oslo.ocl20.semantics.model.expressions.OclExpression;

import org.oslo.ocl20.semantics.model.expressions.impl.OclExpressionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.impl.RelationCallExpImpl#getReferredRelation <em>Referred Relation</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.impl.RelationCallExpImpl#getArgument <em>Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationCallExpImpl extends OclExpressionImpl implements RelationCallExp {
	/**
	 * The cached value of the '{@link #getReferredRelation() <em>Referred Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredRelation()
	 * @generated
	 * @ordered
	 */
	protected Relation referredRelation;

	/**
	 * The cached value of the '{@link #getArgument() <em>Argument</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgument()
	 * @generated
	 * @ordered
	 */
	protected EList argument;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QvtRelationPackage.Literals.RELATION_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation getReferredRelation() {
		if (referredRelation != null && referredRelation.eIsProxy()) {
			InternalEObject oldReferredRelation = (InternalEObject)referredRelation;
			referredRelation = (Relation)eResolveProxy(oldReferredRelation);
			if (referredRelation != oldReferredRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QvtRelationPackage.RELATION_CALL_EXP__REFERRED_RELATION, oldReferredRelation, referredRelation));
			}
		}
		return referredRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetReferredRelation() {
		return referredRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredRelation(Relation newReferredRelation) {
		Relation oldReferredRelation = referredRelation;
		referredRelation = newReferredRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtRelationPackage.RELATION_CALL_EXP__REFERRED_RELATION, oldReferredRelation, referredRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getArgument() {
		if (argument == null) {
			argument = new EObjectContainmentEList(OclExpression.class, this, QvtRelationPackage.RELATION_CALL_EXP__ARGUMENT);
		}
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object accept(OclVisitor visitor, Object data) {
		return ((QvtVisitor)visitor).visit(this,data);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QvtRelationPackage.RELATION_CALL_EXP__ARGUMENT:
				return ((InternalEList)getArgument()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QvtRelationPackage.RELATION_CALL_EXP__REFERRED_RELATION:
				if (resolve) return getReferredRelation();
				return basicGetReferredRelation();
			case QvtRelationPackage.RELATION_CALL_EXP__ARGUMENT:
				return getArgument();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QvtRelationPackage.RELATION_CALL_EXP__REFERRED_RELATION:
				setReferredRelation((Relation)newValue);
				return;
			case QvtRelationPackage.RELATION_CALL_EXP__ARGUMENT:
				getArgument().clear();
				getArgument().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case QvtRelationPackage.RELATION_CALL_EXP__REFERRED_RELATION:
				setReferredRelation((Relation)null);
				return;
			case QvtRelationPackage.RELATION_CALL_EXP__ARGUMENT:
				getArgument().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case QvtRelationPackage.RELATION_CALL_EXP__REFERRED_RELATION:
				return referredRelation != null;
			case QvtRelationPackage.RELATION_CALL_EXP__ARGUMENT:
				return argument != null && !argument.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RelationCallExpImpl
