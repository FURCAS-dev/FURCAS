package com.sap.tc.moin.test.fw.ide;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;

import com.sap.ide.dii05.lib.api.commands.DiiCommandFactory;
import com.sap.ide.dii05.model.api.IDevelopmentConfiguration;
import com.sap.ide.dii05.model.api.ISoftwareComponent;
import com.sap.ide.dii05.test.util.DiiUtil;
import com.sap.ide.dii05.util.api.job.JdiJob;
import com.sap.ide.dii05.util.api.job.JobUtil;


@SuppressWarnings( "nls" )
public class ScExportImportUtilImpl implements ScExportImportUtil {

    /** ***************** Internals ***************************************** */

    private IdeRuntimeTestHelper _ideTestHelper;

    private static final boolean INCLUDE_SOURCES_IN_EXPORT = true;

    private static final boolean EXCLUDE_SOURCES_IN_EXPORT = false;

    private static final Exception NO_EXCEPTION = null;

    /** *********** Construction ******************************************** */

    public ScExportImportUtilImpl( IdeRuntimeTestHelper ideRuntimeTestHelper ) {

        _ideTestHelper = ideRuntimeTestHelper;
    }

    /** ************************ Export / Import of DCs ********************* */

    public boolean executeExportOfScWithArchivesOnly( ISoftwareComponent sc, File destinationFolder ) throws Exception {

        // Caution:
        // MOIN only handles imported SCs with archives-only: details see SpecialDcSyncEventListenerImpl#isDcSyncOrImportEvent
        // Other imported SCs (source SCs) only get visible when projects for the container DCs are created (via the respective events).
        return executeExportOfSc( sc, destinationFolder, EXCLUDE_SOURCES_IN_EXPORT );
    }

    static final String NO_TEXT = "";

    public Set<ISoftwareComponent> executeImportOfSc( File scaFile, IDevelopmentConfiguration destinationDevConfig ) throws Exception {

        File[] scaFiles = new File[] { scaFile };
        MultiStatus returnStatus = new MultiStatus( _ideTestHelper.TEST_PLUGIN_ID, MultiStatus.OK, NO_TEXT, NO_EXCEPTION );
        Set<ISoftwareComponent> importedScs = DiiUtil.importScsFromFiles( scaFiles, destinationDevConfig, _ideTestHelper.NO_PROGRESS_MONITOR, returnStatus );
        return importedScs;
    }

    /** ***************** Internals ***************************************** */

    private boolean executeExportOfSc( ISoftwareComponent sc, File destinationFolder, boolean includeSourcesInExport ) throws Exception {

        Collection<ISoftwareComponent> scList = new ArrayList( );
        scList.add( sc );

        JdiJob job = DiiCommandFactory.forSoftwareComponent( ).create_ExportSoftwareComponentsJob( scList, destinationFolder, includeSourcesInExport );
        IStatus status = JobUtil.syncExec( job, _ideTestHelper.NO_PROGRESS_MONITOR );

        if ( !status.isOK( ) ) {
            if ( status.getException( ) != null ) {
                throw new Exception( status.getException( ) );
            } else {
                return false;
            }
        }
        return true;
    }

}
