package com.sap.tc.moin.repository;

import java.util.Collection;

/**
 * The DataArea is a subset of the data within a {@link Facility}.
 * <p>
 * DataAreas are disjoint and a {@link com.sap.tc.moin.repository.Connection}
 * can only operate on data within one DataArea.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d024227
 */
public interface DataArea {

    /**
     * Gets the Name of the DataArea.
     * <p>
     * DataAreas are identified through their name, which is unique within a
     * facility.
     * 
     * @return the name of the DataArea
     */
    public String getName( );

    /**
     * Gets the Facility hosting this DataArea.
     * 
     * @return the hosting Facility
     */
    public Facility getFacility( );

    /**
     * Gets the data area descriptor. The data area descriptor contains the
     * facility and the data area name.
     * 
     * @return the data area descriptor
     */
    public DataAreaDescriptor getDescriptor( );

    /**
     * Gets the available ClientIDs for the current user.
     * <p>
     * Clients need to obtain a {@link Connection} from the Moin in order to get
     * access to the Modeling data; a {@link ClientSpec} must be provided for
     * this.
     * <p>
     * A ClientSpec is identified by DataArea, ClientId, and User. This gets the
     * ClientIds for all available ClientSpecs for the given user.
     * 
     * @return a {@link Collection} of {@link String}s
     */
    public Collection<String> getClientIds( );

    /**
     * Gets the ClientSpec for the given clientspecId, if it exists.
     * 
     * @param clientId the ClientId (see {@link #getClientIds()})
     * @return the ClientSpec
     */
    public ClientSpec getClientSpec( String clientId );

}