/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.contexts.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.oslo.ocl20.syntax.ast.Visitor;

import org.oslo.ocl20.syntax.ast.contexts.ConstraintAS;
import org.oslo.ocl20.syntax.ast.contexts.ConstraintKindAS;
import org.oslo.ocl20.syntax.ast.contexts.ContextsPackage;
import org.oslo.ocl20.syntax.ast.contexts.OperationAS;
import org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS;

import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;

import org.oslo.ocl20.syntax.ast.impl.VisitableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.contexts.impl.ConstraintASImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.contexts.impl.ConstraintASImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.contexts.impl.ConstraintASImpl#getDefOperation <em>Def Operation</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.contexts.impl.ConstraintASImpl#getBodyExpression <em>Body Expression</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.contexts.impl.ConstraintASImpl#getDefVariable <em>Def Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintASImpl extends VisitableImpl implements ConstraintAS {
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
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final ConstraintKindAS KIND_EDEFAULT = ConstraintKindAS.INIT_LITERAL;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected ConstraintKindAS kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefOperation() <em>Def Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefOperation()
	 * @generated
	 * @ordered
	 */
	protected OperationAS defOperation;

	/**
	 * The cached value of the '{@link #getBodyExpression() <em>Body Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpressionAS bodyExpression;

	/**
	 * The cached value of the '{@link #getDefVariable() <em>Def Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefVariable()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclarationAS defVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ContextsPackage.Literals.CONSTRAINT_AS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.CONSTRAINT_AS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintKindAS getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(ConstraintKindAS newKind) {
		ConstraintKindAS oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.CONSTRAINT_AS__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpressionAS getBodyExpression() {
		if (bodyExpression != null && bodyExpression.eIsProxy()) {
			InternalEObject oldBodyExpression = (InternalEObject)bodyExpression;
			bodyExpression = (OclExpressionAS)eResolveProxy(oldBodyExpression);
			if (bodyExpression != oldBodyExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContextsPackage.CONSTRAINT_AS__BODY_EXPRESSION, oldBodyExpression, bodyExpression));
			}
		}
		return bodyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpressionAS basicGetBodyExpression() {
		return bodyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyExpression(OclExpressionAS newBodyExpression) {
		OclExpressionAS oldBodyExpression = bodyExpression;
		bodyExpression = newBodyExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.CONSTRAINT_AS__BODY_EXPRESSION, oldBodyExpression, bodyExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationAS getDefOperation() {
		if (defOperation != null && defOperation.eIsProxy()) {
			InternalEObject oldDefOperation = (InternalEObject)defOperation;
			defOperation = (OperationAS)eResolveProxy(oldDefOperation);
			if (defOperation != oldDefOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContextsPackage.CONSTRAINT_AS__DEF_OPERATION, oldDefOperation, defOperation));
			}
		}
		return defOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationAS basicGetDefOperation() {
		return defOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefOperation(OperationAS newDefOperation) {
		OperationAS oldDefOperation = defOperation;
		defOperation = newDefOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.CONSTRAINT_AS__DEF_OPERATION, oldDefOperation, defOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclarationAS getDefVariable() {
		if (defVariable != null && defVariable.eIsProxy()) {
			InternalEObject oldDefVariable = (InternalEObject)defVariable;
			defVariable = (VariableDeclarationAS)eResolveProxy(oldDefVariable);
			if (defVariable != oldDefVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContextsPackage.CONSTRAINT_AS__DEF_VARIABLE, oldDefVariable, defVariable));
			}
		}
		return defVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclarationAS basicGetDefVariable() {
		return defVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefVariable(VariableDeclarationAS newDefVariable) {
		VariableDeclarationAS oldDefVariable = defVariable;
		defVariable = newDefVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.CONSTRAINT_AS__DEF_VARIABLE, oldDefVariable, defVariable));
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
			case ContextsPackage.CONSTRAINT_AS__NAME:
				return getName();
			case ContextsPackage.CONSTRAINT_AS__KIND:
				return getKind();
			case ContextsPackage.CONSTRAINT_AS__DEF_OPERATION:
				if (resolve) return getDefOperation();
				return basicGetDefOperation();
			case ContextsPackage.CONSTRAINT_AS__BODY_EXPRESSION:
				if (resolve) return getBodyExpression();
				return basicGetBodyExpression();
			case ContextsPackage.CONSTRAINT_AS__DEF_VARIABLE:
				if (resolve) return getDefVariable();
				return basicGetDefVariable();
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
			case ContextsPackage.CONSTRAINT_AS__NAME:
				setName((String)newValue);
				return;
			case ContextsPackage.CONSTRAINT_AS__KIND:
				setKind((ConstraintKindAS)newValue);
				return;
			case ContextsPackage.CONSTRAINT_AS__DEF_OPERATION:
				setDefOperation((OperationAS)newValue);
				return;
			case ContextsPackage.CONSTRAINT_AS__BODY_EXPRESSION:
				setBodyExpression((OclExpressionAS)newValue);
				return;
			case ContextsPackage.CONSTRAINT_AS__DEF_VARIABLE:
				setDefVariable((VariableDeclarationAS)newValue);
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
			case ContextsPackage.CONSTRAINT_AS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ContextsPackage.CONSTRAINT_AS__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case ContextsPackage.CONSTRAINT_AS__DEF_OPERATION:
				setDefOperation((OperationAS)null);
				return;
			case ContextsPackage.CONSTRAINT_AS__BODY_EXPRESSION:
				setBodyExpression((OclExpressionAS)null);
				return;
			case ContextsPackage.CONSTRAINT_AS__DEF_VARIABLE:
				setDefVariable((VariableDeclarationAS)null);
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
			case ContextsPackage.CONSTRAINT_AS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ContextsPackage.CONSTRAINT_AS__KIND:
				return kind != KIND_EDEFAULT;
			case ContextsPackage.CONSTRAINT_AS__DEF_OPERATION:
				return defOperation != null;
			case ContextsPackage.CONSTRAINT_AS__BODY_EXPRESSION:
				return bodyExpression != null;
			case ContextsPackage.CONSTRAINT_AS__DEF_VARIABLE:
				return defVariable != null;
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
		result.append(", kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //ConstraintASImpl
