
package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;


/**
 * Implementation of the {@link ImpactAnalyzer}
 */

public class ImpactAnalyzerImpl implements ImpactAnalyzer {
    
    @Override
    public EventFilter createFilterForQuery(OCLExpression query, EClass cls, boolean notifyNewContextElements) {
        //ported MOIN implementation
        FilterSynthesisImpl filtersyn = new FilterSynthesisImpl(query, notifyNewContextElements);
        System.out.println("createFilterForQuery");
        return filtersyn.getSynthesisedFilter();
    }
    
    @Override
    public Collection<EObject> getContextObjects(Notification event,
            OCLExpression query, EClass cls) {
        //only very naive implementation
        Resource resource = ((EObject)event.getNotifier()).eResource();
        Collection<EObject> result = new BasicEList<EObject>();
        TreeIterator<EObject> contents = resource.getAllContents();
        while(contents.hasNext()){
            result.add(contents.next());
        }
        System.out.println("getContextObjects");
        return result;
    }

} //ImpactAnalyzerImpl
