package com.sap.tc.moin.query.repository;

import java.util.List;

import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.model.api.IDevelopmentConfiguration;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Moin;


/**
 * Maps MOIN concepts to Repository (DII) concepts. Clients of the MOIN
 * TeamServer need this functionality to translate MOIN-specific search results
 * to repository-specific resource identifiers, which are required to sync
 * corresponding resources to the local workspace.
 * 
 * @author D044522
 */
public interface RepositoryHelper {

    /**
     * @param cri MOIN Container Resource Identifier.
     * @return DII Development Component matching <tt>cri</tt>.
     */
    IDevelopmentComponent getDevelopmentComponentForContainer( CRI cri );

    /**
     * @param dc DII Development Component
     * @return MOIN Container Resource Identifier matching <tt>dc</tt>.
     */
    CRI getContainerForDevelopmentComponent( IDevelopmentComponent dc );

    /**
     * Gets a DevelopmentConfiguration matching the given remote DataArea.
     * 
     * @param dad DataArea returned by the MOIN TeamServer (as part of a
     * {@link MRI}).
     * @return DevelopmentConfiguration matching the given remote DataArea or
     * <tt>null</tt> if not found or not yet synced locally.
     */
    IDevelopmentConfiguration getDevelopmentConfigurationForDataArea( final DataAreaDescriptor dad );

    /**
     * @param devconf DII Development Configuration.
     * @return MOIN Data Area Descriptor matching <tt>devconf</tt>.
     */
    DataAreaDescriptor getDataAreaForDevelopmentConfiguration( final IDevelopmentConfiguration devconf );

    /**
     * Filters a list of local devConfs against devConfs available on the
     * server.
     * 
     * @param localDevConfs
     * @return intersection of local and remote devConfs.
     */
    List<IDevelopmentConfiguration> filterDevelopmentConfigurations( final List<IDevelopmentConfiguration> localDevConfs );

    /**
     * @param localMoin reference to client-local MOIN instance.
     * @return Helper for translating remote MOIN Resource Identifiers to local
     * ones and vice-versa.
     */
    LocalMoinTranslater getLocalMoinTranslater( final Moin localMoin );
}
