package com.sap.mi.tools.mmbuilder.internal;

/**
 * Copyright (c) 2008 by SAP AG, Walldorf. http://www.sap.com All rights
 * reserved.
 * 
 * This software is the confidential and proprietary information of SAP AG,
 * Walldorf. You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered
 * into with SAP.
 * 
 */

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.progress.IProgressService;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * For internal use only, not intended to be use by external clients.
 */
public final class ConvertXMIHandler extends AbstractHandler {

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_METAMODELBUILDER);

	public Object execute(final ExecutionEvent arg0) throws ExecutionException {

		final IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelection(arg0);
		final Object[] objs = selection.toArray();
		final StringBuilder sb = new StringBuilder();
		final IRunnableWithProgress operation = new IRunnableWithProgress() {
			public void run(final IProgressMonitor monitor) {
				String msg = NLS.bind(MMBuilderMessages.ConvertXMI_convertProj, objs.length);
				monitor.beginTask(msg, objs.length * 2);
				for (final Object object : objs) {

					MMBuilderHelper.checkCancellation(monitor);

					final IProject project = MMBuilderHelper.getProject(object);

					if (project != null && project.isAccessible()) {
						msg = NLS.bind(MMBuilderMessages.ConvertXMI_convertingFiles, project.getName());
						monitor.subTask(msg);

						try {
							MetamodelBuilder.convertXMIFiles(project, monitor);
						} catch (final Exception e) {
							ConvertXMIHandler.sTracer.error("Failed to convert project: " + project.getName(), e); //$NON-NLS-1$ // TODO
							if (sb.length() > 0) {
								sb.append(", ");//$NON-NLS-1$
							}
							sb.append(project.getName());
							continue;
						}
						monitor.worked(1);
					}
				}
				monitor.done();
			}
		};

		try {
			final Shell shell = HandlerUtil.getActiveShell(arg0);
			for (final Object object : objs) {
				final IProject project = MMBuilderHelper.getProject(object);
				final IFile[] metamodelPartitionFiles = MetamodelBuilder.getMetamodelPartitionIFiles(project);
				IStatus status = ResourcesPlugin.getWorkspace().validateEdit(metamodelPartitionFiles, shell);
				if( !status.isOK() ) {
					MessageDialog.openError(shell, MMBuilderMessages.ConvertXMI_ErrorTitle, MMBuilderMessages.ConvertXMIHandler_checkoutErrMsg);
					return null;
				}
			}

			final IProgressService ps = PlatformUI.getWorkbench().getProgressService();
			ps.busyCursorWhile(operation);
			if (sb.length() > 0) {
				String msg = MMBuilderMessages.bind(MMBuilderMessages.ConvertXMI_ErrorMsg, sb.toString());
				MessageDialog.openError(shell, MMBuilderMessages.ConvertXMI_ErrorTitle, msg);
			}
		} catch (final OperationCanceledException e) {
			// $JL-EXC$
			// do nothing if user or eclipse cancels
			ConvertXMIHandler.sTracer.debug("Operation canceled by user"); //$NON-NLS-1$
		} catch (final Exception e) {
			throw new ExecutionException("Exception during execution", e); //$NON-NLS-1$
		}
		return null;
	}
}