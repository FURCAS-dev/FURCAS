package com.sap.mi.tools.diagnostics.internal.model;

/**
 * <p>Title:       DelegateNode</p>
 * <p>Description: </p>
 * <p>Copyright:   Copyright (c) 2006</p>
 * <p>Company:     SAP AG</p>
 * @author        d031150
 * @since         NYC
 */
public abstract class DelegateNode extends TreeNode {

	private final Object mDelegate;

	public DelegateNode(TreeNode parent, Object delegate) {
		super(parent);
		mDelegate = delegate;
	}

	protected Object getDelegate() {
		return mDelegate;
	}

	@Override
	public String getText() {
		String text = getDelegate().toString();
		return text;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj instanceof DelegateNode) {
			DelegateNode node = (DelegateNode) obj;
			Object parent = node.getParent();
			if (parent != null) {
				if (!parent.equals(getParent()))
					return false;
			} else if (getParent() != null) {
				return false;
			}

			Object delegate = node.getDelegate();
			if (delegate != null) {
				if (!getDelegate().equals(delegate))
					return false;
			} else if (getDelegate() != null) {
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
////		int h = super.hashCode();
////		Object parent = getParent();
////		if (parent != null)
////			h += parent.hashCode(); 
////		 
////		Object delegate = getDelegate();
////		if (delegate != null)
////			h += delegate.hashCode(); 
////		 
////		return 37 * h;
//	}
		 
		// JM: code has been changed so that equals primarily means 
		// the delegate nodes are equal if they delegate work to 
		// two equal objects. To accomplish this the delegate
		// hashcode takes precedence if available.
		// drawback: different delegate nodes cannot coexist in the 
		// tree if they represent the same (equal) object
		Object probe = getDelegate();
		int result = 0;
		if (probe != null) {
			result = probe.hashCode();
		} else {
			result = super.hashCode();
			probe = getParent();
			if (probe != null) {
				result += probe.hashCode();
			}
		}
		return 37 * result;
	}
}