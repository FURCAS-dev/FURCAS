package com.sap.mi.fwk.ui.dnd;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IAdapterManager;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

/**
 * Protocol for extending the set of objects to be transferred via copy/paste or
 * drag and drop. Usually to be implemented by objects where a copy or drag
 * occurs on, but implementations can also be contributed for a <em>target</em>
 * object class using the
 * {@link IAdapterManager#registerAdapters(IAdapterFactory, Class) Platform's adapter}
 * mechanism or the extension point
 * <code>org.eclipse.core.runtime.adapters</code>.
 * 
 * @author d031150
 */
public interface IModelTransferExtender<T extends RefBaseObject> {

	/**
	 * Extends the original set of objects to transfer. Called for each object
	 * of the set that has a matching type. If e.g. an extender is registered
	 * for Mof classes, it will be called once for each class in the set.
	 * Duplicate results are merged. The <code>originalObjects</code> set,
	 * however, stays the same.
	 * 
	 * @param toExtend
	 *            the object for which additional objects can be returned
	 * @param originalObjects
	 *            the original objects, usually a selection in the workbench
	 * 
	 * @return additional objects to be included in the transfer set
	 */
	RefBaseObject[] getAdditionalObjects(T toExtend, RefBaseObject[] originalObjects);

}
