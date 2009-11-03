package com.sap.tc.moin.js.query.service.client.test;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.easymock.EasyMock;
import org.easymock.IArgumentMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.js.query.service.GetFacilitiesResponse;
import com.sap.tc.moin.js.query.service.KVList;
import com.sap.tc.moin.js.query.service.ObjectFactory;
import com.sap.tc.moin.js.query.service.ProcessError;
import com.sap.tc.moin.js.query.service.ProcessReport;
import com.sap.tc.moin.js.query.service.ProcessWarning;
import com.sap.tc.moin.js.query.service.Query;
import com.sap.tc.moin.js.query.service.QueryExecutionFault;
import com.sap.tc.moin.js.query.service.QueryFormatFault;
import com.sap.tc.moin.js.query.service.WsColumnType;
import com.sap.tc.moin.js.query.service.WsQueryScope;
import com.sap.tc.moin.js.query.service.WsResultObject;
import com.sap.tc.moin.js.query.service.WsResultRow;
import com.sap.tc.moin.js.query.service.WsResultSet;
import com.sap.tc.moin.js.query.service.WsStackTraceElement;
import com.sap.tc.moin.js.query.service.WsThrowable;
import com.sap.tc.moin.js.query.service.client.QsResourceIdentifierConstants;
import com.sap.tc.moin.js.query.service.client.RemoteMqlProcessor;
import com.sap.tc.moin.js.query.service.client.impl.Localization;
import com.sap.tc.moin.js.query.service.client.impl.StringWrapperResourceIdentifierFactory;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.mql.MQLColumnType;
import com.sap.tc.moin.repository.mql.MQLExecutionException;
import com.sap.tc.moin.repository.mql.MQLFormatException;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.test.testcase.MoinTestCase;


/**
 * White box test cases for the Query Service Client implementation of MOIN's
 * Team Server.
 * 
 * @see com.sap.tc.moin.js.query.service.client.RemoteMqlProcessor
 * @see com.sap.tc.moin.js.query.service.Query
 * @author D044522
 */
@SuppressWarnings( "nls" )
public class TestQueryServiceClient extends MoinTestCase {


    /**
     * We use real existing MRIs to be realistic and prevent Exceptions from
     * MOIN.
     */
    private static final String MRI_MOF_CLASS = "PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Model.moinmm#45ED2E29E9B8C271FD484D6E2F52CCB9570C451A";

    private static final String MRI_MOF_ME = "PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Model.moinmm#45ED2E29E74CDCD7A3A740730A6FABA486D5A78D";

    /**
     * The implementation class of
     * {@link com.sap.tc.moin.js.query.service.client.RemoteMqlProcessor} we use
     * for this test.
     */
    private static final String MQL_PROCESSOR_IMPL_CLASS = "com.sap.tc.moin.js.query.service.client.impl.WsMqlProcessorImpl";

    private static final String RI_FACTORY_IMPL_CLASS = "com.sap.tc.moin.js.query.service.client.impl.StringWrapperResourceIdentifierFactory";

    private static final ObjectFactory of = new ObjectFactory( );

    /**
     * Mock WS Proxy
     */
    private Query servicePort;

    /**
     * Component under test
     */
    private RemoteMqlProcessor rmp;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        servicePort = createStrictMock( Query.class );

        // set up the RemoteMqlProcessor and connect it to the mock        
        rmp = getRemoteMqlProcessor( servicePort );

    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        rmp = null;
        servicePort = null;
        super.afterTestMethod( );

    }

    /**
     * Test if all arguments and return values are passed correctly.
     * 
     * @throws Exception if something went wrong
     */
    @Test
    public void querySimpleArgs( ) throws Exception {

        // set up the mock servicePort
        final WsResultSet rwrs = of.createWsResultSet( );
        final String[] attribs = new String[] { null, "names", "id" };
        final String[] typeNames = new String[] { "SomeModel::SomeClass", "String", "Integer" };
        final boolean[] ms = new boolean[] { false, true, false };
        final boolean[] os = new boolean[] { false, true, false };
        final boolean[] us = new boolean[] { false, true, false };
        for ( int i = 0; i < attribs.length; i++ ) {
            final WsColumnType wct = of.createWsColumnType( );
            wct.setAlias( "c" );
            wct.setAttribute( attribs[i] );
            wct.setTypeName( typeNames[i] );
            wct.setMultiValued( ms[i] );
            wct.setOrdered( os[i] );
            wct.setUnique( us[i] );
            rwrs.getColumnType( ).add( wct );
        }
        final String[] mvs = new String[] { "a", "b", "c" };
        // 2 lines, 3 columns as above
        final String[][] svs = new String[][] { { MRI_MOF_CLASS, null, "4711" }, { MRI_MOF_ME, null, "815" } };
        for ( int l = 0; l < svs.length; l++ ) {
            final WsResultRow wrr = of.createWsResultRow( );
            for ( int c = 0; c < svs[l].length; c++ ) {
                final WsResultObject wro = of.createWsResultObject( );
                wro.setSimple( svs[l][c] );
                if ( wro.getSimple( ) == null ) {
                    for ( int i = 0; i < mvs.length; i++ ) {
                        wro.getMulti( ).add( mvs[i] );
                    }
                }
                wrr.getCell( ).add( wro );
            }
            rwrs.getResultRow( ).add( wrr );
        }
        final String moinQuery = "some arbitrary query string";
        expect( servicePort.executeQuery( eq( moinQuery ), WsQueryScopeEquals.eqWsQueryScope( of.createWsQueryScope( ) ), eq( Integer.valueOf( RemoteMqlProcessor.RESULTS_UNLIMITED ) ) ) ).andReturn( rwrs );
        replay( servicePort );

        // execute the query
        final MQLResultSet mrw = rmp.execute( moinQuery, null, null, null, RemoteMqlProcessor.SCOPE_GLOBAL, RemoteMqlProcessor.RESULTS_UNLIMITED );

        // check that the mock WS has actually been called
        EasyMock.verify( servicePort );
        assertNotNull( mrw );
        assertFalse( mrw.isEmpty( ) );
        MQLColumnType[] cts = mrw.getQueryColumnTypes( );
        assertEquals( 3, cts.length );
        for ( int i = 0; i < cts.length; i++ ) {
            assertEquals( rwrs.getColumnType( ).get( i ).getAlias( ), cts[i].alias );
            assertEquals( rwrs.getColumnType( ).get( i ).getAttribute( ), cts[i].attribute );
            assertEquals( rwrs.getColumnType( ).get( i ).getTypeName( ), cts[i].typeName );
            assertEquals( rwrs.getColumnType( ).get( i ).isMultiValued( ), cts[i].multiValued );
            assertEquals( rwrs.getColumnType( ).get( i ).isOrdered( ), cts[i].isOrdered );
            assertEquals( rwrs.getColumnType( ).get( i ).isUnique( ), cts[i].isUnique );
        }
        assertEquals( 2, mrw.getSize( ) );
        for ( int l = 0; l < 2; l++ ) {
            for ( int c = 0; c < 3; c++ ) {
                if ( cts[c].attribute != null ) {
                    if ( cts[c].multiValued ) {
                        final Object[] rMvs = (Object[]) mrw.getAttribute( l, cts[c].alias, cts[c].attribute );
                        for ( int i = 0; i < rMvs.length; i++ ) {
                            assertEquals( mvs[i], rMvs[i] );
                        }
                    } else {
                        assertEquals( rwrs.getResultRow( ).get( l ).getCell( ).get( c ).getSimple( ), mrw.getAttribute( l, cts[c].alias, cts[c].attribute ).toString( ) );
                    }
                } // getMri tested below!
            }
            Object[] as = mrw.getAttributes( l, "c" );
            assertEquals( svs[l][2], as[2] );
        }
        try {
            mrw.getRefObject( 0, "c" );
            fail( "getRefObject not supported" );
        } catch ( UnsupportedOperationException usoe ) {
            assertNotNull( usoe );
        }
        final MRI[] mris = mrw.getMris( "c" );
        final ResourceIdentifierFactory rif = getRiFactory( );
        for ( int i = 0; i < mris.length; i++ ) {
            final MRI rMri = rif.createMri( svs[i][0] );
            assertEquals( rMri, mris[i] );
        }
        try {
            mrw.getRefObjects( "c" );
            fail( "getRefObjects not supported" );
        } catch ( UnsupportedOperationException usoe ) {
            assertNotNull( usoe );
        }
        assertEquals( 1, mrw.removeRow( 1 ) );
        assertNotNull( mrw.toString( ) );
    }

    /**
     * Test transformation of QueryExecutionFault to MQLExecutionException
     */
    @Test
    public void queryExecutionFaultToMQLExecutionException( ) throws Exception {

        // set up the mock servicePort
        final String moinQuery = "some arbitrary query string";
        final String excMsg = "some msg";
        final QueryExecutionFault myQueryExecutionFault = new QueryExecutionFault( excMsg, null );
        expect( servicePort.executeQuery( eq( moinQuery ), WsQueryScopeEquals.eqWsQueryScope( of.createWsQueryScope( ) ), eq( Integer.valueOf( RemoteMqlProcessor.RESULTS_UNLIMITED ) ) ) ).andThrow( myQueryExecutionFault );
        replay( servicePort );

        try {
            // execute the query
            rmp.execute( moinQuery, null, null, null, RemoteMqlProcessor.SCOPE_GLOBAL, RemoteMqlProcessor.RESULTS_UNLIMITED );
            fail( "MQLExecutionException expected" );
        } catch ( MQLExecutionException mee ) {
            assertEquals( Localization.TEAM_SERVER_RETURNED_EXCEPTION.format( excMsg ), mee.getMessage( ) );

        }

        // check that the mock WS has actually been called
        EasyMock.verify( servicePort );

    }

    /**
     * Test transformation of QueryFormatFault to MQLFormatException
     */
    @Test
    public void queryFormatFaultToMQLFormatException( ) throws Exception {

        // set up the mock servicePort
        final String moinQuery = "some arbitrary query string";
        final int numErr = 2;
        final int numWrn = 3;
        final ProcessReport wsPr = of.createProcessReport( );
        // status: failed
        wsPr.setProcessStatus( com.sap.tc.moin.repository.ProcessReport.FAILED );
        final String errMsg = "Some error";
        final List<ProcessError> lWsPE = wsPr.getErrors( );
        final WsThrowable rootCause = of.createWsThrowable( );
        rootCause.setCause( rootCause );
        final WsStackTraceElement wse = of.createWsStackTraceElement( );
        wse.setClassName( MQL_PROCESSOR_IMPL_CLASS );
        final String seFileName = "somefile.jar";
        wse.setFileName( seFileName );
        wse.setLineNumber( 1 );
        final String seMethodName = "someMethod()";
        wse.setMethodName( seMethodName );
        rootCause.getStackTrace( ).add( wse );
        for ( int i = 0; i < numErr; i++ ) {
            final ProcessError o = of.createProcessError( );
            o.setRootCause( rootCause );
            o.setMessage( errMsg );
            o.setStartLine( 1 );
            o.setStartColumn( 2 );
            o.setStartPosition( 3 );
            o.setEndLine( 4 );
            o.setEndColumn( 5 );
            o.setEndPosition( 6 );
            lWsPE.add( o );
        }
        final String wrnMsg = "Some warning";
        final List<ProcessWarning> lWsPW = wsPr.getWarnings( );
        for ( int i = 0; i < numWrn; i++ ) {
            final ProcessWarning o = of.createProcessWarning( );
            o.getStackTrace( ).add( wse );
            o.setMessage( wrnMsg );
            o.setStartLine( 1 );
            o.setStartColumn( 2 );
            o.setStartPosition( 3 );
            o.setEndLine( 4 );
            o.setEndColumn( 5 );
            o.setEndPosition( 6 );
            lWsPW.add( o );
        }
        // param "message" is insubstantial: it will be computed from the ProcessReport in the 2nd param.
        final QueryFormatFault myQueryFormatFault = new QueryFormatFault( null, wsPr );
        expect( servicePort.executeQuery( eq( moinQuery ), WsQueryScopeEquals.eqWsQueryScope( of.createWsQueryScope( ) ), eq( Integer.valueOf( RemoteMqlProcessor.RESULTS_UNLIMITED ) ) ) ).andThrow( myQueryFormatFault );
        replay( servicePort );

        try {
            // execute the query
            rmp.execute( moinQuery, null, null, null, RemoteMqlProcessor.SCOPE_GLOBAL, RemoteMqlProcessor.RESULTS_UNLIMITED );
            fail( "MQLFormatException expected" );
        } catch ( MQLFormatException mee ) {
            com.sap.tc.moin.repository.ProcessReport mPR = mee.getPreparationReport( );
            assertEquals( com.sap.tc.moin.repository.ProcessReport.FAILED, mPR.getProcessStatus( ) );
            List<com.sap.tc.moin.repository.ProcessError> lMPR = mPR.getErrors( );
            assertEquals( numErr, lMPR.size( ) );
            assertEquals( errMsg, lMPR.get( 1 ).getMessage( ) );
            assertEquals( 1, lMPR.get( 1 ).getStartLine( ) );
            assertEquals( 2, lMPR.get( 1 ).getStartColumn( ) );
            assertEquals( 3, lMPR.get( 1 ).getStartPosition( ) );
            assertEquals( 4, lMPR.get( 1 ).getEndLine( ) );
            assertEquals( 5, lMPR.get( 1 ).getEndColumn( ) );
            assertEquals( 6, lMPR.get( 1 ).getEndPosition( ) );
            assertEquals( MQL_PROCESSOR_IMPL_CLASS, lMPR.get( 1 ).getRootCause( ).getStackTrace( )[0].getClassName( ) );
            assertEquals( seFileName, lMPR.get( 1 ).getRootCause( ).getStackTrace( )[0].getFileName( ) );
            assertEquals( seMethodName, lMPR.get( 1 ).getRootCause( ).getStackTrace( )[0].getMethodName( ) );
            assertEquals( 1, lMPR.get( 1 ).getRootCause( ).getStackTrace( )[0].getLineNumber( ) );
            assertNotNull( lMPR.get( 1 ).getRootCause( ).getCause( ) );
            List<com.sap.tc.moin.repository.ProcessWarning> lMPW = mPR.getWarnings( );
            assertEquals( numWrn, lMPW.size( ) );
            assertEquals( wrnMsg, lMPW.get( 1 ).getMessage( ) );
            assertEquals( 1, lMPW.get( 1 ).getStartLine( ) );
            assertEquals( 2, lMPW.get( 1 ).getStartColumn( ) );
            assertEquals( 3, lMPW.get( 1 ).getStartPosition( ) );
            assertEquals( 4, lMPW.get( 1 ).getEndLine( ) );
            assertEquals( 5, lMPW.get( 1 ).getEndColumn( ) );
            assertEquals( 6, lMPW.get( 1 ).getEndPosition( ) );
            assertEquals( MQL_PROCESSOR_IMPL_CLASS, lMPW.get( 1 ).getStackTrace( )[0].getClassName( ) );
        }

        // check that the mock WS has actually been called
        EasyMock.verify( servicePort );
    }

    /**
     * Test transmission of complex Query Arguments (CRI, PRI, etc.)
     * 
     * @throws Exception
     */
    @Test
    public void queryComplexArgs( ) throws Exception {

        final ResourceIdentifierFactory rif = getRiFactory( );
        final MRI mri1 = rif.createMri( MRI_MOF_CLASS );
        final WsQueryScope scope = of.createWsQueryScope( );
        scope.getContainerScope( ).add( mri1.getCri( ).toString( ) );
        scope.getDataAreaScope( ).add( mri1.getDataAreaDescriptor( ).toString( ) );
        scope.getPartitionScope( ).add( mri1.getPri( ).toString( ) );
        scope.setScopeOperation( 1 );
        final String query = "somequery";

        expect( servicePort.executeQuery( eq( query ), WsQueryScopeEquals.eqWsQueryScope( scope ), eq( -1 ) ) ).andReturn( of.createWsResultSet( ) );
        replay( servicePort );

        final MQLResultSet mrs = rmp.execute( query, new PRI[] { mri1.getPri( ) }, new CRI[] { mri1.getCri( ) }, new DataAreaDescriptor[] { mri1.getDataAreaDescriptor( ) }, 1, -1 );
        assertEquals( 0, mrs.getSize( ) );
        assertEquals( 0, mrs.getQueryColumnTypes( ).length );

        EasyMock.verify( servicePort );
    }

    /**
     * Test getFacilities()
     * 
     * @throws Exception
     */
    @Test
    public void getFacilities( ) throws Exception {

        final String PF = "PF";
        final GetFacilitiesResponse gfr = of.createGetFacilitiesResponse( );
        gfr.getFacilityId( ).add( PF );
        expect( servicePort.getFacilities( null ) ).andReturn( gfr );
        replay( servicePort );

        // execute the query
        final List<String> flw = rmp.getFacilities( );
        assertEquals( PF, flw.get( 0 ) );

        // check that the mock WS has actually been called
        EasyMock.verify( servicePort );
    }

    /**
     * Test transmission of DataAreas
     * 
     * @throws Exception
     */
    @Test
    public void getDataAreas( ) throws Exception {

        final String PF = "PF";
        final StringWrapperResourceIdentifierFactory rif = (StringWrapperResourceIdentifierFactory) getRiFactory( );
        final List<String> value = of.createGetDataAreasResponse( ).getDataAreaDescriptor( );
        for ( int i = 0; i < 3; i++ ) {
            value.add( rif.createDataAreaDescriptor( PF, String.valueOf( i ) ).toString( ) );
        }
        expect( servicePort.getDataAreas( PF ) ).andReturn( value );
        replay( servicePort );

        //execute the query
        final List<DataAreaDescriptor> dads = rmp.getDataAreas( PF );
        assertEquals( 3, dads.size( ) );
        for ( int i = 0; i < 3; i++ ) {
            assertEquals( String.valueOf( i ), dads.get( i ).getDataAreaName( ) );
        }

        // check that the mock WS has actually been called
        EasyMock.verify( servicePort );
    }

    /**
     * Test conversion of property bags in
     * {@link Query#getDataArea(com.sap.tc.moin.js.query.service.KVList)} and
     * {@link Query#getDataAreaConfig(String)}.
     * 
     * @throws Exception
     */
    @Test
    public void dataAreaCfg( ) throws Exception {

        final ResourceIdentifierFactory rif = getRiFactory( );
        final MRI mri1 = rif.createMri( MRI_MOF_CLASS );
        final KVList.Entry kvle = of.createKVListEntry( );
        kvle.setKey( QsResourceIdentifierConstants.DEV_CONF_NAME );
        kvle.setValue( mri1.getDataAreaDescriptor( ).getDataAreaName( ) );
        final KVList value = of.createKVList( );
        value.getEntry( ).add( kvle );
        expect( servicePort.getDataAreaConfig( mri1.getDataAreaDescriptor( ).toString( ) ) ).andReturn( value );
        replay( servicePort );

        // execute the query
        final Map<String, String> daCfg = rmp.getDataAreaConfig( mri1.getDataAreaDescriptor( ) );
        assertEquals( mri1.getDataAreaDescriptor( ).getDataAreaName( ), daCfg.get( QsResourceIdentifierConstants.DEV_CONF_NAME ) );

        // check that the mock WS has actually been called
        EasyMock.verify( servicePort );

        // now vice-versa
        servicePort = createStrictMock( Query.class );
        rmp = getRemoteMqlProcessor( servicePort );

        expect( servicePort.getDataArea( KVListEquals.eqKVList( value ) ) ).andReturn( mri1.getDataAreaDescriptor( ).toString( ) );
        replay( servicePort );

        final DataAreaDescriptor dad = rmp.getDataArea( daCfg );
        assertEquals( mri1.getDataAreaDescriptor( ), dad );

        EasyMock.verify( servicePort );
    }

    /**
     * Test ResourceBundle access at runtime.
     * 
     * @throws Exception
     */
    @Test
    public void msgLocalization( ) throws Exception {

        Locale EN_US = new Locale( "EN", "US" );
        assertEquals( "Remote model elements cannot be resolved directly to RefObjects", Localization.REMOTE_ME_CANNOT_BE_RESOLVED.getLocalizedMessage( EN_US ) );
    }

    /**
     * Test
     * {@link com.sap.tc.moin.js.query.client.impl.StringWrapperResourceIdentifierFactory}
     * .
     * 
     * @throws Exception
     */
    @Test
    public void createStringWrappers( ) throws Exception {

        final ResourceIdentifierFactory rif = getRiFactory( );
        MRI mri1 = rif.createMri( MRI_MOF_CLASS );
        MRI mri2 = rif.createMri( mri1.getDataAreaDescriptor( ).getDataAreaName( ), mri1.getContainerName( ), mri1.getPartitionName( ), mri1.getMofId( ) );
        assertEquals( mri1, mri2 );
        PRI pri1 = mri1.getPri( );
        PRI pri2 = rif.createPri( pri1.toString( ) );
        PRI pri3 = rif.createPri( pri2.getDataAreaDescriptor( ).getDataAreaName( ), pri2.getContainerName( ), pri2.getPartitionName( ) );
        assertEquals( pri1, pri2 );
        assertEquals( pri2, pri3 );
        mri2 = pri1.createMri( mri1.getMofId( ) );
        assertEquals( mri1, mri2 );
        LRI lri1 = mri1.getLri( );
        LRI lri2 = rif.createLri( lri1.toString( ) );
        LRI lri3 = rif.createLri( lri2.getDataAreaDescriptor( ).getDataAreaName( ), lri2.getMofId( ) );
        assertEquals( lri1, lri2 );
        assertEquals( lri2, lri3 );
        CRI cri1 = mri1.getCri( );
        CRI cri2 = rif.createCri( cri1.toString( ) );
        CRI cri3 = rif.createCri( cri2.getDataAreaDescriptor( ).getDataAreaName( ), cri2.getContainerName( ) );
        assertEquals( cri1, cri2 );
        assertEquals( cri2, cri3 );
        DataAreaDescriptor dad = StringWrapperResourceIdentifierFactory.getInstance( ).createDataAreaDescriptor( cri1.getDataAreaDescriptor( ).getFacilityId( ), cri1.getDataAreaDescriptor( ).getDataAreaName( ) );
        assertEquals( cri1.getDataAreaDescriptor( ), dad );
    }

    @SuppressWarnings( "unchecked" )
    private static RemoteMqlProcessor getRemoteMqlProcessor( Query q ) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException {

        final Class wmpi = Class.forName( MQL_PROCESSOR_IMPL_CLASS );
        return (RemoteMqlProcessor) wmpi.getConstructor( Query.class ).newInstance( q );
    }

    @SuppressWarnings( "unchecked" )
    private static ResourceIdentifierFactory getRiFactory( ) throws ClassNotFoundException, IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        final Class rif = Class.forName( RI_FACTORY_IMPL_CLASS );
        return (ResourceIdentifierFactory) rif.getMethod( "getInstance", (Class[]) null ).invoke( (Object) null, (Object[]) null );
    }

    /**
     * EasyMock Helper for comparing WsQueryScopes (which do not have an equals
     * method).
     * 
     * @author D044522
     */
    public static class WsQueryScopeEquals implements IArgumentMatcher {

        private final WsQueryScope expected;

        public WsQueryScopeEquals( WsQueryScope expected ) {

            this.expected = expected;
        }

        public void appendTo( StringBuffer buffer ) {

            buffer.append( "eqWsQueryScope(" );
            buffer.append( expected.getClass( ).getName( ) );
            buffer.append( " with containerScope \"" );
            buffer.append( Arrays.toString( expected.getContainerScope( ).toArray( ) ) );
            buffer.append( "\", partitionScope \"" );
            buffer.append( Arrays.toString( expected.getPartitionScope( ).toArray( ) ) );
            buffer.append( "\", dataAreaScope \"" );
            buffer.append( Arrays.toString( expected.getDataAreaScope( ).toArray( ) ) );
            buffer.append( "\", scopeOperation \"" );
            buffer.append( expected.getScopeOperation( ) );
            buffer.append( "\")" );
        }

        public boolean matches( Object actual ) {

            if ( !( actual instanceof WsQueryScope ) ) {
                return false;
            }
            List<String> acs = ( (WsQueryScope) actual ).getContainerScope( );
            List<String> aps = ( (WsQueryScope) actual ).getPartitionScope( );
            List<String> adc = ( (WsQueryScope) actual ).getDataAreaScope( );
            int so = ( (WsQueryScope) actual ).getScopeOperation( );
            return expected.getClass( ).equals( actual.getClass( ) ) && expected.getScopeOperation( ) == so && expected.getContainerScope( ).equals( acs ) && expected.getPartitionScope( ).equals( aps ) && expected.getDataAreaScope( ).equals( adc );
        }

        public static WsQueryScope eqWsQueryScope( WsQueryScope expected ) {

            EasyMock.reportMatcher( new WsQueryScopeEquals( expected ) );
            return null;
        }

    }

    public static class KVListEquals implements IArgumentMatcher {

        private final KVList expected;

        public KVListEquals( KVList expected ) {

            this.expected = expected;
        }

        public void appendTo( StringBuffer buffer ) {

            buffer.append( "eqKVList(" );
            buffer.append( expected.getClass( ).getName( ) );
            buffer.append( "\")" );

        }

        public boolean matches( Object actual ) {

            if ( !( actual instanceof KVList ) ) {
                return false;
            }

            for ( KVList.Entry e : expected.getEntry( ) ) {
                boolean found = false;
                for ( KVList.Entry a : ( (KVList) actual ).getEntry( ) ) {
                    if ( e.getKey( ).equals( a.getKey( ) ) && e.getValue( ).equals( a.getValue( ) ) ) {
                        found = true;
                        break;
                    }
                }
                if ( !found )
                    return false;
            }

            return true;
        }

        public static KVList eqKVList( KVList expected ) {

            EasyMock.reportMatcher( new KVListEquals( expected ) );
            return null;
        }
    }

}
