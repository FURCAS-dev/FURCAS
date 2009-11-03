package com.sap.tc.moin.facility.primary.metamodelmanager;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionStreamProvider;
import com.sap.tc.moin.repository.spi.facility.fs.SpiFsMetaModelManager;

/**
 * @author D047015
 */
public abstract class MetaModelPartitionManagerImpl implements SpiFsMetaModelManager, SpiPartitionStreamProvider {

    /**
     * Mapping: metamodel PRI to responsible stream provider (information
     * provided by runtime host)
     */
    protected Map<PRI, SpiPartitionStreamProvider> metamodelPartitionToStreamProvider = null;

    public MetaModelPartitionManagerImpl( ) {

        this.metamodelPartitionToStreamProvider = new HashMap<PRI, SpiPartitionStreamProvider>( );
    }

    public InputStream getPartitionStream( PRI pri ) {

        if ( pri == null ) {
            throw new MoinNullPointerException( MetaModelManagerMessages.PARAMETERPRIMUSTNOTBENULL );
        }

        InputStream inputStream = null;
        SpiPartitionStreamProvider streamProvider = metamodelPartitionToStreamProvider.get( pri );

        if ( streamProvider != null ) {
            inputStream = streamProvider.getPartitionStream( pri );
        } else {
            throw new MoinLocalizedBaseRuntimeException( MetaModelManagerMessages.NO_STREAM_AVAILABLE_FOR_PARTITION, pri );
        }
        return inputStream;
    }

    public void removeDeployedMetamodelPartitions( CRI metamodelCri ) {

        // remove all pris of the given cri from the mapping
        for ( Iterator<Map.Entry<PRI, SpiPartitionStreamProvider>> iterator = this.metamodelPartitionToStreamProvider.entrySet( ).iterator( ); iterator.hasNext( ); ) {
            Map.Entry<PRI, SpiPartitionStreamProvider> entry = iterator.next( );
            PRI registeredMetamodelPartition = entry.getKey( );
            if ( registeredMetamodelPartition.getCri( ).equals( metamodelCri ) ) {
                iterator.remove( );
            }
        }
    }

}
