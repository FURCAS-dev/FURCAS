package com.sap.tc.moin.test.fw.ide;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.model.api.IDevelopmentConfiguration;

/**
 * The class is intendently not public, because it should only be used in
 * DiTrackUtil.
 * <p>
 * Remark: Coding is copied from Dii05.
 */
/**
 * Context of sof test Run
 * 
 * @author D039596
 */
@SuppressWarnings( "nls" )
public class DiiContext {

    public static String USERNAME = "ext.sys.test.nwdi.username";

    public static String PWD = "ext.sys.test.nwdi.userpassword";

    public static String LSD_URL = "ext.sys.test.nwdi.landscapeDirectoryURL";

    public static String CONFIG_NAME = "ext.sys.test.nwdi.devConfigurationName";

    public static String SC_NAME = "ext.sys.test.nwdi.editableSoftwareComponentName";

    Properties _properties = new Properties( );

    private IDevelopmentConfiguration _devConfig;

    private IDevelopmentComponent _dc;

    private Map<String, Object> _map;

    public DiiContext( InputStream input ) {

        if ( input != null ) {
            try {
                _properties.load( input );
                input.close( );
            } catch ( IOException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace( );
            }
        }
    }

    public DiiContext( ) {

        setSystemProperty( USERNAME );
        setSystemProperty( PWD );
        setSystemProperty( LSD_URL );
        setSystemProperty( CONFIG_NAME );
        setSystemProperty( SC_NAME );
    }

    private void setSystemProperty( String key ) {

        String value = System.getProperty( key );
        if ( value != null ) {
            _properties.setProperty( key, value );
        } else {
            _properties.remove( key );
        }
    }

    public String getUserName( ) {

        return _properties.getProperty( USERNAME );
    }

    public String getPassword( ) {

        return _properties.getProperty( PWD );
    }

    public String getSldUrl( ) {

        return _properties.getProperty( LSD_URL );
    }

    public String getConfigurationName( ) {

        return _properties.getProperty( CONFIG_NAME );
    }

    public String getSCName( ) {

        return _properties.getProperty( SC_NAME );
    }

    public void setDevelopmentConfiguration( IDevelopmentConfiguration config ) {

        _devConfig = config;

    }

    public IDevelopmentConfiguration getDevelopmentConfiguration( ) {

        return _devConfig;

    }

    private Map<String, Object> getMap( ) {

        if ( _map == null ) {
            _map = new HashMap<String, Object>( );
        }
        return _map;
    }

    public IDevelopmentComponent getDc( ) {

        return _dc;
    }

    public void setDc( IDevelopmentComponent _dc ) {

        _dc = _dc;
    }

    public Object getObject( String name ) {

        return getMap( ).get( name );
    }

    public void setObject( String name, Object obj ) {

        getMap( ).put( name, obj );
    }
}
