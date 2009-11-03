package com.sap.mi.fwk;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.osgi.framework.Bundle;

import com.sap.mi.fwk.internal.MiFwkPlugin;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.internal.uihook.IMiFwkOperationExecutor;
import com.sap.mi.fwk.mm.MetamodelManager;
import com.sap.tc.moin.friends.ide.IdePrimaryFacilityUtil;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.cdam.CompoundDataAreaManager;
import com.sap.tc.moin.repository.cdam.ide.IdeCompoundDataAreaManager;
import com.sap.tc.moin.repository.cdam.ide.internal.IdeFacilityDispatcherInternal;
import com.sap.tc.moin.repository.ide.MoinFactory;
import com.sap.tc.moin.repository.spi.facility.ide.ContainerInitializationState;
import com.sap.tc.moin.textverticalization.TranslatableTextFragment;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * Facility to access MOIN models. Contains project-related services.
 * 
 * @author d031150, d024127
 */
public final class ModelManager {

	/**
	 * The generic nature id of MOIN projects. All projects with MOIN content
	 * need this nature. Value is <code>com.sap.mi.fwk.dcfwk.MoinNature</code>.
	 * 
	 * value: com.sap.mi.fwk.dcfwk.MoinNature
	 */
	public static final String MOIN_NATURE = "com.sap.mi.fwk.dcfwk.MoinNature"; //$NON-NLS-1$

	private static final String ATTRIBUTE_OBJ_NAME = "name";//$NON-NLS-1$
	private static final String ATTRIBUTE_OBJ_ID = "id";//$NON-NLS-1$
	private static final String LINE_SEP = System.getProperty("line.separator"); //$NON-NLS-1$
	private static final String EXT_POINT_ELEMENT_OPEXECUTOR = "operationExecutor"; //$NON-NLS-1$
	private static final String EXT_POINT_ATT_OPEXECUTOR_CLASS = "class"; //$NON-NLS-1$

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_MODELHANDLING);

	private static ModelManager sInstance;

	private static IMiFwkOperationExecutor opExecutor;

	/**
	 * @return the instance of this class
	 */
	public static synchronized ModelManager getInstance() {
		if (ModelManager.sInstance == null) {
			ModelManager.sInstance = new ModelManager();
		}
		return ModelManager.sInstance;
	}

	/**
	 * @return a facility for accessing or creating connections
	 */
	public static ConnectionManager getConnectionManager() {
		return ConnectionManager.getInstance();
	}

	/**
	 * @return a facility for accessing or Eclipse markers
	 */
	public static MarkerManager getMarkerManager() {
		return MarkerManager.getInstance();
	}

	/**
	 * @return a utility for managing model partitions
	 */
	public static PartitionService getPartitionService() {
		return PartitionService.getInstance();
	}

	/**
	 * @return a utility for managing the metamodels
	 */
	public static MetamodelManager getMetamodelManager() {
		return MetamodelManager.getInstance();
	}

	/**
	 * @return a utility for query execution
	 */
	public static QueryService getQueryService() {
		return QueryService.getInstance();
	}

	/**
	 * @return the adapter utility for model objects
	 */
	public static ModelAdapter getModelAdapter() {
		return ModelAdapter.getInstance();
	}

	/**
	 * @return the MOIN Instance
	 */
	public Moin getMoinInstance() {
		final Moin moin = MoinFactory.getMoinInstance();
		return moin;
	}

	/**
	 * Test the current project if it is a MOIN project.
	 * 
	 * @param project
	 *            The current project
	 * 
	 * @return whether the given project has the MOIN nature, i.e. whether model
	 *         content can be placed in the project
	 * 
	 * @see #isMoinProjectInitialized(IProject)
	 */
	public boolean isMoinProject(final IProject project) {
		if (project == null) {
			throw new IllegalArgumentException("Project must not be null"); //$NON-NLS-1$
		}

		try {
			// closed projects are unable to return their natures
			if (!project.isAccessible()) {
				return false;
			}
			final boolean hasNature = project.hasNature(ModelManager.MOIN_NATURE);
			return hasNature;
		} catch (final CoreException e) {
			MiFwkPlugin.logError(e, ModelManager.sTracer);
			return false;
		}
	}

	/**
	 * In addition to {@link #isMoinProject(IProject)} checks whether the
	 * project is fully created so that MOIN is able to work on it. Usually the
	 * two methods return that same result except for some early time during
	 * project creation when the project is not completely created. Listeners
	 * called at this time may use this method to find out whether they can go
	 * on or should fail gracefully.
	 * 
	 * @param project
	 *            The current project
	 * 
	 * @return whether the project is fully initialized and ready to be used
	 * 
	 * @see #isMoinProject(IProject)
	 */
	public boolean isMoinProjectInitialized(final IProject project) {
		// do the cheap project-based checks first
		if (!isMoinProject(project)) {
			return false;
		}
		// more expensive check - but necessary during project creation
		// when project is there, but not yet the DC
		final ContainerInitializationState state = runMoinOpWithResourceLock(project, null,
				new IMoinOpRunnable<ContainerInitializationState>() {
					public ContainerInitializationState run(final ContainerInitializationState initState) throws InvocationTargetException,
							InterruptedException {
						return initState;
					}
				}, null);
		if (ContainerInitializationState.NOT_MOIN_RELEVANT == state) {
			return false;
		}
		return true;
	}

	/**
	 * Returns the source folders of the given MOIN project. Note that only the
	 * paths registered at MOIN are taken into account, additional Dii folders
	 * or Java source folders are ignored.
	 * 
	 * @param project
	 *            the project whose source folders are to be queried
	 * @return the source folders, e.g. ["src", "moin/meta"]
	 */
	public IPath[] getMoinResourceFolders(final IProject project) {
		// TODO [Facility Separation] move to facility dispatcher
		return callInDcFwkPlugin(null, "com.sap.mi.fwk.dcfwk.MoinProject", "getMoinResourceFolders", new Class[] { IProject.class }, //$NON-NLS-1$ //$NON-NLS-2$
				project);
	}

	/**
	 * Returns the human readable name of a given object or the MOF id if no
	 * name can be found. The method tries to access a modeled attribute "name"
	 * or "id" in this order. If no attribute with this name is modeled, the
	 * first attribute whose value is a String or
	 * {@link TranslatableTextFragment} is returned, otherwise <code>null</code>
	 * .
	 * 
	 * @param obj
	 *            the object to get a name for
	 * @return the value of attribute "name" or the MOF id if no attribute
	 *         "name" exists
	 * 
	 * @see #getObjectNameAttribute(RefObject)
	 */
	public String getObjectName(final Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException("Obj must not be null"); //$NON-NLS-1$
		}

		if (obj instanceof Partitionable) {
			if (!((Partitionable) obj).is___Alive()) {
				return null;
			}
		}

		// shortcut for MOF
		if (obj instanceof ModelElement) {
			final ModelElement elem = (ModelElement) obj;
			final String name = elem.getName();
			if (name != null) {
				return name;
			}
		}
		if (obj instanceof RefObject) {
			final RefObject refObject = (RefObject) obj;
			final Entry<Attribute, String> attr = getObjectNameAttribute(refObject);
			if (attr != null) {
				final String value = attr.getValue();
				if (value != null) {
					return value;
				}
			}
		}

		// MOF id
		if (obj instanceof RefBaseObject) {
			final RefBaseObject refObject = (RefBaseObject) obj;
			final String objName = refObject.refMofId();
			if (objName != null) {
				return objName;
			}
		}
		return obj.toString();
	}

	/**
	 * Returns the MOF attribute that contains a human readable name of a given
	 * object as its value. The method tries to access a modeled attribute
	 * "name" or "id" in this order. If no attribute with this name is modeled,
	 * the first attribute whose value is a String or
	 * {@link TranslatableTextFragment} is returned, otherwise <code>null</code>
	 * .
	 * 
	 * @param refObject
	 *            the object to get a name for
	 * @return the attribute (currently "name", id" or a
	 *         {@link TranslatableTextFragment}) and the readable name
	 * 
	 * @see #getObjectName(Object)
	 */
	public Entry<Attribute, String> getObjectNameAttribute(final RefObject refObject) {
		final RefObject metaObject = refObject.refMetaObject();
		if (metaObject instanceof MofClass) {
			final JmiHelper jmiHelper = getModelAdapter().getJmiHelper(refObject);
			final Set<Entry<Attribute, Object>> attrs = jmiHelper.getAttributesWithValues(refObject, true).entrySet();
			for (final Entry<Attribute, Object> entry : attrs) {
				final Attribute attr = entry.getKey();
				final Object value = entry.getValue();
				// "name"
				if (ModelManager.ATTRIBUTE_OBJ_NAME.equalsIgnoreCase(attr.getName())) {
					if (value != null) {
						final String v = valueAsString(value);
						return Collections.singletonMap(attr, v).entrySet().iterator().next();
					}
				}
				// "id"
				if (ModelManager.ATTRIBUTE_OBJ_ID.equalsIgnoreCase(attr.getName())) {
					if (value != null) {
						final String v = valueAsString(value);
						return Collections.singletonMap(attr, v).entrySet().iterator().next();
					}
				}
				// string value
				if (value instanceof String) {
					return Collections.singletonMap(attr, (String) value).entrySet().iterator().next();
				}
				// translatable texts
				if (value instanceof TranslatableTextFragment) {
					final String text = valueAsString(value);
					return Collections.singletonMap(attr, text).entrySet().iterator().next();
				}
			}
		}

		return null;
	}

	/**
	 * @return the given value as a string, in case of a
	 *         {@link TranslatableTextFragment translatable text} the original
	 *         text
	 */
	private String valueAsString(final Object value) {
		if (value instanceof TranslatableTextFragment) {
			final String text = ((TranslatableTextFragment) value).getOriginalText();
			return text;
		}
		return String.valueOf(value);
	}

	/**
	 * Creates an extended string presentation of the given
	 * {@link RefBaseObject}, including its type and attributes
	 * 
	 * @param o
	 *            the object to create a string presentation for
	 * @return the string
	 * 
	 * @see #toString(RefBaseObject, StringBuilder)
	 */
	public String toString(final RefBaseObject o) {
		final StringBuilder result = new StringBuilder();
		toString(o, result);
		return result.toString();
	}

	/**
	 * Creates an extended string presentation of the given
	 * {@link RefBaseObject}, including its type and attributes
	 * 
	 * @param o
	 *            the object to create a string presentation for
	 * @param result
	 *            the string buffer to store the result into
	 * @return the same string buffer as <code>result</code> per convenience
	 * 
	 * @see #toString(RefBaseObject)
	 */
	public StringBuilder toString(final RefBaseObject o, final StringBuilder result) {
		final ModelElement metaObject = (ModelElement) o.refMetaObject();
		// type
		result.append(metaObject.getName());
		result.append(" \""); //$NON-NLS-1$
		// human-readable name
		result.append(getObjectName(o));
		result.append("\": "); //$NON-NLS-1$
		// MRI
		result.append(((Partitionable) o).get___Mri());
		result.append(ModelManager.LINE_SEP);
		// all attributes with values (sorted by name)
		if (o instanceof RefObject) {
			final JmiHelper jmiHelper = getModelAdapter().getJmiHelper(o);
			final Map<Attribute, Object> atts = new TreeMap<Attribute, Object>(ModelElementNameComparator.INSTANCE_IGNORING_CASE);
			atts.putAll(jmiHelper.getAttributesWithValues((RefObject) o, true));
			final Set<Entry<Attribute, Object>> attsWithValues = atts.entrySet();
			for (final Entry<Attribute, Object> attr : attsWithValues) {
				result.append("  "); //$NON-NLS-1$
				result.append(attr.getKey().getName());
				result.append("="); //$NON-NLS-1$
				result.append(valueAsString(attr.getValue()));
				result.append(ModelManager.LINE_SEP);
			}
		}
		// class name of Jmi interface
		result.append("  class="); //$NON-NLS-1$
		result.append(((Partitionable) o).get___JmiInterface().getName());
		return result;
	}

	/**
	 * Returns the typed value for a given refobject and its attribute.
	 * 
	 * @param obj
	 *            The current refObject
	 * @param attr
	 *            The refObject's attribute
	 * @param value
	 *            The attribute value
	 * @return The object for this value, e.g. an Integer object
	 */
	public Object getRefValueObject(final RefObject obj, final Attribute attr, final String value) {
		final JmiHelper jmiHelper = getModelAdapter().getJmiHelper(obj);
		final Classifier type = jmiHelper.getNonAliasType(attr.getType());
		if (type instanceof PrimitiveType) {
			if (value != null && value.trim().length() == 0) {
				return null;
			}
			final Class typeClass = jmiHelper.getJavaPrimitiveOrWrapperType(attr);
			if (typeClass.equals(String.class)) {
				return value;
			}
			if (typeClass.equals(Boolean.class) || typeClass.equals(Boolean.TYPE)) {
				return (value != null ? Boolean.valueOf(value) : null);
			}
			if (typeClass.equals(Integer.class) || typeClass.equals(Integer.TYPE)) {
				return (value != null ? Integer.valueOf(value) : null);
			}
			if (typeClass.equals(Long.class) || typeClass.equals(Long.TYPE)) {
				return (value != null ? Long.valueOf(value) : null);
			}
			if (typeClass.equals(Float.class) || typeClass.equals(Float.TYPE)) {
				return (value != null ? Float.valueOf(value) : null);
			}
			if (typeClass.equals(Double.class) || typeClass.equals(Double.TYPE)) {
				return (value != null ? Double.valueOf(value) : null);
			}
			throw new IllegalArgumentException("Unknow primitive type. typeClass:" + typeClass + ", obj:" + obj + ", attributeName:" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					+ attr.getName() + ", value:" + value + ", attribute:" + attr); //$NON-NLS-1$ //$NON-NLS-2$
		} else if (type instanceof EnumerationType) {
			final EnumerationType enumType = (EnumerationType) type;
			final List<RefEnum> enums = jmiHelper.getEnumerationConstants(enumType);
			for (final RefEnum refEnum : enums) {
				if (refEnum.toString().equals(value)) {
					return refEnum;
				}
			}
			throw new IllegalArgumentException("Unknow enum type:" + value + ", legal enum values: " + enums + ", obj:" + obj //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					+ ", attributeName:" + attr.getName() + ", attribute:" + attr); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return value;
	}

	/**
	 * @deprecated use
	 *             {@link #refreshFromFileSystem(IProject, IProgressMonitor)}
	 */
	@Deprecated
	public IStatus refreshFromFileSystem(final IProject project) {
		return refreshFromFileSystem(project, null);
	}

	/**
	 * Refreshes the partitions of the given project. This causes Moin to read
	 * all partitions anew (including new partitions).
	 * <p/>
	 * Eventually locks the whole {@link IWorkspaceRoot Eclipse workspace}, but
	 * at least the project. The caller must therefore either hold the workspace
	 * lock or no resource locks at all.
	 * 
	 * @param project
	 *            the project to refresh
	 * @param monitor
	 *            a progress monitor or <code>null</code>
	 * @return the result status
	 */
	// ATTENTION WITH API CHANGES!!! - Called via reflection from
	// com.sap.mi.fwk.test.service.internal.InvocationHelper and
	// com.sap.mi.fwk.dcfwk.internal.InvocationHelper
	public IStatus refreshFromFileSystem(final IProject project, final IProgressMonitor monitor) {
		// do not check whether project is open since calling refresh with a
		// deleted project has semantics of unregistering it in MOIN
		if (project == null) {
			throw new IllegalArgumentException("Project must not be null"); //$NON-NLS-1$
		}

		final IMoinOpRunnable<Void> refreshOp = new IMoinOpRunnable<Void>() {
			public Void run(final ContainerInitializationState initState) throws InvocationTargetException, InterruptedException {
				// check whether at client spec is initialized
				if (ContainerInitializationState.NOT_INITIALIZED == initState) {
					try {
						// Issue an Eclipse resource refresh since connection /
						// client spec creation does not do this
						// client spec not initialized at this point in time as
						// implicitly done during connection creation
						project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
					} catch (final CoreException e) {
						throw new InvocationTargetException(e);
					}
				} else {
					// If client spec was initialized, refresh with forced==true
					// since it was called explicitly (as part of a repair
					// action). Includes an Eclipse resource refresh.
					MiFwkPlugin.getIdeCompoundDataAreaManager().refreshFromFileSystem(project, true);
				}
				return null;
			}

			@Override
			public String toString() {
				return "Refresh from file system for project " + project.getName(); //$NON-NLS-1$
			}
		};

		try {
			runMoinOpWithResourceLock(project, null, refreshOp, monitor);
			return Status.OK_STATUS;
		} catch (final OperationCanceledException e) { // $JL-EXC$
			return Status.CANCEL_STATUS;
		} catch (final Exception e) { // $JL-EXC$
			return MiFwkPlugin.createStatus(IStatus.ERROR, e.getMessage(), e);
		}
	}

	CompoundClientSpec getTransientClientSpec() {
		final CompoundDataAreaManager cdam = getCompoundDataAreaManager();
		final CompoundClientSpec ccs = cdam.getCompoundClientSpecTransientOnly();
		return ccs;
	}

	/**
	 * Creates a session which allows to access the data in the given project
	 */
	Session createSession(final IProject project, final ContainerInitializationState initState) {
		final CompoundClientSpec clientSpec = getOrCreateClientSpec(project, initState);
		return createSession(clientSpec);
	}

	Session createSession(final CompoundClientSpec clientSpec) {
		final Session session = getMoinInstance().createSession(clientSpec);
		if (ModelManager.sTracer.debug()) {
			// trace session creation
			final Exception exception = new Exception("Call Stack"); //$NON-NLS-1$
			final String message = "Creating session " + session; //$NON-NLS-1$
			ModelManager.sTracer.log(TracerI.DEBUG, message, exception);
		}
		return session;
	}

	private CompoundClientSpec getOrCreateClientSpec(final IProject project, final ContainerInitializationState initState) {
		switch (initState) {
			case INITIALIZED:
				break;
			case NOT_INITIALIZED: {
				getDispatcher().initializeClientSpec(project);
				break;
			}
			case CLIENT_SPEC_ONLY_INITIALIZED:
				MiFwkPlugin.getIdeCompoundDataAreaManager().refreshFromFileSystem(project, false);
				break;
			case NOT_MOIN_RELEVANT:
				// fail with exception
				MiFwkPlugin.assertIsMoinRelevant(project, initState);
				break;
			default:
				throw new IllegalStateException("Unknown initialization state of project " + project + ": " + initState); //$NON-NLS-1$ //$NON-NLS-2$
		}

		final ClientSpec clientSpec = MiFwkPlugin.getIdeCompoundDataAreaManager().getClientSpec(project);
		if (clientSpec == null) {
			throw new IllegalStateException("Not able to get a client spec for project: " + project //$NON-NLS-1$
					+ ", init state: " + initState); //$NON-NLS-1$ 
		}

		final IdeCompoundDataAreaManager cdam = getCompoundDataAreaManager();
		final CompoundClientSpec compoundClientSpec = cdam.getDefaultCompoundClientSpec(clientSpec);
		return compoundClientSpec;
	}

	/**
	 * Runs the given operation protected by a resource lock appropriate for the
	 * given initialization state of the project, i.e. does not lock if it's not
	 * necessary, otherwise blocks until lock is available.
	 * 
	 * @param project
	 *            the project to acquire the lock for
	 * @param initState
	 *            the initialization state of the given project (see
	 *            {@link IdePrimaryFacilityUtil#getContainerInitializationState(IProject)}
	 *            )
	 * @param operation
	 *            the operation to execute
	 * @param monitor
	 *            a progress monitor or <code>null</code>
	 * @param exHandler
	 *            an exception handler or <code>null</code>
	 * @return the operation's result
	 * @throws InterruptedException
	 *             in case of the user's cancellation
	 */
	static <T> T runMoinOpWithResourceLock(final IProject project, final ContainerInitializationState initState,
			final IMoinOpRunnable<T> operation, final IProgressMonitor monitor) {

		final Callable<T> mainOperation = new Callable<T>() {
			public T call() throws Exception {
				ContainerInitializationState projectState = initState;
				if (projectState == null) {
					projectState = getInstance().getDispatcher().getContainerInitializationState(project);
				}

				final ISchedulingRule lock = determineResourceLock(project, projectState);
				try {
					acquireResourceLockIfNeeded(lock, monitor);
					return operation.run(projectState);
				} catch (final OperationCanceledException e) {
					// Happens if beginRule() blocks and is then cancelled e.g.
					// by the user's pressing the cancel button on the jobs
					// dialog.
					final InterruptedException ie = new InterruptedException(e.getMessage());
					ie.initCause(e);
					throw ie;
				} finally {
					// Note that this finally block is executed even on
					// exceptions during acquire() and in the catch blocks
					// (rethrowing exception handler). Necessary since
					// begin/endRule() contract forces us to
					// call endRule() even if beginRule() failed.
					releaseLock(lock);
				}
			}

			@Override
			public String toString() {
				return operation.toString();
			}
		};

		try {
			T result;
			if (getOperationExecutor().isInUiThread()) {
				// Final state of the Modal Context Switch removal: throw a
				// runtime exception and do no longer switch to the modal
				// context "under the hood"
				final IllegalStateException e = new IllegalStateException(
						"Illegal thread exception: this call must not happen in the UI thread. Either use deferred initialization or move this call to a modal context thread."); //$NON-NLS-1$
				e.fillInStackTrace();
				throw e;
			} else {
				result = mainOperation.call();
			}
			return result;
		} catch (final OperationCanceledException e) {
			throw e;
		} catch (final InterruptedException e) {
			final OperationCanceledException oce = new OperationCanceledException(e.getMessage());
			oce.initCause(e);
			throw oce;
		} catch (final InvocationTargetException e) {
			final Throwable cause = e.getCause();
			if (cause instanceof RuntimeException) {
				throw (RuntimeException) cause;
			}
			throw new RuntimeException(cause);
		} catch (final Exception e) {
			if (e instanceof RuntimeException) {
				throw (RuntimeException) e;
			}
			throw new RuntimeException(e);
		}
	}

	/**
	 * @return the appropriate lock object without acquiring it
	 */
	private static ISchedulingRule determineResourceLock(final IProject project, final ContainerInitializationState initState) {
		// Whole locking strategy (which lock for which init state) must match
		// to facility implementation.
		switch (initState) {
			case NOT_INITIALIZED:
				// Need to lock whole workspace as Nwdi facility
				// may be forced the first time to scan cross-project.
				return project.getWorkspace().getRoot();
			case CLIENT_SPEC_ONLY_INITIALIZED:
				return project;
			default:
				// to indicate for releaseLock() that locking is not needed
				// (cannot use null for this)
				return NoLockingRule.INSTANCE;
		}
	}

	/**
	 * Acquires the given lock unless it's a {@link NoLockingRule}
	 * 
	 * @param lock
	 *            the lock to acquire
	 * @param monitor
	 *            a monitor or <code>null</code>
	 * @throws OperationCanceledException
	 *             if the user aborted the operation
	 */
	private static void acquireResourceLockIfNeeded(final ISchedulingRule lock, final IProgressMonitor monitor)
			throws OperationCanceledException {
		// dispatch to dedicated methods to have the lock type
		// in the stack trace
		if (lock instanceof IWorkspaceRoot) {
			acquireWorkspaceLock((IWorkspaceRoot) lock, monitor);
		} else if (lock instanceof IProject) {
			acquireProjectLock((IProject) lock, monitor);
		}
	}

	/*
	 * Separate method in order to see in thread dumps which lock was used
	 */
	private static void acquireWorkspaceLock(final IWorkspaceRoot root, final IProgressMonitor monitor) throws OperationCanceledException {
		Job.getJobManager().beginRule(root, monitor);
	}

	/*
	 * Separate method in order to see in thread dumps which lock was used
	 */
	private static void acquireProjectLock(final IProject project, final IProgressMonitor monitor) throws OperationCanceledException {
		Job.getJobManager().beginRule(project, monitor);
	}

	/**
	 * To be called in finally clauses of all methods
	 */
	private static void releaseLock(final ISchedulingRule lock) {
		// guard against exceptions happing here since this code
		// usually runs in finally clauses
		try {
			// Must release null locks also in case JobManager.begin() failed.
			// Abort only if locking did not take place.
			if (lock == NoLockingRule.INSTANCE) {
				return;
			}

			Job.getJobManager().endRule(lock);
		} catch (final RuntimeException e) {
			MiFwkPlugin.logError("Exception while releasing lock " + lock, e, ModelManager.sTracer); //$NON-NLS-1$
		}
	}

	/*
	 * Do not make this public since clients of ModelManager don't have facility
	 * classes in their classpath
	 */
	IdeCompoundDataAreaManager getCompoundDataAreaManager() {
		return (IdeCompoundDataAreaManager) getMoinInstance().getCompoundDataAreaManager();
	}

	private IdeFacilityDispatcherInternal getDispatcher() {
		return (IdeFacilityDispatcherInternal) getCompoundDataAreaManager();
	}

	/**
	 * For internal use only
	 */
	public static void shutDown() {
		if (ModelManager.sInstance == null) {
			return;
		}

		getConnectionManager().dispose();
		getMarkerManager().dispose();

		ModelManager.sInstance = null;
	}

	static {
		try {
			final Bundle dcFwk = Platform.getBundle("com.sap.mi.fwk.dcfwk"); //$NON-NLS-1$
			if (dcFwk != null) {
				dcFwk.start();
			}
		} catch (final Exception e) { // $JL-EXC$
			MiFwkPlugin.logError(e, ModelManager.sTracer);
		}
	}

	private ModelManager() {
	}

	@SuppressWarnings("unchecked")
	private <T> T callInDcFwkPlugin(final Object instance, final String clazz, final String method, final Class[] argTypes,
			final Object... args) {
		final Bundle dcFwk = Platform.getBundle("com.sap.mi.fwk.dcfwk"); //$NON-NLS-1$
		try {
			final Class cl = dcFwk.loadClass(clazz);
			final Method m = cl.getMethod(method, argTypes);
			return (T) m.invoke(instance, args);
		} catch (final Exception e) {
			MiFwkPlugin.logError(e, ModelManager.sTracer);
			return null;
		}
	}

	static synchronized IMiFwkOperationExecutor getOperationExecutor() {
		if (ModelManager.opExecutor == null) {
			ModelManager.opExecutor = createOperationExecutor();
		}
		return ModelManager.opExecutor;
	}

	/**
	 * Creates an executor via the <code>uiHook</code> extension point
	 * 
	 * @return an executor
	 */
	private static IMiFwkOperationExecutor createOperationExecutor() {
		final IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(MiFwkPlugin.EXT_POINT_ID_UIHOOK).getExtensions();
		if (extensions.length > 0) {
			final IConfigurationElement[] elements = extensions[0].getConfigurationElements();
			for (final IConfigurationElement element : elements) {
				if (ModelManager.EXT_POINT_ELEMENT_OPEXECUTOR.equals(element.getName())) {
					try {
						final Object exec = element.createExecutableExtension(ModelManager.EXT_POINT_ATT_OPEXECUTOR_CLASS);
						if (exec instanceof IMiFwkOperationExecutor) {
							return (IMiFwkOperationExecutor) exec;
						}
						throw new IllegalStateException("Class is not an instance of IMiFwkOperationExecutor: " + exec); //$NON-NLS-1$
					} catch (final CoreException e) {
						throw new IllegalStateException("Unable to create command executor for extension " //$NON-NLS-1$
								+ extensions[0].getContributor().getName(), e);
					}
				}
			}
		}

		throw new IllegalStateException("No IMiFwkOperationExecutor implementation found among extensions " //$NON-NLS-1$
				+ Arrays.toString(extensions));
	}

	/**
	 * An operation on MOIN that needs special locks and thread conditions. Must
	 * be executed through .
	 * 
	 * @param <T>
	 *            the operation's result type
	 */
	static interface IMoinOpRunnable<T> {
		/**
		 * Executes this operation
		 * 
		 * @param initState
		 *            the computed initialization state of the project
		 * @return a result
		 * 
		 * @throws InvocationTargetException
		 *             in case of failures
		 * @throws InterruptedException
		 */
		T run(ContainerInitializationState initState) throws InvocationTargetException, InterruptedException;

		/**
		 * @return a useful description of the operation
		 */
		String toString();
	}

	/**
	 * A rule implementation to transport the information that no locking did
	 * take place. Not intended to be applied to any operation.
	 */
	private static final class NoLockingRule implements ISchedulingRule {

		/**
		 * The single instance
		 */
		static final ISchedulingRule INSTANCE = new NoLockingRule();

		public boolean contains(final ISchedulingRule rule) {
			return rule == this;
		}

		public boolean isConflicting(final ISchedulingRule rule) {
			return rule == this;
		}

		private NoLockingRule() {
		}
	}

}
