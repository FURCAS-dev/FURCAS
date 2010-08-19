/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.filters;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;

public abstract class StructuralFeatureFilter extends EventFilter {

    private final EStructuralFeature feature;

    public StructuralFeatureFilter(EStructuralFeature feature2) {
        super();
        feature = feature2;
    }

    public EStructuralFeature getFeature() {
        return feature;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
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
            return false;
        }
        return event.getFeature().equals(this.getFeature());

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
