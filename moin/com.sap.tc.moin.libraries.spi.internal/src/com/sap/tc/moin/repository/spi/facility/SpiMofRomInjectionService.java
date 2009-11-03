package com.sap.tc.moin.repository.spi.facility;

import java.util.List;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.spi.core.SpiLink;

/**
 * This SPI interface provides means to inject mofRom partitions into the
 * facility.
 * <p>
 * This interface <i>is</i> intended to be implemented by service providers.
 * 
 * @see SpiFacility
 */
public interface SpiMofRomInjectionService {

    /**
     * The content of a mofRom partition.
     */
    public static interface SpiMofRomPartitionContent {

        // FIXME refactor: partitionable -> spielement, spiLink -> spiLink (serializer)
        /**
         * Returns the elements of the partition.
         * 
         * @return The elements of the partition
         */
        public List<Partitionable> getElements( );

        /**
         * Returns the links of the partition.
         * 
         * @return the links o the partition
         */
        public List<SpiLink> getLinks( );

        /**
         * The {@link PRI} of the mofRom partition.
         * 
         * @return The PRI of the mofRom partition
         */
        public PRI getPri( );
    }

    /**
     * Injects mofRom partitions into the facility.
     * 
     * @param mofRomPartitionContent The content of the mofRom partitions to
     * inject.
     */
    public void injectMofRomPartitions( List<SpiMofRomPartitionContent> mofRomPartitionContent );
}
