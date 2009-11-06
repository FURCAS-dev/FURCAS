package com.sap.mi.tools.cockpit.editor.model;

import org.eclipse.core.runtime.Assert;

import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;
import com.sap.mi.tools.cockpit.editor.provider.MOINBrowserLabelProvider;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * @author d003456
 * 
 */
public class MetaObjectNode extends TreeNodeRefObject<RefObject> implements ITreeNodeLabelAware {

	/**
	 * {@link MetaObjectNode}.
	 * 
	 * @param parent
	 * @param modelElement
	 */
	public MetaObjectNode(Object parent, RefObject modelElement) {

		super(parent, modelElement);
		Assert.isNotNull(getParent());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#getChildren()
	 */
	public Object[] getChildren() {

		return new Object[] { new RefObjectNode(this, getValue()) };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.tree.nodes.ITreeNode#hasChildren()
	 */
	public boolean hasChildren() {

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.tools.cockpit.editor.model.ITreeNodeLabelAware#getLabel()
	 */
	public String getLabel() {

		return MOINBrowserLabelProvider.REF_META_OBJECT;
	}

}
