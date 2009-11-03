package com.sap.mi.tools.diagnostics.internal.model;

/**
 * A structural node in the view
 * 
 * @author d031150
 */
public abstract class StructureNode extends TreeNode {

	private int mHash = -1;

	public StructureNode(TreeNode parent) {
		super(parent);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj instanceof StructureNode) {
			StructureNode node = (StructureNode) obj;
			Object parent = node.getParent();
			if (parent != null) {
				if (!parent.equals(getParent()))
					return false;
			} else if (getParent() != null) {
				return false;
			}

			String text = node.getText();
			if (text != null) {
				if (!text.equals(getText()))
					return false;
			} else if (getText() != null) {
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		// cache hash to prevent its computation when text or parent
		// is not valid anymore
		if (mHash == -1) {
			mHash = super.hashCode();
			Object parent = getParent();
			if (parent != null)
				mHash = parent.hashCode();
			String text = getText();
			if (text != null)
				mHash += text.hashCode();
		}
		return mHash;
	}

}
