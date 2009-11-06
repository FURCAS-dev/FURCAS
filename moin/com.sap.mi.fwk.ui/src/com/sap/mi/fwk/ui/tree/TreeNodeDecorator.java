package com.sap.mi.fwk.ui.tree;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.sap.mi.fwk.MarkerManager;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Default node decorator capable of handling {@link ITreeNode} as well as {@link RefObject}. The decorator must be declared in the tool
 * specific plugin.xml using extension point <i>org.eclipse.ui.decorators</i>
 * <p>
 * Example:
 * 
 * <pre>
 *  &lt;extension
 *          point=&quot;org.eclipse.ui.decorators&quot;&gt;
 *       &lt;decorator
 *             class=&quot;com.sap.mi.fwk.ui.tree.TreeNodeDecorator&quot;
 *             id=&quot;com.sap.yourtool.decorator&quot;
 *             label=&quot;%decorator_name&quot;
 *             lightweight=&quot;true&quot;
 *             location=&quot;BOTTOM_LEFT&quot;&gt;
 *          &lt;enablement&gt;
 *             &lt;or&gt;
 *                &lt;objectClass
 *                      name=&quot;com.sap.yourtool.Class1&quot;&gt;
 *                &lt;/objectClass&gt;
 *                &lt;objectClass
 *                      name=&quot;com.sap.yourtool.Class2&quot;&gt;
 *                &lt;/objectClass&gt;
 *             &lt;/or&gt;
 *          &lt;/enablement&gt;
 *       &lt;/decorator&gt;
 * &lt;pre/
 * <p>
 * ATTENTION: This decorator scans elements in the tree recursivley resulting in
 * loading <b>ALL</b> nodes in the tree. If this is not feasible due to high
 * amount of nodes you can implement your own decorator based on this class or
 * independently.
 * 
 * @author d022960, d024127
 * 
 */
public class TreeNodeDecorator extends LabelProvider implements ILightweightLabelDecorator, ILabelDecorator {

	@SuppressWarnings("unused")
	private static final Logger sTracer = Logger.getLogger(MiLocations.MI_MARKERS);

	public static final String DECORATOR_ID = "com.sap.mi.fwk.ui.tree.treenodedecorator"; //$NON-NLS-1$
	public static final int SEVERITY_UNKNOWN = -2;

	/**
	 * No text decoration. Just return the original text.
	 */
	public String decorateText(final String text, final Object element) {
		return text;
	}

	/**
	 * Decorate a given image and store the result in the plugin's image registry in order to avoid massive image creation.
	 */
	public Image decorateImage(final Image image, final Object element) {

		int maxSeverity;
		if (element instanceof ITreeNode<?>) {
			maxSeverity = getMaxSeverity((ITreeNode<?>) element);
		} else if (element instanceof RefObject) {
			maxSeverity = MarkerManager.getInstance().findMaxProblemSeverity((RefObject) element, IMarker.PROBLEM, true,
					IResource.DEPTH_INFINITE);
		} else {
			return image;
		}

		DecorationOverlayIcon icon = null;
		switch (maxSeverity) {
		case IMarker.SEVERITY_ERROR:
			icon = new DecorationOverlayIcon(image, MiFwkUIPlugin.getDefault().getImageDescriptor(MiFwkUIPlugin.DECORATOR_ERROR_IMAGE),
					IDecoration.BOTTOM_LEFT);
			break;
		case IMarker.SEVERITY_WARNING:
			icon = new DecorationOverlayIcon(image, MiFwkUIPlugin.getDefault().getImageDescriptor(MiFwkUIPlugin.DECORATOR_WARNING_IMAGE),
					IDecoration.BOTTOM_LEFT);
			break;
		default:
			// nothing to do -> return original image right away
			return image;
		}

		// get image from cache or add new one
		// DecorationOverlayIcon's toString uses specialized hash code which
		// takes the original image
		// hash code as well as the overlay icon hash code into account.
		// @see DecorationOverlayIcon.toString()
		Image cachedImage = MiFwkUIPlugin.getDefault().getImageRegistry().get(icon.toString());
		if (cachedImage == null) {
			cachedImage = icon.createImage();
			MiFwkUIPlugin.getDefault().getImageRegistry().put(icon.toString(), cachedImage);
		}
		return cachedImage;
	}

	/**
	 * Decorates a given IDecoration object.
	 */
	public void decorate(final Object element, final IDecoration decoration) {

		int maxSeverity;
		if (element instanceof ITreeNode<?>) {
			maxSeverity = getMaxSeverity((ITreeNode<?>) element);
		} else if (element instanceof RefObject) {
			maxSeverity = MarkerManager.getInstance().findMaxProblemSeverity((RefObject) element, IMarker.PROBLEM, true,
					IResource.DEPTH_INFINITE);
		} else {
			return;
		}

		switch (maxSeverity) {
		case IMarker.SEVERITY_ERROR:
			decoration.addOverlay(MiFwkUIPlugin.getDefault().getImageDescriptor(MiFwkUIPlugin.DECORATOR_ERROR_IMAGE));
			break;
		case IMarker.SEVERITY_WARNING:
			decoration.addOverlay(MiFwkUIPlugin.getDefault().getImageDescriptor(MiFwkUIPlugin.DECORATOR_WARNING_IMAGE));
			break;
		default:
			decoration.addOverlay(null);
		}
	}

	/**
	 * Gets the maximum severity for a given tree node and stores it in the tree node for later access
	 * 
	 * @param node
	 *            The tree node
	 * @return max severity from -1 (not set) to 2 (error) or -2 if severity could not be determined.
	 * @see IMarker#SEVERITY_ERROR
	 * @see IMarker#SEVERITY_WARNING
	 * @see IMarker#SEVERITY_INFO
	 */
	protected int getMaxSeverity(final ITreeNode<?> node) {

		final Object value = node.getValue();
		if (value instanceof IProject) {
			final IProject project = (IProject) value;
			if (!project.isAccessible()) {
				return TreeNodeDecorator.SEVERITY_UNKNOWN;
			}
		}

		// if (value instanceof IProject || markerSupport.getMaxSeverity() ==
		// TreeNodeMarkerSupport.SEVERITY_UNKNOWN) {

		int maxProblemSeverity = TreeNodeDecorator.SEVERITY_UNKNOWN;
		final RefObject obj = (RefObject) node.getAdapter(RefObject.class);
		if (obj != null) {
			// do not inspect artifical nodes
			maxProblemSeverity = MarkerManager.getInstance().findMaxProblemSeverity(obj, IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		}
		return maxProblemSeverity;
	}
}