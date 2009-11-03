package com.sap.tc.moin.repository.mmi.xmi;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

/**
 * Writes XMI elements to a stream. The stream is left open upon completion of
 * the write, and a separate XMI element is written for each write operation.
 * The <code>xmiVersion</code> parameter specifies the version of XMI. The
 * values for the <code>xmiVersion</code> parameter are the values placed in the
 * <code>version</code> attribute of the XMI element as defined in the XMI
 * specification, e.g., "1.2" or "2.0".
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface XmiWriter {

    /**
     * Writes an entire extent to a stream.
     * 
     * @param stream The stream to which the extent is written.
     * @param extent The extent that is written.
     * @param xmiVersion The version of XMI, e.g. "1.2" or "2.0"
     * @throws IOException
     */
    public void write( OutputStream stream, RefPackage extent, String xmiVersion ) throws IOException;

    /**
     * Writes MOF objects contained in the collection to a stream.
     * 
     * @param stream The stream to which the extent is written.
     * @param objects The objects to be written
     * @param xmiVersion The version of XMI, e.g. "1.2" or "2.0"
     * @throws IOException
     */
    public void write( OutputStream stream, Collection objects, String xmiVersion ) throws IOException;
}
