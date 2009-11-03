package com.sap.mi.fwk.ui.internal.tree;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.tasklist.ITaskListResourceAdapter;

import com.sap.mi.fwk.ui.internal.adapter.PartitionableResourceAdapter;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNodeRefObject;

public class TreeNodeRefObjectAdapterFactory implements IAdapterFactory {

	@SuppressWarnings("unchecked")
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType.isInstance(adaptableObject)) {
			return adaptableObject;
		}
		// RefObject and RefBaseObject is returned
		// We should not adapt to sub classes of RefObject as we might get inconsistent behaviour
		// in case the standard adapter manager tries to find this factory.
		// Consider the following AdapterManager implementation provided by Eclipse:
		//
		// IAdapterFactory factory = (IAdapterFactory) getFactories(adaptable.getClass()).get(adapterType);
		// if (factory != null) {
		// Class clazz = factory.getClass().getClassLoader().loadClass(typeName);
		// if (clazz != null)
		// return factory.getAdapter(adaptable, clazz);
		// }
		//
		// Eclipse will only load this adapter factory if the class passed by adapterType could be loaded
		// by the classloader the Adapterfactory itself has been loaded with. This is not the case for any
		// subclass of RefObject as it will not be in the classloader scope of the tg generation plugin
		if (adapterType.isAssignableFrom(RefObject.class)) {
			if (adaptableObject instanceof ITreeNodeRefObject) {
				ITreeNodeRefObject<?> element = (ITreeNodeRefObject<?>)adaptableObject;
				RefObject ro = element.getValue();
				if (adapterType.isInstance(ro))
					return ro;
				return null;
			}
		}
		if (adapterType.isAssignableFrom(ITaskListResourceAdapter.class)) {
			return new PartitionableResourceAdapter();
		}
		return null;
	}

	public Class[] getAdapterList() {
		return new Class[] { RefObject.class };
	}
}
