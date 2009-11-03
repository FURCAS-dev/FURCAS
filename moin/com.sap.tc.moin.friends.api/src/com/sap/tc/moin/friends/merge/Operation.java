package com.sap.tc.moin.friends.merge;



/**
 * Represents an Operation
 */
public interface Operation {

    /**
     * @return the (unique) ID
     */
    public String getID( );

    /**
     * @return the type
     */
    public OperationType getType( );

}
