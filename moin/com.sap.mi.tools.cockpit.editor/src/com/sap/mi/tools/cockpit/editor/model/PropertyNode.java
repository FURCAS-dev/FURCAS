package com.sap.mi.tools.cockpit.editor.model;

import org.eclipse.core.runtime.Assert;

import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNode;
import com.sap.mi.tools.cockpit.editor.provider.MOINBrowserLabelProvider;

/**
 * @author d003456
 * 
 */
public class PropertyNode<T extends AttributeValue> extends TreeNode<T> implements ITreeNodeLabelAware {

	/**
	 * Creates {@link PropertyNode}.
	 * 
	 * @param parentNode
	 * @param pair
	 */
	public PropertyNode(ITreeNode<?> parentNode, T pair) {

		super(parentNode, pair);
		Assert.isNotNull(getParent());
		Assert.isNotNull(pair);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#getChildren()
	 */
	public final ITreeNode<?>[] getChildren() {

		return new ITreeNode[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#hasChildren()
	 */
	public boolean hasChildren() {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.tools.cockpit.editor.model.ITreeNodeLabelAware#getLabel()
	 */
	@SuppressWarnings("nls")
	public String getLabel() {

		if (getValue() instanceof AttributeValuePair) {

			final AttributeValuePair attrValuePair = (AttributeValuePair) getValue();
			return attrValuePair.getAttribute().getName() + ", " + attrValuePair.getAttribute().getType().getName() + ": "
					+ attrValuePair.getValue().toString();

		}
		else if (getValue() instanceof NameValuePair) {

			final NameValuePair nameValuePair = (NameValuePair) getValue();
			String type = "";
			final Object value = nameValuePair.getValue();
			if (value instanceof String) {
				type = MOINBrowserLabelProvider.TYPE_STRING_LABEL_PART;
			}
			else if (value instanceof Integer) {
				type = MOINBrowserLabelProvider.TYPE_INTEGER_LABEL_PART;
			}
			else if (value instanceof Long) {
				type = MOINBrowserLabelProvider.TYPE_LONG_LABEL_PART;
			}
			else if (value instanceof Float) {
				type = MOINBrowserLabelProvider.TYPE_FLOAT_LABEL_PART;
			}
			else if (value instanceof Double) {
				type = MOINBrowserLabelProvider.TYPE_DOUBLE_LABEL_PART;
			}
			else if (value instanceof Boolean) {
				type = MOINBrowserLabelProvider.TYPE_BOOLEAN_LABEL_PART;
			}
			else {
				type = MOINBrowserLabelProvider.ERROR_LABEL;
			}
			return nameValuePair.getName() + ", " + type + ": " + nameValuePair.getValue().toString();

		}
		else {
			return MOINBrowserLabelProvider.ERROR_LABEL;
		}
	}

}