package com.sap.tc.moin.repository.test.jmitck;

import java.io.File;
import java.util.List;
import java.util.Properties;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.xmi.XmiReader;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.test.jmitck.vendorwrapper.Generator;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.test.testcase.MoinTestCase;

/**
 * Implementation of <code>com.sun.jmitck.vendorwrapper.Generator</code> for
 * interacting with <em>MOIN</em>.
 * 
 * @author SAP AG, Vasudevan Kalyanaraman (D037271)
 */
public class JmiGenerator implements Generator {

    private Connection _connection;

    public void init( Properties props, File rootFolder ) {
        openConnection( );
    }

    private Connection createConnection( ) {
        return MoinTestCase.getTestHelper( ).getDefaultTestClient( true ).getConnection( );
    }

    private Connection openConnection( ) {
        if ( _connection == null || !_connection.isAlive( ) ) {
            _connection = this.createConnection( );
        }
        return _connection;
    }

    private void closeConnection( ) {
        if ( _connection != null && _connection.isAlive( ) ) {
            _connection.close( );
        }
        _connection = null;
    }

    /**
     * @see com.sap.tc.moin.repository.test.jmitck.vendorwrapper.Generator#createRefPackage(java.lang.String,
     * java.lang.String)
     */
    public RefPackage createRefPackage( String packageName, String prefix ) {
        Connection cx = openConnection( );
        // The prefix is the Java (JMI) prefix as defined in the file
        List<String> packageNames = Utilities.getUtilities( ).decodeQualifiedName( packageName );
        String packageNameDecoded = packageNames.iterator( ).next( );
        RefPackage refPackage = cx.getPackage( TestMetaModels.JMI_TCK_CN, packageNameDecoded );
        return refPackage;
    }

    /**
     * @see com.sap.tc.moin.repository.test.jmitck.vendorwrapper.Generator#createXmiReader()
     */
    public XmiReader createXmiReader( ) {
        Connection cx = openConnection( );
        return cx.getXmiReader( );
    }

    /**
     * @see com.sap.tc.moin.repository.test.jmitck.vendorwrapper.Generator#retire(com.sap.tc.moin.repository.mmi.reflect.RefPackage)
     */
    public void retire( RefPackage refPackage ) {
        closeConnection( );
    }
}