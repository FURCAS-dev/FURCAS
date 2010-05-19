package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;



/**
 * The InstanceFilterTable manages registrations containing {@link com.sap.tc.moin.repository.events.filter.InstanceFilter} and
 * {@link com.sap.tc.moin.repository.events.filter.CompositionHierarchyFilter}
 * 
 * @see de.hpi.sam.bp2009.solution.eventManager.framework.TableForEventFilter.tc.moin.repository.events.framework.EventFilterTable
 * @author Daniel Vocke (D044825)
 */

public class TableInstanceFilter extends TableForEventFilter {

    /**
     * there will be 2 instances of this FilterTable. One instance will handle registrations for instances including compositions
     * and one instance will handle normal "InstanceFilters"
     */
    protected boolean includingCompositions = false;

    public TableInstanceFilter(boolean includingCompositions) {
        super();
        this.includingCompositions = includingCompositions;
    }

    /**
     * @return the {@link MRI} of the affected element if <code>includingCompositions</code> is <code>false</code> or the
     *         {@link MRI} of the affected element and of all its composite parents of <code>includingCompositions</code> is
     *         <code>true</code>.
     */
    public Object getAffectedObject(Notification event) {
        if (event.getNotifier() instanceof EObject) {
            if (includingCompositions)
                return getAffectedElementsIncludingCompositeParents((EObject)event.getNotifier());
            else
                return event.getNotifier();
        }
        return null;

    }

    private Object getAffectedElementsIncludingCompositeParents(EObject eObject) {
        Set<EObject> result = new HashSet<EObject>();
        for(EObject current = eObject; current!=null; current = current.eContainer()){
            result.add(current);
        }
        return result;
        
    }

    @Override
    public Object getIdentifier() {
        return null;
        // TODO check if instance filter is used
        // if (includingCompositions) {
        // return CompositionHierarchyFilter.class;
        // }
        // return InstanceFilter.class;
    }

}