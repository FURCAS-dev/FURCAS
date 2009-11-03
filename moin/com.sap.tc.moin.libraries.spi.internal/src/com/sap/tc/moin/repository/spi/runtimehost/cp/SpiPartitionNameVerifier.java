package com.sap.tc.moin.repository.spi.runtimehost.cp;

/**
 * Verifier for partition names. This verification interface is used for the PRI
 * verification for PRI patterns defined by custom parsers/serializers.
 * 
 * @author d026715
 */
public interface SpiPartitionNameVerifier {

    /**
     * see https://wiki.wdf.sap.corp/display/MOIN/Domain+Partition+Suffixes
     * 
     * @deprecated only temporarily used. Will be replaced by cps registration
     * concept.
     */
    @SuppressWarnings( "nls" )
    @Deprecated
    public static final String[] DEFAULT_SUFFIXES = new String[] { ".diagram", ".workflow", ".task", ".rule", ".triggernet", ".types", ".services", ".consgroup", ".servicerefs", ".authprofile", ".moinmm", ".mointest", // our suffix for test data see MoinTestHelper.TEST_PARTITION_SUFFIX  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
        ".volatile", //$NON-NLS-1$
        ".xmi", // keep ".xmi" for backward compatibility (old partition suffix) //$NON-NLS-1$
        ".bpmn", //$NON-NLS-1$
        ".function", //$NON-NLS-1$
        ".sif", //$NON-NLS-1$
        ".dtype", //$NON-NLS-1$
        ".mtype", // galaxy substitutes for .workflow and .rule //$NON-NLS-1$
        ".eventdef", // galaxy event definitions
        ".sldata" }; //$NON-NLS-1$

    /**
     * Returns if the given partition name identifies a valid model partition.
     * 
     * @param partitionName The partition name to validate
     * @return <code>true</code> if the given <code>partitionName</code> is
     * valid, <code>false</code> otherwise.
     */
    public boolean isValidPartitionName( String partitionName );

    /**
     * Checks if the given partition name identifies a valid model partition and
     * throws an exception if this is not the case.
     * 
     * @param partitionName The partition name to validate
     * @throws MoinLocalizedBaseRuntimeException If the given
     * <code>partitionName</code> is not valid.
     */
    public void validatePartitionName( String partitionName );

}
