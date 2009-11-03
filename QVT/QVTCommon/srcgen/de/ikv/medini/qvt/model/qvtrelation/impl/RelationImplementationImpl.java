/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtrelation.impl;

import de.ikv.medini.qvt.model.qvtbase.TypedModel;

import de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage;
import de.ikv.medini.qvt.model.qvtrelation.Relation;
import de.ikv.medini.qvt.model.qvtrelation.RelationImplementation;

import de.ikv.medini.qvt.qvt.QvtVisitor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.oslo.ocl20.semantics.OclVisitor;
import org.oslo.ocl20.semantics.bridge.Operation;

import org.oslo.ocl20.semantics.bridge.impl.ElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.impl.RelationImplementationImpl#getRelation <em>Relation</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.impl.RelationImplementationImpl#getImpl <em>Impl</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.impl.RelationImplementationImpl#getInDirectionOf <em>In Direction Of</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationImplementationImpl extends ElementImpl implements RelationImplementation {
	/**
	 * The cached value of the '{@link #getRelation() <em>Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected Relation relation;

	/**
	 * The cached value of the '{@link #getImpl() <em>Impl</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImpl()
	 * @generated
	 * @ordered
	 */
	protected Operation impl;

	/**
	 * The cached value of the '{@link #getInDirectionOf() <em>In Direction Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInDirectionOf()
	 * @generated
	 * @ordered
	 */
	protected TypedModel inDirectionOf;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QvtRelationPackage.Literals.RELATION_IMPLEMENTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation getRelation() {
		if (relation != null && relation.eIsProxy()) {
			InternalEObject oldRelation = (InternalEObject)relation;
			relation = (Relation)eResolveProxy(oldRelation);
			if (relation != oldRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QvtRelationPackage.RELATION_IMPLEMENTATION__RELATION, oldRelation, relation));
			}
		}
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetRelation() {
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRelation(Relation newRelation, NotificationChain msgs) {
		Relation oldRelation = relation;
		relation = newRelation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtRelationPackage.RELATION_IMPLEMENTATION__RELATION, oldRelation, newRelation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelation(Relation newRelation) {
		if (newRelation != relation) {
			NotificationChain msgs = null;
			if (relation != null)
				msgs = ((InternalEObject)relation).eInverseRemove(this, QvtRelationPackage.RELATION__OPERATIONAL_IMPL, Relation.class, msgs);
			if (newRelation != null)
				msgs = ((InternalEObject)newRelation).eInverseAdd(this, QvtRelationPackage.RELATION__OPERATIONAL_IMPL, Relation.class, msgs);
			msgs = basicSetRelation(newRelation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtRelationPackage.RELATION_IMPLEMENTATION__RELATION, newRelation, newRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getImpl() {
		if (impl != null && impl.eIsProxy()) {
			InternalEObject oldImpl = (InternalEObject)impl;
			impl = (Operation)eResolveProxy(oldImpl);
			if (impl != oldImpl) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QvtRelationPackage.RELATION_IMPLEMENTATION__IMPL, oldImpl, impl));
			}
		}
		return impl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetImpl() {
		return impl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImpl(Operation newImpl) {
		Operation oldImpl = impl;
		impl = newImpl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtRelationPackage.RELATION_IMPLEMENTATION__IMPL, oldImpl, impl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel getInDirectionOf() {
		if (inDirectionOf != null && inDirectionOf.eIsProxy()) {
			InternalEObject oldInDirectionOf = (InternalEObject)inDirectionOf;
			inDirectionOf = (TypedModel)eResolveProxy(oldInDirectionOf);
			if (inDirectionOf != oldInDirectionOf) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QvtRelationPackage.RELATION_IMPLEMENTATION__IN_DIRECTION_OF, oldInDirectionOf, inDirectionOf));
			}
		}
		return inDirectionOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel basicGetInDirectionOf() {
		return inDirectionOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInDirectionOf(TypedModel newInDirectionOf) {
		TypedModel oldInDirectionOf = inDirectionOf;
		inDirectionOf = newInDirectionOf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtRelationPackage.RELATION_IMPLEMENTATION__IN_DIRECTION_OF, oldInDirectionOf, inDirectionOf));
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
			case QvtRelationPackage.RELATION_IMPLEMENTATION__RELATION:
				if (relation != null)
					msgs = ((InternalEObject)relation).eInverseRemove(this, QvtRelationPackage.RELATION__OPERATIONAL_IMPL, Relation.class, msgs);
				return basicSetRelation((Relation)otherEnd, msgs);
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
			case QvtRelationPackage.RELATION_IMPLEMENTATION__RELATION:
				return basicSetRelation(null, msgs);
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
			case QvtRelationPackage.RELATION_IMPLEMENTATION__RELATION:
				if (resolve) return getRelation();
				return basicGetRelation();
			case QvtRelationPackage.RELATION_IMPLEMENTATION__IMPL:
				if (resolve) return getImpl();
				return basicGetImpl();
			case QvtRelationPackage.RELATION_IMPLEMENTATION__IN_DIRECTION_OF:
				if (resolve) return getInDirectionOf();
				return basicGetInDirectionOf();
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
			case QvtRelationPackage.RELATION_IMPLEMENTATION__RELATION:
				setRelation((Relation)newValue);
				return;
			case QvtRelationPackage.RELATION_IMPLEMENTATION__IMPL:
				setImpl((Operation)newValue);
				return;
			case QvtRelationPackage.RELATION_IMPLEMENTATION__IN_DIRECTION_OF:
				setInDirectionOf((TypedModel)newValue);
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
			case QvtRelationPackage.RELATION_IMPLEMENTATION__RELATION:
				setRelation((Relation)null);
				return;
			case QvtRelationPackage.RELATION_IMPLEMENTATION__IMPL:
				setImpl((Operation)null);
				return;
			case QvtRelationPackage.RELATION_IMPLEMENTATION__IN_DIRECTION_OF:
				setInDirectionOf((TypedModel)null);
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
			case QvtRelationPackage.RELATION_IMPLEMENTATION__RELATION:
				return relation != null;
			case QvtRelationPackage.RELATION_IMPLEMENTATION__IMPL:
				return impl != null;
			case QvtRelationPackage.RELATION_IMPLEMENTATION__IN_DIRECTION_OF:
				return inDirectionOf != null;
		}
		return super.eIsSet(featureID);
	}

} //RelationImplementationImpl
