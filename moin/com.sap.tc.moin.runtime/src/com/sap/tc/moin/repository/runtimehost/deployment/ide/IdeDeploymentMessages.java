package com.sap.tc.moin.repository.runtimehost.deployment.ide;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>PARTITION_DEPLOYMENT_FAILED_XMSG: Deployment of metamodel partitions failed</li>
 * <li>VERSION_MISMATCH_XMSG: Version mismatch for metamodel {0}</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from IdeDeploymentMessages.properties
 */
 
public enum IdeDeploymentMessages implements MoinLocalizedString {


    /**
     * Message: "Deployment of metamodel partitions failed"
     */
    PARTITION_DEPLOYMENT_FAILED("PARTITION_DEPLOYMENT_FAILED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Version mismatch for metamodel {0}"
     */
    VERSION_MISMATCH("VERSION_MISMATCH_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( IdeDeploymentMessages.class );

    private final String myKey;

    private IdeDeploymentMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            // $JL-EXC$        
            return "Localization failed for ResourceBundle " + IdeDeploymentMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  