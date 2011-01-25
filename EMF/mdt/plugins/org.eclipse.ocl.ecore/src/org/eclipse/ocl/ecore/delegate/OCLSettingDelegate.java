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
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OCLSettingDelegate.java,v 1.2 2010/04/08 06:27:21 ewillink Exp $
 */
package org.eclipse.ocl.ecore.delegate;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicSettingDelegate;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.osgi.util.NLS;

/**
 * An implementation of a setting delegate that computes OCL derived features.
 * 
 * @since 3.0
 */
public class OCLSettingDelegate extends BasicSettingDelegate.Stateless
{
	protected final OCLDelegateDomain delegateDomain;
	private OCLExpression derivation;
	private ValueConverter converter;

	/**
	 * Initializes me with my structural feature.
	 * 
	 * @param structuralFeature
	 *            the structural feature that I handle
	 * 
	 * @throws ParserException
	 *             if the structural feature's OCL derivation is invalid
	 */
	public OCLSettingDelegate(OCLDelegateDomain delegateDomain, EStructuralFeature structuralFeature) {
		super(structuralFeature);
		this.delegateDomain = delegateDomain;
		this.converter = structuralFeature.isMany()
			? ValueConverter.LIST
			: ValueConverter.VERBATIM;
	}

	@Override
	protected Object get(InternalEObject owner, boolean resolve, boolean coreType) {
		OCL ocl = delegateDomain.getOCL();
		if (derivation == null) {
			derivation = SettingBehavior.INSTANCE.getFeatureBody(ocl, eStructuralFeature);
		}
		if (derivation == null) {
			String message = NLS.bind(OCLMessages.MissingDerivationForSettingDelegate_ERROR_, getFeatureName());
			throw new OCLDelegateException(message);
		}
		OCL.Query query = ocl.createQuery(derivation);
		Object result = query.evaluate(owner);
		if (ocl.isInvalid(result)) {
			String message = NLS.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, getFeatureName());
			throw new OCLDelegateException(message);
		}
//		if ((result == null) /* || ocl.isInvalid(result) */) {
//			String message = NLS.bind(OCLMessages.EvaluationResultIsNull_ERROR_, getFeatureName());
//			throw new OCLDelegateException(message);
//		}
		return converter.convert(ocl, result);
	}
	
	public String getFeatureName() {
		return eStructuralFeature.getEContainingClass().getEPackage().getName() + "::" + eStructuralFeature.getEContainingClass().getName() + "." + eStructuralFeature.getName();  //$NON-NLS-1$//$NON-NLS-2$
	}

	@Override
	protected boolean isSet(InternalEObject owner) {
		return false; // derived features are, implicitly, never set
	}

	public String toString() {
		return "<" + delegateDomain.getURI() + ":setting> " + getFeatureName(); //$NON-NLS-1$ //$NON-NLS-2$
	}
}
