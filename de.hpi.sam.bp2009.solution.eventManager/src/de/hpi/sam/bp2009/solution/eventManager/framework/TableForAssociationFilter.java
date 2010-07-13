package de.hpi.sam.bp2009.solution.eventManager.framework;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;

import de.hpi.sam.bp2009.solution.eventManager.filters.AssociationFilter;
/**
 * The AssociationFilterTable manages all Registrations containing
 * {@link de.hpi.sam.bp2009.solution.eventManager.filters.sap.tc.moin.repository.events.filter.AssociationFilter}.
 * 
 * @see de.hpi.sam.bp2009.solution.eventManager.framework.TableForEventFilter.tc.moin.repository.events.framework.EventFilterTable
 * @author Daniel Vocke (D044825)
 */
public class TableForAssociationFilter extends TableForEventFilter {

    public TableForAssociationFilter(int numberOfFilterTables) {
        super(numberOfFilterTables);
    }

    /**
     * @return the affected meta object of <code>LinkChangedEvents</code>. If the event is not of type
     * <code>LinkChangeEvent</code>, <code>null</code> is returned.
     */
    public Object getAffectedObject(Notification event) {

        if (isEmpty() || !(event.getFeature()!=null && event.getFeature() instanceof EReference))
            return null;
        return event.getFeature();
    }

    @Override
    public Class<AssociationFilter> getIdentifier() {
        return AssociationFilter.class;
    }
    
    @Override
    protected String criterionToString(Object criterion) {
        return ((EReference) criterion).getName();
    }

}