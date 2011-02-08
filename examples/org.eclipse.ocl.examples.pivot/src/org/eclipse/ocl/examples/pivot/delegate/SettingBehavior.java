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
 * $Id: SettingBehavior.java,v 1.2 2011/02/08 17:51:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;

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

	/**
	 * Return the feature body associated with structuralFeature, if necessary using ocl to
	 * create the relevant parsing environment for a textual definition..
	 */
	public ExpressionInOcl getSpecification(TypeManager typeManager, Property property) {
		ValueSpecification specification = null;
		for (Constraint constraint : property.getOwnedRules()) {
			String stereotype = constraint.getStereotype();
			if (UMLReflection.DERIVATION.equals(stereotype)) {
				specification = constraint.getSpecification();
				break;
			}
			if (UMLReflection.INITIAL.equals(stereotype)) {
				specification = constraint.getSpecification();				
			}
		}
		if (specification == null) {
			return null;
		}
		if (specification instanceof OpaqueExpression ){
			String expression = PivotUtil.getBody((OpaqueExpression)specification);
			if (expression == null) {
				return null;
			}
			specification = PivotUtil.resolveSpecification(typeManager, property, expression);
		}
		if (specification instanceof ExpressionInOcl) {
			return (ExpressionInOcl) specification;
		}
		return null;
	}
}