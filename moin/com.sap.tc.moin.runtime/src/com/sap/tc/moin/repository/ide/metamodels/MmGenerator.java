package com.sap.tc.moin.repository.ide.metamodels;

import java.util.Collection;

/**
 * @author D052089
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface MmGenerator {

    public static final String CONTAINER = "container"; //$NON-NLS-1$

    public static final String DC_DESCRIPTION = "dcDescription"; //$NON-NLS-1$

    public static final String DC_NAME = "dcName"; //$NON-NLS-1$

    public static final String DC_VENDOR = "dcVendor"; //$NON-NLS-1$

    public static final String DC_VERSION = "dcVersion"; //$NON-NLS-1$

    public static final String FACILITY_NAME = "facilityName"; //$NON-NLS-1$

    public static final String GENERATE_MOF = "generateMof"; //$NON-NLS-1$

    public static final String IGNORE_CHECKS = "ignoreChecks"; //$NON-NLS-1$

    public MmGenerationResult generate( MmGenerationInfo metamodelToBeGenerated, Collection<MmGenerationBaseInfo> additionalMetamodelsToConsider ) throws IllegalArgumentException;

    public void convertXmi( MmExecutableInfo metamodelToBeConverted, Collection<MmGenerationBaseInfo> additionalMetamodelsToConsider ) throws IllegalArgumentException;
}
