package com.sap.tc.moin.repository.core.consistency.impl;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>CorrectionInvalidPartitionCouldNotBeDFound_XMSG: Correction with id {0} is invalid. Partition {1} could not be found.</li>
 * <li>IllegalCorrectionId_XMSG: Illegal correction id: {0}</li>
 * <li>IllegalStateForInconsistencyNotificationQueue_XMSG: Illegal state for inconsistency notification queue</li>
 * <li>InconsistencyOnlyOneMRI_XMSG: Inconsistency with only one MRI reported</li>
 * <li>EndsCouldNotBeResolved_XMSG: One or both ends could not be resolved</li>
 * <li>UnknownCorrectionId_XMSG: Unknown correction id</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from CoreConsistencyMessages.properties
 */
 
public enum CoreConsistencyMessages implements MoinLocalizedString {


    /**
     * Message: "Correction with id {0} is invalid. Partition {1} could not be found."
     */
    CORRECTIONINVALIDPARTITIONCOULDNOTBEDFOUND("CorrectionInvalidPartitionCouldNotBeDFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "One or both ends could not be resolved"
     */
    ENDSCOULDNOTBERESOLVED("EndsCouldNotBeResolved_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Illegal correction id: {0}"
     */
    ILLEGALCORRECTIONID("IllegalCorrectionId_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Illegal state for inconsistency notification queue"
     */
    ILLEGALSTATEFORINCONSISTENCYNOTIFICATIONQUEUE("IllegalStateForInconsistencyNotificationQueue_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Inconsistency with only one MRI reported"
     */
    INCONSISTENCYONLYONEMRI("InconsistencyOnlyOneMRI_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unknown correction id"
     */
    UNKNOWNCORRECTIONID("UnknownCorrectionId_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( CoreConsistencyMessages.class );

    private final String myKey;

    private CoreConsistencyMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + CoreConsistencyMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  