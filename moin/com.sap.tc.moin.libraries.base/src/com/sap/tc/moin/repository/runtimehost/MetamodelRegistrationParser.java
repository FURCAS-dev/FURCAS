package com.sap.tc.moin.repository.runtimehost;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;

import com.sap.tc.moin.repository.runtimehost.deployment.RegistrationRecordBase;

/**
 * Registration parser for metamodel partition info.
 * <p>
 * Reads the registration xml file "metamodel.xml" for meta model partitions.
 * The files are based on the schema "metamodel_inf.xsd".
 * </p>
 * 
 * @author d026715
 */
public class MetamodelRegistrationParser extends RegistrationRecordBase {

    public static String RESOURCE_NAME = MmInfoConst.MM2_METAMODEL_XML_FILE_NAME;

    // tag IDs
    public static final String METAMODEL_INF = "MetamodelInf"; //$NON-NLS-1$

    public static final String FACILITY_ID = "FacilityId"; //$NON-NLS-1$

    public static final String DEPLOYMENT_EXTENSION = "DeploymentExtension"; //$NON-NLS-1$

    public static final String RESOURCE_BUNDLE = "ResourceBundle"; //$NON-NLS-1$


    public static final String PARTITIONS = "Partitions"; //$NON-NLS-1$

    public static final String PARTITION = "Partition"; //$NON-NLS-1$

    // attribute keys
    public static final String CLASS_NAME = "class"; //$NON-NLS-1$

    public static final String PARTITION_NAME = "name"; //$NON-NLS-1$

    public static final String CONTENT_HASH = "contentHash"; //$NON-NLS-1$

    // parser setup
    private static final String SCHEMA_ERRORHANDLER_INF_XSD = SCHEMA_LOCATION + "metamodel_inf.xsd"; //$NON-NLS-1$

    private static final String[] FACILITY = new String[] { METAMODEL_INF, FACILITY_ID };

    private static final String[] DEPLOYMENT_EXT = new String[] { METAMODEL_INF, DEPLOYMENT_EXTENSION };

    private static final String[] RESOURCE_BDL = new String[] { METAMODEL_INF, RESOURCE_BUNDLE };

    private static final String[] PARTITION_LIST = new String[] { METAMODEL_INF, PARTITIONS, PARTITION };

    // variables
    private Map<String, Long> partitions = new HashMap<String, Long>( );

    private String deploymentExtensionClass;

    private String resourceBundleClass = null;

    private String facilityId;

    @Override
    protected void initSchema( ) {

        InputStream schemaFile = MetamodelRegistrationParser.class.getClassLoader( ).getResourceAsStream( SCHEMA_ERRORHANDLER_INF_XSD );
        setSchemaValidation( schemaFile );
    }

    @Override
    protected void initVisitors( ) {

        this.visitors.add( new PartitionVisitor( ) );
        this.visitors.add( new FacilityVisitor( ) );
        this.visitors.add( new DeploymentExtVisitor( ) );
        this.visitors.add( new ResourceBdlVisitor( ) );

    }

    class PartitionVisitor implements NodeVisitor {

        public String[][] isInterestedIn( ) {

            return new String[][] { PARTITION_LIST };
        }

        public boolean handleNode( String[] fullPath, Node node ) {

            String partitionName = getAttribute( PARTITION_NAME, node );
            String contentHash = getAttribute( CONTENT_HASH, node );

            Long convertedHash = convertToLong( contentHash );

            partitions.put( partitionName, convertedHash );

            return true;
        }

        private Long convertToLong( String hash ) {

            long longValue;
            try {
                longValue = Long.parseLong( hash );
            } catch ( NumberFormatException ex ) {
                longValue = Hasher.md5toLong( hash );
            }

            return Long.valueOf( longValue );
        }
    }

    class FacilityVisitor implements NodeVisitor {

        public String[][] isInterestedIn( ) {

            return new String[][] { FACILITY };
        }

        public boolean handleNode( String[] fullPath, Node node ) {

            facilityId = getTextContent( node );

            return true;
        }
    }

    class DeploymentExtVisitor implements NodeVisitor {

        public String[][] isInterestedIn( ) {

            return new String[][] { DEPLOYMENT_EXT };
        }

        public boolean handleNode( String[] fullPath, Node node ) {

            deploymentExtensionClass = getAttribute( CLASS_NAME, node );


            return true;
        }
    }

    class ResourceBdlVisitor implements NodeVisitor {

        public String[][] isInterestedIn( ) {

            return new String[][] { RESOURCE_BDL };
        }

        public boolean handleNode( String[] fullPath, Node node ) {

            resourceBundleClass = getAttribute( CLASS_NAME, node );


            return true;
        }
    }


    public Map<String, Long> getPartitions( ) {

        return partitions;
    }


    public String getDeploymentExtensionClass( ) {

        return deploymentExtensionClass;
    }


    public String getResourceBundleClass( ) {

        return resourceBundleClass;
    }


    public String getFacilityId( ) {

        return facilityId;
    }


    /**
     * Converter for md5 hash to long.
     * 
     * @author d026715
     */
    private static class Hasher {

        private static final byte[] ENCODE_TABLE = new byte[] { -1, 10, 11, 12, 13, 14, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1 };

        private static final byte ENCODE_MASK = 31;

        private static final long POSITIVE_HASH_MASK = Long.MAX_VALUE;

        public static long md5toLong( String string32 ) {

            char[] chs = new char[32];
            string32.getChars( 0, 32, chs, 0 );

            long f = 0;
            long s = 0;

            for ( byte i = 0; i < 16; i++ ) {
                f <<= 4;
                f |= ENCODE_TABLE[chs[i] & ENCODE_MASK];
            }
            for ( byte i = 16; i < 32; i++ ) {
                s <<= 4;
                s |= ENCODE_TABLE[chs[i] & ENCODE_MASK];
            }

            return ( f ^ s ) & POSITIVE_HASH_MASK;
        }
    }
}
