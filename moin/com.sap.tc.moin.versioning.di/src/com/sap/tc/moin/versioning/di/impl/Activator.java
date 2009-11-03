package com.sap.tc.moin.versioning.di.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;


/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	private final static TracerI sTracer = TracingManager.getTracer( Activator.class );
	
    // The plug-in ID
    public static final String PLUGIN_ID = "com.sap.tc.moin.versioning.di.epi"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;

    // images
	public static final String FILE_IMAGE_WITH_ERROR_DECORATOR = "FILE_IMAGE_WITH_ERROR_DECORATOR"; //$NON-NLS-1$
	public static final String FILE_IMAGE_WITH_WARNING_DECORATOR = "FILE_IMAGE_WITH_WARNING_DECORATOR"; //$NON-NLS-1$
	public static final String FOLDER_IMAGE_WITH_ERROR_DECORATOR = "FOLDER_IMAGE_WITH_ERROR_DECORATOR"; //$NON-NLS-1$
	public static final String FOLDER_IMAGE_WITH_WARNING_DECORATOR = "FOLDER_IMAGE_WITH_WARNING_DECORATOR"; //$NON-NLS-1$
    
    
    /**
     * The constructor
     */
    public Activator( ) {

        plugin = this;
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    public void start( BundleContext context ) throws Exception {

        super.start( context );
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop( BundleContext context ) throws Exception {

        plugin = null;
        super.stop( context );
    }

    /**
     * Returns the shared instance
     *
     * @return the shared instance
     */
    public static Activator getDefault( ) {

        return plugin;
    }
    
    ImageDescriptor createFileOverlayImage(ImageDescriptor overlayImage) {
    	Image fileImage = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
    	DecorationOverlayIcon overlayIcon = new DecorationOverlayIcon(fileImage, overlayImage, IDecoration.BOTTOM_LEFT);
    	return overlayIcon;
    }
    
    
	protected void initializeImageRegistry(ImageRegistry reg) {
		super.initializeImageRegistry(reg);
		URL lInstallURL = null;
		try {
			Bundle bundle = getDefault().getBundle();
			lInstallURL = FileLocator.resolve(bundle.getEntry("/")); //$NON-NLS-1$
		} catch (IOException e) {
			sTracer.error("IOException occured", e); //$NON-NLS-1$
			return;
		}
		ImageDescriptor errorDecorator = null;
		ImageDescriptor warningDecorator = null;
		try {
			errorDecorator = ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/312_ICON_MESSAGE_ERROR_SMALL.gif")); //$NON-NLS-1$
			warningDecorator = ImageDescriptor.createFromURL(new URL(lInstallURL, "resources/icons/315_ICON_MESSAGE_WARNING_SMALL.gif")); //$NON-NLS-1$			
		} catch (MalformedURLException e) {
			sTracer.error("MalformedURLException occured", e); //$NON-NLS-1$
		}
		// file image with warning and error decorator
		Image fileImage = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
		DecorationOverlayIcon fileImageWithWarningDecorator = new DecorationOverlayIcon(fileImage, warningDecorator, IDecoration.BOTTOM_LEFT);
		DecorationOverlayIcon fileImageWithErrorDecorator = new DecorationOverlayIcon(fileImage, errorDecorator, IDecoration.BOTTOM_LEFT);
		reg.put(FILE_IMAGE_WITH_WARNING_DECORATOR, fileImageWithWarningDecorator); 
		reg.put(FILE_IMAGE_WITH_ERROR_DECORATOR, fileImageWithErrorDecorator);
		// folder image with warning and error decorator
		Image folderImage = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
		DecorationOverlayIcon folderImageWithWarningDecorator = new DecorationOverlayIcon(folderImage, warningDecorator, IDecoration.BOTTOM_LEFT);
		DecorationOverlayIcon folderImageWithErrorDecorator = new DecorationOverlayIcon(folderImage, errorDecorator, IDecoration.BOTTOM_LEFT);
		reg.put(FOLDER_IMAGE_WITH_WARNING_DECORATOR, folderImageWithWarningDecorator); 
		reg.put(FOLDER_IMAGE_WITH_ERROR_DECORATOR, folderImageWithErrorDecorator);
	}

	public Image getImage(String key) {
		return getImageRegistry().get(key);
	}

	public ImageDescriptor getImageDescriptor(String key) {
		return getImageRegistry().getDescriptor(key);
	}

}
