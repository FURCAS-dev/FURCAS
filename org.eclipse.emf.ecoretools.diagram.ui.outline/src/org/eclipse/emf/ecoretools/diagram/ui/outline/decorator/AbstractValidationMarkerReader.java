/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 * 
 * $Id: AbstractValidationMarkerReader.java,v 1.1 2008/05/26 12:26:55 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.ui.outline.decorator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecoretools.diagram.ui.outline.internal.Activator;
import org.eclipse.emf.ecoretools.diagram.ui.outline.internal.Messages;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;

/**
 * This class find the validation markers and return a multiple status
 * containing all the messages
 */
public abstract class AbstractValidationMarkerReader implements IMarkerReader {

	/**
	 * @see org.eclipse.emf.ecoretools.diagram.ui.outline.decorator.IMarkerReader#getStatus(org.eclipse.emf.ecore.EObject)
	 */
	public IStatus getStatus(EObject object) {
		MultiStatus status = new MultiStatus(Activator.PLUGIN_ID, IStatus.OK, Messages.AbstractValidationMarkerReader_ValidationProblems, null);

		IMarker[] markers = getMarkers(object);
		for (int i = 0; i < markers.length; i++) {
			IMarker marker = markers[i];
			IStatus markerStatus = getStatusForMarker(marker);
			if (markerStatus != null) {
				status.add(markerStatus);
			}
		}

		return status;
	}

	/**
	 * Returns the markers associated with the given EObject
	 * 
	 * @param object
	 *            the EObject
	 * @return the list of markers
	 */
	private IMarker[] getMarkers(EObject object) {
		List<IMarker> markerList = new ArrayList<IMarker>();
		ResourceSet set = object.eResource().getResourceSet();

		if (set != null) {
			List<Resource> copiedResources = new ArrayList<Resource>(set.getResources());
			for (Resource res : copiedResources) {
				IFile file = getFile(res);
				if (file != null) {
					String objectLocation = EMFCoreUtil.getQualifiedName(object, true);
					try {
						IMarker[] markers = file.findMarkers(getMarkerType(), true, IResource.DEPTH_ZERO);
						for (int i = 0; i < markers.length; i++) {
							IMarker marker = markers[i];

							String locationAttribute = (String) marker.getAttribute(IMarker.LOCATION);
							// This is a marker for this object
							if (locationAttribute != null && locationAttribute.equals(objectLocation)) {
								markerList.add(marker);
							}
							// Bug #216296 : Marker decorators should be present
							// in the parent hierarchy too
							else if (locationAttribute != null && locationAttribute.startsWith(objectLocation)) {
								markerList.add(marker);
							}
						}
					} catch (CoreException ce) {
						// Ignore bad files
					}
				}
			}
		}

		return markerList.toArray(new IMarker[markerList.size()]);
	}

	/**
	 * Transform a marker into an IStatus
	 * 
	 * @param marker
	 *            The EMF marker
	 * @return the IStatus or <code>null</code> if no marker is found
	 */
	private IStatus getStatusForMarker(IMarker marker) {
		IStatus result = null;
		try {
			Object severityAttribute = marker.getAttribute(IMarker.SEVERITY);
			String message = (String) marker.getAttribute(IMarker.MESSAGE);
			if (severityAttribute != null && severityAttribute instanceof Integer) {
				if (((Integer) severityAttribute).intValue() == IMarker.SEVERITY_ERROR) {
					result = new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.OK, message, null);
				} else if (((Integer) severityAttribute).intValue() == IMarker.SEVERITY_WARNING) {
					result = new Status(IStatus.WARNING, Activator.PLUGIN_ID, IStatus.OK, message, null);
				}
			}
		} catch (CoreException ce) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.AbstractValidationMarkerReader_MarkerNotExist, ce));
		}

		return result;
	}

	/**
	 * Return the IFile associated with the given resource
	 * 
	 * @param resource
	 *            the EMF resource
	 * @return the containing IFile or <code>null</code> if the resource is
	 *         not an IFile
	 */
	private IFile getFile(Resource resource) {
		URI uri = resource.getURI();
		uri = resource.getResourceSet().getURIConverter().normalize(uri);
		String scheme = uri.scheme();
		if ("platform".equals(scheme) && uri.segmentCount() > 1 && "resource".equals(uri.segment(0))) { //$NON-NLS-1$ //$NON-NLS-2$
			StringBuffer platformResourcePath = new StringBuffer();
			for (int j = 1; j < uri.segmentCount(); ++j) {
				platformResourcePath.append('/');
				platformResourcePath.append(uri.segment(j));
			}
			return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformResourcePath.toString()));
		}
		return null;
	}
}
