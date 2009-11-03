package com.sap.tc.moin.friends.merge;

import java.util.Map;
import java.util.Set;

/**
 * Wraps the result of an {@link Operation} invocation/reversion
 * <p>
 * See also {@link OperationInvoker#invokeOperation(OperationTransferObject)},
 * {@link OperationInvoker#revertOperation(OperationTransferObject)}
 */
public interface OperationResult {

    /**
     * @return the result
     */
    public Object retrieveResult( );

    /**
     * @return the affected MofIDs
     */
    public Set<String> getAffectedMofIds( );

    /**
     * @return the operations executed during this operation
     */
    public Map<OperationResult, Object> getDependentExecutedOperations( );

    /**
     * @return the owner (an IMoinMergableNode)
     */
    public Object getOwner( );

    /**
     * @return the {@link OperationTransferObject}
     */
    public OperationTransferObject getOperationTransferObject( );

}
