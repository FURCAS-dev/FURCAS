/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.filters;

import org.eclipse.emf.ecore.EStructuralFeature;

public class AssociationFilter extends StructuralFeatureFilter {
    public AssociationFilter(EStructuralFeature feature) {
        super(feature);
    }

    @Override
    public AssociationFilter clone(){
        return new AssociationFilter(getFeature());

    }

} // AssociationFilterImpl
