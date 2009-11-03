package com.sap.tc.moin.repository;

/**
 * Identifies a repository client. Part of the identifying key properties is the
 * user associated with this client specification.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d043530
 */
public interface ClientSpec {

    /**
     * Gets the ClientId. of the ClientSpec. Different users might choose the
     * same IDs for ClientSpecs. This means that only the combination of UserId
     * and ClientId can uniquely identify a ClientSpec.
     * 
     * @return the ClientId of this client-spec
     */
    public String getClientId( );

    /**
     * Gets the DataArea.
     * 
     * @return the DataArea
     */
    public DataArea getDataArea( );
}