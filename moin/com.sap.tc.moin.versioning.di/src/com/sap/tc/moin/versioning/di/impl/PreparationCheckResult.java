package com.sap.tc.moin.versioning.di.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.sap.tc.moin.versioning.di.FileOperation;

public class PreparationCheckResult {

    public static class ExtStatus extends Status {

        public final static ExtStatus EXT_OK_STATUS = new ExtStatus( IStatus.OK, Activator.PLUGIN_ID, Messages.PreparationCheckResult_ok_XMSG, null );

        private String englishMessage;

        ExtStatus( int severity, String pluginId, String message, String englishMessage ) {

            super( severity, pluginId, message );
            this.englishMessage = englishMessage;
        }

        ExtStatus( int severity, String pluginId, String message, String englishMessage, Throwable exception ) {

            super( severity, pluginId, message, exception );
            this.englishMessage = englishMessage;
        }

        String getEnglishMessage( ) {

            return englishMessage;
        }
    }

    private boolean checkoutPossible = false;

    private boolean containsWarnings = false;

    private boolean foreignModifiersExist = false;

    private FileOperations createOperations = new FileOperations( );

    private FileOperations editOperations = new FileOperations( );

    private FileOperations editExclusiveOperations = new FileOperations( );

    private FileOperations deleteOperations = new FileOperations( );

    private Map<FileOperation, ExtStatus> statusForFileOperations = new HashMap<FileOperation, ExtStatus>( );

    public boolean isCheckoutPossible( ) {

        return checkoutPossible;
    }

    public void setCheckoutPossible( boolean checkoutPossible ) {

        this.checkoutPossible = checkoutPossible;
    }

    public boolean containsWarnings( ) {

        return containsWarnings;
    }

    public boolean foreignModifiersExist( ) {

        return foreignModifiersExist;
    }


    public void setForeignModifiersExist( boolean foreignModifiersExist ) {

        this.foreignModifiersExist = foreignModifiersExist;
    }

    public void addOKCheckResult( FileOperation fileOperation ) {

        addFileOperation( fileOperation, ExtStatus.EXT_OK_STATUS );
    }

    public void addWarningCheckResult( FileOperation fileOperation, String message, String englishMessage ) {

        ExtStatus status = new ExtStatus( IStatus.WARNING, Activator.PLUGIN_ID, message, englishMessage );
        addFileOperation( fileOperation, status );
    }

    public void addErrorCheckResult( FileOperation fileOperation, String message, String englishMessage, Throwable throwable ) {

        ExtStatus status = new ExtStatus( IStatus.ERROR, Activator.PLUGIN_ID, message, englishMessage, throwable );
        addFileOperation( fileOperation, status );
    }

    public Map<FileOperation, ExtStatus> getStatusForFileOperations( ) {

        return statusForFileOperations;
    }

    public IStatus getFileOperationStatus( FileOperation fileOperation ) {

        return statusForFileOperations.get( fileOperation );
    }

    public FileOperations getCreateOperations( ) {

        return createOperations;
    }

    public FileOperations getEditOperations( ) {

        return editOperations;
    }

    public FileOperations getEditExclusiveOperations( ) {

        return editExclusiveOperations;
    }

    public FileOperations getDeleteOperations( ) {

        return deleteOperations;
    }

    private void addFileOperation( FileOperation fileOperation, ExtStatus status ) {

        FileOperations fileOperations = null;
        switch ( fileOperation.getOperationType( ) ) {
            case PREPARE_CREATE:
                fileOperations = createOperations;
                break;
            case EDIT:
                fileOperations = editOperations;
                break;
            case EDIT_EXCLUSIVE:
                fileOperations = editExclusiveOperations;
                break;
            case PREPARE_DELETE:
                fileOperations = deleteOperations;
                break;
        }
        fileOperations.add( fileOperation );
        statusForFileOperations.put( fileOperation, status );
        if ( status.getSeverity( ) == IStatus.WARNING ) {
            fileOperations.setContainsWarnings( true );
            containsWarnings = true;
        } else if ( status.getSeverity( ) == IStatus.ERROR ) {
            fileOperations.setContainsErrors( true );
            checkoutPossible = false;
        }

    }

    public Collection<FileOperation> getFileOperationsWithErrors( ) {

        return getFileOperationsWithStausSeverity( IStatus.ERROR );
    }

    public Collection<FileOperation> getFileOperationsWithWarnings( ) {

        return getFileOperationsWithStausSeverity( IStatus.WARNING );
    }

    public Collection<FileOperation> getFileOperationsWithStausSeverity( int severity ) {

        List<FileOperation> result = new ArrayList<FileOperation>( );
        Set<FileOperation> fileOperations = statusForFileOperations.keySet( );
        for ( FileOperation fileOperation : fileOperations ) {
            IStatus status = statusForFileOperations.get( fileOperation );
            if ( status.getSeverity( ) == severity ) {
                result.add( fileOperation );
            }
        }
        return result;
    }


}
