/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.contexts.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.bridge.Operation;
import org.oslo.ocl20.semantics.bridge.Property;

import org.oslo.ocl20.semantics.impl.SemanticsVisitableImpl;

import org.oslo.ocl20.semantics.model.contexts.Constraint;
import org.oslo.ocl20.semantics.model.contexts.ConstraintKind;
import org.oslo.ocl20.semantics.model.contexts.ContextDeclaration;
import org.oslo.ocl20.semantics.model.contexts.ContextsPackage;

import org.oslo.ocl20.semantics.model.expressions.OclExpression;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Constraint</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.contexts.impl.ConstraintImpl#getName <em>Name</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.contexts.impl.ConstraintImpl#getKind <em>Kind</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.contexts.impl.ConstraintImpl#getDefProperty <em>Def
 * Property</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.contexts.impl.ConstraintImpl#getDefOperation <em>Def
 * Operation</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.contexts.impl.ConstraintImpl#getContext <em>Context
 * </em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.contexts.impl.ConstraintImpl#getBodyExpression <em>Body
 * Expression</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ConstraintImpl extends SemanticsVisitableImpl implements Constraint {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final ConstraintKind KIND_EDEFAULT = ConstraintKind.INIT_LITERAL;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected ConstraintKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefProperty() <em>Def Property</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDefProperty()
	 * @generated
	 * @ordered
	 */
	protected Property defProperty;

	/**
	 * The cached value of the '{@link #getDefOperation() <em>Def Operation</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDefOperation()
	 * @generated
	 * @ordered
	 */
	protected Operation defOperation;

	/**
	 * The cached value of the '{@link #getBodyExpression() <em>Body Expression</em>}' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBodyExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression bodyExpression;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ContextsPackage.Literals.CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.CONSTRAINT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConstraintKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setKind(ConstraintKind newKind) {
		ConstraintKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.CONSTRAINT__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Property getDefProperty() {
		if (defProperty != null && defProperty.eIsProxy()) {
			InternalEObject oldDefProperty = (InternalEObject) defProperty;
			defProperty = (Property) eResolveProxy(oldDefProperty);
			if (defProperty != oldDefProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContextsPackage.CONSTRAINT__DEF_PROPERTY,
					    oldDefProperty, defProperty));
			}
		}
		return defProperty;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Property basicGetDefProperty() {
		return defProperty;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDefProperty(Property newDefProperty) {
		Property oldDefProperty = defProperty;
		defProperty = newDefProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.CONSTRAINT__DEF_PROPERTY,
			    oldDefProperty, defProperty));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Operation getDefOperation() {
		if (defOperation != null && defOperation.eIsProxy()) {
			InternalEObject oldDefOperation = (InternalEObject) defOperation;
			defOperation = (Operation) eResolveProxy(oldDefOperation);
			if (defOperation != oldDefOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
					    ContextsPackage.CONSTRAINT__DEF_OPERATION, oldDefOperation, defOperation));
			}
		}
		return defOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Operation basicGetDefOperation() {
		return defOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDefOperation(Operation newDefOperation) {
		Operation oldDefOperation = defOperation;
		defOperation = newDefOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.CONSTRAINT__DEF_OPERATION,
			    oldDefOperation, defOperation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ContextDeclaration getContext() {
		if (eContainerFeatureID != ContextsPackage.CONSTRAINT__CONTEXT)
			return null;
		return (ContextDeclaration) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetContext(ContextDeclaration newContext, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newContext, ContextsPackage.CONSTRAINT__CONTEXT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setContext(ContextDeclaration newContext) {
		if (newContext != eInternalContainer()
		        || (eContainerFeatureID != ContextsPackage.CONSTRAINT__CONTEXT && newContext != null)) {
			if (EcoreUtil.isAncestor(this, newContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContext != null)
				msgs = ((InternalEObject) newContext).eInverseAdd(this,
				    ContextsPackage.CONTEXT_DECLARATION__CONSTRAINT, ContextDeclaration.class, msgs);
			msgs = basicSetContext(newContext, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.CONSTRAINT__CONTEXT, newContext,
			    newContext));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OclExpression getBodyExpression() {
		return bodyExpression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetBodyExpression(OclExpression newBodyExpression, NotificationChain msgs) {
		OclExpression oldBodyExpression = bodyExpression;
		bodyExpression = newBodyExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			    ContextsPackage.CONSTRAINT__BODY_EXPRESSION, oldBodyExpression, newBodyExpression);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBodyExpression(OclExpression newBodyExpression) {
		if (newBodyExpression != bodyExpression) {
			NotificationChain msgs = null;
			if (bodyExpression != null)
				msgs = ((InternalEObject) bodyExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				        - ContextsPackage.CONSTRAINT__BODY_EXPRESSION, null, msgs);
			if (newBodyExpression != null)
				msgs = ((InternalEObject) newBodyExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				        - ContextsPackage.CONSTRAINT__BODY_EXPRESSION, null, msgs);
			msgs = basicSetBodyExpression(newBodyExpression, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.CONSTRAINT__BODY_EXPRESSION,
			    newBodyExpression, newBodyExpression));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object accept(OclVisitor visitor, Object data) {
		return ((OclVisitor) visitor).visit(this, data);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ContextsPackage.CONSTRAINT__CONTEXT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContext((ContextDeclaration) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ContextsPackage.CONSTRAINT__CONTEXT:
				return basicSetContext(null, msgs);
			case ContextsPackage.CONSTRAINT__BODY_EXPRESSION:
				return basicSetBodyExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case ContextsPackage.CONSTRAINT__CONTEXT:
				return eInternalContainer().eInverseRemove(this, ContextsPackage.CONTEXT_DECLARATION__CONSTRAINT,
				    ContextDeclaration.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ContextsPackage.CONSTRAINT__NAME:
				return getName();
			case ContextsPackage.CONSTRAINT__KIND:
				return getKind();
			case ContextsPackage.CONSTRAINT__DEF_PROPERTY:
				if (resolve)
					return getDefProperty();
				return basicGetDefProperty();
			case ContextsPackage.CONSTRAINT__DEF_OPERATION:
				if (resolve)
					return getDefOperation();
				return basicGetDefOperation();
			case ContextsPackage.CONSTRAINT__CONTEXT:
				return getContext();
			case ContextsPackage.CONSTRAINT__BODY_EXPRESSION:
				return getBodyExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ContextsPackage.CONSTRAINT__NAME:
				setName((String) newValue);
				return;
			case ContextsPackage.CONSTRAINT__KIND:
				setKind((ConstraintKind) newValue);
				return;
			case ContextsPackage.CONSTRAINT__DEF_PROPERTY:
				setDefProperty((Property) newValue);
				return;
			case ContextsPackage.CONSTRAINT__DEF_OPERATION:
				setDefOperation((Operation) newValue);
				return;
			case ContextsPackage.CONSTRAINT__CONTEXT:
				setContext((ContextDeclaration) newValue);
				return;
			case ContextsPackage.CONSTRAINT__BODY_EXPRESSION:
				setBodyExpression((OclExpression) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ContextsPackage.CONSTRAINT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ContextsPackage.CONSTRAINT__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case ContextsPackage.CONSTRAINT__DEF_PROPERTY:
				setDefProperty((Property) null);
				return;
			case ContextsPackage.CONSTRAINT__DEF_OPERATION:
				setDefOperation((Operation) null);
				return;
			case ContextsPackage.CONSTRAINT__CONTEXT:
				setContext((ContextDeclaration) null);
				return;
			case ContextsPackage.CONSTRAINT__BODY_EXPRESSION:
				setBodyExpression((OclExpression) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ContextsPackage.CONSTRAINT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ContextsPackage.CONSTRAINT__KIND:
				return kind != KIND_EDEFAULT;
			case ContextsPackage.CONSTRAINT__DEF_PROPERTY:
				return defProperty != null;
			case ContextsPackage.CONSTRAINT__DEF_OPERATION:
				return defOperation != null;
			case ContextsPackage.CONSTRAINT__CONTEXT:
				return getContext() != null;
			case ContextsPackage.CONSTRAINT__BODY_EXPRESSION:
				return bodyExpression != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} // ConstraintImpl
