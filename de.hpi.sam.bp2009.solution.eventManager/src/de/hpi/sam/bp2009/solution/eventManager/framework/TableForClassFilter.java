package de.hpi.sam.bp2009.solution.eventManager.framework;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * The ClassFilterTable manages all Registrations containing {@link de.hpi.sam.bp2009.solution.eventManager.filters.sap.tc.moin.repository.events.filter.ClassFilter}.
 * 
 * @see de.hpi.sam.bp2009.solution.eventManager.framework.TableForEventFilter.tc.moin.repository.events.framework.EventFilterTable
 * @author Daniel Vocke (D044825)
 */
public class TableForClassFilter extends TableForEventFilter {

    public TableForClassFilter() {
    }

    /**
     * @return the <code>MRI</code> of the meta object of the affected element(s). If the passed event is not of type
     * <code>ModelChangeEvent</code>, <code>null</code> is returned.
     */
    public Object getAffectedObject(Notification event) {
        if (isEmpty() ||!(event.getNotifier() instanceof EObject))
            return null;
        return ((EObject)event.getNotifier()).eClass();

    }

    @Override
    public Object getIdentifier() {
        return de.hpi.sam.bp2009.solution.eventManager.filters.ClassFilter.class;
    }

    @Override
    protected String criterionToString(Object criterion) {
        return ((EClass) criterion).getName();
    }
}