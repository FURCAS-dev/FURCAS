package com.sap.ide.refactoring.core.reference;

import com.sap.mi.textual.grammar.impl.DelayedReference;
import com.sap.mi.textual.parsing.textblocks.reference.ReferenceResolvingListener;


public class ReEvaluationLogger implements ReferenceResolvingListener{

    private final CompressingReEvaluationLog reevaluationLog;

    public ReEvaluationLogger(CompressingReEvaluationLog reevaluationLog) {
	this.reevaluationLog = reevaluationLog;
    }
    
    @Override
    public void outdatedReferencesRemoved(DelayedReference ref, Object valueRemovedFromProperty) {
	reevaluationLog.log(ref, valueRemovedFromProperty, ReEvaluationType.FROM_BOUND_TO_FREE);
    }

    @Override
    public void referenceResolved(DelayedReference ref, Object valueSetOnProperty) {
	reevaluationLog.log(ref, valueSetOnProperty, ReEvaluationType.FROM_FREE_TO_BOUND);
    }

}
