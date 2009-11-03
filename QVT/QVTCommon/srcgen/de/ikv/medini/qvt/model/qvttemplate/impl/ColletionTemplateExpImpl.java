/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvttemplate.impl;

import de.ikv.medini.qvt.model.qvttemplate.ColletionTemplateExp;
import de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.oslo.ocl20.semantics.model.expressions.OclExpression;

import org.oslo.ocl20.semantics.model.types.CollectionType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Colletion Template Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvttemplate.impl.ColletionTemplateExpImpl#getMatch <em>Match</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvttemplate.impl.ColletionTemplateExpImpl#getPart <em>Part</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvttemplate.impl.ColletionTemplateExpImpl#getRefferedCollectionType <em>Reffered Collection Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColletionTemplateExpImpl extends TemplateExpImpl implements ColletionTemplateExp {
	/**
	 * The cached value of the '{@link #getMatch() <em>Match</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatch()
	 * @generated
	 * @ordered
	 */
	protected OclExpression match;

	/**
	 * The cached value of the '{@link #getPart() <em>Part</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPart()
	 * @generated
	 * @ordered
	 */
	protected EList part;

	/**
	 * The cached value of the '{@link #getRefferedCollectionType() <em>Reffered Collection Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefferedCollectionType()
	 * @generated
	 * @ordered
	 */
	protected CollectionType refferedCollectionType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColletionTemplateExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QvtTemplatePackage.Literals.COLLETION_TEMPLATE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getMatch() {
		if (match != null && match.eIsProxy()) {
			InternalEObject oldMatch = (InternalEObject)match;
			match = (OclExpression)eResolveProxy(oldMatch);
			if (match != oldMatch) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QvtTemplatePackage.COLLETION_TEMPLATE_EXP__MATCH, oldMatch, match));
			}
		}
		return match;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetMatch() {
		return match;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatch(OclExpression newMatch) {
		OclExpression oldMatch = match;
		match = newMatch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtTemplatePackage.COLLETION_TEMPLATE_EXP__MATCH, oldMatch, match));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPart() {
		if (part == null) {
			part = new EObjectContainmentEList(OclExpression.class, this, QvtTemplatePackage.COLLETION_TEMPLATE_EXP__PART);
		}
		return part;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionType getRefferedCollectionType() {
		if (refferedCollectionType != null && refferedCollectionType.eIsProxy()) {
			InternalEObject oldRefferedCollectionType = (InternalEObject)refferedCollectionType;
			refferedCollectionType = (CollectionType)eResolveProxy(oldRefferedCollectionType);
			if (refferedCollectionType != oldRefferedCollectionType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QvtTemplatePackage.COLLETION_TEMPLATE_EXP__REFFERED_COLLECTION_TYPE, oldRefferedCollectionType, refferedCollectionType));
			}
		}
		return refferedCollectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionType basicGetRefferedCollectionType() {
		return refferedCollectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefferedCollectionType(CollectionType newRefferedCollectionType) {
		CollectionType oldRefferedCollectionType = refferedCollectionType;
		refferedCollectionType = newRefferedCollectionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtTemplatePackage.COLLETION_TEMPLATE_EXP__REFFERED_COLLECTION_TYPE, oldRefferedCollectionType, refferedCollectionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QvtTemplatePackage.COLLETION_TEMPLATE_EXP__PART:
				return ((InternalEList)getPart()).basicRemove(otherEnd, msgs);
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
			case QvtTemplatePackage.COLLETION_TEMPLATE_EXP__MATCH:
				if (resolve) return getMatch();
				return basicGetMatch();
			case QvtTemplatePackage.COLLETION_TEMPLATE_EXP__PART:
				return getPart();
			case QvtTemplatePackage.COLLETION_TEMPLATE_EXP__REFFERED_COLLECTION_TYPE:
				if (resolve) return getRefferedCollectionType();
				return basicGetRefferedCollectionType();
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
			case QvtTemplatePackage.COLLETION_TEMPLATE_EXP__MATCH:
				setMatch((OclExpression)newValue);
				return;
			case QvtTemplatePackage.COLLETION_TEMPLATE_EXP__PART:
				getPart().clear();
				getPart().addAll((Collection)newValue);
				return;
			case QvtTemplatePackage.COLLETION_TEMPLATE_EXP__REFFERED_COLLECTION_TYPE:
				setRefferedCollectionType((CollectionType)newValue);
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
			case QvtTemplatePackage.COLLETION_TEMPLATE_EXP__MATCH:
				setMatch((OclExpression)null);
				return;
			case QvtTemplatePackage.COLLETION_TEMPLATE_EXP__PART:
				getPart().clear();
				return;
			case QvtTemplatePackage.COLLETION_TEMPLATE_EXP__REFFERED_COLLECTION_TYPE:
				setRefferedCollectionType((CollectionType)null);
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
			case QvtTemplatePackage.COLLETION_TEMPLATE_EXP__MATCH:
				return match != null;
			case QvtTemplatePackage.COLLETION_TEMPLATE_EXP__PART:
				return part != null && !part.isEmpty();
			case QvtTemplatePackage.COLLETION_TEMPLATE_EXP__REFFERED_COLLECTION_TYPE:
				return refferedCollectionType != null;
		}
		return super.eIsSet(featureID);
	}

} //ColletionTemplateExpImpl
