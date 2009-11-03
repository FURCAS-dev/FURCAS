package com.sap.mi.tools.mmdeploy.internal.view;

import java.util.Collection;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.views.properties.IPropertySource;

import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;

/**
 * The node for working sets in the view
 * 
 * @author d031150
 */
class MmWorkingSetNode extends PlatformObject {

	private final String mName;
	private final Collection<MmDeploymentInfo> mMetamodels;
	private final IWorkingSet mWorkingSet;

	MmWorkingSetNode(Collection<MmDeploymentInfo> metamodels, IWorkingSet workingSet) {
		mMetamodels = metamodels;
		mWorkingSet = workingSet;
		mName = workingSet != null ? workingSet.getName() : "Others"; //$NON-NLS-1$
	}

	Collection<MmDeploymentInfo> getMetamodels() {
		return mMetamodels;
	}

	String getName() {
		return mName;
	}

	IWorkingSet getWorkingSet() {
		return mWorkingSet;
	}

	boolean isOthers() {
		return mWorkingSet == null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapter) {
		if (MmDeploymentInfo[].class.isAssignableFrom(adapter))
			return mMetamodels.toArray(new MmDeploymentInfo[mMetamodels.size()]);
		if (IWorkingSet.class.isAssignableFrom(adapter))
			return mWorkingSet;
		if (IPropertySource.class.isAssignableFrom(adapter)) {
			return Platform.getAdapterManager().getAdapter(
					mMetamodels.toArray(new MmDeploymentInfo[mMetamodels.size()]), adapter);
		}
		return super.getAdapter(adapter);
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((mName == null) ? 0 : mName.hashCode());
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
		final MmWorkingSetNode other = (MmWorkingSetNode) obj;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return mName;
	}
}