package com.sap.mi.fwk.ui.internal.mm;

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;

import com.sap.mi.fwk.mm.MetamodelManager;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;

/**
 * Adapts to and persists {@link MmDeploymentInfo metamodels}. Used for
 * metamodels working sets.
 * 
 * @author d031150
 */
final class MmAdaptable extends PlatformObject implements IPersistableElement {

	private final String mContainerName;

	MmAdaptable(MmDeploymentInfo metamodel) {
		this(metamodel.getContainerName());
	}

	MmAdaptable(String containerName) {
		mContainerName = containerName;
	}

	@Override
	public Object getAdapter(Class adapter) {
		if (MmDeploymentInfo.class.isAssignableFrom(adapter)) {
			// Resolve the concrete metamodel not before here since this is a
			// potentially long-running operation. As a consequence we could
			// return null for a working set of an unavailable metamodel.
			return MetamodelManager.getInstance().getDeployedMetamodel(mContainerName);
		}
		if (IPersistableElement.class.isAssignableFrom(adapter))
			return this;
		return super.getAdapter(adapter);
	}

	public void saveState(IMemento memento) {
		memento.putString(MmElementFactory.KEY_CONTAINER_NAME, mContainerName);
	}

	public String getFactoryId() {
		return MmElementFactory.ID;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((mContainerName == null) ? 0 : mContainerName.hashCode());
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
		final MmAdaptable other = (MmAdaptable) obj;
		if (mContainerName == null) {
			if (other.mContainerName != null)
				return false;
		} else if (!mContainerName.equals(other.mContainerName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return mContainerName;
	}

}
