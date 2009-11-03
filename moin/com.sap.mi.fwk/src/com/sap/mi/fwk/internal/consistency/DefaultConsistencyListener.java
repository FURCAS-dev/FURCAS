package com.sap.mi.fwk.internal.consistency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.sap.mi.fwk.MarkerManager;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.consistency.ConsistencyCorrectionHandle;
import com.sap.tc.moin.repository.consistency.ConsistencyListener;
import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.consistency.DanglingLinkConsistencyViolation;
import com.sap.tc.moin.repository.consistency.DuplicateElementConsistencyViolation;
import com.sap.tc.moin.repository.consistency.DuplicateParentConsistencyViolation;
import com.sap.tc.moin.repository.consistency.LinkPermissionConsistencyViolation;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * Default listener for model inconsistencies.
 * <p>
 * <b>Not intended to be used by clients.</b>
 * 
 * @author d024127
 */
public final class DefaultConsistencyListener implements ConsistencyListener {

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_CONSISTENCY);

	private static final String ATTR_VIOLATION_ID = DefaultConsistencyListener.class.getName() + "violationid"; //$NON-NLS-1$
	private static final String ATTR_RESOLUTION_ID = DefaultConsistencyListener.class.getName() + "resolutionid"; //$NON-NLS-1$
	private static final String ATTR_DESCRIPTION = DefaultConsistencyListener.class.getName() + "description"; //$NON-NLS-1$

	/**
	 * The marker type this listerner is using
	 */
	public static final String MARKER_TYPE = "com.sap.mi.fwk.consistencyviolationmarker"; //$NON-NLS-1$

	public void onConsistencyResolution(final ConsistencyViolation[] consistencyViolations, final Connection conn) {

		if (!conn.isAlive()) {
			return;
		}
		// TODO optimize !!!! two nested loops
		final IWorkspaceRunnable operation = new IWorkspaceRunnable() {

			public void run(final IProgressMonitor monitor) throws CoreException {

				for (final ConsistencyViolation consistencyViolation : consistencyViolations) {
					final MRI mri = consistencyViolation.getAffectedElement();
					final RefBaseObject refObj = conn.getElement(mri);
					IMarker[] markers = null;
					if (refObj != null) {
						markers = ModelManager.getMarkerManager().findMarkers(refObj, DefaultConsistencyListener.MARKER_TYPE, false,
								IResource.DEPTH_ZERO);
					} else {
						// element already deleted
						markers = ModelManager.getMarkerManager().findMarkers(mri, DefaultConsistencyListener.MARKER_TYPE, false);
					}

					for (final IMarker marker : markers) {
						final String violationID = marker.getAttribute(DefaultConsistencyListener.ATTR_VIOLATION_ID, null);
						if (violationID != null && violationID.equals(consistencyViolation.getId())) {
							MarkerManager.getInstance().deleteMarker(marker);
							// return immediately???
						}
					}
				}
			}
		};

		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		try {
			workspace.run(operation, null);
		} catch (final CoreException e) {
			DefaultConsistencyListener.sTracer.error("Markers could not be deleted", e); //$NON-NLS-1$
		}
	}

	public void onConsistencyViolation(final ConsistencyViolation[] consistencyViolation, final Connection conn) {

		if (!conn.isAlive()) {
			return;
		}

		final MarkerManager mm = ModelManager.getMarkerManager();
		final Map<String, Object> attributes = new HashMap<String, Object>();

		final IWorkspaceRunnable operation = new IWorkspaceRunnable() {

			public void run(final IProgressMonitor monitor) throws CoreException {

				for (final ConsistencyViolation cv : consistencyViolation) {
					int i = 0;
					attributes.clear();
					final RefBaseObject refObj = conn.getElement(cv.getAffectedElement());
					if (refObj != null) {
						final String currentViolationID = cv.getId();
						if (!markerExists(refObj, currentViolationID)) {
							attributes.put(DefaultConsistencyListener.ATTR_VIOLATION_ID, currentViolationID);
							if (cv instanceof DuplicateElementConsistencyViolation) {
								attributes.put("com.sap.mi.fwk.violationType", "DuplicateElementConsistencyViolation"); //$NON-NLS-1$ //$NON-NLS-2$
							} else if (cv instanceof DanglingLinkConsistencyViolation) {
								attributes.put("com.sap.mi.fwk.violationType", "DanglingLinkConsistencyViolation"); //$NON-NLS-1$ //$NON-NLS-2$
							} else if (cv instanceof DuplicateParentConsistencyViolation) {
								attributes.put("com.sap.mi.fwk.violationType", "DuplicateParentConsistencyViolation"); //$NON-NLS-1$ //$NON-NLS-2$
							} else if (cv instanceof LinkPermissionConsistencyViolation) {
								attributes.put("com.sap.mi.fwk.violationType", "LinkPermissionConsistencyViolation"); //$NON-NLS-1$ //$NON-NLS-2$
							}

							final ConsistencyCorrectionHandle[] correctionHandles = cv.getCorrectionHandles(conn);
							for (final ConsistencyCorrectionHandle consistencyCorrectionHandle : correctionHandles) {
								attributes.put(DefaultConsistencyListener.ATTR_RESOLUTION_ID + i, consistencyCorrectionHandle.getId());
								attributes.put(DefaultConsistencyListener.ATTR_DESCRIPTION + i, consistencyCorrectionHandle.getDescription());
								i++;
							}
							mm.createMarker(refObj, DefaultConsistencyListener.MARKER_TYPE, IMarker.SEVERITY_ERROR, cv.getDescription(conn),
									attributes);
						}
					}
				}
			}
		};

		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		try {
			workspace.run(operation, null);
		} catch (final CoreException e) {
			DefaultConsistencyListener.sTracer.error("Markers could not be created", e); //$NON-NLS-1$
		}
	}

	// ------------------------------------------------------------------------------------------------------------------------------

	private boolean markerExists(final RefBaseObject obj, final String violationID) {

		final IMarker[] markers = MarkerManager.getInstance().findMarkers(obj, DefaultConsistencyListener.MARKER_TYPE, false, IResource.DEPTH_ZERO);
		for (final IMarker marker : markers) {
			final String vId = marker.getAttribute(DefaultConsistencyListener.ATTR_VIOLATION_ID, null);
			if (violationID.equals(vId)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Retrieves the violation id from a given marker
	 * 
	 * @param marker
	 *            The current marker
	 * @return The violation id or null if marker contains no violation id
	 */
	public static final String getViolationID(final IMarker marker) {

		return marker.getAttribute(DefaultConsistencyListener.ATTR_VIOLATION_ID, null);
	}

	/**
	 * Extracts correction handles from a given marker
	 * 
	 * @param marker
	 *            The current marker
	 * @return The correction handles or an empty array if marker contains no
	 *         handles
	 */
	public static final ConsistencyCorrectionHandle[] getHandles(final IMarker marker) {

		int i = 0;
		final List<ConsistencyCorrectionHandle> handles = new ArrayList<ConsistencyCorrectionHandle>();
		String id = marker.getAttribute(DefaultConsistencyListener.ATTR_RESOLUTION_ID + i, null);
		String desc = null;
		while (id != null) {
			desc = marker.getAttribute(DefaultConsistencyListener.ATTR_DESCRIPTION + i, null);
			handles.add(new DefaultCCHnd(id, desc));
			i++;
			id = marker.getAttribute(DefaultConsistencyListener.ATTR_RESOLUTION_ID + i, null);
		}
		return handles.toArray(new ConsistencyCorrectionHandle[handles.size()]);
	}

	/**
	 * Inner class representing a correction handle stored in a marker. DO NOT USE
	 */
	private static final class DefaultCCHnd implements ConsistencyCorrectionHandle {

		private final String id;

		private final String desc;

		public DefaultCCHnd(final String id, final String desc) {

			this.id = id;
			this.desc = desc;
		}

		public String getDescription() {

			return this.desc;
		}

		public String getId() {

			return this.id;
		}
	}
}