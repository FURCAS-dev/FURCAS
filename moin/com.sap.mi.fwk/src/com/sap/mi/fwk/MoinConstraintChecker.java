package com.sap.mi.fwk;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;

import com.sap.mi.fwk.internal.consistency.DefaultConsistencyListener;
import com.sap.mi.fwk.internal.messages.MiFwkMessages;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * Checks the OCL expressions and the consistency for a given project
 * 
 * @author d024127
 * 
 */
public class MoinConstraintChecker extends IncrementalProjectBuilder {

	private static final IMarker[] EMPTY_MARKER_ARRAY = new IMarker[0];

	private static final String EXT_POINT_OCL_CATEGORY = "com.sap.mi.fwk.categoryprovider"; //$NON-NLS-1$

	/*
	 * In order to activate this code the following section has to be added to every .project file this builder should be used for.
	 * <buildSpec> <buildCommand> <name>com.sap.mi.fwk.MoinConstraintChecker</name> </buildCommand> </buildSpec>
	 */

	/**
	 * This builder's id
	 */
	public static final String BUILDER_ID = "com.sap.mi.fwk.MoinConstraintChecker"; //$NON-NLS-1$

	/**
	 * Marker attribute key to store MOIN OCL violation id
	 */
	public static final String ATT_VIOLATION_ID = "com.sap.mi.fwk.MoinConstraintChecker.violationID"; //$NON-NLS-1$

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_OCL);

	private static final Object mutex = new Object();

	// TODO connection is reused to speed up constraint loading and prevent
	// unnecessary creation of sessions

	private static Connection conn = null;

	private static final String MARKER_TYPE = "com.sap.mi.fwk.oclproblemmarker"; //$NON-NLS-1$

	// TODO [OCL] remove emergency switch
	private static final boolean IS_BUILDER_DISABLED = Boolean.FALSE.toString().equals(
			System.getProperty("com.sap.mi.fwk.checkConstraints")); //$NON-NLS-1$

	private static final String MOIN_META_MODEL_NATURE_ID = "com.sap.tc.moin.nwdi.dctype.mm.MoinMetaModelNature"; //$NON-NLS-1$

	private String markerType = MoinConstraintChecker.MARKER_TYPE;

	private final OCLCategoryExtPointManager oclManager = new OCLCategoryExtPointManager();

	/**
	 * Sets the marker type if subclassed
	 * 
	 * @param newType
	 */
	public final void setMarkerType(final String newType) {
		this.markerType = newType;
	}

	/**
	 * @return the current marker type
	 */
	public String getMarkerType() {
		return this.markerType;
	}

	@Override
	protected IProject[] build(final int kind, final Map args, final IProgressMonitor monitor) throws CoreException {
		if (MoinConstraintChecker.IS_BUILDER_DISABLED) {
			return null;
		}

		ensureConnection(getProject());
		if (MoinConstraintChecker.conn == null) {
			return null;
		}

		if (kind == IncrementalProjectBuilder.CLEAN_BUILD) {
			clean(monitor);
		}
		return doBuild(kind, monitor);
	}

	@Override
	protected void clean(final IProgressMonitor monitor) throws CoreException {

		final IProject project = getProject();
		project.deleteMarkers(this.markerType, true, IResource.DEPTH_INFINITE);
		project.deleteMarkers(DefaultConsistencyListener.MARKER_TYPE, true, IResource.DEPTH_INFINITE);

		super.clean(monitor);
	}

	private IProject[] doBuild(final int kind, final IProgressMonitor monitor) throws OperationCanceledException {

		final long startTime = System.nanoTime();

		final IProject project = getProject();
		if (!ModelManager.getInstance().isMoinProject(project)) {
			MoinConstraintChecker.sTracer.warning("MOIN constraint checker invoked on a non-MOIN project. projectName" + project.getName()); //$NON-NLS-1$
			return null;
		}

		checkCancelation(monitor);

		final IResourceDelta delta = getDelta(project);
		final Collection<PRI> allPartitions = PartitionService.getInstance().getPartitions(conn, project);
		Set<PRI> deltaPartitions = null;
		boolean checkDcdef = true;
		if (kind != IncrementalProjectBuilder.FULL_BUILD && delta != null) {
			// assume delta build

			monitor.subTask(MiFwkMessages.MoinConstraintChecker_getting_deltas);
			monitor.worked(1);

			final ResourceVisitor visitor = new ResourceVisitor(monitor, project);
			try {
				delta.accept(visitor);
			} catch (final CoreException e) {
				MoinConstraintChecker.sTracer.error("MOIN Constraint checker encountered a problem while reading resources", e); //$NON-NLS-1$
				return null;
			}
			monitor.worked(1);
			checkDcdef = visitor.isDcdefFound();

			final IResource[] resources = visitor.getResources();
			deltaPartitions = new HashSet<PRI>(resources.length);
			final PartitionService partitionService = ModelManager.getPartitionService();
			for (final IResource resource : resources) {
				checkCancelation(monitor);
				final PRI pri = partitionService.getPRI(project, resource.getProjectRelativePath());
				deltaPartitions.add(pri);
			}
			monitor.worked(1);
		}

		boolean isMetaModelProject;
		try {
			isMetaModelProject = getProject().isNatureEnabled(MOIN_META_MODEL_NATURE_ID);
		} catch (CoreException e1) {
			sTracer.error("Project nature could not be determined: " + getProject(), e1); //$NON-NLS-1$
			return null;
		}

		final Set<PRI> currentPRIs = new HashSet<PRI>(1);
		for (final PRI pri : allPartitions) {
			checkCancelation(monitor);
			conn.getConsistencyViolationListenerRegistry().performConsistencyCheck(pri);

			if (checkDcdef) {
				checkCancelation(monitor);
				conn.getConsistencyViolationListenerRegistry().performDcDependencyCheck(pri);
			}
			monitor.worked(1);

			if (kind == IncrementalProjectBuilder.FULL_BUILD || (deltaPartitions != null && deltaPartitions.contains(pri))) {
				final ModelPartition partition = conn.getPartition(pri);
				if (partition == null) {
					continue;
				}

				monitor.beginTask(MiFwkMessages.MoinConstraintChecker_checking_constraints, 2);
				checkCancelation(monitor);

				MarkerManager.getInstance().deleteMarkers(partition, this.markerType, true, IResource.DEPTH_ZERO);

				// check and call ext point
				Set<String> categories = oclManager.getCategories(pri);

				try {
					DeferredConstraintViolationStatus status;
					currentPRIs.clear();
					currentPRIs.add(pri);

					if (isMetaModelProject) {
						// meta model project
						// status = conn.getOclRegistryService().getMofConstraintRegistry().verifyConstraints(currentPRIs, categories);
						status = conn.getOclRegistryService().getMofConstraintRegistry().analyzeMetamodelPartitions(currentPRIs,
								OclRegistrationCategory.deferred, OclRegistrationCategory.immediate);
					} else {
						// non meta models
						status = conn.getOclRegistryService().getMetamodelConstraintRegistry().verifyConstraints(currentPRIs, categories);
						// status = dummy(currentPRIs, categories);
					}
					createMarkers(status.getAll(), monitor);

				} catch (Exception e) {
					sTracer.error("Error while checking OCL constraints", e); //$NON-NLS-1$
				}
			}
		}
		monitor.worked(1);

		if (MoinConstraintChecker.sTracer.debug()) {
			MoinConstraintChecker.sTracer.debug("Checker [" + this + "] project [" //$NON-NLS-2$ // //$NON-NLS-1$ 
					+ project.getName() + "]: " //$NON-NLS-1$  
					+ (System.nanoTime() - startTime) + 1000000f + "ms"); //$NON-NLS-1$ 
		}

		monitor.done();
		return null;
	}

	// private DeferredConstraintViolationStatus dummy(Set<PRI> pris, Set<String> cats) throws OclManagerException {
	// final List<DeferredConstraintViolationStatusItem> items = new ArrayList<DeferredConstraintViolationStatusItem>();
	//
	// boolean noCheck = (cats == null || cats.isEmpty());
	// for (PRI pri : pris) {
	// final ModelPartition partition = MoinConstraintChecker.conn.getPartition(pri);
	// final Collection modelElements = partition.getElements();
	// for (Object object : modelElements) {
	// DeferredConstraintViolationStatus status = conn.getOclRegistryService().verifyConstraints((RefObject) object);
	// if (noCheck) {
	// items.addAll(status.getAll());
	// } else {
	// for (DeferredConstraintViolationStatusItem item : status.getAll()) {
	// Set<String> categories = item.getConstraintRegistration().getCategories();
	// boolean intersects = !Collections.disjoint(categories, cats);
	// if (intersects) {
	// items.add(item);
	// }
	// }
	// }
	// }
	// }
	// DeferredConstraintViolationStatus status = new DeferredConstraintViolationStatus() {
	//
	// public List<DeferredConstraintViolationStatusItem> getAll() {
	// return items;
	// }
	//
	// public List<DeferredConstraintViolationStatusItem> getErrors() {
	// return null;
	// }
	//
	// public List<DeferredConstraintViolationStatusItem> getInfos() {
	// return null;
	// }
	//
	// public List<DeferredConstraintViolationStatusItem> getWarnings() {
	// return null;
	// }
	//
	// public boolean hasErrors() {
	// return items.isEmpty();
	// }
	//
	// public boolean hasInfos() {
	// return false;
	// }
	//
	// public boolean hasItems() {
	// return items.isEmpty();
	// }
	//
	// public boolean hasWarnings() {
	// return false;
	// }
	// };
	// return status;
	// }

	private final void createMarkers(List<DeferredConstraintViolationStatusItem> violations, IProgressMonitor monitor) {
		final Map<String, Object> attributes = new HashMap<String, Object>();

		for (final DeferredConstraintViolationStatusItem item : violations) {

			checkCancelation(monitor);
			attributes.clear();
			// needed for quickfix support
			attributes.put(MoinConstraintChecker.ATT_VIOLATION_ID, item.getConstraintRegistration().getName());
			int severity;
			final OclRegistrationSeverity itemSeverity = item.getConstraintRegistration().getSeverity();
			switch (itemSeverity) {
			case Error:
				severity = IMarker.SEVERITY_ERROR;
				break;
			case Warning:
				severity = IMarker.SEVERITY_WARNING;
				break;
			default:
				severity = IMarker.SEVERITY_INFO;
			}

			final RefBaseObject rbo = conn.getElement(item.getOffendingMRI());
			final String msg = item.getLocalizedConstraintViolationMessage();
			ModelManager.getMarkerManager().createMarker(rbo, this.markerType, severity, msg, attributes);
		}

	}

	private void checkCancelation(final IProgressMonitor monitor) {
		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
	}

	private static void ensureConnection(final IProject project) {
		// create connection if necessary
		// TODO replace with Moin OCL connection
		synchronized (MoinConstraintChecker.mutex) {
			if (MoinConstraintChecker.conn == null || !MoinConstraintChecker.conn.isAlive()) {
				if (project == null || !project.isAccessible()) {
					sTracer.error("Project must not be null and must be open"); //$NON-NLS-1$
					return;
				}
				try {
					MoinConstraintChecker.conn = ModelManager.getConnectionManager().createConnection(project);
					if (MoinConstraintChecker.conn == null) {
						MoinConstraintChecker.sTracer.error("Constraint checker connection could not be retrieved. project:" + project); //$NON-NLS-1$
						return;
					}
					MoinConstraintChecker.conn.setLabel("Background constraint checker"); //$NON-NLS-1$
				} catch (Exception e) {
					sTracer.error(
							"Connection to MOIN could not be created. Maybe project is not a MOIN project. Consult error log for details.", //$NON-NLS-1$
							e);
					MoinConstraintChecker.conn = null;
				}
			}
		}
	}

	/**
	 * @deprecated without replacement
	 */
	@Deprecated
	public IMarker[] checkElements(final Collection<RefObject> objects, final IProgressMonitor monitor) {
		RuntimeException e = new RuntimeException();
		sTracer.error("Method has been deprecated.", e); //$NON-NLS-1$
		return EMPTY_MARKER_ARRAY;
	}

	/**
	 * Internal class. DO NOT USE
	 */
	private class ResourceVisitor implements IResourceDeltaVisitor, IResourceVisitor {

		private final Set<IResource> partitionResources;
		private final IProgressMonitor monitor;
		private final PartitionService partitionService = ModelManager.getPartitionService();
		private boolean dcdefFound = false;
		private static final String DCDEF_EXTENSION = "dcdef"; //$NON-NLS-1$

		public boolean isDcdefFound() {
			return this.dcdefFound;
		}

		public ResourceVisitor(final IProgressMonitor monitor, final IProject project) {
			this.monitor = monitor;
			this.partitionResources = new HashSet<IResource>();
		}

		public boolean visit(final IResource resource) throws CoreException {
			checkResource(resource);
			return true;
		}

		public boolean visit(final IResourceDelta delta) throws CoreException {
			final IResourceDelta[] affectedChildren = delta.getAffectedChildren();
			for (final IResourceDelta affectedChild : affectedChildren) {
				checkCancelation(this.monitor);
				checkResource(affectedChild.getResource());
			}
			return true;
		}

		private void checkResource(final IResource resource) {
			if (resource.exists()) {
				if (ResourceVisitor.DCDEF_EXTENSION.equals(resource.getFileExtension())) {
					this.dcdefFound = true;
					return;
				}
				if (this.partitionService.isMoinPartition(resource)) {
					this.partitionResources.add(resource);
				}
			}
		}

		public IResource[] getResources() {
			return this.partitionResources.toArray(new IResource[this.partitionResources.size()]);
		}
	}

	private static final class OCLCategoryExtPointManager {

		private static final Set<String> EMPTY_SET = new HashSet<String>(0);
		private final Set<IOCLCategoryProvider> providers = new HashSet<IOCLCategoryProvider>();

		public OCLCategoryExtPointManager() {
			IExtensionRegistry extRegistry = Platform.getExtensionRegistry();
			IExtension[] extensions = extRegistry.getExtensionPoint(EXT_POINT_OCL_CATEGORY).getExtensions();
			for (IExtension extension : extensions) {
				IConfigurationElement[] configurationElements = extension.getConfigurationElements();
				for (IConfigurationElement configurationElement : configurationElements) {
					IOCLCategoryProvider provider = null;
					try {
						provider = (IOCLCategoryProvider) configurationElement.createExecutableExtension("class"); //$NON-NLS-1$
						providers.add(provider);
					} catch (Throwable t) {
						sTracer.error("OCL Constraint checker: Category provider not instantiated: " + configurationElement, t); //$NON-NLS-1$
					}
				}
			}
		}

		public Set<String> getCategories(PRI pri) {
			if (providers.isEmpty()) {
				return EMPTY_SET;
			}
			Set<String> result = new HashSet<String>();
			for (IOCLCategoryProvider provider : providers) {
				try {
					Set<String> currentCats = provider.getCategories(pri);
					if (currentCats != null) {
						result.addAll(currentCats);
					}
				} catch (Throwable t) {
					sTracer.error("OCL Constraint checker: Categroy provider threw an exception.", t); //$NON-NLS-1$
				}
			}
			return result;
		}
	}
}
