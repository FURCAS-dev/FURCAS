package com.sap.tc.moin.repository.runtimehost.deployment;

import com.sap.tc.moin.repository.metamodels.MetaModelVersion;
import com.sap.tc.moin.repository.runtimehost.MmInfoConst;

/**
 * Header of a MOIN archive.<br>
 * This class contains the information read from archive property file
 * {@link MmInfoConst#MM2_PROPERTIES_FILE_NAME}. If this file is not available
 * (old metamodel format), the information comes from the file
 * {@link MmInfoConst#MM_PROPERTIES_FILE_NAME}.
 * 
 * @author D026715
 */
public class MoinArchiveHeader {


    public MoinArchiveHeader( String containerName, String label, String vendor, MetaModelVersion version ) {

        this.containerName = containerName;
        this.label = label;
        this.vendor = vendor;
        this.version = version;
    }


    /**
     * Version of this meta-model
     */
    private MetaModelVersion version = null;

    private String containerName;

    /**
     * Label (description) of the meta-model
     */
    private String label = null;

    /**
     * Vendor of the meta-model
     */
    private String vendor = null;


    public MetaModelVersion getVersion( ) {

        return version;
    }


    public String getContainerName( ) {

        return containerName;
    }


    public String getLabel( ) {

        return label;
    }


    public String getVendor( ) {

        return vendor;
    }
}
