package com.sap.mi.fwk.dcfwk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.osgi.framework.Bundle;

import com.sap.ide.dii05.lib.api.commands.DiiCommandFactory;
import com.sap.ide.dii05.lib.api.core.IDcProject;
import com.sap.ide.dii05.lib.api.modeledit.DiiLibraryOperationCancelledException;
import com.sap.ide.dii05.lib.api.modeledit.DiiModelEditService;
import com.sap.ide.dii05.lib.api.modeledit.IMeAttribute;
import com.sap.ide.dii05.lib.api.modeledit.IMeCustomProperty;
import com.sap.ide.dii05.lib.api.modeledit.IMeCustomPropertyAttribute;
import com.sap.ide.dii05.lib.api.modeledit.IMeDcDependency;
import com.sap.ide.dii05.lib.api.modeledit.IMeDcMetadataState;
import com.sap.ide.dii05.lib.api.modeledit.IMeEntity;
import com.sap.ide.dii05.lib.api.modeledit.IMePublicPart;
import com.sap.ide.dii05.lib.api.modeledit.IMePublicPartRef;
import com.sap.ide.dii05.lib.api.modeledit.INewDcRequestForm;
import com.sap.ide.dii05.lib.api.modeledit.ModelEditFactory;
import com.sap.ide.dii05.lib.api.modeledit.ModelEditPackage;
import com.sap.ide.dii05.lib.api.typefw.IBasicDevelopmentComponentTypeDelegate;
import com.sap.ide.dii05.lib.api.util.DiiModelService;
import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.ide.dii05.lib.internal.dc.core.DCWizardUtil;
import com.sap.ide.dii05.lib.internal.type.BasicDcTypeManager;
import com.sap.ide.dii05.model.api.IAttribute;
import com.sap.ide.dii05.model.api.ICommonEntity;
import com.sap.ide.dii05.model.api.IComponentModel;
import com.sap.ide.dii05.model.api.IComponentType;
import com.sap.ide.dii05.model.api.ICustomProperty;
import com.sap.ide.dii05.model.api.ICustomPropertyAttribute;
import com.sap.ide.dii05.model.api.IDcMetadataState;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.model.api.IDevelopmentConfiguration;
import com.sap.ide.dii05.model.api.IEntity;
import com.sap.ide.dii05.model.api.IPublicPart;
import com.sap.ide.dii05.model.api.ISoftwareComponent;
import com.sap.ide.dii05.model.api.Purpose;
import com.sap.ide.dii05.model.api.RefreshState;
import com.sap.ide.dii05.repository.api.IChangelistProvider;
import com.sap.ide.dii05.ui.api.typefw.DiiDcTypeService;
import com.sap.ide.dii05.ui.api.typefw.DiiNewDcService;
import com.sap.ide.dii05.util.api.job.JdiJob;
import com.sap.ide.dii05.util.api.job.JobUtil;
import com.sap.ide.dii05.util.api.log.DiiMultiStatus;
import com.sap.mi.fwk.dcfwk.internal.DcFwkPlugin;
import com.sap.mi.fwk.dcfwk.internal.InvocationHelper;
import com.sap.mi.fwk.dcfwk.internal.messages.DcFwkMessages;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * Contains common constants for Moin projects and Development Components as
 * well as methods to create such projects programmatically.
 *
 * @author d031150
 */
public final class MoinProject {

	/**
	 * The SAP vendor. Value is <code>sap.com</code>.
	 *
	 * value: <code>sap.com</code>
	 */
	public static final String VENDOR_SAP = "sap.com"; //$NON-NLS-1$

	// DC def. constants
	private static final String ATT_IS_MOIN_DC = "is_moin_dc"; //$NON-NLS-1$

	/**
	 * DC definition property for MOIN. Should only be used for and inside MOIN
	 * DCs after alignment with the MOIN team.
	 */
	public static final String PROP_MOIN = "moin"; //$NON-NLS-1$

	/**
	 * DC definition property for the MOIN namespace. Should only be used for
	 * and inside MOIN DCs after alignment with the MOIN team.
	 */
	public static final String PROP_MOIN_NAMESPACE = "http://xml.sap.com/2007/05/MoinModel"; //$NON-NLS-1$

	// hardcoded to avoid dependency to com.sap.mi.fwk plugin
	private static final String ID_NATURE = "com.sap.mi.fwk.dcfwk.MoinNature"; //$NON-NLS-1$

	// hardcoded to avoid dependency to com.sap.mi.fwk plugin
	private static final String OCL_CONSTRAINT_CHECKER_ID = "com.sap.mi.fwk.MoinConstraintChecker"; //$NON-NLS-1$

	private static final Logger stracer = Logger.getLogger(MoinProject.class.getName());
	private static final String VENDOR_DEFAULT = VENDOR_SAP;
	private static final String NAME_LOCAL_DEV_CONFIG = "LocalDevelopment"; //$NON-NLS-1$
	private static final String NAME_LOCAL_SC = "MyComponents"; //$NON-NLS-1$
	private static final MoinFolderInfo[] NO_MOIN_FOLDERS = new MoinFolderInfo[0];

	private static final String PROP_RES_FOLDERS = "moin_resource_folders"; //$NON-NLS-1$
	private static final String PROP_FOLDERS = "moin_folders"; //$NON-NLS-1$
	private static final String PROP_FOLDER = "folder"; //$NON-NLS-1$
	private static final String PROP_FOLDER_PATH = "path"; //$NON-NLS-1$
	private static final String PROP_FOLDER_EXCLUDE_BUILD = "exclude_in_build"; //$NON-NLS-1$
	private static final String PROP_FOLDER_EXCLUDE_IDE = "exclude_in_ide"; //$NON-NLS-1$

	// public part constants
	private static final String PP_NAME_DEFAULT_ASSEMBLY = "def_assmbl"; //$NON-NLS-1$
	private static final String PP_NAME_DEFAULT_COMPILATION = "def_cmp"; //$NON-NLS-1$

	/**
	 * Creates a DC of the given DC type as well as a corresponding project in
	 * the Eclipse workspace. The DC is created locally, i.e. in the local SC.
	 *
	 * @param name
	 *            the DC name. Note that the returned <em>project</em> may have
	 *            a different name than the DC.
	 * @param vendor
	 *            the vendor name, e.g. <code>acmee.org</code>, or
	 *            <code>null</code> for the default {@link #VENDOR_SAP
	 *            <code>sap.com</code> vendor}
	 * @param dcType
	 *            the type of DC to be created. Must not be <code>null</code>.
	 * @return the Eclipse project for the created DC
	 * @throws CoreException
	 *             if DC or project creation fails
	 *
	 * @see #createDc(String, String, IComponentType, ISoftwareComponent,
	 *      MoinDcOptions, IProgressMonitor)
	 * @see #deleteLocalDc(String, IProgressMonitor)
	 * @see #getDcType(String, String, String)
	 */
	public static IProject createLocalDc(String name, String vendor, IComponentType dcType, IProgressMonitor monitor)
			throws CoreException {

		IDevelopmentComponent dc = createLocalDc(name, vendor, dcType, null, monitor);
		IProject project = DiiResourceService.getProject(dc);
		return project;
	}

	/**
	 * Creates a DC of the given DC type as well as a corresponding project in
	 * the Eclipse workspace. The DC is created locally, i.e. in the local SC.
	 *
	 * @param name
	 *            the DC name. Note that the returned <em>project</em> may have
	 *            a different name than the DC.
	 * @param vendor
	 *            the vendor name, e.g. <code>acmee.org</code>, or
	 *            <code>null</code> for the default {@link #VENDOR_SAP
	 *            <code>sap.com</code> vendor}
	 * @param dcType
	 *            the type of DC to be created. Must not be <code>null</code>.
	 * @param options
	 *            additional options or <code>null</code>
	 * @return the created DC
	 * @throws CoreException
	 *             if DC or project creation fails
	 *
	 * @see #createDc(String, String, IComponentType, ISoftwareComponent,
	 *      MoinDcOptions, IProgressMonitor)
	 * @see #deleteLocalDc(String, IProgressMonitor)
	 * @see #getDcType(String, String, String)
	 */
	public static IDevelopmentComponent createLocalDc(String name, String vendor, IComponentType dcType,
			MoinDcOptions options, IProgressMonitor monitor) throws CoreException {
		return createDc(name, vendor, dcType, null, options, false, null, monitor);
	}

	/**
	 * <b>EXPERIMENTAL</b> Creates a DC of the given DC type as well as a
	 * corresponding project in the Eclipse workspace. If no software component
	 * is given, the DC is created locally, i.e. in the local SC.
	 *
	 * @param name
	 *            the DC name. Note that the returned <em>project</em> may have
	 *            a different name than the DC.
	 * @param vendor
	 *            the vendor name, e.g. <code>acmee.org</code>, or
	 *            <code>null</code> for the default {@link #VENDOR_SAP
	 *            <code>sap.com</code> vendor}
	 * @param dcType
	 *            the type of DC to be created. Must not be <code>null</code>.
	 * @param sc
	 *            the software component the new DC should be contained in, or
	 *            <code>null</code> for the local SC (resulting in a local DC)
	 * @param options
	 *            additional options or <code>null</code>
	 * @param addToSourceControl
	 *            supply <code>true</code> to add the created DC to source
	 *            control
	 * @param changelistProvider
	 *            a change list provider can be specified to suppress the
	 *            Activity Selection dialog.
	 *
	 * @return the created DC
	 * @throws CoreException
	 *             if DC or project creation fails
	 *
	 * @see #createLocalDc(String, String, IComponentType, IProgressMonitor)
	 * @see #deleteLocalDc(String, IProgressMonitor)
	 * @see #getDcType(String, String, String)
	 */
	@Deprecated
	public static IDevelopmentComponent createDc(String name, String vendor, IComponentType dcType,
			ISoftwareComponent sc, MoinDcOptions options, boolean addToSourceControl,
			IChangelistProvider changelistProvider, IProgressMonitor monitor) throws CoreException {

		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException("dcName must not be null nor empty: " + name); //$NON-NLS-1$
		}
		if (vendor == null) {
			vendor = VENDOR_DEFAULT;
		}
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}

		IMoinDcType dcTypeDelegate = getDcTypeDelegate(dcType);
		options = getOptions(dcTypeDelegate, options, true);

		if (sc == null) {
			sc = getLocalSC();
		}
		if (sc == null) {
			String msg = "No SC available, not even locally. dcName: " + name; //$NON-NLS-1$
			IStatus status = DcFwkPlugin.createStatus(IStatus.ERROR, msg, null);
			throw new CoreException(status);
		}
		if (!sc.isModificationAllowed()) {
			String msg = "SC is not modifiable: " + sc.getName(); //$NON-NLS-1$
			IStatus status = DcFwkPlugin.createStatus(IStatus.ERROR, msg, null);
			throw new CoreException(status);
		}

		try {
			IDevelopmentConfiguration localDevConf = sc.getContainingDevelopmentConfiguration();
			IDevelopmentComponent newDc = getLocalDC(sc, name, vendor);
			if (newDc == null) {
				INewDcRequestForm form = createForm(name, vendor, dcType, sc, "BC", "en", addToSourceControl, //$NON-NLS-1$ //$NON-NLS-2$
						changelistProvider);

				IDevelopmentComponent[] dcs = DiiModelEditService.createDevelopmentComponents(
						new INewDcRequestForm[] { form }, monitor);
				if (dcs.length == 0) {
					String msg = "DC could not be created. Name: " + name + ", local dev conf: " + localDevConf //$NON-NLS-1$ //$NON-NLS-2$
							+ ", form: " + form + ", dcType: " + dcType; //$NON-NLS-1$ //$NON-NLS-2$
					IStatus status = DcFwkPlugin.createStatus(IStatus.ERROR, msg, null);
					throw new CoreException(status);
				}
				newDc = dcs[0];

				IDcMetadataState localState = newDc.getLocalState();
				if (localState == null) {
					String msg = "IDcMetadataState not created. dcName: " + name + ", local dev conf: " + localDevConf //$NON-NLS-1$ //$NON-NLS-2$
							+ ", newDc: " + newDc + ", form: " + form + ", dcType: " + dcType; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					IStatus status = DcFwkPlugin.createStatus(IStatus.ERROR, msg, null);
					throw new CoreException(status);
				}

				// delegate may be null in case of non-moin project
				if (dcTypeDelegate != null) {
					configureDc(newDc, dcTypeDelegate, options, monitor, changelistProvider);
				}
			}

			if (options.createProject(newDc)) {
				// check whether project exists
				IProject project = DiiResourceService.getProject(newDc);
				if (project == null) {
					// create the project
					String[] additionalNatures = null;
					String[] additionalBuilders = null;
					MoinFolderInfo[] folderInfos = null;
					// delegate may be null in case of non-moin project
					if (dcTypeDelegate != null) {
						additionalNatures = options.getNatures();
						additionalBuilders = options.getBuilders();
						folderInfos = options.getFolders();
					}
					final IWorkspaceRunnable createProjectRunnable = new CreateProjectRunnable(newDc, dcTypeDelegate,
							additionalNatures, additionalBuilders, folderInfos, options);
					ResourcesPlugin.getWorkspace().run(createProjectRunnable, monitor);
					project = DiiResourceService.getProject(newDc);
				}
			}

			return newDc;
		} catch (OperationCanceledException e) { // $JL-EXC$
			return null;
		} catch (DiiLibraryOperationCancelledException e) { // $JL-EXC$
			return null;
		}
	}

	/**
	 * Returns the local DC with the given name and vendor
	 *
	 * @param dcName
	 *            the DC name. Note that this differs from the DC project name.
	 * @param vendor
	 *            the DC's vendor or <code>null</code> for the default vendor
	 * @return the DC or <code>null</code> if no such component exists
	 * @throws CoreException
	 *             in case of misconfigured landscape
	 */
	public static IDevelopmentComponent getLocalDC(String dcName, String vendor) throws CoreException {
		ISoftwareComponent localSc = getLocalSC();
		if (localSc == null) {
			return null;
		}

		if (vendor == null) {
			vendor = VENDOR_DEFAULT;
		}
		IDevelopmentComponent dc = getLocalDC(localSc, dcName, vendor);
		return dc;
	}

	/**
	 * Deletes the given DC including its Eclipse project (if available).
	 *
	 * @param project
	 *            the DC project to be deleted
	 * @throws CoreException
	 *             if DC or project deletion fails
	 */
	public static void deleteLocalDc(IProject project, IProgressMonitor monitor) throws CoreException {

		if (project == null) {
			throw new IllegalArgumentException("project must not be null"); //$NON-NLS-1$
		}

		// Note: Dii is able to asynchronously remove a DC based on a project
		// deletion, but since we want this to happen immediately,
		// remove the DC first.
		IDevelopmentComponent dc = DiiResourceService.getDevelopmentComponent(project);
		if (dc != null) {
			deleteLocalDc(dc, true, monitor);
		} else {
			// if a project is there without a DC delete it
			deleteProject(project, true, monitor);
		}
	}

	/**
	 * Deletes the given DC and optionally its project
	 *
	 * @param deleteProject
	 *            if <code>true</code>, the corresponding project is deleted as
	 *            well
	 * @param project
	 *            the DC project to be deleted
	 *
	 * @throws CoreException
	 *             if DC or project deletion fails
	 */
	public static void deleteLocalDc(IDevelopmentComponent dc, boolean deleteProject, IProgressMonitor monitor)
			throws CoreException {
		if (dc == null) {
			throw new IllegalArgumentException("DC must not be null"); //$NON-NLS-1$
		}

		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}

		IProject project = DiiResourceService.getProject(dc);
		// Note: Dii is able to asynchronously remove a DC based on a project
		// deletion, but since we want this to happen immediately,
		// remove the DC first.
		JdiJob deleteDcJob = DiiCommandFactory.forDevelopmentComponent().create_DeleteDcsJob(
				new IDevelopmentComponent[] { dc });

		IStatus status = JobUtil.syncExec(deleteDcJob, monitor);
		if (status.getSeverity() == IStatus.ERROR) {
			throw new CoreException(status);
		} else if (!status.isOK()) {
			sTracer.warning(status.getMessage(), status.getException());
		}

		if (deleteProject && project != null) {
			// As we want this menthod to be return sychronously after deletion,
			// set immediate flag.
			deleteProject(project, true, monitor);
		}

		// TODO [Projects] enable refresh for deleted projects
		// final IMoinDcType dcType = getDcTypeDelegate(dc.getComponentType());
		// notifyUpdateListeners(dc, getOptions(dcType, null, false), project);
	}

	/**
	 * Returns a DC type instance for the given keys. Note: does not check
	 * whether the returned type refers to a valid, i.e. registered DC type
	 * instance.
	 *
	 * @param id
	 *            the DC type id. Must not be <code>null</code>.
	 * @param typeVendor
	 *            the DC type vendor. If <code>null</code>, defaults to
	 *            {@link #VENDOR_SAP the <code>sap.com</code> vendor}.
	 * @param subType
	 *            the DC sub type. May be <code>null</code>.
	 * @return the DC type
	 */
	public static IComponentType getDcType(String id, String typeVendor, String subType) {
		if (id == null) {
			throw new IllegalArgumentException("DC type id must not be null"); //$NON-NLS-1$
		}
		if (typeVendor == null) {
			typeVendor = MoinProject.VENDOR_SAP;
		}

		IComponentType type = DiiDcTypeService.createDcType(id, subType, typeVendor);
		return type;
	}

	/**
	 * @deprecated use <code>getMoinResourceFolders</code> in
	 *             <code>com.sap.mi.fwk.ModelManager</code>
	 */
	@Deprecated
	// TODO [Facility Separation] move to facility dispatcher
	// Attention: currently called via reflection from mi.fwk.ModelManager
	public static IPath[] getMoinResourceFolders(IProject project) {
		MoinFolderInfo[] folders = getMoinFolders(project);
		List<IPath> result = new ArrayList<IPath>(folders.length);
		for (MoinFolderInfo info : folders) {
			if (info.isResourceFolder()) {
				result.add(info.getPath());
			}
		}
		return result.toArray(new IPath[result.size()]);
	}

	/**
	 * Creates standard public parts according to the definitions returned by
	 * the given options. If standard options are supplied, one public part of
	 * purpose {@link Purpose#COMPILATION_LITERAL compilation} is created, which
	 * contains one {@link IEntity entity} for each
	 * {@link MoinFolderInfo#isResourceFolder() Moin resource folder}.
	 *
	 * @param options
	 *            the settings specifying which public parts to create
	 * @param dc
	 *            the DC to create the public parts for
	 * @param entityType
	 *            the {@link ICommonEntity#getEntityType() type of entities} to
	 *            create. <code>null</code> defaults to the generic
	 *            <code>Model Folder Tree</code> type.
	 * @return the created public parts
	 * @throws CoreException
	 *             if creation fails
	 */
	public static IMePublicPart[] getPublicPartsForModelFolderTree(MoinDcOptions options, IDevelopmentComponent dc,
			String entityType, IChangelistProvider changelistProvider) throws CoreException {
		Collection<MoinFolderInfo> folders = condenseFolders(options.getFolders());
		if (entityType == null) {
			entityType = ModelFolderTreeEntityService.TYPE_MODEL_FOLDER_TREE;
		}
		IDcMetadataState state = dc.getLocalState();
		List<IMePublicPart> pps = new ArrayList<IMePublicPart>(2);
		if (options.createPublicPart(Purpose.COMPILATION_LITERAL)) {
			pps.add(createPP(PP_NAME_DEFAULT_COMPILATION, Purpose.COMPILATION_LITERAL, folders, entityType, state,
					changelistProvider));
		}
		if (options.createPublicPart(Purpose.ASSEMBLY_LITERAL)) {
			pps.add(createPP(PP_NAME_DEFAULT_ASSEMBLY, Purpose.ASSEMBLY_LITERAL, folders, entityType, state,
					changelistProvider));
		}
		// Intentionally do not commit, so that method also can be used
		// to create temporary pps in order to compare them with existing ones
		// in repairDc().
		return pps.toArray(new IMePublicPart[pps.size()]);
	}

	/**
	 * Creates a public part entity with of given type and the given path as its
	 * name
	 *
	 * @param path
	 *            the path to assign to the entity name
	 * @param entityType
	 *            the entity type
	 * @return the entity
	 */
	public static IMeEntity createEntityForPath(IPath path, String entityType) {
		ModelEditFactory factory = ModelEditPackage.eINSTANCE.getModelEditFactory();
		IMeEntity entity = factory.createIMeEntity();
		entity.setEntityType(entityType);
		entity.setName(path.toString());
		return entity;
	}

	/**
	 * Creates a dependency from the given DC project to the given public part
	 *
	 * @param project
	 *            the project to create the dependency from. Must be a DC
	 *            project.
	 * @param dcName
	 *            the name of the DC to create the dependency to
	 * @param dcVendor
	 *            the vendor of the DC to create the dependency to. Defaults to
	 *            <code>sap.com</code> if <code>null</code>.
	 * @param ppName
	 *            the name of the public part to create the dependency to
	 * @param buildtime
	 *            specifies whether it is a public part usage at buildtime
	 * @param runtime
	 *            specifies whether it is a public part usage at runtime
	 * @param deploytime
	 *            specifies whether it is a public part usage at deploytime
	 * @param changeListProvider
	 *            a provider for an activity or <code>null</code>
	 * @throws CoreException
	 *             in case of failures
	 */
	@SuppressWarnings("unchecked")
	public static void addPublicPartDependency(IProject project, String dcName, String dcVendor, String ppName,
			boolean buildtime, boolean runtime, boolean deploytime, IChangelistProvider changeListProvider)
			throws CoreException {
		if (project == null) {
			throw new IllegalArgumentException("Project must not be null"); //$NON-NLS-1$
		}
		IDevelopmentComponent dc = DiiResourceService.getDevelopmentComponent(project);
		if (dc == null) {
			throw new IllegalArgumentException("No DC available for project " + project.getName()); //$NON-NLS-1$
		}
		IDcMetadataState dcState = dc.getLocalState();
		if (dcState == null) {
			Exception e = new Exception("Could not get IDcMetadataState for DC " + dc.getName()); //$NON-NLS-1$
			IStatus status = DcFwkPlugin.createStatus(IStatus.ERROR, e.getMessage(), e);
			throw new CoreException(status);
		}

		IMeDcMetadataState editableState = DiiModelEditService.getEditableState(dcState, changeListProvider);

		IMePublicPartRef ref = ModelEditFactory.eINSTANCE.createIMePublicPartRef();
		ref.setPpName(ppName);
		ref.setName(dcName);
		ref.setVendor(dcVendor);

		IMeDcDependency dependency = ModelEditFactory.eINSTANCE.createIMeDcDependency();
		dependency.setDcOrPpRef(ref);
		dependency.setAtBuildTime(buildtime);
		dependency.setAtDeployTime(deploytime);
		dependency.setAtRuntime(runtime);

		editableState.getDependencies().add(dependency);

		DiiModelEditService.commitChangesAndRefresh(editableState);
	}

	/**
	 * Aligns the structure of the given DC with the definitions returned by the
	 * {@link IMoinDcType DC type implementation} and the given
	 * {@link MoinDcOptions options}. The current implementation compares
	 * existing public parts with their
	 * {@link IMoinDcType#getPublicParts(IDevelopmentComponent) definition}. In
	 * case of conflicts, i.e. public parts with the same name but different
	 * structure, existing ones are overridden. However, if the given options
	 * declare the public parts not to be
	 * {@link MoinDcOptions#createPublicPart(Purpose) managed automatically},
	 * they remain untouched (usually due to a user decision on DC creation).
	 *
	 * @param dc
	 *            the DC to repair
	 * @param options
	 *            additional options or <code>null</code>
	 * @param monitor
	 *            a progress monitor or <code>null</code>
	 * @throws CoreException
	 *             if the alignment fails
	 */
	@SuppressWarnings("unchecked")
	public static void repairDc(IDevelopmentComponent dc, MoinDcOptions options, IProgressMonitor monitor)
			throws CoreException {
		IMoinDcType moinDcType = getDcTypeDelegate(dc.getComponentType());
		options = getOptions(moinDcType, options, true);

		try {
			IDcMetadataState state = dc.getLocalState();
			IMePublicPart[] pps = options.getPublicParts(dc, null);
			for (IMePublicPart pp : pps) {
				String ppName = pp.getName();
				Purpose purpose = Purpose.get(pp.getPurpose().getName());
				// only repair if the user requested to get the PPs managed
				if (!options.createPublicPart(purpose)) {
					continue;
				}

				IMePublicPart newPp = getEditablePp(ppName, purpose, state, null);
				newPp.setCaption(pp.getCaption());
				newPp.setDescription(pp.getDescription());
				newPp.getEntities().addAll(pp.getEntities());
				IStatus result = DiiModelEditService.commitChanges(newPp);
				if (!result.isOK()) {
					throw new CoreException(result);
				}
			}
		} catch (OperationCanceledException e) { // $JL-EXC$
			if (monitor != null) {
				monitor.setCanceled(true);
			}
		} catch (DiiLibraryOperationCancelledException e) { // $JL-EXC$
			if (monitor != null) {
				monitor.setCanceled(true);
			}
		}
	}

	/**
	 * The purpose of this method is to enhance a DC of a non
	 * {@link IMoinDcType Moin-based} DC type. The method will set the required
	 * natures, add MOIN content source folders and will alter the DC metadata
	 * for the given <code>project</code> in order to enable it for MOIN
	 * content. <br>
	 * Since this method will change the DC metadata it cannot be used while
	 * importing a DC into the Eclipse workspace - use
	 * {@link #enableProjectForMoin(IProject, MoinDcOptions, IProgressMonitor)}
	 * instead.
	 * <p>
	 * Preconditions:
	 * <ul>
	 * <li>The method must be called from a <b>NON-UI thread</b></li>
	 * <li>The caller must either not hold any resource lock or the resource
	 * lock must contain the given <code>IWorkspaceRoot</code>.</li>
	 * <li>The project has to be a DC project available in the Eclipse workspace
	 * </li>
	 * </ul>
	 *
	 * @param project
	 *            the project to enhance. Must be a DC project.
	 * @param options
	 *            additional options or <code>null</code>
	 * @param monitor
	 *            a progress monitor or <code>null</code>
	 * @throws CoreException
	 *             in case of a failure
	 *
	 * @see #disableMoin(IProject, MoinDcOptions, IProgressMonitor)
	 */
	public static void enableForMoin(final IProject project, final MoinDcOptions options, IProgressMonitor monitor)
			throws CoreException {
		final IDevelopmentComponent dc = DiiResourceService.getDevelopmentComponent(project);
		final IMoinDcType dcType = getDcTypeDelegate(dc.getComponentType());
		final MoinDcOptions dcOptions = getOptions(dcType, options, true);

		// Start the enable runnable with changing the DC metadata
		final EnableForMoinRunnable op = new EnableForMoinRunnable(dc, project, dcOptions);
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		// use the workspace as lock since Moin Nwdi facility currently expects
		// it to scan its data area
		ws.run(op, monitor);

		// save DC model - must be done outside workspace runnable as otherwise
		// Dii doesn't find its resources
		IStatus result = DiiModelEditService.commitChangesAndRefresh(op.getEditableState());
		if (!result.isOK()) {
			throw new CoreException(result);
		}

		// Call init hook protected by the workspace lock (implementations may
		// create connections, which require the lock). Cannot do this in
		// runnable above since DC metadata commit must happen before.
		ws.run(new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				initDc(dc, project, dcType, dcOptions, false, monitor);
			}
		}, monitor);

		// refresh only required in case new model folders have been added
		MoinFolderInfo[] folders = dcOptions.getFolders();
		if (dcOptions.refreshMoin(dc) && folders != null && folders.length > 0) {
			InvocationHelper.callModelManager_refreshFromFileSystem(project);
		}
	}

	/**
	 * The purpose of this method is to apply the required project settings for
	 * the given <code>project</code> while importing the corresponding DC into
	 * the Eclipse workspace. The method will set the required natures and add
	 * the MOIN content source folders to the given <code>project</code>, but it
	 * will not alter the DC metadata. Thus, the DC itself must have already
	 * been enabled for MOIN, e.g. have the MOIN relevant properties set on DC
	 * metadata level.<br>
	 * Use {@link #enableForMoin(IProject, MoinDcOptions, IProgressMonitor)} in
	 * case you want to initialize a non {@link IMoinDcType Moin-based} DC type.
	 * <p>
	 * Preconditions:
	 * <ul>
	 * <li>The method must be called from a <b>NON-UI thread</b></li>
	 * <li>The caller must either not hold any resource lock or the resource
	 * lock must contain the given <code>IWorkspaceRoot</code>.</li>
	 * <li>The project has to be a DC project available in the Eclipse workspace
	 * </li>
	 * </ul>
	 *
	 * @param project
	 *            the project to enhance. Must be a DC project.
	 * @param options
	 *            additional options or <code>null</code>
	 * @param monitor
	 *            a progress monitor or <code>null</code>
	 * @throws CoreException
	 *             in case of a failure
	 *
	 * @see #enableForMoin(IProject, MoinDcOptions, IProgressMonitor)
	 */
	public static void enableProjectForMoin(final IProject project, final MoinDcOptions options,
			IProgressMonitor monitor) throws CoreException {
		final IDevelopmentComponent dc = DiiResourceService.getDevelopmentComponent(project);
		if (!isMoinDc(dc)) {
			IStatus status = DcFwkPlugin.createStatus(IStatus.ERROR,
					"DC must be a Moin enabled DC: " + dc.getName(), null); //$NON-NLS-1$
			throw new CoreException(status);
		}
		final IMoinDcType dcType = getDcTypeDelegate(dc.getComponentType());
		final MoinDcOptions dcOptions = getOptions(dcType, options, true);

		// Start the enable runnable without changing any DC metadata (false
		// flag)
		final EnableForMoinRunnable op = new EnableForMoinRunnable(dc, project, dcOptions, false);
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		// use the workspace as lock since Moin Nwdi facility currently expects
		// it to scan its data area
		ws.run(op, monitor);

		// Call init hook protected by the workspace lock (implementations may
		// create connections, which require the lock). Cannot do this in
		// runnable above since DC metadata commit must happen before (in the
		// other use case in method enableForMoin).
		ws.run(new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				initDc(dc, project, dcType, dcOptions, false, monitor);
			}
		}, monitor);

		// refresh only required in case new model folders have been added
		MoinFolderInfo[] folders = dcOptions.getFolders();
		if (dcOptions.refreshMoin(dc) && folders != null && folders.length > 0) {
			IStatus status = InvocationHelper.callModelManager_refreshFromFileSystem(project);
			if (!status.isOK()) {
				throw new CoreException(status);
			}
		}
	}

	/**
	 * Removes all project and DC metadata that marks the given project as Moin
	 * project.
	 * <em>Afterwards Moin will no longer be able to deal with data stored
	 * in the project.</em>
	 *
	 * @param project
	 *            the project to deconfigure. Must be a DC project.
	 * @param options
	 *            additional options or <code>null</code>
	 * @param monitor
	 *            a progress monitor or <code>null</code>
	 * @throws CoreException
	 *             in case of a failure
	 *
	 * @see #enableForMoin(IProject, MoinDcOptions, IProgressMonitor)
	 */
	public static void disableMoin(IProject project, MoinDcOptions options, IProgressMonitor monitor)
			throws CoreException {
		final DisableMoinRunnable op = new DisableMoinRunnable(project, options);
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		// use the workspace as lock since Moin Nwdi facility currently expects
		// it to scan its data area
		ws.run(op, ws.getRoot(), IWorkspace.AVOID_UPDATE, monitor);

		// save DC model - must be done outside workspace runnable as otherwise
		// Dii doesn't find its resources
		IStatus result = DiiModelEditService.commitChangesAndRefresh(op.getEditableState());
		if (!result.isOK()) {
			throw new CoreException(result);
		}
	}

	private static IDcProject getDcProject(IProject project) {
		IDcProject dcProject = DiiResourceService.getDcProject(project);
		if (dcProject == null) {
			throw new IllegalArgumentException("Project is not a DC: " + project.getName()); //$NON-NLS-1$
		}
		return dcProject;
	}

	static IMoinDcType getDcTypeDelegate(IComponentType dcType) throws CoreException {
		if (dcType == null) {
			throw new IllegalArgumentException("DC type must not be null"); //$NON-NLS-1$
		}

		IBasicDevelopmentComponentTypeDelegate delegate = DiiDcTypeService.getDCTypeDelegate(dcType);
		if (delegate instanceof IMoinDcType) {
			return (IMoinDcType) delegate;
		}
		return null;
	}

	/**
	 * <em>For internal use only.</em> Returns an options object guaranteed not
	 * to be null. If <code>explicitOptions</code> is not null, it is returned.
	 * If <code>dcType</code> returns an options, this one is returned.
	 * Otherwise a new options object is created and returned.
	 *
	 * @param dcType
	 *            the dcType with a potential
	 *            {@link IMoinDcType#getOptions(boolean) options}
	 * @param explicitOptions
	 *            explicitly set options or <code>null</code>
	 * @param reset
	 *            if <code>true</code>, all state of the returned options must
	 *            be cleared (or a new options instance be created)
	 * @return options, never null
	 */
	public static MoinDcOptions getOptions(IMoinDcType dcType, MoinDcOptions explicitOptions, boolean reset) {
		// for explicit or new options, we inject the given dc type (or null)
		// so that the option's defaults can delegate to this type
		if (explicitOptions != null) {
			return explicitOptions.setDcType(dcType);
		} else if (dcType != null) {
			return dcType.getOptions(reset);
		}
		return new MoinDcOptions().setDcType(dcType);
	}

	private static void deleteProject(final IProject project, boolean immediate, IProgressMonitor monitor)
			throws CoreException {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}

		final IWorkspaceRunnable deleteProjectRunnable = new DeleteProjectRunnable(project);
		final IWorkspace workspace = project.getWorkspace();
		ISchedulingRule deleteRule = workspace.getRuleFactory().deleteRule(project);
		if (immediate) {
			if (monitor.isCanceled()) {
				return;
			}
			workspace.run(deleteProjectRunnable, deleteRule, IWorkspace.AVOID_UPDATE, monitor);
		} else {
			// use a non-workspace job with a runnable inside so we can
			// avoid periodic updates
			Job deleteJob = new Job(DcFwkMessages.MoinProject_deletingProject) {
				@Override
				public IStatus run(IProgressMonitor monitor) {
					if (monitor.isCanceled()) {
						return Status.CANCEL_STATUS;
					}
					try {
						// outer job already has rule set
						workspace.run(deleteProjectRunnable, null, IWorkspace.AVOID_UPDATE, monitor);
						return Status.OK_STATUS;
					} catch (CoreException e) {
						return e.getStatus();
					}
				}
			};
			deleteJob.setRule(deleteRule);
			deleteJob.setUser(true);
			deleteJob.schedule();
		}
	}

	private static INewDcRequestForm createForm(String name, String vendor, IComponentType type, ISoftwareComponent sc,
			String terminologyDomain, String language, boolean addToSourceControl,
			IChangelistProvider changelistProvider) {

		INewDcRequestForm form = DiiModelEditService.createReqestForm();

		form.setDcName(name);
		form.setVendor(vendor);
		form.setComponentType(type);
		form.setSoftwareComponent(sc); // or setParentDc()
		form.setTerminologyDomain(terminologyDomain);
		form.setLanguage(language);
		form.setAddToSourceControl(addToSourceControl);
		form.setChangelistProvider(changelistProvider);

		return form;
	}

	/**
	 * Returns first found editable Software Component
	 */
	@SuppressWarnings("unchecked")
	private static ISoftwareComponent getLocalSC() throws CoreException {
		IDevelopmentConfiguration config = getLocalConfiguration();
		List scList = config.getSoftwareComponents();
		ISoftwareComponent[] scs;
		if (scList.isEmpty()) {
			scs = DiiModelService.getSoftwareComponents(config, DiiModelService.FORCED_REFRESH);
		} else {
			scs = (ISoftwareComponent[]) scList.toArray(new ISoftwareComponent[scList.size()]);
		}
		for (ISoftwareComponent component : scs) {
			if (NAME_LOCAL_SC.equals(component.getName())) {
				return component;
			}
		}
		return null;
	}

	/**
	 * Returns the instance for first found local configuration
	 */
	@SuppressWarnings("unchecked")
	private static IDevelopmentConfiguration getLocalConfiguration() throws CoreException {
		IComponentModel model = DiiModelService.getComponentModel();
		List<IDevelopmentConfiguration> configs = model.getDevelopmentConfigurations();
		for (IDevelopmentConfiguration configuration : configs) {
			if (NAME_LOCAL_DEV_CONFIG.equals(configuration.getName())) {
				return configuration;
			}
		}

		String msg = "Could not find the configuration '" + NAME_LOCAL_DEV_CONFIG + "' for local DCs. " //$NON-NLS-1$ //$NON-NLS-2$
				+ "Check if you have installed the Archive Pool (AP) Feature."; //$NON-NLS-1$
		IStatus status = DcFwkPlugin.createStatus(IStatus.ERROR, msg, null);
		throw new CoreException(status);
	}

	@SuppressWarnings("unchecked")
	private static IDevelopmentComponent getLocalDC(ISoftwareComponent sc, String dcName, String vendor) {
		IDevelopmentComponent[] dcs;
		if (!RefreshState.REFRESHED_LITERAL.equals(sc.getRefreshState())) {
			dcs = DiiModelService.getDevelopmentComponents(sc, DiiModelService.FORCED_REFRESH);
		} else {
			dcs = (IDevelopmentComponent[]) sc.getDevelopmentComponents().toArray(new IDevelopmentComponent[0]);
		}
		for (IDevelopmentComponent dc : dcs) {
			if (dcName.equals(dc.getName()) && vendor.equals(dc.getVendor())) {
				return dc;
			}
		}
		return null;
	}

	/**
	 * For internal use only
	 */
	public static void configureDc(IDevelopmentComponent dc, IMoinDcType dcType, MoinDcOptions options,
			IProgressMonitor monitor, IChangelistProvider changelistProvider) throws CoreException {
		options = getOptions(dcType, options, false);

		IMeDcMetadataState editableState = configureDc(dc, options, monitor, changelistProvider);

		try {
			dcType.configure(dc, editableState);
		} catch (CoreException e) {
			DcFwkPlugin.logError(e, sTracer);
		} catch (RuntimeException e) { // $JL-EXC$
			DcFwkPlugin.logError("Error in custom DC type " + dcType, e, sTracer); //$NON-NLS-1$
		}

		// Save DC model
		IStatus result = DiiModelEditService.commitChangesAndRefresh(editableState);
		if (!result.isOK()) {
			throw new CoreException(result);
		}

		// sync the used DCs right here, since a Dc type impl. could need
		// it on init point
		DiiNewDcService.syncMissingUsedDcs(dc, monitor);
	}

	/**
	 * For internal use only
	 */
	public static void initDc(IDevelopmentComponent dc, IProject project, IMoinDcType dcType, MoinDcOptions options,
			boolean dcCreated, IProgressMonitor monitor) throws CoreException {
		// Delegate may be null in case its not IMoinDcType-based
		if (dcType != null) {
			try {
				dcType.init(dc, project, monitor);
			} catch (CoreException e) {
				DcFwkPlugin.logError(e, sTracer);
			} catch (RuntimeException e) { // $JL-EXC$
				DcFwkPlugin.logError("Error in custom DC type " + dcType, e, sTracer); //$NON-NLS-1$
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static IMeDcMetadataState configureDc(IDevelopmentComponent dc, MoinDcOptions options,
			IProgressMonitor monitor, IChangelistProvider changelistProvider) throws CoreException {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		monitor.beginTask(DcFwkMessages.MoinProject_configuring, 10);

		IDcMetadataState localState = dc.getLocalState();
		if (localState == null) {
			Exception e = new Exception("Could not get IDcMetadataState for project " + dc.getName()); //$NON-NLS-1$
			IStatus status = DcFwkPlugin.createStatus(IStatus.ERROR, e.getMessage(), e);
			throw new CoreException(status);
		}

		IMeDcMetadataState editableState = DiiModelEditService.getEditableState(localState, changelistProvider);

		Collection<MoinFolderInfo> folders = Collections.emptyList();
		MoinFolderInfo[] rawFolders = options.getFolders();
		if (rawFolders != null && rawFolders.length > 0) {
			folders = condenseFolders(rawFolders);
			Collection<String> resourceRoots = new HashSet<String>(folders.size());
			Collection<String> packageRoots = new HashSet<String>(folders.size());
			for (MoinFolderInfo folder : folders) {
				if (folder.isResourceFolder()) {
					resourceRoots.add(folder.getPath().toString());
				} else if (folder.isPackageFolder()) {
					packageRoots.add(folder.getPath().toString());
				}
			}
			editableState.getRelativeResourceRoots().addAll(resourceRoots);
			editableState.getRelativePackageRoots().addAll(packageRoots);
		}

		// DC properties must be set before the next pp check since it
		// sets the property that the check expects.
		setDcProperties(editableState, folders, options);

		createPPs(dc, options, editableState, monitor, changelistProvider);

		return editableState;
	}

	private static IMeDcMetadataState deconfigureDc(IDevelopmentComponent dc, MoinDcOptions options,
			IProgressMonitor monitor) throws CoreException {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		monitor.beginTask(DcFwkMessages.MoinProject_deconfiguring, 10);

		IDcMetadataState localState = dc.getLocalState();
		if (localState == null) {
			Exception e = new Exception("Could not get IDcMetadataState for project " + dc.getName()); //$NON-NLS-1$
			IStatus status = DcFwkPlugin.createStatus(IStatus.ERROR, e.getMessage(), e);
			throw new CoreException(status);
		}

		IMeDcMetadataState editableState = DiiModelEditService.getEditableState(localState, null);
		removeDcProperties(editableState);

		// leave folder structure untouched for now

		return editableState;
	}

	/**
	 * Produces DC definition XML like
	 *
	 * <pre>
	 * &lt;properties&gt;
	 * 	&lt;moin xmlns=&quot;http://xml.sap.com/2007/05/MoinModel&quot;&gt;
	 * 		&lt;moin_folders&gt;
	 * 			&lt;folder path=&quot;myFolder&quot; exclude_in_build=&quot;true&quot;/&gt;
	 * 		&lt;/moin_folders&gt;
	 * 		&lt;moin_resource_folders&gt;
	 * 			&lt;folder path=&quot;src&quot;/&gt;
	 * 		&lt;/moin_resource_folders&gt;
	 * 	&lt;/moin&gt;
	 * &lt;/properties&gt;
	 * &lt;folders&gt;
	 * 	&lt;source-folder&gt;src&lt;/source-folder&gt;
	 * &lt;/folders&gt;
	 * &lt;attributes&gt;
	 * 	&lt;attribute&gt;
	 * 		&lt;attribute-type&gt;is_moin_dc&lt;/attribute-type&gt;
	 * 		&lt;attribute-vendor&gt;sap.com&lt;/attribute-vendor&gt;
	 * 		&lt;attribute-value&gt;true&lt;/attribute-value&gt;
	 * 	&lt;/attribute&gt;
	 * &lt;/attributes&gt;
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	private static void setDcProperties(IMeDcMetadataState editableState, Collection<MoinFolderInfo> folderInfos,
			MoinDcOptions options) {
		ModelEditFactory factory = ModelEditPackage.eINSTANCE.getModelEditFactory();

		IMeAttribute attMoinDc = null;
		List<IMeAttribute> atts = editableState.getAttributes();
		// find the moin attribute
		for (IMeAttribute att : atts) {
			if (ATT_IS_MOIN_DC.equals(att.getName()) && VENDOR_SAP.equals(att.getVendor())) {
				attMoinDc = att;
				break;
			}
		}
		if (attMoinDc == null) {
			attMoinDc = factory.createIMeAttribute();
			attMoinDc.setName(ATT_IS_MOIN_DC);
			attMoinDc.setVendor(VENDOR_SAP);
			atts.add(attMoinDc);
		}
		attMoinDc.setValue(Boolean.TRUE.toString());

		IMeCustomProperty propMoin = null;
		List<IMeCustomProperty> props = editableState.getCustomProperties();
		// find the moin property
		for (IMeCustomProperty prop : props) {
			if (PROP_MOIN.equals(prop.getName()) && PROP_MOIN_NAMESPACE.equals(prop.getNamespace())) {
				propMoin = prop;
				break;
			}
		}
		if (propMoin == null) {
			propMoin = factory.createIMeCustomProperty();
			propMoin.setName(PROP_MOIN);
			propMoin.setNamespace(PROP_MOIN_NAMESPACE);
			props.add(propMoin);
		}

		IMeCustomProperty propResFolders = null;
		IMeCustomProperty propFolders = null;
		List<IMeCustomProperty> moinChildren = propMoin.getChildren();
		// find the properties for resource and normal folders
		for (IMeCustomProperty folder : moinChildren) {
			String name = folder.getName();
			if (PROP_RES_FOLDERS.equals(name)) {
				propResFolders = folder;
			} else if (PROP_FOLDERS.equals(name)) {
				propFolders = folder;
			}
		}
		if (propResFolders == null) {
			propResFolders = factory.createIMeCustomProperty();
			propResFolders.setName(PROP_RES_FOLDERS);
			moinChildren.add(propResFolders);
		}
		if (propFolders == null) {
			propFolders = factory.createIMeCustomProperty();
			propFolders.setName(PROP_FOLDERS);
			moinChildren.add(propFolders);
		}

		List<IMeCustomProperty> resFolders = propResFolders.getChildren();
		// find the folder attributes and hash them by their path string
		Map<String, IMeCustomPropertyAttribute> resFolderPathAttrByPath = new HashMap<String, IMeCustomPropertyAttribute>(
				resFolders.size());
		for (IMeCustomProperty folder : resFolders) {
			List<IMeCustomPropertyAttribute> folderAtts = folder.getAttributes();
			for (IMeCustomPropertyAttribute att : folderAtts) {
				if (PROP_FOLDER_PATH.equals(att.getName())) {
					resFolderPathAttrByPath.put(att.getValue(), att);
					break;
				}
			}
		}
		List<IMeCustomProperty> folders = propFolders.getChildren();
		Map<String, IMeCustomPropertyAttribute> folderPathAttrByPath = new HashMap<String, IMeCustomPropertyAttribute>(
				folders.size());
		for (IMeCustomProperty folder : folders) {
			List<IMeCustomPropertyAttribute> folderAtts = folder.getAttributes();
			for (IMeCustomPropertyAttribute att : folderAtts) {
				if (PROP_FOLDER_PATH.equals(att.getName())) {
					folderPathAttrByPath.put(att.getValue(), att);
					break;
				}
			}
		}

		for (MoinFolderInfo info : folderInfos) {
			if (info.isRelevantForMoin()) {
				String path = info.getPath().toString();
				IMeCustomPropertyAttribute attPath;
				IMeCustomProperty propFolder;
				if (info.isResourceFolder()) {
					attPath = resFolderPathAttrByPath.get(path);
				} else {
					attPath = folderPathAttrByPath.get(path);
				}
				if (attPath == null) {
					attPath = factory.createIMeCustomPropertyAttribute();
					attPath.setName(PROP_FOLDER_PATH);
					propFolder = factory.createIMeCustomProperty();
					propFolder.setName(PROP_FOLDER);
					propFolder.getAttributes().add(attPath);
				} else {
					propFolder = attPath.getContainingProperty();
				}
				List<IMeCustomPropertyAttribute> folderAtts = propFolder.getAttributes();
				attPath.setValue(path);
				folderAtts.add(attPath);

				if (info.isExcludedInIde()) {
					IMeCustomPropertyAttribute attExcl = factory.createIMeCustomPropertyAttribute();
					attExcl.setName(PROP_FOLDER_EXCLUDE_IDE);
					attExcl.setValue(Boolean.TRUE.toString());
					folderAtts.add(attExcl);
				}
				if (info.isExcludedInBuild()) {
					IMeCustomPropertyAttribute attExcl = factory.createIMeCustomPropertyAttribute();
					attExcl.setName(PROP_FOLDER_EXCLUDE_BUILD);
					attExcl.setValue(Boolean.TRUE.toString());
					folderAtts.add(attExcl);
				}

				if (info.isResourceFolder()) {
					propResFolders.getChildren().add(propFolder);
				} else {
					propFolders.getChildren().add(propFolder);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static void removeDcProperties(IMeDcMetadataState editableState) {
		List<IMeAttribute> atts = editableState.getAttributes();
		IMeAttribute attToRemove = null;
		for (IMeAttribute att : atts) {
			if (ATT_IS_MOIN_DC.equals(att.getName())) {
				attToRemove = att;
				break;
			}
		}
		atts.remove(attToRemove);

		List<IMeCustomProperty> props = editableState.getCustomProperties();
		IMeCustomProperty propToRemove = null;
		for (IMeCustomProperty prop : props) {
			if (PROP_MOIN.equals(prop.getName()) && PROP_MOIN_NAMESPACE.equals(prop.getNamespace())) {
				propToRemove = prop;
				break;
			}
		}
		props.remove(propToRemove);
	}

	private static void createPPs(IDevelopmentComponent dc, MoinDcOptions options, IMeDcMetadataState state,
			IProgressMonitor monitor, IChangelistProvider changelistProvider) throws CoreException {
		IMePublicPart[] pps = options.getPublicParts(dc, changelistProvider);
		for (IMePublicPart pp : pps) {
			IStatus result = DiiModelEditService.commitChangesAndRefresh(pp);
			if (!result.isOK()) {
				throw new CoreException(result);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static IMePublicPart createPP(String name, Purpose purpose, Collection<MoinFolderInfo> folders,
			String entityType, IDcMetadataState state, IChangelistProvider changelistProvider) throws CoreException {
		IMePublicPart pp = getEditablePp(name, purpose, state, changelistProvider);

		pp.setCaption("Model Folder Tree for " + purpose.getName().toLowerCase()); //$NON-NLS-1$

		StringBuilder desc = new StringBuilder("Contains all model partitions in ["); //$NON-NLS-1$
		for (Iterator<MoinFolderInfo> iter = folders.iterator(); iter.hasNext();) {
			MoinFolderInfo folder = iter.next();
			if (!folder.isResourceFolder()) {
				continue;
			}
			IPath path = folder.getPath();
			IMeEntity entity = createEntityForPath(path, entityType);
			pp.getEntities().add(entity);

			desc.append(path);
			if (iter.hasNext()) {
				desc.append(", "); //$NON-NLS-1$
			}
		}
		desc.append("]"); //$NON-NLS-1$
		if (folders.size() > 0) {
			pp.setDescription(desc.toString());
		}

		return pp;
	}

	private static IMePublicPart getEditablePp(String name, Purpose purpose, IDcMetadataState state,
			IChangelistProvider changelistProvider) throws CoreException {
		// DiiModelEditService.newEditablePublicPart throws an exception if the
		// purpose of the found pp doesn't match the given one. Check this case
		// and delete this pp before creating it.
		IPublicPart publicPart = DiiModelEditService.getPublicPart(state, name);
		if (publicPart != null) {
			DiiModelEditService.assureWritability(publicPart, null);
			if (publicPart.getPurpose() != purpose) {
				DiiModelEditService.deletePublicPart(state, name, null);
			}
		}
		IMePublicPart pp = DiiModelEditService.newEditablePublicPart(state, name, purpose, changelistProvider, false);
		return pp;
	}

	/**
	 * For interal use only.
	 * <p/>
	 * Creates a Eclipse project with the given description. Note that this does
	 * not include creation of a corresponding DC, without which Moin will not
	 * be able to store data in the project.
	 *
	 * @param projectDescription
	 *            the project description
	 * @param monitor
	 *            a progress monitor or <code>null</code>
	 * @return the created project
	 * @throws CoreException
	 *             if project creation fails
	 */
	public static IProject createProject(IProjectDescription projectDescription, IMoinDcType dcType,
			IProgressMonitor monitor) throws CoreException {

		MoinDcOptions options = getOptions(dcType, null, true);
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectDescription.getName());
		if (!project.exists()) {
			project.create(projectDescription, monitor);
			if (!project.isOpen()) {
				project.open(monitor);
			}
			// Add natures and builders after project creation because Eclipse
			// only configures the natures (e.g. adding builders) on
			// setDescription() not on project.create()
			configureProject(project, options, monitor);
			createProjectFolders(project, options.getFolders(), monitor);
		} else if (!project.isOpen()) { // open closed project
			project.open(monitor);
			configureProject(project, options.getNatures(), options.getBuilders(), monitor);
		}

		return project;
	}

	/**
	 * For interal use only.
	 * <p/>
	 * Completes the given project with information from the given DC type.
	 * Called when a project is about to be created out of an existing DC.
	 */
	static void configureProject(IProject project, MoinDcOptions options, IProgressMonitor monitor)
			throws CoreException {
		configureProject(project, options.getNatures(), options.getBuilders(), monitor);
	}

	private static void configureProject(IProject project, String[] natures, String[] builders, IProgressMonitor monitor)
			throws CoreException {
		IProjectDescription desc = project.getDescription();

		addNatures(desc, natures, monitor);
		addBuilders(desc, builders, monitor);
		project.setDescription(desc, monitor);
	}

	private static void deconfigureProject(IProject project, MoinDcOptions options, IProgressMonitor monitor)
			throws CoreException {
		IProjectDescription desc = project.getDescription();

		removeNatures(desc, options.getNatures(), monitor);
		removeBuilders(desc, options.getBuilders(), monitor);
		project.setDescription(desc, monitor);
	}

	private static void createProjectFolders(IProject project, MoinFolderInfo[] folderInfos, IProgressMonitor monitor)
			throws CoreException {
		if (folderInfos == null) {
			folderInfos = new MoinFolderInfo[0];
		}
		// Do *not* condense the folder hierarchy here since this would remove
		// sub folders, which we need to create.
		for (MoinFolderInfo info : folderInfos) {
			IFolder folder = project.getFolder(info.getPath());
			if (!folder.getLocation().toFile().exists()) {
				if (folder.exists()) {
					// Folder exists in Eclipse filesystem, but not on hard disk
					// --> make Eclipse forget about folder
					// (Error was an error popup on create archive, repair, ...
					// stating that the resource <folderName> already existed.)
					folder.refreshLocal(IResource.DEPTH_INFINITE, monitor);
				} else {
					createFolderPath(folder, monitor);
				}
			} else if (!folder.exists()) {
				// Folder exists on hard disk but not in Eclipse filesystem
				// --> refresh Eclipse
				project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
			}
		}
	}

	private static void createFolderPath(IFolder folder, IProgressMonitor monitor) throws CoreException {
		IContainer parent = folder.getParent();
		// create parent folders if not existing (Eclipse cannot create whole
		// paths at once)
		if (parent instanceof IFolder && !parent.exists()) {
			createFolderPath((IFolder) parent, monitor);
		}

		folder.create(true, true, monitor);
	}

	private static void addNatures(IProjectDescription description, String[] additionalNatures, IProgressMonitor monitor)
			throws CoreException {
		String[] originalNatures = description.getNatureIds();

		if (additionalNatures == null) {
			additionalNatures = MoinDcOptions.NO_NATURES;
		}
		Set<String> natures = new LinkedHashSet<String>(originalNatures.length + additionalNatures.length + 1);
		natures.addAll(Arrays.asList(originalNatures));
		natures.add(ID_NATURE);
		natures.addAll(Arrays.asList(additionalNatures));

		String[] newNatures = natures.toArray(new String[natures.size()]);
		if (!Arrays.equals(originalNatures, newNatures)) {
			description.setNatureIds(newNatures);
		}
	}

	private static void removeNatures(IProjectDescription description, String[] additionalNatures,
			IProgressMonitor monitor) throws CoreException {
		if (additionalNatures == null) {
			additionalNatures = MoinDcOptions.NO_NATURES;
		}
		String[] originalNatures = description.getNatureIds();
		Set<String> natures = new LinkedHashSet<String>(Arrays.asList(originalNatures));
		natures.remove(ID_NATURE);
		natures.removeAll(Arrays.asList(additionalNatures));

		String[] newNatures = natures.toArray(new String[natures.size()]);
		if (!Arrays.equals(originalNatures, newNatures)) {
			description.setNatureIds(newNatures);
		}
	}

	private static void addBuilders(IProjectDescription description, String[] additionalBuilderIds,
			IProgressMonitor monitor) throws CoreException {
		ICommand[] builderCommands = description.getBuildSpec();
		Set<ICommand> builders = new LinkedHashSet<ICommand>(builderCommands.length);
		builders.addAll(Arrays.asList(builderCommands));

		ICommand command = description.newCommand();
		command.setBuilderName(OCL_CONSTRAINT_CHECKER_ID);

		// BuildCommand class overrides equals/hashcode although it's mutable:
		// need to do dummy call hashcode, otherwise builders won't be equal
		command.isConfigurable();
		builders.add(command);

		if (additionalBuilderIds != null) {
			for (String builderID : additionalBuilderIds) {
				command = description.newCommand();
				command.setBuilderName(builderID);

				// BuildCommand class overrides equals/hashcode although it's
				// mutable: need to do dummy call hashcode, otherwise builders
				// won't be equal
				command.isConfigurable();
				builders.add(command);
			}
		}
		description.setBuildSpec(builders.toArray(new ICommand[builders.size()]));
	}

	private static void removeBuilders(IProjectDescription description, String[] additionalBuilderIds,
			IProgressMonitor monitor) throws CoreException {
		ICommand[] builderCommands = description.getBuildSpec();
		Set<ICommand> builders = new LinkedHashSet<ICommand>(builderCommands.length);
		builders.addAll(Arrays.asList(builderCommands));

		ICommand command = description.newCommand();
		command.setBuilderName(OCL_CONSTRAINT_CHECKER_ID);

		// BuildCommand class overrides equals/hashcode although it's mutable:
		// need to do dummy call hashcode, otherwise builders won't be equal
		command.isConfigurable();
		builders.remove(command);

		if (additionalBuilderIds != null) {
			for (String builderID : additionalBuilderIds) {
				command = description.newCommand();
				command.setBuilderName(builderID);

				// BuildCommand class overrides equals/hashcode although it's
				// mutable: need to do dummy call hashcode, otherwise builders
				// won't be equal
				command.isConfigurable();
				builders.remove(command);
			}
		}
		description.setBuildSpec(builders.toArray(new ICommand[builders.size()]));
	}

	private MoinProject() {
	}

	static {
		Bundle miFwk = Platform.getBundle("com.sap.mi.fwk"); //$NON-NLS-1$
		try {
			miFwk.start();
		} catch (Exception e) { // $JL-EXC$
			DcFwkPlugin.logError(e, sTracer);
		}
	}

	/*
	 * Reduces the folder set by overlapping folders, e.g. removes a/b from
	 * {a/b, a}
	 */
	private static Collection<MoinFolderInfo> condenseFolders(MoinFolderInfo[] infos) {
		final Collection<MoinFolderInfo> toRemove = new HashSet<MoinFolderInfo>();
		List<MoinFolderInfo> result = new ArrayList<MoinFolderInfo>(Arrays.asList(infos));
		// We use sorting via the comparator just to do an efficient traversal.
		// The comparator detects overlapping paths.
		Collections.sort(result, new Comparator<MoinFolderInfo>() {
			public int compare(MoinFolderInfo o1, MoinFolderInfo o2) {
				if (o1 == o2 || o1.equals(o2)) {
					return 0;
				}
				IPath p1 = o1.getPath();
				IPath p2 = o2.getPath();
				return p1.toString().compareTo(p2.toString());
			}
		});

		int index = 1;
		for (Iterator<MoinFolderInfo> it = result.iterator(); it.hasNext();) {
			MoinFolderInfo o1 = it.next();
			IPath p1 = o1.getPath();
			Collection<MoinFolderInfo> remaining = result.subList(index, result.size());
			for (Iterator<MoinFolderInfo> it2 = remaining.iterator(); it2.hasNext();) {
				MoinFolderInfo o2 = it2.next();
				IPath p2 = o2.getPath();
				int segs = p1.matchingFirstSegments(p2);
				if (segs > 0) {
					if (p1.segmentCount() > p2.segmentCount()) {
						toRemove.add(o1);
						logFolderRemoval(p1, p2);
					} else if (p2.segmentCount() > p1.segmentCount()) {
						toRemove.add(o2);
						logFolderRemoval(p1, p2);
					}
				}

			}
			index++;
		}

		result.removeAll(toRemove);

		return result;
	}

	private static void logFolderRemoval(IPath p1, IPath p2) {
		stracer.log(Level.SEVERE, "Nested MOIN folders found: '" + p1.toOSString() + //$NON-NLS-1$
				"' and '" + p2.toOSString() +  //$NON-NLS-1$
				"'. Only the outermost folder will be set for the new DC. " +  //$NON-NLS-1$
				"This indicates an error in the DC type definition; " +  //$NON-NLS-1$
				"re-check the intention of the folder definitions for this DC type."); //$NON-NLS-1$

	}

	/**
	 * Returns the information for folder registered at Moin of the given
	 * project.
	 *
	 * @param project
	 *            the project whose folders are to be queried
	 * @return the folders information
	 */
	@SuppressWarnings("unchecked")
	private static MoinFolderInfo[] getMoinFolders(IProject project) {
		if (!isMoinProject(project)) {
			return NO_MOIN_FOLDERS;
		}
		IDcProject dcProject = getDcProject(project);
		if (dcProject == null) {
			return NO_MOIN_FOLDERS;
		}

		IDcMetadataState metadata = dcProject.getDevelopmentComponent().getLocalState();
		List<ICustomProperty> customProperties = metadata.getCustomProperties();
		for (ICustomProperty prop : customProperties) {
			if (!PROP_MOIN.equals(prop.getName())) {
				continue;
			}
			List<ICustomProperty> children = prop.getChildren();
			List<MoinFolderInfo> result = new ArrayList<MoinFolderInfo>(children.size() * 2);
			for (ICustomProperty childProp : children) {
				boolean isResourceFolder = PROP_RES_FOLDERS.equals(childProp.getName());
				List<ICustomProperty> folders = childProp.getChildren();
				for (ICustomProperty resFolder : folders) {
					if (!PROP_FOLDER.equals(resFolder.getName())) {
						continue;
					}
					List<ICustomPropertyAttribute> folderAtts = resFolder.getAttributes();
					String path = null;
					boolean excludedInIde = false;
					boolean excludedInBuild = false;
					for (ICustomPropertyAttribute att : folderAtts) {
						String name = att.getName();
						String value = att.getValue();
						if (PROP_FOLDER_PATH.equals(name)) {
							path = value;
						} else if (PROP_FOLDER_EXCLUDE_IDE.equals(name)) {
							excludedInIde = Boolean.valueOf(value);
						} else if (PROP_FOLDER_EXCLUDE_BUILD.equals(name)) {
							excludedInBuild = Boolean.valueOf(value);
						}
					}
					if (path != null) {
						try {
							MoinFolderInfo info = new MoinFolderInfo(new Path(path), isResourceFolder, excludedInIde,
									excludedInBuild);
							result.add(info);
						} catch (RuntimeException e) {
							DcFwkPlugin.logError(e, sTracer);
						}
					}
				}
			}
			return result.toArray(new MoinFolderInfo[result.size()]);
		}
		return NO_MOIN_FOLDERS;
	}

	/**
	 * @return whether the given project has the Moin nature, i.e. whether model
	 *         content can be placed in the project. Returns <code>false</code>
	 *         for closed projects.
	 */
	private static boolean isMoinProject(IProject project) {
		if (project == null) {
			throw new IllegalArgumentException("Project must not be null"); //$NON-NLS-1$
		}

		try {
			// closed projects are unable to return their natures
			if (!project.isAccessible()) {
				return false;
			}
			boolean hasNature = project.hasNature(ID_NATURE);
			return hasNature;
		} catch (CoreException e) {
			DcFwkPlugin.logError(e, sTracer);
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	private static boolean isMoinDc(IDevelopmentComponent dc) {

		IAttribute attMoinDc = null;
		boolean value = false;
		List<IAttribute> atts = dc.getLocalState().getAttributes();
		// find the moin attribute
		for (IAttribute att : atts) {
			if (ATT_IS_MOIN_DC.equals(att.getName()) && VENDOR_SAP.equals(att.getVendor())) {
				attMoinDc = att;
				value = new Boolean(attMoinDc.getValue()).booleanValue();
				break;
			}
		}
		return (attMoinDc != null) && value;
	}

	private static final class DeleteProjectRunnable implements IWorkspaceRunnable {
		private final IProject mProject;

		private DeleteProjectRunnable(IProject project) {
			mProject = project;
		}

		public void run(IProgressMonitor monitor) throws CoreException {
			mProject.delete(true, monitor);
		}
	}

	private static final class CreateProjectRunnable implements IWorkspaceRunnable {
		private final IDevelopmentComponent mDc;
		private final String[] mNatures;
		private final String[] mBuilders;
		private final MoinFolderInfo[] mFolderInfos;
		private final IMoinDcType mDcType;
		private final MoinDcOptions mOptions;

		private CreateProjectRunnable(IDevelopmentComponent dc, IMoinDcType dcType, String[] natures,
				String[] builders, MoinFolderInfo[] folderInfos, MoinDcOptions options) {
			mDc = dc;
			mDcType = dcType;
			mNatures = natures;
			mBuilders = builders;
			mFolderInfos = folderInfos;
			mOptions = options;
		}

		public void run(IProgressMonitor monitor) throws CoreException {
			MultiStatus status = new DiiMultiStatus(DcFwkPlugin.PLUGIN_ID, 0, "Create Projects from DCs", null); //$NON-NLS-1$
			IProject project = DCWizardUtil.createProjectFromDC(mDc, BasicDcTypeManager.getManager(), monitor, status);
			if (project == null) {
				// Prevent NPE, instead throw an exception hopefully providing the cause
				String name = null;
				if (mDc == null) {
					name = "<null>"; //$NON-NLS-1$
				}
				else {
					name = mDc.getName();
				}
				throw new IllegalStateException("Could not get project for DC '" + name + "': " + status.toString()); //$NON-NLS-1$ //$NON-NLS-2$
			}
			project.open(monitor);
			IProjectDescription desc = project.getDescription();
			// natures
			addNatures(desc, mNatures, monitor);
			// builders
			addBuilders(desc, mBuilders, monitor);
			project.setDescription(desc, monitor);
			// source folders
			createProjectFolders(project, mFolderInfos, monitor);

			project.refreshLocal(IResource.DEPTH_INFINITE, monitor);

			// Call init hook protected by the workspace lock (implementations
			// may create connections, which require the lock).
			initDc(mDc, project, mDcType, mOptions, true, monitor);
		}
	}

	private static final class EnableForMoinRunnable implements IWorkspaceRunnable {
		private final IProject mProject;
		private final MoinDcOptions mOptions;
		private final IDevelopmentComponent mDc;
		private IMeDcMetadataState mDcState;
		private final boolean mDcMetadataChangeRequested;

		private EnableForMoinRunnable(IDevelopmentComponent dc, IProject project, MoinDcOptions options)
				throws CoreException {
			this(dc, project, options, true);
		}

		private EnableForMoinRunnable(IDevelopmentComponent dc, IProject project, MoinDcOptions options,
				boolean dcMetadataChangeRequested) throws CoreException {
			if (dc == null) {
				throw new IllegalArgumentException("Project is not a DC: " + project); //$NON-NLS-1$
			}
			mDc = dc;
			mProject = project;
			mOptions = options;
			mDcMetadataChangeRequested = dcMetadataChangeRequested;
		}

		public void run(IProgressMonitor monitor) throws CoreException {
			if (mDcMetadataChangeRequested) {
				// Check existing folders for overlaps
				MoinFolderInfo[] existingFolders = MoinProject.getMoinFolders(mProject);
				Collection<MoinFolderInfo> condensedExistingFolders = condenseFolders(existingFolders);
				if (existingFolders.length != condensedExistingFolders.size()) {
					stracer.log(Level.SEVERE, "Found overlaps in the already existing folder definitions for '" + //$NON-NLS-1$
							mProject.getName() + "'. For details see the errors logged directly before this entry."); //$NON-NLS-1$
				}
				// Check new folders for overlaps
				MoinFolderInfo[] newFolders = mOptions.getFolders();
				Collection<MoinFolderInfo> condensedNewFolders = condenseFolders(newFolders);
				if (newFolders.length != condensedNewFolders.size()) {
					stracer.log(Level.SEVERE, "Found overlaps in the new folder definitions for '" + //$NON-NLS-1$
							mProject.getName() + "'. For details see the errors logged directly before this entry."); //$NON-NLS-1$
				}
				// Check combination for overlaps
				Collection<MoinFolderInfo> allFoldersCollection = new ArrayList<MoinFolderInfo>(condensedExistingFolders.size() + condensedNewFolders.size());
				allFoldersCollection.addAll(condensedExistingFolders);
				allFoldersCollection.addAll(condensedNewFolders);
				MoinFolderInfo[] allFolders = new MoinFolderInfo[allFoldersCollection.size()];
				allFolders = allFoldersCollection.toArray(allFolders);
				Collection<MoinFolderInfo> condensedAllFolders = condenseFolders(allFolders);
				if (allFolders.length != condensedAllFolders.size()) {
					stracer.log(Level.SEVERE, "Found overlaps in the combination of already existing and new folder definitions for '" + //$NON-NLS-1$
							mProject.getName() + "'. For details see the errors logged directly before this entry."); //$NON-NLS-1$
				}
				// Add the folders anyway
				mDcState = configureDc(mDc, mOptions, monitor, null);
			}
			configureProject(mProject, mOptions, monitor);
			createProjectFolders(mProject, mOptions.getFolders(), monitor);
		}

		IMeDcMetadataState getEditableState() {
			return mDcState;
		}
	}

	private static final class DisableMoinRunnable implements IWorkspaceRunnable {
		private final IProject mProject;
		private final MoinDcOptions mOptions;
		private final IDevelopmentComponent mDc;
		private IMeDcMetadataState mDcState;

		private DisableMoinRunnable(IProject project, MoinDcOptions options) throws CoreException {
			mDc = DiiResourceService.getDevelopmentComponent(project);
			if (mDc == null) {
				throw new IllegalArgumentException("Project is not a DC: " + project); //$NON-NLS-1$
			}
			IMoinDcType dcType = getDcTypeDelegate(mDc.getComponentType());
			mOptions = getOptions(dcType, options, true);
			mProject = project;
		}

		public void run(IProgressMonitor monitor) throws CoreException {
			mDcState = deconfigureDc(mDc, mOptions, monitor);
			deconfigureProject(mProject, mOptions, monitor);
		}

		IMeDcMetadataState getEditableState() {
			return mDcState;
		}
	}

}