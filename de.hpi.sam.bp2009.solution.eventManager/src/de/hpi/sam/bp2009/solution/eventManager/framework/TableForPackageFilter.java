package de.hpi.sam.bp2009.solution.eventManager.framework;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;

import de.hpi.sam.bp2009.solution.eventManager.filters.PackageFilter;

/**
 * The PackageFilterTable manages all Registrations containing
 * {@link de.hpi.sam.bp2009.solution.eventManager.filters.sap.tc.moin.repository.events.filter.PackageFilter}.
 * 
 * @see de.hpi.sam.bp2009.solution.eventManager.framework.TableForEventFilter.tc.moin.repository.events.framework.EventFilterTable
 * @author Daniel Vocke (D044825)
 */
public class TableForPackageFilter extends TableForEventFilter {

    public TableForPackageFilter(int numberOfFilterTables) {
        super(numberOfFilterTables);
    }

    /**
     * @return the MRI(s) of the package proxy of the affected elements. If the passed event is not of type
     *         <code>ModelChangeEvent</code> or no registrations are stored in this instance, null is returned.
     */
    public Object getAffectedObject(Notification event) {
        if (event.getNotifier() instanceof EObject) {
            return ((EObject) event.getNotifier()).eClass().getEPackage();
        }
        return null;
    }

    @Override
    public Class<PackageFilter> getIdentifier() {
        return PackageFilter.class;
    }

}