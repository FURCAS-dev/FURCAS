package com.sap.tc.moin.repository.test.logger;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>logger_0000_XMSG: A simple message</li>
 * <li>logger_1002_XMSG: Log and trace test case - Exception generated only for test purposes (severity {0})</li>
 * <li>logger_1001_XMSG: Log and trace test case - message (severity {0})</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from TestMessage.properties
 */
 
public enum TestMessage implements MoinLocalizedString {


    /**
     * Message: "A simple message"
     */
    LOGGER_0000("logger_0000_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Log and trace test case - message (severity {0})"
     */
    LOGGER_1001("logger_1001_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Log and trace test case - Exception generated only for test purposes (severity {0})"
     */
    LOGGER_1002("logger_1002_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( TestMessage.class );

    private final String myKey;

    private TestMessage( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + TestMessage.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  