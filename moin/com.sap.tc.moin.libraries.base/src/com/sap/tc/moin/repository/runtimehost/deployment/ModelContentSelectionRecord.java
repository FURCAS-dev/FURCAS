package com.sap.tc.moin.repository.runtimehost.deployment;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sap.tc.moin.repository.runtimehost.MmInfoConst;

/**
 * Class containing the model content selection criteria. The criteria are
 * defined in the registration file "modelcontentselection_inf.xml".
 * 
 * @author D026715
 */
public class ModelContentSelectionRecord extends RegistrationRecordBase {

    private static final String SCHEMA_CONTENT_SELECTION_INF_XSD = SCHEMA_LOCATION + "modelcontentselection_inf.xsd"; //$NON-NLS-1$

    public static String RESOURCE_NAME = MmInfoConst.CUSTOM_CONTENT_SELECTION_INF_FILE_NAME;

    private static final String[] CUSTOM_SELECTION_PROPERTIES = new String[] { "ModelContentSelectionInf", "SupportedContentSelectionTypes", "ContentSelection" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

    private static final String CUSTOM_SELECTION_TYPE = "type"; //$NON-NLS-1$

    private static final String PROPERTY = "Property"; //$NON-NLS-1$

    private static final String PROP_NAME = "name"; //$NON-NLS-1$

    private static final String PROP_VALUE = "value"; //$NON-NLS-1$

    private static final String NUMBER_SEPARATOR = "_"; //$NON-NLS-1$


    private Map<String /* selection type */, Collection<Properties>> selectionCriteria = new HashMap<String, Collection<Properties>>( );

    public ModelContentSelectionRecord( ) {

    }

    @Override
    protected void initSchema( ) {

        InputStream schemaFile = ErrorHandlerRegistrationRecord.class.getClassLoader( ).getResourceAsStream( SCHEMA_CONTENT_SELECTION_INF_XSD );
        setSchemaValidation( schemaFile );
    }

    @Override
    protected void initVisitors( ) {

        this.visitors.add( new CustomSelectionVisitor( ) );


    }

    class CustomSelectionVisitor implements NodeVisitor {

        public String[][] isInterestedIn( ) {

            return new String[][] { CUSTOM_SELECTION_PROPERTIES };
        }

        public boolean handleNode( String[] fullPath, Node node ) {

            String type = getAttribute( CUSTOM_SELECTION_TYPE, node );
            Properties selectionProperties = new Properties( );

            NodeList childNodes = node.getChildNodes( );
            for ( int i = 0; i < childNodes.getLength( ); i++ ) {
                Node childNode = childNodes.item( i );
                if ( childNode.getNodeName( ).equals( PROPERTY ) ) {
                    String name = getAttribute( PROP_NAME, childNode );
                    String value = getAttribute( PROP_VALUE, childNode );
                    String newName = name;
                    int index = 0;
                    while ( selectionProperties.get( newName ) != null ) {
                        newName = name + NUMBER_SEPARATOR + String.valueOf( index );
                        index++;
                    }
                    selectionProperties.put( newName, value );
                }
            }

            Collection<Properties> criteria = ModelContentSelectionRecord.this.selectionCriteria.get( type );
            if ( criteria == null ) {
                criteria = new HashSet<Properties>( );
                ModelContentSelectionRecord.this.selectionCriteria.put( type, criteria );
            }

            criteria.add( selectionProperties );

            // abort traversal here
            return true;
        }
    }

    public Map<String, Collection<Properties>> getSelectionCriteria( ) {

        return this.selectionCriteria;
    }

}
