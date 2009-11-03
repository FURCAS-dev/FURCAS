package com.sap.tc.moin.facility.primary.ipi;

import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.spi.facility.SpiDataArea;

/**
 * Facility internal IPI interface for a DataArea.
 * 
 * @see DataArea
 * @see SpiDataArea
 */
public interface IpiDataArea extends SpiDataArea {

    /**
     * Denotes the kind of a data area.
     */
    public enum Kind {
        /**
         * There is exactly one metamodel data area.
         */
        Metamodel,
        /**
         * Transient data areas have no persistence.
         */
        Transient,
        /**
         * Regular data areas are used for normal partition handling.
         */
        Regular
    }

    /**
     * @return false, if partitions can never be created or changed physically
     * through the MOIN API. Transient partitions are not modifiable.
     */
    boolean isModifiable( );

    /**
     * Lifecycle operation.
     * <p>
     * Releases eventually acquired resources.
     */
    void destroy( );

}
