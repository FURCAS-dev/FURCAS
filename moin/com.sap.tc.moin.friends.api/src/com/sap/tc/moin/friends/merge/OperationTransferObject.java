package com.sap.tc.moin.friends.merge;

/**
 * Wraps the {@link Operation} and it's {@link OperationParameters}
 */
public interface OperationTransferObject {

    /**
     * @return the (unique) id
     */
    String getId( );

    /**
     * @return the operation
     */
    Operation getOperation( );

    /**
     * @return the parameters
     */
    OperationParameters getParameters( );

}
