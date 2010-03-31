package com.sap.tc.moin.test.fw;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Deals with the MOIN test configuration.
 * <p>
 * Beside loading the configuration from an appropriate file, this class offers
 * methods for accessing common configuration settings. Especially for the
 * configuration of test client factories and test clients, this class is a
 * utility for parsing the configuration file.
 * <p>
 * The implementation of the test configuration is based on a properties file of
 * the following format:<br>
 * 
 * <pre>
 * 
 * # Test Default bootstrap property file residing in moin.core\tc~moin~repository~configuration\java\api\configuration directory
 * com.sap.tc.moin.test.defaultBootstrap = facility.nwdi.db.properties
 * 
 * # Default facility type
 * com.sap.tc.moin.test.defaultFacilityType=NWDI
 * 
 * # Optional: test client factory per facility type; can overerule the default test client factories
 * com.sap.tc.moin.test.testClientFactory.NWDI=com.sap.tc.moin.test.nwdi.SdicNwdiTestClientFactoryImpl
 * 
 * # Test client configuration - this is used by default for building a 2-dimensional array of TestClient instances,
 * # i.e. for every user/client-spec combination, a test client is created; note that for accessing the test clients,
 * # indexing starts with 0
 * User1.id=
 * User1.pw= 
 *
 * User2.id=
 * User2.pw=
 * 
 * ClientSpec1.id=
 * ClientSpec2.id=
 *
 * 
 * 
 * Beside that, additional properties can be added and retrieved.
 * 
 * @author D032434
 */
@SuppressWarnings( "nls" )
public class TestConfigurationImpl {

    /**
     * Inner class for grouping several properties together. A property group
     * consists of a base name and sub properties for this group. In the above
     * example, there would be property groups with base name &quot;User&quot;
     * and sub properties &quot;id&quot; and &quot;pw&quot;
     */
    public static final class PropertyGroupImpl {

        private String _baseName;

        private int _index;

        private Properties _subProperties;

        public PropertyGroupImpl( String baseName, int index ) {

            _baseName = baseName;
            _index = index;
            _subProperties = new Properties( );
        }

        public String getBaseName( ) {

            return _baseName;
        }

        public int getIndex( ) {

            return _index;
        }

        public Properties getSubProperties( ) {

            return _subProperties;
        }
    }

    // constant for default test configuration file name
    private final static String DEFAULT_CONF_PROPS = "conf/defaultTestConfiguration.properties";

    public static final String PROP_DEFAULT_BOOTSTRAP_PROPERTIES = "com.sap.tc.moin.test.defaultBootstrap";

    public static final String PROP_DEFAULT_FACILITY_NAME = "com.sap.tc.moin.test.defaultFacilityName";

    public static final String PROP_TESTCLIENT_FACTORY = "com.sap.tc.moin.test.testClientFactory";

    public static final String PROP_MMIMPORTER = "com.sap.tc.moin.test.mmImporter";

    // known facility types
    public static final String FACILITY_NAME_NWDI = "PF";

    public static final String FACILITY_NAME_MEMORY = "MEMORY";

    private static final Properties DEFAULT_PROPERTIES = new Properties( );
    static {
        DEFAULT_PROPERTIES.setProperty( PROP_DEFAULT_BOOTSTRAP_PROPERTIES, "facility.nwdi.db.properties" );
        DEFAULT_PROPERTIES.setProperty( PROP_DEFAULT_FACILITY_NAME, FACILITY_NAME_NWDI ); // currently, nearly all test cases use the NWDI facility at runtime
        DEFAULT_PROPERTIES.setProperty( PROP_TESTCLIENT_FACTORY + "." + FACILITY_NAME_NWDI, NwdiTestClientFactoryImpl.class.getName( ) );
        DEFAULT_PROPERTIES.setProperty( PROP_MMIMPORTER, String.valueOf( 1 ) ); //MM importer default value is 1 - switched on.
    }

    private final Properties properties = new Properties( DEFAULT_PROPERTIES );

    // property groups are initialized lazy and kept in a map (keyed by the base name) and a list of property group instances
    private Map<String, List<PropertyGroupImpl>> propertyGroupsMap = new HashMap<String, List<PropertyGroupImpl>>( );

    // name of the configuration; this should be the filename of effectively loaded resource
    private String _name;

    /**
     * Constructs a configuration instance based on the file with the provided
     * name.
     * 
     * @param fileName
     */
    public TestConfigurationImpl( String name ) {

        super( );

        String fullname = null;

        // if the testcase also didn't set the configuration, use the default
        if ( name == null || name.length( ) == 0 ) {
            fullname = DEFAULT_CONF_PROPS;
        } else {
            fullname = "conf/" + name;
        }

        URL resourceUrl = Thread.currentThread( ).getContextClassLoader( ).getResource( fullname );
        if ( resourceUrl == null ) {
            MoinTestHelper.class.getClassLoader( ).getResource( fullname );
        }
        if ( resourceUrl == null ) {
            throw new IllegalStateException( "Can not get test configuration " + fullname );
        }

        // set the configuration nameto the effectively loaded resource name
        _name = resourceUrl.toString( );

        // now try to read the resource
        InputStream in = null;
        try {
            in = resourceUrl.openStream( );
            properties.load( in );
        } catch ( IOException e ) {
            throw new IllegalStateException( "Loading test configuration failed for resource " + fullname, e );
        } finally {
            if ( in != null ) {
                try {
                    in.close( );
                } catch ( IOException e2 ) {
                    // TODO: only log a warning

                }
            }
        }

        initPropertyGroupList( );
    }

    /**
     * Gets a property of the test configuration.
     * 
     * @param key
     * @return the property of the test configuration with the specific key or
     * <code>null</code>, if no such property exists
     */
    public String getProperty( String key ) {

        return properties.getProperty( key );
    }

    /**
     * Gets a property of the test configuration.
     * 
     * @param key
     * @param defaultValue
     * @return the property of the test configuration with the specific key or
     * <code>defaultValue</code>, if no such property exists
     */
    public String getProperty( String key, String defaultValue ) {

        return properties.getProperty( key, defaultValue );
    }

    /**
     * @return an enumeration of all property keys of the configuration
     */
    public Enumeration<String> getPropertyKeys( ) {

        final Enumeration<Object> keys = properties.keys( );
        return new Enumeration<String>( ) {

            public boolean hasMoreElements( ) {

                return keys.hasMoreElements( );
            }

            public String nextElement( ) {

                return (String) keys.nextElement( );
            }
        };
    }

    /**
     * Gets the name of the default facility.
     */
    public String getDefaultFacilityId( ) {

        return getProperty( PROP_DEFAULT_FACILITY_NAME );
    }

    /**
     * Gets the name of the test client factory implementation class for the
     * specified facility name.
     * 
     * @param facilityName
     * @return the name of the test client factory implementation class for the
     * specified facility name or <code>null</code>, if neither specified in the
     * configuration file nor a default exists
     */
    public String getTestClientFactoryClassName( String facilityName ) {

        if ( facilityName == null ) {
            return null;
        }

        return getProperty( PROP_TESTCLIENT_FACTORY + "." + facilityName );
    }

    /**
     * Returns the list of all property groups for the specified base name.
     * 
     * @param baseName
     * @return the list of all property groups for the specified base name
     */
    public List<PropertyGroupImpl> getPropertyGroupList( String baseName ) {

        return propertyGroupsMap.get( baseName );
    }

    /**
     * Gets the name of this test configuration. This is the full name of the
     * resource from which the configuration was effectively loaded
     * 
     * @return the name of this test configuration
     */
    public String getName( ) {

        return _name;
    }

    /**
     * Initalizes the property group map from the properties data.
     */
    private void initPropertyGroupList( ) {

        // while looping over the unordered properties, it's easier to use a second map for the index instead
        // a set
        Map<String, SortedMap<Integer, PropertyGroupImpl>> tmpPropertyGroupsMap = new HashMap<String, SortedMap<Integer, PropertyGroupImpl>>( );

        // loop over all properties and collect the matching base names
        // this is the regex pattern for property keys: basename has to be a word (\w),
        // followed by a dot, followed by a digit for the index, followed by a word for the
        // sub property
        final String regExPattern = "\\w+\\.[0-9]+\\.\\w+";
        for ( Enumeration<String> propertyKeys = this.getPropertyKeys( ); propertyKeys.hasMoreElements( ); ) {
            String key = propertyKeys.nextElement( ).trim( );
            if ( key.matches( regExPattern ) ) {
                String[] tokens = key.split( "\\." );

                // since we already did a pattern match before, we can be sure that there are 3 tokens,
                // from wich the first is the basename, the second the index and the third the key of the sub property
                String baseName = tokens[0];
                int index = Integer.parseInt( tokens[1] ) - 1;
                String subPropKey = tokens[2];

                // first we look into the map and check if there is already a property group for this base name 
                SortedMap<Integer, PropertyGroupImpl> indexPropGroupMap = tmpPropertyGroupsMap.get( baseName );
                if ( indexPropGroupMap == null ) {
                    // no group yet, so we create a new list and add it to the map
                    indexPropGroupMap = new TreeMap<Integer, PropertyGroupImpl>( );
                    tmpPropertyGroupsMap.put( baseName, indexPropGroupMap );
                }

                // next, we check if a property group for this index already exists
                PropertyGroupImpl propGroup = indexPropGroupMap.get( index );
                if ( propGroup == null ) {
                    // no group yet, so we create a new one
                    propGroup = new PropertyGroupImpl( baseName, index );
                    indexPropGroupMap.put( index, propGroup );
                }

                // now get the value of the (full) property and set it in the property group's sub property
                String value = properties.getProperty( key );
                propGroup.getSubProperties( ).setProperty( subPropKey, value );
            }
        }

        // now that we've collected all properties, we loop over the temporary map and convert the inner map
        // into a list
        for ( String baseName : tmpPropertyGroupsMap.keySet( ) ) {
            SortedMap<Integer, PropertyGroupImpl> indexPropGroupMap = tmpPropertyGroupsMap.get( baseName );
            List<PropertyGroupImpl> propGroupList = this.propertyGroupsMap.get( baseName );
            if ( propGroupList == null ) {
                propGroupList = new ArrayList<PropertyGroupImpl>( );
                this.propertyGroupsMap.put( baseName, propGroupList );
            }
            int lastIndex = 0;
            for ( int index : indexPropGroupMap.keySet( ) ) {
                // make sure that there are no gaps
                if ( index != lastIndex ) {
                    throw new IllegalArgumentException( "Bad test configuration: property group " + baseName + " has a gap before index " + index );
                }
                lastIndex++;

                PropertyGroupImpl propGroup = indexPropGroupMap.get( index );
                propGroupList.add( index, propGroup );
            }
        }
    }
}
