package com.sap.mi.tools.diagnostics.internal.model;

import javax.management.openmbean.CompositeData;

/**
 * A registered editor
 * 
 * @author d024127
 */
public class EditorNode extends DelegateNode {

	private boolean isDefault;

	public EditorNode(TreeNode parent, CompositeData editorData, boolean isDefault) {
		super(parent, editorData);
		this.isDefault = isDefault;
	}

	@Override
	public CompositeData getDelegate() {
		return (CompositeData) super.getDelegate();
	}

	@Override
	public Object[] getChildren() {
		CompositeData data = getDelegate();
		String className = (String) data.get("FactoryClass"); //$NON-NLS-1$
		if (className != null && !"".equals(className)) { //$NON-NLS-1$
			return new Object[] { new InputFactoryNode(this, className) };
		}
		return new Object[0];
	}

	@Override
	public String getText() {
		StringBuffer sb = new StringBuffer();
		CompositeData data = getDelegate();
		sb.append((String) data.get("DisplayName")).append(" [").append((String) data.get("EditorID")).append("]"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		return sb.toString();
	}

	public boolean isDefault() {
		return isDefault;
	}
}
