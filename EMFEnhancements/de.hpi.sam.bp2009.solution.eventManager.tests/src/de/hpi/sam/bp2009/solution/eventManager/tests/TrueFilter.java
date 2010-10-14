package de.hpi.sam.bp2009.solution.eventManager.tests;

import org.eclipse.emf.common.notify.Notification;

import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;

final class TrueFilter extends EventFilter {
    @Override
    public boolean matchesFor(Notification event) {
        return true;

    }

    @Override
    public int hashCode() {

        return 2;

    }

    @Override
    public boolean equals(Object obj) {
        return false;

    }

    @Override
    public EventFilter clone() {
        return new TrueFilter();
        
    }

    @Override
    public Object getFilterCriterion() {
        return true;
        
    }
}