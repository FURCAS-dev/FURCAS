package com.sap.tc.moin.repository.mmi.xmi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

/**
 * Reads an entire XMI element from a stream into a RefPackage. The stream is
 * left open upon completion of the read.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface XmiReader {

    /**
     * Reads an entire XMI element from an InputStream into a package extent.
     * Here, the String <code>URI</code> argument specifies the logical name
     * given to the document to be read, and can be used to resolve relative
     * links, if any. If the <code>InputStream</code> is null, then this methods
     * is equivalent to {@link #read(String, RefPackage)}.
     * 
     * @param stream The source of the XMI element.
     * @param URI The logical name of the document to be read.
     * @param extent The extent to which the element is read.
     * @return The {@link RefObject} elements that were read from the XMI
     * element.
     * @throws IOException
     * @throws MalformedXMIException
     */
    public Collection read( InputStream stream, String URI, RefPackage extent ) throws IOException, MalformedXMIException;

    /**
     * Reads an entire XMI element from a specified URI into an outermost
     * package. If the operation succeeds, the read operation returns a
     * collection of RefObjects which are the outermost objects in the XMI
     * content.
     * 
     * @param URI The logical name of the document to be read.
     * @param extent The extent to which the element is read.
     * @return The {@link RefObject} elements that were read from the XMI
     * element.
     * @throws IOException
     * @throws MalformedXMIException
     */
    public Collection read( String URI, RefPackage extent ) throws IOException, MalformedXMIException;
}