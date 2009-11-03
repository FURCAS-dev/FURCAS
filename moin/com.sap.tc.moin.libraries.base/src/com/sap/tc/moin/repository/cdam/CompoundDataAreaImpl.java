package com.sap.tc.moin.repository.cdam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.shared.util.ListMap;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManager;

public class CompoundDataAreaImpl implements CompoundDataArea {



    private int hashCode = Integer.MIN_VALUE;

    private Map<DataAreaDescriptor, DataArea> dataAreas;

    private ListMap<String /* facility id */, List<DataArea>> dataAreasByFacilityId;

    private DataArea metaModelDataArea;

    private SpiCompoundDataAreaManager dataAreaManager;

    private String name;

    public CompoundDataAreaImpl( SpiCompoundDataAreaManager manager, String name, DataArea metaModelDataArea ) {

        this.dataAreas = new HashMap<DataAreaDescriptor, DataArea>( );
        this.dataAreaManager = manager;
        this.name = name;

        this.dataAreasByFacilityId = new ListMap<String, List<DataArea>>( );

        // initialize meta models
        this.metaModelDataArea = metaModelDataArea;
        this.dataAreas.put( this.metaModelDataArea.getDescriptor( ), this.metaModelDataArea );
        addDataAreaToDataAreaByFacilityId( this.metaModelDataArea );
    }

    public Collection<String> getCompoundClientNames( ) {

        // delegate to data area manager
        return this.dataAreaManager.getCompoundClientNames( this );
    }

    public CompoundClientSpec getCompoundClientSpec( String name ) {

        return this.dataAreaManager.getCompoundClientSpec( name );
    }

    public Collection<DataArea> getDataAreas( ) {

        return this.dataAreas.values( );
    }

    public List<DataArea> getDataAreas( String facilityName ) {

        List<DataArea> result = dataAreasByFacilityId.get( facilityName );
        if ( result != null ) {
            result = Collections.unmodifiableList( result );
        }
        return result;
    }

    public List<String> getFacilityNames( ) {

        return Collections.unmodifiableList( dataAreasByFacilityId.keyList( ) );
    }

    public Collection<DataAreaDescriptor> getDataAreaDescriptors( ) {

        return this.dataAreas.keySet( );
    }

    public void addDataArea( DataArea dataArea ) {

        this.resetHashCode( );
        this.dataAreas.put( dataArea.getDescriptor( ), dataArea );
        addDataAreaToDataAreaByFacilityId( dataArea );
    }

    public void removeDataArea( DataArea dataArea ) {

        this.resetHashCode( );
        this.dataAreas.remove( dataArea.getDescriptor( ) );
        removeDataAreaFromDataAreaByFacilityName( dataArea );
    }

    public DataArea getDataArea( DataAreaDescriptor descriptor ) {

        return this.dataAreas.get( descriptor );
    }

    public String getName( ) {

        return name;
    }

    public DataArea getMetaModelDataArea( ) {

        return this.metaModelDataArea;
    }

    // private methods

    private void addDataAreaToDataAreaByFacilityId( DataArea dataArea ) {

        String facilityName = dataArea.getFacility( ).getId( );
        List<DataArea> dataAreas = this.dataAreasByFacilityId.get( facilityName );
        if ( dataAreas == null ) {
            dataAreas = new ArrayList<DataArea>( );
            this.dataAreasByFacilityId.put( facilityName, dataAreas );
        }
        int indexDataArea = dataAreas.indexOf( dataArea );
        if ( indexDataArea == -1 ) {
            dataAreas.add( dataArea );
        } else {
            dataAreas.set( indexDataArea, dataArea );
        }
    }

    private void removeDataAreaFromDataAreaByFacilityName( DataArea dataArea ) {

        String facilityName = dataArea.getFacility( ).getId( );
        List<DataArea> dataAreas = this.dataAreasByFacilityId.get( facilityName );
        if ( dataAreas != null ) {
            dataAreas.remove( dataArea );
            if ( dataAreas.size( ) == 0 ) {
                this.dataAreasByFacilityId.remove( facilityName );
            }
        }
    }

    private void resetHashCode( ) {

        this.hashCode = Integer.MIN_VALUE;
    }

    @Override
    public int hashCode( ) {

        if ( this.hashCode == Integer.MIN_VALUE ) {
            this.hashCode = this.name.hashCode( );
            for ( DataArea singleDataArea : this.dataAreas.values( ) ) {
                this.hashCode ^= singleDataArea.hashCode( );
            }
        }
        return this.hashCode;
    }

    @Override
    public boolean equals( Object object ) {

        boolean result = false;
        if ( object instanceof CompoundDataArea ) {
            CompoundDataArea cda = (CompoundDataArea) object;
            result = this.name.equals( cda.getName( ) );
            result &= this.getDataAreas( ).containsAll( cda.getDataAreas( ) );
        }
        return result;
    }


    @Override
    public String toString( ) {

        return this.dataAreasByFacilityId.toString( );
    }
}
