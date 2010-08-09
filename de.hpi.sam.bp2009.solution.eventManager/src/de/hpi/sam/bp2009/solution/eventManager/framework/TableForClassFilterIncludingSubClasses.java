package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.hpi.sam.bp2009.solution.eventManager.filters.ClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.ClassFilterIncludingSubclasses;

/**
 * The ClassFilterTable manages all Registrations containing {@link ClassFilter}.
 * 
 * @see TableForEventFilter
 * @author Daniel Vocke (D044825)
 */
public class TableForClassFilterIncludingSubClasses extends TableForEventFilter {

    public TableForClassFilterIncludingSubClasses(int numberOfFilterTables) {
        super(numberOfFilterTables);
    }

    /**
     * @return the <code>MRI</code> of the meta object of the affected element(s). If the passed event is not of type
     * <code>ModelChangeEvent</code>, <code>null</code> is returned.
     */
    public Object getAffectedObject(Notification event) {
        if (isEmpty() ||!(event.getNotifier() instanceof EObject))
            return null;
        Collection<EClass> classes = new HashSet<EClass>();
        EClass eClass = ((EObject)event.getNotifier()).eClass();
        classes.add(eClass);
        classes.addAll(eClass.getEAllSuperTypes());
        return classes;
        

    }

    @Override
    public Class<ClassFilterIncludingSubclasses> getIdentifier() {
        return ClassFilterIncludingSubclasses.class;
    }

    @Override
    protected String criterionToString(Object criterion) {
        return ((EClass) criterion).getName();
    }
}