package com.sap.mi.fwk.ui.internal;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.services.local.ErrorHandling;
import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.cdam.ide.IdeCompoundDataAreaManager;
import com.sap.tc.moin.repository.ide.MoinFactory;

/**
 * The plugin class
 * 
 * @author d031150
 */
public final class MiFwkUIPlugin extends AbstractUIPlugin {

	private static final Logger sTracer = Logger.getLogger(MiLocations.MI_TOOLMODELING);

	public static final String PLUGIN_ID = "com.sap.mi.fwk.ui"; //$NON-NLS-1$ 
	public static final String IMAGE_ID_PROPERTIES = "properties";//$NON-NLS-1$ 
	public static final String DECORATOR_ERROR_IMAGE = "DECORATOR_ERROR_IMAGE";//$NON-NLS-1$
	public static final String DECORATOR_WARNING_IMAGE = "DECORATOR_WARNING_IMAGE";//$NON-NLS-1$
	public static final String HOURGLAS_IMAGE = "HOURGLAS_IMAGE";//$NON-NLS-1$

	private static MiFwkUIPlugin sInstance;

	public MiFwkUIPlugin() {
		sInstance = this;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		ModelManagerUI.shutDown();

		super.stop(context);
	}

	public static MiFwkUIPlugin getDefault() {
		return sInstance;
	}

	protected void initializeImageRegistry(ImageRegistry registry) {

		URL installURL = null;
		try {
			Bundle bundle = getDefault().getBundle(); // 
			installURL = FileLocator.resolve(bundle.getEntry("/")); //$NON-NLS-1$
		} catch (IOException e) {
			sTracer.log(Level.SEVERE, "Exception during initializeImageRegistry", e); //$NON-NLS-1$
			return;
		}

		try {
			registry.put(IMAGE_ID_PROPERTIES, ImageDescriptor.createFromURL(new URL(installURL,
					"resources/properties.gif"))); //$NON-NLS-1$
			registry.put(DECORATOR_ERROR_IMAGE, ImageDescriptor.createFromURL(new URL(installURL,
					"resources/decorators/errorMessage.gif"))); //$NON-NLS-1$
			registry.put(DECORATOR_WARNING_IMAGE, ImageDescriptor.createFromURL(new URL(installURL,
					"resources/decorators/warningMessage.gif"))); //$NON-NLS-1$
			registry.put(HOURGLAS_IMAGE, ImageDescriptor.createFromURL(new URL(installURL,
					"resources/icons/hourClass.gif"))); //$NON-NLS-1$
		} catch (MalformedURLException e) {
		    sTracer.log(Level.SEVERE, "Exception during initializeImageRegistry", e); //$NON-NLS-1$
		}
	}

	/**
	 * Returns an image associated with the given key. Images are automatically
	 * disposed at the point in time this plugin is disposed
	 * 
	 * @param key
	 *            a unique string constant defined by this plugin for accessing
	 *            the corresponding image
	 * @return the image associated with the given key, or <code>null</code> if
	 *         the string is not valid
	 */
	public Image getImage(String key) {
		return getImageRegistry().get(key);
	}

	/**
	 * Returns an image descriptor associated with the given key. Images are
	 * automatically disposed at the point in time this plugin is disposed
	 * 
	 * @param key
	 *            a unique string constant defined by this plugin for accessing
	 *            the corresponding image descriptor
	 * @return the image associated with the given key, or <code>null</code> if
	 *         the string is not valid
	 */
	public ImageDescriptor getImageDescriptor(String key) {
		return getImageRegistry().getDescriptor(key);
	}

	public static IStatus createStatus(int severity, String message, Throwable exception) {
		return createStatus(severity, 0, message, exception);
	}

	public static IStatus createStatus(int severity, int code, String message, Throwable exception) {
		return ErrorHandling.createStatus(severity, code, message, exception, PLUGIN_ID);
	}

	public static IStatus showErrorDialog(Throwable e, String message, String title, Logger tracer) {
		return ErrorHandling.showError(message, e, title, tracer, PLUGIN_ID);
	}

	public static IStatus showErrorDialog(IStatus status, String title, Logger tracer) {
		return ErrorHandling.showStatus(status, title, tracer, PLUGIN_ID);
	}

	public static void logError(Throwable e, Logger tracer) {
		logError(e.getMessage(), e, tracer);
	}

	public static void logError(String message, Throwable e, Logger tracer) {
		ErrorHandling.logError(message, e, tracer, PLUGIN_ID);
	}

	public static void logWarning(String message, Logger tracer) {
		logStatus(createStatus(IStatus.WARNING, message, null), tracer);
	}

	public static void logStatus(IStatus status, Logger tracer) {
		ErrorHandling.logStatus(status, tracer, PLUGIN_ID);
	}

	/**
	 * @return the Compound Data Area Manager (Facility Dispatcher)
	 */
	public static IdeCompoundDataAreaManager getIdeCompoundDataAreaManager() {
		Moin moin = MoinFactory.getMoinInstance();
		return (IdeCompoundDataAreaManager) moin.getCompoundDataAreaManager();
	}

	/**
	 * In case of Development Component project, this method returns the
	 * decorated project name.
	 */
	public static String getProjectLabel(IProject project) {
		if (project == null)
			throw new IllegalArgumentException("Project must not be null"); //$NON-NLS-1$
		if (!project.isAccessible())
			return "<unknown projectname>"; //$NON-NLS-1$
		ILabelDecorator decorator = PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator();
		String decoratedName = decorator.decorateText(project.getName(), project);
		if (decoratedName != null && decoratedName.length() > 0)
			return decoratedName;
		return project.getName();
	}
}
