/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.eventmanager.filters;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;

/**
 * Matches a {@link Notification#getFeature() feature}.
 * Essentially it delegates to the {@link StructuralFeatureFilter} methods, but is specific for 
 * an {@link EReference reference}
 * @author Philipp Berger
 *
 */
public class AssociationFilter extends StructuralFeatureFilter {
    public AssociationFilter(EReference feature) {
        super(feature);
    }

    @Override
    public AssociationFilter clone(){
        return new AssociationFilter(getFeature());
    }
    @Override
    public EReference getFeature() {
    	return (EReference)super.getFeature();
    }

} // AssociationFilterImpl
