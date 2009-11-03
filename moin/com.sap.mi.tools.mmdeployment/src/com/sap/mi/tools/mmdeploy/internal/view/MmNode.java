package com.sap.mi.tools.mmdeploy.internal.view;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.ui.views.properties.IPropertySource;

import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;

/**
 * The node for a metamodel in the view
 * 
 * @author d031150
 */
class MmNode extends PlatformObject {
	private final MmDeploymentInfo mMetamodel;
	private final MmWorkingSetNode mWorkingSet;

	MmNode(MmDeploymentInfo metamodel, MmWorkingSetNode set) {
		mMetamodel = metamodel;
		mWorkingSet = set;
	}

	MmDeploymentInfo getMetamodel() {
		return mMetamodel;
	}

	MmWorkingSetNode getWorkingSet() {
		return mWorkingSet;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapter) {
		if (MmDeploymentInfo.class.isAssignableFrom(adapter))
			return mMetamodel;
		if (IPropertySource.class.isAssignableFrom(adapter))
			return Platform.getAdapterManager().getAdapter(mMetamodel, adapter);
		return super.getAdapter(adapter);
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((mMetamodel == null) ? 0 : mMetamodel.hashCode());
		result = PRIME * result + ((mWorkingSet == null) ? 0 : mWorkingSet.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final MmNode other = (MmNode) obj;
		if (mMetamodel == null) {
			if (other.mMetamodel != null)
				return false;
		} else if (!mMetamodel.equals(other.mMetamodel))
			return false;
		if (mWorkingSet == null) {
			if (other.mWorkingSet != null)
				return false;
		} else if (!mWorkingSet.equals(other.mWorkingSet))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder(mMetamodel.getContainerName());
		if (mWorkingSet != null)
			string.append(" [").append(mWorkingSet.getName()).append("]"); //$NON-NLS-1$ //$NON-NLS-2$
		return string.toString();
	}
}