package com.sap.ap.cts.monet.deepcopy;

import ngpm.NgpmPackage;

import org.eclipse.core.runtime.IAdapterFactory;

import com.sap.ide.treeprovider.GenericRefObjectNode;
import com.sap.mi.fwk.ui.dnd.IModelTransferExtender;
import com.sap.mi.fwk.ui.dnd.IModelTransferTarget;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

/**
 * Provides a Runlet specific deep copy strategy for {@link GenericRefObjectNode} and
 * RefObject. But only if the respective objects originate from the NgpmPackage.
 * 
 * @author D049157
 */
public final class RunletModelCopyAdapterFactory implements IAdapterFactory {

    @SuppressWarnings("unchecked")
    public Object getAdapter(Object adaptableObject, Class adapterType) {
	RefObject refAdaptable = null;
	if (adaptableObject instanceof GenericRefObjectNode) {
	    GenericRefObjectNode node = (GenericRefObjectNode) adaptableObject;
	    refAdaptable = node.getValue();
	} else if (adaptableObject instanceof RefObject) {
	    refAdaptable = (RefObject) adaptableObject;
	}

	if (refAdaptable != null) {
	    Connection co = refAdaptable.get___Connection();
	    MofPackage outmostPkg = refAdaptable.refOutermostPackage().refMetaObject();
	    RefPackage rootPkg = co.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
	    if (co.getJmiHelper().findRefPackageByQualifiedName(outmostPkg.getQualifiedName(), rootPkg) == null) {
		// The outmost package of refAdaptable does not belong to the
		// NgpmPackage
		return null;
	    }

	    if (IModelTransferExtender.class == adapterType) {
		return new RunletModelCopyStrategy();
	    }

	    if (IModelTransferTarget.class == adapterType) {
		return new RunletModelCopyStrategy();
	    }
	}
	return null;
    }

    @SuppressWarnings("unchecked")
    public Class[] getAdapterList() {
	return new Class[] { IModelTransferExtender.class, IModelTransferTarget.class };
    }
}
