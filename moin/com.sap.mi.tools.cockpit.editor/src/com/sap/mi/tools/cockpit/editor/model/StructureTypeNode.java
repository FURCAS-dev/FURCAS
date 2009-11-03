package com.sap.mi.tools.cockpit.editor.model;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

import org.eclipse.core.runtime.Assert;

import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNode;
import com.sap.mi.tools.cockpit.editor.provider.MOINBrowserLabelProvider;

/**
 * @author d003456
 * 
 */
public class StructureTypeNode<T extends AttributeValue> extends TreeNode<T> implements ITreeNodeLabelAware {

	/**
	 * Creates {@link StructureTypeNode}.
	 * 
	 * @param parent
	 * @param pair
	 */
	public StructureTypeNode(ITreeNode<?> parent, T pair) {

		super(parent, pair);
		Assert.isNotNull(getParent());
		Assert.isNotNull(pair);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#getChildren()
	 */
	public Object[] getChildren() {

		final List<ITreeNode<?>> childList = new ArrayList<ITreeNode<?>>();

		if (((AttributeValuePair) getValue()).getValue() instanceof RefStruct) {
			final RefStruct value = (RefStruct) ((AttributeValuePair) getValue()).getValue();
			final List<String> fieldNames = value.refFieldNames();

			for (final String fieldName : fieldNames) {
				final Object field = value.refGetValue(fieldName);

				if (field instanceof String || field instanceof Integer || field instanceof Long || field instanceof Double
						|| field instanceof Float || field instanceof Boolean) {

					childList.add(new PropertyNode<NameValuePair>(this, new NameValuePair(fieldName, field)));

				} else if (field instanceof RefStruct) {

					childList.add(new StructureTypeNode<NameValuePair>(this, new NameValuePair(fieldName, field)));
				}
			}
		} else if (((AttributeValuePair) getValue()).getValue() instanceof String) {
			childList.add(new LiteralNode(this, (String) ((AttributeValuePair) getValue()).getValue()));
		} else {
			childList.add(new LiteralNode(this, MOINBrowserLabelProvider.ERROR_LABEL));
		}

		return childList.toArray();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#hasChildren()
	 */
	public boolean hasChildren() {

		return getChildren().length > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.tools.cockpit.editor.model.ITreeNodeLabelAware#getLabel()
	 */
	public String getLabel() {

		if (getValue() instanceof AttributeValuePair) {
			final Attribute attribute = ((AttributeValuePair) getValue()).getAttribute();
			return attribute.getName() + ", " + attribute.getType().getName(); //$NON-NLS-1$
		} else if (getValue() instanceof NameValuePair) {
			return ((NameValuePair) getValue()).getName();
		}
		return MOINBrowserLabelProvider.ERROR_LABEL;

	}
}
