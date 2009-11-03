package com.sap.tc.moin.versioning.di;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

public interface VersioningService {

    public void setProgressMonitor( IProgressMonitor monitor );

    /**
     * The method <code>prepareModification</code> is used to prepare changes
     * in a set of files. In a first step it is checked for the provided files
     * if the desired operation is possible. Then the user is shown a pop up
     * that shows the results of the checks and offers a checkout button if all
     * operations can be executed.
     * <p>
     * <b>Precondition</b>: the method must be called in the UI thread.
     * <p>
     * <b>Limitation</b>: all files must be contained in the same project.
     * 
     * @param fileOperations A <code>FileOperation</code> contains a file
     * object and the desired operation on the file:
     * <ul>
     * <li>ADD: It is checked if creating a file with the given path would
     * cause problems e.g. local remote conflicts (a file with the given path
     * already exists in the repository)
     * <li>EDIT: It is checked if checking out the file for edit is possible,
     * e.g. it it checked if file is synced to latest and not checked out by
     * others. After the confirmation of the user the file is checked out for
     * edit.
     * <li>EDIT_EXCLUSIVE: Same as EDIT but the file is checked out for edit
     * exclusive.
     * <li>PREPARE_DELETE: It is checked if it is possible to delete the given
     * file. After the confirmation of the user the file is checked out for edit
     * exclusive. This is done to ensure that deletion of the file is possible
     * at a later point of time (e.g. on commit of a Model layer).
     * </ul>
     * @return
     */
    public IStatus prepareModification( Collection<FileOperation> fileOperations, boolean headless, String changelistID );

    /**
     * The method <code>deleteFiles</code> deletes the given files.
     * <p>
     * <b>Precondition</b>: the method must be called in the UI thread.
     * <p>
     * <b>Limitation</b>: all files must be contained in the same project.
     * <p>
     * 1. Behaviour in projects that are not shared: the files in filesToDelete
     * are deleted.
     * <p>
     * 2. Behaviour in shared projects: the following is performed for each file
     * in filesToDelete
     * <ul>
     * <li>file is NOT_CHECKED_OUT: file is deleted<br>
     * <li>file is LOCAL_ONLY and NOT_CHECKED_OUT: (just a new file...): file
     * is deleted<br>
     * <li>file is CHECKED_OUT_FOR_CREATE: file is reverted and deleted<br>
     * <li>file is CHECKED_OUT_FOR_EDIT: file is reverted and checked out for
     * delete<br>
     * <li>file is CHECKED_OUT_FOR_DELETE: a file with the same path was
     * deleted some time before. File was recreated locally. In this case file
     * is deleted and the checkout state remains unchanged
     * </ul>
     * In case of an error a pop up is shown describing all errors
     * 
     * @param filesToDelete
     * @param progressMonitor
     */
    public void deleteFiles( Collection<IFile> filesToDelete, IProgressMonitor progressMonitor );

    /**
     * The method <code>addFilesToSourceControl</code> adds files to source
     * control or it checks-out-for-edit the files (if they already are
     * versioned).<br>
     * <p>
     * <b>Precondition</b>: project is under source control and user is logged
     * on to the repository.<br>
     * <p>
     * <b>Precondition</b>: the method must be called in the UI thread.
     * <p>
     * <b>Limitation</b>: all files must be contained in the same project. The
     * following checks are performed.
     * <ul>
     * <li>it is checked if the corresponding DC can be modified<br>
     * <li>the repository state of the files is refreshed<br>
     * <li>for each file the following checks are performed.<br>
     * a) Does the file have a LOCAL_REMOTE_NAMECLASH? yes => error<br>
     * b) Is the corresponding VFS File checked out for delete? yes => warning<br>
     * </ul>
     * The Check Results are displayed on a popup if there are at least
     * warnings. Finally the files are added to source control.
     * 
     * @param files files to be added to source control
     * @param changelistId changelist to be used
     * @param progressMonitor
     */
    public void addOrEditFilesToSourceControl( Collection<IFile> files, String changelistId, IProgressMonitor progressMonitor );

    /**
     * The method provides an activity from the user
     * 
     * @param resource a resource representing the development configuration
     * @return id of the activity or null if the usr canceled the activity
     * selection dialog
     */
    public String getChangelistFromUser( IResource resource );
    
    boolean isExcludedFromVersioning( IFile file );
}
