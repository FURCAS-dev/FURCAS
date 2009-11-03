package com.sap.tc.moin.repository.runtimehost.deployment;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;

import com.sap.tc.moin.repository.runtimehost.MmInfoConst;

/**
 * Parser for the custom parser/serializer registration.
 * <p>
 * This parser reads the "modelstorage_inf.xml" configuration file which
 * contains the registration of the custom parsers/serializers, including xm
 * parsers/serializers. The file also contains the registration of additional
 * suffixes for already registered parsers/serializers, including the MOIN build
 * in parser/serializer.
 * </p>
 * <p>
 * The schema for the registration file is located in
 * "schema/modelstorage_inf.xsd".
 * </p>
 * 
 * @author d026715
 */
public class ModelstorageRegistrationRecord extends RegistrationRecordBase {

    private static final String SCHEMA_MODELSTORAGE_INF_XSD = SCHEMA_LOCATION + "modelstorage_inf.xsd"; //$NON-NLS-1$

    public static String RESOURCE_NAME = MmInfoConst.MM_STORAGE_INF_FILE_NAME;

    public static final String NO_SERIALIZATION_ID = "<none>"; //$NON-NLS-1$

    private static final String CLASS_NAME = "className"; //$NON-NLS-1$

    private static final String SERIALIZATION_ID = "serializationId"; //$NON-NLS-1$

    private static final String[] XM_SERIALIZATION = new String[] { "ModelstorageInf", "CustomSerializationFactories", "XmSerializationFactory" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

    private static final String[] CUSTOM_SERIALIZATION = new String[] { "ModelstorageInf", "CustomSerializationFactories", "CustomSerializationFactory" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

    private static final String[] FILE_PATTERN = new String[] { "ModelstorageInf", "FilePatterns", "Pattern" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

    private static final String SUFFIX = "suffix"; //$NON-NLS-1$

    private static final String PREFIX = "prefix"; //$NON-NLS-1$

    private Map<String /* serializationId */, String /* className */> customParsers = new HashMap<String, String>( );

    private Map<PriPattern, String /* serializationId */> suffixes = new HashMap<PriPattern, String>( );

    public Map<PriPattern, String> getPatterns( ) {

        return suffixes;
    }

    /**
     * Returns a map of serialization ids and serialization factory classes
     * 
     * @return
     */
    public Map<String, String> getCustomParsers( ) {

        return customParsers;
    }

    @Override
    protected void initVisitors( ) {

        this.visitors.add( new CustomParsersVisitor( ) );
        this.visitors.add( new FilePatternVisitor( ) );

    }

    @Override
    protected void initSchema( ) {

        InputStream schemaFile = ModelstorageRegistrationRecord.class.getClassLoader( ).getResourceAsStream( SCHEMA_MODELSTORAGE_INF_XSD );
        setSchemaValidation( schemaFile );
    }

    class CustomParsersVisitor implements NodeVisitor {

        public String[][] isInterestedIn( ) {

            return new String[][] { CUSTOM_SERIALIZATION, XM_SERIALIZATION };
        }

        public boolean handleNode( String[] fullPath, Node node ) {

            String serializationId = getAttribute( SERIALIZATION_ID, node );
            String className = getAttribute( CLASS_NAME, node );
            if ( className != null ) {
                customParsers.put( serializationId, className );
            }
            return true;
        }
    }

    class FilePatternVisitor implements NodeVisitor {

        public String[][] isInterestedIn( ) {

            return new String[][] { FILE_PATTERN };
        }

        public boolean handleNode( String[] fullPath, Node node ) {

            String serializationId = getAttribute( SERIALIZATION_ID, node );
            String suffix = getAttribute( SUFFIX, node );
            String prefix = getAttribute( PREFIX, node );
            if ( suffix != null ) {
                if ( serializationId == null ) {
                    serializationId = NO_SERIALIZATION_ID;
                }
                // suffix registry must contain suffixes with "." for performance reasons (SpiPartitionNameVerifier)
                if ( !suffix.startsWith( "." ) ) { //$NON-NLS-1$
                    suffix = "." + suffix; //$NON-NLS-1$
                }
                suffixes.put( new PriPattern( prefix, suffix ), serializationId );
            }
            return true;
        }
    }

}
