package com.sap.mi.fwk.dcfwk;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

import com.sap.ide.dii05.lib.api.modeledit.IMePublicPart;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.model.api.Purpose;
import com.sap.ide.dii05.repository.api.IChangelistProvider;

/**
 * Settings used on Moin DC creation.<p/> Clients should extend as needed.
 *
 * @author d031150
 */
public class MoinDcOptions {

	/**
	 * Indicates no builders
	 */
	public static final String[] NO_BUILDERS = new String[0];

	/**
	 * Indicates no natures
	 */
	public static final String[] NO_NATURES = new String[0];

	/**
	 * Indicates no folders
	 */
	public static final MoinFolderInfo[] NO_FOLDERS = new MoinFolderInfo[0];

	/**
	 * Indicates no public parts
	 */
	public static final IMePublicPart[] NO_PUBLIC_PARTS = new IMePublicPart[0];

	private IMoinDcType mMoinDcType;
	private final Map<Purpose, Boolean> mCreatePublicParts = new HashMap<Purpose, Boolean>(
			Purpose.VALUES.size() * 4 / 3);

	/**
	 * Creates new options
	 */
	public MoinDcOptions() {
	}

	/**
	 * Returns additional builder ids that are supposed to be set on creation of
	 * the DC project. Note that these ids must be declared using the
	 * <code>org.eclipse.resources.builders</code> extension point, and
	 * usually connected with a nature in the corresponding
	 * <code>org.eclipse.resources.natures</code> extension.
	 *
	 * @return an empty array by default, which means only generic Moin builders
	 *         are added
	 */
	public String[] getBuilders() {
		if (mMoinDcType != null) {
			MoinDcOptions typeOptions = mMoinDcType.getOptions(false);
			if (typeOptions != null) {
				String[] builders = typeOptions.getBuilders();
				return builders;
			}
		}
		return NO_BUILDERS;
	}

	/**
	 * Returns additional nature ids that are supposed to be set on creation of
	 * the DC project. Note that these ids must be declared using the
	 * <code>org.eclipse.resources.natures</code> extension point.
	 *
	 * @return an empty array by default, which means only a generic Moin nature
	 *         is added
	 *
	 * @see IProjectNature
	 */
	public String[] getNatures() {
		if (mMoinDcType != null) {
			MoinDcOptions typeOptions = mMoinDcType.getOptions(false);
			if (typeOptions != null) {
				String[] natures = typeOptions.getNatures();
				return natures;
			}
		}
		return NO_NATURES;
	}

	/**
	 * @param dc
	 *            the DC
	 * @return whether a project is to be created on DC creation. Default is
	 *         <code>true</code>.
	 * @throws CoreException
	 *             in case of errors
	 */
	public boolean createProject(IDevelopmentComponent dc) throws CoreException {
		return true;
	}

	/**
	 * Returns the definitions for Moin-relevant folders. These folders are
	 * created on DC creation.
	 *
	 * @param dc
	 *            the DC to return the folders for
	 * @return the folders to create. The default implementation asks the
	 *         {@link IMoinDcType#getOptions(boolean) Moin DC type} if
	 *         available, otherwise returns an empty array.
	 * @throws CoreException
	 *             in case of errors
	 *
	 * @see MoinFolderInfo#MoinFolderInfo(IPath, boolean, boolean, boolean)
	 */
	public MoinFolderInfo[] getFolders() throws CoreException {
		if (mMoinDcType != null) {
			MoinDcOptions typeOptions = mMoinDcType.getOptions(false);
			if (typeOptions != null) {
				MoinFolderInfo[] folders = typeOptions.getFolders();
				return folders;
			}
		}
		return NO_FOLDERS;
	}

	/**
	 * Returns whether it is possible for the user to decide to create a public
	 * part of the given purpose or not. This allows for DC types to enforce or
	 * deny the creation of distinct public parts.
	 *
	 * @param publicPartPurpose
	 *            the purpose of the public part
	 * @return <code>true</code> if the user has the chance to alter the
	 *         public part toggle. The default is <code>true</code> for all
	 *         purposes.
	 */
	public boolean isPublicPartCreationChangeable(Purpose publicPartPurpose) {
		return true;
	}

	/**
	 * Returns whether a default public part of the given purpose is to be
	 * created. The default implementation returns the hint set by
	 * {@link #setCreatePublicParts(Purpose, boolean)}, which is done on DC
	 * creation based on a user decision.
	 *
	 * @param publicPartPurpose
	 *            the purpose of the public part
	 * @return whether to create a public part
	 *
	 * @see #setCreatePublicParts(Purpose, boolean)
	 * @see #getPublicParts(IDevelopmentComponent)
	 */
	public synchronized boolean createPublicPart(Purpose publicPartPurpose) {
		Boolean create = mCreatePublicParts.get(publicPartPurpose);
		if (create == null) {
			create = getPublicPartCreationDefault(publicPartPurpose);
		}
		return create;
	}

	/**
	 * Returns the default value for {@link #createPublicPart(Purpose)}.
	 *
	 * @param publicPartPurpose
	 *            the purpose of the public part
	 * @return the default value. This default's default is <code>true</code>
	 *         for <code>compilation</code> public parts only.
	 */
	public boolean getPublicPartCreationDefault(Purpose publicPartPurpose) {
		return Purpose.COMPILATION_LITERAL == publicPartPurpose;
	}

	/**
	 * Returns the public parts that are supposed to be created on creation of
	 * the DC. The default implementation asks the
	 * {@link IMoinDcType Moin DC type} if available, otherwise returns an empty
	 * array.
	 *
	 * @param dc
	 *            the DC to create the public parts for
	 * @param changelistProvider
	 *            a change list provider can be specified to suppress the select activity
	 *            dialog.
	 * @return the public parts
	 * @throws CoreException
	 *             if creation fails
	 *
	 * @see #createPublicPart(Purpose)
	 */
	public IMePublicPart[] getPublicParts(IDevelopmentComponent dc, IChangelistProvider changelistProvider) throws CoreException {
		if (mMoinDcType != null) {
			MoinDcOptions typeOptions = mMoinDcType.getOptions(false);
			if (typeOptions != null) {
				IMePublicPart[] pps = typeOptions.getPublicParts(dc, changelistProvider);
				return pps;
			}
		}
		return NO_PUBLIC_PARTS;
	}

	/**
	 * Sets whether a public part of the given purpose is to be created, based
	 * on a user decision.
	 *
	 * @param publicPartPurpose
	 *            the purpose of the public part
	 * @param create
	 *            whether to create a public part
	 *
	 * @see #createPublicPart(Purpose)
	 */
	public final synchronized void setCreatePublicParts(Purpose publicPartPurpose, boolean create) {
		mCreatePublicParts.put(publicPartPurpose, create);
	}

	/**
	 * Answers whether Moin is to be refreshed based on the definition of the
	 * given DC. Returns <code>true</code> by default. <code>false</code>
	 * should be returned with care since this means that Moin will not be
	 * aware about recent updates of the DC definition.
	 *
	 * @param dc
	 *            the DC to refresh Moin for
	 * @return whether a refresh should be triggered
	 */
	public boolean refreshMoin(IDevelopmentComponent dc) {
		return true;
	}

	/**
	 * <em>For internal use only</em>. Sets a DC type to delegate to if this
	 * options should delegate to the type's
	 * {@link IMoinDcType#getOptions(boolean) options}.
	 *
	 * @param moinDcType
	 *            the DC type to delegate to
	 * @return this instance for convenience
	 */
	MoinDcOptions setDcType(IMoinDcType moinDcType) {
		mMoinDcType = moinDcType;
		return this;
	}

	/**
	 * @return the DC type set by {@link #setDcType(IMoinDcType)} or
	 *         <code>null</code>
	 */
	IMoinDcType getMoinDcType() {
		return mMoinDcType;
	}

}
