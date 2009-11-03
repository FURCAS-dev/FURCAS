package com.sap.tc.moin.repository.runtimehost;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Registration serializer for metamodel partition info.
 * <p>
 * Writes the registration xml file "metamodel.xml" for meta model partitions.
 * The files are based on the schema "metamodel_inf.xsd".
 * </p>
 */
public class MetamodelRegistrationSerializer {

    // variables
    private Map<String, String> partitions = new HashMap<String, String>( );

    private String deploymentExtensionClass;

    private String metaModelResourceBundleName;

    private String facilityId;

    public MetamodelRegistrationSerializer( String deploymentExtensionClass, String metaModelResourceBundleName, String facilityId, Map<String, String> partitions ) {

        super( );
        this.deploymentExtensionClass = deploymentExtensionClass;
        this.metaModelResourceBundleName = metaModelResourceBundleName;
        this.facilityId = facilityId;
        this.partitions = partitions;
    }

    public void serialize( OutputStream oStream ) throws IOException {

        // metamodel.xml: generate it
        final String TAB = "  "; //$NON-NLS-1$
        if ( partitions != null && partitions.size( ) > 0 ) {
            List<String> fileEntries = new ArrayList<String>( );

            // header
            fileEntries.add( "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> " ); //$NON-NLS-1$
            // mm tag
            fileEntries.add( "<" + MetamodelRegistrationParser.METAMODEL_INF + " xmlns=\"http://sap.com/moin/MoinArchive\"" ); //$NON-NLS-1$ //$NON-NLS-2$
            fileEntries.add( TAB + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" ); //$NON-NLS-1$
            fileEntries.add( TAB + "xsi:schemaLocation=\"http://sap.com/moin/MoinArchive metamodel_inf.xsd\">" ); //$NON-NLS-1$

            // facilityId
            fileEntries.add( TAB + "<" + MetamodelRegistrationParser.FACILITY_ID + ">" + facilityId + "</" + MetamodelRegistrationParser.FACILITY_ID + ">" ); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
            // deploymentExtension class
            fileEntries.add( TAB + "<" + MetamodelRegistrationParser.DEPLOYMENT_EXTENSION + " " + MetamodelRegistrationParser.CLASS_NAME + "=\"" + deploymentExtensionClass + "\" />" ); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
            if ( metaModelResourceBundleName != null && metaModelResourceBundleName.length( ) > 0 ) {
                // metaModelResourceBundleName class
                fileEntries.add( TAB + "<" + MetamodelRegistrationParser.RESOURCE_BUNDLE + " " + MetamodelRegistrationParser.CLASS_NAME + "=\"" + metaModelResourceBundleName + "\" />" ); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
            }
            // partitions
            // open partitions tag
            fileEntries.add( TAB + "<" + MetamodelRegistrationParser.PARTITIONS + ">" ); //$NON-NLS-1$ //$NON-NLS-2$

            for ( String partitionName : partitions.keySet( ) ) {
                fileEntries.add( TAB + TAB + "<" + MetamodelRegistrationParser.PARTITION + " " + MetamodelRegistrationParser.PARTITION_NAME + "=\"" + partitionName + "\"" ); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                fileEntries.add( TAB + TAB + TAB + MetamodelRegistrationParser.CONTENT_HASH + "=\"" + partitions.get( partitionName ) + "\" />" ); //$NON-NLS-1$//$NON-NLS-2$
            }
            // close partitions tag
            fileEntries.add( TAB + "</" + MetamodelRegistrationParser.PARTITIONS + ">" ); //$NON-NLS-1$ //$NON-NLS-2$

            // close mm tag
            fileEntries.add( "</" + MetamodelRegistrationParser.METAMODEL_INF + ">" ); //$NON-NLS-1$ //$NON-NLS-2$

            BufferedWriter metamodelXmlWriter = null;
            try {
                metamodelXmlWriter = new BufferedWriter( new OutputStreamWriter( oStream, "UTF-8" ) ); //$NON-NLS-1$
                for ( String entry : fileEntries ) {
                    metamodelXmlWriter.write( entry );
                    metamodelXmlWriter.newLine( );
                }
            } finally {
                if ( metamodelXmlWriter != null ) {
                    metamodelXmlWriter.close( );
                }
            }
        }


    }
}
