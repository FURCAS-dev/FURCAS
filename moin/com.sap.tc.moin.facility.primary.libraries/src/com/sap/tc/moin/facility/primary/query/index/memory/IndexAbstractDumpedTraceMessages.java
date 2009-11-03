package com.sap.tc.moin.facility.primary.query.index.memory;

import com.sap.tc.moin.repository.exception.MoinExternalizedString;
import com.sap.tc.moin.repository.localization.ExternalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Externalized Messages in alphabetical order:
 * <ol>
 * <li>ERROR_DURING_INDEX_DUMP_XMSG: Error during index dump</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from IndexAbstractDumpedTraceMessages.properties
 */
 
public enum IndexAbstractDumpedTraceMessages implements MoinExternalizedString {


    /**
     * Message: "Error during index dump"
     */
    ERROR_DURING_INDEX_DUMP("ERROR_DURING_INDEX_DUMP_XMSG"); //$NON-NLS-1$

    private final static ExternalizedResourceBundleAccessor ACCESSOR = new ExternalizedResourceBundleAccessor( IndexAbstractDumpedTraceMessages.class );

    private final String myKey;

    private IndexAbstractDumpedTraceMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );

    }

}  