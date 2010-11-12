/*******************************************************************************
 * Copyright (c) 2005,2010 Eclipse Modeling Project.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.editor.ui.common;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.common.label.Label;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.common.utils.TracingAdapter;
import org.eclipse.ocl.examples.editor.ui.OCLExamplesEditorPlugin;

/**
 * ResourceAdapter extends Resource with externally imposed and internally chosen
 * read-only attributes..
 */
public abstract class ResourceAdapter extends TracingAdapter
{
	public static ResourceAdapter getAdapter(Resource resource, boolean isLocked) {
		if (resource == null)
			return null;
		ResourceAdapter resourceAdapter = EcoreUtils.getAdapter(resource, ResourceAdapter.class);
		if (resourceAdapter == null)
			resourceAdapter = new ResourceAdapterImpl(resource, isLocked);
		else if (resourceAdapter.isLocked() && !isLocked)
			resourceAdapter.setLocked(isLocked);
		return resourceAdapter;
	}
	
	public static ResourceAdapter getAdapter(Resource resource) {
		return getAdapter(resource, true);
	}

//	public static Orphanage getOrphanage(Object model) {
//		Resource resource = TreeAccessor.eResource(model);
//		ResourceAdapter adapter = getAdapter(resource);
//		return adapter != null ? adapter.getOrphanage() : null;
//	}

//	public static Orphanage getOrphanage(Resource resource) {
//		ResourceAdapter adapter = getAdapter(resource);
//		return adapter != null ? adapter.getOrphanage() : null;
//	}

	public static boolean isLocked(Resource resource) {
		ResourceAdapter adapter = getAdapter(resource);
		return adapter != null ? adapter.isLocked() : false;
	}

//	public static boolean isLocked(Object model) {
//		Resource resource = TreeAccessor.eResource(model);
//		ResourceAdapter adapter = getAdapter(resource);
//		return adapter != null ? adapter.isLocked() : false;
//	}

	public static boolean isReadOnly(Resource resource) {
		ResourceAdapter adapter = getAdapter(resource);
		return adapter != null ? adapter.isReadOnly() : false;
	}

//	public static boolean isReadOnly(Object model) {
//		Resource resource = TreeAccessor.eResource(model);
//		ResourceAdapter adapter = getAdapter(resource);
//		return adapter != null ? adapter.isReadOnly() : false;
//	}

	public static boolean isSaveable(Resource resource) {
		ResourceAdapter adapter = getAdapter(resource);
		return adapter != null ? adapter.isSaveable() : false;
	}

	public abstract boolean computeIsReadOnly();
	public void dispose() {}
//	public abstract Orphanage getOrphanage();	
	public abstract Resource getResource();
	public Resource getUnderlyingResource() {
		return getResource();
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == ResourceAdapter.class;
	}
	
	public abstract boolean isLocked();
	public abstract boolean isReadOnly();
	public abstract boolean isSaveable();
	public abstract void setLocked(boolean isLocked);
	public abstract void setReadOnly(boolean isReadOnly);

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[" + Label.labelFor(getResource()) + "]"
		+ (isReadOnly() ? " read-only" : " read-write")
		+ (isLocked() ? " locked" : " unlocked");
	}

	public static class ResourceAdapterImpl 
		extends ResourceAdapter
		implements IResourceChangeListener
	{
		private final Resource resource;
		private URI uri;					// may be null for a read-write test resource
		private String fileName;			// null if not a file
		private boolean isReadOnly;			// external resource constraint
		private boolean isLocked;			// internal user preference

//		private Orphanage orphanage = null;

		protected ResourceAdapterImpl(Resource resource, boolean isLocked) {
//			this.listener = this;
			this.resource = resource;
			resource.eAdapters().add(this);
			setURI(resource.getURI());			// Sets isReadOnly
			this.isLocked = isReadOnly || isLocked;
//			IWorkspace workspace = ResourcesPlugin.getWorkspace();
//			workspace.addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
		}

		@Override
		public boolean computeIsReadOnly() {
			if (uri == null)
				return false;
			try {
				URL url = new URL(uri.toString());
				URL resolvedURL = FileLocator.resolve(url);		// FIXME Use URI facilities to avoid loss of platform:
				String protocol = resolvedURL.getProtocol();
				if ("file".equals(protocol)) {
					fileName = resolvedURL.getFile();
					File file = new File(fileName);
					if (file.canWrite())
						return false;
				}
			} catch (MalformedURLException e) {
			} catch (IOException e) {
				OCLExamplesEditorPlugin.logError("Failed to access " + uri.toString(), e);
			}
			return true;
		}

		@Override
		public void dispose() {
//			IWorkspace workspace = ResourcesPlugin.getWorkspace();
//			workspace.removeResourceChangeListener(this);
		}

//		@Override
//		public Orphanage getOrphanage() {
//			if (orphanage == null)
//				orphanage = new Orphanage(resource);
//			return orphanage;
//		}
		
		@Override
		public Resource getResource() {
			return resource;
		}

		public URI getURI() {
			return uri;
		}
		
		@Override
		protected void handleNotification(Notification msg) {
			super.notifyChanged(msg);
			if (EcoreUtils.getFeatureID(msg, resource, Resource.class) == Resource.RESOURCE__ERRORS) {
				Object e = msg.getNewValue();
				OCLExamplesEditorPlugin.logError("Error in '" + resource.getURI() + "'",  e instanceof Throwable ? (Throwable)e : null);
			}
		}

		@Override
		public boolean isLocked() {
			return isLocked;
		}

		@Override
		public boolean isReadOnly() {
			return isReadOnly;
		}

		@Override
		public boolean isSaveable() {
			return true;
		}

		public void resourceChanged(IResourceChangeEvent event) {
			IResourceDelta resourceDelta = event.getDelta();
			if (resourceDelta != null)
				resourceChanged(resourceDelta);
		}

		public void resourceChanged(IResourceDelta resourceDelta) {
//			IPath location = resourceDelta.getFullPath();
//			String pathString = "" + location;
//			System.out.println("Resource changed : '" + pathString + "' wrt '" + fileName + "'");
			for (IResourceDelta childDelta : resourceDelta.getAffectedChildren())
				resourceChanged(childDelta);
		}

		@Override
		public void setLocked(boolean setLocked) {
			if (setLocked) {
				if (resource.isModified()) {
					OCLExamplesEditorPlugin.showError("Cannot lock modified resource: " + Label.labelFor(resource), null);
					return;
				}
			}
			else {
				if (computeIsReadOnly()) {
					OCLExamplesEditorPlugin.showError("Cannot unlock read-only resource: " + Label.labelFor(resource), null);
					return;
				}
			}
			boolean wasLocked = isLocked;
			isLocked = setLocked || isReadOnly;
			if (wasLocked != isLocked)
				resource.setModified(resource.isModified());
		}

		@Override
		public void setReadOnly(boolean setReadOnly) {
			if (setReadOnly) {
				if (resource.isModified()) {
					OCLExamplesEditorPlugin.showError("Cannot set modified resource read-only: " + Label.labelFor(resource), null);
					return;
				}
			}
			else {
				if (computeIsReadOnly()) {
					OCLExamplesEditorPlugin.showError("Cannot set read-only resource read-write: " + Label.labelFor(resource), null);
					return;
				}
			}
			boolean wasReadOnly = isReadOnly;
			isReadOnly = setReadOnly;
			isLocked = isLocked || isReadOnly;
			if (wasReadOnly != isReadOnly)
				resource.setModified(resource.isModified());
		}

		public void setURI(URI uri) {
			this.uri = uri;
			fileName = null;
			isReadOnly = computeIsReadOnly();
			setLocked(isLocked || isReadOnly);
		}
	}
}
