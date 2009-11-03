package com.sap.tc.moin.facility.primary.query.index.memory;

import com.sap.tc.moin.facility.primary.ipi.IpiPrimaryFacility;

public interface IndexConstants {

    public static final int INITIAL_ME_PER_PRI = 100;

    public static final int INITIAL_PRI = 10; // 100

    public static final int INITIAL_MC = 500;

    public static final int INITIAL_ME_PER_MMRI = 32;

    public static final int INITIAL_TOTAL_LRI = 16; // 1 << 15;

    public static final int INITIAL_REFMMRI_PER_LRI = 1; // was: 5

    public static final int INITIAL_REFENDS = 2;

    public static final int INITIAL_LINK_PER_PRI = 16;

    public static final int INITIAL_DA = 2;

    public static final int INITIAL_DC = 10;

    public static final int INITIAL_ASSOCMMRI = 400;

    public static final int INITIAL_REMOVE_LINKS = 10;

    public static final int INITIAL_DA_LC = 8;

    public static final boolean ALWAYS_REMOVE_LINK = false;

    public static final String TOP_LEVEL_PACKAGE_ATT_NAME = "name"; //$NON-NLS-1$

    public static final String LOCAL = "local:"; //$NON-NLS-1$

    public static final String ASSOC_CONTAINS_MOF_ID = "45ED2E29A15C5D7FDF8D483F1CFA93E430ADEDCC"; //$NON-NLS-1$

    public static final String ELEMENT_PACKAGE_MOF_ID = "45ED2E2925D14D728A6546C630BDE3FB4BDA77C3"; //$NON-NLS-1$

    public static final String ENCODING = "UTF-8"; //$NON-NLS-1$

    public static final int DUMPMEMORY = 8192; // 256 kbyte = 262144 byte

    public static final long DUMP_THREAD_SLEEP_TIME = 1000 * 60 * 5; // 5 min

    public static final int LEN_LRI = 50;

    public static final int MAX_LEN_PRI_AVG = 200;

    public static final boolean SANITY_CHECK_DISABLED = true;

    public static final int SANITY_CHECK_DISABLED_IGNORE = 1;

    public static final int SANITY_LINKS_COMPLETE = 2;

    public static final int SANITY_LINKS_FAST = 4;

    public static final int SANITY_ELEMENTS = 8;

    public static final int SANITY_DEV_COMP = 16;

    public static final int SANITY_MOFID_CONSISTENCY = 32;

    public static final int SANITY_FORCE_CHECK_ALL = Integer.MAX_VALUE;

    public static final int SANITY_AFTER_PARTITION_REMOVE = SANITY_LINKS_FAST | SANITY_ELEMENTS | SANITY_DEV_COMP;

    public static final int SANITY_BEFORE_PARTITION_REMOVE = SANITY_ELEMENTS | SANITY_DEV_COMP;

    public static final int SANITY_AFTER_LINK_REMOVE = SANITY_LINKS_FAST;

    public static final int SANITY_AFTER_LINK_ADD = SANITY_LINKS_FAST;

    public static final int SANITY_AFTER_ELEMENT_ADD = SANITY_ELEMENTS | SANITY_MOFID_CONSISTENCY;

    public static final int SANITY_AFTER_ELEMENT_REMOVE = SANITY_ELEMENTS | SANITY_MOFID_CONSISTENCY;

    public static final String MM_DA_NAME = IpiPrimaryFacility.META_MODEL_DATA_AREA_ID;

    // FIXME to be removed when metamodel type check is removed 
    public static final String MOF_CONTAINER_NAME = "sap.com/tc/moin/mof_1.4"; //$NON-NLS-1$

    public static final String DUMPER_THREAD_NAME = "IndexDumperThread"; //$NON-NLS-1$

    public static final String DUMP_FILE_SIGN_EXT = ".sign"; //$NON-NLS-1$

    // (see DiResourceIdentifierVerifier#FACILITY_PART_SEPARATOR)
    public static final String DATA_AREA_SEPARATOR = ":"; //$NON-NLS-1$

    /*
     * ############# Logger Message Strings #############
     */

    public static final String INDEXING_STATS = "IndexingAction={0}, PRI={1}, forced={2}"; //$NON-NLS-1$

    public static final String LINK_TABLES_INCONSISTENT = "Number of links in locLinkTable({0}) differs from extLinkTable({1})"; //$NON-NLS-1$

    public static final String FROM_END_OUT_OF_RANGE = "From end parameter must be '0' or '1' but was {0}"; //$NON-NLS-1$

    public static final String UNEQUAL_LENGTH_PRI_AND_TIMESTAMPS = "Length of PRI array({0}) and timestamp array({1}) are unequal"; //$NON-NLS-1$

    public static final String PRIS_CONTAIN_NULL = "PRIs list contains null entry"; //$NON-NLS-1$

    public static final String FOUND_DANGLING_LINK_IN_PARTITION = "Query found possible dangling link {0} "; //$NON-NLS-1$

    public static final String INDEX_INITIALIZATION = "Index initialization."; //$NON-NLS-1$

    public static final String INDEX_TEARDOWN = "Index shut down"; //$NON-NLS-1$

    public static final String STREAM_UNAVAILABLE = "Could not get Stream for parititon {0}"; //$NON-NLS-1$

    public static final String PARSING_ERROR = "Error during indexing of partition {0}"; //$NON-NLS-1$

    public static final String SYNCHRONIZE_INDEX_STATS = "Synchronize index in bulk-operation: number of PRIs={0}, DA={1}, CN={2}"; //$NON-NLS-1$

}
