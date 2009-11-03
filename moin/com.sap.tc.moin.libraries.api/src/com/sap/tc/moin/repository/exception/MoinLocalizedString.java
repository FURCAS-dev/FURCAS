package com.sap.tc.moin.repository.exception;

import java.util.Locale;

/**
 * Represents a "translated" String.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface MoinLocalizedString extends MoinExternalizedString {

    /**
     * @param locale the requested {@link Locale}
     * @return the message
     */
    public String getLocalizedMessage( Locale locale );

}
