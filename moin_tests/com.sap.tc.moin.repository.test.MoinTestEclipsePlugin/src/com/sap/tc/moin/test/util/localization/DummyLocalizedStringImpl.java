/**
 * 
 */
package com.sap.tc.moin.test.util.localization;

import java.text.MessageFormat;
import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;


/**
 * Dummy implementation for localized string which simply wraps a string.
 * <p>
 * This is useful for creating a {@link MoinLocalizedString} instance directly
 * from a string literal, i.e. w/o overhead for externalization and translation.
 * Must only be used within test code (which is not translated by nature).
 * 
 * @author d032434
 */
public class DummyLocalizedStringImpl implements MoinLocalizedString {

    private final String wrappedString;


    /**
     * @param wrappedString
     */
    public DummyLocalizedStringImpl( String wrappedString ) {

        super( );
        this.wrappedString = wrappedString;
    }

    /**
     * @see com.sap.tc.moin.repository.exception.MoinLocalizedString#getLocalizedMessage(java.util.Locale)
     */
    public String getLocalizedMessage( Locale locale ) {

        return this.wrappedString;
    }

    /**
     * @see com.sap.tc.moin.repository.exception.MoinExternalizedString#format(java.lang.Object[])
     */
    public String format( Object... args ) {

        return MessageFormat.format( this.wrappedString, args );
    }

}
