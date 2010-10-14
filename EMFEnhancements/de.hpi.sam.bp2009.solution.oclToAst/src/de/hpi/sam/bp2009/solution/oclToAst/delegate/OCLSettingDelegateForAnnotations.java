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
package de.hpi.sam.bp2009.solution.oclToAst.delegate;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.ecore.delegate.OCLDelegateException;
import org.eclipse.osgi.util.NLS;
/**
 * An implementation of a setting delegate that computes OCL derived features.
 * 
 * @since 3.0
 */
public class OCLSettingDelegateForAnnotations extends org.eclipse.ocl.ecore.delegate.OCLSettingDelegate {
    protected final OCLDelegateDomain delegateDomain;
    private OCLExpression derivation;
    private ValueConverter converter;
    private EReference containment = null;

    public OCLSettingDelegateForAnnotations(OCLDelegateDomain delegateDomain, EStructuralFeature structuralFeature) {
        super(delegateDomain, structuralFeature);
        this.delegateDomain = delegateDomain;
        this.converter = structuralFeature.isMany() ? ValueConverter.LIST : ValueConverter.VERBATIM;
        if (eStructuralFeature instanceof EReference) {
            if (((EReference) eStructuralFeature).isContainment()) {
                this.containment = (EReference) eStructuralFeature;
            }
        }
    }

    @Override
    protected Object get(InternalEObject owner, boolean resolve, boolean coreType) {
        OCL ocl = delegateDomain.getOCL();
        if (derivation == null) {
            derivation = SettingBehaviorForAnnotations.INSTANCE.getFeatureBody(ocl, eStructuralFeature);
        }
        if (derivation == null) {
            Object res;
            try {
                res = super.get(owner, resolve, coreType);
            } catch (OCLDelegateException e) {
                res = owner.eGet(eStructuralFeature, resolve, coreType);
            }
            return res;
        }

        OCL.Query query = ocl.createQuery(derivation);
        Object result = query.evaluate(owner);
        if (ocl.isInvalid(result)) {
            String message = NLS.bind("OCL evaluation result of ''{0}'' is invalid", getFeatureName());
            throw new OCLDelegateException(message);
        }

        return converter.convert(ocl, result);
    }

    @Override
    protected void set(InternalEObject owner, Object newValue) {
        if (containment != null && newValue instanceof EObject) {
            EObject oldContainer = ((EObject) newValue).eContainer();
            owner.eSet(eStructuralFeature, newValue);
            if (owner.eNotificationRequired())
                owner.eNotify(new ENotificationImpl(owner, 666, containment,oldContainer , owner));
        } else {
            owner.eSet(eStructuralFeature, newValue);
        }

    }
    

}
