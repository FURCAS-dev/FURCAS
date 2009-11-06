package com.sap.mi.fwk.ui.dnd;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.PlatformObject;

import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.tc.moin.repository.DeepCopyPolicyHandler;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Default implementation of {@link IModelTransferTarget}. Clients may override
 * as needed.
 * 
 * @author d031150
 */
public class DefaultModelTransferTarget extends PlatformObject implements IModelTransferTarget {

	/**
	 * The default implementation checks whether at least one clipboard object
	 * may be added as <em>composite</em> child to the target, if this one is
	 * a {@link RefObject}. Otherwise calls
	 * {@link #isTransferAllowedForNonRefObjectTarget(Object, RefBaseObject[])}.
	 * 
	 * @see ModelClipboard#isCompositionAllowed(RefObject, RefBaseObject[])
	 * @see #isTransferAllowedForNonRefObjectTarget(Object, RefBaseObject[])
	 */
	public boolean isTransferAllowed(Object target, RefBaseObject[] objectsToTransfer) {
		boolean allowed = false;
		RefObject parent = ModelAdapterUI.getInstance().getRefObject(target);
		if (parent != null)
			allowed = ModelClipboard.isCompositionAllowed(parent, objectsToTransfer);
		else
			allowed = isTransferAllowedForNonRefObjectTarget(target, objectsToTransfer);
		return allowed;
	}

	/**
	 * Called by {@link #isTransferAllowed(Object, RefBaseObject[])} if the
	 * <code>target</code> object is not a {@link RefObject}. The default
	 * implementation returns <code>true</code> if all
	 * <code>objectsToTransfer</code> don't have a composite parent. This is
	 * targeted for the scenario of top-level, i.e. not composed objects being
	 * transferred to a structural tree node that acts as container for these
	 * root objects.
	 * 
	 * @param target
	 *            an object acting as target. Is not a {@link RefObject}.
	 * @param objectsToTransfer
	 * @return <code>true</code> iff the transfer is allowed
	 * 
	 * @see #isTransferAllowed(Object, RefBaseObject[])
	 */
	protected boolean isTransferAllowedForNonRefObjectTarget(Object target, RefBaseObject[] objectsToTransfer) {
		for (RefBaseObject o : objectsToTransfer) {
			if (o instanceof RefObject) {
				RefObject refO = (RefObject) o;
				if (refO.refImmediateComposite() != null)
					return false;
			}
		}
		return true;
	}

	/**
	 * The default implementation tries to add the given objects to the given
	 * target as composite children, if this one is a {@link RefObject}. If
	 * multiple matching {@link Association associations} are available, the
	 * user is asked to choose one.
	 * 
	 * @return an empty collection
	 * 
	 * @see ModelClipboard#addToCompositeParent(RefObject, RefBaseObject[],
	 *      Association, IModelTransferLog)
	 */
	public Collection<ModelPartition> handleTransfer(Object target, RefBaseObject[] objectsToTransfer,
			IModelTransferLog log) throws OperationCanceledException {
		// only can handle RefObjects as parent, but no RefBaseObjects
		RefObject parent = ModelAdapterUI.getInstance().getRefObject(target);
		if (parent != null)
			ModelClipboard.addToCompositeParent(parent, objectsToTransfer, null, log);

		return Collections.emptyList();
	}

	/**
	 * The default implementation returns <code>null</code>
	 */
	public DeepCopyPolicyHandler getDeepCopyPolicyHandler() {
		return null;
	}

	/**
	 * The default implementation returns <code>false</code>
	 */
	public boolean includeExternalCompositeParents() {
		return false;
	}

}
