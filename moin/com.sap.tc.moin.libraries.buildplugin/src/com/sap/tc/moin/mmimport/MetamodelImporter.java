package com.sap.tc.moin.mmimport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.xmi.MalformedXMIException;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalNullArgumentException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.xmi.DefaultImportService;
import com.sap.tc.moin.repository.xmi.XmiReader;

/**
 * Utility class for importing a MOF metamodel given as a set of XMI files into
 * the MOIN repository. As a prerequisite for using this class, a valid
 * {@link com.sap.tc.moin.repository.core.Connection} has to be provided.
 * Furthermore, a {@link java.util.Properties} instance defining the mapping
 * between XMI documents and
 * {@link com.sap.tc.moin.repository.core.ModelPartition model partitions} has
 * to be specified. The properties contained therein must be structured as
 * follows:
 * <p>
 * For every XMI document participating in the import there needs to be an entry
 * (note that this also includes XMI documents from foreign metamodels that were
 * re-used in the current metamodel):
 * <p>
 * <code>&lt;XMI_file_name_w/o_path&gt; = &lt;MRI_of_mapped_partition&gt;,&lt;isSource&gt;</code>
 * <p>
 * The value of the <code>isSource</code> option may be either <code>true</code>
 * or <code>false</code>. A value of <code>true</code> means that the
 * corresponding XMI document is "active" in a sense that new model elements for
 * the contained XMI elements will be created (or, if the mapped model partition
 * already exists, a merge of the content of the XMI document and the mapped
 * partition will be performed). On the other hand, a value of
 * <code>false</code> indicates that the XMI document is "passive" in the
 * metamodel, i.e. it only exists because of the re-use of another metamodel.
 * The importer will only load the mapped partition for this XMI document, but
 * will never modify it.
 * <p>
 * An example of a metamodel re-using the <code>PrimitiveTypes</code> metamodel
 * might be:
 * <p>
 * <code>MyMetamodel.xml=PF:DCs/sap.com/tc~moin~testmetamodel/MyMetamodel,true</code>
 * <br>
 * <code>PrimitiveTypes.xml=PF:DCs/sap.com/tc~moin~mof_1.4/PrimitiveTypes,false
 * </code>
 * <p>
 * Note that this class does not perform a
 * {@link com.sap.tc.moin.repository.core.Connection#save()}.
 */
public class MetamodelImporter {

    /**
     * Performs the metamodel import of the main XMI document defined by the
     * given file.
     * 
     * @param moin The {@link Moin} instance (needed for creation of {@link MRI
     * MRIs}).
     * @param connection The {@link Connection} used by the importer to access
     * the MOIN repository.
     * @param mainXmiDocument The main XMI document of the metamodel to be
     * imported. Note that all dependent XMI files are determined automatically.
     * @param configuration The {@link Properties} instance that defines the
     * mapping between XMI files and
     * {@link com.sap.tc.moin.repository.core.ModelPartition model partitions}.
     * @return The set of all model partitions for which the corresponding XMI
     * document is flagged as "isSource=true" is returned.
     * @throws IOException
     * @throws MalformedXMIException
     */
    public static Collection<ModelPartition> run( Moin moin, Connection connection, File mainXmiDocument, Properties configuration, boolean mofMode ) throws IOException, MalformedXMIException {

        MetamodelImportService mis = new MetamodelImportService( connection, moin, configuration, mofMode );

        // Perform the metamodel import.
        String uri = mainXmiDocument.toURI( ).toString( );
        InputStream stream = null;
        try {
            stream = new FileInputStream( mainXmiDocument );

            return run( connection, mis, stream, uri );
        } finally {
            // always make sure to close opened streams
            if ( stream != null ) {
                try {
                    stream.close( );
                } catch ( IOException e ) {
                    // $JL-EXC$ ignore if stream cannot be closed
                }
            }
        }
    }

    /**
     * Performs the metamodel import of the main XMI document defined by the
     * given URL. Supported URL schemes are <em>file</em> and <em>jar:file</em>.
     * 
     * @param moin The {@link Moin} instance (needed for creation of {@link MRI
     * MRIs}).
     * @param connection The {@link Connection} used by the importer to access
     * the MOIN repository.
     * @param mainXmiDocumentUrl The URL of the main XMI document of the
     * metamodel to be imported. Note that all dependent XMI files are
     * determined automatically.
     * @param configuration The {@link Properties} instance that defines the
     * mapping between XMI files and
     * {@link com.sap.tc.moin.repository.core.ModelPartition model partitions}.
     * @return The set of all model partitions for which the corresponding XMI
     * document is flagged as "isSource=true" is returned.
     * @throws IOException
     * @throws URISyntaxException
     * @throws MalformedXMIException
     */
    public static Collection<ModelPartition> run( Moin moin, Connection connection, URL mainXmiDocumentUrl, Properties configuration, boolean mofMode ) throws IOException, MalformedXMIException, URISyntaxException {

        // check URL scheme
        String urlProtocol = mainXmiDocumentUrl.getProtocol( );
        if ( "file".equals( urlProtocol ) ) { //$NON-NLS-1$
            // call file based import
            return run( moin, connection, urlToFile( mainXmiDocumentUrl ), configuration, mofMode );
        } else if ( "jar".equals( urlProtocol ) ) { //$NON-NLS-1$

            // extract the jar-file part from the entry part
            String path = mainXmiDocumentUrl.getPath( );
            String[] tokens = path.split( "!/" ); //$NON-NLS-1$
            if ( tokens.length < 2 ) {
                throw new MoinIllegalArgumentException( MmImportMessages.NOENTRYFORMAINDOCUMENT, mainXmiDocumentUrl );
            } else if ( tokens.length > 2 ) {
                // TODO: check if this can happen at all (or if ! is escaped in
                // URL).
                throw new MoinIllegalArgumentException( MmImportMessages.JARFILEAAMBIGUOUSINURL, mainXmiDocumentUrl );
            }
            // the first token is the file, the second the main entry
            File jarFileFile = urlToFile( tokens[0] );
            if ( !jarFileFile.exists( ) ) {
                throw new FileNotFoundException( MmImportMessages.METAMODELJARFILENOTFOUND.toString( ) + jarFileFile );
            }
            String mainDocumentEntryName = tokens[1];
            JarFile jarFile = null;
            try {

                // create a JAR file - this opens already an input stream for it
                jarFile = new JarFile( jarFileFile );

                // create a Jar import service for this file
                JarMetaModelImportService jarImportService = new JarMetaModelImportService( connection, moin, configuration, jarFile, mofMode );

                // get the stream for the main document from the import service
                // - the second token should be the entry
                // name
                // the stream for the entry is closed when the jar file is
                // closed
                InputStream mainDocumentInputStream = jarImportService.createInputStream( mainDocumentEntryName );

                // do the mm import
                return run( connection, jarImportService, mainDocumentInputStream, mainDocumentEntryName );
            } finally {
                // always make sure to close opened streams
                if ( jarFile != null ) {
                    try {
                        jarFile.close( );
                    } catch ( IOException e ) {
                        // $JL-EXC$ ignore if stream cannot be closed
                    }
                }
            }
        } else {
            throw new MoinUnsupportedOperationException( MmImportMessages.UNSUPPORTEDURLPROTOCOLFORMETAMODELIMPORTER, mainXmiDocumentUrl );
        }
    }

    /**
     * Internal run method that uses the specified connection, import service,
     * stream and URI for the MM import. The stream has to be closed by the
     * caller.
     * 
     * @param connection
     * @param mis
     * @param stream
     * @param uri
     * @return the imported partitions
     * @throws IOException
     * @throws MalformedXMIException
     */
    private static Collection<ModelPartition> run( Connection connection, MetamodelImportService mis, InputStream stream, String uri ) throws IOException, MalformedXMIException {

        // Get the XmiReader from the connection.
        XmiReader xmiReader = connection.getXmiReader( );
        xmiReader.setImportService( mis );
        RefPackage mofExtent = connection.getPackage( null, "MOIN" ); //$NON-NLS-1$
        xmiReader.read( stream, uri, mofExtent );
        Collection<ModelPartition> sourcePartitions = new LinkedHashSet<ModelPartition>( );
        for ( Iterator<PRI> it = mis.getSourcePRIs( ).iterator( ); it.hasNext( ); ) {
            PRI pri = it.next( );
            ModelPartition partition = connection.getPartition( pri );
            if ( partition != null ) {
                sourcePartitions.add( partition );
            }
        }
        return sourcePartitions;
    }

    private static class MetamodelImportService extends DefaultImportService {

        private Moin moin;

        private CoreConnection connection;

        private HashMap<String, String[]> mappingInfos;

        private MetamodelImportService( Connection connection, Moin moin, Properties configuration, boolean mofMode ) {

            super( mofMode );
            if ( connection instanceof CoreConnection ) {
                this.connection = (CoreConnection) connection;
            } else {
                this.connection = ( (Wrapper<CoreConnection>) connection ).unwrap( );
            }
            this.moin = moin;
            // Store the configuration info in the mappingInfos map.
            this.mappingInfos = new HashMap<String, String[]>( );
            for ( Iterator it = configuration.keySet( ).iterator( ); it.hasNext( ); ) {
                String key = (String) it.next( );
                String value = configuration.getProperty( key );
                String[] options = value.split( "," ); //$NON-NLS-1$
                // Perform a simple sanity check of the options.
                if ( options.length != 2 && options.length != 3 ) {
                    throw new MoinLocalizedBaseRuntimeException( MmImportMessages.METAMODELXMIIMPORTERCONFIGURATIONERRORILLEGALNUMBEROFTOKENS, key );
                }
                if ( !options[1].equalsIgnoreCase( "true" ) && !options[1].equalsIgnoreCase( "false" ) ) { //$NON-NLS-1$ //$NON-NLS-2$
                    throw new MoinLocalizedBaseRuntimeException( MmImportMessages.METAMODELXMIIMPORTERCONFIGURATIONERRORSECONDOPTIONMUSTBETRUEORFALSE, key );
                }
                this.mappingInfos.put( key, options );
            }
        }

        @Override
        public InputStream createInputStreamForMappingTable( String uriOfXmiDocument ) {

            try {
                String[] values = getValues( uriOfXmiDocument );
                if ( values.length == 2 ) {
                    return null;
                } else {
                    return new FileInputStream( values[2] );
                }
            } catch ( FileNotFoundException e ) {
                return null;
            }
        }

        @Override
        public OutputStream createOutputStreamForMappingTable( String uriOfXmiDocument ) {

            try {
                String[] values = getValues( uriOfXmiDocument );
                if ( values.length == 2 ) {
                    return null;
                } else {
                    return new FileOutputStream( values[2] );
                }
            } catch ( FileNotFoundException e ) {
                return null;
            }
        }

        @Override
        public PRI getMappedPartition( String uriOfXmiDocument ) {

            String[] values = getValues( uriOfXmiDocument );
            return this.moin.createPri( values[0] );
        }

        @Override
        public boolean isSource( String uriOfXmiDocument ) {

            String[] values = getValues( uriOfXmiDocument );
            return Boolean.valueOf( values[1] ).booleanValue( );
        }

        @Override
        public String getMappingId( RefObject modelElement ) {

            if ( modelElement instanceof ModelElementInternal ) {
                StringBuffer buf = new StringBuffer( );
                for ( Iterator<String> it = ( (ModelElementInternal) modelElement ).getQualifiedName( connection ).iterator( ); it.hasNext( ); ) {
                    String segment = it.next( );
                    buf.append( segment );
                    if ( it.hasNext( ) ) {
                        buf.append( '.' );
                    }
                }
                return buf.toString( );
            }
            return modelElement.refMofId( );
        }

        /**
         * Returns the set of all partition PRIs of all XMI documents that are
         * flagged as isSource=true.
         * 
         * @return the PRIs
         */
        public Collection<PRI> getSourcePRIs( ) {

            Collection<PRI> sourcePartitionPRIs = new LinkedHashSet<PRI>( );
            for ( Iterator<String[]> it = this.mappingInfos.values( ).iterator( ); it.hasNext( ); ) {
                String[] values = it.next( );
                boolean isSource = Boolean.valueOf( values[1] ).booleanValue( );
                if ( isSource ) {
                    sourcePartitionPRIs.add( this.moin.createPri( values[0] ) );
                }
            }
            return sourcePartitionPRIs;
        }

        private String[] getValues( String uriOfXmiDocument ) {

            String fileName = uriOfXmiDocument.substring( uriOfXmiDocument.lastIndexOf( '/' ) + 1 );
            String[] values = this.mappingInfos.get( fileName );
            if ( values == null ) {
                throw new MoinLocalizedBaseRuntimeException( MmImportMessages.MISSINGMAPPINGINFOFORFILE, fileName );
            }
            return values;
        }
    }

    private static class JarMetaModelImportService extends MetamodelImportService {

        // the jar-file from which the XMIs are read
        private JarFile jarFile = null;

        JarMetaModelImportService( Connection connection, Moin moin, Properties configuration, JarFile jarFile, boolean mofMode ) {

            super( connection, moin, configuration, mofMode );
            this.jarFile = jarFile;
        }

        /*
         * (non-Javadoc) Overwrite the createInputStream method for reading the
         * resources from the JAR file.
         * @seecom.sap.tc.moin.repository.xmi.reader.DefaultImportService#
         * createInputStream(java.lang.String)
         */
        @Override
        public InputStream createInputStream( String uriOfResource ) throws IOException {

            // for now, we expect that the URI is relative to the JAR, i.e.
            // specifies a JAR entry
            // TODO: consider absolute uris

            try {
                ZipEntry entry = this.jarFile.getEntry( uriOfResource );
                if ( entry == null ) {
                    // TODO: think about a separate MoinIOException ... and then localize 
                    throw new IOException( "Cannot resolve resource URI \"" + uriOfResource + "\": no such entry in JAR file " + this.jarFile ); //$NON-NLS-1$ //$NON-NLS-2$
                }

                return this.jarFile.getInputStream( entry );
            } catch ( IOException e ) {
                throw new IOException( e.getLocalizedMessage( ) );
            }
        }
    }

    /**
     * Creates a file object for the specified URL String. Although the
     * java.io.File class provides a constructor with a URI argument, we have to
     * code this ourselves.
     * 
     * @param fileUrl
     * @return
     */
    private static File urlToFile( String fileUrlString ) throws MalformedURLException {

        if ( fileUrlString == null ) {
            throw new MoinIllegalNullArgumentException( "fileUrl" ); //$NON-NLS-1$
        }

        // construct a URL for the sorting and encode if necessary (e.g. for UTF
        // characters...)
        URL fileUrl = new URL( Utilities.getUtilities( ).encodeAsURI( fileUrlString ) );
        return urlToFile( fileUrl );
    }

    /**
     * Creates a file object for the specified URL. Although the java.io.File
     * class provides a constructor with a URI argument, we have to code this
     * ourselves.
     * 
     * @param fileUrl
     * @return
     */
    private static File urlToFile( URL fileUrl ) throws MalformedURLException {

        String protocol = fileUrl.getProtocol( );
        if ( protocol != null && !protocol.equals( "file" ) ) { //$NON-NLS-1$
            throw new MoinIllegalArgumentException( MmImportMessages.WRONGPROTOCOLINURL, fileUrl );
        }

        // construct the file from the URL path
        File file = new File( fileUrl.getPath( ) );

        // check if a host is set - in this case, we construct a windows UNC
        // name by setting \\host as prefix
        String host = fileUrl.getHost( );
        if ( host != null && host.length( ) > 0 ) {
            file = new File( "\\\\" + host, file.toString( ) ); //$NON-NLS-1$
        }

        return file;
    }
}
