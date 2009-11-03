package com.sap.tc.moin.repository.test.cps;

import java.util.Iterator;

import org.junit.Test;

import com.sap.tc.moin.repository.runtimehost.deployment.ErrorHandlerRegistry;
import com.sap.tc.moin.repository.runtimehost.deployment.InstanceReferenceImpl;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiParserErrorHandler;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.test.testcase.MoinTestCase;


public class TestErrorHandlerRegistry extends MoinTestCase {

    private static final String DUMMY_CRI = "DummyCri";

    private static final String DUMMY_CRI2 = "DummyCri2";

    private static final String DUMMY_CRI_ONE_FOR_ALL = "DummyCriOneForAll";

    private static final String DUMMY_CRI_UNLIMITED = "DummyCriUnlimited";

    /**
     * Tests the error handler registry.
     */
    @Test
    public void testErrorHandlerRegistry( ) {

        ErrorHandlerRegistry<InstanceReferenceImpl<MockErrorHandler>> reg = new ErrorHandlerRegistry<InstanceReferenceImpl<MockErrorHandler>>( );

        boolean empty = true;

        for ( Iterator<InstanceReferenceImpl<MockErrorHandler>> iter = reg.iterator( ); iter.hasNext( ); ) {
            empty = false;
            iter.next( );
        }

        verify( empty, "Registry iterator should return nothing" );

        reg.put( DUMMY_CRI, "1.0", "2.0", this.createMockReference( "1" ) );

        InstanceReferenceImpl<MockErrorHandler> spiParserErrorHandler = reg.get( DUMMY_CRI, "1.1" );

        int numberOfEh = 0;

        for ( Iterator<InstanceReferenceImpl<MockErrorHandler>> iter = reg.iterator( ); iter.hasNext( ); ) {
            numberOfEh++;
            iter.next( );
        }

        verify( numberOfEh == 1, "Registry iterator should return one error handler but returned " + numberOfEh );

        verify( spiParserErrorHandler != null, "Error handler 1 not found." );

        reg.put( DUMMY_CRI, "2.0", "3.0", this.createMockReference( "2" ) );

        verify( reg.get( DUMMY_CRI, "2.0" ) != null, "Error handler 2 not found." );

        verify( !reg.put( DUMMY_CRI, "2.0", "2.1", this.createMockReference( "3" ) ), "Overwriting error handler must not succeed." );

        verify( !reg.put( DUMMY_CRI, "2.0", "2.0", this.createMockReference( "4" ) ), "Overwriting error handler must not succeed." );

        reg.put( DUMMY_CRI, "3.0", "4.0", this.createMockReference( "5" ) );

        InstanceReferenceImpl<MockErrorHandler> mockErrorHandler = reg.get( DUMMY_CRI, "3.4" );

        verify( ( mockErrorHandler != null ) && mockErrorHandler.getInstance( ).getId( ).equals( "5" ), "Error handler 5 not found." );

        // special cases

        // one error handler for all versions
        reg.put( DUMMY_CRI_ONE_FOR_ALL, null, null, this.createMockReference( "ForAll" ) );

        // any additional eh
        reg.put( DUMMY_CRI2, "2.0", "3.0", this.createMockReference( "Any" ) );

        InstanceReferenceImpl<MockErrorHandler> mockErrorHandlerForAll = reg.get( DUMMY_CRI_ONE_FOR_ALL, "3.4" );

        verify( ( mockErrorHandlerForAll != null ) && mockErrorHandlerForAll.getInstance( ).getId( ).equals( "ForAll" ), "Error handler ForAll not found." );

        verify( reg.get( DUMMY_CRI_ONE_FOR_ALL, null ) != null, "Error handler ForAll not found." );

        numberOfEh = 0;

        for ( Iterator<InstanceReferenceImpl<MockErrorHandler>> iter = reg.iterator( ); iter.hasNext( ); ) {
            numberOfEh++;
            iter.next( );
        }

        verify( numberOfEh == 5, "Registry iterator should return 5 error handler but returned " + numberOfEh );

        // error handler starting with a given release
        reg.put( DUMMY_CRI_UNLIMITED, "2.0", null, this.createMockReference( "Unlimited" ) );

        InstanceReferenceImpl<MockErrorHandler> mockErrorHandlerUnlimited = reg.get( DUMMY_CRI_UNLIMITED, "3.4" );

        verify( ( mockErrorHandlerUnlimited != null ) && mockErrorHandlerUnlimited.getInstance( ).getId( ).equals( "Unlimited" ), "Error handler Unlimited  not found." );

        verify( reg.get( DUMMY_CRI_UNLIMITED, "1.0" ) == null, "Error handler Unlimited must not be found." );

        verify( reg.get( DUMMY_CRI_UNLIMITED, null ) != null, "Error handler for any version not found." );

    }

    private InstanceReferenceImpl<MockErrorHandler> createMockReference( String value ) {

        InstanceReferenceImpl<MockErrorHandler> reference = new InstanceReferenceImpl<MockErrorHandler>( MockErrorHandler.class.getName( ) );
        reference.setInstance( new MockErrorHandler( value ) );
        return reference;
    }

    class MockErrorHandler implements SpiParserErrorHandler {

        MockErrorHandler( String id ) {

            this.id = id;
        }

        private String id;

        public String getId( ) {

            return id;
        }

        public boolean handleIllegalAttributeValue( SpiParserCallback callback, SpiElement element, String attributeName, Object attributeValue ) {

            // TODO Auto-generated method stub
            return false;
        }

        public boolean handleUnknownAttribute( SpiParserCallback callback, SpiElement element, String attributeName, Object attributeValue ) {

            // TODO Auto-generated method stub
            return false;
        }

        public SpiType handleUnknownType( SpiParserCallback callback, String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

            // TODO Auto-generated method stub
            return null;
        }

        private TestErrorHandlerRegistry getOuterType( ) {

            return TestErrorHandlerRegistry.this;
        }

        @Override
        public int hashCode( ) {

            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType( ).hashCode( );
            result = prime * result + ( ( id == null ) ? 0 : id.hashCode( ) );
            return result;
        }

        @Override
        public boolean equals( Object obj ) {

            if ( this == obj )
                return true;
            if ( obj == null )
                return false;
            if ( getClass( ) != obj.getClass( ) )
                return false;
            MockErrorHandler other = (MockErrorHandler) obj;
            if ( !getOuterType( ).equals( other.getOuterType( ) ) )
                return false;
            if ( id == null ) {
                if ( other.id != null )
                    return false;
            } else if ( !id.equals( other.id ) )
                return false;
            return true;
        }

    }

}
