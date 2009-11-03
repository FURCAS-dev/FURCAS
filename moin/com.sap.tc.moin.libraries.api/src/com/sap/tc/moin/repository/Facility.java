package com.sap.tc.moin.repository;

import java.util.Collection;

/**
 * A technical repository that serves as a physical store for model elements and
 * the links between them. A facility defines a scope for MOF IDs and can
 * resolve the IDs it handed out.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d043530
 * @version Created on 09.02.2005
 */
public interface Facility {

    /**
     * Gets the (logical) Facility ID.
     * <p>
     * Facilities are identified within a {@link Moin}through their IDs.
     * Associations can be cross-Facility and thus the facility ID must be
     * stable enough to be incorporated in such cross-Facility links. This is
     * why we call the ID a "logical" rather than a "technical" ID.
     * 
     * @return the ID
     */
    public String getId( );

    /**
     * Gets the names of the available {@link DataArea}s within this Facility.
     * <p>
     * Model data within a Facility are organized within DataAreas. Each
     * Facility comprises at least one DataArea. When obtaining a
     * {@link Connection}, a client must specify the DataArea; in other words, a
     * Connection can access only data within a given DataArea.
     * 
     * @return an {@link Collection}of {@link String}s
     */
    public Collection<String> getDataAreaNames( );

    /**
     * Gets the {@link DataArea}with the specified name.
     * <p>
     * 
     * @param name the name of the DataArea as obtained through
     * {@link #getDataAreaNames()}
     * @return the DataArea
     */
    public DataArea getDataAreaByName( String name );

    /**
     * Gets the {@link ResourceIdentifierFactory}for this facility.
     * 
     * @return the MRIFactory
     */
    public ResourceIdentifierFactory getRIFactory( );
}