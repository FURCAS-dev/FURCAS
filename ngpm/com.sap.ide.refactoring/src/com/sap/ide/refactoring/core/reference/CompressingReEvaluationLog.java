package com.sap.ide.refactoring.core.reference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.sap.mi.textual.grammar.impl.DelayedReference;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Log of all reference re-evaluations. Besides simple storing those, this class
 * compresses log entries by tracking the current binding state.
 * 
 * e.g. property set, property unset, property unset results is: FROM_BOUND_TO_FREE
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class CompressingReEvaluationLog {

    private static class InternalLogEntry {

	private final DelayedReference ref;
	private final RefObject modelElement;
	
	private Object originalValue = null;
	private Object currentValue = null;
	private ReEvaluationType type;
	
	public InternalLogEntry(DelayedReference ref, Object value, ReEvaluationType type) {
	    this.ref = ref;
	    this.type = type;
	    this.modelElement = (RefObject) ref.getModelElement();
	    
	    switch (type) {
	    case FROM_BOUND_TO_FREE:
		originalValue = value;
		currentValue = null;
		break;
	    case FROM_FREE_TO_BOUND:
		originalValue = null;
		currentValue = value;
		break;
	    default:
		throw new IllegalArgumentException(type + " is only meant for internal use");
	    }
	}
	
	@Override
	public String toString() {
	    return asReadOnlyReEvaluationInfo().toString();
	}
	
	public void merge(InternalLogEntry latestOtherEntry) {
	    if (!latestOtherEntry.equals(this)) {
		throw new IllegalArgumentException("Give does not match the current one");
	    }
	    this.currentValue = latestOtherEntry.currentValue;

	    if (originalValue != null && currentValue == null) {
		type = ReEvaluationType.FROM_BOUND_TO_FREE;
	    } else if (originalValue == null && currentValue != null) {
		type = ReEvaluationType.FROM_FREE_TO_BOUND;
	    } else if (currentValue.equals(originalValue)) {
		type = ReEvaluationType.REBOUND_TO_SAME;
	    } else {
		type = ReEvaluationType.REBOUND_TO_OTHER;
	    }
	}
		
	public ReEvaluationInfo asReadOnlyReEvaluationInfo() {
	    return new ReEvaluationInfo(ref, modelElement, originalValue, currentValue, type);
	}

    }
    
    /**
     * Key: ModelElement;
     * Value: Map of PropertyName to Re-Evaluation state;
     */
    private final HashMap<RefObject, HashMap<String, InternalLogEntry>> logEntries = new HashMap<RefObject, HashMap<String, InternalLogEntry>>();
    
    
    public void log(DelayedReference ref, Object value, ReEvaluationType type) {
	InternalLogEntry newEntry = new InternalLogEntry(ref, value, type);
	
	InternalLogEntry existingEntry = findMatchingExistingLogEntryFor(newEntry);
	if (existingEntry == null) {
	    storeInLog(newEntry);
	} else {
	    existingEntry.merge(newEntry);
	}
    }	

    private void storeInLog(InternalLogEntry newEntry) {
	if (!logEntries.containsKey(newEntry.ref.getModelElement())) {
	    logEntries.put(newEntry.modelElement, new HashMap<String, InternalLogEntry>());
	}
	logEntries.get(newEntry.modelElement).put(newEntry.ref.getPropertyName(), newEntry);
    }

    private InternalLogEntry findMatchingExistingLogEntryFor(InternalLogEntry newEntry) {
	if (!logEntries.containsKey(newEntry.modelElement)) {
	    return null;
	} else {
	    return logEntries.get(newEntry.modelElement).get(newEntry.ref.getPropertyName());
	}
    }
    
    public Collection<ReEvaluationInfo> getLoggedReEvaluations() {
	ArrayList<ReEvaluationInfo> reevaluations = new ArrayList<ReEvaluationInfo>();
	for (HashMap<String, InternalLogEntry> entries : logEntries.values()) {
	    for (InternalLogEntry entry : entries.values()) {
		reevaluations.add(entry.asReadOnlyReEvaluationInfo());
	    }
	}
	return reevaluations;
    }
}
