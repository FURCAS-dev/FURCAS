
package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.impl.InstanceFilterImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;


/**
 * Implementation of the {@link ImpactAnalyzer} 
 * @author Philipp
 *
 */
public class ImpactAnalyzerImpl implements ImpactAnalyzer {
    private class TautologyFilter extends InstanceFilterImpl{
        @Override
        public boolean matchesFor(ModelChangeEvent event) {
            return true;
        }
    }

    @Override
    public EventFilter createFilterForQuery(OCLExpression query, EClass cls) {
        //only very naive implementation
        System.out.println("createFilterForQuery");
        return new TautologyFilter();

    }

    @Override
    public Collection<EObject> getContextObjects(ModelChangeEvent event,
            OCLExpression query, EClass cls) {
        //only very naive implementation
        Resource resource = event.getSourceObject().eResource();
        Collection<EObject> result = new BasicEList<EObject>();
        TreeIterator<EObject> contents = resource.getAllContents();
        while(contents.hasNext()){
            result.add(contents.next());
        }
        System.out.println("getContextObjects");
        return result;
    }

} //ImpactAnalyzerImpl
