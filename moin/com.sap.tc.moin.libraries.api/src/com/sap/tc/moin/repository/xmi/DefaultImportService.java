package com.sap.tc.moin.repository.xmi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;

/**
 * This is the default implementation of the {@link ImportService} interface. It
 * provides the following behaviour:
 * <ul>
 * <li><b>URI-to-InputStream resolving: </b> Only URIs with the scheme
 * <code>file</code> are handled (resulting in FileInputStreams), as well as the
 * following common case: there are multiple inter-linked XMI documents to
 * import, one of them being the main document, and any number of additional XMI
 * documents, directly or indirectly linked to the main document via MOF
 * imports. The additional documents are either stored in the same filesystem
 * folder as the main document, or in subfolders of the main document folder.
 * This file system structure is usually chosen by the XMI export interface of
 * modeling tools, and manifests itself in relative URIs like
 * <code>href="otherFile.xml|12345ABCDE"</code>.</li>
 * <li><b>Partition mapping: </b> No mapping of XMI documents to model
 * partitions (and as a consequence, no merge) is performed, i.e. each created
 * model element will be assigned to the connection's transient partition.
 * </ul>
 */
public class DefaultImportService implements ImportService {

    private final boolean myMofMode;

    /**
     * @param importMof
     */
    public DefaultImportService( boolean importMof ) {

        this.myMofMode = importMof;
    }

    /**
     * @return <code>true</code> if the import is done for MOF
     */
    public boolean isMofMode( ) {

        return this.myMofMode;
    }

    public InputStream createInputStream( String uriOfResource ) throws IOException {

        try {
            URI uri = new URI( uriOfResource );
            String scheme = uri.getScheme( );
            if ( scheme != null && !scheme.equals( "file" ) ) { //$NON-NLS-1$
                throw new MoinUnsupportedOperationException( XmiMessages.UNSUPPORTEDURISCHEME, scheme );
                // TODO use a wrapped exception
            }
            return new FileInputStream( new File( uri ) );
        } catch ( Exception ex ) {
            throw new IOException( ex.getLocalizedMessage( ) );
        }
    }

    public InputStream createInputStreamForMappingTable( String uriOfResource ) {

        // No partition mapping => no mapping table.
        return null;
    }

    public OutputStream createOutputStreamForMappingTable( String uriOfResource ) {

        // No partition mapping => no mapping table.
        return null;
    }

    public String resolveUri( String uriToResolve, String mainDocumentUri ) {

        try {
            URI base = new URI( mainDocumentUri );
            URI resolved = base.resolve( uriToResolve );
            return resolved.toString( );
        } catch ( URISyntaxException ex ) {
            throw new RuntimeException( ex );
        }
    }

    public PRI getMappedPartition( String uriOfXmiDocument ) {

        // No partition mapping.
        return null;
    }

    public boolean isSource( String uriOfXmiDocument ) {

        // No partition mapping => import into transient partition => true
        return true;
    }

    public String getMappingId( String uriOfXmiDocument, XmiElement xmiElement ) {

        // By default we assume that a MOF metamodel is to be imported.
        // Therefore, we compute the XmiElement's qualified name and use it as
        // the mapping ID.
        StringBuffer buf = new StringBuffer( );
        buf.insert( 0, xmiElement.getAttributeValuesByName( ).get( "name" ) ); //$NON-NLS-1$
        XmiElement parent = xmiElement.getParentElement( );
        while ( parent != null ) {
            buf.insert( 0, '.' );
            buf.insert( 0, parent.getAttributeValuesByName( ).get( "name" ) ); //$NON-NLS-1$
            parent = parent.getParentElement( );
        }
        return buf.toString( );
    }

    public String getMappingId( RefObject modelElement ) {

        if ( modelElement instanceof ModelElement ) {
            StringBuffer buf = new StringBuffer( );
            for ( Iterator<String> it = ( (ModelElement) modelElement ).getQualifiedName( ).iterator( ); it.hasNext( ); ) {
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
}