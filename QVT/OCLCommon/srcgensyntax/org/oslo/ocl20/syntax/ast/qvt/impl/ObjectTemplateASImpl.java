/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.oslo.ocl20.syntax.ast.Visitor;

import org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage;
import org.oslo.ocl20.syntax.ast.expressions.IfExpAS;
import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;

import org.oslo.ocl20.syntax.ast.qvt.ObjectTemplateAS;
import org.oslo.ocl20.syntax.ast.qvt.PropertyTemplateAS;
import org.oslo.ocl20.syntax.ast.qvt.QvtPackage;

import org.oslo.ocl20.syntax.ast.types.TypeAS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Template AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.ObjectTemplateASImpl#getPropertyTemplates <em>Property Templates</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectTemplateASImpl extends TemplateASImpl implements ObjectTemplateAS {
	/**
	 * The cached value of the '{@link #getPropertyTemplates() <em>Property Templates</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyTemplates()
	 * @generated
	 * @ordered
	 */
	protected EList propertyTemplates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectTemplateASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return org.oslo.ocl20.syntax.ast.qvt.Package.Literals.OBJECT_TEMPLATE_AS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPropertyTemplates() {
		if (propertyTemplates == null) {
			propertyTemplates = new EObjectResolvingEList(PropertyTemplateAS.class, this, org.oslo.ocl20.syntax.ast.qvt.Package.OBJECT_TEMPLATE_AS__PROPERTY_TEMPLATES);
		}
		return propertyTemplates;
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.OBJECT_TEMPLATE_AS__PROPERTY_TEMPLATES:
				return getPropertyTemplates();
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.OBJECT_TEMPLATE_AS__PROPERTY_TEMPLATES:
				getPropertyTemplates().clear();
				getPropertyTemplates().addAll((Collection)newValue);
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.OBJECT_TEMPLATE_AS__PROPERTY_TEMPLATES:
				getPropertyTemplates().clear();
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.OBJECT_TEMPLATE_AS__PROPERTY_TEMPLATES:
				return propertyTemplates != null && !propertyTemplates.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ObjectTemplateASImpl
