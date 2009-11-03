package com.sap.tc.moin.xmi;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>IllegalNumberOfTokensInProperty_XMSG: Configuration error: illegal number of tokens in property '{0}'</li>
 * <li>SecondOptionInPropertyMustBeTrueOrFalse_XMSG: Configuration error: the second option in property '{0}' must be 'true' or 'false'</li>
 * <li>ExpectedSlashWithinContainerName_XMSG: Expected / within container name '{0}', cannot extract vendor , dc </li>
 * <li>MetamodelIdHasNotBeenDefinedIn_XMSG: Meta-model id has not been defined in {0}</li>
 * <li>MetamodelVendorHasNotBeenDefinedIn_XMSG: Meta-model vendor has not been defined in {0}</li>
 * <li>UnsupportedURLProtocolForMetaModelImporter_XMSG: Unsupported URL protocol for meta-model importer: {0}</li>
 * <li>CanNotBeLegal_XMSG: {0} can not be legal</li>
 * <li>HasNotBeenFound_XMSG: {0} has not been found in {1}</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from MoinXmiMessages.properties
 */
 
public enum MoinXmiMessages implements MoinLocalizedString {


    /**
     * Message: "{0} can not be legal"
     */
    CANNOTBELEGAL("CanNotBeLegal_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Expected / within container name '{0}', cannot extract vendor , dc "
     */
    EXPECTEDSLASHWITHINCONTAINERNAME("ExpectedSlashWithinContainerName_XMSG"), //$NON-NLS-1$

    /**
     * Message: "{0} has not been found in {1}"
     */
    HASNOTBEENFOUND("HasNotBeenFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Configuration error: illegal number of tokens in property '{0}'"
     */
    ILLEGALNUMBEROFTOKENSINPROPERTY("IllegalNumberOfTokensInProperty_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Meta-model id has not been defined in {0}"
     */
    METAMODELIDHASNOTBEENDEFINEDIN("MetamodelIdHasNotBeenDefinedIn_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Meta-model vendor has not been defined in {0}"
     */
    METAMODELVENDORHASNOTBEENDEFINEDIN("MetamodelVendorHasNotBeenDefinedIn_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Configuration error: the second option in property '{0}' must be 'true' or 'false'"
     */
    SECONDOPTIONINPROPERTYMUSTBETRUEORFALSE("SecondOptionInPropertyMustBeTrueOrFalse_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unsupported URL protocol for meta-model importer: {0}"
     */
    UNSUPPORTEDURLPROTOCOLFORMETAMODELIMPORTER("UnsupportedURLProtocolForMetaModelImporter_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( MoinXmiMessages.class );

    private final String myKey;

    private MoinXmiMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + MoinXmiMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  