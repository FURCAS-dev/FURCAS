package com.sap.mi.fwk.ui.internal.mm;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.properties.IPropertySource;

import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;

/**
 * Adapter factory for {@link IPropertySource property sources} for
 *      {@link MmDeploymentInfo} objects
 *      
 * @author d031150
 */
public final class MmPropertiesAdapterFactory implements IAdapterFactory {

    public MmPropertiesAdapterFactory() {
    }

    public Object getAdapter(Object adaptableObject, Class adapterType) {
        if (adapterType.isInstance(adaptableObject)) {
            return adaptableObject;
        }
        if (adapterType == IPropertySource.class) {
            if (adaptableObject instanceof MmDeploymentInfo) {
            	MmDeploymentInfo metamodel = (MmDeploymentInfo) adaptableObject;
                return new MmPropertySource(metamodel);
            }
            else if (adaptableObject instanceof MmDeploymentInfo[]) {
            	MmDeploymentInfo[] metamodels = (MmDeploymentInfo[]) adaptableObject;
            	if (metamodels.length == 1)
            		return new MmPropertySource(metamodels[0]);
            }
        }
        return null;
    }

    public Class[] getAdapterList() {
        return new Class[] { IPropertySource.class };
    }

}
