/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtbase.impl;

import de.ikv.medini.qvt.model.qvtbase.QvtBasePackage;
import de.ikv.medini.qvt.model.qvtbase.TypedModel;

import de.ikv.medini.qvt.qvt.QvtVisitor;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.oslo.ocl20.semantics.OclVisitor;
import org.oslo.ocl20.semantics.bridge.Namespace;

import org.oslo.ocl20.semantics.bridge.impl.NamedElementImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Typed Model</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.TypedModelImpl#getDependsOn <em>Depends On</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.TypedModelImpl#getUsedPackage <em>Used Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypedModelImpl extends NamedElementImpl implements TypedModel {

	public int hashCode() {
		if (this.getName() == null) {
			return 0;
		}
		return this.getName().hashCode();
	}

	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof TypedModel) {
			TypedModel t = (TypedModel) obj;
			if (this.getName() != null && this.getName().equals(t.getName())) {
				// TODO: Include type when comparing
				/*
				 * if (this.getType().equals(t.getType())) return true; else return false;
				 */
				return true;
			}
		}
		return false;
	}

	/**
	 * The cached value of the '{@link #getDependsOn() <em>Depends On</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDependsOn()
	 * @generated
	 * @ordered
	 */
	protected EList dependsOn;

	/**
	 * The cached value of the '{@link #getUsedPackage() <em>Used Package</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUsedPackage()
	 * @generated
	 * @ordered
	 */
	protected EList usedPackage;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TypedModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QvtBasePackage.Literals.TYPED_MODEL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDependsOn() {
		if (dependsOn == null) {
			dependsOn = new EObjectResolvingEList(TypedModel.class, this, QvtBasePackage.TYPED_MODEL__DEPENDS_ON);
		}
		return dependsOn;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList getUsedPackage() {
		if (usedPackage == null) {
			usedPackage = new EObjectResolvingEList(Namespace.class, this, QvtBasePackage.TYPED_MODEL__USED_PACKAGE);
		}
		return usedPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object accept(OclVisitor visitor, Object data) {
		return ((QvtVisitor)visitor).visit(this,data);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QvtBasePackage.TYPED_MODEL__DEPENDS_ON:
				return getDependsOn();
			case QvtBasePackage.TYPED_MODEL__USED_PACKAGE:
				return getUsedPackage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QvtBasePackage.TYPED_MODEL__DEPENDS_ON:
				getDependsOn().clear();
				getDependsOn().addAll((Collection)newValue);
				return;
			case QvtBasePackage.TYPED_MODEL__USED_PACKAGE:
				getUsedPackage().clear();
				getUsedPackage().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case QvtBasePackage.TYPED_MODEL__DEPENDS_ON:
				getDependsOn().clear();
				return;
			case QvtBasePackage.TYPED_MODEL__USED_PACKAGE:
				getUsedPackage().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case QvtBasePackage.TYPED_MODEL__DEPENDS_ON:
				return dependsOn != null && !dependsOn.isEmpty();
			case QvtBasePackage.TYPED_MODEL__USED_PACKAGE:
				return usedPackage != null && !usedPackage.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // TypedModelImpl
