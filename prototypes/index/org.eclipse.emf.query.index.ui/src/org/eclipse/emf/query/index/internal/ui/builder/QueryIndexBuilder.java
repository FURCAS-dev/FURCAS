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
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
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
	protected IProject[] build(int kind, @SuppressWarnings("rawtypes") Map args, IProgressMonitor monitor) throws CoreException {
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
		Registry instance = Resource.Factory.Registry.INSTANCE;
		//Put the XMI extension in the extension factory map.
		instance.getExtensionToFactoryMap().put("xmi", new  XMIResourceFactoryImpl());
		
		final Set<String> extensions = instance.getExtensionToFactoryMap().keySet();
		
		String fileExtension = resource.getFileExtension();
		//Only index those files which are in the extension factory map.In this case we have
		//put the XMI in the extension factory map.
		if (extensions.contains(fileExtension)) {
			IndexFactory.getInstance().executeUpdateCommand(new UpdateCommandAdapter() {

				private Resource emfResource;

				@Override
				public void postCommitAction() {
					//Unload on postCommit
					final URI uri = emfResource.getURI();
					if(uri.isPlatformResource()) {
						emfResource.unload();
					}
				}

				@Override
				public void preCommitAction(IndexUpdater updater) {
					// Load in precommit
					final ResourceSet rs = new ResourceSetImpl();
					String fullPath = resource.getFullPath().toString();
					emfResource = rs.getResource(URI.createPlatformResourceURI(fullPath,true), true);
				}

				@Override
				public void execute(final IndexUpdater updater) {
					final ResourceIndexer indexer = new ResourceIndexer();
					try {
						indexer.resourceChanged(updater, emfResource);
					} catch (Exception e) {
						System.err.println("Error indexing resource: " + emfResource.getURI().toString());
						e.printStackTrace();
					}
				}
			});
		}
	}

}
