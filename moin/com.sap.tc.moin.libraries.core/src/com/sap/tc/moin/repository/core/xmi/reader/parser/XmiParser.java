package com.sap.tc.moin.repository.core.xmi.reader.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.xmi.MalformedXMIException;

import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.xmi.reader.TypeHelper;
import com.sap.tc.moin.repository.core.xmi.reader.XmiReaderImpl;
import com.sap.tc.moin.repository.messages.core.XMI;
import com.sap.tc.moin.repository.xmi.DefaultImportService;
import com.sap.tc.moin.repository.xmi.ImportService;

/**
 * This class encapsulates the complete XMI parsing. It maintains two
 * collections: one for the documents that still need to be parsed (see
 * {@link #waitingURIs}), and one for those that have already been processed
 * (see {@link #processedURIs}). Note that the {@link #waitingURIs} collection
 * may grow dynamically during the parsing, if <code>href</code> attributes
 * pointing to external documents are encountered. For notifying the XmiParser
 * of such an event, the {@link #queueDocument(String, String)} method is
 * provided.
 * <p>
 * The parsing itself is performed by a {@link #saxReader SAX parser}.
 * <p>
 * The data found in the XMI document(s) is collected by an instance of
 * {@link com.sap.tc.moin.repository.core.xmi.reader.parser.XmiContext}, which
 * is accessible by each
 * {@link com.sap.tc.moin.repository.core.xmi.reader.parser.XmiElement}.
 * <p>
 * The only public method {@link #parse(InputStream)} starts the parsing
 * process. After successful completion, an instance of
 * {@link com.sap.tc.moin.repository.core.xmi.reader.parser.ParserResult} is
 * returned, that provides access to all information found in the XMI
 * document(s).
 */
public class XmiParser {

    /**
     * The ImportService of the enclosing {@link XmiReaderImpl}.
     */
    private ImportService importService;

    /**
     * The {@link XmiContext} instance that collects the data.
     */
    private XmiContext context;

    /**
     * The SAX reader used by this XmiContext instance. If multiple files need
     * to be parsed during one <code>read</code> operation, this instance is
     * re-initialized and re-used.
     */
    private SaxReader saxReader;

    /**
     * The URI that was initially passed to one of XmiReader's <code>read</code>
     * methods. This URI is referred to as the <em>main document URI</em>.
     */
    private String mainDocumentUri;

    /**
     * This list contains the URIs of documents that still have to be read in
     * the main loop in {@link #parse(InputStream)}. In partition mode, it
     * always contains exactly one URI, the URI of the model partition to be
     * read. In import mode, the list initially contains one entry as well (the
     * {@link #mainDocumentUri}), but the list can grow dynamically during the
     * import if either <code>&lt;XMI.import&gt;</code> elements or
     * <code>href</code> attributes pointing to external documents are found.
     */
    private List<String> waitingURIs;

    /**
     * This list contains the URIs of all documents that have already been
     * processed, to avoid repeated parsing.
     */
    private List<String> processedURIs;

    /**
     * Creates a new instance of XmiContext and performs one-time
     * initializations of member variables. The constructor is called by
     * {@link XmiReaderImpl} only.
     * 
     * @param mmCache
     */
    public XmiParser( CoreSession session, WorkspaceSet workspaceSet, ImportService impService, String uri, TypeHelper typeHelper ) {

        importService = impService;
        mainDocumentUri = uri;
        // Create the context that collects the data.
        boolean isMofMode = false;
        if ( impService instanceof DefaultImportService ) {
            isMofMode = ( (DefaultImportService) impService ).isMofMode( );
        }
        context = new XmiContext( session, workspaceSet, this, typeHelper, isMofMode );
        // Create the SAX reader.
        saxReader = new SaxReader( context );
        // Initialize the two URI queues.
        waitingURIs = new ArrayList<String>( );
        processedURIs = new ArrayList<String>( );
        // Add the main document to the queue.
        waitingURIs.add( uri );
    }

    /**
     * The main loop parsing all documents in the queue. The queue initially
     * only contains the main document passed to one of the <code>read</code>
     * methods of {@link com.sap.tc.moin.repository.mmi.xmi.XmiReader}, but may grow dynamically
     * during the parse process if <code>href</code> attributes are encountered
     * which point to documents that have not been parsed yet.
     * 
     * @param stream The InputStream of the main document.
     */
    public ParserResult parse( InputStream stream ) throws java.io.IOException, com.sap.tc.moin.repository.mmi.xmi.MalformedXMIException {

        try {
            String currentUri = null;
            // The main loop, running until there are no more URIs in the
            // queue.
            while ( !waitingURIs.isEmpty( ) ) {
                // Get the next URI from the queue.
                currentUri = waitingURIs.get( 0 );
                // Tell the context about the currently processed URI.
                context.setCurrentUri( currentUri );
                // (Re-)Initialize the ReaderSAX instance for the next run.
                saxReader.init( );
                InputStream streamToRead = null;
                // Try to obtain the InputStream.
                if ( currentUri.equals( mainDocumentUri ) ) {
                    // For the main document, the stream supplied by the
                    // XmiReader has to be used.
                    streamToRead = stream;
                } else {
                    // For all other documents, ask the ImportService for the
                    // InputStream. This can only occur in import mode, where
                    // multiple documents may need to be parsed. In partition
                    // mode, we always parse the main document only.
                    streamToRead = importService.createInputStream( currentUri );
                }
                if ( streamToRead == null ) {
                    throw new IOException( XMI.MOIN_XMI_1018.format( new Object[] { currentUri } ) );
                }
                // Parse the stream.
                saxReader.read( streamToRead );
                // Remove the just parsed URI from the queue and add it to
                // the list of already processed URIs, to avoid double
                // processing.
                waitingURIs.remove( currentUri );
                processedURIs.add( currentUri );
            }
            // Inform the XmiContext instance about the end of parsing. The
            // context will perform some post-processing, e.g. check for still
            // unresolved XMI references.
            context.parsingFinished( );
        } catch ( IOException ioe ) {
            // Directly pass on IOExceptions.
            throw ioe;
        } catch ( Exception ex ) {
            // Wrap all other exceptions in a MalformedXMIException.
            throw new MalformedXMIException( ex );
        }
        // All documents were parsed successfully. Ask the context to create
        // a ParserResult instance with the collected data and return it.
        return context.getResult( );
    }

    /**
     * If the given document URI is not in the queue already and has not been
     * processed before, it is added to the queue. Before doing so, the
     * potentially relative URI is resolved against the currently processed URI.
     * <p>
     * This method is called back by the {@link #context} if
     * <ol>
     * <li>the XmiReader operates in <em>import mode</em> and</li>
     * <li>a <code>href</code> attribute pointing to an external document was
     * found.</li>
     * </ol>
     * 
     * @param uriToQueue The URI found in a <code>href</code> attribute.
     * @param currentUri The URI of the XMI document where the <code>href</code>
     * attribute was found.
     */
    void queueDocument( String uriToQueue, String currentUri ) {

        String uri = uriToQueue;
        if ( !context.isLoadingPartition( ) ) {
            // We are in import mode, where "href" attributes to external
            // documents need to be followed. Resolve the uriToQueue
            // against the mainDocumentUri before adding it to the queue.
            uri = importService.resolveUri( uriToQueue, currentUri );
        }
        if ( !waitingURIs.contains( uri ) && !processedURIs.contains( uri ) ) {
            waitingURIs.add( uri );
        }
    }
}