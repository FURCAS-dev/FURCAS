package com.sap.tc.moin.repository.cdam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundClientSpec;
import com.sap.tc.moin.repository.spi.core.SpiResourceInfo;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;

public class CompoundClientSpecImpl implements SpiCompoundClientSpec {

    protected Map<DataAreaDescriptor, ClientSpec> clientSpecs;

    private Map<Facility, List<ClientSpec>> clientSpecsPerFacility;

    private CompoundDataArea compoundDataArea;

    private final String clientId;

    private final int hashCode;

    private ClientSpec metaModelClientSpec;

    public CompoundClientSpecImpl( CompoundDataArea compDataArea, String clientId ) {

        this.clientSpecs = new HashMap<DataAreaDescriptor, ClientSpec>( );
        this.clientSpecsPerFacility = new HashMap<Facility, List<ClientSpec>>( );
        this.compoundDataArea = compDataArea;
        this.clientId = clientId;
        this.hashCode = clientId.hashCode( );

        DataArea metamodelDataArea = compDataArea.getMetaModelDataArea( );

        this.metaModelClientSpec = ( (SpiFacility) metamodelDataArea.getFacility( ) ).getMetamodelClientSpec( );

        this.clientSpecs.put( metamodelDataArea.getDescriptor( ), this.metaModelClientSpec );
        addToFacilitySpecificMap( metaModelClientSpec );
    }

    /**
     * Constructs a compound client-spec with the specified single client-spec.
     * 
     * @param compDataArea
     * @param clientSpec
     */
    public CompoundClientSpecImpl( CompoundDataArea compDataArea, ClientSpec clientSpec ) {

        this( compDataArea, clientSpec.getClientId( ) );
        this.addClientSpec( clientSpec );
    }

    private void addToFacilitySpecificMap( ClientSpec clientSpec ) {

        Facility facility = clientSpec.getDataArea( ).getFacility( );
        List<ClientSpec> clientSpecifications = clientSpecsPerFacility.get( facility );
        if ( clientSpecifications == null ) {
            clientSpecsPerFacility.put( facility, clientSpecifications = new ArrayList<ClientSpec>( ) );
        }
        clientSpecifications.add( clientSpec );
    }

    private void removeFromFacilitySpecificMap( ClientSpec clientSpec ) {

        Facility facility = clientSpec.getDataArea( ).getFacility( );
        Collection<ClientSpec> clientSpecifications = clientSpecsPerFacility.get( facility );
        if ( clientSpecifications != null ) {
            clientSpecifications.remove( clientSpec );
            if ( clientSpecifications.isEmpty( ) ) {
                clientSpecsPerFacility.remove( facility );
            }
        }
    }

    /**
     * Return all {@link ClientSpec}s including the ones for metamodel dataareas
     */
    public Collection<ClientSpec> getClientSpecs( ) {

        return Collections.unmodifiableCollection( clientSpecs.values( ) );
    }

    /**
     * Return all {@link ClientSpec}s for a given facility type
     */
    public Collection<ClientSpec> getClientSpecs( Facility facility ) {

        Collection<ClientSpec> result = getClientSpecsLive( facility );
        if ( !result.isEmpty( ) ) {
            return Collections.unmodifiableCollection( result );
        }
        return result;
    }

    public Collection<ClientSpec> getClientSpecsLive( Facility facility ) {

        List<ClientSpec> result = clientSpecsPerFacility.get( facility );
        if ( result != null ) {
            return result;
        }
        return Collections.emptyList( );
    }

    /**
     * Return the client spec for the passed data area
     * 
     * @return the client spec if found otherwise null
     */
    public ClientSpec getClientSpec( DataAreaDescriptor dataArea ) {

        ClientSpec result = this.clientSpecs.get( dataArea );
        return result;
    }

    public void addClientSpec( ClientSpec clientSpec ) {

        clientSpecs.put( clientSpec.getDataArea( ).getDescriptor( ), clientSpec );
        addToFacilitySpecificMap( clientSpec );
    }

    public void removeClientSpec( ClientSpec clientSpec ) {

        clientSpecs.remove( clientSpec.getDataArea( ).getDescriptor( ) );
        removeFromFacilitySpecificMap( clientSpec );
    }

    public SpiResourceInfo getResourceInfo( LRI lri ) {

        // get client spec for facility in data area descriptor
        SpiClientSpec clientSpec = (SpiClientSpec) getClientSpec( lri.getDataAreaDescriptor( ) );

        // get resource info from client spec

        return clientSpec.getResourceInfo( lri );

    }

    public SpiResourceInfo getResourceInfo( PRI pri ) {

        DataAreaDescriptor dataAreaDescriptor = pri.getDataAreaDescriptor( );
        // get client spec for facility in data area descriptor
        SpiClientSpec clientSpec = (SpiClientSpec) getClientSpec( dataAreaDescriptor );

        // if still not found throw exception
        if ( clientSpec == null ) {
            return null; //TODO throw an exception?
        }

        // get resource info from client spec

        return clientSpec.getResourceInfo( pri );

    }

    public CompoundDataArea getCompoundDataArea( ) {

        return this.compoundDataArea;
    }

    public String getId( ) {

        return this.clientId;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj instanceof CompoundClientSpec ) {
            return this.clientId.equals( ( (CompoundClientSpec) obj ).getId( ) );
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        return this.hashCode;
    }

    @Override
    public String toString( ) {

        return this.getId( );
    }
}
