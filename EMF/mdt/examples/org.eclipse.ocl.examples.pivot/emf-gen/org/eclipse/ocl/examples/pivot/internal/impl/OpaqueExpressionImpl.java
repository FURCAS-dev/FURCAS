/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OpaqueExpressionImpl.java,v 1.2 2011/01/24 20:42:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.internal.operations.OpaqueExpressionOperations;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Opaque Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.OpaqueExpressionImpl#getBodies <em>Body</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.OpaqueExpressionImpl#getLanguages <em>Language</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OpaqueExpressionImpl
		extends ValueSpecificationImpl
		implements OpaqueExpression {

	/**
	 * The cached value of the '{@link #getBodies() <em>Body</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodies()
	 * @generated
	 * @ordered
	 */
	protected EList<String> bodies;

	/**
	 * The cached value of the '{@link #getLanguages() <em>Language</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguages()
	 * @generated
	 * @ordered
	 */
	protected EList<String> languages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OpaqueExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.OPAQUE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getBodies() {
		if (bodies == null)
		{
			bodies = new EDataTypeEList<String>(String.class, this, PivotPackage.OPAQUE_EXPRESSION__BODY);
		}
		return bodies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getLanguages() {
		if (languages == null)
		{
			languages = new EDataTypeUniqueEList<String>(String.class, this, PivotPackage.OPAQUE_EXPRESSION__LANGUAGE);
		}
		return languages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLanguageBodySize(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return OpaqueExpressionOperations.validateLanguageBodySize(this, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case PivotPackage.OPAQUE_EXPRESSION__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.OPAQUE_EXPRESSION__MONIKER:
				return getMoniker();
			case PivotPackage.OPAQUE_EXPRESSION__NAME:
				return getName();
			case PivotPackage.OPAQUE_EXPRESSION__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.OPAQUE_EXPRESSION__IS_STATIC:
				return isStatic();
			case PivotPackage.OPAQUE_EXPRESSION__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.OPAQUE_EXPRESSION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.OPAQUE_EXPRESSION__OWNING_TEMPLATE_PARAMETER:
				if (resolve) return getOwningTemplateParameter();
				return basicGetOwningTemplateParameter();
			case PivotPackage.OPAQUE_EXPRESSION__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.OPAQUE_EXPRESSION__BODY:
				return getBodies();
			case PivotPackage.OPAQUE_EXPRESSION__LANGUAGE:
				return getLanguages();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case PivotPackage.OPAQUE_EXPRESSION__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__BODY:
				getBodies().clear();
				getBodies().addAll((Collection<? extends String>)newValue);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__LANGUAGE:
				getLanguages().clear();
				getLanguages().addAll((Collection<? extends String>)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case PivotPackage.OPAQUE_EXPRESSION__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.OPAQUE_EXPRESSION__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.OPAQUE_EXPRESSION__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.OPAQUE_EXPRESSION__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.OPAQUE_EXPRESSION__BODY:
				getBodies().clear();
				return;
			case PivotPackage.OPAQUE_EXPRESSION__LANGUAGE:
				getLanguages().clear();
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case PivotPackage.OPAQUE_EXPRESSION__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.OPAQUE_EXPRESSION__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.OPAQUE_EXPRESSION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.OPAQUE_EXPRESSION__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.OPAQUE_EXPRESSION__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.OPAQUE_EXPRESSION__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.OPAQUE_EXPRESSION__TYPE:
				return type != null;
			case PivotPackage.OPAQUE_EXPRESSION__OWNING_TEMPLATE_PARAMETER:
				return basicGetOwningTemplateParameter() != null;
			case PivotPackage.OPAQUE_EXPRESSION__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case PivotPackage.OPAQUE_EXPRESSION__BODY:
				return bodies != null && !bodies.isEmpty();
			case PivotPackage.OPAQUE_EXPRESSION__LANGUAGE:
				return languages != null && !languages.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID)
		{
			case PivotPackage.OPAQUE_EXPRESSION___HAS_MONIKER:
				return hasMoniker();
			case PivotPackage.OPAQUE_EXPRESSION___IS_TEMPLATE_PARAMETER:
				return isTemplateParameter();
			case PivotPackage.OPAQUE_EXPRESSION___IS_COMPUTABLE:
				return isComputable();
			case PivotPackage.OPAQUE_EXPRESSION___INTEGER_VALUE:
				return integerValue();
			case PivotPackage.OPAQUE_EXPRESSION___BOOLEAN_VALUE:
				return booleanValue();
			case PivotPackage.OPAQUE_EXPRESSION___STRING_VALUE:
				return stringValue();
			case PivotPackage.OPAQUE_EXPRESSION___UNLIMITED_VALUE:
				return unlimitedValue();
			case PivotPackage.OPAQUE_EXPRESSION___IS_NULL:
				return isNull();
			case PivotPackage.OPAQUE_EXPRESSION___VALIDATE_LANGUAGE_BODY_SIZE__DIAGNOSTICCHAIN_MAP:
				return validateLanguageBodySize((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitOpaqueExpression(this);
	}
} //OpaqueExpressionImpl
