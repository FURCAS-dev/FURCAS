/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.oslo.ocl20.syntax.ast.Visitor;

import org.oslo.ocl20.syntax.ast.impl.VisitableImpl;

import org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS;
import org.oslo.ocl20.syntax.ast.qvt.ObjectTemplateAS;
import org.oslo.ocl20.syntax.ast.qvt.QvtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Member Selection Expression AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.MemberSelectionExpressionASImpl#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.MemberSelectionExpressionASImpl#getSecondName <em>Second Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.MemberSelectionExpressionASImpl#getObjectTemplate <em>Object Template</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MemberSelectionExpressionASImpl extends VisitableImpl implements MemberSelectionExpressionAS {
	/**
	 * The default value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName()
	 * @generated
	 * @ordered
	 */
	protected static final String FIRST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName()
	 * @generated
	 * @ordered
	 */
	protected String firstName = FIRST_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecondName() <em>Second Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondName()
	 * @generated
	 * @ordered
	 */
	protected static final String SECOND_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSecondName() <em>Second Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondName()
	 * @generated
	 * @ordered
	 */
	protected String secondName = SECOND_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getObjectTemplate() <em>Object Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectTemplate()
	 * @generated
	 * @ordered
	 */
	protected ObjectTemplateAS objectTemplate;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemberSelectionExpressionASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return org.oslo.ocl20.syntax.ast.qvt.Package.Literals.MEMBER_SELECTION_EXPRESSION_AS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstName(String newFirstName) {
		String oldFirstName = firstName;
		firstName = newFirstName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.MEMBER_SELECTION_EXPRESSION_AS__FIRST_NAME, oldFirstName, firstName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSecondName() {
		return secondName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondName(String newSecondName) {
		String oldSecondName = secondName;
		secondName = newSecondName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.MEMBER_SELECTION_EXPRESSION_AS__SECOND_NAME, oldSecondName, secondName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTemplateAS getObjectTemplate() {
		if (objectTemplate != null && objectTemplate.eIsProxy()) {
			InternalEObject oldObjectTemplate = (InternalEObject)objectTemplate;
			objectTemplate = (ObjectTemplateAS)eResolveProxy(oldObjectTemplate);
			if (objectTemplate != oldObjectTemplate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, org.oslo.ocl20.syntax.ast.qvt.Package.MEMBER_SELECTION_EXPRESSION_AS__OBJECT_TEMPLATE, oldObjectTemplate, objectTemplate));
			}
		}
		return objectTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTemplateAS basicGetObjectTemplate() {
		return objectTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectTemplate(ObjectTemplateAS newObjectTemplate) {
		ObjectTemplateAS oldObjectTemplate = objectTemplate;
		objectTemplate = newObjectTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.MEMBER_SELECTION_EXPRESSION_AS__OBJECT_TEMPLATE, oldObjectTemplate, objectTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object accept(Visitor visitor, Object data) {
		return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case org.oslo.ocl20.syntax.ast.qvt.Package.MEMBER_SELECTION_EXPRESSION_AS__FIRST_NAME:
				return getFirstName();
			case org.oslo.ocl20.syntax.ast.qvt.Package.MEMBER_SELECTION_EXPRESSION_AS__SECOND_NAME:
				return getSecondName();
			case org.oslo.ocl20.syntax.ast.qvt.Package.MEMBER_SELECTION_EXPRESSION_AS__OBJECT_TEMPLATE:
				if (resolve) return getObjectTemplate();
				return basicGetObjectTemplate();
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.MEMBER_SELECTION_EXPRESSION_AS__FIRST_NAME:
				setFirstName((String)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.MEMBER_SELECTION_EXPRESSION_AS__SECOND_NAME:
				setSecondName((String)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.MEMBER_SELECTION_EXPRESSION_AS__OBJECT_TEMPLATE:
				setObjectTemplate((ObjectTemplateAS)newValue);
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.MEMBER_SELECTION_EXPRESSION_AS__FIRST_NAME:
				setFirstName(FIRST_NAME_EDEFAULT);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.MEMBER_SELECTION_EXPRESSION_AS__SECOND_NAME:
				setSecondName(SECOND_NAME_EDEFAULT);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.MEMBER_SELECTION_EXPRESSION_AS__OBJECT_TEMPLATE:
				setObjectTemplate((ObjectTemplateAS)null);
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.MEMBER_SELECTION_EXPRESSION_AS__FIRST_NAME:
				return FIRST_NAME_EDEFAULT == null ? firstName != null : !FIRST_NAME_EDEFAULT.equals(firstName);
			case org.oslo.ocl20.syntax.ast.qvt.Package.MEMBER_SELECTION_EXPRESSION_AS__SECOND_NAME:
				return SECOND_NAME_EDEFAULT == null ? secondName != null : !SECOND_NAME_EDEFAULT.equals(secondName);
			case org.oslo.ocl20.syntax.ast.qvt.Package.MEMBER_SELECTION_EXPRESSION_AS__OBJECT_TEMPLATE:
				return objectTemplate != null;
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
		result.append(" (firstName: ");
		result.append(firstName);
		result.append(", secondName: ");
		result.append(secondName);
		result.append(')');
		return result.toString();
	}

} //MemberSelectionExpressionASImpl
