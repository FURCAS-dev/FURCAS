package com.sap.tc.moin.repository.core.query.moinql.engine;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityQueryClientScope;


public class CoreQueryClientScope implements SpiFacilityQueryClientScope {

    private CoreConnection conn;

    private ClientSpec[] clientSpecs;

    private Set<PRI> partitionScope;

    private boolean partitionScopeInclusive;

    /**
     * This constructor creates a core query client scope which acts over the
     * entire scope of the connection
     */
    @SuppressWarnings( "unchecked" )
    public CoreQueryClientScope( CoreConnection conn ) {

        this( conn, Collections.EMPTY_SET, false );
    }

    /**
     * This constructor creates a core query client scope which acts over the
     * partition scope as indicated by the PRI set and the boolean (for an
     * exclusive or inclusive scope)
     */
    @SuppressWarnings( "unchecked" )
    public CoreQueryClientScope( CoreConnection conn, Set<PRI> partitionScope, boolean partitionScopeInclusive ) {

        // we keep the connection
        this.conn = conn;

        // we keep the client specs
        Collection<ClientSpec> clientSpecsCollection = conn.getSession( ).getCompoundClientSpec( ).getClientSpecs( );
        this.clientSpecs = clientSpecsCollection.toArray( new ClientSpec[clientSpecsCollection.size( )] );

        // the scope
        this.partitionScope = ( partitionScope == null ? Collections.EMPTY_SET : partitionScope );

        this.partitionScopeInclusive = partitionScopeInclusive;
    }

    public ClientSpec[] getQueryClientScope( ) {

        return this.clientSpecs;
    }

    public CoreConnection getConnection( ) {

        return this.conn;
    }

    public boolean isPartitionScopeInclusive( ) {

        return this.partitionScopeInclusive;
    }

    public Set<PRI> getPartitionsScope( ) {

        return this.partitionScope;
    }
}
