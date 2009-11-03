package com.sap.tc.moin.repository.core.xmi.writer;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.messages.core.XMI;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.xmi.XmiReferenceProvider;
import com.sap.tc.moin.repository.xmi.XmiWriter;

/**
 * This class provides an implementation of the {@link com.sap.tc.moin.repository.mmi.xmi.XmiWriter
 * XmiWriter} interface defined in the JMI 1.0 specification. In addition to the
 * two <code>write</code> methods defined in the standard interface, it offers
 * an additional method for writing
 * {@link com.sap.tc.moin.repository.ModelPartition model partitions}, and
 * provides accessors and mutators for configuration options affecting the
 * serialization process.
 * <p>
 * This class acts as a proxy for the concrete implementations of the different
 * XMI versions: the map {@link #implementations} is initialized with instances
 * of XmiWriters for each supported XMI version, all of which have to implement
 * the internal interface
 * {@link com.sap.tc.moin.repository.core.xmi.writer.XmiWriterInternal}.
 * Incoming <code>write</code> calls are then forwarded to the correct
 * implementation based on the passed value of the <code>xmiVersion</code>
 * parameter.
 */
public class XmiWriterImpl implements XmiWriter {

    /**
     * This configuration option can be used for setting the encoding used
     * during the serialization process.
     * <p>
     * By default,
     * {@link com.sap.tc.moin.repository.xmi.XmiWriter#DEFAULT_ENCODING} is
     * used.
     */
    private String encoding;

    /**
     * This configuration option controls whether the
     * <code>&lt;XMI.header&gt;</code> should be written. As of XMI 1.2, writing
     * of the header is optional.
     * <p>
     * The default is <code>true</code>.
     */
    private boolean useHeader;

    /**
     * This configuration option controls whether to use the
     * <code>xmi.namespace</code> tags attached to the model packages or not. If
     * set to <code>true</code>, all existing <code>xmi.namespace</code> tags
     * will be used to prefix the model elements. If set to <code>false</code>,
     * the qualified names of the model elements will be used for the XMI
     * element names.
     * <p>
     * The default is <code>true</code>.
     */
    private boolean useNamespaces;

    /**
     * This configuration option controls whether to add the optional
     * <code>timestamp</code> attribute to the <code>&lt;XMI&gt;</code> root
     * element. If set to <code>true</code>, the attribute will be filled with
     * the current date and time in milliseconds.
     * <p>
     * The default is <code>false</code>.
     */
    private boolean useTimestamp;

    /**
     * This configuration option controls whether to indent the XMI document
     * with TAB characters or not. Note that while this option makes the
     * resulting file more readable, it will result in substantially bigger
     * files.
     * <p>
     * The default is <code>false</code>.
     */
    private boolean useIndentation;


    /**
     * @see #setReferenceProvider(XmiReferenceProvider)
     */
    private XmiReferenceProvider referenceProvider;

    /**
     * The map of all available XmiWriter implementations, keyed by their XMI
     * version String (e.g. "1.2").
     */
    private Map<String /* xmiVersion */, XmiWriterInternal> implementations;

    /**
     * Creates a new XmiWriter.
     * 
     * @param connectionImpl
     */
    public XmiWriterImpl( CoreSession session ) {

        // Initialize the configuration options.
        encoding = DEFAULT_ENCODING;
        useHeader = true;
        useNamespaces = true;
        useTimestamp = false;
        referenceProvider = null;
        // Initialize the map of available implementations.
        implementations = new HashMap<String, XmiWriterInternal>( );
        implementations.put( "1.2", new XmiWriter12Impl( session, this ) ); //$NON-NLS-1$
    }

    public synchronized void setEncoding( String encoding ) {

        if ( encoding == null || encoding.equals( "" ) ) { //$NON-NLS-1$
            throw new MoinIllegalArgumentException( XMI.ENCODINGNOTNULLOREMPTY );
        }
        this.encoding = encoding;
    }

    public synchronized String getEncoding( ) {

        return encoding;
    }

    public synchronized void setUseNamespaces( boolean useNamespaces ) {

        this.useNamespaces = useNamespaces;
    }

    public synchronized boolean getUseNamespaces( ) {

        return useNamespaces;
    }

    public synchronized void setUseTimestamp( boolean useTimestamps ) {

        this.useTimestamp = useTimestamps;
    }

    public synchronized boolean getUseTimestamp( ) {

        return useTimestamp;
    }

    public synchronized void setUseIndentation( boolean useIndentation ) {

        this.useIndentation = useIndentation;
    }

    public synchronized boolean getUseIndentation( ) {

        return useIndentation;
    }

    public synchronized void setUseHeader( boolean useHeader ) {

        this.useHeader = useHeader;
    }

    public synchronized boolean getUseHeader( ) {

        return useHeader;
    }



    public synchronized void setReferenceProvider( XmiReferenceProvider provider ) {

        referenceProvider = provider;
    }

    public synchronized XmiReferenceProvider getReferenceProvider( ) {

        return referenceProvider;
    }

    @SuppressWarnings( "unchecked" )
    public void write( OutputStream os, Collection objects, String xmiVersion ) throws IOException {

        Set _objects = new LinkedHashSet( );
        for ( Iterator it = objects.iterator( ); it.hasNext( ); ) {
            Object obj = it.next( );
            if ( obj instanceof Wrapper ) {
                _objects.add( ( (Wrapper) obj ).unwrap( ) );
            } else {
                _objects.add( obj );
            }
        }
        getXmiWriter( xmiVersion ).write( os, _objects );
    }

    public void write( OutputStream os, RefPackage extent, String xmiVersion ) throws IOException {

        throw new MoinUnsupportedOperationException( XMI.EXTENTWRITINGNOTSUPPORTED );
        // TODO unwrap the RefPackage
        // getXmiWriter(xmiVersion).write(os, extent);
    }

    public void write( OutputStream os, ModelPartition partition, String xmiVersion ) throws IOException {

        ModelPartition _partition = partition;
        if ( partition instanceof Wrapper ) {
            _partition = ( (Wrapper<CoreModelPartition>) partition ).unwrap( );
        }
        getXmiWriter( xmiVersion ).write( os, _partition );
    }

    private XmiWriterInternal getXmiWriter( String xmiVersion ) {

        if ( xmiVersion == null || xmiVersion.equals( "" ) ) { //$NON-NLS-1$
            throw new MoinIllegalArgumentException( XMI.MOIN_XMI_1006 );
        }
        XmiWriterInternal writer = implementations.get( xmiVersion );
        if ( writer == null ) {
            throw new MoinIllegalArgumentException( XMI.MOIN_XMI_1004, xmiVersion );
        }
        return writer;
    }
}
