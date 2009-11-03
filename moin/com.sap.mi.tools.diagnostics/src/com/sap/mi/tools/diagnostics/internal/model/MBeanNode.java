package com.sap.mi.tools.diagnostics.internal.model;

import javax.management.ObjectName;

import com.sap.mi.tools.diagnostics.internal.MoinJmxClient;

public class MBeanNode extends DelegateNode {

	private final ObjectName mName;
	private final transient MoinJmxClient mClient;

	public MBeanNode(TreeNode parent, ObjectName name, Object mBean, MoinJmxClient client) {
        super(parent, mBean);
		mName = name;
		mClient = client;
    }
	
	public final MoinJmxClient getClient() {
		return mClient;
	}
	
	public final ObjectName getObjectName() {
		return mName;
	}
	
	@Override
	public String getText() {
		return mName.toString();
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = PRIME * ((mName == null) ? 0 : mName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		final MBeanNode other = (MBeanNode) obj;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		return true;
	}

}
