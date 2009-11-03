package com.sap.mi.fwk.ui.dnd;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.OperationCanceledException;

import com.sap.tc.moin.repository.DeepCopyPolicyHandler;
import com.sap.tc.moin.repository.ModelPartition;

/**
 * Protocol for custom operation on the set of objects while they are
 * transferred via copy/paste or drag and drop. Use the default implementation
 * {@link DefaultModelTransferTarget} if possible. Usually to be implemented by
 * objects where a paste or drop occurs on, but implementations can also be
 * contributed for a <em>target</em> object class using the
 * {@link IAdapterManager#registerAdapters(IAdapterFactory, Class) Platform's adapter}
 * mechanism or the extension point
 * <code>org.eclipse.core.runtime.adapters</code>.
 * 
 * @author d031150
 * 
 * @see DefaultModelTransferTarget
 */
public interface IModelTransferTarget {

	/**
	 * Called to allow or deny pasting or dropping. Answers whether the given
	 * objects can be transferred to the given target. Should return in a timely
	 * manner since called frequently by paste actions and drop validators to
	 * provide feedback to the user. See the default implementation in
	 * {@link DefaultModelTransferTarget}, which implements typical transfer
	 * scenarios.
	 * 
	 * @param target
	 *            an object acting as target. Must not be <code>null</code>.
	 * @param objectsToTransfer
	 * @return <code>true</code> iff the transfer is allowed
	 * 
	 * @see DefaultModelTransferTarget#isTransferAllowed(Object,
	 *      RefBaseObject[])
	 */
	boolean isTransferAllowed(Object target, RefBaseObject[] objectsToTransfer);

	/**
	 * Hook for custom logic in the paste step of a copy/paste operation or on
	 * drop. Typically this includes inserting the transferred objects to a
	 * composition hierarchy and a partition.
	 * 
	 * @param target
	 *            the object where the paste or drop occurred on
	 * @param objectsToTransfer
	 *            the objects about to be transferred. In copy/paste scenario
	 *            these are already copies of the original objects.
	 * @param log
	 *            to collect status information. Any errors will be presented to
	 *            the user at the end of the operation.
	 * @return a set of new partitions, which have been created in the course of
	 *         this operation
	 * @throws OperationCanceledException
	 *             on user cancellation. The operation is then silently aborted.
	 */
	Collection<ModelPartition> handleTransfer(Object target, RefBaseObject[] objectsToTransfer, IModelTransferLog log)
			throws OperationCanceledException;

	/**
	 * @return a policy for the deep copy process or <code>null</code>
	 */
	DeepCopyPolicyHandler getDeepCopyPolicyHandler();

	/**
	 * @return whether external compositions (parents) should be considered
	 */
	boolean includeExternalCompositeParents();

}
