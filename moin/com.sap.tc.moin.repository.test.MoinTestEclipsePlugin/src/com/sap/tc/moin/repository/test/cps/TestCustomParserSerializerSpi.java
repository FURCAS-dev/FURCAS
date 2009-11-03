package com.sap.tc.moin.repository.test.cps;

import java.io.IOException;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiElement;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;
import com.sap.tc.moin.repository.test.core.CoreMoinTest;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case001.B1;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;
import com.sap.tc.moin.testcases.case008.A8;
import com.sap.tc.moin.testcases.case008.Case008Package;
import com.sap.tc.moin.testcases.case008.T8;
import com.sap.tc.moin.testcases.case017.A17;
import com.sap.tc.moin.testcases.case025.B25;
import com.sap.tc.moin.testcases.case025.C25;
import com.sap.tc.moin.testcases.case025.D25;

/**
 * Tests if the moin extensions are available.
 * 
 * @author D026715
 */
public class TestCustomParserSerializerSpi extends CoreMoinTest {

    private static final String SERIALIZATION_FACTORY_MOCK = "com.sap.tc.moin.repository.cps.test.Mock";

    private static String REG_SOURCE_PATH = "cpstest";

    protected SpiPartitionSerializationManager getPartitionSerializationManager( ) {

        return ( (SpiFacility) getFacility( ) ).getPartitionSerializationManager( );
    }

    /**
     * Tests the registration parser of custom parsers/serializers.
     * 
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    @Test
    public void testMultiValuedAttributes( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        Connection connection = getMOINConnection( );

        A4 a4_1 = this.createA4( connection );

        Collection<Double> manyPrimitiveDouble = a4_1.getManyPrimitiveDouble( );

        manyPrimitiveDouble.add( new Double( 19.0 ) );
        manyPrimitiveDouble.add( new Double( 71.0 ) );
        Double TEST_VALUE = new Double( 37.0 );
        manyPrimitiveDouble.add( TEST_VALUE );

        // must be a collection of Strings
        RefObject coreA4 = getTestHelper( ).getCoreRefObject( a4_1 );
        Collection result = (Collection) ( (SpiElement) coreA4 ).get___AttributeValue( "manyPrimitiveDouble" );

        boolean ok = true;
        for ( Object object : result ) {
            if ( !( object instanceof String ) ) {
                ok = false;
            }
        }

        verify( ok, "Returned attribute is not of type string as documented in the javadoc" );

        verify( result.contains( TEST_VALUE.toString( ) ), "Returned collection does not contain test value" );

    }

    private void createContentForPartition( Connection connection, ModelPartition partition_01 ) {

        // create some content
        C25 a = this.createC25( connection );
        C25 b = this.createC25( connection );
        a.getToEnd( ).add( b );

        B25 c = this.createB25( connection );
        c.setOnePrimitive( "Value" );

        D25 d = this.createD25( connection );

        T8 structureValue = this.createT8( 12, "Value", connection );

        d.setOneStructureT( structureValue );

        a.setExternalId( "1" );
        partition_01.assignElement( a );
        b.setExternalId( "2" );
        partition_01.assignElement( b );
        c.setExternalId( "34" );
        partition_01.assignElement( c );
        d.setExternalId( "44" );
        partition_01.assignElement( d );
    }

    private B1 createB1( Connection conn ) {

        return conn.createElementInPartition( B1.class, null );
    }

    private A17 createA17( Connection conn ) {

        return conn.createElementInPartition( A17.class, null );
    }

    private C25 createC25( Connection conn ) {

        return conn.createElementInPartition( C25.class, null );
    }

    private B25 createB25( Connection conn ) {

        return conn.createElementInPartition( B25.class, null );
    }

    private D25 createD25( Connection conn ) {

        return conn.createElementInPartition( D25.class, null );
    }

    private T8 createT8( int field1, String field2, Connection conn ) {

        StructureFieldContainer<T8> contT8 = new StructureFieldContainer<T8>( );
        TestcasesPackage testcasesPackage = (TestcasesPackage) conn.getPackage( null, new String[] { "testcases" } );

        Case008Package case008Package = testcasesPackage.getCase008( );
        contT8.put( T8.DESCRIPTORS.FIELD1( ), field1 ).put( T8.DESCRIPTORS.FIELD2( ), field2 );
        T8 a = case008Package.createT8( contT8 );

        return a;
    }

    private B4 createB4( Connection conn ) {

        return conn.createElementInPartition( B4.class, null );
    }

    private A4 createA4( Connection conn ) {

        return conn.createElementInPartition( A4.class, null );
    }

    private A8 createA8( Connection conn ) {

        return conn.createElementInPartition( A8.class, null );
    }
}
