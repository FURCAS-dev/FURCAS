/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl;


/**
 * @author Tobias Hoppe
 *
 */
public class ModifiedImpactAnalyzerImpl extends ImpactAnalyzerImpl {

    /**
     * Modified version of the {@link ImpactAnalyzerImpl} to benchmark time consumption
     */
    public ModifiedImpactAnalyzerImpl() {
        super();      
    }

    public ModifiedImpactAnalyzerResultImpl IAResult = new ModifiedImpactAnalyzerResultImpl();
    
    @Override
    public EventFilter createFilterForExpression(OCLExpression expression, boolean notifyNewContextElements) {
        long before = System.nanoTime();
        EventFilter result = super.createFilterForExpression(expression, notifyNewContextElements);
        long after = System.nanoTime();
        IAResult.getExpToFilterTime().put(expression, (after - before));
        return result;    
    }

    @Override
    public Collection<EObject> getContextObjects(Notification event,
            OCLExpression expression, EClass context) {
        long before = System.nanoTime();
        Collection<EObject> result = super.getContextObjects(event, expression, context);
        long after = System.nanoTime();
        //TODO insert time consumption into csv output
        System.out.println("Time for calculating context objects: " + (after - before) + "ns");
        return result;  
    }

} //ModifiedImpactAnalyzerImpl
