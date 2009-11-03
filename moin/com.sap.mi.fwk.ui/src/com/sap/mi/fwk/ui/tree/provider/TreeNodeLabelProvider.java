package com.sap.mi.fwk.ui.tree.provider;

import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;

import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNode;

/**
 * Convenience class for rendering a "loading data..." place holder including an
 * hour class image until the real data is fetched from Moin. This pattern is
 * used by {@link TreeNodeNavigatorContentProvider}.
 * 
 * ATTENTION: When overlaoding the methods ensure to call the respective
 * <code>super</code> method when no applicable object is found.
 * 
 * @author d024127, d022960
 */
public class TreeNodeLabelProvider extends BaseLabelProvider implements ILabelProvider {

	/**
	 * This implementation returns a common image if the <code>element</code> is
	 * of type {@link ITreeNode#LOADING_DATA_NODE}, otherwise <code>null</code>.
	 * 
	 * @return A common image if the <code>element</code> is of type
	 *         {@link ITreeNode#LOADING_DATA_NODE}, otherwise <code>null</code>.
	 */
	public Image getImage(Object element) {
		if (TreeNode.LOADING_DATA_NODE == element) {
			return MiFwkUIPlugin.getDefault().getImage(MiFwkUIPlugin.HOURGLAS_IMAGE);
		}
		// Label provider is not responsible
		return null;
	}

	/**
	 * This implementation returns a common text if the <code>element</code> is
	 * of type {@link ITreeNode#LOADING_DATA_NODE}, otherwise <code>null</code>.
	 * 
	 * @return A common text if the <code>element</code> is of type
	 *         {@link ITreeNode#LOADING_DATA_NODE}, otherwise <code>null</code>.
	 */
	public String getText(Object element) {
		if (ITreeNode.LOADING_DATA_NODE == element) {
			return MiFwkUiMessages.LoadingData_Label;
		}
		// Label provider is not responsible
		// Note: The Common Navigator Framework checks whether a registered
		// custom LabelProvider returns a image and/or a text. If this is the
		// case dispatching to other LabelProviders does not happen. Thus we
		// must not call toString() by default.
		return null;
	}
}