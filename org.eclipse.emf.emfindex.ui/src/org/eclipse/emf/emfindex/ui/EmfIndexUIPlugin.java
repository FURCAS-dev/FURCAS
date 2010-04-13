package org.eclipse.emf.emfindex.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.emfindex.EmfIndexModule;
import org.eclipse.emf.emfindex.EquinoxEmfIndexModule;
import org.eclipse.emf.emfindex.Logger;
import org.eclipse.emf.emfindex.store.UpdateableIndex;
import org.eclipse.emf.emfindex.ui.builder.EmfIndexNature;
import org.eclipse.emf.emfindex.ui.builder.EmfIndexProjectBuilder;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchListener;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * The activator class controls the plug-in life cycle
 */
public class EmfIndexUIPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.emf.emfindex.ui";

	// The shared instance
	private static EmfIndexUIPlugin plugin;
	
	/**
	 * The constructor
	 */
	public EmfIndexUIPlugin() {
	}
	
	@Inject
	private UpdateableIndex index;
	
	public UpdateableIndex getIndex() {
		return index;
	}

	@Inject
	private Logger logger;

	private Injector injector;
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		getInjector().injectMembers(this);
		initializeIndex();
		registerSaveOnExitListener();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}
	
	public void initializeIndex() {
		if (index != null) {
			loadIndex();
			indexWorkspace();//TODO why do we index the workspace eagerly? 
		}
	}
	
	private void loadIndex() {
		try {
			index.load();
		} catch (Exception e) {
			logger.logError("Error loading EMF index", e);
		}
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static EmfIndexUIPlugin getDefault() {
		return plugin;
	}

	public synchronized Injector getInjector() {
		if (injector == null) {
			if (EMFPlugin.IS_ECLIPSE_RUNNING) {
				try {
					injector = Guice
							.createInjector(new EquinoxEmfIndexModule());
				} catch (Exception e) {
					getLog().log(
							new Status(IStatus.ERROR, getBundle()
									.getSymbolicName(), e.getMessage(), e));
				}
			} else {
				try {
					injector = Guice.createInjector(new EmfIndexModule());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return injector;
	}
	
	private void indexWorkspace() {
		for (final IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			try {
				if (project.isAccessible()) {
					IProjectDescription description = project.getDescription();
					if (description.hasNature(EmfIndexNature.NATURE_ID)) {
						Job builderJob = new Job("EMF Index: indexing " + project.getName()) {
							@Override
							protected IStatus run(IProgressMonitor monitor) {
								try {
									project.build(IncrementalProjectBuilder.CLEAN_BUILD,
											EmfIndexProjectBuilder.BUILDER_ID, null, monitor);
								} catch (CoreException e) {
									logger.logError(e.getMessage(), e);
									Status status = new Status(IStatus.ERROR, EmfIndexUIPlugin.PLUGIN_ID,
											"Error indexing project " + project.getName(), e);
									return status;
								}
								return Status.OK_STATUS;
							}
						};
						builderJob.schedule();
					}
				}
			} catch (CoreException ce) {
				logger.logError("Error getting project description of " + project.getName(), ce);
			}
		}
	}

	private void registerSaveOnExitListener() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench != null) {
			workbench.addWorkbenchListener(new IWorkbenchListener() {
				public boolean preShutdown(IWorkbench workbench, boolean forced) {
					try {
						index.save();
					} catch (Exception e) {
						logger.logError("Error saving EMF index", e);
					}
					return true;
				}
	
				public void postShutdown(IWorkbench workbench) {
					// do nothing.
				}
			});
		}
	}
}
