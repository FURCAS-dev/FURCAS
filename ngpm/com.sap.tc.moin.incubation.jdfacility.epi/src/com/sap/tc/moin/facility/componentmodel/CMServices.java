package com.sap.tc.moin.facility.componentmodel;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.sap.tc.moin.facility.primary.riservice.DiResourceIdentifierConstants;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;


public class CMServices {

    private static final String UTF8 = "utf-8"; //$NON-NLS-1$

    private static final String EMPTY_STRING = ""; //$NON-NLS-1$

    private static final String ROOT_TAG = "root"; //$NON-NLS-1$


    // XML part
    public static Element createElement( Node parent, String name ) {

        return (Element) parent.appendChild( parent.getOwnerDocument( ).createElement( name ) );
    }

    public static Element createDocument( String rootName ) throws ParserConfigurationException {

        DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance( );
        DocumentBuilder docBuilder = dbfac.newDocumentBuilder( );
        Document doc = docBuilder.newDocument( );

        Element res = doc.createElement( rootName );
        doc.appendChild( res );
        return res;
    }

    public static String serializeManagerData( CMManager manager ) throws TransformerException, ParserConfigurationException {

        return docToString( manager.serializeElement( createDocument( ROOT_TAG ) ).getOwnerDocument( ) );
    }

    public static String serializeManagerData_Quiet( CMManager manager ) {

        try {
            return serializeManagerData( manager );
        } catch ( TransformerException e ) {
            // $JL-EXC$
        } catch ( ParserConfigurationException e ) {
            // $JL-EXC$
        }
        return EMPTY_STRING;
    }

    public static void saveStringToFile_Quiet( String fileName, String data ) {

        FileOutputStream out = null;
        try {
            out = new FileOutputStream( fileName );
            out.write( data.getBytes( UTF8 ) );
        } catch ( IOException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace( );
        } finally {
            if ( out != null ) {
                try {
                    out.close( );
                } catch ( Exception e ) {
                    // $JL-EXC$
                }
            }
        }

    }

    public static String docToString( Document doc ) throws TransformerException {

        TransformerFactory transfac = TransformerFactory.newInstance( );
        Transformer trans = transfac.newTransformer( );
        trans.setOutputProperty( OutputKeys.INDENT, "yes" ); //$NON-NLS-1$

        StringWriter sw = new StringWriter( );
        StreamResult result = new StreamResult( sw );
        DOMSource source = new DOMSource( doc );
        trans.transform( source, result );
        String xmlString = sw.toString( );
        return xmlString;
    }

    public static void setAttributeIfNotNullOrEmpty( Element element, String name, String value ) {

        if ( value != null && value.length( ) > 0 ) {
            element.setAttribute( name, value );
        }
    }

    public static String getAttribute( Element element, String attName, String defaultValue ) {

        Attr node = element.getAttributeNode( attName );
        return node != null ? node.getValue( ) : defaultValue;
    }

    public static String getAttribute( Element element, String attName ) {

        return getAttribute( element, attName, "" ); //$NON-NLS-1$
    }

    public static Document parseString( String config ) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance( );
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder( );
            return builder.parse( new ByteArrayInputStream( config.getBytes( UTF8 ) ) );
        } catch ( ParserConfigurationException e1 ) {
            // $JL-EXC$
        } catch ( UnsupportedEncodingException e ) {
            // $JL-EXC$
        } catch ( SAXException e ) {
            // $JL-EXC$
        } catch ( IOException e ) {
            // $JL-EXC$
        }
        return null;
    }


    // (De-)Serialization
    public static String serializeCRI( DataAreaDescriptor current, CRI cri ) {

        StringBuilder result = new StringBuilder( );
        if ( !current.equals( cri.getDataAreaDescriptor( ) ) ) {
            result.append( cri.getDataAreaDescriptor( ).getFacilityId( ) );
            result.append( DiResourceIdentifierConstants.FACILITY_INSTANCE_SEPARATOR );
            result.append( cri.getDataAreaDescriptor( ).getDataAreaName( ) );
            result.append( DiResourceIdentifierConstants.FACILITY_PART_SEPARATOR );
        }
        result.append( cri.getContainerName( ) );
        return result.toString( );
    }

    public static CRI deserializeCRI( Moin moin, DataAreaDescriptor descriptor, String criString ) {

        if ( criString == null || criString.equals( EMPTY_STRING ) ) {
            return null;
        }

        int pos = criString.indexOf( DiResourceIdentifierConstants.FACILITY_PART_SEPARATOR );
        ResourceIdentifierFactory factory;

        if ( pos != -1 ) {
            factory = moin.getFacilityById( criString.substring( 0, pos ) ).getRIFactory( );
            return factory.createCri( criString );

        } else {
            factory = moin.getFacilityById( descriptor.getFacilityId( ) ).getRIFactory( );
            return factory.createCri( descriptor.getDataAreaName( ), criString );
        }
    }


    public static String serializeToString( List<String> list, String concat ) {

        StringBuilder sb = new StringBuilder( );
        for ( String entry : list ) {
            if ( sb.length( ) > 0 ) {
                sb.append( concat );
            }
            sb.append( entry );
        }
        return sb.toString( );
    }

    public static String serializeHashMapToString( Map<String, String> input, String sepEntry, String sepKey ) {

        StringBuilder sb = new StringBuilder( 1024 );

        for ( Entry<String, String> entry : input.entrySet( ) ) {
            if ( sb.length( ) > 0 ) {
                sb.append( sepEntry );
            }
            sb.append( entry.getKey( ) );
            sb.append( sepKey );
            sb.append( entry.getValue( ) );
        }
        return sb.toString( );
    }

    public static Map<String, String> deserializeStringToHashMap( String input, String sepEntry, String sepKey ) {

        HashMap<String, String> res = new HashMap<String, String>( );

        for ( String entry : input.split( sepEntry ) ) {
            String[] kv = entry.split( sepKey );
            if ( kv == null || kv.length < 2 ) {
                continue;
            }
            res.put( kv[0], kv[1] );
        }
        return res;
    }

    // Miscellaneous
    public static boolean eq( Object a, Object b ) {

        return a == null ? b == null : a.equals( b );
    }

    public static final String DefaultKeySeparator = "="; //$NON-NLS-1$

    public static final String DefaultListSeparator = ";"; //$NON-NLS-1$

    public static List<String> deserializeStringToList( String input, String separator ) {

        List<String> res = Arrays.asList( input.split( separator ) );
        while ( res.remove( null ) ) {
            // By intention empty
        }
        while ( res.remove( "" ) ) { //$NON-NLS-1$
            // By intention empty
        }
        return res;
    }

    public static List<String> deserializeStringToList( String input ) {

        return deserializeStringToList( input, DefaultListSeparator );
    }

    // Container type support
    private static Map<String, Class<? extends CMContainer>> containerTypes = new ConcurrentHashMap<String, Class<? extends CMContainer>>( );

    private static synchronized void setContainerClass( String name, Class<? extends CMContainer> containerClass ) {

        synchronized ( containerTypes ) {
            containerTypes.put( name, containerClass );
        }
    }

    public synchronized static Class<? extends CMContainer> getContainerClass( String name ) {

        return containerTypes.get( name );
    }

    public synchronized static <T extends CMContainer> void registerContainerType( Class<T> containerClass ) {

        CMName type = containerClass.getAnnotation( CMName.class );
        String name = type != null ? type.value( ) : null;
        if ( name == null ) {
            throw new IllegalStateException( containerClass.getSimpleName( ) + " has no serialization name" ); //$NON-NLS-1$
        }
        setContainerClass( name, containerClass );
    }

    // DataArea type support
    private static Map<String, Class<? extends CMDataArea>> dataAreaTypes = new ConcurrentHashMap<String, Class<? extends CMDataArea>>( );

    private static synchronized void setDataAreaClass( String name, Class<? extends CMDataArea> containerClass ) {

        synchronized ( containerTypes ) {
            dataAreaTypes.put( name, containerClass );
        }
    }

    public synchronized static Class<? extends CMDataArea> getDataAreaClass( String name ) {

        return dataAreaTypes.get( name );
    }

    public synchronized static <T extends CMDataArea> void registerDataAreaType( Class<T> dataAreaClass ) {

        CMName type = dataAreaClass.getAnnotation( CMName.class );
        String name = type != null ? type.value( ) : null;
        if ( name == null ) {
            throw new IllegalStateException( dataAreaClass.getSimpleName( ) + " has no serialization name" ); //$NON-NLS-1$
        }
        setDataAreaClass( name, dataAreaClass );
    }

    public static class CMRestoreInfo {

        public final Moin moin;

        public final Element element;

        public final CMDataArea cmDataArea;

        public final CMManager cmManager;

        public CMRestoreInfo( Moin moin, Element element, CMDataArea parent, CMManager cmManager ) {

            this.moin = moin;
            this.element = element;
            this.cmDataArea = parent;
            this.cmManager = cmManager;
        }

        public CMRestoreInfo spawn( Element element, CMDataArea dataArea ) {

            return new CMRestoreInfo( moin, element, dataArea, cmManager );
        }

        public CRI deserializeCRI( String criString ) {

            return CMServices.deserializeCRI( moin, cmDataArea.getDataAreaDescriptor( ), criString );
        }

        public String getAttribute( String attName, String defaultValue ) {

            Attr node = element.getAttributeNode( attName );
            return node != null ? node.getValue( ) : defaultValue;
        }

        public String getAttribute( String attName ) {

            return getAttribute( attName, null );
        }
    }

    public static CMContainer createContainerByName( String name, CMRestoreInfo restoreInfo ) {

        Class<? extends CMContainer> constructorClass = CMServices.getContainerClass( name );
        try {
            Constructor<? extends CMContainer> constuctor = constructorClass.getConstructor( CMRestoreInfo.class );
            return constuctor.newInstance( restoreInfo );
        } catch ( Exception e ) {
            throw new IllegalStateException( "Could not create CM container '" + name + "'", e ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    public static CMDataArea createDataAreaByName( String name, CMRestoreInfo restoreInfo ) {

        Class<? extends CMDataArea> constructorClass = CMServices.getDataAreaClass( name );
        try {
            Constructor<? extends CMDataArea> constuctor = constructorClass.getConstructor( CMRestoreInfo.class );
            return constuctor.newInstance( restoreInfo );
        } catch ( Exception e ) {
            throw new IllegalStateException( "Could not create CM container '" + name + "'", e ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    public static Map<CRI, CMUsageMode> toUsageMap( CMUsageMode defaultUsage, Set<CRI> cris ) {

        if ( cris == null || cris.size( ) == 0 ) {
            return Collections.emptyMap( );
        }

        HashMap<CRI, CMUsageMode> uc = new HashMap<CRI, CMUsageMode>( cris.size( ) * 2 );
        for ( CRI ucCri : cris ) {
            uc.put( ucCri, defaultUsage );
        }
        return uc;
    }

    public static Map<CRI, CMUsageMode> toUsageMap( CMUsageMode defaultUsage, CMContainer... containers ) {

        if ( containers == null || containers.length == 0 ) {
            return Collections.emptyMap( );
        }

        HashMap<CRI, CMUsageMode> uc = new HashMap<CRI, CMUsageMode>( containers.length * 2 );
        for ( CMContainer container : containers ) {
            uc.put( container.getCri( ), defaultUsage );
        }
        return uc;
    }

    public static CMUsageMode getUsageMode( String attribute ) {

        if ( attribute == null || attribute.length( ) == 0 ) {
            return CMUsageMode.USE;
        }

        return CMUsageMode.valueOf( attribute );
    }

}
