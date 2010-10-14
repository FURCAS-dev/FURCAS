package de.hpi.sam.bp2009.solution.eventManager.framework;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.hpi.sam.bp2009.solution.eventManager.filters.ClassFilter;

/**
 * The ClassFilterTable manages all Registrations containing {@link ClassFilter}.
 * 
 * @see TableForEventFilter
 * @author Daniel Vocke (D044825)
 */
public class TableForClassFilter extends TableForEventFilter {

    public TableForClassFilter(int numberOfFilterTables) {
        super(numberOfFilterTables);
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
    public Class<ClassFilter> getIdentifier() {
        return ClassFilter.class;
    }

    @Override
    protected String criterionToString(Object criterion) {
        return ((EClass) criterion).getName();
    }
}