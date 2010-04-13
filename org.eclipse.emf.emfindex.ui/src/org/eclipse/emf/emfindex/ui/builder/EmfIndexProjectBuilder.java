/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.ui.builder;

import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.emfindex.Logger;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.store.IndexUpdater;
import org.eclipse.emf.emfindex.store.ResourceIndexer;
import org.eclipse.emf.emfindex.store.UpdateCommand;
import org.eclipse.emf.emfindex.store.UpdateableIndex;

import com.google.inject.Inject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EmfIndexProjectBuilder extends IncrementalProjectBuilder {

	public static final String BUILDER_ID = "org.eclipse.emf.emfindex.ui.emfIndexBuilder";

	@Inject
	private Logger logger;

	@Inject
	private UpdateableIndex index;

	private ResourceIndexer resourceIndexer;

	public EmfIndexProjectBuilder() {
		resourceIndexer = new ResourceIndexer();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
		if (kind == FULL_BUILD) {
			fullBuild(monitor);
		}
		else {
			IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild(monitor);
			}
			else {
				incrementalBuild(delta, monitor);
			}
		}
		return null;
	}

	protected void fullBuild(final IProgressMonitor monitor) throws CoreException {
		try {
			getProject().accept(new IResourceVisitor() {
				public boolean visit(IResource resource) {
					tryIndexResource(resource, false);
					return resource instanceof IContainer;
				}
			});
		}
		catch (CoreException e) {
			logger.logError("Error during full build", e);
		}
	}

	protected void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		delta.accept(new IResourceDeltaVisitor() {
			public boolean visit(IResourceDelta delta) throws CoreException {
				IResource resource = delta.getResource();
				switch (delta.getKind()) {
					case IResourceDelta.ADDED:
					case IResourceDelta.CHANGED:
						tryIndexResource(resource, false);
						break;
					case IResourceDelta.REMOVED:
						tryIndexResource(resource, true);
						break;
				}
				return resource instanceof IContainer;
			}
		});
	}

	protected boolean tryIndexResource(IResource resource, final boolean isDeleted) {
		if (resource instanceof IFile) {
			IFile file = (IFile) resource;
			if (file.isDerived())
				return false;
			try {
				final URI resourceURI = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
				index.executeUpdateCommand(new UpdateCommand<Boolean>() {
					public Boolean execute(IndexUpdater indexUpdater, QueryExecutor queryExecutor) {
						if (isDeleted)
							resourceIndexer.resourceDeleted(resourceURI, indexUpdater);
						else
							resourceIndexer.resourceChanged(resourceURI, indexUpdater);
						return true;
					}
				});
			}
			catch (Exception e) {
				logger.logError("Cannot index resource " + resource.getFullPath().toString(), e);
			}
		}
		return false;
	}
}
