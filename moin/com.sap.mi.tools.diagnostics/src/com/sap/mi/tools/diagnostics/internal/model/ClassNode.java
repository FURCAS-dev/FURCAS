package com.sap.mi.tools.diagnostics.internal.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.management.openmbean.CompositeData;
import javax.management.openmbean.TabularData;

import com.sap.mi.fwk.ui.mbeans.EditorRegistryEntryMBean;

/**
 * The editor class node
 * 
 * @author d024127
 */
public class ClassNode extends DelegateNode {

	public ClassNode(TreeNode parent, EditorRegistryEntryMBean bean) {
		super(parent, bean);
	}

	@Override
	public EditorRegistryEntryMBean getDelegate() {
		return (EditorRegistryEntryMBean) super.getDelegate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] getChildren() {
		// read editors
		List<TreeNode> children = new ArrayList<TreeNode>();
		CompositeData defEditor = getDelegate().getDefaultEditor();
		children.add(new EditorNode(this, defEditor, true));

		TabularData editors = getDelegate().getEditors();
		for (Iterator<CompositeData> it = ((Collection<CompositeData>) editors.values()).iterator(); it.hasNext();) {
			CompositeData editor = it.next();
			children.add(new EditorNode(this, editor, false));
		}
		return children.toArray();
	}

	@Override
	public String getText() {
		return getDelegate().getClassName();
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		String mName = getDelegate().getClassName();
		int result = PRIME * ((mName == null) ? 0 : mName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		final ClassNode other = (ClassNode) obj;
		String mName = getDelegate().getClassName();
		if (mName == null) {
			if (other.getDelegate().getClassName() != null)
				return false;
		} else if (!mName.equals(other.getDelegate().getClassName()))
			return false;
		return true;
	}
}
