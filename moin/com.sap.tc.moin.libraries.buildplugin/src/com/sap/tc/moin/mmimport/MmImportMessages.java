package com.sap.tc.moin.mmimport;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>CannotResolveResourceUriNoSuchEntryInJarFile_XMSG: Cannot resolve resource URI '{0}': no such entry in JAR file {1}</li>
 * <li>JarFileAambiguousInUrl_XMSG: JAR file ambiguous in URL {0}</li>
 * <li>MetaModelJARFileNotFound_XMSG: Meta-model JAR file not found: {0}</li>
 * <li>MetamodelXmiImporterConfigurationErrorIllegalNumberOfTokens_XMSG: MetamodelXmiImporter configuration error: illegal number of tokens in property '{0}'</li>
 * <li>MetamodelXmiImporterConfigurationErrorSecondOptionMustBeTrueOrFalse_XMSG: MetamodelXmiImporter configuration error: the second option in property '{0}' must be 'true' or 'false'</li>
 * <li>MissingMappingInfoForFile_XMSG: Missing mapping information for file '{0}'. Please check your import configuration file.</li>
 * <li>NoEntryForMainDocument_XMSG: No entry for main document specified in JAR file URL {0}</li>
 * <li>UnsupportedURLProtocolForMetaModelImporter_XMSG: Unsupported URL protocol for meta-model importer: {0}</li>
 * <li>WrongProtocolInUrl_XMSG: Wrong protocol in URL '{0}' - must be either empty or 'file'.</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from MmImportMessages.properties
 */
 
public enum MmImportMessages implements MoinLocalizedString {


    /**
     * Message: "Cannot resolve resource URI '{0}': no such entry in JAR file {1}"
     */
    CANNOTRESOLVERESOURCEURINOSUCHENTRYINJARFILE("CannotResolveResourceUriNoSuchEntryInJarFile_XMSG"), //$NON-NLS-1$

    /**
     * Message: "JAR file ambiguous in URL {0}"
     */
    JARFILEAAMBIGUOUSINURL("JarFileAambiguousInUrl_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Meta-model JAR file not found: {0}"
     */
    METAMODELJARFILENOTFOUND("MetaModelJARFileNotFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MetamodelXmiImporter configuration error: illegal number of tokens in property '{0}'"
     */
    METAMODELXMIIMPORTERCONFIGURATIONERRORILLEGALNUMBEROFTOKENS("MetamodelXmiImporterConfigurationErrorIllegalNumberOfTokens_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MetamodelXmiImporter configuration error: the second option in property '{0}' must be 'true' or 'false'"
     */
    METAMODELXMIIMPORTERCONFIGURATIONERRORSECONDOPTIONMUSTBETRUEORFALSE("MetamodelXmiImporterConfigurationErrorSecondOptionMustBeTrueOrFalse_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Missing mapping information for file '{0}'. Please check your import configuration file."
     */
    MISSINGMAPPINGINFOFORFILE("MissingMappingInfoForFile_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No entry for main document specified in JAR file URL {0}"
     */
    NOENTRYFORMAINDOCUMENT("NoEntryForMainDocument_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unsupported URL protocol for meta-model importer: {0}"
     */
    UNSUPPORTEDURLPROTOCOLFORMETAMODELIMPORTER("UnsupportedURLProtocolForMetaModelImporter_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Wrong protocol in URL '{0}' - must be either empty or 'file'."
     */
    WRONGPROTOCOLINURL("WrongProtocolInUrl_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( MmImportMessages.class );

    private final String myKey;

    private MmImportMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + MmImportMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  