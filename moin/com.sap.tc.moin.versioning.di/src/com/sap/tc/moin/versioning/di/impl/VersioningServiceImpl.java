package com.sap.tc.moin.versioning.di.impl;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.ide.dii05.model.api.IDcMetadataState;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.repository.api.CheckoutState;
import com.sap.ide.dii05.repository.api.DiiRepositoryException;
import com.sap.ide.dii05.repository.api.DiiRepositoryService;
import com.sap.ide.dii05.repository.api.IChangelistProvider;
import com.sap.ide.dii05.repository.api.IComplexOperationSupport;
import com.sap.ide.dii05.repository.api.IFeatureSupport;
import com.sap.ide.dii05.repository.api.IRepositoryService;
import com.sap.ide.dii05.repository.api.IRepositoryState;
import com.sap.ide.dii05.repository.api.IResourceOperation;
import com.sap.ide.dii05.repository.api.IResourceOperationStatus;
import com.sap.ide.dii05.repository.api.ISourceControl;
import com.sap.ide.dii05.repository.api.LocationState;
import com.sap.ide.dii05.repository.api.IFeatureSupport.StateFeature;
import com.sap.ide.dii05.repository.internal.wrapper.SourceControlWrapper;
import com.sap.tc.logging.Location;
import com.sap.tc.logging.Severity;
import com.sap.tc.moin.versioning.di.FileOperation;
import com.sap.tc.moin.versioning.di.VersioningService;
import com.sap.tc.moin.versioning.di.FileOperation.OperationType;
import com.sap.tc.moin.versioning.di.impl.preferences.PreferenceHelper;

/**
 * @author d020964
 */
public class VersioningServiceImpl implements VersioningService {

    private static final String SPACE = " ";  //$NON-NLS-1$

	private static final String DOUBLE_BLANK = "  ";  //$NON-NLS-1$

	private static final String CR = "\n";  //$NON-NLS-1$

	private static final String DOUBLE_CR = "\n\n";  //$NON-NLS-1$

	private static final String EMPTY_STRING = "";  //$NON-NLS-1$

	// Trace-Location which is a sub-location of the location used by IdeDii05VersioninService
    // --> These locations are automatically switched on together in the MOIN-specific preferences (Trace Configuration)
    private final static Location LOCATION = Location.getLocation( "com.sap.moin.facility.primary.versionservice.dii" ); //$NON-NLS-1$

    // Trace should be done in a format similar to the MOIN-format:
    private final static String TRACE_PREFIX = "[MOIN-DII05: com.sap.tc.moin.versioning.di.impl.VersioningServiceImpl]"; //$NON-NLS-1$

    // NOTE: it is assumed that 
    // if files from different projects are provided all projects share the 
    // same team provider.
    // TODO: check this at the API methods!
    private IProgressMonitor _progressMonitor = null;

    private static final String ERROR_MESSAGE_DELETE = Messages.VersioningServiceImpl_errorsOnDeletion_XMSG;

    private static final String ERROR_MESSAGE_ADD = Messages.VersioningServiceImpl_errorsOnAdd_XMSG;

    public void addOrEditFilesToSourceControl( Collection<IFile> files, String changelistId, IProgressMonitor progressMonitor ) {

        addOrEditFilesToSourceControl( (IFile[]) files.toArray( new IFile[files.size( )] ), changelistId );
    }

    public void deleteFiles( Collection<IFile> filesToDelete, IProgressMonitor progressMonitor ) {

        deleteFiles( (IFile[]) filesToDelete.toArray( new IFile[filesToDelete.size( )] ), progressMonitor );
    }

    public IStatus prepareModification( Collection<FileOperation> fileOperations, boolean headless, String changelistId ) {

        Object[] args = new Object[] { TRACE_PREFIX, "prepareModification", null }; //$NON-NLS-1$

        // check parameters
        for ( FileOperation fileOperation : fileOperations ) {
            if ( fileOperation.getFile( ) == null ) {
                IllegalArgumentException e = new IllegalArgumentException( "Illegal argument: fileOperations contains a FileOperation with file == null" ); //$NON-NLS-1$
                if ( isTraced( Severity.DEBUG ) ) {
                    args[2] = e.getMessage( );
                    trace( Severity.DEBUG, "{0}{1}: {2}.", args, e ); //$NON-NLS-1$
                }
                throw e;
            }
        }
        // collect all FileOperations on read only files and create operations
        List<FileOperation> relevantFileOperations = getRelevantFileOperations( fileOperations );

        if ( relevantFileOperations.size( ) == 0 ) {
            // nothing to do
            if ( isTraced( Severity.INFO ) ) {
                trace( Severity.INFO, "{0}{1}: File operations are not relevant.", args ); //$NON-NLS-1$
            }
            return Status.OK_STATUS;
        }
        // todo: not yet considered: fileOperations from different projects, where some are version-controlled and some are not version-controlled
        IProject project = relevantFileOperations.get( 0 ).getFile( ).getProject( );
        if ( isProjectUnderSourceControl( project ) ) {
            // project is under source control
            String title = Messages.VersioningServiceImpl_checkoutDialogTitle_XGRP;
            String message = Messages.VersioningServiceImpl_checkoutDialogMessage_XMSG;
            if ( isTraced( Severity.INFO ) ) {
                trace( Severity.INFO, "{0}{1}: Dialog for performing file operations for DTR will be shown.", args ); //$NON-NLS-1$
            }
            IStatus result = showReadonlyRepositoryObjectsAndCheckout( project, relevantFileOperations, title, message, headless, changelistId );
            return result;
        } else {
            if ( containsOnlyCreateOperations( relevantFileOperations ) ) {
                return Status.OK_STATUS;
            }
            // project is not under source control, but has readonly
            // files!!!
            if ( isTraced( Severity.INFO ) ) {
                trace( Severity.INFO, "{0}{1}: Error dialog for read-only resources in a project which is not under version-control will be shown.", args ); //$NON-NLS-1$
            }
            IStatus result;
            if ( headless ) {
                String message = getMessageForReadonlyRepositoryObjectsInNonDTRProject( relevantFileOperations );
                result = new Status( IStatus.ERROR, Activator.PLUGIN_ID, message, null );
            } else {
                showReadonlyRepositoryObjectsInNonDTRProject( relevantFileOperations );
                result = new Status( IStatus.CANCEL, Activator.PLUGIN_ID, Messages.VersioningServiceImpl_preparationWasCanceled_XMSG );
            }
            return result;
        }

    }

    private static IFile[] getFiles( Collection<FileOperation> fileOperations ) {

        List<IFile> result = new ArrayList<IFile>( );
        for ( FileOperation fileOperation : fileOperations ) {
            result.add( fileOperation.getFile( ) );
        }
        return (IFile[]) result.toArray( new IFile[result.size( )] );
    }

    private static boolean refreshFiles( IFile[] files ) {

        HashSet<IContainer> alreadyRefreshedFolders = new HashSet<IContainer>( );
        boolean succeeded = true;

        for ( int i = 0; i < files.length; i++ ) {
            IFile file = files[i];
            IProject project = file.getProject( );
            IRepositoryService repositoryService = DiiRepositoryService.getRepositoryService( project );
            IContainer parent = file.getParent( );
            if ( alreadyRefreshedFolders.contains( parent ) ) {
                continue;
            }
            try {
                repositoryService.getSourceControl( ).refresh( new Object[] { parent } );
            } catch ( DiiRepositoryException e ) {
                if ( isTraced( Severity.ERROR ) ) {
                    Object[] args = new Object[] { TRACE_PREFIX, "refreshFiles", file.getLocation( ).toOSString( ), e.getMessage( ) }; //$NON-NLS-1$
                    trace( Severity.ERROR, "{0}{1}: refreshing file [{2}] failed: {3}.", args, e ); //$NON-NLS-1$
                }
                succeeded = false;
            }
            alreadyRefreshedFolders.add( parent );
        }

        return succeeded;
    }

    private static List<FileOperation> getRelevantFileOperations( Collection<FileOperation> fileOperations ) {

        List<FileOperation> result = new ArrayList<FileOperation>( );
        for ( FileOperation fileOperation : fileOperations ) {
            IFile file = fileOperation.getFile( );
            OperationType operationType = fileOperation.getOperationType( );
            IProject project = file.getProject( );
            if ( operationType == FileOperation.OperationType.PREPARE_CREATE || file.isReadOnly( ) ) {
                result.add( fileOperation );
            } else {
                // no creation and file is writable
                // in case of a deletion or edit exclusive it is to checked if the file is checked
                // out for edit exclusive
                if ( ( operationType == OperationType.PREPARE_DELETE || operationType == OperationType.EDIT_EXCLUSIVE ) ) {
                    if ( isProjectUnderSourceControl( project ) ) {
                        if ( isCheckedOutForEditNonExclusive( file ) ) {
                            result.add( fileOperation );
                        } else {
                            if ( isTraced( Severity.INFO ) ) {
                                Object[] args = new Object[] { TRACE_PREFIX, "getRelevantFileOperations", operationType, file.getName( ), file.getFullPath( ) }; //$NON-NLS-1$
                                trace( Severity.INFO, "{0}{1}: File for operation [{2}, {3}] is already exclusively checked out: {4}.", args ); //$NON-NLS-1$
                            }
                        }
                    } else {
                        if ( isTraced( Severity.INFO ) ) {
                            Object[] args = new Object[] { TRACE_PREFIX, "getRelevantFileOperations", operationType, file.getName( ), project.getFullPath( ) }; //$NON-NLS-1$
                            trace( Severity.INFO, "{0}{1}: Project for operation [{2}, {3}] is not under version control: {4}.", args ); //$NON-NLS-1$
                        }
                    }
                } else {
                    if ( isTraced( Severity.INFO ) ) {
                        Object[] args = new Object[] { TRACE_PREFIX, "getRelevantFileOperations", operationType, file.getName( ), file.getFullPath( ) }; //$NON-NLS-1$
                        trace( Severity.INFO, "{0}{1}: File for operation [{2}, {3}] is already writable: {4}.", args ); //$NON-NLS-1$
                    }
                }
            }
        }
        return result;
    }

    private static boolean isCheckedOutForEditNonExclusive( IFile file ) {

        IProject project = file.getProject( );
        IRepositoryService repositoryService = DiiRepositoryService.getRepositoryService( project );
        IRepositoryState repositoryState = null;
        CheckoutState checkoutState = null;
        try {
            repositoryState = repositoryService.getSourceControl( ).getRepositoryState( file );
            checkoutState = repositoryState.getCheckoutState( );
            if ( checkoutState == CheckoutState.EDIT && !repositoryState.isLocked( ) ) {
                return true;
            }
        } catch ( DiiRepositoryException e ) {
            if ( isTraced( Severity.ERROR ) ) {
                Object[] args = new Object[] { TRACE_PREFIX, "isCheckedOutForEditNonExclusive", e.getMessage( ) }; //$NON-NLS-1$
                trace( Severity.ERROR, "{0}{1}: DiiRepositoryException occurred: {2}.", args, e ); //$NON-NLS-1$
            }
            return false;
        }
        return false;
    }

    private static boolean containsOnlyCreateOperations( Collection<FileOperation> fileOperations ) {

        for ( FileOperation fileOperation : fileOperations ) {
            if ( fileOperation.getOperationType( ) != FileOperation.OperationType.PREPARE_CREATE ) {
                return false;
            }
        }
        return true;
    }



    /**
     * Method showReadonlyRepositoryObjectsAndCheckout.
     * 
     * @param project
     * @param repositoryObjects
     * @param title title of the checkout dialog
     * @param message message in front of the listed repository objects
     * @return boolean precondition: project is under source control
     */
    IStatus showReadonlyRepositoryObjectsAndCheckout( IProject project, final List<FileOperation> fileOperations, String title, String message, boolean headless, String changelistId ) {

        final IRepositoryService repositoryService = DiiRepositoryService.getRepositoryService( project );

        // check if user is logged on
        if ( !repositoryService.getSourceControl( ).isLoggedIn( project ) ) {
            if ( headless ) {
                IllegalStateException e = new IllegalStateException( "Login to Source Control is required in headless mode." ); //$NON-NLS-1$
                if ( isTraced( Severity.DEBUG ) ) {
                    Object[] args = new Object[] { TRACE_PREFIX, "showReadonlyRepositoryObjectsAndCheckout", e.getMessage( ) }; //$NON-NLS-1$
                    trace( Severity.DEBUG, "{0}{1}: {2}.", args, e ); //$NON-NLS-1$
                }
                throw e;
            }
            if ( !logon( project ) ) {
                if ( isTraced( Severity.INFO ) ) {
                    Object[] args = new Object[] { TRACE_PREFIX, "showReadonlyRepositoryObjectsAndCheckout" }; //$NON-NLS-1$
                    trace( Severity.INFO, "{0}{1}: Logon failed.", args ); //$NON-NLS-1$
                }
                return createCancelStatus( Messages.VersioningServiceImpl_logonFailed_XMSG );
            }
        }

        final PreparationCheckResult checkResult = new PreparationCheckResult( );

        IRunnableWithProgress op = new IRunnableWithProgress( ) {

            public void run( IProgressMonitor monitor ) throws InvocationTargetException, InterruptedException {

                checkRepositoryStates( fileOperations, repositoryService, checkResult, monitor );
            }
        };
        if ( Display.getCurrent( ) != null ) {
            // UI thread => execute checkRepositoryStates in ModalContext
            try {
                PlatformUI.getWorkbench( ).getProgressService( ).busyCursorWhile( op );
            } catch ( InvocationTargetException e ) { //$JL-EXC$
                Throwable cause = e.getCause( );
                if ( isTraced( Severity.ERROR ) ) {
                    Object[] args = new Object[] { TRACE_PREFIX, "showReadonlyRepositoryObjectsAndCheckout", cause.getMessage( ) }; //$NON-NLS-1$
                    trace( Severity.ERROR, "{0}{1}: {2}.", args, ( cause instanceof Exception ) ? ( (Exception) cause ) : e ); //$NON-NLS-1$
                }
            } catch ( InterruptedException e ) { //$JL-EXC$
                if ( isTraced( Severity.DEBUG ) ) {
                    Object[] args = new Object[] { TRACE_PREFIX, "showReadonlyRepositoryObjectsAndCheckout" }; //$NON-NLS-1$
                    trace( Severity.DEBUG, "{0}{1}: Repository operation was interupted.", args, e ); //$NON-NLS-1$
                }
                return createCancelStatus( Messages.VersioningServiceImpl_checkingRepositoryStatesInterrupted_XMSG );
            } catch ( OperationCanceledException e ) { //$JL-EXC$
                if ( isTraced( Severity.DEBUG ) ) {
                    Object[] args = new Object[] { TRACE_PREFIX, "showReadonlyRepositoryObjectsAndCheckout" }; //$NON-NLS-1$
                    trace( Severity.DEBUG, "{0}{1}: Repository operation was canceled.", args, e ); //$NON-NLS-1$
                }
                return createCancelStatus( Messages.VersioningServiceImpl_checkingRepositoryStatesCanceled_XMSG );
            }
        } else {
            // non UI thread
            IProgressMonitor monitor = getProgressMonitor( );
            try {
                checkRepositoryStates( fileOperations, repositoryService, checkResult, monitor );
            } catch ( InterruptedException e ) {
                if ( isTraced( Severity.DEBUG ) ) {
                    Object[] args = new Object[] { TRACE_PREFIX, "showReadonlyRepositoryObjectsAndCheckout" }; //$NON-NLS-1$
                    trace( Severity.DEBUG, "{0}{1}: Repository operation was interupted.", args, e ); //$NON-NLS-1$
                }
                return createCancelStatus( Messages.VersioningServiceImpl_checkingRepositoryStatesInterrupted_XMSG ); //$JL-EXC$
            }
        }

        if ( !checkResult.isCheckoutPossible( ) ) {
            message = Messages.VersioningServiceImpl_checkoutDialogErrorMessage_XMSG;;
        }
        if ( headless ) {
            if ( !checkResult.isCheckoutPossible( ) ) {
            	return createPreparationFailedStatus( checkResult );
            }
        } else {
            boolean showPrepareDialog = PreferenceHelper.getInstance( ).getShowPrepareDialog( );
            boolean hideCheckoutDialog = !showPrepareDialog && checkResult.isCheckoutPossible( ) && !checkResult.containsWarnings( );
            if ( !hideCheckoutDialog ) {
                CheckoutDialog checkoutDialog = new CheckoutDialog( title, message, checkResult );
                checkoutDialog.open( );
                if ( !checkoutDialog.getDoCheckout( ) ) {
                    if ( isTraced( Severity.DEBUG ) ) {
                        Object[] args = new Object[] { TRACE_PREFIX, "showReadonlyRepositoryObjectsAndCheckout" }; //$NON-NLS-1$
                        trace( Severity.ERROR, "{0}{1}: Checkout was canceled.", args ); //$NON-NLS-1$
                    }
                    return createCancelStatus( Messages.VersioningServiceImpl_checkoutCanceled_XMSG ); //$JL-EXC$
                }
            }
        }
        IStatus status = checkout( null, fileOperations, headless, changelistId );
        return status;
    }

    private IStatus createPreparationFailedStatus( PreparationCheckResult checkResult ) {

        MultiStatus multiStatus = new MultiStatus(Activator.PLUGIN_ID, 0, Messages.VersioningServiceImpl_checkoutDialogErrorMessage_XMSG, null);
        Map<FileOperation, PreparationCheckResult.ExtStatus> statusForFileOperations = checkResult.getStatusForFileOperations( );
        Set<FileOperation> fileOperations = statusForFileOperations.keySet( );
        for ( FileOperation fileOperation : fileOperations ) {
            PreparationCheckResult.ExtStatus status = statusForFileOperations.get( fileOperation );
            if ( status.getSeverity( ) == IStatus.ERROR ) {
                IFile file = fileOperation.getFile( );
                String path = Utils.getFilePath( file );
                String message = status.getMessage( ) + " " + path; //$NON-NLS-1$
                multiStatus.add( new Status(IStatus.ERROR, Activator.PLUGIN_ID, message) );   
            }
        }
        return multiStatus;
    }

    private IProgressMonitor getProgressMonitor( ) {

        if ( _progressMonitor != null ) {
            return _progressMonitor;
        } else {
            return new NullProgressMonitor( );
        }
    }
    
    private static IStatus createCancelStatus(String message) {
        return new Status(IStatus.CANCEL, Activator.PLUGIN_ID, message, null);
    }

    private String getDetailMessage( PreparationCheckResult checkResult, boolean localized ) {

    	String titleAdd;
    	String titleEdit;
    	String titleEditExclusive;
    	String titleDelete;
    	
    	if (localized) {
        	titleAdd = Messages.VersioningServiceImpl_prepareCreate_XGRP;
        	titleEdit = Messages.VersioningServiceImpl_prepareEdit_XGRP;
        	titleEditExclusive = Messages.VersioningServiceImpl_prepareEditExclusive_XGRP;
        	titleDelete = Messages.VersioningServiceImpl_prepareDelete_XGRP;
    		
    	} else {
        	titleAdd = "The following files will be created";  //$NON-NLS-1$
        	titleEdit = "The following files need to be prepared for editing";  //$NON-NLS-1$
        	titleEditExclusive ="The following files need to be prepared for exclusive editing";  //$NON-NLS-1$
        	titleDelete = "The following files need to be prepared for deletion";  //$NON-NLS-1$
    		
    	}
        StringBuilder addMessage = new StringBuilder( titleAdd + DOUBLE_CR ); 
        StringBuilder editMessage = new StringBuilder( titleEdit + DOUBLE_CR ); 
        StringBuilder editExclusiveMessage = new StringBuilder( titleEditExclusive + DOUBLE_CR ); 
        StringBuilder deleteMessage = new StringBuilder( titleDelete + DOUBLE_CR );
        boolean addOccured = false;
        boolean editOccured = false;
        boolean editExclusiveOccured = false;
        boolean deleteOccured = false;
        Map<FileOperation, PreparationCheckResult.ExtStatus> statusForFileOperations = checkResult.getStatusForFileOperations( );
        Set<FileOperation> fileOperations = statusForFileOperations.keySet( );
        for ( FileOperation fileOperation : fileOperations ) {
            IFile file = fileOperation.getFile( );
            String path = Utils.getFilePath( file );
            PreparationCheckResult.ExtStatus status = statusForFileOperations.get( fileOperation );
            String message = path + CR;  
            if ( !status.isOK( ) ) {
                message = message + DOUBLE_BLANK + getMessage( status, localized ) + CR;   
            }
            switch ( fileOperation.getOperationType( ) ) {
                case PREPARE_CREATE:
                    addMessage.append( message );
                    addOccured = true;
                    break;
                case EDIT:
                    editMessage.append( message );
                    editOccured = true;
                    break;
                case EDIT_EXCLUSIVE:
                    editExclusiveMessage.append( message );
                    editExclusiveOccured = true;
                    break;
                case PREPARE_DELETE:
                    deleteMessage.append( message );
                    deleteOccured = true;
                    break;
            }
        }
        return ( addOccured ? addMessage + CR : EMPTY_STRING )   
        	+ ( editOccured ? editMessage + CR : EMPTY_STRING )  
        	+ ( editExclusiveOccured ? editExclusiveMessage + CR : EMPTY_STRING ) 
        	+ ( deleteOccured ? deleteMessage + CR : EMPTY_STRING ); 
    }

    String getMessage( PreparationCheckResult.ExtStatus status, boolean localized ) {

        String prefix;
        switch (status.getSeverity()) {
		case IStatus.INFO:
			if (localized) {
				prefix = Messages.VersioningServiceImpl_infoPrefix_XMSG;
			} else {
				prefix = "Info:"; //$NON-NLS-1$
			}
			break;
		case IStatus.WARNING:
			if (localized) {
				prefix = Messages.VersioningServiceImpl_warningPrefix_XMSG;
			} else {
				prefix = "Warning:"; //$NON-NLS-1$
			}
			break;
		case IStatus.ERROR:
			if (localized) {
				prefix = Messages.VersioningServiceImpl_errorPrefix_XMSG;
			} else {
				prefix = "Error:"; //$NON-NLS-1$
			}
			break;
		default:
			prefix = "UNKNOWN"; //$NON-NLS-1$
		}
        
        if (localized) {
        	return prefix + SPACE + status.getMessage( );
        } else {
        	return prefix + SPACE + status.getEnglishMessage();
        }
    }

    private void checkRepositoryStates( final List<FileOperation> fileOperations, final IRepositoryService repositoryService, final PreparationCheckResult checkResult, final IProgressMonitor monitor ) throws InterruptedException {

        monitor.beginTask( Messages.VersioningServiceImpl_performingRepositoryOperations_XMSG, IProgressMonitor.UNKNOWN );
        monitor.subTask( Messages.VersioningServiceImpl_RefreshingFiles_XMSG );
        if ( !refreshFiles( getFiles( fileOperations ) ) ) {
            InterruptedException e = new InterruptedException( "Refreshing files was interupted." ); //$NON-NLS-1$
            if ( isTraced( Severity.DEBUG ) ) {
                Object[] args = new Object[] { TRACE_PREFIX, "checkRepositoryStates", e.getMessage( ) }; //$NON-NLS-1$
                trace( Severity.DEBUG, "{0}{1}: {2}.", args, e ); //$NON-NLS-1$
            }
            throw e;
        }

        monitor.subTask( Messages.VersioningServiceImpl_computingRepositoryStates_XMSG );
        checkResult.setCheckoutPossible( true );
        for ( FileOperation fileOperation : fileOperations ) {
            IFile file = fileOperation.getFile( );
            OperationType operationType = fileOperation.getOperationType( );
            monitor.worked( 1 );
            if ( !isWorkspaceModifiable( file ) ) {
            	String message = NLS.bind(Messages.VersioningServiceImpl_DCNotModifiable_XMSG, file.getLocation().toOSString());
            	String englishMessage = NLS.bind("DC containing file {0} is not modifiable.", file.getLocation().toOSString());  //$NON-NLS-1$
                checkResult.addErrorCheckResult( fileOperation, message, englishMessage, null );
                checkResult.setCheckoutPossible( false );
            } else {
                try {
                    if ( operationType == FileOperation.OperationType.PREPARE_CREATE && !file.exists( ) ) {
                        checkResult.addOKCheckResult( fileOperation );
                        continue; // TODO: this is a workaround because calling getRepositoryState causes an exception
                        // if file does not exist locally and remotely. 
                    }
                    IRepositoryState repositoryState = repositoryService.getSourceControl( ).getRepositoryState( file );
                    LocationState locationState = repositoryState.getLocationState( );
                    if ( operationType == FileOperation.OperationType.PREPARE_CREATE ) {
                        if ( locationState == LocationState.LOCAL_REMOTE_NAMECLASH ) {
                            String message = Messages.VersioningServiceImpl_fileExists_XMSG;
                            String englishMessage = "A file with the given path already exists in the repository.";  //$NON-NLS-1$
                            checkResult.addErrorCheckResult( fileOperation, message, englishMessage, null );
                            checkResult.setCheckoutPossible( false );
                        } else {
                            checkResult.addOKCheckResult( fileOperation );
                        }
                    } else {
                        if ( file.exists( ) ) {
                            if ( locationState == LocationState.LOCAL_ONLY && file.isReadOnly( ) ) {
                                String message = Messages.VersioningServiceImpl_fileReadOnlyNotUnderSrcControl_XMSG;
                                String englishMessage = "File is readlony but not under source control.";  //$NON-NLS-1$
                                checkResult.addErrorCheckResult( fileOperation, message, englishMessage, null );
                                checkResult.setCheckoutPossible( false );
                            } else if ( locationState != LocationState.SYNCED_TO_HEAD ) {
                                String message = Messages.VersioningServiceImpl_notSyncedToLatest_XMSG;
                                String englishMessage = "File is not synced to the latest version.";  //$NON-NLS-1$
                                checkResult.addErrorCheckResult( fileOperation, message, englishMessage, null );
                                checkResult.setCheckoutPossible( false );
                            } else {
                                String[] otherCheckouters = getForeignModifiers( repositoryService, repositoryState, file );
                                if ( otherCheckouters != null && otherCheckouters.length > 0 ) {
                                    checkResult.setForeignModifiersExist( true );
                                    String message = getOtherCheckoutersMessage( otherCheckouters, true);
                                    String englishMessage = getOtherCheckoutersMessage( otherCheckouters, false);
                                    if ( operationType == FileOperation.OperationType.PREPARE_DELETE ) {
                                        checkResult.addErrorCheckResult( fileOperation, message, englishMessage, null );
                                        checkResult.setCheckoutPossible( false );
                                    } else {
                                        checkResult.addWarningCheckResult( fileOperation, message, englishMessage );
                                    }
                                } else {
                                    checkResult.addOKCheckResult( fileOperation );
                                }
                            }
                        }
                    }

                } catch ( DiiRepositoryException e ) {
                	String englishMessage = "Could not get repository state";  //$NON-NLS-1$
                    checkResult.addErrorCheckResult( fileOperation, Messages.VersioningServiceImpl_errorGettingRepositoryState_XMSG, englishMessage, e );
                    if ( isTraced( Severity.DEBUG ) ) {
                        Object[] args = new Object[] { TRACE_PREFIX, "checkRepositoryStates", e.getMessage( ) }; //$NON-NLS-1$
                        trace( Severity.DEBUG, "{0}{1}: Retrieval of repository state failed: {2}.", args, e ); //$NON-NLS-1$
                    }
                    checkResult.setCheckoutPossible( false );
                }
            }
        }
    }
    
    private String getOtherCheckoutersMessage(String[] otherCheckouters, boolean localized) {
    	if (localized) {
	    	if (otherCheckouters.length == 1) {
	    		return NLS.bind(Messages.VersioningServiceImpl_checkedOutByOtherUser_XMSG, otherCheckouters[0]);
	    	}
	    	return NLS.bind(Messages.VersioningServiceImpl_checkedOutByOtherUsers_XMSG, getUsers(otherCheckouters));
    	} else {
	    	if (otherCheckouters.length == 1) {
	    		return NLS.bind("File is already checked out by user {0}", otherCheckouters[0]);  //$NON-NLS-1$
	    	}
	    	return NLS.bind("File is already checked out by the following users: {0}", getUsers(otherCheckouters));  //$NON-NLS-1$
    	}
    }

    private static String[] getForeignModifiers( IRepositoryService repositoryService, IRepositoryState repositoryState, IResource resource ) throws DiiRepositoryException {

        IFeatureSupport.Feature feature = StateFeature.FOREIGN_MODIFIER;
        boolean support = repositoryService.getSourceControl( ).supports( feature, resource );
        if ( !support ) {
            return new String[0];
        }
        return repositoryState.getForeignModifiers( );
    }

    private String getUsers( String[] otherCheckouters ) {

        String users = EMPTY_STRING;
        for ( int k = 0; k < otherCheckouters.length; k++ ) {
            if ( users.length( ) == 0 ) {
                users = otherCheckouters[k];
            } else {
                users = users + ", " + otherCheckouters[k];  //$NON-NLS-1$
            }
        }
        return users;
    }


    static void showReadonlyRepositoryObjectsInNonDTRProject( List<FileOperation> fileOperations ) {

        String details = getMessageForReadonlyRepositoryObjectsInNonDTRProject( fileOperations );
        String message = Messages.VersioningServiceImpl_writeablilityRequired_XMSG;
        String title = Messages.VersioningServiceImpl_modificationNotPossible_XGRP;
        TextDialog textDialog = new TextDialog( title, message, details );
        textDialog.open( );
    }
    
    private static String getMessageForReadonlyRepositoryObjectsInNonDTRProject(List<FileOperation> fileOperations ) {
        String details = Messages.VersioningServiceImpl_readOnlyFilesInNonDTRProject_XMSG;
        for ( FileOperation fileOperation : fileOperations ) {
            IFile file = fileOperation.getFile( );
            if ( file.exists( ) && file.isReadOnly( ) ) {
                details += CR + Messages.VersioningServiceImpl_readOnlyPrefix_XMSG + file.getLocation( );
            }
        }
        return details;
    }
    
    /**
     * @param files files contains new files (to be added to source control) or
     * existing files (to be checked-out-for-edit). All files must be contained
     * in the same project for each file in files the following is done:
     * <p>
     * a) corresponding VFS file is checked out for delete: the state of file is
     * transformed to co4edit
     * <p>
     * b) new file: file is checked out for add
     * <p>
     * c) existing file: file is checked out for edit.
     * <p>
     * The method throws an OperationCanceledException if the user has canceled
     * a logon popup
     */
    public static void addOrEditFilesToSourceControl( IFile[] files, String changeList ) throws OperationCanceledException {

        if ( files == null || files.length == 0 ) {
            return;
        }
        if ( isTraced( Severity.DEBUG ) ) {
            Object[] args = new Object[] { TRACE_PREFIX, "addFilesToSourceControl", null }; //$NON-NLS-1$
            trace( Severity.DEBUG, "{0}{1}: Adding Files to source control: ", args ); //$NON-NLS-1$
            for ( int i = 0; i < files.length; i++ ) {
                args[2] = files[i].getLocation( ).toOSString( );
                trace( Severity.DEBUG, "{0}{1}: Adding {2}", args ); //$NON-NLS-1$
            }
        }
        excludeFilesFromMonitoring( files );
        IChangelistProvider changelistProvider = null;
        if ( changeList != null ) {
            changelistProvider = new ChangelistProvider( changeList );
        }
        IProject project = files[0].getProject( );
        IRepositoryService repositoryService = DiiRepositoryService.getRepositoryService( project );
        IComplexOperationSupport complexOperations = repositoryService.getComplexOperations( );
        // create ResourceOperation with forceTransform = true
        IResourceOperation[] operations = DiiRepositoryService.constructMultipleResourceOperations( files, IResourceOperation.OperationType.ADD_EDIT, false, changelistProvider );
        IResourceOperationStatus[] states = complexOperations.perform( operations, IResourceOperation.NO_SIMULATE, null );
        doErrorHandling( complexOperations, states, ERROR_MESSAGE_ADD );
    }

    private static void excludeFilesFromMonitoring( IFile[] files ) {

        for ( int i = 0; i < files.length; i++ ) {
            IResource resource = files[i];
            IRepositoryService repositoryService = DiiRepositoryService.getRepositoryService( resource );
            try {
                SourceControlWrapper sourceControl = (SourceControlWrapper) repositoryService.getSourceControl( );
                // We explicitly check if included. Otherwise we would allow an exclude below another exclude what we
                // don't want.
                if ( sourceControl.isMonitorResource( resource ) ) {
                    sourceControl.setMonitorResource( resource, false );
                }
            } catch ( CoreException e ) {
                if ( isTraced( Severity.ERROR ) ) {
                    Object[] args = new Object[] { TRACE_PREFIX, "excludeFilesFromMonitoring", e.getMessage( ) }; //$NON-NLS-1$
                    trace( Severity.ERROR, "{0}{1}: excludeFilesFromMonitoring failed: {2}", args, e ); //$NON-NLS-1$
                }
            }
        }
    }


    /**
     * Method checkout.
     * 
     * @param teamProvider
     * @param repositoryObjects
     * @return boolean preconditions: project is under source control user is
     * logged on to DTR the readonly files in repositoryObjects are in DTR and
     * SYNCHED_TO_LATEST
     */
    private IStatus checkout( Object teamProvider, List<FileOperation> fileOperations, boolean headless, String changelistId ) {

        if ( containsOnlyCreateOperations( fileOperations ) ) {
            return Status.OK_STATUS; // nothing to do
        }
        ProgressMonitorDialog dialog = null;
        IProgressMonitor progressMonitor = null;
        String changelistToUse = changelistId;
        IStatus checkoutStatus;
        try {
            if ( headless ) {
                progressMonitor = getProgressMonitor( );
            } else {
                if ( changelistToUse == null ) {
                    IFile file = fileOperations.get( 0 ).getFile( );
                    changelistToUse = getChangelistFromUser( file );
                }
                if ( changelistToUse == null ) {
                    if ( isTraced( Severity.DEBUG ) ) {
                        Object[] args = new Object[] { TRACE_PREFIX, "checkout" }; //$NON-NLS-1$
                        trace( Severity.DEBUG, "{0}{1}: Change list for check out could not be determined.", args ); //$NON-NLS-1$
                    }
                    return createCancelStatus( Messages.VersioningServiceImpl_changelistMissing_XMSG );
                }
                dialog = new ProgressMonitorDialog( PlatformUI.getWorkbench( ).getActiveWorkbenchWindow( ).getShell( ) );
                dialog.open( );
                progressMonitor = dialog.getProgressMonitor( );
            }
            IChangelistProvider changelistProvider = new ChangelistProvider( changelistToUse );
            checkoutStatus = checkout( fileOperations, progressMonitor, changelistProvider, headless );
        } finally {
            if ( dialog != null ) {
                dialog.close( );
            }
        }
        if ( !checkoutStatus.isOK( ) ) {
            if ( isTraced( Severity.DEBUG ) ) {
                Object[] args = new Object[] { TRACE_PREFIX, "checkout" }; //$NON-NLS-1$
                trace( Severity.DEBUG, "{0}{1}: Check out failed.", args ); //$NON-NLS-1$
            }
        }
        return checkoutStatus;
    }



    public String getChangelistFromUser( IResource resource ) {

        String result = null;
        ISourceControl sourceControl = DiiRepositoryService.getRepositoryService( resource ).getSourceControl( );
        try {
            result = sourceControl.getChangelistIdInteractively( resource );
        } catch ( DiiRepositoryException e ) {
            if ( isTraced( Severity.ERROR ) ) {
                Object[] args = new Object[] { TRACE_PREFIX, "getChangelistFromUser", e.getMessage( ) }; //$NON-NLS-1$
                trace( Severity.ERROR, "{0}{1}: getChangelistIdInteractively failed: {2}.", args, e ); //$NON-NLS-1$
            }
        } catch ( OperationCanceledException e ) { // $JL-EXC$
            if ( isTraced( Severity.ERROR ) ) {
                Object[] args = new Object[] { TRACE_PREFIX, "getChangelistFromUser" }; //$NON-NLS-1$
                trace( Severity.ERROR, "{0}{1}: User has canceled the change list selection dialog.", args, e ); //$NON-NLS-1$
            }
        }
        return result;
    }

    private IStatus checkout( List<FileOperation> fileOperations, IProgressMonitor progressMonitor, IChangelistProvider changelistProvider, boolean headless ) {

        List<IFile> filesToEdit = new ArrayList<IFile>( );
        List<IFile> filesToEditExclusive = new ArrayList<IFile>( );

        for ( FileOperation fileOperation : fileOperations ) {
            IFile file = fileOperation.getFile( );
            if ( file.exists( ) ) {
                if ( fileOperation.getOperationType( ) == FileOperation.OperationType.EDIT ) {
                    filesToEdit.add( file );
                } else if ( fileOperation.getOperationType( ) == FileOperation.OperationType.PREPARE_DELETE || fileOperation.getOperationType( ) == FileOperation.OperationType.EDIT_EXCLUSIVE ) {
                    filesToEditExclusive.add( file );
                }
            }
        }

        if ( filesToEdit.size( ) == 0 && filesToEditExclusive.size( ) == 0 ) {
            return Status.OK_STATUS;
        }

        IProject project;
        if ( filesToEdit.size( ) > 0 ) {
            project = filesToEdit.get( 0 ).getProject( );
        } else {
            project = filesToEditExclusive.get( 0 ).getProject( );
        }
        IRepositoryService repositoryService = DiiRepositoryService.getRepositoryService( project );

        IFile[] filesToEdit2 = filesToEdit.toArray( new IFile[filesToEdit.size( )] );
        IFile[] filesToEditExclusive2 = filesToEditExclusive.toArray( new IFile[filesToEditExclusive.size( )] );
        progressMonitor.beginTask( Messages.VersioningServiceImpl_checkoutFiles_XMSG, filesToEdit2.length );
        IResourceOperation[] editOperations = DiiRepositoryService.constructMultipleResourceOperations( filesToEdit2, IResourceOperation.OperationType.EDIT, false, changelistProvider );
        IResourceOperationStatus[] editStatuses = repositoryService.getComplexOperations( ).perform( editOperations, false, progressMonitor );
        IResourceOperation[] editExclusiveOperations = DiiRepositoryService.constructMultipleResourceOperations( filesToEditExclusive2, IResourceOperation.OperationType.EDIT, true, changelistProvider );
        IResourceOperationStatus[] editExclusiveStatuses = repositoryService.getComplexOperations( ).perform( editExclusiveOperations, false, progressMonitor );
        IResourceOperationStatus[] result = combineResourceOperationSets( editStatuses, editExclusiveStatuses );
        if ( !headless ) {
            repositoryService.getComplexOperations( ).showStates( Messages.VersioningServiceImpl_errorsOccuredOnCheckout_XMSG, result, IStatus.ERROR );
        }
        if (isStatusOk( result ) ) {
            return Status.OK_STATUS;
        }
        // problems occurred: build an IStatus and return it
        MultiStatus multiStatus = new MultiStatus(Activator.PLUGIN_ID, 0, Messages.VersioningServiceImpl_RepositoryOperationsFailed_XMSG, null);
        for ( int i = 0; i < result.length; i++ ) {
            IResourceOperationStatus operationStatus = result[i];
            if ( operationStatus.getStatus( ).getSeverity( ) >= IStatus.ERROR ) {
                multiStatus.add( operationStatus.getStatus( ) );
            }
        }
        return multiStatus;
    }

    private static IResourceOperationStatus[] combineResourceOperationSets( IResourceOperationStatus[] operationSet1, IResourceOperationStatus[] operationSet2 ) {

        IResourceOperationStatus[] combinedOperations = new IResourceOperationStatus[operationSet1.length + operationSet2.length];
        System.arraycopy( operationSet1, 0, combinedOperations, 0, operationSet1.length );
        System.arraycopy( operationSet2, 0, combinedOperations, operationSet1.length, operationSet2.length );
        return combinedOperations;
    }

    private static class ChangelistProvider implements IChangelistProvider {

        private String changelist = null;

        ChangelistProvider( String changelist ) {

            this.changelist = changelist;
        }

        public String getChangelistId( Object resource ) throws DiiRepositoryException {

            return changelist;
        }

    }

    private static boolean isStatusOk( IResourceOperationStatus[] statuses ) {

        for ( int i = 0; i < statuses.length; i++ ) {
            IResourceOperationStatus operationStatus = statuses[i];
            if ( operationStatus.getStatus( ).getSeverity( ) >= IStatus.ERROR ) {
                return false;
            }
        }
        return true;
    }

    private static boolean isWorkspaceModifiable( IFile file ) {

        IDevelopmentComponent dc = DiiResourceService.getDevelopmentComponent( file );
        if ( dc == null ) {
        	throw new IllegalStateException("DC could not be determined for " + file.getLocation( ));  //$NON-NLS-1$
        }

        IDcMetadataState localState = dc.getLocalState( );
        if ( localState == null ) {
        	throw new IllegalStateException("DC is not available locally for " + file.getLocation( ));  //$NON-NLS-1$
        }

        return localState.isModificationAllowed( );
    }

    /**
     * Method deleteFiles.
     * 
     * @param project
     * @param filesToDelete (all contained in project) delete the files
     * contained in filesToDelete 1. Behaviour in projects that are not shared:
     * the files in filesToDelete are deleted. 2. Behaviour in shared projects:
     * the following is performed for each file in filesToDelete a) file is
     * readonly: this results in an error b) file is LOCAL_ONLY and
     * NOT_CHECKED_OUT (just a new file...): file is deleted c) file is
     * CHECKED_OUT_FOR_CREATE: file is reverted and deleted d) file is
     * CHECKED_OUT_FOR_EDIT: file is reverted and checked out for delete e) file
     * is CHECKED_OUT_FOR_DELETE: a file with the same path was deleted some
     * time before. File was recreated locally. In this case file is deleted and
     * the checkout state remains unchanged In case of an error a popup is shown
     * describing all occured errors
     */
    public static void deleteFiles( IFile[] filesToDelete, IProgressMonitor progressMonitor ) {

        if ( filesToDelete == null ) {
            IllegalArgumentException e = new IllegalArgumentException( "filesToDelete is null" ); //$NON-NLS-1$
            if ( isTraced( Severity.DEBUG ) ) {
                Object[] args = new Object[] { TRACE_PREFIX, "deleteFiles", e.getMessage( ) }; //$NON-NLS-1$
                trace( Severity.DEBUG, "{0}{1}: {2}.", args, e ); //$NON-NLS-1$
            }
            throw e;
        }
        if ( filesToDelete.length == 0 ) {
            return;
        }
        IProject project = filesToDelete[0].getProject( );
        // check if all files are contained in project
        for ( int i = 0; i < filesToDelete.length; i++ ) {
            if ( filesToDelete[i].getProject( ) != project ) {
                IllegalArgumentException e = new IllegalArgumentException( "filesToDelete contains files with wrong project" ); //$NON-NLS-1$
                if ( isTraced( Severity.DEBUG ) ) {
                    Object[] args = new Object[] { TRACE_PREFIX, "deleteFiles", e.getMessage( ) }; //$NON-NLS-1$
                    trace( Severity.DEBUG, "{0}{1}: {2}.", args, e ); //$NON-NLS-1$
                }
                throw e;
            }
        }
        // Provide trace output for file deletion
        if ( isTraced( Severity.DEBUG ) ) {
            Object[] args = new Object[] { TRACE_PREFIX, "deleteFiles", null }; //$NON-NLS-1$
            trace( Severity.DEBUG, "{0}{1}: Deleting versioned files:", args ); //$NON-NLS-1$
            for ( int i = 0; i < filesToDelete.length; i++ ) {
                args[2] = filesToDelete[i].getLocation( ).toOSString( );
                trace( Severity.DEBUG, "{0}{1}: Deleting {2}.", args ); //$NON-NLS-1$
            }
        }
        // delete the files
        long startTime = System.currentTimeMillis( );
        try {
            IRepositoryService repositoryService = DiiRepositoryService.getRepositoryService( project );
            // Login is automatically done if necessary.		
            IResourceOperation[] operations = DiiRepositoryService.constructMultipleResourceOperations( filesToDelete, IResourceOperation.OperationType.DELETE, true, null );
            IComplexOperationSupport complexOperationSupport = repositoryService.getComplexOperations( );
            IResourceOperationStatus[] states = complexOperationSupport.perform( operations, false, progressMonitor );
            doErrorHandling( complexOperationSupport, states, ERROR_MESSAGE_DELETE );
        } catch ( OperationCanceledException e ) {
            // user has eg. canceled logon
            // note: logon should not happen because canModify assures that the user is logged on if MDOChangeInfo
            // contains MDOs that will be deleted
            if ( isTraced( Severity.ERROR ) ) {
                Object[] args = new Object[] { TRACE_PREFIX, "deleteFiles" }; //$NON-NLS-1$
                trace( Severity.ERROR, "{0}{1}: deleting files was canceled.", args ); //$NON-NLS-1$
            }
            return;
        }
        long time = System.currentTimeMillis( ) - startTime;
        if ( isTraced( Severity.INFO ) ) {
            Object[] args = new Object[] { TRACE_PREFIX, "deleteFiles", time }; //$NON-NLS-1$
            trace( Severity.INFO, "{0}{1}: Deleting versioned files took {2} ms.", args ); //$NON-NLS-1$
        }
    }

    private static void doErrorHandling( final IComplexOperationSupport complexOperationSupport, final IResourceOperationStatus[] states, final String message ) {

        if ( Display.getCurrent( ) != null ) {
            // running in the UI thread
            complexOperationSupport.showStates( message, states, IStatus.ERROR );
        } else {
            Runnable runnable = new Runnable( ) {

                public void run( ) {

                    complexOperationSupport.showStates( message, states, IStatus.ERROR );
                }
            };
            Display.getDefault( ).asyncExec( runnable );
        }
    }

    /**
     * @param project
     * @return true if the given project is shared with a repository
     */
    public static boolean isProjectUnderSourceControl( IProject project ) {

        IRepositoryService repositoryService = DiiRepositoryService.getRepositoryService( project );
        ISourceControl sourceControl = repositoryService.getSourceControl( );
        return sourceControl.isProjectUnderSourceControl( project );
    }
    
    public boolean isExcludedFromVersioning( IFile file ) {

        return file.isDerived( IResource.CHECK_ANCESTORS );
    }
    
    public static boolean logon( IProject project ) {

        if ( project == null ) {
            IllegalArgumentException e = new IllegalArgumentException( "project==null" ); //$NON-NLS-1$
            if ( isTraced( Severity.DEBUG ) ) {
                Object[] args = new Object[] { TRACE_PREFIX, "logon", e.getMessage( ) }; //$NON-NLS-1$
                trace( Severity.DEBUG, "{0}{1}: {2}.", args, e ); //$NON-NLS-1$
            }
            throw e;
        }
        boolean rtn;
        IRepositoryService repositoryService = DiiRepositoryService.getRepositoryService( project );
        try {
            rtn = repositoryService.getSourceControl( ).loginToSourceRepository( project );
        } catch ( OperationCanceledException e ) {
            if ( isTraced( Severity.DEBUG ) ) {
                Object[] args = new Object[] { TRACE_PREFIX, "logon", e.getMessage( ) }; //$NON-NLS-1$
                trace( Severity.DEBUG, "{0}{1}: {2}.", args, e ); //$NON-NLS-1$
            }
            return false; // $JL-EXC$
        }
        return rtn;
    }

    public void setProgressMonitor( IProgressMonitor monitor ) {

        _progressMonitor = monitor;
    }

    /* ******************** Tracing ***************************************** */

    private static boolean isTraced( int severity ) {

        return LOCATION.beLogged( severity );
    }

    private static void trace( int severity, String msg, Object[] args ) {

        if ( LOCATION.beLogged( severity ) ) {
            LOCATION.logT( severity, msg, args );
        }
    }

    private static void trace( int severity, String msg, Object[] args, Exception e ) {

        if ( LOCATION.beLogged( severity ) ) {
            LOCATION.traceThrowableT( severity, msg, args, e );
        }
    }

}
