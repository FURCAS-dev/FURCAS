package com.sap.emf.ocl.trigger;

import java.util.Collection;

public abstract class AbstractTriggerable implements Triggerable {
    private final Collection<ExpressionWithContext> triggerExpressions;
    
    public AbstractTriggerable(Collection<ExpressionWithContext> triggerExpressions) {
        this.triggerExpressions = triggerExpressions;
    }

    public Collection<ExpressionWithContext> getTriggerExpressionsWithContext() {
        return triggerExpressions;
    }

}
