package com.sap.tc.moin.repository.spi.core;

import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.core.serialization.SpiPartitionReader;
import com.sap.tc.moin.repository.spi.core.serialization.SpiPartitionWriter;
import com.sap.tc.moin.repository.spi.ps.SpiCustomParserSerializerFactory;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;

/**
 * Provides partition management related MOIN Core functionality to other
 * layers.
 * <p>
 * This interface is not intended to be implemented by service providers. The
 * implementation will be provided by the MOIN Core.
 * 
 * @author d047015
 */
public interface SpiPartitionService extends SpiCustomParserSerializerFactory {

    // TODO: Add missing JavaDoc

    public SpiPartitionReader createPartitionReader( );

    public SpiPartitionWriter createPartitionWriter( );

    /**
     * Returns the core parser callback to be passed to the custom parsers.
     * 
     * @return
     */
    public SpiParserCallback getCoreParserCallback( SpiPartitionSerializationManager serializationManager, SpiSession session, ModelPartition partition );

    /**
     * Evicts the given partitions grouped by stage.
     * 
     * @param partitionsToEvictPerStage the partitions to evict grouped by stage
     * @throws IllegalArgumentException if the input parameter is null
     */
    public void evictPartitions( Map<SpiStage, List<PRI>> partitionsToEvictPerStage );

    /**
     * Determines whether a partition contains translatable texts.
     * <p>
     * A partition contains a text if it has at least one class in it with a
     * translatable text typed attribute.
     * 
     * @param connection The MOIN connection
     * @param pri The PRI of the partition to check for translatable texts.
     */
    public boolean hasTranslatableTexts( Connection connection, PRI pri );

    /**
     * 
     */
    public void requestMofRomInjection( );
}