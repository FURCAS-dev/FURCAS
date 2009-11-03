package com.sap.tc.moin.versioning.di;

import org.eclipse.core.resources.IFile;

public class FileOperation {

    private static final String SPACE_STRING = " "; //$NON-NLS-1$

	public enum OperationType {
        EDIT, EDIT_EXCLUSIVE, PREPARE_DELETE, PREPARE_CREATE
    };

    private IFile file;

    private OperationType operationType;

    public FileOperation( IFile file, OperationType operationType ) {

        super( );
        this.file = file;
        this.operationType = operationType;
    }

    public IFile getFile( ) {

        return file;
    }

    public void setFile( IFile file ) {

        this.file = file;
    }

    public OperationType getOperationType( ) {

        return operationType;
    }

    public void setOperationType( OperationType operationType ) {

        this.operationType = operationType;
    }

    public String toString( ) {

        return file.toString( ) + SPACE_STRING + operationType.toString( );
    }
}
