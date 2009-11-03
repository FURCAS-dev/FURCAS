package com.sap.mi.tools.mmdeploy.internal.view;

import java.util.Collection;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.IWorkingSet;

import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;

/**
 * Adapts {@link MmNode nodes} from the deployment view to
 * {@link MmDeploymentInfo metamodels}
 * 
 * @author d031150
 */
public class MmDeploymentInfoAdapterFactory implements IAdapterFactory {

	@SuppressWarnings("unchecked")
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType.isInstance(adaptableObject)) {
			return adaptableObject;
		}
		if (adapterType == MmDeploymentInfo.class) {
			if (adaptableObject instanceof MmNode) {
				MmNode mmNode = (MmNode) adaptableObject;
				return mmNode.getMetamodel();
			}
		} else if (adapterType == MmDeploymentInfo[].class) {
			if (adaptableObject instanceof MmWorkingSetNode) {
				MmWorkingSetNode mmNode = (MmWorkingSetNode) adaptableObject;
				Collection<MmDeploymentInfo> metamodels = mmNode.getMetamodels();
				return metamodels.toArray(new MmDeploymentInfo[metamodels.size()]);
			}
		} else if (adapterType == IWorkingSet.class) {
			if (adaptableObject instanceof MmWorkingSetNode) {
				MmWorkingSetNode mmNode = (MmWorkingSetNode) adaptableObject;
				return mmNode.getWorkingSet(); // may return null
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Class[] getAdapterList() {
		return new Class[] { MmDeploymentInfo.class, MmDeploymentInfo[].class, IWorkingSet.class };
	}

}
