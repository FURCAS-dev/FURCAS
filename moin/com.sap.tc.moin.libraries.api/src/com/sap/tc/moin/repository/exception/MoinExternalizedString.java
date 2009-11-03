package com.sap.tc.moin.repository.exception;

/**
 * Represents an "Externalized" String
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface MoinExternalizedString {

    /**
     * Simple message parameter replacement, using English locale
     * 
     * @param args the arguments for parameter replacement
     * @return the formatted String
     */
    public String format( Object... args );
}
