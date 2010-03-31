package com.sap.tc.moin.repository.test.jmitck.mapping;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.sap.tc.moin.repository.test.jmitck.TestErrorException;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestDescription;
import com.sap.tc.moin.repository.test.jmitck.javatest.lib.MultiTest;

/**
 * A collection of tests to test mapping capabilites. Currently holds some
 * common capabilities. May be factored out later. Not currently being used as a
 * Multitest (run from the command line).
 */
@SuppressWarnings( "nls" )
public class MappingTests extends MultiTest {

    private ClassLoader loader;

    // private Map arguments = new HashMap();
    private TestDescription td;

    protected PrintWriter trOut;

    public void init( ClassLoader loader, TestDescription td, PrintWriter trOut ) {

        this.loader = loader;
        this.td = td;
        this.trOut = trOut;
    }

    public ClassLoader getClassLoader( ) {

        return loader;
    }

    public void setClassLoader( ClassLoader classLoader ) {

        loader = classLoader;
    }

    protected String getParam( String key, boolean required ) {

        String value = td.getParameter( key );
        if ( ( value == null ) && required ) {
            throw new TestErrorException( "Test requires parameter " + key + " defined in test " + Util.getTestId( td ) );
        }
        if ( ( value != null ) && value.equals( "&nbsp;" ) ) {
            value = "";
        }
        return value;
    }

    protected int getIntParam( String key, boolean required ) {

        String str = getParam( key, required );
        if ( str == null ) {
            return -1;
        }
        try {
            return Integer.parseInt( str );
        } catch ( NumberFormatException nfe ) {
            throw new TestErrorException( "Test " + Util.getTestId( td ) + " requires parameter " + key + " to be an integer; illegal value: " + str );
        }
    }

    protected boolean getBooleanParam( String key, boolean required ) {

        String str = getParam( key, required );
        return Boolean.valueOf( str ).booleanValue( );
    }

    protected List<String> getParamList( String key, boolean required ) {

        String str = getParam( key, required );
        List<String> answer = new ArrayList<String>( );
        if ( ( str != null ) && !str.equals( "[none]" ) && !str.equals( "&nbsp;" ) ) {
            StringTokenizer st = new StringTokenizer( str, "," );
            while ( st.hasMoreTokens( ) ) {
                answer.add( st.nextToken( ).trim( ) );
            }
        }
        return answer;
    }

}
