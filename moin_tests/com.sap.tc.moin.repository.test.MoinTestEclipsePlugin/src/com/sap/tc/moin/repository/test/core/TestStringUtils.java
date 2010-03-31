package com.sap.tc.moin.repository.test.core;

import java.util.Locale;

import org.junit.Test;

import com.sap.tc.moin.repository.shared.util.StringUtils;

public class TestStringUtils extends CoreMoinTest {

    @Test
    public void testUncamelize( ) throws Exception {

        assertNull( StringUtils.unCamelize( null, null ) );
        assertNull( StringUtils.unCamelize( null, "" ) );
        assertNull( StringUtils.unCamelize( null, "_" ) );

        assertEquals( "testIt", StringUtils.unCamelize( "testIt", null ) );
        assertEquals( "testIt", StringUtils.unCamelize( "testIt", "" ) );

        assertEquals( "test", StringUtils.unCamelize( "test", "_" ) );

        assertEquals( "A_CAR", unCamelize( "aCar" ) );
        assertEquals( "IS_SINGLETON", unCamelize( "isSingleton" ) );
        assertEquals( "CUSTOMER_ID", unCamelize( "customerID" ) );
        assertEquals( "XML_WRITER", unCamelize( "XMLWriter" ) );
        assertEquals( "IS_ID_AVAILABLE", unCamelize( "isIDAvailable" ) );
        assertEquals( "MULT0_OR_MULT1", unCamelize( "mult0OrMult1" ) );
        assertEquals( "_MOF_ID123", unCamelize( "_mofId123" ) );

        assertEquals( "someMOINTest", StringUtils.unCamelize( "someTest", "MOIN" ) );
    }

    private String unCamelize( String inputString ) {

        return StringUtils.unCamelize( inputString, "_" /* separatorString */).toUpperCase( Locale.ENGLISH );
    }
}