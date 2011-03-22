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
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Matches a {@link Notification#getFeature() feature}.
 * @author Philipp Berger
 *
 */
public class StructuralFeatureFilter extends EventFilter {

    private final EStructuralFeature feature;

    /**
     * The standard constructor
     * @param negated set {@link #isNegated()}
     * @param passes the {@link EStructuralFeature feature} to match
     */
    public StructuralFeatureFilter(EStructuralFeature feature, boolean negated) {
        super(negated);
        this.feature = feature;
    }

    /**
     * Gives the {@link EStructuralFeature feature} of the filter
     * @return {@link EStructuralFeature feature}
     */
    public EStructuralFeature getFeature() {
        return feature;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StructuralFeatureFilter other = (StructuralFeatureFilter) obj;
        if (feature == null) {
            if (other.feature != null)
                return false;
        } else if (!feature.equals(other.feature))
            return false;
        return isNegated() == ((EventFilter) other).isNegated();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((feature == null) ? 0 : feature.hashCode());
        if (isNegated()) {
            result = prime * result;
        }
        return result;
    }

    public boolean matchesFor(Notification event) {
        if (event.getFeature() == null) {
            return isNegated();
        }
        if( event.getFeature().equals(this.getFeature())){
        	return !isNegated();
        };
        return isNegated();


    }

    @Override
    public StructuralFeatureFilter clone(){
        return new StructuralFeatureFilter(getFeature(), isNegated());
    }
    
    @Override
    public String toString() {
        if (getFeature() != null)
            return "feature: " + getFeature().toString();
        return "empty FeatureFilter";
    }

    @Override
    public Object getFilterCriterion() {
        return getFeature();
    }
} // StructuralFeatureFilterImpl
