package org.eclipse.emf.query2.syntax.ui;

import org.eclipse.emf.query2.syntax.ui.internal.QueryActivator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * @author Animesh Kumar, SAP Labs India Pvt. Ltd.
 * 
 */
public class SyntaxUIImageRegistry {
	private static ImageRegistry mRegistry = QueryActivator.getDefault().getImageRegistry();
	private static final String ROOT_ICON_PATH = "icons/"; //$NON-NLS-1$
	public static final String EPACKAGE_ICON = ROOT_ICON_PATH + "package.gif"; //$NON-NLS-1$
	
	/**
	 * * Don't dispose the image retrieved from the registry
	 * 
	 * @param imageId
	 * @return
	 */
	public static Image getImage(String imageId) {
		if (mRegistry.getDescriptor(imageId) == null) {
			loadAndUpdateImageDescriptor(imageId);
		}
		return mRegistry.get(imageId);
	}

	/**
	 * * Don't dispose the image retrieved from the registry
	 * 
	 * @param imageId
	 * @return
	 */
	public static ImageDescriptor getImageDescriptor(String imageId) {
		ImageDescriptor imageDescriptor = null;
		if (mRegistry.getDescriptor(imageId) == null) {
			loadAndUpdateImageDescriptor(imageId);
		}
		imageDescriptor = mRegistry.getDescriptor(imageId);
		return imageDescriptor;
	}

	private static void loadAndUpdateImageDescriptor(String imageId) {
		ImageDescriptor imageDescriptor = QueryActivator.getImageDescriptor(imageId);
		if (imageDescriptor != null) {
			mRegistry.put(imageId, imageDescriptor);
		}
	}
}
