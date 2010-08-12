/**
 * 
 */
package com.sap.ide.refactoring.core.reference;

public enum ReEvaluationType {
    
    /** Property unset */
    FROM_BOUND_TO_FREE,
    
    /** Property set */
    FROM_FREE_TO_BOUND,
    
    /** Property unset and then set back to the old set value */
    REBOUND_TO_SAME,
    
    /** Property unset and then set back to a new, different value */
    REBOUND_TO_OTHER
}