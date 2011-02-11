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
 * $Id: SettingBehavior.java,v 1.3 2011/02/11 20:00:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.osgi.util.NLS;

/**
 * @since 3.0
 */
public class SettingBehavior extends AbstractDelegatedBehavior<EStructuralFeature, SettingDelegate.Factory.Registry, SettingDelegate.Factory>
{
	public static final SettingBehavior INSTANCE = new SettingBehavior();
	public static final String DERIVATION_CONSTRAINT_KEY = "derivation"; //$NON-NLS-1$
	public static final String INITIAL_CONSTRAINT_KEY = "initial"; //$NON-NLS-1$
	public static final String NAME = "settingDelegates"; //$NON-NLS-1$

	public SettingDelegate.Factory getDefaultFactory() {
		return SettingDelegate.Factory.Registry.INSTANCE.getFactory(getName());
	}

	public SettingDelegate.Factory.Registry getDefaultRegistry() {
		return SettingDelegate.Factory.Registry.INSTANCE;
	}

	public EPackage getEPackage(EStructuralFeature eStructuralFeature) {
		return eStructuralFeature.getEContainingClass().getEPackage();
	}

	/**
	 * Return the feature body associated with structuralFeature, if necessary using ocl to
	 * create the relevant parsing environment for a textual definition..
	 * @throws OCLDelegateException 
	 */
	public ExpressionInOcl getExpressionInOcl(TypeManager typeManager, Property property) throws OCLDelegateException {
		Constraint constraint = getConstraintForStereotype(property, UMLReflection.DERIVATION);
		if (constraint == null) {
			constraint = getConstraintForStereotype(property, UMLReflection.INITIAL);
		}
		if (constraint != null) {
			ExpressionInOcl expressionInOcl = getExpressionInOcl(typeManager, property, constraint);
			if (expressionInOcl != null) {
				return expressionInOcl;
			}
		}
		String message = NLS.bind(OCLMessages.MissingDerivationForSettingDelegate_ERROR_, property);
		throw new OCLDelegateException(message);
	}

	@Override
	public SettingDelegate.Factory getFactory(DelegateDomain delegateDomain, EStructuralFeature eStructuralFeature) {
		SettingDelegate.Factory.Registry registry = DelegateResourceSetAdapter.getRegistry(
			eStructuralFeature, getRegistryClass(), getDefaultRegistry());
	    return registry.getFactory(delegateDomain.getURI());
	}	

	public Class<SettingDelegate.Factory> getFactoryClass() {
		return SettingDelegate.Factory.class;
	}
	
	public String getName() {
		return NAME;
	}

	public Class<SettingDelegate.Factory.Registry> getRegistryClass() {
		return SettingDelegate.Factory.Registry.class;
	}
}