package org.eclipse.emf.query.index.ui.images;

import org.eclipse.emf.query.index.ui.Activator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * @author Animesh Kumar, SAP Labs India Pvt. Ltd.
 *
 */
public class IndexUIImageRegistry {
	private static ImageRegistry mRegistry = Activator.getDefault().getImageRegistry();
	private static final String ROOT_ICON_PATH = "icons/"; //$NON-NLS-1$
	public static final String EOBJECT_ICON = ROOT_ICON_PATH + "EObject.gif"; //$NON-NLS-1$
	public static final String EOBJECTGROUP_ICON = ROOT_ICON_PATH + "EObjects.gif"; //$NON-NLS-1$
	public static final String RESOURCEGROUP_ICON = ROOT_ICON_PATH + "Resources.gif"; //$NON-NLS-1$
	public static final String RESOURCE_ICON = ROOT_ICON_PATH + "Resource.gif"; //$NON-NLS-1$
	public static final String INCOMINGLINKSGROUP_ICON = ROOT_ICON_PATH + "IncomingLinks.gif"; //$NON-NLS-1$
	public static final String LINK_ICON = ROOT_ICON_PATH + "link.gif"; //$NON-NLS-1$
	public static final String OUTGOINGLINKSGROUP_ICON = ROOT_ICON_PATH + "OutgoingLinks.gif"; //$NON-NLS-1$
	public static final String TYPES_ICON = ROOT_ICON_PATH + "Types.gif"; //$NON-NLS-1$
	public static final String TYPE_ICON = ROOT_ICON_PATH + "Type.gif"; //$NON-NLS-1$
	public static final String FILTER_ICON = ROOT_ICON_PATH + "filter.gif"; //$NON-NLS-1$
	public static final String LEGEND_ICON = ROOT_ICON_PATH + "legends.gif"; //$NON-NLS-1$
	
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
		ImageDescriptor imageDescriptor = Activator.getImageDescriptor(imageId);
		if (imageDescriptor != null) {
			mRegistry.put(imageId, imageDescriptor);
		}
	}
}
