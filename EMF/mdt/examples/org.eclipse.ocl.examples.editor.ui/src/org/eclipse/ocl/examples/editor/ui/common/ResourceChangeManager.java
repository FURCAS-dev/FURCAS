/**
 * <copyright>
 * 
 * Copyright (c) 2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: ResourceChangeManager.java,v 1.1 2010/03/13 13:16:11 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.ocl.examples.editor.ui.OCLExamplesEditorPlugin;
import org.eclipse.ocl.examples.editor.ui.text.TextResource;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * ResourceChangeManager manages the resources of an editor using a ResourceSet. 
 * <p>
 * The code is based on the auto-generated EcoreEditor code and is separated out
 * to support re-use in single and multi-page editors.
 */
public abstract class ResourceChangeManager implements IResourceChangeListener
{
	private class ResourceDeltaVisitor implements IResourceDeltaVisitor
	{
		protected ResourceSet resourceSet = getResourceSet();
		protected Collection<Resource> changedResources = new ArrayList<Resource>();
		protected Map<Resource, IPath> refactoredResources = new HashMap<Resource, IPath>();

		public boolean visit(IResourceDelta delta) {
			if (delta.getResource().getType() == IResource.FILE) {
				int flags = delta.getFlags();
				int kind = delta.getKind();
				if ((kind & IResourceDelta.REMOVED) != 0) {  // Deleted or renamed
					URI uri = URI.createPlatformResourceURI(delta.getFullPath().toString(), true);		// See Bugzilla 236362
					Resource resource = resourceSet.getResource(uri, false);
					if (resource != null) {
						if (OCLExamplesEditorPlugin.EDITOR_SAVE.isActive())
							OCLExamplesEditorPlugin.EDITOR_SAVE.println(getClass(), "Removed " + resource.getURI().toString());
						refactoredResources.put(resource, delta.getMovedToPath());
					}
				}
				else if (((kind & IResourceDelta.CHANGED) != 0) && ((flags & ~IResourceDelta.MARKERS) != 0)) {
					URI uri = URI.createPlatformResourceURI(delta.getFullPath().toString(), true);		// See Bugzilla 236362
					Resource resource = resourceSet.getResource(uri, false);
					if (resource != null) {
						if ((resource instanceof TextResource) && (((TextResource)resource).isSaveInProgress()))
							;
						else if (!savedResources.remove(resource)) {
								if (OCLExamplesEditorPlugin.EDITOR_SAVE.isActive())
									OCLExamplesEditorPlugin.EDITOR_SAVE.println(getClass(), "Changed " + resource.getURI().toString());
								changedResources.add(resource);
							} else {
								if (OCLExamplesEditorPlugin.EDITOR_SAVE.isActive())
									OCLExamplesEditorPlugin.EDITOR_SAVE.println(getClass(), "Saved " + resource.getURI().toString());
							}
						}
					}
				}
			return true;
		}

		private Collection<Resource> getChangedResources() {
			return changedResources;
		}

		private Map<Resource, IPath> getRefactoredResources() {
			return refactoredResources;
		}
	}

	private final class ResourceChangedRunnable implements Runnable
	{
		public void run() {
			if (OCLExamplesEditorPlugin.EDITOR_SAVE.isActive())
				OCLExamplesEditorPlugin.EDITOR_SAVE.println(getClass(), "run");
			handleActivate();
		}
	}

	private final class ResourceRemovedRunnable implements Runnable
	{
		public void run() {
			if (OCLExamplesEditorPlugin.EDITOR_SAVE.isActive())
				OCLExamplesEditorPlugin.EDITOR_SAVE.println(getClass(), "run");
			closeEditor(false);
		}
	}

	private final class ResourceRenamedRunnable implements Runnable
	{
		private IPath path;
		
		public ResourceRenamedRunnable(IPath path) {
			this.path = path;
		}

		public void run() {
			setPartName(path.lastSegment());
		}
	}

	private final class SaveOperation1 extends WorkspaceModifyOperation
	{
		private final Map<Object, Object> saveOptions;

		private SaveOperation1(Map<Object, Object> saveOptions) {
			this.saveOptions = saveOptions;
		}

		// This is the method that gets invoked when the operation runs.
		//
		@Override
		public void execute(IProgressMonitor monitor)
		{
			suspendResourceListening();
			// Save the resources to the file system.
			//
			boolean first = true;
			for (Resource resource : getResourceSet().getResources())
			{
				if ((first || !resource.getContents().isEmpty() || isPersisted(resource)) && !getEditingDomain().isReadOnly(resource))
				{
					try
					{
						savingResources.add(resource);
						savedResources.add(resource);
						if (OCLExamplesEditorPlugin.EDITOR_SAVE.isActive())
							OCLExamplesEditorPlugin.EDITOR_SAVE.println(getClass(), "Save " + resource.getURI().toString());
						resource.save(saveOptions);
					}
					catch (Exception exception) {
						handleResourceException(resource, exception, false);
					}
					finally {
						if (OCLExamplesEditorPlugin.EDITOR_SAVE.isActive())
							OCLExamplesEditorPlugin.EDITOR_SAVE.println(getClass(), "Saved all");
					}
					first = false;
				}
			}
		}
	}

	private final class SaveOperation2 extends WorkspaceModifyOperation
	{
		private SaveOperation2() {}

		// This is the method that gets invoked when the operation runs.
		//
		@Override
		public void execute(IProgressMonitor monitor)
		{
			resumeResourceListening();
			if (OCLExamplesEditorPlugin.EDITOR_SAVE.isActive())
				OCLExamplesEditorPlugin.EDITOR_SAVE.println(getClass(), "Saved all2");
		}
	}

	/**
	 * Resources that have been removed since last activation.
	 */
	private Collection<Resource> removedResources = new ArrayList<Resource>();

	/**
	 * Resources that have been changed since last activation.
	 */
	private Collection<Resource> changedResources = new ArrayList<Resource>();

	/**
	 * Resources that have been saved.
	 */
	private Collection<Resource> savedResources = new ArrayList<Resource>();

	/**
	 * Resources that have been saved.
	 */
	private Collection<Resource> savingResources = new ArrayList<Resource>();

	protected abstract void asyncExec(Runnable runnable);

	protected abstract void closeEditor(boolean save);
	
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
	}

	/**
	 * This is for implementing {@link IEditorPart} and simply saves the model file.
	 */
	public void doSave(IProgressMonitor progressMonitor)
	{
		// Save only resources that have actually changed.
		//
		Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

		// Do the work within an operation because this is a long running activity that modifies the workbench.
		//
		WorkspaceModifyOperation operation1 = new SaveOperation1(saveOptions);
		WorkspaceModifyOperation operation2 = new SaveOperation2();
		suspendProblemIndicationUpdate();
		try
		{
			// This runs the options, and shows progress.
			//
			ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(getShell());
			progressMonitorDialog.run(true, false, operation1);

			// Refresh the necessary state.
			//
			if (OCLExamplesEditorPlugin.EDITOR_SAVE.isActive())
				OCLExamplesEditorPlugin.EDITOR_SAVE.println(getClass(), "Saved all");
			try
			{
				// This runs the options, and shows progress.
				//
				progressMonitorDialog.run(true, false, operation2);

				// Refresh the necessary state.
				//
				if (OCLExamplesEditorPlugin.EDITOR_SAVE.isActive())
					OCLExamplesEditorPlugin.EDITOR_SAVE.println(getClass(), "Saved all2");
				savingResources.clear();
			}
			catch (Exception exception)
			{
				// Something went wrong that shouldn't.
				//
				OCLExamplesEditorPlugin.INSTANCE.log(exception);
			}
			refreshAfterSave();
		}
		catch (Exception exception)
		{
			// Something went wrong that shouldn't.
			//
			OCLExamplesEditorPlugin.INSTANCE.log(exception);
		}
		finally {
			resumeProblemIndicationUpdate();
		}
	}

	protected abstract AdapterFactoryEditingDomain getEditingDomain();

	protected abstract ResourceSet getResourceSet();

	protected abstract Shell getShell();

	/**
	 * Handles activation of the editor or it's associated views.
	 */
	public void handleActivate()
	{
		refreshReadOnlyActions();

		if (!removedResources.isEmpty())
		{
			if (handleDirtyConflict())
			{
				closeEditor(false);
			}
			else
			{
				removedResources.clear();
				changedResources.clear();
				savedResources.clear();
				if (OCLExamplesEditorPlugin.EDITOR_SAVE.isActive())
					OCLExamplesEditorPlugin.EDITOR_SAVE.println(getClass(), "Clear saved after removed");
			}
		}
		else if (!changedResources.isEmpty())
		{
			changedResources.removeAll(savedResources);
			handleChangedResources();
			changedResources.clear();
			savedResources.clear();
			if (OCLExamplesEditorPlugin.EDITOR_SAVE.isActive())
				OCLExamplesEditorPlugin.EDITOR_SAVE.println(getClass(), "Clear saved after changed");
		}
	}

	/**
	 * Handles what to do with changed resources on activation.
	 */
	protected void handleChangedResources()
	{
		if (!changedResources.isEmpty() && (!isDirty() || handleDirtyConflict()))
		{
			flushCommandStack();
			suspendProblemIndicationUpdate();
			if (isDirty()) {
				changedResources.addAll(getResourceSet().getResources());
			}
			try {
				for (Resource resource : changedResources)
				{
					if (resource.isLoaded())
					{
						resource.unload();
						try {
							resource.load(Collections.EMPTY_MAP);
						}
						catch (IOException exception) {
							handleResourceException(resource, exception, true);
						}
					}
				}
				refreshSelection(false);
			}
			finally {
				resumeProblemIndicationUpdate();
			}
		}
	}

	protected abstract void flushCommandStack();

	/**
	 * Shows a dialog that asks if conflicting changes should be discarded.
	 */
	protected abstract boolean handleDirtyConflict();

	protected abstract void handleResourceException(Resource resource, Exception exception, boolean forceUpdate);

	public void init() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
	}
	
	public abstract boolean isActiveEditor();
	
	public abstract boolean isDirty();

	/**
	 * This returns whether something has been persisted to the URI of the specified resource.
	 * The implementation uses the URI converter from the editor's resource set to try to open an input stream. 
	 */
	protected boolean isPersisted(Resource resource)
	{
		boolean result = false;
		try
		{
			InputStream stream = getResourceSet().getURIConverter().createInputStream(resource.getURI());
			if (stream != null)
			{
				result = true;
				stream.close();
			}
		}
		catch (IOException e)
		{
			// Ignore
		}
		return result;
	}

//	public boolean isSaving(Resource resource) {
//		return savingResources.contains(resource);
//	}

	protected abstract void refreshAfterSave();

	protected void refreshReadOnlyActions() {
		AdapterFactoryEditingDomain editingDomain = getEditingDomain();
		// Recompute the read only state.
		//
		if (editingDomain.getResourceToReadOnlyMap() != null) {
			editingDomain.getResourceToReadOnlyMap().clear();

			// Refresh any actions that may become enabled or disabled.
			//
			refreshSelection(true);
		}
	}

	protected abstract void refreshSelection(boolean forceRefresh);

	protected abstract void resumeProblemIndicationUpdate();

	protected abstract void resumeResourceListening();

	public void resourceChanged(IResourceChangeEvent event) {
		// Only listening to these.
		// if (event.getType() == IResourceDelta.POST_CHANGE)
		{
			IResourceDelta delta = event.getDelta();
			try {
				ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
				delta.accept(visitor);
				Map<Resource, IPath> refactoredResources = visitor.getRefactoredResources();
				if (!refactoredResources.isEmpty()) {
					if (OCLExamplesEditorPlugin.EDITOR_SAVE.isActive())
						for (Resource removedResource : refactoredResources.keySet())
							OCLExamplesEditorPlugin.EDITOR_SAVE.println(getClass(), "Removed " + removedResource.getURI().toString());
					removedResources.addAll(refactoredResources.keySet());
					if (!isDirty())
						asyncExec(new ResourceRemovedRunnable());
					else {
						for (Resource removedResource : refactoredResources.keySet()) {
							if (removedResource instanceof TextResource) {
								IPath path = refactoredResources.get(removedResource);
								if (path != null)
									asyncExec(new ResourceRenamedRunnable(path));
							}
						}
					}
				}
				if (!visitor.getChangedResources().isEmpty()) {
					if (OCLExamplesEditorPlugin.EDITOR_SAVE.isActive())
						for (Resource changedResource : visitor.getChangedResources())
							OCLExamplesEditorPlugin.EDITOR_SAVE.println(getClass(), "Changed " + changedResource.getURI().toString());
					changedResources.addAll(visitor.getChangedResources());
					if (isActiveEditor()) {
						asyncExec(new ResourceChangedRunnable());
					}
				}
			} catch (CoreException exception) {
				OCLExamplesEditorPlugin.INSTANCE.log(exception);
			}
		}
	}

	protected abstract void setPartName(String partName);

	protected abstract void suspendProblemIndicationUpdate();

	protected abstract void suspendResourceListening();
}
