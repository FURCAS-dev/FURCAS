package com.sap.tc.moin.test.fw.ide;

import java.util.List;
import java.util.Locale;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;

import com.sap.ide.dii05.lib.api.commands.DiiCommandFactory;
import com.sap.ide.dii05.lib.api.util.DiiLibraryException;
import com.sap.ide.dii05.lib.api.util.DiiModelService;
import com.sap.ide.dii05.lib.internal.DiiLibraryPlugin;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.model.api.IDevelopmentConfiguration;
import com.sap.ide.dii05.model.api.ISoftwareComponent;
import com.sap.ide.dii05.model.api.OnlineState;
import com.sap.ide.dii05.repository.api.CheckoutState;
import com.sap.ide.dii05.repository.api.DiiRepositoryService;
import com.sap.ide.dii05.repository.api.IChangelistProvider;
import com.sap.ide.dii05.repository.api.IRepositoryService;
import com.sap.ide.dii05.repository.api.ISourceControl;
import com.sap.ide.dii05.repository.api.LocationState;
import com.sap.ide.dii05.repository.internal.wrapper.SourceControlWrapper;
import com.sap.ide.dii05.test.util.DiiUtil;
import com.sap.ide.dii05.util.api.job.JdiJob;
import com.sap.ide.dii05.util.api.job.JobUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;

@SuppressWarnings( "nls" )
public class DiTrackUtilImpl extends UtilImpl implements DiTrackUtil {

    /** *********** Internals *********************************************** */

    private DiiContext _context = null;

    private IdeRuntimeTestHelper _ideTestHelper;

    private static final String PROP_FILE = "properties/nwdi.properties"; //$NON-NLS-1$

    private static final int MAX_WAITING_FOR_ASYNCHRONOUS_CHECK_OUT = 30000; // 30 sec

    private static final int MAX_WAITING_FOR_CHECKIN_WITH_WORKSPACE_LOCK = 30000; // 30 sec

    /** *********** Construction ******************************************** */

    public DiTrackUtilImpl( IdeRuntimeTestHelper ideRuntimeTestHelper ) {

        _ideTestHelper = ideRuntimeTestHelper;
    }

    /** *********** API ***************************************************** */

    public void importDevConfig( ) throws Exception {

        checkConnection( );
        if ( getDiiContext( ).getDevelopmentConfiguration( ) == null ) {
            DevConfImportUtil.importDevConfiguration( getDiiContext( ) );
        }
    }

    public void cleanupDevConfig( ) {

        IDevelopmentConfiguration[] configs = DiiModelService.getDevelopmentConfigurations( DiiModelService.getComponentModel( ), DiiModelService.FORCED_REFRESH );
        if ( configs != null ) {
            for ( int i = 0; i < configs.length; i++ ) {
                String path = configs[i].getLocalRoot( );
                Path configPath = new Path( path );
                try {
                    Integer.parseInt( configPath.lastSegment( ) );
                    DiiUtil.deleteAllActivitis( configs[i] );
                    try {
                        DiiLibraryPlugin.getPlugin( ).getDevConfManager( ).removeConfiguration( configs[i], true );
                    } catch ( DiiLibraryException e ) {
                        // ignore it
                    }
                } catch ( Exception e ) {
                    // nothing to do
                }
            }
        }

        // reset context
        _context = null;

    }

    public IDevelopmentConfiguration getDevConfig( ) throws Exception {

        IDevelopmentConfiguration devConfig = getDiiContext( ).getDevelopmentConfiguration( );
        return devConfig;
    }

    @SuppressWarnings( "unchecked" )
    IDevelopmentConfiguration getOnlineDevelopmentConfiguration( ) {

        List<IDevelopmentConfiguration> configs = DiiLibraryPlugin.getPlugin( ).getComponentModel( ).getDevelopmentConfigurations( );
        IDevelopmentConfiguration atLeastOneconfig = null;
        for ( IDevelopmentConfiguration developmentConfiguration : configs ) {
            if ( OnlineState.ONLINE_LITERAL.equals( developmentConfiguration.getOnlineState( ) ) ) {
                // atLeastOneconfig = developmentConfiguration;
                String name = _context.getConfigurationName( );
                if ( name == null ) {
                    return developmentConfiguration;
                } else {
                    name = name.toLowerCase( Locale.ENGLISH );
                }
                if ( developmentConfiguration.getName( ).toLowerCase( Locale.ENGLISH ).indexOf( name ) >= 0 || ( developmentConfiguration.getSlLocation( ) != null && developmentConfiguration.getSlLocation( ).toLowerCase( Locale.ENGLISH ).indexOf( name ) >= 0 ) ) {
                    return developmentConfiguration;
                }
            }
        }
        return atLeastOneconfig;
    }

    /**
     * Returns first found modifiable Software Component
     */
    public ISoftwareComponent getEditableSC( IDevelopmentConfiguration config ) {

        String scName = _context.getSCName( );
        if ( scName == null ) {
            return null;
        }
        ISoftwareComponent[] scs = DiiModelService.getSoftwareComponents( config, DiiModelService.FORCED_REFRESH );
        for ( int i = 0; i < scs.length; i++ ) {
            if ( scs[i].isModificationAllowed( ) ) {

                if ( scName.equals( scs[i].getName( ) ) ) {
                    return scs[i];
                }

            }
        }
        return null;
    }

    // Scenario 3: 
    // Remove DC (which is synced from DTR) from local disc --> sync state = not synced, but remote
    // Remark: Scenario 2 --> delete DC (is not supported in scenario 3)
    public boolean removeDcs( IDevelopmentComponent[] developmentComponents ) throws Exception {

        JdiJob removeJob = DiiCommandFactory.forDevelopmentComponent( ).create_RemoveDcsJob( developmentComponents, true );
        IStatus status = JobUtil.syncExec( removeJob, null );

        boolean isOk = status.isOK( );
        if ( !isOk ) {
            Throwable thr = status.getException( );
            if ( thr != null ) {
                throw new Exception( thr );
            }
        }
        return isOk;
    }

    public void excludeFromSourceControl( IResource resource ) {

        IRepositoryService repositoryService = DiiRepositoryService.getRepositoryService( resource );
        if ( repositoryService == null ) {
            return;
        }
        SourceControlWrapper sourceControl = (SourceControlWrapper) repositoryService.getSourceControl( );
        if ( sourceControl == null ) {
            return;
        }
        // We explicitly check if included. Otherwise we would allow an exclude below another exclude what we
        // don't want.
        try {
            if ( sourceControl.isMonitorResource( resource ) ) {
                sourceControl.setMonitorResource( resource, false );
            }
        } catch ( CoreException ce ) {
            throw new RuntimeException( "Unable to remove resource from source control: " + resource.getFullPath( ), ce ); //$NON-NLS-1$
        }
    }

    public CheckoutState getCheckoutState( IFile fileHandle ) throws Exception {

        ISourceControl sourceControl = DiiRepositoryService.getRepositoryService( fileHandle ).getSourceControl( );
        CheckoutState checkoutState = sourceControl.getRepositoryState( fileHandle ).getCheckoutState( );
        return checkoutState;
    }

    public boolean hasCheckoutLock( IFile fileHandle ) throws Exception {

        ISourceControl sourceControl = DiiRepositoryService.getRepositoryService( fileHandle ).getSourceControl( );
        boolean hasCheckoutLock = sourceControl.getRepositoryState( fileHandle ).isLocked( );
        return hasCheckoutLock;
    }

    public LocationState getLocationState( IFile fileHandle ) throws Exception {

        ISourceControl sourceControl = DiiRepositoryService.getRepositoryService( fileHandle ).getSourceControl( );
        LocationState LocationState = sourceControl.getRepositoryState( fileHandle ).getLocationState( );
        return LocationState;
    }

    public IStatus checkInChangeList( IDevelopmentConfiguration devConfig, IChangelistProvider changelistProvider, String changelistId ) {

        // Use Case: 
        // The check-in of the activity requires an exclusive lock on DTR server (shared workspace-lock)
        // We wait max MAX_WAITING_FOR_CHECKIN_WITH_WORKSPACE_LOCK sec for an successful check-in. The check-in can fail e.g. in case of parallel check-in by other client or in case of parallel integrate of an activity or propagation list.
        int max_counter = MAX_WAITING_FOR_CHECKIN_WITH_WORKSPACE_LOCK / 100;
        int counter = max_counter;
        IStatus status = DiiUtil.checkInChangeList( changelistProvider, devConfig );
        while ( counter > 0 && ( status.getSeverity( ) == IStatus.ERROR || status.getSeverity( ) == IStatus.CANCEL ) ) {
            threadSleep( 100, "createAndCheckInPartition" ); //$NON-NLS-1$
            counter--;
            // Check in the change --> the files get versioned
            status = DiiUtil.checkInChangeList( changelistProvider, devConfig );
        }
        String message = "Waited " + ( ( max_counter - counter ) * 100 ) + " millis for the check-in of activity (exlusive lock on DTR)"; //$NON-NLS-1$ //$NON-NLS-2$
        java.lang.System.out.println( message );
        java.lang.System.out.flush( );

        if ( status.getSeverity( ) == IStatus.ERROR || status.getSeverity( ) == IStatus.CANCEL ) {
            if ( status.getException( ) != null ) {
                throw new IllegalStateException( "The activity " + changelistId + " could not be checked-in: " + status.getMessage( ), status.getException( ) ); //$NON-NLS-1$ //$NON-NLS-2$
            } else {
                throw new IllegalStateException( "The activity " + changelistId + " could not be checked-in: " + status.getMessage( ) ); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
        return status;
    }

    /** *********** Internals *********************************************** */

    private DiiContext getDiiContext( ) throws Exception {

        if ( _context == null ) {

            _context = new DiiContext( );
//            InputStream stream;
//            try {
//                stream = FileLocator.openStream( getCurrentBundle( ), new Path( getDiiContextFile( ) ), false );
//                _context = new DiiContext( stream );
//            } catch ( IOException e ) {
//                throw new Exception( "can not read properties for dii context", e );
//            }
            IDevelopmentConfiguration onlineDevelopmentConfiguration = getOnlineDevelopmentConfiguration( );
            if ( onlineDevelopmentConfiguration != null ) {
                _context.setDevelopmentConfiguration( onlineDevelopmentConfiguration );
            }
        }
        return _context;
    }

    private void checkConnection( ) throws Exception {

        DiiContext context = getDiiContext( );
        StringBuffer msgBuf = null;

        msgBuf = checkValues( msgBuf, DiiContext.LSD_URL, context.getSldUrl( ) );
        msgBuf = checkValues( msgBuf, DiiContext.USERNAME, context.getUserName( ) );
        msgBuf = checkValues( msgBuf, DiiContext.PWD, context.getPassword( ) );
        msgBuf = checkValues( msgBuf, DiiContext.CONFIG_NAME, context.getConfigurationName( ) );
        if ( msgBuf != null ) {
            throw new Exception( msgBuf.toString( ) );
        }
    }

    private StringBuffer checkValues( StringBuffer buf, String parameterId, String checkString ) {

        StringBuffer myBuf = buf;
        if ( checkString == null ) {
            if ( myBuf == null ) {
                myBuf = new StringBuffer( );
                myBuf.append( "Missing Connection Parameter: " ); //$NON-NLS-1$
            } else {
                myBuf.append( ", " ); //$NON-NLS-1$
            }
            myBuf.append( parameterId );
        }
        return myBuf;
    }

    private String getDiiContextFile( ) {

        return PROP_FILE;
    }

    @Override
    public void createAndCheckInPartition(Connection connection, PRI pri, boolean partitionContainsTexts, boolean xlfFileExists,
	    boolean performCheckIn, IDevelopmentConfiguration devConfig, IChangelistProvider changelistProvider, String changelistId)
	    throws Exception {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void enableTestMode(String changelistId) {
	// TODO Auto-generated method stub
	
    }

}
