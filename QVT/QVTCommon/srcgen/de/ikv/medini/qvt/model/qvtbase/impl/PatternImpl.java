/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtbase.impl;

import de.ikv.medini.qvt.model.qvtbase.Pattern;
import de.ikv.medini.qvt.model.qvtbase.Predicate;
import de.ikv.medini.qvt.model.qvtbase.QvtBasePackage;

import de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage;
import de.ikv.medini.qvt.model.qvtrelation.Relation;

import de.ikv.medini.qvt.qvt.QvtVisitor;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.oslo.ocl20.semantics.OclVisitor;
import org.oslo.ocl20.semantics.bridge.impl.ElementImpl;

import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.PatternImpl#getWhereOwner <em>Where Owner</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.PatternImpl#getWhenOwner <em>When Owner</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.PatternImpl#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.PatternImpl#getBindsTo <em>Binds To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatternImpl extends ElementImpl implements Pattern {
	/**
	 * The cached value of the '{@link #getPredicate() <em>Predicate</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicate()
	 * @generated
	 * @ordered
	 */
	protected EList predicate;

	/**
	 * The cached value of the '{@link #getBindsTo() <em>Binds To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindsTo()
	 * @generated
	 * @ordered
	 */
	protected EList bindsTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QvtBasePackage.Literals.PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation getWhereOwner() {
		if (eContainerFeatureID != QvtBasePackage.PATTERN__WHERE_OWNER) return null;
		return (Relation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhereOwner(Relation newWhereOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newWhereOwner, QvtBasePackage.PATTERN__WHERE_OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhereOwner(Relation newWhereOwner) {
		if (newWhereOwner != eInternalContainer() || (eContainerFeatureID != QvtBasePackage.PATTERN__WHERE_OWNER && newWhereOwner != null)) {
			if (EcoreUtil.isAncestor(this, newWhereOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newWhereOwner != null)
				msgs = ((InternalEObject)newWhereOwner).eInverseAdd(this, QvtRelationPackage.RELATION__WHERE, Relation.class, msgs);
			msgs = basicSetWhereOwner(newWhereOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtBasePackage.PATTERN__WHERE_OWNER, newWhereOwner, newWhereOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation getWhenOwner() {
		if (eContainerFeatureID != QvtBasePackage.PATTERN__WHEN_OWNER) return null;
		return (Relation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhenOwner(Relation newWhenOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newWhenOwner, QvtBasePackage.PATTERN__WHEN_OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhenOwner(Relation newWhenOwner) {
		if (newWhenOwner != eInternalContainer() || (eContainerFeatureID != QvtBasePackage.PATTERN__WHEN_OWNER && newWhenOwner != null)) {
			if (EcoreUtil.isAncestor(this, newWhenOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newWhenOwner != null)
				msgs = ((InternalEObject)newWhenOwner).eInverseAdd(this, QvtRelationPackage.RELATION__WHEN, Relation.class, msgs);
			msgs = basicSetWhenOwner(newWhenOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtBasePackage.PATTERN__WHEN_OWNER, newWhenOwner, newWhenOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPredicate() {
		if (predicate == null) {
			predicate = new EObjectContainmentWithInverseEList(Predicate.class, this, QvtBasePackage.PATTERN__PREDICATE, QvtBasePackage.PREDICATE__PATTERN);
		}
		return predicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getBindsTo() {
		if (bindsTo == null) {
			bindsTo = new EObjectResolvingEList(VariableDeclaration.class, this, QvtBasePackage.PATTERN__BINDS_TO);
		}
		return bindsTo;
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QvtBasePackage.PATTERN__WHERE_OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetWhereOwner((Relation)otherEnd, msgs);
			case QvtBasePackage.PATTERN__WHEN_OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetWhenOwner((Relation)otherEnd, msgs);
			case QvtBasePackage.PATTERN__PREDICATE:
				return ((InternalEList)getPredicate()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QvtBasePackage.PATTERN__WHERE_OWNER:
				return basicSetWhereOwner(null, msgs);
			case QvtBasePackage.PATTERN__WHEN_OWNER:
				return basicSetWhenOwner(null, msgs);
			case QvtBasePackage.PATTERN__PREDICATE:
				return ((InternalEList)getPredicate()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case QvtBasePackage.PATTERN__WHERE_OWNER:
				return eInternalContainer().eInverseRemove(this, QvtRelationPackage.RELATION__WHERE, Relation.class, msgs);
			case QvtBasePackage.PATTERN__WHEN_OWNER:
				return eInternalContainer().eInverseRemove(this, QvtRelationPackage.RELATION__WHEN, Relation.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QvtBasePackage.PATTERN__WHERE_OWNER:
				return getWhereOwner();
			case QvtBasePackage.PATTERN__WHEN_OWNER:
				return getWhenOwner();
			case QvtBasePackage.PATTERN__PREDICATE:
				return getPredicate();
			case QvtBasePackage.PATTERN__BINDS_TO:
				return getBindsTo();
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
			case QvtBasePackage.PATTERN__WHERE_OWNER:
				setWhereOwner((Relation)newValue);
				return;
			case QvtBasePackage.PATTERN__WHEN_OWNER:
				setWhenOwner((Relation)newValue);
				return;
			case QvtBasePackage.PATTERN__PREDICATE:
				getPredicate().clear();
				getPredicate().addAll((Collection)newValue);
				return;
			case QvtBasePackage.PATTERN__BINDS_TO:
				getBindsTo().clear();
				getBindsTo().addAll((Collection)newValue);
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
			case QvtBasePackage.PATTERN__WHERE_OWNER:
				setWhereOwner((Relation)null);
				return;
			case QvtBasePackage.PATTERN__WHEN_OWNER:
				setWhenOwner((Relation)null);
				return;
			case QvtBasePackage.PATTERN__PREDICATE:
				getPredicate().clear();
				return;
			case QvtBasePackage.PATTERN__BINDS_TO:
				getBindsTo().clear();
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
			case QvtBasePackage.PATTERN__WHERE_OWNER:
				return getWhereOwner() != null;
			case QvtBasePackage.PATTERN__WHEN_OWNER:
				return getWhenOwner() != null;
			case QvtBasePackage.PATTERN__PREDICATE:
				return predicate != null && !predicate.isEmpty();
			case QvtBasePackage.PATTERN__BINDS_TO:
				return bindsTo != null && !bindsTo.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PatternImpl
