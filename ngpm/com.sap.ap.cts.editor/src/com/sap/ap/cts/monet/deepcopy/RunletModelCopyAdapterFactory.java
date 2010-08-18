package com.sap.ap.cts.monet.deepcopy;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.ide.treeprovider.GenericRefObjectNode;


/**
 * Provides a Runlet specific deep copy strategy for {@link GenericRefObjectNode} and
 * EObject. But only if the respective objects originate from the NgpmPackage.
 * 
 * @author D049157
 */
public final class RunletModelCopyAdapterFactory implements IAdapterFactory {

    @SuppressWarnings("unchecked")
    public Object getAdapter(Object adaptableObject, Class adapterType) {
	EObject refAdaptable = null;
	if (adaptableObject instanceof GenericRefObjectNode) {
	    GenericRefObjectNode node = (GenericRefObjectNode) adaptableObject;
	    refAdaptable = node.getValue();
	} else if (adaptableObject instanceof EObject) {
	    refAdaptable = (EObject) adaptableObject;
	}

	if (refAdaptable != null) {
	    ResourceSet co = refAdaptable.get___Connection();
	    EPackage outmostPkg = refAdaptable.refOutermostPackage().refMetaObject();
	    EPackage rootPkg = co.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
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
