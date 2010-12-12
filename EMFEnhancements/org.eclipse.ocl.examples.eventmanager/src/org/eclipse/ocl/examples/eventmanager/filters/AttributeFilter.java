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

import org.eclipse.emf.ecore.EStructuralFeature;

public class AttributeFilter extends StructuralFeatureFilter {
    public AttributeFilter(EStructuralFeature feature) {
        super(feature);
    }

    @Override
    public AttributeFilter clone(){
        return new AttributeFilter(getFeature());
    }

} // AttributeFilterImpl
