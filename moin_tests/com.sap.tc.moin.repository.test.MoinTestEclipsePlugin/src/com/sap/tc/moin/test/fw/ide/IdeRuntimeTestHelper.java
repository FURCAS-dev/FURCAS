package com.sap.tc.moin.test.fw.ide;


import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.sap.ide.dii05.repository.api.IChangelistProvider;
import com.sap.tc.moin.test.fw.MoinTestHelper;



@SuppressWarnings( "nls" )
public interface IdeRuntimeTestHelper extends MoinTestHelper {

    final String TEST_PLUGIN_ID = "com.sap.tc.moin.repository.test.MoinTestEclipsePlugin";

    final IProgressMonitor NO_PROGRESS_MONITOR = new NullProgressMonitor( );

    final IChangelistProvider NO_CHANGELIST_PROVIDER = null;

    final boolean DO_CHECKIN = true;

    final boolean DONT_CHECKIN = false;

    final boolean FORCED_REFRESH = true;

    final boolean DONT_FORCED_REFRESH = false;

    final boolean DO_INITIALIZE = true;

    final boolean DONT_INITIALIZE = false;

    final String TEST_DC_VENDOR = "test.sap.com";

    /** ***************** Utilities ***************************************** */

    MoinConnectionUtil getMoinConnectionUtil( );

    FileUtil getFileUtil( );

    DevConfUtil getDevConfUtil( );

    DcModificationUtil getDcModificationUtil( );

    DcBuildUtil getDcBuildUtil( );

    DiTrackUtil getDiTrackUtil( );

    S2XUtil getS2XUtil( );

    ScExportImportUtil getScExportImportUtil( );

    /** *********** Creation of DCs and Projects **************************** */

    /**
     * Creates a DC project with a test DC type and a test nature. If the DC
     * project already exists, this is a nop.
     * 
     * @param dcName the name of the DC. Note that this differs from the
     * corresponding project name.
     * @return The Eclipse project
     */
    IProject getOrCreateLocalMoinDCProject( String dcVendor, String dcName ) throws Exception;

    IProject getOrCreateLocalMoinMetaModelDCProject( String dcVendor, String dcName ) throws Exception;

    IProject getOrCreateLocalJavaDCProject( String dcVendor, String dcName ) throws Exception;

    IProject getOrCreateLocalDictionaryDCProject( String dcVendor, String dcName ) throws Exception;

    /**
     * Creates DC of type "dummy". The DC is not marked as model dc.
     * 
     * @param dcVendor
     * @param dcName
     * @return
     * @throws Exception
     */
    IProject getOrCreateLocalDummyDCProject( String dcVendor, String dcName ) throws Exception;

    /**
     * Creates DC of type "dummy". The DC is marked as model dc.
     * 
     * @param dcVendor
     * @param dcName
     * @return
     * @throws Exception
     */
    IProject getOrCreateLocalDummyMoinDCProject( String dcVendor, String dcName ) throws Exception;

    /** ************ DC access ********************************************** */

    String getFullDCName( String dcVendor, String dcName );

    /** *************** Others ********************************************** */

    /**
     * Sets whether the workspace performs autobuilds. When autobuild is on, any
     * changes made to a project and its resources automatically triggers an
     * incremental build of the workspace.
     * 
     * @param value <code>true</code> to turn on autobuilding, and
     * <code>false</code> to turn it off
     */
    boolean setAutoBuilding( boolean value );

    /**
     * Creates and returns an empty temporary directory a test can use for file
     * system operations.<br>
     * The directory is created in a folder named MOIN_TEMP which is located in
     * a project MOIN_TEMP_PROJECT (which itself is located in the workspace
     * root directory).
     */
    File getTemporaryTestDirectory( );

    void cleanupTemporaryTestProject( );

}
