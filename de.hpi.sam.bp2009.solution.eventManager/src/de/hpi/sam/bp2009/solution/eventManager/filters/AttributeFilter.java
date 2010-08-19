/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.filters;

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
