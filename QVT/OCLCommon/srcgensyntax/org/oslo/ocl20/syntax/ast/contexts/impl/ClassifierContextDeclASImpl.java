/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.contexts.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.oslo.ocl20.syntax.ast.Visitor;

import org.oslo.ocl20.syntax.ast.contexts.ClassifierContextDeclAS;
import org.oslo.ocl20.syntax.ast.contexts.ContextsPackage;

import org.oslo.ocl20.syntax.ast.types.TypeAS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier Context Decl AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.contexts.impl.ClassifierContextDeclASImpl#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.contexts.impl.ClassifierContextDeclASImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassifierContextDeclASImpl extends ContextDeclarationASImpl implements ClassifierContextDeclAS {
	/**
	 * The cached value of the '{@link #getPathName() <em>Path Name</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathName()
	 * @generated
	 * @ordered
	 */
	protected EList pathName;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TypeAS type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassifierContextDeclASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ContextsPackage.Literals.CLASSIFIER_CONTEXT_DECL_AS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPathName() {
		if (pathName == null) {
			pathName = new EDataTypeUniqueEList(String.class, this, ContextsPackage.CLASSIFIER_CONTEXT_DECL_AS__PATH_NAME);
		}
		return pathName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeAS getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (TypeAS)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContextsPackage.CLASSIFIER_CONTEXT_DECL_AS__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeAS basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TypeAS newType) {
		TypeAS oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.CLASSIFIER_CONTEXT_DECL_AS__TYPE, oldType, type));
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
			case ContextsPackage.CLASSIFIER_CONTEXT_DECL_AS__PATH_NAME:
				return getPathName();
			case ContextsPackage.CLASSIFIER_CONTEXT_DECL_AS__TYPE:
				if (resolve) return getType();
				return basicGetType();
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
			case ContextsPackage.CLASSIFIER_CONTEXT_DECL_AS__PATH_NAME:
				getPathName().clear();
				getPathName().addAll((Collection)newValue);
				return;
			case ContextsPackage.CLASSIFIER_CONTEXT_DECL_AS__TYPE:
				setType((TypeAS)newValue);
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
			case ContextsPackage.CLASSIFIER_CONTEXT_DECL_AS__PATH_NAME:
				getPathName().clear();
				return;
			case ContextsPackage.CLASSIFIER_CONTEXT_DECL_AS__TYPE:
				setType((TypeAS)null);
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
			case ContextsPackage.CLASSIFIER_CONTEXT_DECL_AS__PATH_NAME:
				return pathName != null && !pathName.isEmpty();
			case ContextsPackage.CLASSIFIER_CONTEXT_DECL_AS__TYPE:
				return type != null;
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
		result.append(" (pathName: ");
		result.append(pathName);
		result.append(')');
		return result.toString();
	}

} //ClassifierContextDeclASImpl
