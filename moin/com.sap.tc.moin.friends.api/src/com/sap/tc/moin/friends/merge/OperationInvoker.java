package com.sap.tc.moin.friends.merge;

import java.util.Set;

/**
 * The operation invoker
 */
public interface OperationInvoker {

    /**
     * @param operation the operation to invoke
     * @param owner the owner (an IMoinMergableNode)
     * @return the result
     */
    public OperationResult invokeOperation( OperationTransferObject operation, Object owner );

    /**
     * @param operation the operation to revert
     * @param owner the owner (an IMoinMergableNode)
     * @return the result
     */
    public OperationResult revertOperation( OperationTransferObject operation, Object owner );

    /**
     * @return true if there are pending (dependent) operations that have not
     * been completed
     */
    public boolean hasPendingOperations( );

    /**
     * @return the MOFIds for which to refresh the tree
     */
    public Set<OperationResult> getOperationResults( );
}
