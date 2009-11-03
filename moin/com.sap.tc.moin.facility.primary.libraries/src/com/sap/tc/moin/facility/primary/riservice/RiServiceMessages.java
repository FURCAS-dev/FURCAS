package com.sap.tc.moin.facility.primary.riservice;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>ILLEGAL_DESCRIPTOR_WRONG_FACILITY_XMSG: An illegal DataAreaDescriptor has been passed: The descriptor {0} was not created with facility "{1}" which hosting this factory</li>
 * <li>ContainerNameMissing_XMSG: Container name missing in string: "{0}"</li>
 * <li>ContainerNamePrefixMissingInCRI_XMSG: Container name prefix "{0}" missing after first occurrence of data area name separator "{1}" in CRI string: "{2}"</li>
 * <li>ContainerNamePrefixMissingMRI_XMSG: Container name prefix "{0}" missing after first occurrence of data area name separator "{1}" in MRI string: "{2}"</li>
 * <li>ContainerNamePrefixMissingPRI_XMSG: Container name prefix "{0}" missing after first occurrence of data area name separator "{1}" in PRI string: "{2}"</li>
 * <li>ContainerNamePrefixNotAllowedInLRI_XMSG: Container name prefix "{0}" not allowed in LRI string: "{1}"</li>
 * <li>ContainerNameSuffixMissingMRI_XMSG: Container name suffix "{0}" missing after first occurrence of data area name separator "{1}" in MRI string: "{2}"</li>
 * <li>ContainerNameSuffixMissingPRI_XMSG: Container name suffix "{0}" missing after first occurrence of data area name separator "{1}" in PRI string: "{2}"</li>
 * <li>ContainerNameSuffixNotAllowedInCRI_XMSG: Container name suffix "{0}" not allowed in CRI string: "{1}"</li>
 * <li>ContainerNameSuffixNotAllowedInLRI_XMSG: Container name suffix "{0}" not allowed in LRI string: "{1}"</li>
 * <li>DataAreaMissing_XMSG: Data Area name missing in string: "{0}"</li>
 * <li>DataAreaNameSeparatorMissing_XMSG: Data area name separator "{0}" missing in string: "{1}"</li>
 * <li>FacilityIdSeparatorMissing_XMSG: Facility id separator "{0}" missing in string: "{1}"</li>
 * <li>IllegalPartitionSuffixForMetaModelDataArea_XMSG: Invalid partition name: The name "{0}" has an illegal suffix. Partition names in DataArea "{1}" must end with "{2}"</li>
 * <li>InvalidResourceFolder_XMSG: Invalid path for model partition: The name "{0}" does not start with a valid resource folder for container "{1}". Currently valid resource folders for this container are: {2}</li>
 * <li>InvalidVolatilePartition_XMSG: Invalid path for volatile partition: it does not end with the valid partition suffix ("{0}"): {1}</li>
 * <li>InvalidPathLastSegmentNotSuffixOnly_XMSG: Invalid path of model partition: last path segment must not be a suffix only: {0}</li>
 * <li>MofIdMissing_XMSG: MofId missing in string: "{0}"</li>
 * <li>MofIdSeparatorMissingMRI_XMSG: MofId separator "{0}" missing after first occurrence of data area name separator "{1}" in MRI string: "{2}"</li>
 * <li>MofSeparatorNotAllowedInCRI_XMSG: MofId separator "{0}" not allowed in CRI string: "{1}"</li>
 * <li>MofIdSeparatorNotAllowedInLRI_XMSG: MofId separator "{0}" not allowed in LRI string: "{1}"</li>
 * <li>MofSeparatorNotAllowedPRI_XMSG: MofId separator "{0}" not allowed in PRI string: "{1}"</li>
 * <li>NoNWDIResourceIdentifier_XMSG: Not an NWDI resource identifier (wrong facility id "{0}"): "{1}"</li>
 * <li>PartitionNameMissing_XMSG: Partition name missing in string: "{0}"</li>
 * <li>CREATION_FAILED_FACILITY_NOT_ALIVE_XMSG: {0} creation failed. The hosting facility is not alive any more</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from RiServiceMessages.properties
 */
 
public enum RiServiceMessages implements MoinLocalizedString {


    /**
     * Message: "{0} creation failed. The hosting facility is not alive any more"
     */
    CREATION_FAILED_FACILITY_NOT_ALIVE("CREATION_FAILED_FACILITY_NOT_ALIVE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Container name missing in string: "{0}""
     */
    CONTAINERNAMEMISSING("ContainerNameMissing_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Container name prefix "{0}" missing after first occurrence of data area name separator "{1}" in CRI string: "{2}""
     */
    CONTAINERNAMEPREFIXMISSINGINCRI("ContainerNamePrefixMissingInCRI_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Container name prefix "{0}" missing after first occurrence of data area name separator "{1}" in MRI string: "{2}""
     */
    CONTAINERNAMEPREFIXMISSINGMRI("ContainerNamePrefixMissingMRI_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Container name prefix "{0}" missing after first occurrence of data area name separator "{1}" in PRI string: "{2}""
     */
    CONTAINERNAMEPREFIXMISSINGPRI("ContainerNamePrefixMissingPRI_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Container name prefix "{0}" not allowed in LRI string: "{1}""
     */
    CONTAINERNAMEPREFIXNOTALLOWEDINLRI("ContainerNamePrefixNotAllowedInLRI_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Container name suffix "{0}" missing after first occurrence of data area name separator "{1}" in MRI string: "{2}""
     */
    CONTAINERNAMESUFFIXMISSINGMRI("ContainerNameSuffixMissingMRI_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Container name suffix "{0}" missing after first occurrence of data area name separator "{1}" in PRI string: "{2}""
     */
    CONTAINERNAMESUFFIXMISSINGPRI("ContainerNameSuffixMissingPRI_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Container name suffix "{0}" not allowed in CRI string: "{1}""
     */
    CONTAINERNAMESUFFIXNOTALLOWEDINCRI("ContainerNameSuffixNotAllowedInCRI_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Container name suffix "{0}" not allowed in LRI string: "{1}""
     */
    CONTAINERNAMESUFFIXNOTALLOWEDINLRI("ContainerNameSuffixNotAllowedInLRI_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Data Area name missing in string: "{0}""
     */
    DATAAREAMISSING("DataAreaMissing_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Data area name separator "{0}" missing in string: "{1}""
     */
    DATAAREANAMESEPARATORMISSING("DataAreaNameSeparatorMissing_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Facility id separator "{0}" missing in string: "{1}""
     */
    FACILITYIDSEPARATORMISSING("FacilityIdSeparatorMissing_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An illegal DataAreaDescriptor has been passed: The descriptor {0} was not created with facility "{1}" which hosting this factory"
     */
    ILLEGAL_DESCRIPTOR_WRONG_FACILITY("ILLEGAL_DESCRIPTOR_WRONG_FACILITY_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Invalid partition name: The name "{0}" has an illegal suffix. Partition names in DataArea "{1}" must end with "{2}""
     */
    ILLEGALPARTITIONSUFFIXFORMETAMODELDATAAREA("IllegalPartitionSuffixForMetaModelDataArea_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Invalid path of model partition: last path segment must not be a suffix only: {0}"
     */
    INVALIDPATHLASTSEGMENTNOTSUFFIXONLY("InvalidPathLastSegmentNotSuffixOnly_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Invalid path for model partition: The name "{0}" does not start with a valid resource folder for container "{1}". Currently valid resource folders for this container are: {2}"
     */
    INVALIDRESOURCEFOLDER("InvalidResourceFolder_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Invalid path for volatile partition: it does not end with the valid partition suffix ("{0}"): {1}"
     */
    INVALIDVOLATILEPARTITION("InvalidVolatilePartition_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MofId missing in string: "{0}""
     */
    MOFIDMISSING("MofIdMissing_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MofId separator "{0}" missing after first occurrence of data area name separator "{1}" in MRI string: "{2}""
     */
    MOFIDSEPARATORMISSINGMRI("MofIdSeparatorMissingMRI_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MofId separator "{0}" not allowed in LRI string: "{1}""
     */
    MOFIDSEPARATORNOTALLOWEDINLRI("MofIdSeparatorNotAllowedInLRI_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MofId separator "{0}" not allowed in CRI string: "{1}""
     */
    MOFSEPARATORNOTALLOWEDINCRI("MofSeparatorNotAllowedInCRI_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MofId separator "{0}" not allowed in PRI string: "{1}""
     */
    MOFSEPARATORNOTALLOWEDPRI("MofSeparatorNotAllowedPRI_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Not an NWDI resource identifier (wrong facility id "{0}"): "{1}""
     */
    NONWDIRESOURCEIDENTIFIER("NoNWDIResourceIdentifier_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition name missing in string: "{0}""
     */
    PARTITIONNAMEMISSING("PartitionNameMissing_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( RiServiceMessages.class );

    private final String myKey;

    private RiServiceMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + RiServiceMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  