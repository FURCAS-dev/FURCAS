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
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OCLSettingDelegate.java,v 1.2 2011/02/11 20:00:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.BasicSettingDelegate;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;
import org.eclipse.osgi.util.NLS;

/**
 * An implementation of a setting delegate that computes OCL derived features.
 * 
 * @since 3.0
 */
public class OCLSettingDelegate extends BasicSettingDelegate.Stateless
{
	protected final OCLDelegateDomain delegateDomain;
	private Property property;
	private ExpressionInOcl specification;

	/**
	 * Initializes me with my structural feature.
	 * 
	 * @param structuralFeature
	 *            the structural feature that I handle
	 */
	public OCLSettingDelegate(OCLDelegateDomain delegateDomain, EStructuralFeature structuralFeature) {
		super(structuralFeature);
		this.delegateDomain = delegateDomain;
	}

	@Override
	protected Object get(InternalEObject owner, boolean resolve, boolean coreType) {
		OCL ocl = delegateDomain.getOCL();
		TypeManager typeManager = ocl.getEnvironment().getTypeManager();
		ValueFactory valueFactory = typeManager.getValueFactory();
		if (specification == null) {
			if (property == null) {
				Resource ecoreMetaModel = eStructuralFeature.eResource();
				Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreMetaModel, typeManager);
				property = ecore2Pivot.getCreated(Property.class, eStructuralFeature);
			}
			specification = SettingBehavior.INSTANCE.getExpressionInOcl(typeManager, property);
		}
		OCL.Query query = ocl.createQuery(specification);
		Value result = query.evaluate(owner);
		if (result.isInvalid()) {
			String message = NLS.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, property);
			throw new OCLDelegateException(message);
		}
//		if ((result == null) /* || ocl.isInvalid(result) */) {
//			String message = NLS.bind(OCLMessages.EvaluationResultIsNull_ERROR_, getFeatureName());
//			throw new OCLDelegateException(message);
//		}
		return valueFactory.getEcoreValueOf(result);
	}

	@Override
	protected boolean isSet(InternalEObject owner) {
		return false; // derived features are, implicitly, never set
	}

	@Override
	public String toString() {
		if (property != null) {
			return "<" + delegateDomain.getURI() + ":setting> " + property; //$NON-NLS-1$ //$NON-NLS-2$
		}
		else {
			String name = eStructuralFeature.getEContainingClass().getEPackage().getName()
			+ "::" + eStructuralFeature.getEContainingClass().getName()
			+ "." + eStructuralFeature.getName();
			return "<" + delegateDomain.getURI() + ":setting> " + name; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
