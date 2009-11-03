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

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.oslo.ocl20.syntax.ast.Visitor;

import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;

import org.oslo.ocl20.syntax.ast.impl.VisitableImpl;

import org.oslo.ocl20.syntax.ast.qvt.GeneralDomainAS;
import org.oslo.ocl20.syntax.ast.qvt.DomainAS;
import org.oslo.ocl20.syntax.ast.qvt.PrimitiveDomainAS;
import org.oslo.ocl20.syntax.ast.qvt.QvtPackage;
import org.oslo.ocl20.syntax.ast.qvt.RelationAS;
import org.oslo.ocl20.syntax.ast.qvt.VariableDeclarationAS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.RelationASImpl#getIsTopLevel <em>Is Top Level</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.RelationASImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.RelationASImpl#getOverrides <em>Overrides</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.RelationASImpl#getWhere <em>Where</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.RelationASImpl#getVariableDeclarations <em>Variable Declarations</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.RelationASImpl#getDomains <em>Domains</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.RelationASImpl#getWhen <em>When</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationASImpl extends VisitableImpl implements RelationAS {
	/**
	 * The default value of the '{@link #getIsTopLevel() <em>Is Top Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsTopLevel()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean IS_TOP_LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsTopLevel() <em>Is Top Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsTopLevel()
	 * @generated
	 * @ordered
	 */
	protected Boolean isTopLevel = IS_TOP_LEVEL_EDEFAULT;

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
	 * The default value of the '{@link #getOverrides() <em>Overrides</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverrides()
	 * @generated
	 * @ordered
	 */
	protected static final String OVERRIDES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOverrides() <em>Overrides</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverrides()
	 * @generated
	 * @ordered
	 */
	protected String overrides = OVERRIDES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWhere() <em>Where</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhere()
	 * @generated
	 * @ordered
	 */
	protected EList where;

	/**
	 * The cached value of the '{@link #getVariableDeclarations() <em>Variable Declarations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList variableDeclarations;

	/**
	 * The cached value of the '{@link #getDomains() <em>Domains</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomains()
	 * @generated
	 * @ordered
	 */
	protected EList domains;

	/**
	 * The cached value of the '{@link #getWhen() <em>When</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhen()
	 * @generated
	 * @ordered
	 */
	protected EList when;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return org.oslo.ocl20.syntax.ast.qvt.Package.Literals.RELATION_AS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getIsTopLevel() {
		return isTopLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsTopLevel(Boolean newIsTopLevel) {
		Boolean oldIsTopLevel = isTopLevel;
		isTopLevel = newIsTopLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__IS_TOP_LEVEL, oldIsTopLevel, isTopLevel));
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
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOverrides() {
		return overrides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverrides(String newOverrides) {
		String oldOverrides = overrides;
		overrides = newOverrides;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__OVERRIDES, oldOverrides, overrides));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDomains() {
		if (domains == null) {
			domains = new EObjectResolvingEList(GeneralDomainAS.class, this, org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__DOMAINS);
		}
		return domains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getVariableDeclarations() {
		if (variableDeclarations == null) {
			variableDeclarations = new EObjectResolvingEList(VariableDeclarationAS.class, this, org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__VARIABLE_DECLARATIONS);
		}
		return variableDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getWhere() {
		if (where == null) {
			where = new EObjectResolvingEList(OclExpressionAS.class, this, org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__WHERE);
		}
		return where;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getWhen() {
		if (when == null) {
			when = new EObjectResolvingEList(OclExpressionAS.class, this, org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__WHEN);
		}
		return when;
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__IS_TOP_LEVEL:
				return getIsTopLevel();
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__NAME:
				return getName();
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__OVERRIDES:
				return getOverrides();
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__WHERE:
				return getWhere();
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__VARIABLE_DECLARATIONS:
				return getVariableDeclarations();
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__DOMAINS:
				return getDomains();
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__WHEN:
				return getWhen();
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__IS_TOP_LEVEL:
				setIsTopLevel((Boolean)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__NAME:
				setName((String)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__OVERRIDES:
				setOverrides((String)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__WHERE:
				getWhere().clear();
				getWhere().addAll((Collection)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__VARIABLE_DECLARATIONS:
				getVariableDeclarations().clear();
				getVariableDeclarations().addAll((Collection)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__DOMAINS:
				getDomains().clear();
				getDomains().addAll((Collection)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__WHEN:
				getWhen().clear();
				getWhen().addAll((Collection)newValue);
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__IS_TOP_LEVEL:
				setIsTopLevel(IS_TOP_LEVEL_EDEFAULT);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__OVERRIDES:
				setOverrides(OVERRIDES_EDEFAULT);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__WHERE:
				getWhere().clear();
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__VARIABLE_DECLARATIONS:
				getVariableDeclarations().clear();
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__DOMAINS:
				getDomains().clear();
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__WHEN:
				getWhen().clear();
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__IS_TOP_LEVEL:
				return IS_TOP_LEVEL_EDEFAULT == null ? isTopLevel != null : !IS_TOP_LEVEL_EDEFAULT.equals(isTopLevel);
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__OVERRIDES:
				return OVERRIDES_EDEFAULT == null ? overrides != null : !OVERRIDES_EDEFAULT.equals(overrides);
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__WHERE:
				return where != null && !where.isEmpty();
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__VARIABLE_DECLARATIONS:
				return variableDeclarations != null && !variableDeclarations.isEmpty();
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__DOMAINS:
				return domains != null && !domains.isEmpty();
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS__WHEN:
				return when != null && !when.isEmpty();
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
		result.append(" (isTopLevel: ");
		result.append(isTopLevel);
		result.append(", name: ");
		result.append(name);
		result.append(", overrides: ");
		result.append(overrides);
		result.append(')');
		return result.toString();
	}

} //RelationASImpl
