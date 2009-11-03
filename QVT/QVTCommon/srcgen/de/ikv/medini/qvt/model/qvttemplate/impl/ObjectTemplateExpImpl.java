/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvttemplate.impl;

import de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp;
import de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem;
import de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage;

import de.ikv.medini.qvt.qvt.QvtVisitor;

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
import org.oslo.ocl20.semantics.bridge.Classifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Template Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvttemplate.impl.ObjectTemplateExpImpl#getRefferedClass <em>Reffered Class</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvttemplate.impl.ObjectTemplateExpImpl#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectTemplateExpImpl extends TemplateExpImpl implements ObjectTemplateExp {
	/**
	 * The cached value of the '{@link #getRefferedClass() <em>Reffered Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefferedClass()
	 * @generated
	 * @ordered
	 */
	protected Classifier refferedClass;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectTemplateExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QvtTemplatePackage.Literals.OBJECT_TEMPLATE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getRefferedClass() {
		if (refferedClass != null && refferedClass.eIsProxy()) {
			InternalEObject oldRefferedClass = (InternalEObject)refferedClass;
			refferedClass = (Classifier)eResolveProxy(oldRefferedClass);
			if (refferedClass != oldRefferedClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QvtTemplatePackage.OBJECT_TEMPLATE_EXP__REFFERED_CLASS, oldRefferedClass, refferedClass));
			}
		}
		return refferedClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier basicGetRefferedClass() {
		return refferedClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefferedClass(Classifier newRefferedClass) {
		Classifier oldRefferedClass = refferedClass;
		refferedClass = newRefferedClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtTemplatePackage.OBJECT_TEMPLATE_EXP__REFFERED_CLASS, oldRefferedClass, refferedClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPart() {
		if (part == null) {
			part = new EObjectContainmentWithInverseEList(PropertyTemplateItem.class, this, QvtTemplatePackage.OBJECT_TEMPLATE_EXP__PART, QvtTemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER);
		}
		return part;
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
			case QvtTemplatePackage.OBJECT_TEMPLATE_EXP__PART:
				return ((InternalEList)getPart()).basicAdd(otherEnd, msgs);
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
			case QvtTemplatePackage.OBJECT_TEMPLATE_EXP__PART:
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
			case QvtTemplatePackage.OBJECT_TEMPLATE_EXP__REFFERED_CLASS:
				if (resolve) return getRefferedClass();
				return basicGetRefferedClass();
			case QvtTemplatePackage.OBJECT_TEMPLATE_EXP__PART:
				return getPart();
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
			case QvtTemplatePackage.OBJECT_TEMPLATE_EXP__REFFERED_CLASS:
				setRefferedClass((Classifier)newValue);
				return;
			case QvtTemplatePackage.OBJECT_TEMPLATE_EXP__PART:
				getPart().clear();
				getPart().addAll((Collection)newValue);
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
			case QvtTemplatePackage.OBJECT_TEMPLATE_EXP__REFFERED_CLASS:
				setRefferedClass((Classifier)null);
				return;
			case QvtTemplatePackage.OBJECT_TEMPLATE_EXP__PART:
				getPart().clear();
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
			case QvtTemplatePackage.OBJECT_TEMPLATE_EXP__REFFERED_CLASS:
				return refferedClass != null;
			case QvtTemplatePackage.OBJECT_TEMPLATE_EXP__PART:
				return part != null && !part.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ObjectTemplateExpImpl
