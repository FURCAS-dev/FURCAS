package com.sap.tc.moin.js.query.service.client.impl;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>Remote_ME_cannot_be_resolved: Remote model elements cannot be resolved directly to RefObjects</li>
 * <li>Team_Server_returned_Exception: Team Server returned Exception\: {0}</li>
 * <li>Team_Server_returned_result: Team Server returned result\: {0}</li>
 * <li>Mql_Processor_created: {0} created for service URL {1}</li>
 * <li>Class_read_only: {0} is read-only\!</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from Localization.properties
 */
 
public enum Localization implements MoinLocalizedString {


    /**
     * Message: "{0} is read-only\!"
     */
    CLASS_READ_ONLY("Class_read_only"), //$NON-NLS-1$

    /**
     * Message: "{0} created for service URL {1}"
     */
    MQL_PROCESSOR_CREATED("Mql_Processor_created"), //$NON-NLS-1$

    /**
     * Message: "Remote model elements cannot be resolved directly to RefObjects"
     */
    REMOTE_ME_CANNOT_BE_RESOLVED("Remote_ME_cannot_be_resolved"), //$NON-NLS-1$

    /**
     * Message: "Team Server returned Exception\: {0}"
     */
    TEAM_SERVER_RETURNED_EXCEPTION("Team_Server_returned_Exception"), //$NON-NLS-1$

    /**
     * Message: "Team Server returned result\: {0}"
     */
    TEAM_SERVER_RETURNED_RESULT("Team_Server_returned_result"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( Localization.class );

    private final String myKey;

    private Localization( String bundleKey ) {

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
            return "Localization failed for ResourceBundle " + Localization.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  