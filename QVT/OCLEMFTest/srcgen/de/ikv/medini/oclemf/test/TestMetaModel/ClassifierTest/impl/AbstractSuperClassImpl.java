/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl;

import de.ikv.medini.kernel.impl.MediniObjectImpl;

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
 * An implementation of the model object '<em><b>Abstract Super Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.AbstractSuperClassImpl#getSubClass <em>Sub Class</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.AbstractSuperClassImpl#getAbstractSuperName <em>Abstract Super Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractSuperClassImpl extends MediniObjectImpl implements AbstractSuperClass {
	/**
	 * The cached value of the '{@link #getSubClass() <em>Sub Class</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubClass()
	 * @generated
	 * @ordered
	 */
	protected EList subClass = null;

	/**
	 * The default value of the '{@link #getAbstractSuperName() <em>Abstract Super Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractSuperName()
	 * @generated
	 * @ordered
	 */
	protected static final String ABSTRACT_SUPER_NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getAbstractSuperName() <em>Abstract Super Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractSuperName()
	 * @generated
	 * @ordered
	 */
	protected String abstractSuperName = ABSTRACT_SUPER_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractSuperClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ClassifierTestPackage.Literals.ABSTRACT_SUPER_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSubClass() {
		if (subClass == null) {
			subClass = new EObjectWithInverseResolvingEList.ManyInverse(SubClass.class, this, ClassifierTestPackage.ABSTRACT_SUPER_CLASS__SUB_CLASS, ClassifierTestPackage.SUB_CLASS__ABSTRACT_SUPER_CLASS);
		}
		return subClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAbstractSuperName() {
		return abstractSuperName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstractSuperName(String newAbstractSuperName) {
		String oldAbstractSuperName = abstractSuperName;
		abstractSuperName = newAbstractSuperName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassifierTestPackage.ABSTRACT_SUPER_CLASS__ABSTRACT_SUPER_NAME, oldAbstractSuperName, abstractSuperName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassifierTestPackage.ABSTRACT_SUPER_CLASS__SUB_CLASS:
				return ((InternalEList)getSubClass()).basicAdd(otherEnd, msgs);
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
			case ClassifierTestPackage.ABSTRACT_SUPER_CLASS__SUB_CLASS:
				return ((InternalEList)getSubClass()).basicRemove(otherEnd, msgs);
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
			case ClassifierTestPackage.ABSTRACT_SUPER_CLASS__SUB_CLASS:
				return getSubClass();
			case ClassifierTestPackage.ABSTRACT_SUPER_CLASS__ABSTRACT_SUPER_NAME:
				return getAbstractSuperName();
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
			case ClassifierTestPackage.ABSTRACT_SUPER_CLASS__SUB_CLASS:
				getSubClass().clear();
				getSubClass().addAll((Collection)newValue);
				return;
			case ClassifierTestPackage.ABSTRACT_SUPER_CLASS__ABSTRACT_SUPER_NAME:
				setAbstractSuperName((String)newValue);
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
			case ClassifierTestPackage.ABSTRACT_SUPER_CLASS__SUB_CLASS:
				getSubClass().clear();
				return;
			case ClassifierTestPackage.ABSTRACT_SUPER_CLASS__ABSTRACT_SUPER_NAME:
				setAbstractSuperName(ABSTRACT_SUPER_NAME_EDEFAULT);
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
			case ClassifierTestPackage.ABSTRACT_SUPER_CLASS__SUB_CLASS:
				return subClass != null && !subClass.isEmpty();
			case ClassifierTestPackage.ABSTRACT_SUPER_CLASS__ABSTRACT_SUPER_NAME:
				return ABSTRACT_SUPER_NAME_EDEFAULT == null ? abstractSuperName != null : !ABSTRACT_SUPER_NAME_EDEFAULT.equals(abstractSuperName);
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
		result.append(" (AbstractSuperName: ");
		result.append(abstractSuperName);
		result.append(')');
		return result.toString();
	}

} //AbstractSuperClassImpl