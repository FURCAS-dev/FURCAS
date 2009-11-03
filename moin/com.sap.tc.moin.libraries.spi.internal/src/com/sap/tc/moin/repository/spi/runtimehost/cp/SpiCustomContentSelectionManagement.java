package com.sap.tc.moin.repository.spi.runtimehost.cp;

import java.util.Collection;

import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;


public interface SpiCustomContentSelectionManagement {

    /**
     * The method retrieves a the complete set of content-selection-properties
     * from the SpiPartitionSerializationManager and checks its correctness.
     * <p>
     * Example: Content selection properties for DI
     * <p>
     * The content selection properties of a
     * custom-parser-serializer-registration describe one/several DC type/s with
     * its/their MOIN-relevant folders. A related set of
     * content-selection-properties is related to one DC type as
     * reference-point: it is the set of content-selection-properties for one DC
     * type. This set describes the DC type name and vendor and the related
     * MOIN-relevant folders inside of DCs with this DC type.
     * </p>
     */
    CheckResult checkContentSelectionProperties( );

    public interface CheckResult {

        int getSeverity( );

        Collection<MoinIllegalArgumentException> getErrors( );

        Collection<MoinIllegalArgumentException> getWarnings( );

    }
}
