package com.sap.mi.fwk.dcfwk;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.PlatformObject;

/**
 * Describes the structure and properties of a folder in a Moin DC.
 * 
 * @author d031150
 */
public final class MoinFolderInfo extends PlatformObject {

	public static final int DC_FOLDER_TYPE_RESOURCE = 0;
	public static final int DC_FOLDER_TYPE_PACKAGE = 1;
	public static final int DC_FOLDER_TYPE_NONE = 2;

	private final IPath mPath;
	private final boolean mResourceFolder;
	private final boolean mPackageFolder;
	private final boolean mRelevantForMoin;
	private final boolean mExcludedInIde;
	private final boolean mExcludedInBuild;

	/**
	 * Creates a folder descriptor for the given DC-relative path
	 * 
	 * @param path
	 *            the folder path. Must be relative to the respective DC or
	 *            project, e.g. <code>src/packages</code>. Must not be
	 *            <code>null</code> nor empty.
	 * @param isResourceFolder
	 *            <code>true</code> to indicate that the folder is also visible
	 *            during DC build (locally and on central build servers).
	 *            <code>false</code> signals that the folder is not needed
	 *            during build, but is relevant for other purposes, e.g.
	 *            debugging.
	 * 
	 * @see #MoinFolderInfo(IPath, boolean, boolean, boolean)
	 */
	public MoinFolderInfo(IPath path, boolean isResourceFolder) {
		this(path, isResourceFolder, false, false);
	}

	/**
	 * Creates a folder descriptor for the given DC-relative path
	 * 
	 * @param path
	 *            the folder path. Must be relative to the respective DC or
	 *            project, e.g. <code>src/packages</code>. Must not be
	 *            <code>null</code> nor empty.
	 * @param isResourceFolder
	 *            <code>true</code> to indicate that the folder is also visible
	 *            during DC build (locally and on central build servers).
	 *            <code>false</code> signals that the folder is not needed
	 *            during build, but is relevant for other purposes, e.g.
	 *            debugging.
	 * @param excludedInIde
	 *            if <code>true</code>, all content in this folder is not
	 *            visible for Moin in the IDE, which means that partitions
	 *            cannot be stored nor read from this location. Useful as a
	 *            storage for non-modelled resources like images. Must be
	 *            <code>false</code> if <code>isResourceFolder==true</code>.
	 * @param excludedInBuild
	 *            if <code>true</code>, all content in this folder is not
	 *            visible for Moin during DC build (locally and on central build
	 *            servers). Must be <code>false</code> if
	 *            <code>isResourceFolder==true</code>.
	 * @see #MoinFolderInfo(IPath, boolean)
	 */
	public MoinFolderInfo(IPath path, boolean isResourceFolder, boolean excludedInIde, boolean excludedInBuild) {
		if (path == null)
			throw new IllegalArgumentException("Path must not be null"); //$NON-NLS-1$
		if (path.isEmpty())
			throw new IllegalArgumentException("Path must not be empty"); //$NON-NLS-1$
		if (isResourceFolder) {
			if (excludedInIde)
				throw new IllegalArgumentException("Resource folder must not be excluded in IDE: " + path); //$NON-NLS-1$
			// <sw 08102008> removed due to CSN 0120031469 0003938876 2008:
			// diagram folder is now a MOIN resource folder but excluded in
			// build
			// if (excludedInBuild)
			//				throw new IllegalArgumentException("Resource folder must not be excluded in build: " + path); //$NON-NLS-1$
			// </sw 08102008>
		}
		mPath = path;
		mResourceFolder = isResourceFolder;
		mPackageFolder = false;
		mRelevantForMoin = true;
		mExcludedInIde = excludedInIde;
		mExcludedInBuild = excludedInBuild;
	}

	/**
	 * Creates a folder descriptor for the given DC-relative path
	 * 
	 * @param path
	 *            the folder path. Must be relative to the respective DC or
	 *            project, e.g. <code>src/packages</code>. Must not be
	 *            <code>null</code> nor empty.
	 * @param dcFolderType
	 *            {@link #DC_FOLDER_TYPE_RESOURCE} to indicate that the folder
	 *            is a resource folder for the DC (containing non-Java files)
	 *            and also visible during DC build (locally and on central build
	 *            servers). {@link #DC_FOLDER_TYPE_PACKAGE} to indicate that the
	 *            folder is a package folder for the DC (containing Java files)
	 *            and also visible during DC build (locally and on central build
	 *            servers). {@value #DC_FOLDER_TYPE_NONE} signals that the
	 *            folder is not needed during build, but is relevant for other
	 *            purposes, e.g. debugging.
	 * @param relevantForMoin
	 *            if <code>true</code>, this folder will be visible for MOIN and
	 *            will be set as a MOIN folder or MOIN Resource folder. It may
	 *            then contain MOIN partition files that can be read by MOIN.
	 *            <p>
	 *            if <code>false</code>, this folder will not be registered for
	 *            MOIN which means that MOIN will not be able to access any
	 *            partitions stored inside.
	 *            <p>
	 *            Additionally and independently from the value of this
	 *            parameter, this folder may be set as a DC folder as controlled
	 *            by the parameter <code>dcFolderType</code>.
	 * @param excludedInIde
	 *            if <code>true</code>, all content in this folder is not
	 *            visible for Moin in the IDE, which means that partitions
	 *            cannot be stored nor read from this location. Useful as a
	 *            storage for non-modelled resources like images. Must be
	 *            <code>false</code> if <code>isResourceFolder==true</code>.
	 * @param excludedInBuild
	 *            if <code>true</code>, all content in this folder is not
	 *            visible for Moin during DC build (locally and on central build
	 *            servers). Must be <code>false</code> if
	 *            <code>isResourceFolder==true</code>.
	 * @see #MoinFolderInfo(IPath, boolean)
	 */
	public MoinFolderInfo(IPath path, int dcFolderType, boolean relevantForMoin, boolean excludedInIde,
			boolean excludedInBuild) {
		if (path == null)
			throw new IllegalArgumentException("Path must not be null"); //$NON-NLS-1$
		if (path.isEmpty())
			throw new IllegalArgumentException("Path must not be empty"); //$NON-NLS-1$
		switch (dcFolderType) {
		case DC_FOLDER_TYPE_RESOURCE:
			if (excludedInIde) {
				throw new IllegalArgumentException("Resource folder must not be excluded in IDE: " + path); //$NON-NLS-1$
			}
			// <sw 08102008> removed due to CSN 0120031469 0003938876 2008:
			// diagram folder is now a MOIN resource folder but excluded in
			// build
			// if (excludedInBuild)
			//				throw new IllegalArgumentException("Resource folder must not be excluded in build: " + path); //$NON-NLS-1$
			// </sw 08102008>
			mResourceFolder = true;
			mPackageFolder = false;
			break;
		case DC_FOLDER_TYPE_PACKAGE:
			if (excludedInIde) {
				throw new IllegalArgumentException("Package folder must not be excluded in IDE: " + path); //$NON-NLS-1$
			}
			mResourceFolder = false;
			mPackageFolder = true;
			break;
		case DC_FOLDER_TYPE_NONE:
			mResourceFolder = false;
			mPackageFolder = false;
		default:
			throw new IllegalArgumentException(
					"dcFolderType must be one of 'DC_FOLDER_TYPE_RESOURCE', 'DC_FOLDER_TYPE_PACKAGE' or 'DC_FOLDER_TYPE_NONE': " + dcFolderType); //$NON-NLS-1$
		}
		mPath = path;
		mRelevantForMoin = relevantForMoin;
		mExcludedInIde = excludedInIde;
		mExcludedInBuild = excludedInBuild;
	}

	/**
	 * @return this folder's DC-relative path, e.g. <code>src/packages</code>
	 */
	public IPath getPath() {
		return mPath;
	}

	/**
	 * @return whether the folder is also visible during DC build as a DC
	 *         resource folder (locally and on central build servers, containing
	 *         non-Java files). <code>false</code> signals that the folder is
	 *         not needed during build, but is relevant for other purposes, e.g.
	 *         debugging. A DC folder can either be a DC resource or a DC
	 *         package folder, {@link #isPackageFolder()}.
	 */
	public boolean isResourceFolder() {
		return mResourceFolder;
	}

	/**
	 * @return whether the folder is also visible during DC build as a DC
	 *         package folder (locally and on central build servers, containing
	 *         Java files). <code>false</code> signals that the folder is not
	 *         needed during build, but is relevant for other purposes, e.g.
	 *         debugging. A DC folder can either be a DC resource or a DC
	 *         package folder, {@link #isResourceFolder()}.
	 */
	public boolean isPackageFolder() {
		return mPackageFolder;
	}

	/**
	 * @return whether content in this folder is visible for Moin at all
	 */
	public boolean isRelevantForMoin() {
		return mRelevantForMoin;
	}

	/**
	 * @return whether content in this folder is visible for Moin in the IDE
	 */
	public boolean isExcludedInIde() {
		return mExcludedInIde;
	}

	/**
	 * @return whether content in this folder is visible for Moin during DC
	 *         build
	 */
	public boolean isExcludedInBuild() {
		return mExcludedInBuild;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (mExcludedInBuild ? 1231 : 1237);
		result = prime * result + (mExcludedInIde ? 1231 : 1237);
		result = prime * result + (mResourceFolder ? 1231 : 1237);
		result = prime * result + ((mPath == null) ? 0 : mPath.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final MoinFolderInfo other = (MoinFolderInfo) obj;
		if (mExcludedInBuild != other.mExcludedInBuild)
			return false;
		if (mExcludedInIde != other.mExcludedInIde)
			return false;
		if (mResourceFolder != other.mResourceFolder)
			return false;
		if (mPath == null) {
			if (other.mPath != null)
				return false;
		} else if (!mPath.equals(other.mPath))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder(mPath.toString());
		s.append(", resourceFolder=").append(mResourceFolder); //$NON-NLS-1$
		s.append(", excludedInIde=").append(mExcludedInIde); //$NON-NLS-1$
		s.append(", excludedInBuild=").append(mExcludedInBuild); //$NON-NLS-1$
		return s.toString();
	}

}