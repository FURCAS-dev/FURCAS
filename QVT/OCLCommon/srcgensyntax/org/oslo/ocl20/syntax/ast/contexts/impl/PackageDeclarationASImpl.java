/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.contexts.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.oslo.ocl20.syntax.ast.Visitor;

import org.oslo.ocl20.syntax.ast.contexts.ContextDeclarationAS;
import org.oslo.ocl20.syntax.ast.contexts.ContextsPackage;
import org.oslo.ocl20.syntax.ast.contexts.PackageDeclarationAS;

import org.oslo.ocl20.syntax.ast.impl.VisitableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Declaration AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.contexts.impl.PackageDeclarationASImpl#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.contexts.impl.PackageDeclarationASImpl#getContextDecls <em>Context Decls</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageDeclarationASImpl extends VisitableImpl implements PackageDeclarationAS {
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
	 * The cached value of the '{@link #getContextDecls() <em>Context Decls</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextDecls()
	 * @generated
	 * @ordered
	 */
	protected EList contextDecls;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageDeclarationASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ContextsPackage.Literals.PACKAGE_DECLARATION_AS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPathName() {
		if (pathName == null) {
			pathName = new EDataTypeUniqueEList(String.class, this, ContextsPackage.PACKAGE_DECLARATION_AS__PATH_NAME);
		}
		return pathName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getContextDecls() {
		if (contextDecls == null) {
			contextDecls = new EObjectResolvingEList(ContextDeclarationAS.class, this, ContextsPackage.PACKAGE_DECLARATION_AS__CONTEXT_DECLS);
		}
		return contextDecls;
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
			case ContextsPackage.PACKAGE_DECLARATION_AS__PATH_NAME:
				return getPathName();
			case ContextsPackage.PACKAGE_DECLARATION_AS__CONTEXT_DECLS:
				return getContextDecls();
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
			case ContextsPackage.PACKAGE_DECLARATION_AS__PATH_NAME:
				getPathName().clear();
				getPathName().addAll((Collection)newValue);
				return;
			case ContextsPackage.PACKAGE_DECLARATION_AS__CONTEXT_DECLS:
				getContextDecls().clear();
				getContextDecls().addAll((Collection)newValue);
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
			case ContextsPackage.PACKAGE_DECLARATION_AS__PATH_NAME:
				getPathName().clear();
				return;
			case ContextsPackage.PACKAGE_DECLARATION_AS__CONTEXT_DECLS:
				getContextDecls().clear();
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
			case ContextsPackage.PACKAGE_DECLARATION_AS__PATH_NAME:
				return pathName != null && !pathName.isEmpty();
			case ContextsPackage.PACKAGE_DECLARATION_AS__CONTEXT_DECLS:
				return contextDecls != null && !contextDecls.isEmpty();
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

} //PackageDeclarationASImpl
