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

import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;

import org.oslo.ocl20.syntax.ast.impl.VisitableImpl;

import org.oslo.ocl20.syntax.ast.qvt.ObjectTemplateAS;
import org.oslo.ocl20.syntax.ast.qvt.QvtPackage;
import org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Comprehension Expression AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.SetComprehensionExpressionASImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.SetComprehensionExpressionASImpl#getObjectTemplate <em>Object Template</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.SetComprehensionExpressionASImpl#getOclExpression <em>Ocl Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetComprehensionExpressionASImpl extends VisitableImpl implements SetComprehensionExpressionAS {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getOclExpression() <em>Ocl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpressionAS oclExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetComprehensionExpressionASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return org.oslo.ocl20.syntax.ast.qvt.Package.Literals.SET_COMPREHENSION_EXPRESSION_AS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.SET_COMPREHENSION_EXPRESSION_AS__NAME, oldName, name));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, org.oslo.ocl20.syntax.ast.qvt.Package.SET_COMPREHENSION_EXPRESSION_AS__OBJECT_TEMPLATE, oldObjectTemplate, objectTemplate));
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
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.SET_COMPREHENSION_EXPRESSION_AS__OBJECT_TEMPLATE, oldObjectTemplate, objectTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpressionAS getOclExpression() {
		if (oclExpression != null && oclExpression.eIsProxy()) {
			InternalEObject oldOclExpression = (InternalEObject)oclExpression;
			oclExpression = (OclExpressionAS)eResolveProxy(oldOclExpression);
			if (oclExpression != oldOclExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, org.oslo.ocl20.syntax.ast.qvt.Package.SET_COMPREHENSION_EXPRESSION_AS__OCL_EXPRESSION, oldOclExpression, oclExpression));
			}
		}
		return oclExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpressionAS basicGetOclExpression() {
		return oclExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOclExpression(OclExpressionAS newOclExpression) {
		OclExpressionAS oldOclExpression = oclExpression;
		oclExpression = newOclExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.SET_COMPREHENSION_EXPRESSION_AS__OCL_EXPRESSION, oldOclExpression, oclExpression));
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.SET_COMPREHENSION_EXPRESSION_AS__NAME:
				return getName();
			case org.oslo.ocl20.syntax.ast.qvt.Package.SET_COMPREHENSION_EXPRESSION_AS__OBJECT_TEMPLATE:
				if (resolve) return getObjectTemplate();
				return basicGetObjectTemplate();
			case org.oslo.ocl20.syntax.ast.qvt.Package.SET_COMPREHENSION_EXPRESSION_AS__OCL_EXPRESSION:
				if (resolve) return getOclExpression();
				return basicGetOclExpression();
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.SET_COMPREHENSION_EXPRESSION_AS__NAME:
				setName((String)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.SET_COMPREHENSION_EXPRESSION_AS__OBJECT_TEMPLATE:
				setObjectTemplate((ObjectTemplateAS)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.SET_COMPREHENSION_EXPRESSION_AS__OCL_EXPRESSION:
				setOclExpression((OclExpressionAS)newValue);
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.SET_COMPREHENSION_EXPRESSION_AS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.SET_COMPREHENSION_EXPRESSION_AS__OBJECT_TEMPLATE:
				setObjectTemplate((ObjectTemplateAS)null);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.SET_COMPREHENSION_EXPRESSION_AS__OCL_EXPRESSION:
				setOclExpression((OclExpressionAS)null);
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.SET_COMPREHENSION_EXPRESSION_AS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case org.oslo.ocl20.syntax.ast.qvt.Package.SET_COMPREHENSION_EXPRESSION_AS__OBJECT_TEMPLATE:
				return objectTemplate != null;
			case org.oslo.ocl20.syntax.ast.qvt.Package.SET_COMPREHENSION_EXPRESSION_AS__OCL_EXPRESSION:
				return oclExpression != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //SetComprehensionExpressionASImpl
