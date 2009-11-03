package com.sap.tc.moin.repository.runtimehost.deployment;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.sap.tc.moin.repository.runtimehost.RuntimehostMessages;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * Base parser implementation. Provides common parser functionality.
 * 
 * <pre>
 * Ideas:
 * - simplified attribute access 
 * - simplified text access
 * </pre>
 * 
 * @author d026715
 */
public abstract class RegistrationRecordBase {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_RUNTIME_HOST, MoinLocationEnum.MOIN_RUNTIMHOST, RegistrationRecordBase.class );

    protected static final String SCHEMA_LOCATION = "schema/"; //$NON-NLS-1$

    public static String RESOURCE_NAME;

    protected Collection<NodeVisitor> visitors = new HashSet<NodeVisitor>( );

    private boolean initialized = false;

    protected Schema schema = null;

    protected abstract void initVisitors( );

    protected abstract void initSchema( );

    public void setSchemaValidation( InputStream schemaFile ) {

        SchemaFactory schemaFactory = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
        try {
            schema = schemaFactory.newSchema( new StreamSource( schemaFile ) );
        } catch ( SAXException e ) {
            log.trace( e, MoinSeverity.ERROR, RuntimehostMessages.REGISTRATION_SCHEMA_ERROR, schemaFile );
            throw new MoinDeploymentException( e, RuntimehostMessages.REGISTRATION_SCHEMA_ERROR, schemaFile );
        }
    }

    public void parse( InputStream stream ) throws SAXException, IOException, ParserConfigurationException {

        if ( !initialized ) {
            this.initVisitors( );
            this.initSchema( );
            this.initialized = true;
        }

        // initialize document builder factory with schema
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance( );
        documentBuilderFactory.setNamespaceAware( true );

        if ( schema != null ) {
            documentBuilderFactory.setSchema( schema );
        }

        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder( );
        documentBuilder.setErrorHandler( new RegistrationParserErrorHandler( ) );

        // parse registration
        Document document = documentBuilder.parse( stream );

        this.traverseNode( document );
    }

    protected void traverseNode( Node node ) {

        List<String> path = new ArrayList<String>( 10 );
        this.traverseNode( node, path );
    }

    private void traverseNode( Node node, List<String> path ) {

        String[] tags = new String[path.size( )];
        path.toArray( tags );
        boolean stop = this.handleNode( tags, node );

        if ( !stop ) {
            NodeList childNodes = node.getChildNodes( );

            for ( int i = 0; i < childNodes.getLength( ); i++ ) {
                Node item = childNodes.item( i );
                path.add( item.getNodeName( ) );
                this.traverseNode( item, path );
                path.remove( path.size( ) - 1 );
            }
        }
    }

    private boolean handleNode( String[] tags, Node node ) {

        for ( NodeVisitor visitor : this.visitors ) {
            if ( containsTags( visitor.isInterestedIn( ), tags ) ) {
                return visitor.handleNode( tags, node );
            }
        }
        return false;
    }

    private boolean containsTags( String[][] visitorsTags, String[] foundTags ) {

        for ( String[] tags : visitorsTags ) {
            if ( Arrays.equals( tags, foundTags ) ) {
                return true;
            }
        }
        return false;
    }

    protected String getAttribute( String name, Node node ) {

        Node attribute = node.getAttributes( ).getNamedItem( name );
        if ( attribute != null ) {
            return attribute.getNodeValue( );
        }
        return null;
    }

    protected String getTextContent( Node node ) {

        if ( node.getChildNodes( ).getLength( ) > 0 ) {
            Node childNode = node.getChildNodes( ).item( 0 );
            return childNode.getNodeValue( );
        }
        return null;
    }

    public interface NodeVisitor {

        /**
         * Returns the tags that the visitor is interested in.
         * 
         * @return
         */
        String[][] isInterestedIn( );

        /**
         * Handles the DOM node.
         * 
         * @param fullPath
         * @param node
         * @return true if the traversal can be stopped here
         */
        boolean handleNode( String[] fullPath, Node node );
    }

    static class RegistrationParserErrorHandler implements ErrorHandler {

        public void error( SAXParseException exception ) throws SAXException {

            log.trace( exception, MoinSeverity.ERROR, RuntimehostMessages.REGISTRATION_FILE_CONTENT_ERROR );
            throw exception;
        }

        public void fatalError( SAXParseException exception ) throws SAXException {

            log.trace( exception, MoinSeverity.FATAL, RuntimehostMessages.REGISTRATION_FILE_CONTENT_ERROR );
            throw exception;

        }

        public void warning( SAXParseException exception ) throws SAXException {

            log.trace( exception, MoinSeverity.WARNING, RuntimehostMessages.REGISTRATION_FILE_CONTENT_ERROR );

        }

    }

}
