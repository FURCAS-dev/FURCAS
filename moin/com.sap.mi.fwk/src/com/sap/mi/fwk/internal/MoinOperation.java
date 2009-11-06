package com.sap.mi.fwk.internal;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.sap.mi.fwk.internal.messages.MiFwkMessages;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;

/**
 * Represents a MOIN command in the Eclipse world
 * 
 * @author d024127
 */
public class MoinOperation extends AbstractOperation {

	private final static Logger sTracer = Logger.getLogger(MiLocations.MI_COMMANDS);
	private final CommandStack cmdStack;

	/**
	 * Creates a new operation wrapper for the given MOIN command or command
	 * group.
	 * 
	 * @param description
	 *            a label for the operation
	 * @param cmdStack
	 *            The Moin command stack
	 */
	public MoinOperation(String description, CommandStack cmdStack) {
		super(description);
		if (cmdStack == null) {
			throw new IllegalArgumentException("Command stack must not be null"); //$NON-NLS-1$
		}
		this.cmdStack = cmdStack;
	}

	@Override
	public IStatus execute(IProgressMonitor monitor, IAdaptable info) {
		sTracer.logp(Level.SEVERE, MoinOperation.class.getName(), "execute", "This method must not be called"); //$NON-NLS-1$ //$NON-NLS-2$
		throw new UnsupportedOperationException("Must not be called"); //$NON-NLS-1$
	}

	@Override
	public IStatus undo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		if (!canUndo()) {
			return new Status(IStatus.ERROR, "com.sap.mi.fwk", MiFwkMessages.MoinOperation_StatusNothingToUndo); //$NON-NLS-1$
		}
		try {
			cmdStack.undo();
		} catch (ExecutionCancelledException e) {
			return Status.CANCEL_STATUS;
		} catch (Exception e) {
			throw new ExecutionException("An exception occured during undo", e); //$NON-NLS-1$
		}
		return Status.OK_STATUS;
	}

	@Override
	public IStatus redo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		if (!canRedo()) {
			return new Status(IStatus.ERROR, "com.sap.mi.fwk", MiFwkMessages.MoinOperation_StatusNothingToRedo); //$NON-NLS-1$
		}
		try {
			cmdStack.redo();
		} catch (ExecutionCancelledException e) {
			return Status.CANCEL_STATUS;
		} catch (Exception e) {
			throw new ExecutionException("An exception occured during redo", e); //$NON-NLS-1$
		}
		return Status.OK_STATUS;
	}

	@Override
	public boolean canExecute() {
		return false;
	}

	@Override
	public boolean canRedo() {
		return cmdStack.canRedo();
	}

	@Override
	public boolean canUndo() {
		return cmdStack.canUndo();
	}

	@Override
	public String toString() {
		return getLabel();
	}

	public CommandStack getCmdStack() {
		return cmdStack;
	}
}