
package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import java.util.Collection;
import java.util.HashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.InstanceScopeAnalysis;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.PathCache;


/**
 * Implementation of the {@link ImpactAnalyzer}
 */
public class ImpactAnalyzerImpl implements ImpactAnalyzer {
    
    private HashMap<OCLExpression, FilterSynthesisImpl> expToFilterSyn = new HashMap<OCLExpression, FilterSynthesisImpl>();
    private PathCache pathCache = new PathCache();
    
    /**
     * @return the expToFilterSyn
     */
    protected HashMap<OCLExpression, FilterSynthesisImpl> getExpToFilterSyn() {
        return expToFilterSyn;
    }

    /**
     * @return the pathCache
     */
    protected PathCache getPathCache() {
        return pathCache;
    }

    /**
     * @param expToFilterSyn the expToFilterSyn to set
     */
    protected void setExpToFilterSyn(HashMap<OCLExpression, FilterSynthesisImpl> expToFilterSyn) {
        this.expToFilterSyn = expToFilterSyn;
    }

    /**
     * @param pathCache the pathCache to set
     */
    protected void setPathCache(PathCache pathCache) {
        this.pathCache = pathCache;
    }

    @Override
    public EventFilter createFilterForExpression(OCLExpression expression, boolean notifyNewContextElements) {
    	FilterSynthesisImpl filtersyn = new FilterSynthesisImpl(expression, notifyNewContextElements);
        this.getExpToFilterSyn().put(expression, filtersyn);
        return filtersyn.getSynthesisedFilter();
    }
    
    @Override
    public Collection<EObject> getContextObjects(Notification event,
            OCLExpression expression, EClass context) {
        if(!(this.getExpToFilterSyn().containsKey(expression))){
            createFilterForExpression(expression, true);
        }
        InstanceScopeAnalysis instanceScopeAnalysis = new InstanceScopeAnalysis(expression, context, this.getPathCache(), this.getExpToFilterSyn().get(expression));        
        return instanceScopeAnalysis.getContextObjects(event);
    }

	/**
	 * resets all instance variables of the {@link ImpactAnalyzer}
	 * 
	 */
    public void reset() {
        this.getExpToFilterSyn().clear();
        this.setPathCache(new PathCache());       
    }

} //ImpactAnalyzerImpl
