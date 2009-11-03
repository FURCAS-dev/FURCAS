package com.sap.mi.fwk.internal.uihook;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;

import org.eclipse.core.runtime.IProgressMonitor;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;

/**
 * Defines ways for how to execute operations issued from the framework that may
 * need UI-related parts.
 * </p>
 * For internal use only, not intended to be implemented by external clients.
 * 
 * @author d031150
 */
public interface IMiFwkOperationExecutor {

	/**
	 * @return whether the current thread is the UI thread
	 */
	boolean isInUiThread();

	/**
	 * Runs the given operation in a UI modal context. Must block until the
	 * operation has finished.
	 * 
	 * @param operation
	 *            the operation to execute
	 * @param fork
	 *            if <code>true</code>, use a background thread
	 * @param monitor
	 *            to report progress with
	 * @return the operation's resuklt, which may be <code>null</code>
	 * 
	 * @throws InvocationTargetException
	 *             in case of failures within the operation
	 * @throws InterruptedException
	 *             if the operation was cancelled
	 */
	<T> T inModalContext(Callable<T> operation, boolean fork, IProgressMonitor monitor)
			throws InvocationTargetException, InterruptedException;
	/**
	 * The method saves the given connection using the ModalContext thread.
	 * The method must be called from the UI thread.
	 * @param connection
	 * @throws NullPartitionNotEmptyException
	 * @throws PartitionsNotSavedException
	 */
	void saveConnectionInModalContext(final Connection connection) throws NullPartitionNotEmptyException, PartitionsNotSavedException, ReferencedTransientElementsException;
	
}
