package com.sap.mi.fwk.ui.internal.adapter;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.views.tasklist.ITaskListResourceAdapter;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class PartitionableResourceAdapter implements ITaskListResourceAdapter {

	public IResource getAffectedResource(IAdaptable adaptable) {
		RefBaseObject rbo = null;
		if (adaptable instanceof RefBaseObject) {
			rbo = (RefBaseObject) adaptable;
		}
		if (rbo == null) {
			rbo = getAdapter(adaptable, RefBaseObject.class);
		}
		if (rbo == null) {
			rbo = getAdapter(adaptable, RefObject.class);
		}
		if (rbo != null) {
			return ModelAdapter.getInstance().getFile(rbo);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private static <T extends RefBaseObject> T getAdapter(IAdaptable adaptable, Class<T> adapterClass) {
		Object adapter = adaptable.getAdapter(adapterClass);
		if (adapter != null) {
			return (T) adapter;
		}
		return null;
	}

}
