package com.sap.runlet.operationaltransformation;

import java.util.ArrayList;
import java.util.List;

public class UnmergedOperationsQueue<O extends Operation<S>, S> {
    /**
     * As the {@link #unmergedOperationsForPeer} queues are cleaned up whenever merge
     * confirmations are received from peers, we need to remember which local operation
     * number the first element in the queue resulted from.
     */
    private int numberOfFirstInList;
    
    private List<O> unmergedOperations;
    
    public UnmergedOperationsQueue() {
	numberOfFirstInList = 0;
	unmergedOperations = new ArrayList<O>(5);
    }
    
    /**
     * After an operation has been locally applied and needs to be propagated
     * to the peer for which this is the queue of unmerged operations, the operation
     * must be appended to this queue.
     */
    public synchronized void sentOutOperation(O operationSentOut) {
	unmergedOperations.add(operationSentOut);
    }

    /**
     * Returns a copied list of unmerged and stepwise transformed local
     * operations starting at the requested local operation number.
     * 
     * @param numberOfConfirmedLocalOperations
     *            A value of 0 means that the remote peer has not confirmed the
     *            merge of any local operation yet.
     */
    public synchronized List<O> getUnmergedOperations(int numberOfConfirmedLocalOperations) {
	return new ArrayList<O>(unmergedOperations.subList(
		numberOfConfirmedLocalOperations-numberOfFirstInList,
		unmergedOperations.size()));
    }
    
    /**
     * Replaces the local operation with number <tt>localOperationNumber</tt> in the queue by
     * <tt>transformedOperation</tt>.
     * 
     * @param localOperationNumber starts with 0
     */
    public synchronized void updateWithTransformed(int localOperationNumber, O transformedOperation) {
	unmergedOperations.set(localOperationNumber-numberOfFirstInList, transformedOperation);
    }

    /**
     * Cleans up the queue so that only unconfirmed / unmerged operations
     * remain. Afterwards, {@link #getUnmergedOperations(int) asking for an
     * unmerged operation} with an argument for
     * <tt>numberOfConfirmedLocalOperations</tt> smaller than
     * <tt>numberOfMergedOperations</tt> passed to this call will result in an
     * exception.
     * 
     * @param numberOfMergedOperations
     *            tells how many operations that emerged from the local peer the
     *            remote peer has confirmed to have merged.
     */
    public synchronized void confirm(int numberOfMergedOperations) {
	for (int i=numberOfFirstInList; i<numberOfMergedOperations; i++) {
	    unmergedOperations.remove(0);
	}
	numberOfFirstInList = numberOfMergedOperations;
    }
    
    public synchronized String toString() {
	int i=numberOfFirstInList;
	StringBuilder result = new StringBuilder();
	result.append('[');
	boolean first = true;
	for (O op : unmergedOperations) {
	    if (!first) {
		result.append(", ");
	    } else {
		first = false;
	    }
	    result.append(i);
	    result.append(": ");
	    result.append(op);
	}
	result.append(']');
	return result.toString();
    }
}
