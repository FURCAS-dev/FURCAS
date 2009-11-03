package com.sap.tc.moin.test.fw.ide;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;

import com.sap.ide.dii05.lib.api.commands.DiiCommandFactory;
import com.sap.ide.dii05.lib.api.core.IDcProject;
import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.ide.dii05.model.api.BuildState;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.model.api.IDevelopmentConfiguration;
import com.sap.ide.dii05.repository.api.DiiRepositoryService;
import com.sap.ide.dii05.repository.api.IRepositoryService;
import com.sap.ide.dii05.repository.api.ISourceControl;
import com.sap.ide.dii05.ui.api.actions.DiiActionFactory;
import com.sap.ide.dii05.util.api.job.JdiJob;
import com.sap.ide.dii05.util.api.job.JobUtil;


@SuppressWarnings( "nls" )
public class DcBuildUtilImpl implements DcBuildUtil {

    /** *********** Internals *********************************************** */

    private IdeRuntimeTestHelper _ideTestHelper;

    private static boolean USED_DCS_FOR_MM_BUILD_SYNCED = false;

    /** *********** Construction ******************************************** */

    DcBuildUtilImpl( IdeRuntimeTestHelper ideRuntimeTestHelper ) {

        _ideTestHelper = ideRuntimeTestHelper;
    }

    /** *********** API ***************************************************** */


    // Caution:
    // This handling is only valid for local-only MM DCs for which no used DCs (MM federation) have to be synced from DTR / CBS.
    public boolean executeDcBuildForLocalMMDc( String dcVendor, String dcName ) throws Exception {

        IProject project = _ideTestHelper.getOrCreateLocalMoinMetaModelDCProject( dcVendor, dcName );
        IDcProject dcProject = DiiResourceService.getDcProject( project );
        IDevelopmentComponent dc = dcProject.getDevelopmentComponent( );

        if ( isDcUnderSourceControl( project ) ) {
            throw new IllegalArgumentException( "DC is under source control: " + _ideTestHelper.getFullDCName( dcVendor, dcName ) );
        }

        syncUsedDcsNeededForDcBuild( dc );

        JdiJob buildJob = DiiCommandFactory.forDevelopmentComponent( ).create_BuildDcsJob( new IDevelopmentComponent[] { dc }, true );

        IStatus status = JobUtil.syncExec( buildJob, null );
        BuildState buildState = dc.getLocalBuildState( );

        if ( !status.isOK( ) && status.getException( ) != null ) {
            throw new Exception( status.getException( ) );
        }
        return buildState.getValue( ) == BuildState.SUCCESSFULLY_BUILT;
    }

    // Caution:
    // This handling is only valid for local-only MM DCs for which no used DCs (MM federation) have to be synced from DTR / CBS.
    // Remark:
    // DC Build must also be possible for DC without project
    public boolean executeDcBuildForLocalMMDc( IDevelopmentComponent dc ) throws Exception {

        if ( isDcUnderSourceControl( dc ) ) {
            throw new IllegalArgumentException( "DC is under source control: " + _ideTestHelper.getFullDCName( dc.getVendor( ), dc.getName( ) ) );
        }


        // Preparation of DC-Build:
        syncUsedDcsNeededForDcBuild( dc );

        // Execute the DC-build in a JDI-job:
        JdiJob buildJob = DiiCommandFactory.forDevelopmentComponent( ).create_BuildDcsJob( new IDevelopmentComponent[] { dc }, true );
        IStatus status = JobUtil.syncExec( buildJob, null );
        BuildState buildState = dc.getLocalBuildState( );

        if ( !status.isOK( ) && status.getException( ) != null ) {
            throw new Exception( status.getException( ) );
        }
        return buildState.getValue( ) == BuildState.SUCCESSFULLY_BUILT;
    }

    /** **************** Internals ****************************************** */

    // Caution:
    // This handling is only valid for local-only MM DCs for which no used DCs (MM federation) have to be synced from DTR / CBS.
    private void syncUsedDcsNeededForDcBuild( IDevelopmentComponent developmentComponent ) {

        // The DCs needed for DC build are synced from archive pool.

        // Sync of the DCs needed for MM-Build is done only once:
        if ( USED_DCS_FOR_MM_BUILD_SYNCED ) {
            return;
        }
        DiiActionFactory.forDevelopmentComponent( ).create_SyncUsedDcsAction( new IDevelopmentComponent[] { developmentComponent }, true ).run( null );
        USED_DCS_FOR_MM_BUILD_SYNCED = true;
    }

    private static boolean isDcUnderSourceControl( IProject project ) {

        IRepositoryService repositoryService = DiiRepositoryService.getRepositoryService( project );
        ISourceControl sourceControl = repositoryService.getSourceControl( );
        return sourceControl.isProjectUnderSourceControl( project );
    }

    private static boolean isDcUnderSourceControl( IDevelopmentComponent dc ) {

        IDevelopmentConfiguration devConfig = dc.getContainingSoftwareComponent( ).getContainingDevelopmentConfiguration( );
        return !devConfig.isLocal( );
    }

}
