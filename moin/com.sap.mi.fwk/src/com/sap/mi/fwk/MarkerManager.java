package com.sap.mi.fwk;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.LoggingMXBean;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import javax.management.ObjectName;
import javax.management.StandardMBean;

import org.eclipse.core.commands.common.EventManager;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceRuleFactory;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.MultiRule;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.mbeans.MarkerManagerMBean;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionContentChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionDeleteEvent;
import com.sap.tc.moin.repository.events.type.PartitionSaveEvent;

/**
 * Manages creation, deletion, and returning of markers for model objects.
 * Markers are attached to the partition a given object resides in and contain
 * the object's serialized MRI.
 * 
 * @author d024127
 */
public final class MarkerManager extends EventManager implements IResourceChangeListener {

	private static final IMarker[] EMPTY_ARRAY = new IMarker[0];

	/**
	 * Determines whether JMX is enabled
	 */
	public static final boolean JMX_ENABLED = (System.getProperty("com.sun.management.jmxremote.port") != null); //$NON-NLS-1$

	/**
	 * Key constant for RefObject's MRI in a marker
	 */
	public static final String ATTRIBUTE_OBJ_MRI = MarkerManager.class.getName() + ".REF_OBJECT_ID";//$NON-NLS-1$

	/**
	 * Key for RefObject's class name
	 */
	public static final String ATTRIBUTE_OBJ_CLASSNAME = MarkerManager.class.getName() + ".REF_OBJECT_CLASSNAME";//$NON-NLS-1$

	/**
	 * Key for secondary object preferences
	 */
	public static final String ATTRIBUTE_SEC_OBJ_PREFIX = MarkerManager.class.getName() + ".SEC_OBJ_";//$NON-NLS-1$

	private static final String JMX_NAME = "com.sap.mi.fwk:name=MarkerManager"; //$NON-NLS-1$

	/*
	 * Editor id attribute used to start the editor launcher directly from the
	 * marker. This string constant is declare in org.eclipse.ui.ide.IDE but
	 * using it from there would require a dependency to the ide plugin.
	 * Therefore the string has been replicated. With new Eclipse releases, this
	 * value has to be checked.
	 */
	private static final String EDITOR_ID_ATTR = "org.eclipse.ui.editorID"; //$NON-NLS-1$

	/*
	 * The ID of the generic editor launcher declared in com.sap.mi.fwk.ui. This
	 * id together with EDITOR_ID_ATTR is used to start the mi.fwk editor
	 * launcher without associating it with a concrete file extension. Again it
	 * is replicated here to avoid dependency to the ui plugin.
	 */
	private static final String EDITOR_LAUNCHER_ID = "com.sap.mi.fwk.ui.editor.EditorLauncher"; //$NON-NLS-1$

	private static final Logger sTracer = Logger.getLogger(MiLocations.MI_MARKERS);

	private static MarkerManager sInstance;

	private ObjectName mBeanName;
	private MarkerManagerMBean mBean;
	private final MarkerCache markerCache = new MarkerCache();

	final UpdateListener partitionListener = new PartitionListener();

	/**
	 * Interface for listeners to be notified when MOIN based markers were
	 * refreshed
	 */
	public interface MarkerRefreshListener {
		/**
		 * Implementers of this class will be notified when a MOIN based marker
		 * has been changed
		 * 
		 * @param affectedProject
		 *            The project the marker belongs to
		 */
		public void onMarkerChange(IProject affectedProject);
	}

	/**
	 * Adds a listener to the marker manager which is informed if markers
	 * change.
	 * 
	 * @param listener
	 *            The new listener to be notified
	 * @return true, if listener has be added, false if it was already present
	 */
	public synchronized boolean addRefreshListener(MarkerRefreshListener listener) {
		List<Object> listeners = Arrays.asList(getListeners());
		boolean contained = listeners.contains(listener);
		addListenerObject(listener);
		return !contained;
	}

	/**
	 * Removes a listener from the marker manager which is informed if markers
	 * change.
	 * 
	 * @param listener
	 *            The listener to not be notified anymore
	 * @return true, if listener has be in the list before
	 */
	public synchronized boolean removeRefreshListener(MarkerRefreshListener listener) {
		List<Object> listeners = Arrays.asList(getListeners());
		boolean contained = listeners.contains(listener);
		removeListenerObject(listener);
		return contained;
	}

	public void resourceChanged(IResourceChangeEvent event) {
		// if (!fireEvents) {
		// return;
		// }
		IMarkerDelta[] markerDelta = event.findMarkerDeltas(null, true);
		if (markerDelta.length == 0) {
			return;
		}
		Set<IProject> visitedProjects = new HashSet<IProject>(1);
		IProject project = null;
		IProject lastProject = null;
		for (IMarkerDelta delta : markerDelta) {
			if (delta.getKind() == IResourceDelta.REMOVED) {
				String mriString = delta.getAttribute(ATTRIBUTE_OBJ_MRI, null);
				if (mriString != null) {
					MRI mri = null;
					try {
						mri = ModelManager.getInstance().getMoinInstance().createMri(mriString);
					} catch (InvalidResourceIdentifierException e) {
						// skip resource, project may not be fully initialized
						// at this point in time
						if (sTracer.isLoggable(Level.FINE)) {
							sTracer.logp(Level.FINE, MarkerManager.class.getName(),
									"resourceChanged", "Model partition not accessible - skipped. Additional info: " + e.getMessage());//$NON-NLS-1$//$NON-NLS-2$
						}
					}
					if (mri != null) {
						markerCache.removeMarker(mri, delta.getMarker());
					}
				}
			}
			project = delta.getResource().getProject();
			if (project != null && !project.equals(lastProject)) {
				lastProject = project;
				if (visitedProjects.add(project)) {
					Object[] snapshot = getListeners();
					for (Object listener : snapshot) {
						if (listener != null) {
							try {
								((MarkerRefreshListener) listener).onMarkerChange(project);
							} catch (Exception e) {
								sTracer.logp(Level.SEVERE, MarkerManager.class.getName(), "resourceChanged", //$NON-NLS-1$
										"Listener threw exception. listener:" + listener, e);//$NON-NLS-1$
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Creates a marker in the given project for the given RefBaseObject. Usage
	 * example: <code>
	 RefBaseObject refObject = ...;
	 
	 Map<String, Object> attributes = new HashMap<String, Object>();
	 attributes.put("MyOwnAttribute", "some value"); // optional additional parameter

	 IMarker marker = ModelManager.getMarkerManager().
	 createMarker(refObject, IMarker.PROBLEM, IMarker.ERROR, "My error message", attributes);
	 </code>
	 * 
	 * @param obj
	 *            The {@link RefBaseObject} for which the marker should be set
	 * @param markerType
	 *            The marker type ({@link IMarker#PROBLEM}, {@link IMarker#TASK}
	 *            , {@link IMarker#BOOKMARK})
	 * @param severity
	 *            The marker's severity ({@link IMarker#SEVERITY_ERROR},
	 *            {@link IMarker#SEVERITY_INFO},
	 *            {@link IMarker#SEVERITY_WARNING})
	 * @param message
	 *            The marker's message as it appears in the problems view
	 * @param attributes
	 *            Optional parameters. if no optional parameters are rquired
	 *            this parameter might be null, or the method
	 *            {@link #createMarker(RefBaseObject, String, int, String)} can
	 *            be used
	 * @return The created marker
	 * @see IResource#createMarker(String)
	 * @see #createMarker(RefBaseObject, String, int, String)
	 * @throws IllegalArgumentException
	 *             if project or obj is null
	 */
	public IMarker createMarker(RefBaseObject obj, final String markerType, int severity, String message, Map<String, Object> attributes) {
		if (obj == null) {
			throw new IllegalArgumentException("obj must not be null");//$NON-NLS-1$
		}

		if (attributes == null) {
			attributes = new HashMap<String, Object>();
		}

		MRI mri = obj.get___Mri();
		attributes.put(ATTRIBUTE_OBJ_MRI, mri.toString());
		attributes.put(ATTRIBUTE_OBJ_CLASSNAME, obj.get___JmiInterface().getName());
		attributes.put(EDITOR_ID_ATTR, EDITOR_LAUNCHER_ID); // used to start
		// editor

		if (!attributes.containsKey(IMarker.LINE_NUMBER)) {
			// instead of hardcoding the line number the method
			// getLineNumber determines
			// the position of the problematinc object in the xmi file
			// since this is a potentially time consuming operation (reading
			// the file and scanning for a string match)
			// it is not used
			// int lineNumber = getLineNumber(markerFile, obj);
			// attributes.put(IMarker.LINE_NUMBER, 1);
		}

		if (!attributes.containsKey(IMarker.LOCATION)) {
			StringBuilder objName = new StringBuilder(ModelManager.getInstance().getObjectName(obj));

			if (obj.refMetaObject() instanceof ModelElement) {
				ModelElement me = (ModelElement) obj.refMetaObject();
				objName.append(" ").append(me.getQualifiedName()); //$NON-NLS-1$
			}

			attributes.put(IMarker.LOCATION, objName.toString());
			attributes.put(IMarker.LINE_NUMBER, obj.refMofId());
		}

		if (!attributes.containsKey(IMarker.SEVERITY)) {
			attributes.put(IMarker.SEVERITY, severity);
		}

		if (!attributes.containsKey(IMarker.MESSAGE)) {
			attributes.put(IMarker.MESSAGE, message);
		}

		IFile markerFile = ModelAdapter.getInstance().getFile(obj);
		if (markerFile == null || !markerFile.exists()) {
			// sTracer.log(Level.SEVERE, "Partition file not found. obj:" + obj + ",
			// markerType:" + markerType + ", attributes:"
			// + attributes);
			return null;
		}

		IMarker marker = null;
		try {
			marker = markerFile.createMarker(markerType);
			marker.setAttributes(attributes);
		} catch (Exception e) {
			sTracer.log(Level.SEVERE, "Marker could not be set. most likely marker file does not exist. see exception.", e);//$NON-NLS-1$
		}
		markerCache.addMarker(mri, marker);
		return marker;
	}

	/**
	 * Creates a marker in the given project for the given RefBaseObject. Usage
	 * example: <code>
	 RefBaseObject refObject = ...;
	 
	 IMarker marker = ModelManager.getMarkerManager().
	 createMarker(refObject, IMarker.PROBLEM, IMarker.ERROR, "My error message");
	 </code>
	 * 
	 * @param obj
	 *            The {@link RefBaseObject} for which the marker should be set
	 * @param markerType
	 *            The marker type ({@link IMarker#PROBLEM}, {@link IMarker#TASK}
	 *            , {@link IMarker#BOOKMARK})
	 * @param severity
	 *            The marker's severity ({@link IMarker#SEVERITY_ERROR},
	 *            {@link IMarker#SEVERITY_INFO},
	 *            {@link IMarker#SEVERITY_WARNING})
	 * @param message
	 *            The marker's message as it appears in the problems view
	 * @return The created IMarker
	 * @see IResource#createMarker(String)
	 * @see IMarker
	 * @see #createMarker(RefBaseObject, String, int, String, Map)
	 * @throws IllegalArgumentException
	 *             if obj is null
	 */
	public IMarker createMarker(RefBaseObject obj, String markerType, int severity, String message) {

		Map<String, Object> attributes = new HashMap<String, Object>();
		return createMarker(obj, markerType, severity, message, attributes);
	}

	/**
	 * Creates a marker
	 * 
	 * @param obj
	 *            The model element to create the marker for.
	 * @param secondaryObjects
	 *            An arbitrary list of secondary objects. These objects must be
	 *            analyzed by the receiving editor
	 * @param markerType
	 *            The marker type (see {@link IMarker#getType()})
	 * @param severity
	 *            The marker severity
	 * @param message
	 *            The message
	 * @param attributes
	 *            additional arguments
	 * @return The created marker
	 */
	public IMarker createMarker(RefBaseObject obj, Set<RefBaseObject> secondaryObjects, String markerType, int severity, String message,
			Map<String, Object> attributes) {
		if (secondaryObjects != null) {
			if (attributes == null) {
				attributes = new HashMap<String, Object>();
			}
			addSecondaryObjectMris(secondaryObjects, attributes);
		}
		IMarker marker = createMarker(obj, markerType, severity, message, attributes);
		return marker;
	}

	/**
	 * Creates a marker and sets a set of secondary objects. If this marker is
	 * double clicked in the problems view the editor to be started is
	 * determined through the parameter obj. Any additional objects specified in
	 * secondary will be handed over to the editor via the marker. In case of a
	 * diagram editor for example these objects could be focused after the
	 * diagram is opened. To retrieve the list of secondary object mris use
	 * method {@link #getSecondaryObjectMris(IMarker)}.
	 * 
	 * @param obj
	 *            The object to be opened
	 * @param secondaryObjects
	 *            A list of sub objects to be focued inside the editor, might be
	 *            null
	 * @param markerType
	 *            The marker type
	 * @param severity
	 *            The marker severity
	 * @param message
	 *            The marker message
	 * @return The newly created marker
	 * @see #getSecondaryObjectMris(IMarker)
	 */
	public IMarker createMarker(RefBaseObject obj, Set<RefBaseObject> secondaryObjects, String markerType, int severity, String message) {
		Map<String, Object> attributes = null;
		if (secondaryObjects != null) {
			attributes = new HashMap<String, Object>();
			addSecondaryObjectMris(secondaryObjects, attributes);
		}
		IMarker marker = createMarker(obj, markerType, severity, message, attributes);
		return marker;
	}

	/**
	 * Removes all markers for a given partition in the given project
	 * 
	 * @param partition
	 *            The current partition
	 * @param connection
	 *            The current connection
	 * @param type
	 *            The marker type
	 * @param includeSubtypes
	 *            True, to include marker subtypes
	 * @param depth
	 *            The depth to be searched
	 * 
	 * @deprecated use
	 *             {@link #deleteMarkers(ModelPartition, String, boolean, int)}
	 *             instead
	 */
	@Deprecated
	public void deleteMarkers(ModelPartition partition, Connection connection, String type, boolean includeSubtypes, int depth) {
		deleteMarkers(partition, type, includeSubtypes, depth);
	}

	/**
	 * Removes all markers for a given partition in the given project
	 * 
	 * @param partition
	 *            The partition
	 * @param type
	 *            The marker type
	 * @param includeSubtypes
	 *            True, to include marker subtypes
	 * @param depth
	 *            The depth to be searched
	 * 
	 * @throws IllegalArgumentException
	 *             if any of the parameters is null
	 */
	public void deleteMarkers(ModelPartition partition, String type, boolean includeSubtypes, int depth) {
		if (partition == null) {
			throw new IllegalArgumentException("project must not be null");//$NON-NLS-1$
		}

		IFile markerFile = null;
		try {
			markerFile = ModelAdapter.getInstance().getFile(partition.getPri());
			markerFile.deleteMarkers(type, includeSubtypes, depth);
		} catch (Exception e) {
			sTracer.log(Level.SEVERE, "Marker file or markers could not be found. partition:" + partition + ", markerFile: "//$NON-NLS-1$ //$NON-NLS-2$
					+ markerFile, e);
		}
	}

	/**
	 * Removes all markers for a given object in the given project
	 * 
	 * @param obj
	 *            The object
	 * @param type
	 *            The marker type
	 * @param includeSubtypes
	 *            true to include marker subtypes
	 * @param depth
	 *            The depth to be searched
	 * 
	 * @throws IllegalArgumentException
	 *             if any of the parameters is null
	 */
	public void deleteMarkers(RefBaseObject obj, final String type, final boolean includeSubtypes, int depth) {
		if (obj == null) {
			throw new IllegalArgumentException("obj must not be null");//$NON-NLS-1$
		}

		final IMarker[] markers = findMarkers(obj, type, includeSubtypes, depth);

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IResourceRuleFactory ruleFactory = workspace.getRuleFactory();

		Set<ISchedulingRule> rules = new HashSet<ISchedulingRule>(1);
		for (IMarker marker : markers) {
			IFile partFile = (IFile) marker.getResource();
			ISchedulingRule rule = ruleFactory.markerRule(partFile);
			if (rule != null) {
				// markerRule returns null (not implemented yet?), so this code
				// should also work once markerRule returns != null
				rules.add(rule);
			}
		}
		IWorkspaceRunnable operation = new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				for (IMarker marker : markers) {
					if (marker.exists()) {
						try {
							marker.delete();
						} catch (CoreException e) {
							sTracer.logp(Level.SEVERE, MarkerManager.class.getName(), "run", "Marker could not be deleted", e);//$NON-NLS-1$ //$NON-NLS-2$
						}
					}
				}
			}
		};

		MultiRule multiRule = new MultiRule(rules.toArray(new ISchedulingRule[rules.size()]));
		try {
			workspace.run(operation, multiRule, IWorkspace.AVOID_UPDATE, null);
		} catch (OperationCanceledException e) {
			// $JL-EXC$
			// do nothing if user or eclipse cancels
			sTracer.fine("Operation canceled");//$NON-NLS-1$
		} catch (CoreException e) {
			sTracer.log(Level.SEVERE, "Not all markers could not be deleted", e);//$NON-NLS-1$
		}
	}

	/**
	 * Removes the given marker
	 * 
	 * @param marker
	 * @throws IllegalArgumentException
	 *             if the parameter is null
	 */
	public void deleteMarker(IMarker marker) {
		if (marker == null) {
			throw new IllegalArgumentException("marker must not be null");//$NON-NLS-1$
		}
		try {
			marker.delete();
		} catch (Exception e) {
			sTracer.log(Level.SEVERE, "Marker could not be removed. marker:" + marker, e);//$NON-NLS-1$
		}
	}

	/**
	 * Retrieves all markers for a given mri in a given connection. Note that
	 * this method does not load the object associated with the given mri. As a
	 * consequence, the composite tree cannot be traversed and therefore this
	 * method has no <code>depth</code> parameter.
	 * 
	 * @param mri
	 *            the current mri
	 * @param connection
	 *            the current active connection
	 * @param type
	 *            the marker type
	 * @param includeSubtypes
	 *            if true, also sub types of the given marker type are found
	 * @return an marker array - can be empty but will never by null
	 * @deprecated use {@link #findMarkers(MRI, String, boolean)} instead
	 */
	@Deprecated
	public IMarker[] findMarkers(MRI mri, Connection connection, String type, boolean includeSubtypes) {
		return findMarkers(mri, type, includeSubtypes);
	}

	/**
	 * Retrieves all markers for a given mri in a given connection. Note that
	 * this method does not load the object associated with the given mri. As a
	 * consequence, the composite tree cannot be traversed and therefore this
	 * method has no <code>depth</code> parameter.
	 * 
	 * @param mri
	 *            the current mri
	 * @param type
	 *            the marker type
	 * @param includeSubtypes
	 *            if true, also sub types of the given marker type are found
	 * @return an marker array - can be empty but will never by null
	 */
	public IMarker[] findMarkers(MRI mri, String type, boolean includeSubtypes) {
		IMarker[] markers = markerCache.getMarkers(mri);
		if (type == null || markers.length == 0) {
			return markers;
		}

		Set<IMarker> result = new HashSet<IMarker>();
		for (IMarker marker : markers) {
			try {
				if (marker.exists()) {
					if (marker.getType().equals(type) || (includeSubtypes && marker.isSubtypeOf(type))) {
						result.add(marker);
					}
				}
			} catch (CoreException e) {
				sTracer.logp(Level.SEVERE, MarkerManager.class.getName(), "findMarkers", "Marker info could not be read", e);//$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return result.toArray(new IMarker[result.size()]);
	}

	/**
	 * Returns all markers for a given object in the given project or an empty
	 * array if no marker exist. The depth parameter
	 * {@link IResource#DEPTH_INFINITE} should be used with care since it will
	 * trigger a recursive traversal of the <b>complete</b> composition tree
	 * with the given objects as the root. This also implies that all objects
	 * will be loaded into memory.
	 * 
	 * @param obj
	 *            The given object
	 * @param type
	 *            Marker type
	 * @param includeSubtypes
	 *            Include marker subtypes
	 * @param depth
	 *            Search depth for composite associations. This parameter
	 *            accepts the values {@link IResource#DEPTH_ZERO},
	 *            {@link IResource#DEPTH_ONE}, and
	 *            {@link IResource#DEPTH_INFINITE}.
	 * @return An array with all markers. Array might be empty but never null.
	 * @throws IllegalArgumentException
	 *             if obj parameter is null
	 * @see IResource#findMarkers(String, boolean, int)
	 * @see IResource#DEPTH_ZERO
	 * @see IResource#DEPTH_ONE
	 * @see IResource#DEPTH_INFINITE
	 */
	public IMarker[] findMarkers(RefBaseObject obj, String type, boolean includeSubtypes, int depth) {
		if (obj == null) {
			throw new IllegalArgumentException("Obj parameter must not be null");//$NON-NLS-1$
		}
		if (IResource.DEPTH_ZERO == depth) {
			MRI mri = ((Partitionable) obj).get___Mri();
			return findMarkers(mri, type, includeSubtypes);
		} else {
			return findMarkersInfinite(obj, type, includeSubtypes, depth);
		}
	}

	/**
	 * 
	 */
	private IMarker[] findMarkersInfinite(RefBaseObject obj, String type, boolean includeSubtypes, int depth) {

		Connection connection = ((Partitionable) obj).get___Connection();
		if (!connection.isAlive()) {
			sTracer.logp(Level.SEVERE, MarkerManager.class.getName(), "findMarkersInfinite", "Connection not alive:" + connection); //$NON-NLS-1$ //$NON-NLS-2$
			return null;
		}

		boolean infinite = (depth == IResource.DEPTH_INFINITE);
		Collection<RefObject> compositeChildren = null;
		try {
			compositeChildren = connection.getJmiHelper().getCompositeChildren((RefObject) obj, infinite);
		} catch (Exception e) {
			compositeChildren = new HashSet<RefObject>(1);
		}
		compositeChildren.add((RefObject) obj);

		Set<IMarker> result = new HashSet<IMarker>();
		for (RefObject refObj : compositeChildren) {
			MRI mri = ((Partitionable) refObj).get___Mri();
			IMarker[] childMarkers = findMarkers(mri, type, includeSubtypes);
			for (IMarker marker : childMarkers) {
				result.add(marker);
			}
		}

		return result.toArray(new IMarker[result.size()]);
	}

	/**
	 * Returns all markers for a given object in the given project or an empty
	 * array if no marker exist
	 * 
	 * @param partition
	 *            The given partition
	 * @param connection
	 *            TODO
	 * @param type
	 *            Marker type
	 * @param includeSubtypes
	 *            Include marker subtypes
	 * @param depth
	 *            Search depth for composite associations - not yet supported
	 * @return An array with all markers. Array might be empty.
	 * @throws IllegalArgumentException
	 *             if partition parameters is null
	 * @see IResource#findMarkers(String, boolean, int)
	 * @deprecated use
	 *             {@link #findMarkers(ModelPartition, String, boolean, int)}
	 *             instead
	 */
	@Deprecated
	public IMarker[] findMarkers(ModelPartition partition, Connection connection, String type, boolean includeSubtypes, int depth) {
		return findMarkers(partition, type, includeSubtypes, depth);
	}

	/**
	 * Returns all markers for a given object in the given project or an empty
	 * array if no marker exist
	 * 
	 * @param partition
	 *            The given partition
	 * @param type
	 *            Marker type
	 * @param includeSubtypes
	 *            Include marker subtypes
	 * @param depth
	 *            Search depth for composite associations - not yet supported
	 * @return An array with all markers. Array might be empty.
	 * @throws IllegalArgumentException
	 *             if partition parameters is null
	 * @see IResource#findMarkers(String, boolean, int)
	 */
	public IMarker[] findMarkers(ModelPartition partition, String type, boolean includeSubtypes, int depth) {
		if (partition == null) {
			throw new IllegalArgumentException("partition must not be null");//$NON-NLS-1$
		}
		PRI pri = partition.getPri();
		IMarker[] markers = markerCache.getMarkers(pri);
		if (type == null || markers.length == 0) {
			return markers;
		}

		Set<IMarker> result = new HashSet<IMarker>();
		for (IMarker marker : markers) {
			try {
				if (marker.exists()) {
					if (marker.getType().equals(type) || (includeSubtypes && marker.isSubtypeOf(type))) {
						result.add(marker);
					}
				}
			} catch (CoreException e) {
				sTracer.logp(Level.SEVERE, MarkerManager.class.getName(), "findMarkers", "Marker info could not be read", e);//$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return result.toArray(new IMarker[result.size()]);
	}

	/**
	 * Returns the maximum value of the {@link IMarker#SEVERITY} attribute
	 * across markers of the specified type on this model element, and,
	 * optionally, on its children. If <code>includeSubtypes</code>is
	 * <code>false</code>, only markers whose type exactly matches the given
	 * type are considered. Returns <code>-1</code> if there are no matching
	 * markers. Returns {@link IMarker#SEVERITY_ERROR} if any of the markers has
	 * a severity greater than or equal to {@link IMarker#SEVERITY_ERROR}.
	 * 
	 * @param obj
	 *            the model element to be searched
	 * @param type
	 *            the type of marker to consider (normally
	 *            {@link IMarker#PROBLEM} or one of its subtypes), or
	 *            <code>null</code> to indicate all types
	 * @param includeSubtypes
	 *            whether or not to consider sub-types of the given type
	 * @param depth
	 *            how far to recurse (see <code>IResource.DEPTH_* </code>)
	 * @return {@link IMarker#SEVERITY_INFO}, {@link IMarker#SEVERITY_WARNING},
	 *         {@link IMarker#SEVERITY_ERROR}, or -1
	 * @see IResource#DEPTH_ZERO
	 * @see IResource#DEPTH_ONE
	 * @see IResource#DEPTH_INFINITE
	 */
	public int findMaxProblemSeverity(RefBaseObject obj, String type, boolean includeSubtypes, int depth) {
		if (obj == null) {
			throw new IllegalArgumentException("Obj parameter must not be null");//$NON-NLS-1$
		}

		// object already deleted
		if (!obj.is___Alive()) {
			return -1;
		}

		Connection connection = obj.get___Connection();
		Collection<RefObject> compositeChildren = null;
		RefObject root = (RefObject) obj;

		if (depth != IResource.DEPTH_ZERO) {
			boolean infinite = (depth == IResource.DEPTH_INFINITE);
			try {
				compositeChildren = connection.getJmiHelper().getCompositeChildren(root, infinite);
			} catch (Exception e) {
				sTracer.logp(Level.SEVERE, MarkerManager.class.getName(), "findMaxProblemSeverity", "could not retrieve composite children", //$NON-NLS-1$ //$NON-NLS-2$
						e);
			}
		}

		int maxSeverity = -1;

		MRI mri = obj.get___Mri();
		IMarker[] markers = findMarkers(mri, type, includeSubtypes);
		for (IMarker marker : markers) {
			if (marker.exists()) {
				int currentSeverity = marker.getAttribute(IMarker.SEVERITY, -1);
				if (currentSeverity == IMarker.SEVERITY_ERROR) {
					return IMarker.SEVERITY_ERROR;
				} else {
					if (maxSeverity < currentSeverity) {
						maxSeverity = currentSeverity;
					}
				}
			}
		}

		if (compositeChildren != null) {
			for (RefObject currentObj : compositeChildren) {
				mri = ((Partitionable) currentObj).get___Mri();
				markers = findMarkers(mri, type, includeSubtypes);
				for (IMarker marker2 : markers) {
					if (marker2.exists()) {
						int currentSeverity = marker2.getAttribute(IMarker.SEVERITY, -1);
						if (currentSeverity == IMarker.SEVERITY_ERROR) {
							return IMarker.SEVERITY_ERROR;
						}
						if (maxSeverity < currentSeverity) {
							maxSeverity = currentSeverity;
						}
					}
				}
			}
		}
		return maxSeverity;
	}

	/**
	 * Extracts a RefBaseObject from a given marker.
	 * 
	 * @param connection
	 *            The current connection
	 * @param marker
	 *            The current marker
	 * @return The RefBaseObject or <code>null</code> if marker contains no
	 *         object
	 * @throws IllegalArgumentException
	 *             if any of the parameters is null
	 */
	public RefBaseObject getObject(Connection connection, IMarker marker) {
		// according to javadoc IMarker must not be implemented by developers
		// so using own class which uses adaption is not possible
		if (connection == null) {
			throw new IllegalArgumentException("Connection must not be null");//$NON-NLS-1$
		}
		if (marker == null) {
			throw new IllegalArgumentException("Marker must not be null");//$NON-NLS-1$
		}
		String mriString = null;
		MRI mri = null;
		RefBaseObject obj = null;
		try {
			mriString = marker.getAttribute(ATTRIBUTE_OBJ_MRI, null);
			if (mriString != null) {
				mri = ModelManager.getInstance().getMoinInstance().createMri(mriString);
				obj = connection.getElement(mri);
			}
		} catch (Exception e) {
			sTracer.log(Level.SEVERE, "General exception. marker:" + marker + ", connection:" + connection + ", mriString:"//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					+ mriString + ", mri:" + mri, e);//$NON-NLS-1$
		}
		return obj;
	}

	/**
	 * Creates and returns the singleton instance
	 * 
	 * @return The singleton instance
	 */
	public static synchronized MarkerManager getInstance() {
		if (sInstance == null) {
			sInstance = new MarkerManager();
		}
		return sInstance;
	}

	/**
	 * Returns secondary objects from this marker
	 * 
	 * @param marker
	 *            The current marker
	 * @return The secondary objects or an empty array if no markers exist
	 */
	public String[] getSecondaryObjectMris(IMarker marker) {
		Map attributes;
		try {
			attributes = marker.getAttributes();
		} catch (CoreException e) {
			sTracer.log(Level.SEVERE, e.getMessage(), e);
			return new String[0];
		}
		int i = 0;
		List<String> result = new ArrayList<String>();
		String mri = (String) attributes.get(ATTRIBUTE_SEC_OBJ_PREFIX + i);
		while (mri != null) {
			result.add(mri);
			i = i + 1;
			mri = (String) attributes.get(ATTRIBUTE_SEC_OBJ_PREFIX + i);
		}
		return result.toArray(new String[result.size()]);
	}

	private void addSecondaryObjectMris(Set<RefBaseObject> secObjs, Map<String, Object> attributes) {
		int i = 0;
		for (RefBaseObject object : secObjs) {
			attributes.put(ATTRIBUTE_SEC_OBJ_PREFIX + i, ((Partitionable) object).get___Mri().toString());
			i = i + 1;
		}
		return;
	}

	/**
	 * Hide constructor
	 */
	private MarkerManager() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
		if (JMX_ENABLED) {
			try {
				mBean = new MarkerManagerMBeanImpl();
				mBeanName = mBean.getObjectName();
			} catch (Exception e) { // $JL-EXC$
				sTracer.logp(Level.SEVERE, MarkerManager.class.getName(), "Constructor", "MBean not initialized", e);//$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}

	/**
	 * For internal use only
	 */
	void dispose() {
		clearListeners();
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		if (JMX_ENABLED) {
			try {
				ManagementFactory.getPlatformMBeanServer().unregisterMBean(mBeanName);
			} catch (Exception e) {
				sTracer.log(Level.SEVERE, "MBean not unregistered", e);//$NON-NLS-1$
			}
		}
		markerCache.clear();
		sInstance = null;
	}

	// used for testing
	@SuppressWarnings("unused")
	private final MarkerManagerMBean getBean() {
		return mBean;
	}

	/**
	 * Removes markers if element has been deleted
	 */
	private final class PartitionListener implements UpdateListener {

		public void notifyUpdate(EventChain events) {
			List<ChangeEvent> eventList = events.getEvents();
			for (ChangeEvent event : eventList) {
				if (event instanceof PartitionDeleteEvent) {
					PartitionChangeEvent pEvent = (PartitionChangeEvent) event;
					PRI pri = pEvent.getAffectedPartitionPri();
					markerCache.removeMarkers(pri);
					return;
				}

				if (event instanceof PartitionSaveEvent || event instanceof PartitionContentChangeEvent) {

					PartitionChangeEvent pEvent = (PartitionChangeEvent) event;
					final Connection con = pEvent.getEventTriggerConnection();
					final PRI pri = pEvent.getAffectedPartitionPri();
					final MRI[] mris = markerCache.getMRIs(pri);
					if (mris.length > 0) {
						IWorkspaceRunnable operation = new IWorkspaceRunnable() {
							public void run(IProgressMonitor monitor) throws CoreException {
								for (MRI mri : mris) {
									if (!con.elementExists(mri)) {
										// mri does not exist so delete
										// the marker
										IMarker[] markers = markerCache.getMarkers(mri);
										for (IMarker marker : markers) {
											if (marker.exists()) {
												marker.delete();
											}
										}
										// could be left upto resourceChange
										// listener
										markerCache.removeMarkers(mri);
									}
								}
							}
						};

						IWorkspace workspace = ResourcesPlugin.getWorkspace();
						IResourceRuleFactory ruleFactory = workspace.getRuleFactory();
						IFile partFile = ModelAdapter.getInstance().getFile(pEvent.getAffectedPartitionPri());
						ISchedulingRule rule = ruleFactory.markerRule(partFile);

						try {
							workspace.run(operation, rule, IWorkspace.AVOID_UPDATE, null);
						} catch (OperationCanceledException e) {
							// $JL-EXC$
							// do nothing if user or eclipse cancels
							sTracer.fine("Operation canceled");//$NON-NLS-1$
						} catch (Exception e) {
							sTracer.log(Level.SEVERE, "Markers could not be deleted", e);//$NON-NLS-1$
						}
					}
				}
			}
		}
	}

	private static final class MarkerManagerMBeanImpl extends StandardMBean implements MarkerManagerMBean {
		private final ObjectName mBeanName;

		/**
		 * JMX Bean constructor
		 * 
		 * @throws Exception
		 */
		public MarkerManagerMBeanImpl() throws Exception {
			super(MarkerManagerMBean.class);
			mBeanName = new ObjectName(JMX_NAME);
			ManagementFactory.getPlatformMBeanServer().registerMBean(this, mBeanName);
		}

		public ObjectName getObjectName() {
			return mBeanName;
		}

		public String[] getListeners() {
			Object[] listeners = MarkerManager.getInstance().getListeners();
			String[] result = new String[listeners.length];
			int i = 0;
			for (Object listener : listeners) {
				result[i] = listener.toString();
				i++;
			}
			return result;
		}

		public long getCacheHits() {
			return MarkerManager.getInstance().markerCache.hits;
		}

		public long getCacheMisses() {
			return MarkerManager.getInstance().markerCache.misses;
		}

		public void clearCache() {
			MarkerManager.getInstance().markerCache.clear();
		}

		public long getAdds() {
			return MarkerManager.getInstance().markerCache.adds;
		}

		public long getRemoves() {
			return MarkerManager.getInstance().markerCache.removes;
		}

		public long getPartitionCount() {
			return MarkerManager.getInstance().markerCache.markerCacheMap.size();
		}

		public long getTotalMarkerCount() {
			return MarkerManager.getInstance().markerCache.getTotalMarkerCount();
		}

		public long getTotalElementCount() {
			return MarkerManager.getInstance().markerCache.getTotalElementCount();
		}
	}

	/**
	 * Internal class. DO NOT USE
	 */
	private static final class MarkerCache {

		private static final MRI[] EMPTY_ARRAY = new MRI[0];

		// pri -> mri -> marker
		private final Map<PRI, Map<MRI, Set<IMarker>>> markerCacheMap = new HashMap<PRI, Map<MRI, Set<IMarker>>>(0);
		private long hits = 0;
		private long misses = 0;
		private long adds = 0;
		private long removes = 0;

		public final synchronized void clear() {
			markerCacheMap.clear();
			hits = 0;
			misses = 0;
			adds = 0;
			removes = 0;
		}

		private Map<MRI, Set<IMarker>> initCache(PRI pri, boolean forceInit) {

			Map<MRI, Set<IMarker>> mrisToMarkers = null;
			if (!forceInit) {
				mrisToMarkers = markerCacheMap.get(pri);
				if (mrisToMarkers != null) {
					if (sTracer.isLoggable(Level.FINE)) {
						sTracer.logp(Level.FINE, MarkerCache.class.getName(), "initCache", "cache hit:" + ModelManager.getInstance().getObjectName(pri)); //$NON-NLS-1$ //$NON-NLS-2$
					}
					hits++;
					return mrisToMarkers;
				}
			}

			long start = System.currentTimeMillis();
			misses++;
			markerCacheMap.remove(pri);
			mrisToMarkers = new HashMap<MRI, Set<IMarker>>(0);
			markerCacheMap.put(pri, mrisToMarkers);

			final IFile partFile = ModelAdapter.getInstance().getFile(pri);
			if (partFile != null && partFile.exists()) {
				IMarker[] markers = null;
				try {
					markers = partFile.findMarkers(null, true, IResource.DEPTH_INFINITE);
				} catch (CoreException e) {
					sTracer.logp(Level.SEVERE, MarkerCache.class.getName(), "initCache", "Markers not found", e);//$NON-NLS-1$ //$NON-NLS-2$
					return mrisToMarkers;
				}
				final Moin moin = ModelManager.getInstance().getMoinInstance();
				for (int i = 0; i < markers.length; i++) {
					if (markers[i].exists()) {
						String mriString = markers[i].getAttribute(ATTRIBUTE_OBJ_MRI, null);
						if (mriString != null) {
							MRI mri = moin.createMri(mriString);
							if (mri != null) {
								Set<IMarker> markerSet = mrisToMarkers.get(mri);
								if (markerSet == null) {
									markerSet = new HashSet<IMarker>();
									mrisToMarkers.put(mri, markerSet);
								}
								markerSet.add(markers[i]);
								adds++;
							}
						} else {
							if (sTracer.isLoggable(Level.FINE)) {
								sTracer.logp(Level.FINE, MarkerCache.class.getName(), "init", "Non MOIN marker found:" + markers[i]); //$NON-NLS-1$ //$NON-NLS-2$
							}
						}
					}
				}
			}

			if (sTracer.isLoggable(Level.FINE)) {
				long end = System.currentTimeMillis();
				sTracer.logp(Level.FINE, "MarkerManager", "initCache", "Cache initialized in " + (end - start) + "ms."); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			return mrisToMarkers;
		}

		public final synchronized long getTotalMarkerCount() {
			long result = 0;
			Collection<Map<MRI, Set<IMarker>>> values = markerCacheMap.values();
			for (Map<MRI, Set<IMarker>> value : values) {
				Collection<Set<IMarker>> markers = value.values();
				for (Set<IMarker> set : markers) {
					result = result + set.size();
				}
			}
			return result;
		}

		public final synchronized long getTotalElementCount() {
			long result = 0;
			Collection<Map<MRI, Set<IMarker>>> values = markerCacheMap.values();
			for (Map<MRI, Set<IMarker>> value : values) {
				result = result + value.size();
			}
			return result;
		}

		public final synchronized void addMarker(MRI mri, IMarker marker) {
			PRI pri = mri.getPri();
			Map<MRI, Set<IMarker>> mrisToMarkers = initCache(pri, false);
			if (mrisToMarkers == null) {
				mrisToMarkers = new HashMap<MRI, Set<IMarker>>(0);
				markerCacheMap.put(pri, mrisToMarkers);
			}
			Set<IMarker> markers = mrisToMarkers.get(mri);
			if (markers == null) {
				markers = new HashSet<IMarker>();
				mrisToMarkers.put(mri, markers);
			}
			markers.add(marker);
			adds++;
		}

		public final synchronized IMarker[] getMarkers(PRI pri) {
			Map<MRI, Set<IMarker>> mrisToMarkers = initCache(pri, false);
			Set<IMarker> result = new HashSet<IMarker>();
			if (mrisToMarkers != null) {
				for (Map.Entry<MRI, Set<IMarker>> entry : mrisToMarkers.entrySet()) {
					result.addAll(entry.getValue());
				}
			}
			return result.toArray(new IMarker[result.size()]);
		}

		public final synchronized IMarker[] getMarkers(MRI mri) {
			PRI pri = mri.getPri();
			Map<MRI, Set<IMarker>> mrisToMarkers = initCache(pri, false);
			if (mrisToMarkers != null) {
				if (sTracer.isLoggable(Level.FINE)) {
					sTracer.logp(Level.FINE, "MarkerCache", "getMarkers", "cache hit. pri:" + pri + ", mri:" + mri);//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				}
				Set<IMarker> set = mrisToMarkers.get(mri);
				if (set != null) {
					return set.toArray(new IMarker[set.size()]);
				}
			}
			return MarkerManager.EMPTY_ARRAY;
		}

		public final synchronized MRI[] getMRIs(PRI pri) {
			Map<MRI, Set<IMarker>> mrisToMarkers = initCache(pri, false);
			if (mrisToMarkers != null) {
				Set<MRI> mris = mrisToMarkers.keySet();
				if (mris != null) {
					return mris.toArray(new MRI[mris.size()]);
				}
			}
			return EMPTY_ARRAY;
		}

		public final synchronized void removeMarkers(MRI mri) {
			PRI pri = mri.getPri();
			Map<MRI, Set<IMarker>> mrisToMarkers = initCache(pri, false);
			if (mrisToMarkers != null) {
				mrisToMarkers.remove(mri);
				// if (mrisToMarkers.size() == 0) {
				// markerCacheMap.remove(pri);
				// }
				removes++;
			}
		}

		public final synchronized void removeMarkers(PRI pri) {
			markerCacheMap.remove(pri);
			removes++;
		}

		public final synchronized void removeMarker(MRI mri, IMarker marker) {
			PRI pri = mri.getPri();
			Map<MRI, Set<IMarker>> mrisToMarkers = markerCacheMap.get(pri);
			if (mrisToMarkers != null) {
				Set<IMarker> markers = mrisToMarkers.get(mri);
				if (markers != null) {
					markers.remove(marker);
					if (markers.size() == 0) {
						mrisToMarkers.remove(mri);
						// if (mrisToMarkers.size() == 0) {
						// markerCacheMap.remove(pri);
						// }
					}
					removes++;
				}
			}
		}
	}
}
