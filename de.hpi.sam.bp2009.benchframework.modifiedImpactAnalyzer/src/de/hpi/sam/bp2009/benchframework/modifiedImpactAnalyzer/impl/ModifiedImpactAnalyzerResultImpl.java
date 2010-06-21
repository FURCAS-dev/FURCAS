package de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl;

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.benchframework.impl.ResultObjectImpl;

/**
 * @author Tobias Hoppe
 *
 */
public class ModifiedImpactAnalyzerResultImpl extends ResultObjectImpl {

    /**
     * Mapping from OCL expression to time
     * in nanoseconds needed to create event filter for the given expression
     * 
     */
    private HashMap<String, Long> expToFilterTime = new HashMap<String, Long>();
    

    private HashMap<OCLExpression, HashMap<Notification, Long>> expToInsScopeTime = new HashMap<OCLExpression, HashMap<Notification,Long>>();
    
    /**
     * Map from OCLExpression to a time set including the time for executing
     *  the OCLExpression on the optimized context instance set calculated
     *   by Instance SCope Analysis and the time needed for evaluating an
     *    OCLExpression on all instances of the given context. 
     */
    private HashMap<OCLExpression, List<Long>> expToEvalTime = new HashMap<OCLExpression, List<Long>>();
    
    protected ModifiedImpactAnalyzerResultImpl(){
        super();
    }

    public HashMap<String, Long> getExpToFilterTime() {
        return expToFilterTime;
    }

    public HashMap<OCLExpression, List<Long>> getExpToEvalTime() {
        return expToEvalTime;
    }
    
    public long timeForCalculatingAllFilters(){
        long result = 0;
        for (Long time:expToFilterTime.values()){
            result += time.longValue();
        }       
        return result;
    }

    public HashMap<OCLExpression, HashMap<Notification, Long>> getExpToInsScopeTime() {
        return expToInsScopeTime;
    }
}
