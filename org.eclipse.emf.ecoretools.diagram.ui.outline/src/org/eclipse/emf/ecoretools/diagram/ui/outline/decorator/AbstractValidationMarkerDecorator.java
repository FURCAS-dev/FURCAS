/***********************************************************************
 * Copyright (c) 2007, 2008 Anyware Technologies and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 * 
 * $Id: AbstractValidationMarkerDecorator.java,v 1.1 2008/05/26 12:26:55 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.diagram.ui.outline.decorator;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.diagram.ui.outline.internal.Activator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.widgets.Display;

/**
 * This label decorator displays additional icons for errors and warnings from
 * EMF Validation Markers
 */
public abstract class AbstractValidationMarkerDecorator implements ILightweightLabelDecorator {

	/** Image Descriptor for the Error overall icon */
	protected static final ImageDescriptor ERROR;

	/** Image Descriptor for the Warning overall icon */
	protected static final ImageDescriptor WARNING;

	static {
		ERROR = Activator.getImageDescriptor("icons/ovr16/error_co.gif"); //$NON-NLS-1$
		WARNING = Activator.getImageDescriptor("icons/ovr16/warning_co.gif"); //$NON-NLS-1$
	}

	private IResourceChangeListener resourceListener;

	private ListenerList listeners;

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) {
		if (listeners == null) {
			listeners = new ListenerList();
		}
		listeners.add(listener);
		if (resourceListener == null) {
			resourceListener = new IResourceChangeListener() {

				public void resourceChanged(IResourceChangeEvent event) {
					handleResourceChanged(event);
				}
			};

			ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceListener);
		}
	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) {
		if (listeners != null) {
			listeners.remove(listener);
			if (listeners.isEmpty() && resourceListener != null) {
				ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceListener);
				resourceListener = null;
			}
		}
	}

	/**
	 * Handles the event from a resource modification.<br>
	 * Here handles modifications of markers.
	 * 
	 * @param event
	 *            the resource event
	 */
	private void handleResourceChanged(IResourceChangeEvent event) {
		IMarkerDelta[] markerDeltas = event.findMarkerDeltas(getMarkerReader().getMarkerType(), true);
		if (markerDeltas.length > 0) {
			if (Display.getCurrent() != Display.getDefault()) {
				asyncFireEObjectMarkerChanged();
			} else {
				fireEObjectMarkerChanged();
			}
		}
	}

	/**
	 * Send the events asynchronously
	 */
	private void asyncFireEObjectMarkerChanged() {
		Display.getDefault().asyncExec(new Runnable() {

			/**
			 * @see java.lang.Runnable#run()
			 */
			public void run() {
				fireEObjectMarkerChanged();
			}
		});
	}

	/**
	 * Send an event to the LabelProviderListeners
	 */
	private void fireEObjectMarkerChanged() {
		if (listeners != null && !listeners.isEmpty()) {
			LabelProviderChangedEvent event = new LabelProviderChangedEvent(this);
			Object[] listenersArray = listeners.getListeners();
			for (int i = 0; i < listenersArray.length; i++) {
				((ILabelProviderListener) listenersArray[i]).labelProviderChanged(event);
			}
		}
	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {
		if (resourceListener != null) {
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceListener);
			resourceListener = null;
		}
	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object,
	 *      java.lang.String)
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/**
	 * @see org.eclipse.jface.viewers.ILightweightLabelDecorator#decorate(java.lang.Object,
	 *      org.eclipse.jface.viewers.IDecoration)
	 */
	public void decorate(Object element, IDecoration decoration) {
		if (!(element instanceof EObject)) {
			return;
		}

		EObject object = (EObject) element;

		if (object.eResource() != null) {
			IStatus status = getMarkerReader().getStatus(object);
			if (status.matches(IStatus.ERROR)) {
				decoration.addOverlay(getErrorImageDescriptor());
			} else if (status.matches(IStatus.WARNING)) {
				decoration.addOverlay(getWarningImageDescriptor());
			}
		}
	}

	private IMarkerReader markerReader;

	/**
	 * Get the specific marker reader
	 * 
	 * @return the IMarkerReader
	 */
	protected IMarkerReader getMarkerReader() {
		if (markerReader == null) {
			markerReader = createMarkerReader();
		}
		return markerReader;
	}

	/**
	 * Must be implemented to create the specific marker reader
	 * 
	 * @return the IMarkerReader
	 */
	protected abstract IMarkerReader createMarkerReader();

	/**
	 * The image descriptor of the error decoration
	 * 
	 * @return the ImageDescriptor of the error decoration
	 */
	protected ImageDescriptor getErrorImageDescriptor() {
		return ERROR;
	}

	/**
	 * The image descriptor of the warning decoration
	 * 
	 * @return the ImageDescriptor of the warning decoration
	 */
	protected ImageDescriptor getWarningImageDescriptor() {
		return WARNING;
	}
}
