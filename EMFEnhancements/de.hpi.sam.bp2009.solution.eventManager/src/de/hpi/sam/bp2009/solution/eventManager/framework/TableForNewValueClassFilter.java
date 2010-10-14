package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.hpi.sam.bp2009.solution.eventManager.filters.NewValueClassFilter;
/**
 * The AssociationFilterTable manages all Registrations containing
 * {@link de.hpi.sam.bp2009.solution.eventManager.filters.sap.tc.moin.repository.events.filter.AssociationFilter}.
 * 
 * @see de.hpi.sam.bp2009.solution.eventManager.framework.TableForEventFilter.tc.moin.repository.events.framework.EventFilterTable
 * @author Daniel Vocke (D044825)
 */
public class TableForNewValueClassFilter extends TableForEventFilter {

    public TableForNewValueClassFilter(int numberOfFilterTables) {
        super(numberOfFilterTables);
    }

    /**
     * @return the affected meta object of <code>LinkChangedEvents</code>. If the event is not of type
     * <code>LinkChangeEvent</code>, <code>null</code> is returned.
     */
    public Object getAffectedObject(Notification event) {
        if(event.getNewValue() == null)
            return null;
        if(event.getNewValue() instanceof EObject){
            return ((EObject)event.getNewValue()).eClass();
        }else if(event.getNewValue() instanceof EList<?>){
            Set<EClass> result = new HashSet<EClass>();
            for(Object o: ((EList<?>)event.getNewValue())){
                if(o instanceof EObject){
                    result.add(((EObject)o).eClass());
                }
            }
            return result;
        }
        return null;
    }

    @Override
    public Class<NewValueClassFilter> getIdentifier() {
        return NewValueClassFilter.class;
    }
    
    @Override
    protected String criterionToString(Object criterion) {
        StringBuilder result = new StringBuilder();
        if (criterion instanceof EClass) {
            result.append(((EClass) criterion).getName());
        } else {
            Set<?> eClassSet = (Set<?>) criterion;
            boolean first = true;
            for (Object eClass : eClassSet) {
                if (!first) {
                    result.append(", ");
                } else {
                    result.append(((EClass) eClass).getName());
                }
            }
        }
        return result.toString();
    }
}