package com.sap.mi.tools.mmdeploy.internal.view;

import org.eclipse.core.runtime.jobs.ISchedulingRule;

/**
 * Rule to use for import and check operations
 * 
 * @author d031150
 */
public final class MmSchedulingRule implements ISchedulingRule {
    
	public static final ISchedulingRule INSTANCE = new MmSchedulingRule();

    public boolean contains(ISchedulingRule rule) {
        return rule == this;
    }

    public boolean isConflicting(ISchedulingRule rule) {
        return rule == this;
    }
    
    private MmSchedulingRule() {
    }
    
}