package com.sap.tc.moin.ocl.utils.jmi;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>CannotDetermineCollectionKind_XMSG: Can not determine collection kind</li>
 * <li>ExceptionInitOclHelper_XMSG: Exception while initializing OCL Helper</li>
 * <li>FailedToCreatePackageForGenObject_XMSG: Failed to create package for generated objects</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from OclUtilExceptions.properties
 */
 
public enum OclUtilExceptions implements MoinLocalizedString {


    /**
     * Message: "Can not determine collection kind"
     */
    CANNOTDETERMINECOLLECTIONKIND("CannotDetermineCollectionKind_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Exception while initializing OCL Helper"
     */
    EXCEPTIONINITOCLHELPER("ExceptionInitOclHelper_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Failed to create package for generated objects"
     */
    FAILEDTOCREATEPACKAGEFORGENOBJECT("FailedToCreatePackageForGenObject_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( OclUtilExceptions.class );

    private final String myKey;

    private OclUtilExceptions( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + OclUtilExceptions.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  