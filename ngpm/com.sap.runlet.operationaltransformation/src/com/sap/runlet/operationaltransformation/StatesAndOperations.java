package com.sap.runlet.operationaltransformation;

import java.util.LinkedList;
import java.util.List;

/**
 * Maintains a list of states and the operations that transformed the i-th into
 * the i+1st, starting with an initial state. Using {@link #apply(Operation)},
 * operation/state pairs can be appended to the end.
 * <p>
 * 
 * @author Axel Uhl D043530
 * 
 */
public class StatesAndOperations<O extends Operation<S>, S> {
    private List<S> states = new LinkedList<S>();
    private List<O> operations = new LinkedList<O>();

    public StatesAndOperations(S initialState) {
	states.add(initialState);
    }

    /**
     * Applies the <tt>operation</tt> to the {@link #getCurrentState() current
     * state} and records both, the new current state and the operation.
     * 
     * @return the new current state that results from applying
     *         <tt>operation</tt> to the state that was current when the
     *         operation was invoked.
     */
    public synchronized S apply(O operation) {
	S result = operation.applyTo(getCurrentState());
	states.add(result);
	operations.add(operation);
	return result;
    }
    
    public S getCurrentState() {
	return states.get(states.size() - 1);
    }

}
