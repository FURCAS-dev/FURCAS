package com.sap.mi.fwk.ui.internal.consistency;

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

import java.util.Collection;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator2;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.internal.consistency.DefaultConsistencyListener;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.CommandManager;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.consistency.ConsistencyCorrectionHandle;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * This class generates default quickfixes for consistency violation resolutions
 * <p>
 * This class is not intended to be used by clients.
 * 
 * @author d024127
 */
public class ConsistencyResolutionGenerator implements IMarkerResolutionGenerator2 {

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_CONSISTENCY);

	public boolean hasResolutions(IMarker marker) {
		return (DefaultConsistencyListener.getViolationID(marker) != null);
	}

	public IMarkerResolution[] getResolutions(IMarker marker) {
		String violationID = DefaultConsistencyListener.getViolationID(marker);
		if (violationID != null) {
			ConsistencyCorrectionHandle[] cchs = DefaultConsistencyListener.getHandles(marker);
			IMarkerResolution[] result = new IMarkerResolution[cchs.length];
			for (int i = 0; i < cchs.length; i++) {
				result[i] = new ConsistencyViolationQuickfix(cchs[i].getId(), cchs[i].getDescription());
			}
			return result;
		}
		return null;
	}

	private static final class ConsistencyViolationQuickfix implements IMarkerResolution {

		private final String label;
		private final String id;

		public ConsistencyViolationQuickfix(String id, String label) {
			this.id = id;
			this.label = label;
		}

		public String getLabel() {
			return this.label;
		}

		public void run(IMarker marker) {
			final IProject project = marker.getResource().getProject();
			final Connection[] con = new Connection[1];

			final IRunnableWithProgress createConnectionOp = new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) {
					monitor.subTask(MiFwkUiMessages.ConsistencyResolutionGenerator_applyingResolution);
					// running in non ui thread
					con[0] = ConnectionManager.getInstance().createConnection(project);
				}
			};

			final IRunnableWithProgress applyCorrectionOp = new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) {
					monitor.subTask(MiFwkUiMessages.ConsistencyResolutionGenerator_applyingResolution);
					// running in non ui thread
					try {
						con[0].getConsistencyViolationListenerRegistry().applyCorrection(ConsistencyViolationQuickfix.this.id);
						ConnectionManager.getInstance().save(con[0]);
					} catch (Exception e) {
						sTracer.error("Exception during quifix execution : ", e); //$NON-NLS-1$
					}
				}
			};

			try {
				IProgressService ps = PlatformUI.getWorkbench().getProgressService();
				ps.busyCursorWhile(createConnectionOp);

				if (con[0] != null) {
					Collection<PartitionOperation> affectedPartitions = con[0].getConsistencyViolationListenerRegistry()
							.getAffectedPartitions(this.id);

					CommandManager.getInstance().prepareExecution(con[0], affectedPartitions);
					ps.busyCursorWhile(applyCorrectionOp);
				}
			} catch (OperationCanceledException e) {
				// $JL-EXC$
				// do nothing if user or eclipse cancels
				sTracer.debug("Operation canceled by user"); //$NON-NLS-1$
			} catch (Exception e) {
				sTracer.error("Exception during quickfix execution: ", e); //$NON-NLS-1$
			} finally {
				if (con[0] != null) {
					con[0].close();
				}
			}
		}
	}
}
