/*******************************************************************************
 * Copyright (c) 2007,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.editor.ui.builder;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.editor.ui.ICreationFactory;
import org.eclipse.ocl.examples.editor.ui.OCLExamplesEditorPlugin;
import org.eclipse.ocl.examples.modelregistry.eclipse.EclipseFileHandle;
import org.eclipse.ocl.examples.modelregistry.eclipse.EclipseProjectHandle;
import org.eclipse.ocl.examples.parser.environment.ICSTFileEnvironment;
import org.eclipse.ocl.examples.parser.environment.ICSTRootEnvironment;
import org.eclipse.ocl.lpg.ProblemHandler;

@Deprecated // Use CommonBuilder
public abstract class AbstractBuilder extends IncrementalProjectBuilder
{
	protected class DeltaVisitor implements IResourceDeltaVisitor
	{
		protected final IProgressMonitor monitor;
		
		public DeltaVisitor(IProgressMonitor monitor) {
			this.monitor = monitor;
		}
		
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse.core.resources.IResourceDelta)
		 */
		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource resource = delta.getResource();
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				// handle added resource
				checkResource(resource, monitor);
				break;
			case IResourceDelta.REMOVED:
				// handle removed resource
				break;
			case IResourceDelta.CHANGED:
				// handle changed resource
				checkResource(resource, monitor);
				break;
			}
			//return true to continue visiting children.
			return !monitor.isCanceled();
		}
	}

	protected class ResourceVisitor implements IResourceVisitor
	{
		protected final IProgressMonitor monitor;

		public ResourceVisitor(IProgressMonitor monitor) {
			this.monitor = monitor;
		}
		public boolean visit(IResource resource) {
			checkResource(resource, monitor);
			//return true to continue visiting children.
			return !monitor.isCanceled();
		}
	}
	
	protected final ICreationFactory creationFactory;

	protected AbstractBuilder(ICreationFactory creationFactory) {
		this.creationFactory = creationFactory;
	}

	protected void addMarker(int severity, IResource resource, String message, int lineNumber, int charStart, int charEnd) {
		String markerId = creationFactory.getProblemMarkerId();
//		System.out.println(getClass().getSimpleName() + ".addMarker " + markerId + resource);
		try {
			IMarker marker = resource.createMarker(markerId);
			marker.setAttribute(IMarker.MESSAGE, message);
			marker.setAttribute(IMarker.SEVERITY, severity);
			if (lineNumber == -1) {
				lineNumber = 1;
			}
			marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
			if (charStart <= charEnd) {
				marker.setAttribute(IMarker.CHAR_START, charStart);
				marker.setAttribute(IMarker.CHAR_END, charEnd);
			}
		} catch (CoreException e) {
			OCLExamplesEditorPlugin.logError("Failed to add marker " + markerId, e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.internal.events.InternalBuilder#build(int,
	 *      java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@SuppressWarnings("rawtypes")
	@Override protected IProject[] build(int kind, Map args, IProgressMonitor monitor)
			throws CoreException {
		if (kind == FULL_BUILD) {
//			QVTPreferences.clean();
			fullBuild(monitor);
		} else {
			IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild(monitor);
			} else {
				incrementalBuild(delta, monitor);
			}
		}
		return null;
	}

	protected void checkResource(IResource iResource, final IProgressMonitor monitor) {
		if (iResource instanceof IFile) {
			if (creationFactory.hasExtension(iResource.getFileExtension(), creationFactory.getTextExtensions())) {
				IFile file = (IFile) iResource;
				IPath concretePath = file.getFullPath();
				deleteMarkers(file);
				try {
					compile(file, monitor);
				} catch (IOException e) {
					addMarker(IMarker.SEVERITY_ERROR, file, "Internal error : " + e.getClass().getName() + " - see Error Log for details", 1, 1, 1);
					OCLExamplesEditorPlugin.logError("Failed to read '" + concretePath.toString() + "'", e);
	//					} catch (CoreException e) {
				} catch (Throwable e) {
					addMarker(IMarker.SEVERITY_ERROR, file, "Internal error : " + e.getClass().getName() + " - see Error Log for details", 1, 1, 1);
					OCLExamplesEditorPlugin.logError("Failed to build '" + concretePath.toString() + "'", e);
					e.printStackTrace();		// FIXME this is just a debug convenience
				}
			}
		}
	}

	protected void compile(IFile file, final IProgressMonitor progressMonitor) throws IOException, CoreException {
		IPath concretePath = file.getFullPath();
		IPath abstractPath = concretePath.removeFileExtension().addFileExtension(creationFactory.getXMLExtension());
		EclipseProjectHandle projectHandle = new EclipseProjectHandle(file.getProject());
		EclipseFileHandle fileHandle = projectHandle.getFileHandle(file);
		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createPlatformResourceURI(abstractPath.toString(), true);
		URI ecoreURI = creationFactory.getEcoreURI(uri);
		ICSTFileEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> environment = creationFactory.createFileEnvironment(fileHandle, resourceSet, ecoreURI);
		ProblemHandler reporter = creationFactory.createProblemHandler(file);
		environment.setProblemHandler(reporter);
		ICSTRootEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> rootEnvironment = environment.parse(null, environment.getFile(), progressMonitor);
		try {
			Resource resource = creationFactory.getEcoreResource(resourceSet, rootEnvironment.getASTNode(), uri);
			resource.save(null);
			rootEnvironment.validate();
		} catch (IOException e) {
			OCLExamplesEditorPlugin.logError("Failed to save '" + abstractPath.toString() + "'", e);
		}
		reporter.flush(BasicMonitor.toMonitor(progressMonitor));
	}

	protected DeltaVisitor createDeltaVisitor(IProgressMonitor monitor) {
		return new DeltaVisitor(monitor);
	}

	protected ResourceVisitor createResourceVisitor(final IProgressMonitor monitor) {
		return new ResourceVisitor(monitor);
	}

	protected void deleteMarkers(IResource resource) {
		String markerId = creationFactory.getProblemMarkerId();
		try {
//			file.deleteMarkers(null, false, IResource.DEPTH_ZERO);
//			System.out.println(getClass().getSimpleName() + ".deleteMarkers " + markerId + " 0 " + resource);
			resource.deleteMarkers(markerId, false, IResource.DEPTH_ZERO);
		} catch (CoreException e) {
			OCLExamplesEditorPlugin.logError("Failed to delete resource markers for " + markerId, e);
		}
	}

	protected void fullBuild(final IProgressMonitor monitor) {
		String markerId = creationFactory.getProblemMarkerId();
		try {
			IProject project = getProject();
//			System.out.println(getClass().getSimpleName() + ".fullBuild(deleteMarkers) " + markerId + " INFINITE " + project);
			project.deleteMarkers(markerId, false, IResource.DEPTH_INFINITE);
			project.accept(createResourceVisitor(monitor));
		} catch (CoreException e) {
			OCLExamplesEditorPlugin.logError("Failed to delete projects markers for " + markerId, e);
		}
	}

	protected void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		// the visitor does the work.
		delta.accept(createDeltaVisitor(monitor));
	}
}
