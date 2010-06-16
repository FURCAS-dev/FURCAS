package de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl;

import java.util.HashMap;

import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.benchframework.impl.ResultObjectImpl;

/**
 * @author Tobias Hoppe
 *
 */
public class ModifiedImpactAnalyzerResultImpl extends ResultObjectImpl {

    /**
     * Mapping from OCL expression to time in nano seconds 
     * needed to create event filter for the given expression
     * 
     */
    private HashMap<OCLExpression, Long> expToFilterTime = new HashMap<OCLExpression, Long>();
    
    protected ModifiedImpactAnalyzerResultImpl(){
        super();
    }

    public HashMap<OCLExpression, Long> getExpToFilterTime() {
        return expToFilterTime;
    }
}
