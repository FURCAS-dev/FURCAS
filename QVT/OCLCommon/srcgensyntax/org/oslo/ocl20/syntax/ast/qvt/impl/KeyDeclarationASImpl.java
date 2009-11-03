/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.oslo.ocl20.syntax.ast.Visitor;
import org.oslo.ocl20.syntax.ast.impl.VisitableImpl;
import org.oslo.ocl20.syntax.ast.qvt.KeyDeclarationAS;
import org.oslo.ocl20.syntax.ast.qvt.QvtPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Key Declaration AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.KeyDeclarationASImpl#getClassId <em>Class Id</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.KeyDeclarationASImpl#getPropertyIds <em>Property Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KeyDeclarationASImpl extends VisitableImpl implements KeyDeclarationAS {
	/**
	 * The default value of the '{@link #getClassId() <em>Class Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassId()
	 * @generated
	 * @ordered
	 */
	protected static final List CLASS_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassId() <em>Class Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassId()
	 * @generated
	 * @ordered
	 */
	protected List classId = CLASS_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyIds() <em>Property Ids</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyIds()
	 * @generated
	 * @ordered
	 */
	protected static final List PROPERTY_IDS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPropertyIds() <em>Property Ids</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyIds()
	 * @generated
	 * @ordered
	 */
	protected List propertyIds = PROPERTY_IDS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KeyDeclarationASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return org.oslo.ocl20.syntax.ast.qvt.Package.Literals.KEY_DECLARATION_AS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getClassId() {
		return classId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassId(List newClassId) {
		List oldClassId = classId;
		classId = newClassId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.KEY_DECLARATION_AS__CLASS_ID, oldClassId, classId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getPropertyIds() {
		return propertyIds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyIds(List newPropertyIds) {
		List oldPropertyIds = propertyIds;
		propertyIds = newPropertyIds;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.KEY_DECLARATION_AS__PROPERTY_IDS, oldPropertyIds, propertyIds));
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.KEY_DECLARATION_AS__CLASS_ID:
				return getClassId();
			case org.oslo.ocl20.syntax.ast.qvt.Package.KEY_DECLARATION_AS__PROPERTY_IDS:
				return getPropertyIds();
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.KEY_DECLARATION_AS__CLASS_ID:
				setClassId((List)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.KEY_DECLARATION_AS__PROPERTY_IDS:
				setPropertyIds((List)newValue);
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.KEY_DECLARATION_AS__CLASS_ID:
				setClassId(CLASS_ID_EDEFAULT);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.KEY_DECLARATION_AS__PROPERTY_IDS:
				setPropertyIds(PROPERTY_IDS_EDEFAULT);
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.KEY_DECLARATION_AS__CLASS_ID:
				return CLASS_ID_EDEFAULT == null ? classId != null : !CLASS_ID_EDEFAULT.equals(classId);
			case org.oslo.ocl20.syntax.ast.qvt.Package.KEY_DECLARATION_AS__PROPERTY_IDS:
				return PROPERTY_IDS_EDEFAULT == null ? propertyIds != null : !PROPERTY_IDS_EDEFAULT.equals(propertyIds);
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
		result.append(" (classId: ");
		result.append(classId);
		result.append(", propertyIds: ");
		result.append(propertyIds);
		result.append(')');
		return result.toString();
	}

} //KeyDeclarationASImpl
