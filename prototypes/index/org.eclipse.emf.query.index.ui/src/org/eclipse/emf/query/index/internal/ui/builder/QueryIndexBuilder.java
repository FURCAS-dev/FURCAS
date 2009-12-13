package org.eclipse.emf.query.index.internal.ui.builder;

import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query.index.update.IndexUpdater;
import org.eclipse.emf.query.index.update.ResourceIndexer;
import org.eclipse.emf.query.index.update.UpdateCommandAdapter;

public class QueryIndexBuilder extends IncrementalProjectBuilder {

	class SampleDeltaVisitor implements IResourceDeltaVisitor {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse .core.resources.IResourceDelta)
		 */
		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource resource = delta.getResource();
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				// handle added resource
				indexFile(resource);
				break;
			case IResourceDelta.REMOVED:
				removeFile(resource);
				break;
			case IResourceDelta.CHANGED:
				// handle changed resource
				indexFile(resource);
				break;
			}
			// return true to continue visiting children.
			return true;
		}
	}

	class SampleResourceVisitor implements IResourceVisitor {
		private final IProgressMonitor monitor;

		public SampleResourceVisitor(IProgressMonitor monitor) {
			this.monitor = monitor;
		}

		public boolean visit(IResource resource) {
			monitor.beginTask("indexing resource " + resource.getFullPath().toString(), IProgressMonitor.UNKNOWN);
			indexFile(resource);
			monitor.done();
			// return true to continue visiting children.
			return true;
		}
	}

	public static final String BUILDER_ID = "org.eclipse.emf.query.index.ui.queryIndexBuilder";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.internal.events.InternalBuilder#build(int, java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
		if (kind == FULL_BUILD) {
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

	public void removeFile(final IResource resource) {
		IndexFactory.getInstance().executeUpdateCommand(new UpdateCommandAdapter() {

			@Override
			public void execute(IndexUpdater updater) {
				updater.deleteResource(URI.createPlatformResourceURI(resource.getFullPath().toString(), true));
			}
		});
	}

	protected void fullBuild(final IProgressMonitor monitor) throws CoreException {
		try {
			getProject().accept(new SampleResourceVisitor(monitor));
		} catch (CoreException e) {
		}
	}

	protected void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		// the visitor does the work.
		delta.accept(new SampleDeltaVisitor());
	}

	private void indexFile(final IResource resource) {
		final Set<String> extensions = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().keySet();
		String fileExtension = resource.getFileExtension();
		if ("xmi".equals(fileExtension) || "xml".equals(fileExtension) || extensions.contains(fileExtension)) {
			IndexFactory.getInstance().executeUpdateCommand(new UpdateCommandAdapter() {

				@Override
				public void execute(final IndexUpdater updater) {
					final ResourceIndexer indexer = new ResourceIndexer();
					final ResourceSet rs = new ResourceSetImpl();
					try {
						indexer.resourceChanged(updater, rs.getResource(URI.createPlatformResourceURI(resource.getFullPath().toString(),
								true), true));
					} catch (Exception e) {
						System.err.println("Error indexing resource: " + resource.getFullPath().toString());
						e.printStackTrace();
					}
				}
			});
		}
	}

}
