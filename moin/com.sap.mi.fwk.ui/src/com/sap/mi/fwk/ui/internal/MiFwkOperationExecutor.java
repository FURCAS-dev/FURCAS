package com.sap.mi.fwk.ui.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.operation.IThreadListener;
import org.eclipse.jface.operation.ModalContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.internal.uihook.IMiFwkOperationExecutor;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;

/**
 * Sole implementation of {@link IMiFwkOperationExecutor}. Intended to be
 * called only through <code>uiHook</code> extension.
 * 
 * @author d031150
 */
public final class MiFwkOperationExecutor implements IMiFwkOperationExecutor {

	private static IMiFwkOperationExecutor sInstance = new MiFwkOperationExecutor();

	/**
	 * @return the singleton instance
	 */
	public static IMiFwkOperationExecutor getInstance() {
		return sInstance;
	}

	public boolean isInUiThread() {
		if (Display.getCurrent() != null)
			return true;
		return false;
	}

	public <T> T inModalContext(Callable<T> operation, boolean fork, IProgressMonitor monitor)
			throws InvocationTargetException, InterruptedException {

		if (monitor == null)
			monitor = new NullProgressMonitor();
		Callable2ProgressRunnable<T> op = new Callable2ProgressRunnable<T>(operation, fork);
		ModalContext.run(op, fork, monitor, PlatformUI.getWorkbench().getDisplay());

		return op.getResult();
	}

	public void saveConnectionInModalContext(final Connection connection) throws NullPartitionNotEmptyException, PartitionsNotSavedException, ReferencedTransientElementsException {
		if (Display.getCurrent()==null) {
			throw new IllegalStateException("Must be called from the UI thread."); //$NON-NLS-1$ 
		}
		IProgressService progressService = PlatformUI.getWorkbench().getProgressService();
		IRunnableWithProgress runnable = new IRunnableWithProgress(){
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException,
					InterruptedException {
				try {
					ConnectionManager.getInstance().saveInWorkspaceRunnable(connection);
				} catch (PartitionsNotSavedException e) {
					throw new InvocationTargetException(e);
				}
			}
		};
		try {
			progressService.busyCursorWhile(runnable);
		} catch (InvocationTargetException e) { // $JL-EXC$
			Throwable cause = e.getCause();
			if (cause instanceof PartitionsNotSavedException) {
				throw (PartitionsNotSavedException) cause;
			}
			if (cause instanceof RuntimeException) {
				throw (RuntimeException) cause;
			}
			throw new RuntimeException(cause);
		} catch (InterruptedException e1) {
			throw new RuntimeException(e1);
		}
	}
	
	
	private MiFwkOperationExecutor() {
	}

	private static final class Callable2ProgressRunnable<T> implements IRunnableWithProgress, IThreadListener {
		private final Callable<T> operation;
		private T result;
		private final boolean forked;

		Callable2ProgressRunnable(Callable<T> operation, boolean forked) {
			this.operation = operation;
			this.forked = forked;
		}

		T getResult() {
			return this.result;
		}

		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			if (this.forked && Display.getCurrent() != null) {
				throw new IllegalStateException("Operation '" + this.operation //$NON-NLS-1$
						+ "' supposed to run in background thread, but ModalContext is disabled during startup. " //$NON-NLS-1$
						+ "Perform the operation asynchronously."); //$NON-NLS-1$
			}

			try {
				this.result = this.operation.call();
			} catch (OperationCanceledException e) {
				InterruptedException ie = new InterruptedException(e.getMessage());
				ie.initCause(e);
				throw ie;
			} catch (InterruptedException e) {
				throw e;
			} catch (InvocationTargetException e) {
				throw e;
			} catch (Exception e) {
				throw new InvocationTargetException(e);
			}
		}

		public void threadChange(Thread thread) {
			if (this.operation instanceof IThreadListener) {
				IThreadListener l = (IThreadListener) this.operation;
				l.threadChange(thread);
			}
		}
	}

}
