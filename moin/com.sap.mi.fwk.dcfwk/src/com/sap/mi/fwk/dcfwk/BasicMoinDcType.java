package com.sap.mi.fwk.dcfwk;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.sap.ide.dii05.lib.api.core.IDcProject;
import com.sap.ide.dii05.lib.api.modeledit.IMeDcMetadataState;
import com.sap.ide.dii05.lib.api.modeledit.IMePublicPart;
import com.sap.ide.dii05.lib.api.typefw.IPublicPartEntityService;
import com.sap.ide.dii05.model.api.IComponentType;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.model.api.Purpose;
import com.sap.ide.dii05.repository.api.IChangelistProvider;
import com.sap.ide.dii05.ui.api.typefw.BasicDcTypeDelegate;
import com.sap.ide.dii05.ui.api.typefw.IDevelopmentComponentTypeDelegate;
import com.sap.ide.dii05.ui.api.typefw.IGenericNewDcWizard;
import com.sap.ide.dii05.ui.api.typefw.ITypeSpecificNewDcWizard;
import com.sap.ide.dii05.ui.internal.type.entity.FilesAndFolderPpEntityService;
import com.sap.mi.fwk.dcfwk.internal.DcFwkPlugin;
import com.sap.mi.fwk.dcfwk.ui.NewMoinDcWizardDelegate;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * Abstract implementation of a DC type and {@link IMoinDcType}. DC types with
 * Java notion should subclass
 * <code>com.sap.ide.dii05.jdt.api.type.JavaDCType</code> instead and
 * implement {@link IMoinDcType} directly.
 * 
 * @author d031150
 */
public abstract class BasicMoinDcType extends BasicDcTypeDelegate implements IMoinDcType, IExecutableExtension {

	static final TracerI sTracer = TracingManager.getTracer(BasicMoinDcType.class);

	private MoinDcOptions mOptions;

	private IComponentType mCompType;

	/**
	 * Creates a new delegate. Used by Eclipse extension instantiation.
	 */
	public BasicMoinDcType() {
		super();
	}

	/**
	 * Does nothing by default
	 * 
	 * @see IMoinDcType#configure(IDevelopmentComponent, IMeDcMetadataState)
	 */
	public void configure(IDevelopmentComponent dc, IMeDcMetadataState editableState) throws CoreException {
	}

	/**
	 * Does nothing by default
	 * 
	 * @see IMoinDcType#init(IDevelopmentComponent, IProject, IProgressMonitor)
	 */
	public void init(IDevelopmentComponent dc, IProject project, IProgressMonitor monitor) throws CoreException {
	}

	/**
	 * @returns a cleaned or new options instance, never <code>null</code>.
	 *          By default new {@link MoinDcOptions standard settings} are
	 *          returned.
	 */
	protected MoinDcOptions newOptions() {
		return new CompatibilityDcOptions();
	}

	/**
	 * Creates a default wizard with one additional page for the public part
	 * handling, which currently displays two options for whether to create
	 * compilation and assembly public parts.
	 */
	@Override
	public final ITypeSpecificNewDcWizard getTypeSpecificNewDcWizard(IGenericNewDcWizard outerWizard) {
		return new NewMoinDcWizardDelegate(outerWizard, this);
	}

	/**
	 * @return by default <code>false</code> for
	 *         {@link Purpose#INFRASTRUCTURE_LITERAL infrastructure} public
	 *         parts, <code>true</code> otherwise
	 * 
	 * @see BasicDcTypeDelegate#supportsPublicPartPurpose(Purpose)
	 */
	@Override
	public boolean supportsPublicPartPurpose(Purpose purpose) {
		if (Purpose.INFRASTRUCTURE_LITERAL == purpose)
			return false;
		return true;
	}

	/**
	 * This default implementation returns the ids of the
	 * {@link IPublicPartEntityService entity services} for files and folders (
	 * <code>com.sap.ide.dii05.ui.internal.type.entity.FilesAndFolderPpEntityService</code>)
	 * as well as for
	 * {@link ModelFolderTreeEntityService#ID_SERVICE_MODEL_FOLDER_TREE model folder trees}.
	 * Subclasses may override with more specific entity services. Note that
	 * these services must be registered via extension point
	 * <code>com.sap.ide.dii05.lib.ppentityservices</code>.
	 * 
	 * @see IDevelopmentComponentTypeDelegate#getSupportedPublicPartEntityServiceIds(IDevelopmentComponent)
	 */
	@Override
	public String[] getSupportedPublicPartEntityServiceIds(IDevelopmentComponent dc) {
		return new String[] { FilesAndFolderPpEntityService.ID,
				ModelFolderTreeEntityService.ID_SERVICE_MODEL_FOLDER_TREE };
	}

	/**
	 * @deprecated use {@link MoinDcOptions#getNatures()} by overriding
	 *             {@link #getOptions(boolean)}
	 */
	@Deprecated
	public String[] getNatures() {
		return MoinDcOptions.NO_NATURES;
	}

	/**
	 * @deprecated use {@link MoinDcOptions#getBuilders()} by overriding
	 *             {@link #getOptions(boolean)}
	 */
	@Deprecated
	public String[] getBuilders() {
		return MoinDcOptions.NO_BUILDERS;
	}

	/**
	 * @return descriptors for folders where Moin content should be stored. The
	 *         given folders will be created on file system and appropriately
	 *         registered at the development infrastructure.
	 * 
	 * @see MoinFolderInfo#MoinFolderInfo(IPath, boolean)
	 * 
	 * @deprecated use {@link MoinDcOptions#getFolders()} by overriding
	 *             {@link #getOptions(boolean)}
	 */
	@Deprecated
	public MoinFolderInfo[] getFolders() {
		return MoinDcOptions.NO_FOLDERS;
	}

	@Override
	public final IStatus dcProjectCreated(IDcProject dcProject, IProgressMonitor monitor) {
		try {
			MoinProject.configureProject(dcProject.getProject(), getOptions(false), monitor);
			return Status.OK_STATUS;
		} catch (CoreException e) {
			DcFwkPlugin.logError(e, sTracer);
			return e.getStatus();
		}
	}

	/**
	 * @return settings for the DC creation. Calls {@link #newOptions()}
	 *         whenever
	 *         <code>reset/code> is <code>true</code>, otherwise uses a cached value.
	 */
	public final MoinDcOptions getOptions(boolean reset) {
		if (mOptions == null || reset)
			mOptions = newOptions();
		// clear the delegator dc type to avoid circular calls
		mOptions.setDcType(null);
		return mOptions;
	}

	/**
	 * @return the DC type identifier. The default implementation reads the
	 *         corresponding data this class is registered with at the
	 *         <code>com.sap.ide.dii05.ui.dctype</code> extension point. The
	 *         the information is only available on instances created by Eclipse
	 *         extension instantiation (which is the usual case).
	 * 
	 * @see IMoinDcType#getComponentType()
	 */
	public IComponentType getComponentType() {
		return mCompType;
	}

	/**
	 * @see #getComponentType()
	 */
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		String id = config.getAttribute("type"); //$NON-NLS-1$
		String vendor = config.getAttribute("vendor"); //$NON-NLS-1$
		String subType = config.getAttribute("subtype"); //$NON-NLS-1$
		mCompType = MoinProject.getDcType(id, vendor, subType);
	}

	/**
	 * Bridges to the corresponding methods on {@link BasicMoinDcType} for
	 * compatibility reasons
	 */
	private final class CompatibilityDcOptions extends MoinDcOptions {
		@Override
		BasicMoinDcType getMoinDcType() {
			return BasicMoinDcType.this;
		}

		@Override
		public String[] getNatures() {
			// bridge to old method
			return getMoinDcType().getNatures();
		}

		@Override
		public String[] getBuilders() {
			// bridge to old method
			return getMoinDcType().getBuilders();
		}

		@Override
		public MoinFolderInfo[] getFolders() throws CoreException {
			// bridge to old method
			return getMoinDcType().getFolders();
		}

		@Override
		public IMePublicPart[] getPublicParts(IDevelopmentComponent dc, IChangelistProvider changelistProvider) throws CoreException {
			IMePublicPart[] pps = MoinProject.getPublicPartsForModelFolderTree(this, dc,
					ModelFolderTreeEntityService.TYPE_MODEL_FOLDER_TREE, changelistProvider);
			return pps;
		}

	}

}
