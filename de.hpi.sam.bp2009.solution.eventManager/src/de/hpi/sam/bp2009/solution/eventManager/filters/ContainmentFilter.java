/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.filters;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class ContainmentFilter extends EventFilter {

    private ContainmentFilter() {
        super();
    }

    static final public ContainmentFilter INSTANCE = new ContainmentFilter();

    @Override
    public boolean matchesFor(Notification event) {
        if (event.getFeature() instanceof EReference) {
            return ((EReference) event.getFeature()).isContainment();
        } else if (!(event.getNotifier() instanceof EObject)) {
            return true;
        }
        return false;

    }

    @Override
    public int hashCode() {
        return "ContainmentFilterImpl".hashCode() + 31*(isNegated() ? 43 : 0);

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return isNegated() == ((EventFilter) obj).isNegated();
    }

    @Override
    public ContainmentFilter clone() {
        return INSTANCE;

    }

    @Override
    public Object getFilterCriterion() {
        return true;
    }
} // ContainmentFilterImpl
