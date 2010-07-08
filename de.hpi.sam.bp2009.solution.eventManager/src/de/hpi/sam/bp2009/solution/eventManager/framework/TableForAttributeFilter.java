package de.hpi.sam.bp2009.solution.eventManager.framework;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;

import de.hpi.sam.bp2009.solution.eventManager.filters.AttributeFilter;


/**
 * The AttributeFilterTable manages all Registrations containing {@link de.hpi.sam.bp2009.solution.eventManager.filters.sap.tc.moin.repository.events.filter.AttributeFilter}.
 * 
 * @see de.hpi.sam.bp2009.solution.eventManager.framework.TableForEventFilter.tc.moin.repository.events.framework.EventFilterTable
 * @author Daniel Vocke (D044825)
 */
public class TableForAttributeFilter extends TableForEventFilter {

    public TableForAttributeFilter() {
    }

    /**
     * @return the affected meta object of <code>AttributeValueEvents</code>. If the event is not of type
     * <code>AttributeValueEvent</code>, <code>null</code> is returned.
     */
    public Object getAffectedObject(Notification event) {
        if (isEmpty() || !(event.getFeature()!=null && event.getFeature() instanceof EAttribute))
            return null;
        //TODO check if source obj is the right one
        return event.getFeature();
    }

    @Override
    public Object getIdentifier() {
        return AttributeFilter.class;
    }

    @Override
    protected String criterionToString(Object criterion) {
        return ((EAttribute) criterion).getName();
    }
}