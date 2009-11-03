package com.sap.tc.moin.repository.events.filter;

import com.sap.tc.moin.repository.CRI;


/**
 * A ContainerFilter allows filtering for events that occur within a specific
 * Container.
 * 
 * @author Martin Kolb
 */
public class ContainerFilter extends EventFilter {

    /**
     * @param modelContainerName The name of the model container
     */
    public ContainerFilter( CRI cri ) {

        super( cri.getContainerName( ) );
    }

    /**
     * @param modelContainerName The name of the model container
     */
    public ContainerFilter( String modelContainerName ) {

        super( modelContainerName );
    }

}