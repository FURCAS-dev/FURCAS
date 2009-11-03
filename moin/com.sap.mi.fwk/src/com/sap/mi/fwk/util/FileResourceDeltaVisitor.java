package com.sap.mi.fwk.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

/**
 * A resource delta visitor for files that groups the recorded deltas along the
 * operations add, delete, move and content change. Additionally a set of file
 * extensions needs to be specified as a filter. Used by
 * {@link FileBasedBuilder} class.
 * 
 * @author d031150
 */
public final class FileResourceDeltaVisitor implements IResourceDeltaVisitor {

	private final List<IFile> mAddedFiles = new ArrayList<IFile>();
	private final List<IFile> mDeletedFiles = new ArrayList<IFile>();
	private final List<IFile> mChangedFiles = new ArrayList<IFile>();
	private final List<IFile> mMovedFilesOld = new ArrayList<IFile>();
	private final List<IFile> mMovedFilesNew = new ArrayList<IFile>();
	private final List<String> mFileExtensions;
	private final IPath[] mRelevantFolders;

	/**
	 * Creates a new visitor that considers files with the given extensions
	 * 
	 * @param extensions
	 *            the extensions to consider
	 * @param relevantFolders
	 *            the paths that are supposed to be considered as legal folders.
	 *            Add, move and content changes are issued only for files in
	 *            these folders (and sub folders). Deletions, however, may also
	 *            be propagated for files outside.
	 */
	public FileResourceDeltaVisitor(String[] extensions, IPath[] relevantFolders) {
		if (extensions == null)
			throw new IllegalArgumentException("Extensions must not be null"); //$NON-NLS-1$
		if (relevantFolders == null)
			throw new IllegalArgumentException("Folders must not be null"); //$NON-NLS-1$
		mFileExtensions = Arrays.asList(extensions);
		mRelevantFolders = relevantFolders;
	}

	/**
	 * @return all files that are new
	 */
	public IFile[] getAddedFiles() {
		return mAddedFiles.toArray(new IFile[mAddedFiles.size()]);
	}

	/**
	 * @return all files that have been deleted
	 */
	public IFile[] getDeletedFiles() {
		return mDeletedFiles.toArray(new IFile[mDeletedFiles.size()]);
	}

	/**
	 * @return all files whose content has changed
	 */
	public IFile[] getChangedFiles() {
		return mChangedFiles.toArray(new IFile[mChangedFiles.size()]);
	}

	/**
	 * @return the former locations of all files that have been moved
	 */
	public IFile[] getMovedFilesOld() {
		return mMovedFilesOld.toArray(new IFile[mMovedFilesOld.size()]);
	}

	/**
	 * @return the new locations of all files that have been moved
	 */
	public IFile[] getMovedFilesNew() {
		return mMovedFilesNew.toArray(new IFile[mMovedFilesNew.size()]);
	}

	/**
	 * Processes the given delta as specified. Results can be obtained through
	 * the getter methods of this visitor.
	 */
	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource resource = delta.getResource();

		// exclude root, projects, folders
		if (!(resource instanceof IFile))
			return true;

		int kind = delta.getKind();
		int flags = delta.getFlags();
		String extension = resource.getFileExtension();
		if (kind == IResourceDelta.CHANGED || kind == IResourceDelta.REMOVED) {
			// only interested in content changes
			if (kind == IResourceDelta.CHANGED && (flags & IResourceDelta.CONTENT) == 0)
				return true;

			if (!mFileExtensions.contains(extension))
				return true;

			if (kind == IResourceDelta.CHANGED) {
				if (!isContainedInPath(mRelevantFolders, resource))
					return false;
				mChangedFiles.add((IFile) resource);
			} else if (kind == IResourceDelta.REMOVED) {
				if ((flags & IResourceDelta.MOVED_TO) != 0) {
					IFile newFile = resource.getWorkspace().getRoot().getFile(delta.getMovedToPath());
					// If the new location is not below the allowed paths,
					// only issue a delete, not a move.
					// The other way round, however, we accept a disallowed
					// path to appear as old location.
					if (!isContainedInPath(mRelevantFolders, newFile)) {
						mDeletedFiles.add((IFile) resource);
					} else {
						mMovedFilesOld.add((IFile) resource);
						mMovedFilesNew.add(newFile);
						// On file move Eclipse also issues an add event.
						// Check whether this is the case and revert it.
						mAddedFiles.remove(newFile);
					}
				} else {
					mDeletedFiles.add((IFile) resource);
				}
			}
		} else if (kind == IResourceDelta.ADDED) {
			if (!mFileExtensions.contains(extension))
				return true;
			if (!isContainedInPath(mRelevantFolders, resource))
				return false;
			// On file move Eclipse also issues an add event,.
			// which we want to suppress. Only let "real" adds pass.
			if (!mMovedFilesNew.contains(resource))
				mAddedFiles.add((IFile) resource);
		}
		return true;
	}

	/**
	 * @return whether the given resource is contained in one of the given paths
	 */
	static boolean isContainedInPath(IPath[] paths, IResource resource) {
		IPath resRelPath = resource.getProjectRelativePath();
		IPath resAbsPath = resource.getFullPath();
		for (IPath path : paths) {
			if (path == null || path.isEmpty())
				throw new IllegalArgumentException("Path must not be null nor empty: " + path); //$NON-NLS-1$
			// "src/fooBar" in "src/fooBar/file.xml"
			if (path.isPrefixOf(resRelPath))
				return true;
			// "/Project" in "/Project/src/fooBar/file.xml"
			if (path.isPrefixOf(resAbsPath))
				return true;
		}
		return false;
	}

}