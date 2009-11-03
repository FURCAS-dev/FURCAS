package com.sap.tc.moin.js.query.service.client;

/**
 * Internal constants used for parsing/serializing MOIN Resource Identifiers.
 * 
 * @author D044522
 */
public interface QsResourceIdentifierConstants {

    public static final char FACILITY_PART_SEPARATOR = ':';

    public static final char FACILITY_INSTANCE_SEPARATOR = '.';

    public static final char SUFFIX_START_CHAR = '.';

    public static final char MOF_ID_SEPARATION_CHAR = '#';

    public static final String DC_NAME_PART_PREFIX = "DCs/"; //$NON-NLS-1$

    public static final String DC_NAME_PART_SUFFIX = "/_comp/"; //$NON-NLS-1$

    public static final String DC_INTERNAL = "internal"; //$NON-NLS-1$

    /**
     * Key for transmitting a NWDI Development Configuration name as a value in
     * {@link RemoteMqlProcessor#getDataArea(java.util.Map) and
     * {@link RemoteMqlProcessor#getDataAreaConfig(com.sap.tc.moin.repository.DataAreaDescriptor)}
     * .
     */
    public static final String DEV_CONF_NAME = "DevConfName"; //$NON-NLS-1$

    public static final String PRIMARY_FACILITY_ID = "PF"; //$NON-NLS-1$

}
