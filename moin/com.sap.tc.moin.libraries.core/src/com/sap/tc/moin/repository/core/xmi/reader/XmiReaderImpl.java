package com.sap.tc.moin.repository.core.xmi.reader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.xmi.MalformedXMIException;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.xmi.reader.parser.ParserResult;
import com.sap.tc.moin.repository.core.xmi.reader.parser.XmiParser;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalNullArgumentException;
import com.sap.tc.moin.repository.messages.core.XMI;
import com.sap.tc.moin.repository.spi.core.SpiWorkspace;
import com.sap.tc.moin.repository.xmi.DefaultImportService;
import com.sap.tc.moin.repository.xmi.ImportService;
import com.sap.tc.moin.repository.xmi.XmiReader;

/**
 * This class provides an implementation of the {@link com.sap.tc.moin.repository.mmi.xmi.XmiReader}
 * interface as defined in the JMI 1.0 specification. In addition to the two
 * <code>read</code> methods defined in that interface, it offers additional
 * methods for reading {@link com.sap.tc.moin.repository.ModelPartition model
 * partitions}, and for setting configuration options affecting the
 * deserialization process.
 * <p>
 * Each instance of this class is assigned to a
 * {@link com.sap.tc.moin.repository.core.Workspace workspace} which has to be
 * passed as a constructor parameter and cannot be changed later on. This
 * workspace is used for loading or adding model elements and links during a
 * <code>read</code> operation.
 * <p>
 * As a prerequisite for the correct functioning of the XmiReader, all
 * metamodels of all model elements in the XMI document(s) to be read have to be
 * provided as input to the <code>read</code> methods, via the
 * <code>extent</code> parameter of type {@link com.sap.tc.moin.repository.mmi.reflect.RefPackage}.
 * Any model element whose metamodel is not available in this package extent
 * will cause the XmiReader to fail.
 * <p>
 * Depending on which of the methods are called, this implementation always
 * operates in one of two modes: <em>import mode</em> or <em>partition mode</em>.
 * <ul>
 * <li><b>Import mode: </b> This mode is triggered by calls to
 * {@link #read(String, RefPackage)} or
 * {@link #read(InputStream, String, RefPackage)}, and is used to add external
 * (third-party) models or metamodels to the MOIN repository. An important
 * feature of the import mode is the <em>incremental import</em> functionality:
 * if a model or metamodel is imported a second time, the XmiReader can be
 * configured to perform a merge of the previously imported model elements with
 * the current content of the XMI document(s) (see also:
 * {@link com.sap.tc.moin.repository.xmi.ImportService}). In import mode, model
 * element and links are <b>created </b> using normal JMI calls. In particular
 * this means that each model element receives a new MOF-ID, constraint
 * verifications are performed and change events are fired.</li>
 * <li><b>Partition mode: </b> This mode is triggered by calls to
 * {@link #read(InputStream, ModelPartition, RefPackage)}. In partition mode,
 * model elements and links are merely <b>loaded </b> from an existing
 * {@link com.sap.tc.moin.repository.ModelPartition}, meaning that each model
 * element keeps its MOF-ID, no constraint verifications are performed and no
 * change events are fired.</li>
 * </ul>
 * <p>
 * This implementation is thread-safe. While multiple threads can use the same
 * XmiReader instance for the parallel parsing of XMI documents, the threads are
 * synchronized on the owning {@link com.sap.tc.moin.repository.core.Workspace}
 * instance when it comes to updating the repository.
 * <p>
 * If an exceptional situation occurs in the middle of a <code>read</code>
 * operation, a rollback of all modifications up to that moment is performed.
 * Thus the caller can be sure that the repository is the same state as before.
 * <p>
 * This XmiReader implementation is able to deserialize documents conforming to
 * the XMI 1.0, XMI 1.1 and XMI 1.2 standards.
 */
public class XmiReaderImpl implements XmiReader {


    /**
     * The workspace that this XmiReader instance is operating on.
     */
    private Workspace workspace;

    /**
     * The {@link ImportService} that is used in <em>import mode</em>.
     */
    private ImportService importService;

    private final CoreConnection connection;

    /**
     * Creates a new XmiReader that is assigned to the given workspace. All
     * instances and links created during the deserialization process will be
     * loaded into or added to that workspace.
     * 
     * @param connectionImpl
     * @param ws The Workspace that this XmiReader instance is operating on.
     */
    public XmiReaderImpl( CoreConnection connection, Workspace ws ) {

        this.connection = connection;
        // Check the input parameter.
        checkWorkspace( ws );
        workspace = ws;
        // Initialize the configuration options.
        importService = new DefaultImportService( false );
    }

    /**
     * Returns the workspace that this XmiReader instance is operating on.
     */
    public SpiWorkspace getWorkspace( ) {

        return workspace;
    }

    public synchronized void setImportService( ImportService impService ) {

        importService = impService;
    }

    public synchronized ImportService getImportService( ) {

        return importService;
    }

    /**
     * Reads an XMI document from the location given by the URI String, using
     * the specified package extent for metamodel lookups.
     * <p>
     * For obtaining the InputStream, the XmiReader will pass the URI to the
     * currently registered {@link com.sap.tc.moin.repository.xmi.ImportService}
     * via
     * {@link com.sap.tc.moin.repository.xmi.ImportService#createInputStream(String)}
     * . An IOException will be thrown if no InputStream could be obtained.
     * <p>
     * The <code>extent</code> parameter must contain a package extent. It is
     * used for metamodel lookups during the read operation, and therefore has
     * to contain all metamodels required for reading the given model partition.
     * Any model element whose metamodel is not available in this package extent
     * will cause the XmiReader to fail.
     * <p>
     * If the operation succeeds, a collection of RefObject instances is
     * returned, which contains - with respect to composition - the outermost
     * objects found in the XMI document. (Note that the XMI specification
     * requires to map composite links to XML element nesting. Thus, the topmost
     * XMI elements in a valid XMI document are always roots of composition
     * hierarchies.)
     * <p>
     * This call switches the XmiReader to what we call <em>import mode</em>.
     * 
     * @param uriOfXmiDocument The String representation of the URI of the XMI
     * document to read.
     * @param extent The package extent used for metamodel lookups.
     * @throws java.io.IOException
     * @throws com.sap.tc.moin.repository.mmi.xmi.MalformedXMIException when the XmiReader is given a
     * malformed <code>&lt;XMI&gt;</code> element
     */
    public Collection<RefObject> read( String uriOfXmiDocument, RefPackage extent ) throws java.io.IOException, com.sap.tc.moin.repository.mmi.xmi.MalformedXMIException {

        // Forward the call to the method taking an array of extents.
        return read( uriOfXmiDocument, new RefPackage[] { extent } );
    }

    /**
     * Reads an XMI document from the location given by the URI String, using
     * the specified array of package extents for metamodel lookups.
     * <p>
     * For obtaining the InputStream, the XmiReader will pass the URI to the
     * currently registered {@link com.sap.tc.moin.repository.xmi.ImportService}
     * via
     * {@link com.sap.tc.moin.repository.xmi.ImportService#createInputStream(String)}
     * . An IOException will be thrown if no InputStream could be obtained.
     * <p>
     * The package extents passed in the <code>extents</code> parameter are used
     * for metamodel lookups during the deserialization, and therefore have to
     * contain all metamodels required for reading the given XMI document(s).
     * Any model element found in the XMI document(s) whose metamodel is not
     * available in one of these package extents will cause the XmiReader to
     * fail.
     * 
     * @param uriOfXmiDocument The String representation of the URI where the
     * XMI document is located.
     * @param extents The array of package extents used for metamodel lookups.
     * @throws java.io.IOException
     * @throws com.sap.tc.moin.repository.mmi.xmi.MalformedXMIException when the XmiReader is given a
     * malformed XMI document
     * @return XMI requires complete composition hierarchies to be stored in one
     * document, from the root element down to all leaves. What is returned by a
     * call to this method is the collection of all such composition roots (i.e.
     * <em>not</em> the collection of <em>all</em> model elements).
     */
    public Collection<RefObject> read( String uriOfXmiDocument, RefPackage[] extents ) throws java.io.IOException, com.sap.tc.moin.repository.mmi.xmi.MalformedXMIException {

        // Check the input parameters.
        checkUri( uriOfXmiDocument );
        checkExtents( extents );
        // Ask the ImportService for the InputStream.
        InputStream stream = getImportService( ).createInputStream( uriOfXmiDocument );
        if ( stream == null ) {
            throw new IOException( XMI.MOIN_XMI_1018.format( new Object[] { uriOfXmiDocument } ) );
        }
        try {
            // Forward the call to the main read method.
            return readInternal( stream, uriOfXmiDocument, extents );
        } finally {
            // Since we opened the InputStream ourselves, close it.
            stream.close( );
        }
    }

    /**
     * Reads an XMI document from the given InputStream, using the specified
     * package extent for metamodel lookups.
     * <p>
     * The <code>uriOfXmiDocument</code> parameter has to contain the URI of the
     * document behind the InputStream, and is used for resolving relative links
     * to other XMI documents.
     * <p>
     * The <code>extent</code> parameter must contain a package extent. It is
     * used for metamodel lookups during the read operation, and therefore has
     * to contain all metamodels required for reading the given model partition.
     * Any model element whose metamodel is not available in this package extent
     * will cause the XmiReader to fail.
     * <p>
     * If the operation succeeds, a collection of RefObject instances is
     * returned, which contains - with respect to composition - the outermost
     * objects found in the document. (Note that the XMI specification requires
     * to map composite links to XML element nesting. Thus, the topmost XMI
     * elements in a valid XMI document are always roots of composition
     * hierarchies.)
     * <p>
     * This call switches the XmiReader to what we call <em>import mode</em>.
     * 
     * @param stream The InputStream containing the XMI document.
     * @param uriOfXmiDocument The URI of the XMI document to read.
     * @param extent The package extent used for metamodel lookups.
     * @throws java.io.IOException
     * @throws com.sap.tc.moin.repository.mmi.xmi.MalformedXMIException when the XmiReader is given a
     * malformed XMI document
     */
    public Collection<RefObject> read( InputStream stream, String uriOfXmiDocument, RefPackage extent ) throws java.io.IOException, com.sap.tc.moin.repository.mmi.xmi.MalformedXMIException {

        // Forward the call to the method taking an array of extents.
        return read( stream, uriOfXmiDocument, new RefPackage[] { extent } );
    }

    /**
     * Reads an XMI document from the given InputStream, using the specified
     * array of package extents for metamodel lookups.
     * <p>
     * The <code>uriOfXmiDocument</code> parameter has to contain the URI of the
     * XMI document behind the InputStream, and is used for resolving relative
     * links to other XMI documents that might be found during parsing.
     * <p>
     * The package extents passed in the <code>extents</code> parameter are used
     * for metamodel lookups during the deserialization, and therefore have to
     * contain all metamodels required for reading the given XMI document(s).
     * Any model element found in the XMI document(s) whose metamodel is not
     * available in one of these package extents will cause the XmiReader to
     * fail.
     * 
     * @param stream The InputStream from which the XMI document is read.
     * @param uriOfXmiDocument The String representation of the URI behind the
     * InputStream.
     * @param extents The array of package extents used for metamodel lookups.
     * @throws java.io.IOException
     * @throws com.sap.tc.moin.repository.mmi.xmi.MalformedXMIException when the XmiReader is given a
     * malformed XMI document
     * @return XMI requires complete composition hierarchies to be stored in one
     * document, from the root element down to all leaves. What is returned by a
     * call to this method is the collection of all such composition roots (i.e.
     * <em>not</em> the collection of <em>all</em> model elements).
     */
    public Collection<RefObject> read( InputStream stream, String uriOfXmiDocument, RefPackage[] extents ) throws java.io.IOException, com.sap.tc.moin.repository.mmi.xmi.MalformedXMIException {

        if ( stream == null ) {
            // No InputStream was given. According to the JMI spec, forward the
            // call to corresponding read method taking the URI String.
            return read( uriOfXmiDocument, extents );
        }
        // Check the input parameters.
        checkUri( uriOfXmiDocument );
        checkExtents( extents );
        // Forward the call to the main read method.
        return readInternal( stream, uriOfXmiDocument, extents );
    }

    /**
     * The main read method, which is called by all public read methods. Both
     * the InputStream and the URI are expected to be non- <code>null</code>. In
     * a first step, all XMI documents are parsed by an instance of
     * {@link XmiParser}, which returns an instance of {@link ParserResult}
     * containing all information found in the XMI documents. In a second step,
     * the repository is updated by an instance of {@link RepositoryService}.
     * Finally, the collection of composition roots found in the XMI documents
     * is returned, as required by the JMI specification.
     */
    private synchronized Collection<RefObject> readInternal( InputStream stream, String uri, RefPackage[] extents ) throws java.io.IOException, com.sap.tc.moin.repository.mmi.xmi.MalformedXMIException {

        // Create the XmiParser. It needs an instance of TypeHelper to be able
        // to resolve the XMI element names.
        TypeHelper typeHelper = new TypeHelper( connection, extents );
        XmiParser parser = new XmiParser( connection.getSession( ), workspace.getWorkspaceSet( ), getImportService( ), uri, typeHelper );
        // Parse the XMI document(s). Any exception during parsing will be
        // passed through to the client, and the
        // XmiReader will terminate leaving the repository content untouched.
        ParserResult parserResult = parser.parse( stream );
        // Parsing was successful. The ParserResult contains all information
        // about model elements and links that were
        // found in the XMI document(s). As the second step, update the
        // repository now. First, create the
        // RepositoryService instance. The concrete RepositoryService
        // implementation is chosen based on the mode in
        // which the XmiReader is operating (partition mode or import mode).
        RepositoryService repService = null;

        // We are in import mode.
        repService = new ImportingRepositoryService( connection, workspace, typeHelper, getImportService( ) );

        // Synchronize all updates on the owning workspace.
        synchronized ( workspace ) {
            try {
                // Update the repository. Any exception results in a rollback.
                return repService.updateRepository( parserResult );
            } catch ( Exception ex ) {
                // Ask the RepositoryService to undo all changes.
                repService.rollbackChanges( );
                throw new MalformedXMIException( ex );
            }
        }
    }

    /**
     * Sanity check for the URI parameter. Tries to create a URI from the given
     * String.
     */
    private void checkUri( String uriOfXmiDocument ) {

        if ( uriOfXmiDocument == null ) {
            throw new MoinIllegalNullArgumentException( "URI" ); //$NON-NLS-1$
        }
        try {
            // Try to create an URI instance from the String.
            new URI( uriOfXmiDocument );
        } catch ( URISyntaxException e ) {
            throw new MoinIllegalArgumentException( e, XMI.MOIN_XMI_1032, uriOfXmiDocument );
        }
    }

    /**
     * Sanity check for the workspace parameter
     */
    private void checkWorkspace( Workspace workspace ) {

        if ( workspace == null ) {
            throw new MoinIllegalNullArgumentException( "workspace" ); //$NON-NLS-1$
        }
    }

    /**
     * Sanity check for the extent parameter
     */
    private void checkExtents( RefPackage[] extents ) {

        for ( int i = 0; i < extents.length; i++ ) {
            if ( extents[i] == null ) {
                throw new MoinIllegalArgumentException( XMI.MOIN_XMI_1021 );
            }
        }
    }



}