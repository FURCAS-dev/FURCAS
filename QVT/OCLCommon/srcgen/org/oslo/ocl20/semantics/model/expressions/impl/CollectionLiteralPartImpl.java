/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.bridge.Classifier;

import org.oslo.ocl20.semantics.impl.SemanticsVisitableImpl;

import org.oslo.ocl20.semantics.model.expressions.CollectionLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.CollectionLiteralPart;
import org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Collection Literal Part</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.oslo.ocl20.semantics.model.expressions.impl.CollectionLiteralPartImpl#getCollectionLiteralExp
 * <em>Collection Literal Exp</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.impl.CollectionLiteralPartImpl#getType <em>
 * Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CollectionLiteralPartImpl extends SemanticsVisitableImpl implements CollectionLiteralPart {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Classifier type;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CollectionLiteralPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.COLLECTION_LITERAL_PART;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollectionLiteralExp getCollectionLiteralExp() {
		if (eContainerFeatureID != ExpressionsPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP)
			return null;
		return (CollectionLiteralExp) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetCollectionLiteralExp(CollectionLiteralExp newCollectionLiteralExp,
	        NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newCollectionLiteralExp,
		    ExpressionsPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCollectionLiteralExp(CollectionLiteralExp newCollectionLiteralExp) {
		if (newCollectionLiteralExp != eInternalContainer()
		        || (eContainerFeatureID != ExpressionsPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP && newCollectionLiteralExp != null)) {
			if (EcoreUtil.isAncestor(this, newCollectionLiteralExp))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCollectionLiteralExp != null)
				msgs = ((InternalEObject) newCollectionLiteralExp).eInverseAdd(this,
				    ExpressionsPackage.COLLECTION_LITERAL_EXP__PARTS, CollectionLiteralExp.class, msgs);
			msgs = basicSetCollectionLiteralExp(newCollectionLiteralExp, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ExpressionsPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP, newCollectionLiteralExp,
			    newCollectionLiteralExp));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Classifier getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject) type;
			type = (Classifier) eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
					    ExpressionsPackage.COLLECTION_LITERAL_PART__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Classifier basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setType(Classifier newType) {
		Classifier oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.COLLECTION_LITERAL_PART__TYPE,
			    oldType, type));
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
			case ExpressionsPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCollectionLiteralExp((CollectionLiteralExp) otherEnd, msgs);
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
			case ExpressionsPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP:
				return basicSetCollectionLiteralExp(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case ExpressionsPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP:
				return eInternalContainer().eInverseRemove(this, ExpressionsPackage.COLLECTION_LITERAL_EXP__PARTS,
				    CollectionLiteralExp.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionsPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP:
				return getCollectionLiteralExp();
			case ExpressionsPackage.COLLECTION_LITERAL_PART__TYPE:
				if (resolve)
					return getType();
				return basicGetType();
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
			case ExpressionsPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP:
				setCollectionLiteralExp((CollectionLiteralExp) newValue);
				return;
			case ExpressionsPackage.COLLECTION_LITERAL_PART__TYPE:
				setType((Classifier) newValue);
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
			case ExpressionsPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP:
				setCollectionLiteralExp((CollectionLiteralExp) null);
				return;
			case ExpressionsPackage.COLLECTION_LITERAL_PART__TYPE:
				setType((Classifier) null);
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
			case ExpressionsPackage.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP:
				return getCollectionLiteralExp() != null;
			case ExpressionsPackage.COLLECTION_LITERAL_PART__TYPE:
				return type != null;
		}
		return super.eIsSet(featureID);
	}

} // CollectionLiteralPartImpl
