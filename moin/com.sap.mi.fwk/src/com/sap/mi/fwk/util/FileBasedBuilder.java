package com.sap.mi.fwk.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;

import com.sap.mi.fwk.internal.MiFwkPlugin;
import com.sap.mi.fwk.internal.tracing.MiLocations;

/**
 * Base class for a builder that provides file-based processing hooks rather
 * than resource delta traversal. The hooks are grouped along the operations
 * add, delete, move and content change. Additionally a set of file extensions
 * needs to be specified as a filter. Uses {@link FileResourceDeltaVisitor} for
 * delta processing.
 * 
 * @author d031150
 */
public abstract class FileBasedBuilder extends IncrementalProjectBuilder {

	private static final Logger sTracer = Logger.getLogger(MiLocations.MI);

	/**
	 * @return the file extensions this builder wants to process. Files with
	 *         other extensions are ignored.
	 */
	protected abstract String[] getFileExtensions();

	/**
	 * Called for all files which content have been modified.
	 * 
	 * @param files
	 *            the files which have been modified
	 * @param monitor
	 *            a progress monitor
	 * @throws CoreException
	 *             in case of failures
	 */
	protected abstract void processFilesWithChangedContent(IFile[] files, IProgressMonitor monitor)
			throws CoreException;

	/**
	 * Called for all files which content have been added.
	 * 
	 * @param files
	 *            the files which have been added
	 * @param monitor
	 *            a progress monitor
	 * @throws CoreException
	 *             in case of failures
	 */
	protected abstract void processAddedFiles(IFile[] files, IProgressMonitor monitor) throws CoreException;

	/**
	 * Called for all files which have been deleted.
	 * 
	 * @param files
	 *            the files which have been deleted
	 * @param monitor
	 *            a progress monitor
	 * @throws CoreException
	 *             in case of failures
	 */
	protected abstract void processDeletedFiles(IFile[] files, IProgressMonitor monitor) throws CoreException;

	/**
	 * Called for all file which has been moved.
	 * 
	 * @param oldFiles
	 *            the files before the were moved
	 * @param newFiles
	 *            the files where they are located now
	 * @param monitor
	 *            a progress monitor
	 * @throws CoreException
	 *             in case of failures
	 */
	protected abstract void processMovedFiles(IFile[] oldFiles, IFile[] newFiles, IProgressMonitor monitor)
			throws CoreException;

	/**
	 * Called if an unspecific resource change has occurred, or in case of a
	 * {@link IncrementalProjectBuilder#FULL_BUILD full} or
	 * {@link IncrementalProjectBuilder#CLEAN_BUILD clean} build. The default
	 * implementation calls
	 * {@link #processFilesWithChangedContent(IFile[], IProgressMonitor)} with
	 * all applicable files of the project, subclasses may implement a more
	 * efficient build strategy.
	 * 
	 * @param monitor
	 *            a progress monitor
	 * @throws CoreException
	 *             in case of failures
	 */
	protected void processFull(IProgressMonitor monitor) throws CoreException {
		IFile[] files = getAllFiles();
		if (sTracer.isLoggable(Level.FINE))
			sTracer.fine("Process all resources [value<" + Arrays.toString(files) + ">]"); //$NON-NLS-1$ //$NON-NLS-2$

		if (files.length > 0)
			processFilesWithChangedContent(files, monitor);
	}

	/**
	 * Returns the paths that are supposed to be considered as legal folders.
	 * Add, move and content changes are issued only for files in these folders
	 * (and sub folders). Deletions, however, may also be propagated for files
	 * outside. The default implementation returns the project root folder.
	 * 
	 * @return the relevant folders. Must not be <code>null</code> nor empty
	 *         nor absolute.
	 * @throws CoreException
	 *             in case of failures
	 */
	protected IPath[] getRelevantFolders() throws CoreException {
		IProject project = getProject();
		return new IPath[] { project.getFullPath() };
	}

	/**
	 * @return all files in the relevant {@link #getRelevantFolders() folders}
	 *         matching the relevant
	 *         {@link #getFileExtensions() file extensions}
	 * @throws CoreException
	 *             in case of failures
	 */
	protected IFile[] getAllFiles() throws CoreException {
		List<IFile> allFiles = new ArrayList<IFile>();
		FileResourceVisitor visitor = new FileResourceVisitor(allFiles, getRelevantFolders(), getFileExtensions());
		getProject().accept(visitor);
		return allFiles.toArray(new IFile[allFiles.size()]);
	}

	@Override
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
		if (kind == FULL_BUILD || kind == CLEAN_BUILD) {
			clean(monitor);
		}
		return doBuild(kind, args, monitor);
	}

	private IProject[] doBuild(int kind, Map args, IProgressMonitor monitor) throws CoreException {

		long startTime = 0L;
		if (sTracer.isLoggable(Level.FINE)) {
			sTracer.fine("Builder started"); //$NON-NLS-1$
			startTime = System.nanoTime();
		}

		IProject project = getProject();

		IResourceDelta delta = getDelta(project);
		if (delta != null) {
			FileResourceDeltaVisitor visitor = new FileResourceDeltaVisitor(getFileExtensions(), getRelevantFolders());

			try {
				delta.accept(visitor);
			} catch (CoreException e) {
				MiFwkPlugin.logError(e, sTracer);
			}

			IFile[] movedFilesNew = visitor.getMovedFilesNew();
			IFile[] movedFilesOld = visitor.getMovedFilesOld();
			IFile[] changedFiles = visitor.getChangedFiles();
			IFile[] addedFiles = visitor.getAddedFiles();
			IFile[] deletedFiles = visitor.getDeletedFiles();
			try {
				if (movedFilesNew.length > 0) {
					if (sTracer.isLoggable(Level.FINE))
						sTracer.fine("Process moved resources [value<" + Arrays.toString(movedFilesNew) + ">]"); //$NON-NLS-1$ //$NON-NLS-2$
					processMovedFiles(movedFilesOld, movedFilesNew, monitor);
				}

				if (changedFiles.length > 0) {
					if (sTracer.isLoggable(Level.FINE))
						sTracer.fine("Process changed resources [value<" + Arrays.toString(changedFiles) + ">]"); //$NON-NLS-1$ //$NON-NLS-2$
					processFilesWithChangedContent(changedFiles, monitor);
				}

				if (addedFiles.length > 0) {
					if (sTracer.isLoggable(Level.FINE))
						sTracer.fine("Process added resources [value<" + Arrays.toString(addedFiles) + ">]"); //$NON-NLS-1$ //$NON-NLS-2$
					processAddedFiles(addedFiles, monitor);
				}

				if (deletedFiles.length > 0) {
					if (sTracer.isLoggable(Level.FINE))
						sTracer.fine("Process deleted resources [value<" + Arrays.toString(deletedFiles) + ">]"); //$NON-NLS-1$ //$NON-NLS-2$
					processDeletedFiles(deletedFiles, monitor);
				}

			} catch (Exception e) {
				MiFwkPlugin.logError(e, sTracer);
			} finally {
				monitor.done();
				if (sTracer.isLoggable(Level.FINE)) {
					sTracer.fine("Builder finished [" + getClass().getName() + "] project [" + project.getName() //$NON-NLS-1$ //$NON-NLS-2$
							+ "]: " + (System.nanoTime() - startTime) / 1000000f + "ms"); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		} else { // no delta -> full or clean build - process all files
			processFull(monitor);
		}

		return null;
	}

	/**
	 * Returns all legal files in the resource tree the visitor is started from
	 */
	static final class FileResourceVisitor implements IResourceVisitor {
		private final List<IFile> mFiles;
		private final IPath[] mSourcePaths;
		private final List<String> mFileExtensions;

		FileResourceVisitor(List<IFile> files, IPath[] sourcePaths, String[] extensions) {
			mFiles = files;
			mSourcePaths = sourcePaths;
			mFileExtensions = Arrays.asList(extensions);
		}

		public boolean visit(IResource resource) throws CoreException {
			if (resource.getType() != IResource.FILE)
				return true;
			if (!mFileExtensions.contains(resource.getFileExtension()))
				return true;
			if (!FileResourceDeltaVisitor.isContainedInPath(mSourcePaths, resource))
				return false;
			mFiles.add((IFile) resource);
			return true;
		}
	}

}
