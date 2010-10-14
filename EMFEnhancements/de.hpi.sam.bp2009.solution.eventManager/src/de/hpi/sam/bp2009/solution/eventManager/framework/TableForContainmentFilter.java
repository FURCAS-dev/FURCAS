package de.hpi.sam.bp2009.solution.eventManager.framework;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import de.hpi.sam.bp2009.solution.eventManager.filters.ContainmentFilter;


/**
 * The AttributeFilterTable manages all Registrations containing {@link de.hpi.sam.bp2009.solution.eventManager.filters.sap.tc.moin.repository.events.filter.AttributeFilter}.
 * 
 * @see de.hpi.sam.bp2009.solution.eventManager.framework.TableForEventFilter.tc.moin.repository.events.framework.EventFilterTable
 * @author Daniel Vocke (D044825)
 */
public class TableForContainmentFilter extends TableForEventFilter {

    public TableForContainmentFilter(int numberOfFilterTables) {
        super(numberOfFilterTables);
    }

    /**
     * @return the affected meta object of <code>AttributeValueEvents</code>. If the event is not of type
     * <code>AttributeValueEvent</code>, <code>null</code> is returned.
     */
    public Object getAffectedObject(Notification event) {
        if(event.getFeature()==null && (event.getNotifier() instanceof Resource))
            return true;
        if (isEmpty() || !(event.getFeature()!=null && event.getFeature() instanceof EReference))
            return null;
        //TODO check if source obj is the right one
        return ((EReference)event.getFeature()).isContainment();
    }

    @Override
    public Class<ContainmentFilter> getIdentifier() {
        return ContainmentFilter.class;
    }

    
}