
package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import java.util.Collection;
import java.util.HashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.FilterSynthesis;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.InstanceScopeAnalysis;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.PathCache;


/**
 * Implementation of the {@link ImpactAnalyzer}
 */

public class ImpactAnalyzerImpl implements ImpactAnalyzer {
    
    private HashMap<OCLExpression, FilterSynthesis> expToFilterSyn = new HashMap<OCLExpression, FilterSynthesis>();
    private PathCache pathCache = new PathCache();
    
    /**
     * @return the expToFilterSyn
     */
    HashMap<OCLExpression, FilterSynthesis> getExpToFilterSyn() {
        return expToFilterSyn;
    }

    /**
     * @return the pathCache
     */
    PathCache getPathCache() {
        return pathCache;
    }

    /**
     * @param expToFilterSyn the expToFilterSyn to set
     */
    void setExpToFilterSyn(HashMap<OCLExpression, FilterSynthesis> expToFilterSyn) {
        this.expToFilterSyn = expToFilterSyn;
    }

    /**
     * @param pathCache the pathCache to set
     */
    void setPathCache(PathCache pathCache) {
        this.pathCache = pathCache;
    }

    @Override
    public EventFilter createFilterForQuery(OCLExpression expression, boolean notifyNewContextElements) {
        FilterSynthesis filtersyn = new FilterSynthesisImpl(expression, notifyNewContextElements);
        this.getExpToFilterSyn().put(expression, filtersyn);
        return filtersyn.getSynthesisedFilter();
    }
    
    @Override
    public Collection<EObject> getAllContextObjects(Notification event) {
        Resource resource = ((EObject)event.getNotifier()).eResource();
        Collection<EObject> result = new BasicEList<EObject>();
        TreeIterator<EObject> contents = resource.getAllContents();
        while(contents.hasNext()){
            result.add(contents.next());
        }
        return result;
    }

    @Override
    public Collection<EObject> getContextObjects(Notification event,
            OCLExpression expression, EClass context) {
        if(!(this.getExpToFilterSyn().containsKey(expression))){
            createFilterForQuery(expression, true);
        }
        InstanceScopeAnalysis instanceScopeAnalysis = new InstanceScopeAnalysis(expression, this.getPathCache(), this.getExpToFilterSyn().get(expression));        
        return instanceScopeAnalysis.getContextObjects(event, expression, context);
    }

    @Override
    public void reset() {
        this.getExpToFilterSyn().clear();
        this.setPathCache(new PathCache());       
    }

} //ImpactAnalyzerImpl
