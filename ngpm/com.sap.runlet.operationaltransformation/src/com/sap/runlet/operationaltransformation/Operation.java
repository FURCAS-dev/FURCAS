package com.sap.runlet.operationaltransformation;

/**
 * A change operation can be applied to some start state of some
 * universe and transforms that universe into a target state.
 * 
 * @author Axel Uhl D043530
 * 
 * @param <S> the class that models the state, on instances of which operations perform changes
 */
public interface Operation<S> extends Cloneable {
    public Operation<S> clone();
    
    /**
     * Applies this operation to the state <tt>toState</tt>, producing a new target state
     * which is returned.
     * 
     * @param toState the state to which to apply this operation
     * @return the state produced by applying this operation to <tt>toState</tt>
     */
    S applyTo(S toState);
}
