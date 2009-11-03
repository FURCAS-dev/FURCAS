package com.sap.tc.moin.facility.primary.riservice;

/**
 * Defines constants used by different parts of the Di based resource identifier
 * service implementation.
 * 
 * @author D047015
 */
public interface DiResourceIdentifierConstants {

    // FIXME: this delimiter is defined MOIN-wide and should be defined elsewhere 
    public static final char FACILITY_PART_SEPARATOR = ':';

    // FIXME: this delimiter is defined MOIN-wide and should be defined elsewhere 
    public static final char FACILITY_INSTANCE_SEPARATOR = '.';

    public static final char SUFFIX_START_CHAR = '.';

    public static final char MOF_ID_SEPARATION_CHAR = '#';

    public static final String DC_NAME_PART_PREFIX = "DCs/"; //$NON-NLS-1$

    public static final String DC_NAME_PART_SUFFIX = "/_comp/"; //$NON-NLS-1$

    public static final String DC_INTERNAL = "internal"; //$NON-NLS-1$

    // MOIN internally defined credentials:
    // Resource folder as it is used starting with MS6 in MOIN Core,
    // see com.sap.tc.moin.repository.core.impl.PartitionManagerImpl,
    // e.g. method createExtentPartition(Stage metaModelStage)
    // todo: remove this constant when final solution is realized, see in
    // checkMS7LocalPartitionPathRestriction
    // Caution:
    // Usages expect that the trailing '/' is part of the constant (performance:
    // avoid repeated concatenation with '/')
    public static final String FIXED_VOLATILE_PARTITION_FOLDER = "<volatile-partitions>/"; //$NON-NLS-1$

    // NullPartition prefix
    // (path without suffix as it is used in MOIN Core, see
    // com.sap.tc.moin.repository.core.impl.PartitionManagerImpl)
    // todo: remove this constant when final solution is realized, see in
    // checkMS7LocalPartitionPathRestriction
    public static final String NULL_PARTITION_PREFIX = FIXED_VOLATILE_PARTITION_FOLDER + "null-partition/"; //$NON-NLS-1$

    // partition suffix for volatile partitions as defined in CorePartitionFactory
    public static final String FIXED_VOLATILE_PARTITION_SUFFIX = ".volatile"; //$NON-NLS-1$
}
