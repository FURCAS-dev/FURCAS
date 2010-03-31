package com.sap.tc.moin.repository.performance.test.build;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.test.performance.PerformanceMeter;
import org.junit.Test;

import com.sap.ide.dii05.lib.api.commands.DiiCommandFactory;
import com.sap.ide.dii05.lib.api.core.IDcProject;
import com.sap.ide.dii05.lib.api.modeledit.DiiModelEditService;
import com.sap.ide.dii05.lib.api.modeledit.IMeBuildPlugin;
import com.sap.ide.dii05.lib.api.modeledit.IMeDcDependency;
import com.sap.ide.dii05.lib.api.modeledit.IMeDcMetadataState;
import com.sap.ide.dii05.lib.api.modeledit.IMePublicPartRef;
import com.sap.ide.dii05.lib.api.modeledit.ModelEditFactory;
import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.ui.api.actions.DiiActionFactory;
import com.sap.ide.dii05.util.api.job.JdiJob;
import com.sap.ide.dii05.util.api.job.JobUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.cdam.ide.IdeCompoundDataAreaManager;
import com.sap.tc.moin.repository.filesystem.FileSystemRuntimeHost;
import com.sap.tc.moin.repository.runtimehost.build.MoinFactory;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.test.performance.TestPerfBase;
import com.sap.tc.moin.test.fw.ide.IdeRuntimeTestHelper;
import com.sap.tc.moin.test.testcase.MoinTestCase;


public class TestPerfBuild extends TestPerfBase {


    @Test
    public void testBuildMetaModelDc( ) throws Exception {

        IDevelopmentComponent devComp = setupBuildDc( );

        PerformanceMeter m = createPerformanceMeter( "META_MODEL_BUILD", false, "Performance test for the meta-model DC build." );

        try {

            for ( int i = 0; i < 100; i++ ) {
                m.start( );
                IStatus stat = executeBuild( devComp );
                m.stop( );

                assertTrue( stat.isOK( ) );
            }

            m.commit( );
        } finally {
            m.dispose( );

            JdiJob buildJob = DiiCommandFactory.forDevelopmentComponent( ).create_DeleteDcsJob( new IDevelopmentComponent[] { devComp } );

            IStatus status = JobUtil.syncExec( buildJob, null );

            assertTrue( "Delete job failed.", status.isOK( ) );
        }
    }

    @Test
    public void testBuildMoinInitialization( ) throws Exception {

        PerformanceMeter m = createPerformanceMeter( "MOIN_INITIALIZATION_BUILD_RH", false, "Performance test for the minimal MOIN initialization." );

        try {

            for ( int i = 0; i < 100; i++ ) {
                m.start( );

//                BuildRuntimeHostImpl rh = new BuildRuntimeHostImpl( );
//
//                rh.getMoinInstance( );
//
//                m.stop( );
                FileSystemRuntimeHost rh = MoinFactory.createRTH( );
                MoinFactory.getMoinInstance( rh, null );
//                rh.shutDown( );

                m.stop( );

            }

            m.commit( );

        } finally {
            m.dispose( );
        }
    }

    @SuppressWarnings( "unchecked" )
    private IDevelopmentComponent setupBuildDc( ) throws Exception {

        // Create test DC project and initialize MOIN for it:
        String dcVendor = "sap.com";
        String dcName = "test/moin/metamodel/dc";
        IProject eclipseProject = ( (IdeRuntimeTestHelper) MoinTestCase.getTestHelper( ) ).getOrCreateLocalMoinMetaModelDCProject( dcVendor, dcName );

        SpiClientSpec clientSpec = (SpiClientSpec) ( (IdeCompoundDataAreaManager) getInstance( ).getCompoundDataAreaManager( ) ).getClientSpec( eclipseProject );

        Connection moinConnection = createConnection( );

        ModelPartition part = moinConnection.createPartition( getFacility( ).getRIFactory( ).createPri( clientSpec.getDataArea( ).getName( ), dcVendor + "/" + dcName, "moin/meta/Metamodel.xmi" ) );

        ModelPackage modelPkg = (ModelPackage) moinConnection.getPackage( null, "Model" );

        MofPackage p1 = (MofPackage) modelPkg.getMofPackage( ).refCreateInstance( );
        p1.setName( "p1" );
        p1.setAnnotation( "p1Annotation" );
        p1.setVisibility( VisibilityKindEnum.PUBLIC_VIS );

        MofClass c1 = (MofClass) modelPkg.getMofClass( ).refCreateInstance( );
        c1.setName( "c1" );
        c1.setAnnotation( "c1Annotation" );
        c1.setVisibility( VisibilityKindEnum.PUBLIC_VIS );

        p1.getContents( ).add( c1 );

        for ( Partitionable p : moinConnection.getNullPartition( ).getElements( ) ) {
            p.assign___Partition( part );
        }

        moinConnection.save( );

        IDevelopmentComponent devComp = getDevelopmentComponent( dcVendor, dcName );

        enableMMBuild( devComp );

        return devComp;
    }

    private IStatus executeBuild( IDevelopmentComponent devComp ) throws Exception {

        JdiJob buildJob = DiiCommandFactory.forDevelopmentComponent( ).create_BuildDcsJob( new IDevelopmentComponent[] { devComp }, false );

        return JobUtil.syncExec( buildJob, null );

    }


    private IDevelopmentComponent getDevelopmentComponent( String dcVendor, String dcName ) throws Exception {

        IProject project = ( (IdeRuntimeTestHelper) MoinTestCase.getTestHelper( ) ).getOrCreateLocalMoinMetaModelDCProject( dcVendor, dcName );

        IDcProject dcProject = DiiResourceService.getDcProject( project );

        IDevelopmentComponent devComp = dcProject.getDevelopmentComponent( );

        return devComp;
    }

    @SuppressWarnings( "unchecked" )
    private void enableMMBuild( IDevelopmentComponent developmentComponent ) throws Exception {

        // Get the editable state of the DC
        IMeDcMetadataState state = null;

        state = DiiModelEditService.getEditableState( developmentComponent.getLocalState( ), null );

        // Set the build plugin
        IMeBuildPlugin buildPlugin = state.getBuildPlugin( );
        buildPlugin.setName( "tc/moin/bi/bp/mmbuildplugin" );
        buildPlugin.setVendor( "sap.com" );
        buildPlugin.setPpName( "def" );

        // Add dependency to tc/moin/api
        IMeDcDependency dependency = ModelEditFactory.eINSTANCE.createIMeDcDependency( );
        IMePublicPartRef ppRef = ModelEditFactory.eINSTANCE.createIMePublicPartRef( );
        ppRef.setName( "tc/moin/api" );
        ppRef.setVendor( "sap.com" );
        ppRef.setPpName( "api" );
        dependency.setDcOrPpRef( ppRef );
        dependency.setAtBuildTime( true );
        state.getDependencies( ).add( dependency );

        // Add dependency to tc/moin/jmicore/api
        dependency = ModelEditFactory.eINSTANCE.createIMeDcDependency( );
        ppRef = ModelEditFactory.eINSTANCE.createIMePublicPartRef( );
        ppRef.setName( "tc/moin/jmicore/api" );
        ppRef.setVendor( "sap.com" );
        ppRef.setPpName( "api" );
        dependency.setDcOrPpRef( ppRef );
        dependency.setAtBuildTime( true );
        state.getDependencies( ).add( dependency );

        DiiModelEditService.commitChanges( state );

        DiiActionFactory.forDevelopmentComponent( ).create_SyncUsedDcsAction( new IDevelopmentComponent[] { developmentComponent }, true ).run( null );
    }


}
