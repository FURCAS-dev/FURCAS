/**
 * 
 */
package com.sap.tc.moin.repository.test.jmitck;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.test.jmitck.javatest.TestDescription;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestFinder.Fault;
import com.sap.tc.moin.repository.test.jmitck.test.javatest.finder.HTMLTestFinder;

/**
 * @author d045397 Utility class for the JMI TCK tests.
 */
public class TestJmiTckUtil {

    /**
     * finds and returns the testDescriptions contained in a given properties
     * object
     */
    public List<Object[]> findTestDescriptions( Properties tdProps ) throws Fault {

        // collection for adding the found test descriptions
        List<Object[]> coll = new ArrayList<Object[]>( );

        // initialization of the HtmlTestFinder
        HTMLTestFinder htmlTestFinder = new HTMLTestFinder( );
        //htmlTestFinder.init(new String[] {"-webWalk"}, new File(System.getProperty("user.dir")), testEnv);

        // reads filenames from properties file
        Iterator<Entry<Object, Object>> itProps = tdProps.entrySet( ).iterator( );
        int cutPos;
        String fileName;
        Collection<InputStream> streams = new ArrayList<InputStream>( );
        InputStream is = null;
        while ( itProps.hasNext( ) ) {
            // reduces the string to the actual path
            // and gets resource as stream
            String s = itProps.next( ).toString( );
            cutPos = s.indexOf( "=" ); //$NON-NLS-1$
            fileName = "/" + s.substring( cutPos + 1, s.length( ) ); //$NON-NLS-1$
            streams.add( getClass( ).getResourceAsStream( fileName ) );
        }

        // parses html files for testdescription
        Iterator<InputStream> itStreams = streams.iterator( );
        while ( itStreams.hasNext( ) ) {
            is = itStreams.next( );
            htmlTestFinder.read( is );
            TestDescription[] tdArray = htmlTestFinder.getTests( );
            for ( int i = 0; i < tdArray.length; i++ ) {
                coll.add( new Object[] { tdArray[i], true } );
            }
        }

        return coll;
    }

    Properties loadProperties( String fileName ) throws IOException {

        Properties tdProps = new Properties( );
        InputStream stream = getClass( ).getResourceAsStream( fileName );
        tdProps.load( stream );
        try {
            stream.close( );
        } catch ( IOException e ) {
            // silently ignored
        }

        return tdProps;
    }

}
