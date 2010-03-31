package com.sap.mi.fwk.ui.test.quickfix;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.tc.moin.repository.Connection;

public class MarkerResolutionGenerator implements IMarkerResolutionGenerator {

	public IMarkerResolution[] getResolutions(IMarker marker) {
		IMarkerResolution resolution = new MIEMarkerResolution();
		return new IMarkerResolution[] { resolution };
	}

	public class MIEMarkerResolution implements IMarkerResolution {

		public String getLabel() {
			return "Quick fix for any kind of problem ...";
		}

		public void run(IMarker marker) {
			ModelManager.getInstance();
			IResource resource = marker.getResource();
			if (resource == null)
				throw new IllegalStateException("No resource for " + marker);
			IProject project = resource.getProject();
			Connection connection;
			try {
				connection = getConnection(project);
				ModelManager.getMarkerManager().getObject(connection, marker);

				ModelManager.getMarkerManager().deleteMarker(marker);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		private Connection getConnection(final IProject project) throws InvocationTargetException, InterruptedException {

			// try it the easy way ... but do not create one if it doesn't exist
			Connection connection = ConnectionManager.getInstance().getExistingDefaultConnection(project);
			if (connection != null) {
				return connection;
			}

			// connection has to be created
			final Connection[] connections = new Connection[1];

			// create runnable
			IRunnableWithProgress operation = new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					// running in non UI thread
					monitor.beginTask(MiFwkUiMessages.AbstractCommandHandler_creating, 1);
					connections[0] = ConnectionManager.getInstance().getOrCreateDefaultConnection(project);
					if (monitor.isCanceled()) {
						throw new InterruptedException();
					}
					monitor.done();
				}
			};

			IProgressService ps = PlatformUI.getWorkbench().getProgressService();
			ps.busyCursorWhile(operation);
			return connections[0];
		}
	}
}
