package com.sap.tc.moin.facility.primary.query.index.memory;


public class IndexFsDumpedConstants {

    /*
     * ############# File System Dumped Index Log Messages ############
     */
    public static final String ERROR_IN_DUMPER_THREAD_SHUTDOWN = "Error occured while shutting down index dumper thread"; //$NON-NLS-1$

    public static final String DUMPER_THREAD_STOP_REQUESTED = "Request received to stop index dumper thread {0}"; //$NON-NLS-1$

    public static final String DUMPER_THREAD_STARTING = "Starting index dumper thread {0}"; //$NON-NLS-1$

    public static final String DUMPER_THREAD_ENDING = "Index dumper thread stopped {0}"; //$NON-NLS-1$

    public static final String INDEX_DUMPED = "Index successfully dumped to file {0}"; //$NON-NLS-1$

    public static final String INACTIVE_SYNC_NOT_ALLOWED = "Inactive sync currently not supported in FS dumped scenario"; //$NON-NLS-1$

    public static final String COULD_NOT_LOAD_DUMP_FROM_FILE = "Unable to load index from dump file {0}"; //$NON-NLS-1$

    public static final String LOADED_DUMP_FROM_FILE = "Index loaded from dump file {0}"; //$NON-NLS-1$

    public static final String DUMPFILE_NOT_AVAILABLE = "Dump file not available {0}"; //$NON-NLS-1$

    public static final String SIGN_FILE_MISSING = "Index completeness check failed, rebuilt from file system necessary"; //$NON-NLS-1$

    public static final String ERROR_DELETE_DUMP = "Could not delete existing index dump file {0}"; //$NON-NLS-1$

    public static final String ERROR_DELETE_SIGN_FILE = "Could not delete index sign file {0}"; //$NON-NLS-1$

    public static final String COULD_NOT_DUMP_INDEX_TO_FILE = "Could not dump index to file {0}"; //$NON-NLS-1$
}
