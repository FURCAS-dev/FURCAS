package com.sap.tc.moin.repository.test.jmitck.modelsem;

import java.io.IOException;
import java.io.InputStream;

/**
 * Acts as access point for accessing Xmi input resources.
 * <p>
 * Really, not sure what the point is. Probably expected it to be much more.
 * Should refactor out, but there's no time left.
 */
public class XmiDictionary {

    private static XmiDictionary instance = new XmiDictionary( );

    private XmiDictionary( ) {

    }

    /**
     * Returns the singleton instance.
     * 
     * @return a <code>XmiDictionary</code> value
     */
    public static XmiDictionary getInstance( ) {

        return instance;
    }

    /**
     * Returns the input stream corresponding to the provided path.
     * 
     * @param id a <code>String</code> a path, relative to this classes'
     * location.
     * @return an <code>InputStream</code> the input stream to read in the XMI.
     * @exception IOException if an the resource could not be found or opened.
     */
    public InputStream getStream( String id ) throws IOException {

        return getClass( ).getResourceAsStream( id );
    }
}
