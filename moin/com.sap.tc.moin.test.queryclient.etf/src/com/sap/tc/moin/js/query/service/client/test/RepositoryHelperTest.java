package com.sap.tc.moin.js.query.service.client.test;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.easymock.EasyMock;
import org.eclipse.core.resources.IProject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.ide.dii05.lib.api.util.DiiModelService;
import com.sap.ide.dii05.model.api.IComponentModel;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.model.api.IDevelopmentConfiguration;
import com.sap.ide.dii05.model.api.ISoftwareComponent;
import com.sap.ide.dii05.model.api.OnlineState;
import com.sap.junit.CheckPropertyFile;
import com.sap.junit.Staged;
import com.sap.tc.moin.js.query.service.client.QsResourceIdentifierConstants;
import com.sap.tc.moin.js.query.service.client.RemoteMqlProcessor;
import com.sap.tc.moin.js.query.service.client.impl.StringWrapperResourceIdentifierFactory;
import com.sap.tc.moin.query.repository.LocalMoinTranslater;
import com.sap.tc.moin.query.repository.RepositoryHelper;
import com.sap.tc.moin.query.repository.RepositoryHelperFactory;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.test.fw.ide.DcModificationUtil;
import com.sap.tc.moin.test.fw.ide.DiTrackUtil;
import com.sap.tc.moin.test.fw.ide.IdeRuntimeTestHelper;
import com.sap.tc.moin.test.testcase.MoinTestCase;


/**
 * Tests the implementation of {@link RepositoryHelper} and
 * {@link RepositoryHelperFactory}.
 * 
 * @author D044522
 */
@SuppressWarnings( "nls" )
public class RepositoryHelperTest extends MoinTestCase {

    /**
     * Mock {@link RemoteMqlProcessor}.
     */
    private RemoteMqlProcessor rmp = null;

    /**
     * Component under test.
     */
    private RepositoryHelper rh = null;

    private final static DiTrackUtil dtu = ( (IdeRuntimeTestHelper) getTestHelper( ) ).getDiTrackUtil( );

    private final static DcModificationUtil dmu = ( (IdeRuntimeTestHelper) getTestHelper( ) ).getDcModificationUtil( );

    private final static StringWrapperResourceIdentifierFactory swrif = StringWrapperResourceIdentifierFactory.getInstance( );

    public static final String TEST_DC_VENDOR = "sap.com";

    public static final String TEST_SC_NAME = "HM-BPEM-TEST";

    //public static final String TEST_DC_NAME = "test/queryserver/glx";
    public static final String TEST_DC_NAME = "test/queryserver/moin";

    //public static final String TEST_PARTITION_PATH = "src/bpmn/myprocess.bpmn";
    public static final String TEST_PARTITION_PATH = "moin/meta/Metamodel.moinmm";

    //public static final String TEST_MOFID = "492D517293D06A40BBBF11DDBF39001558C93B55";
    public static final String TEST_MOFID = "492D6B2AE7FFC8E0BBCE11DDCDE9001558C93B55";

    public static final String KEY_DEV_CONF_NAME = "ext.sys.test.nwdi.devConfigurationName";

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        rmp = createStrictMock( RemoteMqlProcessor.class );
        final RepositoryHelperFactory rhf = new RepositoryHelperFactory( );
        rh = rhf.createRepositoryHelper( QsResourceIdentifierConstants.PRIMARY_FACILITY_ID, rmp );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        rmp = null;
        rh = null;
        super.afterTestMethod( );
    }


    // importDevConfig fails inexplicably :-(
//    @BeforeClass
//    public static void importDevConfig( ) throws Exception {
//
//        final InputStream is = RepositoryHelperTest.class.getClassLoader( ).getResourceAsStream( "resources/nwdi.properties" );
//        final Properties p = new Properties( );
//        try {
//            p.load( is );
//        } finally {
//            is.close( );
//        }
//        System.setProperties( p );
//        // importing DevConfigs is expensive!!! do it only once in the first method
//        dtu.importDevConfig( );
//    }

    // CheckPropertyFile does not work on static @BeforeClass methods :-(
    @CheckPropertyFile( { "devtest.masstest.properties", "ext.", "moinnwdiparams" } )
    @Test
    @Staged
    public void importDevConfig( ) throws Exception {

        // importing DevConfigs is expensive!!! do it only once in the first method
        dtu.importDevConfig( );
    }

    @Test
    @Staged
    public void filterDevelopmentConfigurations( ) throws Exception {

        final IComponentModel cm = DiiModelService.getComponentModel( );
        final IDevelopmentConfiguration[] devConfs = DiiModelService.getDevelopmentConfigurations( cm, DiiModelService.NO_REFRESH );
        assertTrue( "No DevelopmentConfigurations found", devConfs != null && devConfs.length > 0 );

        final List<DataAreaDescriptor> rdads = new ArrayList<DataAreaDescriptor>( 2 );
        rdads.add( swrif.createDataAreaDescriptor( QsResourceIdentifierConstants.PRIMARY_FACILITY_ID, devConfs[0].getName( ) ) );
        rdads.add( swrif.createDataAreaDescriptor( QsResourceIdentifierConstants.PRIMARY_FACILITY_ID, "SomeRemoteDevConf" ) );

        expect( rmp.getDataAreas( QsResourceIdentifierConstants.PRIMARY_FACILITY_ID ) ).andReturn( rdads );
        replay( rmp );

        final List<IDevelopmentConfiguration> rLst = rh.filterDevelopmentConfigurations( Arrays.asList( devConfs ) );

        EasyMock.verify( rmp );

        assertNotNull( "No intersecting devConfs", rLst );
        assertEquals( "Wrong # of devConfs" + rLst.size( ), 1, rLst.size( ) );
        assertEquals( devConfs[0].getName( ), rLst.get( 0 ).getName( ) );
    }

    @Test
    @Staged
    public void getDevelopmentConfigurationForDataArea( ) throws Exception {

        final String dataAreaName = System.getProperty( KEY_DEV_CONF_NAME );
        final DataAreaDescriptor dad = swrif.createDataAreaDescriptor( QsResourceIdentifierConstants.PRIMARY_FACILITY_ID, dataAreaName );
        final IDevelopmentConfiguration devConf = rh.getDevelopmentConfigurationForDataArea( dad );
        assertNotNull( devConf );
        assertEquals( dataAreaName, devConf.getName( ) );
    }

    @Test
    @Staged
    public void getDataAreaForDevelopmentConfiguration( ) throws Exception {

        final IDevelopmentConfiguration devconf = dtu.getDevConfig( );
        assertNotNull( "DevelopmentConfiguration not found", devconf );

        expect( rmp.getResourceIdentifierFactory( ) ).andReturn( swrif );
        replay( rmp );

        DataAreaDescriptor dad = rh.getDataAreaForDevelopmentConfiguration( devconf );

        EasyMock.verify( rmp );

        assertNotNull( dad );
        assertEquals( devconf.getName( ), dad.getDataAreaName( ) );
    }

    @Test
    @Staged
    public void getContainerForDevelopmentComponent( ) throws Exception {

        final IDevelopmentConfiguration devConf = dtu.getDevConfig( );
        assertEquals( "DevConf has to be online to enable refresh of child nodes. Try cleaning your workspace!", OnlineState.ONLINE_LITERAL, devConf.getOnlineState( ) );
        final String dcName = TEST_DC_NAME;
        final String dcVendor = TEST_DC_VENDOR;
        // DiiUtil.getDc automatically refreshes DiiModel if required.
        //IDevelopmentComponent dc = DiiUtil.getDc( dcVendor, dcName, devConf, true );
        //IDevelopmentComponent dc = DiiModelService.getDcByNameAndVendor( devConf, dcName, dcVendor );
        // local getDC() including scName works much faster! 
        IDevelopmentComponent dc = getDC( devConf, TEST_SC_NAME, dcVendor, dcName );
        assertNotNull( "DC not found: " + dcName, dc );

        expect( rmp.getResourceIdentifierFactory( ) ).andReturn( swrif );
        replay( rmp );

        final CRI cri = rh.getContainerForDevelopmentComponent( dc );

        EasyMock.verify( rmp );

        assertNotNull( cri );
        assertEquals( devConf.getName( ), cri.getDataAreaDescriptor( ).getDataAreaName( ) );
        assertTrue( cri.getContainerName( ).startsWith( dcVendor ) );
        assertTrue( cri.getContainerName( ).endsWith( dcName ) );
    }

    @Test
    @Staged
    public void getDevelopmentComponentForContainer( ) throws Exception {

        final IDevelopmentConfiguration devConf = dtu.getDevConfig( );
        assertEquals( "DevConf has to be online to enable refresh of child nodes. Try cleaning your workspace!", OnlineState.ONLINE_LITERAL, devConf.getOnlineState( ) );
        final String dataAreaName = System.getProperty( KEY_DEV_CONF_NAME );
        assertTrue( "Property not set: " + KEY_DEV_CONF_NAME, ( dataAreaName != null && dataAreaName.length( ) > 0 ) );
        final String dcName = TEST_DC_NAME;
        final String containerName = TEST_DC_VENDOR + '/' + dcName;
        final CRI cri = swrif.createCri( QsResourceIdentifierConstants.PRIMARY_FACILITY_ID, dataAreaName, containerName );
        final IDevelopmentComponent dc = rh.getDevelopmentComponentForContainer( cri );
        assertNotNull( "DC not found: " + dcName, dc );
        assertEquals( dcName, dc.getName( ) );
    }

    @Test
    @Staged
    public void getLocalMri( ) throws Exception {

        final IDevelopmentConfiguration devConf = dtu.getDevConfig( );
        assertEquals( "DevConf has to be online to enable refresh of child nodes. Try cleaning your workspace!", OnlineState.ONLINE_LITERAL, devConf.getOnlineState( ) );
        final String dcName = TEST_DC_NAME;
        final String dcVendor = TEST_DC_VENDOR;
        IDevelopmentComponent dc = getDC( devConf, TEST_SC_NAME, dcVendor, dcName );
        assertNotNull( "DC not found: " + dcName, dc );

        final IProject prj = dmu.getOrCreateProjectForExistingDc( dc, false );
        assertNotNull( "DC project not imported", prj );

        final String dataAreaName = System.getProperty( KEY_DEV_CONF_NAME );
        assertTrue( "Property not set: " + KEY_DEV_CONF_NAME, ( dataAreaName != null && dataAreaName.length( ) > 0 ) );

        final MRI remote = swrif.createMri( QsResourceIdentifierConstants.PRIMARY_FACILITY_ID, dataAreaName, dcVendor + '/' + dcName, TEST_PARTITION_PATH, TEST_MOFID );

        expect( rmp.getResourceIdentifierFactory( ) ).andReturn( swrif );
        replay( rmp );

        final LocalMoinTranslater lmt = rh.getLocalMoinTranslater( getInstance( ) );

        EasyMock.verify( rmp );

        // try 5 times to wait 300ms for new project to get indexed by MOIN 
        // see also com.sap.mi.fwk.util.MoinProjectUtil.waitForPathAvailability()
        final int tries = 5;
        MRI local = null;
        for ( int i = 0; local == null && i < tries; i++ ) {
            try {
                local = lmt.getLocalMri( remote );
            } catch ( InvalidResourceIdentifierException e ) {

            }
            if ( local == null )
                Thread.sleep( 300 );
        }

        assertNotNull( "Failed to get local MRI after " + tries + " tries", local );
        assertEquals( remote.getContainerName( ), local.getContainerName( ) );
        assertEquals( remote.getMofId( ), local.getMofId( ) );
        assertEquals( remote.getPartitionName( ), local.getPartitionName( ) );
        // dataAreaName will be different
    }

    @Test
    @Staged
    public void getRemoteMri( ) throws Exception {

        final IDevelopmentConfiguration devConf = dtu.getDevConfig( );
        // local dataAreaName = devConfName[devConfImportId] !!!
        final String dataAreaName = devConf.getName( ) + '[' + devConf.getImportId( ) + ']';


        // try 5 times to wait 300ms for new project to get indexed by MOIN 
        // see also com.sap.mi.fwk.util.MoinProjectUtil.waitForPathAvailability()

        final int tries = 5;
        MRI local = null;
        for ( int i = 0; local == null && i < tries; i++ ) {
            try {
                local = getInstance( ).createMri( QsResourceIdentifierConstants.PRIMARY_FACILITY_ID, dataAreaName, TEST_DC_VENDOR + '/' + TEST_DC_NAME, TEST_PARTITION_PATH, TEST_MOFID );
            } catch ( InvalidResourceIdentifierException e ) {

            }
            if ( local == null )
                Thread.sleep( 300 );
        }
        assertNotNull( "Failed to get local MRI after " + tries + " tries", local );

        expect( rmp.getResourceIdentifierFactory( ) ).andReturn( swrif );
        replay( rmp );

        final LocalMoinTranslater lmt = rh.getLocalMoinTranslater( getInstance( ) );
        final MRI remote = lmt.getRemoteMri( local );

        EasyMock.verify( rmp );

        assertEquals( local.getContainerName( ), remote.getContainerName( ) );
        assertEquals( local.getMofId( ), remote.getMofId( ) );
        assertEquals( local.getPartitionName( ), remote.getPartitionName( ) );
        // dataAreaName will be different
    }


//    @AfterClass
    @Test
    @Staged
    public void cleanupDevConfig( ) throws Exception {

        // importing DevConfigs is expensive!!! clean up only once in the last method
        dtu.cleanupDevConfig( );
    }

    public static IDevelopmentComponent getDC( IDevelopmentConfiguration devConf, String scName, String dcVendor, String dcName ) {

        if ( devConf == null ) {
            return null;
        }
        IDevelopmentComponent dc = DiiModelService.getDcByNameAndVendor( devConf, dcName, dcVendor );
        if ( dc == null ) {
            // DC not yet synced locally --> refresh DII component model!
            final ISoftwareComponent[] scs = DiiModelService.getSoftwareComponents( devConf );
            if ( scs != null && scs.length > 0 ) {
                for ( int i = 0; i < scs.length; i++ ) {
                    final ISoftwareComponent sc = scs[i];
                    if ( sc.getName( ).equals( scName ) ) {
                        DiiModelService.getDevelopmentComponents( sc, DiiModelService.FORCED_REFRESH );
                        //faster than iterating over array and search by dcs[i].getName().equals():
                        dc = DiiModelService.getDcByNameAndVendor( devConf, dcName, dcVendor );
                        if ( dc != null ) {
                            break;
                        }
                    }
                }
            }
        }
        return dc;
    }

}
