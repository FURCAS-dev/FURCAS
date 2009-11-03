/**
 * 
 */
package com.sap.tc.moin.repository.runtimehost.deployment;

import java.io.IOException;


/**
 * Exception thrown in case of invalid meta-model archives.
 */
public class InvalidMetaModelArchiveFormatException extends IOException {

    private static final long serialVersionUID = -6625751047412693306L;

    /**
     * @param s
     */
    public InvalidMetaModelArchiveFormatException( String s ) {

        super( s );
    }
}
