/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.oslo.ocl20.syntax.ast.Visitor;

import org.oslo.ocl20.syntax.ast.expressions.DotSelectionExpAS;
import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;

import org.oslo.ocl20.syntax.ast.impl.VisitableImpl;

import org.oslo.ocl20.syntax.ast.qvt.DomainAS;
import org.oslo.ocl20.syntax.ast.qvt.ExecutionKindAS;
import org.oslo.ocl20.syntax.ast.qvt.PropertyTemplateAS;
import org.oslo.ocl20.syntax.ast.qvt.QvtPackage;

import org.oslo.ocl20.syntax.ast.types.TypeAS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.DomainASImpl#getExecutionKind <em>Execution Kind</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.DomainASImpl#getModelId <em>Model Id</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.DomainASImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.DomainASImpl#getImplementedBy <em>Implemented By</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.DomainASImpl#getPropertyTemplates <em>Property Templates</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.DomainASImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.DomainASImpl#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainASImpl extends GeneralDomainASImpl implements DomainAS {
	/**
	 * The default value of the '{@link #getExecutionKind() <em>Execution Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionKind()
	 * @generated
	 * @ordered
	 */
	protected static final ExecutionKindAS EXECUTION_KIND_EDEFAULT = ExecutionKindAS.CHECK_ONLY_LITERAL;

	/**
	 * The cached value of the '{@link #getExecutionKind() <em>Execution Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionKind()
	 * @generated
	 * @ordered
	 */
	protected ExecutionKindAS executionKind = EXECUTION_KIND_EDEFAULT;

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
	 * The cached value of the '{@link #getImplementedBy() <em>Implemented By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementedBy()
	 * @generated
	 * @ordered
	 */
	protected DotSelectionExpAS implementedBy;

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
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TypeAS type;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected OclExpressionAS body;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return org.oslo.ocl20.syntax.ast.qvt.Package.Literals.DOMAIN_AS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionKindAS getExecutionKind() {
		return executionKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionKind(ExecutionKindAS newExecutionKind) {
		ExecutionKindAS oldExecutionKind = executionKind;
		executionKind = newExecutionKind == null ? EXECUTION_KIND_EDEFAULT : newExecutionKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__EXECUTION_KIND, oldExecutionKind, executionKind));
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
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__MODEL_ID, oldModelId, modelId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DotSelectionExpAS getImplementedBy() {
		if (implementedBy != null && implementedBy.eIsProxy()) {
			InternalEObject oldImplementedBy = (InternalEObject)implementedBy;
			implementedBy = (DotSelectionExpAS)eResolveProxy(oldImplementedBy);
			if (implementedBy != oldImplementedBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__IMPLEMENTED_BY, oldImplementedBy, implementedBy));
			}
		}
		return implementedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DotSelectionExpAS basicGetImplementedBy() {
		return implementedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementedBy(DotSelectionExpAS newImplementedBy) {
		DotSelectionExpAS oldImplementedBy = implementedBy;
		implementedBy = newImplementedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__IMPLEMENTED_BY, oldImplementedBy, implementedBy));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__TYPE, oldType, type));
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
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpressionAS getBody() {
		if (body != null && body.eIsProxy()) {
			InternalEObject oldBody = (InternalEObject)body;
			body = (OclExpressionAS)eResolveProxy(oldBody);
			if (body != oldBody) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__BODY, oldBody, body));
			}
		}
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpressionAS basicGetBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(OclExpressionAS newBody) {
		OclExpressionAS oldBody = body;
		body = newBody;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__BODY, oldBody, body));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPropertyTemplates() {
		if (propertyTemplates == null) {
			propertyTemplates = new EObjectResolvingEList(PropertyTemplateAS.class, this, org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__PROPERTY_TEMPLATES);
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__EXECUTION_KIND:
				return getExecutionKind();
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__MODEL_ID:
				return getModelId();
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__NAME:
				return getName();
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__IMPLEMENTED_BY:
				if (resolve) return getImplementedBy();
				return basicGetImplementedBy();
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__PROPERTY_TEMPLATES:
				return getPropertyTemplates();
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__BODY:
				if (resolve) return getBody();
				return basicGetBody();
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__EXECUTION_KIND:
				setExecutionKind((ExecutionKindAS)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__MODEL_ID:
				setModelId((String)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__NAME:
				setName((String)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__IMPLEMENTED_BY:
				setImplementedBy((DotSelectionExpAS)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__PROPERTY_TEMPLATES:
				getPropertyTemplates().clear();
				getPropertyTemplates().addAll((Collection)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__TYPE:
				setType((TypeAS)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__BODY:
				setBody((OclExpressionAS)newValue);
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__EXECUTION_KIND:
				setExecutionKind(EXECUTION_KIND_EDEFAULT);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__MODEL_ID:
				setModelId(MODEL_ID_EDEFAULT);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__IMPLEMENTED_BY:
				setImplementedBy((DotSelectionExpAS)null);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__PROPERTY_TEMPLATES:
				getPropertyTemplates().clear();
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__TYPE:
				setType((TypeAS)null);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__BODY:
				setBody((OclExpressionAS)null);
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__EXECUTION_KIND:
				return executionKind != EXECUTION_KIND_EDEFAULT;
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__MODEL_ID:
				return MODEL_ID_EDEFAULT == null ? modelId != null : !MODEL_ID_EDEFAULT.equals(modelId);
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__IMPLEMENTED_BY:
				return implementedBy != null;
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__PROPERTY_TEMPLATES:
				return propertyTemplates != null && !propertyTemplates.isEmpty();
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__TYPE:
				return type != null;
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS__BODY:
				return body != null;
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
		result.append(" (executionKind: ");
		result.append(executionKind);
		result.append(", modelId: ");
		result.append(modelId);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //DomainASImpl
