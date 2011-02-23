/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: ValidationBehavior.java,v 1.2 2011/02/11 20:00:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.osgi.util.NLS;

/**
 * @since 3.0
 */
public class ValidationBehavior extends AbstractDelegatedBehavior<EClassifier, EValidator.ValidationDelegate.Registry, ValidationDelegate.Factory>
{
	public static final ValidationBehavior INSTANCE = new ValidationBehavior();
	public static final String NAME = "validationDelegates"; //$NON-NLS-1$

	public ValidationDelegate.Factory getDefaultFactory() {
		return (ValidationDelegate.Factory) ValidationDelegate.Factory.Registry.INSTANCE.getValidationDelegate(getName());
	}

	public EValidator.ValidationDelegate.Registry getDefaultRegistry() {
		return ValidationDelegate.Factory.Registry.INSTANCE;
	}

	public EPackage getEPackage(EClassifier eClassifier) {
		return eClassifier.getEPackage();
	}
	
	public ExpressionInOcl getExpressionInOcl(TypeManager typeManager, EClassifier eClassifier, String constraintName) throws OCLDelegateException {
		Resource ecoreMetaModel = eClassifier.eResource();
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreMetaModel, typeManager);
		Type type = ecore2Pivot.getCreated(Type.class, eClassifier);
		Constraint constraint = PivotUtil.getNamedElement(type.getOwnedRules(), constraintName);
		if (constraint != null) {
			ExpressionInOcl expressionInOcl = getExpressionInOcl(typeManager, type, constraint);
			if (expressionInOcl != null) {
				return expressionInOcl;
			}
		}
		String message = NLS.bind(OCLMessages.MissingBodyForInvocationDelegate_ERROR_, type);
		throw new OCLDelegateException(message);
	}

	@Override
	public ValidationDelegate.Factory getFactory(DelegateDomain delegateDomain, EClassifier eClassifier) {
		EValidator.ValidationDelegate.Registry registry = DelegateResourceSetAdapter.getRegistry(
			eClassifier, ValidationDelegate.Registry.class, getDefaultRegistry());
	    return (ValidationDelegate.Factory) registry.getValidationDelegate(delegateDomain.getURI());
	}

	public Class<ValidationDelegate.Factory> getFactoryClass() {
		return ValidationDelegate.Factory.class;
	}

	public String getName() {
		return NAME;
	}

	public Class<ValidationDelegate.Factory.Registry> getRegistryClass() {
		return ValidationDelegate.Factory.Registry.class;
	}
}