/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl;

import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.AbstractSuperClass;
import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestPackage;
import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SubClass;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.SubClassImpl#getSubName <em>Sub Name</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.SubClassImpl#getAbstractSuperClass <em>Abstract Super Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubClassImpl extends SuperClassImpl implements SubClass {
	/**
	 * The default value of the '{@link #getSubName() <em>Sub Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubName()
	 * @generated
	 * @ordered
	 */
	protected static final String SUB_NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getSubName() <em>Sub Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubName()
	 * @generated
	 * @ordered
	 */
	protected String subName = SUB_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAbstractSuperClass() <em>Abstract Super Class</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractSuperClass()
	 * @generated
	 * @ordered
	 */
	protected EList abstractSuperClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ClassifierTestPackage.Literals.SUB_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubName() {
		return subName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubName(String newSubName) {
		String oldSubName = subName;
		subName = newSubName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassifierTestPackage.SUB_CLASS__SUB_NAME, oldSubName, subName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAbstractSuperClass() {
		if (abstractSuperClass == null) {
			abstractSuperClass = new EObjectWithInverseResolvingEList.ManyInverse(AbstractSuperClass.class, this, ClassifierTestPackage.SUB_CLASS__ABSTRACT_SUPER_CLASS, ClassifierTestPackage.ABSTRACT_SUPER_CLASS__SUB_CLASS);
		}
		return abstractSuperClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassifierTestPackage.SUB_CLASS__ABSTRACT_SUPER_CLASS:
				return ((InternalEList)getAbstractSuperClass()).basicAdd(otherEnd, msgs);
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
			case ClassifierTestPackage.SUB_CLASS__ABSTRACT_SUPER_CLASS:
				return ((InternalEList)getAbstractSuperClass()).basicRemove(otherEnd, msgs);
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
			case ClassifierTestPackage.SUB_CLASS__SUB_NAME:
				return getSubName();
			case ClassifierTestPackage.SUB_CLASS__ABSTRACT_SUPER_CLASS:
				return getAbstractSuperClass();
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
			case ClassifierTestPackage.SUB_CLASS__SUB_NAME:
				setSubName((String)newValue);
				return;
			case ClassifierTestPackage.SUB_CLASS__ABSTRACT_SUPER_CLASS:
				getAbstractSuperClass().clear();
				getAbstractSuperClass().addAll((Collection)newValue);
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
			case ClassifierTestPackage.SUB_CLASS__SUB_NAME:
				setSubName(SUB_NAME_EDEFAULT);
				return;
			case ClassifierTestPackage.SUB_CLASS__ABSTRACT_SUPER_CLASS:
				getAbstractSuperClass().clear();
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
			case ClassifierTestPackage.SUB_CLASS__SUB_NAME:
				return SUB_NAME_EDEFAULT == null ? subName != null : !SUB_NAME_EDEFAULT.equals(subName);
			case ClassifierTestPackage.SUB_CLASS__ABSTRACT_SUPER_CLASS:
				return abstractSuperClass != null && !abstractSuperClass.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (SubName: ");
		result.append(subName);
		result.append(')');
		return result.toString();
	}

} //SubClassImpl