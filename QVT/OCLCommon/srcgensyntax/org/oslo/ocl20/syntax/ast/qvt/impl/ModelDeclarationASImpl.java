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
import org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS;
import org.oslo.ocl20.syntax.ast.qvt.QvtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Declaration AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.ModelDeclarationASImpl#getModelId <em>Model Id</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.ModelDeclarationASImpl#getMetaModelIds <em>Meta Model Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelDeclarationASImpl extends VisitableImpl implements ModelDeclarationAS {
	/**
	 * The default value of the '{@link #getModelId() <em>Model Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelId()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelId() <em>Model Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelId()
	 * @generated
	 * @ordered
	 */
	protected String modelId = MODEL_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetaModelIds() <em>Meta Model Ids</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModelIds()
	 * @generated
	 * @ordered
	 */
	protected static final List META_MODEL_IDS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetaModelIds() <em>Meta Model Ids</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModelIds()
	 * @generated
	 * @ordered
	 */
	protected List metaModelIds = META_MODEL_IDS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelDeclarationASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return org.oslo.ocl20.syntax.ast.qvt.Package.Literals.MODEL_DECLARATION_AS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModelId() {
		return modelId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelId(String newModelId) {
		String oldModelId = modelId;
		modelId = newModelId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.MODEL_DECLARATION_AS__MODEL_ID, oldModelId, modelId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getMetaModelIds() {
		return metaModelIds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaModelIds(List newMetaModelIds) {
		List oldMetaModelIds = metaModelIds;
		metaModelIds = newMetaModelIds;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.MODEL_DECLARATION_AS__META_MODEL_IDS, oldMetaModelIds, metaModelIds));
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.MODEL_DECLARATION_AS__MODEL_ID:
				return getModelId();
			case org.oslo.ocl20.syntax.ast.qvt.Package.MODEL_DECLARATION_AS__META_MODEL_IDS:
				return getMetaModelIds();
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.MODEL_DECLARATION_AS__MODEL_ID:
				setModelId((String)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.MODEL_DECLARATION_AS__META_MODEL_IDS:
				setMetaModelIds((List)newValue);
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.MODEL_DECLARATION_AS__MODEL_ID:
				setModelId(MODEL_ID_EDEFAULT);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.MODEL_DECLARATION_AS__META_MODEL_IDS:
				setMetaModelIds(META_MODEL_IDS_EDEFAULT);
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.MODEL_DECLARATION_AS__MODEL_ID:
				return MODEL_ID_EDEFAULT == null ? modelId != null : !MODEL_ID_EDEFAULT.equals(modelId);
			case org.oslo.ocl20.syntax.ast.qvt.Package.MODEL_DECLARATION_AS__META_MODEL_IDS:
				return META_MODEL_IDS_EDEFAULT == null ? metaModelIds != null : !META_MODEL_IDS_EDEFAULT.equals(metaModelIds);
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
		result.append(" (modelId: ");
		result.append(modelId);
		result.append(", metaModelIds: ");
		result.append(metaModelIds);
		result.append(')');
		return result.toString();
	}

} //ModelDeclarationASImpl
