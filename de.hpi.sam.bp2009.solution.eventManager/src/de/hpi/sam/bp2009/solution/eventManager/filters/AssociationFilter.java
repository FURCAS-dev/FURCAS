/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.filters;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class AssociationFilter extends StructuralFeatureFilter {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    public AssociationFilter() {
        super();
    }

    public AssociationFilter(EStructuralFeature feature) {
        super(feature);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated Not
     */
    public void setReference(EReference reference) {
        setFeature(reference);
    }

    @Override
    public AssociationFilter clone(){
        return new AssociationFilter(getFeature());

    }

} // AssociationFilterImpl
