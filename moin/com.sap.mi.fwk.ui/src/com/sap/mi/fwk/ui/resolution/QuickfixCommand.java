package com.sap.mi.fwk.ui.resolution;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.IMarkerResolution;

import com.sap.mi.fwk.IRunnableWithConnection;
import com.sap.mi.fwk.MarkerManager;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * A quickfix that executes a command. This class will be instantiated directly
 * by the Eclipse resolution framework using the default constructor. Therefore
 * it must not extend {@link Command} since this requires a {@link Connection}
 * in its constructor.
 * 
 * @author D024127
 */
public abstract class QuickfixCommand implements IMarkerResolution {

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_OCL);

	private RefBaseObject modelElement;
	private IMarker marker;
	private Connection connection;

	/**
	 * @return the command to be executed
	 */
	protected abstract Command getCommand();

	/**
	 * Returns the current marker
	 * 
	 * @return The current marker
	 */
	protected final IMarker getMarker() {
		return marker;
	}

	/**
	 * Returns the connection used by this quick fix to execute the command.
	 * 
	 * @return the current active connection
	 */
	protected final Connection getConnection() {
		return connection;
	}

	/**
	 * Returns the current model element based on the marker. The element will
	 * not be loaded until this method is called
	 * 
	 * @return The model element referenced by this marker
	 */
	protected final RefBaseObject getModelElement() {
		if (modelElement == null) {
			modelElement = MarkerManager.getInstance().getObject(connection, marker);
		}
		return modelElement;
	}

	public void run(final IMarker marker) {
		final IProject project = marker.getResource().getProject();
		IRunnableWithConnection runnable = new IRunnableWithConnection() {
			public void run(Connection connection, IProgressMonitor monitor) {
				QuickfixCommand.this.connection = connection;

				QuickfixCommand.this.marker = marker;
				try {
					Command command = getCommand();
					if (command == null) {
						IStatus status = MiFwkUIPlugin.createStatus(IStatus.ERROR,
								"The quickfix could not find an associated command", null); //$NON-NLS-1$
						MiFwkUIPlugin.showErrorDialog(status, "Quickfix execution failed", sTracer); //$NON-NLS-1$
						return;
					}
					String desc = command.getDescription();
					if (desc != null)
						connection.setLabel(desc + " - " + connection.getLabel()); //$NON-NLS-1$
					CommandHandle handle = command.getConnection().getCommandStack().execute(command);
					if (handle != null) {
						ConnectionManagerUI.getInstance().save(connection, project, null);
					}
					MarkerManager.getInstance().deleteMarker(marker);
				} catch (Exception e) { // $JL-EXC$
					MiFwkUIPlugin.showErrorDialog(e, "Quickfix execution failed", null, sTracer); //$NON-NLS-1$
				} finally {
					if (connection != null)
						connection.close();
				}
			}
		};
		ConnectionManagerUI.getInstance().createConnectionAsync(project, runnable);
	}
}